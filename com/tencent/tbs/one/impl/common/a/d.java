package com.tencent.tbs.one.impl.common.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class d {
    public static ArrayList<String> a(Context context) {
        try {
            return new ArrayList<>(Arrays.asList(context.getSharedPreferences("com.tencent.tbs.one.report", 4).getString("stat_not_yet_sent", "").split(",")));
        } catch (Throwable unused) {
            b(context);
            return new ArrayList<>();
        }
    }

    public static void b(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("com.tencent.tbs.one.report", 4).edit();
            edit.clear();
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public static boolean c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.tbs.one.report", 4);
            long j3 = sharedPreferences.getLong("last_send_time", -1L);
            if (j3 < 0) {
                sharedPreferences.edit().putLong("last_send_time", System.currentTimeMillis()).apply();
                return false;
            }
            if (System.currentTimeMillis() - j3 <= 86400000) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            b(context);
            return false;
        }
    }
}
