package com.tencent.mobileqq.loginregister.sms;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.LoginResult;
import mqq.app.api.IRuntimeService;
import oicq.wlogin_sdk.request.WUserSigInfo;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes15.dex */
public interface ISmsVerifyCodeService extends IRuntimeService {
    public static final int LOGIN_DEV_AUTH = 3;
    public static final int NT_PHONE_LOGIN = 5;
    public static final int NT_REGISTER = 6;
    public static final int PHONE_LOGIN = 2;
    public static final int REGISTER = 1;
    public static final int REGISTER_UP_SMS = 4;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a implements b {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService.b
        public void b(QBaseActivity qBaseActivity, int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, qBaseActivity, Integer.valueOf(i3), str, bundle);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService.b
        public void c(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void a(QBaseActivity qBaseActivity, Bundle bundle, Object obj);

        void b(QBaseActivity qBaseActivity, int i3, String str, Bundle bundle);

        void c(Bundle bundle);

        void d(QBaseActivity qBaseActivity, Bundle bundle);
    }

    boolean handleLoginSmsVerifySuccess(QBaseActivity qBaseActivity, Bundle bundle);

    boolean handleNTPhoneLoginSmsVerifySuccess(QBaseActivity qBaseActivity, LoginResult loginResult);

    boolean handleNTRegisterVerifySuccess(QBaseActivity qBaseActivity, String str, RegisterVerifyResult registerVerifyResult);

    boolean handlePhoneLoginSmsVerifySuccess(QBaseActivity qBaseActivity, WUserSigInfo wUserSigInfo);

    boolean handleRegisterSendUpSmsSuccess(QBaseActivity qBaseActivity, Bundle bundle);

    boolean handleRegisterVerifySuccess(QBaseActivity qBaseActivity, String str, String str2);

    boolean handleSmsVerifyCodeCancel(QBaseActivity qBaseActivity, Bundle bundle);

    boolean handleSmsVerifyCodeFail(QBaseActivity qBaseActivity, int i3, String str, Bundle bundle);

    void handleTransToSendUpSms(QBaseActivity qBaseActivity, Bundle bundle);

    void startVerifyCode(QBaseActivity qBaseActivity, int i3, d dVar, b bVar);
}
