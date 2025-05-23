package com.eclipsesource.mmv8.utils.typedarrays;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ArrayBuffer {
    private ByteBuffer byteBuffer;

    public ArrayBuffer(int i3) {
        this.byteBuffer = ByteBuffer.allocateDirect(i3);
    }

    private ByteBuffer validateByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
            return byteBuffer;
        }
        throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
    }

    public byte getByte(int i3) {
        return this.byteBuffer.get(i3);
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    public short getUnsignedByte(int i3) {
        return (short) (this.byteBuffer.get(i3) & 255);
    }

    public int limit() {
        return this.byteBuffer.limit();
    }

    public void put(int i3, byte b16) {
        this.byteBuffer.put(i3, b16);
    }

    public String toString() {
        return "[object ArrayBuffer]";
    }

    public ArrayBuffer(byte[] bArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        this.byteBuffer = allocateDirect;
        allocateDirect.put(bArr, 0, bArr.length);
    }

    public ArrayBuffer(ByteBuffer byteBuffer) {
        this.byteBuffer = validateByteBuffer(byteBuffer);
    }
}
