package com.tencent.mobileqq.pb;

import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class ByteStringMicro {
    public static final ByteStringMicro EMPTY = new ByteStringMicro(new byte[0]);
    private final byte[] bytes;
    private volatile int hash = 0;

    ByteStringMicro(byte[] bArr) {
        this.bytes = bArr;
    }

    public static ByteStringMicro copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new ByteStringMicro(str.getBytes(str2));
    }

    public static ByteStringMicro copyFromUtf8(String str) {
        try {
            return new ByteStringMicro(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported?");
        }
    }

    public byte byteAt(int i3) {
        return this.bytes[i3];
    }

    public void copyTo(byte[] bArr, int i3) {
        byte[] bArr2 = this.bytes;
        System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteStringMicro)) {
            return false;
        }
        byte[] bArr = this.bytes;
        int length = bArr.length;
        byte[] bArr2 = ((ByteStringMicro) obj).bytes;
        if (length != bArr2.length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i3 = this.hash;
        if (i3 == 0) {
            byte[] bArr = this.bytes;
            int length = bArr.length;
            for (byte b16 : bArr) {
                length = (length * 31) + b16;
            }
            if (length == 0) {
                i3 = 1;
            } else {
                i3 = length;
            }
            this.hash = i3;
        }
        return i3;
    }

    public boolean isEmpty() {
        if (this.bytes.length == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.bytes.length;
    }

    public byte[] toByteArray() {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.bytes, str);
    }

    public String toStringUtf8() {
        try {
            return new String(this.bytes, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported?");
        }
    }

    public static ByteStringMicro copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public void copyTo(byte[] bArr, int i3, int i16, int i17) {
        System.arraycopy(this.bytes, i3, bArr, i16, i17);
    }

    public static ByteStringMicro copyFrom(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = new byte[i16];
        System.arraycopy(bArr, i3, bArr2, 0, i16);
        return new ByteStringMicro(bArr2);
    }
}
