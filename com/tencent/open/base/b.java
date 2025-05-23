package com.tencent.open.base;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BitmapUtil;
import java.io.File;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    public static BitmapFactory.Options a(BitmapFactory.Options options, int i3, int i16, boolean z16) {
        options.inJustDecodeBounds = false;
        options.inSampleSize = 2;
        if (!z16) {
            while (true) {
                int i17 = options.outWidth;
                int i18 = options.inSampleSize;
                if (i17 / i18 < i3 || options.outHeight / i18 < i16) {
                    break;
                }
                options.inSampleSize = i18 + 1;
            }
        } else {
            while (true) {
                int i19 = options.outWidth;
                int i26 = options.inSampleSize;
                if (i19 / i26 < i3 && options.outHeight / i26 < i16) {
                    break;
                }
                options.inSampleSize = i26 + 1;
            }
        }
        options.inSampleSize--;
        return options;
    }

    public static Bitmap b(Bitmap bitmap, int i3, int i16, BitmapFactory.Options options, boolean z16) {
        if (bitmap == null) {
            return null;
        }
        if (i3 == -1) {
            i3 = (options.outWidth * i16) / options.outHeight;
        }
        if (i16 == -1) {
            i16 = (options.outHeight * i3) / options.outWidth;
        }
        if (i3 != -1 && i16 != -1) {
            int i17 = options.outHeight;
            int i18 = options.outWidth;
            if (i17 > i18) {
                if (z16) {
                    i3 = (i18 * i16) / i17;
                } else {
                    i16 = (i17 * i3) / i18;
                }
            } else if (z16) {
                i16 = (i17 * i3) / i18;
            } else {
                i3 = (i18 * i16) / i17;
            }
        }
        return Bitmap.createScaledBitmap(bitmap, i3, i16, true);
    }

    public static BitmapFactory.Options c() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPurgeable = true;
        options.inInputShareable = true;
        return options;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap d(String str, int i3, int i16, boolean z16) {
        Bitmap bitmap;
        Bitmap.Config config;
        Bitmap bitmap2 = null;
        if (str == null || !new File(str).exists()) {
            return null;
        }
        try {
            BitmapFactory.Options c16 = c();
            BitmapFactory.decodeFile(str, c16);
            if (c16.outHeight <= 0 || c16.outWidth <= 0) {
                return null;
            }
            a(c16, i3, i16, z16);
            try {
                bitmap = BitmapFactory.decodeFile(str, c16);
            } catch (Exception e16) {
                QLog.e(BitmapUtil.TAG, 1, "loadResizedBitmap error", e16);
                bitmap = null;
            }
            if (bitmap == null) {
                return null;
            }
            try {
                if (bitmap.hasAlpha()) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                c16.inPreferredConfig = config;
                return b(bitmap, i3, i16, c16, z16);
            } catch (OutOfMemoryError e17) {
                bitmap2 = bitmap;
                e = e17;
                if (!QLog.isColorLevel()) {
                    QLog.d(BitmapUtil.TAG, 2, QLog.getStackTraceString(e));
                    return bitmap2;
                }
                return bitmap2;
            }
        } catch (OutOfMemoryError e18) {
            e = e18;
            if (!QLog.isColorLevel()) {
            }
        }
    }
}
