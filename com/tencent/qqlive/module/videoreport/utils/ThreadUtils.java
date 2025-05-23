package com.tencent.qqlive.module.videoreport.utils;

import android.os.Looper;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ThreadUtils {
    public static boolean isMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }
}
