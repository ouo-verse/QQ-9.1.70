package com.eclipsesource.mmv8.debug;

import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.debug.DebugHandler;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface BreakHandler {
    void onBreak(DebugHandler.DebugEvent debugEvent, ExecutionState executionState, EventData eventData, V8Object v8Object);
}
