package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Mangosteen extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static List<Kiwifruit> f382900k;

    /* renamed from: l, reason: collision with root package name */
    public static Map<Integer, m> f382901l;

    /* renamed from: m, reason: collision with root package name */
    public static Map<Integer, Cdo> f382902m;

    /* renamed from: n, reason: collision with root package name */
    public static Map<Integer, Cinstanceof> f382903n;

    /* renamed from: o, reason: collision with root package name */
    public static Cfinally f382904o;

    /* renamed from: p, reason: collision with root package name */
    public static Map<Integer, Blackberry> f382905p;

    /* renamed from: q, reason: collision with root package name */
    public static Sorosis f382906q;

    /* renamed from: a, reason: collision with root package name */
    public int f382907a;

    /* renamed from: b, reason: collision with root package name */
    public List<Kiwifruit> f382908b;

    /* renamed from: c, reason: collision with root package name */
    public Map<Integer, m> f382909c;

    /* renamed from: d, reason: collision with root package name */
    public Map<Integer, Cdo> f382910d;

    /* renamed from: e, reason: collision with root package name */
    public int f382911e;

    /* renamed from: f, reason: collision with root package name */
    public Map<Integer, Cinstanceof> f382912f;

    /* renamed from: g, reason: collision with root package name */
    public int f382913g;

    /* renamed from: h, reason: collision with root package name */
    public Cfinally f382914h;

    /* renamed from: i, reason: collision with root package name */
    public Map<Integer, Blackberry> f382915i;

    /* renamed from: j, reason: collision with root package name */
    public Sorosis f382916j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12084);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f382900k = new ArrayList();
        ((ArrayList) f382900k).add(new Kiwifruit());
        HashMap hashMap = new HashMap();
        f382901l = hashMap;
        hashMap.put(0, new m());
        f382902m = new HashMap();
        ((HashMap) f382902m).put(0, new Cdo());
        f382903n = new HashMap();
        ((HashMap) f382903n).put(0, new Cinstanceof());
        f382904o = new Cfinally();
        f382905p = new HashMap();
        ((HashMap) f382905p).put(0, new Blackberry());
        f382906q = new Sorosis();
    }

    public Mangosteen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382907a = 0;
        this.f382908b = null;
        this.f382909c = null;
        this.f382910d = null;
        this.f382911e = 0;
        this.f382912f = null;
        this.f382913g = 0;
        this.f382914h = null;
        this.f382915i = null;
        this.f382916j = null;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382907a, 0);
        List<Kiwifruit> list = this.f382908b;
        if (list != null) {
            solar.a((Collection) list, 1);
        }
        Map<Integer, m> map = this.f382909c;
        if (map != null) {
            solar.a((Map) map, 2);
        }
        Map<Integer, Cdo> map2 = this.f382910d;
        if (map2 != null) {
            solar.a((Map) map2, 3);
        }
        solar.a(this.f382911e, 4);
        Map<Integer, Cinstanceof> map3 = this.f382912f;
        if (map3 != null) {
            solar.a((Map) map3, 5);
        }
        solar.a(this.f382913g, 6);
        Cfinally cfinally = this.f382914h;
        if (cfinally != null) {
            solar.a((Taurus) cfinally, 7);
        }
        Map<Integer, Blackberry> map4 = this.f382915i;
        if (map4 != null) {
            solar.a((Map) map4, 8);
        }
        Sorosis sorosis = this.f382916j;
        if (sorosis != null) {
            solar.a((Taurus) sorosis, 9);
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
        if (obj == null || !(obj instanceof Mangosteen)) {
            return false;
        }
        Mangosteen mangosteen = (Mangosteen) obj;
        if (Triangulum.a(this.f382907a, mangosteen.f382907a) && this.f382908b.equals(mangosteen.f382908b) && this.f382909c.equals(mangosteen.f382909c) && this.f382910d.equals(mangosteen.f382910d) && Triangulum.a(this.f382911e, mangosteen.f382911e) && this.f382912f.equals(mangosteen.f382912f) && Triangulum.a(this.f382913g, mangosteen.f382913g) && this.f382914h.equals(mangosteen.f382914h) && this.f382915i.equals(mangosteen.f382915i) && this.f382916j.equals(mangosteen.f382916j)) {
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
        this.f382907a = serpens.a(this.f382907a, 0, true);
        this.f382908b = (List) serpens.a((Serpens) f382900k, 1, false);
        this.f382909c = (Map) serpens.a((Serpens) f382901l, 2, false);
        this.f382910d = (Map) serpens.a((Serpens) f382902m, 3, false);
        this.f382911e = serpens.a(this.f382911e, 4, false);
        this.f382912f = (Map) serpens.a((Serpens) f382903n, 5, false);
        this.f382913g = serpens.a(this.f382913g, 6, false);
        this.f382914h = (Cfinally) serpens.a((Taurus) f382904o, 7, false);
        this.f382915i = (Map) serpens.a((Serpens) f382905p, 8, false);
        this.f382916j = (Sorosis) serpens.a((Taurus) f382906q, 9, false);
    }
}
