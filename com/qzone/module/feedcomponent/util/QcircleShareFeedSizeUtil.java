package com.qzone.module.feedcomponent.util;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QcircleShareFeedSizeUtil {
    private static final int FIT_LONG = 777;
    private static final int FIT_SHORT = 486;

    public static int[] fitQcircleShareFeed(int[] iArr) {
        if (iArr == null || iArr.length != 2) {
            return iArr;
        }
        int i3 = iArr[0];
        int i16 = iArr[1];
        if (i3 == 0 || i16 == 0) {
            return new int[]{FIT_SHORT, 777};
        }
        if (i16 >= i3) {
            return new int[]{FIT_SHORT, 777};
        }
        return new int[]{777, FIT_SHORT};
    }
}
