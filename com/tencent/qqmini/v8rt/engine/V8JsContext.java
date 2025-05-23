package com.tencent.qqmini.v8rt.engine;

import android.os.ConditionVariable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class V8JsContext {
    public static final int DEFAULT_CONTEXT_ID = 0;
    private int contextId;
    private final String sTAG;
    private V8JsRuntime v8JsRuntime;

    public V8JsContext(V8JsRuntime v8JsRuntime, int i3) {
        this.v8JsRuntime = v8JsRuntime;
        this.contextId = i3;
        this.sTAG = "V8JsCt-" + v8JsRuntime.getId() + "-" + i3;
    }

    private JsRuntimeThread getJsRunner() {
        return this.v8JsRuntime.getJsRuntimeThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$garbageCollect$0() {
        V8JsBridge.nativeGarbageCollect(this.v8JsRuntime.getId(), this.contextId);
    }

    public void cleanGlobal() {
        JsRuntimeLoader.cleanGlobal(this);
    }

    public Object convertPtrJsonString(final long j3) {
        if (getJsRunner().isReleased()) {
            Logger.e(this.sTAG, "convertPtrJsonString fail, thread released");
            return 0;
        }
        final ConditionVariable conditionVariable = new ConditionVariable();
        final ValueCallback valueCallback = new ValueCallback(null) { // from class: com.tencent.qqmini.v8rt.engine.V8JsContext.8
            @Override // com.tencent.qqmini.v8rt.engine.Callback
            public void onFinish(Object obj) {
                this.value = obj;
                conditionVariable.open();
            }
        };
        getJsRunner().run(this, new Runnable() { // from class: com.tencent.qqmini.v8rt.engine.V8JsContext.9
            @Override // java.lang.Runnable
            public void run() {
                valueCallback.onFinish(V8JsBridge.jniPtrJsonString(j3, V8JsContext.this.contextId));
            }
        });
        conditionVariable.block();
        return valueCallback.value;
    }

    public void evaluateJsAsync(final String str, final Callback callback) {
        if (getJsRunner().isReleased()) {
            Logger.e(this.sTAG, "evaluateJsAsync fail, thread released");
        } else {
            getJsRunner().run(this, new Runnable() { // from class: com.tencent.qqmini.v8rt.engine.V8JsContext.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        V8JsBridge.jniEvalJs(V8JsContext.this.v8JsRuntime.getId(), V8JsContext.this.contextId, str);
                        Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.onFinish(null);
                        }
                    } catch (Throwable th5) {
                        Logger.e(V8JsContext.this.sTAG, "evaluateJsAsync error " + th5.getMessage());
                    }
                }
            });
        }
    }

    public void evaluateJsAsyncWithCodeCache(final String str, final Callback callback, final String str2, final String str3) {
        if (getJsRunner().isReleased()) {
            Logger.e(this.sTAG, "evaluateJsAsync fail, thread released");
        } else {
            getJsRunner().run(this, new Runnable() { // from class: com.tencent.qqmini.v8rt.engine.V8JsContext.5
                @Override // java.lang.Runnable
                public void run() {
                    Engine.loadScriptStringWithCodeCache(V8JsContext.this.v8JsRuntime.getId(), V8JsContext.this.contextId, str, str2, str3);
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onFinish(null);
                    }
                }
            });
        }
    }

    public void evaluateJsAsyncWithReturn(final String str, final Callback callback) {
        getJsRunner().run(this, new Runnable() { // from class: com.tencent.qqmini.v8rt.engine.V8JsContext.4
            @Override // java.lang.Runnable
            public void run() {
                callback.onFinish(V8JsBridge.jniEvalJsWithReturn(V8JsContext.this.v8JsRuntime.getId(), V8JsContext.this.contextId, str));
            }
        });
    }

    public void evaluateJsAsyncWithReturnPtr(final String str, final Callback callback) {
        if (getJsRunner().isReleased()) {
            Logger.e(this.sTAG, "evaluateJsAsyncWithReturnPtr fail, thread released");
        } else {
            getJsRunner().run(this, new Runnable() { // from class: com.tencent.qqmini.v8rt.engine.V8JsContext.7
                @Override // java.lang.Runnable
                public void run() {
                    long jniEvalJsWithReturnPtr = V8JsBridge.jniEvalJsWithReturnPtr(V8JsContext.this.v8JsRuntime.getId(), V8JsContext.this.contextId, str);
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onFinish(Long.valueOf(jniEvalJsWithReturnPtr));
                    }
                }
            });
        }
    }

    public void evaluateJsSync(String str) {
        if (getJsRunner().isReleased()) {
            Logger.e(this.sTAG, "evaluateJsSync fail, thread released");
            return;
        }
        final ConditionVariable conditionVariable = new ConditionVariable();
        evaluateJsAsync(str, new Callback() { // from class: com.tencent.qqmini.v8rt.engine.V8JsContext.1
            @Override // com.tencent.qqmini.v8rt.engine.Callback
            public void onFinish(Object obj) {
                conditionVariable.open();
            }
        });
        conditionVariable.block();
    }

    public long evaluateJsWithReturnPtrSync(String str) {
        if (getJsRunner().isReleased()) {
            Logger.e(this.sTAG, "evaluateJsWithReturnSync fail, thread released");
            return 0L;
        }
        final ConditionVariable conditionVariable = new ConditionVariable();
        ValueCallback valueCallback = new ValueCallback(null) { // from class: com.tencent.qqmini.v8rt.engine.V8JsContext.6
            @Override // com.tencent.qqmini.v8rt.engine.Callback
            public void onFinish(Object obj) {
                this.value = obj;
                conditionVariable.open();
            }
        };
        evaluateJsAsyncWithReturnPtr(str, valueCallback);
        conditionVariable.block();
        return ((Long) valueCallback.value).longValue();
    }

    public Object evaluateJsWithReturnSync(String str) {
        Object obj = null;
        if (getJsRunner().isReleased()) {
            Logger.e(this.sTAG, "evaluateJsWithReturnSync fail, thread released");
            return null;
        }
        final ConditionVariable conditionVariable = new ConditionVariable();
        ValueCallback valueCallback = new ValueCallback(obj) { // from class: com.tencent.qqmini.v8rt.engine.V8JsContext.3
            @Override // com.tencent.qqmini.v8rt.engine.Callback
            public void onFinish(Object obj2) {
                this.value = obj2;
                conditionVariable.open();
            }
        };
        evaluateJsAsyncWithReturn(str, valueCallback);
        conditionVariable.block();
        return valueCallback.value;
    }

    public void garbageCollect() {
        if (getJsRunner().isReleased()) {
            Logger.e(this.sTAG, "garbageCollect fail, thread released");
        } else {
            getJsRunner().run(this, new Runnable() { // from class: com.tencent.qqmini.v8rt.engine.a
                @Override // java.lang.Runnable
                public final void run() {
                    V8JsContext.this.lambda$garbageCollect$0();
                }
            });
        }
    }

    public int getContextId() {
        return this.contextId;
    }

    public V8JsRuntime getV8JsRuntime() {
        return this.v8JsRuntime;
    }

    public void injectAll() {
        injectGlobalConfig();
        injectConsole();
        injectTimer();
        injectJsBridge();
        cleanGlobal();
    }

    public void injectConsole() {
        Engine.nativeInjectConsole(this.v8JsRuntime.getId(), this.contextId);
        JsRuntimeLoader.injectBasicJs(Engine.getInstance().mEnginePathProvider, new String[]{"console.js"}, this);
    }

    public void injectGlobalConfig() {
        JsRuntimeLoader.injectGlobalConfig(this);
    }

    public void injectJsBridge() {
        Engine.nativeInjectJsBridge(this.v8JsRuntime.getId(), this.contextId);
        Engine.nativeInjectJsWorker(this.v8JsRuntime.getId(), this.contextId);
    }

    public void injectNativeBuffer() {
        Engine.nativeInjectNativeBuffer(this.v8JsRuntime.getId(), this.contextId);
    }

    public void injectTimer() {
        Engine.nativeInjectTimer(this.v8JsRuntime.getId(), this.contextId);
        JsRuntimeLoader.injectBasicJs(Engine.getInstance().mEnginePathProvider, new String[]{"timer.js"}, this);
    }

    public String toString() {
        return "V8JsContext(" + this.v8JsRuntime.getId() + "," + this.contextId + ")";
    }
}
