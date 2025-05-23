package com.tencent.luggage.wxa.t;

import com.tencent.luggage.wxa.n0.l;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.q.i;
import com.tencent.luggage.wxa.t.b;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements b.InterfaceC6729b {

    /* renamed from: a, reason: collision with root package name */
    public final long f140811a;

    /* renamed from: b, reason: collision with root package name */
    public final long f140812b;

    /* renamed from: c, reason: collision with root package name */
    public final long f140813c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f140814d;

    /* renamed from: e, reason: collision with root package name */
    public final long f140815e;

    /* renamed from: f, reason: collision with root package name */
    public final int f140816f;

    public d(long j3, long j16, long j17) {
        this(j3, j16, j17, null, 0L, 0);
    }

    public static d a(i iVar, l lVar, long j3, long j16) {
        int u16;
        int i3 = iVar.f137768g;
        int i16 = iVar.f137765d;
        long j17 = j3 + iVar.f137764c;
        int f16 = lVar.f();
        if ((f16 & 1) != 1 || (u16 = lVar.u()) == 0) {
            return null;
        }
        long b16 = v.b(u16, i3 * 1000000, i16);
        if ((f16 & 6) != 6) {
            return new d(j17, b16, j16);
        }
        long u17 = lVar.u();
        lVar.f(1);
        long[] jArr = new long[99];
        for (int i17 = 0; i17 < 99; i17++) {
            jArr[i17] = lVar.q();
        }
        return new d(j17, b16, j16, jArr, u17, iVar.f137764c);
    }

    @Override // com.tencent.luggage.wxa.t.b.InterfaceC6729b
    public long b(long j3) {
        long j16;
        long j17;
        long j18 = 0;
        if (a()) {
            if (j3 >= this.f140811a) {
                double d16 = ((j3 - r3) * 256.0d) / this.f140815e;
                int b16 = v.b(this.f140814d, (long) d16, true, false) + 1;
                long a16 = a(b16);
                if (b16 == 0) {
                    j16 = 0;
                } else {
                    j16 = this.f140814d[b16 - 1];
                }
                if (b16 == 99) {
                    j17 = 256;
                } else {
                    j17 = this.f140814d[b16];
                }
                long a17 = a(b16 + 1);
                if (j17 != j16) {
                    j18 = (long) (((a17 - a16) * (d16 - j16)) / (j17 - j16));
                }
                return a16 + j18;
            }
        }
        return 0L;
    }

    @Override // com.tencent.luggage.wxa.q.k
    public long c() {
        return this.f140812b;
    }

    public d(long j3, long j16, long j17, long[] jArr, long j18, int i3) {
        this.f140811a = j3;
        this.f140812b = j16;
        this.f140813c = j17;
        this.f140814d = jArr;
        this.f140815e = j18;
        this.f140816f = i3;
    }

    @Override // com.tencent.luggage.wxa.q.k
    public boolean a() {
        return this.f140814d != null;
    }

    @Override // com.tencent.luggage.wxa.q.k
    public long a(long j3) {
        if (!a()) {
            return this.f140811a;
        }
        float f16 = (((float) j3) * 100.0f) / ((float) this.f140812b);
        if (f16 > 0.0f) {
            if (f16 >= 100.0f) {
                r0 = 256.0f;
            } else {
                int i3 = (int) f16;
                r0 = i3 != 0 ? (float) this.f140814d[i3 - 1] : 0.0f;
                r0 += ((i3 < 99 ? (float) this.f140814d[i3] : 256.0f) - r0) * (f16 - i3);
            }
        }
        long round = Math.round(r0 * 0.00390625d * this.f140815e);
        long j16 = this.f140811a;
        long j17 = round + j16;
        long j18 = this.f140813c;
        return Math.min(j17, j18 != -1 ? j18 - 1 : ((j16 - this.f140816f) + this.f140815e) - 1);
    }

    public final long a(int i3) {
        return (this.f140812b * i3) / 100;
    }
}
