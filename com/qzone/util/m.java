package com.qzone.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import cooperation.qzone.util.QZLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes37.dex */
public class m {
    public static Bitmap b(String str, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (FileNotFoundException e16) {
            QZLog.w("ImageUtils", "decodeImg: ", e16);
            fileInputStream = null;
        }
        return d(fileInputStream, options);
    }

    private static Bitmap d(InputStream inputStream, BitmapFactory.Options options) {
        if (inputStream == null) {
            return null;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8096);
        try {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                try {
                    bufferedInputStream.close();
                } catch (IOException e16) {
                    QZLog.w("ImageUtils", "decodeImgWithStream: failed to close", e16);
                }
                return decodeStream;
            } catch (Throwable th5) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e17) {
                    QZLog.w("ImageUtils", "decodeImgWithStream: failed to close", e17);
                }
                throw th5;
            }
        } catch (OutOfMemoryError e18) {
            QZLog.w("ImageUtils", "decodeImgWithStream: failed to decode", e18);
            System.gc();
            try {
                bufferedInputStream.close();
            } catch (IOException e19) {
                QZLog.w("ImageUtils", "decodeImgWithStream: failed to close", e19);
            }
            return null;
        }
    }

    public static int[] f(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        b(str, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static Bitmap a(String str) {
        return b(str, null);
    }

    public static Bitmap e() {
        return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    }

    public static Bitmap c(String str) {
        Bitmap b16 = str != null ? b(str, null) : null;
        return b16 == null ? e() : b16;
    }
}
