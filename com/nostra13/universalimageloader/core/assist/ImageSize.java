package com.nostra13.universalimageloader.core.assist;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ImageSize {
    private static final String SEPARATOR = "x";
    private static final int TO_STRING_MAX_LENGHT = 9;
    private final int height;
    private final int width;

    public ImageSize(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public ImageSize scale(float f16) {
        return new ImageSize((int) (this.width * f16), (int) (this.height * f16));
    }

    public ImageSize scaleDown(int i3) {
        return new ImageSize(this.width / i3, this.height / i3);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(9);
        sb5.append(this.width);
        sb5.append("x");
        sb5.append(this.height);
        return sb5.toString();
    }

    public ImageSize(int i3, int i16, int i17) {
        if (i17 % 180 == 0) {
            this.width = i3;
            this.height = i16;
        } else {
            this.width = i16;
            this.height = i3;
        }
    }
}
