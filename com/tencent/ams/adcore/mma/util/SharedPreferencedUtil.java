package com.tencent.ams.adcore.mma.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class SharedPreferencedUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String SP_CONFIG_KEY_FILE = "tg_trackingConfig";
    public static final String SP_KEY_ANDROID_ID = "android_id";
    public static final String SP_KEY_IMEI = "imei";
    public static final String SP_KEY_MAC = "mac";
    public static final String SP_NAME_CONFIG = "tg.cn.com.mma.mobile.tracking.sdkconfig";
    public static final String SP_NAME_OTHER = "tg.cn.com.mma.mobile.tracking.other";
    public static final String SP_OTHER_KEY_UPDATE_TIME = "tg_updateTime";

    public SharedPreferencedUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static long getLong(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0L;
        }
        return context.getSharedPreferences(str, 0).getLong(str2, 0L);
    }

    public static String getString(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        return context.getSharedPreferences(str, 0).getString(str2, "");
    }

    public static void putLong(Context context, String str, String str2, long j3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putLong(str2, j3);
            edit.commit();
        }
    }

    public static void putString(Context context, String str, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }
}
