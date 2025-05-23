package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.V8Object;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FunctionMirror extends ObjectMirror {
    private static final String NAME = "name";
    private static final String SCRIPT = "script";

    public FunctionMirror(V8Object v8Object) {
        super(v8Object);
    }

    public String getName() {
        return this.v8Object.executeStringFunction("name", null);
    }

    public String getScriptName() {
        V8Object executeObjectFunction = this.v8Object.executeObjectFunction(SCRIPT, null);
        try {
            return executeObjectFunction.executeStringFunction("name", null);
        } finally {
            executeObjectFunction.release();
        }
    }

    @Override // com.eclipsesource.mmv8.debug.mirror.Mirror
    public boolean isFunction() {
        return true;
    }
}
