package com.eclipsesource.mmv8.debug;

import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Function;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.V8Value;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DebugHandler implements Releasable {
    private static final String CHANGE_BREAK_POINT_CONDITION = "changeBreakPointCondition";
    private static final String CLEAR_BREAK_POINT = "clearBreakPoint";
    private static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
    public static String DEBUG_OBJECT_NAME = "__j2v8_Debug";
    private static final String DISABLE_ALL_BREAK_POINTS = "disableAllBreakPoints";
    private static final String DISABLE_SCRIPT_BREAK_POINT = "disableScriptBreakPoint";
    private static final String ENABLE_SCRIPT_BREAK_POINT = "enableScriptBreakPoint";
    private static final String FIND_SCRIPT_BREAK_POINT = "findScriptBreakPoint";
    private static final String NUMBER = "number";
    private static final String SCRIPT_BREAK_POINTS = "scriptBreakPoints";
    private static final String SET_BREAK_POINT = "setBreakPoint";
    private static final String SET_LISTENER = "setListener";
    private static final String SET_SCRIPT_BREAK_POINT_BY_NAME = "setScriptBreakPointByName";
    private static final String V8_DEBUG_OBJECT = "Debug";
    private List<BreakHandler> breakHandlers = new ArrayList();
    private V8Object debugObject;
    private V8 runtime;

    /* compiled from: P */
    /* renamed from: com.eclipsesource.mmv8.debug.DebugHandler$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$eclipsesource$mmv8$debug$DebugHandler$DebugEvent;

        static {
            int[] iArr = new int[DebugEvent.values().length];
            $SwitchMap$com$eclipsesource$mmv8$debug$DebugHandler$DebugEvent = iArr;
            try {
                iArr[DebugEvent.Break.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$eclipsesource$mmv8$debug$DebugHandler$DebugEvent[DebugEvent.BeforeCompile.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$eclipsesource$mmv8$debug$DebugHandler$DebugEvent[DebugEvent.AfterCompile.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$eclipsesource$mmv8$debug$DebugHandler$DebugEvent[DebugEvent.Exception.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class BreakpointHandler implements JavaVoidCallback {
        BreakpointHandler() {
        }

        private EventData createDebugEvent(DebugEvent debugEvent, V8Object v8Object) {
            int i3 = AnonymousClass1.$SwitchMap$com$eclipsesource$mmv8$debug$DebugHandler$DebugEvent[debugEvent.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return new EventData(v8Object);
                        }
                        return new ExceptionEvent(v8Object);
                    }
                    return new CompileEvent(v8Object);
                }
                return new CompileEvent(v8Object);
            }
            return new BreakEvent(v8Object);
        }

        private void invokeHandler(V8Array v8Array, int i3, BreakHandler breakHandler) {
            V8Object v8Object;
            ExecutionState executionState;
            V8Object v8Object2;
            ExecutionState executionState2;
            V8Object object;
            V8Object v8Object3 = null;
            EventData eventData = null;
            try {
                object = v8Array.getObject(1);
                try {
                    v8Object2 = v8Array.getObject(2);
                    try {
                        v8Object = v8Array.getObject(3);
                    } catch (Throwable th5) {
                        th = th5;
                        v8Object = null;
                        executionState = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    v8Object = null;
                    executionState = null;
                    v8Object2 = null;
                    executionState2 = null;
                }
                try {
                    executionState2 = new ExecutionState(object);
                } catch (Throwable th7) {
                    th = th7;
                    executionState = null;
                    executionState2 = executionState;
                    v8Object3 = object;
                    safeRelease(v8Object3);
                    safeRelease(v8Object2);
                    safeRelease(v8Object);
                    safeRelease(executionState2);
                    safeRelease(executionState);
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
                v8Object = null;
                executionState = null;
                v8Object2 = null;
                executionState2 = null;
            }
            try {
                DebugEvent debugEvent = DebugEvent.values()[i3];
                eventData = createDebugEvent(debugEvent, v8Object2);
                breakHandler.onBreak(debugEvent, executionState2, eventData, v8Object);
                safeRelease(object);
                safeRelease(v8Object2);
                safeRelease(v8Object);
                safeRelease(executionState2);
                safeRelease(eventData);
            } catch (Throwable th9) {
                th = th9;
                executionState = eventData;
                v8Object3 = object;
                safeRelease(v8Object3);
                safeRelease(v8Object2);
                safeRelease(v8Object);
                safeRelease(executionState2);
                safeRelease(executionState);
                throw th;
            }
        }

        private void safeRelease(Releasable releasable) {
            if (releasable != null) {
                releasable.release();
            }
        }

        @Override // com.eclipsesource.mmv8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            if (v8Array != null && !v8Array.isUndefined()) {
                int integer = v8Array.getInteger(0);
                Iterator it = DebugHandler.this.breakHandlers.iterator();
                while (it.hasNext()) {
                    invokeHandler(v8Array, integer, (BreakHandler) it.next());
                }
            }
        }

        public /* synthetic */ BreakpointHandler(DebugHandler debugHandler, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum DebugEvent {
        Undefined(0),
        Break(1),
        Exception(2),
        NewFunction(3),
        BeforeCompile(4),
        AfterCompile(5),
        CompileError(6),
        PromiseError(7),
        AsyncTaskEvent(8);

        int index;

        DebugEvent(int i3) {
            this.index = i3;
        }
    }

    public DebugHandler(V8 v85) {
        this.runtime = v85;
        setupDebugObject(v85);
        setupBreakpointHandler();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.eclipsesource.mmv8.debug.DebugHandler$1] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.eclipsesource.mmv8.V8Value] */
    /* JADX WARN: Type inference failed for: r1v4 */
    private void setupBreakpointHandler() {
        V8Array v8Array;
        V8Function v8Function;
        ?? r16 = 0;
        V8Array v8Array2 = null;
        this.debugObject.registerJavaMethod(new BreakpointHandler(this, r16), DEBUG_BREAK_HANDLER);
        try {
            v8Function = (V8Function) this.debugObject.getObject(DEBUG_BREAK_HANDLER);
        } catch (Throwable th5) {
            th = th5;
            v8Array = null;
        }
        try {
            v8Array2 = new V8Array(this.runtime).push((V8Value) v8Function);
            this.debugObject.executeFunction(SET_LISTENER, v8Array2);
            if (v8Function != null && !v8Function.isReleased()) {
                v8Function.release();
            }
            if (v8Array2 != null && !v8Array2.isReleased()) {
                v8Array2.release();
            }
        } catch (Throwable th6) {
            th = th6;
            V8Array v8Array3 = v8Array2;
            r16 = v8Function;
            v8Array = v8Array3;
            if (r16 != 0 && !r16.isReleased()) {
                r16.release();
            }
            if (v8Array != null && !v8Array.isReleased()) {
                v8Array.release();
            }
            throw th;
        }
    }

    private void setupDebugObject(V8 v85) {
        V8Object object = v85.getObject(DEBUG_OBJECT_NAME);
        try {
            this.debugObject = object.getObject("Debug");
        } finally {
            object.release();
        }
    }

    public void addBreakHandler(BreakHandler breakHandler) {
        this.runtime.getLocker().checkThread();
        this.breakHandlers.add(breakHandler);
    }

    public void changeBreakPointCondition(int i3, String str) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i3);
        v8Array.push(str);
        try {
            this.debugObject.executeVoidFunction(CHANGE_BREAK_POINT_CONDITION, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void clearBreakPoint(int i3) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i3);
        try {
            this.debugObject.executeVoidFunction(CLEAR_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void disableAllBreakPoints() {
        this.debugObject.executeVoidFunction(DISABLE_ALL_BREAK_POINTS, null);
    }

    public void disableScriptBreakPoint(int i3) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i3);
        try {
            this.debugObject.executeVoidFunction(DISABLE_SCRIPT_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void enableScriptBreakPoint(int i3) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i3);
        try {
            this.debugObject.executeVoidFunction(ENABLE_SCRIPT_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public ScriptBreakPoint getScriptBreakPoint(int i3) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i3);
        v8Array.push(false);
        V8Object v8Object = null;
        try {
            v8Object = this.debugObject.executeObjectFunction(FIND_SCRIPT_BREAK_POINT, v8Array);
            return new ScriptBreakPoint(v8Object);
        } finally {
            v8Array.release();
            if (v8Object != null) {
                v8Object.release();
            }
        }
    }

    public int getScriptBreakPointCount() {
        V8Array executeArrayFunction = this.debugObject.executeArrayFunction(SCRIPT_BREAK_POINTS, null);
        try {
            return executeArrayFunction.length();
        } finally {
            executeArrayFunction.release();
        }
    }

    public int[] getScriptBreakPointIDs() {
        V8Array executeArrayFunction = this.debugObject.executeArrayFunction(SCRIPT_BREAK_POINTS, null);
        try {
            int[] iArr = new int[executeArrayFunction.length()];
            for (int i3 = 0; i3 < executeArrayFunction.length(); i3++) {
                V8Object object = executeArrayFunction.getObject(i3);
                try {
                    iArr[i3] = object.executeIntegerFunction("number", null);
                    object.release();
                } finally {
                }
            }
            return iArr;
        } finally {
            executeArrayFunction.release();
        }
    }

    @Override // com.eclipsesource.mmv8.Releasable
    public void release() {
        this.debugObject.release();
    }

    public void removeBreakHandler(BreakHandler breakHandler) {
        this.runtime.getLocker().checkThread();
        this.breakHandlers.remove(breakHandler);
    }

    public int setBreakpoint(V8Function v8Function) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push((V8Value) v8Function);
        try {
            return this.debugObject.executeIntegerFunction(SET_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public int setScriptBreakpoint(String str, int i3) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(str);
        v8Array.push(i3);
        try {
            return this.debugObject.executeIntegerFunction(SET_SCRIPT_BREAK_POINT_BY_NAME, v8Array);
        } finally {
            v8Array.release();
        }
    }
}
