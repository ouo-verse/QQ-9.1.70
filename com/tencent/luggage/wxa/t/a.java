package com.tencent.luggage.wxa.t;

import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.t.b;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements b.InterfaceC6729b {

    /* renamed from: a, reason: collision with root package name */
    public final long f140788a;

    /* renamed from: b, reason: collision with root package name */
    public final int f140789b;

    /* renamed from: c, reason: collision with root package name */
    public final long f140790c;

    public a(long j3, int i3, long j16) {
        long b16;
        this.f140788a = j3;
        this.f140789b = i3;
        if (j16 == -1) {
            b16 = -9223372036854775807L;
        } else {
            b16 = b(j16);
        }
        this.f140790c = b16;
    }

    @Override // com.tencent.luggage.wxa.q.k
    public boolean a() {
        return this.f140790c != -9223372036854775807L;
    }

    @Override // com.tencent.luggage.wxa.t.b.InterfaceC6729b
    public long b(long j3) {
        return ((Math.max(0L, j3 - this.f140788a) * 1000000) * 8) / this.f140789b;
    }

    @Override // com.tencent.luggage.wxa.q.k
    public long c() {
        return this.f140790c;
    }

    @Override // com.tencent.luggage.wxa.q.k
    public long a(long j3) {
        long j16 = this.f140790c;
        if (j16 == -9223372036854775807L) {
            return 0L;
        }
        return this.f140788a + ((v.a(j3, 0L, j16) * this.f140789b) / 8000000);
    }
}
