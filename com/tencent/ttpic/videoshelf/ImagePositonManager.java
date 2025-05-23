package com.tencent.ttpic.videoshelf;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes27.dex */
public class ImagePositonManager {
    public static void setMovePosition(Drawable drawable, Matrix matrix, float f16, float f17, int i3, int i16) {
        RectF rectF = new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(rectF);
        float width = rectF.width();
        float height = rectF.height();
        float f18 = i3;
        if (width > f18 && rectF.left + f16 <= 0.0f && rectF.right + f16 >= f18) {
            matrix.postTranslate(f16, 0.0f);
        }
        float f19 = i16;
        if (height > f19 && rectF.top + f17 <= 0.0f && rectF.bottom + f17 >= f19) {
            matrix.postTranslate(0.0f, f17);
        }
    }

    public static void setShowPosition(Drawable drawable, Matrix matrix, int i3, int i16) {
        float f16;
        float f17;
        RectF rectF = new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(rectF);
        float width = rectF.width();
        float height = rectF.height();
        float f18 = i3;
        if (width <= f18) {
            f16 = ((i3 / 2) - (width / 2.0f)) - rectF.left;
        } else {
            f16 = 0.0f;
        }
        float f19 = i16;
        if (height <= f19) {
            f17 = ((i16 / 2) - (height / 2.0f)) - rectF.top;
        } else {
            f17 = 0.0f;
        }
        if (width > f18) {
            float f26 = rectF.left;
            if (f26 > 0.0f) {
                f16 = -f26;
            }
        }
        if (width > f18) {
            float f27 = rectF.right;
            if (f27 < f18) {
                f16 = f18 - f27;
            }
        }
        if (height > f19) {
            float f28 = rectF.top;
            if (f28 > 0.0f) {
                f17 = -f28;
            }
        }
        if (height > f19) {
            float f29 = rectF.bottom;
            if (f29 < f19) {
                f17 = f19 - f29;
            }
        }
        matrix.postTranslate(f16, f17);
    }
}
