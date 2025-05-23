package com.tencent.mobileqq.qqlive.api.impl.login;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.login.LoginLogic;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveModuleLoginImpl implements IQQLiveModuleLogin {
    static IPatchRedirector $redirector_;
    private final LoginLogic loginLogic;

    public QQLiveModuleLoginImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.loginLogic = new LoginLogic();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.loginLogic.destroy();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public LoginInfo getLoginInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LoginInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.loginLogic.getLoginInfo();
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public LoginRequest getLoginRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LoginRequest) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.loginLogic.getLoginRequest();
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public int getLoginStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.loginLogic.getLoginStatus();
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public LiveUserInfo getUserInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LiveUserInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.loginLogic.getUserInfo();
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) iQQLiveSDK);
        } else {
            this.loginLogic.init(iQQLiveSDK);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public boolean isLogined() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.loginLogic.isLogined();
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public void login(LoginRequest loginRequest, IQQLiveLoginCallback iQQLiveLoginCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) loginRequest, (Object) iQQLiveLoginCallback);
        } else {
            this.loginLogic.login(loginRequest, iQQLiveLoginCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public void reLogin(LoginRequest loginRequest, IQQLiveLoginCallback iQQLiveLoginCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) loginRequest, (Object) iQQLiveLoginCallback);
        } else {
            this.loginLogic.reLogin(loginRequest, iQQLiveLoginCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public void registerLoginStateCallback(IQQLiveLoginCallback iQQLiveLoginCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) iQQLiveLoginCallback);
        } else {
            this.loginLogic.registerLoginStateCallback(iQQLiveLoginCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.loginLogic.reset();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public void unregisterLoginStateCallback(IQQLiveLoginCallback iQQLiveLoginCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) iQQLiveLoginCallback);
        } else {
            this.loginLogic.unregisterLoginStateCallback(iQQLiveLoginCallback);
        }
    }
}
