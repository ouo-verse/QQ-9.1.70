package com.tencent.filter.art;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.view.RendererUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class NightRGBStretchFilter extends BaseFilter {
    static IPatchRedirector $redirector_;
    private BaseFilter adjustFilter;
    private float strenth;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class NightRGBStretchImpFilter extends BaseFilter {
        static IPatchRedirector $redirector_;
        private int paramTEXTRUEID;

        public NightRGBStretchImpFilter() {
            super(BaseFilter.getFragmentShader(88));
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.paramTEXTRUEID = 0;
            }
        }

        @Override // com.tencent.filter.BaseFilter
        public void applyFilterChain(boolean z16, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            } else {
                this.paramTEXTRUEID = RendererUtils.createTexture();
                super.applyFilterChain(z16, f16, f17);
            }
        }

        @Override // com.tencent.filter.BaseFilter
        public void beforeRender(int i3, int i16, int i17) {
            int i18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            QImage saveTexture2QImage = RendererUtils.saveTexture2QImage(i3, i16, i17);
            int[] nativeGetArrayHistogram = saveTexture2QImage.nativeGetArrayHistogram();
            saveTexture2QImage.Dispose();
            int i19 = 0;
            int i26 = 0;
            for (int i27 = 0; i27 < 256; i27++) {
                int i28 = nativeGetArrayHistogram[i27];
                i26 += i28;
                i19 += i28 * i27;
            }
            int i29 = i19 / i26;
            float f16 = i26;
            int i36 = (int) (0.001f * f16);
            int i37 = (int) (f16 * 0.99f);
            int i38 = 0;
            int i39 = 0;
            while (true) {
                if (i38 < 256) {
                    i39 += nativeGetArrayHistogram[i38];
                    if (i39 > i36) {
                        i18 = i38;
                        break;
                    }
                    i38++;
                } else {
                    i18 = 0;
                    break;
                }
            }
            int i46 = i38 + 1;
            while (true) {
                if (i46 < 256) {
                    i39 += nativeGetArrayHistogram[i46];
                    if (i39 > i37) {
                        break;
                    } else {
                        i46++;
                    }
                } else {
                    i46 = 255;
                    break;
                }
            }
            float f17 = i46 - i18;
            float log = (float) (Math.log(0.5d) / Math.log((i29 - i18) / f17));
            double d16 = log;
            if (d16 < 0.1d) {
                log = 0.1f;
            }
            if (d16 > 10.0d) {
                log = 10.0f;
            }
            float[] fArr = new float[256];
            for (int i47 = 0; i47 < i18; i47++) {
                fArr[i47] = 0.0f;
            }
            for (int i48 = i18; i48 < i46; i48++) {
                fArr[i48] = (float) Math.pow((i48 - i18) / f17, log);
            }
            while (i46 < 256) {
                fArr[i46] = 1.0f;
                i46++;
            }
            int[] iArr = new int[256];
            for (int i49 = 0; i49 < 256; i49++) {
                iArr[i49] = (int) (fArr[i49] * 255.0f);
            }
            GLES20.glActiveTexture(33984);
            GLSLRender.nativeTextCure(iArr, this.paramTEXTRUEID);
        }

        @Override // com.tencent.filter.BaseFilter
        public void clearGLSL() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                RendererUtils.clearTexture(this.paramTEXTRUEID);
                super.clearGLSL();
            }
        }

        @Override // com.tencent.filter.BaseFilter
        public boolean renderTexture(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
            }
            setTextureParam(this.paramTEXTRUEID, 1);
            return super.renderTexture(i3, i16, i17);
        }
    }

    public NightRGBStretchFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.strenth = 0.5f;
            this.adjustFilter = null;
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
        BaseFilter baseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        baseFilter.scaleFact = Math.min(100.0f / Math.min(f17, f16), 1.0f);
        setNextFilter(baseFilter, null);
        NightRGBStretchImpFilter nightRGBStretchImpFilter = new NightRGBStretchImpFilter();
        this.adjustFilter = nightRGBStretchImpFilter;
        nightRGBStretchImpFilter.addParam(new UniformParam.FloatParam("param", this.strenth));
        if (this.strenth >= 0.5f) {
            this.adjustFilter.addParam(new UniformParam.FloatParam("scale", 2.0f));
        } else {
            this.adjustFilter.addParam(new UniformParam.FloatParam("scale", 1.0f));
        }
        baseFilter.setNextFilter(this.adjustFilter, new int[]{this.srcTextureIndex + 1});
        super.applyFilterChain(z16, f16, f17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void clearGLSL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.adjustFilter = null;
            super.clearGLSL();
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public boolean isAdjustFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.filter.BaseFilter
    public void setAdjustParam(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
            return;
        }
        this.strenth = f16;
        BaseFilter baseFilter = this.adjustFilter;
        if (baseFilter != null) {
            baseFilter.addParam(new UniformParam.FloatParam("param", f16));
        }
    }
}
