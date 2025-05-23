package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MilkCoffeeFilter extends BaseFilter {
    public MilkCoffeeFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(3.0f, 40.0f, 3.0f, 329.0f, 352.0f, 10.0f, 35.0f);
        setNextFilter(hSVColorChannelFilter, null);
        HSVColorChannelFilter hSVColorChannelFilter2 = new HSVColorChannelFilter();
        hSVColorChannelFilter2.setInput(-5.0f, 5.0f, 10.0f, 6.0f, 32.0f, 52.0f, 82.0f);
        hSVColorChannelFilter.setNextFilter(hSVColorChannelFilter2, null);
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/milkcoffee_curve.png", 33986));
        hSVColorChannelFilter2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(134));
        baseFilter2.addParam(new UniformParam.FloatsParam("color2", new float[]{0.7294118f, 0.5372549f, 0.5058824f, 1.0f}));
        baseFilter2.addParam(new UniformParam.FloatParam("transparency", 0.1f));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter3.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{0.0f, 0.0f, -0.023529412f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.0f, 0.0f, -0.023529412f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{-0.007843138f, 0.0f, 0.0f}));
        baseFilter2.setNextFilter(baseFilter3, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
