package com.tencent.oskplayer.support.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OskBitmap {
    public static final String TAG = "OskBitmap";

    public static int calculateInSampleSizeHigh(BitmapFactory.Options options, int i3, int i16) {
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        int i19 = 1;
        if (i17 > i16 || i18 > i3) {
            int i26 = i17 / 2;
            int i27 = i18 / 2;
            while (i26 / i19 >= i16 && i27 / i19 >= i3) {
                i19 *= 2;
            }
        }
        return i19;
    }

    public static int calculateInSampleSizeLow(BitmapFactory.Options options) {
        return calculateInSampleSizeLow(options, 720, 1280);
    }

    public static void printDebugPixelValue(Bitmap bitmap) {
        if (bitmap != null) {
            String str = "";
            int i3 = 0;
            String str2 = "";
            String str3 = str2;
            String str4 = str3;
            while (i3 < bitmap.getHeight()) {
                int i16 = 0;
                while (i16 < bitmap.getWidth()) {
                    int pixel = bitmap.getPixel(i16, i3);
                    int red = Color.red(pixel);
                    int blue = Color.blue(pixel);
                    int green = Color.green(pixel);
                    str2 = str2 + green + ",";
                    str3 = str3 + blue + ",";
                    str4 = str4 + Color.alpha(pixel) + ",";
                    i16++;
                    str = str + red + ",";
                }
                str2 = str2 + "\n";
                str3 = str3 + "\n";
                str4 = str4 + "\n";
                i3++;
                str = str + "\n";
            }
            Log.v(TAG, "S:\n" + bitmap.getWidth() + "*" + bitmap.getHeight());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("R:\n");
            sb5.append(str);
            Log.v(TAG, sb5.toString());
            Log.v(TAG, "G:\n" + str2);
            Log.v(TAG, "B:\n" + str3);
            Log.v(TAG, "A:\n" + str4);
            return;
        }
        Log.v(TAG, "invalid bitmap");
    }

    public static int calculateInSampleSizeLow(BitmapFactory.Options options, int i3, int i16) {
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        int i19 = 1;
        if (i17 > i16 || i18 > i3) {
            int i26 = i17 / 2;
            int i27 = i18 / 2;
            while (i26 / i19 > i16 / 2 && i27 / i19 > i3 / 2) {
                i19 *= 2;
            }
        }
        return i19;
    }
}
