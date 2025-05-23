package com.tencent.taveffect.effects;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.taveffect.core.CacheTextureFilter;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.utils.TAVGLUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CanyingEffect extends BaseEffect {
    private static final String FRAGMENT_SHADER_CODE = "curTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nfloat currentFrameWeight = 0.35;\nuniform sampler2D beforeFrame1;\nfloat beforeFrame1Weight = 0.3;\nuniform sampler2D beforeFrame2;\nfloat beforeFrame2Weight = 0.2;\nuniform sampler2D beforeFrame3;\nfloat beforeFrame3Weight = 0.1;\nuniform sampler2D beforeFrame4;\nfloat beforeFrame4Weight = 0.05;\nvoid main()\n{\n    vec4 renderTex = texture2D(curTexture,vTextureCoord);\n    \t    \n    vec4 shadow1 = texture2D(beforeFrame1, vTextureCoord);\n    vec4 shadow2 = texture2D(beforeFrame2, vTextureCoord);\n    vec4 shadow3 = texture2D(beforeFrame3, vTextureCoord);\n    vec4 shadow4 = texture2D(beforeFrame4, vTextureCoord);\n    \n    vec4 shadow = beforeFrame1Weight * shadow1 + beforeFrame2Weight * shadow2 + beforeFrame3Weight * shadow3 + beforeFrame4Weight * shadow4;\n    gl_FragColor = currentFrameWeight * renderTex + shadow;\n}";
    private int beforeFrame1Handle;
    private int beforeFrame2Handle;
    private int beforeFrame3Handle;
    private int beforeFrame4Handle;
    private CacheTextureFilter cacheTextureFilter;
    private int[] cacheTexture = new int[4];
    private int[] frameBuffer = new int[1];
    private int currFrameIndex = 0;

    private void cacheTexture(TAVTextureInfo tAVTextureInfo, int i3) {
        if (tAVTextureInfo.getTextureType() == 36197) {
            if (this.cacheTextureFilter == null) {
                this.cacheTextureFilter = new CacheTextureFilter();
            }
            this.cacheTextureFilter.setParams(this.xyMatrix, this.stMatrix, this.cropRect, this.alpha);
            this.cacheTextureFilter.setRendererWidth(this.rendererWidth);
            this.cacheTextureFilter.setRendererHeight(this.rendererHeight);
            this.cacheTextureFilter.renderTexture(tAVTextureInfo, this.cacheTexture[i3 - 1]);
            return;
        }
        GLES20.glBindFramebuffer(36160, this.frameBuffer[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, tAVTextureInfo.textureID, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.cacheTexture[i3 - 1]);
        GLES20.glCopyTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6407, 0, 0, this.rendererWidth, this.rendererHeight, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
    }

    private void setBeforeTexture(int i3, int i16) {
        GLES20.glActiveTexture(33984 + i16);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.cacheTexture[i16 - 1]);
        GLES20.glUniform1i(i3, i16);
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected void afterDraw(TAVTextureInfo tAVTextureInfo) {
        int i3 = this.currFrameIndex;
        if (i3 % 4 == 0) {
            cacheTexture(tAVTextureInfo, 4);
        } else if (i3 % 4 == 1) {
            cacheTexture(tAVTextureInfo, 3);
        } else if (i3 % 4 == 2) {
            cacheTexture(tAVTextureInfo, 2);
        } else {
            cacheTexture(tAVTextureInfo, 1);
        }
        int i16 = this.currFrameIndex + 1;
        this.currFrameIndex = i16;
        if (i16 > 3) {
            this.currFrameIndex = 0;
        }
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected void beforeDraw(TAVTextureInfo tAVTextureInfo) {
        setBeforeTexture(this.beforeFrame1Handle, 1);
        setBeforeTexture(this.beforeFrame2Handle, 2);
        setBeforeTexture(this.beforeFrame3Handle, 3);
        setBeforeTexture(this.beforeFrame4Handle, 4);
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected String getFragmentShaderCode(TAVTextureInfo tAVTextureInfo) {
        if (tAVTextureInfo.textureType == 36197) {
            return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES curTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nfloat currentFrameWeight = 0.35;\nuniform sampler2D beforeFrame1;\nfloat beforeFrame1Weight = 0.3;\nuniform sampler2D beforeFrame2;\nfloat beforeFrame2Weight = 0.2;\nuniform sampler2D beforeFrame3;\nfloat beforeFrame3Weight = 0.1;\nuniform sampler2D beforeFrame4;\nfloat beforeFrame4Weight = 0.05;\nvoid main()\n{\n    vec4 renderTex = texture2D(curTexture,vTextureCoord);\n    \t    \n    vec4 shadow1 = texture2D(beforeFrame1, vTextureCoord);\n    vec4 shadow2 = texture2D(beforeFrame2, vTextureCoord);\n    vec4 shadow3 = texture2D(beforeFrame3, vTextureCoord);\n    vec4 shadow4 = texture2D(beforeFrame4, vTextureCoord);\n    \n    vec4 shadow = beforeFrame1Weight * shadow1 + beforeFrame2Weight * shadow2 + beforeFrame3Weight * shadow3 + beforeFrame4Weight * shadow4;\n    gl_FragColor = currentFrameWeight * renderTex + shadow;\n}";
        }
        return "uniform sampler2D curTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nfloat currentFrameWeight = 0.35;\nuniform sampler2D beforeFrame1;\nfloat beforeFrame1Weight = 0.3;\nuniform sampler2D beforeFrame2;\nfloat beforeFrame2Weight = 0.2;\nuniform sampler2D beforeFrame3;\nfloat beforeFrame3Weight = 0.1;\nuniform sampler2D beforeFrame4;\nfloat beforeFrame4Weight = 0.05;\nvoid main()\n{\n    vec4 renderTex = texture2D(curTexture,vTextureCoord);\n    \t    \n    vec4 shadow1 = texture2D(beforeFrame1, vTextureCoord);\n    vec4 shadow2 = texture2D(beforeFrame2, vTextureCoord);\n    vec4 shadow3 = texture2D(beforeFrame3, vTextureCoord);\n    vec4 shadow4 = texture2D(beforeFrame4, vTextureCoord);\n    \n    vec4 shadow = beforeFrame1Weight * shadow1 + beforeFrame2Weight * shadow2 + beforeFrame3Weight * shadow3 + beforeFrame4Weight * shadow4;\n    gl_FragColor = currentFrameWeight * renderTex + shadow;\n}";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.taveffect.effects.BaseEffect
    public void initShader(TAVTextureInfo tAVTextureInfo) {
        super.initShader(tAVTextureInfo);
        this.beforeFrame1Handle = GLES20.glGetUniformLocation(this.program, "beforeFrame1");
        this.beforeFrame2Handle = GLES20.glGetUniformLocation(this.program, "beforeFrame2");
        this.beforeFrame3Handle = GLES20.glGetUniformLocation(this.program, "beforeFrame3");
        this.beforeFrame4Handle = GLES20.glGetUniformLocation(this.program, "beforeFrame4");
        GLES20.glGenTextures(4, this.cacheTexture, 0);
        for (int i3 = 0; i3 < 4; i3++) {
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.cacheTexture[i3]);
            TAVGLUtils.checkEglError("glBindTexture mTextureID");
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6407, this.rendererWidth, this.rendererHeight, 0, 6407, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
            TAVGLUtils.checkEglError("glTexParameter");
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        }
        GLES20.glGenFramebuffers(1, this.frameBuffer, 0);
    }

    @Override // com.tencent.taveffect.effects.BaseEffect, com.tencent.taveffect.core.TAVTextureProcessor
    public void release() {
        CacheTextureFilter cacheTextureFilter = this.cacheTextureFilter;
        if (cacheTextureFilter != null) {
            cacheTextureFilter.release();
        }
        int[] iArr = this.cacheTexture;
        if (iArr[0] != 0) {
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
        }
        int[] iArr2 = this.frameBuffer;
        if (iArr2[0] != 0) {
            GLES20.glDeleteFramebuffers(1, iArr2, 0);
            this.frameBuffer[0] = 0;
        }
        super.release();
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    /* renamed from: clone */
    public CanyingEffect mo93clone() {
        return (CanyingEffect) cloneFilter(new CanyingEffect());
    }
}
