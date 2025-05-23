package com.tencent.thumbplayer.common;

import android.text.TextUtils;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import java.math.BigDecimal;
import java.util.regex.Pattern;

/* loaded from: classes26.dex */
public class TPBasicTypeParseUtil {
    private static final String TAG = "TPBasicTypeParseUtil";

    public static boolean isNumeric(String str) {
        try {
            if (!Pattern.compile("-?[0-9]+(\\.[0-9]+)?").matcher(new BigDecimal(str).toString()).matches()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean optBoolean(String str, boolean z16) {
        if ("true".equalsIgnoreCase(str)) {
            return true;
        }
        if ("false".equalsIgnoreCase(str)) {
            return false;
        }
        return z16;
    }

    public static double optDouble(String str, double d16) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e16) {
                TPLogUtil.e(TAG, e16);
            }
        }
        return d16;
    }

    public static float optFloat(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException e16) {
                TPLogUtil.e(TAG, e16);
            }
        }
        return i3;
    }

    public static int optInt(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e16) {
                TPLogUtil.e(TAG, e16);
            }
        }
        return i3;
    }

    public static long optLong(String str, long j3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e16) {
                TPLogUtil.e(TAG, e16);
            }
        }
        return j3;
    }
}
