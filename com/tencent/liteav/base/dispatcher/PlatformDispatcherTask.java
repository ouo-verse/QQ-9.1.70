package com.tencent.liteav.base.dispatcher;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
/* loaded from: classes7.dex */
class PlatformDispatcherTask implements Runnable {
    private long mNativePlatformDispatcherTask;

    public PlatformDispatcherTask(long j3) {
        this.mNativePlatformDispatcherTask = j3;
    }

    private void destroyTask() {
        long j3 = this.mNativePlatformDispatcherTask;
        if (j3 != 0) {
            nativeDestroyTask(j3);
            this.mNativePlatformDispatcherTask = 0L;
        }
    }

    public static Handler getMainHandler() {
        return new Handler(Looper.getMainLooper());
    }

    private static native void nativeDestroyTask(long j3);

    private static native void nativeRunTask(long j3);

    protected void finalize() throws Throwable {
        destroyTask();
        super.finalize();
    }

    @Override // java.lang.Runnable
    public void run() {
        long j3 = this.mNativePlatformDispatcherTask;
        if (j3 != 0) {
            nativeRunTask(j3);
            destroyTask();
        }
    }
}
