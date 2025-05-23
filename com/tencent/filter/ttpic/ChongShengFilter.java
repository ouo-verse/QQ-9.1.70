package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ChongShengFilter extends BaseFilter {
    private BaseFilter nextFilter;

    public ChongShengFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        GPUImageLookupFilter gPUImageLookupFilter = new GPUImageLookupFilter();
        this.nextFilter = gPUImageLookupFilter;
        gPUImageLookupFilter.addParam(new TextureResParam("inputImageTexture2", "sh/chongsheng_lf.png", 33986));
        setNextFilter(this.nextFilter, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
