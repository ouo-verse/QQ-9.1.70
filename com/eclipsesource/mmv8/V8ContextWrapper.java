package com.eclipsesource.mmv8;

import androidx.annotation.NonNull;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class V8ContextWrapper implements InvocationHandler {
    private static final String TAG = "V8ContextWrapper";
    private final MultiContextV8 multiContextV8;
    private final V8Context proxy;
    private final V8ContextImpl v8ContextImpl;
    private final long v8ContextPtr;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public final class V8ContextImpl extends V8Object implements V8Context {
        private final long ptr;

        public V8ContextImpl(long j3) {
            super(V8ContextWrapper.this.multiContextV8.getV8());
            this.objectHandle = this.f32585v8.getGlobalObject();
            this.ptr = j3;
        }

        private void shareObjectImpl(String str, V8Context v8Context, String str2) {
            checkReleased();
            this.f32585v8.checkThread();
            if (str == null || str.isEmpty() || v8Context == null) {
                return;
            }
            V8Object object = getObject(str);
            if (str2 != null && !str2.isEmpty()) {
                str = str2;
            }
            v8Context.add(str, object);
            object.release();
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public Object batchExecuteScripts(ArrayList<V8ScriptEvaluateRequest> arrayList, String str, ExecuteDetails executeDetails) {
            return this.f32585v8.batchExecuteScripts(arrayList, str, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public V8Array executeArrayScript(String str, ExecuteDetails executeDetails) {
            return this.f32585v8.executeArrayScript(str, null, 0, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public boolean executeBooleanScript(String str, ExecuteDetails executeDetails) {
            return this.f32585v8.executeBooleanScript(str, null, 0, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public String executeDebugScript(String str, String str2) {
            return this.f32585v8.executeDebugScript(str, str2);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public double executeDoubleScript(String str, ExecuteDetails executeDetails) {
            return this.f32585v8.executeDoubleScript(str, null, 0, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public Object executeFileScript(V8ScriptFileDescriptor v8ScriptFileDescriptor, String str, int i3, String str2, String str3, int i16, ExecuteDetails executeDetails) {
            return this.f32585v8.executeFileScript(v8ScriptFileDescriptor, str, i3, str2, str3, i16, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public int executeIntegerScript(String str, ExecuteDetails executeDetails) {
            return this.f32585v8.executeIntegerScript(str, null, 0, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public V8Object executeObjectScript(String str, ExecuteDetails executeDetails) {
            return this.f32585v8.executeObjectScript(str, null, 0, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public Object executeScript(String str, ExecuteDetails executeDetails) {
            return this.f32585v8.executeScript(str, null, 0, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public String executeStringScript(String str, ExecuteDetails executeDetails) {
            return this.f32585v8.executeStringScript(str, null, 0, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public void executeVoidScript(String str, ExecuteDetails executeDetails) {
            this.f32585v8.executeVoidScript(str, null, 0, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public long getPtr() {
            return this.ptr;
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public SharedV8ArrayBuffer newSharedV8ArrayBuffer(@NonNull InSandboxByteBuffer inSandboxByteBuffer) {
            V8 v85 = this.f32585v8;
            ByteBuffer asByteBuffer = inSandboxByteBuffer.asByteBuffer();
            Objects.requireNonNull(asByteBuffer);
            return new SharedV8ArrayBuffer(v85, asByteBuffer);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public V8Array newV8Array() {
            return new V8Array(this.f32585v8);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public V8ArrayBuffer newV8ArrayBuffer(int i3) {
            return new V8ArrayBuffer(this.f32585v8, i3);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public V8Function newV8Function(JavaCallback javaCallback) {
            return new V8Function(this.f32585v8, javaCallback);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public V8Object newV8Object() {
            return new V8Object(this.f32585v8);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public V8TypedArray newV8TypedArray(V8ArrayBuffer v8ArrayBuffer, int i3, int i16, int i17) {
            return new V8TypedArray(this.f32585v8, v8ArrayBuffer, i3, i16, i17);
        }

        @Override // com.eclipsesource.mmv8.V8Value, com.eclipsesource.mmv8.Releasable
        public void release() {
            if (isReleased()) {
                return;
            }
            this.f32585v8.releaseObjRef(this);
            V8ContextWrapper.this.multiContextV8.releaseContext(V8ContextWrapper.this);
            this.released = true;
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public void shareObject(String str, V8Context v8Context) {
            shareObjectImpl(str, v8Context, null);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public V8Array executeArrayScript(String str, String str2, int i3, ExecuteDetails executeDetails) {
            return this.f32585v8.executeArrayScript(str, str2, i3, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public boolean executeBooleanScript(String str, String str2, int i3, ExecuteDetails executeDetails) {
            return this.f32585v8.executeBooleanScript(str, str2, i3, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public double executeDoubleScript(String str, String str2, int i3, ExecuteDetails executeDetails) {
            return this.f32585v8.executeDoubleScript(str, str2, i3, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public int executeIntegerScript(String str, String str2, int i3, ExecuteDetails executeDetails) {
            return this.f32585v8.executeIntegerScript(str, str2, i3, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public V8Object executeObjectScript(String str, String str2, int i3, ExecuteDetails executeDetails) {
            return this.f32585v8.executeObjectScript(str, str2, i3, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public Object executeScript(String str, String str2, int i3, ExecuteDetails executeDetails) {
            return this.f32585v8.executeScript(str, str2, i3, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public String executeStringScript(String str, String str2, int i3, ExecuteDetails executeDetails) {
            return this.f32585v8.executeStringScript(str, str2, i3, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public void executeVoidScript(String str, String str2, int i3, ExecuteDetails executeDetails) {
            this.f32585v8.executeVoidScript(str, str2, i3, null, null, 0, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public SharedV8ArrayBuffer newSharedV8ArrayBuffer(@NonNull V8ArrayBuffer v8ArrayBuffer) {
            return new SharedV8ArrayBuffer(this.f32585v8, v8ArrayBuffer.getBackingStore());
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public V8ArrayBuffer newV8ArrayBuffer(ByteBuffer byteBuffer) {
            return new V8ArrayBuffer(this.f32585v8, byteBuffer);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public void shareObject(String str, V8Context v8Context, String str2) {
            shareObjectImpl(str, v8Context, str2);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public V8Array executeArrayScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
            return this.f32585v8.executeArrayScript(str, str2, i3, str3, str4, i16, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public boolean executeBooleanScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
            return this.f32585v8.executeBooleanScript(str, str2, i3, str3, str4, i16, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public double executeDoubleScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
            return this.f32585v8.executeDoubleScript(str, str2, i3, str3, str4, i16, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public int executeIntegerScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
            return this.f32585v8.executeIntegerScript(str, str2, i3, str3, str4, i16, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public V8Object executeObjectScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
            return this.f32585v8.executeObjectScript(str, str2, i3, str3, str4, i16, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public Object executeScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
            return this.f32585v8.executeScript(str, str2, i3, str3, str4, i16, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public String executeStringScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
            return this.f32585v8.executeStringScript(str, str2, i3, str3, str4, i16, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public void executeVoidScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
            this.f32585v8.executeVoidScript(str, str2, i3, str3, str4, i16, executeDetails);
        }

        @Override // com.eclipsesource.mmv8.V8Context
        public V8Object getGlobalObject() {
            return this;
        }
    }

    public V8ContextWrapper(MultiContextV8 multiContextV8, long j3) {
        this.multiContextV8 = multiContextV8;
        this.v8ContextPtr = j3;
        enterContext();
        this.v8ContextImpl = new V8ContextImpl(j3);
        this.proxy = (V8Context) Proxy.newProxyInstance(V8ContextWrapper.class.getClassLoader(), new Class[]{V8Context.class}, this);
    }

    private void enterContext() {
        this.multiContextV8.enterContext(this);
    }

    public V8Context context() {
        return this.proxy;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.v8ContextPtr == ((V8ContextWrapper) obj).v8ContextPtr) {
            return true;
        }
        return false;
    }

    public long getPtr() {
        return this.v8ContextPtr;
    }

    public int hashCode() {
        long j3 = this.v8ContextPtr;
        return (int) (j3 ^ (j3 >>> 32));
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (!method.getName().equals("isReleased")) {
            this.v8ContextImpl.checkReleased();
            enterContext();
        }
        try {
            return method.invoke(this.v8ContextImpl, objArr);
        } catch (InvocationTargetException e16) {
            throw e16.getCause();
        }
    }
}
