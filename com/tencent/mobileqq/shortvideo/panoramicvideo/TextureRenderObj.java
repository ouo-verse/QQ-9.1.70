package com.tencent.mobileqq.shortvideo.panoramicvideo;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GL.TextureUtil;
import com.tencent.mobileqq.shortvideo.panoramicvideo.utils.MatrixUtil;
import com.tencent.qqmini.sdk.report.MiniReportManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TextureRenderObj extends PassThroughRenderObj {
    private int mTextureHeight;
    private int mTextureId;
    private int mTextureWidth;
    private Plane texturePlane;

    public TextureRenderObj(Context context) {
        super(context);
        this.texturePlane = new Plane(false);
    }

    public void destroyTexture() {
        GLES20.glDeleteTextures(1, new int[]{this.mTextureId}, 0);
    }

    @Override // com.tencent.mobileqq.shortvideo.panoramicvideo.PassThroughRenderObj, com.tencent.mobileqq.shortvideo.panoramicvideo.BaseRenderObj
    public void onDrawFrame(int i3) {
        onPreDrawElements();
        GlUtil.checkGlError("onPreDrawElements");
        this.glPassThroughProgram.use();
        Matrix.setIdentityM(this.projectionMatrix, 0);
        GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        TextureUtil.bindTexture2D(this.mTextureId, 33984, this.glPassThroughProgram.getTextureSamplerHandle(), 0);
        this.texturePlane.uploadTexCoordinateBuffer(this.glPassThroughProgram.getTextureCoordinateHandle());
        this.texturePlane.uploadVerticesBuffer(this.glPassThroughProgram.getPositionHandle());
        MatrixUtil.updateProjection(this.mTextureWidth, this.mTextureHeight, this.surfaceWidth, this.surfaceHeight, 1, this.projectionMatrix);
        GLES20.glUniformMatrix4fv(this.glPassThroughProgram.getMVPMatrixHandle(), 1, false, this.projectionMatrix, 0);
        this.texturePlane.draw();
        GLES20.glDisable(3042);
    }

    public void setTextureId(int i3) {
        this.mTextureId = i3;
    }

    public void setTextureSize(int i3, int i16) {
        this.mTextureWidth = i3;
        this.mTextureHeight = i16;
    }
}
