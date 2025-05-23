package com.tencent.mobileqq.qqlive.data.login;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LoginRequest {
    static IPatchRedirector $redirector_;
    public String authAppId;
    public String extData;
    public String qqA2;
    public String uin;

    public LoginRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "LoginRequest{, uin=" + this.uin + ", QQA2='" + this.qqA2 + "', customExtData='" + this.extData + "'}";
    }
}
