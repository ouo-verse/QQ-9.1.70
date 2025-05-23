package com.tencent.libra.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RFWThumbnailUtils {
    private static final int OPTIONS_NONE = 0;
    public static final int OPTIONS_RECYCLE_INPUT = 2;
    private static final int OPTIONS_SCALE_UP = 1;

    public static Bitmap extractThumbnail(Bitmap bitmap, int i3, int i16, int i17, boolean z16) {
        float f16;
        int height;
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() < bitmap.getHeight()) {
            f16 = i3;
            height = bitmap.getWidth();
        } else {
            f16 = i16;
            height = bitmap.getHeight();
        }
        float f17 = f16 / height;
        Matrix matrix = new Matrix();
        matrix.setScale(f17, f17);
        return transform(matrix, bitmap, i3, i16, i17 | 1, z16);
    }

    public static float getAdjustScale(float f16, float f17, float f18, float f19, boolean z16) {
        float f26;
        if (f18 <= 0.0f || f19 <= 0.0f || f16 <= 0.0f || f17 <= 0.0f) {
            return 1.0f;
        }
        if (f16 / f17 <= f18 / f19 ? z16 : !z16) {
            f26 = f18 / f16;
        } else {
            f26 = f19 / f17;
        }
        if (f26 > 1.0f && LibraConfigUtil.INSTANCE.enableAdjustScaleLimit()) {
            return 1.0f;
        }
        return f26;
    }

    private static Bitmap transform(Matrix matrix, Bitmap bitmap, int i3, int i16, int i17, boolean z16) {
        boolean z17;
        Bitmap createBitmap;
        boolean z18 = true;
        if ((i17 & 1) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if ((i17 & 2) == 0) {
            z18 = false;
        }
        int width = bitmap.getWidth() - i3;
        int height = bitmap.getHeight() - i16;
        if (!z17 && (width < 0 || height < 0)) {
            Bitmap.Config config = bitmap.getConfig();
            Bitmap.Config config2 = Bitmap.Config.RGB_565;
            if (config != config2) {
                config2 = Bitmap.Config.ARGB_8888;
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(i3, i16, config2);
            Canvas canvas = new Canvas(createBitmap2);
            int max = Math.max(0, width / 2);
            int max2 = Math.max(0, height / 2);
            Rect rect = new Rect(max, max2, Math.min(i3, bitmap.getWidth()) + max, Math.min(i16, bitmap.getHeight()) + max2);
            int width2 = (i3 - rect.width()) / 2;
            int height2 = (i16 - rect.height()) / 2;
            canvas.drawBitmap(bitmap, rect, new Rect(width2, height2, i3 - width2, i16 - height2), (Paint) null);
            if (z18) {
                bitmap.recycle();
            }
            canvas.setBitmap(null);
            return createBitmap2;
        }
        float adjustScale = getAdjustScale(bitmap.getWidth(), bitmap.getHeight(), i3, i16, z16);
        matrix.setScale(adjustScale, adjustScale);
        Bitmap createBitmap3 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z18 && createBitmap3 != bitmap) {
            bitmap.recycle();
        }
        int max3 = Math.max(0, createBitmap3.getWidth() - i3);
        int max4 = Math.max(0, createBitmap3.getHeight() - i16);
        if (max3 == 0 && max4 == 0) {
            createBitmap = createBitmap3;
        } else {
            createBitmap = Bitmap.createBitmap(createBitmap3, max3 / 2, max4 / 2, i3, i16);
        }
        if (createBitmap != createBitmap3 && (z18 || createBitmap3 != bitmap)) {
            createBitmap3.recycle();
        }
        return createBitmap;
    }
}
