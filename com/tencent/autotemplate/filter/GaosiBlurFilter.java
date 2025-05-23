package com.tencent.autotemplate.filter;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.taveffect.utils.TAVGLUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GaosiBlurFilter extends BaseEffect {
    static IPatchRedirector $redirector_;
    private String FRAGMENT_SHADER;
    private int heightOffsetHandle;
    protected boolean horizontal;
    private int radius;
    private int radiusHandle;
    private int widthOffsetHandle;

    public GaosiBlurFilter(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        this.FRAGMENT_SHADER = "uTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform int uRadius;\nuniform float uWidthOffset;\nuniform float uHeightOffset;\nmediump float getGaussWeight(mediump float currentPos, mediump float sigma) {\n    return 1.0 / sigma * exp(-(currentPos * currentPos) / (2.0 * sigma * sigma));\n}\nvoid main() {\n" + getGaussianSampleCode() + "}";
        this.horizontal = z16;
        this.radius = i3;
    }

    private String getBoxSampleCode() {
        return "   int diameter = 2 * uRadius + 1; \n   vec4 sampleTex;\n   vec3 col = vec3(0.0, 0.0, 0.0);  \n   float weightSum = 0.0; \n   for(int i = 0; i < diameter; i++) {\n       vec2 offset = vec2(float(i - uRadius) * uWidthOffset, float(i - uRadius) * uHeightOffset);  \n       sampleTex = vec4(texture2D(uTexture, vTextureCoord.st+offset));\n       float index = float(i); \n       float boxWeight = float(1.0) / float(diameter); \n       col += sampleTex.rgb * boxWeight; \n       weightSum += boxWeight;\n   }   \n   gl_FragColor = vec4(col / weightSum, sampleTex.a);   \n";
    }

    private String getGaussianSampleCode() {
        return "   int diameter = 2 * uRadius + 1;  \n   vec4 sampleTex;\n   vec3 col = vec3(0.0, 0.0, 0.0);  \n   float weightSum = 0.0; \n   for(int i = 0; i < diameter; i++) {\n       vec2 offset = vec2(float(i - uRadius) * uWidthOffset, float(i - uRadius) * uHeightOffset);  \n       sampleTex = vec4(texture2D(uTexture, vTextureCoord.st+offset));\n       float index = float(i); \n       float gaussWeight = getGaussWeight(index - float(diameter - 1)/2.0,           (float(diameter - 1)/2.0 + 1.0) / 2.0); \n       col += sampleTex.rgb * gaussWeight; \n       weightSum += gaussWeight;\n   }   \n   gl_FragColor = vec4(col / weightSum, sampleTex.a);   \n";
    }

    private String getStackSampleCode() {
        return "int diameter = 2 * uRadius + 1;  \n   vec4 sampleTex;\n   vec3 col = vec3(0.0, 0.0, 0.0);  \n   float weightSum = 0.0; \n   for(int i = 0; i < diameter; i++) {\n       vec2 offset = vec2(float(i - uRadius) * uWidthOffset, float(i - uRadius) * uHeightOffset);  \n       sampleTex = vec4(texture2D(uTexture, vTextureCoord.st+offset));\n       float index = float(i); \n       float boxWeight = float(uRadius) + 1.0 - abs(index - float(uRadius)); \n       col += sampleTex.rgb * boxWeight; \n       weightSum += boxWeight;\n   }   \n   gl_FragColor = vec4(col / weightSum, sampleTex.a);   \n";
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected void beforeDraw(TAVTextureInfo tAVTextureInfo) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tAVTextureInfo);
            return;
        }
        GLES20.glUniform1i(this.radiusHandle, this.radius);
        int i3 = this.widthOffsetHandle;
        float f17 = 0.0f;
        if (this.horizontal) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f / tAVTextureInfo.width;
        }
        GLES20.glUniform1f(i3, f16);
        int i16 = this.heightOffsetHandle;
        if (this.horizontal) {
            f17 = 1.0f / tAVTextureInfo.height;
        }
        GLES20.glUniform1f(i16, f17);
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected String getFragmentShaderCode(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) tAVTextureInfo);
        }
        if (tAVTextureInfo.textureType == 36197) {
            return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES " + this.FRAGMENT_SHADER;
        }
        return "uniform sampler2D " + this.FRAGMENT_SHADER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.taveffect.effects.BaseEffect
    public void initShader(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tAVTextureInfo);
            return;
        }
        super.initShader(tAVTextureInfo);
        this.radiusHandle = GLES20.glGetUniformLocation(this.program, "uRadius");
        TAVGLUtils.checkEglError("glGetUniformLocation uRadius");
        this.widthOffsetHandle = GLES20.glGetUniformLocation(this.program, "uWidthOffset");
        TAVGLUtils.checkEglError("glGetUniformLocation uWidthOffset");
        this.heightOffsetHandle = GLES20.glGetUniformLocation(this.program, "uHeightOffset");
        TAVGLUtils.checkEglError("glGetUniformLocation uHeightOffset");
    }

    public void scale(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        if (this.xyMatrix == null) {
            this.xyMatrix = new Matrix();
        }
        this.xyMatrix.reset();
        this.xyMatrix.setScale(f16, f16);
        this.xyMatrix.postTranslate(f17, f18);
    }

    public void setRadius(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.radius = i3;
        }
    }
}
