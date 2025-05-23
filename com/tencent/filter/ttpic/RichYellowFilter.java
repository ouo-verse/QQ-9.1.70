package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class RichYellowFilter extends BaseFilter {
    public RichYellowFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(7.0f, 16.0f, 9.0f, 332.0f, 347.0f, 11.0f, 29.0f);
        setNextFilter(hSVColorChannelFilter, null);
        HSVColorChannelFilter hSVColorChannelFilter2 = new HSVColorChannelFilter();
        hSVColorChannelFilter2.setInput(0.0f, -6.0f, 5.0f, 359.0f, 17.0f, 49.0f, 72.0f);
        hSVColorChannelFilter.setNextFilter(hSVColorChannelFilter2, null);
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/richyellow_curve.png", 33986));
        hSVColorChannelFilter2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{0.011764706f, 0.0f, -0.011764706f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{-0.02745098f, 0.0f, 0.02745098f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{0.023529412f, 0.011764706f, -0.02745098f}));
        baseFilter.setNextFilter(baseFilter2, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
