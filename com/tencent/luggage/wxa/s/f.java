package com.tencent.luggage.wxa.s;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: d, reason: collision with root package name */
    public static final long[] f139984d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f139985a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public int f139986b;

    /* renamed from: c, reason: collision with root package name */
    public int f139987c;

    public long a(com.tencent.luggage.wxa.q.e eVar, boolean z16, boolean z17, int i3) {
        if (this.f139986b == 0) {
            if (!eVar.b(this.f139985a, 0, 1, z16)) {
                return -1L;
            }
            int a16 = a(this.f139985a[0] & 255);
            this.f139987c = a16;
            if (a16 != -1) {
                this.f139986b = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i16 = this.f139987c;
        if (i16 > i3) {
            this.f139986b = 0;
            return -2L;
        }
        if (i16 != 1) {
            eVar.a(this.f139985a, 1, i16 - 1);
        }
        this.f139986b = 0;
        return a(this.f139985a, this.f139987c, z17);
    }

    public void b() {
        this.f139986b = 0;
        this.f139987c = 0;
    }

    public int a() {
        return this.f139987c;
    }

    public static int a(int i3) {
        long j3;
        int i16 = 0;
        do {
            long[] jArr = f139984d;
            if (i16 >= jArr.length) {
                return -1;
            }
            j3 = jArr[i16] & i3;
            i16++;
        } while (j3 == 0);
        return i16;
    }

    public static long a(byte[] bArr, int i3, boolean z16) {
        long j3 = bArr[0] & 255;
        if (z16) {
            j3 &= ~f139984d[i3 - 1];
        }
        for (int i16 = 1; i16 < i3; i16++) {
            j3 = (j3 << 8) | (bArr[i16] & 255);
        }
        return j3;
    }
}
