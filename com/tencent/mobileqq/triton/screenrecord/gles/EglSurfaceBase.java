package com.tencent.mobileqq.triton.screenrecord.gles;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001J\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cR\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/triton/screenrecord/gles/EglSurfaceBase;", "", "mEglCore", "Lcom/tencent/mobileqq/triton/screenrecord/gles/EglCore;", "(Lcom/tencent/mobileqq/triton/screenrecord/gles/EglCore;)V", "height", "", "getHeight", "()I", "mEGLSurface", "Landroid/opengl/EGLSurface;", "kotlin.jvm.PlatformType", "getMEglCore", "()Lcom/tencent/mobileqq/triton/screenrecord/gles/EglCore;", "setMEglCore", "mHeight", "mWidth", "width", "getWidth", "createWindowSurface", "", "surface", "makeCurrent", "releaseEglSurface", "setPresentationTime", "nsecs", "", "swapBuffers", "", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public class EglSurfaceBase {
    private EGLSurface mEGLSurface;

    @NotNull
    private EglCore mEglCore;
    private int mHeight;
    private int mWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    public EglSurfaceBase(@NotNull EglCore mEglCore) {
        Intrinsics.checkParameterIsNotNull(mEglCore, "mEglCore");
        this.mEglCore = mEglCore;
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mWidth = -1;
        this.mHeight = -1;
    }

    public final void createWindowSurface(@NotNull Object surface) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(surface, "surface");
        if (this.mEGLSurface == EGL14.EGL_NO_SURFACE) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mEGLSurface = this.mEglCore.createWindowSurface(surface);
            return;
        }
        throw new IllegalStateException("surface already created".toString());
    }

    public final int getHeight() {
        int i3 = this.mHeight;
        if (i3 < 0) {
            return this.mEglCore.querySurface(this.mEGLSurface, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT);
        }
        return i3;
    }

    @NotNull
    protected final EglCore getMEglCore() {
        return this.mEglCore;
    }

    public final int getWidth() {
        int i3 = this.mWidth;
        if (i3 < 0) {
            return this.mEglCore.querySurface(this.mEGLSurface, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH);
        }
        return i3;
    }

    public final void makeCurrent() {
        this.mEglCore.makeCurrent(this.mEGLSurface);
    }

    public final void releaseEglSurface() {
        this.mEglCore.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
    }

    protected final void setMEglCore(@NotNull EglCore eglCore) {
        Intrinsics.checkParameterIsNotNull(eglCore, "<set-?>");
        this.mEglCore = eglCore;
    }

    public final void setPresentationTime(long nsecs) {
        this.mEglCore.setPresentationTime(this.mEGLSurface, nsecs);
    }

    public final boolean swapBuffers() {
        return this.mEglCore.swapBuffers(this.mEGLSurface);
    }
}
