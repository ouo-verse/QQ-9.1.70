package com.tencent.luggage.wxa.k6;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.xweb.WebView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.e5.k f131630c;

    /* renamed from: d, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.e5.j f131631d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f131632e;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f131629b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "ENABLED", "getENABLED()Z", 0))};

    /* renamed from: a, reason: collision with root package name */
    public static final a f131628a = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.k6.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6363a implements ValueCallback {

        /* renamed from: a, reason: collision with root package name */
        public static final C6363a f131633a = new C6363a();

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceiveValue(String str) {
            w.d("Luggage.HTMLGeolocationPolyfill", "tryPolyfill result:" + str);
        }
    }

    static {
        com.tencent.luggage.wxa.e5.k kVar = new com.tencent.luggage.wxa.e5.k("Luggage.HTMLGeolocationPolyfill");
        f131630c = kVar;
        f131631d = new com.tencent.luggage.wxa.e5.j(kVar, Boolean.FALSE);
        f131632e = "(function(window) {\n    if (typeof window.__WXGeolocationPolyfill !== 'undefined') {\n        return window.__WXGeolocationPolyfill;\n    }\n    var originFuncGetCurrentPosition = window.navigator.geolocation.getCurrentPosition;\n    window.__WXGeolocationPolyfill = {};\n    window.__WXGeolocationPolyfill.getCurrentPosition = function(successCallback, errorCallback, options) {\n        if (typeof window.wx === 'undefined') {\n            originFuncGetCurrentPosition(successCallback, errorCallback, options);\n            return;\n        }\n        console.info('__WXGeolocationPolyfill.getCurrentPosition invoke')\n        window.wx.getLocation({\n            success: function(res) {\n                var coords = {\n                    latitude: res.latitude,\n                    longitude: res.longitude,\n                    accuracy: res.accuracy,\n                    altitude: null,\n                    altitudeAccuracy: null,\n                    heading: null,\n                    speed: res.speed\n                };\n                var position = {\n                    coords: coords,\n                    timestamp: Date.now()\n                };\n                if (typeof successCallback === 'function') {\n                    successCallback(position);\n                }\n            },\n            fail: function(res) {\n                if (typeof errorCallback === 'function') {\n                    errorCallback(res);\n                }\n            }\n        })\n    };\n    window.navigator.geolocation.getCurrentPosition = window.__WXGeolocationPolyfill.getCurrentPosition;\n    return window.__WXGeolocationPolyfill;\n})(this);";
    }

    public final boolean a() {
        return ((Boolean) f131631d.a(this, f131629b[0])).booleanValue();
    }

    public static final void a(WebView mmWebView) {
        Intrinsics.checkNotNullParameter(mmWebView, "mmWebView");
        if (f131628a.a()) {
            mmWebView.evaluateJavascript(f131632e, C6363a.f131633a);
        }
    }
}
