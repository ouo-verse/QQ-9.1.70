package com.tencent.qcircle.weseevideo.editor.utils;

import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes22.dex */
public class HandlerUtils {
    private static Handler mMainHandler;
    private static final Object mMainHandlerLock = new Object();

    public static Handler getMainHandler() {
        if (mMainHandler == null) {
            synchronized (mMainHandlerLock) {
                if (mMainHandler == null) {
                    mMainHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return mMainHandler;
    }
}
