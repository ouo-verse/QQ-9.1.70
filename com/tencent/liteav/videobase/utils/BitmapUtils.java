package com.tencent.liteav.videobase.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class BitmapUtils {
    public static Bitmap createBitmap(Bitmap bitmap, Matrix matrix, boolean z16) {
        if (bitmap == null) {
            return null;
        }
        bitmap.getConfig();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        try {
            if (z16) {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                new Canvas(createBitmap).drawBitmap(bitmap, matrix, paint);
                return createBitmap;
            }
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th5) {
            LiteavLog.e("BitmapUtils", "build bitmap failed.", th5);
            return null;
        }
    }

    public static Bitmap createBitmapFromBuffer(ByteBuffer byteBuffer, int i3, int i16) {
        try {
            byteBuffer.position(0);
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(byteBuffer);
            return createBitmap;
        } catch (Throwable th5) {
            LiteavLog.e("BitmapUtils", "build bitmap failed.", th5);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Bitmap createBitmapFromFile(String str, int i3, int i16) {
        int i17;
        try {
            int i18 = 1;
            int i19 = 0;
            switch (new ExifInterface(str).getAttributeInt("Orientation", 1)) {
                case 1:
                    i18 = 0;
                    i17 = i19;
                    i19 = i18;
                    break;
                case 2:
                    i17 = i19;
                    i19 = i18;
                    break;
                case 3:
                    i18 = 0;
                    i19 = 180;
                    i17 = i19;
                    i19 = i18;
                    break;
                case 4:
                    i19 = 180;
                    i17 = i19;
                    i19 = i18;
                    break;
                case 5:
                    i19 = 270;
                    i17 = i19;
                    i19 = i18;
                    break;
                case 6:
                    i18 = 0;
                    i19 = 90;
                    i17 = i19;
                    i19 = i18;
                    break;
                case 7:
                    i19 = 90;
                    i17 = i19;
                    i19 = i18;
                    break;
                case 8:
                    i18 = 0;
                    i19 = 270;
                    i17 = i19;
                    i19 = i18;
                    break;
                default:
                    i17 = 0;
                    break;
            }
            Matrix matrix = new Matrix();
            if (i19 != 0) {
                matrix.postScale(-1.0f, 1.0f);
            }
            if (i17 != 0) {
                matrix.postRotate(i17);
            }
            Bitmap loadBitmapFile = loadBitmapFile(str, i3, i16, i17);
            return Bitmap.createBitmap(loadBitmapFile, 0, 0, loadBitmapFile.getWidth(), loadBitmapFile.getHeight(), matrix, true);
        } catch (Throwable th5) {
            LiteavLog.e("BitmapUtils", "build bitmap failed, path: ".concat(String.valueOf(str)), th5);
            return null;
        }
    }

    private static Bitmap loadBitmapFile(String str, int i3, int i16, int i17) throws Throwable {
        boolean z16;
        int i18;
        int i19;
        if (i3 > 0 && i16 > 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i26 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (i17 != 90 && i17 != 270) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                i18 = options.outHeight;
            } else {
                i18 = options.outWidth;
            }
            if (z16) {
                i19 = options.outWidth;
            } else {
                i19 = options.outHeight;
            }
            if (i18 > i3 || i19 > i16) {
                int i27 = i18 / ((i3 / 2) + 1);
                int i28 = i19 / ((i16 / 2) + 1);
                if (i28 > i27) {
                    i26 = i27;
                } else {
                    i26 = i28;
                }
            }
            options.inSampleSize = i26;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        }
        return BitmapFactory.decodeFile(str);
    }

    public static void saveBitmapToFile(Bitmap bitmap, String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                    fileOutputStream2.flush();
                    com.tencent.liteav.base.util.e.a(fileOutputStream2);
                } catch (Exception e16) {
                    e = e16;
                    fileOutputStream = fileOutputStream2;
                    LiteavLog.e("BitmapUtils", "save jpg file failed.", e);
                    com.tencent.liteav.base.util.e.a(fileOutputStream);
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    com.tencent.liteav.base.util.e.a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }
}
