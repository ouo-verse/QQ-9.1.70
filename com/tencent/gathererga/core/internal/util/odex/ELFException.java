package com.tencent.gathererga.core.internal.util.odex;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ELFException extends RuntimeException {
    static IPatchRedirector $redirector_;

    public ELFException(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }
}
