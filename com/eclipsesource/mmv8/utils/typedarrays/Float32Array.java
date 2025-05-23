package com.eclipsesource.mmv8.utils.typedarrays;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Float32Array extends TypedArray {
    public Float32Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public float get(int i3) {
        return this.buffer.asFloatBuffer().get(i3);
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int getType() {
        return 16;
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int length() {
        return this.buffer.asFloatBuffer().limit();
    }

    public void put(int i3, float f16) {
        this.buffer.asFloatBuffer().put(i3, f16);
    }

    public Float32Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }
}
