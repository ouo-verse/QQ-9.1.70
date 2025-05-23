package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Herbaceous extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f382813a;

    /* renamed from: b, reason: collision with root package name */
    public String f382814b;

    /* renamed from: c, reason: collision with root package name */
    public String f382815c;

    /* renamed from: d, reason: collision with root package name */
    public String f382816d;

    /* renamed from: e, reason: collision with root package name */
    public int f382817e;

    /* renamed from: f, reason: collision with root package name */
    public String f382818f;

    /* renamed from: g, reason: collision with root package name */
    public String f382819g;

    /* renamed from: h, reason: collision with root package name */
    public int f382820h;

    public Herbaceous() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382813a = "";
        this.f382814b = "";
        this.f382815c = "";
        this.f382816d = "";
        this.f382817e = 0;
        this.f382818f = "";
        this.f382819g = "";
        this.f382820h = 0;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) solar);
            return;
        }
        String str = this.f382813a;
        if (str != null) {
            solar.a(str, 0);
        }
        String str2 = this.f382814b;
        if (str2 != null) {
            solar.a(str2, 1);
        }
        String str3 = this.f382815c;
        if (str3 != null) {
            solar.a(str3, 2);
        }
        String str4 = this.f382816d;
        if (str4 != null) {
            solar.a(str4, 3);
        }
        int i3 = this.f382817e;
        if (i3 != 0) {
            solar.a(i3, 4);
        }
        String str5 = this.f382818f;
        if (str5 != null) {
            solar.a(str5, 5);
        }
        String str6 = this.f382819g;
        if (str6 != null) {
            solar.a(str6, 6);
        }
        int i16 = this.f382820h;
        if (i16 != 0) {
            solar.a(i16, 7);
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) serpens);
            return;
        }
        this.f382813a = serpens.b(0, false);
        this.f382814b = serpens.b(1, false);
        this.f382815c = serpens.b(2, false);
        this.f382816d = serpens.b(3, false);
        this.f382817e = serpens.a(this.f382817e, 4, false);
        this.f382818f = serpens.b(5, false);
        this.f382819g = serpens.b(6, false);
        this.f382820h = serpens.a(this.f382820h, 7, false);
    }
}
