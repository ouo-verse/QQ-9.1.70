package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Mango extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static List<Lichee> f382897c;

    /* renamed from: a, reason: collision with root package name */
    public int f382898a;

    /* renamed from: b, reason: collision with root package name */
    public List<Lichee> f382899b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12075);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f382897c = arrayList;
        arrayList.add(new Lichee());
    }

    public Mango() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f382898a = 0;
            this.f382899b = null;
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382898a, 0);
        List<Lichee> list = this.f382899b;
        if (list != null) {
            solar.a((Collection) list, 1);
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
        if (obj == null || !(obj instanceof Mango)) {
            return false;
        }
        Mango mango = (Mango) obj;
        if (Triangulum.a(this.f382898a, mango.f382898a) && this.f382899b.equals(mango.f382899b)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) serpens);
        } else {
            this.f382898a = serpens.a(this.f382898a, 0, true);
            this.f382899b = (List) serpens.a((Serpens) f382897c, 1, false);
        }
    }
}
