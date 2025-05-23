package mqq.app.remote;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.remote.e;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* loaded from: classes28.dex */
public class ServiceRemoteProxy {
    private static final String TAG = "ServiceRemoteProxy";
    private static final Object LOCK_OBJECT = new Object();
    private static final HashMap<String, Class<?>> CACHE_CLASS_MAP = new HashMap<>(512);
    private static final ConcurrentHashMap<String, Object> CACHE_PROXY_CLASS_MAP = new ConcurrentHashMap<>(512);
    private static final HashMap<String, Method> CACHE_METHOD_MAP = new HashMap<>(512);

    ServiceRemoteProxy() {
    }

    public static EIPCResult callInMainProcess(String str, Bundle bundle, int i3) {
        Class<?> cls;
        Method method;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "action:" + str + "  callbackId:" + i3);
        }
        if (!TextUtils.isEmpty(str) && str.contains("$")) {
            String[] split = str.split("\\$");
            if (split.length != 3) {
                return EIPCResult.createExceptionResult(new IllegalStateException("wrong action, action = " + str));
            }
            String str2 = split[1];
            String str3 = split[2];
            try {
                HashMap<String, Class<?>> hashMap = CACHE_CLASS_MAP;
                if (hashMap.containsKey(str2)) {
                    cls = hashMap.get(str2);
                } else {
                    Class<?> cls2 = Class.forName(str2);
                    hashMap.put(str2, cls2);
                    cls = cls2;
                }
                IRuntimeService runtimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(cls, "");
                if (runtimeService == null) {
                    return EIPCResult.createExceptionResult(new IllegalStateException("IRuntimeService is null, action = " + str));
                }
                bundle.setClassLoader(cls.getClassLoader());
                ArrayList<String> stringArrayList = bundle.getStringArrayList("__parameterTypes__");
                if (stringArrayList == null) {
                    return EIPCResult.createExceptionResult(new IllegalStateException("parameterList is null, action = " + str));
                }
                int size = stringArrayList.size();
                Class<?>[] clsArr = new Class[size];
                Object[] objArr = new Object[size];
                for (int i16 = 0; i16 < stringArrayList.size(); i16++) {
                    String str4 = stringArrayList.get(i16);
                    clsArr[i16] = e.d(str4);
                    objArr[i16] = e.c(bundle, str4, "__arg+" + i16 + "__");
                }
                HashMap<String, Method> hashMap2 = CACHE_METHOD_MAP;
                if (hashMap2.get(str) != null) {
                    method = hashMap2.get(str);
                } else {
                    Method declaredMethod = cls.getDeclaredMethod(str3, clsArr);
                    hashMap2.put(str, declaredMethod);
                    method = declaredMethod;
                }
                Object invoke = method.invoke(runtimeService, objArr);
                EIPCResult createSuccessResult = EIPCResult.createSuccessResult(bundle);
                e.k(bundle, method.getReturnType().getName(), "result", invoke);
                bundle.putString(RemoteProxy.KEY_RESULT_TYPE, method.getReturnType().getName());
                return createSuccessResult;
            } catch (Exception e16) {
                CACHE_METHOD_MAP.clear();
                e16.printStackTrace();
                QLog.d(TAG, 1, "onCall exception", e16);
                return EIPCResult.createExceptionResult(e16);
            }
        }
        return EIPCResult.createExceptionResult(new IllegalStateException("wrong acton"));
    }

    public static void clear() {
        CACHE_CLASS_MAP.clear();
        CACHE_PROXY_CLASS_MAP.clear();
    }

    public static Object getProxy(Class<? extends IRuntimeService> cls, Class<? extends IRuntimeService> cls2) {
        String name = cls.getName();
        ConcurrentHashMap<String, Object> concurrentHashMap = CACHE_PROXY_CLASS_MAP;
        if (concurrentHashMap.containsKey(name)) {
            return concurrentHashMap.get(name);
        }
        synchronized (LOCK_OBJECT) {
            if (!concurrentHashMap.containsKey(name)) {
                Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), cls2.getInterfaces(), new ServiceRemoteHandler(cls));
                concurrentHashMap.put(name, newProxyInstance);
                return newProxyInstance;
            }
            return concurrentHashMap.get(name);
        }
    }
}
