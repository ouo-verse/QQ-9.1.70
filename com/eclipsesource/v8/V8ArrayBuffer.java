package com.eclipsesource.v8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8ArrayBuffer extends V8Value {
    ByteBuffer byteBuffer;

    public V8ArrayBuffer(V8 v85, int i3) {
        super(v85);
        initialize(v85.getV8RuntimePtr(), Integer.valueOf(i3));
        ByteBuffer createV8ArrayBufferBackingStore = v85.createV8ArrayBufferBackingStore(v85.getV8RuntimePtr(), this.objectHandle, i3);
        this.byteBuffer = createV8ArrayBufferBackingStore;
        createV8ArrayBufferBackingStore.order(ByteOrder.nativeOrder());
    }

    public final byte[] array() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.array();
    }

    public final int arrayOffset() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.arrayOffset();
    }

    public final int capacity() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.capacity();
    }

    public final V8ArrayBuffer clear() {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.clear();
        return this;
    }

    public V8ArrayBuffer compact() {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.compact();
        return this;
    }

    @Override // com.eclipsesource.v8.V8Value
    protected V8Value createTwin() {
        return new V8ArrayBuffer(this.f32589v8, this.byteBuffer);
    }

    public int doubleLimit() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.asDoubleBuffer().limit();
    }

    public final V8ArrayBuffer flip() {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.flip();
        return this;
    }

    public int floatLimit() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.asFloatBuffer().limit();
    }

    public byte get() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.get();
    }

    public char getChar() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.getChar();
    }

    public double getDouble() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.getDouble();
    }

    public float getFloat() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.getFloat();
    }

    public int getInt() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.getInt();
    }

    public long getLong() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.getLong();
    }

    public short getShort() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.getShort();
    }

    public final boolean hasArray() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.hasArray();
    }

    public final boolean hasRemaining() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.hasRemaining();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.eclipsesource.v8.V8Value
    public void initialize(long j3, Object obj) {
        this.f32589v8.checkThread();
        if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            int limit = byteBuffer.limit();
            V8 v85 = this.f32589v8;
            this.objectHandle = v85.initNewV8ArrayBuffer(v85.getV8RuntimePtr(), byteBuffer, limit);
        } else {
            int intValue = ((Integer) obj).intValue();
            V8 v86 = this.f32589v8;
            this.objectHandle = v86.initNewV8ArrayBuffer(v86.getV8RuntimePtr(), intValue);
        }
        this.released = false;
        addObjectReference(this.objectHandle);
    }

    public int intLimit() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.asIntBuffer().limit();
    }

    public boolean isDirect() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.isDirect();
    }

    public boolean isReadOnly() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.isReadOnly();
    }

    public int limit() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.limit();
    }

    public final V8ArrayBuffer mark() {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.mark();
        return this;
    }

    public final ByteOrder order() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.order();
    }

    public final int position() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.position();
    }

    public V8ArrayBuffer put(byte b16) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.put(b16);
        return this;
    }

    public V8ArrayBuffer putChar(char c16) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.putChar(c16);
        return this;
    }

    public V8ArrayBuffer putDouble(double d16) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.putDouble(d16);
        return this;
    }

    public V8ArrayBuffer putFloat(float f16) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.putFloat(f16);
        return this;
    }

    public V8ArrayBuffer putInt(int i3) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.putInt(i3);
        return this;
    }

    public V8ArrayBuffer putLong(long j3) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.putLong(j3);
        return this;
    }

    public V8ArrayBuffer putShort(short s16) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.putShort(s16);
        return this;
    }

    public final int remaining() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.remaining();
    }

    public final V8ArrayBuffer reset() {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.reset();
        return this;
    }

    public final V8ArrayBuffer rewind() {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.rewind();
        return this;
    }

    public int shortLimit() {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.asShortBuffer().limit();
    }

    @Override // com.eclipsesource.v8.V8Value
    public V8ArrayBuffer twin() {
        this.f32589v8.checkThread();
        checkReleased();
        return (V8ArrayBuffer) super.twin();
    }

    public byte get(int i3) {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.get(i3);
    }

    public char getChar(int i3) {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.getChar(i3);
    }

    public double getDouble(int i3) {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.getDouble(i3);
    }

    public float getFloat(int i3) {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.getFloat(i3);
    }

    public int getInt(int i3) {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.getInt(i3);
    }

    public long getLong(int i3) {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.getLong(i3);
    }

    public short getShort(int i3) {
        this.f32589v8.checkThread();
        checkReleased();
        return this.byteBuffer.getShort(i3);
    }

    public final V8ArrayBuffer limit(int i3) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.limit(i3);
        return this;
    }

    public final V8ArrayBuffer order(ByteOrder byteOrder) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.order(byteOrder);
        return this;
    }

    public final V8ArrayBuffer position(int i3) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.position(i3);
        return this;
    }

    public V8ArrayBuffer put(int i3, byte b16) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.put(i3, b16);
        return this;
    }

    public V8ArrayBuffer putChar(int i3, char c16) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.putChar(i3, c16);
        return this;
    }

    public V8ArrayBuffer putDouble(int i3, double d16) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.putDouble(i3, d16);
        return this;
    }

    public V8ArrayBuffer putFloat(int i3, float f16) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.putFloat(i3, f16);
        return this;
    }

    public V8ArrayBuffer putInt(int i3, int i16) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.asIntBuffer().put(i3, i16);
        return this;
    }

    public V8ArrayBuffer putLong(int i3, long j3) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.putLong(i3, j3);
        return this;
    }

    public V8ArrayBuffer putShort(int i3, short s16) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.putShort(i3, s16);
        return this;
    }

    public V8ArrayBuffer(V8 v85, ByteBuffer byteBuffer) {
        super(v85);
        byteBuffer = byteBuffer == null ? ByteBuffer.allocateDirect(0) : byteBuffer;
        if (byteBuffer.isDirect()) {
            initialize(v85.getV8RuntimePtr(), byteBuffer);
            this.byteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.nativeOrder());
            return;
        }
        throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
    }

    public V8ArrayBuffer get(byte[] bArr, int i3, int i16) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.get(bArr, i3, i16);
        return this;
    }

    public V8ArrayBuffer put(ByteBuffer byteBuffer) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.put(byteBuffer);
        return this;
    }

    public V8ArrayBuffer get(byte[] bArr) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.get(bArr);
        return this;
    }

    public V8ArrayBuffer put(byte[] bArr, int i3, int i16) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.put(bArr, i3, i16);
        return this;
    }

    public final V8ArrayBuffer put(byte[] bArr) {
        this.f32589v8.checkThread();
        checkReleased();
        this.byteBuffer.put(bArr);
        return this;
    }
}
