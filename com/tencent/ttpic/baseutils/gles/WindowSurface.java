package com.tencent.ttpic.baseutils.gles;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WindowSurface extends EglSurfaceBase {
    private boolean mReleaseSurface;
    private Surface mSurface;

    public WindowSurface(EglCore eglCore, Surface surface, boolean z16) {
        super(eglCore);
        createWindowSurface(surface);
        this.mSurface = surface;
        this.mReleaseSurface = z16;
    }

    @Override // com.tencent.ttpic.baseutils.gles.EglSurfaceBase
    public /* bridge */ /* synthetic */ void createOffscreenSurface(int i3, int i16) {
        super.createOffscreenSurface(i3, i16);
    }

    @Override // com.tencent.ttpic.baseutils.gles.EglSurfaceBase
    public /* bridge */ /* synthetic */ void createWindowSurface(Object obj) {
        super.createWindowSurface(obj);
    }

    @Override // com.tencent.ttpic.baseutils.gles.EglSurfaceBase
    public /* bridge */ /* synthetic */ int getHeight() {
        return super.getHeight();
    }

    @Override // com.tencent.ttpic.baseutils.gles.EglSurfaceBase
    public /* bridge */ /* synthetic */ int getWidth() {
        return super.getWidth();
    }

    @Override // com.tencent.ttpic.baseutils.gles.EglSurfaceBase
    public /* bridge */ /* synthetic */ void makeCurrent() {
        super.makeCurrent();
    }

    @Override // com.tencent.ttpic.baseutils.gles.EglSurfaceBase
    public /* bridge */ /* synthetic */ void makeCurrentReadFrom(EglSurfaceBase eglSurfaceBase) {
        super.makeCurrentReadFrom(eglSurfaceBase);
    }

    public void recreate(EglCore eglCore) {
        Surface surface = this.mSurface;
        if (surface != null) {
            this.mEglCore = eglCore;
            createWindowSurface(surface);
            return;
        }
        throw new RuntimeException("not yet implemented for SurfaceTexture");
    }

    public void release() {
        releaseEglSurface();
        Surface surface = this.mSurface;
        if (surface != null) {
            if (this.mReleaseSurface) {
                surface.release();
            }
            this.mSurface = null;
        }
    }

    @Override // com.tencent.ttpic.baseutils.gles.EglSurfaceBase
    public /* bridge */ /* synthetic */ void releaseEglSurface() {
        super.releaseEglSurface();
    }

    @Override // com.tencent.ttpic.baseutils.gles.EglSurfaceBase
    public /* bridge */ /* synthetic */ void saveFrame(File file) throws IOException {
        super.saveFrame(file);
    }

    @Override // com.tencent.ttpic.baseutils.gles.EglSurfaceBase
    public /* bridge */ /* synthetic */ void setPresentationTime(long j3) {
        super.setPresentationTime(j3);
    }

    @Override // com.tencent.ttpic.baseutils.gles.EglSurfaceBase
    public /* bridge */ /* synthetic */ boolean swapBuffers() {
        return super.swapBuffers();
    }

    public WindowSurface(EglCore eglCore, SurfaceTexture surfaceTexture) {
        super(eglCore);
        createWindowSurface(surfaceTexture);
    }
}
