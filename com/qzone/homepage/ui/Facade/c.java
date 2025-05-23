package com.qzone.homepage.ui.Facade;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends ImageProcessor {
    public static double a(int i3, int i16) {
        double d16 = (i3 * 1.0d) / i16;
        double screenHeight = (ViewUtils.getScreenHeight() * 1.0d) / ViewUtils.getScreenWidth();
        if (d16 <= screenHeight) {
            return 0.0d;
        }
        double d17 = (d16 - screenHeight) / d16;
        if (0.3d < d17) {
            return 0.3d;
        }
        return d17;
    }

    public static double b(int i3, int i16) {
        double d16 = (i16 * 1.0d) / i3;
        double screenWidth = (ViewUtils.getScreenWidth() * 1.0d) / ViewUtils.getScreenHeight();
        if (d16 <= screenWidth) {
            return 0.0d;
        }
        double d17 = (d16 - screenWidth) / d16;
        if (0.3d < d17) {
            return 0.3d;
        }
        return d17;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        Bitmap createBitmap;
        try {
            BitmapReference bitmapRef = ((ImageDrawable) drawable).getBitmapRef();
            int width = bitmapRef.getWidth();
            int height = bitmapRef.getHeight();
            double a16 = a(height, width);
            if (a16 - 0.0d > 1.0E-13d) {
                int round = (int) Math.round(a16 * height);
                createBitmap = Bitmap.createBitmap(bitmapRef.getBitmap(), 0, round / 2, width, height - round);
                if (!bitmapRef.isRecycled()) {
                    bitmapRef.release();
                }
            } else {
                double b16 = b(height, width);
                if (b16 - 0.0d > 1.0E-13d) {
                    int round2 = (int) Math.round(b16 * width);
                    createBitmap = Bitmap.createBitmap(bitmapRef.getBitmap(), round2 / 2, 0, width - round2, height);
                    if (!bitmapRef.isRecycled()) {
                        bitmapRef.release();
                    }
                } else {
                    createBitmap = Bitmap.createBitmap(bitmapRef.getBitmap(), 0, 0, width, height);
                }
            }
            return new SpecifiedBitmapDrawable(BitmapReference.getBitmapReference(createBitmap));
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
