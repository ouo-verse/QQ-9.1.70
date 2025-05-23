package com.tencent.qqmini.sdk.core.proxy.engine;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes23.dex */
public class ProxyServiceEngine {
    private static final String TAG = "ProxyServiceEngine";
    private static final ProxyServiceEngine sInstance = new ProxyServiceEngine();
    private Map<Class, Class> mProxyServicesMap = ProxyServiceList.get();
    private Map<Class, Object> mActivatedServices = new HashMap();

    ProxyServiceEngine() {
    }

    public static ProxyServiceEngine g() {
        return sInstance;
    }

    public Object getProxyService(Class cls) {
        Class cls2 = this.mProxyServicesMap.get(cls);
        if (cls2 == null) {
            QMLog.w(TAG, "Can NOT find service class by proxy name: " + cls);
            return null;
        }
        Object obj = this.mActivatedServices.get(cls2);
        if (obj != null) {
            return obj;
        }
        synchronized (this) {
            if (obj == null) {
                try {
                    obj = cls2.newInstance();
                    QMLog.i(TAG, "Create a new proxy instance of " + cls2);
                    this.mActivatedServices.put(cls2, obj);
                } catch (Exception unused) {
                    QMLog.e(TAG, "Failed to create instance of " + cls2);
                }
            }
        }
        return obj;
    }

    public Object newProxyService(Class cls) {
        Object newInstance;
        Class cls2 = this.mProxyServicesMap.get(cls);
        if (cls2 == null) {
            QMLog.w(TAG, "Can NOT find service class: " + cls);
            return null;
        }
        synchronized (this) {
            try {
                try {
                    QMLog.i(TAG, "Create a new proxy cls:" + cls2);
                    newInstance = cls2.newInstance();
                } catch (Exception unused) {
                    QMLog.e(TAG, "Failed to create cls:" + cls2);
                    return null;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        return newInstance;
    }
}
