package com.tencent.mobileqq.utils;

import android.content.Context;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.msf.sdk.MSFSharedPreUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class as {
    public static long a(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("daily_boot_report", 0L);
    }

    public static long b(Context context, String str) {
        return MSFSharedPreUtils.getLoginTimeMillisInTodayZero(str);
    }

    public static void c(Context context, long j3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("daily_boot_report", j3).apply();
    }

    public static void d(Context context, String str, long j3) {
        MSFSharedPreUtils.setLoginTimeMillisInTodayZero(str, j3);
    }
}
