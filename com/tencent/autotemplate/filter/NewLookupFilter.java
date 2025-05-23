package com.tencent.autotemplate.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.taveffect.effects.LookupFilter;
import com.tencent.taveffect.utils.TAVGLUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NewLookupFilter extends BaseEffect {
    static IPatchRedirector $redirector_ = null;
    private static final String FRAGMENT_SHADER = "sTexture;\nprecision mediump float;\nuniform sampler2D sLookupTexture; // lookup texture\nvarying highp vec2 vTextureCoord;\n\nuniform lowp float intensity;\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    textureColor = clamp(textureColor, 0.0, 1.0);\n    highp float blueColor = textureColor.b * 63.0;\n    \n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    \n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    \n    highp float redPos = 0.125 * textureColor.r;\n    highp float greenPos = 0.125 * textureColor.g;\n    redPos = clamp(redPos, 2.0/512.0, 0.125- 2.0/512.0);\n    greenPos = clamp(greenPos, 2.0/512.0, 0.125- 2.0/512.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + redPos;\n    texPos1.y = (quad1.y * 0.125)  + greenPos;\n    \n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125)  + redPos;\n    texPos2.y = (quad2.y * 0.125) + greenPos;\n    \n    lowp vec4 newColor1 = texture2D(sLookupTexture, texPos1);\n    lowp vec4 newColor2 = texture2D(sLookupTexture, texPos2);\n    \n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n    gl_FragColor = newColor;\n}";
    private static final String FRAGMENT_SHADER_PREFIX = "uniform sampler2D  ";
    private static final String FRAGMENT_SHADER_PREFIX_OES = " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES ";
    private float intensity;
    private int intensityHandle;
    private Bitmap lookupBitmap;
    private int lookupTextureID;
    private int sLookupTextureHandle;

    public NewLookupFilter(Bitmap bitmap) {
        this(bitmap, 1.0f);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmap);
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected void afterDraw(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) tAVTextureInfo);
        } else {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        }
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected void beforeDraw(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tAVTextureInfo);
            return;
        }
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.lookupTextureID);
        GLES20.glUniform1i(this.sLookupTextureHandle, 1);
        GLES20.glUniform1f(this.intensityHandle, this.intensity);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        NewLookupFilter newLookupFilter = (NewLookupFilter) obj;
        if (this.intensity != newLookupFilter.intensity || this.lookupBitmap != newLookupFilter.lookupBitmap) {
            return false;
        }
        return super.equals(obj);
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected String getFragmentShaderCode(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) tAVTextureInfo);
        }
        if (tAVTextureInfo.textureType == 36197) {
            return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nuniform sampler2D sLookupTexture; // lookup texture\nvarying highp vec2 vTextureCoord;\n\nuniform lowp float intensity;\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    textureColor = clamp(textureColor, 0.0, 1.0);\n    highp float blueColor = textureColor.b * 63.0;\n    \n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    \n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    \n    highp float redPos = 0.125 * textureColor.r;\n    highp float greenPos = 0.125 * textureColor.g;\n    redPos = clamp(redPos, 2.0/512.0, 0.125- 2.0/512.0);\n    greenPos = clamp(greenPos, 2.0/512.0, 0.125- 2.0/512.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + redPos;\n    texPos1.y = (quad1.y * 0.125)  + greenPos;\n    \n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125)  + redPos;\n    texPos2.y = (quad2.y * 0.125) + greenPos;\n    \n    lowp vec4 newColor1 = texture2D(sLookupTexture, texPos1);\n    lowp vec4 newColor2 = texture2D(sLookupTexture, texPos2);\n    \n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n    gl_FragColor = newColor;\n}";
        }
        return "uniform sampler2D  sTexture;\nprecision mediump float;\nuniform sampler2D sLookupTexture; // lookup texture\nvarying highp vec2 vTextureCoord;\n\nuniform lowp float intensity;\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    textureColor = clamp(textureColor, 0.0, 1.0);\n    highp float blueColor = textureColor.b * 63.0;\n    \n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    \n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    \n    highp float redPos = 0.125 * textureColor.r;\n    highp float greenPos = 0.125 * textureColor.g;\n    redPos = clamp(redPos, 2.0/512.0, 0.125- 2.0/512.0);\n    greenPos = clamp(greenPos, 2.0/512.0, 0.125- 2.0/512.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + redPos;\n    texPos1.y = (quad1.y * 0.125)  + greenPos;\n    \n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125)  + redPos;\n    texPos2.y = (quad2.y * 0.125) + greenPos;\n    \n    lowp vec4 newColor1 = texture2D(sLookupTexture, texPos1);\n    lowp vec4 newColor2 = texture2D(sLookupTexture, texPos2);\n    \n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n    gl_FragColor = newColor;\n}";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.taveffect.effects.BaseEffect
    public TAVTextureInfo getOutputTextureInfo(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TAVTextureInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) tAVTextureInfo);
        }
        return super.getOutputTextureInfo(tAVTextureInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.taveffect.effects.BaseEffect
    public void initShader(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tAVTextureInfo);
            return;
        }
        super.initShader(tAVTextureInfo);
        this.sLookupTextureHandle = GLES20.glGetUniformLocation(this.program, "sLookupTexture");
        TAVGLUtils.checkEglError("glGetUniformLocation sLookupTexture");
        this.intensityHandle = GLES20.glGetUniformLocation(this.program, "intensity");
        TAVGLUtils.checkEglError("glGetUniformLocation intensity");
        if (this.lookupTextureID == -1) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i3 = iArr[0];
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
            TAVGLUtils.checkEglError("glBindTexture mTextureID");
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
            TAVGLUtils.checkEglError("glTexParameter");
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6407, this.rendererWidth, this.rendererHeight, 0, 6407, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, this.lookupBitmap, 0);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
            this.lookupTextureID = i3;
        }
    }

    @Override // com.tencent.taveffect.effects.BaseEffect, com.tencent.taveffect.core.TAVTextureProcessor
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        int i3 = this.lookupTextureID;
        if (i3 != -1) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
            this.lookupTextureID = -1;
        }
        super.release();
    }

    public NewLookupFilter(Bitmap bitmap, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bitmap, Float.valueOf(f16));
            return;
        }
        this.lookupTextureID = -1;
        this.lookupBitmap = bitmap;
        this.intensity = f16;
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    /* renamed from: clone */
    public LookupFilter mo93clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? (LookupFilter) cloneFilter(new LookupFilter(this.lookupBitmap, this.intensity)) : (LookupFilter) iPatchRedirector.redirect((short) 9, (Object) this);
    }
}
