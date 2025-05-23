package com.eclipsesource.v8;

import com.tencent.mobileqq.mini.cache.Entry;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class V8Value implements Releasable {
    public static final int BOOLEAN = 3;
    public static final int BYTE = 9;
    public static final int DOUBLE = 2;
    public static final int FLOAT_32_ARRAY = 16;
    public static final int FLOAT_64_ARRAY = 2;
    public static final int INTEGER = 1;
    public static final int INT_16_ARRAY = 13;
    public static final int INT_32_ARRAY = 1;
    public static final int INT_8_ARRAY = 9;
    public static final int NULL = 0;
    public static final int STRING = 4;
    public static final int UNDEFINED = 99;
    public static final int UNKNOWN = 0;
    public static final int UNSIGNED_INT_16_ARRAY = 14;
    public static final int UNSIGNED_INT_32_ARRAY = 15;
    public static final int UNSIGNED_INT_8_ARRAY = 11;
    public static final int UNSIGNED_INT_8_CLAMPED_ARRAY = 12;
    public static final int V8_ARRAY = 5;
    public static final int V8_ARRAY_BUFFER = 10;
    public static final int V8_FUNCTION = 7;
    public static final int V8_OBJECT = 6;
    public static final int V8_TYPED_ARRAY = 8;
    protected long objectHandle;
    protected boolean released = true;

    /* renamed from: v8, reason: collision with root package name */
    protected V8 f32589v8;

    /* JADX INFO: Access modifiers changed from: protected */
    public V8Value() {
    }

    @Deprecated
    public static String getStringRepresentaion(int i3) {
        return getStringRepresentation(i3);
    }

    public static String getStringRepresentation(int i3) {
        if (i3 != 99) {
            switch (i3) {
                case 0:
                    return "Null";
                case 1:
                    return "Integer";
                case 2:
                    return "Double";
                case 3:
                    return "Boolean";
                case 4:
                    return Entry.DATA_TYPE_STRING;
                case 5:
                    return "V8Array";
                case 6:
                    return "V8Object";
                case 7:
                    return "V8Function";
                case 8:
                    return "V8TypedArray";
                case 9:
                    return "Byte";
                case 10:
                    return "V8ArrayBuffer";
                case 11:
                    return "UInt8Array";
                case 12:
                    return "UInt8ClampedArray";
                case 13:
                    return "Int16Array";
                case 14:
                    return "UInt16Array";
                case 15:
                    return "UInt32Array";
                case 16:
                    return "Float32Array";
                default:
                    throw new IllegalArgumentException("Invalid V8 type: " + i3);
            }
        }
        return "Undefined";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addObjectReference(long j3) throws Error {
        this.objectHandle = j3;
        try {
            this.f32589v8.addObjRef(this);
        } catch (Error e16) {
            release();
            throw e16;
        } catch (RuntimeException e17) {
            release();
            throw e17;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkReleased() {
        if (!this.released) {
        } else {
            throw new IllegalStateException("Object released");
        }
    }

    public V8Value clearWeak() {
        this.f32589v8.checkThread();
        this.f32589v8.checkReleased();
        this.f32589v8.v8WeakReferences.remove(Long.valueOf(getHandle()));
        V8 v85 = this.f32589v8;
        v85.clearWeak(v85.getV8RuntimePtr(), getHandle());
        return this;
    }

    @Override // com.eclipsesource.v8.Releasable, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f32589v8.checkThread();
        if (!this.released) {
            try {
                this.f32589v8.releaseObjRef(this);
            } finally {
                this.released = true;
                V8 v85 = this.f32589v8;
                v85.release(v85.getV8RuntimePtr(), this.objectHandle);
            }
        }
    }

    protected abstract V8Value createTwin();

    public boolean equals(Object obj) {
        return strictEquals(obj);
    }

    public String getConstructorName() {
        this.f32589v8.checkThread();
        this.f32589v8.checkReleased();
        V8 v85 = this.f32589v8;
        return v85.getConstructorName(v85.getV8RuntimePtr(), this.objectHandle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getHandle() {
        checkReleased();
        return this.objectHandle;
    }

    public V8 getRuntime() {
        return this.f32589v8;
    }

    public int getV8Type() {
        if (isUndefined()) {
            return 99;
        }
        this.f32589v8.checkThread();
        this.f32589v8.checkReleased();
        V8 v85 = this.f32589v8;
        return v85.getType(v85.getV8RuntimePtr(), this.objectHandle);
    }

    public int hashCode() {
        this.f32589v8.checkThread();
        checkReleased();
        V8 v85 = this.f32589v8;
        return v85.identityHash(v85.getV8RuntimePtr(), getHandle());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize(long j3, Object obj) {
        long initNewV8Object = this.f32589v8.initNewV8Object(j3);
        this.released = false;
        addObjectReference(initNewV8Object);
    }

    public boolean isReleased() {
        return this.released;
    }

    public boolean isUndefined() {
        return false;
    }

    public boolean isWeak() {
        this.f32589v8.checkThread();
        this.f32589v8.checkReleased();
        V8 v85 = this.f32589v8;
        return v85.isWeak(v85.getV8RuntimePtr(), getHandle());
    }

    public boolean jsEquals(Object obj) {
        this.f32589v8.checkThread();
        checkReleased();
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof V8Value)) {
            return false;
        }
        if (isUndefined() && ((V8Value) obj).isUndefined()) {
            return true;
        }
        V8Value v8Value = (V8Value) obj;
        if (v8Value.isUndefined()) {
            return false;
        }
        V8 v85 = this.f32589v8;
        return v85.equals(v85.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
    }

    @Override // com.eclipsesource.v8.Releasable
    @Deprecated
    public void release() {
        close();
    }

    public V8Value setWeak() {
        this.f32589v8.checkThread();
        this.f32589v8.checkReleased();
        this.f32589v8.v8WeakReferences.put(Long.valueOf(getHandle()), this);
        V8 v85 = this.f32589v8;
        v85.setWeak(v85.getV8RuntimePtr(), getHandle());
        return this;
    }

    public boolean strictEquals(Object obj) {
        this.f32589v8.checkThread();
        checkReleased();
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof V8Value)) {
            return false;
        }
        if (isUndefined() && ((V8Value) obj).isUndefined()) {
            return true;
        }
        V8Value v8Value = (V8Value) obj;
        if (v8Value.isUndefined()) {
            return false;
        }
        V8 v85 = this.f32589v8;
        return v85.strictEquals(v85.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
    }

    public V8Value twin() {
        if (isUndefined()) {
            return this;
        }
        this.f32589v8.checkThread();
        this.f32589v8.checkReleased();
        V8Value createTwin = createTwin();
        this.f32589v8.createTwin(this, createTwin);
        return createTwin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public V8Value(V8 v85) {
        if (v85 == null) {
            this.f32589v8 = (V8) this;
        } else {
            this.f32589v8 = v85;
        }
    }
}
