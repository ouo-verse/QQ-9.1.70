package com.tencent.filament.zplan.engine.js;

import androidx.annotation.Keep;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.filament.js.annotation.JsFilamentEvent;
import com.tencent.filament.zplan.engine.FilamentNativeJsApp;
import com.tencent.filament.zplanservice.util.e;
import com.tencent.filament.zplanservice.util.log.FLog;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001%B\u0015\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001b\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002J\u0018\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\bH\u0002J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002J \u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0007R$\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R8\u0010\u0019\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00010\u0017j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u0001`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR<\u0010\u001c\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001b0\u0017j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001b`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/filament/zplan/engine/js/FilamentJsPluginEngine;", "", "", "apiName", "getPlugin", "Ljava/lang/Class;", "pluginClass", "createJsPlugin", "", "getEventPluginMap", "Ljava/lang/reflect/Method;", "getMethod", "Lcom/tencent/filament/zplan/engine/js/a;", "requestEvent", "plugin", "dispatchEventToPlugin", AdMetricTag.EVENT_NAME, "param", "", "callbackId", "handleNativeRequest", "eventPluginMap", "Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "activatedPluginMap", "Ljava/util/HashMap;", "Ljava/lang/ref/WeakReference;", "methodCache", "Lcom/tencent/filament/zplan/engine/FilamentNativeJsApp;", "appRef", "Ljava/lang/ref/WeakReference;", "getAppRef", "()Ljava/lang/ref/WeakReference;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentJsPluginEngine {

    @NotNull
    public static final String TAG = "FilamentJsPluginEngine";
    private final HashMap<Class<?>, Object> activatedPluginMap;

    @NotNull
    private final WeakReference<FilamentNativeJsApp> appRef;
    private final Map<String, Class<?>> eventPluginMap;
    private final HashMap<String, WeakReference<Method>> methodCache;

    public FilamentJsPluginEngine(@NotNull WeakReference<FilamentNativeJsApp> appRef) {
        Intrinsics.checkNotNullParameter(appRef, "appRef");
        this.appRef = appRef;
        this.activatedPluginMap = new HashMap<>();
        this.methodCache = new HashMap<>();
        this.eventPluginMap = getEventPluginMap();
    }

    private final Object createJsPlugin(Class<?> pluginClass) {
        Object obj = this.activatedPluginMap.get(pluginClass);
        if (obj != null) {
            return obj;
        }
        try {
            Object obj2 = pluginClass.newInstance();
            HashMap<Class<?>, Object> hashMap = this.activatedPluginMap;
            Intrinsics.checkNotNullExpressionValue(obj2, "obj");
            hashMap.put(pluginClass, obj2);
            return obj2;
        } catch (Exception e16) {
            FLog.INSTANCE.e(TAG, "Failed to create plugin " + pluginClass, e16);
            return null;
        }
    }

    private final String dispatchEventToPlugin(a requestEvent, Object plugin) {
        Method method = null;
        try {
            String str = plugin.getClass().getCanonicalName() + '.' + requestEvent.getEvent();
            WeakReference<Method> weakReference = this.methodCache.get(str);
            if (weakReference != null) {
                method = weakReference.get();
            }
            if (method == null) {
                method = getMethod(plugin.getClass(), requestEvent.getEvent());
                if (method == null) {
                    return "";
                }
                method.setAccessible(true);
                this.methodCache.put(str, new WeakReference<>(method));
            }
            Object invoke = method.invoke(plugin, requestEvent);
            if (invoke == null) {
                return "";
            }
            String obj = invoke.toString();
            if (obj == null) {
                return "";
            }
            return obj;
        } catch (IllegalAccessError e16) {
            FLog.INSTANCE.e(TAG, "dispatchEvent " + requestEvent.getEvent() + " failed, method = " + method + ", access exception ", e16);
            return "";
        } catch (RuntimeException e17) {
            FLog.INSTANCE.e(TAG, "dispatchEvent " + requestEvent.getEvent() + " failed, method = " + method + ", runtime exception " + e17, e17);
            return "";
        } catch (InvocationTargetException e18) {
            FLog.INSTANCE.e(TAG, "dispatchEvent " + requestEvent.getEvent() + " failed, method = " + method + ", invoke exception " + e18, e18);
            return "";
        }
    }

    private final Map<String, Class<?>> getEventPluginMap() {
        Object a16 = e.f106444a.a("com.tencent.filament.js.generated.JsPluginScope", "EVENT_HANDLERS");
        if (a16 instanceof Map) {
            return (Map) a16;
        }
        return new HashMap();
    }

    private final Method getMethod(Class<?> pluginClass, String apiName) {
        JsFilamentEvent jsFilamentEvent;
        for (Method method : pluginClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(JsFilamentEvent.class) && (jsFilamentEvent = (JsFilamentEvent) method.getAnnotation(JsFilamentEvent.class)) != null) {
                for (String str : jsFilamentEvent.value()) {
                    if (Intrinsics.areEqual(str, apiName)) {
                        return method;
                    }
                }
            }
        }
        FLog.INSTANCE.e(TAG, "Failed to getMethod in JsPlugin " + pluginClass + " for event " + apiName);
        return null;
    }

    private final Object getPlugin(String apiName) {
        Class<?> cls = this.eventPluginMap.get(apiName);
        if (cls != null) {
            Object obj = this.activatedPluginMap.get(cls);
            if (obj != null) {
                return obj;
            }
            return createJsPlugin(cls);
        }
        return null;
    }

    @NotNull
    public final WeakReference<FilamentNativeJsApp> getAppRef() {
        return this.appRef;
    }

    @NativeMethodProxy
    @NotNull
    public final String handleNativeRequest(@NotNull String eventName, @NotNull String param, int callbackId) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(param, "param");
        FLog fLog = FLog.INSTANCE;
        fLog.i(TAG, "handleNativeRequest. eventName: " + eventName + ", param: " + param + ", callbackId: " + callbackId);
        Object plugin = getPlugin(eventName);
        if (plugin == null) {
            fLog.e(TAG, "plugin is null. eventName: " + eventName + ", param: " + param + ", callbackId: " + callbackId);
            return "";
        }
        return dispatchEventToPlugin(new a(eventName, param, new WeakReference(this), callbackId), plugin);
    }
}
