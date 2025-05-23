package com.tencent.mobileqq.microapp.apkg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class i implements Cloneable {
    static IPatchRedirector $redirector_;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public i clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (i) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            return (i) super.clone();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
