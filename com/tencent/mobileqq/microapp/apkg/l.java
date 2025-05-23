package com.tencent.mobileqq.microapp.apkg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class l implements Cloneable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public i f245874a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f245875b;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public l clone() {
        l lVar;
        Throwable th5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (l) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            lVar = (l) super.clone();
        } catch (Throwable th6) {
            lVar = null;
            th5 = th6;
        }
        try {
            lVar.f245874a = this.f245874a.clone();
        } catch (Throwable th7) {
            th5 = th7;
            th5.printStackTrace();
            return lVar;
        }
        return lVar;
    }
}
