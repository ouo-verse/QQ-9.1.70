package com.tencent.ttpic.openapi.filter;

import com.tencent.filter.BaseFilter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CropFilter extends BaseFilter {
    private float bottom;
    private float left;

    public CropFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        this.left = 0.0f;
        this.bottom = 0.0f;
    }

    private void updatePosition(int i3, int i16, int i17, int i18) {
        float f16 = (i17 - i3) / i17;
        float f17 = (i18 - i16) / i18;
        float f18 = f16 - 1.0f;
        float f19 = 1.0f - f16;
        float f26 = (-1.0f) + f17;
        float f27 = 1.0f - f17;
        setPositions(new float[]{f18, f26, f18, f27, f19, f27, f19, f26});
    }

    private void updateTexCords(int i3, int i16, int i17, int i18) {
        float f16 = ((i17 - i3) / 2.0f) / i17;
        float f17 = 1.0f - f16;
        float f18 = ((i18 - i16) / 2.0f) / i18;
        float f19 = 1.0f - f18;
        if (Float.compare(f16, this.left) == 0 && Float.compare(f18, this.bottom) == 0) {
            return;
        }
        this.left = f16;
        this.bottom = f18;
        setTexCords(new float[]{f16, f18, f16, f19, f17, f19, f17, f18});
    }

    @Override // com.tencent.filter.BaseFilter
    public void clearGLSLSelf() {
        this.left = 0.0f;
        this.bottom = 0.0f;
        super.clearGLSLSelf();
    }

    public void updateCorpRect(int i3, int i16, int i17, int i18) {
        updateTexCords(i3, i16, i17, i18);
    }
}
