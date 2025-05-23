package com.tencent.qqnt.selectable;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class b implements i<Object> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private boolean f362094d;

    /* renamed from: e, reason: collision with root package name */
    private g f362095e;

    /* renamed from: f, reason: collision with root package name */
    private h f362096f;

    /* renamed from: h, reason: collision with root package name */
    private h f362097h;

    /* renamed from: i, reason: collision with root package name */
    private k f362098i;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f362094d = true;
        }
    }

    private a u() {
        a C = a.C();
        if (this == C.F()) {
            return C;
        }
        throw new IllegalStateException("The proxy has been not attached.");
    }

    @Override // com.tencent.qqnt.selectable.i
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3);
        } else {
            a.C().a(i3);
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public int b(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return u().b(i3, i16);
    }

    @Override // com.tencent.qqnt.selectable.i
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.f362094d;
    }

    @Override // com.tencent.qqnt.selectable.i
    public void d(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            u().d(i3, z16);
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
        } else {
            a.C().e(i3);
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return u().f();
    }

    @Override // com.tencent.qqnt.selectable.i
    public void g(@NonNull k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) kVar);
        } else {
            this.f362098i = kVar;
            kVar.g(this);
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            u().h();
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return u().i();
    }

    @Override // com.tencent.qqnt.selectable.i
    public boolean isSelected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        a C = a.C();
        if (this == C.F() && C.isSelected()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.selectable.i
    public void j(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            u().j(i3, i16);
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            u().k();
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            u().l(i3);
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public int length() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return u().length();
    }

    @Override // com.tencent.qqnt.selectable.i
    public void m(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
        } else {
            u().m(i3, i16, z16);
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public void n(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, obj);
            return;
        }
        a C = a.C();
        if (C.F() != null) {
            C.z();
        }
        C.G(this);
        C.s(this.f362095e);
        C.t(this.f362096f, this.f362097h);
        C.g(this.f362098i);
        C.n(obj);
    }

    @Override // com.tencent.qqnt.selectable.i
    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return u().o();
    }

    @Override // com.tencent.qqnt.selectable.i
    public void p(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            u().p(i3, i16);
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return u().q();
    }

    @Override // com.tencent.qqnt.selectable.i
    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            a.C().r();
        }
    }

    public void s(@NonNull g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gVar);
        } else {
            this.f362095e = gVar;
            gVar.g(this);
        }
    }

    public void t(@NonNull h hVar, @NonNull h hVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar, (Object) hVar2);
            return;
        }
        this.f362096f = hVar;
        hVar.g(this);
        this.f362097h = hVar2;
        hVar2.g(this);
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        a C = a.C();
        if (this == C.F()) {
            C.z();
        }
    }
}
