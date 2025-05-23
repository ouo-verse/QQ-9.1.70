package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class cm extends m implements Cloneable {

    /* renamed from: m, reason: collision with root package name */
    static cl f98463m = new cl();

    /* renamed from: n, reason: collision with root package name */
    static Map<String, String> f98464n = null;

    /* renamed from: o, reason: collision with root package name */
    static final /* synthetic */ boolean f98465o = true;

    /* renamed from: a, reason: collision with root package name */
    public boolean f98466a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f98467b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f98468c = true;

    /* renamed from: d, reason: collision with root package name */
    public String f98469d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f98470e = "";

    /* renamed from: f, reason: collision with root package name */
    public cl f98471f = null;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, String> f98472g = null;

    /* renamed from: h, reason: collision with root package name */
    public long f98473h = 0;

    /* renamed from: i, reason: collision with root package name */
    public String f98474i = "";

    /* renamed from: j, reason: collision with root package name */
    public String f98475j = "";

    /* renamed from: k, reason: collision with root package name */
    public int f98476k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f98477l = 0;

    static {
        HashMap hashMap = new HashMap();
        f98464n = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f98466a, 0);
        lVar.a(this.f98467b, 1);
        lVar.a(this.f98468c, 2);
        String str = this.f98469d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f98470e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        cl clVar = this.f98471f;
        if (clVar != null) {
            lVar.a((m) clVar, 5);
        }
        Map<String, String> map = this.f98472g;
        if (map != null) {
            lVar.a((Map) map, 6);
        }
        lVar.a(this.f98473h, 7);
        String str3 = this.f98474i;
        if (str3 != null) {
            lVar.a(str3, 8);
        }
        String str4 = this.f98475j;
        if (str4 != null) {
            lVar.a(str4, 9);
        }
        lVar.a(this.f98476k, 10);
        lVar.a(this.f98477l, 11);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f98465o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        cm cmVar = (cm) obj;
        if (!n.a(this.f98466a, cmVar.f98466a) || !n.a(this.f98467b, cmVar.f98467b) || !n.a(this.f98468c, cmVar.f98468c) || !n.a(this.f98469d, cmVar.f98469d) || !n.a(this.f98470e, cmVar.f98470e) || !n.a(this.f98471f, cmVar.f98471f) || !n.a(this.f98472g, cmVar.f98472g) || !n.a(this.f98473h, cmVar.f98473h) || !n.a(this.f98474i, cmVar.f98474i) || !n.a(this.f98475j, cmVar.f98475j) || !n.a(this.f98476k, cmVar.f98476k) || !n.a(this.f98477l, cmVar.f98477l)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f98466a = kVar.a(0, true);
        this.f98467b = kVar.a(1, true);
        this.f98468c = kVar.a(2, true);
        this.f98469d = kVar.b(3, false);
        this.f98470e = kVar.b(4, false);
        this.f98471f = (cl) kVar.a((m) f98463m, 5, false);
        this.f98472g = (Map) kVar.a((k) f98464n, 6, false);
        this.f98473h = kVar.a(this.f98473h, 7, false);
        this.f98474i = kVar.b(8, false);
        this.f98475j = kVar.b(9, false);
        this.f98476k = kVar.a(this.f98476k, 10, false);
        this.f98477l = kVar.a(this.f98477l, 11, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb5, int i3) {
        i iVar = new i(sb5, i3);
        iVar.a(this.f98466a, "enable");
        iVar.a(this.f98467b, "enableUserInfo");
        iVar.a(this.f98468c, "enableQuery");
        iVar.a(this.f98469d, "url");
        iVar.a(this.f98470e, "expUrl");
        iVar.a((m) this.f98471f, "security");
        iVar.a((Map) this.f98472g, "valueMap");
        iVar.a(this.f98473h, "strategylastUpdateTime");
        iVar.a(this.f98474i, "httpsUrl");
        iVar.a(this.f98475j, "httpsExpUrl");
        iVar.a(this.f98476k, "eventRecordCount");
        iVar.a(this.f98477l, "eventTimeInterval");
    }
}
