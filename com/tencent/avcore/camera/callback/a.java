package com.tencent.avcore.camera.callback;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected f f77404d;

    /* renamed from: e, reason: collision with root package name */
    protected final com.tencent.avcore.camera.b f77405e;

    /* renamed from: f, reason: collision with root package name */
    protected c f77406f;

    /* renamed from: h, reason: collision with root package name */
    protected final C0780a f77407h;

    /* renamed from: i, reason: collision with root package name */
    protected int f77408i;

    /* renamed from: m, reason: collision with root package name */
    private Context f77409m;

    /* compiled from: P */
    /* renamed from: com.tencent.avcore.camera.callback.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0780a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f77410a;

        /* renamed from: b, reason: collision with root package name */
        public int f77411b;

        /* renamed from: c, reason: collision with root package name */
        public int f77412c;

        /* renamed from: d, reason: collision with root package name */
        public int f77413d;

        C0780a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f77410a = 0;
            this.f77411b = 0;
            this.f77412c = 0;
        }
    }

    public a(com.tencent.avcore.camera.b bVar, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) cVar);
            return;
        }
        this.f77404d = new f();
        this.f77406f = null;
        this.f77407h = new C0780a();
        this.f77408i = -1;
        this.f77405e = bVar;
        this.f77406f = cVar;
        this.f77409m = bVar.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(C0780a c0780a) {
        int l3;
        int b16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) c0780a);
            return;
        }
        int g16 = this.f77405e.g();
        int i16 = 0;
        if (this.f77405e.B()) {
            l3 = 0;
        } else {
            l3 = this.f77405e.l() * 90;
        }
        int o16 = this.f77405e.o();
        if (this.f77405e.k() == 1) {
            i16 = (360 - ((g16 + l3) % 360)) % 360;
        } else if (this.f77405e.k() == 2) {
            i16 = ((g16 - l3) + 360) % 360;
        }
        int i17 = i16 + o16;
        if (g16 == 270 || g16 == 90 ? !(o16 % 180 != 0 || this.f77405e.k() != 1 || (d() && !this.f77405e.A())) : !((g16 != 0 && g16 != 180) || (o16 == 90 || o16 == 270 ? this.f77405e.k() != 1 || this.f77405e.c().c(this.f77409m) : this.f77405e.k() != 1 || !this.f77405e.c().c(this.f77409m)))) {
            i17 += 180;
        }
        if (this.f77405e.k() == 1) {
            if (this.f77405e.n() > 0) {
                i3 = (360 - this.f77405e.n()) + i17;
                int i18 = (i3 % 360) / 90;
                if (c0780a == null) {
                    c0780a.f77410a = i18;
                    c0780a.f77411b = o16;
                    c0780a.f77412c = g16;
                    c0780a.f77413d = l3;
                    return;
                }
                return;
            }
            b16 = c(o16, this.f77405e.B());
        } else if (this.f77405e.d() > 0) {
            b16 = this.f77405e.d();
        } else {
            b16 = b(o16, this.f77405e.B());
        }
        i3 = b16 + i17;
        int i182 = (i3 % 360) / 90;
        if (c0780a == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int b(int i3, boolean z16) {
        byte b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16))).intValue();
        }
        if (i3 != 0) {
            if (i3 != 90) {
                if (i3 != 180) {
                    if (i3 == 270) {
                        b16 = 3;
                    }
                } else {
                    b16 = 2;
                }
            } else {
                b16 = 1;
            }
            if (!z16) {
                return this.f77405e.c().o(this.f77409m, false, false, b16, false) * 90;
            }
            return this.f77405e.c().e(this.f77409m, false, false, b16, false) * 90;
        }
        b16 = 0;
        if (!z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c(int i3, boolean z16) {
        byte b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16))).intValue();
        }
        if (i3 != 0) {
            if (i3 != 90) {
                if (i3 != 180) {
                    if (i3 == 270) {
                        b16 = 3;
                    }
                } else {
                    b16 = 2;
                }
            } else {
                b16 = 1;
            }
            if (!z16) {
                return this.f77405e.c().o(this.f77409m, true, false, b16, false) * 90;
            }
            return this.f77405e.c().e(this.f77409m, true, false, b16, false) * 90;
        }
        b16 = 0;
        if (!z16) {
        }
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f77408i == -1) {
            if (this.f77405e.c().f(this.f77409m)) {
                this.f77408i = 1;
            } else {
                this.f77408i = 0;
            }
        }
        if (this.f77408i != 1) {
            return false;
        }
        return true;
    }

    public abstract void e();

    public abstract void f(long j3, SurfaceTexture surfaceTexture);
}
