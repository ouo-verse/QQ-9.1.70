package com.tencent.mobileqq.wink.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Size;
import androidx.annotation.Nullable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes21.dex */
public class f {
    public static int a(BitmapFactory.Options options, int i3, int i16) {
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        int i19 = 1;
        if (i3 > 0 && i16 > 0 && (i17 > i16 || i18 > i3)) {
            i19 = Math.min(Math.round(i17 / i16), Math.round(i18 / i3));
            while ((i18 * i17) / (i19 * i19) > i3 * i16 * 2) {
                i19++;
            }
        }
        return i19;
    }

    @Nullable
    public static String b(int i3, int i16, String str) {
        if (i3 > 0 && i16 > 0) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            File externalCacheDir = com.tencent.mobileqq.wink.b.c().getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = com.tencent.mobileqq.wink.b.c().getCacheDir();
            }
            File file = new File(externalCacheDir, str + "transparent_" + i3 + "_" + i16 + ".png");
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            createBitmap.eraseColor(0);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    createBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    String absolutePath = file.getAbsolutePath();
                    fileOutputStream.close();
                    return absolutePath;
                } finally {
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return null;
    }

    public static Bitmap c(String str) {
        return d(str, null);
    }

    public static Bitmap d(String str, BitmapFactory.Options options) {
        Bitmap decodeFile = SafeBitmapFactory.decodeFile(str, options);
        int k3 = k(str);
        if (k3 == 0) {
            return decodeFile;
        }
        try {
            return s(k3, decodeFile);
        } catch (Exception unused) {
            return decodeFile;
        }
    }

    public static Bitmap e(String str, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        Bitmap decodeStream;
        Bitmap bitmap = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception e16) {
            w53.b.d("BitmapUtils", "decodeFileWithBuffer failed", e16);
        }
        if (options != null) {
            try {
                if (options.inJustDecodeBounds) {
                    decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(fileInputStream, 2048), null, options);
                    bitmap = decodeStream;
                    fileInputStream.close();
                    return bitmap;
                }
            } finally {
            }
        }
        decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(fileInputStream, 8192), null, options);
        bitmap = decodeStream;
        fileInputStream.close();
        return bitmap;
    }

    public static Bitmap f(String str, int i3, int i16) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, i3, i16);
        options.inJustDecodeBounds = false;
        options.inPreferQualityOverSpeed = true;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception unused) {
            return null;
        } catch (OutOfMemoryError unused2) {
            options.inSampleSize *= 2;
            return BitmapFactory.decodeFile(str, options);
        }
    }

    public static Bitmap g(Resources resources, int i3) {
        if (resources == null || i3 <= 0) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(resources, i3, options);
            options.inJustDecodeBounds = false;
            options.inSampleSize = 1;
            return BitmapFactory.decodeResource(resources, i3, options);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public static Size h(String str) {
        return i(str, false);
    }

    public static Size i(String str, boolean z16) {
        int k3;
        if (!new File(str).exists()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        e(str, options);
        int i3 = options.outWidth;
        int i16 = options.outHeight;
        if (z16 && ((k3 = k(str)) == 90 || k3 == 270)) {
            i3 = i16;
            i16 = i3;
        }
        return new Size(i3, i16);
    }

    @Nullable
    public static Bitmap j(String str, int i3, int i16, boolean z16) {
        int i17;
        if (!new File(str).exists()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        e(str, options);
        options.inJustDecodeBounds = false;
        int i18 = options.outWidth;
        int i19 = options.outHeight;
        if (i18 > i19) {
            i17 = i3;
        } else {
            i17 = i16;
        }
        if (i19 < i18) {
            i3 = i16;
        }
        int min = Math.min(i18 / i17, i19 / i3);
        if (min < 1) {
            min = 1;
        }
        options.inSampleSize = min;
        Bitmap r16 = r(options, str, true);
        if (r16 == null) {
            options.inSampleSize++;
            r16 = q(options, str);
        }
        if (r16 == null) {
            return null;
        }
        if (z16) {
            int k3 = k(str);
            if (k3 == 0) {
                return r16;
            }
            Bitmap s16 = s(k3, r16);
            r16.recycle();
            return s16;
        }
        return r16;
    }

    public static int k(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt != 8) {
                        return 0;
                    }
                    return 270;
                }
                return 90;
            }
            return 180;
        } catch (Exception e16) {
            w53.b.d("BitmapUtils", "getPictureRotate failed", e16);
            return 0;
        }
    }

    public static boolean l(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        if (options.outHeight >= options.outWidth) {
            return true;
        }
        return false;
    }

    public static Bitmap m(Bitmap bitmap, float f16, float f17) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(f16 / width, f17 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static boolean n(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
            return true;
        }
        return false;
    }

    public static boolean o(String str, String str2, int i3) {
        int i16;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        if (options.outWidth <= i3 && options.outHeight <= i3) {
            return FileUtils.copyFile(str, str2);
        }
        Bitmap c16 = c(str);
        if (c16.getWidth() > c16.getHeight()) {
            i16 = (c16.getHeight() * i3) / c16.getWidth();
        } else {
            i16 = i3;
            i3 = (c16.getWidth() * i3) / c16.getHeight();
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(c16, i3, i16, true);
        File u16 = u(str2, createScaledBitmap, 90);
        if (!c16.isRecycled()) {
            c16.recycle();
        }
        if (createScaledBitmap != null && !createScaledBitmap.isRecycled()) {
            createScaledBitmap.recycle();
        }
        if (u16 != null) {
            return true;
        }
        return false;
    }

    public static boolean p(String str, String str2, int i3, int i16) {
        int i17;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        Bitmap c16 = c(str);
        if (c16 == null) {
            return false;
        }
        if (options.outWidth <= i3 && options.outHeight <= i3) {
            File u16 = u(str2, c16, i16);
            if (!c16.isRecycled()) {
                c16.recycle();
            }
            if (u16 != null) {
                return true;
            }
            return false;
        }
        if (c16.getWidth() > c16.getHeight()) {
            i17 = (c16.getHeight() * i3) / c16.getWidth();
        } else {
            i17 = i3;
            i3 = (c16.getWidth() * i3) / c16.getHeight();
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(c16, i3, i17, true);
        File u17 = u(str2, createScaledBitmap, i16);
        if (!c16.isRecycled()) {
            c16.recycle();
        }
        if (createScaledBitmap != null && !createScaledBitmap.isRecycled()) {
            createScaledBitmap.recycle();
        }
        if (u17 != null) {
            return true;
        }
        return false;
    }

    private static Bitmap q(BitmapFactory.Options options, String str) {
        int i3 = 0;
        while (true) {
            if (i3 > 0 && options.inSampleSize > 7) {
                return null;
            }
            try {
                return e(str, options);
            } catch (OutOfMemoryError unused) {
                options.inSampleSize++;
                i3++;
            }
        }
    }

    public static Bitmap r(BitmapFactory.Options options, String str, boolean z16) {
        try {
            return e(str, options);
        } catch (OutOfMemoryError unused) {
            if (z16) {
                return r(options, str, false);
            }
            return null;
        }
    }

    public static Bitmap s(int i3, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i3);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static File t(String str, Bitmap bitmap) {
        return u(str, bitmap, 100);
    }

    public static File u(String str, Bitmap bitmap, int i3) {
        return v(str, bitmap, Bitmap.CompressFormat.JPEG, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File v(String str, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i3) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
        } catch (IOException unused) {
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
        try {
            try {
                bitmap.compress(compressFormat, i3, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                return file;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            file.delete();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
            }
            return null;
        }
    }
}
