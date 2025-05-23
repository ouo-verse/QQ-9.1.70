package com.tencent.open;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.loginregister.v;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.OpenSdkIMBlockFragment;
import com.tencent.open.agent.QrAgentLoginManager;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import com.tencent.open.agent.util.t;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* loaded from: classes22.dex */
public class OpenSdkQIPCModule extends c {

    /* renamed from: d, reason: collision with root package name */
    private static volatile OpenSdkQIPCModule f339505d;

    OpenSdkQIPCModule(String str) {
        super(str);
    }

    public static OpenSdkQIPCModule c() {
        if (f339505d == null) {
            synchronized (OpenSdkQIPCModule.class) {
                if (f339505d == null) {
                    f339505d = new OpenSdkQIPCModule("open_sdk_qipc_module");
                }
            }
        }
        return f339505d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Bundle bundle) {
        if (bundle.getInt("key_sso_ret", -1000) == 0) {
            String string = bundle.getString("uin");
            boolean z16 = bundle.getBoolean("is_from_login");
            up3.b.a(string);
            com.tencent.qqconnect.wtlogin.c.c(BaseActivity.sTopActivity, (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
            OpenSdkIMBlockFragment.th(BaseActivity.sTopActivity, string, z16);
        } else {
            QQToast.makeText(BaseActivity.sTopActivity, R.string.f172922rr, 0).show();
        }
        if (((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).isBlockNotifyActivity(QBaseActivity.sTopActivity)) {
            QBaseActivity.sTopActivity.finish();
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, final Bundle bundle, int i3) {
        MqqHandler handler;
        t.f("OpenSdkQIPCModule", "onCall main proc action : " + str);
        if ("action_get_accountInfo".equals(str)) {
            Bundle bundle2 = new Bundle();
            EIPCResult createResult = EIPCResult.createResult(0, bundle2);
            String string = bundle.getString("uin");
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (!TextUtils.isEmpty(string) && (runtime instanceof QQAppInterface)) {
                bundle2.putString("key_nickname", ac.G((QQAppInterface) runtime, string));
            }
            callbackResult(i3, createResult);
        } else if ("action_ptlogin_cancel".equals(str)) {
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            t.f("OpenSdkQIPCModule", "onCall ptlogin cancel activity=" + baseActivity);
            if (baseActivity instanceof SplashActivity) {
                baseActivity.doOnBackPressed();
            }
        } else if ("action_on_sso_login_complete".equals(str)) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.OpenSdkQIPCModule.1
                @Override // java.lang.Runnable
                public void run() {
                    OpenSdkQIPCModule.this.d(bundle);
                }
            });
        } else {
            if ("action_on_agent_activity_destroy".equals(str)) {
                GuardManager.sInstance.noticeSubThreadBackground("com.tencent.mobileqq:openSdk");
                return EIPCResult.createResult(0, null);
            }
            if ("action_on_qr_code_login_success".equals(str)) {
                AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
                if (appInterface != null && (handler = appInterface.getHandler(v.class)) != null) {
                    handler.sendEmptyMessage(2004);
                }
            } else if ("action_open_auth_telemetry_report".equals(str)) {
                ((IOpenAuthTelemetryReportMgr) QRoute.api(IOpenAuthTelemetryReportMgr.class)).doReportAction(bundle);
            } else if ("action_on_sso_add_account_success".equals(str)) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.OpenSdkQIPCModule.2
                    @Override // java.lang.Runnable
                    public void run() {
                        MobileQQ.sMobileQQ.refreAccountList();
                        t.b("OpenSdkQIPCModule", "refreshAccountList in main process.");
                    }
                }, 64, null, false);
            } else if ("action_send_auth_qr_request".equals(str)) {
                QLog.i("OpenSdkQIPCModule", 2, "onCall: ACTION_SEND_AUTH_QR_REQUEST ");
                QrAgentLoginManager.t().q();
            } else if ("action_get_study_mode".equals(str)) {
                boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
                QLog.i("OpenSdkQIPCModule", 2, "studyModeSwitch:" + studyModeSwitch);
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("key_study_mode", studyModeSwitch);
                callbackResult(i3, EIPCResult.createSuccessResult(bundle3));
            }
        }
        return null;
    }
}
