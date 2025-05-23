package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Blackberry extends CanisMinor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f375453a;

    /* renamed from: b, reason: collision with root package name */
    public float f375454b;

    /* renamed from: c, reason: collision with root package name */
    public float f375455c;

    /* renamed from: d, reason: collision with root package name */
    public float f375456d;

    /* renamed from: e, reason: collision with root package name */
    public float f375457e;

    public Blackberry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f375453a = 0;
        this.f375454b = 0.0f;
        this.f375455c = 0.0f;
        this.f375456d = 0.0f;
        this.f375457e = 0.0f;
    }

    @Override // com.tencent.tfd.sdk.wxa.CanisMinor
    public final void a(Canesatici canesatici) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canesatici);
            return;
        }
        canesatici.a(this.f375453a, 0);
        canesatici.a(this.f375454b, 1);
        canesatici.a(this.f375455c, 2);
        float f16 = this.f375456d;
        if (f16 != 0.0f) {
            canesatici.a(f16, 3);
        }
        float f17 = this.f375457e;
        if (f17 != 0.0f) {
            canesatici.a(f17, 4);
        }
    }

    @Override // com.tencent.tfd.sdk.wxa.CanisMinor
    public final void a(Caelum caelum) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) caelum);
            return;
        }
        this.f375453a = caelum.a(this.f375453a, 0, true);
        this.f375454b = caelum.a(this.f375454b, 1, true);
        this.f375455c = caelum.a(this.f375455c, 2, true);
        this.f375456d = caelum.a(this.f375456d, 3, false);
        this.f375457e = caelum.a(this.f375457e, 4, false);
    }
}
