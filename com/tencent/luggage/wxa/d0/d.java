package com.tencent.luggage.wxa.d0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements l {

    /* renamed from: a, reason: collision with root package name */
    public final l[] f123949a;

    public d(l[] lVarArr) {
        this.f123949a = lVarArr;
    }

    @Override // com.tencent.luggage.wxa.d0.l
    public final boolean a(long j3) {
        boolean z16;
        boolean z17 = false;
        do {
            long b16 = b();
            if (b16 == Long.MIN_VALUE) {
                break;
            }
            z16 = false;
            for (l lVar : this.f123949a) {
                if (lVar.b() == b16) {
                    z16 |= lVar.a(j3);
                }
            }
            z17 |= z16;
        } while (z16);
        return z17;
    }

    @Override // com.tencent.luggage.wxa.d0.l
    public final long b() {
        long j3 = Long.MAX_VALUE;
        for (l lVar : this.f123949a) {
            long b16 = lVar.b();
            if (b16 != Long.MIN_VALUE) {
                j3 = Math.min(j3, b16);
            }
        }
        if (j3 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j3;
    }

    @Override // com.tencent.luggage.wxa.d0.l
    public final long c() {
        long j3 = Long.MAX_VALUE;
        for (l lVar : this.f123949a) {
            long c16 = lVar.c();
            if (c16 != Long.MIN_VALUE) {
                j3 = Math.min(j3, c16);
            }
        }
        if (j3 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j3;
    }
}
