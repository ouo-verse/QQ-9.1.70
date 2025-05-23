package com.tencent.mobileqq.mini.zxing;

import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class LuminanceSource {
    private final int height;
    private final int width;

    /* JADX INFO: Access modifiers changed from: protected */
    public LuminanceSource(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }

    public LuminanceSource crop(int i3, int i16, int i17, int i18) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public final int getHeight() {
        return this.height;
    }

    public abstract byte[] getMatrix();

    public abstract byte[] getRow(int i3, byte[] bArr);

    public final int getWidth() {
        return this.width;
    }

    public LuminanceSource invert() {
        return new InvertedLuminanceSource(this);
    }

    public boolean isCropSupported() {
        return false;
    }

    public boolean isRotateSupported() {
        return false;
    }

    public LuminanceSource rotateCounterClockwise() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public LuminanceSource rotateCounterClockwise45() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        int i3 = this.width;
        byte[] bArr = new byte[i3];
        StringBuilder sb5 = new StringBuilder(this.height * (i3 + 1));
        for (int i16 = 0; i16 < this.height; i16++) {
            bArr = getRow(i16, bArr);
            for (int i17 = 0; i17 < this.width; i17++) {
                int i18 = bArr[i17] & 255;
                sb5.append(i18 < 64 ? '#' : i18 < 128 ? '+' : i18 < 192 ? '.' : TokenParser.SP);
            }
            sb5.append('\n');
        }
        return sb5.toString();
    }
}
