package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class g extends m {

    /* renamed from: k, reason: collision with root package name */
    static byte[] f98503k = null;

    /* renamed from: l, reason: collision with root package name */
    static Map<String, String> f98504l = null;

    /* renamed from: m, reason: collision with root package name */
    static final /* synthetic */ boolean f98505m = true;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f98512g;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, String> f98514i;

    /* renamed from: j, reason: collision with root package name */
    public Map<String, String> f98515j;

    /* renamed from: a, reason: collision with root package name */
    public short f98506a = 0;

    /* renamed from: b, reason: collision with root package name */
    public byte f98507b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f98508c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f98509d = 0;

    /* renamed from: e, reason: collision with root package name */
    public String f98510e = null;

    /* renamed from: f, reason: collision with root package name */
    public String f98511f = null;

    /* renamed from: h, reason: collision with root package name */
    public int f98513h = 0;

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f98506a, 1);
        lVar.a(this.f98507b, 2);
        lVar.a(this.f98508c, 3);
        lVar.a(this.f98509d, 4);
        lVar.a(this.f98510e, 5);
        lVar.a(this.f98511f, 6);
        lVar.a(this.f98512g, 7);
        lVar.a(this.f98513h, 8);
        lVar.a((Map) this.f98514i, 9);
        lVar.a((Map) this.f98515j, 10);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f98505m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        g gVar = (g) obj;
        if (n.a(1, (int) gVar.f98506a) && n.a(1, (int) gVar.f98507b) && n.a(1, gVar.f98508c) && n.a(1, gVar.f98509d) && n.a((Object) 1, (Object) gVar.f98510e) && n.a((Object) 1, (Object) gVar.f98511f) && n.a((Object) 1, (Object) gVar.f98512g) && n.a(1, gVar.f98513h) && n.a((Object) 1, (Object) gVar.f98514i) && n.a((Object) 1, (Object) gVar.f98515j)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        try {
            this.f98506a = kVar.a(this.f98506a, 1, true);
            this.f98507b = kVar.a(this.f98507b, 2, true);
            this.f98508c = kVar.a(this.f98508c, 3, true);
            this.f98509d = kVar.a(this.f98509d, 4, true);
            this.f98510e = kVar.b(5, true);
            this.f98511f = kVar.b(6, true);
            if (f98503k == null) {
                f98503k = new byte[]{0};
            }
            this.f98512g = kVar.c(7, true);
            this.f98513h = kVar.a(this.f98513h, 8, true);
            if (f98504l == null) {
                HashMap hashMap = new HashMap();
                f98504l = hashMap;
                hashMap.put("", "");
            }
            this.f98514i = (Map) kVar.a((k) f98504l, 9, true);
            if (f98504l == null) {
                HashMap hashMap2 = new HashMap();
                f98504l = hashMap2;
                hashMap2.put("", "");
            }
            this.f98515j = (Map) kVar.a((k) f98504l, 10, true);
        } catch (Exception e16) {
            e16.printStackTrace();
            System.out.println("RequestPacket decode error " + f.a(this.f98512g));
            throw new RuntimeException(e16);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb5, int i3) {
        i iVar = new i(sb5, i3);
        iVar.a(this.f98506a, "iVersion");
        iVar.a(this.f98507b, "cPacketType");
        iVar.a(this.f98508c, "iMessageType");
        iVar.a(this.f98509d, "iRequestId");
        iVar.a(this.f98510e, "sServantName");
        iVar.a(this.f98511f, "sFuncName");
        iVar.a(this.f98512g, "sBuffer");
        iVar.a(this.f98513h, "iTimeout");
        iVar.a((Map) this.f98514i, "context");
        iVar.a((Map) this.f98515j, "status");
    }
}
