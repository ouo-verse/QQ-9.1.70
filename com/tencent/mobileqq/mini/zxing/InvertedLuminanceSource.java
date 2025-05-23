package com.tencent.mobileqq.mini.zxing;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class InvertedLuminanceSource extends LuminanceSource {
    private final LuminanceSource delegate;

    public InvertedLuminanceSource(LuminanceSource luminanceSource) {
        super(luminanceSource.getWidth(), luminanceSource.getHeight());
        this.delegate = luminanceSource;
    }

    @Override // com.tencent.mobileqq.mini.zxing.LuminanceSource
    public LuminanceSource crop(int i3, int i16, int i17, int i18) {
        return new InvertedLuminanceSource(this.delegate.crop(i3, i16, i17, i18));
    }

    @Override // com.tencent.mobileqq.mini.zxing.LuminanceSource
    public byte[] getMatrix() {
        byte[] matrix = this.delegate.getMatrix();
        int width = getWidth() * getHeight();
        byte[] bArr = new byte[width];
        for (int i3 = 0; i3 < width; i3++) {
            bArr[i3] = (byte) (255 - (matrix[i3] & 255));
        }
        return bArr;
    }

    @Override // com.tencent.mobileqq.mini.zxing.LuminanceSource
    public byte[] getRow(int i3, byte[] bArr) {
        byte[] row = this.delegate.getRow(i3, bArr);
        int width = getWidth();
        for (int i16 = 0; i16 < width; i16++) {
            row[i16] = (byte) (255 - (row[i16] & 255));
        }
        return row;
    }

    @Override // com.tencent.mobileqq.mini.zxing.LuminanceSource
    public LuminanceSource invert() {
        return this.delegate;
    }

    @Override // com.tencent.mobileqq.mini.zxing.LuminanceSource
    public boolean isCropSupported() {
        return this.delegate.isCropSupported();
    }

    @Override // com.tencent.mobileqq.mini.zxing.LuminanceSource
    public boolean isRotateSupported() {
        return this.delegate.isRotateSupported();
    }

    @Override // com.tencent.mobileqq.mini.zxing.LuminanceSource
    public LuminanceSource rotateCounterClockwise() {
        return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise());
    }

    @Override // com.tencent.mobileqq.mini.zxing.LuminanceSource
    public LuminanceSource rotateCounterClockwise45() {
        return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise45());
    }
}
