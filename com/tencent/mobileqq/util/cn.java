package com.tencent.mobileqq.util;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.BaseConstantState;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableColorStateList;
import com.tencent.theme.SkinnableNinePatchDrawable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cn {
    public static String a(int i3) {
        try {
            return String.format("#%06X", Integer.valueOf(i3 & 16777215));
        } catch (Exception e16) {
            QLog.d("SkinUtils", 1, "colorToHexStr error : ", e16);
            return "";
        }
    }

    @SuppressLint({"NewApi"})
    public static int b(Bitmap bitmap) {
        if (bitmap == null) {
            return -1;
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    private static String c(Paint paint) {
        ColorFilter colorFilter;
        int colorAdd;
        String obj;
        if (paint == null) {
            colorFilter = null;
        } else {
            colorFilter = paint.getColorFilter();
        }
        if (!(colorFilter instanceof LightingColorFilter)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("not lighting color filter, color filter : ");
            if (colorFilter == null) {
                obj = "null";
            } else {
                obj = colorFilter.toString();
            }
            sb5.append(obj);
            return sb5.toString();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            colorAdd = ((LightingColorFilter) colorFilter).getColorAdd();
            return a(colorAdd);
        }
        return "sdk limit";
    }

    public static final Bitmap d(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (!(drawable instanceof SkinnableBitmapDrawable)) {
            return null;
        }
        return ((SkinnableBitmapDrawable) drawable).getBitmap();
    }

    public static int e(Drawable drawable) {
        if (drawable == null) {
            return -1;
        }
        if (drawable instanceof BitmapDrawable) {
            return b(((BitmapDrawable) drawable).getBitmap());
        }
        if (drawable instanceof SkinnableBitmapDrawable) {
            return b(((SkinnableBitmapDrawable) drawable).getBitmap());
        }
        if (!(drawable instanceof SkinnableNinePatchDrawable)) {
            return -1;
        }
        return b(((SkinnableNinePatchDrawable) drawable).getBitmap());
    }

    public static Drawable f(Drawable drawable) {
        if (drawable instanceof SkinnableBitmapDrawable) {
            return ((SkinnableBitmapDrawable) drawable).mutate2();
        }
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainer.DrawableContainerState) {
                Drawable[] children = ((DrawableContainer.DrawableContainerState) constantState).getChildren();
                if (children != null && children.length != 0) {
                    for (int i3 = 0; i3 < children.length; i3++) {
                        children[i3] = f(children[i3]);
                    }
                } else {
                    return drawable.mutate();
                }
            }
        }
        if (drawable != null) {
            return drawable.mutate();
        }
        return null;
    }

    public static void g(ColorStateList colorStateList) {
        if (!(colorStateList instanceof SkinnableColorStateList)) {
            QLog.d("SkinUtils", 1, "not SkinnableColorStateList");
            return;
        }
        SkinnableColorStateList skinnableColorStateList = (SkinnableColorStateList) colorStateList;
        try {
            QLog.d("SkinUtils", 1, "skin color file : ", skinnableColorStateList.skinData.mFileName, " color : ", a(skinnableColorStateList.getDefaultColor()));
        } catch (NullPointerException unused) {
            QLog.i("SkinUtils", 1, "[printSkinnableColor] skinColor or skinColor.skinData is null,  skinColor = " + skinnableColorStateList);
        }
    }

    public static void h(Drawable drawable) {
        if (drawable instanceof DrawableContainer) {
            Drawable[] children = ((DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()).getChildren();
            QLog.d("SkinUtils", 1, "print drawable container, ", drawable.toString());
            for (Drawable drawable2 : children) {
                h(drawable2);
            }
            return;
        }
        boolean z16 = drawable instanceof SkinnableBitmapDrawable;
        if (!z16 && !(drawable instanceof SkinnableNinePatchDrawable)) {
            QLog.d("SkinUtils", 1, "not skinnable drawable");
        } else if (z16) {
            SkinnableBitmapDrawable skinnableBitmapDrawable = (SkinnableBitmapDrawable) drawable;
            QLog.d("SkinUtils", 1, "skin bitmap file : ", ((BaseConstantState) skinnableBitmapDrawable.getConstantState()).skinData.mFileName, " color : ", c(skinnableBitmapDrawable.getPaint()));
        } else {
            SkinnableNinePatchDrawable skinnableNinePatchDrawable = (SkinnableNinePatchDrawable) drawable;
            QLog.d("SkinUtils", 1, "skin nine patch file : ", ((BaseConstantState) skinnableNinePatchDrawable.getConstantState()).skinData.mFileName, " color : ", c(skinnableNinePatchDrawable.getPaint()));
        }
    }
}
