package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Longan extends Taurus implements Cloneable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static Cprotected f382877d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ boolean f382878e;

    /* renamed from: a, reason: collision with root package name */
    public int f382879a;

    /* renamed from: b, reason: collision with root package name */
    public Cprotected f382880b;

    /* renamed from: c, reason: collision with root package name */
    public long f382881c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11999);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382878e = true;
            f382877d = new Cprotected();
        }
    }

    public Longan() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382879a = 0;
        this.f382880b = null;
        this.f382881c = 0L;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382879a, 0);
        Cprotected cprotected = this.f382880b;
        if (cprotected != null) {
            solar.a((Taurus) cprotected, 1);
        }
        solar.a(this.f382881c, 2);
    }

    public Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f382878e) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        Longan longan = (Longan) obj;
        if (!Triangulum.a(this.f382879a, longan.f382879a) || !this.f382880b.equals(longan.f382880b) || !Triangulum.a(this.f382881c, longan.f382881c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
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

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) serpens);
            return;
        }
        this.f382879a = serpens.a(this.f382879a, 0, true);
        this.f382880b = (Cprotected) serpens.a((Taurus) f382877d, 1, false);
        this.f382881c = serpens.a(this.f382881c, 2, true);
    }
}
