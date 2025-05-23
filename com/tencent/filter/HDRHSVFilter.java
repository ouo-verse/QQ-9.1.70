package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.view.RendererUtils;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HDRHSVFilter extends BaseFilter {
    static IPatchRedirector $redirector_;
    private BaseFilter copyFilter;
    private HistogramsStrectchFilter hisStretchFilter;
    private BaseFilter hsv2rgbFilter;
    float maxRatio;
    float minRatio;
    private BaseFilter rgb2hsvFilter;
    private BaseFilter saturationFilter;
    float saturationMag;
    private BaseFilter scaleUpFilter;
    private BaseFilter sharpen;
    float sharpnessMag;
    private ChannelStretchFilter stretech;
    float stretechMag;
    private int[] tex;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class ChannelStretchFilter extends BaseFilter {
        static IPatchRedirector $redirector_;
        float stretechMag;

        public ChannelStretchFilter() {
            super(BaseFilter.getFragmentShader(30));
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.stretechMag = 25.0f;
            }
        }

        @Override // com.tencent.filter.BaseFilter
        public void applyFilterChain(boolean z16, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            } else {
                addParam(new UniformParam.FloatParam("strength", this.stretechMag));
                super.applyFilterChain(z16, f16, f17);
            }
        }

        @Override // com.tencent.filter.BaseFilter
        public void clearGLSL() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                super.clearGLSL();
            }
        }

        public void updateparam(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
            } else {
                this.stretechMag = f16;
                addParam(new UniformParam.FloatParam("strength", f16));
            }
        }
    }

    public HDRHSVFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.stretechMag = 25.0f;
        this.sharpnessMag = 0.3f;
        this.saturationMag = 1.3f;
        this.minRatio = 0.001f;
        this.maxRatio = 0.999f;
        this.sharpen = null;
        this.stretech = null;
        this.tex = new int[1];
    }

    @Override // com.tencent.filter.BaseFilter
    public Frame RenderProcess(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Frame) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        BaseFilter baseFilter = getmNextFilter();
        setNextFilter(null, null);
        Frame RenderProcess = super.RenderProcess(i3, i16, i17);
        this.hisStretchFilter.setTextureParam(i3, 0);
        Frame RenderProcess2 = this.hisStretchFilter.RenderProcess(RenderProcess.getTextureId(), RenderProcess.width, RenderProcess.height, i16, i17);
        RenderProcess.unlock();
        Frame RenderProcess3 = this.rgb2hsvFilter.RenderProcess(RenderProcess2.getTextureId(), i16, i17);
        RenderProcess2.unlock();
        this.stretech.setTextureParam(RenderProcess3.getTextureId(), 0);
        int ceil = (int) Math.ceil(Math.max(i16, i17) / 200.0d);
        QImage saveTexture2QImage = RendererUtils.saveTexture2QImage(RenderProcess3.getTextureId(), RenderProcess3.width, RenderProcess3.height);
        QImage InplaceBlur8bitQImage = saveTexture2QImage.InplaceBlur8bitQImage(ceil, 10);
        saveTexture2QImage.Dispose();
        GLSLRender.nativeTextImage(InplaceBlur8bitQImage, this.tex[0]);
        InplaceBlur8bitQImage.Dispose();
        this.stretech.setTextureParam(this.tex[0], 1);
        Frame RenderProcess4 = this.stretech.RenderProcess(RenderProcess3.getTextureId(), i16, i17);
        RenderProcess3.unlock();
        Frame RenderProcess5 = this.sharpen.RenderProcess(RenderProcess4.getTextureId(), i16, i17);
        RenderProcess4.unlock();
        Frame RenderProcess6 = this.hsv2rgbFilter.RenderProcess(RenderProcess5.getTextureId(), i16, i17);
        RenderProcess5.unlock();
        Frame RenderProcess7 = this.saturationFilter.RenderProcess(RenderProcess6.getTextureId(), i16, i17);
        RenderProcess6.unlock();
        if (baseFilter != null) {
            Frame RenderProcess8 = baseFilter.RenderProcess(RenderProcess7.getTextureId(), RenderProcess7.width, RenderProcess7.height);
            RenderProcess7.unlock();
            RenderProcess7 = RenderProcess8;
        }
        setNextFilter(baseFilter, null);
        return RenderProcess7;
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        super.applyFilterChain(z16, f16, f17);
        this.scaleFact = Math.min(100.0f / Math.min(f17, f16), 1.0f);
        HistogramsStrectchFilter histogramsStrectchFilter = new HistogramsStrectchFilter(this.minRatio, this.maxRatio);
        this.hisStretchFilter = histogramsStrectchFilter;
        histogramsStrectchFilter.applyFilterChain(z16, f16, f17);
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(28));
        this.rgb2hsvFilter = baseFilter;
        baseFilter.applyFilterChain(z16, f16, f17);
        ChannelStretchFilter channelStretchFilter = new ChannelStretchFilter();
        this.stretech = channelStretchFilter;
        channelStretchFilter.updateparam(this.stretechMag);
        this.stretech.applyFilterChain(z16, f16, f17);
        BaseFilter baseFilter2 = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        this.scaleUpFilter = baseFilter2;
        baseFilter2.apply();
        BaseFilter baseFilter3 = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        this.copyFilter = baseFilter3;
        baseFilter3.apply();
        BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getVertexShader(2), BaseFilter.getFragmentShader(33));
        this.sharpen = baseFilter4;
        baseFilter4.addParam(new UniformParam.FloatParam("sharpness", this.sharpnessMag));
        this.sharpen.applyFilterChain(z16, f16, f17);
        BaseFilter baseFilter5 = new BaseFilter(BaseFilter.getFragmentShader(29));
        this.hsv2rgbFilter = baseFilter5;
        baseFilter5.applyFilterChain(z16, f16, f17);
        BaseFilter baseFilter6 = new BaseFilter(BaseFilter.getFragmentShader(31));
        this.saturationFilter = baseFilter6;
        baseFilter6.addParam(new UniformParam.FloatParam("saturation", this.saturationMag));
        this.saturationFilter.applyFilterChain(z16, f16, f17);
        int[] iArr = this.tex;
        GLES20.glGenTextures(iArr.length, iArr, 0);
    }

    @Override // com.tencent.filter.BaseFilter
    public void clearGLSLSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.clearGLSLSelf();
        this.copyFilter.clearGLSLSelf();
        this.stretech.clearGLSLSelf();
        this.scaleUpFilter.clearGLSLSelf();
        this.hisStretchFilter.clearGLSLSelf();
        this.rgb2hsvFilter.clearGLSLSelf();
        this.saturationFilter.clearGLSLSelf();
        this.hsv2rgbFilter.clearGLSLSelf();
        int[] iArr = this.tex;
        GlUtil.glDeleteTextures(iArr.length, iArr, 0);
    }

    @Override // com.tencent.filter.BaseFilter
    public boolean isAdjustFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.filter.BaseFilter
    public void setAdjustParam(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            return;
        }
        float max = (float) Math.max((float) Math.min(f16, 1.0d), 0.0d);
        float f17 = 50.0f * max;
        this.stretechMag = f17;
        this.sharpnessMag = max * 0.6f;
        ChannelStretchFilter channelStretchFilter = this.stretech;
        if (channelStretchFilter != null) {
            channelStretchFilter.updateparam(f17);
        }
        BaseFilter baseFilter = this.sharpen;
        if (baseFilter != null) {
            baseFilter.addParam(new UniformParam.FloatParam("sharpness", this.sharpnessMag));
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void setParameterDic(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) map);
            return;
        }
        if (map.containsKey("stretechMag")) {
            this.stretechMag = ((Float) map.get("stretechMag")).floatValue();
        }
        if (map.containsKey("sharpnessMag")) {
            this.sharpnessMag = ((Float) map.get("sharpnessMag")).floatValue();
        }
        if (map.containsKey("saturationMag")) {
            this.saturationMag = ((Float) map.get("saturationMag")).floatValue();
        }
        if (map.containsKey("percent")) {
            float floatValue = ((Float) map.get("percent")).floatValue();
            this.minRatio = floatValue;
            this.maxRatio = 1.0f - floatValue;
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void RenderProcess(int i3, int i16, int i17, int i18, double d16, Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Double.valueOf(d16), frame);
            return;
        }
        Frame RenderProcess = RenderProcess(i3, i16, i17);
        this.copyFilter.RenderProcess(RenderProcess.getTextureId(), RenderProcess.width, RenderProcess.height, i18, d16, frame);
        RenderProcess.clear();
    }
}
