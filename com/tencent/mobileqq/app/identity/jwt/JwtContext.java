package com.tencent.mobileqq.app.identity.jwt;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class JwtContext {
    static IPatchRedirector $redirector_;
    private JsonWebSignature joseObject;
    private String jwt;

    public JwtContext(String str, JsonWebSignature jsonWebSignature) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) jsonWebSignature);
        } else {
            this.jwt = str;
            this.joseObject = jsonWebSignature;
        }
    }

    public JsonWebSignature getJoseObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JsonWebSignature) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.joseObject;
    }

    public String getJwt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.jwt;
    }
}
