package com.tencent.mobileqq.triton.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.mobileqq.triton.internal.utils.Logger;

/* compiled from: P */
@TritonKeep
/* loaded from: classes19.dex */
public class NativeImageDecoder {
    private static int MAX_IMAGE_HEIGHT = 1024;
    private static int MAX_IMAGE_WIDTH = 1024;
    private static final String TAG = "NativeImageDecoder";

    @TritonKeep
    public static Bitmap decodeGifBuffer(byte[] bArr, int i3) {
        Bitmap decodeImageBuffer = decodeImageBuffer(bArr, i3);
        if (decodeImageBuffer == null || decodeImageBuffer.isRecycled()) {
            return null;
        }
        Bitmap.Config config = decodeImageBuffer.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        if (config != config2) {
            Bitmap copy = decodeImageBuffer.copy(config2, true);
            if (copy == null) {
                copy = Bitmap.createBitmap(decodeImageBuffer.getWidth(), decodeImageBuffer.getHeight(), Bitmap.Config.ARGB_8888);
                new Canvas(copy).drawBitmap(decodeImageBuffer, 0.0f, 0.0f, (Paint) null);
            }
            return copy;
        }
        return decodeImageBuffer;
    }

    @TritonKeep
    public static Bitmap decodeImageBuffer(byte[] bArr, int i3) {
        return decodeImageBuffer(bArr, i3, MAX_IMAGE_WIDTH * 2, MAX_IMAGE_HEIGHT * 2);
    }

    public static Bitmap decodeImageBuffer(byte[] bArr, int i3, int i16, int i17) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, i3, options);
            int i18 = options.outWidth;
            int i19 = options.outHeight;
            options.inSampleSize = (i18 > i16 || i19 > i17) ? Math.min(Math.round(i18 / i16), Math.round(i19 / i17)) : 1;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeByteArray(bArr, 0, i3, options);
        } catch (Exception e16) {
            Logger.e(TAG, "decodeJpgBuffer failed:" + e16.getMessage());
            return null;
        } catch (OutOfMemoryError e17) {
            Logger.e(TAG, "decodeJpgBuffer oom:" + e17.getMessage());
            return null;
        }
    }
}
