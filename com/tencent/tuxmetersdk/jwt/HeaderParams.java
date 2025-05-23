package com.tencent.tuxmetersdk.jwt;

import com.tencent.mobileqq.app.identity.jwt.JsonWebSignature;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes27.dex */
public final class HeaderParams {
    static IPatchRedirector $redirector_;
    public static String ALGORITHM;
    public static String CONTENT_TYPE;
    public static String KEY_ID;
    public static String TYPE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12210);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ALGORITHM = JsonWebSignature.ALGORITHM;
        CONTENT_TYPE = JsonWebSignature.CONTENT_TYPE;
        TYPE = JsonWebSignature.TYPE;
        KEY_ID = "kid";
    }

    HeaderParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
