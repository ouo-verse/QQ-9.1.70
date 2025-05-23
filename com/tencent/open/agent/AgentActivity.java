package com.tencent.open.agent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.open.agent.report.OpenAuthTelemetryProxy;
import com.tencent.open.agent.util.AgentOnActivityResultHelper;
import com.tencent.open.agent.util.AuthCallbackUtils;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.t;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
@RoutePage(desc = "\u4e92\u8054Agent\u4ee3\u7406\u9875\u9762", path = RouterConstants.UI_ROUTE_QQ_AGENT)
/* loaded from: classes22.dex */
public class AgentActivity extends BaseActivity {
    public static final String CONFIG_ENTRY_FILTER_INTENT_SWITCH = "opensdk_entry_filter_intent_switch";
    private static final long IPC_THREAD_WAITING_TIME = 2000;
    public static final String MMKV_KEY_AGENT_INTENT_PRE_ACTIVITY_TIME = "opensdk_agent_intent_pre_activity_time";
    private static final int MSG_KILL_PROCESS = 1;
    private static final boolean OPEN_SDK_IPC_SUB_THREAD_DEFAULT = true;
    private static final String TAG = "AgentActivity";
    private static final String TOGGLE_OPEN_SDK_IPC_SUB_THREAD_SWITCH = "qq_opensdk_ipc_sub_thread_switch";
    private QQProgressDialog mProgress;
    private int mWaitingCallbackCount;
    private boolean mIsBackToAPP = false;
    private boolean mOnResumeIsInited = false;
    private AtomicBoolean mShouldKillProcess = new AtomicBoolean(true);
    private Handler mHandler = new a();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what == 1 && AgentActivity.this.mShouldKillProcess.compareAndSet(true, false)) {
                t.f(AgentActivity.TAG, "handler kill opensdk process");
                SystemMethodProxy.killProcess(Process.myPid());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b implements QQProgressDialog.b {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.QQProgressDialog.b
        public void onBackPressed() {
            t.f(AgentActivity.TAG, "onBackPressed finishAct");
            AgentActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements com.tencent.qqconnect.wtlogin.b {
        c() {
        }

        @Override // com.tencent.qqconnect.wtlogin.b
        public void a(int i3, Object obj) {
            t.f(AgentActivity.TAG, "onEvent code = " + i3);
            if (i3 == 1) {
                AgentActivity.this.mWaitingCallbackCount++;
                return;
            }
            if (i3 == 2) {
                AgentActivity.this.mIsBackToAPP = true;
                AgentActivity.this.mWaitingCallbackCount--;
                t.f(AgentActivity.TAG, "onEvent finishAct");
                AgentActivity.this.finish();
                return;
            }
            if (i3 == 3) {
                AgentActivity.this.onQrCodeLoginSuccess(0, (Intent) obj);
                AgentActivity.this.mWaitingCallbackCount++;
            }
        }
    }

    private void addEventListener() {
        waitAppRuntime().f(new c());
    }

    private void backToThirdAppAndFinish(int i3, Intent intent) {
        AuthCallbackUtils.a(this, i3, intent);
        finish();
    }

    private boolean handleAction() {
        String l3 = com.tencent.open.agent.util.c.l(getIntent(), "key_action");
        t.b(TAG, "handleAction action=", l3);
        if ("action_login".equals(l3)) {
            OpenAuthTelemetryProxy.b("");
        }
        com.tencent.open.agent.strategy.a.b(l3).a(this);
        return true;
    }

    private boolean isErrorProcess() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("opensdk_agent_check_process_switch", true)) {
            return false;
        }
        try {
            if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof OpenSDKAppInterface) {
                if ("com.tencent.mobileqq:openSdk".equals(MobileQQ.sMobileQQ.getQQProcessName())) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isExecuteIpcOnSubThread() {
        try {
            boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(TOGGLE_OPEN_SDK_IPC_SUB_THREAD_SWITCH, true);
            t.b(TAG, "isExecuteIpcOnSubThread: " + isFeatureSwitchEnable);
            return isFeatureSwitchEnable;
        } catch (Exception e16) {
            t.d(TAG, "isExecuteIpcOnSubThread: default", e16);
            return true;
        }
    }

    private static boolean needFilterInvalidIntent(Intent intent) {
        boolean z16;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(CONFIG_ENTRY_FILTER_INTENT_SWITCH, true);
        QLog.i(TAG, 1, "needFilterInvalidIntent switch: " + isSwitchOn);
        if (!isSwitchOn || intent == null) {
            return false;
        }
        QLog.i(TAG, 2, "needFilterInvalidIntent flags: " + Integer.toHexString(intent.getFlags()));
        if ((intent.getFlags() & 1048576) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i(TAG, 1, "needFilterInvalidIntent fromHistory");
            return false;
        }
        long longExtra = intent.getLongExtra("preAct_time", 0L);
        if (longExtra <= 0) {
            QLog.i(TAG, 2, "needFilterInvalidIntent time is 0");
            return false;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        long decodeLong = from.decodeLong(MMKV_KEY_AGENT_INTENT_PRE_ACTIVITY_TIME, 0L);
        QLog.d(TAG, 2, "needFilterInvalidIntent time compare: " + longExtra + "/" + decodeLong);
        if (decodeLong != longExtra) {
            from.encodeLong(MMKV_KEY_AGENT_INTENT_PRE_ACTIVITY_TIME, longExtra);
            return false;
        }
        QLog.i(TAG, 1, "needFilterInvalidIntent same time: " + longExtra);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyMainProcessAgentActDestroy(boolean z16) {
        t.b(TAG, "[onDestroy] ipc result: " + BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "open_sdk_qipc_module", "action_on_agent_activity_destroy", new Bundle()).code + ", isSubThread: " + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onQrCodeLoginSuccess(int i3, Intent intent) {
        String stringExtra = intent.getStringExtra("param_qr_code_url");
        intent.putExtra("key_error_code", 0);
        intent.putExtra("key_response", com.tencent.open.agent.util.g.N(stringExtra).toString());
        super.setResult(i3, intent);
        QLog.i(TAG, 1, "onQrCodeLoginSuccess finishAct resultCode: " + i3);
        super.finish();
        this.mIsBackToAPP = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerIpcModule(boolean z16) {
        t.f(TAG, "OpenSdkQIPCClient registerModule. isSubThread: " + z16);
        com.tencent.open.f.registerModule();
    }

    private OpenSDKAppInterface waitAppRuntime() {
        OpenSDKAppInterface openSDKAppInterface = (OpenSDKAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        t.b(TAG, "waitAppRuntime app=" + openSDKAppInterface.hashCode());
        return openSDKAppInterface;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        t.b(TAG, "onCreate");
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        super.doOnCreate(bundle);
        if (needFilterInvalidIntent(getIntent())) {
            startActivity(InstalledAppListMonitor.getLaunchIntentForPackage(getPackageManager(), getPackageName()));
            return true;
        }
        if (isExecuteIpcOnSubThread()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.agent.AgentActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    AgentActivity.this.registerIpcModule(true);
                }
            }, 16, null, false);
        } else {
            registerIpcModule(false);
        }
        ForwardStatisticsReporter.a();
        ForwardStatisticsReporter.m("KEY_LOGIN_STAGE_1_TOTAL");
        ForwardStatisticsReporter.m("KEY_AUTHORITY_TOTAL");
        QQProgressDialog k3 = AuthUIUtil.k(this, this.mProgress, R.layout.b16);
        this.mProgress = k3;
        k3.O(new b());
        if (isErrorProcess()) {
            t.e(TAG, "onCreate isErrorProcess");
            backToThirdAppAndFinish(0, null);
            return true;
        }
        addEventListener();
        if (super.getIntent() != null && bundle == null) {
            return handleAction();
        }
        t.b(TAG, "onCreate super.getIntent() == null || savedInstanceState != null");
        com.tencent.open.agent.util.d.r(1, "LOGIN_CHECK_AGENT", null, null, 0, "AgentActivity getIntent is null");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        Boolean valueOf;
        super.doOnResume();
        Object[] objArr = new Object[6];
        objArr[0] = "onResume mOnResumeIsInited=";
        objArr[1] = Boolean.valueOf(this.mOnResumeIsInited);
        objArr[2] = ", mWaitingCallbackCount=";
        objArr[3] = Integer.valueOf(this.mWaitingCallbackCount);
        objArr[4] = ", isLogin=";
        if (getAppInterface() == null) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(getAppInterface().isLogin());
        }
        objArr[5] = valueOf;
        t.b(TAG, objArr);
        if (this.mOnResumeIsInited && this.mWaitingCallbackCount == 0) {
            t.f(TAG, "onResume finishAct cancel");
            backToThirdAppAndFinish(0, null);
            this.mIsBackToAPP = true;
            return;
        }
        this.mOnResumeIsInited = true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i3) {
        return SharedPreferencesProxyManager.getInstance().getProxy(str, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        t.b(TAG, "onActivityResult, requestCode: " + i3 + " | resultCode: " + i16 + " | data: " + intent);
        if (AgentOnActivityResultHelper.b()) {
            super.onActivityResult(i3, i16, intent);
        }
        if (AgentOnActivityResultHelper.a(i3)) {
            QLog.i(TAG, 1, "onActivityResult filter requestCode: " + i3);
            return;
        }
        if (intent != null && intent.getBooleanExtra("param_is_qr_code_login", false)) {
            onQrCodeLoginSuccess(i16, intent);
            return;
        }
        t.f(TAG, "onActivityResult finishAct resultCode: " + i16 + ", data: " + intent);
        backToThirdAppAndFinish(i16, intent);
        if (intent != null && intent.getBooleanExtra("moveTaskToBack", false)) {
            moveTaskToBack(true);
        }
        this.mIsBackToAPP = true;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        t.f(TAG, "onConfigurationChanged");
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        t.b(TAG, "-->onDestroy");
        super.onDestroy();
        AuthUIUtil.c(this, this.mProgress);
        waitAppRuntime().h(4, null);
        waitAppRuntime().i();
        if (this.mIsBackToAPP) {
            if (!BaseGesturePWDUtil.isAppOnForeground(this)) {
                GesturePWDUtils.setAppForground(this, false);
            }
            QLog.flushLog(true);
            if (isExecuteIpcOnSubThread()) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.agent.AgentActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AgentActivity.this.mHandler.sendEmptyMessageDelayed(1, 2000L);
                        AgentActivity.this.notifyMainProcessAgentActDestroy(true);
                        if (AgentActivity.this.mShouldKillProcess.compareAndSet(true, false)) {
                            t.f(AgentActivity.TAG, "kill opensdk process");
                            SystemMethodProxy.killProcess(Process.myPid());
                        }
                        AgentActivity.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }, 16, null, false);
            } else {
                notifyMainProcessAgentActDestroy(false);
                SystemMethodProxy.killProcess(Process.myPid());
            }
        }
        com.tencent.open.f.unRegisterModule();
    }
}
