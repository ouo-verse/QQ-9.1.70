package com.tencent.autotemplate.filter;

import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.taveffect.utils.TAVGLUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MergeTextureFilter extends BaseEffect {
    static IPatchRedirector $redirector_ = null;
    private static final String FRAGMENT_SHADER_CODE = "sTexture;\nuniform sampler2D blurTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float blurOffsetX;  // x\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nuniform float blurOffsetY;  // y\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nuniform float blurOffsetXEnd;  // x\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nuniform float blurOffsetYEnd;  // y\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nvoid main() {\n   if (vTextureCoord.x >= blurOffsetX && vTextureCoord.x <= blurOffsetXEnd && vTextureCoord.y >= blurOffsetY && vTextureCoord.y <= blurOffsetYEnd) {\n       gl_FragColor = texture2D(sTexture, vTextureCoord);\n   } else {\n       gl_FragColor = texture2D(blurTexture, vTextureCoord);\n   }\n}";
    public static final float MERGE_FOR_ERROR = 0.01f;
    private int blurOffsetXEndHandle;
    private int blurOffsetXHandle;
    private int blurOffsetYEndHandle;
    private int blurOffsetYHandle;
    private int blurTextureHandle;
    private TAVTextureInfo blurTextureInfo;
    private float offsetX;
    private float offsetY;

    public MergeTextureFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected void beforeDraw(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) tAVTextureInfo);
            return;
        }
        float f16 = this.offsetX;
        if (f16 == 0.0f) {
            GLES20.glUniform1f(this.blurOffsetXHandle, 0.0f);
            GLES20.glUniform1f(this.blurOffsetXEndHandle, 1.0f);
        } else {
            GLES20.glUniform1f(this.blurOffsetXHandle, f16 + 0.01f);
            GLES20.glUniform1f(this.blurOffsetXEndHandle, (1.0f - this.offsetX) - 0.01f);
        }
        float f17 = this.offsetY;
        if (f17 == 0.0f) {
            GLES20.glUniform1f(this.blurOffsetYHandle, 0.0f);
            GLES20.glUniform1f(this.blurOffsetYEndHandle, 1.0f);
        } else {
            GLES20.glUniform1f(this.blurOffsetYHandle, f17 + 0.01f);
            GLES20.glUniform1f(this.blurOffsetYEndHandle, (1.0f - this.offsetY) - 0.01f);
        }
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.blurTextureInfo.textureID);
        GLES20.glUniform1i(this.blurTextureHandle, 1);
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected String getFragmentShaderCode(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) tAVTextureInfo);
        }
        if (tAVTextureInfo.textureType == 36197) {
            return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nuniform sampler2D blurTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float blurOffsetX;  // x\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nuniform float blurOffsetY;  // y\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nuniform float blurOffsetXEnd;  // x\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nuniform float blurOffsetYEnd;  // y\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nvoid main() {\n   if (vTextureCoord.x >= blurOffsetX && vTextureCoord.x <= blurOffsetXEnd && vTextureCoord.y >= blurOffsetY && vTextureCoord.y <= blurOffsetYEnd) {\n       gl_FragColor = texture2D(sTexture, vTextureCoord);\n   } else {\n       gl_FragColor = texture2D(blurTexture, vTextureCoord);\n   }\n}";
        }
        return "uniform sampler2D sTexture;\nuniform sampler2D blurTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float blurOffsetX;  // x\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nuniform float blurOffsetY;  // y\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nuniform float blurOffsetXEnd;  // x\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nuniform float blurOffsetYEnd;  // y\u8f74\u8fb9\u6846\u6a21\u7cca\u504f\u79fb\u503c\nvoid main() {\n   if (vTextureCoord.x >= blurOffsetX && vTextureCoord.x <= blurOffsetXEnd && vTextureCoord.y >= blurOffsetY && vTextureCoord.y <= blurOffsetYEnd) {\n       gl_FragColor = texture2D(sTexture, vTextureCoord);\n   } else {\n       gl_FragColor = texture2D(blurTexture, vTextureCoord);\n   }\n}";
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
        this.blurOffsetXEndHandle = GLES20.glGetUniformLocation(this.program, "blurOffsetXEnd");
        TAVGLUtils.checkEglError("glGetUniformLocation blurOffsetX");
        this.blurOffsetYEndHandle = GLES20.glGetUniformLocation(this.program, "blurOffsetYEnd");
        TAVGLUtils.checkEglError("glGetUniformLocation blurOffsetY");
        this.blurTextureHandle = GLES20.glGetUniformLocation(this.program, "blurTexture");
        TAVGLUtils.checkEglError("glGetUniformLocation blurTexture");
    }

    public TAVTextureInfo mergeTexture(TAVTextureInfo tAVTextureInfo, TAVTextureInfo tAVTextureInfo2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TAVTextureInfo) iPatchRedirector.redirect((short) 7, (Object) this, (Object) tAVTextureInfo, (Object) tAVTextureInfo2);
        }
        this.blurTextureInfo = tAVTextureInfo;
        return super.applyNewTexture(tAVTextureInfo2);
    }

    public void setOffsetX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.offsetX = f16;
        }
    }

    public void setOffsetY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            this.offsetY = f16;
        }
    }
}
