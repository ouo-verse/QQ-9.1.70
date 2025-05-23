package com.eclipsesource.v8.inspector;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8Inspector {
    private long inspectorPtr;
    private V8 runtime;
    private boolean waitingForConnection = true;
    private List<DebuggerConnectionListener> debuggerConnectionListeners = new ArrayList();

    protected V8Inspector(V8 v85, V8InspectorDelegate v8InspectorDelegate, String str) {
        this.inspectorPtr = 0L;
        this.runtime = v85;
        this.inspectorPtr = v85.createInspector(v8InspectorDelegate, str);
    }

    public static V8Inspector createV8Inspector(V8 v85, V8InspectorDelegate v8InspectorDelegate, String str) {
        return new V8Inspector(v85, v8InspectorDelegate, str);
    }

    private void verifyDebuggerConnection(String str) {
        V8Object v8Object = null;
        try {
            v8Object = this.runtime.executeObjectScript("JSON.parse(JSON.stringify(" + str + "))");
            if (v8Object.getString("method").equals("Runtime.runIfWaitingForDebugger")) {
                this.waitingForConnection = false;
                this.runtime.schedulePauseOnNextStatement(this.inspectorPtr, "");
                Iterator<DebuggerConnectionListener> it = this.debuggerConnectionListeners.iterator();
                while (it.hasNext()) {
                    it.next().onDebuggerConnected();
                }
            }
            v8Object.close();
        } catch (Throwable th5) {
            if (v8Object != null) {
                v8Object.close();
            }
            throw th5;
        }
    }

    public void addDebuggerConnectionListener(DebuggerConnectionListener debuggerConnectionListener) {
        this.debuggerConnectionListeners.add(debuggerConnectionListener);
    }

    public void dispatchProtocolMessage(String str) {
        try {
            this.runtime.dispatchProtocolMessage(this.inspectorPtr, str);
            if (this.waitingForConnection) {
                verifyDebuggerConnection(str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void removeDebuggerConnectionListener(DebuggerConnectionListener debuggerConnectionListener) {
        this.debuggerConnectionListeners.remove(debuggerConnectionListener);
    }

    public static V8Inspector createV8Inspector(V8 v85, V8InspectorDelegate v8InspectorDelegate) {
        return new V8Inspector(v85, v8InspectorDelegate, null);
    }
}
