package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Blackberry extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static List<String> f382603g;

    /* renamed from: h, reason: collision with root package name */
    public static List<String> f382604h;

    /* renamed from: a, reason: collision with root package name */
    public int f382605a;

    /* renamed from: b, reason: collision with root package name */
    public int f382606b;

    /* renamed from: c, reason: collision with root package name */
    public int f382607c;

    /* renamed from: d, reason: collision with root package name */
    public List<String> f382608d;

    /* renamed from: e, reason: collision with root package name */
    public List<String> f382609e;

    /* renamed from: f, reason: collision with root package name */
    public String f382610f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10746);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f382603g = arrayList;
        arrayList.add("");
        ArrayList arrayList2 = new ArrayList();
        f382604h = arrayList2;
        arrayList2.add("");
    }

    public Blackberry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382605a = 0;
        this.f382606b = 0;
        this.f382607c = 0;
        this.f382608d = null;
        this.f382609e = null;
        this.f382610f = "";
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382605a, 0);
        solar.a(this.f382606b, 1);
        solar.a(this.f382607c, 2);
        List<String> list = this.f382608d;
        if (list != null) {
            solar.a((Collection) list, 3);
        }
        List<String> list2 = this.f382609e;
        if (list2 != null) {
            solar.a((Collection) list2, 4);
        }
        String str = this.f382610f;
        if (str != null) {
            solar.a(str, 5);
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
        if (obj == null || !(obj instanceof Blackberry)) {
            return false;
        }
        Blackberry blackberry = (Blackberry) obj;
        if (Triangulum.a(this.f382605a, blackberry.f382605a) && Triangulum.a(this.f382606b, blackberry.f382606b) && Triangulum.a(this.f382607c, blackberry.f382607c) && this.f382608d.equals(blackberry.f382608d) && this.f382609e.equals(blackberry.f382609e) && this.f382610f.equals(blackberry.f382610f)) {
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
        this.f382605a = serpens.a(this.f382605a, 0, false);
        this.f382606b = serpens.a(this.f382606b, 1, false);
        this.f382607c = serpens.a(this.f382607c, 2, false);
        this.f382608d = (List) serpens.a((Serpens) f382603g, 3, false);
        this.f382609e = (List) serpens.a((Serpens) f382604h, 4, false);
        this.f382610f = serpens.b(5, false);
    }
}
