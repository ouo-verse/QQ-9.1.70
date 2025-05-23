package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Triangulum extends CanisMinor implements Cloneable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static Cthrows f375705d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ boolean f375706e;

    /* renamed from: a, reason: collision with root package name */
    public int f375707a;

    /* renamed from: b, reason: collision with root package name */
    public Cthrows f375708b;

    /* renamed from: c, reason: collision with root package name */
    public long f375709c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62743);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f375706e = true;
            f375705d = new Cthrows();
        }
    }

    public Triangulum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f375707a = 0;
        this.f375708b = null;
        this.f375709c = 0L;
    }

    @Override // com.tencent.tfd.sdk.wxa.CanisMinor
    public final void a(Canesatici canesatici) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canesatici);
            return;
        }
        canesatici.a(this.f375707a, 0);
        Cthrows cthrows = this.f375708b;
        if (cthrows != null) {
            canesatici.a((CanisMinor) cthrows, 1);
        }
        canesatici.a(this.f375709c, 2);
    }

    public final Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f375706e) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        Triangulum triangulum = (Triangulum) obj;
        if (!CanisMajor.a(this.f375707a, triangulum.f375707a) || !this.f375708b.equals(triangulum.f375708b) || !CanisMajor.a(this.f375709c, triangulum.f375709c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        try {
            throw new Exception("");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.tfd.sdk.wxa.CanisMinor
    public final void a(Caelum caelum) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) caelum);
            return;
        }
        this.f375707a = caelum.a(this.f375707a, 0, true);
        this.f375708b = (Cthrows) caelum.a((CanisMinor) f375705d, 1, false);
        this.f375709c = caelum.a(this.f375709c, 2, true);
    }
}
