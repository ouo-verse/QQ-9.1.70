package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class OceanFilter extends BaseFilter {
    public OceanFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/ocean_curve2.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/ocean_curve3.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(59));
        baseFilter3.addParam(new UniformParam.FloatsParam("color2", new float[]{0.84313726f, 0.8784314f, 0.78431374f, 1.0f}));
        baseFilter3.addParam(new UniformParam.FloatParam("transparency", 0.35f));
        baseFilter2.setNextFilter(baseFilter3, null);
        BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(116));
        baseFilter4.addParam(new UniformParam.FloatsParam("color2", new float[]{0.09411765f, 0.19607843f, 0.3019608f, 1.0f}));
        baseFilter4.addParam(new UniformParam.FloatParam("transparency", 0.42f));
        baseFilter3.setNextFilter(baseFilter4, null);
        BaseFilter baseFilter5 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter5.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{-0.11764706f, 0.0f, 0.11372549f}));
        baseFilter5.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{-0.07058824f, 0.0f, 0.039215688f}));
        baseFilter5.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{-0.023529412f, 0.0f, 0.019607844f}));
        baseFilter4.setNextFilter(baseFilter5, null);
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(0.0f, 9.0f, 9.0f, 307.0f, 336.0f, 6.0f, 37.0f);
        baseFilter5.setNextFilter(hSVColorChannelFilter, null);
        BaseFilter baseFilter6 = new BaseFilter(BaseFilter.getFragmentShader(13));
        baseFilter6.addParam(new UniformParam.FloatParam("contrast", 1.1f));
        baseFilter6.addParam(new UniformParam.FloatParam("saturation", 1.0f));
        baseFilter6.addParam(new UniformParam.FloatParam("brightness", 1.0f));
        hSVColorChannelFilter.setNextFilter(baseFilter6, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
