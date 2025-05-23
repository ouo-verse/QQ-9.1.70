package com.tencent.qqmini.container.core;

import android.content.Context;
import com.tencent.qqmini.miniapp.plugin.CanvasJsPlugin;
import com.tencent.qqmini.miniapp.plugin.ImageViewJsPlugin;
import com.tencent.qqmini.miniapp.plugin.LivePlayerJsPlugin;
import com.tencent.qqmini.miniapp.plugin.LivePusherJsPlugin;
import com.tencent.qqmini.miniapp.plugin.MediaJsPlugin;
import com.tencent.qqmini.miniapp.plugin.ScrollViewJsPlugin;
import com.tencent.qqmini.miniapp.plugin.TextViewJsPlugin;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.plugins.InputJsPlugin;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class h extends com.tencent.qqmini.sdk.plugins.engine.c {

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, Class<?>> f346118f = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private final Set<Class<?>> f346119e;

    public h(Context context) {
        super(context);
        this.f346119e = new HashSet();
        b();
    }

    public static void a(Class<?> cls) {
        JsEvent jsEvent;
        if (cls != null && !f346118f.containsValue(cls)) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(JsEvent.class) && (jsEvent = (JsEvent) method.getAnnotation(JsEvent.class)) != null) {
                    for (String str : jsEvent.value()) {
                        f346118f.put(str, cls);
                    }
                }
            }
        }
    }

    private void b() {
        this.f346119e.add(UIJsPlugin.class);
        this.f346119e.add(CanvasJsPlugin.class);
        this.f346119e.add(InputJsPlugin.class);
        this.f346119e.add(MediaJsPlugin.class);
        this.f346119e.add(ImageViewJsPlugin.class);
        this.f346119e.add(LivePlayerJsPlugin.class);
        this.f346119e.add(LivePusherJsPlugin.class);
        this.f346119e.add(ScrollViewJsPlugin.class);
        this.f346119e.add(TextViewJsPlugin.class);
    }

    private boolean c(String str) {
        if (!this.f346119e.contains(this.mEventPluginMap.get(str)) && !this.f346119e.contains(this.mSecondaryEventPluginMap.get(str))) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine
    protected IJsPlugin getSecondaryEventHandler(String str) {
        Class<?> cls = this.mSecondaryEventPluginMap.get(str);
        if (cls == null) {
            cls = f346118f.get(str);
        }
        if (cls == null) {
            return null;
        }
        IJsPlugin iJsPlugin = this.mActivatedPlugins.get(cls);
        if (iJsPlugin != null) {
            return iJsPlugin;
        }
        return createJsPlugin(cls);
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine, com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine
    public String handleNativeRequest(String str, String str2, IJsService iJsService, int i3, int i16) {
        if (!(this.mMiniAppContext instanceof ax)) {
            return "";
        }
        if (QMLog.isColorLevel()) {
            QMLog.d("Mini-JsPluginEngine", "handleNativeRequest: eventName: " + str + "  callbackId: " + i3);
        }
        RequestEvent createRequestEvent = createRequestEvent(str, str2, iJsService, i3);
        createRequestEvent.webViewId = i16;
        NativeContainer u16 = ((ax) this.mMiniAppContext).u(i16);
        if (u16 != null && c(str)) {
            return u16.H(createRequestEvent);
        }
        return checkAuthorization(createRequestEvent);
    }
}
