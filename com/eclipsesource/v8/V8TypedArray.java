package com.eclipsesource.v8;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8TypedArray extends V8Array {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class V8ArrayData {
        private V8ArrayBuffer buffer;
        private int offset;
        private int size;
        private int type;

        public V8ArrayData(V8ArrayBuffer v8ArrayBuffer, int i3, int i16, int i17) {
            this.buffer = v8ArrayBuffer;
            this.offset = i3;
            this.size = i16;
            this.type = i17;
        }
    }

    public V8TypedArray(V8 v85, V8ArrayBuffer v8ArrayBuffer, int i3, int i16, int i17) {
        super(v85, new V8ArrayData(v8ArrayBuffer, i16, i17, i3));
    }

    private void checkArrayProperties(V8ArrayData v8ArrayData) {
        checkOffset(v8ArrayData);
        checkSize(v8ArrayData);
    }

    private void checkOffset(V8ArrayData v8ArrayData) {
        if (v8ArrayData.offset % getStructureSize(v8ArrayData.type) == 0) {
            return;
        }
        throw new IllegalStateException("RangeError: Start offset of Int32Array must be a multiple of " + getStructureSize(v8ArrayData.type));
    }

    private void checkSize(V8ArrayData v8ArrayData) {
        if (v8ArrayData.size >= 0) {
            if ((v8ArrayData.size * getStructureSize(v8ArrayData.type)) + v8ArrayData.offset <= v8ArrayData.buffer.limit()) {
                return;
            } else {
                throw new IllegalStateException("RangeError: Invalid typed array length");
            }
        }
        throw new IllegalStateException("RangeError: Invalid typed array length");
    }

    private long createTypedArray(long j3, V8ArrayData v8ArrayData) {
        int i3 = v8ArrayData.type;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 9) {
                    switch (i3) {
                        case 11:
                            return this.f32589v8.initNewV8UInt8Array(j3, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                        case 12:
                            return this.f32589v8.initNewV8UInt8ClampedArray(j3, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                        case 13:
                            return this.f32589v8.initNewV8Int16Array(j3, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                        case 14:
                            return this.f32589v8.initNewV8UInt16Array(j3, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                        case 15:
                            return this.f32589v8.initNewV8UInt32Array(j3, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                        case 16:
                            return this.f32589v8.initNewV8Float32Array(j3, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                        default:
                            throw new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(v8ArrayData.type));
                    }
                }
                return this.f32589v8.initNewV8Int8Array(j3, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
            }
            return this.f32589v8.initNewV8Float64Array(j3, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
        }
        return this.f32589v8.initNewV8Int32Array(j3, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
    }

    public static int getStructureSize(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 9) {
                    switch (i3) {
                        case 11:
                        case 12:
                            break;
                        case 13:
                        case 14:
                            return 2;
                        case 15:
                        case 16:
                            return 4;
                        default:
                            throw new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(i3));
                    }
                }
                return 1;
            }
            return 8;
        }
        return 4;
    }

    @Override // com.eclipsesource.v8.V8Array, com.eclipsesource.v8.V8Object, com.eclipsesource.v8.V8Value
    protected V8Value createTwin() {
        this.f32589v8.checkThread();
        checkReleased();
        return new V8TypedArray(this.f32589v8);
    }

    @Override // com.eclipsesource.v8.V8Array
    public Object get(int i3) {
        this.f32589v8.checkThread();
        checkReleased();
        int type = getType();
        if (type != 1) {
            if (type != 2) {
                if (type != 9) {
                    switch (type) {
                        case 11:
                            return Short.valueOf((short) (((Number) super.get(i3)).shortValue() & 255));
                        case 12:
                            return Short.valueOf((short) (((Number) super.get(i3)).byteValue() & 255));
                        case 13:
                            return Short.valueOf(((Number) super.get(i3)).shortValue());
                        case 14:
                            return Integer.valueOf(((Integer) super.get(i3)).intValue() & 65535);
                        case 15:
                            return Long.valueOf(((Number) super.get(i3)).longValue() & (-1));
                        case 16:
                            return Float.valueOf(((Number) super.get(i3)).floatValue());
                        default:
                            return null;
                    }
                }
                return Byte.valueOf(((Number) super.get(i3)).byteValue());
            }
            return super.get(i3);
        }
        return super.get(i3);
    }

    public V8ArrayBuffer getBuffer() {
        return (V8ArrayBuffer) get("buffer");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.eclipsesource.v8.V8Array, com.eclipsesource.v8.V8Value
    public void initialize(long j3, Object obj) {
        this.f32589v8.checkThread();
        if (obj == null) {
            super.initialize(j3, obj);
            return;
        }
        V8ArrayData v8ArrayData = (V8ArrayData) obj;
        checkArrayProperties(v8ArrayData);
        long createTypedArray = createTypedArray(j3, v8ArrayData);
        this.released = false;
        addObjectReference(createTypedArray);
    }

    V8TypedArray(V8 v85) {
        super(v85);
    }
}
