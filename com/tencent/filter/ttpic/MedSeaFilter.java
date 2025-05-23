package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MedSeaFilter extends BaseFilter {
    public MedSeaFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/medsea_curve.png", 33986));
        setNextFilter(baseFilter, null);
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(-3.0f, 21.0f, 6.0f, 299.0f, 329.0f, 359.0f, 29.0f);
        baseFilter.setNextFilter(hSVColorChannelFilter, null);
        HSVColorChannelFilter hSVColorChannelFilter2 = new HSVColorChannelFilter();
        hSVColorChannelFilter2.setInput(-6.0f, 1.0f, 8.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        hSVColorChannelFilter.setNextFilter(hSVColorChannelFilter2, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{0.09803922f, 0.09019608f, 0.06666667f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.07058824f, 0.0f, 0.0f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{0.0f, 0.0f, 0.0f}));
        hSVColorChannelFilter2.setNextFilter(baseFilter2, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
