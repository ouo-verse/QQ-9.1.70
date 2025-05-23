package com.tencent.qqmini.sdk.monitor.service;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MonitorHandlerThread {
    private static HT loopThread;
    private static HT writeLogThread;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class HT {
        private Handler handler;
        public HandlerThread handlerThread;
        private Looper looper;

        public HT(String str, HandlerThread handlerThread) {
            this.handlerThread = null;
            this.handler = null;
            this.looper = null;
            if (handlerThread != null) {
                this.handlerThread = handlerThread;
            } else {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Tencent_PerformanceMonitorThread_" + str);
                this.handlerThread = baseHandlerThread;
                baseHandlerThread.start();
            }
            this.looper = this.handlerThread.getLooper();
            this.handler = new Handler(this.looper);
        }

        public Handler getHandler() {
            return this.handler;
        }

        public Looper getLooper() {
            return this.looper;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface ThreadFactory {
        HandlerThread getLooperThread();
    }

    public static Handler getLooperThreadHandler() {
        if (loopThread == null) {
            loopThread = new HT("loop", null);
        }
        return loopThread.getHandler();
    }

    public static Handler getWriteFileHandler() {
        if (writeLogThread == null) {
            writeLogThread = new HT("writelog", null);
        }
        return writeLogThread.getHandler();
    }
}
