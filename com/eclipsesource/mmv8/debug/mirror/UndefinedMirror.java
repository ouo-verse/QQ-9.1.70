package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.V8Object;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UndefinedMirror extends ValueMirror {
    public UndefinedMirror(V8Object v8Object) {
        super(v8Object);
    }

    @Override // com.eclipsesource.mmv8.debug.mirror.Mirror
    public boolean isUndefined() {
        return true;
    }

    @Override // com.eclipsesource.mmv8.debug.mirror.Mirror
    public String toString() {
        return "undefined";
    }
}
