package com.tencent.mobileqq.minigame.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppUtil {
    private static final String KEY_LAST_STARTTIME = "lastStartTime";
    public static final int LMODE_AGAIN = 3;
    public static final int LMODE_NEW_INSTALL = 1;
    public static final int LMODE_UPDATE = 2;
    private static AppUtil sInstance;
    private boolean isOpenMarked = false;
    private int mLaunchMode = 3;

    public static AppUtil getInstance() {
        if (sInstance == null) {
            sInstance = new AppUtil();
        }
        return sInstance;
    }

    public static long getPackageFirstInstallTime(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).firstInstallTime;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static long getPackageLastUpdateTime(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).lastUpdateTime;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static String getProcessName() {
        return BaseApplicationImpl.getApplication().getQQProcessName();
    }

    public static boolean isMainProcess() {
        return "com.tencent.mobileqq".equals(getProcessName());
    }

    public int getAppLaunchMode(Context context) {
        if (this.isOpenMarked) {
            return this.mLaunchMode;
        }
        this.isOpenMarked = true;
        SharedPreferences sharedPreferences = context.getSharedPreferences("tt_launch_sp", 0);
        long j3 = sharedPreferences.getLong(KEY_LAST_STARTTIME, 0L);
        sharedPreferences.edit().putLong(KEY_LAST_STARTTIME, System.currentTimeMillis()).apply();
        long packageFirstInstallTime = getPackageFirstInstallTime(context);
        long packageLastUpdateTime = getPackageLastUpdateTime(context);
        if (j3 == 0) {
            this.mLaunchMode = 1;
        } else if (packageFirstInstallTime >= j3) {
            this.mLaunchMode = 1;
        } else if (packageLastUpdateTime >= j3) {
            this.mLaunchMode = 2;
        } else {
            this.mLaunchMode = 3;
        }
        return this.mLaunchMode;
    }

    public int getLaunchMode() {
        return this.mLaunchMode;
    }

    public boolean isFirstOpen(Context context) {
        return getAppLaunchMode(context) != 3;
    }
}
