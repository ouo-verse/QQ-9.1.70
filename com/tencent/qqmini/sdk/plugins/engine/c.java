package com.tencent.qqmini.sdk.plugins.engine;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class c extends JsPluginEngine {

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, WeakReference<Method>> f348300d;

    public c(Context context) {
        super(context);
        this.f348300d = new ConcurrentHashMap();
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine
    @NonNull
    protected f createPermissionReqImpl() {
        return new d();
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine
    protected String dispatchRequestEventToPlugin(RequestEvent requestEvent, IJsPlugin iJsPlugin) {
        Method method;
        Object obj = null;
        try {
            String str = iJsPlugin.getClass().getCanonicalName() + "." + requestEvent.event;
            WeakReference<Method> weakReference = this.f348300d.get(str);
            if (weakReference != null) {
                method = weakReference.get();
            } else {
                method = null;
            }
            if (method == null) {
                try {
                    method = JsPluginList.getMethod(iJsPlugin.getClass(), requestEvent.event);
                    if (method != null) {
                        method.setAccessible(true);
                    }
                    this.f348300d.put(str, new WeakReference<>(method));
                } catch (IllegalAccessException e16) {
                    e = e16;
                    obj = method;
                    QMLog.w(JsPluginEngine.TAG, "dispatchEvent " + requestEvent.event + " failed, method = " + obj + ", access exception " + e.getMessage(), e);
                    requestEvent.fail();
                    return "";
                } catch (RuntimeException e17) {
                    e = e17;
                    obj = method;
                    QMLog.w(JsPluginEngine.TAG, "dispatchEvent " + requestEvent.event + " failed, method = " + obj + ", runtime exception " + e.getMessage(), e);
                    requestEvent.fail();
                    return "";
                } catch (InvocationTargetException e18) {
                    e = e18;
                    obj = method;
                    QMLog.w(JsPluginEngine.TAG, "dispatchEvent " + requestEvent.event + " failed, method = " + obj + ", invoke exception " + e.getMessage(), e);
                    requestEvent.fail();
                    return "";
                }
            }
            if (method != null) {
                obj = method.invoke(iJsPlugin, requestEvent);
            }
            if (obj == null) {
                return "";
            }
            return obj.toString();
        } catch (IllegalAccessException e19) {
            e = e19;
        } catch (RuntimeException e26) {
            e = e26;
        } catch (InvocationTargetException e27) {
            e = e27;
        }
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine
    protected void fillEventPluginMap(Map<String, Class> map, Map<String, Class> map2) {
        map.putAll(JsPluginList.getEventPluginMap(false));
        map2.putAll(JsPluginList.getSecondaryEventPluginMap(false));
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine, com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        Map<Class, IJsPlugin> map = this.mActivatedPlugins;
        if (map != null && map.size() > 0) {
            Iterator<IJsPlugin> it = this.mActivatedPlugins.values().iterator();
            while (it.hasNext()) {
                it.next().onCreate(iMiniAppContext);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine, com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        this.f348300d.clear();
    }
}
