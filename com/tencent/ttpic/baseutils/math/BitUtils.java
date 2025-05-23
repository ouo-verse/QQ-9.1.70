package com.tencent.ttpic.baseutils.math;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BitUtils {
    public static final int BIT_TURN_ZERO_1 = 65534;
    public static final int BIT_TURN_ZERO_2 = 65533;
    public static final int BIT_TURN_ZERO_3 = 65531;
    public static final int BIT_TURN_ZERO_4 = 65527;

    public static boolean checkBit(int i3, int i16) {
        if ((i3 & i16) == i16) {
            return true;
        }
        return false;
    }

    public static int turnBitTo0(int i3, int i16) {
        return i3 & i16;
    }

    public static int turnBitTo1(int i3, int i16) {
        return i3 | i16;
    }
}
