package com.tencent.timi.game.utils;

/* compiled from: P */
/* loaded from: classes26.dex */
public class y {
    private static int a(long j3, long j16) {
        return e(d(j3), d(j16));
    }

    public static String b(long j3) {
        if (j3 == 0) {
            return "0";
        }
        int i3 = 64;
        char[] cArr = new char[64];
        if (j3 < 0) {
            long j16 = 10;
            long c16 = c(j3, j16);
            i3 = 63;
            cArr[63] = Character.forDigit((int) (j3 - (j16 * c16)), 10);
            j3 = c16;
        }
        while (j3 > 0) {
            i3--;
            long j17 = 10;
            cArr[i3] = Character.forDigit((int) (j3 % j17), 10);
            j3 /= j17;
        }
        return new String(cArr, i3, 64 - i3);
    }

    private static long c(long j3, long j16) {
        if (j16 < 0) {
            if (a(j3, j16) < 0) {
                return 0L;
            }
            return 1L;
        }
        if (j3 >= 0) {
            return j3 / j16;
        }
        int i3 = 1;
        long j17 = ((j3 >>> 1) / j16) << 1;
        if (a(j3 - (j17 * j16), j16) < 0) {
            i3 = 0;
        }
        return j17 + i3;
    }

    private static long d(long j3) {
        return j3 ^ Long.MIN_VALUE;
    }

    private static int e(long j3, long j16) {
        if (j3 < j16) {
            return -1;
        }
        if (j3 > j16) {
            return 1;
        }
        return 0;
    }
}
