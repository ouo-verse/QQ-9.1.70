package com.tencent.android.gldrawable.api.base;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AutoReleaseThreadHandler {
    protected static final long FIRST_TIMEOUT = 2000;
    protected static final long SECOND_TIMEOUT = 1000;
    private static final String TAG = "AutoReleaseHandler";
    private volatile AutoReleasHandler decodingThreadHandler;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class AutoReleasHandler extends Handler {
        private static final int WHAT_AUTO_QUIT = 1;
        private final HandlerThread decodingThread;
        private boolean isAlive;

        AutoReleasHandler(HandlerThread handlerThread) {
            super(handlerThread.getLooper());
            this.isAlive = true;
            this.decodingThread = handlerThread;
            GLDrawableApi.config().log("AutoReleaseHandler start thread", null);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            if (this.isAlive) {
                this.isAlive = false;
                sendEmptyMessageDelayed(1, 1000L);
                GLDrawableApi.config().log("AutoReleaseHandler wait stop thread", null);
            } else {
                this.decodingThread.quit();
                GLDrawableApi.config().log("AutoReleaseHandler stop thread", null);
            }
        }

        public void waitQuit() {
            removeMessages(1);
            sendEmptyMessageDelayed(1, 2000L);
        }
    }

    public void post(Runnable runnable) {
        try {
            if (this.decodingThreadHandler == null || !this.decodingThreadHandler.isAlive) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Auto-Release ThreadHandler", 10);
                baseHandlerThread.start();
                this.decodingThreadHandler = new AutoReleasHandler(baseHandlerThread);
            }
            this.decodingThreadHandler.waitQuit();
            this.decodingThreadHandler.post(runnable);
        } catch (OutOfMemoryError unused) {
        }
    }
}
