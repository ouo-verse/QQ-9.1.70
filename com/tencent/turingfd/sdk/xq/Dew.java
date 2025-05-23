package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Dew extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static Damson f382718f;

    /* renamed from: g, reason: collision with root package name */
    public static Herbaceous f382719g;

    /* renamed from: a, reason: collision with root package name */
    public Damson f382720a;

    /* renamed from: b, reason: collision with root package name */
    public Herbaceous f382721b;

    /* renamed from: c, reason: collision with root package name */
    public int f382722c;

    /* renamed from: d, reason: collision with root package name */
    public String f382723d;

    /* renamed from: e, reason: collision with root package name */
    public String f382724e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11459);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382718f = new Damson();
            f382719g = new Herbaceous();
        }
    }

    public Dew() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382720a = null;
        this.f382721b = null;
        this.f382722c = 0;
        this.f382723d = "";
        this.f382724e = "";
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        Damson damson = this.f382720a;
        if (damson != null) {
            solar.a((Taurus) damson, 0);
        }
        Herbaceous herbaceous = this.f382721b;
        if (herbaceous != null) {
            solar.a((Taurus) herbaceous, 1);
        }
        solar.a(this.f382722c, 2);
        String str = this.f382723d;
        if (str != null) {
            solar.a(str, 3);
        }
        String str2 = this.f382724e;
        if (str2 != null) {
            solar.a(str2, 4);
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Dew)) {
            return false;
        }
        Dew dew = (Dew) obj;
        Damson damson = this.f382720a;
        Damson damson2 = dew.f382720a;
        int i3 = Triangulum.f383138a;
        if (damson.equals(damson2) && this.f382721b.equals(dew.f382721b) && Triangulum.a(this.f382722c, dew.f382722c) && this.f382723d.equals(dew.f382723d) && this.f382724e.equals(dew.f382724e)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) serpens);
            return;
        }
        this.f382720a = (Damson) serpens.a((Taurus) f382718f, 0, false);
        this.f382721b = (Herbaceous) serpens.a((Taurus) f382719g, 1, false);
        this.f382722c = serpens.a(this.f382722c, 2, false);
        this.f382723d = serpens.b(3, false);
        this.f382724e = serpens.b(4, false);
    }
}
