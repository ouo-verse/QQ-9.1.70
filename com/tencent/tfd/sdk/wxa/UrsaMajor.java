package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class UrsaMajor extends CanisMinor implements Cloneable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f375738a;

    /* renamed from: b, reason: collision with root package name */
    public String f375739b;

    /* renamed from: c, reason: collision with root package name */
    public int f375740c;

    /* renamed from: d, reason: collision with root package name */
    public int f375741d;

    public UrsaMajor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f375738a = 0;
        this.f375739b = "";
        this.f375740c = 0;
        this.f375741d = 0;
    }

    @Override // com.tencent.tfd.sdk.wxa.CanisMinor
    public final void a(Canesatici canesatici) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canesatici);
            return;
        }
        canesatici.a(this.f375738a, 0);
        canesatici.a(this.f375739b, 1);
        int i3 = this.f375740c;
        if (i3 != 0) {
            canesatici.a(i3, 3);
        }
        int i16 = this.f375741d;
        if (i16 != 0) {
            canesatici.a(i16, 4);
        }
    }

    @Override // com.tencent.tfd.sdk.wxa.CanisMinor
    public final void a(Caelum caelum) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) caelum);
            return;
        }
        this.f375738a = caelum.a(this.f375738a, 0, true);
        this.f375739b = caelum.b(1, true);
        this.f375740c = caelum.a(this.f375740c, 3, false);
        this.f375741d = caelum.a(this.f375741d, 4, false);
    }
}
