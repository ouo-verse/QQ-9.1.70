package com.tencent.mobileqq.mini.zxing;

/* loaded from: classes33.dex */
public final class PlanarYUVLuminanceSource extends LuminanceSource {
    private static final int THUMBNAIL_SCALE_FACTOR = 2;
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final int top;
    private final byte[] yuvData;

    public PlanarYUVLuminanceSource(byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26, boolean z16) {
        super(i19, i26);
        if (i17 + i19 <= i3 && i18 + i26 <= i16) {
            this.yuvData = bArr;
            this.dataWidth = i3;
            this.dataHeight = i16;
            this.left = i17;
            this.top = i18;
            if (z16) {
                reverseHorizontal(i19, i26);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }

    private void reverseHorizontal(int i3, int i16) {
        byte[] bArr = this.yuvData;
        int i17 = (this.top * this.dataWidth) + this.left;
        int i18 = 0;
        while (i18 < i16) {
            int i19 = (i3 / 2) + i17;
            int i26 = (i17 + i3) - 1;
            int i27 = i17;
            while (i27 < i19) {
                byte b16 = bArr[i27];
                bArr[i27] = bArr[i26];
                bArr[i26] = b16;
                i27++;
                i26--;
            }
            i18++;
            i17 += this.dataWidth;
        }
    }

    @Override // com.tencent.mobileqq.mini.zxing.LuminanceSource
    public LuminanceSource crop(int i3, int i16, int i17, int i18) {
        return new PlanarYUVLuminanceSource(this.yuvData, this.dataWidth, this.dataHeight, this.left + i3, this.top + i16, i17, i18, false);
    }

    @Override // com.tencent.mobileqq.mini.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int i3 = this.dataWidth;
        if (width == i3 && height == this.dataHeight) {
            return this.yuvData;
        }
        int i16 = width * height;
        byte[] bArr = new byte[i16];
        int i17 = (this.top * i3) + this.left;
        if (width == i3) {
            System.arraycopy(this.yuvData, i17, bArr, 0, i16);
            return bArr;
        }
        for (int i18 = 0; i18 < height; i18++) {
            System.arraycopy(this.yuvData, i17, bArr, i18 * width, width);
            i17 += this.dataWidth;
        }
        return bArr;
    }

    public int getThumbnailHeight() {
        return getHeight() / 2;
    }

    public int getThumbnailWidth() {
        return getWidth() / 2;
    }

    @Override // com.tencent.mobileqq.mini.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    public int[] renderThumbnail() {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int[] iArr = new int[width * height];
        byte[] bArr = this.yuvData;
        int i3 = (this.top * this.dataWidth) + this.left;
        for (int i16 = 0; i16 < height; i16++) {
            int i17 = i16 * width;
            for (int i18 = 0; i18 < width; i18++) {
                iArr[i17 + i18] = ((bArr[(i18 * 2) + i3] & 255) * 65793) | (-16777216);
            }
            i3 += this.dataWidth * 2;
        }
        return iArr;
    }

    @Override // com.tencent.mobileqq.mini.zxing.LuminanceSource
    public byte[] getRow(int i3, byte[] bArr) {
        if (i3 >= 0 && i3 < getHeight()) {
            int width = getWidth();
            if (bArr == null || bArr.length < width) {
                bArr = new byte[width];
            }
            System.arraycopy(this.yuvData, ((i3 + this.top) * this.dataWidth) + this.left, bArr, 0, width);
            return bArr;
        }
        throw new IllegalArgumentException("Requested row is outside the image: " + i3);
    }
}
