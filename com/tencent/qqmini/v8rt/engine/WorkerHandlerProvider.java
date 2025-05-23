package com.tencent.qqmini.v8rt.engine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes23.dex */
public class WorkerHandlerProvider {
    public static WorkerHandlerProvider sInstance = new WorkerHandlerProvider();
    public static Map<V8JsRuntime, IWorkerEventHandler> sWorkerHandlerProvider = new ConcurrentHashMap();

    public static WorkerHandlerProvider getInstance() {
        return sInstance;
    }

    public IWorkerEventHandler getWorkerHandler(V8JsRuntime v8JsRuntime) {
        return sWorkerHandlerProvider.get(v8JsRuntime);
    }

    public void removeWorkerHandler(V8JsRuntime v8JsRuntime) {
        sWorkerHandlerProvider.remove(v8JsRuntime);
    }

    public void setWorkerHandler(V8JsRuntime v8JsRuntime, IWorkerEventHandler iWorkerEventHandler) {
        sWorkerHandlerProvider.put(v8JsRuntime, iWorkerEventHandler);
    }
}
