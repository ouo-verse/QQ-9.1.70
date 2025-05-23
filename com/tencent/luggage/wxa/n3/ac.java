package com.tencent.luggage.wxa.n3;

/* compiled from: P */
/* loaded from: classes8.dex */
public final /* synthetic */ class ac {
    public static /* synthetic */ long a(long j3, long j16) {
        if (j16 < 0) {
            if ((j3 ^ Long.MIN_VALUE) < (j16 ^ Long.MIN_VALUE)) {
                return 0L;
            }
            return 1L;
        }
        if (j3 >= 0) {
            return j3 / j16;
        }
        int i3 = 1;
        long j17 = ((j3 >>> 1) / j16) << 1;
        if (((j3 - (j17 * j16)) ^ Long.MIN_VALUE) < (j16 ^ Long.MIN_VALUE)) {
            i3 = 0;
        }
        return j17 + i3;
    }
}
