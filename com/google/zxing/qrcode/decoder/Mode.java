package com.google.zxing.qrcode.decoder;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum Mode {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);

    private final int bits;
    private final int[] characterCountBitsForVersions;

    Mode(int[] iArr, int i3) {
        this.characterCountBitsForVersions = iArr;
        this.bits = i3;
    }

    public int getBits() {
        return this.bits;
    }

    public int getCharacterCountBits(Version version) {
        char c16;
        int versionNumber = version.getVersionNumber();
        if (versionNumber <= 9) {
            c16 = 0;
        } else if (versionNumber <= 26) {
            c16 = 1;
        } else {
            c16 = 2;
        }
        return this.characterCountBitsForVersions[c16];
    }
}
