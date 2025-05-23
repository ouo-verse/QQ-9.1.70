package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class ch extends m {
    static ArrayList<cg> A;
    static Map<String, String> B;
    static Map<String, String> C;

    /* renamed from: v, reason: collision with root package name */
    static Map<String, String> f98397v;

    /* renamed from: w, reason: collision with root package name */
    static cf f98398w;

    /* renamed from: x, reason: collision with root package name */
    static ce f98399x;

    /* renamed from: y, reason: collision with root package name */
    static ArrayList<ce> f98400y;

    /* renamed from: z, reason: collision with root package name */
    static ArrayList<ce> f98401z;

    /* renamed from: a, reason: collision with root package name */
    public String f98402a = "";

    /* renamed from: b, reason: collision with root package name */
    public long f98403b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f98404c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f98405d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f98406e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f98407f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f98408g = "";

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f98409h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f98410i = "";

    /* renamed from: j, reason: collision with root package name */
    public cf f98411j = null;

    /* renamed from: k, reason: collision with root package name */
    public int f98412k = 0;

    /* renamed from: l, reason: collision with root package name */
    public String f98413l = "";

    /* renamed from: m, reason: collision with root package name */
    public String f98414m = "";

    /* renamed from: n, reason: collision with root package name */
    public ce f98415n = null;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<ce> f98416o = null;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<ce> f98417p = null;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<cg> f98418q = null;

    /* renamed from: r, reason: collision with root package name */
    public Map<String, String> f98419r = null;

    /* renamed from: s, reason: collision with root package name */
    public Map<String, String> f98420s = null;

    /* renamed from: t, reason: collision with root package name */
    public String f98421t = "";

    /* renamed from: u, reason: collision with root package name */
    public boolean f98422u = true;

    static {
        HashMap hashMap = new HashMap();
        f98397v = hashMap;
        hashMap.put("", "");
        f98398w = new cf();
        f98399x = new ce();
        f98400y = new ArrayList<>();
        f98400y.add(new ce());
        f98401z = new ArrayList<>();
        f98401z.add(new ce());
        A = new ArrayList<>();
        A.add(new cg());
        HashMap hashMap2 = new HashMap();
        B = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        C = hashMap3;
        hashMap3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f98402a, 0);
        lVar.a(this.f98403b, 1);
        lVar.a(this.f98404c, 2);
        String str = this.f98405d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f98406e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        String str3 = this.f98407f;
        if (str3 != null) {
            lVar.a(str3, 5);
        }
        String str4 = this.f98408g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        Map<String, String> map = this.f98409h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
        String str5 = this.f98410i;
        if (str5 != null) {
            lVar.a(str5, 8);
        }
        cf cfVar = this.f98411j;
        if (cfVar != null) {
            lVar.a((m) cfVar, 9);
        }
        lVar.a(this.f98412k, 10);
        String str6 = this.f98413l;
        if (str6 != null) {
            lVar.a(str6, 11);
        }
        String str7 = this.f98414m;
        if (str7 != null) {
            lVar.a(str7, 12);
        }
        ce ceVar = this.f98415n;
        if (ceVar != null) {
            lVar.a((m) ceVar, 13);
        }
        ArrayList<ce> arrayList = this.f98416o;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 14);
        }
        ArrayList<ce> arrayList2 = this.f98417p;
        if (arrayList2 != null) {
            lVar.a((Collection) arrayList2, 15);
        }
        ArrayList<cg> arrayList3 = this.f98418q;
        if (arrayList3 != null) {
            lVar.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.f98419r;
        if (map2 != null) {
            lVar.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.f98420s;
        if (map3 != null) {
            lVar.a((Map) map3, 18);
        }
        String str8 = this.f98421t;
        if (str8 != null) {
            lVar.a(str8, 19);
        }
        lVar.a(this.f98422u, 20);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f98402a = kVar.b(0, true);
        this.f98403b = kVar.a(this.f98403b, 1, true);
        this.f98404c = kVar.b(2, true);
        this.f98405d = kVar.b(3, false);
        this.f98406e = kVar.b(4, false);
        this.f98407f = kVar.b(5, false);
        this.f98408g = kVar.b(6, false);
        this.f98409h = (Map) kVar.a((k) f98397v, 7, false);
        this.f98410i = kVar.b(8, false);
        this.f98411j = (cf) kVar.a((m) f98398w, 9, false);
        this.f98412k = kVar.a(this.f98412k, 10, false);
        this.f98413l = kVar.b(11, false);
        this.f98414m = kVar.b(12, false);
        this.f98415n = (ce) kVar.a((m) f98399x, 13, false);
        this.f98416o = (ArrayList) kVar.a((k) f98400y, 14, false);
        this.f98417p = (ArrayList) kVar.a((k) f98401z, 15, false);
        this.f98418q = (ArrayList) kVar.a((k) A, 16, false);
        this.f98419r = (Map) kVar.a((k) B, 17, false);
        this.f98420s = (Map) kVar.a((k) C, 18, false);
        this.f98421t = kVar.b(19, false);
        this.f98422u = kVar.a(20, false);
    }
}
