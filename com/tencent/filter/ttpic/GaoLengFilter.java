package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GaoLengFilter extends BaseFilter {
    public GaoLengFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/gaoleng_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{-0.22352941f, 0.039215688f, 0.08627451f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{-0.14901961f, 0.0f, 0.08627451f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{-0.019607844f, 0.019607844f, 0.05882353f}));
        baseFilter2.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(116));
        baseFilter3.addParam(new UniformParam.FloatsParam("color2", new float[]{0.06666667f, 0.6f, 0.8745098f, 1.0f}));
        baseFilter3.addParam(new UniformParam.FloatParam("transparency", 0.7f));
        baseFilter2.setNextFilter(baseFilter3, null);
        BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(55));
        baseFilter4.addParam(new UniformParam.FloatParam("scaleC", -0.07500002f));
        baseFilter4.addParam(new UniformParam.FloatParam("scaleT", 0.0f));
        baseFilter3.setNextFilter(baseFilter4, null);
        BaseFilter baseFilter5 = new BaseFilter(BaseFilter.getFragmentShader(13));
        baseFilter5.addParam(new UniformParam.FloatParam("contrast", 1.13f));
        baseFilter5.addParam(new UniformParam.FloatParam("saturation", 1.0f));
        baseFilter5.addParam(new UniformParam.FloatParam("brightness", 1.0f));
        baseFilter4.setNextFilter(baseFilter5, null);
        BaseFilter baseFilter6 = new BaseFilter(BaseFilter.getFragmentShader(108));
        baseFilter6.addParam(new UniformParam.FloatParam("inputH", 1.0f));
        baseFilter6.addParam(new UniformParam.FloatParam("inputS", 1.0f));
        baseFilter6.addParam(new UniformParam.FloatParam("inputV", 0.98f));
        baseFilter5.setNextFilter(baseFilter6, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
