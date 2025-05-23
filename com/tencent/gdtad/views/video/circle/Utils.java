package com.tencent.gdtad.views.video.circle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes6.dex */
public class Utils {
    @Nullable
    public static Bitmap getBitmap(@Nullable Context context, int i3) {
        if (context == null) {
            return null;
        }
        return getBitmap(context.getResources().getDrawable(i3));
    }

    public static Bitmap getBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        throw new IllegalArgumentException("unsupported drawable type");
    }
}
