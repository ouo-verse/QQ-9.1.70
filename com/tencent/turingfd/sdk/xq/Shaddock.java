package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Shaddock extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f383069a;

    /* renamed from: b, reason: collision with root package name */
    public float f383070b;

    /* renamed from: c, reason: collision with root package name */
    public float f383071c;

    /* renamed from: d, reason: collision with root package name */
    public float f383072d;

    /* renamed from: e, reason: collision with root package name */
    public float f383073e;

    public Shaddock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383069a = 0;
        this.f383070b = 0.0f;
        this.f383071c = 0.0f;
        this.f383072d = 0.0f;
        this.f383073e = 0.0f;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f383069a, 0);
        solar.a(this.f383070b, 1);
        solar.a(this.f383071c, 2);
        float f16 = this.f383072d;
        if (f16 != 0.0f) {
            solar.a(f16, 3);
        }
        float f17 = this.f383073e;
        if (f17 != 0.0f) {
            solar.a(f17, 4);
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) serpens);
            return;
        }
        this.f383069a = serpens.a(this.f383069a, 0, true);
        this.f383070b = serpens.a(this.f383070b, 1, true);
        this.f383071c = serpens.a(this.f383071c, 2, true);
        this.f383072d = serpens.a(this.f383072d, 3, false);
        this.f383073e = serpens.a(this.f383073e, 4, false);
    }
}
