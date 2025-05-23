package com.eclipsesource.mmv8.utils.typedarrays;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Int8Array extends TypedArray {
    public Int8Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public byte get(int i3) {
        return this.buffer.get(i3);
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int getType() {
        return 9;
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int length() {
        return this.buffer.limit();
    }

    public void put(int i3, byte b16) {
        this.buffer.put(i3, b16);
    }

    public Int8Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }
}
