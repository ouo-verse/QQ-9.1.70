package com.tencent.av.video.effect.lowlight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import com.tencent.av.video.effect.utils.StorageUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LowLightTools {
    private static final String LOW_LIGHT_IMAGE = "LowLight.png";
    public static final String TAG = "LowLightTools";

    public static <T extends Number> double clipping(T t16) {
        if (t16.doubleValue() < 0.0d) {
            return 0.0d;
        }
        if (t16.doubleValue() > 255.0d) {
            return 255.0d;
        }
        return t16.doubleValue();
    }

    public static Bitmap getLowLightImage(Context context, String str) {
        try {
            return BitmapFactory.decodeStream(CommonUtils.getInputStreamFromPath(context, str + "/" + LOW_LIGHT_IMAGE));
        } catch (Exception e16) {
            Log.d(TAG, "getLowLightImage:" + e16);
            return null;
        }
    }

    public static void saveBitmap(Bitmap bitmap) {
        File file = new File(StorageUtils.VIDEO_EFFECT_PATH + "LowLight/lowLight_saved.png");
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e16) {
            Log.d(TAG, "saveBitmap:" + e16);
        }
    }

    public static Bitmap getLowLightImage(float f16, float f17, float f18, float f19, boolean z16) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
            byte[] bArr = new byte[262144];
            int i3 = 0;
            for (int i16 = 0; i16 < 256; i16++) {
                for (int i17 = 0; i17 < 256; i17++) {
                    byte clipping = (byte) clipping(Double.valueOf(Math.pow(((int) clipping(Integer.valueOf((int) (((i16 - f16) / ((float) Math.pow(1.0f - (((255.0f - i17) * f17) / (255.0f - f16)), f18))) + f16)))) / 255.0f, f19) * 255.0d));
                    bArr[i3] = clipping;
                    bArr[i3 + 1] = clipping;
                    bArr[i3 + 2] = clipping;
                    bArr[i3 + 3] = -1;
                    i3 += 4;
                }
            }
            createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
            if (z16) {
                saveBitmap(createBitmap);
            }
            return createBitmap;
        } catch (Throwable th5) {
            Log.d(TAG, "getLowLightImage:" + th5);
            return null;
        }
    }
}
