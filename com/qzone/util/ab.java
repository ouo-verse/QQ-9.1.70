package com.qzone.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ab {
    public static Bitmap a(Drawable drawable, int i3, int i16) {
        BitmapReference bitmapRef;
        Bitmap bitmap;
        if (drawable == null || !(drawable instanceof BitmapRefDrawable) || (bitmapRef = ((BitmapRefDrawable) drawable).getBitmapRef()) == null || (bitmap = bitmapRef.getBitmap()) == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, i3, i16, false);
    }
}
