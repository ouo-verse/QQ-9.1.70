package com.tencent.taveffect.effects;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.taveffect.core.CacheTextureFilter;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.utils.TAVGLUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public class HuanjueEffect extends BaseEffect {
    private static final String FRAGMENT_SHADER_CODE = "curTexture;\nprecision mediump float;\nuniform sampler2D beforeFrame;\nvarying vec2 vTextureCoord;\nuniform vec4 colorMask;\nfloat shadowScale = 3.0;\nfloat shadowContrast = 3.0;\nvoid main()\n{\n    vec4 shadow =  texture2D(beforeFrame, vTextureCoord);\n    vec4 videoColor = texture2D(curTexture, vTextureCoord);\n\n    float luminanceMain = 0.2125 * videoColor.r + 0.7154 * videoColor.g + 0.0721 * videoColor.b;\n    float luminanceShadow = 0.2125 * shadow.r + 0.7154 * shadow.g + 0.0721 * shadow.b;\n\n    float gray = max(1.0 - luminanceMain, 1.0 - luminanceShadow);\n\n    float scale = pow(gray, shadowContrast) * shadowScale;\n    vec4 mask = clamp(colorMask * scale, 0.0, 1.0);\n    mask.w = 0.0;\n\n    vec4 preColor = mask * videoColor + (vec4(1.0, 1.0, 1.0, 1.0) - mask) * shadow;\n    vec4 afterColor = (vec4(1.0, 1.0, 1.0, 1.0) - mask) * videoColor + mask * shadow;\n    gl_FragColor = colorMask.w * preColor + (1.0 - colorMask.w) * afterColor;\n}";
    private int beforeFrameHandle;
    private CacheTextureFilter cacheTextureFilter;
    private int colorMaskHandle;
    private int curTextureHandle;
    private int currFrameIndex = 0;
    private int[] frameBuffer = new int[1];
    private int[] cacheTexture = new int[1];

    private void cacheTexture(TAVTextureInfo tAVTextureInfo) {
        if (tAVTextureInfo.getTextureType() == 36197) {
            if (this.cacheTextureFilter == null) {
                this.cacheTextureFilter = new CacheTextureFilter();
            }
            this.cacheTextureFilter.setParams(this.xyMatrix, this.stMatrix, this.cropRect, this.alpha);
            this.cacheTextureFilter.setRendererWidth(this.rendererWidth);
            this.cacheTextureFilter.setRendererHeight(this.rendererHeight);
            this.cacheTextureFilter.renderTexture(tAVTextureInfo, this.cacheTexture[0]);
            return;
        }
        GLES20.glBindFramebuffer(36160, this.frameBuffer[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, tAVTextureInfo.textureID, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.cacheTexture[0]);
        GLES20.glCopyTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6407, 0, 0, this.rendererWidth, this.rendererHeight, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected void afterDraw(TAVTextureInfo tAVTextureInfo) {
        int i3 = this.currFrameIndex;
        if (i3 == 0) {
            cacheTexture(tAVTextureInfo);
        } else if (i3 == 1) {
            GLES20.glUniform4f(this.colorMaskHandle, 1.0f, 0.0f, 0.0f, 1.0f);
        } else if (i3 == 4) {
            GLES20.glUniform4f(this.colorMaskHandle, 0.0f, 0.0f, 1.0f, 0.0f);
        }
        int i16 = this.currFrameIndex + 1;
        this.currFrameIndex = i16;
        if (i16 > 8) {
            this.currFrameIndex = 0;
        }
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected void beforeDraw(TAVTextureInfo tAVTextureInfo) {
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.cacheTexture[0]);
        GLES20.glUniform1i(this.beforeFrameHandle, 1);
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected String getFragmentShaderCode(TAVTextureInfo tAVTextureInfo) {
        if (tAVTextureInfo.textureType == 36197) {
            return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES curTexture;\nprecision mediump float;\nuniform sampler2D beforeFrame;\nvarying vec2 vTextureCoord;\nuniform vec4 colorMask;\nfloat shadowScale = 3.0;\nfloat shadowContrast = 3.0;\nvoid main()\n{\n    vec4 shadow =  texture2D(beforeFrame, vTextureCoord);\n    vec4 videoColor = texture2D(curTexture, vTextureCoord);\n\n    float luminanceMain = 0.2125 * videoColor.r + 0.7154 * videoColor.g + 0.0721 * videoColor.b;\n    float luminanceShadow = 0.2125 * shadow.r + 0.7154 * shadow.g + 0.0721 * shadow.b;\n\n    float gray = max(1.0 - luminanceMain, 1.0 - luminanceShadow);\n\n    float scale = pow(gray, shadowContrast) * shadowScale;\n    vec4 mask = clamp(colorMask * scale, 0.0, 1.0);\n    mask.w = 0.0;\n\n    vec4 preColor = mask * videoColor + (vec4(1.0, 1.0, 1.0, 1.0) - mask) * shadow;\n    vec4 afterColor = (vec4(1.0, 1.0, 1.0, 1.0) - mask) * videoColor + mask * shadow;\n    gl_FragColor = colorMask.w * preColor + (1.0 - colorMask.w) * afterColor;\n}";
        }
        return "uniform sampler2D curTexture;\nprecision mediump float;\nuniform sampler2D beforeFrame;\nvarying vec2 vTextureCoord;\nuniform vec4 colorMask;\nfloat shadowScale = 3.0;\nfloat shadowContrast = 3.0;\nvoid main()\n{\n    vec4 shadow =  texture2D(beforeFrame, vTextureCoord);\n    vec4 videoColor = texture2D(curTexture, vTextureCoord);\n\n    float luminanceMain = 0.2125 * videoColor.r + 0.7154 * videoColor.g + 0.0721 * videoColor.b;\n    float luminanceShadow = 0.2125 * shadow.r + 0.7154 * shadow.g + 0.0721 * shadow.b;\n\n    float gray = max(1.0 - luminanceMain, 1.0 - luminanceShadow);\n\n    float scale = pow(gray, shadowContrast) * shadowScale;\n    vec4 mask = clamp(colorMask * scale, 0.0, 1.0);\n    mask.w = 0.0;\n\n    vec4 preColor = mask * videoColor + (vec4(1.0, 1.0, 1.0, 1.0) - mask) * shadow;\n    vec4 afterColor = (vec4(1.0, 1.0, 1.0, 1.0) - mask) * videoColor + mask * shadow;\n    gl_FragColor = colorMask.w * preColor + (1.0 - colorMask.w) * afterColor;\n}";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.taveffect.effects.BaseEffect
    public void initShader(TAVTextureInfo tAVTextureInfo) {
        super.initShader(tAVTextureInfo);
        this.colorMaskHandle = GLES20.glGetUniformLocation(this.program, "colorMask");
        this.beforeFrameHandle = GLES20.glGetUniformLocation(this.program, "beforeFrame");
        this.curTextureHandle = GLES20.glGetUniformLocation(this.program, "curTexture");
        GLES20.glGenTextures(1, this.cacheTexture, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.cacheTexture[0]);
        TAVGLUtils.checkEglError("glBindTexture mTextureID");
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6407, this.rendererWidth, this.rendererHeight, 0, 6407, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        TAVGLUtils.checkEglError("glTexParameter");
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
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
            GLES20.glDeleteTextures(1, iArr, 0);
            this.cacheTexture[0] = 0;
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
    public HuanjueEffect mo93clone() {
        return (HuanjueEffect) cloneFilter(new HuanjueEffect());
    }
}
