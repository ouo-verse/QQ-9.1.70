package com.qq.e.comm.plugin.router;

import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class PublicApiHelper {
    private static volatile DefaultApiImpl defaultApi;
    private static ConcurrentHashMap<Class<? extends ModuleApi>, ModuleApi> sMap = new ConcurrentHashMap<>();

    public static <T extends ModuleApi> T getModuleApi(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        ConcurrentHashMap<Class<? extends ModuleApi>, ModuleApi> concurrentHashMap = sMap;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(cls) && sMap.get(cls) != null) {
            return (T) sMap.get(cls);
        }
        if (defaultApi == null) {
            synchronized (PublicApiHelper.class) {
                if (defaultApi == null) {
                    defaultApi = new DefaultApiImpl();
                }
            }
        }
        return (T) Proxy.newProxyInstance(PublicApiHelper.class.getClassLoader(), new Class[]{cls}, new DefaultApiIInvocationHandler(defaultApi));
    }

    public static void registerAll(Map<Class<? extends ModuleApi>, ModuleApi> map) {
        ConcurrentHashMap<Class<? extends ModuleApi>, ModuleApi> concurrentHashMap = sMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.putAll(map);
        }
    }

    public static void unregister(Class<? extends ModuleApi> cls) {
        ConcurrentHashMap<Class<? extends ModuleApi>, ModuleApi> concurrentHashMap = sMap;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(cls)) {
            sMap.remove(cls);
        }
    }
}
