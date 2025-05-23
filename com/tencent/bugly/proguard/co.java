package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class co extends m implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    static ArrayList<cn> f98487f;

    /* renamed from: g, reason: collision with root package name */
    static Map<String, String> f98488g;

    /* renamed from: a, reason: collision with root package name */
    public byte f98489a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f98490b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f98491c = "";

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<cn> f98492d = null;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f98493e = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb5, int i3) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f98489a, 0);
        String str = this.f98490b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.f98491c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        ArrayList<cn> arrayList = this.f98492d;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f98493e;
        if (map != null) {
            lVar.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f98489a = kVar.a(this.f98489a, 0, true);
        this.f98490b = kVar.b(1, false);
        this.f98491c = kVar.b(2, false);
        if (f98487f == null) {
            f98487f = new ArrayList<>();
            f98487f.add(new cn());
        }
        this.f98492d = (ArrayList) kVar.a((k) f98487f, 3, false);
        if (f98488g == null) {
            HashMap hashMap = new HashMap();
            f98488g = hashMap;
            hashMap.put("", "");
        }
        this.f98493e = (Map) kVar.a((k) f98488g, 4, false);
    }
}
