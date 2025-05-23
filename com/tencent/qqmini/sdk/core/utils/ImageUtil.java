package com.tencent.qqmini.sdk.core.utils;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.tencent.component.media.image.ImageConsts;
import com.tencent.libra.util.ImageContentType;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class ImageUtil {
    public static final String ACCEPT = "Accept";
    public static final float BITMAP_QUALITY_COMPRESS_HEIGHT_BOUNDARY = 4000.0f;
    public static final float BITMAP_QUALITY_COMPRESS_WIDTH_BOUNDARY = 1440.0f;
    public static final int DEFAULT_FILE_BUFFER_SIZE = 8192;
    public static final String FILE_PHOTO_DIR = "photo";
    public static final String FILE_PHOTO_PATH = "photo/";
    public static final String FILE_THUMB2_DIR = "thumb2";
    public static final String FILE_THUMB2_PATH = "thumb2/";
    public static final String FILE_THUMB_DIR = "thumb";
    public static final String FILE_THUMB_PATH = "thumb/";
    public static final int SIZE_1KB = 1024;
    public static final String TAG = "ImageUtil";

    public static int calculateInSampleSize(BitmapFactory.Options options, float f16, float f17) {
        int i3 = 1;
        if (options == null) {
            return 1;
        }
        int i16 = options.outHeight;
        int i17 = options.outWidth;
        if (i16 > f17 || i17 > f16) {
            float f18 = i16 / 2;
            float f19 = i17 / 2;
            while (true) {
                float f26 = i3;
                if (f18 / f26 < f17 || f19 / f26 < f16) {
                    break;
                }
                i3 *= 2;
            }
        }
        return i3;
    }

    public static Bitmap compressBitmap(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        if (bitmap != null && compressFormat != null && Bitmap.CompressFormat.PNG != compressFormat) {
            float min = Math.min(1440.0f / bitmap.getWidth(), 4000.0f / bitmap.getHeight());
            int i3 = 100;
            if (min < 1.0f) {
                i3 = (int) (100 * min);
            }
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    bitmap.compress(compressFormat, i3, byteArrayOutputStream2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception unused) {
                    }
                    return decodeByteArray;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        QMLog.e("ImageUtil", "compressBitmap error! " + th);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        return bitmap;
                    } catch (Throwable th6) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th6;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } else {
            return bitmap;
        }
    }

    public static byte[] compressImage(Bitmap bitmap, int i3) {
        return compressImage(bitmap, i3, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r4 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (r4 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String compressImageJpg(String str, String str2, int i3, int i16, int i17) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        String str3 = null;
        try {
            File file = new File(str);
            BitmapFactory.Options sizeOpt = getSizeOpt(file, i3, i16);
            fileInputStream = new FileInputStream(file);
            try {
                str3 = compressJPGFile(fileInputStream, sizeOpt, str2, Math.min(100, i17));
            } catch (Error unused) {
            } catch (Exception unused2) {
            } catch (Throwable th5) {
                th = th5;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Error unused4) {
            fileInputStream = null;
        } catch (Exception unused5) {
            fileInputStream = null;
        } catch (Throwable th6) {
            th = th6;
        }
        try {
            fileInputStream.close();
        } catch (IOException unused6) {
            return str3;
        }
    }

    private static String compressJPGFile(InputStream inputStream, BitmapFactory.Options options, String str, int i3) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
        if (decodeStream == null) {
            return null;
        }
        if (QMLog.isColorLevel()) {
            QMLog.i("ImageUtil", "CompressJPGFile, destWidth = " + decodeStream.getWidth() + ", destHeight = " + decodeStream.getHeight());
        }
        try {
            fileOutputStream = new FileOutputStream(createNewFile(str));
            try {
                decodeStream.compress(Bitmap.CompressFormat.JPEG, Math.min(100, i3), fileOutputStream);
                try {
                    fileOutputStream.close();
                    return str;
                } catch (IOException unused) {
                    return str;
                }
            } catch (Exception unused2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            fileOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static File createNewFile(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        try {
            if (!file.exists()) {
                int lastIndexOf = str.lastIndexOf(47);
                if (lastIndexOf > 0 && lastIndexOf < str.length() - 1) {
                    File file2 = new File(str.substring(0, lastIndexOf));
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                }
            } else {
                file.delete();
            }
            file.createNewFile();
            return file;
        } catch (IOException unused) {
            return null;
        }
    }

    public static String cutAndSaveShareScreenshot(BaseRuntime baseRuntime, Activity activity, Bitmap bitmap) {
        int width;
        double height;
        if (activity != null) {
            width = activity.getResources().getDisplayMetrics().widthPixels;
            height = width;
        } else {
            width = (int) DeviceInfoUtil.getWidth();
            height = DeviceInfoUtil.getHeight();
        }
        Bitmap cutOutImg = cutOutImg(Bitmap.createBitmap(bitmap), width, (int) (height * 0.8d));
        byte[] compressImage = compressImage(cutOutImg, TextCell.FLAG_EMO_MASK);
        File file = new File(((MiniAppFileManager) baseRuntime.getManager(MiniAppFileManager.class)).getTmpPath("png"));
        boolean saveBitmapToFile = saveBitmapToFile(compressImage, file);
        if (cutOutImg != null && !cutOutImg.isRecycled()) {
            cutOutImg.recycle();
        }
        if (saveBitmapToFile) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static Bitmap cutOutImg(Bitmap bitmap, float f16, float f17) {
        int i3;
        int i16;
        if (bitmap == null) {
            return null;
        }
        try {
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            float f18 = f16 / width;
            float f19 = f17 / height;
            if (f18 > f19) {
                i3 = (int) f16;
                i16 = (int) (f18 * height);
            } else {
                i3 = (int) (f19 * width);
                i16 = (int) f17;
            }
            Matrix matrix = new Matrix();
            float f26 = i3;
            matrix.postScale(f26 / width, i16 / height);
            matrix.postTranslate((f16 - f26) / 2.0f, 0.0f);
            Bitmap createBitmap = Bitmap.createBitmap((int) f16, (int) f17, Bitmap.Config.ARGB_4444);
            new Canvas(createBitmap).drawBitmap(bitmap, matrix, null);
            return createBitmap;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public static void deletePic2SystemMedia(Context context, File file) {
        try {
            py3.b.e(context.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data='" + file.getAbsolutePath() + "'", null);
        } catch (Exception e16) {
            QMLog.e("ImageUtil", "deletePic2SystemMedia fail.", e16);
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        } else {
            createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Drawable getDrawable(Context context, String str, String str2) {
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        if (!TextUtils.isEmpty(str2)) {
            if (android.webkit.URLUtil.isNetworkUrl(str2)) {
                return miniAppProxy.getDrawable(context, str2, 0, 0, new ColorDrawable(0));
            }
            MiniAppFileManager miniAppFileManager = MiniAppFileManager.getMiniAppFileManager(str);
            if (miniAppFileManager != null) {
                return miniAppProxy.getDrawable(context, miniAppFileManager.getAbsolutePath(str2), 0, 0, new ColorDrawable(0));
            }
            return null;
        }
        return null;
    }

    public static int getExifOrientation(String str) {
        ExifInterface exifInterface;
        int attributeInt;
        if (isPngFile(str)) {
            return 0;
        }
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException unused) {
            exifInterface = null;
        }
        if (exifInterface == null || (attributeInt = exifInterface.getAttributeInt("Orientation", -1)) == -1) {
            return 0;
        }
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

    public static String getHttpImgmimeType(String str) {
        if (!str.toLowerCase().startsWith("http://") && !str.toLowerCase().startsWith("https:")) {
            return null;
        }
        return getMimeType(str);
    }

    public static Bitmap getLocalBitmap(String str) {
        FileInputStream fileInputStream;
        Throwable th5;
        BufferedInputStream bufferedInputStream;
        Bitmap bitmap = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream, 8192);
            } catch (FileNotFoundException unused) {
                bufferedInputStream = null;
            } catch (OutOfMemoryError unused2) {
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th5 = th6;
                bufferedInputStream = null;
            }
        } catch (FileNotFoundException unused3) {
            bufferedInputStream = null;
            fileInputStream = null;
        } catch (OutOfMemoryError unused4) {
            bufferedInputStream = null;
            fileInputStream = null;
        } catch (Throwable th7) {
            fileInputStream = null;
            th5 = th7;
            bufferedInputStream = null;
        }
        try {
            bitmap = BitmapFactory.decodeStream(bufferedInputStream);
            fileInputStream.close();
            bufferedInputStream.close();
        } catch (FileNotFoundException unused5) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return bitmap;
        } catch (OutOfMemoryError unused6) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return bitmap;
        } catch (Throwable th8) {
            th5 = th8;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                    throw th5;
                }
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th5;
        }
        return bitmap;
    }

    public static Bitmap getLocalBitmapwithHW(String str, int i3, int i16) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i17 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i18 = options.outWidth;
        int i19 = options.outHeight;
        if (i19 < i16 || i18 < i3) {
            return null;
        }
        options.inJustDecodeBounds = false;
        int i26 = 1;
        while (i19 / i26 > i16) {
            i26++;
        }
        while (i18 / i17 > i3) {
            i17++;
        }
        if (i17 < i26) {
            i26 = i17;
        }
        options.inSampleSize = i26;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        ThumbnailUtils.extractThumbnail(decodeFile, i3, i16);
        return decodeFile;
    }

    public static Bitmap getLocalCompressedBitmap(String str, BitmapFactory.Options options) {
        Bitmap compressBitmap;
        if (StringUtil.isEmpty(str) || options == null) {
            return null;
        }
        try {
            if (isPngFile(str)) {
                options.inPreferredConfig = Bitmap.Config.ARGB_4444;
            } else {
                options.inPreferredConfig = Bitmap.Config.RGB_565;
            }
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (isJpgFile(str)) {
                compressBitmap = compressBitmap(decodeFile, Bitmap.CompressFormat.JPEG);
            } else if (isWebpFile(str)) {
                compressBitmap = compressBitmap(decodeFile, Bitmap.CompressFormat.WEBP);
            } else {
                return decodeFile;
            }
            return compressBitmap;
        } catch (Throwable th5) {
            QMLog.e("ImageUtil", "getLocalBitmap error! " + th5);
            return null;
        }
    }

    public static InputStream getLocalImageStream(String str, boolean z16) {
        Bitmap.CompressFormat compressFormat;
        Bitmap.CompressFormat compressFormat2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int exifOrientation = getExifOrientation(str);
        int i3 = 1;
        for (int max = Math.max(options.outWidth, options.outHeight); max > 4000; max /= 2) {
            i3 *= 2;
        }
        if (i3 > 1) {
            QMLog.w("ImageUtil", "getLocalImageStream: start to crop image");
            options.inJustDecodeBounds = false;
            options.inSampleSize = i3;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile != null) {
                if (exifOrientation != 0) {
                    try {
                        decodeFile = rotaingImageView(exifOrientation, decodeFile);
                    } catch (Exception unused) {
                        QMLog.w("ImageUtil", "getLocalImageStream: failed to rotate bitmap");
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (z16) {
                    compressFormat2 = Bitmap.CompressFormat.PNG;
                } else {
                    compressFormat2 = Bitmap.CompressFormat.JPEG;
                }
                if (decodeFile.compress(compressFormat2, 80, byteArrayOutputStream)) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    decodeFile.recycle();
                    return new ByteArrayInputStream(byteArray);
                }
                decodeFile.recycle();
            }
            QMLog.e("ImageUtil", "getLocalImageStream: failed to compress bitmap");
        }
        if (i3 == 1 && exifOrientation != 0) {
            try {
                Bitmap rotaingImageView = rotaingImageView(exifOrientation, BitmapFactory.decodeFile(str, null));
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                if (z16) {
                    compressFormat = Bitmap.CompressFormat.PNG;
                } else {
                    compressFormat = Bitmap.CompressFormat.JPEG;
                }
                if (rotaingImageView.compress(compressFormat, 100, byteArrayOutputStream2)) {
                    byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                    rotaingImageView.recycle();
                    return new ByteArrayInputStream(byteArray2);
                }
                rotaingImageView.recycle();
            } catch (FileNotFoundException e16) {
                QMLog.e("ImageUtil", "getLocalImageStream: failed to read file", e16);
                return null;
            }
        }
        return new BufferedInputStream(new FileInputStream(str));
    }

    public static InputStream getLocalImageStreamWithCache(String str, String str2, boolean z16) {
        InputStream localNoBitmapImageStream;
        e eVar = e.f348080c;
        if (eVar.has(str)) {
            QMLog.i("ImageUtil", "getLocalImageStreamWithCache \u7f13\u5b58\u5b58\u5728\uff0cpath:" + str);
            return eVar.get(str).e();
        }
        QMLog.i("ImageUtil", "getLocalImageStreamWithCache \u7f13\u5b58\u4e0d\u5b58\u5728\uff0cpath:" + str);
        if (z16) {
            localNoBitmapImageStream = getLocalImageStream(str, isPngFile(str));
        } else {
            localNoBitmapImageStream = getLocalNoBitmapImageStream(str);
        }
        if (localNoBitmapImageStream == null) {
            return null;
        }
        return eVar.c(str, localNoBitmapImageStream, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0087 A[Catch: IOException -> 0x008b, TRY_ENTER, TryCatch #5 {IOException -> 0x008b, blocks: (B:40:0x0070, B:42:0x0075, B:44:0x007a, B:31:0x0087, B:33:0x008f, B:35:0x0094), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008f A[Catch: IOException -> 0x008b, TryCatch #5 {IOException -> 0x008b, blocks: (B:40:0x0070, B:42:0x0075, B:44:0x007a, B:31:0x0087, B:33:0x008f, B:35:0x0094), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094 A[Catch: IOException -> 0x008b, TRY_LEAVE, TryCatch #5 {IOException -> 0x008b, blocks: (B:40:0x0070, B:42:0x0075, B:44:0x007a, B:31:0x0087, B:33:0x008f, B:35:0x0094), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070 A[Catch: IOException -> 0x008b, TRY_ENTER, TryCatch #5 {IOException -> 0x008b, blocks: (B:40:0x0070, B:42:0x0075, B:44:0x007a, B:31:0x0087, B:33:0x008f, B:35:0x0094), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075 A[Catch: IOException -> 0x008b, TryCatch #5 {IOException -> 0x008b, blocks: (B:40:0x0070, B:42:0x0075, B:44:0x007a, B:31:0x0087, B:33:0x008f, B:35:0x0094), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a A[Catch: IOException -> 0x008b, TRY_LEAVE, TryCatch #5 {IOException -> 0x008b, blocks: (B:40:0x0070, B:42:0x0075, B:44:0x007a, B:31:0x0087, B:33:0x008f, B:35:0x0094), top: B:2:0x000a }] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ByteArrayInputStream getLocalNoBitmapImageStream(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ?? file = new File(str);
        ?? exists = file.exists();
        try {
            try {
                if (exists == 0) {
                    return null;
                }
                try {
                    exists = new FileInputStream((File) file);
                    try {
                        file = new BufferedInputStream(exists, 8192);
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        file = 0;
                        exists = exists;
                        byteArrayOutputStream2 = file;
                        e.printStackTrace();
                        if (byteArrayOutputStream2 != null) {
                        }
                        if (file != 0) {
                        }
                        if (exists != 0) {
                        }
                        return null;
                    } catch (IOException e17) {
                        e = e17;
                        file = 0;
                        exists = exists;
                        byteArrayOutputStream2 = file;
                        e.printStackTrace();
                        if (byteArrayOutputStream2 != null) {
                        }
                        if (file != 0) {
                        }
                        if (exists != 0) {
                        }
                        return null;
                    } catch (Throwable th5) {
                        byteArrayOutputStream = null;
                        th = th5;
                        file = 0;
                    }
                    try {
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                    } catch (FileNotFoundException e18) {
                        e = e18;
                        byteArrayOutputStream2 = null;
                    } catch (IOException e19) {
                        e = e19;
                        byteArrayOutputStream2 = null;
                    } catch (Throwable th6) {
                        byteArrayOutputStream = null;
                        th = th6;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                                throw th;
                            }
                        }
                        if (file != 0) {
                            file.close();
                        }
                        if (exists != 0) {
                            exists.close();
                        }
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = file.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        }
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream2.toByteArray());
                        try {
                            byteArrayOutputStream2.close();
                            file.close();
                            exists.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                        }
                        return byteArrayInputStream;
                    } catch (FileNotFoundException e28) {
                        e = e28;
                        e.printStackTrace();
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        if (file != 0) {
                            file.close();
                        }
                        if (exists != 0) {
                            exists.close();
                        }
                        return null;
                    } catch (IOException e29) {
                        e = e29;
                        e.printStackTrace();
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        if (file != 0) {
                            file.close();
                        }
                        if (exists != 0) {
                            exists.close();
                        }
                        return null;
                    }
                } catch (FileNotFoundException e36) {
                    e = e36;
                    exists = 0;
                    file = 0;
                } catch (IOException e37) {
                    e = e37;
                    exists = 0;
                    file = 0;
                } catch (Throwable th7) {
                    file = 0;
                    byteArrayOutputStream = null;
                    th = th7;
                    exists = 0;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (IOException e38) {
            e38.printStackTrace();
        }
    }

    public static String getMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (isJpgFile(str)) {
            return ImageContentType.MIME_TYPE_JPG;
        }
        if (isPngFile(str)) {
            return "image/png";
        }
        if (str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
            return "image/gif";
        }
        if (!str.endsWith(".svg")) {
            return null;
        }
        return "image/svg+xml";
    }

    public static double getOptRatio(InputStream inputStream, int i3, int i16) {
        double d16;
        double d17;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        int i17 = options.outWidth;
        int i18 = options.outHeight;
        if (i17 <= i3 && i18 <= i16) {
            return 1.0d;
        }
        if (i17 > i18) {
            d16 = i17 / i3;
            d17 = i18 / i16;
        } else {
            double d18 = i17 / i16;
            d16 = i18 / i3;
            d17 = d18;
        }
        if (d16 <= d17) {
            return d17;
        }
        return d16;
    }

    public static BitmapFactory.Options getSizeOpt(File file, int i3, int i16) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        FileInputStream fileInputStream = new FileInputStream(file);
        double optRatio = getOptRatio(fileInputStream, i3, i16);
        fileInputStream.close();
        options.inSampleSize = (int) optRatio;
        options.inJustDecodeBounds = true;
        FileInputStream fileInputStream2 = new FileInputStream(file);
        BitmapFactory.decodeStream(fileInputStream2, null, options);
        fileInputStream2.close();
        int i17 = 0;
        while (options.outWidth > i3) {
            options.inSampleSize++;
            FileInputStream fileInputStream3 = new FileInputStream(file);
            BitmapFactory.decodeStream(fileInputStream3, null, options);
            fileInputStream3.close();
            if (i17 > 3) {
                break;
            }
            i17++;
        }
        options.inJustDecodeBounds = false;
        return options;
    }

    public static String getType(BitmapFactory.Options options) {
        String str = options.outMimeType;
        if (str == null) {
            return "unknown";
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.indexOf("jpg") >= 0) {
            return "jpg";
        }
        if (lowerCase.indexOf(MimeHelper.IMAGE_SUBTYPE_JPEG) >= 0) {
            return MimeHelper.IMAGE_SUBTYPE_JPEG;
        }
        if (lowerCase.indexOf("png") >= 0) {
            return "png";
        }
        if (lowerCase.indexOf("gif") >= 0) {
            return "gif";
        }
        if (lowerCase.indexOf("webp") < 0) {
            return "unknown";
        }
        return "webp";
    }

    public static boolean isHttpImgRequest(String str, Map<String, String> map) {
        String str2;
        if (str != null) {
            if ((str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith("https:")) && map != null && map.containsKey("Accept") && (str2 = map.get("Accept")) != null) {
                if (str2.contains("image/apng") || str2.contains(ImageConsts.IMAGE_TYPE_SHARPP) || str2.contains("image/tpg") || str2.contains("image/svg+xml") || str2.contains("image/avif") || str2.contains("image/webp") || str2.contains("image/gif") || str2.contains(ImageContentType.MIME_TYPE_JPG) || str2.contains("image/png")) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean isJpgFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.endsWith("jpg") && !str.endsWith(MimeHelper.IMAGE_SUBTYPE_JPEG) && !str.endsWith("JPG") && !str.endsWith("JPEG")) {
            return false;
        }
        return true;
    }

    public static boolean isPngFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.endsWith("png") && !str.endsWith("PNG")) {
            return false;
        }
        return true;
    }

    public static boolean isWebpFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.endsWith("webp") && !str.endsWith("WEBP")) {
            return false;
        }
        return true;
    }

    public static Bitmap rotaingImageView(int i3, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i3);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void saveBitmapToFile(Bitmap bitmap, File file) throws IOException {
        if (bitmap == null || file == null) {
            return;
        }
        File file2 = new File(file.getParent());
        if (!file2.exists() || !file2.isDirectory()) {
            file2.mkdirs();
        }
        if (!file.exists() || !file.isFile()) {
            file.createNewFile();
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    bufferedOutputStream2.close();
                } catch (IOException e16) {
                    e = e16;
                    bufferedOutputStream = bufferedOutputStream2;
                    QMLog.e("ImageUtil", "failed when compressing bitmap to file with IOException.", e);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    QMLog.e("ImageUtil", "failed when compressing bitmap to file with unexpected exception: ", th);
                    if (bufferedOutputStream != null) {
                    }
                }
            } catch (IOException e17) {
                e = e17;
            } catch (Throwable th6) {
                th = th6;
            }
        } finally {
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
        }
    }

    public static void savePic2SystemMedia(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(absolutePath, options);
        String str = options.outMimeType;
        ContentValues contentValues = new ContentValues(7);
        contentValues.put("title", file.getName());
        contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, file.getName());
        contentValues.put("date_modified", Long.valueOf(file.lastModified() / 1000));
        contentValues.put(JobDbManager.COL_UP_MIME_TYPE, str);
        contentValues.put("_data", absolutePath);
        contentValues.put("_size", Long.valueOf(file.length()));
        try {
            if (context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues) == null) {
                MediaStore.Images.Media.insertImage(context.getContentResolver(), absolutePath, file.getName(), (String) null);
            }
        } catch (Exception e16) {
            QMLog.e("ImageUtil", "savePic2SystemMedia fail.", e16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        r0.inSampleSize = r3 * 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BitmapFactory.Options scaleBitmap(String str, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i16 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        int i19 = 1;
        while (true) {
            if (i17 <= i3 || i18 <= i3) {
                break;
            }
            float f16 = i3;
            if (Math.min(Math.round(i17 / f16), Math.round(i18 / f16)) >= 2) {
                i18 /= 2;
                i17 /= 2;
                if (i18 < i3 || i17 < i3) {
                    break;
                }
                if (i18 == i3 || i17 == i3) {
                    break;
                }
                i19 *= 2;
            } else {
                options.inSampleSize = i19;
                break;
            }
        }
        options.inSampleSize = i19;
        options.inJustDecodeBounds = false;
        int i26 = options.inSampleSize;
        if (i26 >= 1) {
            i16 = i26;
        }
        options.inSampleSize = i16;
        return options;
    }

    public static byte[] compressImage(Bitmap bitmap, int i3, boolean z16) {
        if (bitmap == null || i3 < 1) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i16 = 100;
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        while (i16 > 70 && byteArray.length / 1024 > i3) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.PNG, i16, byteArrayOutputStream);
            i16 -= 5;
            byteArray = byteArrayOutputStream.toByteArray();
        }
        if (z16) {
            bitmap.recycle();
        }
        return byteArray;
    }

    public static boolean saveBitmapToFile(byte[] bArr, File file) {
        if (bArr == null || bArr.length < 1 || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file2 = new File(file.getParent());
                if (!file2.exists() || !file2.isDirectory()) {
                    file2.mkdirs();
                }
                if (!file.exists() || !file.isFile()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    return true;
                } catch (IOException e17) {
                    e = e17;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
