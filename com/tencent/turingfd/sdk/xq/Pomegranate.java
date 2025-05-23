package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class Pomegranate extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f383027a;

    /* renamed from: b, reason: collision with root package name */
    public int f383028b;

    /* renamed from: c, reason: collision with root package name */
    public int f383029c;

    public Pomegranate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383027a = 0;
        this.f383028b = 0;
        this.f383029c = 0;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f383027a, 0);
        solar.a(this.f383028b, 1);
        solar.a(this.f383029c, 2);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Pomegranate)) {
            return false;
        }
        Pomegranate pomegranate = (Pomegranate) obj;
        if (Triangulum.a(this.f383027a, pomegranate.f383027a) && Triangulum.a(this.f383028b, pomegranate.f383028b) && Triangulum.a(this.f383029c, pomegranate.f383029c)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) serpens);
            return;
        }
        this.f383027a = serpens.a(this.f383027a, 0, false);
        this.f383028b = serpens.a(this.f383028b, 1, false);
        this.f383029c = serpens.a(this.f383029c, 2, false);
    }
}
