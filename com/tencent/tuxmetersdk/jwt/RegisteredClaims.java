package com.tencent.tuxmetersdk.jwt;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RegisteredClaims {
    static IPatchRedirector $redirector_;
    public static String AUDIENCE;
    public static String EXPIRES_AT;
    public static String ISSUED_AT;
    public static String ISSUER;
    public static String JWT_ID;
    public static String NOT_BEFORE;
    public static String SUBJECT;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12235);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ISSUER = "iss";
        SUBJECT = "sub";
        AUDIENCE = "aud";
        EXPIRES_AT = "exp";
        NOT_BEFORE = "nbf";
        ISSUED_AT = "iat";
        JWT_ID = "jti";
    }

    RegisteredClaims() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
