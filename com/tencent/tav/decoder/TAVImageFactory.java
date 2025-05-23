package com.tencent.tav.decoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.tencent.tav.decoder.logger.Logger;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVImageFactory {
    private static Bitmap.Config[] SUPPORT_CONFIGS = {Bitmap.Config.ALPHA_8, Bitmap.Config.RGB_565, Bitmap.Config.ARGB_4444, Bitmap.Config.ARGB_8888};
    private static final String TAG = "TAVImageFactory";

    @Nullable
    private static synchronized Bitmap checkBitmapConfig(@Nullable Bitmap bitmap) {
        synchronized (TAVImageFactory.class) {
            if (bitmap != null) {
                if (bitmap.getConfig() != null) {
                    if (Arrays.binarySearch(SUPPORT_CONFIGS, bitmap.getConfig()) < 0) {
                        return transcodeBitmap(bitmap);
                    }
                    return bitmap;
                }
            }
            return null;
        }
    }

    @Nullable
    public static synchronized Bitmap fixSupportImageConfig(@Nullable Bitmap bitmap) {
        Bitmap checkBitmapConfig;
        synchronized (TAVImageFactory.class) {
            try {
                checkBitmapConfig = checkBitmapConfig(bitmap);
            } catch (Exception e16) {
                Logger.e(TAG, "fixSupportImageConfig: ", e16);
                return null;
            }
        }
        return checkBitmapConfig;
    }

    private static Bitmap transcodeBitmap(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }
}
