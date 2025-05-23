package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FenFilter extends BaseFilter {
    public FenFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{0.0f, -0.06411765f, 0.03137255f}));
        baseFilter.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{0.03137255f, -0.015882352f, 0.0f}));
        baseFilter.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(56));
        baseFilter2.addParam(new UniformParam.FloatsParam("color2", new float[]{0.38039216f, 0.30588236f, 0.4117647f, 1.0f}));
        baseFilter2.addParam(new UniformParam.FloatParam("transparency", 0.3f));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter3.addParam(new TextureResParam("inputImageTexture2", "sh/fen.png", 33986));
        baseFilter2.setNextFilter(baseFilter3, null);
        BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter4.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter4.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter4.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{0.018431371f, 0.0f, -0.037254903f}));
        baseFilter4.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        baseFilter3.setNextFilter(baseFilter4, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
