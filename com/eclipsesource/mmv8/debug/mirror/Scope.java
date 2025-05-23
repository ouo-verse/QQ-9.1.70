package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.V8Value;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Scope extends Mirror {
    private static final String SCOPE_OBJECT = "scopeObject";
    private static final String SCOPE_TYPE = "scopeType";
    private static final String SET_VARIABLE_VALUE = "setVariableValue";

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum ScopeType {
        Global(0),
        Local(1),
        With(2),
        Closure(3),
        Catch(4),
        Block(5),
        Script(6);

        int index;

        ScopeType(int i3) {
            this.index = i3;
        }
    }

    public Scope(V8Object v8Object) {
        super(v8Object);
    }

    public ObjectMirror getScopeObject() {
        V8Object v8Object = null;
        try {
            v8Object = this.v8Object.executeObjectFunction(SCOPE_OBJECT, null);
            return (ObjectMirror) Mirror.createMirror(v8Object);
        } finally {
            if (v8Object != null) {
                v8Object.release();
            }
        }
    }

    public ScopeType getType() {
        return ScopeType.values()[this.v8Object.executeIntegerFunction(SCOPE_TYPE, null)];
    }

    public void setVariableValue(String str, int i3) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        v8Array.push(i3);
        try {
            this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void setVariableValue(String str, V8Value v8Value) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        v8Array.push(v8Value);
        try {
            this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void setVariableValue(String str, boolean z16) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        v8Array.push(z16);
        try {
            this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void setVariableValue(String str, String str2) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        v8Array.push(str2);
        try {
            this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void setVariableValue(String str, double d16) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        v8Array.push(d16);
        try {
            this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
        } finally {
            v8Array.release();
        }
    }
}
