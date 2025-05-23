package org.light.extDecoder.apng.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ByteBufferWriter implements Writer {
    protected ByteBuffer byteBuffer;

    public ByteBufferWriter() {
        reset(10240);
    }

    @Override // org.light.extDecoder.apng.io.Writer
    public int position() {
        return this.byteBuffer.position();
    }

    @Override // org.light.extDecoder.apng.io.Writer
    public void putByte(byte b16) {
        this.byteBuffer.put(b16);
    }

    @Override // org.light.extDecoder.apng.io.Writer
    public void putBytes(byte[] bArr) {
        this.byteBuffer.put(bArr);
    }

    @Override // org.light.extDecoder.apng.io.Writer
    public void reset(int i3) {
        ByteBuffer byteBuffer = this.byteBuffer;
        if (byteBuffer == null || i3 > byteBuffer.capacity()) {
            ByteBuffer allocate = ByteBuffer.allocate(i3);
            this.byteBuffer = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.byteBuffer.clear();
    }

    @Override // org.light.extDecoder.apng.io.Writer
    public void skip(int i3) {
        this.byteBuffer.position(i3 + position());
    }

    @Override // org.light.extDecoder.apng.io.Writer
    public byte[] toByteArray() {
        return this.byteBuffer.array();
    }

    @Override // org.light.extDecoder.apng.io.Writer
    public void close() {
    }
}
