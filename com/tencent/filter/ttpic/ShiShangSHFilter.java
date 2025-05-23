package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ShiShangSHFilter extends BaseFilter {
    private int effectindex;

    public ShiShangSHFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        this.effectindex = 0;
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
        if (this.effectindex == 0) {
            BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
            baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/shishang_sh_curve.png", 33986));
            setNextFilter(baseFilter, null);
            BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(61));
            baseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/shishang_sh_blend.jpg", 33986));
            baseFilter.setNextFilter(baseFilter2, null);
        } else {
            BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(62));
            baseFilter3.addParam(new TextureResParam("inputImageTexture2", "sh/fugu_sh_blend.jpg", 33986));
            setNextFilter(baseFilter3, null);
            BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(3));
            baseFilter4.addParam(new UniformParam.FloatParam("filterAdjustParam", 0.3f));
            baseFilter3.setNextFilter(baseFilter4, new int[]{this.srcTextureIndex});
        }
        super.applyFilterChain(z16, f16, f17);
    }

    public ShiShangSHFilter(int i3) {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        this.effectindex = i3;
    }
}
