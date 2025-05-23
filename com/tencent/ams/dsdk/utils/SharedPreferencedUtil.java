package com.tencent.ams.dsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class SharedPreferencedUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String SP_KEY_BUNDLE_CONFIG = "com.tencent.ams.dynamic.bundles";
    private static final String SP_KEY_UPDATE_BUNDLE_CONFIG_TIME = "last_update_bundle_config_time";

    public SharedPreferencedUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean getBoolean(Context context, String str, String str2, boolean z16) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return context.getSharedPreferences(str, 0).getBoolean(str2, z16);
    }

    public static int getInt(Context context, String str, String str2, int i3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        return context.getSharedPreferences(str, 0).getInt(str2, i3);
    }

    public static long getLastUpdateBundleConfigTime() {
        return getLong(DKEngine.getApplicationContext(), SP_KEY_BUNDLE_CONFIG, SP_KEY_UPDATE_BUNDLE_CONFIG_TIME, 0L);
    }

    public static long getLong(Context context, String str, String str2, long j3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return context.getSharedPreferences(str, 0).getLong(str2, j3);
        }
        return 0L;
    }

    public static String getString(Context context, String str, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        }
        return "";
    }

    public static void putBoolean(Context context, String str, String str2, boolean z16) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putBoolean(str2, z16);
            edit.apply();
        }
    }

    public static void putInt(Context context, String str, String str2, int i3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putInt(str2, i3);
            edit.apply();
        }
    }

    public static void putLong(Context context, String str, String str2, long j3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putLong(str2, j3);
            edit.apply();
        }
    }

    public static void putString(Context context, String str, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, str3);
            edit.apply();
        }
    }

    public static void updateLastUpdateBundleConfigTime() {
        putLong(DKEngine.getApplicationContext(), SP_KEY_BUNDLE_CONFIG, SP_KEY_UPDATE_BUNDLE_CONFIG_TIME, System.currentTimeMillis());
    }
}
