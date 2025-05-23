package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.v1;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JsBridgeController {
    private static final String JS_BRIDGE_PRE_FIX = "DtJsBridge://";
    private Map<Object, JsHandlerRegistry> mJsHandlerRegistryCache;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class InstanceHolder {
        static JsBridgeController sInstance = new JsBridgeController();

        InstanceHolder() {
        }
    }

    private JsHandlerRegistry fetchJsInterface(@NonNull Object obj) {
        JsHandlerRegistry jsHandlerRegistry;
        if (this.mJsHandlerRegistryCache.containsKey(obj)) {
            jsHandlerRegistry = this.mJsHandlerRegistryCache.get(obj);
        } else {
            jsHandlerRegistry = null;
        }
        if (jsHandlerRegistry != null) {
            return jsHandlerRegistry;
        }
        JsHandlerRegistry jsHandlerRegistry2 = new JsHandlerRegistry(obj);
        this.mJsHandlerRegistryCache.put(obj, jsHandlerRegistry2);
        return jsHandlerRegistry2;
    }

    public static JsBridgeController getInstance() {
        return InstanceHolder.sInstance;
    }

    private String getJsonBody(String str) {
        return str.substring(13);
    }

    private boolean isValidMessage(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith(JS_BRIDGE_PRE_FIX);
        }
        return false;
    }

    public String shouldIntercept(Object obj, String str, String str2) {
        if (!isValidMessage(str) || obj == null) {
            return "";
        }
        return JsBridgeCall.call(fetchJsInterface(obj), getJsonBody(str), str2);
    }

    JsBridgeController() {
        this.mJsHandlerRegistryCache = new WeakHashMap();
    }
}
