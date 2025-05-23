package com.tencent.mobileqq.surfaceviewaction;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.surfaceviewaction.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class a {
    static IPatchRedirector $redirector_;
    public float C;
    public float D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public c I;
    public b J;
    public int K;
    protected List<com.tencent.mobileqq.surfaceviewaction.action.a> L;
    protected int M;
    protected int N;

    /* renamed from: d, reason: collision with root package name */
    public String f291150d;

    /* renamed from: e, reason: collision with root package name */
    public float f291151e;

    /* renamed from: f, reason: collision with root package name */
    public float f291152f;

    /* renamed from: h, reason: collision with root package name */
    public float f291153h;

    /* renamed from: i, reason: collision with root package name */
    public float f291154i;

    /* renamed from: m, reason: collision with root package name */
    public float f291155m;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f291155m = 1.0f;
        this.C = 1.0f;
        this.D = 0.0f;
        this.E = 255;
        this.F = 0;
        this.G = 1;
        this.H = false;
        this.L = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        int i3 = 0;
        boolean z16 = false;
        while (i3 < this.L.size()) {
            com.tencent.mobileqq.surfaceviewaction.action.a aVar = this.L.get(i3);
            if (aVar.d()) {
                int i16 = aVar.f291162g;
                if ((i16 & 1) != 0) {
                    this.f291153h = aVar.f291156a;
                    this.f291154i = aVar.f291157b;
                }
                if ((i16 & 2) != 0) {
                    this.f291155m = aVar.f291158c;
                }
                if ((i16 & 4) != 0) {
                    this.E = aVar.f291159d;
                }
                if ((i16 & 8) != 0) {
                    this.D = aVar.f291160e;
                }
                z16 = true;
            }
            if (aVar.f291165j) {
                if (aVar.f291164i) {
                    aVar.f();
                } else {
                    this.L.remove(i3);
                    i3--;
                }
            }
            i3++;
        }
        if (this.J != null && j() != null) {
            int e16 = j().e();
            b bVar = this.J;
            int i17 = (e16 * bVar.f291188a) / 1000;
            if (i17 > 0) {
                i17--;
            }
            b.a[] aVarArr = bVar.f291189b;
            if (i17 < aVarArr.length) {
                b.a aVar2 = aVarArr[i17];
                this.f291153h = aVar2.f291190a;
                this.f291154i = aVar2.f291191b;
                return true;
            }
            return z16;
        }
        return z16;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        float f16 = 1.0f;
        for (a aVar = (a) this.I; aVar != null; aVar = (a) aVar.I) {
            f16 *= aVar.E / 255.0f;
        }
        return (int) (f16 * 255.0f);
    }

    public float g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Float) iPatchRedirector.redirect((short) 18, (Object) this)).floatValue();
        }
        float f16 = 1.0f;
        for (a aVar = (a) this.I; aVar != null; aVar = (a) aVar.I) {
            f16 *= aVar.f291155m;
        }
        return f16;
    }

    public void h(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) fVar);
            return;
        }
        float f16 = this.f291153h;
        float f17 = this.f291154i;
        int i3 = this.F;
        if (i3 != 1) {
            if (i3 == 2) {
                f16 += (this.M / this.C) / 2.0f;
            }
        } else {
            f16 = (this.M / this.C) - f16;
        }
        int i16 = this.G;
        if (i16 != 0) {
            if (i16 == 2) {
                f17 += (this.N / this.C) / 2.0f;
            }
        } else {
            f17 = (this.N / this.C) - f17;
        }
        for (a aVar = (a) this.I; aVar != null; aVar = (a) aVar.I) {
            f16 += aVar.f291153h;
            f17 += aVar.f291154i;
        }
        fVar.f291217a = f16;
        fVar.f291218b = f17;
    }

    public float i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.f291155m;
    }

    public abstract e j();

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.H;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        for (int i3 = 0; i3 < this.L.size(); i3++) {
            this.L.get(i3).b();
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            this.L.clear();
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        for (int i3 = 0; i3 < this.L.size(); i3++) {
            this.L.get(i3).c();
        }
    }

    public void o(com.tencent.mobileqq.surfaceviewaction.action.a... aVarArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) aVarArr);
            return;
        }
        for (com.tencent.mobileqq.surfaceviewaction.action.a aVar : aVarArr) {
            aVar.f();
            this.L.add(aVar);
        }
    }

    public void p(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bVar);
        } else {
            this.J = bVar;
        }
    }

    public void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.F = i3;
        }
    }

    public void r(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.f291150d = str;
        }
    }

    public void s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.E = i3;
        }
    }

    public void t(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        } else {
            this.D = f16;
        }
    }

    public void u(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            this.f291155m = f16;
        }
    }

    public void v(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            this.C = f16;
        }
    }

    public void w(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.K = i3;
        }
    }

    public void x(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.G = i3;
        }
    }

    public void y(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            this.f291153h = f16;
        }
    }

    public void z(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.f291154i = f16;
        }
    }
}
