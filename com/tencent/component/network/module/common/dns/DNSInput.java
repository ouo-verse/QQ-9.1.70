package com.tencent.component.network.module.common.dns;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DNSInput {
    private byte[] array;
    private int end;
    private int pos = 0;
    private int saved_pos = -1;
    private int saved_end = -1;

    public DNSInput(byte[] bArr) {
        this.array = bArr;
        this.end = bArr.length;
    }

    private void require(int i3) throws WireParseException {
        if (i3 <= remaining()) {
        } else {
            throw new WireParseException("end of input");
        }
    }

    public void clearActive() {
        this.end = this.array.length;
    }

    public int current() {
        return this.pos;
    }

    public void jump(int i3) {
        byte[] bArr = this.array;
        if (i3 < bArr.length) {
            this.pos = i3;
            this.end = bArr.length;
            return;
        }
        throw new IllegalArgumentException("cannot jump past end of input");
    }

    public void readByteArray(byte[] bArr, int i3, int i16) throws WireParseException {
        require(i16);
        System.arraycopy(this.array, this.pos, bArr, i3, i16);
        this.pos += i16;
    }

    public byte[] readCountedString() throws WireParseException {
        require(1);
        byte[] bArr = this.array;
        int i3 = this.pos;
        this.pos = i3 + 1;
        return readByteArray(bArr[i3] & 255);
    }

    public int readU16() throws WireParseException {
        require(2);
        byte[] bArr = this.array;
        int i3 = this.pos;
        int i16 = i3 + 1;
        int i17 = bArr[i3] & 255;
        this.pos = i16 + 1;
        return (i17 << 8) + (bArr[i16] & 255);
    }

    public long readU32() throws WireParseException {
        require(4);
        byte[] bArr = this.array;
        int i3 = this.pos;
        int i16 = i3 + 1;
        int i17 = bArr[i3] & 255;
        int i18 = i16 + 1;
        int i19 = bArr[i16] & 255;
        int i26 = i18 + 1;
        int i27 = bArr[i18] & 255;
        this.pos = i26 + 1;
        return (i17 << 24) + (i19 << 16) + (i27 << 8) + (bArr[i26] & 255);
    }

    public int readU8() throws WireParseException {
        require(1);
        byte[] bArr = this.array;
        int i3 = this.pos;
        this.pos = i3 + 1;
        return bArr[i3] & 255;
    }

    public int remaining() {
        return this.end - this.pos;
    }

    public void restore() {
        int i3 = this.saved_pos;
        if (i3 >= 0) {
            this.pos = i3;
            this.end = this.saved_end;
            this.saved_pos = -1;
            this.saved_end = -1;
            return;
        }
        throw new IllegalStateException("no previous state");
    }

    public void save() {
        this.saved_pos = this.pos;
        this.saved_end = this.end;
    }

    public void setActive(int i3) {
        int length = this.array.length;
        int i16 = this.pos;
        if (i3 <= length - i16) {
            this.end = i16 + i3;
            return;
        }
        throw new IllegalArgumentException("cannot set active region past end of input");
    }

    public byte[] readByteArray(int i3) throws WireParseException {
        require(i3);
        byte[] bArr = new byte[i3];
        System.arraycopy(this.array, this.pos, bArr, 0, i3);
        this.pos += i3;
        return bArr;
    }

    public byte[] readByteArray() {
        int remaining = remaining();
        byte[] bArr = new byte[remaining];
        System.arraycopy(this.array, this.pos, bArr, 0, remaining);
        this.pos += remaining;
        this.end = this.array.length - 1;
        return bArr;
    }
}
