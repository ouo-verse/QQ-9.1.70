package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class TeaMilkFilter extends BaseFilter {
    public TeaMilkFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(0.0f, -20.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        setNextFilter(hSVColorChannelFilter, null);
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(56));
        baseFilter.addParam(new UniformParam.FloatsParam("color2", new float[]{0.09019608f, 0.06666667f, 0.06666667f, 1.0f}));
        baseFilter.addParam(new UniformParam.FloatParam("transparency", 0.5f));
        hSVColorChannelFilter.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/teamilk_curve2.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(59));
        baseFilter3.addParam(new UniformParam.FloatsParam("color2", new float[]{0.9411765f, 0.91764706f, 0.85490197f, 1.0f}));
        baseFilter3.addParam(new UniformParam.FloatParam("transparency", 1.0f));
        baseFilter2.setNextFilter(baseFilter3, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
