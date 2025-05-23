package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.finally, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cfinally extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static Map<Integer, String> f383350d;

    /* renamed from: e, reason: collision with root package name */
    public static List<String> f383351e;

    /* renamed from: a, reason: collision with root package name */
    public int f383352a;

    /* renamed from: b, reason: collision with root package name */
    public Map<Integer, String> f383353b;

    /* renamed from: c, reason: collision with root package name */
    public List<String> f383354c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13615);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap hashMap = new HashMap();
        f383350d = hashMap;
        hashMap.put(0, "");
        ArrayList arrayList = new ArrayList();
        f383351e = arrayList;
        arrayList.add("");
    }

    public Cfinally() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383352a = 0;
        this.f383353b = null;
        this.f383354c = null;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f383352a, 0);
        Map<Integer, String> map = this.f383353b;
        if (map != null) {
            solar.a((Map) map, 1);
        }
        List<String> list = this.f383354c;
        if (list != null) {
            solar.a((Collection) list, 2);
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
        if (obj == null || !(obj instanceof Cfinally)) {
            return false;
        }
        Cfinally cfinally = (Cfinally) obj;
        if (Triangulum.a(this.f383352a, cfinally.f383352a) && this.f383353b.equals(cfinally.f383353b) && this.f383354c.equals(cfinally.f383354c)) {
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
        this.f383352a = serpens.a(this.f383352a, 0, true);
        this.f383353b = (Map) serpens.a((Serpens) f383350d, 1, false);
        this.f383354c = (List) serpens.a((Serpens) f383351e, 2, false);
    }
}
