package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class YoungFilter extends BaseFilter {
    public YoungFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/young_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{0.07058824f, 0.0f, 0.0f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.11764706f, -0.023529412f, 0.050980393f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{-0.003921569f, 0.0f, 0.019607844f}));
        baseFilter.setNextFilter(baseFilter2, null);
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(0.0f, 10.0f, 22.0f, 335.0f, 5.0f, 35.0f, 65.0f);
        baseFilter2.setNextFilter(hSVColorChannelFilter, null);
        HSVColorChannelFilter hSVColorChannelFilter2 = new HSVColorChannelFilter();
        hSVColorChannelFilter2.setInput(-6.0f, 2.0f, 10.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        hSVColorChannelFilter.setNextFilter(hSVColorChannelFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(13));
        baseFilter3.addParam(new UniformParam.FloatParam("contrast", 1.05f));
        baseFilter3.addParam(new UniformParam.FloatParam("saturation", 1.0f));
        baseFilter3.addParam(new UniformParam.FloatParam("brightness", 1.0f));
        hSVColorChannelFilter2.setNextFilter(baseFilter3, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
