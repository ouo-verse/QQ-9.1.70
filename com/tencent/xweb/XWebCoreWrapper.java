package com.tencent.xweb;

import com.tencent.luggage.wxa.ar.g0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.tq.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebCoreWrapper implements d {
    public static final String TAG = "XWebCoreWrapper";

    public Class<?> getBridgeClass(String str) {
        try {
            ClassLoader webViewCoreClassLoader = getWebViewCoreClassLoader();
            if (webViewCoreClassLoader != null) {
                return webViewCoreClassLoader.loadClass(getBridgePackageName() + "." + str);
            }
            return null;
        } catch (Throwable th5) {
            x0.f(TAG, "getBridgeClass failed, class:" + str + ", error:" + th5);
            return null;
        }
    }

    public Object getBridgeObject(Object obj) {
        try {
            return new g0(obj, "getBridge", new Class[0]).a(new Object[0]);
        } catch (Throwable th5) {
            x0.f(TAG, "getBridgeObject failed, object:" + obj + ", error:" + th5);
            return null;
        }
    }

    public String getBridgePackageName() {
        return null;
    }

    public Class<?> getClass(String str) {
        try {
            ClassLoader webViewCoreClassLoader = getWebViewCoreClassLoader();
            if (webViewCoreClassLoader != null) {
                return webViewCoreClassLoader.loadClass(str);
            }
            return null;
        } catch (Throwable th5) {
            x0.f(TAG, "getClass failed, class:" + str + ", error:" + th5);
            return null;
        }
    }

    public ClassLoader getWebViewCoreClassLoader() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.tq.d
    public boolean hasFeature(int i3) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.tq.d
    public boolean invokeNativeChannel(int i3, Object[] objArr) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.tq.d
    public Object invokeRuntimeChannel(int i3, Object[] objArr) {
        return null;
    }
}
