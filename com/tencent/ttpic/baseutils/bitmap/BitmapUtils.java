package com.tencent.ttpic.baseutils.bitmap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.ttpic.AEBaseConfig;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.encrypt.FileEncryptUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.baseutils.zip.ZipUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Date;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes27.dex */
public class BitmapUtils {
    private static final String ASSETS_RAW_DIR = "raw";
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    private static final int DEFAULT_SIZE = 1000;
    private static final int DEFAULT_SIZE_SMALL = 500;
    public static boolean ENABLE_DEBUG = false;
    public static boolean ENABLE_PROFILE = true;
    private static final int INDEX_ORIENTATION = 0;
    public static final int JPEG_QUALITY = 99;
    public static final String RES_PREFIX_ASSETS = "assets://";
    public static final String RES_PREFIX_HTTP = "http://";
    public static final String RES_PREFIX_HTTPS = "https://";
    public static final String RES_PREFIX_STORAGE = "/";
    private static final String TAG = "BitmapUtils";
    public static int currentShareIndex = -1;
    private static final String[] IMAGE_PROJECTION = {"orientation"};
    private static final String[] PATH_PROJECTION = {"_data"};
    private static final float[] mMatrixValues = new float[16];
    private static final float[] mTempMatrix = new float[32];

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum SAVE_STATUS {
        SAVE_SUCCESS,
        SAVE_FAILED,
        SAVE_OOM,
        SAVE_NULL,
        SAVE_CHANGE_DIR
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Size {
        public int height;
        public int width;

        public Size(int i3, int i16) {
            this.width = i3;
            this.height = i16;
        }

        public String toString() {
            return "Size{width=" + this.width + ", height=" + this.height + '}';
        }
    }

    public static Bitmap RGBA2Bitmap(byte[] bArr, int i3, int i16) {
        if (bArr == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        return createBitmap;
    }

    public static byte[] bitmap2RGBA(Bitmap bitmap) {
        if (!isLegal(bitmap)) {
            return null;
        }
        try {
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
            bitmap.copyPixelsToBuffer(allocate);
            return allocate.array();
        } catch (OutOfMemoryError e16) {
            LogUtils.e(TAG, "bitmap2RGBA OOM! " + e16.getMessage());
            ReportUtil.report(String.format("OutOfMemoryError! copy. width = %d, height = %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
            return null;
        }
    }

    public static boolean bitmapExists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("assets://") && !new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static byte[] bmpToByteArray(Bitmap bitmap, boolean z16) {
        if (!isLegal(bitmap)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        if (z16) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e16) {
            LogUtils.e(e16);
        }
        return byteArray;
    }

    public static Bitmap bytesArray2Bimap(byte[] bArr) {
        if (bArr.length != 0) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    public static int calculateInSampleSizeNew(BitmapFactory.Options options, int i3, int i16, boolean z16) {
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
            if (ApiHelper.hasNougat()) {
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
            if (ApiHelper.hasNougat()) {
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

    /* JADX WARN: Removed duplicated region for block: B:47:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String compressImageFile(String str, BitmapFactory.Options options, File file) {
        FileOutputStream fileOutputStream;
        Bitmap bitmap;
        LogUtils.d(TAG, "compressImageFile(%s, %s, %s)", str, options, file.getAbsolutePath());
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = file.getAbsolutePath() + File.separator + "topic_thumb_temp_" + new Date().getTime();
        File file2 = new File(str2);
        FileOutputStream fileOutputStream2 = null;
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file2);
        } catch (Exception e16) {
            e = e16;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
        try {
            try {
                if (!isSupportImgType(options.outMimeType)) {
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                    try {
                        bitmap = BitmapFactory.decodeFile(str, options);
                    } catch (OutOfMemoryError e17) {
                        LogUtils.e(e17);
                        ReportUtil.report(String.format("OutOfMemoryError! compressImageFile. path = %s, width = %d, height = %d.", str, Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)));
                        bitmap = null;
                    }
                    if (bitmap != null) {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                        bitmap.recycle();
                    } else {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused) {
                        }
                        return null;
                    }
                }
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
                return str2;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception e18) {
            e = e18;
            LogUtils.e(e);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        }
    }

    public static Bitmap copy(Bitmap bitmap, boolean z16) {
        try {
            if (!isLegal(bitmap)) {
                return null;
            }
            return bitmap.copy(bitmap.getConfig(), z16);
        } catch (OutOfMemoryError unused) {
            LogUtils.e(TAG, "bitmap copy OOM!");
            ReportUtil.report(String.format("OutOfMemoryError! copy. width = %d, height = %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
            return null;
        }
    }

    public static Bitmap createBitmap(Bitmap bitmap, int i3, int i16, int i17, int i18, Matrix matrix) {
        Paint paint;
        Bitmap createBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            Canvas canvas = new Canvas();
            if (matrix != null && !matrix.isIdentity()) {
                RectF rectF = new RectF(0.0f, 0.0f, i17, i18);
                matrix.mapRect(rectF);
                try {
                    createBitmap = Bitmap.createBitmap(Math.round(rectF.width()), Math.round(rectF.height()), bitmap.getConfig());
                    canvas.translate(-rectF.left, -rectF.top);
                    canvas.concat(matrix);
                    paint = new Paint(2);
                    if (!matrix.rectStaysRect()) {
                        paint.setAntiAlias(true);
                    }
                } catch (OutOfMemoryError e16) {
                    LogUtils.e(e16);
                    return null;
                }
            } else {
                try {
                    paint = null;
                    createBitmap = Bitmap.createBitmap(i17, i18, bitmap.getConfig());
                } catch (NullPointerException e17) {
                    LogUtils.e(e17);
                    return null;
                } catch (OutOfMemoryError e18) {
                    LogUtils.e(e18);
                }
            }
            createBitmap.setDensity(bitmap.getDensity());
            canvas.setBitmap(createBitmap);
            canvas.drawBitmap(bitmap, new Rect(i3, i16, i3 + i17, i16 + i18), new RectF(0.0f, 0.0f, i17, i18), paint);
            return createBitmap;
        }
        return null;
    }

    public static Bitmap cropCenter(Bitmap bitmap, int i3, int i16, boolean z16) {
        boolean z17;
        Bitmap bitmap2;
        long currentTimeMillis = System.currentTimeMillis();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        boolean z18 = true;
        try {
            bitmap2 = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            z17 = true;
        } catch (OutOfMemoryError unused) {
            z17 = false;
            bitmap2 = null;
        }
        if (!z17) {
            try {
                bitmap2 = Bitmap.createBitmap(i3, i16, Bitmap.Config.RGB_565);
            } catch (OutOfMemoryError unused2) {
            }
            if (z18 || bitmap2 == null) {
                return null;
            }
            Canvas canvas = new Canvas(bitmap2);
            canvas.translate((i3 - width) / 2, (i16 - height) / 2);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(2));
            if (z16) {
                bitmap.recycle();
            }
            LogUtils.d(TAG, "crop bitmap - " + (System.currentTimeMillis() - currentTimeMillis));
            return bitmap2;
        }
        z18 = z17;
        if (z18) {
        }
        return null;
    }

    public static Bitmap decodeBitmap(String str) {
        return decodeBitmap(str, false, null, -1, -1);
    }

    public static Bitmap decodeSampleBitmap(Context context, String str, int i3, int i16) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("assets://")) {
            return decodeSampledBitmapFromAssets(context, getRealPath(str), i3, i16);
        }
        if (bitmapExists(str)) {
            return decodeSampledBitmapFromFile(str, i3, i16);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        if (r5 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
    
        if (r5 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeSampleBitmapFromAssets(Context context, String str, int i3) {
        Bitmap bitmap = null;
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                InputStream open = context.getAssets().open(str);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = i3;
                try {
                    try {
                        bitmap = BitmapFactory.decodeStream(open, null, options);
                    } catch (Exception e16) {
                        LogUtils.e(TAG, e16.toString());
                    } catch (OutOfMemoryError unused) {
                        options.inSampleSize <<= 1;
                        try {
                            open.reset();
                            bitmap = BitmapFactory.decodeStream(open, null, options);
                        } catch (IOException | OutOfMemoryError e17) {
                            LogUtils.e(TAG, e17.toString());
                            ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", str, Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)));
                        }
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException unused2) {
                                return bitmap;
                            }
                        }
                        return bitmap;
                    }
                } catch (Throwable th5) {
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th5;
                }
            } catch (IOException e18) {
                LogUtils.e(TAG, e18.toString());
            }
        }
        return null;
    }

    public static Bitmap decodeSampleBitmapFromOption(Context context, String str, int i3, int i16, BitmapFactory.Options options) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (options == null) {
            return decodeSampleBitmap(context, str, i3, i16);
        }
        if (str.startsWith("assets://")) {
            return decodeSampledBitmapFromAssets(context, getRealPath(str), options);
        }
        if (!bitmapExists(str)) {
            return null;
        }
        return decodeSampledBitmapFromFile(str, options);
    }

    public static Bitmap decodeSampledBitmapFromAssets(Context context, String str, int i3, int i16) {
        InputStream open;
        Bitmap bitmap = null;
        if (!TextUtils.isEmpty(str) && context != null) {
            AssetManager assets = context.getAssets();
            try {
                try {
                    open = assets.open(str);
                } catch (IOException e16) {
                    LogUtils.i(TAG, "", e16, new Object[0]);
                }
            } catch (IOException unused) {
                open = assets.open(str.substring(0, str.lastIndexOf(46) + 1) + "webp");
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(open, null, options);
            options.inSampleSize = calculateInSampleSizeNew(options, i3, i16, true);
            options.inJustDecodeBounds = false;
            try {
                open.reset();
                bitmap = BitmapFactory.decodeStream(open, null, options);
            } catch (IOException e17) {
                LogUtils.e(TAG, e17);
            } catch (OutOfMemoryError unused2) {
                options.inSampleSize <<= 1;
                try {
                    open.reset();
                    bitmap = BitmapFactory.decodeStream(open, null, options);
                } catch (IOException | OutOfMemoryError e18) {
                    LogUtils.e(TAG, e18);
                    ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", str, Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)));
                }
            }
            IOUtils.closeQuietly(open);
            return bitmap;
        }
        return null;
    }

    public static Bitmap decodeSampledBitmapFromFile(String str, int i3, int i16) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSizeNew(options, i3, i16, true);
        options.inJustDecodeBounds = false;
        ApiHelper.hasHoneycomb();
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError unused) {
            options.inSampleSize <<= 1;
            try {
                return BitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError e16) {
                LogUtils.e(e16);
                ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", str, Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)));
                return null;
            }
        }
    }

    public static Bitmap decodeSampledBitmapFromFileCheckExif(String str, int i3, int i16) {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSizeNew(options, i3, i16, true);
        options.inJustDecodeBounds = false;
        int degreeByExif = getDegreeByExif(str) % 360;
        try {
            bitmap = BitmapFactory.decodeFile(str, options);
            if (degreeByExif != 0) {
                try {
                    return rotateBitmap(bitmap, degreeByExif);
                } catch (OutOfMemoryError unused) {
                    options.inSampleSize <<= 1;
                    try {
                        bitmap = BitmapFactory.decodeFile(str, options);
                        if (degreeByExif != 0) {
                            return rotateBitmap(bitmap, degreeByExif);
                        }
                        return bitmap;
                    } catch (OutOfMemoryError e16) {
                        LogUtils.e(e16);
                        ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", str, Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)));
                        return bitmap;
                    }
                }
            }
            return bitmap;
        } catch (OutOfMemoryError unused2) {
            bitmap = null;
        }
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources resources, int i3, int i16, int i17) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i3, options);
        options.inSampleSize = calculateInSampleSizeNew(options, i16, i17, true);
        options.inJustDecodeBounds = false;
        try {
            return BitmapFactory.decodeResource(resources, i3, options);
        } catch (Exception e16) {
            LogUtils.e(e16);
            return null;
        } catch (OutOfMemoryError e17) {
            LogUtils.e(e17);
            try {
                options.inSampleSize *= 2;
                return BitmapFactory.decodeResource(resources, i3, options);
            } catch (OutOfMemoryError e18) {
                e18.printStackTrace();
                ReportUtil.report(String.format("OutOfMemoryError! res = %s, width = %d, height = %d.", resources, Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)));
                return null;
            }
        }
    }

    public static String getBase64FromBitmap(Bitmap bitmap, int i3, int i16) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bitmap == null) {
            LogUtils.d(TAG, "[getBase64FromBitmap] bitmap is null!");
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Exception unused) {
        } catch (Throwable unused2) {
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, i16, byteArrayOutputStream);
            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), i3);
            try {
                byteArrayOutputStream.close();
            } catch (IOException e16) {
                LogUtils.e(e16);
            }
            return encodeToString;
        } catch (Exception unused3) {
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e17) {
                    LogUtils.e(e17);
                }
            }
            return "";
        } catch (Throwable unused4) {
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e18) {
                    LogUtils.e(e18);
                }
            }
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap getBitmapFromEncryptedFile(Context context, String str) {
        byte[] bArr;
        InputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (str.startsWith("assets://")) {
                fileInputStream = context.getAssets().open(FileUtils.getRealPath(str));
            } else {
                fileInputStream = new FileInputStream(str);
            }
            bArr = FileEncryptUtils.decryptFile(fileInputStream);
        } catch (Exception e16) {
            e = e16;
            bArr = null;
        }
        try {
            IOUtils.closeQuietly(fileInputStream);
        } catch (Exception e17) {
            e = e17;
            LogUtils.e("BitmapUtils", "decodeBitmap  getStream", e, new Object[0]);
            if (bArr != null) {
            }
        }
        if (bArr != null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } catch (OutOfMemoryError e18) {
            LogUtils.e("BitmapUtils", "decodeByteArray", e18, new Object[0]);
            return null;
        }
    }

    public static Point getBitmapSize(Context context, String str) {
        if (str.startsWith("assets://")) {
            return getBitmapSizeFromAssets(context, getRealPath(str));
        }
        return getBitmapSizeFromFile(str);
    }

    private static Point getBitmapSizeFromAssets(Context context, String str) {
        Point point = new Point(0, 0);
        if (TextUtils.isEmpty(str)) {
            return point;
        }
        InputStream inputStream = null;
        try {
            try {
                InputStream open = context.getAssets().open(str);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(open, null, options);
                    Point point2 = new Point(options.outWidth, options.outHeight);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    }
                    return point2;
                } catch (IOException e17) {
                    e = e17;
                    inputStream = open;
                    LogUtils.e(TAG, e.toString());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    return point;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = open;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e19) {
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

    private static Point getBitmapSizeFromFile(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new Point(options.outWidth, options.outHeight);
    }

    @SuppressLint({"NewApi"})
    public static int getBitmapSizeInBytes(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        if (DeviceInstance.getSDKVersion() > 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
            }
        }
        if (DeviceInstance.getSDKVersion() >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getWidth() * bitmap.getRowBytes();
    }

    public static int getDegreeByExif(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return getDegreeByOrientation(new ExifInterface(str).getAttributeInt("Orientation", 0));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getDegreeByOrientation(int i3) {
        if (i3 != 3) {
            if (i3 != 6) {
                if (i3 != 8) {
                    return 0;
                }
                return 270;
            }
            return 90;
        }
        return 180;
    }

    public static Bitmap getImageFromPathWithDecode(Context context, String str) {
        InputStream inputStream;
        InputStream fileInputStream;
        Bitmap decodeByteArray;
        InputStream inputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (str.startsWith("/")) {
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (IOException unused) {
                    fileInputStream = new FileInputStream(str.substring(0, str.lastIndexOf(46) + 1) + "webp");
                }
            } else {
                try {
                    fileInputStream = context.getAssets().open(str);
                } catch (IOException unused2) {
                    fileInputStream = context.getAssets().open(str.substring(0, str.lastIndexOf(46) + 1) + "webp");
                }
            }
            if (fileInputStream == null) {
                return null;
            }
            try {
                byte[] decryptFile = FileEncryptUtils.decryptFile(fileInputStream);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                int i3 = 960;
                while (true) {
                    try {
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeByteArray(decryptFile, 0, decryptFile.length, options);
                        options.inSampleSize = calculateInSampleSizeNew(options, i3, i3, false);
                        options.inJustDecodeBounds = false;
                        options.inPreferQualityOverSpeed = true;
                        decodeByteArray = BitmapFactory.decodeByteArray(decryptFile, 0, decryptFile.length, options);
                        break;
                    } catch (OutOfMemoryError unused3) {
                        i3 = (int) (i3 / 1.5f);
                    } finally {
                        IOUtils.closeQuietly(fileInputStream);
                    }
                }
                IOUtils.closeQuietly(fileInputStream);
                if (decodeByteArray == null) {
                    return null;
                }
                Bitmap.Config config = decodeByteArray.getConfig();
                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                if (config == config2) {
                    return decodeByteArray;
                }
                Bitmap copy = decodeByteArray.copy(config2, false);
                if (copy != decodeByteArray) {
                    recycle(decodeByteArray);
                }
                return copy;
            } catch (Exception e16) {
                inputStream = fileInputStream;
                e = e16;
                try {
                    LogUtils.e(e);
                    IOUtils.closeQuietly(inputStream);
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream2 = inputStream;
                    IOUtils.closeQuietly(inputStream2);
                    throw th;
                }
            } catch (Throwable th6) {
                inputStream2 = fileInputStream;
                th = th6;
                IOUtils.closeQuietly(inputStream2);
                throw th;
            }
        } catch (Exception e17) {
            e = e17;
            inputStream = null;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static int[] getImageSize(String str, int i3, int i16) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int calculateInSampleSizeNew = calculateInSampleSizeNew(options, i3, i16, true);
        int i17 = 1;
        while (Math.pow(2.0d, i17) < calculateInSampleSizeNew) {
            i17++;
        }
        int pow = (int) Math.pow(2.0d, i17 - 1);
        int i18 = options.outWidth / pow;
        int i19 = options.outHeight / pow;
        int degreeByExif = getDegreeByExif(str);
        if (degreeByExif == 90 || degreeByExif == 270) {
            i19 = i18;
            i18 = i19;
        }
        return new int[]{i18, i19};
    }

    public static InputStream getInputStreamByName(String str) {
        AssetManager assets = AEBaseConfig.getContext().getAssets();
        try {
            try {
                return assets.open(str);
            } catch (IOException unused) {
                return null;
            }
        } catch (IOException unused2) {
            return assets.open(ASSETS_RAW_DIR + File.separator + str);
        }
    }

    private static Size getNewSize(int i3, int i16, int i17, int i18) {
        Size size;
        float f16 = i3;
        float f17 = i16;
        float min = Math.min(i17 / f16, i18 / f17);
        if (min < 1.0d) {
            size = new Size((int) (f16 * min), (int) (f17 * min));
        } else {
            size = new Size(i3, i16);
        }
        size.width = Math.max(size.width, 1);
        size.height = Math.max(size.height, 1);
        return size;
    }

    public static String getRealPath(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("assets://")) {
            return str.substring(9);
        }
        return str;
    }

    public static boolean isLegal(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            return true;
        }
        return false;
    }

    private static boolean isPowerOf2(int i3) {
        if ((i3 & (i3 - 1)) == 0) {
            return true;
        }
        return false;
    }

    private static boolean isSizeInRange(int i3) {
        if (i3 >= 1000 && i3 <= 4000) {
            return true;
        }
        return false;
    }

    public static boolean isSizeLeagle(int i3, int i16) {
        if (isSizeInRange(i3) && isSizeInRange(i16)) {
            return true;
        }
        return false;
    }

    private static boolean isSupportImgType(String str) {
        if (str != null && (str.equalsIgnoreCase("image/jpeg") || str.equalsIgnoreCase("image/png") || str.equalsIgnoreCase("image/gif"))) {
            return true;
        }
        return false;
    }

    public static boolean recycle(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
            return true;
        }
        return false;
    }

    public static Bitmap resizeBySidesRange(Bitmap bitmap, int i3, int i16) {
        int width;
        int height;
        if (bitmap.getHeight() / bitmap.getWidth() >= 1.0d) {
            width = bitmap.getHeight();
            height = bitmap.getWidth();
        } else {
            width = bitmap.getWidth();
            height = bitmap.getHeight();
        }
        if (height < i3 && width < i16) {
            return bitmap;
        }
        Size newSize = getNewSize(height, width, i3, i16);
        return Bitmap.createScaledBitmap(bitmap, newSize.width, newSize.height, false);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i3) {
        return rotateBitmap(bitmap, i3, true);
    }

    public static SAVE_STATUS saveBitmap(Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                if (bitmap != null) {
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 99, fileOutputStream2);
                        fileOutputStream2.flush();
                    } catch (Exception e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        LogUtils.e(e);
                        SAVE_STATUS save_status = SAVE_STATUS.SAVE_FAILED;
                        IOUtils.closeQuietly(fileOutputStream);
                        return save_status;
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        fileOutputStream = fileOutputStream2;
                        LogUtils.e(e);
                        ReportUtil.report(String.format("OutOfMemoryError! saveBitmap. path = %s, width = %d, height = %d.", str, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
                        SAVE_STATUS save_status2 = SAVE_STATUS.SAVE_OOM;
                        IOUtils.closeQuietly(fileOutputStream);
                        return save_status2;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        IOUtils.closeQuietly(fileOutputStream);
                        throw th;
                    }
                }
                IOUtils.closeQuietly(fileOutputStream2);
                return SAVE_STATUS.SAVE_SUCCESS;
            } catch (Exception e18) {
                e = e18;
            } catch (OutOfMemoryError e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static SAVE_STATUS saveBitmap2JPG(Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                if (bitmap != null) {
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 99, fileOutputStream2);
                        fileOutputStream2.flush();
                    } catch (Exception e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        LogUtils.e(e);
                        SAVE_STATUS save_status = SAVE_STATUS.SAVE_FAILED;
                        IOUtils.closeQuietly(fileOutputStream);
                        return save_status;
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        fileOutputStream = fileOutputStream2;
                        LogUtils.e(e);
                        ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", str, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
                        SAVE_STATUS save_status2 = SAVE_STATUS.SAVE_OOM;
                        IOUtils.closeQuietly(fileOutputStream);
                        return save_status2;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        IOUtils.closeQuietly(fileOutputStream);
                        throw th;
                    }
                }
                IOUtils.closeQuietly(fileOutputStream2);
                return SAVE_STATUS.SAVE_SUCCESS;
            } catch (Exception e18) {
                e = e18;
            } catch (OutOfMemoryError e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static byte[] saveBitmap2JpgByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        OutOfMemoryError e16;
        byte[] bArr = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream2 = byteArrayOutputStream;
        }
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e17) {
                e = e17;
            } catch (OutOfMemoryError e18) {
                byteArrayOutputStream = null;
                e16 = e18;
            }
            if (bitmap != null) {
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 99, byteArrayOutputStream);
                    byteArrayOutputStream.flush();
                    bArr = byteArrayOutputStream.toByteArray();
                } catch (Exception e19) {
                    e = e19;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    LogUtils.e(e);
                    IOUtils.closeQuietly(byteArrayOutputStream2);
                    return bArr;
                } catch (OutOfMemoryError e26) {
                    e16 = e26;
                    LogUtils.e(e16);
                    ReportUtil.report(String.format("OutOfMemoryError! width = %d, height = %d.", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
                    IOUtils.closeQuietly(byteArrayOutputStream);
                    return bArr;
                }
            }
            IOUtils.closeQuietly(byteArrayOutputStream);
            return bArr;
        } catch (Throwable th6) {
            th = th6;
            IOUtils.closeQuietly(byteArrayOutputStream2);
            throw th;
        }
    }

    public static SAVE_STATUS saveBitmap2PNG(Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                if (bitmap != null) {
                    try {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 99, fileOutputStream2);
                        fileOutputStream2.flush();
                    } catch (Exception e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        LogUtils.e(e);
                        SAVE_STATUS save_status = SAVE_STATUS.SAVE_FAILED;
                        IOUtils.closeQuietly(fileOutputStream);
                        return save_status;
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        fileOutputStream = fileOutputStream2;
                        LogUtils.e(e);
                        ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", str, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
                        SAVE_STATUS save_status2 = SAVE_STATUS.SAVE_OOM;
                        IOUtils.closeQuietly(fileOutputStream);
                        return save_status2;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        IOUtils.closeQuietly(fileOutputStream);
                        throw th;
                    }
                }
                IOUtils.closeQuietly(fileOutputStream2);
                return SAVE_STATUS.SAVE_SUCCESS;
            } catch (Exception e18) {
                e = e18;
            } catch (OutOfMemoryError e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, float f16, boolean z16) {
        if (isLegal(bitmap)) {
            Matrix matrix = new Matrix();
            matrix.postScale(f16, f16);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (createBitmap != bitmap && z16) {
                    recycle(bitmap);
                }
                return createBitmap;
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
                ReportUtil.report(String.format("OutOfMemoryError! scaleBitmap. width = %d, height = %d.", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
                return bitmap;
            }
        }
        return null;
    }

    public static Bitmap unZip(byte[] bArr, int i3, int i16) {
        if (bArr == null) {
            return null;
        }
        return RGBA2Bitmap(ZipUtils.unZip(bArr), i3, i16);
    }

    public static byte[] zip(Bitmap bitmap) {
        if (!isLegal(bitmap)) {
            return null;
        }
        return ZipUtils.zip(bitmap2RGBA(bitmap));
    }

    public static Bitmap decodeBitmap(String str, boolean z16) {
        return decodeBitmap(str, z16, null, -1, -1);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i3, boolean z16) {
        if (bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i3, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == createBitmap) {
                return bitmap;
            }
            if (z16) {
                bitmap.recycle();
            }
            return createBitmap;
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return bitmap;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeBitmap(String str, boolean z16, Bitmap.Config config, int i3, int i16) {
        byte[] bArr;
        InputStream inputStreamByName;
        Bitmap bitmap = null;
        try {
            if (z16) {
                inputStreamByName = new FileInputStream(str);
            } else {
                inputStreamByName = getInputStreamByName(str);
            }
            bArr = FileEncryptUtils.decryptFile(inputStreamByName);
            try {
                IOUtils.closeQuietly(inputStreamByName);
            } catch (Exception e16) {
                e = e16;
                LogUtils.e(TAG, e.getStackTrace().toString());
                if (bArr != null) {
                }
            }
        } catch (Exception e17) {
            e = e17;
            bArr = null;
        }
        if (bArr != null) {
            LogUtils.w(TAG, "[" + str + "] decrypted buffer is null.");
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (config != null) {
            options.inPreferredConfig = config;
        } else {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        }
        try {
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } catch (OutOfMemoryError unused) {
        }
        if (i3 == -1) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, i3, i16), new Paint(6));
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap decodeSampleBitmap(Context context, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("assets://")) {
            return decodeSampleBitmapFromAssets(context, getRealPath(str), i3);
        }
        if (bitmapExists(str)) {
            return decodeSampledBitmapFromFile(str, i3);
        }
        return null;
    }

    public static Bitmap decodeSampledBitmapFromFile(String str, BitmapFactory.Options options) {
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e16) {
            LogUtils.e(e16);
            return null;
        } catch (OutOfMemoryError unused) {
            options.inSampleSize <<= 1;
            try {
                return BitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError e17) {
                LogUtils.e(e17);
                ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", str, Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)));
                return null;
            }
        }
    }

    public static Bitmap decodeSampledBitmapFromFile(String str, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i3;
        options.inJustDecodeBounds = false;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError unused) {
            options.inSampleSize <<= 1;
            try {
                return BitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError e16) {
                LogUtils.e(TAG, e16.toString());
                ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", str, Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)));
                return null;
            }
        }
    }

    public static Bitmap decodeBitmap(String str, Bitmap.Config config) {
        return decodeBitmap(str, false, config, -1, -1);
    }

    public static Bitmap decodeSampledBitmapFromAssets(Context context, String str, BitmapFactory.Options options) {
        InputStream open;
        Bitmap bitmap = null;
        if (!TextUtils.isEmpty(str) && context != null) {
            AssetManager assets = context.getAssets();
            try {
                try {
                    open = assets.open(str);
                } catch (IOException e16) {
                    LogUtils.i(TAG, "", e16, new Object[0]);
                }
            } catch (IOException unused) {
                open = assets.open(str.substring(0, str.lastIndexOf(46) + 1) + "webp");
            }
            try {
                open.reset();
                bitmap = BitmapFactory.decodeStream(open, null, options);
            } catch (IOException e17) {
                LogUtils.e(TAG, e17);
            } catch (OutOfMemoryError unused2) {
                options.inSampleSize <<= 1;
                try {
                    open.reset();
                    bitmap = BitmapFactory.decodeStream(open, null, options);
                } catch (IOException | OutOfMemoryError e18) {
                    LogUtils.e(TAG, e18);
                    ReportUtil.report(String.format("OutOfMemoryError! path = %s, width = %d, height = %d.", str, Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)));
                }
            }
            IOUtils.closeQuietly(open);
            return bitmap;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File saveBitmap(Context context, Bitmap bitmap, String str, String str2, Bitmap.CompressFormat compressFormat, String str3) {
        FileOutputStream fileOutputStream;
        File file;
        StringBuilder sb5;
        File cacheDir;
        FileOutputStream fileOutputStream2 = null;
        if (str != null) {
            File file2 = new File(str);
            if (!file2.isDirectory() && !file2.mkdirs()) {
                return null;
            }
        } else if (context != null && (cacheDir = context.getCacheDir()) != null) {
            str = cacheDir.getAbsolutePath();
        }
        boolean z16 = false;
        try {
            try {
                if (compressFormat == Bitmap.CompressFormat.PNG) {
                    sb5 = new StringBuilder();
                    sb5.append(str2);
                    sb5.append(".png");
                } else {
                    sb5 = new StringBuilder();
                    sb5.append(str2);
                    sb5.append(".jpg");
                }
                file = new File(str, sb5.toString());
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        try {
                            if (compressFormat != Bitmap.CompressFormat.JPEG || str3 == null || str3.length() <= 0) {
                                z16 = bitmap.compress(compressFormat, 99, fileOutputStream);
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream2 = fileOutputStream;
                            IOUtils.closeQuietly(fileOutputStream2);
                            throw th;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        LogUtils.e(e);
                        IOUtils.closeQuietly(fileOutputStream);
                        if (z16) {
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                    fileOutputStream = null;
                }
            } catch (Throwable th6) {
                th = th6;
                IOUtils.closeQuietly(fileOutputStream2);
                throw th;
            }
        } catch (Exception e18) {
            e = e18;
            fileOutputStream = null;
            file = null;
        }
        IOUtils.closeQuietly(fileOutputStream);
        if (z16) {
            return null;
        }
        return file;
    }
}
