package com.tencent.qqmini.sdk.plugins.engine;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.core.utils.ReflectionUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes23.dex */
public class JsPluginList {
    private static final String APP_JS_PLUGIN = "com.tencent.qqmini.sdk.core.generated.AppJsPluginScope";
    private static final boolean DEBUG = false;
    private static final String EVENTS_HANDLES = "EVENT_HANDLERS";
    private static final String EXT_JS_PLUGIN = "com.tencent.qqmini.sdk.core.generated.ExtJsPluginScope";
    private static final String GAME_JS_PLUGIN = "com.tencent.qqmini.sdk.core.generated.GameJsPluginScope";
    private static final String GENERATED_PACKAGE = "com.tencent.qqmini.sdk.core.generated.";
    private static final String MAP_JS_PLUGIN = "com.tencent.qqmini.sdk.core.generated.MapJsPluginScope";
    private static final String PRELOAD_PLUGINS = "PRELOAD_PLUGINS";
    private static final String SDK_JS_PLUGIN = "com.tencent.qqmini.sdk.core.generated.SdkJsPluginScope";
    private static final String SECONDARY_EVENT_HANDLERS = "SECONDARY_EVENT_HANDLERS";
    private static final String TAG = "JsPluginList";
    private static Map<Class, String> sPluginScope = new HashMap();

    public static void clear() {
        sPluginScope.clear();
    }

    private static void fillEventPluginMap(String str, Map<String, Class> map) {
        for (Map.Entry<String, Class> entry : getEventHandlersByScope(str).entrySet()) {
            String key = entry.getKey();
            Class value = entry.getValue();
            if (map.containsKey(key)) {
                QMLog.w(TAG, "register JsPlugin, conflict event:" + key);
            } else {
                map.put(key, value);
                sPluginScope.put(value, str);
            }
        }
    }

    private static void fillPreloadPlugins(String str, List<Class> list) {
        Iterator<Class> it = getPreloadPluginsByScope(str).iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
    }

    private static void fillSecondaryEventPluginMap(String str, Map<String, Class> map) {
        for (Map.Entry<String, Class> entry : getSecondaryEventHandlersByScope(str).entrySet()) {
            String key = entry.getKey();
            Class value = entry.getValue();
            if (map.containsKey(key)) {
                QMLog.w(TAG, "register Secondary JsPlugin, conflict event:" + key);
            } else {
                map.put(key, value);
                sPluginScope.put(value, str);
            }
        }
    }

    private static Map<String, Class> getEventHandlersByScope(String str) {
        Object staticField = ReflectionUtil.getStaticField(str, EVENTS_HANDLES);
        if (staticField instanceof Map) {
            return (Map) staticField;
        }
        return new HashMap();
    }

    public static Map<String, Class> getEventPluginMap(boolean z16) {
        String str;
        HashMap hashMap = new HashMap();
        fillEventPluginMap(SDK_JS_PLUGIN, hashMap);
        if (z16) {
            str = GAME_JS_PLUGIN;
        } else {
            str = APP_JS_PLUGIN;
        }
        fillEventPluginMap(str, hashMap);
        fillEventPluginMap(MAP_JS_PLUGIN, hashMap);
        fillEventPluginMap(EXT_JS_PLUGIN, hashMap);
        QMLog.i(TAG, "Registered events size: " + hashMap.keySet().size());
        return hashMap;
    }

    public static Method getMethod(Class cls, String str) {
        if (cls != null && str != null) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(JsEvent.class)) {
                    for (String str2 : ((JsEvent) method.getAnnotation(JsEvent.class)).value()) {
                        if (str2.equals(str)) {
                            return method;
                        }
                    }
                }
            }
            QMLog.w(TAG, "Failed to getMethod in JsPlugin " + cls + " for event " + str);
        }
        return null;
    }

    public static b getMethodItem(Class cls, String str) {
        if (cls != null && str != null) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(JsEvent.class)) {
                    JsEvent jsEvent = (JsEvent) method.getAnnotation(JsEvent.class);
                    for (String str2 : jsEvent.value()) {
                        if (str2.equals(str)) {
                            return new b(method, jsEvent.isSync());
                        }
                    }
                }
            }
            QMLog.w(TAG, "Failed to getMethod in JsPlugin " + cls + " for event " + str);
        }
        return null;
    }

    public static List<Class> getPreloadPlugins(boolean z16) {
        String str;
        ArrayList arrayList = new ArrayList();
        fillPreloadPlugins(SDK_JS_PLUGIN, arrayList);
        if (z16) {
            str = GAME_JS_PLUGIN;
        } else {
            str = APP_JS_PLUGIN;
        }
        fillPreloadPlugins(str, arrayList);
        fillPreloadPlugins(EXT_JS_PLUGIN, arrayList);
        return arrayList;
    }

    private static List<Class> getPreloadPluginsByScope(String str) {
        Object staticField = ReflectionUtil.getStaticField(str, PRELOAD_PLUGINS);
        if (staticField instanceof List) {
            return (List) staticField;
        }
        return new ArrayList();
    }

    private static Map<String, Class> getSecondaryEventHandlersByScope(String str) {
        Object staticField = ReflectionUtil.getStaticField(str, SECONDARY_EVENT_HANDLERS);
        if (staticField instanceof Map) {
            return (Map) staticField;
        }
        return new HashMap();
    }

    public static Map<String, Class> getSecondaryEventPluginMap(boolean z16) {
        String str;
        HashMap hashMap = new HashMap();
        fillSecondaryEventPluginMap(SDK_JS_PLUGIN, hashMap);
        if (z16) {
            str = GAME_JS_PLUGIN;
        } else {
            str = APP_JS_PLUGIN;
        }
        fillSecondaryEventPluginMap(str, hashMap);
        fillSecondaryEventPluginMap(EXT_JS_PLUGIN, hashMap);
        QMLog.i(TAG, "Registered secondary events size: " + hashMap.keySet().size());
        return hashMap;
    }
}
