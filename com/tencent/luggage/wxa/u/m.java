package com.tencent.luggage.wxa.u;

import com.tencent.luggage.wxa.n0.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final int f142002a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f142003b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f142004c;

    /* renamed from: d, reason: collision with root package name */
    public final int f142005d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f142006e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f142007f;

    public m(long[] jArr, int[] iArr, int i3, long[] jArr2, int[] iArr2) {
        boolean z16;
        boolean z17;
        if (iArr.length == jArr2.length) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.n0.a.a(z16);
        if (jArr.length == jArr2.length) {
            z17 = true;
        } else {
            z17 = false;
        }
        com.tencent.luggage.wxa.n0.a.a(z17);
        com.tencent.luggage.wxa.n0.a.a(iArr2.length == jArr2.length);
        this.f142003b = jArr;
        this.f142004c = iArr;
        this.f142005d = i3;
        this.f142006e = jArr2;
        this.f142007f = iArr2;
        this.f142002a = jArr.length;
    }

    public int a(long j3) {
        for (int b16 = v.b(this.f142006e, j3, true, false); b16 >= 0; b16--) {
            if ((this.f142007f[b16] & 1) != 0) {
                return b16;
            }
        }
        return -1;
    }

    public int b(long j3) {
        for (int a16 = v.a(this.f142006e, j3, true, false); a16 < this.f142006e.length; a16++) {
            if ((this.f142007f[a16] & 1) != 0) {
                return a16;
            }
        }
        return -1;
    }
}
