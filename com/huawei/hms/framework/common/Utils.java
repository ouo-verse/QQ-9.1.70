package com.huawei.hms.framework.common;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Utils {
    private static final String TAG = "Utils";

    public static long getCurrentTime(boolean z16) {
        if (z16) {
            return SystemClock.elapsedRealtime();
        }
        return System.currentTimeMillis();
    }

    public static boolean is64Bit(Context context) {
        if (context == null) {
            Logger.e("Utils", "Null context, please check it.");
            return false;
        }
        if (context.getApplicationContext() != null) {
            context.getApplicationContext();
        }
        return Process.is64Bit();
    }
}
