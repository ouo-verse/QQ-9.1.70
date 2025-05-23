package com.tencent.qqmini.v8rt.engine;

/* compiled from: P */
/* loaded from: classes23.dex */
public class V8JsRuntime {
    private V8JsContext defaultJsContext = new V8JsContext(this, 0);
    private int engineId;
    private IInspectorAgent inspectorAgent;
    private final JsRuntimeThread jsRuntimeThread;

    public V8JsRuntime(int i3, IInspectorAgent iInspectorAgent) {
        this.engineId = i3;
        this.jsRuntimeThread = new JsRuntimeThread(i3);
        this.inspectorAgent = iInspectorAgent;
    }

    public V8JsContext getDefaultContext() {
        return this.defaultJsContext;
    }

    public int getId() {
        return this.engineId;
    }

    public JsRuntimeThread getJsRuntimeThread() {
        return this.jsRuntimeThread;
    }

    public void release() {
        this.jsRuntimeThread.release();
        IInspectorAgent iInspectorAgent = this.inspectorAgent;
        if (iInspectorAgent != null) {
            iInspectorAgent.stop();
        }
        Engine.getInstance().removeJsRuntime(this);
    }
}
