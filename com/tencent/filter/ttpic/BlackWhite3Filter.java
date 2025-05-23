package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;

/* compiled from: P */
/* loaded from: classes6.dex */
public class BlackWhite3Filter extends BaseFilter {
    public BlackWhite3Filter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(13));
        baseFilter.addParam(new UniformParam.FloatParam("contrast", 1.0f));
        baseFilter.addParam(new UniformParam.FloatParam("saturation", 0.0f));
        baseFilter.addParam(new UniformParam.FloatParam("brightness", 1.0f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(56));
        baseFilter2.addParam(new UniformParam.FloatsParam("color2", new float[]{0.0627451f, 0.07058824f, 0.09019608f, 1.0f}));
        baseFilter2.addParam(new UniformParam.FloatParam("transparency", 1.0f));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(59));
        baseFilter3.addParam(new UniformParam.FloatsParam("color2", new float[]{0.9098039f, 0.87058824f, 0.85882354f, 1.0f}));
        baseFilter3.addParam(new UniformParam.FloatParam("transparency", 0.55f));
        baseFilter2.setNextFilter(baseFilter3, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
