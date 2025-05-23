package com.tencent.mobileqq.triton.screenrecord.gles;

import android.view.Surface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/triton/screenrecord/gles/WindowSurface;", "Lcom/tencent/mobileqq/triton/screenrecord/gles/EglSurfaceBase;", "eglCore", "Lcom/tencent/mobileqq/triton/screenrecord/gles/EglCore;", "surface", "Landroid/view/Surface;", "releaseSurface", "", "(Lcom/tencent/mobileqq/triton/screenrecord/gles/EglCore;Landroid/view/Surface;Z)V", "mReleaseSurface", "mSurface", "release", "", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class WindowSurface extends EglSurfaceBase {
    private final boolean mReleaseSurface;
    private Surface mSurface;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowSurface(@NotNull EglCore eglCore, @Nullable Surface surface, boolean z16) {
        super(eglCore);
        Intrinsics.checkParameterIsNotNull(eglCore, "eglCore");
        if (surface == null) {
            Intrinsics.throwNpe();
        }
        createWindowSurface(surface);
        this.mSurface = surface;
        this.mReleaseSurface = z16;
    }

    public final void release() {
        releaseEglSurface();
        Surface surface = this.mSurface;
        if (surface != null) {
            if (this.mReleaseSurface) {
                if (surface == null) {
                    Intrinsics.throwNpe();
                }
                surface.release();
            }
            this.mSurface = null;
        }
    }
}
