package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Hickory extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: t, reason: collision with root package name */
    public static List<Integer> f382821t;

    /* renamed from: u, reason: collision with root package name */
    public static Cumquat f382822u;

    /* renamed from: v, reason: collision with root package name */
    public static List<Integer> f382823v;

    /* renamed from: a, reason: collision with root package name */
    public int f382824a;

    /* renamed from: b, reason: collision with root package name */
    public int f382825b;

    /* renamed from: c, reason: collision with root package name */
    public int f382826c;

    /* renamed from: d, reason: collision with root package name */
    public int f382827d;

    /* renamed from: e, reason: collision with root package name */
    public List<Integer> f382828e;

    /* renamed from: f, reason: collision with root package name */
    public int f382829f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f382830g;

    /* renamed from: h, reason: collision with root package name */
    public int f382831h;

    /* renamed from: i, reason: collision with root package name */
    public int f382832i;

    /* renamed from: j, reason: collision with root package name */
    public String f382833j;

    /* renamed from: k, reason: collision with root package name */
    public String f382834k;

    /* renamed from: l, reason: collision with root package name */
    public int f382835l;

    /* renamed from: m, reason: collision with root package name */
    public String f382836m;

    /* renamed from: n, reason: collision with root package name */
    public String f382837n;

    /* renamed from: o, reason: collision with root package name */
    public String f382838o;

    /* renamed from: p, reason: collision with root package name */
    public int f382839p;

    /* renamed from: q, reason: collision with root package name */
    public Cumquat f382840q;

    /* renamed from: r, reason: collision with root package name */
    public List<Integer> f382841r;

    /* renamed from: s, reason: collision with root package name */
    public int f382842s;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11839);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f382821t = arrayList;
        arrayList.add(0);
        f382822u = new Cumquat();
        ArrayList arrayList2 = new ArrayList();
        f382823v = arrayList2;
        arrayList2.add(0);
    }

    public Hickory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382824a = 0;
        this.f382825b = 0;
        this.f382826c = 0;
        this.f382827d = 0;
        this.f382828e = null;
        this.f382829f = 0;
        this.f382830g = false;
        this.f382831h = 0;
        this.f382832i = 0;
        this.f382833j = "";
        this.f382834k = "";
        this.f382835l = 0;
        this.f382836m = "";
        this.f382837n = "";
        this.f382838o = "";
        this.f382839p = 0;
        this.f382840q = null;
        this.f382841r = null;
        this.f382842s = 0;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382824a, 0);
        solar.a(this.f382825b, 1);
        solar.a(this.f382826c, 2);
        solar.a(this.f382827d, 3);
        List<Integer> list = this.f382828e;
        if (list != null) {
            solar.a((Collection) list, 4);
        }
        solar.a(this.f382829f, 5);
        solar.a(this.f382830g ? (byte) 1 : (byte) 0, 6);
        solar.a(this.f382831h, 7);
        solar.a(this.f382832i, 8);
        String str = this.f382833j;
        if (str != null) {
            solar.a(str, 9);
        }
        String str2 = this.f382834k;
        if (str2 != null) {
            solar.a(str2, 10);
        }
        solar.a(this.f382835l, 11);
        String str3 = this.f382836m;
        if (str3 != null) {
            solar.a(str3, 12);
        }
        String str4 = this.f382837n;
        if (str4 != null) {
            solar.a(str4, 13);
        }
        String str5 = this.f382838o;
        if (str5 != null) {
            solar.a(str5, 14);
        }
        solar.a(this.f382839p, 15);
        Cumquat cumquat = this.f382840q;
        if (cumquat != null) {
            solar.a((Taurus) cumquat, 16);
        }
        List<Integer> list2 = this.f382841r;
        if (list2 != null) {
            solar.a((Collection) list2, 17);
        }
        solar.a(this.f382842s, 18);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Hickory)) {
            return false;
        }
        Hickory hickory = (Hickory) obj;
        if (Triangulum.a(this.f382824a, hickory.f382824a) && Triangulum.a(this.f382825b, hickory.f382825b) && Triangulum.a(this.f382826c, hickory.f382826c) && Triangulum.a(this.f382827d, hickory.f382827d) && this.f382828e.equals(hickory.f382828e) && Triangulum.a(this.f382829f, hickory.f382829f) && Triangulum.a(this.f382830g, hickory.f382830g) && Triangulum.a(this.f382831h, hickory.f382831h) && Triangulum.a(this.f382832i, hickory.f382832i) && this.f382833j.equals(hickory.f382833j) && this.f382834k.equals(hickory.f382834k) && Triangulum.a(this.f382835l, hickory.f382835l) && this.f382836m.equals(hickory.f382836m) && this.f382837n.equals(hickory.f382837n) && this.f382838o.equals(hickory.f382838o) && Triangulum.a(this.f382839p, hickory.f382839p) && this.f382840q.equals(hickory.f382840q) && this.f382841r.equals(hickory.f382841r) && Triangulum.a(this.f382842s, hickory.f382842s)) {
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
        this.f382824a = serpens.a(this.f382824a, 0, true);
        this.f382825b = serpens.a(this.f382825b, 1, false);
        this.f382826c = serpens.a(this.f382826c, 2, false);
        this.f382827d = serpens.a(this.f382827d, 3, false);
        this.f382828e = (List) serpens.a((Serpens) f382821t, 4, false);
        this.f382829f = serpens.a(this.f382829f, 5, false);
        this.f382830g = serpens.a(this.f382830g, 6, false);
        this.f382831h = serpens.a(this.f382831h, 7, false);
        this.f382832i = serpens.a(this.f382832i, 8, false);
        this.f382833j = serpens.b(9, false);
        this.f382834k = serpens.b(10, false);
        this.f382835l = serpens.a(this.f382835l, 11, false);
        this.f382836m = serpens.b(12, false);
        this.f382837n = serpens.b(13, false);
        this.f382838o = serpens.b(14, false);
        this.f382839p = serpens.a(this.f382839p, 15, false);
        this.f382840q = (Cumquat) serpens.a((Taurus) f382822u, 16, false);
        this.f382841r = (List) serpens.a((Serpens) f382823v, 17, false);
        this.f382842s = serpens.a(this.f382842s, 18, false);
    }
}
