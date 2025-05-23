package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.const, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cconst extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static Dew f383241e;

    /* renamed from: f, reason: collision with root package name */
    public static List<Date> f383242f;

    /* renamed from: g, reason: collision with root package name */
    public static List<Fig> f383243g;

    /* renamed from: h, reason: collision with root package name */
    public static List<Durian> f383244h;

    /* renamed from: a, reason: collision with root package name */
    public Dew f383245a;

    /* renamed from: b, reason: collision with root package name */
    public List<Date> f383246b;

    /* renamed from: c, reason: collision with root package name */
    public List<Fig> f383247c;

    /* renamed from: d, reason: collision with root package name */
    public List<Durian> f383248d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13473);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f383241e = new Dew();
        f383242f = new ArrayList();
        f383242f.add(new Date());
        f383243g = new ArrayList();
        f383243g.add(new Fig());
        f383244h = new ArrayList();
        f383244h.add(new Durian());
    }

    public Cconst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383245a = null;
        this.f383246b = null;
        this.f383247c = null;
        this.f383248d = null;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        Dew dew = this.f383245a;
        if (dew != null) {
            solar.a((Taurus) dew, 0);
        }
        List<Date> list = this.f383246b;
        if (list != null) {
            solar.a((Collection) list, 1);
        }
        List<Fig> list2 = this.f383247c;
        if (list2 != null) {
            solar.a((Collection) list2, 2);
        }
        List<Durian> list3 = this.f383248d;
        if (list3 != null) {
            solar.a((Collection) list3, 3);
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
        if (obj == null || !(obj instanceof Cconst)) {
            return false;
        }
        Cconst cconst = (Cconst) obj;
        Dew dew = this.f383245a;
        Dew dew2 = cconst.f383245a;
        int i3 = Triangulum.f383138a;
        if (dew.equals(dew2) && this.f383246b.equals(cconst.f383246b) && this.f383247c.equals(cconst.f383247c) && this.f383248d.equals(cconst.f383248d)) {
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
        this.f383245a = (Dew) serpens.a((Taurus) f383241e, 0, false);
        this.f383246b = (List) serpens.a((Serpens) f383242f, 1, false);
        this.f383247c = (List) serpens.a((Serpens) f383243g, 2, false);
        this.f383248d = (List) serpens.a((Serpens) f383244h, 3, false);
    }
}
