package com.tencent.qqmusic.mediaplayer;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BufferInfo {
    public int bufferSize;
    public byte[] byteBuffer;
    public byte[] tempByteBuffer;

    public void appendByte(byte[] bArr, int i3, int i16) {
        if (bArr != null && i3 >= 0 && i16 > 0 && i3 + i16 <= bArr.length) {
            setByteBufferCapacity(this.bufferSize + i16);
            System.arraycopy(bArr, i3, this.byteBuffer, this.bufferSize, i16);
        }
    }

    public void fillByte(byte[] bArr, int i3) {
        if (bArr != null && i3 > 0 && i3 <= bArr.length) {
            this.byteBuffer = bArr;
            this.bufferSize = i3;
        }
    }

    public BufferInfo fillInto(BufferInfo bufferInfo) {
        bufferInfo.bufferSize = this.bufferSize;
        bufferInfo.byteBuffer = this.byteBuffer;
        bufferInfo.tempByteBuffer = this.tempByteBuffer;
        return bufferInfo;
    }

    public void setByteBufferCapacity(int i3) {
        byte[] bArr = this.byteBuffer;
        if (bArr == null || bArr.length < i3) {
            this.byteBuffer = new byte[i3];
        }
    }

    public void setTempByteBufferCapacity(int i3) {
        byte[] bArr = this.tempByteBuffer;
        if (bArr == null || bArr.length < i3) {
            this.tempByteBuffer = new byte[i3];
        }
    }
}
