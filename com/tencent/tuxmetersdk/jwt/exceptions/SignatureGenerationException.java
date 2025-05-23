package com.tencent.tuxmetersdk.jwt.exceptions;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.jwt.algorithms.Algorithm;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SignatureGenerationException extends JWTCreationException {
    static IPatchRedirector $redirector_;

    public SignatureGenerationException(Algorithm algorithm, Throwable th5) {
        super("The Token's Signature couldn't be generated when signing using the Algorithm: " + algorithm, th5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) algorithm, (Object) th5);
        }
    }
}
