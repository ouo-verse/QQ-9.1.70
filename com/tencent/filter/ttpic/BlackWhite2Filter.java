package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class BlackWhite2Filter extends BaseFilter {
    public BlackWhite2Filter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(58));
        baseFilter.addParam(new UniformParam.FloatsParam("channelparam", new float[]{0.4f, 0.4f, 0.2f}));
        baseFilter.addParam(new UniformParam.FloatsParam("mixparam", new float[]{1.0f, 1.0f, 1.0f}));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/blackwhite.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(109));
        baseFilter3.addParam(new TextureResParam("inputImageTexture2", "sh/blackwhite2levelmask.png", 33986));
        baseFilter3.addParam(new UniformParam.FloatsParam("levelMinimum", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("levelMiddle", new float[]{0.2f, 0.2f, 0.2f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("levelMaximum", new float[]{1.0f, 1.0f, 1.0f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("minOutput", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("maxOutput", new float[]{1.0f, 1.0f, 1.0f}));
        baseFilter2.setNextFilter(baseFilter3, null);
        BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(61));
        baseFilter4.addParam(new TextureResParam("inputImageTexture2", "sh/blackwhite2overlay.png", 33986));
        baseFilter3.setNextFilter(baseFilter4, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
