package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class LanFilter extends BaseFilter {
    public LanFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(55));
        baseFilter.addParam(new UniformParam.FloatParam("scaleC", -0.549f));
        baseFilter.addParam(new UniformParam.FloatParam("scaleT", 0.0f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(63));
        baseFilter2.addParam(new UniformParam.FloatsParam("color2", new float[]{0.5921569f, 0.7647059f, 0.8392157f, 1.0f}));
        baseFilter2.addParam(new UniformParam.FloatParam("transparency", 0.58f));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(107));
        baseFilter3.addParam(new TextureResParam("inputImageTexture2", "sh/lan_curve1.png", 33986));
        baseFilter3.addParam(new TextureResParam("inputImageTexture3", "sh/lan_curve1mask.png", 33987));
        baseFilter2.setNextFilter(baseFilter3, null);
        BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter4.addParam(new TextureResParam("inputImageTexture2", "sh/lan_curve2.png", 33986));
        baseFilter3.setNextFilter(baseFilter4, null);
        BaseFilter baseFilter5 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter5.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{-0.019607844f, 0.0f, 0.019607844f}));
        baseFilter5.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter5.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter5.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        baseFilter4.setNextFilter(baseFilter5, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
