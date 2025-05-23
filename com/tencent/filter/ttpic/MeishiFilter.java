package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MeishiFilter extends BaseFilter {
    public MeishiFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(13));
        baseFilter.addParam(new UniformParam.FloatParam("contrast", 1.0f));
        baseFilter.addParam(new UniformParam.FloatParam("saturation", 1.4f));
        baseFilter.addParam(new UniformParam.FloatParam("brightness", 1.0f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{0.011764706f, 0.0f, 0.0f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.039215688f, 0.0f, -0.039215688f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter2.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(108));
        baseFilter3.addParam(new UniformParam.FloatParam("inputH", 1.0f));
        baseFilter3.addParam(new UniformParam.FloatParam("inputS", 1.0f));
        baseFilter3.addParam(new UniformParam.FloatParam("inputV", 1.02f));
        baseFilter2.setNextFilter(baseFilter3, null);
        BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter4.addParam(new TextureResParam("inputImageTexture2", "sh/meishi_curve.png", 33986));
        baseFilter3.setNextFilter(baseFilter4, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
