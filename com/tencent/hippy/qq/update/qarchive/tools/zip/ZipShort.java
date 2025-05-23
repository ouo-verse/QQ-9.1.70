package com.tencent.hippy.qq.update.qarchive.tools.zip;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ZipShort implements Cloneable {
    private static final int BYTE_1_MASK = 65280;
    private static final int BYTE_1_SHIFT = 8;
    private final int value;

    public ZipShort(int i3) {
        this.value = i3;
    }

    public static byte[] getBytes(int i3) {
        return new byte[]{(byte) (i3 & 255), (byte) ((i3 & 65280) >> 8)};
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e16) {
            throw new RuntimeException(e16);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ZipShort) || this.value != ((ZipShort) obj).getValue()) {
            return false;
        }
        return true;
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }

    public String toString() {
        return "ZipShort value: " + this.value;
    }

    public static int getValue(byte[] bArr, int i3) {
        return ((bArr[i3 + 1] << 8) & 65280) + (bArr[i3] & 255);
    }

    public byte[] getBytes() {
        int i3 = this.value;
        return new byte[]{(byte) (i3 & 255), (byte) ((i3 & 65280) >> 8)};
    }

    public ZipShort(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipShort(byte[] bArr, int i3) {
        this.value = getValue(bArr, i3);
    }

    public static int getValue(byte[] bArr) {
        return getValue(bArr, 0);
    }
}
