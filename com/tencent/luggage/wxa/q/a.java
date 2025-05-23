package com.tencent.luggage.wxa.q;

import com.tencent.luggage.wxa.n0.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements k {

    /* renamed from: a, reason: collision with root package name */
    public final int f137738a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f137739b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f137740c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f137741d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f137742e;

    /* renamed from: f, reason: collision with root package name */
    public final long f137743f;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f137739b = iArr;
        this.f137740c = jArr;
        this.f137741d = jArr2;
        this.f137742e = jArr3;
        int length = iArr.length;
        this.f137738a = length;
        if (length > 0) {
            int i3 = length - 1;
            this.f137743f = jArr2[i3] + jArr3[i3];
        } else {
            this.f137743f = 0L;
        }
    }

    @Override // com.tencent.luggage.wxa.q.k
    public boolean a() {
        return true;
    }

    public int c(long j3) {
        return v.b(this.f137742e, j3, true, true);
    }

    @Override // com.tencent.luggage.wxa.q.k
    public long a(long j3) {
        return this.f137740c[c(j3)];
    }

    @Override // com.tencent.luggage.wxa.q.k
    public long c() {
        return this.f137743f;
    }
}
