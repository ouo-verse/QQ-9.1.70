package com.tencent.mobileqq.qui.profileskin.material_color.hct;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private double f276914a;

    /* renamed from: b, reason: collision with root package name */
    private double f276915b;

    /* renamed from: c, reason: collision with root package name */
    private double f276916c;

    /* renamed from: d, reason: collision with root package name */
    private int f276917d;

    b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            f(i3);
        }
    }

    public static b a(double d16, double d17, double d18) {
        return new b(c.q(d16, d17, d18));
    }

    public static b b(int i3) {
        return new b(i3);
    }

    private void f(int i3) {
        this.f276917d = i3;
        a a16 = a.a(i3);
        this.f276914a = a16.e();
        this.f276915b = a16.d();
        this.f276916c = com.tencent.mobileqq.qui.profileskin.material_color.utils.a.j(i3);
    }

    public double c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Double) iPatchRedirector.redirect((short) 3, (Object) this)).doubleValue();
        }
        return this.f276915b;
    }

    public double d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Double) iPatchRedirector.redirect((short) 2, (Object) this)).doubleValue();
        }
        return this.f276914a;
    }

    public double e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Double) iPatchRedirector.redirect((short) 4, (Object) this)).doubleValue();
        }
        return this.f276916c;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f276917d;
    }
}
