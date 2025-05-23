package com.tencent.biz.videostory.video;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;
import com.tencent.ttpic.openapi.config.MediaConfig;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes5.dex */
public class SimpleGLThread {

    /* renamed from: a, reason: collision with root package name */
    private Handler f97171a;

    /* renamed from: b, reason: collision with root package name */
    private EglCore f97172b;

    /* renamed from: c, reason: collision with root package name */
    private OffscreenSurface f97173c;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.videostory.video.SimpleGLThread$4, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f97176d;
        final /* synthetic */ SimpleGLThread this$0;

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f97176d) {
                this.f97176d.notifyAll();
            }
        }
    }

    public SimpleGLThread(final EGLContext eGLContext, String str) {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(str, 9);
        baseHandlerThread.start();
        do {
        } while (!baseHandlerThread.isAlive());
        QLog.i("SimpleGLThread", 1, "create SimpleGLThread");
        Handler handler = new Handler(baseHandlerThread.getLooper());
        this.f97171a = handler;
        handler.post(new Runnable() { // from class: com.tencent.biz.videostory.video.SimpleGLThread.1
            @Override // java.lang.Runnable
            public void run() {
                SimpleGLThread.this.f97172b = new EglCore(eGLContext, 0);
                SimpleGLThread.this.f97173c = new OffscreenSurface(SimpleGLThread.this.f97172b, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
                SimpleGLThread.this.f97173c.makeCurrent();
            }
        });
    }

    public void f() {
        Handler handler = this.f97171a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.biz.videostory.video.SimpleGLThread.3
                @Override // java.lang.Runnable
                public void run() {
                    SimpleGLThread.this.f97173c.release();
                    SimpleGLThread.this.f97172b.release();
                    SimpleGLThread.this.f97171a.getLooper().quit();
                }
            });
        }
    }

    public void g(Runnable runnable) {
        Handler handler = this.f97171a;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public void h(Runnable runnable) {
        final Object obj = new Object();
        QLog.d("SimpleGLThread", 4, "runJobSync: sync obj+" + obj.hashCode());
        synchronized (obj) {
            g(runnable);
            g(new Runnable() { // from class: com.tencent.biz.videostory.video.SimpleGLThread.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            try {
                LockMethodProxy.wait(obj);
                QLog.d("SimpleGLThread", 4, "runJobSync: job done+" + obj.hashCode());
            } catch (InterruptedException unused) {
                QLog.w("SimpleGLThread", 2, "runJobSync: interrupted");
            }
        }
    }
}
