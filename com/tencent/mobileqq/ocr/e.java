package com.tencent.mobileqq.ocr;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqcamera.api.ICameraUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.o;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f254755a;

    /* renamed from: b, reason: collision with root package name */
    public static String f254756b;

    /* renamed from: c, reason: collision with root package name */
    public static String f254757c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f254758d;

    static {
        boolean z16;
        String path;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18037);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f254758d = true;
        if (BaseApplication.getContext().getExternalFilesDir(null) != null && BaseApplication.getContext().getExternalCacheDir() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            path = BaseApplication.getContext().getExternalFilesDir(null).getPath();
        } else {
            path = BaseApplication.getContext().getFilesDir().getPath();
        }
        File file = new File(path, "ocr");
        f254755a = file.getAbsolutePath();
        if (!file.exists() && !file.mkdir()) {
            f254758d = false;
            QLog.d("Q.ocr.image", 1, "WTF! mk ocr dir failed!");
        }
        if (file.exists()) {
            File file2 = new File(f254755a, "preview");
            f254756b = file2.getAbsolutePath();
            if (!file2.exists() && !file2.mkdir()) {
                QLog.d("Q.ocr.image", 1, "WTF! mk ocr preview dir failed!");
            }
        }
        if (file.exists()) {
            File file3 = new File(f254755a, "cache");
            f254757c = file3.getAbsolutePath();
            if (!file3.exists() && !file3.mkdir()) {
                QLog.d("Q.ocr.image", 1, "mkdir cache dir failed!");
            }
        }
    }

    public static boolean a(String str) {
        String imageMimeType = o.getImageMimeType(str);
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.image", 2, "checkImageFormat format:" + imageMimeType);
        }
        if (TextUtils.isEmpty(imageMimeType) && !MimeHelper.IMAGE_BMP.equalsIgnoreCase(imageMimeType) && !"image/jpeg".equalsIgnoreCase(imageMimeType) && !"image/png".equalsIgnoreCase(imageMimeType)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(String str, String str2) {
        int i3;
        int i16;
        float f16;
        float f17;
        Bitmap c16;
        if (TextUtils.isEmpty(str2)) {
            QLog.d("Q.ocr.image", 1, "compressImage, newImagePath is empty");
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        if (com.tencent.mobileqq.ocr.data.b.a() != null) {
            i3 = 400;
            if (com.tencent.mobileqq.ocr.data.b.a().f254748d >= 400) {
                i3 = com.tencent.mobileqq.ocr.data.b.a().f254748d;
            }
            i16 = 10;
            if (com.tencent.mobileqq.ocr.data.b.a().f254747c >= 10) {
                i16 = com.tencent.mobileqq.ocr.data.b.a().f254747c;
            }
        } else {
            i3 = 800;
            i16 = 70;
        }
        float f18 = 1.0f;
        if (i18 > i17 && i17 > i3) {
            f16 = i3 * 1.0f;
            f17 = i17;
        } else {
            if (i18 < i17 && i18 > i3) {
                f16 = i3 * 1.0f;
                f17 = i18;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.ocr.image", 2, "compressImage radio:" + f18 + ",source file size:" + new File(str).length() + ",shortSide:" + i3 + ",picQuality:" + i16);
            }
            int i19 = (int) (i17 * f18);
            int i26 = (int) (i18 * f18);
            Matrix matrix = new Matrix();
            matrix.setScale(f18, f18);
            options.inJustDecodeBounds = false;
            c16 = c(str, options, 1, 2);
            if (c16 != null) {
                if (c16.getHeight() > i19 || c16.getWidth() > i26) {
                    try {
                        Bitmap createBitmap = Bitmap.createBitmap(c16, 0, 0, c16.getWidth(), c16.getHeight(), matrix, false);
                        if (!c16.isRecycled()) {
                            c16.recycle();
                        }
                        c16 = createBitmap;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    } catch (OutOfMemoryError e17) {
                        e17.printStackTrace();
                    }
                }
                if (c16 != null) {
                    int rowBytes = c16.getRowBytes() * c16.getHeight();
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.ocr.image", 2, "compressImage target bmp size:" + (rowBytes / 1024) + "KB");
                    }
                    return k(c16, str2, Bitmap.CompressFormat.JPEG, i16, true);
                }
            }
            return false;
        }
        f18 = f16 / f17;
        if (QLog.isColorLevel()) {
        }
        int i192 = (int) (i17 * f18);
        int i262 = (int) (i18 * f18);
        Matrix matrix2 = new Matrix();
        matrix2.setScale(f18, f18);
        options.inJustDecodeBounds = false;
        c16 = c(str, options, 1, 2);
        if (c16 != null) {
        }
        return false;
    }

    public static Bitmap c(String str, BitmapFactory.Options options, int i3, int i16) {
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError unused) {
            if (i3 < i16) {
                options.inSampleSize++;
                return c(str, options, i3 + 1, i16);
            }
            return null;
        }
    }

    public static String d(String str) {
        String str2;
        try {
            String name = new File(str).getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > -1 && lastIndexOf < name.length()) {
                name = name.substring(0, lastIndexOf);
            }
            str2 = new File(f254757c, name + "_" + System.currentTimeMillis() + ".tmp").getAbsolutePath();
        } catch (Exception e16) {
            e16.printStackTrace();
            str2 = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.image", 2, String.format("getCachePath oldPath: %s, newPath: %s", str, str2));
        }
        return str2;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0059: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:90), block:B:36:0x0059 */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] e(String str) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        File file = new File(str);
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        BufferedInputStream bufferedInputStream3 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (FileNotFoundException e16) {
                e = e16;
                bufferedInputStream = null;
            } catch (IOException e17) {
                e = e17;
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                try {
                    bufferedInputStream3.close();
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
                throw th;
            }
            try {
                bufferedInputStream.read(bArr, 0, length);
                bufferedInputStream.close();
                try {
                    bufferedInputStream.close();
                } catch (Exception e19) {
                    e19.printStackTrace();
                }
            } catch (FileNotFoundException e26) {
                e = e26;
                e.printStackTrace();
                try {
                    bufferedInputStream.close();
                } catch (Exception e27) {
                    e = e27;
                    e.printStackTrace();
                    bArr = null;
                    if (bArr == null) {
                    }
                    QLog.d("Q.ocr.image", 1, "savePreviewImage turn to jpeg bytes failed!");
                    return null;
                }
                bArr = null;
                if (bArr == null) {
                }
                QLog.d("Q.ocr.image", 1, "savePreviewImage turn to jpeg bytes failed!");
                return null;
            } catch (IOException e28) {
                e = e28;
                e.printStackTrace();
                try {
                    bufferedInputStream.close();
                } catch (Exception e29) {
                    e = e29;
                    e.printStackTrace();
                    bArr = null;
                    if (bArr == null) {
                    }
                    QLog.d("Q.ocr.image", 1, "savePreviewImage turn to jpeg bytes failed!");
                    return null;
                }
                bArr = null;
                if (bArr == null) {
                }
                QLog.d("Q.ocr.image", 1, "savePreviewImage turn to jpeg bytes failed!");
                return null;
            }
            if (bArr == null && bArr.length != 0) {
                return bArr;
            }
            QLog.d("Q.ocr.image", 1, "savePreviewImage turn to jpeg bytes failed!");
            return null;
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream3 = bufferedInputStream2;
            bufferedInputStream3.close();
            throw th;
        }
    }

    private static String f() {
        try {
            return new SimpleDateFormat(DateUtil.DATE_FORMAT_14).format(new Date(System.currentTimeMillis())) + ".jpg";
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String g(String str, boolean z16) {
        String str2;
        try {
            File file = new File(f254755a);
            File file2 = new File(f254756b);
            if (!file.exists() && !file.mkdir()) {
                QLog.d("Q.ocr.image", 1, "getImagePath WTF! mk ocr dir failed!");
            }
            if (!file2.exists() && !file2.mkdir()) {
                QLog.d("Q.ocr.image", 1, "getImagePath WTF! mk ocr preview dir failed!");
            }
            if (z16) {
                str2 = f254756b;
            } else {
                str2 = f254755a;
            }
            return new File(str2, str).getAbsolutePath();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static Point h(Point point, Point point2, Point point3, Point point4) {
        int i3 = point2.x;
        int i16 = point.x;
        double d16 = i3 - i16;
        int i17 = point3.x;
        double d17 = i17 - point4.x;
        int i18 = point2.y;
        int i19 = point.y;
        double d18 = i18 - i19;
        int i26 = point3.y;
        double d19 = i26 - point4.y;
        double d26 = i17 - i16;
        double d27 = i26 - i19;
        double d28 = (d16 * d19) - (d18 * d17);
        if (Math.abs(d28) < 0.001d) {
            return null;
        }
        double d29 = ((d19 * d26) - (d17 * d27)) / d28;
        double d36 = point.x + ((point2.x - r2) * d29);
        double d37 = point.y + (d29 * (point2.y - r0));
        if (Math.abs(d36 - point4.x) < 5.0d && Math.abs(d37 - point4.y) < 5.0d) {
            return new Point(point4);
        }
        return new Point((int) d36, (int) d37);
    }

    public static float i(int i3, int i16, String str, Paint paint) {
        float textSize = paint.getTextSize();
        float measureText = paint.measureText(str);
        float f16 = i3;
        if (measureText > f16) {
            while (measureText > f16) {
                textSize -= 1.0f;
                paint.setTextSize(textSize);
                measureText = paint.measureText(str);
            }
        } else {
            float f17 = 0.97f * f16;
            if (measureText < f17) {
                while (measureText < f17) {
                    textSize += 1.0f;
                    paint.setTextSize(textSize);
                    measureText = paint.measureText(str);
                }
                if (measureText > f16) {
                    textSize -= 1.0f;
                }
            }
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f18 = fontMetrics.descent;
        float f19 = fontMetrics.ascent;
        while (f18 - f19 > i16) {
            textSize -= 1.0f;
            paint.setTextSize(textSize);
            Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
            f18 = fontMetrics2.descent;
            f19 = fontMetrics2.ascent;
        }
        return textSize;
    }

    public static String j(List<com.tencent.mobileqq.gallery.picocr.b> list) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        for (com.tencent.mobileqq.gallery.picocr.b bVar : list) {
            if (bVar != null && (str = bVar.f211807a) != null) {
                sb5.append(str);
            }
        }
        return sb5.toString().replace(" ", "");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0026 -> B:12:0x004d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean k(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i3, boolean z16) {
        long j3;
        boolean z17 = false;
        BufferedOutputStream bufferedOutputStream = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str)));
                try {
                    z17 = bitmap.compress(compressFormat, i3, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    if (z16) {
                        bitmap.recycle();
                    }
                    bufferedOutputStream2.close();
                } catch (Exception e17) {
                    e = e17;
                    bufferedOutputStream = bufferedOutputStream2;
                    QLog.e("Q.ocr.image", 1, "saveBitmap exception", e);
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (QLog.isColorLevel()) {
                    }
                    return z17;
                } catch (OutOfMemoryError unused) {
                    bufferedOutputStream = bufferedOutputStream2;
                    QLog.e("Q.ocr.image", 1, "saveBitmap oom");
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (QLog.isColorLevel()) {
                    }
                    return z17;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
            } catch (OutOfMemoryError unused2) {
            }
            if (QLog.isColorLevel()) {
                if (new File(str).exists()) {
                    j3 = new File(str).length() / 1024;
                } else {
                    j3 = 0;
                }
                QLog.d("Q.ocr.image", 2, "saveBitmap filename:" + str + ",format:" + compressFormat + ",quality:" + i3 + ",size:" + j3 + "KB");
            }
            return z17;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0108, code lost:
    
        if (r2 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x012a, code lost:
    
        com.tencent.cache.api.util.ImageCacheHelper.f98636a.i(r13, r2, com.tencent.cache.api.Business.Default);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0128, code lost:
    
        if (r2 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0150, code lost:
    
        if (r2 != null) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x015e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String l(byte[] bArr, int i3, int i16, int i17, int i18) {
        Bitmap bitmap;
        Bitmap clipJpegToBitmap;
        long j3;
        if (QLog.isColorLevel()) {
            if (bArr != null) {
                j3 = bArr.length;
            } else {
                j3 = 0;
            }
            QLog.d("Q.ocr.image", 2, "savePreviewImage data.length:" + j3 + ",height:" + i16 + ",width:" + i3 + ",format:" + i17 + ",rotation:" + i18);
        }
        byte[] bArr2 = null;
        if (bArr == null) {
            return null;
        }
        String g16 = g(f(), true);
        if (i16 > 0 && i3 > 0 && (i17 == 17 || i17 == 20)) {
            if (!o(g16, new YuvImage(bArr, i17, i3, i16, null), 100)) {
                QLog.d("Q.ocr.image", 1, "savePreviewImage saveYuvImage failed!");
                return null;
            }
            byte[] e16 = e(g16);
            try {
                if (e16 == null) {
                    QLog.d("Q.ocr.image", 1, "savePreviewImage getFileData is null");
                    return g16;
                }
                try {
                    clipJpegToBitmap = ((ICameraUtils) QRoute.api(ICameraUtils.class)).clipJpegToBitmap(e16, new Rect(0, 0, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT), false, 0);
                } catch (IOException e17) {
                    e = e17;
                    bitmap = null;
                } catch (OutOfMemoryError unused) {
                    bitmap = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (new File(g16).exists() && bArr2 != null) {
                        ImageCacheHelper.f98636a.i(g16, bArr2, Business.Default);
                    }
                    throw th;
                }
                if (clipJpegToBitmap == null) {
                    QLog.d("Q.ocr.image", 1, "clipJpegToBitmap failed");
                    new File(g16).exists();
                    return g16;
                }
                bitmap = ((ICameraUtils) QRoute.api(ICameraUtils.class)).rotateBitmap(clipJpegToBitmap, i18, true);
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.ocr.image", 2, "savePreviewImage rotation:" + i18);
                    }
                    if (bitmap == null) {
                        BaseImageUtil.saveBitmapFileAsJPEG(clipJpegToBitmap, 100, new File(g16));
                        QLog.d("Q.ocr.image", 1, "rotateBitmap failed");
                    } else {
                        BaseImageUtil.saveBitmapFileAsJPEG(bitmap, 100, new File(g16));
                    }
                    if (new File(g16).exists()) {
                    }
                } catch (IOException e18) {
                    e = e18;
                    e.printStackTrace();
                    ((ICameraUtils) QRoute.api(ICameraUtils.class)).tryRecycle(bitmap);
                    if (new File(g16).exists()) {
                    }
                    if (!new File(g16).exists()) {
                    }
                } catch (OutOfMemoryError unused2) {
                    QLog.e("Q.ocr.image", 1, "savePreviewImage oom");
                    ((ICameraUtils) QRoute.api(ICameraUtils.class)).tryRecycle(bitmap);
                    if (new File(g16).exists()) {
                    }
                    if (!new File(g16).exists()) {
                    }
                }
                if (!new File(g16).exists()) {
                    return null;
                }
                return g16;
            } catch (Throwable th6) {
                th = th6;
                bArr2 = bArr;
            }
        } else {
            QLog.d("Q.ocr.image", 1, "savePreviewImage image is invalid!");
            return null;
        }
    }

    public static String m(byte[] bArr, int i3, int i16, int i17, int i18, int i19) {
        return n(bArr, i3, i16, i17, i18, i19, null, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x01db, code lost:
    
        if (r2 != null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01fe, code lost:
    
        com.tencent.cache.api.util.ImageCacheHelper.f98636a.i(r14, r2, com.tencent.cache.api.Business.Default);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01fc, code lost:
    
        if (r2 != null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0223, code lost:
    
        if (r2 != null) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0142 A[Catch: all -> 0x019d, TryCatch #5 {all -> 0x019d, blocks: (B:48:0x0110, B:33:0x0120, B:35:0x0142, B:37:0x0156, B:38:0x0163, B:40:0x016d, B:45:0x015c, B:46:0x0148), top: B:47:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0156 A[Catch: all -> 0x019d, TryCatch #5 {all -> 0x019d, blocks: (B:48:0x0110, B:33:0x0120, B:35:0x0142, B:37:0x0156, B:38:0x0163, B:40:0x016d, B:45:0x015c, B:46:0x0148), top: B:47:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x016d A[Catch: all -> 0x019d, TRY_LEAVE, TryCatch #5 {all -> 0x019d, blocks: (B:48:0x0110, B:33:0x0120, B:35:0x0142, B:37:0x0156, B:38:0x0163, B:40:0x016d, B:45:0x015c, B:46:0x0148), top: B:47:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015c A[Catch: all -> 0x019d, TryCatch #5 {all -> 0x019d, blocks: (B:48:0x0110, B:33:0x0120, B:35:0x0142, B:37:0x0156, B:38:0x0163, B:40:0x016d, B:45:0x015c, B:46:0x0148), top: B:47:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0148 A[Catch: all -> 0x019d, TryCatch #5 {all -> 0x019d, blocks: (B:48:0x0110, B:33:0x0120, B:35:0x0142, B:37:0x0156, B:38:0x0163, B:40:0x016d, B:45:0x015c, B:46:0x0148), top: B:47:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0231 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0232 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String n(byte[] bArr, int i3, int i16, int i17, int i18, int i19, RectF rectF, boolean z16) {
        byte[] bArr2;
        int i26;
        String str;
        Bitmap bitmap;
        Bitmap clipJpegToBitmap;
        int width;
        int height;
        int i27;
        int i28;
        int height2;
        long j3;
        byte[] bArr3 = bArr;
        int i29 = i3;
        int i36 = i16;
        if (QLog.isColorLevel()) {
            if (bArr3 != null) {
                j3 = bArr3.length;
            } else {
                j3 = 0;
            }
            QLog.d("Q.ocr.image", 2, "savePreviewImage data.length:" + j3 + ",height:" + i36 + ",width:" + i29 + ",format:" + i17 + ",orientation:" + i19 + ", rectf:" + rectF);
        }
        if (bArr3 == null) {
            return null;
        }
        String g16 = g(f(), true);
        if (z16) {
            i26 = 100;
            str = g16;
        } else if (i36 > 0 && i29 > 0 && (i17 == 17 || i17 == 20)) {
            bArr2 = bArr;
            i26 = 100;
            str = g16;
            if (!o(str, new YuvImage(bArr2, i17, i3, i16, null), 100)) {
                QLog.d("Q.ocr.image", 1, "savePreviewImage saveYuvImage failed!");
                return null;
            }
            bArr3 = e(str);
        } else {
            QLog.d("Q.ocr.image", 1, "savePreviewImage image is invalid!");
            return null;
        }
        try {
            if (bArr3 == null) {
                QLog.d("Q.ocr.image", 1, "savePreviewImage getFileData is null");
                return str;
            }
            try {
                clipJpegToBitmap = ((ICameraUtils) QRoute.api(ICameraUtils.class)).clipJpegToBitmap(bArr3, new Rect(0, 0, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT), false, 0);
            } catch (IOException e16) {
                e = e16;
                bitmap = null;
            } catch (OutOfMemoryError unused) {
                bitmap = null;
            } catch (Throwable th5) {
                th = th5;
                bArr2 = null;
                if (new File(str).exists() && bArr2 != null) {
                    ImageCacheHelper.f98636a.i(str, bArr2, Business.Default);
                }
                throw th;
            }
            if (clipJpegToBitmap == null) {
                QLog.d("Q.ocr.image", 1, "clipJpegToBitmap failed");
                new File(str).exists();
                return str;
            }
            int jpegRotation = ((ICameraUtils) QRoute.api(ICameraUtils.class)).getJpegRotation(i18, i19);
            bitmap = ((ICameraUtils) QRoute.api(ICameraUtils.class)).rotateBitmap(clipJpegToBitmap, jpegRotation, true);
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.ocr.image", 2, "savePreviewImage rotation:" + jpegRotation);
                }
                if (rectF != null && bitmap != null) {
                    if (i29 > i36) {
                        try {
                            if (bitmap.getWidth() < bitmap.getHeight()) {
                                float f16 = i36;
                                width = (int) (((rectF.left * f16) + 0.5f) - ((i36 - bitmap.getWidth()) / 2));
                                float f17 = i29;
                                height = (int) (((rectF.top * f17) + 0.5f) - ((i29 - bitmap.getHeight()) / 2));
                                if (width > 0) {
                                    i28 = bitmap.getWidth();
                                    i27 = 0;
                                } else {
                                    int width2 = (int) ((rectF.width() * f16) + 0.5f);
                                    i27 = width;
                                    i28 = width2;
                                }
                                if (height > 0) {
                                    height2 = bitmap.getHeight();
                                    height = 0;
                                } else {
                                    height2 = (int) ((rectF.height() * f17) + 0.5f);
                                }
                                Bitmap createBitmap = Bitmap.createBitmap(bitmap, i27, height, i28, height2);
                                if (QLog.isColorLevel()) {
                                    QLog.d("Q.ocr.image", 2, "savePreviewImage cropImage w:" + createBitmap.getWidth(), " h:", Integer.valueOf(createBitmap.getHeight()));
                                }
                                bitmap = createBitmap;
                            }
                        } catch (Throwable th6) {
                            QLog.e("Q.ocr.image", 1, "savePreviewImage cropImage e:" + th6.getMessage());
                        }
                    }
                    i36 = i29;
                    i29 = i36;
                    float f162 = i36;
                    width = (int) (((rectF.left * f162) + 0.5f) - ((i36 - bitmap.getWidth()) / 2));
                    float f172 = i29;
                    height = (int) (((rectF.top * f172) + 0.5f) - ((i29 - bitmap.getHeight()) / 2));
                    if (width > 0) {
                    }
                    if (height > 0) {
                    }
                    Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, i27, height, i28, height2);
                    if (QLog.isColorLevel()) {
                    }
                    bitmap = createBitmap2;
                }
                if (bitmap == null) {
                    BaseImageUtil.saveBitmapFileAsJPEG(clipJpegToBitmap, i26, new File(str));
                    QLog.d("Q.ocr.image", 1, "rotateBitmap failed");
                } else {
                    BaseImageUtil.saveBitmapFileAsJPEG(bitmap, i26, new File(str));
                }
                if (new File(str).exists()) {
                }
            } catch (IOException e17) {
                e = e17;
                e.printStackTrace();
                ((ICameraUtils) QRoute.api(ICameraUtils.class)).tryRecycle(bitmap);
                if (new File(str).exists()) {
                }
                if (new File(str).exists()) {
                }
            } catch (OutOfMemoryError unused2) {
                QLog.e("Q.ocr.image", 1, "savePreviewImage oom");
                ((ICameraUtils) QRoute.api(ICameraUtils.class)).tryRecycle(bitmap);
                if (new File(str).exists()) {
                }
                if (new File(str).exists()) {
                }
            }
            if (new File(str).exists()) {
                return str;
            }
            return null;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static boolean o(String str, YuvImage yuvImage, int i3) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                if (yuvImage != null) {
                    try {
                        yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), i3, fileOutputStream2);
                    } catch (Exception e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream == null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (IOException e17) {
                            e17.printStackTrace();
                            return false;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                fileOutputStream2.flush();
                try {
                    fileOutputStream2.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
                return true;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e26) {
            e = e26;
        }
    }
}
