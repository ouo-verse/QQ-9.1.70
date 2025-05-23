package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class RichRedFilter extends BaseFilter {
    public RichRedFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(0.0f, 13.0f, 0.0f, 340.0f, 352.0f, 10.0f, 20.0f);
        setNextFilter(hSVColorChannelFilter, null);
        HSVColorChannelFilter hSVColorChannelFilter2 = new HSVColorChannelFilter();
        hSVColorChannelFilter2.setInput(0.0f, -18.0f, 15.0f, 352.0f, 15.0f, 45.0f, 70.0f);
        hSVColorChannelFilter.setNextFilter(hSVColorChannelFilter2, null);
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/richred_curve.png", 33986));
        hSVColorChannelFilter2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{0.0f, 0.007843138f, 0.007843138f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{-0.023529412f, 0.011764706f, 0.043137256f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{-0.007843138f, 0.0f, 0.0f}));
        baseFilter.setNextFilter(baseFilter2, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
