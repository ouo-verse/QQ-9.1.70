package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class NaichaFilter extends BaseFilter {
    public NaichaFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(13));
        baseFilter.addParam(new UniformParam.FloatParam("contrast", 1.0f));
        baseFilter.addParam(new UniformParam.FloatParam("saturation", 0.5f));
        baseFilter.addParam(new UniformParam.FloatParam("brightness", 1.0f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/heibai4_Curve.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(59));
        baseFilter3.addParam(new UniformParam.FloatsParam("color2", new float[]{0.84705883f, 0.8f, 0.74509805f, 1.0f}));
        baseFilter3.addParam(new UniformParam.FloatParam("transparency", 1.0f));
        baseFilter2.setNextFilter(baseFilter3, null);
        BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(56));
        baseFilter4.addParam(new UniformParam.FloatsParam("color2", new float[]{0.09019608f, 0.06666667f, 0.06666667f, 1.0f}));
        baseFilter4.addParam(new UniformParam.FloatParam("transparency", 1.0f));
        baseFilter3.setNextFilter(baseFilter4, null);
        BaseFilter baseFilter5 = new BaseFilter(BaseFilter.getFragmentShader(117));
        baseFilter5.addParam(new TextureResParam("inputImageTexture2", "sh/heibai4_blend.png", 33986));
        baseFilter5.addParam(new UniformParam.FloatParam("transparency", 0.8f));
        baseFilter4.setNextFilter(baseFilter5, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
