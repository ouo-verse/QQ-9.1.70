package com.tencent.qqlive.tvkplayer.tools.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKImageUtils {
    private static final String TAG = "TVKImageUtils";

    @Nullable
    public static Bitmap blendBitmapByOverlay(@Nullable Bitmap bitmap, @Nullable Bitmap bitmap2) {
        if (bitmap2 != null && bitmap != null) {
            Bitmap.Config config = bitmap.getConfig();
            Bitmap.Config config2 = bitmap.getConfig();
            Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
            if (config2 != config3) {
                Bitmap copy = bitmap.copy(config3, true);
                bitmap.recycle();
                bitmap = copy;
            }
            Bitmap.Config config4 = bitmap2.getConfig();
            Bitmap.Config config5 = Bitmap.Config.ARGB_8888;
            if (config4 != config5) {
                Bitmap copy2 = bitmap2.copy(config5, true);
                bitmap2.recycle();
                bitmap2 = copy2;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, bitmap.getWidth(), bitmap.getHeight(), true);
            if (createScaledBitmap != bitmap2) {
                bitmap2.recycle();
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.OVERLAY));
            canvas.drawBitmap(createScaledBitmap, 0.0f, 0.0f, (Paint) null);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            if (createBitmap.getConfig() != config) {
                Bitmap copy3 = createBitmap.copy(config, true);
                createBitmap.recycle();
                return copy3;
            }
            return createBitmap;
        }
        TVKLogUtil.w(TAG, "srcBitmap=" + bitmap + "dstBitmap=" + bitmap2 + ", no need to blend");
        return bitmap;
    }
}
