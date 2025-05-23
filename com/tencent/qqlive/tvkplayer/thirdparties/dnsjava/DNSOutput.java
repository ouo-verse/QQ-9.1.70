package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DNSOutput {
    private byte[] array;
    private int pos;
    private int saved_pos;

    public DNSOutput(int i3) {
        this.array = new byte[i3];
        this.pos = 0;
        this.saved_pos = -1;
    }

    private void check(long j3, int i3) {
        long j16 = 1 << i3;
        if (j3 >= 0 && j3 <= j16) {
            return;
        }
        throw new IllegalArgumentException(j3 + " out of range for " + i3 + " bit value");
    }

    private void need(int i3) {
        byte[] bArr = this.array;
        int length = bArr.length;
        int i16 = this.pos;
        if (length - i16 >= i3) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i16 + i3) {
            length2 = i16 + i3;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i16);
        this.array = bArr2;
    }

    static byte[] toU16(int i3) {
        return new byte[]{(byte) ((i3 >>> 8) & 255), (byte) (i3 & 255)};
    }

    public int current() {
        return this.pos;
    }

    public void jump(int i3) {
        if (i3 <= this.pos) {
            this.pos = i3;
            return;
        }
        throw new IllegalArgumentException("cannot jump past end of data");
    }

    public void restore() {
        int i3 = this.saved_pos;
        if (i3 >= 0) {
            this.pos = i3;
            this.saved_pos = -1;
            return;
        }
        throw new IllegalStateException("no previous state");
    }

    public void save() {
        this.saved_pos = this.pos;
    }

    public byte[] toByteArray() {
        int i3 = this.pos;
        byte[] bArr = new byte[i3];
        System.arraycopy(this.array, 0, bArr, 0, i3);
        return bArr;
    }

    public void writeByteArray(byte[] bArr, int i3, int i16) {
        need(i16);
        System.arraycopy(bArr, i3, this.array, this.pos, i16);
        this.pos += i16;
    }

    public void writeCountedString(byte[] bArr) {
        if (bArr.length <= 255) {
            need(bArr.length + 1);
            byte[] bArr2 = this.array;
            int i3 = this.pos;
            this.pos = i3 + 1;
            bArr2[i3] = (byte) (255 & bArr.length);
            writeByteArray(bArr, 0, bArr.length);
            return;
        }
        throw new IllegalArgumentException("Invalid counted string");
    }

    public void writeU16(int i3) {
        check(i3, 16);
        need(2);
        byte[] bArr = this.array;
        int i16 = this.pos;
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((i3 >>> 8) & 255);
        this.pos = i17 + 1;
        bArr[i17] = (byte) (i3 & 255);
    }

    public void writeU16At(int i3, int i16) {
        check(i3, 16);
        if (i16 <= this.pos - 2) {
            byte[] bArr = this.array;
            bArr[i16] = (byte) ((i3 >>> 8) & 255);
            bArr[i16 + 1] = (byte) (i3 & 255);
            return;
        }
        throw new IllegalArgumentException("cannot write past end of data");
    }

    public void writeU32(long j3) {
        check(j3, 32);
        need(4);
        byte[] bArr = this.array;
        int i3 = this.pos;
        int i16 = i3 + 1;
        bArr[i3] = (byte) ((j3 >>> 24) & 255);
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((j3 >>> 16) & 255);
        int i18 = i17 + 1;
        bArr[i17] = (byte) ((j3 >>> 8) & 255);
        this.pos = i18 + 1;
        bArr[i18] = (byte) (j3 & 255);
    }

    public void writeU8(int i3) {
        check(i3, 8);
        need(1);
        byte[] bArr = this.array;
        int i16 = this.pos;
        this.pos = i16 + 1;
        bArr[i16] = (byte) (i3 & 255);
    }

    public void writeByteArray(byte[] bArr) {
        writeByteArray(bArr, 0, bArr.length);
    }

    public DNSOutput() {
        this(32);
    }
}
