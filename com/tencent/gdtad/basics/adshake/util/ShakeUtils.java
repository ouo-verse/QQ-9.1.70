package com.tencent.gdtad.basics.adshake.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ShakeUtils {
    private static final String TAG = "ShakeUtils";
    private static int sScreenHeightPixels;
    private static int sScreenWidthPixels;

    public static Bitmap bitmapFromBase64String(String str, int i3, int i16) {
        QLog.i(TAG, 1, "bitmapFromBase64String width:" + i3 + ", height:" + i16);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            if (decode == null || decode.length <= 0) {
                return null;
            }
            return createBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length), i3, i16, true);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "bitmapFromBase64String error." + th5.toString());
            return null;
        }
    }

    public static Bitmap bitmapFromBase64StringSafe(String str, int i3, int i16) {
        QLog.i(TAG, 1, "bitmapFromBase64String width:" + i3 + ", height:" + i16);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            if (decode == null || decode.length <= 0) {
                return null;
            }
            return scaleBitmapSafe(BitmapFactory.decodeByteArray(decode, 0, decode.length), i3, i16);
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "bitmapFromBase64String error." + th5.toString());
            return null;
        }
    }

    public static int buildColorFromARGB(float f16, float f17, float f18, float f19) {
        return (((int) ((f16 * 255.0f) + 0.5f)) << 24) | (((int) ((f17 * 255.0f) + 0.5f)) << 16) | (((int) ((f18 * 255.0f) + 0.5f)) << 8) | ((int) ((f19 * 255.0f) + 0.5f));
    }

    public static Bitmap createBitmap(Bitmap bitmap, int i3, int i16, boolean z16) {
        Bitmap createScaledBitmap;
        if (bitmap != null && ((bitmap.getWidth() != i3 || bitmap.getHeight() != i16) && i3 > 0 && i16 > 0 && (createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i3, i16, true)) != bitmap)) {
            if (z16) {
                bitmap.recycle();
            }
            return createScaledBitmap;
        }
        return bitmap;
    }

    public static int getRelativeSize(int i3) {
        return (int) ((getScreenWidth() * i3) / 750.0f);
    }

    public static int getRelativeSize375(int i3) {
        return (int) ((getScreenWidth() * i3) / 375.0f);
    }

    public static int getScreenHeight() {
        if (sScreenHeightPixels == 0) {
            initScreenSize();
        }
        return sScreenHeightPixels;
    }

    public static int getScreenWidth() {
        if (sScreenWidthPixels == 0) {
            initScreenSize();
        }
        return sScreenWidthPixels;
    }

    public static float getTextPaintBaselineToTop(float f16) {
        Paint paint = new Paint();
        paint.setTextSize(f16);
        return Math.abs(paint.getFontMetrics().top);
    }

    public static float getTextWidth(float f16, boolean z16, String str) {
        Typeface typeface;
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f16);
        if (z16) {
            typeface = Typeface.DEFAULT_BOLD;
        } else {
            typeface = Typeface.DEFAULT;
        }
        textPaint.setTypeface(typeface);
        return Layout.getDesiredWidth(str, textPaint);
    }

    public static void initScreenSize() {
        try {
            WindowManager windowManager = (WindowManager) BaseApplication.getContext().getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i3 = displayMetrics.widthPixels;
            int i16 = displayMetrics.heightPixels;
            sScreenWidthPixels = Math.min(i3, i16);
            sScreenHeightPixels = Math.max(i3, i16);
            QLog.i(TAG, 1, "sScreenWidthPixels = " + sScreenWidthPixels + ",sScreenHeightPixels = " + sScreenHeightPixels);
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "initScreenSize failed", th5);
        }
    }

    public static boolean isInDebug(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) == 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int safeParseColor(String str, int i3) {
        try {
            return Color.parseColor(str);
        } catch (Throwable unused) {
            QLog.i(TAG, 1, "can't parse color: " + str + ", use default instead.");
            return i3;
        }
    }

    public static Bitmap scaleBitmapSafe(Bitmap bitmap, int i3, int i16) {
        if (bitmap != null && ((bitmap.getWidth() != i3 || bitmap.getHeight() != i16) && i3 > 0 && i16 > 0)) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale(i3 / width, i16 / height);
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (Throwable th5) {
                QLog.i(TAG, 1, "scaleBitmapSafe error." + th5.toString());
            }
        }
        return bitmap;
    }
}
