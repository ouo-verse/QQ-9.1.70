package com.tencent.tuxmetersdk.jwt.exceptions;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class JWTCreationException extends RuntimeException {
    static IPatchRedirector $redirector_;

    public JWTCreationException(String str, Throwable th5) {
        super(str, th5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) th5);
        }
    }
}
