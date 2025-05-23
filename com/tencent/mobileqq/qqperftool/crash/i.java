package com.tencent.mobileqq.qqperftool.crash;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    f f274269a;

    /* renamed from: b, reason: collision with root package name */
    c f274270b;

    /* renamed from: c, reason: collision with root package name */
    k f274271c;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f274269a = null;
            this.f274270b = null;
        }
    }

    public boolean a(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) dVar)).booleanValue();
        }
        c cVar = this.f274270b;
        if (cVar != null) {
            return cVar.h(dVar);
        }
        return false;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        f fVar = this.f274269a;
        if (fVar == null) {
            return false;
        }
        return fVar.a();
    }

    public synchronized void c(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (this.f274269a == null) {
            this.f274269a = new f();
            c cVar = new c();
            this.f274270b = cVar;
            this.f274269a.d(cVar);
            k kVar = new k(z16, z17);
            this.f274271c = kVar;
            kVar.c(this.f274270b);
        }
    }

    public boolean d(@NonNull Thread thread, @NonNull Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) thread, (Object) th5)).booleanValue();
        }
        f fVar = this.f274269a;
        if (fVar == null) {
            return false;
        }
        fVar.uncaughtException(thread, th5);
        return true;
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        f fVar = this.f274269a;
        if (fVar != null) {
            fVar.b();
        }
        k kVar = this.f274271c;
        if (kVar != null) {
            com.tencent.mobileqq.qqperftool.common.b.a("LightCrashCatcher", "registerToSystem mSignalCrashCatcher result = " + kVar.b(z16));
        }
    }

    public void f(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) dVar);
            return;
        }
        c cVar = this.f274270b;
        if (cVar != null) {
            cVar.i(dVar);
        }
    }

    public void g(com.tencent.mobileqq.qqperftool.crashdefend.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar);
            return;
        }
        f fVar = this.f274269a;
        if (fVar != null) {
            fVar.c(dVar);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        f fVar = this.f274269a;
        if (fVar != null) {
            fVar.e();
        }
        k kVar = this.f274271c;
        if (kVar != null) {
            com.tencent.mobileqq.qqperftool.common.b.a("LightCrashCatcher", "unRegisterFromSystem mSignalCrashCatcher result = " + kVar.d());
        }
    }
}
