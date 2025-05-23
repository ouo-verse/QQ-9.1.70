package com.tencent.ttpic.baseutils.math;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Math {
    public static final double NINETY_DEGREES = 1.5707963267948966d;
    public static final double ONE_EIGHTY_DEGREES = 3.141592653589793d;
    public static final double ONE_TWENTY_DEGREES = 2.0943951023931953d;
    private static final long POWER_CLAMP = 4294967295L;
    public static final double THREE_SIXTY_DEGREES = 6.283185307179586d;

    Math() {
    }

    public static int power(int i3, int i16) {
        long j3 = i16 & 4294967295L;
        long j16 = i3;
        int i17 = 1;
        while (j3 != 0) {
            if ((1 & j3) != 0) {
                i17 = (int) (i17 * j16);
            }
            j3 >>>= 1;
            j16 *= j16;
        }
        return i17;
    }
}
