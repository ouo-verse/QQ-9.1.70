package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ObjectMirror extends ValueMirror {
    private static final String PROPERTIES = "properties";
    private static final String PROPERTY_NAMES = "propertyNames";

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum PropertyKind {
        Named(1),
        Indexed(2);

        int index;

        PropertyKind(int i3) {
            this.index = i3;
        }
    }

    public ObjectMirror(V8Object v8Object) {
        super(v8Object);
    }

    public PropertiesArray getProperties(PropertyKind propertyKind, int i3) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(propertyKind.index);
        v8Array.push(i3);
        V8Array v8Array2 = null;
        try {
            v8Array2 = this.v8Object.executeArrayFunction("properties", v8Array);
            return new PropertiesArray(v8Array2);
        } finally {
            v8Array.release();
            if (v8Array2 != null && !v8Array2.isReleased()) {
                v8Array2.release();
            }
        }
    }

    public String[] getPropertyNames(PropertyKind propertyKind, int i3) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(propertyKind.index);
        v8Array.push(i3);
        V8Array v8Array2 = null;
        try {
            v8Array2 = this.v8Object.executeArrayFunction(PROPERTY_NAMES, v8Array);
            int length = v8Array2.length();
            String[] strArr = new String[length];
            for (int i16 = 0; i16 < length; i16++) {
                strArr[i16] = v8Array2.getString(i16);
            }
            v8Array.release();
            v8Array2.release();
            return strArr;
        } catch (Throwable th5) {
            v8Array.release();
            if (v8Array2 != null) {
                v8Array2.release();
            }
            throw th5;
        }
    }

    @Override // com.eclipsesource.mmv8.debug.mirror.Mirror
    public boolean isObject() {
        return true;
    }

    @Override // com.eclipsesource.mmv8.debug.mirror.Mirror
    public String toString() {
        return this.v8Object.toString();
    }
}
