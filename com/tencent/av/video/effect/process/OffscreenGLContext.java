package com.tencent.av.video.effect.process;

import android.os.Handler;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OffscreenGLContext {
    private Handler mHandler;
    private OffscreenSurface mOffscreenSurface;

    public OffscreenGLContext() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("MyOffscreenGLThread" + ((int) (Math.random() * 100.0d)));
        baseHandlerThread.start();
        Handler handler = new Handler(baseHandlerThread.getLooper());
        this.mHandler = handler;
        handler.post(new Runnable() { // from class: com.tencent.av.video.effect.process.OffscreenGLContext.1
            @Override // java.lang.Runnable
            public void run() {
                OffscreenGLContext.this.mOffscreenSurface = new OffscreenSurface();
            }
        });
    }

    public void destroy() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler.post(new Runnable() { // from class: com.tencent.av.video.effect.process.OffscreenGLContext.2
                @Override // java.lang.Runnable
                public void run() {
                    OffscreenGLContext.this.mOffscreenSurface.release();
                    OffscreenGLContext.this.mHandler.getLooper().quit();
                    OffscreenGLContext.this.mHandler = null;
                }
            });
        }
    }

    public void post(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler != null && runnable != null) {
            handler.post(runnable);
        }
    }
}
