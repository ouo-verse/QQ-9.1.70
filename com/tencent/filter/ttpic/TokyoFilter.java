package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class TokyoFilter extends BaseFilter {
    public TokyoFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/tokyo_curve.png", 33986));
        setNextFilter(baseFilter, null);
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(0.0f, 11.0f, 0.0f, 307.0f, 337.0f, 7.0f, 37.0f);
        baseFilter.setNextFilter(hSVColorChannelFilter, null);
        HSVColorChannelFilter hSVColorChannelFilter2 = new HSVColorChannelFilter();
        hSVColorChannelFilter2.setInput(0.0f, 26.0f, 32.0f, 6.0f, 37.0f, 67.0f, 96.0f);
        hSVColorChannelFilter.setNextFilter(hSVColorChannelFilter2, null);
        HSVColorChannelFilter hSVColorChannelFilter3 = new HSVColorChannelFilter();
        hSVColorChannelFilter3.setInput(0.0f, 0.0f, 23.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        hSVColorChannelFilter2.setNextFilter(hSVColorChannelFilter3, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
