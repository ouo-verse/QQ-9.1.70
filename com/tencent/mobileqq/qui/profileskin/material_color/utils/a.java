package com.tencent.mobileqq.qui.profileskin.material_color.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static final double[][] f276937a;

    /* renamed from: b, reason: collision with root package name */
    static final double[][] f276938b;

    /* renamed from: c, reason: collision with root package name */
    static final double[] f276939c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50657);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f276937a = new double[][]{new double[]{0.41233895d, 0.35762064d, 0.18051042d}, new double[]{0.2126d, 0.7152d, 0.0722d}, new double[]{0.01932141d, 0.11916382d, 0.95034478d}};
        f276938b = new double[][]{new double[]{3.2413774792388685d, -1.5376652402851851d, -0.49885366846268053d}, new double[]{-0.9691452513005321d, 1.8758853451067872d, 0.04156585616912061d}, new double[]{0.05562093689691305d, -0.20395524564742123d, 1.0571799111220335d}};
        f276939c = new double[]{95.047d, 100.0d, 108.883d};
    }

    public static int a(double[] dArr) {
        return c(e(dArr[0]), e(dArr[1]), e(dArr[2]));
    }

    public static int b(double d16) {
        int e16 = e(n(d16));
        return c(e16, e16, e16);
    }

    public static int c(int i3, int i16, int i17) {
        return ((i3 & 255) << 16) | (-16777216) | ((i16 & 255) << 8) | (i17 & 255);
    }

    public static int d(int i3) {
        return i3 & 255;
    }

    public static int e(double d16) {
        double pow;
        double d17 = d16 / 100.0d;
        if (d17 <= 0.0031308d) {
            pow = d17 * 12.92d;
        } else {
            pow = (Math.pow(d17, 0.4166666666666667d) * 1.055d) - 0.055d;
        }
        return b.b(0, 255, (int) Math.round(pow * 255.0d));
    }

    public static int f(int i3) {
        return (i3 >> 8) & 255;
    }

    static double g(double d16) {
        if (d16 > 0.008856451679035631d) {
            return Math.pow(d16, 0.3333333333333333d);
        }
        return ((d16 * 903.2962962962963d) + 16.0d) / 116.0d;
    }

    static double h(double d16) {
        double d17 = d16 * d16 * d16;
        if (d17 > 0.008856451679035631d) {
            return d17;
        }
        return ((d16 * 116.0d) - 16.0d) / 903.2962962962963d;
    }

    public static double i(int i3) {
        double pow;
        double d16 = i3 / 255.0d;
        if (d16 <= 0.040449936d) {
            pow = d16 / 12.92d;
        } else {
            pow = Math.pow((d16 + 0.055d) / 1.055d, 2.4d);
        }
        return pow * 100.0d;
    }

    public static double j(int i3) {
        return (g(m(i3)[1] / 100.0d) * 116.0d) - 16.0d;
    }

    public static int k(int i3) {
        return (i3 >> 16) & 255;
    }

    public static double[] l() {
        return f276939c;
    }

    public static double[] m(int i3) {
        return b.d(new double[]{i(k(i3)), i(f(i3)), i(d(i3))}, f276937a);
    }

    public static double n(double d16) {
        return h((d16 + 16.0d) / 116.0d) * 100.0d;
    }
}
