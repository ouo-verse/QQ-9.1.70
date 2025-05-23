package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class NextDoorFilter extends BaseFilter {
    public NextDoorFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(107));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/nextdoor_center_curve.png", 33986));
        baseFilter.addParam(new TextureResParam("inputImageTexture3", "sh/nextdoor_center_curve_mask.png", 33987));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(107));
        baseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/nextdoor_edge_curve.png", 33986));
        baseFilter2.addParam(new TextureResParam("inputImageTexture3", "sh/nextdoor_edge_curve_mask.png", 33987));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter3.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{0.0f, -0.05490196f, 0.101960786f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.0f, -0.08627451f, 0.0f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter3.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        baseFilter2.setNextFilter(baseFilter3, null);
        BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(59));
        baseFilter4.addParam(new UniformParam.FloatsParam("color2", new float[]{0.99215686f, 0.84705883f, 0.6392157f, 1.0f}));
        baseFilter4.addParam(new UniformParam.FloatParam("transparency", 0.3f));
        baseFilter3.setNextFilter(baseFilter4, null);
        HSVColorChannelFilter hSVColorChannelFilter = new HSVColorChannelFilter();
        hSVColorChannelFilter.setInput(1.0f, 20.0f, 0.0f, 335.0f, 352.0f, 16.0f, 28.0f);
        baseFilter4.setNextFilter(hSVColorChannelFilter, null);
        BaseFilter baseFilter5 = new BaseFilter(BaseFilter.getFragmentShader(13));
        baseFilter5.addParam(new UniformParam.FloatParam("contrast", 1.1f));
        baseFilter5.addParam(new UniformParam.FloatParam("saturation", 1.0f));
        baseFilter5.addParam(new UniformParam.FloatParam("brightness", 1.0f));
        hSVColorChannelFilter.setNextFilter(baseFilter5, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
