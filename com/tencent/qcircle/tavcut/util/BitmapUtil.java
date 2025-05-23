package com.tencent.qcircle.tavcut.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BitmapUtil {
    public static final int BUFFER_SIZE_DECODE_BITMAP = 8192;
    public static final int BUFFER_SIZE_DECODE_BOUND = 2048;
    private static final String TAG = "BitmapUtil";

    public static Bitmap cropBitmap(String str, CropConfig cropConfig) {
        return cropBitmap(str, cropConfig, 1);
    }

    public static Bitmap decodeBitmap(String str, int i3) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i3;
            return BitmapFactory.decodeFile(str, options);
        } catch (Error e16) {
            Logger.e(e16);
            return null;
        } catch (Exception e17) {
            Logger.e(e17);
            return null;
        }
    }

    public static Bitmap decodeBitmapWithCrop(String str, CropConfig cropConfig) {
        int i3;
        try {
            if (!new File(str).exists()) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            decodeFileWithBuffer(str, options);
            options.inJustDecodeBounds = false;
            int max = Math.max(options.outWidth, options.outHeight);
            if (max > 2560) {
                i3 = (max / ExportOutput.VALUE_LEVEL_1440P_MAX_LENGTH) + 1;
            } else {
                i3 = 1;
            }
            if (i3 < 1) {
                i3 = 1;
            }
            String str2 = TAG;
            Logger.i(str2, "decodeBitmapWithCrop... samplesize = " + i3);
            options.inSampleSize = i3;
            options.inMutable = true;
            Bitmap retryOptionBitmap = retryOptionBitmap(options, str, true);
            if (retryOptionBitmap == null) {
                Logger.i(str2, "decodeBitmapWithCrop... bitmap is null");
                options.inSampleSize++;
                retryOptionBitmap = retryOptionBitmap(options, str);
            }
            if (retryOptionBitmap == null) {
                Logger.i(str2, "decodeBitmapWithCrop... bitmap == null");
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(retryOptionBitmap, (int) (retryOptionBitmap.getWidth() * cropConfig.getX()), (int) (retryOptionBitmap.getHeight() * cropConfig.getY()), (int) (retryOptionBitmap.getWidth() * cropConfig.getWidth()), (int) (retryOptionBitmap.getHeight() * cropConfig.getHeight()));
            int imageRotation = getImageRotation(str);
            if (imageRotation != 0) {
                Matrix matrix = new Matrix();
                matrix.setRotate(imageRotation);
                Bitmap retryMatrixBitmap = retryMatrixBitmap(createBitmap, createBitmap.getWidth(), createBitmap.getHeight(), matrix, false);
                if (retryMatrixBitmap != createBitmap && retryMatrixBitmap != null) {
                    return retryMatrixBitmap;
                }
                return createBitmap;
            }
            return createBitmap;
        } catch (Error e16) {
            Logger.e(e16);
            return null;
        } catch (Exception e17) {
            Logger.e(e17);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
    
        if (r1 == null) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeFileWithBuffer(String str, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        Bitmap decodeStream;
        FileInputStream fileInputStream2 = null;
        r0 = null;
        Bitmap bitmap = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception e16) {
            e = e16;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
        try {
            if (options != null) {
                try {
                    try {
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                    Logger.e(TAG, e.toString());
                }
                if (options.inJustDecodeBounds) {
                    decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(fileInputStream, 2048), null, options);
                    bitmap = decodeStream;
                    fileInputStream.close();
                }
            }
            fileInputStream.close();
        } catch (IOException unused2) {
            return bitmap;
        }
        decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(fileInputStream, 8192), null, options);
        bitmap = decodeStream;
    }

    public static Bitmap getBitmapWithSize(String str, int i3, int i16, boolean z16, boolean z17) {
        if (!new File(str).exists()) {
            return null;
        }
        int imageRotation = getImageRotation(str);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        decodeFileWithBuffer(str, options);
        options.inJustDecodeBounds = false;
        int min = Math.min(options.outWidth / i3, options.outHeight / i16);
        if (min < 1) {
            min = 1;
        }
        options.inSampleSize = min;
        Bitmap retryOptionBitmap = retryOptionBitmap(options, str, true);
        if (retryOptionBitmap == null) {
            options.inSampleSize++;
            retryOptionBitmap = retryOptionBitmap(options, str);
        }
        if (retryOptionBitmap == null) {
            return null;
        }
        int width = retryOptionBitmap.getWidth();
        int height = retryOptionBitmap.getHeight();
        float f16 = i3 / width;
        float f17 = i16 / height;
        if (f16 > 1.0f && f17 > 1.0f) {
            if (imageRotation == 0) {
                return retryOptionBitmap;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(imageRotation, retryOptionBitmap.getWidth() / 2.0f, retryOptionBitmap.getHeight() / 2.0f);
            return retryMatrixBitmap(retryOptionBitmap, width, height, matrix, true);
        }
        Matrix matrix2 = new Matrix();
        if (z16) {
            float min2 = Math.min(f16, f17);
            if (z17) {
                min2 = Math.max(f16, f17);
            }
            matrix2.postScale(min2, min2);
        } else {
            matrix2.postScale(f16, f17);
        }
        if (imageRotation != 0) {
            matrix2.postRotate(imageRotation, retryOptionBitmap.getWidth() / 2.0f, retryOptionBitmap.getHeight() / 2.0f);
        }
        return retryMatrixBitmap(retryOptionBitmap, width, height, matrix2, true);
    }

    public static int getImageRotation(String str) {
        int i3;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt != 8) {
                        return 0;
                    }
                    i3 = 270;
                } else {
                    i3 = 90;
                }
            } else {
                i3 = 180;
            }
            return i3;
        } catch (IOException e16) {
            Logger.e(e16);
            return 0;
        }
    }

    public static Size getImageSize(@NonNull String str) {
        return getImageSize(str, true);
    }

    public static boolean isValidBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            return true;
        }
        return false;
    }

    public static Bitmap retryMatrixBitmap(Bitmap bitmap, int i3, int i16, Matrix matrix, boolean z16) {
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, i3, i16, matrix, true);
        } catch (OutOfMemoryError e16) {
            Logger.e(TAG, "catch out of mem Matrix " + z16, e16);
            if (z16) {
                return retryMatrixBitmap(bitmap, i3, i16, matrix, false);
            }
            return null;
        }
    }

    private static Bitmap retryOptionBitmap(BitmapFactory.Options options, String str, boolean z16) {
        try {
            return decodeFileWithBuffer(str, options);
        } catch (OutOfMemoryError e16) {
            Logger.e(TAG, "catch out of mem Option " + z16, e16);
            if (z16) {
                return retryOptionBitmap(options, str, false);
            }
            return null;
        }
    }

    public static boolean saveBitmap(Bitmap bitmap, int i3, String str) {
        return saveBitmap(bitmap, Bitmap.CompressFormat.JPEG, i3, str, null);
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int i3) {
        try {
            if (!isValidBitmap(bitmap)) {
                return null;
            }
            int max = Math.max(bitmap.getWidth(), bitmap.getHeight());
            if (max > i3) {
                float f16 = (i3 * 1.0f) / max;
                Matrix matrix = new Matrix();
                matrix.postScale(f16, f16);
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            }
            return bitmap;
        } catch (Error e16) {
            Logger.e(e16);
            return null;
        } catch (Exception e17) {
            Logger.e(e17);
            return null;
        }
    }

    public static Bitmap cropBitmap(String str, @NonNull CropConfig cropConfig, int i3) {
        try {
            Bitmap decodeBitmap = decodeBitmap(str, i3);
            if (!isValidBitmap(decodeBitmap)) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap((int) (decodeBitmap.getWidth() * cropConfig.getWidth()), (int) (decodeBitmap.getHeight() * cropConfig.getHeight()), decodeBitmap.getConfig());
            new Canvas(createBitmap).drawBitmap(decodeBitmap, new Rect((int) (decodeBitmap.getWidth() * cropConfig.getX()), (int) (decodeBitmap.getHeight() * cropConfig.getY()), (int) (decodeBitmap.getWidth() * (cropConfig.getX() + cropConfig.getWidth())), (int) (decodeBitmap.getHeight() * (cropConfig.getY() + cropConfig.getHeight()))), new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight()), new Paint());
            return createBitmap;
        } catch (Error e16) {
            Logger.e(e16);
            return null;
        } catch (Exception e17) {
            Logger.e(e17);
            return null;
        }
    }

    public static Size getImageSize(@NonNull String str, boolean z16) {
        int imageRotation;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        Size size = new Size(options.outWidth, options.outHeight);
        if (z16 && ((imageRotation = getImageRotation(str)) == 90 || imageRotation == 270)) {
            size.setWidth(options.outHeight);
            size.setHeight(options.outWidth);
        }
        return size;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean saveBitmap(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i3, String str, ExifInterface exifInterface) {
        String attribute;
        if (!isValidBitmap(bitmap)) {
            Logger.e(TAG, "bitmap is invalid!");
            return false;
        }
        boolean z16 = true;
        FileOutputStream fileOutputStream = null;
        try {
        } catch (IOException e16) {
            Logger.e(e16);
        }
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
                try {
                    bitmap.compress(compressFormat, i3, fileOutputStream2);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e17) {
                    e = e17;
                    fileOutputStream = fileOutputStream2;
                    Logger.e(e);
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        if (exifInterface != null) {
                        }
                        return z16;
                    }
                    z16 = false;
                    if (exifInterface != null) {
                    }
                    return z16;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e18) {
                            Logger.e(e18);
                        }
                    }
                    throw th;
                }
            } catch (IOException e19) {
                e = e19;
            }
            if (exifInterface != null) {
                try {
                    ExifInterface exifInterface2 = new ExifInterface(str);
                    for (Field field : ExifInterface.class.getFields()) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith("TAG")) {
                            String obj = field.get(ExifInterface.class).toString();
                            if (!obj.equals("Orientation") && (attribute = exifInterface.getAttribute(obj)) != null) {
                                exifInterface2.setAttribute(obj, attribute);
                            }
                        }
                    }
                    exifInterface2.saveAttributes();
                } catch (Exception e26) {
                    Logger.e(e26);
                }
            }
            return z16;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static Bitmap retryOptionBitmap(BitmapFactory.Options options, String str) {
        Bitmap bitmap = null;
        int i3 = 0;
        while (true) {
            if (i3 > 0 && options.inSampleSize > 7) {
                return bitmap;
            }
            try {
                bitmap = decodeFileWithBuffer(str, options);
                Logger.i("QZoneUpload", "options.inSampleSize \uff1a " + options.inSampleSize);
                return bitmap;
            } catch (OutOfMemoryError e16) {
                Logger.e(TAG, "catch out of mem Option small options", e16);
                options.inSampleSize++;
                i3++;
            }
        }
    }
}
