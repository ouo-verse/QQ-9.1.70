package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Fig extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static List<String> f382739g;

    /* renamed from: h, reason: collision with root package name */
    public static List<String> f382740h;

    /* renamed from: a, reason: collision with root package name */
    public int f382741a;

    /* renamed from: b, reason: collision with root package name */
    public String f382742b;

    /* renamed from: c, reason: collision with root package name */
    public int f382743c;

    /* renamed from: d, reason: collision with root package name */
    public String f382744d;

    /* renamed from: e, reason: collision with root package name */
    public List<String> f382745e;

    /* renamed from: f, reason: collision with root package name */
    public List<String> f382746f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11659);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f382739g = arrayList;
        arrayList.add("");
        ArrayList arrayList2 = new ArrayList();
        f382740h = arrayList2;
        arrayList2.add("");
    }

    public Fig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382741a = 0;
        this.f382742b = "";
        this.f382743c = 0;
        this.f382744d = "";
        this.f382745e = null;
        this.f382746f = null;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382741a, 0);
        String str = this.f382742b;
        if (str != null) {
            solar.a(str, 1);
        }
        solar.a(this.f382743c, 2);
        String str2 = this.f382744d;
        if (str2 != null) {
            solar.a(str2, 3);
        }
        List<String> list = this.f382745e;
        if (list != null) {
            solar.a((Collection) list, 4);
        }
        List<String> list2 = this.f382746f;
        if (list2 != null) {
            solar.a((Collection) list2, 5);
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
        if (obj == null || !(obj instanceof Fig)) {
            return false;
        }
        Fig fig = (Fig) obj;
        if (Triangulum.a(this.f382741a, fig.f382741a) && this.f382742b.equals(fig.f382742b) && Triangulum.a(this.f382743c, fig.f382743c) && this.f382744d.equals(fig.f382744d) && this.f382745e.equals(fig.f382745e) && this.f382746f.equals(fig.f382746f)) {
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
        this.f382741a = serpens.a(this.f382741a, 0, true);
        this.f382742b = serpens.b(1, false);
        this.f382743c = serpens.a(this.f382743c, 2, false);
        this.f382744d = serpens.b(3, false);
        this.f382745e = (List) serpens.a((Serpens) f382739g, 4, false);
        this.f382746f = (List) serpens.a((Serpens) f382740h, 5, false);
    }
}
