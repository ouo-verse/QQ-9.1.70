package com.tencent.tgpa.vendorpd;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class R {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes26.dex */
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
