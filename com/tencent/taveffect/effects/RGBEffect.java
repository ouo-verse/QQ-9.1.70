package com.tencent.taveffect.effects;

import android.opengl.GLES20;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.utils.TAVGLUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public class RGBEffect extends BaseEffect {
    private static final String FRAGMENT_SHADER_CODE = "sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float progress;\nuniform vec2 maxOffset;\nvoid main()\n{\n    float updateProgress = clamp(progress, 0.0, 1.0);\n    vec2 offset = mix(vec2(0.0, 0.0), maxOffset, updateProgress);\n    vec4 shadowG = texture2D(sTexture, vTextureCoord);\n    vec4 shadowGColor = vec4(0.0, shadowG.y, 0.0, 1.0);\n    vec4 shadowR = texture2D(sTexture, vTextureCoord + offset);\n    vec4 shadowRColor = vec4(shadowR.x, 0.0, 0.0, 1.0);\n    vec4 shadowB = texture2D(sTexture, vTextureCoord - offset);\n    vec4 shadowBColor = vec4(0.0, 0.0, shadowB.z, 1.0);\n    gl_FragColor = (shadowRColor + shadowGColor + shadowBColor);\n}";
    private float delayTime;
    private int maxOffsetHandle;
    private float progress;
    private int progressHandle;

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected void beforeDraw(TAVTextureInfo tAVTextureInfo) {
        float f16 = this.progress;
        if (f16 <= 1.01f) {
            this.progress = f16 + 0.03f;
        } else {
            float f17 = this.delayTime + 0.03f;
            this.delayTime = f17;
            if (f17 > 0.3f) {
                this.progress = 0.0f;
                this.delayTime = 0.0f;
            }
        }
        GLES20.glUniform2f(this.maxOffsetHandle, 0.05f, 0.0f);
        TAVGLUtils.checkEglError("glUniform2f maxOffsetHandle");
        GLES20.glUniform1f(this.progressHandle, this.progress);
        TAVGLUtils.checkEglError("glUniform1f progressHandle");
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected String getFragmentShaderCode(TAVTextureInfo tAVTextureInfo) {
        if (tAVTextureInfo.textureType == 36197) {
            return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float progress;\nuniform vec2 maxOffset;\nvoid main()\n{\n    float updateProgress = clamp(progress, 0.0, 1.0);\n    vec2 offset = mix(vec2(0.0, 0.0), maxOffset, updateProgress);\n    vec4 shadowG = texture2D(sTexture, vTextureCoord);\n    vec4 shadowGColor = vec4(0.0, shadowG.y, 0.0, 1.0);\n    vec4 shadowR = texture2D(sTexture, vTextureCoord + offset);\n    vec4 shadowRColor = vec4(shadowR.x, 0.0, 0.0, 1.0);\n    vec4 shadowB = texture2D(sTexture, vTextureCoord - offset);\n    vec4 shadowBColor = vec4(0.0, 0.0, shadowB.z, 1.0);\n    gl_FragColor = (shadowRColor + shadowGColor + shadowBColor);\n}";
        }
        return "uniform sampler2D sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float progress;\nuniform vec2 maxOffset;\nvoid main()\n{\n    float updateProgress = clamp(progress, 0.0, 1.0);\n    vec2 offset = mix(vec2(0.0, 0.0), maxOffset, updateProgress);\n    vec4 shadowG = texture2D(sTexture, vTextureCoord);\n    vec4 shadowGColor = vec4(0.0, shadowG.y, 0.0, 1.0);\n    vec4 shadowR = texture2D(sTexture, vTextureCoord + offset);\n    vec4 shadowRColor = vec4(shadowR.x, 0.0, 0.0, 1.0);\n    vec4 shadowB = texture2D(sTexture, vTextureCoord - offset);\n    vec4 shadowBColor = vec4(0.0, 0.0, shadowB.z, 1.0);\n    gl_FragColor = (shadowRColor + shadowGColor + shadowBColor);\n}";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.taveffect.effects.BaseEffect
    public void initShader(TAVTextureInfo tAVTextureInfo) {
        super.initShader(tAVTextureInfo);
        this.maxOffsetHandle = GLES20.glGetUniformLocation(this.program, "maxOffset");
        TAVGLUtils.checkEglError("glGetAttribLocation maxOffset");
        this.progressHandle = GLES20.glGetUniformLocation(this.program, "progress");
        TAVGLUtils.checkEglError("glGetAttribLocation progress");
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    /* renamed from: clone */
    public RGBEffect mo93clone() {
        return (RGBEffect) cloneFilter(new RGBEffect());
    }
}
