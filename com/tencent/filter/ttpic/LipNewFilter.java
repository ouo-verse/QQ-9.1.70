package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class LipNewFilter extends BaseFilter {
    public LipNewFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/lipnew_curve.png", 33986));
        setNextFilter(baseFilter, null);
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(0.0f, 27.0f, 0.0f, 320.0f, 340.0f, 10.0f, 36.0f);
        baseFilter.setNextFilter(hSVColorChannelFilter, null);
        HSVColorChannelFilter hSVColorChannelFilter2 = new HSVColorChannelFilter();
        hSVColorChannelFilter2.setInput(-5.0f, -5.0f, 0.0f, 3.0f, 15.0f, 54.0f, 67.0f);
        hSVColorChannelFilter.setNextFilter(hSVColorChannelFilter2, null);
        HSVColorChannelFilter hSVColorChannelFilter3 = new HSVColorChannelFilter();
        hSVColorChannelFilter3.setInput(0.0f, -50.0f, 10.0f, 118.0f, 151.0f, 221.0f, 250.0f);
        hSVColorChannelFilter2.setNextFilter(hSVColorChannelFilter3, null);
        HSVColorChannelFilter hSVColorChannelFilter4 = new HSVColorChannelFilter();
        hSVColorChannelFilter4.setInput(0.0f, -30.0f, 50.0f, 46.0f, 62.0f, 127.0f, 140.0f);
        hSVColorChannelFilter3.setNextFilter(hSVColorChannelFilter4, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{0.019607844f, -0.039215688f, -0.019607844f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{-0.039215688f, -0.019607844f, 0.0f}));
        hSVColorChannelFilter4.setNextFilter(baseFilter2, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
