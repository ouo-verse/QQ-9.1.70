package com.tencent.mobileqq.utils;

import android.R;
import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.webkit.MimeTypeMap;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.image.GifDrawable;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.injector.BaseImageUtilInjector;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.transfile.chatpic.PicUploadExifInfoSwitch;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.peak.PeakConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SyncFailedException;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class BaseImageUtil {

    @Deprecated
    public static final int BIZTYPE_DOODLE = 6;
    public static final int BIZTYPE_FORWARD = 5;
    public static final int BIZTYPE_QZONE_SHARE = 7;
    public static final int BIZTYPE_SCREENSHOT = 3;
    public static final int BIZTYPE_SECRET_FILE = 8;
    public static final int BIZTYPE_SENDPHOTO = 1;
    public static final int BIZTYPE_SENDPHOTO_SHOT = 2;
    public static final int BIZTYPE_SHARE = 4;
    public static final int BUFFER_SIZE_DECODE_BOUND = 2048;
    public static final int COMPRESS_ERRORCODE_DEST_DECODE_FAIL_COMPRESS_FAIL = 9;
    public static final int COMPRESS_ERRORCODE_DEST_DECODE_FAIL_COMPRESS_SDCARDFULL = 0;
    public static final int COMPRESS_ERRORCODE_DEST_WRITE_FAIL = 5;
    public static final int COMPRESS_ERRORCODE_SRC_DECODE_FAIL_OM = 3;
    public static final int COMPRESS_ERRORCODE_SRC_DECODE_FAIL_OTHER = 4;
    public static final int COMPRESS_ERRORCODE_SRC_DECODE_FAIL_RETRY = 8;
    public static final int COMPRESS_ERRORCODE_SRC_DECODE_FAIL_ROTATE = 7;
    public static final int COMPRESS_ERRORCODE_SRC_DECODE_FAIL_SCALE = 6;
    public static final int COMPRESS_ERRORCODE_SRC_NOT_EXIST = 1;
    public static final int COMPRESS_ERRORCODE_SRC_SIZE_ZERO = 2;
    public static final float FACE_SQUARE_RADDIO = 0.071428575f;
    public static final int FACE_SQUARE_RADIUS = 10;
    public static final int FACE_SQUARE_RADIUS_100_X_100 = 7;
    public static final int FACE_SQUARE_RADIUS_40_X_40 = 3;
    public static final int FACE_WIDTH_HEIGHT = 50;
    public static final String FILE_PHOTO_DIR = "photo";
    public static final String FILE_PHOTO_PATH = "photo/";
    public static final String FILE_THUMB2_DIR = "thumb2";
    public static final String FILE_THUMB2_PATH = "thumb2/";
    public static final String FILE_THUMB_DIR = "thumb";
    public static final String FILE_THUMB_PATH = "thumb/";
    public static final int IMAGEFACTOR = 3;
    static final int MAX_COMPRESS_RETRY_COUNT = 2;
    static int MAX_LIMIT = 0;
    static final int MAX_LIMIT_NORMAL = 960;
    static final int QUALITY_NOT_WIFI = 70;
    static final int QUALITY_WIFI = 80;
    public static final String REPORT_SENDPHOTO_ISWIFI = "report_sendphoto_iswifi";
    public static final String REPORT_SENDPHOTO_NOT_LARGER_960 = "report_sendphoto_not_larger_960";
    public static final String REPORT_SENDPHOTO_NOT_LONG_PHOTO = "report_sendphoto_not_long_photo";
    public static final String REPORT_TAG_APPSHARE_IMAGE_UPLOAD_INVALID = "actAppShareImageuploadInvalid";
    public static final String REPORT_TAG_C2C_IMAGE_UPLOAD_INVALID = "actC2CImageuploadInvalid";
    public static final String REPORT_TAG_GROUP_IMAGE_UPLOAD_INVALID = "actGrpImageuploadInvalid";
    public static final String REPORT_TAG_PUB_IMAGE_UPLOAD_INVALID = "actPubImageuploadInvalid";
    public static final float ROUND_CORNER_RADIUS = 2.0f;
    static final String TAG = "ImageUtil";
    public static final String TAG_UPLOAD = "image_upload";
    public static final String TAG_UPLOAD_WITHE_EXCEPTION_STACK = "image_upload_exception_stack";

    @QAutoInject(configPath = "AutoInjectYml/Foundation/Establish/Inject_BaseImageUtil.yml", version = 1)
    static com.tencent.mobileqq.inject.c sBaseImage;
    private static ArrayList sBaseImage_AutoGenClazzList_QAutoInjectTransform;
    static String[] sComressTag;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public enum ScalingLogic {
        CROP,
        FIT,
        SCALE_CROP
    }

    static {
        ArrayList arrayList = new ArrayList();
        sBaseImage_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(BaseImageUtilInjector.class);
        MAX_LIMIT = 1280;
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Rect calculateBigImageBounds(Rect rect, int i3, float f16) {
        int i16;
        if (rect != null && i3 > 0 && f16 > 0.0f) {
            int i17 = (int) (i3 * f16);
            int width = rect.width();
            int width2 = rect.width();
            if (width > width2) {
                i16 = width;
            } else {
                i16 = width2;
            }
            if (i16 < i17) {
                Rect rect2 = new Rect();
                scaleThumbTo(rect2, width, width2, i17);
                return rect2;
            }
            return null;
        }
        return null;
    }

    public static Rect calculateDstRect(int i3, int i16, int i17, int i18, ScalingLogic scalingLogic) {
        if (scalingLogic == ScalingLogic.FIT) {
            float f16 = i3 / i16;
            float f17 = i17;
            float f18 = i18;
            if (f16 > f17 / f18) {
                return new Rect(0, 0, i17, (int) (f17 / f16));
            }
            return new Rect(0, 0, (int) (f18 * f16), i18);
        }
        return new Rect(0, 0, i17, i18);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        r6.inSampleSize = r2 * 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BitmapFactory.Options calculateInSampleSize(BitmapFactory.Options options, String str, int i3) {
        options.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(str, options);
        int i16 = options.outHeight;
        int i17 = options.outWidth;
        int i18 = 1;
        while (true) {
            if (i16 <= i3 && i17 <= i3) {
                break;
            }
            if (Math.round(Math.max(i16, i17) / (i3 * 1.0f)) >= 2) {
                i17 /= 2;
                i16 /= 2;
                if (i17 < i3 && i16 < i3) {
                    options.inSampleSize = i18;
                    break;
                }
                if (i17 == i3 || i16 == i3) {
                    break;
                }
                i18 *= 2;
            } else {
                options.inSampleSize = i18;
                break;
            }
        }
        options.inJustDecodeBounds = false;
        int i19 = options.inSampleSize;
        options.inSampleSize = i19 >= 1 ? i19 : 1;
        return options;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        r0.inSampleSize = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BitmapFactory.Options calculateInSampleSize2(String str, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i16 = 1;
        options.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(str, options);
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        logImage("compressAIOThumbImg  org width:" + i18 + ",height:" + i17);
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
        options.inSampleSize = i19 * 2;
        options.inJustDecodeBounds = false;
        int i26 = options.inSampleSize;
        if (i26 >= 1) {
            i16 = i26;
        }
        options.inSampleSize = i16;
        return options;
    }

    public static Rect calculateSrcRect(int i3, int i16, int i17, int i18, ScalingLogic scalingLogic) {
        if (scalingLogic == ScalingLogic.CROP) {
            float f16 = i3;
            float f17 = i16;
            float f18 = i17 / i18;
            if (f16 / f17 > f18) {
                int i19 = (int) (f17 * f18);
                int i26 = (i3 - i19) / 2;
                return new Rect(i26, 0, i19 + i26, i16);
            }
            int i27 = (int) (f16 / f18);
            int i28 = (i16 - i27) / 2;
            return new Rect(0, i28, i3, i27 + i28);
        }
        return new Rect(0, 0, i3, i16);
    }

    public static Rect calculateThumbBounds(Drawable drawable, int i3, int i16, float f16) {
        int i17;
        Rect rect = new Rect();
        if (drawable != null && i16 > 0 && i3 > 0 && i16 > i3 && f16 > 0.0f) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > intrinsicHeight) {
                i17 = intrinsicWidth;
            } else {
                i17 = intrinsicHeight;
            }
            if (i17 < i3) {
                scaleThumbTo(rect, intrinsicWidth, intrinsicHeight, (int) (i3 * f16));
            } else if (i17 >= i3 && i17 < i16) {
                rect.set(0, 0, (int) (intrinsicWidth * f16), (int) (intrinsicHeight * f16));
            } else {
                scaleThumbTo(rect, intrinsicWidth, intrinsicHeight, (int) (i16 * f16));
            }
        }
        return rect;
    }

    public static Bitmap clipBitmap2BgBound(Bitmap bitmap, int i3, int i16, int i17, boolean z16) {
        if (bitmap != null && i3 != 0) {
            try {
                Resources resources = BaseApplication.getContext().getResources();
                Drawable drawable = resources.getDrawable(i3);
                Bitmap createBitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
                createBitmap.setDensity(resources.getDisplayMetrics().densityDpi);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                canvas.drawARGB(0, 0, 0, 0);
                Rect rect2 = new Rect(0, 0, i16, i17);
                drawable.setBounds(rect2);
                paint.setAntiAlias(true);
                paint.setDither(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(bitmap, rect, rect2, paint);
                int c16 = com.tencent.mobileqq.util.x.c(BaseApplication.getContext(), 55.0f);
                if (z16 && i17 > c16) {
                    paint.setShader(new LinearGradient(0.0f, i17 - c16, 0.0f, i17, 0, -1728053248, Shader.TileMode.CLAMP));
                    canvas.drawRect(rect2, paint);
                }
                if (drawable instanceof SkinnableNinePatchDrawable) {
                    ((SkinnableNinePatchDrawable) drawable).getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                } else if (drawable instanceof NinePatchDrawable) {
                    ((NinePatchDrawable) drawable).getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                } else {
                    QLog.e("ImageUtil", 1, "invalid drawable resource :" + drawable.getClass().getName());
                }
                drawable.draw(canvas);
                return createBitmap;
            } catch (Throwable th5) {
                QLog.e("ImageUtil", 1, "clip bitmap error:" + th5.getMessage());
            }
        }
        return null;
    }

    public static String compressImageForGroup(Context context, String str, int i3) {
        String str2 = AppConstants.SDCARD_PATH + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        int i16 = 600;
        int i17 = 800;
        try {
            compressImagetoSize(context, str, str2, 600, 800);
            int i18 = 0;
            while (new File(str2).length() > i3 && i18 < 3) {
                i18++;
                i16 -= 100;
                i17 -= 100;
                compressImagetoSize(context, str, str2, Math.max(100, i16), Math.max(100, i17));
            }
            String thumbPath = getThumbPath(context, Uri.parse(str));
            String thumbPath2 = getThumbPath(context, Uri.parse(str2));
            File file = new File(thumbPath);
            if (file.exists()) {
                file.renameTo(new File(thumbPath2));
            } else {
                compressImagetoSize(context, str2, thumbPath2, 160, 160);
            }
            return str2;
        } catch (Exception e16) {
            logImage("compressImageForGroup exception", e16);
            return str;
        }
    }

    public static String compressImageJpg(String str, String str2, int i3, int i16, int i17) {
        return compressImageJpg(str, str2, i3, i16, i17, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void compressImagetoSize(Context context, String str, String str2, int i3, int i16) {
        Throwable th5;
        BufferedInputStream bufferedInputStream;
        Exception e16;
        BitmapFactory.Options sizeOpt;
        try {
            try {
                File file = new File(str);
                sizeOpt = getSizeOpt(file, i3, i16);
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Exception e17) {
                bufferedInputStream = null;
                e16 = e17;
            } catch (Throwable th6) {
                i3 = 0;
                th5 = th6;
                if (i3 != 0) {
                }
                throw th5;
            }
            try {
                try {
                    compressPngFile(bufferedInputStream, sizeOpt, str2);
                    i3 = bufferedInputStream;
                } catch (Exception e18) {
                    e16 = e18;
                    logImage("compress : compressImagetoSize" + e16.getMessage());
                    i3 = bufferedInputStream;
                    if (bufferedInputStream == null) {
                        return;
                    }
                    i3.close();
                }
                i3.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (i3 != 0) {
                try {
                    i3.close();
                } catch (IOException unused2) {
                }
            }
            throw th5;
        }
    }

    static String compressJPGFile(InputStream inputStream, BitmapFactory.Options options, String str, int i3, boolean z16) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        Bitmap decodeStream = SafeBitmapFactory.decodeStream(inputStream, null, options);
        if (z16) {
            decodeStream = imageCrop(decodeStream);
        }
        if (decodeStream == null) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ImageUtil", 2, "CompressJPGFile, destWidth = " + decodeStream.getWidth() + ", destHeight = " + decodeStream.getHeight());
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

    /* JADX WARN: Code restructure failed: missing block: B:34:0x008a, code lost:
    
        if (r6.exists() != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008c, code lost:
    
        r6.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0072, code lost:
    
        if (r6.exists() != false) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static String compressPngFile(InputStream inputStream, BitmapFactory.Options options, String str) {
        BufferedOutputStream bufferedOutputStream;
        Throwable th5;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeStream = SafeBitmapFactory.decodeStream(inputStream, null, options);
        if (decodeStream == null) {
            return null;
        }
        File createNewFile = createNewFile(str);
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(createNewFile));
        } catch (Exception unused) {
            bufferedOutputStream = null;
        } catch (OutOfMemoryError unused2) {
            bufferedOutputStream = null;
        } catch (Throwable th6) {
            bufferedOutputStream = null;
            th5 = th6;
        }
        try {
            decodeStream.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            try {
                bufferedOutputStream.close();
            } catch (IOException unused3) {
            }
            if (!decodeStream.isRecycled()) {
                decodeStream.recycle();
            }
            if (str == null && createNewFile != null && createNewFile.exists()) {
                createNewFile.delete();
                return str;
            }
            return str;
        } catch (Exception unused4) {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused5) {
                }
            }
            if (!decodeStream.isRecycled()) {
                decodeStream.recycle();
            }
            if (createNewFile != null) {
            }
            return null;
        } catch (OutOfMemoryError unused6) {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused7) {
                }
            }
            if (!decodeStream.isRecycled()) {
                decodeStream.recycle();
            }
            if (createNewFile != null) {
            }
            return null;
        } catch (Throwable th7) {
            th5 = th7;
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused8) {
                }
            }
            if (!decodeStream.isRecycled()) {
                decodeStream.recycle();
            }
            if (str == null) {
                if (createNewFile != null) {
                    if (createNewFile.exists()) {
                        createNewFile.delete();
                        throw th5;
                    }
                    throw th5;
                }
                throw th5;
            }
            throw th5;
        }
    }

    private static int computeInitialSampleSize(BitmapFactory.Options options, int i3, int i16) {
        int ceil;
        int min;
        double d16 = options.outWidth;
        double d17 = options.outHeight;
        if (i16 == -1) {
            ceil = 1;
        } else {
            ceil = (int) Math.ceil(Math.sqrt((d16 * d17) / i16));
        }
        if (i3 == -1) {
            min = 128;
        } else {
            double d18 = i3;
            min = (int) Math.min(Math.floor(d16 / d18), Math.floor(d17 / d18));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i16 == -1 && i3 == -1) {
            return 1;
        }
        if (i3 == -1) {
            return ceil;
        }
        return min;
    }

    public static boolean copyExif(String str, String str2) {
        String str3 = "";
        if (str != null && !str.equals(str2) && !JpegExifReader.isCrashJpeg(str)) {
            try {
                ExifInterface exifInterface = new ExifInterface(str);
                ExifInterface exifInterface2 = new ExifInterface(str2);
                exifInterface2.setAttribute("Orientation", exifInterface.getAttributeInt("Orientation", 0) + "");
                String attribute = exifInterface.getAttribute("DateTime");
                if (attribute != null) {
                    str3 = attribute;
                }
                exifInterface2.setAttribute("DateTime", str3);
                exifInterface2.saveAttributes();
                return true;
            } catch (IOException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("ImageUtil", 2, "copyExif ", e16);
                }
            } catch (UnsupportedOperationException e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("ImageUtil", 2, "copyExif ", e17);
                }
                return false;
            }
        }
        return false;
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

    public static void cropAndCompressImage(String str, String str2, int i3, int i16) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            SafeBitmapFactory.decodeFile(str, options);
            if (options.outWidth < i3 && options.outHeight < i16) {
                compressImageJpg(str, str2, i3, i16, 100);
                return;
            }
            Bitmap decodeFile = SafeBitmapFactory.decodeFile(str);
            if (decodeFile.getWidth() < i3) {
                decodeFile.getWidth();
            } else if (decodeFile.getHeight() < i16) {
                decodeFile.getHeight();
            }
            saveBitmapFileAsJPEG(cutOutImg(decodeFile, i3, i16), new File(str));
        } catch (Error e16) {
            logImage(e16.toString());
        } catch (Exception e17) {
            logImage(e17.toString());
        }
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
            logImage("cutOurImg() img:[" + width + ", " + height + "], default: [" + f16 + ", " + f17 + "]");
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
            float f27 = i16;
            matrix.postScale(f26 / width, f27 / height);
            matrix.postTranslate((f16 - f26) / 2.0f, (f17 - f27) / 2.0f);
            Bitmap createBitmap = Bitmap.createBitmap((int) f16, (int) f17, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(bitmap, matrix, null);
            return createBitmap;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public static String decimalToDMS(double d16) {
        double d17 = d16 % 1.0d;
        String valueOf = String.valueOf((int) d16);
        double d18 = d17 * 60.0d;
        double d19 = d18 % 1.0d;
        int i3 = (int) d18;
        if (i3 < 0) {
            i3 *= -1;
        }
        String valueOf2 = String.valueOf(i3);
        int i16 = (int) (d19 * 60.0d);
        if (i16 < 0) {
            i16 *= -1;
        }
        return valueOf + "/1," + valueOf2 + "/1," + String.valueOf(i16) + "/1";
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(3:(3:27|28|(5:30|4|5|6|7))|6|7)|3|4|5|(3:(0)|(1:18)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        if (r1 != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0026, code lost:
    
        r4 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeFileWithBufferedStream(String str, BitmapFactory.Options options) {
        ?? r16;
        InputStream inputStream;
        Bitmap bitmap = null;
        try {
            if (options != null) {
                try {
                } catch (Throwable th5) {
                    Throwable th6 = th5;
                    r16 = bitmap;
                    try {
                        QLog.e("ImageUtil", 1, "", th6);
                        inputStream = r16;
                    } catch (Throwable th7) {
                        if (r16 != 0) {
                            try {
                                r16.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th7;
                    }
                }
                if (options.inJustDecodeBounds) {
                    r16 = new BufferedInputStream(new FileInputStream(str), 2048);
                    bitmap = BitmapFactory.decodeStream(r16, null, options);
                    inputStream = r16;
                    inputStream.close();
                }
            }
            inputStream.close();
        } catch (IOException unused2) {
            return bitmap;
        }
        r16 = new BufferedInputStream(new FileInputStream(str));
        bitmap = BitmapFactory.decodeStream(r16, null, options);
        inputStream = r16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001c, code lost:
    
        if (r2 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0018, code lost:
    
        if (r2 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeResourceStream(Resources resources, int i3) {
        BufferedInputStream bufferedInputStream;
        Bitmap bitmap = null;
        try {
            TypedValue typedValue = new TypedValue();
            bufferedInputStream = new BufferedInputStream(resources.openRawResource(i3, typedValue));
            try {
                bitmap = BitmapFactory.decodeResourceStream(resources, typedValue, bufferedInputStream, null, null);
            } catch (OutOfMemoryError unused) {
            } catch (Throwable unused2) {
            }
        } catch (OutOfMemoryError unused3) {
            bufferedInputStream = null;
        } catch (Throwable unused4) {
            bufferedInputStream = null;
        }
        try {
            bufferedInputStream.close();
        } catch (IOException unused5) {
            return bitmap;
        }
    }

    public static Bitmap decodeScaledBitmap(String str, int i3, int i16) {
        BufferedInputStream bufferedInputStream;
        BitmapFactory.Options options;
        BufferedInputStream bufferedInputStream2;
        Bitmap bitmap = null;
        if (str == null) {
            return null;
        }
        try {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                SafeBitmapFactory.decodeStream(bufferedInputStream, null, options2);
                int i17 = options2.outWidth;
                int i18 = options2.outHeight;
                options = new BitmapFactory.Options();
                options.inSampleSize = Math.max(i17 / i3, i18 / i16);
                options.inJustDecodeBounds = false;
                options.inPurgeable = true;
                bufferedInputStream.close();
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = null;
        }
        try {
            bitmap = SafeBitmapFactory.decodeStream(bufferedInputStream2, null, options);
            bufferedInputStream2.close();
        } catch (Throwable th7) {
            th = th7;
            bufferedInputStream = bufferedInputStream2;
            try {
                th.printStackTrace();
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                return bitmap;
            } catch (Throwable th8) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                throw th8;
            }
        }
        return bitmap;
    }

    public static void deletePic2SystemMedia(Context context, File file) {
        try {
            py3.b.e(context.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data='" + file.getAbsolutePath() + "'", null);
        } catch (Exception e16) {
            QLog.e("ImageUtil", 1, "deletePic2SystemMedia fail.", e16);
        }
    }

    public static Bitmap drawBitmapCoverLayer(Bitmap bitmap, boolean z16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        try {
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            if (createBitmap != null) {
                Canvas canvas = new Canvas(createBitmap);
                if (canvas.getDensity() != bitmap.getDensity()) {
                    canvas.setDensity(bitmap.getDensity());
                }
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                paint.setColor(Color.parseColor("#80000000"));
                RectF rectF = new RectF(0.0f, 0.0f, width, height);
                if (z16) {
                    canvas.drawRoundRect(rectF, width / 2, height / 2, paint);
                } else {
                    canvas.drawRect(rectF, paint);
                }
                return createBitmap;
            }
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ImageUtil", 2, "grey bitmap, oom, stack:" + MsfSdkUtils.getStackTraceString(e16));
            }
        }
        return bitmap;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap.Config config;
        Bitmap bitmap = null;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            try {
                if (drawable.getOpacity() != -1) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
                if (bitmap != null) {
                    Canvas canvas = new Canvas(bitmap);
                    drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                    drawable.draw(canvas);
                }
            } catch (OutOfMemoryError unused) {
            }
        }
        return bitmap;
    }

    public static Bitmap drawabletoBitmap(Drawable drawable) {
        Bitmap.Config config;
        Bitmap bitmap = null;
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicWidth2 = drawable.getIntrinsicWidth();
        if (intrinsicWidth > 0 && intrinsicWidth2 > 0) {
            try {
                if (drawable.getOpacity() != -1) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicWidth2, config);
                if (bitmap != null) {
                    Canvas canvas = new Canvas(bitmap);
                    drawable.setBounds(0, 0, intrinsicWidth, intrinsicWidth2);
                    drawable.draw(canvas);
                }
            } catch (OutOfMemoryError unused) {
            }
        }
        return bitmap;
    }

    public static Bitmap drawabletoBitmapV2(Drawable drawable, int i3, int i16) {
        Bitmap.Config config;
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            if (i3 > 0 && i16 > 0) {
                float f16 = intrinsicWidth;
                float f17 = i3 / f16;
                float f18 = intrinsicHeight;
                float f19 = i16 / f18;
                if (f17 >= f19) {
                    f17 = f19;
                }
                if (f17 < 1.0f) {
                    intrinsicWidth = (int) (f16 * f17);
                    intrinsicHeight = (int) (f18 * f17);
                }
            }
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                try {
                    if (drawable.getOpacity() != -1) {
                        config = Bitmap.Config.ARGB_8888;
                    } else {
                        config = Bitmap.Config.RGB_565;
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
                    if (createBitmap != null) {
                        Canvas canvas = new Canvas(createBitmap);
                        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                        drawable.draw(canvas);
                    }
                    return createBitmap;
                } catch (OutOfMemoryError unused) {
                }
            }
        }
        return null;
    }

    private static void ensureInitInject() {
        boolean z16;
        if (sBaseImage == null) {
            initQAutoInject();
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[AutoInject] inject:");
            if (sBaseImage != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("ImageUtil", 2, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void forceSyncFile(FileOutputStream fileOutputStream) throws IOException, SyncFailedException {
        fileOutputStream.flush();
        FileDescriptor fd5 = fileOutputStream.getFD();
        if (fd5 != null && fd5.valid()) {
            fd5.sync();
        }
    }

    @TargetApi(17)
    public static Bitmap gaussionBlur(Context context, Bitmap bitmap, float f16, float f17) {
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * f16), Math.round(bitmap.getHeight() * f16), false);
        Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap.getWidth(), createScaledBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        RenderScript create = RenderScript.create(context);
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
        Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
        create2.setRadius(f17);
        create2.setInput(createFromBitmap);
        create2.forEach(createFromBitmap2);
        createFromBitmap2.copyTo(createBitmap);
        createFromBitmap.destroy();
        createFromBitmap2.destroy();
        create2.destroy();
        create.destroy();
        return createBitmap;
    }

    public static StateListDrawable getBtnSelector(int i3, Context context) {
        if (context == null) {
            return null;
        }
        Drawable drawable = context.getResources().getDrawable(i3);
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable newDrawable = drawable.getConstantState().newDrawable();
        newDrawable.mutate().setAlpha(102);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, newDrawable);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static Bitmap getCicrlColorBitmap(Bitmap bitmap, int i3, int i16) {
        if (bitmap == null) {
            return null;
        }
        try {
            int i17 = i16 * 2;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth() + i17, bitmap.getHeight() + i17, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            Rect rect2 = new Rect(i16, i16, bitmap.getWidth() + i16, bitmap.getHeight() + i16);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            paint.setColor(i3);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(i16);
            canvas.drawCircle(r0 / 2, r2 / 2, (r0 / 2) - (i16 / 2), paint);
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static Bitmap getCircleFaceBitmap(Bitmap bitmap, int i3, int i16) {
        float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        int width = bitmap.getWidth();
        if (width > 0) {
            float f17 = width;
            float f18 = i3;
            if (f17 < f16 * f18) {
                f16 = f17 / f18;
            }
        }
        int i17 = (int) (i3 * f16);
        return getRoundedCornerBitmap(bitmap, i17, i17, (int) (i16 * f16));
    }

    public static Bitmap getClipCenterRectBitmap(Bitmap bitmap, int i3, int i16) {
        if (bitmap != null && i3 > 0 && i16 > 0) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Paint paint = new Paint();
                int i17 = width > i3 ? (width - i3) / 2 : 0;
                int i18 = height > i16 ? (height - i16) / 2 : 0;
                int i19 = i3 + i17;
                if (i19 <= width) {
                    width = i19;
                }
                int i26 = i16 + i18;
                if (i26 <= height) {
                    height = i26;
                }
                Rect rect = new Rect(i17, i18, width, height);
                Rect rect2 = new Rect(0, 0, width - i17, height - i18);
                RectF rectF = new RectF(rect2);
                Bitmap createBitmap = Bitmap.createBitmap(rect2.right, rect2.bottom, Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                paint.setAntiAlias(true);
                paint.setDither(true);
                paint.setFilterBitmap(true);
                canvas.drawARGB(0, 0, 0, 0);
                paint.setColor(-12434878);
                canvas.drawRect(rectF, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(bitmap, rect, rect2, paint);
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                return createBitmap;
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("ImageUtil", 2, "getClipCenterRectBitmap throw error ... " + th5.getMessage());
                }
            }
        }
        return null;
    }

    public static Bitmap getClipCenterRoundedCornerBitmap(Bitmap bitmap, int i3, int i16, float f16) {
        Bitmap clipCenterRectBitmap = getClipCenterRectBitmap(bitmap, i3, i16);
        if (clipCenterRectBitmap != null) {
            return getRoundedCornerBitmap3(clipCenterRectBitmap, f16, i3, i16);
        }
        return null;
    }

    public static Bitmap getClipRectBitmapScale(Bitmap bitmap, Rect rect, int i3) {
        if (bitmap != null) {
            try {
                if (rect.left >= 0 && rect.top >= 0 && rect.right <= bitmap.getWidth() && rect.bottom <= bitmap.getHeight()) {
                    Paint paint = new Paint();
                    Rect rect2 = new Rect(0, 0, rect.width() / i3, rect.height() / i3);
                    RectF rectF = new RectF(rect2);
                    Bitmap createBitmap = Bitmap.createBitmap(rect2.width(), rect2.height(), Bitmap.Config.RGB_565);
                    Canvas canvas = new Canvas(createBitmap);
                    paint.setAntiAlias(true);
                    paint.setDither(true);
                    paint.setFilterBitmap(true);
                    canvas.drawARGB(0, 0, 0, 0);
                    paint.setColor(-12434878);
                    canvas.drawRect(rectF, paint);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                    canvas.drawBitmap(bitmap, rect, rect2, paint);
                    if (!bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                    return createBitmap;
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("ImageUtil", 2, "getClipRectBitmap throw error ... " + th5.getMessage());
                }
            }
        }
        return null;
    }

    public static Bitmap getDefaultDiscusionFaceBitmap() {
        Bitmap f16 = ImageCacheHelper.f98636a.f("static://DefaultDiscusionFace");
        if (f16 == null) {
            try {
                f16 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), com.tencent.mobileqq.R.drawable.bqc);
            } catch (OutOfMemoryError unused) {
            }
            if (f16 != null) {
                ImageCacheHelper.f98636a.i("static://DefaultDiscusionFace", f16, Business.Conversation);
            }
        }
        return f16;
    }

    public static Drawable getDefaultDiscusionFaceDrawable() {
        return new BitmapDrawable(getDefaultDiscusionFaceBitmap());
    }

    public static Bitmap getDefaultFaceBitmap() {
        return getDefaultFaceBitmap(true);
    }

    public static Bitmap getDefaultFaceBitmap140_140() {
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f("static://DefaultFace140_140");
        if (f16 == null) {
            f16 = com.tencent.mobileqq.util.j.h(BaseApplication.getContext().getResources(), com.tencent.mobileqq.R.drawable.cop);
            if (f16 != null) {
                imageCacheHelper.i("static://DefaultFace140_140", f16, Business.Conversation);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ImageUtil", 2, "getDefaultFaceBitmap140_140, bitmap=" + f16);
            }
        }
        return f16;
    }

    public static Drawable getDefaultFaceDrawable() {
        return new BitmapDrawable(getDefaultFaceBitmap());
    }

    public static Drawable getDefaultFaceDrawable140_140() {
        return new BitmapDrawable(getDefaultFaceBitmap140_140());
    }

    public static Bitmap getDefaultPhoneContactBitmap() {
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f("static://DefaultPhoneContactFace");
        if (f16 == null) {
            f16 = com.tencent.mobileqq.util.j.h(BaseApplication.getContext().getResources(), com.tencent.mobileqq.R.drawable.cq9);
            if (f16 != null) {
                imageCacheHelper.i("static://DefaultPhoneContactFace", f16, Business.Default);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ImageUtil", 2, "getDefaultPhoneContactBitmap, bitmap=" + f16);
            }
        }
        return f16;
    }

    public static Bitmap getDefaultSubAccountFaceBitmap() {
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f("static://DefaultSubAccountFace");
        if (f16 == null && (f16 = com.tencent.mobileqq.util.j.h(BaseApplication.getContext().getResources(), com.tencent.mobileqq.R.drawable.icon_recent_subaccount)) != null) {
            imageCacheHelper.i("static://DefaultSubAccountFace", f16, Business.Conversation);
        }
        return f16;
    }

    public static Drawable getDefaultSubAccountFaceDrawable() {
        return new BitmapDrawable(getDefaultSubAccountFaceBitmap());
    }

    public static Bitmap getDefaultSystemIconBitmap() {
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f("static://DefaultSystemIcon");
        if (f16 == null && (f16 = com.tencent.mobileqq.util.j.h(BaseApplication.getContext().getResources(), com.tencent.mobileqq.R.drawable.b5_)) != null) {
            imageCacheHelper.i("static://DefaultSystemIcon", f16, Business.Conversation);
        }
        return f16;
    }

    public static Bitmap getDefaultTroopFaceBitmap() {
        String str;
        int i3;
        if (QQTheme.isNowSimpleUI()) {
            str = "static://DefaultTroopFace_square";
            i3 = com.tencent.mobileqq.R.drawable.coo;
        } else {
            str = "static://DefaultTroopFace";
            i3 = com.tencent.mobileqq.R.drawable.bqc;
        }
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(str);
        if (f16 == null && (f16 = getRoundFaceBitmap(com.tencent.mobileqq.util.j.h(BaseApplication.getContext().getResources(), i3), 50, 50)) != null) {
            imageCacheHelper.i(str, f16, Business.Conversation);
        }
        return f16;
    }

    public static Bitmap getDefaultTroopFaceBitmapInMemberList() {
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f("static://DefaultTroopFaceNew");
        if (f16 == null && (f16 = getRoundFaceBitmap(com.tencent.mobileqq.util.j.h(BaseApplication.getContext().getResources(), com.tencent.mobileqq.R.drawable.bqd), 50, 50)) != null) {
            imageCacheHelper.i("static://DefaultTroopFaceNew", f16, Business.AIO);
        }
        return f16;
    }

    public static Drawable getDefaultTroopFaceDrawable() {
        return new BitmapDrawable(getDefaultTroopFaceBitmap());
    }

    public static Drawable getDefaultTroopFaceDrawableNew() {
        return new BitmapDrawable(getDefaultTroopFaceBitmapInMemberList());
    }

    public static Bitmap getDrawableBitmap(Drawable drawable) {
        Bitmap.Config config;
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicWidth2 = drawable.getIntrinsicWidth();
        if (intrinsicWidth > 0 && intrinsicWidth2 > 0) {
            try {
                if (drawable.getOpacity() != -1) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicWidth2, config);
                if (createBitmap != null) {
                    new Canvas(createBitmap).drawBitmap(createBitmap, new Matrix(), new Paint());
                }
                return createBitmap;
            } catch (OutOfMemoryError unused) {
            }
        }
        return null;
    }

    public static int getExifOrientation(ExifInterface exifInterface) {
        int i3;
        if (exifInterface != null) {
            int attributeInt = exifInterface.getAttributeInt("Orientation", -1);
            logImage("getExifOrientation  orientation  =====" + attributeInt + "=====");
            if (attributeInt != -1) {
                if (attributeInt == 3) {
                    i3 = 180;
                } else if (attributeInt == 6) {
                    i3 = 90;
                } else if (attributeInt == 8) {
                    i3 = 270;
                }
                logImage("getExifOrientation degree =======" + i3 + "==========");
                return i3;
            }
        }
        i3 = 0;
        logImage("getExifOrientation degree =======" + i3 + "==========");
        return i3;
    }

    public static int getFaceSquareRadius(int i3) {
        if (i3 < 100) {
            return 3;
        }
        if (i3 < 140) {
            return 7;
        }
        return 10;
    }

    public static Bitmap getHalfRoundedBitmap(Bitmap bitmap, float f16, int i3, int i16) {
        Bitmap bitmap2 = bitmap;
        if (bitmap2 == null) {
            return null;
        }
        try {
            float f17 = i16;
            float min = Math.min(bitmap.getWidth() / i3, bitmap.getHeight() / f17);
            int ceil = (int) Math.ceil(bitmap.getWidth() / min);
            int ceil2 = (int) Math.ceil(bitmap.getHeight() / min);
            if (ceil != i3 || ceil2 != i16) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, ceil, ceil2, true);
                int i17 = (ceil - i3) / 2;
                if (i17 < 0) {
                    i17 = 0;
                }
                int i18 = (ceil2 - i16) / 2;
                if (i18 < 0) {
                    i18 = 0;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ImageUtil", 2, "HALF_ROUND_CORNER_DECODER scale = " + min + ", scaledWidth = " + ceil + ", scaledHeight = " + ceil2 + ", xTopLeft = " + i17 + ", yTopLeft = " + i18 + ", width = " + i3 + ", height = " + i16 + " roundPx: " + f16);
                }
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, i17, i18, i3, i16);
                createScaledBitmap.recycle();
                bitmap2 = createBitmap;
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap2);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            Rect rect2 = new Rect(0, 0, i3, i16);
            Rect rect3 = new Rect(0, (int) (f17 - f16), i3, (int) (f17 + f16));
            RectF rectF = new RectF(rect2);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f16, f16, paint);
            canvas.drawRect(rect3, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap2, rect, rect2, paint);
            return createBitmap2;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static int getImageDegree(String str) {
        int readOrientation = JpegExifReader.readOrientation(str);
        if (readOrientation != 3) {
            if (readOrientation != 6) {
                if (readOrientation != 8) {
                    return 0;
                }
                return 270;
            }
            return 90;
        }
        return 180;
    }

    private static String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public static double getOptRatio(InputStream inputStream, int i3, int i16) {
        double d16;
        double d17;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeStream(inputStream, null, options);
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

    public static Bitmap getPartRoundBitmap(Bitmap bitmap, float f16, int i3, int i16) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i17 = width - i3;
            int i18 = height - i16;
            Bitmap createBitmap = Bitmap.createBitmap(i17, i18, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, i16, i17, height);
            Rect rect2 = new Rect(0, 0, i17, i18);
            RectF rectF = new RectF(rect2);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            return createBitmap;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    private static void getPicArgs(ExifInterface exifInterface, ExifInterface exifInterface2, boolean z16) {
        String str;
        String attribute = exifInterface.getAttribute("DateTime");
        String attribute2 = exifInterface.getAttribute("Flash");
        String attribute3 = exifInterface.getAttribute("FocalLength");
        String attribute4 = exifInterface.getAttribute("GPSAltitude");
        String attribute5 = exifInterface.getAttribute("GPSAltitudeRef");
        String attribute6 = exifInterface.getAttribute("GPSDateStamp");
        String attribute7 = exifInterface.getAttribute("GPSLatitude");
        String attribute8 = exifInterface.getAttribute("GPSLatitudeRef");
        String attribute9 = exifInterface.getAttribute("GPSLongitude");
        String attribute10 = exifInterface.getAttribute("GPSLongitudeRef");
        String attribute11 = exifInterface.getAttribute("GPSProcessingMethod");
        String attribute12 = exifInterface.getAttribute("GPSTimeStamp");
        String attribute13 = exifInterface.getAttribute("ISOSpeedRatings");
        String attribute14 = exifInterface.getAttribute("Make");
        String attribute15 = exifInterface.getAttribute("Model");
        String attribute16 = exifInterface.getAttribute("WhiteBalance");
        String attribute17 = exifInterface.getAttribute("UserComment");
        String attribute18 = exifInterface.getAttribute("ImageDescription");
        if (attribute18 != null && QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            str = attribute17;
            sb5.append("E D = ");
            sb5.append(attribute18);
            QLog.d("ImageUtil", 2, sb5.toString());
        } else {
            str = attribute17;
        }
        if (attribute != null && z16) {
            exifInterface2.setAttribute("DateTime", attribute);
        } else {
            exifInterface2.setAttribute("DateTime", "");
        }
        if (attribute2 != null) {
            exifInterface2.setAttribute("Flash", attribute2);
        }
        if (attribute3 != null) {
            exifInterface2.setAttribute("FocalLength", attribute3);
        }
        if (attribute4 != null && z16) {
            exifInterface2.setAttribute("GPSAltitude", attribute4);
        }
        if (attribute5 != null && z16) {
            exifInterface2.setAttribute("GPSAltitudeRef", attribute5);
        }
        if (attribute6 != null && z16) {
            exifInterface2.setAttribute("GPSDateStamp", attribute6);
        }
        if (attribute7 != null && z16) {
            exifInterface2.setAttribute("GPSLatitude", attribute7);
        }
        if (attribute8 != null && z16) {
            exifInterface2.setAttribute("GPSLatitudeRef", attribute8);
        }
        if (attribute9 != null && z16) {
            exifInterface2.setAttribute("GPSLongitude", attribute9);
        }
        if (attribute10 != null && z16) {
            exifInterface2.setAttribute("GPSLongitudeRef", attribute10);
        }
        if (attribute11 != null && z16) {
            exifInterface2.setAttribute("GPSProcessingMethod", attribute11);
        }
        if (attribute12 != null && z16) {
            exifInterface2.setAttribute("GPSTimeStamp", attribute12);
        }
        if (attribute13 != null) {
            exifInterface2.setAttribute("ISOSpeedRatings", attribute13);
        }
        if (attribute14 != null && z16) {
            exifInterface2.setAttribute("Make", attribute14);
        }
        if (attribute15 != null && z16) {
            exifInterface2.setAttribute("Model", attribute15);
        }
        if (attribute16 != null) {
            exifInterface2.setAttribute("WhiteBalance", attribute16);
        }
        if (str != null && z16) {
            exifInterface2.setAttribute("UserComment", str);
        }
    }

    public static String getRealPathFromContentURI(Context context, Uri uri) {
        return FileProvider7Helper.getRealPathFromContentURI(context, uri);
    }

    public static int getRotateDegree(String str) {
        Object obj;
        int i3;
        try {
            obj = Class.forName("android.media.ExifInterface").getConstructor(String.class).newInstance(str);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("reflection", 2, "e = " + e16.toString());
            }
            obj = null;
        }
        if (obj == null) {
            return 0;
        }
        try {
            i3 = ((Integer) obj.getClass().getMethod("getAttributeInt", String.class, Integer.TYPE).invoke(obj, "Orientation", -1)).intValue();
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.e("reflection", 2, "e = " + e17.toString());
            }
            i3 = 0;
        }
        if (i3 == -1) {
            return 0;
        }
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

    public static Bitmap getRoundFaceBitmap(Bitmap bitmap, int i3, int i16) {
        float f16;
        if (bitmap == null) {
            return null;
        }
        float f17 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        int width = bitmap.getWidth();
        if (width > 0) {
            float f18 = width;
            float f19 = i3;
            if (f18 < f17 * f19) {
                f17 = f18 / f19;
            }
        }
        int i17 = (i3 + i16) / 2;
        if (i17 < 35) {
            f16 = 2.0f;
        } else if (i17 < 50) {
            f16 = 3.0f;
        } else if (i17 < 64) {
            f16 = 5.0f;
        } else {
            f16 = 6.0f;
        }
        return getRoundedCornerBitmap(bitmap, (int) (f16 * f17), (int) (i3 * f17), (int) (i16 * f17));
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float f16, int i3, int i16) {
        return getRoundedCornerBitmap(bitmap, f16, false, i3, i16);
    }

    public static Bitmap getRoundedCornerBitmap2(Bitmap bitmap, float f16, int i3, int i16) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            createBitmap.setDensity(BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            Rect rect2 = new Rect(0, 0, i3, i16);
            RectF rectF = new RectF(rect2);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            return createBitmap;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static Bitmap getRoundedCornerBitmap3(Bitmap bitmap, float f16, int i3, int i16) {
        if (bitmap == null) {
            return null;
        }
        try {
            float min = Math.min(bitmap.getWidth() / i3, bitmap.getHeight() / i16);
            int ceil = (int) Math.ceil(bitmap.getWidth() / min);
            int ceil2 = (int) Math.ceil(bitmap.getHeight() / min);
            if (ceil != i3 || ceil2 != i16) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, ceil, ceil2, true);
                int i17 = (ceil - i3) / 2;
                if (i17 < 0) {
                    i17 = 0;
                }
                int i18 = (ceil2 - i16) / 2;
                if (i18 < 0) {
                    i18 = 0;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("ImageUtil", 2, "ROUND_CORNER_DECODER scale = " + min + ", scaledWidth = " + ceil + ", scaledHeight = " + ceil2 + ", xTopLeft = " + i17 + ", yTopLeft = " + i18 + ", width = " + i3 + ", height = " + i16);
                }
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, i17, i18, i3, i16);
                createScaledBitmap.recycle();
                bitmap = createBitmap;
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap2);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            Rect rect2 = new Rect(0, 0, i3, i16);
            RectF rectF = new RectF(rect2);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-16777216);
            canvas.drawRoundRect(rectF, f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            bitmap.recycle();
            return createBitmap2;
        } catch (Throwable th5) {
            th5.printStackTrace();
            if (QLog.isDevelopLevel()) {
                QLog.w("ImageUtil", 2, "ROUND_CORNER_DECODER bitmap == null, ", th5);
            }
            return null;
        }
    }

    public static Bitmap getRoundedCornerBitmap4(Bitmap bitmap, int i3, int i16, int i17, int i18) {
        Rect rect;
        Bitmap bitmap2 = bitmap;
        if (bitmap2 == null) {
            return null;
        }
        try {
            float min = Math.min(bitmap.getWidth() / i3, bitmap.getHeight() / i16);
            int ceil = (int) Math.ceil(bitmap.getWidth() / min);
            int ceil2 = (int) Math.ceil(bitmap.getHeight() / min);
            if (ceil != i3 || ceil2 != i16) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, ceil, ceil2, true);
                int i19 = (ceil - i3) / 2;
                if (i19 < 0) {
                    i19 = 0;
                }
                int i26 = (ceil2 - i16) / 2;
                if (i26 < 0) {
                    i26 = 0;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("ImageUtil", 2, "ROUND_CORNER_DECODER scale = " + min + ", scaledWidth = " + ceil + ", scaledHeight = " + ceil2 + ", xTopLeft = " + i19 + ", yTopLeft = " + i26 + ", width = " + i3 + ", height = " + i16);
                }
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, i19, i26, i3, i16);
                createScaledBitmap.recycle();
                bitmap2 = createBitmap;
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap2);
            Paint paint = new Paint();
            Rect rect2 = new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            Rect rect3 = new Rect(0, 0, i3, i16);
            RectF rectF = new RectF(rect3);
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 != 3) {
                        if (i18 != 4) {
                            rect = null;
                        } else {
                            rect = new Rect(-i17, 0, i3 - i17, i16);
                        }
                    } else {
                        rect = new Rect(i17, 0, i3 + i17, i16);
                    }
                } else {
                    rect = new Rect(0, -i17, i3, i16 - i17);
                }
            } else {
                rect = new Rect(0, i17, i3, i16 + i17);
            }
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-16777216);
            float f16 = i17;
            canvas.drawRoundRect(rectF, f16, f16, paint);
            if (rect != null) {
                canvas.drawRect(rect, paint);
            }
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap2, rect2, rect3, paint);
            bitmap2.recycle();
            return createBitmap2;
        } catch (Throwable th5) {
            th5.printStackTrace();
            if (QLog.isDevelopLevel()) {
                QLog.w("ImageUtil", 2, "ROUND_CORNER_DECODER bitmap == null, ", th5);
                return null;
            }
            return null;
        }
    }

    public static BitmapFactory.Options getSizeOpt(File file, int i3, int i16) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        FileInputStream fileInputStream = new FileInputStream(file);
        double optRatio = getOptRatio(fileInputStream, i3, i16);
        fileInputStream.close();
        options.inSampleSize = (int) optRatio;
        options.inJustDecodeBounds = true;
        FileInputStream fileInputStream2 = new FileInputStream(file);
        SafeBitmapFactory.decodeStream(fileInputStream2, null, options);
        fileInputStream2.close();
        int i17 = 0;
        while (options.outWidth > i3) {
            options.inSampleSize++;
            FileInputStream fileInputStream3 = new FileInputStream(file);
            SafeBitmapFactory.decodeStream(fileInputStream3, null, options);
            fileInputStream3.close();
            if (i17 > 3) {
                break;
            }
            i17++;
        }
        options.inJustDecodeBounds = false;
        return options;
    }

    public static String getThumbPath(Context context, Uri uri) {
        String str = AppConstants.SDCARD_PATH + "thumb/";
        if (uri == null) {
            return "";
        }
        String realPathFromContentURI = getRealPathFromContentURI(context, uri);
        if (realPathFromContentURI.startsWith(str)) {
            return realPathFromContentURI;
        }
        String str2 = str + realPathFromContentURI.hashCode() + realPathFromContentURI.substring(realPathFromContentURI.lastIndexOf("/") + 1);
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    public static String getToSendPicPath(Context context, Uri uri) {
        if (uri == null) {
            return "";
        }
        String realPathFromContentURI = getRealPathFromContentURI(context, uri);
        return AppConstants.SDCARD_PATH + "photo/" + realPathFromContentURI.hashCode() + realPathFromContentURI.substring(realPathFromContentURI.lastIndexOf("/") + 1);
    }

    public static String getTypeByStream(FileInputStream fileInputStream) {
        byte[] bArr = new byte[8];
        try {
            fileInputStream.read(bArr, 0, 8);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        String upperCase = HexUtil.bytes2HexStr(bArr).toUpperCase();
        if (upperCase.contains(HippyImageInfo.IMAGE_FLAG_JPG)) {
            return "jpg";
        }
        if (upperCase.contains(HippyImageInfo.IMAGE_FLAG_PNG)) {
            return "png";
        }
        if (upperCase.contains(HippyImageInfo.IMAGE_FLAG_GIF)) {
            return "gif";
        }
        if (upperCase.contains(HippyImageInfo.IMAGE_FLAG_TIF)) {
            return HippyImageInfo.IMAGE_TYPE_TIF;
        }
        if (upperCase.contains(HippyImageInfo.IMAGE_FLAG_BMP)) {
            return "bmp";
        }
        if (upperCase.contains("0A")) {
            return "pcx";
        }
        if (!upperCase.contains("4D4D") && !upperCase.contains("4949")) {
            if (upperCase.contains("464F524D")) {
                return "iff";
            }
            if (upperCase.contains("52494646")) {
                return "ani";
            }
            if (upperCase.contains("0000020000")) {
                return "tga";
            }
            if (upperCase.contains("0000100000")) {
                return "rle";
            }
            if (upperCase.contains("0000010001002020")) {
                return "ico";
            }
            if (upperCase.contains("0000020001002020")) {
                return "cur";
            }
            return upperCase;
        }
        return "tiff";
    }

    public static final Bitmap grey(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
            if (createBitmap != null) {
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setSaturation(0.0f);
                paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                return createBitmap;
            }
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ImageUtil", 2, "grey bitmap, oom, stack:" + MsfSdkUtils.getStackTraceString(e16));
            }
        }
        return bitmap;
    }

    public static Bitmap imageCrop(Bitmap bitmap) {
        int i3;
        int i16;
        int i17;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > height) {
                i3 = height;
            } else {
                i3 = width;
            }
            if (width > height) {
                i16 = (width - height) / 2;
            } else {
                i16 = 0;
            }
            if (width > height) {
                i17 = 0;
            } else {
                i17 = (height - width) / 2;
            }
            return Bitmap.createBitmap(bitmap, i16, i17, i3, i3, (Matrix) null, false);
        }
        return null;
    }

    @QAutoInitMethod
    static void initQAutoInject() {
        sBaseImage = (com.tencent.mobileqq.inject.c) com.tencent.mobileqq.qroute.utils.b.a(sBaseImage_AutoGenClazzList_QAutoInjectTransform);
    }

    public static boolean isGifFile(String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean isGifFile = GifDrawable.isGifFile(new File(str));
            if (QLog.isColorLevel()) {
                QLog.d(PeakConstants.TAG, 2, "isGifFile result:" + isGifFile);
            }
            return isGifFile;
        }
        return false;
    }

    public static boolean isJPEGImage(String str) {
        boolean z16 = false;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            z16 = "jpg".equals(getTypeByStream(fileInputStream));
            fileInputStream.close();
            return z16;
        } catch (Exception e16) {
            logImage(e16.toString());
            return z16;
        }
    }

    public static boolean isValidPic(String str) {
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            SafeBitmapFactory.decodeFile(str, options);
        } catch (Exception | OutOfMemoryError unused) {
        }
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BitmapFactory.Options jusDecodeBounds(File file) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(file.getPath(), options);
        return options;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void logImage(String str) {
        com.tencent.mobileqq.inject.c cVar;
        ensureInitInject();
        if (QLog.isColorLevel() || ((cVar = sBaseImage) != null && cVar.isActiveReporting())) {
            QLog.e("ImageUtil", 2, str);
        }
    }

    public static Drawable maskDrawableByColor(Drawable drawable, int i3) {
        Drawable mutate;
        boolean z16;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof SkinnableBitmapDrawable) {
            mutate = ((SkinnableBitmapDrawable) drawable).mutate2();
            z16 = true;
        } else {
            mutate = drawable.getConstantState().newDrawable().mutate();
            z16 = false;
        }
        mutate.setColorFilter(new LightingColorFilter(0, i3));
        if (z16) {
            mutate.invalidateSelf();
        }
        return mutate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportSendPhoto(String str, Context context, boolean z16) {
        ensureInitInject();
        com.tencent.mobileqq.inject.c cVar = sBaseImage;
        if (cVar != null) {
            cVar.a(str, context, z16);
        }
    }

    public static Bitmap rgb565Toargb888(Bitmap bitmap) {
        int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, createBitmap.getWidth(), 0, 0, createBitmap.getWidth(), createBitmap.getHeight());
        return createBitmap;
    }

    public static Bitmap rotateAndFrame(Bitmap bitmap, float f16) {
        double radians = Math.toRadians(f16);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double abs = Math.abs(Math.cos(radians));
        double abs2 = Math.abs(Math.sin(radians));
        double d16 = height;
        double d17 = width;
        int i3 = (int) ((d16 * abs2) + (d17 * abs));
        int i16 = (int) ((d17 * abs2) + (d16 * abs));
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.rotate(f16, i3 / 2.0f, i16 / 2.0f);
        canvas.drawBitmap(bitmap, (i3 - width) / 2.0f, (i16 - height) / 2.0f, (Paint) null);
        return createBitmap;
    }

    public static final Bitmap round(Bitmap bitmap, float f16) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        try {
            bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e16) {
            logImage("OOM occurred in ImageUtil.round" + e16.getMessage());
        }
        if (bitmap2 != null) {
            Canvas canvas = new Canvas(bitmap2);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectF = new RectF(rect);
            paint.setAntiAlias(true);
            canvas.drawRoundRect(rectF, f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
        }
        return bitmap2;
    }

    public static final void roundInCanvas(Bitmap bitmap, Canvas canvas, int i3, int i16, float f16, int i17) {
        if (bitmap != null && canvas != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Rect rect = new Rect(i3, i16, width + i3, height + i16);
            Rect rect2 = new Rect(0, 0, width, height);
            RectF rectF = new RectF(rect2);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(i17);
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            canvas2.drawRoundRect(rectF, f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas2.drawBitmap(bitmap, rect2, rect2, paint);
            canvas.drawBitmap(createBitmap, rect2, rect, (Paint) null);
        }
    }

    public static boolean saveBitmapFileAsJPEG(Bitmap bitmap, int i3, File file) throws IOException {
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
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i3, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    bufferedOutputStream2.close();
                    return true;
                } catch (IOException e16) {
                    throw e16;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e17) {
            throw e17;
        }
    }

    public static boolean saveBitmapFileAsPNG(Bitmap bitmap, int i3, File file) throws IOException {
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
                    bitmap.compress(Bitmap.CompressFormat.PNG, i3, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    bufferedOutputStream2.close();
                    return true;
                } catch (IOException e16) {
                    throw e16;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e17) {
            throw e17;
        }
    }

    public static void saveBitmapToFile(Bitmap bitmap, File file) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        File file2 = new File(file.getParent());
        if (!file2.exists() || !file2.isDirectory()) {
            file2.mkdirs();
        }
        if (!file.exists() || !file.isFile()) {
            file.createNewFile();
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (IOException unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException unused2) {
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
            }
            throw th;
        }
    }

    public static boolean saveExif(ExifInterface exifInterface, ExifInterface exifInterface2) {
        return saveExif(exifInterface, exifInterface2, true);
    }

    public static void savePhotoToSysAlbum(Context context, String str) {
        FileProvider7Helper.savePhotoToSysAlbum(context, str);
    }

    public static void savePic2SystemMedia(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(absolutePath, options);
        String str = options.outMimeType;
        if (str == null) {
            str = getMimeType(absolutePath);
            QLog.d("ImageUtil", 1, "path:", absolutePath, ", mimeType:", str);
        }
        int imageDegree = getImageDegree(absolutePath);
        ContentValues contentValues = new ContentValues(7);
        contentValues.put("title", file.getName());
        contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, file.getName());
        contentValues.put("date_modified", Long.valueOf(file.lastModified() / 1000));
        contentValues.put(JobDbManager.COL_UP_MIME_TYPE, str);
        contentValues.put("orientation", Integer.valueOf(imageDegree));
        contentValues.put("_data", absolutePath);
        contentValues.put("_size", Long.valueOf(file.length()));
        try {
            if (context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues) == null) {
                QLog.d("ImageUtil", 1, "uri is null, values: ", contentValues);
                MediaStore.Images.Media.insertImage(context.getContentResolver(), absolutePath, file.getName(), (String) null);
            }
        } catch (Exception e16) {
            QLog.e("ImageUtil", 1, "savePic2SystemMedia fail.", e16);
        }
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int i3) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float max = i3 / (Math.max(width, height) * 1.0f);
        if (max != 1.0f && max > 0.0f) {
            try {
                matrix.postScale(max, max);
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (Exception e16) {
                logImage("compress :" + e16.getMessage());
            } catch (OutOfMemoryError unused) {
                logImage("compress :  scaleBitmap OOM");
            }
        }
        if (bitmap2 != null) {
            if (!bitmap.isRecycled() && !bitmap.equals(bitmap2)) {
                bitmap.recycle();
            }
            return bitmap2;
        }
        return bitmap;
    }

    public static int scaleFromDensity(int i3, int i16, int i17) {
        if (i16 != 0 && i16 != i17) {
            return ((i3 * i17) + (i16 >> 1)) / i16;
        }
        return i3;
    }

    private static void scaleThumbTo(Rect rect, int i3, int i16, int i17) {
        if (i3 > i16) {
            rect.set(0, 0, i17, (int) ((i17 / i3) * i16));
        } else {
            rect.set(0, 0, (int) ((i17 / i16) * i3), i17);
        }
    }

    public static void setBackgroundBitmapWhenOOM(Resources resources, View view, int i3) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inInputShareable = true;
            options.inPurgeable = true;
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inSampleSize = 2;
            view.setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeResource(resources, i3, options)));
        } catch (OutOfMemoryError unused) {
        }
    }

    public static void transferFile(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            File file = new File(str);
            File createNewFile = createNewFile(str2);
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(createNewFile);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read >= 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    }
                    fileInputStream2.close();
                } catch (Exception unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (fileOutputStream == null) {
                        return;
                    }
                    fileOutputStream.close();
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (IOException unused5) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception unused6) {
                fileOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
            }
        } catch (Exception unused7) {
            fileOutputStream = null;
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.close();
        } catch (IOException unused8) {
        }
    }

    public static boolean updateExif(String str, String str2, String str3) {
        if (str != null && !JpegExifReader.isCrashJpeg(str)) {
            try {
                ExifInterface exifInterface = new ExifInterface(str);
                exifInterface.setAttribute("Orientation", str3);
                exifInterface.saveAttributes();
                if (QLog.isDevelopLevel()) {
                    QLog.d("ImageUtil", 4, "[updateExif]tag=" + str2 + ", value=" + str3);
                    return true;
                }
                return true;
            } catch (IOException | NullPointerException | UnsupportedOperationException unused) {
            }
        }
        return false;
    }

    public static boolean updateLBSExif(String str, double d16, double d17) {
        String str2;
        String str3;
        if (str != null && !JpegExifReader.isCrashJpeg(str)) {
            try {
                ExifInterface exifInterface = new ExifInterface(str);
                exifInterface.setAttribute("GPSLatitude", decimalToDMS(d16));
                if (d16 > 0.0d) {
                    str2 = "N";
                } else {
                    str2 = androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH;
                }
                exifInterface.setAttribute("GPSLatitudeRef", str2);
                exifInterface.setAttribute("GPSLongitude", decimalToDMS(d17));
                if (d17 > 0.0d) {
                    str3 = "E";
                } else {
                    str3 = "W";
                }
                exifInterface.setAttribute("GPSLongitudeRef", str3);
                exifInterface.saveAttributes();
                if (QLog.isDevelopLevel()) {
                    QLog.d("ImageUtil", 4, "[updateLBSExif]GPSLatitude = " + exifInterface.getAttribute("GPSLatitude") + ", GPSLongitude = " + exifInterface.getAttribute("GPSLongitude"));
                    return true;
                }
                return true;
            } catch (IOException | NullPointerException unused) {
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ImageUtil", 4, "[updateLBSExif] failed");
            return false;
        }
        return false;
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
    public static String compressImageJpg(String str, String str2, int i3, int i16, int i17, boolean z16) {
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
                str3 = compressJPGFile(fileInputStream, sizeOpt, str2, Math.min(100, i17), z16);
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

    public static Bitmap getDefaultFaceBitmap(boolean z16) {
        String str;
        int i3;
        if (z16 || !QQTheme.isNowSimpleUI()) {
            str = "static://DefaultFace";
            i3 = com.tencent.mobileqq.R.drawable.f160830com;
        } else {
            str = "static://DefaultFace_square";
            i3 = com.tencent.mobileqq.R.drawable.coo;
        }
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(str);
        if (f16 == null) {
            f16 = com.tencent.mobileqq.util.j.h(BaseApplication.getContext().getResources(), i3);
            if (f16 != null) {
                imageCacheHelper.i(str, f16, Business.Conversation);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ImageUtil", 2, "getDefaultFaceBitmap, bitmap=" + f16);
            }
        }
        return f16;
    }

    public static Drawable getDefaultFaceDrawable(boolean z16) {
        return new BitmapDrawable(getDefaultFaceBitmap(z16));
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float f16, boolean z16, int i3, int i16) {
        int i17;
        int i18;
        int i19;
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i3 > width) {
                i3 = width;
            }
            if (i16 > height) {
                i16 = height;
            }
            if (width > height) {
                i19 = (width - height) / 2;
                i3 = i16;
                i17 = height;
                i18 = 0;
            } else if (height > width) {
                i16 = i3;
                i17 = width;
                i18 = (height - width) / 2;
                height = i17;
                i19 = 0;
            } else {
                i17 = height;
                i18 = 0;
                height = width;
                i19 = 0;
            }
            if (!z16) {
                f16 = i3;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(i19, i18, height + i19, i17 + i18);
            Rect rect2 = new Rect(0, 0, i3, i16);
            RectF rectF = new RectF(rect2);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            return createBitmap;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static boolean saveExif(ExifInterface exifInterface, ExifInterface exifInterface2, boolean z16) {
        if (exifInterface != null && exifInterface2 != null) {
            getPicArgs(exifInterface, exifInterface2, PicUploadExifInfoSwitch.getSwitch());
            String attribute = exifInterface.getAttribute("ImageLength");
            String attribute2 = exifInterface.getAttribute("ImageWidth");
            if (attribute != null) {
                exifInterface2.setAttribute("ImageLength", attribute);
            }
            if (attribute2 != null) {
                exifInterface2.setAttribute("ImageWidth", attribute2);
            }
            if (ZhuoXusManager.instance().isSendPicExifOpen()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (attribute != null) {
                        jSONObject.put("ImageLength", attribute);
                    }
                    if (attribute2 != null) {
                        jSONObject.put("ImageWidth", attribute2);
                    }
                    exifInterface2.setAttribute("ImageDescription", jSONObject.toString());
                    if (QLog.isColorLevel()) {
                        QLog.d("ImageUtil", 2, "s E D = " + jSONObject.toString());
                    }
                } catch (Throwable th5) {
                    logImage("F s d " + th5.getMessage());
                }
            }
            try {
                exifInterface2.saveAttributes();
                return true;
            } catch (Exception e16) {
                logImage("Failed to save EXIF. " + e16.getMessage());
            }
        }
        return false;
    }

    public static Bitmap getCircleFaceBitmap(Context context, Bitmap bitmap, int i3, int i16) {
        if (bitmap == null) {
            return null;
        }
        float f16 = context.getResources().getDisplayMetrics().density;
        int width = bitmap.getWidth();
        if (width > 0) {
            float f17 = width;
            float f18 = i3;
            if (f17 < f16 * f18) {
                f16 = f17 / f18;
            }
        }
        int i17 = (int) (i3 * f16);
        return getRoundedCornerBitmap(bitmap, i17, i17, (int) (i16 * f16));
    }

    public static int getExifOrientation(String str) {
        if (com.tencent.mobileqq.activity.photo.incompatiblephoto.b.a(str)) {
            int heifOrientation = Utils.getHeifOrientation(str);
            if (heifOrientation == 3) {
                return 180;
            }
            if (heifOrientation != 6) {
                return heifOrientation != 8 ? 0 : 270;
            }
            return 90;
        }
        return JpegExifReader.getRotationDegree(str);
    }

    private static void logImage(String str, Throwable th5) {
        com.tencent.mobileqq.inject.c cVar;
        ensureInitInject();
        if (QLog.isColorLevel() || ((cVar = sBaseImage) != null && cVar.isActiveReporting())) {
            QLog.e("ImageUtil", 2, str, th5);
        }
    }

    public static String getToSendPicPath(Context context, String str, int i3, int i16) {
        if (str == null) {
            return "";
        }
        File file = new File(str);
        long lastModified = file.exists() ? file.lastModified() : 0L;
        int i17 = 1;
        String substring = str.substring(str.lastIndexOf("/") + 1);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(AppConstants.SDCARD_PATH);
        stringBuffer.append("photo/");
        if (NetworkUtil.isWifiEnabled(context)) {
            stringBuffer.append(Global.TRACKING_WIFI);
        }
        if (i3 != 1 && i3 != 1001 && i3 != 10002 && i3 != 3000) {
            i17 = 0;
        }
        stringBuffer.append(i17);
        stringBuffer.append(ReportConstant.COSTREPORT_PREFIX);
        stringBuffer.append(i16);
        stringBuffer.append((str + lastModified).hashCode());
        stringBuffer.append(substring);
        return stringBuffer.toString();
    }

    public static String getThumbPath(Context context, String str) {
        if (str == null) {
            return "";
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "thumb/");
        if (str.startsWith(sDKPrivatePath)) {
            return str;
        }
        String str2 = sDKPrivatePath + str.hashCode() + str.substring(str.lastIndexOf("/") + 1);
        File file = new File(sDKPrivatePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    public static final Bitmap round(Bitmap bitmap, float f16, float f17, int i3) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        try {
            bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e16) {
            logImage("OOM occurred in ImageUtil.round" + e16.getMessage());
        }
        if (bitmap2 != null) {
            Canvas canvas = new Canvas(bitmap2);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectF = new RectF(rect);
            paint.setAntiAlias(true);
            canvas.drawRoundRect(rectF, f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            if (f17 > 0.0f) {
                paint.setColor(i3);
                paint.setAlpha(153);
                paint.setStrokeWidth(f17);
                paint.setStyle(Paint.Style.STROKE);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                canvas.drawRoundRect(rectF, f16, f16, paint);
            }
        }
        return bitmap2;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i3, int i16) {
        int i17 = 1;
        if (i3 != 0 && i16 != 0 && i3 != -1 && i16 != -1) {
            float f16 = options.outWidth * options.outHeight;
            float f17 = i3 * i16;
            while (true) {
                f16 /= f17;
                if (f16 <= 1.0f) {
                    break;
                }
                i17 *= 2;
                f17 = 4.0f;
            }
        }
        return i17;
    }

    public static boolean saveBitmapFileAsJPEG(Bitmap bitmap, File file) throws IOException {
        return saveBitmapFileAsJPEG(bitmap, 100, file);
    }

    public static String getToSendPicPath(String str, int i3) {
        return AppConstants.SDCARD_PATH + "photo/" + str.hashCode() + i3 + str.substring(str.lastIndexOf("/") + 1);
    }

    public static Bitmap getClipCenterRectBitmap(Bitmap bitmap, float f16) {
        int i3;
        int i16;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f17 = width;
        float f18 = height;
        float f19 = (1.0f * f17) / f18;
        if (f19 == f16) {
            return bitmap;
        }
        if (f19 > f16) {
            i16 = (int) (f18 * f16);
            i3 = height;
        } else {
            i3 = (int) (f17 / f16);
            i16 = width;
        }
        return Bitmap.createBitmap(bitmap, (width - i16) / 2, (height - i3) / 2, i16, i3);
    }
}
