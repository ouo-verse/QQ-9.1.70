package com.tencent.qui.video.floatingview.view;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class m {
    static IPatchRedirector $redirector_;
    private static final int A;
    private static final int B;
    private static final int C;
    private static final int D;
    private static final int E;
    private static final int F;
    private static final int G;
    private static final int H;
    private static final HashMap<String, Integer> I;

    /* renamed from: i, reason: collision with root package name */
    public static float f363976i;

    /* renamed from: j, reason: collision with root package name */
    public static float f363977j;

    /* renamed from: k, reason: collision with root package name */
    public static float f363978k;

    /* renamed from: l, reason: collision with root package name */
    private static final int f363979l;

    /* renamed from: m, reason: collision with root package name */
    public static int f363980m;

    /* renamed from: n, reason: collision with root package name */
    public static int f363981n;

    /* renamed from: o, reason: collision with root package name */
    public static int f363982o;

    /* renamed from: p, reason: collision with root package name */
    public static int f363983p;

    /* renamed from: q, reason: collision with root package name */
    private static final int f363984q;

    /* renamed from: r, reason: collision with root package name */
    private static final int f363985r;

    /* renamed from: s, reason: collision with root package name */
    private static final int f363986s;

    /* renamed from: t, reason: collision with root package name */
    private static final int f363987t;

    /* renamed from: u, reason: collision with root package name */
    private static final int f363988u;

    /* renamed from: v, reason: collision with root package name */
    private static final int f363989v;

    /* renamed from: w, reason: collision with root package name */
    private static final int f363990w;

    /* renamed from: x, reason: collision with root package name */
    private static final int f363991x;

    /* renamed from: y, reason: collision with root package name */
    private static final int f363992y;

    /* renamed from: z, reason: collision with root package name */
    private static final int f363993z;

    /* renamed from: a, reason: collision with root package name */
    private int f363994a;

    /* renamed from: b, reason: collision with root package name */
    private int f363995b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f363996c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f363997d;

    /* renamed from: e, reason: collision with root package name */
    private int f363998e;

    /* renamed from: f, reason: collision with root package name */
    private int f363999f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f364000g;

    /* renamed from: h, reason: collision with root package name */
    private float f364001h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10942);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
            return;
        }
        f363976i = 0.6666667f;
        f363977j = 1.7777778f;
        f363978k = 0.5625f;
        int a16 = com.tencent.biz.qui.quicommon.e.a(14.0f);
        f363979l = a16;
        f363980m = ud0.b.a().getResources().getDimensionPixelSize(R.dimen.dau);
        f363981n = ud0.b.a().getResources().getDimensionPixelSize(R.dimen.das);
        int dimensionPixelSize = ud0.b.a().getResources().getDimensionPixelSize(R.dimen.dat);
        int i3 = f363980m;
        f363982o = dimensionPixelSize + i3;
        f363983p = a16 - i3;
        f363984q = (com.tencent.biz.qui.quicommon.e.l(ud0.b.a()) + a16) - f363980m;
        f363985r = com.tencent.biz.qui.quicommon.e.e(ud0.b.a()) - f363980m;
        int k3 = ((com.tencent.biz.qui.quicommon.e.k() - (a16 * 2)) / 2) + (f363980m * 2);
        f363986s = k3;
        f363987t = (k3 * 16) / 9;
        int k16 = ((com.tencent.biz.qui.quicommon.e.k() - (a16 * 2)) / 3) + (f363980m * 2);
        f363988u = k16;
        f363989v = (k16 * 16) / 9;
        int k17 = (com.tencent.biz.qui.quicommon.e.k() - (a16 * 2)) + (f363980m * 2);
        f363990w = k17;
        f363991x = (k17 * 9) / 16;
        int k18 = ((com.tencent.biz.qui.quicommon.e.k() - (a16 * 2)) / 2) + (f363980m * 2);
        f363992y = k18;
        f363993z = (k18 * 9) / 16;
        int k19 = ((com.tencent.biz.qui.quicommon.e.k() - com.tencent.biz.qui.quicommon.e.l(ud0.b.a())) - (com.tencent.biz.qui.quicommon.e.a(14.0f) * 2)) + (f363980m * 2);
        A = k19;
        B = (k19 * 9) / 16;
        int k26 = (com.tencent.biz.qui.quicommon.e.k() / 2) + (f363980m * 2);
        C = k26;
        D = (k26 * 9) / 16;
        int k27 = (com.tencent.biz.qui.quicommon.e.k() / 2) + (f363980m * 2);
        E = k27;
        F = (k27 * 16) / 9;
        int k28 = (com.tencent.biz.qui.quicommon.e.k() / 3) + (f363980m * 2);
        G = k28;
        H = (k28 * 16) / 9;
        I = new HashMap<>();
    }

    public m(boolean z16, boolean z17) {
        int h16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.f363996c = z16;
        this.f363997d = z17;
        this.f363994a = b();
        this.f363995b = a();
        HashMap<String, Integer> hashMap = I;
        if (hashMap.containsKey(this.f363997d + "top_margin" + this.f363996c)) {
            h16 = hashMap.get(this.f363997d + "top_margin" + this.f363996c).intValue();
        } else {
            h16 = h();
        }
        this.f363998e = h16;
        if (hashMap.containsKey(this.f363997d + "right_margin" + this.f363996c)) {
            i3 = hashMap.get(this.f363997d + "right_margin" + this.f363996c).intValue();
        } else {
            i3 = f363983p;
        }
        this.f363999f = i3;
    }

    private int b() {
        if (this.f363997d) {
            if (this.f363996c) {
                return f363988u;
            }
            return f363992y;
        }
        if (this.f363996c) {
            return D;
        }
        return H;
    }

    private int f(boolean z16) {
        int i3;
        int g16;
        int l3;
        int i16;
        if (this.f363997d) {
            int h16 = com.tencent.biz.qui.quicommon.e.h();
            if (z16) {
                i16 = f363989v;
            } else {
                i16 = f363993z;
            }
            g16 = h16 - i16;
            l3 = g();
        } else {
            int h17 = com.tencent.biz.qui.quicommon.e.h();
            if (z16) {
                i3 = C;
            } else {
                i3 = G;
            }
            g16 = (h17 - i3) - g();
            l3 = com.tencent.biz.qui.quicommon.e.l(ud0.b.a());
        }
        return g16 - l3;
    }

    private int q(boolean z16) {
        int r16 = r(z16);
        boolean m3 = com.tencent.biz.qui.quicommon.e.m();
        boolean n3 = com.tencent.biz.qui.quicommon.e.n();
        int l3 = com.tencent.biz.qui.quicommon.e.l(ud0.b.a());
        if (m3) {
            if (n3) {
                return (com.tencent.biz.qui.quicommon.e.j() - r16) - f363983p;
            }
            return ((com.tencent.biz.qui.quicommon.e.j() - r16) - f363983p) - l3;
        }
        return (com.tencent.biz.qui.quicommon.e.j() - r16) - f363983p;
    }

    private int r(boolean z16) {
        if (this.f363997d) {
            if (z16) {
                return f363988u;
            }
            return f363992y;
        }
        if (z16) {
            return D;
        }
        return H;
    }

    public m A(boolean z16, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (m) iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Float.valueOf(f16));
        }
        this.f364000g = z16;
        this.f364001h = f16;
        return this;
    }

    public m B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (m) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        this.f363999f = i3;
        return this;
    }

    public m C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (m) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        this.f363998e = i3;
        return this;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (this.f363997d) {
            if (this.f363996c) {
                return f363989v;
            }
            return f363993z;
        }
        if (this.f363996c) {
            return C;
        }
        return G;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.f363995b;
    }

    public int d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, i3)).intValue();
        }
        if (this.f363996c) {
            return (int) (i3 * f363977j);
        }
        return (int) (i3 * f363978k);
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        if (this.f363997d) {
            if (this.f363996c) {
                return f363986s;
            }
            return f363990w;
        }
        if (this.f363996c) {
            return B;
        }
        return F;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        if (this.f363997d) {
            return f363985r;
        }
        return com.tencent.biz.qui.quicommon.e.a(14.0f) - f363980m;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        if (this.f363997d) {
            return f363984q;
        }
        return com.tencent.biz.qui.quicommon.e.a(14.0f) - f363980m;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return b();
    }

    public float j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        return this.f364001h;
    }

    public float k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Float) iPatchRedirector.redirect((short) 26, (Object) this)).floatValue();
        }
        if (this.f363997d) {
            return f363976i;
        }
        return 1.0f / f363976i;
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        int min = Math.min(this.f363999f, (com.tencent.biz.qui.quicommon.e.j() - this.f363994a) - f363983p);
        this.f363999f = min;
        return min;
    }

    public int m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, z16)).intValue();
        }
        if (this.f363997d) {
            if (z16) {
                return f363987t;
            }
            return f363991x;
        }
        if (z16) {
            return A;
        }
        return E;
    }

    public int n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, z16)).intValue();
        }
        if (this.f363997d) {
            if (z16) {
                return f363986s;
            }
            return f363990w;
        }
        if (z16) {
            return B;
        }
        return F;
    }

    public int o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, z16)).intValue();
        }
        if (this.f363997d) {
            if (z16) {
                return f363989v;
            }
            return f363993z;
        }
        if (z16) {
            return C;
        }
        return G;
    }

    public int p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, z16)).intValue();
        }
        if (this.f363997d) {
            if (z16) {
                return f363988u;
            }
            return f363992y;
        }
        if (z16) {
            return D;
        }
        return H;
    }

    public int s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        int max = Math.max(this.f363998e, h());
        this.f363998e = max;
        return max;
    }

    public int t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f363994a;
    }

    public int u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this, i3)).intValue();
        }
        if (this.f363996c) {
            return (int) (i3 * f363978k);
        }
        return (int) (i3 * f363977j);
    }

    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f364000g;
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        if (this.f364000g) {
            HashMap<String, Integer> hashMap = I;
            hashMap.put(this.f363997d + "top_margin" + this.f363996c, Integer.valueOf(Math.min(this.f363998e, f(this.f363996c))));
            hashMap.put(this.f363997d + "right_margin" + this.f363996c, Integer.valueOf(this.f363999f));
            hashMap.put(this.f363997d + "top_margin" + (this.f363996c ^ true), Integer.valueOf(Math.min(this.f363998e, f(!this.f363996c))));
            hashMap.put(this.f363997d + "right_margin" + (this.f363996c ^ true), Integer.valueOf(this.f363999f));
            return;
        }
        HashMap<String, Integer> hashMap2 = I;
        hashMap2.put(this.f363997d + "top_margin" + this.f363996c, Integer.valueOf(Math.min(this.f363998e, f(this.f363996c))));
        hashMap2.put(this.f363997d + "right_margin" + this.f363996c, Integer.valueOf(q(this.f363996c)));
        hashMap2.put(this.f363997d + "top_margin" + (this.f363996c ^ true), Integer.valueOf(Math.min(this.f363998e, f(!this.f363996c))));
        hashMap2.put(this.f363997d + "right_margin" + (this.f363996c ^ true), Integer.valueOf(q(!this.f363996c)));
    }

    public m x(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (m) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        this.f363997d = z17;
        this.f363996c = z16;
        return this;
    }

    public m y(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (m) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        this.f363994a = i3;
        return this;
    }

    public m z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (m) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        this.f363995b = i3;
        return this;
    }
}
