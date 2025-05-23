package com.eclipsesource.mmv8;

import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8Object extends V8Value {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Undefined extends V8Object {
        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object add(String str, boolean z16) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object addUndefined(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public boolean contains(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Value
        public boolean equals(Object obj) {
            if ((obj instanceof V8Object) && ((V8Object) obj).isUndefined()) {
                return true;
            }
            return false;
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Array executeArrayFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public boolean executeBooleanFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public double executeDoubleFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public Object executeFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public int executeIntegerFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public Object executeJSFunction(String str, Object... objArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object executeObjectFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public String executeStringFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public void executeVoidFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Array getArray(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public boolean getBoolean(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public double getDouble(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public int getInteger(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public String[] getKeys() {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object getObject(String str) throws V8ResultUndefined {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Value
        public V8 getRuntime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public String getString(String str) throws V8ResultUndefined {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public int getType(String str) throws V8ResultUndefined {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Value
        public int hashCode() {
            return 919;
        }

        @Override // com.eclipsesource.mmv8.V8Value
        public boolean isReleased() {
            return false;
        }

        @Override // com.eclipsesource.mmv8.V8Value
        public boolean isUndefined() {
            return true;
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object setPrototype(V8Object v8Object) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public String toString() {
            return "undefined";
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object add(String str, double d16) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object add(String str, int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z16) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object, com.eclipsesource.mmv8.V8Value
        public Undefined twin() {
            return (Undefined) super.twin();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object add(String str, String str2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object add(String str, V8Value v8Value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Value, com.eclipsesource.mmv8.Releasable
        public void release() {
        }
    }

    public V8Object(V8 v85) {
        this(v85, null);
    }

    private void checkKey(String str) {
        if (str != null) {
        } else {
            throw new IllegalArgumentException("Key cannot be null");
        }
    }

    public V8Object add(String str, int i3) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        v85.add(v85.getV8RuntimePtr(), this.objectHandle, str, i3);
        return this;
    }

    public V8Object addNull(String str) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        v85.addNull(v85.getV8RuntimePtr(), this.objectHandle, str);
        return this;
    }

    public V8Object addUndefined(String str) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        v85.addUndefined(v85.getV8RuntimePtr(), this.objectHandle, str);
        return this;
    }

    public boolean contains(String str) {
        this.f32585v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v85 = this.f32585v8;
        return v85.contains(v85.getV8RuntimePtr(), this.objectHandle, str);
    }

    @Override // com.eclipsesource.mmv8.V8Value
    public V8Value createTwin() {
        return new V8Object(this.f32585v8);
    }

    public V8Array executeArrayFunction(String str, V8Array v8Array) {
        long handle;
        this.f32585v8.checkThread();
        checkReleased();
        this.f32585v8.checkRuntime(v8Array);
        if (v8Array == null) {
            handle = 0;
        } else {
            handle = v8Array.getHandle();
        }
        V8 v85 = this.f32585v8;
        Object executeFunction = v85.executeFunction(v85.getV8RuntimePtr(), 5, this.objectHandle, str, handle);
        if (executeFunction instanceof V8Array) {
            return (V8Array) executeFunction;
        }
        throw new V8ResultUndefined();
    }

    public boolean executeBooleanFunction(String str, V8Array v8Array) {
        long handle;
        this.f32585v8.checkThread();
        checkReleased();
        this.f32585v8.checkRuntime(v8Array);
        if (v8Array == null) {
            handle = 0;
        } else {
            handle = v8Array.getHandle();
        }
        V8 v85 = this.f32585v8;
        return v85.executeBooleanFunction(v85.getV8RuntimePtr(), getHandle(), str, handle);
    }

    public double executeDoubleFunction(String str, V8Array v8Array) {
        long handle;
        this.f32585v8.checkThread();
        checkReleased();
        this.f32585v8.checkRuntime(v8Array);
        if (v8Array == null) {
            handle = 0;
        } else {
            handle = v8Array.getHandle();
        }
        V8 v85 = this.f32585v8;
        return v85.executeDoubleFunction(v85.getV8RuntimePtr(), getHandle(), str, handle);
    }

    public Object executeFunction(String str, V8Array v8Array) {
        long handle;
        this.f32585v8.checkThread();
        checkReleased();
        this.f32585v8.checkRuntime(v8Array);
        if (v8Array == null) {
            handle = 0;
        } else {
            handle = v8Array.getHandle();
        }
        V8 v85 = this.f32585v8;
        return v85.executeFunction(v85.getV8RuntimePtr(), 0, this.objectHandle, str, handle);
    }

    public int executeIntegerFunction(String str, V8Array v8Array) {
        long handle;
        this.f32585v8.checkThread();
        checkReleased();
        this.f32585v8.checkRuntime(v8Array);
        if (v8Array == null) {
            handle = 0;
        } else {
            handle = v8Array.getHandle();
        }
        V8 v85 = this.f32585v8;
        return v85.executeIntegerFunction(v85.getV8RuntimePtr(), getHandle(), str, handle);
    }

    public Object executeJSFunction(String str) {
        return executeFunction(str, null);
    }

    public V8Object executeObjectFunction(String str, V8Array v8Array) {
        long handle;
        this.f32585v8.checkThread();
        checkReleased();
        this.f32585v8.checkRuntime(v8Array);
        if (v8Array == null) {
            handle = 0;
        } else {
            handle = v8Array.getHandle();
        }
        V8 v85 = this.f32585v8;
        Object executeFunction = v85.executeFunction(v85.getV8RuntimePtr(), 6, this.objectHandle, str, handle);
        if (executeFunction instanceof V8Object) {
            return (V8Object) executeFunction;
        }
        throw new V8ResultUndefined();
    }

    public String executeStringFunction(String str, V8Array v8Array) {
        long handle;
        this.f32585v8.checkThread();
        checkReleased();
        this.f32585v8.checkRuntime(v8Array);
        if (v8Array == null) {
            handle = 0;
        } else {
            handle = v8Array.getHandle();
        }
        V8 v85 = this.f32585v8;
        return v85.executeStringFunction(v85.getV8RuntimePtr(), getHandle(), str, handle);
    }

    public void executeVoidFunction(String str, V8Array v8Array) {
        long handle;
        this.f32585v8.checkThread();
        checkReleased();
        this.f32585v8.checkRuntime(v8Array);
        if (v8Array == null) {
            handle = 0;
        } else {
            handle = v8Array.getHandle();
        }
        V8 v85 = this.f32585v8;
        v85.executeVoidFunction(v85.getV8RuntimePtr(), this.objectHandle, str, handle);
    }

    public Object get(String str) {
        this.f32585v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v85 = this.f32585v8;
        return v85.get(v85.getV8RuntimePtr(), 6, this.objectHandle, str);
    }

    public V8Array getArray(String str) {
        this.f32585v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v85 = this.f32585v8;
        Object obj = v85.get(v85.getV8RuntimePtr(), 5, this.objectHandle, str);
        if (obj != null && !(obj instanceof V8Array)) {
            throw new V8ResultUndefined();
        }
        return (V8Array) obj;
    }

    public boolean getBoolean(String str) {
        this.f32585v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v85 = this.f32585v8;
        return v85.getBoolean(v85.getV8RuntimePtr(), this.objectHandle, str);
    }

    public double getDouble(String str) {
        this.f32585v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v85 = this.f32585v8;
        return v85.getDouble(v85.getV8RuntimePtr(), this.objectHandle, str);
    }

    public int getInteger(String str) {
        this.f32585v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v85 = this.f32585v8;
        return v85.getInteger(v85.getV8RuntimePtr(), this.objectHandle, str);
    }

    public String[] getKeys() {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.getKeys(v85.getV8RuntimePtr(), this.objectHandle);
    }

    public V8Object getObject(String str) {
        this.f32585v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v85 = this.f32585v8;
        Object obj = v85.get(v85.getV8RuntimePtr(), 6, this.objectHandle, str);
        if (obj != null && !(obj instanceof V8Object)) {
            throw new V8ResultUndefined();
        }
        return (V8Object) obj;
    }

    public String getString(String str) {
        this.f32585v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v85 = this.f32585v8;
        return v85.getString(v85.getV8RuntimePtr(), this.objectHandle, str);
    }

    public int getType(String str) {
        this.f32585v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v85 = this.f32585v8;
        return v85.getType(v85.getV8RuntimePtr(), this.objectHandle, str);
    }

    public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
        this.f32585v8.checkThread();
        checkReleased();
        this.f32585v8.registerCallback(javaCallback, getHandle(), str);
        return this;
    }

    public V8Object setPrototype(V8Object v8Object) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        v85.setPrototype(v85.getV8RuntimePtr(), this.objectHandle, v8Object.getHandle());
        return this;
    }

    public String toString() {
        if (!isReleased() && !this.f32585v8.isReleased()) {
            this.f32585v8.checkThread();
            V8 v85 = this.f32585v8;
            return v85.toString(v85.getV8RuntimePtr(), getHandle());
        }
        return "[Object released]";
    }

    public V8Object(V8 v85, Object obj) {
        super(v85);
        if (v85 != null) {
            this.f32585v8.checkThread();
            initialize(this.f32585v8.getV8RuntimePtr(), obj);
        }
    }

    public Object executeJSFunction(String str, Object... objArr) {
        if (objArr == null) {
            return executeFunction(str, null);
        }
        V8Array v8Array = new V8Array(this.f32585v8.getRuntime());
        try {
            for (Object obj : objArr) {
                if (obj == null) {
                    v8Array.pushNull();
                } else if (obj instanceof V8Value) {
                    v8Array.push((V8Value) obj);
                } else if (obj instanceof Integer) {
                    v8Array.push((Integer) obj);
                } else if (obj instanceof Double) {
                    v8Array.push((Double) obj);
                } else if (obj instanceof Long) {
                    v8Array.push(((Long) obj).doubleValue());
                } else if (obj instanceof Float) {
                    v8Array.push(((Float) obj).floatValue());
                } else if (obj instanceof Boolean) {
                    v8Array.push((Boolean) obj);
                } else if (obj instanceof String) {
                    v8Array.push((String) obj);
                } else {
                    throw new IllegalArgumentException("Unsupported Object of type: " + obj.getClass());
                }
            }
            return executeFunction(str, v8Array);
        } finally {
            v8Array.release();
        }
    }

    @Override // com.eclipsesource.mmv8.V8Value
    public V8Object twin() {
        return (V8Object) super.twin();
    }

    public V8Object add(String str, boolean z16) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        v85.add(v85.getV8RuntimePtr(), this.objectHandle, str, z16);
        return this;
    }

    public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
        this.f32585v8.checkThread();
        checkReleased();
        this.f32585v8.registerVoidCallback(javaVoidCallback, getHandle(), str);
        return this;
    }

    public V8Object() {
    }

    public V8Object add(String str, double d16) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        v85.add(v85.getV8RuntimePtr(), this.objectHandle, str, d16);
        return this;
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr) {
        return registerJavaMethod(obj, str, str2, clsArr, false);
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z16) {
        this.f32585v8.checkThread();
        checkReleased();
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            this.f32585v8.registerCallback(obj, method, getHandle(), str2, z16);
            return this;
        } catch (NoSuchMethodException e16) {
            throw new IllegalStateException(e16);
        } catch (SecurityException e17) {
            throw new IllegalStateException(e17);
        }
    }

    public V8Object add(String str, String str2) {
        this.f32585v8.checkThread();
        checkReleased();
        if (str2 == null) {
            V8 v85 = this.f32585v8;
            v85.addNull(v85.getV8RuntimePtr(), this.objectHandle, str);
        } else if (str2.equals(V8.getUndefined())) {
            V8 v86 = this.f32585v8;
            v86.addUndefined(v86.getV8RuntimePtr(), this.objectHandle, str);
        } else {
            V8 v87 = this.f32585v8;
            v87.add(v87.getV8RuntimePtr(), this.objectHandle, str, str2);
        }
        return this;
    }

    public V8Object add(String str, V8Value v8Value) {
        this.f32585v8.checkThread();
        checkReleased();
        this.f32585v8.checkRuntime(v8Value);
        if (v8Value == null) {
            V8 v85 = this.f32585v8;
            v85.addNull(v85.getV8RuntimePtr(), this.objectHandle, str);
        } else if (v8Value.equals(V8.getUndefined())) {
            V8 v86 = this.f32585v8;
            v86.addUndefined(v86.getV8RuntimePtr(), this.objectHandle, str);
        } else {
            V8 v87 = this.f32585v8;
            v87.addObject(v87.getV8RuntimePtr(), this.objectHandle, str, v8Value.getHandle());
        }
        return this;
    }
}
