package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;

/* loaded from: classes2.dex */
public class PropertiesArray implements Releasable {
    private V8Array v8Array;

    public PropertiesArray(V8Array v8Array) {
        this.v8Array = v8Array.twin();
    }

    public PropertyMirror getProperty(int i3) {
        V8Object object = this.v8Array.getObject(i3);
        try {
            return new PropertyMirror(object);
        } finally {
            object.release();
        }
    }

    public int length() {
        return this.v8Array.length();
    }

    @Override // com.eclipsesource.mmv8.Releasable
    public void release() {
        if (!this.v8Array.isReleased()) {
            this.v8Array.release();
        }
    }
}
