package com.tencent.mobileqq.mini.fake;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.manager.MiniAppDetainManager;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import op3.b;

/* compiled from: P */
/* loaded from: classes33.dex */
public class FakeSdkBrandUI implements IFakeBrandUI {
    private static final String COOKIE_DOMAIN = "qzone.qq.com";
    private static final int MAX_LENGTH = 10000;
    private static final String TAG = "minisdk-start_FakeSdkBrandUI";
    private static volatile boolean mHasOKHttpClientInit = false;
    public static volatile boolean mHasOnCreate = false;
    public static volatile boolean mHasOnResume = false;
    private Intent mIntent;
    private IUIProxy mUIProxy;
    private MiniAppInfo miniAppInfo = null;

    public static String changeUin(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.length() < 10) {
            StringBuilder sb5 = new StringBuilder("o");
            for (int length = str.length(); length < 10; length++) {
                sb5.append("0");
            }
            sb5.append(str);
            return sb5.toString();
        }
        return "o" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0093, code lost:
    
        com.tencent.qphone.base.util.QLog.i(com.tencent.mobileqq.mini.fake.FakeSdkBrandUI.TAG, 1, "finishAndRemoveTask finish and remove task: id=" + r4.getTaskInfo().id);
        r4.finishAndRemoveTask();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean finishAndRemoveTask(Activity activity) {
        List<ActivityManager.AppTask> appTasks;
        Intent intent;
        Intent intent2;
        Intent intent3;
        if (activity != null) {
            try {
                ActivityManager activityManager = (ActivityManager) activity.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                if (activityManager == null || (appTasks = activityManager.getAppTasks()) == null) {
                    return false;
                }
                Iterator<ActivityManager.AppTask> it = appTasks.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.AppTask next = it.next();
                    if (next != null && next.getTaskInfo() != null) {
                        intent = next.getTaskInfo().baseIntent;
                        if (intent != null) {
                            intent2 = next.getTaskInfo().baseIntent;
                            if (intent2.getComponent() != null) {
                                intent3 = next.getTaskInfo().baseIntent;
                                String className = intent3.getComponent().getClassName();
                                QLog.i(TAG, 1, "finishAndRemoveTask try finish and remove task: id=" + next.getTaskInfo().id + ", componentName:" + className);
                                if (!TextUtils.isEmpty(className) && className.equals(activity.getClass().getName())) {
                                    break;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return true;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "finishAndRemoveTask exception.", th5);
            }
        }
        return false;
    }

    public static void initOKHttpClient() {
        if (mHasOKHttpClientInit) {
            return;
        }
        mHasOKHttpClientInit = true;
        MiniOkHttpClientFactory.init(60000L, 60000L, 60000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void recoveryIntent(final BaseActivity baseActivity, Intent intent) {
        MiniAppInfo miniAppInfo;
        if (intent == null) {
            return;
        }
        MiniAppInfo miniAppInfo2 = null;
        try {
            miniAppInfo = (MiniAppInfo) intent.getParcelableExtra(IPCConst.KEY_APPINFO);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
        } catch (Throwable th6) {
            th = th6;
            miniAppInfo2 = miniAppInfo;
            QLog.e(TAG, 1, "recoveryIntent exception!", th);
            miniAppInfo = miniAppInfo2;
            if (QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_INTENT_INVALID_RESTART, 1) <= 0) {
            }
            if (miniAppInfo == null) {
                return;
            } else {
                return;
            }
        }
        if (miniAppInfo != null) {
            if (miniAppInfo.getMaxListSize() > 10000) {
                QLog.i(TAG, 1, "deserialization error\uff0ckillProcess" + Process.myPid());
                baseActivity.finish();
                finishAndRemoveTask(baseActivity);
                SystemMethodProxy.killProcess(Process.myPid());
                return;
            }
            return;
        }
        MiniAppConfig miniAppConfig = (MiniAppConfig) intent.getParcelableExtra("CONFIG");
        if (miniAppConfig != null) {
            miniAppInfo2 = MiniSdkLauncher.convert(miniAppConfig);
            intent.putExtra(IPCConst.KEY_APPINFO, miniAppInfo2);
            QLog.e(TAG, 1, "recoveryIntent from MiniAppConfig succeed!");
            miniAppInfo = miniAppInfo2;
        }
        boolean z16 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_INTENT_INVALID_RESTART, 1) <= 0;
        if (miniAppInfo == null || !z16) {
            return;
        }
        QLog.e(TAG, 1, "Intent Data is invalid! KillProcess now!");
        if (baseActivity != null) {
            QQToast.makeText(baseActivity.getApplicationContext(), "\u8bf7\u91cd\u65b0\u6253\u5f00\u5c0f\u7a0b\u5e8f", 1).show();
        }
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.fake.FakeSdkBrandUI.2
            @Override // java.lang.Runnable
            public void run() {
                FakeSdkBrandUI.this.finishAndRemoveTask(baseActivity);
                QLog.e(FakeSdkBrandUI.TAG, 1, "killProcess " + Process.myPid());
                SystemMethodProxy.killProcess(Process.myPid());
            }
        }, 2000L);
    }

    public static void setCookie() {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            final b bVar = new b(com.tencent.open.adapter.a.f().e());
            final op3.a aVar = new op3.a();
            aVar.a(true);
            final long l3 = com.tencent.open.adapter.a.f().l();
            ((IPskeyManager) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IPskeyManager.class, "all")).getPskey(new String[]{"qzone.qq.com"}, new sd2.a() { // from class: com.tencent.mobileqq.mini.fake.FakeSdkBrandUI.3
                @Override // sd2.a
                public void onSuccess(Map<String, String> map) {
                    String str = map.get("qzone.qq.com");
                    QLog.i(FakeSdkBrandUI.TAG, 1, "getPskey onSuccess pskey:" + str);
                    op3.a.this.b("qzone.qq.com/", "uin=" + FakeSdkBrandUI.changeUin(String.valueOf(l3)) + "; path=/; domain=.qzone.qq.com;");
                    op3.a.this.b("qzone.qq.com/", "p_uin=" + FakeSdkBrandUI.changeUin(String.valueOf(l3)) + "; path=/; domain=.qzone.qq.com;");
                    op3.a.this.b("qzone.qq.com/", "p_skey=" + str + "; path=/; domain=.qzone.qq.com;");
                    bVar.a();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("setCookie cost:");
                    sb5.append(currentTimeMillis2 - currentTimeMillis);
                    QLog.e(FakeSdkBrandUI.TAG, 1, sb5.toString());
                }

                @Override // sd2.a
                public void onFail(String str) {
                    QLog.e(FakeSdkBrandUI.TAG, 1, "getPskey onFail!", str);
                }
            });
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public boolean doBeforeOnCreate(BaseActivity baseActivity, Bundle bundle) {
        QLog.i(TAG, 1, "doBeforeOnCreate");
        mHasOnCreate = true;
        Intent intent = baseActivity.getIntent();
        try {
            recoveryIntent(baseActivity, intent);
            this.miniAppInfo = (MiniAppInfo) baseActivity.getIntent().getParcelableExtra(IPCConst.KEY_APPINFO);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "", th5);
        }
        MiniAppInfo miniAppInfo = this.miniAppInfo;
        if (miniAppInfo != null) {
            MiniAppController.recordAppLaunchTime(miniAppInfo.appId, 46);
        }
        MiniSDK.init(baseActivity.getApplicationContext());
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.mini.fake.FakeSdkBrandUI.1
            @Override // java.lang.Runnable
            public void run() {
                FakeSdkBrandUI.setCookie();
                FakeSdkBrandUI.initOKHttpClient();
            }
        });
        RelativeLayout relativeLayout = new RelativeLayout(baseActivity);
        baseActivity.setContentView(relativeLayout);
        FrameLayout frameLayout = new FrameLayout(baseActivity);
        relativeLayout.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.mIntent = intent;
        IUIProxy uIProxy = AppLoaderFactory.g().getMiniAppEnv().getUIProxy(this.miniAppInfo);
        this.mUIProxy = uIProxy;
        if (uIProxy != null) {
            QLog.i(TAG, 1, "UIProxy completed");
            this.mUIProxy.onAttachActivity(baseActivity, bundle, frameLayout);
        }
        MiniSDKClientQIPCModule.registerModule();
        MiniAppDetainManager.INSTANCE.preloadAppDetainRecord(this.miniAppInfo);
        return true;
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public boolean doDispatchKeyEvent(KeyEvent keyEvent) {
        return this.mUIProxy.doDispatchKeyEvent(keyEvent);
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public void doOnActivityResult(BaseActivity baseActivity, int i3, int i16, Intent intent) {
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onActivityResult(baseActivity, i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public void doOnBackPressed(BaseActivity baseActivity, boolean z16) {
        IUIProxy iUIProxy = this.mUIProxy;
        if ((iUIProxy != null ? iUIProxy.onBackPressed(baseActivity) : false) || baseActivity.moveTaskToBack(false)) {
            return;
        }
        baseActivity.finish();
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public boolean doOnCreate(BaseActivity baseActivity, Bundle bundle) {
        return true;
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public void doOnNewIntent(BaseActivity baseActivity, Intent intent) {
        QLog.i(TAG, 1, "doOnNewIntent");
        try {
            this.mIntent = intent;
            recoveryIntent(baseActivity, intent);
            this.mUIProxy = AppLoaderFactory.g().getMiniAppEnv().getUIProxy((MiniAppInfo) baseActivity.getIntent().getParcelableExtra(IPCConst.KEY_APPINFO));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "doOnNewIntent exception!", th5);
        }
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public void doOnResume(BaseActivity baseActivity) {
        QLog.i(TAG, 1, "doOnResume");
        if (this.miniAppInfo != null && mHasOnResume) {
            MiniAppController.recordAppLaunchTime(this.miniAppInfo.appId, 46);
        }
        mHasOnResume = true;
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            Intent intent = this.mIntent;
            if (intent != null) {
                iUIProxy.onIntentUpdate(intent);
                this.mIntent = null;
            }
            this.mUIProxy.onMiniResume();
        }
        ImmersiveUtils.setStatusTextColor(true, baseActivity.getWindow());
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public void doRefreshMiniBadge(BaseActivity baseActivity, Bundle bundle) {
        if (this.mUIProxy != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_appid", bundle.getString("miniAppID"));
            bundle2.putInt(IPCConst.KEY_BADGE_COUNT, bundle.getInt(MiniChatConstants.PARAM_PROC_BADGE_COUNT));
            this.mUIProxy.onRefreshMiniBadge(baseActivity, bundle2);
        }
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public boolean isWrapContent(BaseActivity baseActivity) {
        return false;
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public boolean moveTaskToBack(BaseActivity baseActivity, boolean z16, boolean z17) {
        PageGestureProxy pageGestureProxy = (PageGestureProxy) AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
        if (pageGestureProxy == null) {
            return false;
        }
        pageGestureProxy.onMoveTaskToBack(baseActivity);
        return false;
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public void doOnDestroy(BaseActivity baseActivity) {
        QLog.i(TAG, 1, "doOnDestroy");
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onDetachActivity(baseActivity);
        }
        MiniSDKClientQIPCModule.unRegisterModule();
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public void doOnPause(BaseActivity baseActivity) {
        QLog.i(TAG, 1, "doOnPause");
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onMiniPause();
        }
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public void doOnStart(BaseActivity baseActivity) {
        QLog.i(TAG, 1, "doOnStart");
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onMiniStart();
        }
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public void doOnStop(BaseActivity baseActivity) {
        QLog.i(TAG, 1, "doOnStop");
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onMiniStop();
        }
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public void finish(BaseActivity baseActivity) {
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public void onProcessBackground(BaseActivity baseActivity, Bundle bundle) {
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public void onProcessForeGround(BaseActivity baseActivity, Bundle bundle) {
    }

    @Override // com.tencent.mobileqq.mini.fake.IFakeBrandUI
    public void onRefreshMiniBadge(BaseActivity baseActivity, Bundle bundle) {
    }
}
