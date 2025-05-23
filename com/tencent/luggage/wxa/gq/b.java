package com.tencent.luggage.wxa.gq;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends com.tencent.luggage.wxa.hq.a {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ boolean f126806d = true;

    /* renamed from: b, reason: collision with root package name */
    public final int f126807b;

    /* renamed from: c, reason: collision with root package name */
    public final int f126808c;

    public b(int i3, int i16) {
        if (!f126806d && i3 < i16) {
            throw new AssertionError();
        }
        this.f126807b = i3;
        this.f126808c = i16;
    }

    @Override // com.tencent.luggage.wxa.hq.b
    public synchronized boolean c(g gVar) {
        boolean z16;
        int b16 = gVar.b();
        int a16 = gVar.a("LIMIT", this.f126807b);
        if (a16 > b16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && a16 >= this.f126807b) {
            gVar.d("LIMIT", this.f126808c);
        }
        return z16;
    }

    @Override // com.tencent.luggage.wxa.hq.a, com.tencent.luggage.wxa.hq.b
    public synchronized void d(g gVar) {
        super.d(gVar);
        if (gVar.a("LIMIT") <= this.f126808c) {
            gVar.d("LIMIT", this.f126807b);
        }
    }
}
