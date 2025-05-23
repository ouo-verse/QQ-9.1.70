package com.tencent.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NumberUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "NumberUtil";

    public NumberUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String intArrayToString(int[][] iArr) {
        StringBuilder sb5 = new StringBuilder("[");
        if (iArr != null && iArr.length > 0 && iArr[0].length > 0) {
            for (int[] iArr2 : iArr) {
                sb5.append("[");
                int i3 = 0;
                while (i3 < iArr2.length - 1) {
                    sb5.append(iArr2[i3]);
                    sb5.append(", ");
                    i3++;
                }
                sb5.append(iArr2[i3]);
                sb5.append("] ");
            }
        }
        sb5.append("]");
        return sb5.toString();
    }

    public static boolean stringToBoolean(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return z16;
        }
        try {
            return Boolean.parseBoolean(str);
        } catch (Exception e16) {
            QLog.d(TAG, 1, "stringToBoolean", e16);
            return z16;
        }
    }

    public static float stringToFloat(String str, float f16) {
        if (TextUtils.isEmpty(str)) {
            return f16;
        }
        try {
            return Float.valueOf(str).floatValue();
        } catch (NumberFormatException e16) {
            QLog.d(TAG, 1, "stringToFloat", e16);
            return f16;
        }
    }

    public static int stringToInt(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return i3;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e16) {
            QLog.d(TAG, 1, "stringToInt", e16);
            return i3;
        }
    }

    public static long stringToLong(String str, long j3) {
        if (TextUtils.isEmpty(str)) {
            return j3;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (NumberFormatException e16) {
            QLog.d(TAG, 1, "stringToLong", e16);
            return j3;
        }
    }

    public static boolean stringToBoolean(String str) {
        return stringToBoolean(str, false);
    }

    public static float stringToFloat(String str) {
        return stringToFloat(str, 0.0f);
    }

    public static int stringToInt(String str) {
        return stringToInt(str, 0);
    }

    public static long stringToLong(String str) {
        return stringToLong(str, 0L);
    }
}
