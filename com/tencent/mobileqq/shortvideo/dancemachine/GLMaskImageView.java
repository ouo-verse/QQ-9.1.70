package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GLMaskImageView extends GLImageView {
    protected GLImage mMask;
    private String mMaskPath;
    RectF region;

    public GLMaskImageView(GLViewContext gLViewContext, String str) {
        super(gLViewContext, str);
        this.mMask = new GLImage();
        this.region = new RectF();
        this.mMaskPath = "";
        initView(4);
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GLImageView, com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void release() {
        super.release();
        this.mMask.release();
        this.mMaskPath = "";
    }

    public void setMaskImage(String str) {
        if (!this.mMaskPath.equals(str)) {
            this.mMask.loadTextureSync(str);
            this.mMaskPath = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void transferVertexData() {
        super.transferVertexData();
        RectF currentDrawRegionSize = getCurrentDrawRegionSize();
        RectF rectF = new RectF(this.context.getViewPort());
        this.region.setIntersect(currentDrawRegionSize, rectF);
        float width = (this.region.left - rectF.left) / rectF.width();
        float width2 = (rectF.right - this.region.right) / rectF.width();
        float height = (this.region.top - rectF.top) / rectF.height();
        float height2 = (rectF.bottom - this.region.bottom) / rectF.height();
        this.mVertexBuffer.put(width);
        this.mVertexBuffer.put(height);
        this.mVertexBuffer.put(width);
        float f16 = 1.0f - height2;
        this.mVertexBuffer.put(f16);
        float f17 = 1.0f - width2;
        this.mVertexBuffer.put(f17);
        this.mVertexBuffer.put(f16);
        this.mVertexBuffer.put(f17);
        this.mVertexBuffer.put(height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void updateAttribute() {
        super.updateAttribute();
        int intValue = this.mProgramObject.attribute.get("a_texCoordMask").intValue();
        GLES20.glVertexAttribPointer(intValue, 2, 5126, false, 0, this.mProgramObject.getMaskOffset() * this.mVertexPointCount * 4);
        GLES20.glEnableVertexAttribArray(intValue);
        int intValue2 = this.mProgramObject.uniform.get("u_texture_mask").intValue();
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mMask.getTexture());
        GLES20.glUniform1i(intValue2, 1);
    }
}
