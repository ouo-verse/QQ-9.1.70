package com.tencent.biz.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    protected static String f78470a = "ImageUtil";

    public static byte[] a(Bitmap bitmap) {
        return BaseImageUtil.bitmap2Bytes(bitmap);
    }

    private static int b(BitmapFactory.Options options, int i3, int i16) {
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

    public static final int c(BitmapFactory.Options options, int i3, int i16) {
        int b16 = b(options, i3, i16);
        if (b16 <= 8) {
            int i17 = 1;
            while (i17 < b16) {
                i17 <<= 1;
            }
            return i17;
        }
        return 8 * ((b16 + 7) / 8);
    }

    public static Drawable d(Drawable drawable, int i3) {
        if (drawable == null) {
            return null;
        }
        Drawable mutate = drawable.getConstantState().newDrawable().mutate();
        mutate.setColorFilter(new LightingColorFilter(0, i3));
        return mutate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x007f -> B:23:0x0080). Please report as a decompilation issue!!! */
    public static String e(Context context, String str, Bundle bundle) {
        byte[] bArr;
        FileOutputStream fileOutputStream;
        if (str != 0 && !str.equals("")) {
            String str2 = AppConstants.SDCARD_FILE_SAVE_TMP_PATH;
            File file = new File(str2);
            file.mkdirs();
            if (!file.canWrite()) {
                if (QLog.isColorLevel()) {
                    QLog.d(f78470a, 2, "dir can't write");
                }
                return null;
            }
            String str3 = str2 + AbsDownloader.getFileName(str);
            File file2 = new File(str3);
            if (file2.exists()) {
                return str3;
            }
            try {
                try {
                } catch (OutOfMemoryError e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f78470a, 2, "saveTmpImage:" + e16.toString());
                    }
                    return null;
                }
            } catch (Exception unused) {
            }
            if (str.startsWith("data:")) {
                int indexOf = str.indexOf(44);
                if (indexOf > 0 && str.substring(0, indexOf).contains(";base64")) {
                    bArr = PluginBaseInfoHelper.Base64Helper.decode(str.substring(indexOf), 0);
                }
                bArr = null;
            } else {
                bArr = HttpUtil.openUrlForByte(context, str, "GET", null, bundle);
            }
            try {
                if (bArr == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f78470a, 2, "download error");
                    }
                    return null;
                }
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (IOException unused2) {
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    str = 0;
                    if (str != 0) {
                        try {
                            str.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
                try {
                    fileOutputStream.write(bArr);
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused4) {
                    }
                    return str3;
                } catch (IOException unused5) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f78470a, 2, "write data error");
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(f78470a, 2, "url is invalid");
            }
            return null;
        }
    }

    public static final Bitmap f(Bitmap bitmap, int i3) {
        int i16;
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > 0 && height > 0) {
            if (width > height) {
                i16 = width;
            } else {
                i16 = height;
            }
            if (i16 <= i3) {
                return bitmap;
            }
            float f16 = i3 / i16;
            Matrix matrix = new Matrix();
            matrix.postScale(f16, f16);
            try {
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e(f78470a, 2, "scaleBitmap, exp=", th5);
                }
            }
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        return bitmap2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Bitmap g(String str, int i3) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i16 = options.outWidth;
        int i17 = options.outHeight;
        if (options.mCancel || i16 == -1 || i17 == -1) {
            return null;
        }
        if (i16 <= i17) {
            i16 = i17;
        }
        Bitmap.Config config = Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (i16 > i3) {
            options.inSampleSize = c(options, -1, i3 * i3);
        }
        options.inJustDecodeBounds = false;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            } catch (Exception e16) {
                e = e16;
                bufferedInputStream = null;
            } catch (OutOfMemoryError unused) {
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedInputStream2 != null) {
                }
                throw th;
            }
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                try {
                    bufferedInputStream.close();
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e(f78470a, 2, "scaleBitmap, finally exception:", e17);
                    }
                }
                int i18 = options.outWidth;
                int i19 = options.outHeight;
                if (i18 <= i19) {
                    i18 = i19;
                }
                if (i18 > i3) {
                    return f(decodeStream, i3);
                }
                return decodeStream;
            } catch (Exception e18) {
                e = e18;
                if (QLog.isColorLevel()) {
                    QLog.e(f78470a, 2, "scaleBitmap, Exception", e);
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e19) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f78470a, 2, "scaleBitmap, finally exception:", e19);
                        }
                    }
                }
                return null;
            } catch (OutOfMemoryError unused2) {
                if (QLog.isColorLevel()) {
                    QLog.e(f78470a, 2, "scaleBitmap, OutOfMemoryError");
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e26) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f78470a, 2, "scaleBitmap, finally exception:", e26);
                        }
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream2 = config;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (Exception e27) {
                    if (QLog.isColorLevel()) {
                        QLog.e(f78470a, 2, "scaleBitmap, finally exception:", e27);
                    }
                }
            }
            throw th;
        }
    }
}
