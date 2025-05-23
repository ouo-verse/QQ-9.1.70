package com.tencent.halley.common.utils;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class i {
    public static String a(long j3) {
        long j16;
        if (j3 == 0) {
            return "0";
        }
        int i3 = 64;
        char[] cArr = new char[64];
        if (j3 < 0) {
            if (j3 >= 0) {
                j16 = j3 / 10;
            } else {
                int i16 = 1;
                long j17 = ((j3 >>> 1) / 10) << 1;
                if (b(j3 - (j17 * 10)) < 0) {
                    i16 = 0;
                }
                j16 = i16 + j17;
            }
            Long.signum(j16);
            cArr[63] = Character.forDigit((int) (j3 - (j16 * 10)), 10);
            i3 = 63;
            j3 = j16;
        }
        while (j3 > 0) {
            i3--;
            cArr[i3] = Character.forDigit((int) (j3 % 10), 10);
            j3 /= 10;
        }
        return new String(cArr, i3, 64 - i3);
    }

    private static int b(long j3) {
        return c(j3 ^ Long.MIN_VALUE);
    }

    private static int c(long j3) {
        if (j3 < -9223372036854775798L) {
            return -1;
        }
        if (j3 > -9223372036854775798L) {
            return 1;
        }
        return 0;
    }
}
