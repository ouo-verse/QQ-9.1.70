package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.V8Object;

/* compiled from: P */
/* loaded from: classes2.dex */
public class StringMirror extends ValueMirror {
    public StringMirror(V8Object v8Object) {
        super(v8Object);
    }

    @Override // com.eclipsesource.mmv8.debug.mirror.Mirror
    public boolean isString() {
        return true;
    }

    @Override // com.eclipsesource.mmv8.debug.mirror.Mirror
    public String toString() {
        return this.v8Object.executeStringFunction("toText", null);
    }
}
