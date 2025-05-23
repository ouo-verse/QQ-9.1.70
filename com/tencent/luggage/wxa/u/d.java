package com.tencent.luggage.wxa.u;

import com.tencent.luggage.wxa.n0.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f141878a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f141879b;

        /* renamed from: c, reason: collision with root package name */
        public final int f141880c;

        /* renamed from: d, reason: collision with root package name */
        public final long[] f141881d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f141882e;

        public b(long[] jArr, int[] iArr, int i3, long[] jArr2, int[] iArr2) {
            this.f141878a = jArr;
            this.f141879b = iArr;
            this.f141880c = i3;
            this.f141881d = jArr2;
            this.f141882e = iArr2;
        }
    }

    public static b a(int i3, long[] jArr, int[] iArr, long j3) {
        int i16 = 8192 / i3;
        int i17 = 0;
        for (int i18 : iArr) {
            i17 += v.a(i18, i16);
        }
        long[] jArr2 = new long[i17];
        int[] iArr2 = new int[i17];
        long[] jArr3 = new long[i17];
        int[] iArr3 = new int[i17];
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        for (int i28 = 0; i28 < iArr.length; i28++) {
            int i29 = iArr[i28];
            long j16 = jArr[i28];
            while (i29 > 0) {
                int min = Math.min(i16, i29);
                jArr2[i26] = j16;
                int i36 = i3 * min;
                iArr2[i26] = i36;
                i27 = Math.max(i27, i36);
                jArr3[i26] = i19 * j3;
                iArr3[i26] = 1;
                j16 += iArr2[i26];
                i19 += min;
                i29 -= min;
                i26++;
            }
        }
        return new b(jArr2, iArr2, i27, jArr3, iArr3);
    }
}
