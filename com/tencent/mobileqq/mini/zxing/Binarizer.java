package com.tencent.mobileqq.mini.zxing;

import com.tencent.mobileqq.mini.zxing.common.BitArray;
import com.tencent.mobileqq.mini.zxing.common.BitMatrix;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class Binarizer {
    private final LuminanceSource source;

    /* JADX INFO: Access modifiers changed from: protected */
    public Binarizer(LuminanceSource luminanceSource) {
        this.source = luminanceSource;
    }

    public abstract Binarizer createBinarizer(LuminanceSource luminanceSource);

    public abstract BitMatrix getBlackMatrix() throws NotFoundException;

    public abstract BitArray getBlackRow(int i3, BitArray bitArray) throws NotFoundException;

    public final int getHeight() {
        return this.source.getHeight();
    }

    public final LuminanceSource getLuminanceSource() {
        return this.source;
    }

    public final int getWidth() {
        return this.source.getWidth();
    }
}
