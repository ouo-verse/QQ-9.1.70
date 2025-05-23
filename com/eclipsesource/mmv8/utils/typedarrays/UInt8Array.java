package com.eclipsesource.mmv8.utils.typedarrays;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UInt8Array extends TypedArray {
    public UInt8Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public short get(int i3) {
        return (short) (this.buffer.get(i3) & 255);
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int getType() {
        return 11;
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int length() {
        return this.buffer.limit();
    }

    public void put(int i3, short s16) {
        this.buffer.put(i3, (byte) (s16 & 255));
    }

    public UInt8Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }
}
