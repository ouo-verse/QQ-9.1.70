package com.qzone.preview.service;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Method;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ServiceCmdDispatcher {
    private HashMap<String, a> mCmdMap = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a {

        /* renamed from: a, reason: collision with root package name */
        public Object f50023a;

        /* renamed from: b, reason: collision with root package name */
        public Method f50024b;

        a() {
        }
    }

    public void destroy() {
        HashMap<String, a> hashMap = this.mCmdMap;
        if (hashMap != null) {
            hashMap.clear();
            this.mCmdMap = null;
        }
    }

    public void loadMethods(Object obj, Class<?> cls) {
        for (Method method : cls.getMethods()) {
            if (method.isAnnotationPresent(ServiceCmd.class)) {
                method.setAccessible(true);
                ServiceCmd serviceCmd = (ServiceCmd) method.getAnnotation(ServiceCmd.class);
                a aVar = new a();
                aVar.f50023a = obj;
                aVar.f50024b = method;
                if (serviceCmd != null && !TextUtils.isEmpty(serviceCmd.value())) {
                    this.mCmdMap.put(serviceCmd.value(), aVar);
                }
            }
        }
    }

    public Message dispatchCmd(String str, Object obj, Handler handler) {
        a aVar;
        Method method;
        if (obj != null && (aVar = this.mCmdMap.get(str)) != null && (method = aVar.f50024b) != null) {
            try {
                if (handler != null) {
                    method.invoke(aVar.f50023a, obj, handler);
                } else {
                    method.invoke(aVar.f50023a, obj);
                }
            } catch (Exception e16) {
                QZLog.e(QZLog.TO_DEVICE_TAG, Log.getStackTraceString(e16));
            }
        }
        return null;
    }
}
