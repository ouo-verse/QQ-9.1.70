package com.tencent.taveffect.effects;

import android.opengl.GLES20;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.utils.TAVGLUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ShanbaiEffect extends BaseEffect {
    private static String FRAGMENT_SHADER_CODE = "sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float brightness;\nuniform float contrast;\nfloat saturation = 1.0;\nvec4 addEnd = vec4(0.0, 0.0, 0.0, 0.0);\nvec4 multiplier = vec4(1.0, 1.0, 1.0, 1.0);\nvoid main()\n{\n    vec4 renderTex = texture2D(sTexture, vTextureCoord);\n\n    vec4 finalColor = renderTex;\n\n    float gray = 0.2125 * renderTex.r + 0.7154 * renderTex.g + 0.0721 * renderTex.b;\n    vec4 grayColor = vec4(gray, gray, gray, 1.0);\n\n    finalColor = mix(grayColor, finalColor, saturation);\n\n    vec4 avgColor = vec4(0.5, 0.5, 0.5, 1.0);\n\n    finalColor = mix(avgColor, finalColor, contrast);\n\n    finalColor = finalColor + addEnd;\n    finalColor = abs(finalColor);\n\n    finalColor = finalColor * multiplier;\n    finalColor = finalColor * brightness;\n\n    gl_FragColor = finalColor;\n}";
    private int brightnessHandle;
    private int contrastHandle;
    private float brightnessMax = 3.0f;
    private float contrastMax = 1.3f;
    private float brightnessNormal = 1.0f;
    private float contrastNormal = 1.0f;
    public float progress = 0.0f;
    private float delayTime = 0.0f;
    private boolean flashUp = true;
    private boolean flashDown = false;

    private void update() {
        if (this.flashUp) {
            float f16 = this.progress + (this.deltaTime * 7.0f);
            this.progress = f16;
            if (f16 > 1.0f) {
                this.flashUp = false;
                this.flashDown = true;
                this.progress = 1.0f;
            }
            GLES20.glUniform1f(this.brightnessHandle, TAVGLUtils.lerp(this.brightnessNormal, this.brightnessMax, this.progress));
            GLES20.glUniform1f(this.contrastHandle, TAVGLUtils.lerp(this.contrastNormal, this.contrastMax, this.progress));
            return;
        }
        if (this.flashDown) {
            float f17 = this.progress - (this.deltaTime * 7.0f);
            this.progress = f17;
            if (f17 <= 0.0f) {
                this.flashUp = false;
                this.flashDown = false;
                this.progress = 0.0f;
            }
            GLES20.glUniform1f(this.brightnessHandle, TAVGLUtils.lerp(this.brightnessNormal, this.brightnessMax, this.progress));
            GLES20.glUniform1f(this.contrastHandle, TAVGLUtils.lerp(this.contrastNormal, this.contrastMax, this.progress));
            return;
        }
        float f18 = this.delayTime + this.deltaTime;
        this.delayTime = f18;
        if (f18 > 0.1f) {
            this.delayTime = 0.0f;
            this.progress = 0.0f;
            this.flashUp = true;
            this.flashDown = false;
        }
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected void beforeDraw(TAVTextureInfo tAVTextureInfo) {
        update();
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected String getFragmentShaderCode(TAVTextureInfo tAVTextureInfo) {
        if (tAVTextureInfo.textureType == 36197) {
            return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES " + FRAGMENT_SHADER_CODE;
        }
        return "uniform sampler2D " + FRAGMENT_SHADER_CODE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.taveffect.effects.BaseEffect
    public void initShader(TAVTextureInfo tAVTextureInfo) {
        super.initShader(tAVTextureInfo);
        this.brightnessHandle = GLES20.glGetUniformLocation(this.program, "brightness");
        TAVGLUtils.checkEglError("glGetAttribLocation brightness");
        this.contrastHandle = GLES20.glGetUniformLocation(this.program, "contrast");
        TAVGLUtils.checkEglError("glGetAttribLocation contrast");
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    /* renamed from: clone */
    public ShanbaiEffect mo93clone() {
        return (ShanbaiEffect) cloneFilter(new ShanbaiEffect());
    }
}
