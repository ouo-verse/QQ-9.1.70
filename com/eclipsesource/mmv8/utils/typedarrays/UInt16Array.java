package com.eclipsesource.mmv8.utils.typedarrays;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UInt16Array extends TypedArray {
    public UInt16Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public int get(int i3) {
        return this.buffer.asShortBuffer().get(i3) & 65535;
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int getType() {
        return 14;
    }

    @Override // com.eclipsesource.mmv8.utils.typedarrays.TypedArray
    public int length() {
        return this.buffer.asShortBuffer().limit();
    }

    public void put(int i3, int i16) {
        this.buffer.asShortBuffer().put(i3, (short) (i16 & 65535));
    }

    public UInt16Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }
}
