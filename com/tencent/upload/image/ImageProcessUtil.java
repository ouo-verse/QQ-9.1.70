package com.tencent.upload.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.utils.BitmapUtils;
import com.tencent.upload.utils.UploadLog;
import com.tencent.upload.utils.reflection.Reflect;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes27.dex */
public class ImageProcessUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ImageProcessUtil";

    public ImageProcessUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean bitmapToFile(Bitmap bitmap, String str, int i3, boolean z16, boolean z17, String str2) {
        Bitmap.CompressFormat compressFormat;
        boolean z18;
        StringBuilder sb5;
        boolean z19;
        BufferedOutputStream bufferedOutputStream;
        if (TextUtils.isEmpty(str)) {
            ImageProcessService.sMsg = "bitmapToFile=emptySavePath";
            UploadLog.w(TAG, "bitmapToFile=emptySavePath");
            ImageProcessService.MILESTONE.enable(1048576);
            return false;
        }
        File file = new File(str);
        File file2 = new File(file.getParent() + File.separator + System.currentTimeMillis() + "_" + bitmap.hashCode());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("bitmapToFile() tempFile:");
        sb6.append(file2.getAbsolutePath());
        UploadLog.w(TAG, sb6.toString());
        if (z16) {
            compressFormat = Bitmap.CompressFormat.PNG;
        } else {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        if (str2 != null && (str2.equalsIgnoreCase("image/jpeg") || str2.equalsIgnoreCase("image/webp"))) {
            z18 = true;
        } else {
            z18 = false;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        if (z18 && z17) {
            try {
                Object obj = Bitmap.CompressFormat.class.getField("WEBP").get(null);
                if (obj instanceof Bitmap.CompressFormat) {
                    compressFormat = (Bitmap.CompressFormat) obj;
                }
            } catch (Exception unused) {
            }
        }
        UploadLog.d(TAG, "compress start, compressFormat: " + compressFormat);
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    z19 = bitmap.compress(compressFormat, i3, bufferedOutputStream);
                    bufferedOutputStream.flush();
                } catch (Exception e16) {
                    e = e16;
                    bufferedOutputStream2 = bufferedOutputStream;
                    String str3 = "bitmapToFile compress=exception " + e.getMessage();
                    ImageProcessService.sMsg = str3;
                    UploadLog.w(TAG, str3);
                    ImageProcessService.MILESTONE.enable(2097152);
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Exception e17) {
                            e = e17;
                            sb5 = new StringBuilder();
                            sb5.append("bitmapToFile() close=exception ");
                            sb5.append(e.getMessage());
                            ImageProcessService.sMsg = sb5.toString();
                            UploadLog.w(TAG, ImageProcessService.sMsg);
                            ImageProcessService.MILESTONE.enable(4194304);
                            z19 = false;
                            UploadLog.d(TAG, "compress end");
                            if (!z19) {
                            }
                            return z19;
                        }
                    }
                    z19 = false;
                    UploadLog.d(TAG, "compress end");
                    if (!z19) {
                    }
                    return z19;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Exception e18) {
                            ImageProcessService.sMsg = "bitmapToFile() close=exception " + e18.getMessage();
                            UploadLog.w(TAG, ImageProcessService.sMsg);
                            ImageProcessService.MILESTONE.enable(4194304);
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
            }
            try {
                bufferedOutputStream.close();
            } catch (Exception e26) {
                e = e26;
                sb5 = new StringBuilder();
                sb5.append("bitmapToFile() close=exception ");
                sb5.append(e.getMessage());
                ImageProcessService.sMsg = sb5.toString();
                UploadLog.w(TAG, ImageProcessService.sMsg);
                ImageProcessService.MILESTONE.enable(4194304);
                z19 = false;
                UploadLog.d(TAG, "compress end");
                if (!z19) {
                }
                return z19;
            }
            UploadLog.d(TAG, "compress end");
            if (!z19) {
                if (!file2.renameTo(file)) {
                    file2.delete();
                    String str4 = "bitmapToFile(), fail rename to:" + file;
                    ImageProcessService.sMsg = str4;
                    UploadLog.w(TAG, str4);
                    ImageProcessService.MILESTONE.enable(16777216);
                    return false;
                }
            } else {
                file2.delete();
            }
            return z19;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static int calculateRotateDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 0);
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
        } catch (IOException e16) {
            ImageProcessService.MILESTONE.enable(2048);
            UploadLog.w(TAG, "calculateRotateDegree() EXIF_NULL " + e16.getMessage());
            return 0;
        }
    }

    public static String compressFile(String str, String str2, int i3, int i16, int i17, boolean z16, boolean z17, boolean z18) {
        int i18;
        boolean z19;
        Milestone milestone = ImageProcessService.MILESTONE;
        milestone.enable(1);
        BitmapFactory.Options decodeBitmapOptions = decodeBitmapOptions(str);
        boolean equalsIgnoreCase = "image/png".equalsIgnoreCase(decodeBitmapOptions.outMimeType);
        IUploadConfig.UploadImageSize uploadImageSize = new IUploadConfig.UploadImageSize(decodeBitmapOptions.outWidth, decodeBitmapOptions.outHeight, 100);
        int i19 = uploadImageSize.width;
        if (i19 != 0 && (i18 = uploadImageSize.height) != 0) {
            int min = Math.min(i19 / i3, i18 / i16);
            if (min < 1) {
                min = 1;
            }
            milestone.enable(4);
            BitmapFactory.Options options = BitmapUtils.getOptions();
            options.inSampleSize = min;
            UploadLog.v(TAG, "decodeFileWithRetry sampleSize=" + min);
            Bitmap decodeFileWithRetry = decodeFileWithRetry(str, options);
            if (decodeFileWithRetry == null) {
                milestone.enable(128);
                milestone.disableAll(8, 16, 32, 64);
                options.inSampleSize++;
                decodeFileWithRetry = decodeFileWithRetry(str, options);
                UploadLog.i(TAG, "re decodeFileWithRetry");
            }
            milestone.enable(256);
            if (decodeFileWithRetry == null) {
                ImageProcessService.sMsg = "decodeFileWithRetry=null";
                UploadLog.w(TAG, "decodeFileWithRetry=null");
                milestone.enable(512);
                return null;
            }
            int width = decodeFileWithRetry.getWidth();
            int height = decodeFileWithRetry.getHeight();
            float f16 = i3 / width;
            float f17 = i16 / height;
            if (f16 > 1.0f) {
                f16 = 1.0f;
            }
            if (f17 > 1.0f) {
                f17 = 1.0f;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(f16, f17);
            if (z16) {
                milestone.enable(1024);
                int calculateRotateDegree = calculateRotateDegree(str);
                if (calculateRotateDegree != 0) {
                    matrix.postRotate(calculateRotateDegree, i3 / 2, i16 / 2);
                    milestone.enable(4096);
                }
            }
            if (equalsIgnoreCase && isAlphaChanelOpen(str)) {
                z19 = true;
            } else {
                z19 = false;
            }
            Bitmap transformBitmap = transformBitmap(decodeFileWithRetry, width, height, matrix);
            milestone.enable(262144);
            if (transformBitmap == null) {
                milestone.enable(524288);
                transformBitmap = decodeFileWithRetry;
            }
            if (transformBitmap != decodeFileWithRetry) {
                decodeFileWithRetry.recycle();
            }
            UploadLog.v(TAG, "transformBitmap scaleWidth=" + f16 + " scaleHeight=" + f17);
            boolean bitmapToFile = bitmapToFile(transformBitmap, str2, i17, z19, z17, decodeBitmapOptions.outMimeType);
            transformBitmap.recycle();
            if (bitmapToFile) {
                milestone.enable(8388608);
                if (z18) {
                    copyAllExifNew(str, str2);
                } else {
                    copyAllExif(str, str2);
                }
                return str2;
            }
            ImageProcessService.sMsg = "bitmapToFile=false";
            UploadLog.w(TAG, "bitmapToFile=false");
            milestone.enable(16777216);
            return null;
        }
        milestone.enable(2);
        ImageProcessService.sMsg = "decodeBitmapSize=0";
        UploadLog.w(TAG, "decodeBitmapSize=0");
        return null;
    }

    public static void copyAllExif(String str, String str2) {
        try {
            ExifInterface exifInterface = new ExifInterface(str2);
            ExifInterface exifInterface2 = new ExifInterface(str);
            if (Build.VERSION.SDK_INT >= 24) {
                Reflect.on(exifInterface).set("mExifByteOrder", Reflect.on(exifInterface2).get("mExifByteOrder"));
            }
            boolean z16 = false;
            if (Reflect.on(exifInterface2).get("mAttributes").getClass().isArray()) {
                HashMap[] hashMapArr = (HashMap[]) Reflect.on(exifInterface2).get("mAttributes");
                Reflect.on(exifInterface).set("mAttributes", hashMapArr);
                exifInterface.setAttribute("Orientation", String.valueOf(0));
                int i3 = 0;
                while (true) {
                    if (i3 >= hashMapArr.length) {
                        break;
                    }
                    if (hashMapArr[i3].get("DateTime") != null) {
                        z16 = true;
                        break;
                    }
                    i3++;
                }
                if (!z16) {
                    exifInterface.setAttribute("DateTime", d.f247921x);
                }
            } else {
                HashMap hashMap = (HashMap) Reflect.on(exifInterface2).get("mAttributes");
                Reflect.on(exifInterface).set("mAttributes", hashMap);
                exifInterface.setAttribute("Orientation", String.valueOf(0));
                if (TextUtils.isEmpty((CharSequence) hashMap.get("DateTime"))) {
                    exifInterface.setAttribute("DateTime", d.f247921x);
                }
            }
            exifInterface.saveAttributes();
        } catch (Throwable th5) {
            UploadLog.e(TAG, "exif copy failed!!,e:" + Log.getStackTraceString(th5));
        }
    }

    public static void copyAllExifNew(String str, String str2) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            UploadLog.d(TAG, "save saveExif saveExifRet:" + BaseImageUtil.saveExif(new ExifInterface(str), new ExifInterface(str2)) + ",time:" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e16) {
            UploadLog.w(TAG, "save saveExif error:" + e16);
        }
    }

    public static BitmapFactory.Options decodeBitmapOptions(String str) {
        BufferedInputStream bufferedInputStream;
        BitmapFactory.Options options = BitmapUtils.getOptions();
        options.inJustDecodeBounds = true;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(str)), 8192);
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            BitmapFactory.decodeStream(bufferedInputStream, null, options);
            bufferedInputStream.close();
            bufferedInputStream.close();
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream2 = bufferedInputStream;
            try {
                UploadLog.e(TAG, "decodeBitmapOptions fail : ", th);
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                return options;
            } catch (Throwable th7) {
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                }
                throw th7;
            }
        }
        return options;
    }

    public static IUploadConfig.UploadImageSize decodeBitmapSize(String str) {
        BitmapFactory.Options decodeBitmapOptions = decodeBitmapOptions(str);
        return new IUploadConfig.UploadImageSize(decodeBitmapOptions.outWidth, decodeBitmapOptions.outHeight, 100);
    }

    public static Bitmap decodeFileWithRetry(String str, BitmapFactory.Options options) {
        Bitmap bitmap;
        ImageProcessService.MILESTONE.enable(8);
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError unused) {
            ImageProcessService.sMsg = "decodeFile=oom";
            UploadLog.w(TAG, ImageProcessService.sMsg);
            ImageProcessService.MILESTONE.enable(16);
            System.gc();
            System.gc();
            try {
                LockMethodProxy.sleep(1000L);
            } catch (InterruptedException e16) {
                UploadLog.e(TAG, "decodeFileWithRetry", e16);
            }
            try {
                bitmap = BitmapFactory.decodeFile(str, options);
                try {
                    ImageProcessService.MILESTONE.enable(32);
                    return bitmap;
                } catch (OutOfMemoryError unused2) {
                    ImageProcessService.sMsg = "decodeFile2=oom";
                    UploadLog.w(TAG, "decodeFile2=oom");
                    ImageProcessService.MILESTONE.enable(64);
                    System.gc();
                    System.gc();
                    try {
                        LockMethodProxy.sleep(1000L);
                        return bitmap;
                    } catch (InterruptedException e17) {
                        UploadLog.e(TAG, "decodeFileWithRetry", e17);
                        return bitmap;
                    }
                }
            } catch (OutOfMemoryError unused3) {
                bitmap = null;
            }
        }
    }

    public static boolean isAlphaChanelOpen(String str) {
        return new PNGReader().isTransparentPng(str);
    }

    public static Bitmap transformBitmap(Bitmap bitmap, int i3, int i16, Matrix matrix) {
        Bitmap bitmap2;
        Milestone milestone = ImageProcessService.MILESTONE;
        milestone.enable(8192);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, i3, i16, matrix, true);
        } catch (Throwable th5) {
            th = th5;
            bitmap2 = null;
        }
        try {
            milestone.enable(16384);
            return bitmap2;
        } catch (Throwable th6) {
            th = th6;
            String str = "createBitmap=oom" + th.toString();
            ImageProcessService.sMsg = str;
            UploadLog.w(TAG, str);
            Milestone milestone2 = ImageProcessService.MILESTONE;
            milestone2.enable(32768);
            System.gc();
            System.gc();
            try {
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, i3, i16, matrix, true);
                milestone2.enable(65536);
                return bitmap2;
            } catch (Throwable th7) {
                String str2 = "createBitmap2=oom" + th7.toString();
                ImageProcessService.sMsg = str2;
                UploadLog.w(TAG, str2);
                ImageProcessService.MILESTONE.enable(131072);
                System.gc();
                return bitmap2;
            }
        }
    }
}
