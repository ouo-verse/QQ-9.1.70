package com.eclipsesource.mmv8.utils.typedarrays;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Int16Array extends TypedArray {
    public Int16Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public short get(int i3) {
        return this.buffer.asShortBuffer().get(i3);
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int getType() {
        return 13;
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int length() {
        return this.buffer.asShortBuffer().limit();
    }

    public void put(int i3, short s16) {
        this.buffer.asShortBuffer().put(i3, s16);
    }

    public Int16Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }
}
