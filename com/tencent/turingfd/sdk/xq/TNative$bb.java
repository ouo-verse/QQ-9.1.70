package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
final class TNative$bb {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface I {
        void m();
    }

    public TNative$bb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static native void m1();

    private static native void m2();
}
