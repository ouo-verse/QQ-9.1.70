package com.tencent.component.media.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.DecodeImageTask;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.sharpP.SharpPUtils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

/* compiled from: P */
@Public
/* loaded from: classes5.dex */
public final class BitmapUtils {
    private static final int DEFAULT_QUALITY = 90;
    private static final String[] EXIF_TAGS = {"FNumber", "DateTime", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ISOSpeedRatings", "Make", "Model", "Orientation", "WhiteBalance"};
    public static final String TAG = "BitmapUtils";
    private static BitmapFactory.Options options;

    BitmapUtils() {
    }

    @TargetApi(11)
    public static void addInBitmapOptions(BitmapFactory.Options options2, Bitmap bitmap) {
        if (options2 == null) {
            return;
        }
        options2.inMutable = true;
        if (bitmap != null && canUseForInBitmap(bitmap, options2)) {
            options2.inBitmap = bitmap;
        }
    }

    private static boolean canUseForInBitmap(Bitmap bitmap, BitmapFactory.Options options2) {
        int i3;
        if (options2 == null || (i3 = options2.inSampleSize) < 1 || bitmap == null || (options2.outWidth / i3) * (options2.outHeight / i3) * getBytesPerPixel(bitmap.getConfig()) > bitmap.getAllocationByteCount()) {
            return false;
        }
        return true;
    }

    public static byte[] compressToBytes(Bitmap bitmap) {
        return compressToBytes(bitmap, 90, bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG);
    }

    public static void copyExif(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists() && file2.exists()) {
                if (SharpPUtils.isSharpP(file)) {
                    ImageManagerEnv.getLogger().w("BitmapUtils", "sharpP image do not support copy exif");
                    return;
                }
                try {
                    ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
                    ExifInterface exifInterface2 = new ExifInterface(file2.getAbsolutePath());
                    for (String str3 : EXIF_TAGS) {
                        String attribute = exifInterface.getAttribute(str3);
                        if (attribute != null) {
                            exifInterface2.setAttribute(str3, attribute);
                        }
                    }
                    exifInterface2.saveAttributes();
                    return;
                } catch (Throwable th5) {
                    ImageManagerEnv.getLogger().e("BitmapUtils", "copyExif failed: " + th5.getMessage());
                    return;
                }
            }
            ImageManagerEnv.getLogger().e("BitmapUtils", "copyExif: file not exits!");
            return;
        }
        ImageManagerEnv.getLogger().e("BitmapUtils", "copyExif: path is empty!");
    }

    public static BitmapReference drawableToBitmapByCanvas(Drawable drawable) {
        BitmapReference bitmapReference;
        try {
            bitmapReference = ImageManager.getInstance().getBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(bitmapReference.getBitmap());
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return bitmapReference;
            } catch (Throwable unused) {
                if (bitmapReference == null) {
                    return null;
                }
                try {
                    if (bitmapReference.isRecycled()) {
                        return null;
                    }
                    bitmapReference.release();
                    return null;
                } catch (Throwable unused2) {
                    return null;
                }
            }
        } catch (Throwable unused3) {
            bitmapReference = null;
        }
    }

    public static int getBitmapAllocSize(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap.getAllocationByteCount();
        }
        return 0;
    }

    public static int getBytesPerPixel(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            return 4;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        if (config == Bitmap.Config.ALPHA_8) {
            return 1;
        }
        ImageManagerEnv.getLogger().w("BitmapUtils", "getBytePerPixel config is error " + config);
        return 4;
    }

    public static BitmapFactory.Options getOptions() {
        return new BitmapFactory.Options();
    }

    public static BitmapReference processExif(BitmapReference bitmapReference, String str) {
        return processExif(bitmapReference, str, "");
    }

    public static int readOrientation(String str) {
        ExifInterface exifInterface;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e16) {
            ImageManagerLog.e("BitmapUtils", "readOrientation, IOException");
            e16.printStackTrace();
            exifInterface = null;
        }
        if (exifInterface == null) {
            return 0;
        }
        int attributeInt = exifInterface.getAttributeInt("Orientation", 0);
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
    }

    public static void resize(LruCache lruCache, float f16) {
        if (lruCache != null && f16 <= 1.0f && f16 >= 0.0f) {
            int maxSize = lruCache.maxSize();
            int i3 = (int) (maxSize * f16);
            if (i3 <= 0) {
                i3 = 1;
            }
            ImageManagerLog.i("BitmapUtils", "resize  oldMaxSize=" + maxSize + ",newMaxSize=" + i3 + ",ration=" + f16);
            lruCache.resize(i3);
        }
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i3) {
        Bitmap bitmap2;
        int i16 = i3 % 360;
        if (i16 == 0) {
            return bitmap;
        }
        boolean z16 = (i16 > 45 && i16 < 135) || (i16 > 225 && i16 < 315);
        int width = !z16 ? bitmap.getWidth() : bitmap.getHeight();
        int height = !z16 ? bitmap.getHeight() : bitmap.getWidth();
        try {
            bitmap2 = Bitmap.createBitmap(width, height, bitmap.getConfig());
        } catch (Throwable unused) {
            bitmap2 = null;
        }
        if (bitmap2 == null || bitmap2 == bitmap) {
            return bitmap;
        }
        Canvas canvas = new Canvas(bitmap2);
        int width2 = (width - bitmap.getWidth()) / 2;
        int height2 = (height - bitmap.getHeight()) / 2;
        if (width2 != 0 || height2 != 0) {
            canvas.translate(width2, height2);
        }
        canvas.rotate(i16, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        bitmap.recycle();
        return bitmap2;
    }

    public static void saveBitmapToFile(Bitmap bitmap, String str) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str)));
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e16) {
                        ImageManagerEnv.getLogger().e("BitmapUtils", "saveBitmapToFile exception" + e16.getMessage());
                    }
                } catch (Exception e17) {
                    e = e17;
                    bufferedOutputStream = bufferedOutputStream2;
                    ImageManagerEnv.getLogger().e("BitmapUtils", "saveBitmapToFile exception" + e.getMessage());
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e18) {
                            ImageManagerEnv.getLogger().e("BitmapUtils", "saveBitmapToFile exception" + e18.getMessage());
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e19) {
                            ImageManagerEnv.getLogger().e("BitmapUtils", "saveBitmapToFile exception" + e19.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e26) {
            e = e26;
        }
    }

    public static void setBitmapOptionInNativeAlloc(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("inNativeAlloc");
            declaredField.setAccessible(true);
            declaredField.setBoolean(obj, true);
        } catch (Throwable unused) {
        }
    }

    public static void trimToSize(LruCache lruCache, float f16) {
        if (lruCache != null && f16 <= 1.0f && f16 >= 0.0f) {
            int size = lruCache.size();
            int i3 = (int) (size * f16);
            ImageManagerLog.i("BitmapUtils", "trimToSize  oldSize=" + size + ",newSize=" + i3 + ",ration=" + f16);
            lruCache.trimToSize(i3);
        }
    }

    public static byte[] compressToBytes(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        return compressToBytes(bitmap, 90, compressFormat);
    }

    public static BitmapReference processExif(BitmapReference bitmapReference, String str, String str2) {
        int rotationDegree;
        if (bitmapReference == null || TextUtils.isEmpty(str)) {
            return bitmapReference;
        }
        Integer imagePath2Rotation = DecodeImageTask.getImagePath2Rotation(str);
        if (imagePath2Rotation == null) {
            try {
                if (!new File(str).exists()) {
                    return bitmapReference;
                }
            } catch (Throwable th5) {
                ImageManagerEnv.getLogger().e("BitmapUtils", Log.getStackTraceString(th5));
            }
            if (!TextUtils.isEmpty(str2) && MimeHelper.IMAGE_HEIF.equals(str2)) {
                rotationDegree = readOrientation(str);
            } else {
                rotationDegree = ImageManagerEnv.g().getRotationDegree(str);
            }
            DecodeImageTask.putImagePath2Rotation(str, rotationDegree);
        } else {
            rotationDegree = imagePath2Rotation.intValue();
        }
        return rotateBitmap(bitmapReference, rotationDegree);
    }

    public static byte[] compressToBytes(Bitmap bitmap, int i3, Bitmap.CompressFormat compressFormat) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(65536);
        bitmap.compress(compressFormat, i3, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void resize(LruCache lruCache, float f16, int i3) {
        if (lruCache != null && f16 <= 1.0f && f16 >= 0.0f) {
            int maxSize = lruCache.maxSize();
            int i16 = (int) (maxSize * f16);
            if (i16 < i3) {
                i16 = i3;
            }
            ImageManagerLog.i("BitmapUtils", "resize  oldMaxSize=" + maxSize + ",newMaxSize=" + i16 + ",ration=" + f16 + ", minCacheSize = " + i3);
            lruCache.resize(i16);
        }
    }

    public static void trimToSize(LruCache lruCache, float f16, int i3) {
        if (lruCache != null && f16 <= 1.0f && f16 >= 0.0f) {
            int size = lruCache.size();
            int i16 = (int) (size * f16);
            if (i16 >= i3) {
                i3 = i16;
            }
            ImageManagerLog.i("BitmapUtils", "trimToSize  oldSize=" + size + ",newSize=" + i3 + ",ration=" + f16);
            lruCache.trimToSize(i3);
        }
    }

    public static BitmapReference rotateBitmap(BitmapReference bitmapReference, int i3) {
        BitmapReference bitmapReference2;
        int i16 = i3 % 360;
        if (i16 == 0) {
            return bitmapReference;
        }
        boolean z16 = (i16 > 45 && i16 < 135) || (i16 > 225 && i16 < 315);
        int width = !z16 ? bitmapReference.getWidth() : bitmapReference.getHeight();
        int height = !z16 ? bitmapReference.getHeight() : bitmapReference.getWidth();
        try {
            bitmapReference2 = ImageManager.getInstance().getBitmap(width, height, bitmapReference.getConfig());
        } catch (Throwable unused) {
            bitmapReference2 = null;
        }
        if (bitmapReference2 == null || bitmapReference2 == bitmapReference) {
            return bitmapReference;
        }
        Canvas canvas = new Canvas(bitmapReference2.getBitmap());
        int width2 = (width - bitmapReference.getWidth()) / 2;
        int height2 = (height - bitmapReference.getHeight()) / 2;
        if (width2 != 0 || height2 != 0) {
            canvas.translate(width2, height2);
        }
        canvas.rotate(i16, bitmapReference.getWidth() / 2, bitmapReference.getHeight() / 2);
        canvas.drawBitmap(bitmapReference.getBitmap(), 0.0f, 0.0f, (Paint) null);
        bitmapReference.release();
        return bitmapReference2;
    }

    @Public
    @SuppressLint({"InlinedApi"})
    public static Bitmap processExif(Bitmap bitmap, String str) {
        if (bitmap == null || TextUtils.isEmpty(str)) {
            return bitmap;
        }
        try {
            if (!new File(str).exists()) {
                return bitmap;
            }
        } catch (Throwable th5) {
            ImageManagerEnv.getLogger().e("BitmapUtils", Log.getStackTraceString(th5));
        }
        return rotateBitmap(bitmap, ImageManagerEnv.g().getRotationDegree(str));
    }
}
