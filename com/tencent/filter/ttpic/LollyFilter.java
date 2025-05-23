package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class LollyFilter extends BaseFilter {
    public LollyFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(59));
        baseFilter.addParam(new UniformParam.FloatsParam("color2", new float[]{0.3882353f, 0.9490196f, 0.99607843f, 1.0f}));
        baseFilter.addParam(new UniformParam.FloatParam("transparency", 0.18f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{-0.039215688f, -0.047058824f, 0.03137255f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{-0.0627451f, -0.007843138f, 0.03137255f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{0.0f, -0.039215688f, 0.03137255f}));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter3.addParam(new TextureResParam("inputImageTexture2", "sh/lolly_curve.png", 33986));
        baseFilter2.setNextFilter(baseFilter3, null);
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(7.0f, 30.0f, 0.0f, 306.0f, 336.0f, 6.0f, 36.0f);
        baseFilter3.setNextFilter(hSVColorChannelFilter, null);
        HSVColorChannelFilter hSVColorChannelFilter2 = new HSVColorChannelFilter();
        hSVColorChannelFilter2.setInput(-14.0f, 24.0f, 0.0f, 169.0f, 180.0f, 229.0f, 259.0f);
        hSVColorChannelFilter.setNextFilter(hSVColorChannelFilter2, null);
        HSVColorChannelFilter hSVColorChannelFilter3 = new HSVColorChannelFilter();
        hSVColorChannelFilter3.setInput(0.0f, 30.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        hSVColorChannelFilter2.setNextFilter(hSVColorChannelFilter3, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
