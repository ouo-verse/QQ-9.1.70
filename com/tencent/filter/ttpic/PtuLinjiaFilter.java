package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* loaded from: classes6.dex */
public class PtuLinjiaFilter extends BaseFilter {
    public PtuLinjiaFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/linjia_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{0.0f, -0.02745098f, 0.050980393f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.0f, -0.043137256f, 0.0f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter2.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(59));
        baseFilter3.addParam(new UniformParam.FloatsParam("color2", new float[]{0.99215686f, 0.84705883f, 0.6392157f, 1.0f}));
        baseFilter3.addParam(new UniformParam.FloatParam("transparency", 0.4f));
        baseFilter2.setNextFilter(baseFilter3, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
