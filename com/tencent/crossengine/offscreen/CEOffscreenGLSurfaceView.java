package com.tencent.crossengine.offscreen;

import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CEOffscreenGLSurfaceView extends GLSurfaceView {

    /* renamed from: d, reason: collision with root package name */
    private OffscreenWorldRender f100517d;

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        OffscreenWorldRender offscreenWorldRender = this.f100517d;
        if (offscreenWorldRender != null) {
            offscreenWorldRender.a();
        }
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        OffscreenWorldRender offscreenWorldRender = this.f100517d;
        if (offscreenWorldRender != null) {
            offscreenWorldRender.b();
        }
        super.onResume();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        super.surfaceChanged(surfaceHolder, i3, i16, i17);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
    }
}
