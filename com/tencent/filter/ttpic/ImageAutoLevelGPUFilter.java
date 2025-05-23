package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;

/* loaded from: classes6.dex */
public class ImageAutoLevelGPUFilter extends BaseFilter {

    /* renamed from: p, reason: collision with root package name */
    private float f106456p;

    public ImageAutoLevelGPUFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        this.f106456p = 1.0f;
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        int theFilterIndex = getTheFilterIndex(this);
        BaseFilter baseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        baseFilter.scaleFact = Math.min(100.0f / Math.min(f17, f16), 1.0f);
        setNextFilter(baseFilter, null);
        baseFilter.setNextFilter(new HistogramAutoLevelFilter(this.f106456p), new int[]{this.srcTextureIndex + 1 + theFilterIndex});
        super.applyFilterChain(z16, f16, f17);
    }
}
