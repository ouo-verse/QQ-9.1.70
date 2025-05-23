package com.tencent.mapsdk.internal;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class h extends p {

    /* renamed from: k, reason: collision with root package name */
    static byte[] f148607k = null;

    /* renamed from: l, reason: collision with root package name */
    static Map<String, String> f148608l = null;

    /* renamed from: m, reason: collision with root package name */
    static final /* synthetic */ boolean f148609m = true;

    /* renamed from: a, reason: collision with root package name */
    public short f148610a;

    /* renamed from: b, reason: collision with root package name */
    public byte f148611b;

    /* renamed from: c, reason: collision with root package name */
    public int f148612c;

    /* renamed from: d, reason: collision with root package name */
    public int f148613d;

    /* renamed from: e, reason: collision with root package name */
    public String f148614e;

    /* renamed from: f, reason: collision with root package name */
    public String f148615f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f148616g;

    /* renamed from: h, reason: collision with root package name */
    public int f148617h;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, String> f148618i;

    /* renamed from: j, reason: collision with root package name */
    public Map<String, String> f148619j;

    public h() {
        this.f148610a = (short) 0;
        this.f148611b = (byte) 0;
        this.f148612c = 0;
        this.f148613d = 0;
        this.f148614e = null;
        this.f148615f = null;
        this.f148617h = 0;
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f148609m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void display(StringBuilder sb5, int i3) {
        k kVar = new k(sb5, i3);
        kVar.a(this.f148610a, "iVersion");
        kVar.a(this.f148611b, "cPacketType");
        kVar.a(this.f148612c, "iMessageType");
        kVar.a(this.f148613d, "iRequestId");
        kVar.a(this.f148614e, "sServantName");
        kVar.a(this.f148615f, "sFuncName");
        kVar.a(this.f148616g, "sBuffer");
        kVar.a(this.f148617h, "iTimeout");
        kVar.a((Map) this.f148618i, "context");
        kVar.a((Map) this.f148619j, "status");
    }

    public final boolean equals(Object obj) {
        h hVar = (h) obj;
        if (q.a(1, (int) hVar.f148610a) && q.a(1, (int) hVar.f148611b) && q.a(1, hVar.f148612c) && q.a(1, hVar.f148613d) && q.a((Object) 1, (Object) hVar.f148614e) && q.a((Object) 1, (Object) hVar.f148615f) && q.a((Object) 1, (Object) hVar.f148616g) && q.a(1, hVar.f148617h) && q.a((Object) 1, (Object) hVar.f148618i) && q.a((Object) 1, (Object) hVar.f148619j)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void readFrom(m mVar) {
        try {
            this.f148610a = mVar.a(this.f148610a, 1, true);
            this.f148611b = mVar.a(this.f148611b, 2, true);
            this.f148612c = mVar.a(this.f148612c, 3, true);
            this.f148613d = mVar.a(this.f148613d, 4, true);
            this.f148614e = mVar.b(5, true);
            this.f148615f = mVar.b(6, true);
            if (f148607k == null) {
                f148607k = new byte[]{0};
            }
            this.f148616g = mVar.c(7, true);
            this.f148617h = mVar.a(this.f148617h, 8, true);
            if (f148608l == null) {
                HashMap hashMap = new HashMap();
                f148608l = hashMap;
                hashMap.put("", "");
            }
            this.f148618i = (Map) mVar.a((m) f148608l, 9, true);
            if (f148608l == null) {
                HashMap hashMap2 = new HashMap();
                f148608l = hashMap2;
                hashMap2.put("", "");
            }
            this.f148619j = (Map) mVar.a((m) f148608l, 10, true);
        } catch (Exception e16) {
            e16.printStackTrace();
            System.out.println("RequestPacket decode error " + i.a(this.f148616g));
            throw new RuntimeException(e16);
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void writeTo(n nVar) {
        nVar.a(this.f148610a, 1);
        nVar.a(this.f148611b, 2);
        nVar.a(this.f148612c, 3);
        nVar.a(this.f148613d, 4);
        nVar.a(this.f148614e, 5);
        nVar.a(this.f148615f, 6);
        nVar.a(this.f148616g, 7);
        nVar.a(this.f148617h, 8);
        nVar.a((Map) this.f148618i, 9);
        nVar.a((Map) this.f148619j, 10);
    }

    h(short s16, byte b16, int i3, int i16, String str, String str2, byte[] bArr, int i17, Map<String, String> map, Map<String, String> map2) {
        this.f148610a = s16;
        this.f148611b = b16;
        this.f148612c = i3;
        this.f148613d = i16;
        this.f148614e = str;
        this.f148615f = str2;
        this.f148616g = bArr;
        this.f148617h = i17;
        this.f148618i = map;
        this.f148619j = map2;
    }
}
