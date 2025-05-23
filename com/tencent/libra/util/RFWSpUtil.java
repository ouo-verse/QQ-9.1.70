package com.tencent.libra.util;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RFWSpUtil {
    private static final String PIC_CACHE_TIME_KEY = "pic_cache_time";
    private static final String SP_NAME = "RFWPicLoader";

    public static String getLastDeleteCacheTime(Context context) {
        return getString(context, PIC_CACHE_TIME_KEY);
    }

    private static String getString(Context context, String str) {
        if (context == null) {
            return "";
        }
        return context.getSharedPreferences(SP_NAME, 4).getString(str, "");
    }

    private static void save(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SP_NAME, 4).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void setDeleteCacheTime(Context context, String str) {
        save(context, PIC_CACHE_TIME_KEY, str);
    }
}
