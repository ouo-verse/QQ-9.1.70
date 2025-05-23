package com.tencent.freesia;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class R {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class id {
        id() {
        }
    }

    R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
