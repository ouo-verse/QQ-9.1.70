package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class ck extends m {

    /* renamed from: i, reason: collision with root package name */
    static byte[] f98451i;

    /* renamed from: j, reason: collision with root package name */
    static Map<String, String> f98452j;

    /* renamed from: a, reason: collision with root package name */
    public byte f98453a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f98454b = 0;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f98455c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f98456d = "";

    /* renamed from: e, reason: collision with root package name */
    public long f98457e = 0;

    /* renamed from: f, reason: collision with root package name */
    public String f98458f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f98459g = "";

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f98460h = null;

    static {
        f98451i = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        f98452j = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f98453a, 0);
        lVar.a(this.f98454b, 1);
        byte[] bArr = this.f98455c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
        String str = this.f98456d;
        if (str != null) {
            lVar.a(str, 3);
        }
        lVar.a(this.f98457e, 4);
        String str2 = this.f98458f;
        if (str2 != null) {
            lVar.a(str2, 5);
        }
        String str3 = this.f98459g;
        if (str3 != null) {
            lVar.a(str3, 6);
        }
        Map<String, String> map = this.f98460h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f98453a = kVar.a(this.f98453a, 0, true);
        this.f98454b = kVar.a(this.f98454b, 1, true);
        this.f98455c = kVar.c(2, false);
        this.f98456d = kVar.b(3, false);
        this.f98457e = kVar.a(this.f98457e, 4, false);
        this.f98458f = kVar.b(5, false);
        this.f98459g = kVar.b(6, false);
        this.f98460h = (Map) kVar.a((k) f98452j, 7, false);
    }
}
