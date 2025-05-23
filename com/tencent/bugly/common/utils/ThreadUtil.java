package com.tencent.bugly.common.utils;

import android.os.Looper;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ThreadUtil {
    public static boolean isInCurrentLooperThread(Looper looper) {
        if (looper != null && Thread.currentThread() == looper.getThread()) {
            return true;
        }
        return false;
    }

    public static boolean isInMainThread() {
        return isInCurrentLooperThread(Looper.getMainLooper());
    }
}
