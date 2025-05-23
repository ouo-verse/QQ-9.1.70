package com.tencent.crossengine.offscreen;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes32.dex */
public class OffscreenWorldRender implements GLSurfaceView.Renderer {

    /* renamed from: d, reason: collision with root package name */
    private long f100525d;

    /* renamed from: e, reason: collision with root package name */
    private String f100526e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f100527f;

    private native void nGLESDestory();

    private native void nGLESInit();

    private native void nGLESRender(long j3, String str);

    private native void nGLESResize(int i3, int i16);

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.f100527f) {
            com.tencent.crossengine.log.a.a("OffscreenWorldRender", "onDrawFrame return " + this.f100527f);
            return;
        }
        nGLESRender(this.f100525d, this.f100526e);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        if (this.f100527f) {
            com.tencent.crossengine.log.a.a("OffscreenWorldRender", "onSurfaceChanged return " + this.f100527f);
            return;
        }
        nGLESResize(i3, i16);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        nGLESInit();
    }

    public void a() {
        this.f100527f = true;
    }

    public void b() {
        this.f100527f = false;
    }
}
