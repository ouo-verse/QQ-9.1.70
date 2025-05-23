package com.tencent.ttpic.openapi.filter;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.util.HandlerUtil;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes27.dex */
public class SimpleGLThread {
    private EglCore mCore;
    private Handler mHandler;
    private OffscreenSurface mOffscreenSurface;
    private String mThreadName;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnSurfaceCreatedListener {
        void onSurfaceCreated(OffscreenSurface offscreenSurface);
    }

    public SimpleGLThread(EGLContext eGLContext, String str) {
        this(eGLContext, str, null);
    }

    public void destroy() {
        destroy(null);
    }

    public Looper getLooper() {
        Handler handler = this.mHandler;
        if (handler == null) {
            return null;
        }
        return handler.getLooper();
    }

    public void makeCurrent() {
        this.mOffscreenSurface.makeCurrent();
    }

    public void postJob(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public void postJobSync(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(runnable);
            HandlerUtil.waitDone(this.mHandler);
        }
    }

    public void removeCallbacksAndMessages(Object obj) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(obj);
        }
    }

    public void sendEmptyMessage(int i3) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessage(i3);
        }
    }

    public void waitDone() {
        HandlerUtil.waitDone(this.mHandler);
    }

    public SimpleGLThread(final EGLContext eGLContext, String str, final OnSurfaceCreatedListener onSurfaceCreatedListener) {
        this.mThreadName = str;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(this.mThreadName);
        baseHandlerThread.start();
        Handler handler = new Handler(baseHandlerThread.getLooper());
        this.mHandler = handler;
        handler.post(new Runnable() { // from class: com.tencent.ttpic.openapi.filter.SimpleGLThread.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SimpleGLThread.this.mCore = new EglCore(eGLContext, 0);
                    SimpleGLThread.this.mOffscreenSurface = new OffscreenSurface(SimpleGLThread.this.mCore, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
                    SimpleGLThread.this.mOffscreenSurface.makeCurrent();
                    OnSurfaceCreatedListener onSurfaceCreatedListener2 = onSurfaceCreatedListener;
                    if (onSurfaceCreatedListener2 != null) {
                        onSurfaceCreatedListener2.onSurfaceCreated(SimpleGLThread.this.mOffscreenSurface);
                    }
                } catch (RuntimeException e16) {
                    Log.e("SimpleGLThread", "new EglCore crash : " + e16.getMessage());
                    SimpleGLThread.this.mCore = null;
                }
            }
        });
    }

    public void destroy(final Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.ttpic.openapi.filter.SimpleGLThread.2
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                    if (SimpleGLThread.this.mCore != null) {
                        SimpleGLThread.this.mOffscreenSurface.release();
                        SimpleGLThread.this.mCore.release();
                        SimpleGLThread.this.mHandler.getLooper().quitSafely();
                    }
                }
            });
        }
    }

    public void waitDone(int i3) {
        HandlerUtil.waitDone(this.mHandler, i3);
    }
}
