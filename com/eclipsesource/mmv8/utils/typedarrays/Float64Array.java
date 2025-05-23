package com.eclipsesource.mmv8.utils.typedarrays;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Float64Array extends TypedArray {
    public Float64Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public double get(int i3) {
        return this.buffer.asDoubleBuffer().get(i3);
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int getType() {
        return 2;
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int length() {
        return this.buffer.asDoubleBuffer().limit();
    }

    public void put(int i3, double d16) {
        this.buffer.asDoubleBuffer().put(i3, d16);
    }

    public Float64Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }
}
