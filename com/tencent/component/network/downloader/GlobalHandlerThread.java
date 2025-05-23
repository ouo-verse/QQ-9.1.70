package com.tencent.component.network.downloader;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GlobalHandlerThread {
    private static final byte[] INSTANCE_LOCK = new byte[0];
    private static volatile GlobalHandlerThread mInstance;
    private Handler mHandler;
    private HandlerThread mWorkThread;

    GlobalHandlerThread(Context context) {
        try {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("download_async");
            this.mWorkThread = baseHandlerThread;
            baseHandlerThread.start();
            this.mHandler = new Handler(this.mWorkThread.getLooper());
        } catch (Exception unused) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
    }

    public static GlobalHandlerThread getInstance(Context context) {
        if (mInstance == null) {
            synchronized (INSTANCE_LOCK) {
                if (mInstance == null) {
                    mInstance = new GlobalHandlerThread(context);
                }
            }
        }
        return mInstance;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public Looper getLooper() {
        HandlerThread handlerThread = this.mWorkThread;
        if (handlerThread != null) {
            return handlerThread.getLooper();
        }
        return null;
    }
}
