package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Marc extends Taurus implements Cloneable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f382917a;

    /* renamed from: b, reason: collision with root package name */
    public String f382918b;

    /* renamed from: c, reason: collision with root package name */
    public int f382919c;

    /* renamed from: d, reason: collision with root package name */
    public int f382920d;

    /* renamed from: e, reason: collision with root package name */
    public String f382921e;

    /* renamed from: f, reason: collision with root package name */
    public long f382922f;

    public Marc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382917a = 0;
        this.f382918b = "";
        this.f382919c = 0;
        this.f382920d = 0;
        this.f382921e = "";
        this.f382922f = 0L;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382917a, 0);
        solar.a(this.f382918b, 1);
        int i3 = this.f382919c;
        if (i3 != 0) {
            solar.a(i3, 3);
        }
        int i16 = this.f382920d;
        if (i16 != 0) {
            solar.a(i16, 4);
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) serpens);
            return;
        }
        this.f382917a = serpens.a(this.f382917a, 0, true);
        this.f382918b = serpens.b(1, true);
        this.f382919c = serpens.a(this.f382919c, 3, false);
        this.f382920d = serpens.a(this.f382920d, 4, false);
        this.f382921e = serpens.b(5, false);
        this.f382922f = serpens.a(this.f382922f, 6, false);
    }
}
