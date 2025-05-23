package com.tencent.mobileqq.qqlive.data.login;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LoginOpenIdInfo {
    static IPatchRedirector $redirector_;
    public String accessToken;
    public String openId;

    public LoginOpenIdInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
