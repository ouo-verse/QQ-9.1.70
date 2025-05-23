package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ThursdayFilter extends BaseFilter {
    public ThursdayFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(0.0f, 27.0f, 0.0f, 316.0f, 340.0f, 0.0f, 24.0f);
        setNextFilter(hSVColorChannelFilter, null);
        HSVColorChannelFilter hSVColorChannelFilter2 = new HSVColorChannelFilter();
        hSVColorChannelFilter2.setInput(-5.0f, 20.0f, 5.0f, 358.0f, 28.0f, 46.0f, 74.0f);
        hSVColorChannelFilter.setNextFilter(hSVColorChannelFilter2, null);
        HSVColorChannelFilter hSVColorChannelFilter3 = new HSVColorChannelFilter();
        hSVColorChannelFilter3.setInput(20.0f, 0.0f, 0.0f, 68.0f, 90.0f, 124.0f, 140.0f);
        hSVColorChannelFilter2.setNextFilter(hSVColorChannelFilter3, null);
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{0.05882353f, 0.039215688f, 0.0f}));
        baseFilter.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.0f, 0.039215688f, 0.0f}));
        baseFilter.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{-0.019607844f, 0.039215688f, 0.019607844f}));
        baseFilter.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        hSVColorChannelFilter3.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/thursday_curve.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
