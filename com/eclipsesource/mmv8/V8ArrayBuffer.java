package com.eclipsesource.mmv8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8ArrayBuffer extends V8Value {
    private ByteBuffer byteBuffer;

    public V8ArrayBuffer(V8 v85, int i3) {
        super(v85);
        initialize(v85.getV8RuntimePtr(), Integer.valueOf(i3));
        ByteBuffer createV8ArrayBufferBackingStore = v85.createV8ArrayBufferBackingStore(v85.getV8RuntimePtr(), this.objectHandle, i3);
        this.byteBuffer = createV8ArrayBufferBackingStore;
        createV8ArrayBufferBackingStore.order(ByteOrder.nativeOrder());
    }

    @Override // com.eclipsesource.mmv8.V8Value
    public V8Value createTwin() {
        return new V8ArrayBuffer(this.f32585v8, this.byteBuffer);
    }

    public ByteBuffer getBackingStore() {
        this.f32585v8.checkReleased();
        this.f32585v8.checkThread();
        return this.byteBuffer;
    }

    @Override // com.eclipsesource.mmv8.V8Value
    public void initialize(long j3, Object obj) {
        this.f32585v8.checkThread();
        if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            int limit = byteBuffer.limit();
            V8 v85 = this.f32585v8;
            this.objectHandle = v85.initNewV8ArrayBuffer(v85.getV8RuntimePtr(), byteBuffer, limit);
        } else {
            int intValue = ((Integer) obj).intValue();
            V8 v86 = this.f32585v8;
            this.objectHandle = v86.initNewV8ArrayBuffer(v86.getV8RuntimePtr(), intValue);
        }
        this.released = false;
        addObjectReference(this.objectHandle);
    }

    @Override // com.eclipsesource.mmv8.V8Value
    public V8ArrayBuffer twin() {
        return (V8ArrayBuffer) super.twin();
    }

    public V8ArrayBuffer(V8 v85, ByteBuffer byteBuffer) {
        this(v85, byteBuffer, false);
    }

    public V8ArrayBuffer(V8 v85, ByteBuffer byteBuffer, boolean z16) {
        super(v85);
        if (byteBuffer.isDirect()) {
            initialize(v85.getV8RuntimePtr(), byteBuffer);
            if (z16) {
                this.byteBuffer = byteBuffer;
            } else {
                this.byteBuffer = v85.getBackingStore(v85.getV8RuntimePtr(), this.objectHandle);
            }
            ByteBuffer byteBuffer2 = this.byteBuffer;
            if (byteBuffer2 != null) {
                byteBuffer2.order(ByteOrder.nativeOrder());
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
    }
}
