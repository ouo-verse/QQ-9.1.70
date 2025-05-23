package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Kiwifruit extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static Hickory f382857e;

    /* renamed from: f, reason: collision with root package name */
    public static String f382858f;

    /* renamed from: a, reason: collision with root package name */
    public Hickory f382859a;

    /* renamed from: b, reason: collision with root package name */
    public String f382860b;

    /* renamed from: c, reason: collision with root package name */
    public String f382861c;

    /* renamed from: d, reason: collision with root package name */
    public String f382862d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11929);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382857e = new Hickory();
            f382858f = new String();
        }
    }

    public Kiwifruit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382859a = null;
        this.f382860b = "";
        this.f382861c = "";
        this.f382862d = null;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a((Taurus) this.f382859a, 0);
        String str = this.f382860b;
        if (str != null) {
            solar.a(str, 1);
        }
        String str2 = this.f382861c;
        if (str2 != null) {
            solar.a(str2, 2);
        }
        String str3 = this.f382862d;
        if (str3 != null) {
            solar.a(str3, 3);
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
        if (obj == null || !(obj instanceof Kiwifruit)) {
            return false;
        }
        Kiwifruit kiwifruit = (Kiwifruit) obj;
        Hickory hickory = this.f382859a;
        Hickory hickory2 = kiwifruit.f382859a;
        int i3 = Triangulum.f383138a;
        if (hickory.equals(hickory2) && this.f382860b.equals(kiwifruit.f382860b) && this.f382861c.equals(kiwifruit.f382861c) && this.f382862d.equals(kiwifruit.f382862d)) {
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
        this.f382859a = (Hickory) serpens.a((Taurus) f382857e, 0, true);
        this.f382860b = serpens.b(1, false);
        this.f382861c = serpens.b(2, false);
        this.f382862d = serpens.a(f382858f, 3, false);
    }
}
