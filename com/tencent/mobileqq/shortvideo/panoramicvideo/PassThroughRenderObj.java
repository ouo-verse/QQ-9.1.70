package com.tencent.mobileqq.shortvideo.panoramicvideo;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GL.GLPassThroughProgram;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GL.TextureUtil;

/* loaded from: classes18.dex */
public class PassThroughRenderObj extends BaseRenderObj {
    protected Context context;
    protected GLPassThroughProgram glPassThroughProgram;
    protected float[] projectionMatrix = new float[16];
    private Plane plane = new Plane(true);

    public PassThroughRenderObj(Context context) {
        this.context = context;
        this.glPassThroughProgram = new GLPassThroughProgram(context);
    }

    @Override // com.tencent.mobileqq.shortvideo.panoramicvideo.BaseRenderObj
    public void destroy() {
        this.glPassThroughProgram.onDestroy();
    }

    @Override // com.tencent.mobileqq.shortvideo.panoramicvideo.BaseRenderObj
    public void init() {
        this.glPassThroughProgram.create();
    }

    @Override // com.tencent.mobileqq.shortvideo.panoramicvideo.BaseRenderObj
    public void onDrawFrame(int i3) {
        onPreDrawElements();
        GlUtil.checkGlError("onPreDrawElements");
        this.glPassThroughProgram.use();
        Matrix.setIdentityM(this.projectionMatrix, 0);
        this.plane.uploadTexCoordinateBuffer(this.glPassThroughProgram.getTextureCoordinateHandle());
        this.plane.uploadVerticesBuffer(this.glPassThroughProgram.getPositionHandle());
        GLES20.glUniformMatrix4fv(this.glPassThroughProgram.getMVPMatrixHandle(), 1, false, this.projectionMatrix, 0);
        TextureUtil.bindTexture2D(i3, 33984, this.glPassThroughProgram.getTextureSamplerHandle(), 0);
        GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
        this.plane.draw();
    }
}
