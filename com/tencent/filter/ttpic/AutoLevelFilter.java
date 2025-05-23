package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;

/* compiled from: P */
/* loaded from: classes6.dex */
public class AutoLevelFilter extends BaseFilter {
    public AutoLevelFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        if (z16) {
            super.applyFilterChain(z16, f16, f17);
            return;
        }
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getVertexShader(13), BaseFilter.getFragmentShader(112));
        baseFilter.addParam(new UniformParam.FloatParam("sharpness", 0.2f));
        baseFilter.addParam(new UniformParam.FloatParam("inputH", 1.0f));
        baseFilter.addParam(new UniformParam.FloatParam("inputS", 1.2f));
        baseFilter.addParam(new UniformParam.FloatParam("inputV", 1.0f));
        baseFilter.addParam(new UniformParam.FloatParam("imageWidthFactor", 1.0f / f16));
        baseFilter.addParam(new UniformParam.FloatParam("imageHeightFactor", 1.0f / f17));
        setNextFilter(baseFilter, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
