package com.tencent.pts.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes22.dex */
public final class PTSValueConvertUtil {
    static IPatchRedirector $redirector_ = null;
    private static float RPX_TO_DP_RATE = 0.0f;
    private static final String TAG = "PTSValueConvertUtil";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42019);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            RPX_TO_DP_RATE = PTSDeviceUtil.getScreenWidthDp() / 750.0f;
        }
    }

    PTSValueConvertUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Deprecated
    public static float dp2px(float f16) {
        return PTSDeviceUtil.dp2px(f16);
    }

    public static boolean getBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str) || TextUtils.equals("0", str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static int getColor(Object obj) {
        long j3;
        String valueOf;
        if (obj == 0) {
            return 0;
        }
        try {
            valueOf = String.valueOf(obj);
        } catch (Exception e16) {
            PTSLog.e(TAG, "getColor, value = " + obj + ", e = " + e16);
            j3 = 0;
        }
        if (TextUtils.isEmpty(valueOf)) {
            return 0;
        }
        if (TextUtils.isDigitsOnly(valueOf)) {
            long parseLong = Long.parseLong(valueOf);
            obj = 24;
            j3 = ((parseLong << 24) & (-16777216)) | ((parseLong >> 8) & 16777215);
        } else {
            int a16 = c.a(valueOf);
            j3 = a16;
            obj = a16;
        }
        return (int) j3;
    }

    public static float getFloat(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        if (obj instanceof String) {
            try {
                return Float.valueOf((String) obj).floatValue();
            } catch (Exception unused) {
            }
        }
        return 0.0f;
    }

    public static int getInt(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj).intValue();
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static String getString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return obj.toString();
        }
        return "";
    }

    @Deprecated
    public static float px2dp(float f16) {
        return PTSDeviceUtil.px2dp(f16);
    }
}
