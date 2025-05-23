package com.tencent.mobileqq.qui.profileskin.material_color.palettes;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qui.profileskin.material_color.hct.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    Map<Integer, Integer> f276933a;

    /* renamed from: b, reason: collision with root package name */
    b f276934b;

    /* renamed from: c, reason: collision with root package name */
    double f276935c;

    /* renamed from: d, reason: collision with root package name */
    double f276936d;

    a(double d16, double d17, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Double.valueOf(d16), Double.valueOf(d17), bVar);
            return;
        }
        this.f276933a = new HashMap();
        this.f276935c = d16;
        this.f276936d = d17;
        this.f276934b = bVar;
    }

    private static b a(double d16, double d17) {
        b a16 = b.a(d16, d17, 50.0d);
        b bVar = a16;
        double abs = Math.abs(a16.c() - d17);
        for (double d18 = 1.0d; d18 < 50.0d; d18 += 1.0d) {
            if (Math.round(d17) == Math.round(bVar.c())) {
                return bVar;
            }
            b a17 = b.a(d16, d17, 50.0d + d18);
            double abs2 = Math.abs(a17.c() - d17);
            if (abs2 < abs) {
                bVar = a17;
                abs = abs2;
            }
            b a18 = b.a(d16, d17, 50.0d - d18);
            double abs3 = Math.abs(a18.c() - d17);
            if (abs3 < abs) {
                bVar = a18;
                abs = abs3;
            }
        }
        return bVar;
    }

    public static a b(double d16, double d17) {
        return new a(d16, d17, a(d16, d17));
    }

    public b c(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16));
        }
        return b.a(this.f276935c, this.f276936d, d16);
    }
}
