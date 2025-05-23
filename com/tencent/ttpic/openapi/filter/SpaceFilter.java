package com.tencent.ttpic.openapi.filter;

import com.tencent.filter.BaseFilter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SpaceFilter extends BaseFilter {
    private float mRatio;

    public SpaceFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        this.mRatio = 0.0f;
    }

    public void setSpaceRatio(float f16) {
        if (Float.compare(this.mRatio, f16) == 0) {
            return;
        }
        this.mRatio = f16;
        float f17 = 1.0f - f16;
        float f18 = -f17;
        setPositions(new float[]{f18, f18, f18, f17, f17, f17, f17, f18});
    }
}
