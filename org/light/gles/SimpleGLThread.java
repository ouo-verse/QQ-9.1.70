package org.light.gles;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import org.light.utils.HandlerUtil;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes29.dex */
public class SimpleGLThread {
    private static final int VIDEO_OUTPUT_HEIGHT = 960;
    private static final int VIDEO_OUTPUT_WIDTH = 720;
    private EglCore mCore;
    private Handler mHandler;
    private OffscreenSurface mOffscreenSurface;
    private String mThreadName;

    /* compiled from: P */
    /* loaded from: classes29.dex */
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
        handler.post(new Runnable() { // from class: org.light.gles.SimpleGLThread.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SimpleGLThread.this.mCore = new EglCore(eGLContext, 0);
                    SimpleGLThread.this.mOffscreenSurface = new OffscreenSurface(SimpleGLThread.this.mCore, 720, 960);
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
            handler.post(new Runnable() { // from class: org.light.gles.SimpleGLThread.2
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
