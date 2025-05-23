package com.tencent.mobileqq.engineering.preload;

import com.tencent.mobileqq.engineering.preload.inter.ILogger;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import java.util.concurrent.ExecutorService;

/* loaded from: classes12.dex */
public class PreLoader {
    public static final String TAG = "PreLoader";
    public static ILogger sLogger;

    public static <T> void addListener(String str, OnTaskListener<T> onTaskListener) {
        PreLoaderPool.getInstance().setListener(str, onTaskListener);
    }

    public static boolean exists(String str) {
        return PreLoaderPool.getInstance().exists(str);
    }

    public static void log(String str) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.d(TAG, str);
        }
    }

    public static <T> String preLoad(String str, BasePreLoadTask<T> basePreLoadTask) {
        return PreLoaderPool.getInstance().preLoad(str, basePreLoadTask);
    }

    public static void remove(String str) {
        PreLoaderPool.getInstance().remove(str);
    }

    public static <T> void removeListener(String str, OnTaskListener<T> onTaskListener) {
        PreLoaderPool.getInstance().removeListener(str, onTaskListener);
    }

    public static void setDefaultThreadPoolExecutor(ExecutorService executorService) {
        Worker.setDefaultThreadPoolExecutor(executorService);
    }

    public static void setLogger(ILogger iLogger) {
        sLogger = iLogger;
    }

    public static void log(Throwable th5) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.d(TAG, "", th5);
        }
    }
}
