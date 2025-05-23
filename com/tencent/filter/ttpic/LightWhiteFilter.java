package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class LightWhiteFilter extends BaseFilter {
    public LightWhiteFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(0.0f, 10.0f, 0.0f, 329.0f, 349.0f, 13.0f, 32.0f);
        setNextFilter(hSVColorChannelFilter, null);
        HSVColorChannelFilter hSVColorChannelFilter2 = new HSVColorChannelFilter();
        hSVColorChannelFilter2.setInput(0.0f, -10.0f, -4.0f, 2.0f, 18.0f, 49.0f, 72.0f);
        hSVColorChannelFilter.setNextFilter(hSVColorChannelFilter2, null);
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/lightwhite_curve.png", 33986));
        hSVColorChannelFilter2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(13));
        baseFilter2.addParam(new UniformParam.FloatParam("contrast", 1.05f));
        baseFilter2.addParam(new UniformParam.FloatParam("saturation", 1.0f));
        baseFilter2.addParam(new UniformParam.FloatParam("brightness", 1.0f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
