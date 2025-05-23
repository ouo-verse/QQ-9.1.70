package com.tencent.soter.core.biometric;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.model.SLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class SoterBiometricAntiBruteForceStrategy {
    static IPatchRedirector $redirector_ = null;
    private static final long DEFAULT_FREEZE_TIME = -1;
    private static final int FREEZE_SECOND = 30;
    private static final String KEY_FAIL_TIMES = "key_fail_times";
    private static final String KEY_LAST_FREEZE_TIME = "key_last_freeze_time";
    private static final int MAX_FAIL_NUM = 5;
    private static final String TAG = "Soter.SoterBiometricAntiBruteForceStrategy";

    SoterBiometricAntiBruteForceStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addFailTime(Context context) {
        setCurrentFailTime(context, Integer.valueOf(Integer.valueOf(getCurrentFailTime(context)).intValue() + 1).intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void freeze(Context context) {
        setCurrentFailTime(context, 6);
        setLastFreezeTime(context, System.currentTimeMillis());
    }

    private static int getCurrentFailTime(Context context) {
        Integer valueOf = Integer.valueOf(getCurrentFailTimeInDB(context));
        SLogger.i(TAG, "soter: current retry time: " + valueOf, new Object[0]);
        return valueOf.intValue();
    }

    private static int getCurrentFailTimeInDB(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(KEY_FAIL_TIMES, 0);
    }

    private static long getLastFreezeTime(Context context) {
        Long valueOf = Long.valueOf(getLastFreezeTimeInDB(context));
        SLogger.i(TAG, "soter: current last freeze time: " + valueOf, new Object[0]);
        return valueOf.longValue();
    }

    private static long getLastFreezeTimeInDB(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(KEY_LAST_FREEZE_TIME, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isCurrentFailTimeAvailable(Context context) {
        if (getCurrentFailTime(context) >= 5) {
            return false;
        }
        SLogger.i(TAG, "soter: fail time available", new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isCurrentTweenTimeAvailable(Context context) {
        int currentTimeMillis = (int) ((System.currentTimeMillis() - getLastFreezeTime(context)) / 1000);
        SLogger.i(TAG, "soter: tween sec after last freeze: " + currentTimeMillis, new Object[0]);
        if (currentTimeMillis <= 30) {
            return false;
        }
        SLogger.d(TAG, "soter: after last freeze", new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSystemHasAntiBruteForce() {
        return true;
    }

    private static void setCurrentFailTime(Context context, int i3) {
        SLogger.i(TAG, "soter: setting to time: " + i3, new Object[0]);
        if (i3 < 0) {
            SLogger.w(TAG, "soter: illegal fail time", new Object[0]);
        } else {
            setCurrentFailTimeInDB(context, i3);
        }
    }

    private static void setCurrentFailTimeInDB(Context context, int i3) {
        if (context == null) {
            SLogger.e(TAG, "soter: context is null", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(KEY_FAIL_TIMES, i3);
        edit.apply();
    }

    private static void setLastFreezeTime(Context context, long j3) {
        SLogger.i(TAG, "soter: setting last freeze time: " + j3, new Object[0]);
        if (j3 < -1) {
            SLogger.w(TAG, "soter: illegal setLastFreezeTime", new Object[0]);
        } else {
            setLastFreezeTimeInDB(context, j3);
        }
    }

    private static void setLastFreezeTimeInDB(Context context, long j3) {
        if (context == null) {
            SLogger.e(TAG, "soter: context is null", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong(KEY_LAST_FREEZE_TIME, j3);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unFreeze(Context context) {
        setLastFreezeTime(context, -1L);
        setCurrentFailTime(context, 0);
    }
}
