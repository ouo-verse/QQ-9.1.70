package com.tenpay.sdk.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MemBitmap {
    public static Bitmap createScaledBitmap(Bitmap bitmap, int i3, int i16, boolean z16) {
        try {
            return Bitmap.createScaledBitmap(bitmap, i3, i16, z16);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static Bitmap decodeFile(String str) {
        try {
            return BitmapFactory.decodeFile(str);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }
}
