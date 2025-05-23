package org.light.extDecoder.apng.io;

import java.nio.ByteOrder;

/* loaded from: classes29.dex */
public class APNGWriter extends ByteBufferWriter {
    @Override // org.light.extDecoder.apng.io.ByteBufferWriter, org.light.extDecoder.apng.io.Writer
    public void reset(int i3) {
        super.reset(i3);
        this.byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    public void writeFourCC(int i3) {
        putByte((byte) (i3 & 255));
        putByte((byte) ((i3 >> 8) & 255));
        putByte((byte) ((i3 >> 16) & 255));
        putByte((byte) ((i3 >> 24) & 255));
    }

    public void writeInt(int i3) {
        putByte((byte) ((i3 >> 24) & 255));
        putByte((byte) ((i3 >> 16) & 255));
        putByte((byte) ((i3 >> 8) & 255));
        putByte((byte) (i3 & 255));
    }
}
