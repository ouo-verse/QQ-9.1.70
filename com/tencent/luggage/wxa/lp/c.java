package com.tencent.luggage.wxa.lp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.luggage.wxa.np.e;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static boolean a() {
        return true;
    }

    public static void b(Context context) {
        a(context, 6);
        a(context, System.currentTimeMillis());
    }

    public static int c(Context context) {
        Integer valueOf = Integer.valueOf(d(context));
        e.c("Soter.SoterAntiBruteForceStrategy", "soter: current retry time: " + valueOf, new Object[0]);
        return valueOf.intValue();
    }

    public static int d(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("key_fail_times", 0);
    }

    public static long e(Context context) {
        Long valueOf = Long.valueOf(f(context));
        e.c("Soter.SoterAntiBruteForceStrategy", "soter: current last freeze time: " + valueOf, new Object[0]);
        return valueOf.longValue();
    }

    public static long f(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("key_last_freeze_time", -1L);
    }

    public static boolean g(Context context) {
        if (c(context) >= 5) {
            return false;
        }
        e.c("Soter.SoterAntiBruteForceStrategy", "soter: fail time available", new Object[0]);
        return true;
    }

    public static boolean h(Context context) {
        int currentTimeMillis = (int) ((System.currentTimeMillis() - e(context)) / 1000);
        e.c("Soter.SoterAntiBruteForceStrategy", "soter: tween sec after last freeze: " + currentTimeMillis, new Object[0]);
        if (currentTimeMillis <= 30) {
            return false;
        }
        e.a("Soter.SoterAntiBruteForceStrategy", "soter: after last freeze", new Object[0]);
        return true;
    }

    public static void i(Context context) {
        a(context, -1L);
        a(context, 0);
    }

    public static void a(Context context, int i3) {
        e.c("Soter.SoterAntiBruteForceStrategy", "soter: setting to time: " + i3, new Object[0]);
        if (i3 < 0) {
            e.e("Soter.SoterAntiBruteForceStrategy", "soter: illegal fail time", new Object[0]);
        } else {
            b(context, i3);
        }
    }

    public static void b(Context context, int i3) {
        if (context == null) {
            e.b("Soter.SoterAntiBruteForceStrategy", "soter: context is null", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("key_fail_times", i3);
        edit.apply();
    }

    public static void a(Context context, long j3) {
        e.c("Soter.SoterAntiBruteForceStrategy", "soter: setting last freeze time: " + j3, new Object[0]);
        if (j3 < -1) {
            e.e("Soter.SoterAntiBruteForceStrategy", "soter: illegal setLastFreezeTime", new Object[0]);
        } else {
            b(context, j3);
        }
    }

    public static void b(Context context, long j3) {
        if (context == null) {
            e.b("Soter.SoterAntiBruteForceStrategy", "soter: context is null", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("key_last_freeze_time", j3);
        edit.apply();
    }

    public static void a(Context context) {
        a(context, Integer.valueOf(Integer.valueOf(c(context)).intValue() + 1).intValue());
    }
}
