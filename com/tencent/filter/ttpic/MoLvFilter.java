package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MoLvFilter extends BaseFilter {
    public MoLvFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(57));
        double d16 = 0.292f;
        double d17 = 0.383f;
        baseFilter.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{(float) (d16 * (-0.1843137254901961d)), (float) (d16 * 0.07058823529411765d), 0.0f}));
        baseFilter.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{(float) ((-0.1843137254901961d) * d17), (float) (d17 * 0.07058823529411765d), 0.019607844f}));
        baseFilter.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{0.0627451f, -0.09411765f, 0.0f}));
        baseFilter.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(60));
        baseFilter2.addParam(new UniformParam.FloatParam("inputH", 1.0f));
        baseFilter2.addParam(new UniformParam.FloatParam("inputS", 1.0f));
        baseFilter2.addParam(new UniformParam.FloatParam("inputV", 1.146f));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter3.addParam(new TextureResParam("inputImageTexture2", "sh/molv_curve1.png", 33986));
        baseFilter2.setNextFilter(baseFilter3, null);
        BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(107));
        baseFilter4.addParam(new TextureResParam("inputImageTexture2", "sh/molv_curve2.png", 33986));
        baseFilter4.addParam(new TextureResParam("inputImageTexture3", "sh/molv_curve2mask.png", 33987));
        baseFilter3.setNextFilter(baseFilter4, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
