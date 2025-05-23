package com.tencent.gdtad.aditem;

import androidx.annotation.NonNull;
import com.tencent.open.base.MD5Utils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtAdUtil {
    private static final String TAG = "GdtAdUtil";

    @NonNull
    public static String getShareCheck(long j3, long j16, int i3) {
        return MD5Utils.toMD5(String.format("%s_%d_%d_%d", "!@#$%qboi!@#^&*m13=4aa22", Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3))).toLowerCase();
    }
}
