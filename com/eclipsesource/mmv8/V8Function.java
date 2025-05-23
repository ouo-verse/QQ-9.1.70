package com.eclipsesource.mmv8;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8Function extends V8Object {
    public V8Function(V8 v85, JavaCallback javaCallback) {
        super(v85, javaCallback);
    }

    public Object call(V8Object v8Object, V8Array v8Array) {
        long handle;
        this.f32585v8.checkThread();
        checkReleased();
        this.f32585v8.checkRuntime(v8Object);
        this.f32585v8.checkRuntime(v8Array);
        if (v8Object == null) {
            v8Object = this.f32585v8;
        }
        if (v8Array == null) {
            handle = 0;
        } else {
            handle = v8Array.getHandle();
        }
        long j3 = handle;
        if (v8Object.isUndefined()) {
            v8Object = this.f32585v8;
        }
        long handle2 = v8Object.getHandle();
        V8 v85 = this.f32585v8;
        return v85.executeFunction(v85.getV8RuntimePtr(), handle2, this.objectHandle, j3);
    }

    @Override // com.eclipsesource.mmv8.V8Object, com.eclipsesource.mmv8.V8Value
    public V8Value createTwin() {
        return new V8Function(this.f32585v8);
    }

    @Override // com.eclipsesource.mmv8.V8Value
    public void initialize(long j3, Object obj) {
        if (obj == null) {
            super.initialize(j3, null);
            return;
        }
        long[] initNewV8Function = this.f32585v8.initNewV8Function(j3);
        this.f32585v8.createAndRegisterMethodDescriptor((JavaCallback) obj, initNewV8Function[1]);
        this.released = false;
        addObjectReference(initNewV8Function[0]);
    }

    @Override // com.eclipsesource.mmv8.V8Object
    public String toString() {
        if (!this.released && !this.f32585v8.isReleased()) {
            return super.toString();
        }
        return "[Function released]";
    }

    public V8Function(V8 v85) {
        this(v85, null);
    }

    @Override // com.eclipsesource.mmv8.V8Object, com.eclipsesource.mmv8.V8Value
    public V8Function twin() {
        return (V8Function) super.twin();
    }
}
