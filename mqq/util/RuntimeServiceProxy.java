package mqq.util;

import android.util.Log;
import com.tencent.mobileqq.imcore.proxy.basic.StatisticCollectorProxy;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import mqq.inject.MqqInjectorManager;

/* loaded from: classes28.dex */
public class RuntimeServiceProxy implements InvocationHandler {
    public static final String TAG = "RuntimeServiceProxy";

    private Object getDefaultValue(Class<?> cls) {
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Character.TYPE) {
            return (char) 0;
        }
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (cls == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (cls == String.class) {
            return "";
        }
        return tryCreateTypeDefaultValue(cls);
    }

    private String getProxyInterfaceName(Object obj) {
        return obj.getClass().getInterfaces()[0].getName();
    }

    private void reportProxyObjectInvoke(String str, String str2, Throwable th5) {
        HashMap hashMap = new HashMap();
        hashMap.put("implName", str);
        hashMap.put("methodName", str2);
        hashMap.put("trace", Log.getStackTraceString(th5));
        StatisticCollectorProxy.collectPerformance(null, "RuntimeServiceProxyInvoke", true, 0L, 0L, hashMap, null);
    }

    private Object tryCreateTypeDefaultValue(Class<?> cls) {
        if (cls.isInterface()) {
            return RuntimeServiceHelper.createReturnProxy(cls);
        }
        try {
            Constructor<?> constructor = cls.getConstructor(new Class[0]);
            if (constructor.isAccessible()) {
                constructor.newInstance(new Object[0]);
            }
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return null;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String proxyInterfaceName = getProxyInterfaceName(obj);
        QLog.d(TAG, 1, "invoke interface: ", proxyInterfaceName, " call method: ", method.getName());
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "invoke stack: ", new Throwable(method.getName()));
        }
        if (!MqqInjectorManager.instance().isPublicVersion()) {
            reportProxyObjectInvoke(proxyInterfaceName, method.getName(), new Throwable());
        }
        return getDefaultValue(method.getReturnType());
    }
}
