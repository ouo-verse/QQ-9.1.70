package com.eclipsesource.mmv8.utils.typedarrays;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Int32Array extends TypedArray {
    public Int32Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public int get(int i3) {
        return this.buffer.asIntBuffer().get(i3);
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int getType() {
        return 1;
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int length() {
        return this.buffer.asIntBuffer().limit();
    }

    public void put(int i3, int i16) {
        this.buffer.asIntBuffer().put(i3, i16);
    }

    public Int32Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }
}
