package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.BeautysFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* loaded from: classes6.dex */
public class TianMeiZiPaiFilter extends BaseFilter {
    public TianMeiZiPaiFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BeautysFilter beautysFilter = new BeautysFilter(0, 0);
        beautysFilter.setEffectIndex(2);
        beautysFilter.setSrcFilterIndex(this.srcTextureIndex + 1);
        beautysFilter.applyFilterChain(z16, f16, f17);
        setNextFilter(beautysFilter, null);
        BaseFilter lastFilter = beautysFilter.getLastFilter();
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/tianmeizipai_curve.png", 33986));
        lastFilter.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{0.03137255f, 0.0f, 0.0f}));
        baseFilter.setNextFilter(baseFilter2, null);
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(0.0f, 3.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        baseFilter2.setNextFilter(hSVColorChannelFilter, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
