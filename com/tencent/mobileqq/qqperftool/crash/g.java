package com.tencent.mobileqq.qqperftool.crash;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private d f274262a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.qqperftool.crashdefend.d f274263b;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f274262a = null;
            this.f274263b = null;
        }
    }

    public boolean a(@NonNull Thread thread, @NonNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) thread, (Object) bVar)).booleanValue();
        }
        d dVar = this.f274262a;
        if (dVar != null) {
            dVar.b(bVar);
        }
        com.tencent.mobileqq.qqperftool.crashdefend.d dVar2 = this.f274263b;
        if (dVar2 != null) {
            return dVar2.a(bVar);
        }
        return false;
    }

    public d b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (d) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f274262a;
    }

    public void c(com.tencent.mobileqq.qqperftool.crashdefend.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
        } else {
            this.f274263b = dVar;
        }
    }

    public void d(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
        } else {
            this.f274262a = dVar;
        }
    }
}
