package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MilkBlueFilter extends BaseFilter {
    public MilkBlueFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(-3.0f, 40.0f, 10.0f, 316.0f, 348.0f, 10.0f, 45.0f);
        setNextFilter(hSVColorChannelFilter, null);
        HSVColorChannelFilter hSVColorChannelFilter2 = new HSVColorChannelFilter();
        hSVColorChannelFilter2.setInput(0.0f, 5.0f, 25.0f, 0.0f, 32.0f, 52.0f, 82.0f);
        hSVColorChannelFilter.setNextFilter(hSVColorChannelFilter2, null);
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/milkblue_curve.png", 33986));
        hSVColorChannelFilter2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(63));
        baseFilter2.addParam(new UniformParam.FloatsParam("color2", new float[]{0.7294118f, 0.8901961f, 0.99607843f, 1.0f}));
        baseFilter2.addParam(new UniformParam.FloatParam("transparency", 0.1f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
