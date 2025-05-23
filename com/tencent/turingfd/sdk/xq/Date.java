package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Date extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static Cumquat f382703k;

    /* renamed from: l, reason: collision with root package name */
    public static String f382704l;

    /* renamed from: m, reason: collision with root package name */
    public static List<String> f382705m;

    /* renamed from: n, reason: collision with root package name */
    public static List<String> f382706n;

    /* renamed from: o, reason: collision with root package name */
    public static List<String> f382707o;

    /* renamed from: a, reason: collision with root package name */
    public Cumquat f382708a;

    /* renamed from: b, reason: collision with root package name */
    public String f382709b;

    /* renamed from: c, reason: collision with root package name */
    public String f382710c;

    /* renamed from: d, reason: collision with root package name */
    public String f382711d;

    /* renamed from: e, reason: collision with root package name */
    public int f382712e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f382713f;

    /* renamed from: g, reason: collision with root package name */
    public List<String> f382714g;

    /* renamed from: h, reason: collision with root package name */
    public String f382715h;

    /* renamed from: i, reason: collision with root package name */
    public List<String> f382716i;

    /* renamed from: j, reason: collision with root package name */
    public List<String> f382717j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11434);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f382703k = new Cumquat();
        f382704l = new String();
        f382705m = new ArrayList();
        ((ArrayList) f382705m).add(new String());
        ArrayList arrayList = new ArrayList();
        f382706n = arrayList;
        arrayList.add("");
        ArrayList arrayList2 = new ArrayList();
        f382707o = arrayList2;
        arrayList2.add("");
    }

    public Date() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382708a = null;
        this.f382709b = null;
        this.f382710c = "";
        this.f382711d = "";
        this.f382712e = 0;
        this.f382713f = null;
        this.f382714g = null;
        this.f382715h = "";
        this.f382716i = null;
        this.f382717j = null;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a((Taurus) this.f382708a, 0);
        String str = this.f382709b;
        if (str != null) {
            solar.a(str, 1);
        }
        String str2 = this.f382710c;
        if (str2 != null) {
            solar.a(str2, 2);
        }
        String str3 = this.f382711d;
        if (str3 != null) {
            solar.a(str3, 3);
        }
        solar.a(this.f382712e, 4);
        byte[] bArr = this.f382713f;
        if (bArr != null) {
            solar.a(bArr, 5);
        }
        List<String> list = this.f382714g;
        if (list != null) {
            solar.a((Collection) list, 6);
        }
        String str4 = this.f382715h;
        if (str4 != null) {
            solar.a(str4, 7);
        }
        List<String> list2 = this.f382716i;
        if (list2 != null) {
            solar.a((Collection) list2, 8);
        }
        List<String> list3 = this.f382717j;
        if (list3 != null) {
            solar.a((Collection) list3, 9);
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
        if (obj == null || !(obj instanceof Date)) {
            return false;
        }
        Date date = (Date) obj;
        Cumquat cumquat = this.f382708a;
        Cumquat cumquat2 = date.f382708a;
        int i3 = Triangulum.f383138a;
        if (cumquat.equals(cumquat2) && this.f382709b.equals(date.f382709b) && this.f382710c.equals(date.f382710c) && this.f382711d.equals(date.f382711d) && Triangulum.a(this.f382712e, date.f382712e) && this.f382713f.equals(date.f382713f) && this.f382714g.equals(date.f382714g) && this.f382715h.equals(date.f382715h) && this.f382716i.equals(date.f382716i) && this.f382717j.equals(date.f382717j)) {
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
        this.f382708a = (Cumquat) serpens.a((Taurus) f382703k, 0, true);
        this.f382709b = serpens.a(f382704l, 1, false);
        this.f382710c = serpens.b(2, false);
        this.f382711d = serpens.b(3, false);
        this.f382712e = serpens.a(this.f382712e, 4, false);
        this.f382713f = serpens.a(5, false);
        this.f382714g = (List) serpens.a((Serpens) f382705m, 6, false);
        this.f382715h = serpens.b(7, false);
        this.f382716i = (List) serpens.a((Serpens) f382706n, 8, false);
        this.f382717j = (List) serpens.a((Serpens) f382707o, 9, false);
    }
}
