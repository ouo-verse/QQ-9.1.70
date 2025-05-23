package com.eclipsesource.mmv8.utils.typedarrays;

import com.eclipsesource.mmv8.V8TypedArray;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class TypedArray {
    protected ByteBuffer buffer;

    public TypedArray(ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
            if (byteBuffer.limit() % V8TypedArray.getStructureSize(getType()) == 0) {
                this.buffer = byteBuffer;
                return;
            }
            throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
        }
        throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
    }

    public ByteBuffer getByteBuffer() {
        return this.buffer;
    }

    public abstract int getType();

    public abstract int length();
}
