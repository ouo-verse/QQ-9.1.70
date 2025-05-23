package com.tencent.mobileqq.qqlive.anchor.room.helper;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f270870a;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements IQQLiveLoginCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f270871a;

        a(b bVar) {
            this.f270871a = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) bVar);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                e.this.e(i3, str, this.f270871a);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback
        public void onSuccess(LoginInfo loginInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) loginInfo);
            } else if (loginInfo == null) {
                e.this.f("logined, but loginInfo is null", this.f270871a);
            } else {
                e.this.g(loginInfo, this.f270871a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface b {
        void a(QQLiveErrorMsg qQLiveErrorMsg);

        void onSuccess(LoginInfo loginInfo);
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f270870a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i3, String str, b bVar) {
        this.f270870a = false;
        QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
        qQLiveErrorMsg.bizModule = 2;
        qQLiveErrorMsg.bizErrCode = 6100;
        qQLiveErrorMsg.bizErrMsg = "init login err";
        qQLiveErrorMsg.originErrCode = i3;
        qQLiveErrorMsg.originErrMsg = str;
        bVar.a(qQLiveErrorMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, b bVar) {
        this.f270870a = false;
        QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
        qQLiveErrorMsg.bizModule = 2;
        qQLiveErrorMsg.bizErrCode = 6100;
        qQLiveErrorMsg.bizErrMsg = str;
        bVar.a(qQLiveErrorMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(LoginInfo loginInfo, b bVar) {
        this.f270870a = true;
        bVar.onSuccess(loginInfo);
    }

    public void d(@NonNull IQQLiveSDK iQQLiveSDK, @NonNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK, (Object) bVar);
            return;
        }
        boolean z16 = false;
        if (iQQLiveSDK != null && bVar != null) {
            this.f270870a = false;
            IQQLiveModuleLogin loginModule = iQQLiveSDK.getLoginModule();
            if (loginModule == null) {
                f("loginModule is null", bVar);
                return;
            }
            if (!loginModule.isLogined()) {
                LoginRequest loginRequest = loginModule.getLoginRequest();
                if (loginRequest == null) {
                    f("loginRequst is null", bVar);
                    return;
                } else {
                    loginModule.login(loginRequest, new a(bVar));
                    return;
                }
            }
            LoginInfo loginInfo = loginModule.getLoginInfo();
            if (loginInfo == null) {
                f("loginInfo is null", bVar);
                return;
            } else {
                g(loginInfo, bVar);
                return;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doLogin, params is null, liveSDK's null=");
        if (iQQLiveSDK == null) {
            z16 = true;
        }
        sb5.append(z16);
        QLog.e("QQLiveAnchor_Login", 1, sb5.toString());
    }
}
