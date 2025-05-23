package com.tencent.qphone.base.util.log;

import android.annotation.SuppressLint;
import okio.Utf8;

/* compiled from: P */
@SuppressLint({"UseValueOf"})
/* loaded from: classes22.dex */
public class LargerInteger {
    private static final Integer[] LARGER_VALUES = new Integer[Utf8.MASK_2BYTES];
    private static final int MAX = 4096;

    static {
        for (int i3 = 128; i3 < 4096; i3++) {
            LARGER_VALUES[i3 - 128] = new Integer(i3);
        }
    }

    public static Integer valueOf(int i3) {
        if (i3 >= 128 && i3 < 4096) {
            return LARGER_VALUES[i3 - 128];
        }
        return Integer.valueOf(i3);
    }
}
