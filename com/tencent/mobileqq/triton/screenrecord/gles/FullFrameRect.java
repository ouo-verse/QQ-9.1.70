package com.tencent.mobileqq.triton.screenrecord.gles;

import android.opengl.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/triton/screenrecord/gles/FullFrameRect;", "", "()V", "mProgram", "Lcom/tencent/mobileqq/triton/screenrecord/gles/Texture2dProgram;", "mRectDrawable", "Lcom/tencent/mobileqq/triton/screenrecord/gles/Drawable2d;", "createTextureObject", "", "drawFrame", "", "textureId", "texMatrix", "", "release", "doEglCleanup", "", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class FullFrameRect {
    private static final float[] IDENTITY_MATRIX;
    private final Drawable2d mRectDrawable = new Drawable2d();
    private Texture2dProgram mProgram = new Texture2dProgram();

    static {
        float[] fArr = new float[16];
        IDENTITY_MATRIX = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public final int createTextureObject() {
        Texture2dProgram texture2dProgram = this.mProgram;
        if (texture2dProgram == null) {
            Intrinsics.throwNpe();
        }
        return texture2dProgram.createTextureObject();
    }

    public final void drawFrame(int textureId, @Nullable float[] texMatrix) {
        Texture2dProgram texture2dProgram = this.mProgram;
        if (texture2dProgram == null) {
            Intrinsics.throwNpe();
        }
        texture2dProgram.draw(IDENTITY_MATRIX, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), texMatrix, this.mRectDrawable.getTexCoordArray(), textureId, this.mRectDrawable.getTexCoordStride());
    }

    public final void release(boolean doEglCleanup) {
        Texture2dProgram texture2dProgram = this.mProgram;
        if (texture2dProgram != null) {
            if (doEglCleanup) {
                if (texture2dProgram == null) {
                    Intrinsics.throwNpe();
                }
                texture2dProgram.release();
            }
            this.mProgram = null;
        }
    }
}
