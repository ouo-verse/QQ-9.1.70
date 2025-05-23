package com.microrapid.opencv;

import android.graphics.Bitmap;
import android.graphics.Rect;

/* loaded from: classes2.dex */
public class StrokeNativeProcessor {
    public static Bitmap getOutlineImage(Bitmap bitmap, Rect rect, double d16, double d17, double d18, int i3, int i16, int i17, boolean z16) {
        int[] iArr = new int[4];
        Bitmap nativeOutlineImage = nativeOutlineImage(bitmap, iArr, d16, d17, d18, i3, i16, i17, z16);
        int i18 = iArr[0];
        rect.left = i18;
        int i19 = iArr[1];
        rect.top = i19;
        rect.right = i18 + iArr[2];
        rect.bottom = i19 + iArr[3];
        return nativeOutlineImage;
    }

    public static native Bitmap nativeOutlineImage(Bitmap bitmap, int[] iArr, double d16, double d17, double d18, int i3, int i16, int i17, boolean z16);
}
