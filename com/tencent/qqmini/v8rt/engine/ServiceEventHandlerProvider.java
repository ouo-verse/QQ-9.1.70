package com.tencent.qqmini.v8rt.engine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes23.dex */
public class ServiceEventHandlerProvider {
    public static ServiceEventHandlerProvider sInstance = new ServiceEventHandlerProvider();
    public static Map<V8JsRuntime, IServiceEventHandler> sServiceEventHandlerMap = new ConcurrentHashMap();

    public static ServiceEventHandlerProvider getInstance() {
        return sInstance;
    }

    public IServiceEventHandler getServiceEventHandler(V8JsRuntime v8JsRuntime) {
        return sServiceEventHandlerMap.get(v8JsRuntime);
    }

    public void removeServiceEventHandler(V8JsRuntime v8JsRuntime) {
        sServiceEventHandlerMap.remove(v8JsRuntime);
    }

    public void setServiceEventHandler(V8JsRuntime v8JsRuntime, IServiceEventHandler iServiceEventHandler) {
        sServiceEventHandlerMap.put(v8JsRuntime, iServiceEventHandler);
    }
}
