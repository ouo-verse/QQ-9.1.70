package com.tencent.smtt.sdk;

import java.util.Set;

/* loaded from: classes23.dex */
public class GeolocationPermissions {

    /* renamed from: a, reason: collision with root package name */
    private static GeolocationPermissions f368962a;

    private static synchronized GeolocationPermissions a() {
        GeolocationPermissions geolocationPermissions;
        synchronized (GeolocationPermissions.class) {
            if (f368962a == null) {
                f368962a = new GeolocationPermissions();
            }
            geolocationPermissions = f368962a;
        }
        return geolocationPermissions;
    }

    public static GeolocationPermissions getInstance() {
        return a();
    }

    public void allow(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().g(str);
        } else {
            android.webkit.GeolocationPermissions.getInstance().allow(str);
        }
    }

    public void clear(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().f(str);
        } else {
            android.webkit.GeolocationPermissions.getInstance().clear(str);
        }
    }

    public void clearAll() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().o();
        } else {
            android.webkit.GeolocationPermissions.getInstance().clearAll();
        }
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().c(str, valueCallback);
        } else {
            android.webkit.GeolocationPermissions.getInstance().getAllowed(str, valueCallback);
        }
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().b(valueCallback);
        } else {
            android.webkit.GeolocationPermissions.getInstance().getOrigins(valueCallback);
        }
    }
}
