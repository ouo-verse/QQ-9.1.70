package com.tencent.turingfd.sdk.xq;

import android.content.pm.FeatureInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Cumquat extends Taurus {
    static IPatchRedirector $redirector_;
    public static List<List<byte[]>> A;
    public static Map<Long, FeatureInfo> B;

    /* renamed from: y, reason: collision with root package name */
    public static List<Integer> f382661y;

    /* renamed from: z, reason: collision with root package name */
    public static List<byte[]> f382662z;

    /* renamed from: a, reason: collision with root package name */
    public int f382663a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f382664b;

    /* renamed from: c, reason: collision with root package name */
    public String f382665c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f382666d;

    /* renamed from: e, reason: collision with root package name */
    public long f382667e;

    /* renamed from: f, reason: collision with root package name */
    public String f382668f;

    /* renamed from: g, reason: collision with root package name */
    public int f382669g;

    /* renamed from: h, reason: collision with root package name */
    public String f382670h;

    /* renamed from: i, reason: collision with root package name */
    public int f382671i;

    /* renamed from: j, reason: collision with root package name */
    public String f382672j;

    /* renamed from: k, reason: collision with root package name */
    public int f382673k;

    /* renamed from: l, reason: collision with root package name */
    public int f382674l;

    /* renamed from: m, reason: collision with root package name */
    public int f382675m;

    /* renamed from: n, reason: collision with root package name */
    public List<Integer> f382676n;

    /* renamed from: o, reason: collision with root package name */
    public int f382677o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f382678p;

    /* renamed from: q, reason: collision with root package name */
    public int f382679q;

    /* renamed from: r, reason: collision with root package name */
    public int f382680r;

    /* renamed from: s, reason: collision with root package name */
    public List<byte[]> f382681s;

    /* renamed from: t, reason: collision with root package name */
    public int f382682t;

    /* renamed from: u, reason: collision with root package name */
    public List<List<byte[]>> f382683u;

    /* renamed from: v, reason: collision with root package name */
    public byte[] f382684v;

    /* renamed from: w, reason: collision with root package name */
    public Map<Long, FeatureInfo> f382685w;

    /* renamed from: x, reason: collision with root package name */
    public String f382686x;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11378);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f382661y = arrayList;
        arrayList.add(0);
        ArrayList arrayList2 = new ArrayList();
        f382662z = arrayList2;
        arrayList2.add(new byte[]{0});
        A = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new byte[]{0});
        ((ArrayList) A).add(arrayList3);
        B = new HashMap();
        ((HashMap) B).put(0L, new FeatureInfo());
    }

    public Cumquat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382663a = 0;
        this.f382664b = null;
        this.f382665c = "";
        this.f382666d = null;
        this.f382667e = 0L;
        this.f382668f = "";
        this.f382669g = 0;
        this.f382670h = "";
        this.f382671i = 0;
        this.f382672j = "";
        this.f382673k = 0;
        this.f382674l = 0;
        this.f382675m = 0;
        this.f382676n = null;
        this.f382677o = 0;
        this.f382678p = false;
        this.f382679q = 0;
        this.f382680r = 0;
        this.f382681s = null;
        this.f382682t = -1;
        this.f382683u = null;
        this.f382684v = null;
        this.f382685w = null;
        this.f382686x = "";
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382663a, 0);
        byte[] bArr = this.f382664b;
        if (bArr != null) {
            solar.a(bArr, 1);
        }
        String str = this.f382665c;
        if (str != null) {
            solar.a(str, 2);
        }
        byte[] bArr2 = this.f382666d;
        if (bArr2 != null) {
            solar.a(bArr2, 3);
        }
        solar.a(this.f382667e, 4);
        String str2 = this.f382668f;
        if (str2 != null) {
            solar.a(str2, 5);
        }
        solar.a(this.f382669g, 6);
        String str3 = this.f382670h;
        if (str3 != null) {
            solar.a(str3, 7);
        }
        solar.a(this.f382671i, 8);
        String str4 = this.f382672j;
        if (str4 != null) {
            solar.a(str4, 9);
        }
        solar.a(this.f382673k, 10);
        solar.a(this.f382674l, 11);
        solar.a(this.f382675m, 12);
        List<Integer> list = this.f382676n;
        if (list != null) {
            solar.a((Collection) list, 13);
        }
        solar.a(this.f382677o, 14);
        solar.a(this.f382678p ? (byte) 1 : (byte) 0, 15);
        solar.a(this.f382679q, 16);
        solar.a(this.f382680r, 17);
        List<byte[]> list2 = this.f382681s;
        if (list2 != null) {
            solar.a((Collection) list2, 18);
        }
        solar.a(this.f382682t, 20);
        List<List<byte[]>> list3 = this.f382683u;
        if (list3 != null) {
            solar.a((Collection) list3, 21);
        }
        byte[] bArr3 = this.f382684v;
        if (bArr3 != null) {
            solar.a(bArr3, 22);
        }
        Map<Long, FeatureInfo> map = this.f382685w;
        if (map != null) {
            solar.a((Map) map, 23);
        }
        String str5 = this.f382686x;
        if (str5 != null) {
            solar.a(str5, 24);
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
        if (obj == null || !(obj instanceof Cumquat)) {
            return false;
        }
        Cumquat cumquat = (Cumquat) obj;
        if (Triangulum.a(this.f382663a, cumquat.f382663a) && this.f382664b.equals(cumquat.f382664b) && this.f382665c.equals(cumquat.f382665c) && this.f382666d.equals(cumquat.f382666d) && Triangulum.a(this.f382667e, cumquat.f382667e) && this.f382668f.equals(cumquat.f382668f) && Triangulum.a(this.f382669g, cumquat.f382669g) && this.f382670h.equals(cumquat.f382670h) && Triangulum.a(this.f382671i, cumquat.f382671i) && this.f382672j.equals(cumquat.f382672j) && Triangulum.a(this.f382673k, cumquat.f382673k) && Triangulum.a(this.f382674l, cumquat.f382674l) && Triangulum.a(this.f382675m, cumquat.f382675m) && this.f382676n.equals(cumquat.f382676n) && Triangulum.a(this.f382677o, cumquat.f382677o) && Triangulum.a(this.f382678p, cumquat.f382678p) && Triangulum.a(this.f382679q, cumquat.f382679q) && Triangulum.a(this.f382680r, cumquat.f382680r) && this.f382681s.equals(cumquat.f382681s) && Triangulum.a(this.f382682t, cumquat.f382682t) && this.f382683u.equals(cumquat.f382683u) && this.f382684v.equals(cumquat.f382684v) && this.f382685w.equals(cumquat.f382685w) && this.f382686x.equals(cumquat.f382686x)) {
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
        this.f382663a = serpens.a(this.f382663a, 0, true);
        this.f382664b = serpens.a(1, false);
        this.f382665c = serpens.b(2, false);
        this.f382666d = serpens.a(3, false);
        this.f382667e = serpens.a(this.f382667e, 4, false);
        this.f382668f = serpens.b(5, false);
        this.f382669g = serpens.a(this.f382669g, 6, false);
        this.f382670h = serpens.b(7, false);
        this.f382671i = serpens.a(this.f382671i, 8, false);
        this.f382672j = serpens.b(9, false);
        this.f382673k = serpens.a(this.f382673k, 10, false);
        this.f382674l = serpens.a(this.f382674l, 11, false);
        this.f382675m = serpens.a(this.f382675m, 12, false);
        this.f382676n = (List) serpens.a((Serpens) f382661y, 13, false);
        this.f382677o = serpens.a(this.f382677o, 14, false);
        this.f382678p = serpens.a(this.f382678p, 15, false);
        this.f382679q = serpens.a(this.f382679q, 16, false);
        this.f382680r = serpens.a(this.f382680r, 17, false);
        this.f382681s = (List) serpens.a((Serpens) f382662z, 18, false);
        this.f382682t = serpens.a(this.f382682t, 20, false);
        this.f382683u = (List) serpens.a((Serpens) A, 21, false);
        this.f382684v = serpens.a(22, false);
        this.f382685w = (Map) serpens.a((Serpens) B, 23, false);
        this.f382686x = serpens.b(24, false);
    }
}
