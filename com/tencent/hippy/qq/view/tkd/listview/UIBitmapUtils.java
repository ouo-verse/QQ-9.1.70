package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes7.dex */
public class UIBitmapUtils {
    public static Drawable getColorImage(Bitmap bitmap, int i3) {
        return getColorImage(new BitmapDrawable(BaseApplication.getContext().getResources(), bitmap), i3);
    }

    public static Drawable getColorImage(Drawable drawable, int i3) {
        if (drawable == null) {
            return null;
        }
        if (drawable.getConstantState() == null) {
            Drawable mutate = drawable.mutate();
            if (mutate != null) {
                return new TintDrawableWrapper(mutate, i3);
            }
            return null;
        }
        Drawable mutate2 = drawable.getConstantState().newDrawable().mutate();
        if (mutate2 != null) {
            return new TintDrawableWrapper(mutate2, i3);
        }
        return null;
    }
}
