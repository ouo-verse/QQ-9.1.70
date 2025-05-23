package com.tencent.ttpic.baseutils.gles;

import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class OffscreenSurface extends EglSurfaceBase {
    public OffscreenSurface(EglCore eglCore, int i3, int i16) {
        super(eglCore);
        createOffscreenSurface(i3, i16);
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

    public void release() {
        releaseEglSurface();
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
}
