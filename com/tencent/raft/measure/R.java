package com.tencent.raft.measure;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class R {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class string {
        string() {
        }
    }

    R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
