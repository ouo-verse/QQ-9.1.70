package com.tencent.autotemplate.filter;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.taveffect.core.TAVRectangle;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.taveffect.utils.TAVGLUtils;

/* compiled from: P */
@Deprecated
/* loaded from: classes3.dex */
public class ScaleFilter extends BaseEffect {
    static IPatchRedirector $redirector_ = null;
    private static final String FRAGMENT_SHADER_CODE = "sTexture;\nuniform sampler2D blurTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float blurOffsetX;  // x\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nuniform float blurOffsetY;  // y\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nvoid main() {\n   vec2 uv = vTextureCoord.xy;\n   vec4 color;\n   // \u4e2d\u95f4\u4e3a\u539f\u56fe\uff0c\u9700\u8981\u7f29\u5c0f\n   if (uv.x >= blurOffsetX && uv.x <= 1.0 - blurOffsetX && uv.y >= blurOffsetY && uv.y <= 1.0 - blurOffsetY) {\n       // \u5185\u90e8UV\u7f29\u653e\u503c\n       float scaleX = 1.0 / (1.0 - 2.0 * blurOffsetX);\n       float scaleY = 1.0 / (1.0 - 2.0 * blurOffsetY);\n       // \u8ba1\u7b97\u51fa\u5185\u90e8\u65b0\u7684UV\u5750\u6807\n       vec2 newUV = vec2((uv.x - blurOffsetX) * scaleX, (uv.y - blurOffsetY) * scaleY);\n       color = texture2D(sTexture, newUV);\n   } else {\n       color = texture2D(blurTexture, uv);\n   }\n   gl_FragColor = color;\n}";
    private int blurOffsetXHandle;
    private int blurOffsetYHandle;
    private int blurTextureHandle;
    private TAVTextureInfo blurTextureInfo;
    private float offsetX;
    private float offsetY;

    public ScaleFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public TAVTextureInfo applyNewTexture(TAVTextureInfo tAVTextureInfo, TAVTextureInfo tAVTextureInfo2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TAVTextureInfo) iPatchRedirector.redirect((short) 9, (Object) this, (Object) tAVTextureInfo, (Object) tAVTextureInfo2);
        }
        this.blurTextureInfo = tAVTextureInfo;
        return super.applyNewTexture(tAVTextureInfo2);
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected void beforeDraw(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) tAVTextureInfo);
            return;
        }
        GLES20.glUniform1f(this.blurOffsetXHandle, this.offsetX);
        GLES20.glUniform1f(this.blurOffsetYHandle, this.offsetY);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.blurTextureInfo.textureID);
        GLES20.glUniform1i(this.blurTextureHandle, 1);
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected String getFragmentShaderCode(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) tAVTextureInfo);
        }
        if (tAVTextureInfo.textureType == 36197) {
            return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nuniform sampler2D blurTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float blurOffsetX;  // x\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nuniform float blurOffsetY;  // y\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nvoid main() {\n   vec2 uv = vTextureCoord.xy;\n   vec4 color;\n   // \u4e2d\u95f4\u4e3a\u539f\u56fe\uff0c\u9700\u8981\u7f29\u5c0f\n   if (uv.x >= blurOffsetX && uv.x <= 1.0 - blurOffsetX && uv.y >= blurOffsetY && uv.y <= 1.0 - blurOffsetY) {\n       // \u5185\u90e8UV\u7f29\u653e\u503c\n       float scaleX = 1.0 / (1.0 - 2.0 * blurOffsetX);\n       float scaleY = 1.0 / (1.0 - 2.0 * blurOffsetY);\n       // \u8ba1\u7b97\u51fa\u5185\u90e8\u65b0\u7684UV\u5750\u6807\n       vec2 newUV = vec2((uv.x - blurOffsetX) * scaleX, (uv.y - blurOffsetY) * scaleY);\n       color = texture2D(sTexture, newUV);\n   } else {\n       color = texture2D(blurTexture, uv);\n   }\n   gl_FragColor = color;\n}";
        }
        return "uniform sampler2D sTexture;\nuniform sampler2D blurTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float blurOffsetX;  // x\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nuniform float blurOffsetY;  // y\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nvoid main() {\n   vec2 uv = vTextureCoord.xy;\n   vec4 color;\n   // \u4e2d\u95f4\u4e3a\u539f\u56fe\uff0c\u9700\u8981\u7f29\u5c0f\n   if (uv.x >= blurOffsetX && uv.x <= 1.0 - blurOffsetX && uv.y >= blurOffsetY && uv.y <= 1.0 - blurOffsetY) {\n       // \u5185\u90e8UV\u7f29\u653e\u503c\n       float scaleX = 1.0 / (1.0 - 2.0 * blurOffsetX);\n       float scaleY = 1.0 / (1.0 - 2.0 * blurOffsetY);\n       // \u8ba1\u7b97\u51fa\u5185\u90e8\u65b0\u7684UV\u5750\u6807\n       vec2 newUV = vec2((uv.x - blurOffsetX) * scaleX, (uv.y - blurOffsetY) * scaleY);\n       color = texture2D(sTexture, newUV);\n   } else {\n       color = texture2D(blurTexture, uv);\n   }\n   gl_FragColor = color;\n}";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.taveffect.effects.BaseEffect
    public TAVTextureInfo getOutputTextureInfo(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TAVTextureInfo) iPatchRedirector.redirect((short) 10, (Object) this, (Object) tAVTextureInfo);
        }
        if (this.outputTextureInfo == null) {
            this.outputTextureInfo = new TAVTextureInfo();
        }
        this.outputTextureInfo.setFrameTimeUs(tAVTextureInfo.frameTimeUs);
        this.outputTextureInfo.setWidth(this.rendererWidth);
        this.outputTextureInfo.setHeight(this.rendererHeight);
        this.outputTextureInfo.setPreRotation(tAVTextureInfo.getPreRotation());
        this.outputTextureInfo.setTextureType(GLSLRender.GL_TEXTURE_2D);
        this.outputTextureInfo.setTextureID(this.textureID[0]);
        return this.outputTextureInfo;
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
        this.blurOffsetXHandle = GLES20.glGetUniformLocation(this.program, "blurOffsetX");
        TAVGLUtils.checkEglError("glGetUniformLocation blurOffsetX");
        this.blurOffsetYHandle = GLES20.glGetUniformLocation(this.program, "blurOffsetY");
        TAVGLUtils.checkEglError("glGetUniformLocation blurOffsetY");
        this.blurTextureHandle = GLES20.glGetUniformLocation(this.program, "blurTexture");
        TAVGLUtils.checkEglError("glGetUniformLocation blurTexture");
    }

    public void setBlurTextureInfo(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tAVTextureInfo);
        } else {
            this.blurTextureInfo = tAVTextureInfo;
        }
    }

    public void setOffsetX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            this.offsetX = f16;
        }
    }

    public void setOffsetY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.offsetY = f16;
        }
    }

    @Override // com.tencent.taveffect.effects.BaseEffect, com.tencent.taveffect.core.TAVBaseFilter
    public void setParams(Matrix matrix, Matrix matrix2, TAVRectangle tAVRectangle, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, matrix, matrix2, tAVRectangle, Float.valueOf(f16));
        } else {
            this.cropRect = tAVRectangle;
            this.alpha = f16;
        }
    }
}
