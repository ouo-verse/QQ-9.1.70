package com.tencent.luggage.wxa.d0;

import com.tencent.luggage.wxa.m.u;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m extends u {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f124039j = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final long f124040b;

    /* renamed from: c, reason: collision with root package name */
    public final long f124041c;

    /* renamed from: d, reason: collision with root package name */
    public final long f124042d;

    /* renamed from: e, reason: collision with root package name */
    public final long f124043e;

    /* renamed from: f, reason: collision with root package name */
    public final long f124044f;

    /* renamed from: g, reason: collision with root package name */
    public final long f124045g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f124046h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f124047i;

    public m(long j3, boolean z16) {
        this(j3, j3, 0L, 0L, z16, false);
    }

    @Override // com.tencent.luggage.wxa.m.u
    public int a() {
        return 1;
    }

    @Override // com.tencent.luggage.wxa.m.u
    public int b() {
        return 1;
    }

    public m(long j3, long j16, long j17, long j18, boolean z16, boolean z17) {
        this(-9223372036854775807L, -9223372036854775807L, j3, j16, j17, j18, z16, z17);
    }

    @Override // com.tencent.luggage.wxa.m.u
    public u.c a(int i3, u.c cVar, boolean z16, long j3) {
        com.tencent.luggage.wxa.n0.a.a(i3, 0, 1);
        Object obj = z16 ? f124039j : null;
        long j16 = this.f124045g;
        boolean z17 = this.f124047i;
        if (z17) {
            j16 += j3;
            if (j16 > this.f124043e) {
                j16 = -9223372036854775807L;
            }
        }
        return cVar.a(obj, this.f124040b, this.f124041c, this.f124046h, z17, j16, this.f124043e, 0, 0, this.f124044f);
    }

    public m(long j3, long j16, long j17, long j18, long j19, long j26, boolean z16, boolean z17) {
        this.f124040b = j3;
        this.f124041c = j16;
        this.f124042d = j17;
        this.f124043e = j18;
        this.f124044f = j19;
        this.f124045g = j26;
        this.f124046h = z16;
        this.f124047i = z17;
    }

    @Override // com.tencent.luggage.wxa.m.u
    public u.b a(int i3, u.b bVar, boolean z16) {
        com.tencent.luggage.wxa.n0.a.a(i3, 0, 1);
        Object obj = z16 ? f124039j : null;
        return bVar.a(obj, obj, 0, this.f124042d, -this.f124044f);
    }

    @Override // com.tencent.luggage.wxa.m.u
    public int a(Object obj) {
        return f124039j.equals(obj) ? 0 : -1;
    }
}
