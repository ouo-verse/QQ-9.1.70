package com.tencent.tuxmetersdk.jwt;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.jwt.JWTCreator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class JWT {
    static IPatchRedirector $redirector_;

    public JWT() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static JWTCreator.Builder create() {
        return JWTCreator.init();
    }
}
