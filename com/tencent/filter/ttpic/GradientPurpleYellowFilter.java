package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* loaded from: classes6.dex */
public class GradientPurpleYellowFilter extends BaseFilter {
    public GradientPurpleYellowFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/purpleyellow_nuan_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(136));
        baseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/gradient_purpleyellow_rgb.png", 33986, this.needFlipBlend ? 1 : 0));
        baseFilter2.addParam(new UniformParam.FloatParam("ralpha", 0.6f));
        baseFilter2.addParam(new UniformParam.FloatParam("galpha", 0.6f));
        baseFilter2.addParam(new UniformParam.FloatParam("balpha", 0.6f));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter3.addParam(new TextureResParam("inputImageTexture2", "sh/purpleyellow_anticmos_curve.png", 33986));
        baseFilter2.setNextFilter(baseFilter3, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
