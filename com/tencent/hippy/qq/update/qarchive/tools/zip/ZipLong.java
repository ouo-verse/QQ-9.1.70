package com.tencent.hippy.qq.update.qarchive.tools.zip;

import com.tencent.commonsdk.soload.MyZipConstants;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ZipLong implements Cloneable {
    private static final int BYTE_1 = 1;
    private static final int BYTE_1_MASK = 65280;
    private static final int BYTE_1_SHIFT = 8;
    private static final int BYTE_2 = 2;
    private static final int BYTE_2_MASK = 16711680;
    private static final int BYTE_2_SHIFT = 16;
    private static final int BYTE_3 = 3;
    private static final long BYTE_3_MASK = 4278190080L;
    private static final int BYTE_3_SHIFT = 24;
    private final long value;
    public static final ZipLong CFH_SIG = new ZipLong(MyZipConstants.CENSIG);
    public static final ZipLong LFH_SIG = new ZipLong(MyZipConstants.LOCSIG);
    public static final ZipLong DD_SIG = new ZipLong(MyZipConstants.EXTSIG);
    static final ZipLong ZIP64_MAGIC = new ZipLong(4294967295L);

    public ZipLong(long j3) {
        this.value = j3;
    }

    public static byte[] getBytes(long j3) {
        return new byte[]{(byte) (255 & j3), (byte) ((65280 & j3) >> 8), (byte) ((16711680 & j3) >> 16), (byte) ((j3 & BYTE_3_MASK) >> 24)};
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e16) {
            throw new RuntimeException(e16);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ZipLong) || this.value != ((ZipLong) obj).getValue()) {
            return false;
        }
        return true;
    }

    public long getValue() {
        return this.value;
    }

    public int hashCode() {
        return (int) this.value;
    }

    public String toString() {
        return "ZipLong value: " + this.value;
    }

    public static long getValue(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] << 24) & BYTE_3_MASK) + ((bArr[i3 + 2] << RegisterType.UNINIT_REF) & 16711680) + ((bArr[i3 + 1] << 8) & 65280) + (bArr[i3] & 255);
    }

    public byte[] getBytes() {
        return getBytes(this.value);
    }

    public ZipLong(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipLong(byte[] bArr, int i3) {
        this.value = getValue(bArr, i3);
    }

    public static long getValue(byte[] bArr) {
        return getValue(bArr, 0);
    }
}
