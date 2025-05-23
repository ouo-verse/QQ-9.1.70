package com.tencent.mobileqq.qui.profileskin.material_color.hct;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static final d f276922k;

    /* renamed from: a, reason: collision with root package name */
    private final double f276923a;

    /* renamed from: b, reason: collision with root package name */
    private final double f276924b;

    /* renamed from: c, reason: collision with root package name */
    private final double f276925c;

    /* renamed from: d, reason: collision with root package name */
    private final double f276926d;

    /* renamed from: e, reason: collision with root package name */
    private final double f276927e;

    /* renamed from: f, reason: collision with root package name */
    private final double f276928f;

    /* renamed from: g, reason: collision with root package name */
    private final double[] f276929g;

    /* renamed from: h, reason: collision with root package name */
    private final double f276930h;

    /* renamed from: i, reason: collision with root package name */
    private final double f276931i;

    /* renamed from: j, reason: collision with root package name */
    private final double f276932j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50655);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f276922k = a(50.0d);
        }
    }

    d(double d16, double d17, double d18, double d19, double d26, double d27, double[] dArr, double d28, double d29, double d36) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Double.valueOf(d16), Double.valueOf(d17), Double.valueOf(d18), Double.valueOf(d19), Double.valueOf(d26), Double.valueOf(d27), dArr, Double.valueOf(d28), Double.valueOf(d29), Double.valueOf(d36));
            return;
        }
        this.f276928f = d16;
        this.f276923a = d17;
        this.f276924b = d18;
        this.f276925c = d19;
        this.f276926d = d26;
        this.f276927e = d27;
        this.f276929g = dArr;
        this.f276930h = d28;
        this.f276931i = d29;
        this.f276932j = d36;
    }

    public static d a(double d16) {
        return l(com.tencent.mobileqq.qui.profileskin.material_color.utils.a.l(), (com.tencent.mobileqq.qui.profileskin.material_color.utils.a.n(50.0d) * 63.66197723675813d) / 100.0d, d16, 2.0d, false);
    }

    public static d l(double[] dArr, double d16, double d17, double d18, boolean z16) {
        double c16;
        double max = Math.max(0.1d, d17);
        double[][] dArr2 = a.f276902k;
        double d19 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d26 = dArr3[0] * d19;
        double d27 = dArr[1];
        double d28 = d26 + (dArr3[1] * d27);
        double d29 = dArr[2];
        double d36 = d28 + (dArr3[2] * d29);
        double[] dArr4 = dArr2[1];
        double d37 = (dArr4[0] * d19) + (dArr4[1] * d27) + (dArr4[2] * d29);
        double[] dArr5 = dArr2[2];
        double d38 = (d19 * dArr5[0]) + (d27 * dArr5[1]) + (d29 * dArr5[2]);
        double d39 = (d18 / 10.0d) + 0.8d;
        if (d39 >= 0.9d) {
            c16 = com.tencent.mobileqq.qui.profileskin.material_color.utils.b.c(0.59d, 0.69d, (d39 - 0.9d) * 10.0d);
        } else {
            c16 = com.tencent.mobileqq.qui.profileskin.material_color.utils.b.c(0.525d, 0.59d, (d39 - 0.8d) * 10.0d);
        }
        double d46 = c16;
        double a16 = com.tencent.mobileqq.qui.profileskin.material_color.utils.b.a(0.0d, 1.0d, z16 ? 1.0d : (1.0d - (Math.exp(((-d16) - 42.0d) / 92.0d) * 0.2777777777777778d)) * d39);
        double[] dArr6 = {(((100.0d / d36) * a16) + 1.0d) - a16, (((100.0d / d37) * a16) + 1.0d) - a16, (((100.0d / d38) * a16) + 1.0d) - a16};
        double d47 = 5.0d * d16;
        double d48 = 1.0d / (d47 + 1.0d);
        double d49 = d48 * d48 * d48 * d48;
        double d56 = 1.0d - d49;
        double cbrt = (d49 * d16) + (0.1d * d56 * d56 * Math.cbrt(d47));
        double n3 = com.tencent.mobileqq.qui.profileskin.material_color.utils.a.n(max) / dArr[1];
        double sqrt = Math.sqrt(n3) + 1.48d;
        double pow = 0.725d / Math.pow(n3, 0.2d);
        double pow2 = Math.pow(((dArr6[2] * cbrt) * d38) / 100.0d, 0.42d);
        double[] dArr7 = {Math.pow(((dArr6[0] * cbrt) * d36) / 100.0d, 0.42d), Math.pow(((dArr6[1] * cbrt) * d37) / 100.0d, 0.42d), pow2};
        double d57 = dArr7[0];
        double d58 = (d57 * 400.0d) / (d57 + 27.13d);
        double d59 = dArr7[1];
        return new d(n3, ((d58 * 2.0d) + ((d59 * 400.0d) / (d59 + 27.13d)) + (((400.0d * pow2) / (pow2 + 27.13d)) * 0.05d)) * pow, pow, pow, d46, d39, dArr6, cbrt, Math.pow(cbrt, 0.25d), sqrt);
    }

    public double b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Double) iPatchRedirector.redirect((short) 1, (Object) this)).doubleValue();
        }
        return this.f276923a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double c() {
        return this.f276926d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double d() {
        return this.f276930h;
    }

    public double e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Double) iPatchRedirector.redirect((short) 5, (Object) this)).doubleValue();
        }
        return this.f276931i;
    }

    public double f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Double) iPatchRedirector.redirect((short) 2, (Object) this)).doubleValue();
        }
        return this.f276928f;
    }

    public double g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Double) iPatchRedirector.redirect((short) 3, (Object) this)).doubleValue();
        }
        return this.f276924b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double h() {
        return this.f276927e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double i() {
        return this.f276925c;
    }

    public double[] j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (double[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f276929g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double k() {
        return this.f276932j;
    }
}
