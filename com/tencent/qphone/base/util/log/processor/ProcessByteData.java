package com.tencent.qphone.base.util.log.processor;

/* loaded from: classes22.dex */
public class ProcessByteData {
    public byte[] bytes;
    public int capacity;
    public int length;
    public int offset;

    public ProcessByteData() {
        this.bytes = new byte[2048];
        this.capacity = 2048;
        this.offset = 0;
        this.length = 0;
    }

    public void append(byte[] bArr, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            this.bytes[this.length + i16] = bArr[i16];
        }
        this.length += i3;
    }

    public void clear() {
        this.offset = 0;
        this.length = 0;
    }

    public void setData(byte[] bArr, int i3, int i16) {
        this.bytes = bArr;
        this.capacity = bArr.length;
        this.offset = i3;
        this.length = i16;
    }

    public void append(byte[] bArr, int i3, int i16) {
        for (int i17 = 0; i17 < i16; i17++) {
            byte[] bArr2 = this.bytes;
            int i18 = this.offset;
            this.offset = i18 + 1;
            bArr2[i18] = bArr[i3 + i17];
        }
        this.length += i16;
    }

    public ProcessByteData(int i3) {
        this.bytes = new byte[i3];
        this.capacity = i3;
        this.offset = 0;
        this.length = 0;
    }

    public ProcessByteData(byte[] bArr, int i3, int i16) {
        this.bytes = bArr;
        this.capacity = bArr == null ? 0 : bArr.length;
        this.offset = i3;
        this.length = i16;
    }
}
