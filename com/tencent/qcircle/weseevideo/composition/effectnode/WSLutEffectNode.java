package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qcircle.weseevideo.model.effect.LutModel;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.taveffect.effects.LookupFilter;
import com.tencent.taveffect.utils.TAVGLUtils;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.report.IReportable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WSLutEffectNode implements TAVVideoEffect {
    private Bitmap mLutBitmap;
    private LutModel mLutModel;
    private final String sEffectId = "WSLutEffectNode" + Integer.toHexString(hashCode());
    protected String reportKey = "WSLutEffectNode";

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private class WSLutEffectFilter implements TAVVideoEffect.Filter, IReportable {
        private TextureInfo cacheTextureInfo;
        private LUTFilter mEffect;

        public WSLutEffectFilter() {
            this.mEffect = new LUTFilter();
        }

        @NonNull
        private TextureInfo getOutputTextureInfo(TAVTextureInfo tAVTextureInfo) {
            return new TextureInfo(tAVTextureInfo.textureID, tAVTextureInfo.textureType, tAVTextureInfo.width, tAVTextureInfo.height, null, 0);
        }

        @NonNull
        private TAVTextureInfo getTavTextureInfo(TextureInfo textureInfo) {
            return new TAVTextureInfo(textureInfo.textureID, textureInfo.textureType, textureInfo.width, textureInfo.height, null, 0);
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
        public CIImage apply(TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo) {
            if (this.mEffect == null) {
                return cIImage;
            }
            CIContext ciContext = renderInfo.getCiContext();
            if (ciContext != null && ciContext.getRenderContext() != null) {
                long timeUs = renderInfo.getTime().getTimeUs() / 1000;
                if (WSLutEffectNode.this.mLutModel != null && (timeUs < WSLutEffectNode.this.mLutModel.getLutStartTime() || timeUs > WSLutEffectNode.this.mLutModel.getLutStartTime() + WSLutEffectNode.this.mLutModel.getLutDuration())) {
                    return cIImage;
                }
                if (!BitmapUtil.isValidBitmap(WSLutEffectNode.this.mLutBitmap)) {
                    return cIImage;
                }
                this.mEffect.setLUTBitmap(WSLutEffectNode.this.mLutBitmap);
                if (WSLutEffectNode.this.mLutModel != null) {
                    this.mEffect.setIntensity(WSLutEffectNode.this.mLutModel.getLutAlpha());
                }
                int i3 = (int) cIImage.getSize().width;
                int i16 = (int) cIImage.getSize().height;
                this.mEffect.setRendererWidth(i3);
                this.mEffect.setRendererHeight(i16);
                if (this.cacheTextureInfo == null) {
                    ciContext.getRenderContext().makeCurrent();
                    this.cacheTextureInfo = CIContext.newTextureInfo(i3, i16);
                }
                TextureInfo textureInfo = this.cacheTextureInfo;
                if (textureInfo.width != i3 || textureInfo.height != i16) {
                    ciContext.getRenderContext().makeCurrent();
                    this.cacheTextureInfo.release();
                    this.cacheTextureInfo = CIContext.newTextureInfo(i3, i16);
                }
                ciContext.convertImageToTexture(cIImage, this.cacheTextureInfo);
                TextureInfo outputTextureInfo = getOutputTextureInfo(this.mEffect.applyFilter(getTavTextureInfo(this.cacheTextureInfo)));
                outputTextureInfo.setTextureMatrix(this.cacheTextureInfo.getTextureMatrix());
                return new CIImage(outputTextureInfo);
            }
            return cIImage;
        }

        @Override // com.tencent.tavkit.report.IReportable
        public String getReportKey() {
            return WSLutEffectNode.this.reportKey;
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            LUTFilter lUTFilter = this.mEffect;
            if (lUTFilter != null) {
                lUTFilter.release();
                this.mEffect = null;
            }
            TextureInfo textureInfo = this.cacheTextureInfo;
            if (textureInfo != null && !textureInfo.isReleased()) {
                this.cacheTextureInfo.release();
            }
        }
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    public TAVVideoEffect.Filter createFilter() {
        return new WSLutEffectFilter();
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    @Nullable
    /* renamed from: effectId */
    public String getMEffectId() {
        if (this.mLutModel == null) {
            return "";
        }
        return this.sEffectId;
    }

    public void setLutMode(LutModel lutModel) {
        if (!TextUtils.isEmpty(lutModel.getLutBitmap()) && (this.mLutModel == null || !lutModel.getLutBitmap().equals(this.mLutModel.getLutBitmap()))) {
            this.mLutBitmap = BitmapFactory.decodeFile(lutModel.getLutBitmap());
        }
        this.mLutModel = lutModel;
    }

    public void setReportKey(String str) {
        this.reportKey = str;
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class LUTFilter extends BaseEffect {
        private static final String FRAGMENT_SHADER = "sTexture;\nprecision mediump float;\nuniform sampler2D sLookupTexture; // lookup texture\nvarying highp vec2 vTextureCoord;\n\nuniform lowp float intensity;\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    textureColor = clamp(textureColor, 0.0, 1.0);\n    highp float blueColor = textureColor.b * 63.0;\n    \n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    \n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    \n    highp float redPos = 0.125 * textureColor.r;\n    highp float greenPos = 0.125 * textureColor.g;\n    redPos = clamp(redPos, 2.0/512.0, 0.125- 2.0/512.0);\n    greenPos = clamp(greenPos, 2.0/512.0, 0.125- 2.0/512.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + redPos;\n    texPos1.y = (quad1.y * 0.125)  + greenPos;\n    \n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125)  + redPos;\n    texPos2.y = (quad2.y * 0.125) + greenPos;\n    \n    lowp vec4 newColor1 = texture2D(sLookupTexture, texPos1);\n    lowp vec4 newColor2 = texture2D(sLookupTexture, texPos2);\n    \n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n    gl_FragColor = newColor;\n}";
        private static final String FRAGMENT_SHADER_PREFIX = "uniform sampler2D  ";
        private static final String FRAGMENT_SHADER_PREFIX_OES = " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES ";
        private int intensityHandle;
        private Bitmap lutBitmap;
        private int lutTextureHandle;
        private float intensity = 1.0f;
        private int lutTextureID = -1;

        public LUTFilter() {
        }

        @Override // com.tencent.taveffect.effects.BaseEffect
        protected void afterDraw(TAVTextureInfo tAVTextureInfo) {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        }

        @Override // com.tencent.taveffect.effects.BaseEffect
        protected void beforeDraw(TAVTextureInfo tAVTextureInfo) {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.lutTextureID);
            GLES20.glUniform1i(this.lutTextureHandle, 1);
            GLES20.glUniform1f(this.intensityHandle, this.intensity);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj.getClass() != getClass()) {
                return false;
            }
            LUTFilter lUTFilter = (LUTFilter) obj;
            if (this.intensity != lUTFilter.intensity || this.lutBitmap != lUTFilter.lutBitmap) {
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.tencent.taveffect.effects.BaseEffect
        protected String getFragmentShaderCode(TAVTextureInfo tAVTextureInfo) {
            if (tAVTextureInfo.textureType == 36197) {
                return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nuniform sampler2D sLookupTexture; // lookup texture\nvarying highp vec2 vTextureCoord;\n\nuniform lowp float intensity;\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    textureColor = clamp(textureColor, 0.0, 1.0);\n    highp float blueColor = textureColor.b * 63.0;\n    \n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    \n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    \n    highp float redPos = 0.125 * textureColor.r;\n    highp float greenPos = 0.125 * textureColor.g;\n    redPos = clamp(redPos, 2.0/512.0, 0.125- 2.0/512.0);\n    greenPos = clamp(greenPos, 2.0/512.0, 0.125- 2.0/512.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + redPos;\n    texPos1.y = (quad1.y * 0.125)  + greenPos;\n    \n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125)  + redPos;\n    texPos2.y = (quad2.y * 0.125) + greenPos;\n    \n    lowp vec4 newColor1 = texture2D(sLookupTexture, texPos1);\n    lowp vec4 newColor2 = texture2D(sLookupTexture, texPos2);\n    \n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n    gl_FragColor = newColor;\n}";
            }
            return "uniform sampler2D  sTexture;\nprecision mediump float;\nuniform sampler2D sLookupTexture; // lookup texture\nvarying highp vec2 vTextureCoord;\n\nuniform lowp float intensity;\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    textureColor = clamp(textureColor, 0.0, 1.0);\n    highp float blueColor = textureColor.b * 63.0;\n    \n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    \n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    \n    highp float redPos = 0.125 * textureColor.r;\n    highp float greenPos = 0.125 * textureColor.g;\n    redPos = clamp(redPos, 2.0/512.0, 0.125- 2.0/512.0);\n    greenPos = clamp(greenPos, 2.0/512.0, 0.125- 2.0/512.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + redPos;\n    texPos1.y = (quad1.y * 0.125)  + greenPos;\n    \n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125)  + redPos;\n    texPos2.y = (quad2.y * 0.125) + greenPos;\n    \n    lowp vec4 newColor1 = texture2D(sLookupTexture, texPos1);\n    lowp vec4 newColor2 = texture2D(sLookupTexture, texPos2);\n    \n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n    gl_FragColor = newColor;\n}";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.taveffect.effects.BaseEffect
        public void initShader(TAVTextureInfo tAVTextureInfo) {
            super.initShader(tAVTextureInfo);
            this.lutTextureHandle = GLES20.glGetUniformLocation(this.program, "sLookupTexture");
            TAVGLUtils.checkEglError("glGetUniformLocation sLookupTexture");
            this.intensityHandle = GLES20.glGetUniformLocation(this.program, "intensity");
            TAVGLUtils.checkEglError("glGetUniformLocation intensity");
            if (this.lutTextureID == -1) {
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
                GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, this.lutBitmap, 0);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
                this.lutTextureID = i3;
            }
        }

        @Override // com.tencent.taveffect.effects.BaseEffect, com.tencent.taveffect.core.TAVTextureProcessor
        public void release() {
            int i3 = this.lutTextureID;
            if (i3 != -1) {
                GLES20.glDeleteTextures(1, new int[]{i3}, 0);
                this.lutTextureID = -1;
            }
            super.release();
        }

        public void setIntensity(float f16) {
            this.intensity = f16;
        }

        public void setLUTBitmap(Bitmap bitmap) {
            this.lutBitmap = bitmap;
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.lutTextureID);
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        }

        @Override // com.tencent.taveffect.core.TAVBaseFilter
        /* renamed from: clone */
        public LookupFilter mo93clone() {
            return (LookupFilter) cloneFilter(new LookupFilter(this.lutBitmap, this.intensity));
        }
    }
}
