package com.tencent.mobileqq.microapp.apkg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class j implements Cloneable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public l f245863a;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public j clone() {
        j jVar;
        Throwable th5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (j) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            jVar = (j) super.clone();
        } catch (Throwable th6) {
            jVar = null;
            th5 = th6;
        }
        try {
            jVar.f245863a = this.f245863a.clone();
        } catch (Throwable th7) {
            th5 = th7;
            th5.printStackTrace();
            return jVar;
        }
        return jVar;
    }
}
