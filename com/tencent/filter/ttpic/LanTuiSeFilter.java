package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class LanTuiSeFilter extends BaseFilter {
    public LanTuiSeFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/lantuise.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(108));
        baseFilter2.addParam(new UniformParam.FloatParam("inputH", 1.0f));
        baseFilter2.addParam(new UniformParam.FloatParam("inputS", 1.0f));
        baseFilter2.addParam(new UniformParam.FloatParam("inputV", 1.0914f));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter3.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{0.0f, 0.0f, 0.064941175f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{-0.15152942f, 0.0f, 0.08293334f}));
        baseFilter3.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        baseFilter2.setNextFilter(baseFilter3, null);
        BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(55));
        baseFilter4.addParam(new UniformParam.FloatParam("scaleC", -0.14400002f));
        baseFilter4.addParam(new UniformParam.FloatParam("scaleT", 0.0f));
        baseFilter3.setNextFilter(baseFilter4, null);
        BaseFilter baseFilter5 = new BaseFilter(BaseFilter.getFragmentShader(56));
        baseFilter5.addParam(new UniformParam.FloatsParam("color2", new float[]{0.54901963f, 0.654902f, 0.69803923f, 1.0f}));
        baseFilter5.addParam(new UniformParam.FloatParam("transparency", 0.15f));
        baseFilter4.setNextFilter(baseFilter5, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
