package com.qq.e.comm.plugin.router;

import com.qq.e.comm.plugin.router.ModuleApi;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DefaultApiIInvocationHandler<T extends ModuleApi> implements InvocationHandler {
    private static final int EVENT_METHOD_CALLED_NOT_REGISTERED = 11110000;
    private static final String TAG = "DefaultApiIInvocationHandler_";
    private T object;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultApiIInvocationHandler(T t16) {
        this.object = t16;
    }

    private void reportForMethodInvoke(Method method) {
        String str;
        try {
            Method declaredMethod = StatTracer.class.getDeclaredMethod("trackEvent", Integer.TYPE, JSONObject.class, JSONObject.class);
            JSONObject jSONObject = new JSONObject();
            if (method != null) {
                str = method.getName();
            } else {
                str = null;
            }
            jSONObject.put("methodName", str);
            declaredMethod.invoke(StatTracer.class, Integer.valueOf(EVENT_METHOD_CALLED_NOT_REGISTERED), null, jSONObject);
        } catch (Throwable th5) {
            GDTLogger.e("reportForMethodInvoke error:", th5);
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        reportForMethodInvoke(method);
        try {
            return method.invoke(this.object, objArr);
        } catch (Throwable th5) {
            GDTLogger.e("Method Invoke error:", th5);
            return null;
        }
    }
}
