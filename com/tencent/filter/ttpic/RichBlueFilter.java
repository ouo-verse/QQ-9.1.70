package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class RichBlueFilter extends BaseFilter {
    public RichBlueFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(0.0f, -19.0f, 8.0f, 354.0f, 20.0f, 52.0f, 77.0f);
        setNextFilter(hSVColorChannelFilter, null);
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/richblue_curve.png", 33986));
        hSVColorChannelFilter.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{-0.17254902f, -0.039215688f, 0.16470589f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.023529412f, -0.007843138f, 0.078431375f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{0.03137255f, 0.0f, 0.0f}));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(13));
        baseFilter3.addParam(new UniformParam.FloatParam("contrast", 0.97f));
        baseFilter3.addParam(new UniformParam.FloatParam("saturation", 1.0f));
        baseFilter3.addParam(new UniformParam.FloatParam("brightness", 1.0f));
        baseFilter2.setNextFilter(baseFilter3, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
