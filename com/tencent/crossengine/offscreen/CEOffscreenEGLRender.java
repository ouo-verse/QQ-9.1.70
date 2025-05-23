package com.tencent.crossengine.offscreen;

import android.os.Handler;
import android.view.Surface;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CEOffscreenEGLRender {

    /* renamed from: a, reason: collision with root package name */
    private long f100508a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f100509b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f100510c;

    private native long nInitRender();

    private native void nOnDrawFrame(long j3, long j16, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nOnSurfaceChanged(long j3, Surface surface, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nOnSurfaceCreated(long j3, Surface surface, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nOnSurfaceDestroyed(long j3);

    private native void nRelease(long j3);

    public void g(final Surface surface, final int i3, final int i16) {
        this.f100509b.post(new Runnable() { // from class: com.tencent.crossengine.offscreen.CEOffscreenEGLRender.4
            @Override // java.lang.Runnable
            public void run() {
                CEOffscreenEGLRender cEOffscreenEGLRender = CEOffscreenEGLRender.this;
                cEOffscreenEGLRender.nOnSurfaceChanged(cEOffscreenEGLRender.f100508a, surface, i3, i16);
                CEOffscreenEGLRender.this.f100510c = true;
            }
        });
    }

    public void h(final Surface surface, final int i3, final int i16) {
        this.f100509b.post(new Runnable() { // from class: com.tencent.crossengine.offscreen.CEOffscreenEGLRender.3
            @Override // java.lang.Runnable
            public void run() {
                CEOffscreenEGLRender cEOffscreenEGLRender = CEOffscreenEGLRender.this;
                cEOffscreenEGLRender.nOnSurfaceCreated(cEOffscreenEGLRender.f100508a, surface, i3, i16);
                CEOffscreenEGLRender.this.f100510c = true;
            }
        });
    }

    public void i() {
        this.f100510c = false;
        this.f100509b.post(new Runnable() { // from class: com.tencent.crossengine.offscreen.CEOffscreenEGLRender.5
            @Override // java.lang.Runnable
            public void run() {
                CEOffscreenEGLRender cEOffscreenEGLRender = CEOffscreenEGLRender.this;
                cEOffscreenEGLRender.nOnSurfaceDestroyed(cEOffscreenEGLRender.f100508a);
            }
        });
    }

    public void f(b bVar) {
    }
}
