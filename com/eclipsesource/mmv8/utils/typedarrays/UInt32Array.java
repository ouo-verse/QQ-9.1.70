package com.eclipsesource.mmv8.utils.typedarrays;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UInt32Array extends TypedArray {
    public UInt32Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public long get(int i3) {
        return this.buffer.asIntBuffer().get(i3) & (-1);
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int getType() {
        return 15;
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int length() {
        return this.buffer.asIntBuffer().limit();
    }

    public void put(int i3, long j3) {
        this.buffer.asIntBuffer().put(i3, (int) (j3 & (-1)));
    }

    public UInt32Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }
}
