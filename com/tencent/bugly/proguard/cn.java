package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class cn extends m {

    /* renamed from: i, reason: collision with root package name */
    static Map<String, String> f98478i;

    /* renamed from: a, reason: collision with root package name */
    public long f98479a = 0;

    /* renamed from: b, reason: collision with root package name */
    public byte f98480b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f98481c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f98482d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f98483e = "";

    /* renamed from: f, reason: collision with root package name */
    public Map<String, String> f98484f = null;

    /* renamed from: g, reason: collision with root package name */
    public String f98485g = "";

    /* renamed from: h, reason: collision with root package name */
    public boolean f98486h = true;

    static {
        HashMap hashMap = new HashMap();
        f98478i = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f98479a, 0);
        lVar.a(this.f98480b, 1);
        String str = this.f98481c;
        if (str != null) {
            lVar.a(str, 2);
        }
        String str2 = this.f98482d;
        if (str2 != null) {
            lVar.a(str2, 3);
        }
        String str3 = this.f98483e;
        if (str3 != null) {
            lVar.a(str3, 4);
        }
        Map<String, String> map = this.f98484f;
        if (map != null) {
            lVar.a((Map) map, 5);
        }
        String str4 = this.f98485g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        lVar.a(this.f98486h, 7);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f98479a = kVar.a(this.f98479a, 0, true);
        this.f98480b = kVar.a(this.f98480b, 1, true);
        this.f98481c = kVar.b(2, false);
        this.f98482d = kVar.b(3, false);
        this.f98483e = kVar.b(4, false);
        this.f98484f = (Map) kVar.a((k) f98478i, 5, false);
        this.f98485g = kVar.b(6, false);
        this.f98486h = kVar.a(7, false);
    }
}
