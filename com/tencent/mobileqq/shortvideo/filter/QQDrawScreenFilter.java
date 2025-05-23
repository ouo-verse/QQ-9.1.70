package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.shortvideo.filter.QQFilterConstants;
import com.tencent.ttpic.openapi.filter.TextureRender;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQDrawScreenFilter extends QQBaseFilter {
    public TextureRender textureRender;

    public QQDrawScreenFilter(int i3, QQFilterRenderManager qQFilterRenderManager) {
        super(i3, qQFilterRenderManager);
    }

    public void init() {
        this.textureRender = new TextureRender();
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        if (this.textureRender == null) {
            init();
        }
        boolean booleanParam = getQQFilterRenderManager().getBooleanParam(QQFilterConstants.FilterParameters.KEY_DRAW_SCREEN);
        int intParam = getQQFilterRenderManager().getIntParam(QQFilterConstants.FilterParameters.KEY_WIDTH);
        int intParam2 = getQQFilterRenderManager().getIntParam(QQFilterConstants.FilterParameters.KEY_HEIGHT);
        if (booleanParam) {
            QQFilterLogManager.setOnDrawFilterStart();
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(0, 0, intParam, intParam2);
            TextureRender textureRender = this.textureRender;
            if (textureRender != null) {
                textureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, this.mInputTextureID, null, null);
            }
            QQFilterLogManager.setOnDrawFilterEnd("\u7ed8\u5236\u5230\u5c4f\u5e55");
        }
        this.mOutputTextureID = this.mInputTextureID;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        TextureRender textureRender = this.textureRender;
        if (textureRender != null) {
            textureRender.release();
            this.textureRender = null;
        }
    }
}
