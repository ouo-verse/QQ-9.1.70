package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.graphics.Color;

/* compiled from: P */
/* loaded from: classes4.dex */
public class Utils {
    private static final String TAG = "Utils_TMTEST";
    private static int UED_SCREEN = 375;
    private static float sDensity;
    private static int sScreenWidth;

    public static int dp2px(double d16) {
        float f16 = sDensity;
        if (f16 < 0.0f) {
            f16 = 1.0f;
        }
        if (d16 >= 0.0d) {
            return (int) ((d16 * f16) + 0.5d);
        }
        return -((int) (((-d16) * f16) + 0.5d));
    }

    public static void init(float f16, int i3) {
        sDensity = f16;
        sScreenWidth = i3;
    }

    public static boolean isDigit(char c16) {
        if (c16 >= '0' && c16 <= '9') {
            return true;
        }
        return false;
    }

    public static boolean isEL(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        if ((str.charAt(0) != '$' || str.charAt(1) != '{' || str.charAt(length - 1) != '}') && (str.charAt(0) != '@' || str.charAt(1) != '{' || str.charAt(length - 1) != '}')) {
            return false;
        }
        return true;
    }

    public static boolean isHex(char c16) {
        if ((c16 >= '0' && c16 <= '9') || ((c16 >= 'a' && c16 <= 'f') || (c16 >= 'A' && c16 <= 'F'))) {
            return true;
        }
        return false;
    }

    public static boolean isSpace(char c16) {
        if (' ' != c16 && '\t' != c16 && '\n' != c16) {
            return false;
        }
        return true;
    }

    public static boolean isThreeUnknown(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        if (str.charAt(0) != '@' || str.charAt(1) != '{' || str.charAt(length - 1) != '}') {
            return false;
        }
        return true;
    }

    public static int parseColor(String str) {
        try {
            return Integer.valueOf(Color.parseColor(str)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int px2dp(float f16) {
        float f17 = sDensity;
        if (f17 < 0.0f) {
            f17 = 1.0f;
        }
        return (int) ((f16 / f17) + 0.5f);
    }

    public static int rp2px(double d16) {
        return (int) (((d16 * sScreenWidth) / UED_SCREEN) + 0.5d);
    }

    public static void setUedScreenWidth(int i3) {
        UED_SCREEN = i3;
    }

    public static Boolean toBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if ("true".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
            return null;
        }
        return null;
    }

    public static Double toDouble(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    public static Float toFloat(Object obj) {
        if (obj instanceof Float) {
            return (Float) obj;
        }
        if (obj instanceof Double) {
            return Float.valueOf(((Double) obj).floatValue());
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            try {
                return Float.valueOf((String) obj);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    public static Integer toInteger(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            try {
                return Integer.valueOf((int) Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    public static Long toLong(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf((long) Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    public static String toString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    public static int rp2px(int i3, double d16) {
        sScreenWidth = i3;
        return rp2px(d16);
    }
}
