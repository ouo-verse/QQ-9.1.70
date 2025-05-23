package com.tencent.taveffect.core;

import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;
import com.tencent.taveffect.effects.BaseEffect;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CacheTextureFilter extends BaseEffect {
    private static final String FRAGMENT_SHADER_CODE = "sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private int[] frameBuffer = new int[1];

    private void bindTexture(int i3) {
        GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
        int[] iArr = this.frameBuffer;
        if (iArr[0] == 0) {
            GLES20.glGenFramebuffers(1, iArr, 0);
        }
        GLES20.glBindFramebuffer(36160, this.frameBuffer[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected String getFragmentShaderCode(TAVTextureInfo tAVTextureInfo) {
        if (tAVTextureInfo.textureType == 36197) {
            return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
        }
        return "uniform sampler2D sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    }

    @Override // com.tencent.taveffect.effects.BaseEffect, com.tencent.taveffect.core.TAVTextureProcessor
    public void release() {
        int[] iArr = this.frameBuffer;
        if (iArr[0] != 0) {
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            this.frameBuffer[0] = 0;
        }
        super.release();
    }

    public void renderTexture(TAVTextureInfo tAVTextureInfo, int i3) {
        if (tAVTextureInfo.textureType != this.textureType || this.program == 0) {
            initShader(tAVTextureInfo);
        }
        bindTexture(i3);
        useProgram();
        onDraw(tAVTextureInfo);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(tAVTextureInfo.getTextureType(), 0);
        int[] iArr = this.defaultViewport;
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
    }
}
