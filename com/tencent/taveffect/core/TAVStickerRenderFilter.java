package com.tencent.taveffect.core;

import android.graphics.Matrix;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerRenderFilter extends TAVRendererFilter {
    @Override // com.tencent.taveffect.core.TAVRendererFilter, com.tencent.taveffect.core.TAVBaseFilter
    public void setParams(Matrix matrix, Matrix matrix2, TAVRectangle tAVRectangle, float f16) {
        this.xyMatrix = matrix;
        this.stMatrix = matrix2;
        this.cropRect = tAVRectangle;
        this.alpha = f16;
    }
}
