package com.tencent.thumbplayer.core.codec.tmediacodec.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class ThreadManager {
    private static final HandlerThread mHandlerThread;
    private static Handler sSubHandler;
    private static final Handler mHandler = new Handler(Looper.getMainLooper());
    private static final ExecutorService mThreadPool = ProxyExecutors.newCachedThreadPool();

    static {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("tmediacodec-sub");
        mHandlerThread = baseHandlerThread;
        baseHandlerThread.start();
        sSubHandler = new Handler(baseHandlerThread.getLooper());
    }

    ThreadManager() {
    }

    public static void execute(@NonNull Runnable runnable) {
        mThreadPool.execute(runnable);
    }

    public static void postOnSubThread(@NonNull Runnable runnable) {
        sSubHandler.post(runnable);
    }

    public static void runOnSubThread(@NonNull Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            mThreadPool.execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThread(@NonNull Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            mHandler.post(runnable);
        }
    }
}
