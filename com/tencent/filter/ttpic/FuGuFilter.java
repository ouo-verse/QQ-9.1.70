package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FuGuFilter extends BaseFilter {
    public FuGuFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(56));
        baseFilter.addParam(new UniformParam.FloatsParam("color2", new float[]{0.18039216f, 0.14901961f, 0.07450981f, 1.0f}));
        baseFilter.addParam(new UniformParam.FloatParam("transparency", 1.0f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{-0.023529412f, 0.105882354f, 0.0f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter2.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(115));
        baseFilter3.addParam(new UniformParam.FloatsParam("color2", new float[]{0.39607844f, 0.25490198f, 0.18431373f, 1.0f}));
        baseFilter3.addParam(new UniformParam.FloatParam("transparency", 0.87f));
        baseFilter2.setNextFilter(baseFilter3, null);
        BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter4.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{0.0f, 0.05490196f, 0.0f}));
        baseFilter4.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.0f, 0.05490196f, 0.0f}));
        baseFilter4.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{0.03137255f, 0.05490196f, -0.24313726f}));
        baseFilter4.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        baseFilter3.setNextFilter(baseFilter4, null);
        BaseFilter baseFilter5 = new BaseFilter(BaseFilter.getFragmentShader(13));
        baseFilter5.addParam(new UniformParam.FloatParam("contrast", 1.0f));
        baseFilter5.addParam(new UniformParam.FloatParam("saturation", 0.6f));
        baseFilter5.addParam(new UniformParam.FloatParam("brightness", 1.0f));
        baseFilter4.setNextFilter(baseFilter5, null);
        BaseFilter baseFilter6 = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter6.addParam(new TextureResParam("inputImageTexture2", "sh/fugu_curve.png", 33986));
        baseFilter5.setNextFilter(baseFilter6, null);
        BaseFilter baseFilter7 = new BaseFilter(BaseFilter.getFragmentShader(60));
        baseFilter7.addParam(new UniformParam.FloatParam("inputH", 1.0f));
        baseFilter7.addParam(new UniformParam.FloatParam("inputS", 1.0f));
        baseFilter7.addParam(new UniformParam.FloatParam("inputV", 0.974f));
        baseFilter6.setNextFilter(baseFilter7, null);
        BaseFilter baseFilter8 = new BaseFilter(BaseFilter.getFragmentShader(63));
        baseFilter8.addParam(new UniformParam.FloatsParam("color2", new float[]{0.9490196f, 0.9098039f, 0.8039216f, 1.0f}));
        baseFilter8.addParam(new UniformParam.FloatParam("transparency", 0.5f));
        baseFilter7.setNextFilter(baseFilter8, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
