package com.eclipsesource.mmv8.debug.mirror;

import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Frame extends Mirror {
    private static final String ARGUMENT_COUNT = "argumentCount";
    private static final String ARGUMENT_NAME = "argumentName";
    private static final String ARGUMENT_VALUE = "argumentValue";
    private static final String COLUMN = "column";
    private static final String FUNC = "func";
    private static final String LINE = "line";
    private static final String LOCAL_COUNT = "localCount";
    private static final String LOCAL_NAME = "localName";
    private static final String LOCAL_VALUE = "localValue";
    private static final String NAME = "name";
    private static final String POSITION = "position";
    private static final String SCOPE = "scope";
    private static final String SCOPE_COUNT = "scopeCount";
    private static final String SCRIPT = "script";
    private static final String SOURCE_LOCATION = "sourceLocation";
    private static final String SOURCE_TEXT = "sourceText";

    public Frame(V8Object v8Object) {
        super(v8Object);
    }

    public int getArgumentCount() {
        return this.v8Object.executeIntegerFunction(ARGUMENT_COUNT, null);
    }

    public String getArgumentName(int i3) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i3);
        try {
            return this.v8Object.executeStringFunction(ARGUMENT_NAME, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public ValueMirror getArgumentValue(int i3) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i3);
        Releasable releasable = null;
        try {
            V8Object executeObjectFunction = this.v8Object.executeObjectFunction(ARGUMENT_VALUE, v8Array);
            if (Mirror.isValue(executeObjectFunction)) {
                ValueMirror valueMirror = new ValueMirror(executeObjectFunction);
                v8Array.release();
                if (executeObjectFunction != null) {
                    executeObjectFunction.release();
                }
                return valueMirror;
            }
            throw new IllegalStateException("Argument value is not a ValueMirror");
        } catch (Throwable th5) {
            v8Array.release();
            if (0 != 0) {
                releasable.release();
            }
            throw th5;
        }
    }

    public FunctionMirror getFunction() {
        V8Object v8Object = null;
        try {
            v8Object = this.v8Object.executeObjectFunction(FUNC, null);
            return new FunctionMirror(v8Object);
        } finally {
            if (v8Object != null) {
                v8Object.release();
            }
        }
    }

    public int getLocalCount() {
        return this.v8Object.executeIntegerFunction(LOCAL_COUNT, null);
    }

    public String getLocalName(int i3) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i3);
        try {
            return this.v8Object.executeStringFunction(LOCAL_NAME, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public ValueMirror getLocalValue(int i3) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i3);
        Releasable releasable = null;
        try {
            V8Object executeObjectFunction = this.v8Object.executeObjectFunction(LOCAL_VALUE, v8Array);
            if (Mirror.isValue(executeObjectFunction)) {
                ValueMirror createMirror = Mirror.createMirror(executeObjectFunction);
                v8Array.release();
                if (executeObjectFunction != null) {
                    executeObjectFunction.release();
                }
                return createMirror;
            }
            throw new IllegalStateException("Local value is not a ValueMirror");
        } catch (Throwable th5) {
            v8Array.release();
            if (0 != 0) {
                releasable.release();
            }
            throw th5;
        }
    }

    public Scope getScope(int i3) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i3);
        V8Object v8Object = null;
        try {
            v8Object = this.v8Object.executeObjectFunction("scope", v8Array);
            return new Scope(v8Object);
        } finally {
            v8Array.release();
            if (v8Object != null) {
                v8Object.release();
            }
        }
    }

    public int getScopeCount() {
        return this.v8Object.executeIntegerFunction(SCOPE_COUNT, null);
    }

    public SourceLocation getSourceLocation() {
        String str = null;
        V8Object executeObjectFunction = this.v8Object.executeObjectFunction(SOURCE_LOCATION, null);
        FunctionMirror function = getFunction();
        String scriptName = function.getScriptName();
        try {
            V8Object v8Object = (V8Object) executeObjectFunction.get(SCRIPT);
            if (v8Object != null) {
                str = v8Object.getString("name");
                v8Object.release();
            }
            if (str != null || scriptName == null) {
                scriptName = "undefined";
            }
            return new SourceLocation(scriptName, executeObjectFunction.getInteger("position"), executeObjectFunction.getInteger(LINE), executeObjectFunction.getInteger("column"), executeObjectFunction.getString(SOURCE_TEXT));
        } finally {
            function.release();
            executeObjectFunction.release();
        }
    }

    @Override // com.eclipsesource.mmv8.debug.mirror.Mirror
    public boolean isFrame() {
        return true;
    }
}
