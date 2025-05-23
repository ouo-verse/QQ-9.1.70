package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Loquat extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static List<Lemon> f382882c;

    /* renamed from: a, reason: collision with root package name */
    public int f382883a;

    /* renamed from: b, reason: collision with root package name */
    public List<Lemon> f382884b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12010);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f382882c = arrayList;
        arrayList.add(new Lemon());
    }

    public Loquat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f382883a = 0;
            this.f382884b = null;
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382883a, 0);
        List<Lemon> list = this.f382884b;
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
        if (obj == null || !(obj instanceof Loquat)) {
            return false;
        }
        Loquat loquat = (Loquat) obj;
        if (Triangulum.a(this.f382883a, loquat.f382883a) && this.f382884b.equals(loquat.f382884b)) {
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
            this.f382883a = serpens.a(this.f382883a, 0, true);
            this.f382884b = (List) serpens.a((Serpens) f382882c, 1, false);
        }
    }
}
