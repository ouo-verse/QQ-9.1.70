package com.tencent.mobileqq.qqlive.base.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.base.sdk.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    class C8361a implements MainTicketCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IQQLiveSDK f271152a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IQQLiveLoginCallback f271153b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IQQLiveModuleLogin f271154c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f271155d;

        C8361a(IQQLiveSDK iQQLiveSDK, IQQLiveLoginCallback iQQLiveLoginCallback, IQQLiveModuleLogin iQQLiveModuleLogin, AppRuntime appRuntime) {
            this.f271152a = iQQLiveSDK;
            this.f271153b = iQQLiveLoginCallback;
            this.f271154c = iQQLiveModuleLogin;
            this.f271155d = appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, iQQLiveSDK, iQQLiveLoginCallback, iQQLiveModuleLogin, appRuntime);
            }
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            } else {
                QLog.i("QQLiveSDKHelper", 1, "initSDKLoginForAnchor async get login ticket fail");
            }
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mainTicketInfo);
            } else {
                QLog.i("QQLiveSDKHelper", 1, "initSDKLoginForAnchor async get login ticket success");
                a.d(this.f271152a, this.f271153b, this.f271154c, this.f271155d, mainTicketInfo.getA2());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b implements IQQLiveLoginCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IQQLiveLoginCallback f271156a;

        b(IQQLiveLoginCallback iQQLiveLoginCallback) {
            this.f271156a = iQQLiveLoginCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iQQLiveLoginCallback);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveSDKHelper", 1, "login fail code " + i3 + " msg " + str);
            }
            IQQLiveLoginCallback iQQLiveLoginCallback = this.f271156a;
            if (iQQLiveLoginCallback != null) {
                iQQLiveLoginCallback.onFailed(i3, str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback
        public void onSuccess(LoginInfo loginInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) loginInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveSDKHelper", 1, "login info " + loginInfo);
            }
            IQQLiveLoginCallback iQQLiveLoginCallback = this.f271156a;
            if (iQQLiveLoginCallback != null) {
                iQQLiveLoginCallback.onSuccess(loginInfo);
            }
        }
    }

    public static void b(IQQLiveSDK iQQLiveSDK, IQQLiveLoginCallback iQQLiveLoginCallback) {
        IQQLiveModuleLogin loginModule;
        AppRuntime appRuntime;
        Object valueOf;
        if (iQQLiveSDK == null || (loginModule = iQQLiveSDK.getLoginModule()) == null || (appRuntime = iQQLiveSDK.getAppRuntime()) == null) {
            return;
        }
        if (!loginModule.isLogined()) {
            TicketManager ticketManager = (TicketManager) appRuntime.getManager(2);
            if (ticketManager.useAsyncTicketInterface()) {
                ticketManager.getA2(bv.b(appRuntime.getCurrentUin(), 0L), 16, new C8361a(iQQLiveSDK, iQQLiveLoginCallback, loginModule, appRuntime));
                return;
            }
            String a26 = ticketManager.getA2(appRuntime.getCurrentUin());
            QLog.i("QQLiveSDKHelper", 1, "initSDKLoginForAnchor sync get login ticket");
            d(iQQLiveSDK, iQQLiveLoginCallback, loginModule, appRuntime, a26);
            return;
        }
        LoginInfo loginInfo = iQQLiveSDK.getLoginModule().getLoginInfo();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("already login, uid=");
            if (loginInfo == null) {
                valueOf = "null";
            } else {
                valueOf = Long.valueOf(loginInfo.uid);
            }
            sb5.append(valueOf);
            QLog.d("QQLiveSDKHelper", 1, sb5.toString());
        }
        if (iQQLiveLoginCallback != null) {
            if (loginInfo != null) {
                iQQLiveLoginCallback.onSuccess(loginInfo);
            } else {
                iQQLiveLoginCallback.onFailed(-1, "loginInfo is null");
            }
        }
    }

    public static IQQLiveSDK c(AppRuntime appRuntime) {
        if (appRuntime == null) {
            appRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        }
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId());
        if (sDKImpl != null && !sDKImpl.isInited()) {
            sDKImpl.init(appRuntime, QQLiveSDKConfigHelper.getDefIQQLiveSDK());
        }
        return sDKImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(IQQLiveSDK iQQLiveSDK, IQQLiveLoginCallback iQQLiveLoginCallback, IQQLiveModuleLogin iQQLiveModuleLogin, AppRuntime appRuntime, String str) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.uin = appRuntime.getCurrentUin();
        loginRequest.qqA2 = str;
        if (QQLiveSDKConfigHelper.getQQLiveAppId().equals(iQQLiveSDK.getAppId())) {
            loginRequest.authAppId = QQLiveSDKConfigHelper.getLoginAuthAppId();
            loginRequest.extData = QQLiveSDKConfigHelper.getLoginExtData();
        }
        iQQLiveModuleLogin.login(loginRequest, new b(iQQLiveLoginCallback));
    }
}
