package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.V8Object;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ArrayMirror extends ObjectMirror {
    private static final String LENGTH = "length";

    public ArrayMirror(V8Object v8Object) {
        super(v8Object);
    }

    @Override // com.eclipsesource.mmv8.debug.mirror.Mirror
    public boolean isArray() {
        return true;
    }

    public int length() {
        return this.v8Object.executeIntegerFunction(LENGTH, null);
    }
}
