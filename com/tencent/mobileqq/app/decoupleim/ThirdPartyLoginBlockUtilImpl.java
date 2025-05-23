package com.tencent.mobileqq.app.decoupleim;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.loginregister.JumpLoginResult;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.util.c;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;
import tencent.im.login.GatewayVerify$RspBody;

/* loaded from: classes11.dex */
public class ThirdPartyLoginBlockUtilImpl {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile ThirdPartyLoginBlockUtilImpl f195483b;

    /* renamed from: a, reason: collision with root package name */
    private OpenSDKLoginCallback f195484a;

    /* loaded from: classes11.dex */
    public static class LoginViewOpenSDKCb implements OpenSDKLoginCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<QBaseActivity> f195485a;

        public LoginViewOpenSDKCb(QBaseActivity qBaseActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
            } else if (qBaseActivity == null) {
                QLog.e("ThirdPartyLoginUtilImpl", 1, "LoginViewOpenSDKCb constructor params wrong");
            } else {
                this.f195485a = new WeakReference<>(qBaseActivity);
            }
        }

        private boolean a() {
            if (this.f195485a == null) {
                QLog.e("ThirdPartyLoginUtilImpl", 1, "LoginViewOpenSDKCb mActRef error");
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.app.decoupleim.OpenSDKLoginCallback
        public void onLoginFailed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.d("ThirdPartyLoginUtilImpl", 1, "onLoginFailed");
            if (a()) {
                return;
            }
            QBaseActivity qBaseActivity = this.f195485a.get();
            if (qBaseActivity == null) {
                QLog.e("ThirdPartyLoginUtilImpl", 1, "onLoginFailed error: activity == null");
            } else {
                QQToast.makeText(qBaseActivity, R.string.f208775dm, 0).show();
            }
        }

        @Override // com.tencent.mobileqq.app.decoupleim.OpenSDKLoginCallback
        public void onLoginSuccess(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            QLog.d("ThirdPartyLoginUtilImpl", 1, "onLoginSuccess");
            ReportController.r(null, "dc00898", "", "", "0X800B18A", "0X800B18A", 0, 0, "", "", "", "");
            if (a()) {
                return;
            }
            QBaseActivity qBaseActivity = this.f195485a.get();
            if (qBaseActivity == null) {
                QLog.e("ThirdPartyLoginUtilImpl", 1, "onLoginSuccess error: activity == null");
            } else {
                ThreadManager.getUIHandler().post(new Runnable(qBaseActivity, str) { // from class: com.tencent.mobileqq.app.decoupleim.ThirdPartyLoginBlockUtilImpl.LoginViewOpenSDKCb.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ QBaseActivity f195486d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f195487e;

                    {
                        this.f195486d = qBaseActivity;
                        this.f195487e = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, LoginViewOpenSDKCb.this, qBaseActivity, str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            new JumpLoginResult().m(this.f195486d, this.f195487e);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f195488d;

        a(String str) {
            this.f195488d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ThirdPartyLoginBlockUtilImpl.this, (Object) str);
            }
        }

        private void a(EIPCResult eIPCResult) {
            if (eIPCResult.code != 0) {
                ThirdPartyLoginBlockUtilImpl.this.f195484a.onLoginFailed();
            } else {
                ThirdPartyLoginBlockUtilImpl.this.f195484a.onLoginSuccess(this.f195488d);
            }
        }

        private boolean b(EIPCResult eIPCResult) {
            if (eIPCResult != null && eIPCResult.data != null && ThirdPartyLoginBlockUtilImpl.this.f195484a != null) {
                return false;
            }
            return true;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                return;
            }
            if (b(eIPCResult)) {
                QLog.e("ThirdPartyLoginUtilImpl", 1, "toWtLoginOnOpenSdk callback params error");
                return;
            }
            QLog.d("ThirdPartyLoginUtilImpl", 1, "code=" + eIPCResult.code + " ssoResult=" + eIPCResult.data.getInt("key_sso_ret"));
            a(eIPCResult);
        }
    }

    ThirdPartyLoginBlockUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ThirdPartyLoginBlockUtilImpl b() {
        if (f195483b == null) {
            synchronized (ThirdPartyLoginBlockUtilImpl.class) {
                if (f195483b == null) {
                    f195483b = new ThirdPartyLoginBlockUtilImpl();
                }
            }
        }
        return f195483b;
    }

    private boolean f(byte[] bArr, QBaseActivity qBaseActivity) {
        if (qBaseActivity != null && qBaseActivity.getIntent() != null) {
            if (bArr == null) {
                QLog.d("ThirdPartyLoginUtilImpl", 1, "not im block");
                return true;
            }
            return false;
        }
        QLog.e("ThirdPartyLoginUtilImpl", 1, "activity related param null");
        return true;
    }

    public boolean c(QBaseActivity qBaseActivity, String str, String str2, int i3, OpenSDKLoginCallback openSDKLoginCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, qBaseActivity, str, str2, Integer.valueOf(i3), openSDKLoginCallback)).booleanValue();
        }
        QLog.d("ThirdPartyLoginUtilImpl", 2, "handleByThirdPartyLoginUtil");
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && qBaseActivity.getIntent() != null) {
            if (i3 == 1 && c.m(qBaseActivity.getIntent())) {
                g(openSDKLoginCallback);
                e(str, str2, qBaseActivity.getIntent().getStringExtra("im_block_sso_appid"));
                return true;
            }
            QLog.e("ThirdPartyLoginUtilImpl", 1, "handleByThirdPartyLoginUtil is not forbid or is not from auth");
            return false;
        }
        QLog.e("ThirdPartyLoginUtilImpl", 1, "handleByThirdPartyLoginUtil activity error!");
        return false;
    }

    public boolean d(byte[] bArr, QBaseActivity qBaseActivity, String str, String str2, OpenSDKLoginCallback openSDKLoginCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, bArr, qBaseActivity, str, str2, openSDKLoginCallback)).booleanValue();
        }
        if (h(bArr, qBaseActivity)) {
            QLog.d("ThirdPartyLoginUtilImpl", 1, "handleByThirdPartyLoginUtil true");
            g(openSDKLoginCallback);
            e(str, str2, qBaseActivity.getIntent().getStringExtra("im_block_sso_appid"));
            return true;
        }
        QLog.d("ThirdPartyLoginUtilImpl", 1, "handleByThirdPartyLoginUtil false");
        return false;
    }

    public void e(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3);
        } else {
            QLog.d("ThirdPartyLoginUtilImpl", 1, "loginWithOpenSDKApi");
            com.tencent.qqconnect.wtlogin.c.e(str, str2, str3, new a(str));
        }
    }

    public void g(OpenSDKLoginCallback openSDKLoginCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) openSDKLoginCallback);
        } else {
            this.f195484a = openSDKLoginCallback;
        }
    }

    public boolean h(byte[] bArr, QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr, (Object) qBaseActivity)).booleanValue();
        }
        QLog.d("ThirdPartyLoginUtilImpl", 1, "shouldIMLoginBlock");
        if (f(bArr, qBaseActivity)) {
            return false;
        }
        try {
            GatewayVerify$RspBody gatewayVerify$RspBody = new GatewayVerify$RspBody();
            gatewayVerify$RspBody.mergeFrom(bArr);
            if (gatewayVerify$RspBody.msg_rsp_lft_info.uint32_lft_forbid_area.get() == 1 && c.m(qBaseActivity.getIntent())) {
                QLog.d("ThirdPartyLoginUtilImpl", 1, "shouldIMLoginBlock FORBID_AREA_IM");
                return true;
            }
            ReportController.r(null, "dc00898", "", "", "0X800B189", "0X800B189", 0, 0, "", "", "", "");
            QLog.d("ThirdPartyLoginUtilImpl", 1, "shouldIMLoginBlock FORBID_AREA_ALL");
            return false;
        } catch (Exception e16) {
            QLog.e("ThirdPartyLoginUtilImpl", 1, "GatewayVerify.RspBody error: ", e16);
            return false;
        }
    }
}
