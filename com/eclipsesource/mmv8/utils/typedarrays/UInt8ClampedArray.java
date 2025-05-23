package com.eclipsesource.mmv8.utils.typedarrays;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UInt8ClampedArray extends TypedArray {
    public UInt8ClampedArray(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public short get(int i3) {
        return (short) (this.buffer.get(i3) & 255);
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int getType() {
        return 12;
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int length() {
        return this.buffer.limit();
    }

    public void put(int i3, short s16) {
        if (s16 > 255) {
            this.buffer.put(i3, (byte) -1);
        } else if (s16 < 0) {
            this.buffer.put(i3, (byte) 0);
        } else {
            this.buffer.put(i3, (byte) s16);
        }
    }

    public UInt8ClampedArray(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }
}
