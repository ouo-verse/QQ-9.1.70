package com.eclipsesource.mmv8.debug;

import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.V8ResultUndefined;

/* loaded from: classes2.dex */
public class ScriptBreakPoint implements Releasable {
    private static final String CONDITION = "condition";
    private static final String LINE = "line";
    private static final String NUMBER = "number";
    private static final String SET_CONDITION = "setCondition";
    private V8Object v8Object;

    public ScriptBreakPoint(V8Object v8Object) {
        this.v8Object = v8Object.twin();
    }

    public int getBreakPointNumber() {
        return this.v8Object.executeIntegerFunction("number", null);
    }

    public String getCondition() {
        try {
            return this.v8Object.executeStringFunction(CONDITION, null);
        } catch (V8ResultUndefined unused) {
            return "undefined";
        }
    }

    public int getLine() {
        return this.v8Object.executeIntegerFunction(LINE, null);
    }

    @Override // com.eclipsesource.mmv8.Releasable
    public void release() {
        V8Object v8Object = this.v8Object;
        if (v8Object != null && !v8Object.isReleased()) {
            this.v8Object.release();
            this.v8Object = null;
        }
    }

    public void setCondition(String str) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        try {
            this.v8Object.executeVoidFunction(SET_CONDITION, v8Array);
        } finally {
            v8Array.release();
        }
    }
}
