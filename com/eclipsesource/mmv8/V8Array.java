package com.eclipsesource.mmv8;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8Array extends V8Object {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Undefined extends V8Array {
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
        public int executeIntegerFunction(String str, V8Array v8Array) {
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

        @Override // com.eclipsesource.mmv8.V8Array
        public Object get(int i3) {
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

        @Override // com.eclipsesource.mmv8.V8Array
        public boolean[] getBooleans(int i3, int i16) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public byte getByte(int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public byte[] getBytes(int i3, int i16) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public double getDouble(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public double[] getDoubles(int i3, int i16) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public int getInteger(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public int[] getIntegers(int i3, int i16) {
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

        @Override // com.eclipsesource.mmv8.V8Array
        public String[] getStrings(int i3, int i16) {
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

        @Override // com.eclipsesource.mmv8.V8Array
        public int length() {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public V8Array push(boolean z16) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public V8Array pushUndefined() {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object setPrototype(V8Object v8Object) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array, com.eclipsesource.mmv8.V8Object
        public String toString() {
            return "undefined";
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object add(String str, double d16) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public V8Array getArray(int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public boolean getBoolean(int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public int getBooleans(int i3, int i16, boolean[] zArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public int getBytes(int i3, int i16, byte[] bArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public double getDouble(int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public int getDoubles(int i3, int i16, double[] dArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public int getInteger(int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public int getIntegers(int i3, int i16, int[] iArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public V8Object getObject(int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public String getString(int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public int getStrings(int i3, int i16, String[] strArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public int getType() {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public V8Array push(double d16) {
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

        @Override // com.eclipsesource.mmv8.V8Array
        public int getType(int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public V8Array push(int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z16) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object add(String str, String str2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public int getType(int i3, int i16) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public V8Array push(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array, com.eclipsesource.mmv8.V8Object, com.eclipsesource.mmv8.V8Value
        public Undefined twin() {
            return (Undefined) super.twin();
        }

        @Override // com.eclipsesource.mmv8.V8Object
        public V8Object add(String str, V8Value v8Value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Array
        public V8Array push(V8Value v8Value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.eclipsesource.mmv8.V8Value, com.eclipsesource.mmv8.Releasable
        public void release() {
        }
    }

    public V8Array() {
    }

    @Override // com.eclipsesource.mmv8.V8Object, com.eclipsesource.mmv8.V8Value
    public V8Value createTwin() {
        return new V8Array(this.f32585v8);
    }

    public Object get(int i3) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.arrayGet(v85.getV8RuntimePtr(), 6, this.objectHandle, i3);
    }

    public V8Array getArray(int i3) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        Object arrayGet = v85.arrayGet(v85.getV8RuntimePtr(), 5, this.objectHandle, i3);
        if (arrayGet != null && !(arrayGet instanceof V8Array)) {
            throw new V8ResultUndefined();
        }
        return (V8Array) arrayGet;
    }

    public boolean getBoolean(int i3) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.arrayGetBoolean(v85.getV8RuntimePtr(), getHandle(), i3);
    }

    public boolean[] getBooleans(int i3, int i16) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.arrayGetBooleans(v85.getV8RuntimePtr(), getHandle(), i3, i16);
    }

    public byte getByte(int i3) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.arrayGetByte(v85.getV8RuntimePtr(), getHandle(), i3);
    }

    public byte[] getBytes(int i3, int i16) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.arrayGetBytes(v85.getV8RuntimePtr(), getHandle(), i3, i16);
    }

    public double getDouble(int i3) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.arrayGetDouble(v85.getV8RuntimePtr(), getHandle(), i3);
    }

    public double[] getDoubles(int i3, int i16) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.arrayGetDoubles(v85.getV8RuntimePtr(), getHandle(), i3, i16);
    }

    public int getInteger(int i3) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.arrayGetInteger(v85.getV8RuntimePtr(), getHandle(), i3);
    }

    public int[] getIntegers(int i3, int i16) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.arrayGetIntegers(v85.getV8RuntimePtr(), getHandle(), i3, i16);
    }

    public V8Object getObject(int i3) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        Object arrayGet = v85.arrayGet(v85.getV8RuntimePtr(), 6, this.objectHandle, i3);
        if (arrayGet != null && !(arrayGet instanceof V8Object)) {
            throw new V8ResultUndefined();
        }
        return (V8Object) arrayGet;
    }

    public String getString(int i3) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.arrayGetString(v85.getV8RuntimePtr(), getHandle(), i3);
    }

    public String[] getStrings(int i3, int i16) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.arrayGetStrings(v85.getV8RuntimePtr(), getHandle(), i3, i16);
    }

    public int getType(int i3) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.getType(v85.getV8RuntimePtr(), getHandle(), i3);
    }

    @Override // com.eclipsesource.mmv8.V8Value
    public void initialize(long j3, Object obj) {
        long initNewV8Array = this.f32585v8.initNewV8Array(j3);
        this.released = false;
        addObjectReference(initNewV8Array);
    }

    public int length() {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.arrayGetSize(v85.getV8RuntimePtr(), getHandle());
    }

    public V8Array push(int i3) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        v85.addArrayIntItem(v85.getV8RuntimePtr(), getHandle(), i3);
        return this;
    }

    public V8Array pushNull() {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        v85.addArrayNullItem(v85.getV8RuntimePtr(), getHandle());
        return this;
    }

    public V8Array pushUndefined() {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        v85.addArrayUndefinedItem(v85.getV8RuntimePtr(), getHandle());
        return this;
    }

    @Override // com.eclipsesource.mmv8.V8Object
    public String toString() {
        if (!this.released && !this.f32585v8.isReleased()) {
            return super.toString();
        }
        return "[Array released]";
    }

    public V8Array(V8 v85) {
        super(v85);
        v85.checkThread();
    }

    @Override // com.eclipsesource.mmv8.V8Object, com.eclipsesource.mmv8.V8Value
    public V8Array twin() {
        return (V8Array) super.twin();
    }

    public V8Array(V8 v85, Object obj) {
        super(v85, obj);
    }

    public int getBooleans(int i3, int i16, boolean[] zArr) {
        this.f32585v8.checkThread();
        checkReleased();
        if (i16 <= zArr.length) {
            V8 v85 = this.f32585v8;
            return v85.arrayGetBooleans(v85.getV8RuntimePtr(), getHandle(), i3, i16, zArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getBytes(int i3, int i16, byte[] bArr) {
        this.f32585v8.checkThread();
        checkReleased();
        if (i16 <= bArr.length) {
            V8 v85 = this.f32585v8;
            return v85.arrayGetBytes(v85.getV8RuntimePtr(), getHandle(), i3, i16, bArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getDoubles(int i3, int i16, double[] dArr) {
        this.f32585v8.checkThread();
        checkReleased();
        if (i16 <= dArr.length) {
            V8 v85 = this.f32585v8;
            return v85.arrayGetDoubles(v85.getV8RuntimePtr(), getHandle(), i3, i16, dArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getIntegers(int i3, int i16, int[] iArr) {
        this.f32585v8.checkThread();
        checkReleased();
        if (i16 <= iArr.length) {
            V8 v85 = this.f32585v8;
            return v85.arrayGetIntegers(v85.getV8RuntimePtr(), getHandle(), i3, i16, iArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getStrings(int i3, int i16, String[] strArr) {
        this.f32585v8.checkThread();
        checkReleased();
        if (i16 <= strArr.length) {
            V8 v85 = this.f32585v8;
            return v85.arrayGetStrings(v85.getV8RuntimePtr(), getHandle(), i3, i16, strArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getType() {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.getArrayType(v85.getV8RuntimePtr(), getHandle());
    }

    public V8Array push(boolean z16) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        v85.addArrayBooleanItem(v85.getV8RuntimePtr(), getHandle(), z16);
        return this;
    }

    public int getType(int i3, int i16) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        return v85.getType(v85.getV8RuntimePtr(), getHandle(), i3, i16);
    }

    public V8Array push(double d16) {
        this.f32585v8.checkThread();
        checkReleased();
        V8 v85 = this.f32585v8;
        v85.addArrayDoubleItem(v85.getV8RuntimePtr(), getHandle(), d16);
        return this;
    }

    public V8Array push(String str) {
        this.f32585v8.checkThread();
        checkReleased();
        if (str == null) {
            V8 v85 = this.f32585v8;
            v85.addArrayNullItem(v85.getV8RuntimePtr(), getHandle());
        } else if (str.equals(V8.getUndefined())) {
            V8 v86 = this.f32585v8;
            v86.addArrayUndefinedItem(v86.getV8RuntimePtr(), getHandle());
        } else {
            V8 v87 = this.f32585v8;
            v87.addArrayStringItem(v87.getV8RuntimePtr(), getHandle(), str);
        }
        return this;
    }

    public V8Array push(V8Value v8Value) {
        this.f32585v8.checkThread();
        checkReleased();
        this.f32585v8.checkRuntime(v8Value);
        if (v8Value == null) {
            V8 v85 = this.f32585v8;
            v85.addArrayNullItem(v85.getV8RuntimePtr(), getHandle());
        } else if (v8Value.equals(V8.getUndefined())) {
            V8 v86 = this.f32585v8;
            v86.addArrayUndefinedItem(v86.getV8RuntimePtr(), getHandle());
        } else {
            V8 v87 = this.f32585v8;
            v87.addArrayObjectItem(v87.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
        }
        return this;
    }

    public V8Array push(Object obj) {
        this.f32585v8.checkThread();
        checkReleased();
        if (obj instanceof V8Value) {
            this.f32585v8.checkRuntime((V8Value) obj);
        }
        if (obj == null) {
            V8 v85 = this.f32585v8;
            v85.addArrayNullItem(v85.getV8RuntimePtr(), getHandle());
        } else if (obj.equals(V8.getUndefined())) {
            V8 v86 = this.f32585v8;
            v86.addArrayUndefinedItem(v86.getV8RuntimePtr(), getHandle());
        } else if (obj instanceof Double) {
            V8 v87 = this.f32585v8;
            v87.addArrayDoubleItem(v87.getV8RuntimePtr(), getHandle(), ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            V8 v88 = this.f32585v8;
            v88.addArrayIntItem(v88.getV8RuntimePtr(), getHandle(), ((Integer) obj).intValue());
        } else if (obj instanceof Float) {
            V8 v89 = this.f32585v8;
            v89.addArrayDoubleItem(v89.getV8RuntimePtr(), getHandle(), ((Float) obj).doubleValue());
        } else if (obj instanceof Number) {
            V8 v810 = this.f32585v8;
            v810.addArrayDoubleItem(v810.getV8RuntimePtr(), getHandle(), ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            V8 v811 = this.f32585v8;
            v811.addArrayBooleanItem(v811.getV8RuntimePtr(), getHandle(), ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            V8 v812 = this.f32585v8;
            v812.addArrayStringItem(v812.getV8RuntimePtr(), getHandle(), (String) obj);
        } else if (obj instanceof V8Value) {
            V8 v813 = this.f32585v8;
            v813.addArrayObjectItem(v813.getV8RuntimePtr(), getHandle(), ((V8Value) obj).getHandle());
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }
}
