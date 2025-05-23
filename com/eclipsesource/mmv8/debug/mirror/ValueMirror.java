package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.V8Object;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ValueMirror extends Mirror {
    private static final String VALUE = "value";

    public ValueMirror(V8Object v8Object) {
        super(v8Object);
    }

    public Object getValue() {
        return this.v8Object.executeFunction("value", null);
    }

    @Override // com.eclipsesource.mmv8.debug.mirror.Mirror
    public boolean isValue() {
        return true;
    }
}
