package com.tencent.ad.tangram.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import java.text.DecimalFormat;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdUIUtils {
    private static final String TAG = "AdUIUtils";

    public static final int dp2px(float f16, @Nullable Resources resources) {
        if (f16 != 0.0f && resources != null) {
            return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
        }
        return 0;
    }

    @NonNull
    public static String formatNumberToChineseUnit(long j3) {
        String str;
        try {
            DecimalFormat decimalFormat = new DecimalFormat("##0.00");
            if (j3 == 0) {
                return "";
            }
            double d16 = j3;
            if (d16 < 10000.0d) {
                str = String.valueOf(j3) + "\u6b21\u4e0b\u8f7d";
            } else if (d16 < 1.0E8d) {
                str = decimalFormat.format(d16 / 10000.0d) + "\u4e07\u6b21\u4e0b\u8f7d";
            } else {
                str = decimalFormat.format(d16 / 1.0E8d) + "\u4ebf\u6b21\u4e0b\u8f7d";
            }
            return str;
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static int formatStringToGravity(String str, String str2) throws Exception {
        if (!TextUtils.isEmpty(str)) {
            String upperCase = str.toUpperCase();
            upperCase.hashCode();
            char c16 = '\uffff';
            switch (upperCase.hashCode()) {
                case 2332679:
                    if (upperCase.equals("LEFT")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case 77974012:
                    if (upperCase.equals("RIGHT")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 1984282709:
                    if (upperCase.equals("CENTER")) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    return 8388611;
                case 1:
                    return 8388613;
                case 2:
                    return 17;
                default:
                    throw new Exception(str2 + " unknown gravity type");
            }
        }
        throw new Exception(str2 + " unknown gravity type");
    }

    public static int formatStringToRelativeLayoutRule(@Nullable String str, String str2) throws Exception {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    return 14;
                case 1:
                    return 9;
                case 2:
                    return 11;
                default:
                    throw new Exception(str2 + " unknown layout rule type");
            }
        }
        throw new Exception(str2 + " unknown layout rule type");
    }

    @Nullable
    public static Bitmap getBitmapFromString(String str) {
        byte[] decode;
        try {
            if (!TextUtils.isEmpty(str) && (decode = Base64.decode(str, 0)) != null && decode.length > 0) {
                return BitmapFactory.decodeByteArray(decode, 0, decode.length);
            }
            return null;
        } catch (Throwable th5) {
            AdLog.e(TAG, "getBitmapFromString error" + th5);
            return null;
        }
    }

    @NonNull
    public static String getFileSizeDesc(long j3) {
        String str;
        try {
            if (j3 < 1024) {
                str = j3 + "B";
            } else {
                DecimalFormat decimalFormat = new DecimalFormat("##0.0");
                double d16 = j3;
                if (d16 < 1048576.0d) {
                    str = decimalFormat.format(d16 / 1024.0d) + "K";
                } else if (d16 < 1.073741824E9d) {
                    str = decimalFormat.format(d16 / 1048576.0d) + "M";
                } else {
                    str = decimalFormat.format(d16 / 1.073741824E9d) + "G";
                }
            }
            return str;
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static int getPercentageFromString(@NonNull String str, String str2) throws Exception {
        try {
            return Integer.parseInt(str.substring(0, str.length() - 1));
        } catch (Exception unused) {
            throw new Exception(str2 + " unknown percent string");
        }
    }

    public static double getPercentageOfGlobalVisibleRect(@Nullable View view) {
        if (view == null) {
            return 0.0d;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect) || rect.left >= getScreenWidth(view.getContext()) || rect.top >= getScreenHeight(view.getContext()) || rect.right <= 0 || rect.bottom <= 0) {
            return 0.0d;
        }
        return ((rect.width() * 1.0d) * rect.height()) / (view.getWidth() * view.getHeight());
    }

    public static int getPhysicalScreenWidth(@Nullable Context context) {
        if (context == null || context.getResources() == null || context.getResources().getDisplayMetrics() == null) {
            AdLog.e(TAG, "getScreenWidth error");
            return Integer.MIN_VALUE;
        }
        int i3 = context.getResources().getDisplayMetrics().widthPixels;
        int i16 = context.getResources().getDisplayMetrics().heightPixels;
        if (i3 > i16) {
            return i16;
        }
        return i3;
    }

    public static int getPxFromString(@NonNull String str, String str2) throws Exception {
        try {
            return Integer.parseInt(str.substring(0, str.length() - 2));
        } catch (Exception unused) {
            throw new Exception(str2 + " unknown px string");
        }
    }

    public static int getScreenHeight(@Nullable Context context) {
        if (context == null || context.getResources() == null || context.getResources().getDisplayMetrics() == null) {
            AdLog.e(TAG, "getScreenHeight error");
            return Integer.MIN_VALUE;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(@Nullable Context context) {
        if (context == null || context.getResources() == null || context.getResources().getDisplayMetrics() == null) {
            AdLog.e(TAG, "getScreenWidth error");
            return Integer.MIN_VALUE;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getValueDependsOnScreenWidth(Context context, int i3, int i16) {
        if (i3 != 0) {
            return Double.valueOf(((i16 * 1.0d) * getPhysicalScreenWidth(context)) / i3).intValue();
        }
        return 0;
    }

    public static int px2dp(@Nullable Context context, int i3) {
        if (context != null && context.getResources() != null && context.getResources().getDisplayMetrics() != null) {
            float f16 = context.getResources().getDisplayMetrics().density;
            if (f16 <= 0.0f) {
                return Integer.MIN_VALUE;
            }
            return Math.round(i3 / f16);
        }
        return Integer.MIN_VALUE;
    }

    public static final int px2sp(int i3, @Nullable Context context) {
        if (context == null) {
            return 0;
        }
        return (int) ((i3 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
