package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Mandarin extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static Mangosteen f382888g;

    /* renamed from: h, reason: collision with root package name */
    public static Mango f382889h;

    /* renamed from: i, reason: collision with root package name */
    public static Loquat f382890i;

    /* renamed from: a, reason: collision with root package name */
    public int f382891a;

    /* renamed from: b, reason: collision with root package name */
    public int f382892b;

    /* renamed from: c, reason: collision with root package name */
    public int f382893c;

    /* renamed from: d, reason: collision with root package name */
    public Mangosteen f382894d;

    /* renamed from: e, reason: collision with root package name */
    public Mango f382895e;

    /* renamed from: f, reason: collision with root package name */
    public Loquat f382896f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12046);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f382888g = new Mangosteen();
        f382889h = new Mango();
        f382890i = new Loquat();
    }

    public Mandarin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382891a = 0;
        this.f382892b = 0;
        this.f382893c = 0;
        this.f382894d = null;
        this.f382895e = null;
        this.f382896f = null;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382891a, 0);
        solar.a(this.f382892b, 1);
        solar.a(this.f382893c, 2);
        Mangosteen mangosteen = this.f382894d;
        if (mangosteen != null) {
            solar.a((Taurus) mangosteen, 3);
        }
        Mango mango = this.f382895e;
        if (mango != null) {
            solar.a((Taurus) mango, 4);
        }
        Loquat loquat = this.f382896f;
        if (loquat != null) {
            solar.a((Taurus) loquat, 5);
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
        if (obj == null || !(obj instanceof Mandarin)) {
            return false;
        }
        Mandarin mandarin = (Mandarin) obj;
        if (Triangulum.a(this.f382891a, mandarin.f382891a) && Triangulum.a(this.f382892b, mandarin.f382892b) && Triangulum.a(this.f382893c, mandarin.f382893c) && this.f382894d.equals(mandarin.f382894d) && this.f382895e.equals(mandarin.f382895e) && this.f382896f.equals(mandarin.f382896f)) {
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
        this.f382891a = serpens.a(this.f382891a, 0, true);
        this.f382892b = serpens.a(this.f382892b, 1, false);
        this.f382893c = serpens.a(this.f382893c, 2, false);
        this.f382894d = (Mangosteen) serpens.a((Taurus) f382888g, 3, false);
        this.f382895e = (Mango) serpens.a((Taurus) f382889h, 4, false);
        this.f382896f = (Loquat) serpens.a((Taurus) f382890i, 5, false);
    }
}
