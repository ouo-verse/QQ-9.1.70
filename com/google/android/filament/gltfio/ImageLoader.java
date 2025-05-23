package com.google.android.filament.gltfio;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ImageLoader {
    public static int desiredSize = Integer.MAX_VALUE;

    private static int calculateInSampleSizeNew(BitmapFactory.Options options, int i3, int i16, boolean z16) {
        int i17;
        int i18 = options.outHeight;
        int i19 = options.outWidth;
        float max = Math.max(i19, i18);
        float min = Math.min(i19, i18);
        float max2 = Math.max(i3, i16);
        if (Math.min(i3, i16) <= 0.0f || max <= max2) {
            return 1;
        }
        if (max / min > 2.0f) {
            float f16 = i19 * i18;
            float f17 = i3 * i16;
            if (Build.VERSION.SDK_INT >= 24) {
                i17 = 1;
                while (f16 / (i17 * i17) >= f17) {
                    i17++;
                }
                if (!z16 || i17 <= 1) {
                    return i17;
                }
            } else {
                int i26 = 1;
                while (f16 / (i26 * i26) >= f17) {
                    i26 *= 2;
                }
                if (z16 && i26 > 1) {
                    return i26 / 2;
                }
                return i26;
            }
        } else {
            i17 = 1;
            if (Build.VERSION.SDK_INT >= 24) {
                while (max / i17 >= max2) {
                    i17++;
                }
                if (!z16 || i17 <= 1) {
                    return i17;
                }
            } else {
                while (max / i17 >= max2) {
                    i17 *= 2;
                }
                if (z16 && i17 > 1) {
                    return i17 / 2;
                }
                return i17;
            }
        }
        return i17 - 1;
    }

    private static int[] getImageInfoFromFile(char[] cArr) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Log.d(ZPlanApiImpl.FILAMENT_TAG, "loadImageFromFile Info: " + String.valueOf(cArr));
            BitmapFactory.decodeFile(String.valueOf(cArr), options);
            int i3 = desiredSize;
            int calculateInSampleSizeNew = calculateInSampleSizeNew(options, i3, i3, false);
            return new int[]{options.outWidth / calculateInSampleSizeNew, options.outHeight / calculateInSampleSizeNew, calculateInSampleSizeNew};
        } catch (Exception unused) {
            return null;
        }
    }

    private static int[] getImageInfoFromMemory(byte[] bArr, int i3) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, i3, options);
            int i16 = desiredSize;
            int calculateInSampleSizeNew = calculateInSampleSizeNew(options, i16, i16, false);
            return new int[]{options.outWidth / calculateInSampleSizeNew, options.outHeight / calculateInSampleSizeNew, calculateInSampleSizeNew};
        } catch (Exception unused) {
            return null;
        }
    }

    private static byte[] loadImageFromFile(char[] cArr, int i3) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i3;
            Log.d(ZPlanApiImpl.FILAMENT_TAG, "loadImageFromFile: " + String.valueOf(cArr));
            Bitmap decodeFile = BitmapFactory.decodeFile(String.valueOf(cArr), options);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(decodeFile.getByteCount());
            decodeFile.copyPixelsToBuffer(allocateDirect);
            Log.d(ZPlanApiImpl.FILAMENT_TAG, "test for image load width: " + decodeFile.getWidth() + ", height:" + decodeFile.getHeight());
            decodeFile.recycle();
            return allocateDirect.array();
        } catch (Exception unused) {
            return null;
        }
    }

    private static byte[] loadImageFromMemory(byte[] bArr, int i3, int i16) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i16;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, i3, options);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(decodeByteArray.getByteCount());
            decodeByteArray.copyPixelsToBuffer(allocateDirect);
            Log.d(ZPlanApiImpl.FILAMENT_TAG, "test for image load width: " + decodeByteArray.getWidth() + ", height:" + decodeByteArray.getHeight());
            decodeByteArray.recycle();
            return allocateDirect.array();
        } catch (Exception unused) {
            return null;
        }
    }
}
