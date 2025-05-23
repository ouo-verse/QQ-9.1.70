package com.tencent.mobileqq.qui.profileskin.material_color.hct;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    static final double[][] f276902k;

    /* renamed from: l, reason: collision with root package name */
    static final double[][] f276903l;

    /* renamed from: a, reason: collision with root package name */
    private final double f276904a;

    /* renamed from: b, reason: collision with root package name */
    private final double f276905b;

    /* renamed from: c, reason: collision with root package name */
    private final double f276906c;

    /* renamed from: d, reason: collision with root package name */
    private final double f276907d;

    /* renamed from: e, reason: collision with root package name */
    private final double f276908e;

    /* renamed from: f, reason: collision with root package name */
    private final double f276909f;

    /* renamed from: g, reason: collision with root package name */
    private final double f276910g;

    /* renamed from: h, reason: collision with root package name */
    private final double f276911h;

    /* renamed from: i, reason: collision with root package name */
    private final double f276912i;

    /* renamed from: j, reason: collision with root package name */
    private final double[] f276913j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50648);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f276902k = new double[][]{new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};
            f276903l = new double[][]{new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};
        }
    }

    a(double d16, double d17, double d18, double d19, double d26, double d27, double d28, double d29, double d36) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Double.valueOf(d16), Double.valueOf(d17), Double.valueOf(d18), Double.valueOf(d19), Double.valueOf(d26), Double.valueOf(d27), Double.valueOf(d28), Double.valueOf(d29), Double.valueOf(d36));
            return;
        }
        this.f276913j = new double[]{0.0d, 0.0d, 0.0d};
        this.f276904a = d16;
        this.f276905b = d17;
        this.f276906c = d18;
        this.f276907d = d19;
        this.f276908e = d26;
        this.f276909f = d27;
        this.f276910g = d28;
        this.f276911h = d29;
        this.f276912i = d36;
    }

    public static a a(int i3) {
        return b(i3, d.f276922k);
    }

    static a b(int i3, d dVar) {
        double i16 = com.tencent.mobileqq.qui.profileskin.material_color.utils.a.i((16711680 & i3) >> 16);
        double i17 = com.tencent.mobileqq.qui.profileskin.material_color.utils.a.i((65280 & i3) >> 8);
        double i18 = com.tencent.mobileqq.qui.profileskin.material_color.utils.a.i(i3 & 255);
        return c((0.41233895d * i16) + (0.35762064d * i17) + (0.18051042d * i18), (0.2126d * i16) + (0.7152d * i17) + (0.0722d * i18), (i16 * 0.01932141d) + (i17 * 0.11916382d) + (i18 * 0.95034478d), dVar);
    }

    static a c(double d16, double d17, double d18, d dVar) {
        double d19;
        double[][] dArr = f276902k;
        double[] dArr2 = dArr[0];
        double d26 = (dArr2[0] * d16) + (dArr2[1] * d17) + (dArr2[2] * d18);
        double[] dArr3 = dArr[1];
        double d27 = (dArr3[0] * d16) + (dArr3[1] * d17) + (dArr3[2] * d18);
        double[] dArr4 = dArr[2];
        double d28 = (dArr4[0] * d16) + (dArr4[1] * d17) + (dArr4[2] * d18);
        double d29 = dVar.j()[0] * d26;
        double d36 = dVar.j()[1] * d27;
        double d37 = dVar.j()[2] * d28;
        double pow = Math.pow((dVar.d() * Math.abs(d29)) / 100.0d, 0.42d);
        double pow2 = Math.pow((dVar.d() * Math.abs(d36)) / 100.0d, 0.42d);
        double pow3 = Math.pow((dVar.d() * Math.abs(d37)) / 100.0d, 0.42d);
        double signum = ((Math.signum(d29) * 400.0d) * pow) / (pow + 27.13d);
        double signum2 = ((Math.signum(d36) * 400.0d) * pow2) / (pow2 + 27.13d);
        double signum3 = ((Math.signum(d37) * 400.0d) * pow3) / (pow3 + 27.13d);
        double d38 = (((signum * 11.0d) + ((-12.0d) * signum2)) + signum3) / 11.0d;
        double d39 = ((signum + signum2) - (signum3 * 2.0d)) / 9.0d;
        double d46 = signum2 * 20.0d;
        double d47 = (((signum * 20.0d) + d46) + (21.0d * signum3)) / 20.0d;
        double d48 = (((signum * 40.0d) + d46) + signum3) / 20.0d;
        double degrees = Math.toDegrees(Math.atan2(d39, d38));
        if (degrees < 0.0d) {
            degrees += 360.0d;
        } else if (degrees >= 360.0d) {
            degrees -= 360.0d;
        }
        double d49 = degrees;
        double radians = Math.toRadians(d49);
        double pow4 = Math.pow((d48 * dVar.g()) / dVar.b(), dVar.c() * dVar.k()) * 100.0d;
        double d56 = pow4 / 100.0d;
        double c16 = (4.0d / dVar.c()) * Math.sqrt(d56) * (dVar.b() + 4.0d) * dVar.e();
        if (d49 < 20.14d) {
            d19 = d49 + 360.0d;
        } else {
            d19 = d49;
        }
        double pow5 = Math.pow(1.64d - Math.pow(0.29d, dVar.f()), 0.73d) * Math.pow(((((((Math.cos(Math.toRadians(d19) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d) * dVar.h()) * dVar.i()) * Math.hypot(d38, d39)) / (d47 + 0.305d), 0.9d);
        double sqrt = Math.sqrt(d56) * pow5;
        double e16 = sqrt * dVar.e();
        double log1p = Math.log1p(e16 * 0.0228d) * 43.859649122807014d;
        return new a(d49, sqrt, pow4, c16, e16, Math.sqrt((pow5 * dVar.c()) / (dVar.b() + 4.0d)) * 50.0d, (1.7000000000000002d * pow4) / ((0.007d * pow4) + 1.0d), log1p * Math.cos(radians), log1p * Math.sin(radians));
    }

    public double d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Double) iPatchRedirector.redirect((short) 3, (Object) this)).doubleValue();
        }
        return this.f276905b;
    }

    public double e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Double) iPatchRedirector.redirect((short) 2, (Object) this)).doubleValue();
        }
        return this.f276904a;
    }
}
