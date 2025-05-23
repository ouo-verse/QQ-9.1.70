package com.tencent.biz.richframework.util;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWImageUtil {
    public static int calculateInSampleSize(int i3, int i16, int i17, int i18) {
        int i19 = 1;
        if (i17 > 0 && i18 > 0 && i3 > 0 && i16 > 0 && (i16 > i18 || i3 > i17)) {
            int i26 = i16 / 2;
            int i27 = i3 / 2;
            while (i26 / i19 > i18 && i27 / i19 > i17) {
                i19 *= 2;
            }
        }
        return i19;
    }

    public static Bitmap convertHardWareBitmapAfterAndroidP(Bitmap bitmap) {
        Bitmap.Config config;
        Bitmap createBitmap;
        if (Build.VERSION.SDK_INT < 28) {
            return bitmap;
        }
        Bitmap.Config config2 = bitmap.getConfig();
        config = Bitmap.Config.HARDWARE;
        if (config2 != config) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Picture picture = new Picture();
        picture.beginRecording(width, height).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        picture.endRecording();
        createBitmap = Bitmap.createBitmap(picture, width, height, Bitmap.Config.ARGB_8888);
        return createBitmap;
    }

    public static Rect getImageVisibleRect(ImageView imageView, ImageView.ScaleType scaleType) {
        imageView.getImageMatrix().getValues(new float[10]);
        int[] iArr = new int[2];
        imageView.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        Rect rect = new Rect(i3, iArr[1], imageView.getWidth() + i3, iArr[1] + imageView.getHeight());
        float width = imageView.getWidth();
        float height = imageView.getHeight();
        Drawable drawable = imageView.getDrawable();
        if (drawable == null) {
            return rect;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float f16 = width - ((int) (intrinsicWidth * r1[0]));
        float f17 = height - ((int) (intrinsicHeight * r1[4]));
        if (scaleType == null) {
            scaleType = imageView.getScaleType();
        }
        Rect rect2 = new Rect(rect);
        if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float f18 = f16 / 2.0f;
            rect2.left = (int) (rect.left + f18 + 0.5f);
            float f19 = f17 / 2.0f;
            rect2.top = (int) (rect.top + f19 + 0.5f);
            rect2.right = (int) ((rect.right - f18) + 0.5f);
            rect2.bottom = (int) ((rect.bottom - f19) + 0.5f);
        } else if (scaleType == ImageView.ScaleType.FIT_START) {
            rect2.right = (int) ((rect.right - f16) + 0.5f);
            rect2.top = rect.top;
            rect2.left = rect.left;
            rect2.bottom = (int) ((rect.bottom - f17) + 0.5f);
        } else if (scaleType == ImageView.ScaleType.FIT_CENTER) {
            float f26 = f16 / 2.0f;
            rect2.left = (int) (rect.left + f26 + 0.5f);
            float f27 = f17 / 2.0f;
            rect2.top = (int) (rect.top + f27 + 0.5f);
            rect2.right = (int) ((rect.right - f26) + 0.5f);
            rect2.bottom = (int) ((rect.bottom - f27) + 0.5f);
        } else if (scaleType == ImageView.ScaleType.FIT_END) {
            rect2.left = (int) (rect.left + f16 + 0.5f);
            rect2.top = (int) (rect.top + f17 + 0.5f);
            rect2.right = rect.right;
            rect2.bottom = rect.bottom;
        }
        return rect2;
    }
}
