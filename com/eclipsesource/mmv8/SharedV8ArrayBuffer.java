package com.eclipsesource.mmv8;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SharedV8ArrayBuffer extends V8ArrayBuffer {
    SharedV8ArrayBuffer(V8 v85, int i3) {
        super(v85, i3);
        throw new IllegalArgumentException("not support this way construct");
    }

    @Override // com.eclipsesource.mmv8.V8ArrayBuffer, com.eclipsesource.mmv8.V8Value
    public void initialize(long j3, Object obj) {
        this.f32585v8.checkThread();
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        int limit = byteBuffer.limit();
        V8 v85 = this.f32585v8;
        long initNewSharedV8ArrayBuffer = v85.initNewSharedV8ArrayBuffer(v85.getV8RuntimePtr(), byteBuffer, limit);
        this.objectHandle = initNewSharedV8ArrayBuffer;
        this.released = false;
        addObjectReference(initNewSharedV8ArrayBuffer);
    }

    public void manualRelease() {
        super.release();
    }

    public SharedV8ArrayBuffer(V8 v85, @NonNull ByteBuffer byteBuffer) {
        super(v85, byteBuffer);
    }

    @Override // com.eclipsesource.mmv8.V8Value, com.eclipsesource.mmv8.Releasable
    public void release() {
    }
}
