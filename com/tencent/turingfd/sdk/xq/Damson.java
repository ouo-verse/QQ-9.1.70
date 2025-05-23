package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Damson extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name */
    public static Pomegranate f382687o;

    /* renamed from: p, reason: collision with root package name */
    public static Ccase f382688p;

    /* renamed from: a, reason: collision with root package name */
    public int f382689a;

    /* renamed from: b, reason: collision with root package name */
    public int f382690b;

    /* renamed from: c, reason: collision with root package name */
    public int f382691c;

    /* renamed from: d, reason: collision with root package name */
    public int f382692d;

    /* renamed from: e, reason: collision with root package name */
    public int f382693e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f382694f;

    /* renamed from: g, reason: collision with root package name */
    public int f382695g;

    /* renamed from: h, reason: collision with root package name */
    public int f382696h;

    /* renamed from: i, reason: collision with root package name */
    public long f382697i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f382698j;

    /* renamed from: k, reason: collision with root package name */
    public int f382699k;

    /* renamed from: l, reason: collision with root package name */
    public int f382700l;

    /* renamed from: m, reason: collision with root package name */
    public Pomegranate f382701m;

    /* renamed from: n, reason: collision with root package name */
    public Ccase f382702n;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11401);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382687o = new Pomegranate();
            f382688p = new Ccase();
        }
    }

    public Damson() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382689a = 0;
        this.f382690b = 0;
        this.f382691c = 0;
        this.f382692d = 0;
        this.f382693e = 0;
        this.f382694f = null;
        this.f382695g = 0;
        this.f382696h = 0;
        this.f382697i = 0L;
        this.f382698j = null;
        this.f382699k = 0;
        this.f382700l = 0;
        this.f382701m = null;
        this.f382702n = null;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382689a, 0);
        solar.a(this.f382690b, 1);
        solar.a(this.f382691c, 2);
        solar.a(this.f382692d, 3);
        solar.a(this.f382693e, 4);
        byte[] bArr = this.f382694f;
        if (bArr != null) {
            solar.a(bArr, 5);
        }
        solar.a(this.f382695g, 6);
        solar.a(this.f382696h, 7);
        solar.a(this.f382697i, 8);
        byte[] bArr2 = this.f382698j;
        if (bArr2 != null) {
            solar.a(bArr2, 9);
        }
        solar.a(this.f382699k, 10);
        solar.a(this.f382700l, 11);
        Pomegranate pomegranate = this.f382701m;
        if (pomegranate != null) {
            solar.a((Taurus) pomegranate, 12);
        }
        Ccase ccase = this.f382702n;
        if (ccase != null) {
            solar.a((Taurus) ccase, 13);
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
        if (obj == null || !(obj instanceof Damson)) {
            return false;
        }
        Damson damson = (Damson) obj;
        if (Triangulum.a(this.f382689a, damson.f382689a) && Triangulum.a(this.f382690b, damson.f382690b) && Triangulum.a(this.f382691c, damson.f382691c) && Triangulum.a(this.f382692d, damson.f382692d) && Triangulum.a(this.f382693e, damson.f382693e) && this.f382694f.equals(damson.f382694f) && Triangulum.a(this.f382695g, damson.f382695g) && Triangulum.a(this.f382696h, damson.f382696h) && Triangulum.a(this.f382697i, damson.f382697i) && this.f382698j.equals(damson.f382698j) && Triangulum.a(this.f382699k, damson.f382699k) && Triangulum.a(this.f382700l, damson.f382700l) && this.f382701m.equals(damson.f382701m) && this.f382702n.equals(damson.f382702n)) {
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
        this.f382689a = serpens.a(this.f382689a, 0, false);
        this.f382690b = serpens.a(this.f382690b, 1, false);
        this.f382691c = serpens.a(this.f382691c, 2, false);
        this.f382692d = serpens.a(this.f382692d, 3, false);
        this.f382693e = serpens.a(this.f382693e, 4, false);
        this.f382694f = serpens.a(5, false);
        this.f382695g = serpens.a(this.f382695g, 6, false);
        this.f382696h = serpens.a(this.f382696h, 7, false);
        this.f382697i = serpens.a(this.f382697i, 8, false);
        this.f382698j = serpens.a(9, false);
        this.f382699k = serpens.a(this.f382699k, 10, false);
        this.f382700l = serpens.a(this.f382700l, 11, false);
        this.f382701m = (Pomegranate) serpens.a((Taurus) f382687o, 12, false);
        this.f382702n = (Ccase) serpens.a((Taurus) f382688p, 13, false);
    }
}
