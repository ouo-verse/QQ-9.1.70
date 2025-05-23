package com.tencent.luggage.wxa.kp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {
    public static boolean a() {
        return true;
    }

    public static void b(Context context) {
        a(context, 6);
        a(context, System.currentTimeMillis());
    }

    public static int c(Context context) {
        Integer valueOf = Integer.valueOf(d(context));
        com.tencent.luggage.wxa.np.e.c("Soter.SoterBiometricAntiBruteForceStrategy", "soter: current retry time: " + valueOf, new Object[0]);
        return valueOf.intValue();
    }

    public static int d(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("key_fail_times", 0);
    }

    public static long e(Context context) {
        Long valueOf = Long.valueOf(f(context));
        com.tencent.luggage.wxa.np.e.c("Soter.SoterBiometricAntiBruteForceStrategy", "soter: current last freeze time: " + valueOf, new Object[0]);
        return valueOf.longValue();
    }

    public static long f(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("key_last_freeze_time", -1L);
    }

    public static boolean g(Context context) {
        if (c(context) >= 5) {
            return false;
        }
        com.tencent.luggage.wxa.np.e.c("Soter.SoterBiometricAntiBruteForceStrategy", "soter: fail time available", new Object[0]);
        return true;
    }

    public static boolean h(Context context) {
        int currentTimeMillis = (int) ((System.currentTimeMillis() - e(context)) / 1000);
        com.tencent.luggage.wxa.np.e.c("Soter.SoterBiometricAntiBruteForceStrategy", "soter: tween sec after last freeze: " + currentTimeMillis, new Object[0]);
        if (currentTimeMillis <= 30) {
            return false;
        }
        com.tencent.luggage.wxa.np.e.a("Soter.SoterBiometricAntiBruteForceStrategy", "soter: after last freeze", new Object[0]);
        return true;
    }

    public static void i(Context context) {
        a(context, -1L);
        a(context, 0);
    }

    public static void a(Context context, int i3) {
        com.tencent.luggage.wxa.np.e.c("Soter.SoterBiometricAntiBruteForceStrategy", "soter: setting to time: " + i3, new Object[0]);
        if (i3 < 0) {
            com.tencent.luggage.wxa.np.e.e("Soter.SoterBiometricAntiBruteForceStrategy", "soter: illegal fail time", new Object[0]);
        } else {
            b(context, i3);
        }
    }

    public static void b(Context context, int i3) {
        if (context == null) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterBiometricAntiBruteForceStrategy", "soter: context is null", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("key_fail_times", i3);
        edit.apply();
    }

    public static void a(Context context, long j3) {
        com.tencent.luggage.wxa.np.e.c("Soter.SoterBiometricAntiBruteForceStrategy", "soter: setting last freeze time: " + j3, new Object[0]);
        if (j3 < -1) {
            com.tencent.luggage.wxa.np.e.e("Soter.SoterBiometricAntiBruteForceStrategy", "soter: illegal setLastFreezeTime", new Object[0]);
        } else {
            b(context, j3);
        }
    }

    public static void b(Context context, long j3) {
        if (context == null) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterBiometricAntiBruteForceStrategy", "soter: context is null", new Object[0]);
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
