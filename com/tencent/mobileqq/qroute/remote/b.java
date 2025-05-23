package com.tencent.mobileqq.qroute.remote;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f276469a;

    /* renamed from: b, reason: collision with root package name */
    private static a f276470b;

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<String, Class<?>> f276471c;

    /* renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Object> f276472d;

    /* renamed from: e, reason: collision with root package name */
    private static final HashMap<String, Method> f276473e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8712);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f276469a = new Object();
        f276471c = new HashMap<>(512);
        f276472d = new ConcurrentHashMap<>(512);
        f276473e = new HashMap<>(512);
    }

    public static c a(String str, Bundle bundle, int i3) {
        Class<?> cls;
        Method method;
        if (QRoute.logger.isColorLevel()) {
            QRoute.logger.debug("QRemoteProxy", "action:" + str + "  callbackId:" + i3);
        }
        if (!TextUtils.isEmpty(str) && str.contains("$")) {
            String[] split = str.split("\\$");
            if (split.length != 3) {
                return new c(-101, bundle, new IllegalStateException("wrong action, action = " + str));
            }
            String str2 = split[1];
            String str3 = split[2];
            try {
                HashMap<String, Class<?>> hashMap = f276471c;
                if (hashMap.containsKey(str2)) {
                    cls = hashMap.get(str2);
                } else {
                    Class<?> cls2 = Class.forName(str2);
                    hashMap.put(str2, cls2);
                    cls = cls2;
                }
                QRouteApi api = QRoute.api(cls);
                if (api == null) {
                    return new c(-101, bundle, new IllegalStateException("qRouteApi is null, action = " + str));
                }
                bundle.setClassLoader(cls.getClassLoader());
                ArrayList<String> stringArrayList = bundle.getStringArrayList("__parameterTypes__");
                int size = stringArrayList.size();
                Class<?>[] clsArr = new Class[size];
                Object[] objArr = new Object[size];
                for (int i16 = 0; i16 < stringArrayList.size(); i16++) {
                    String str4 = stringArrayList.get(i16);
                    clsArr[i16] = e.d(str4);
                    objArr[i16] = e.c(bundle, str4, "__arg+" + i16 + "__");
                }
                HashMap<String, Method> hashMap2 = f276473e;
                if (hashMap2.get(str) != null) {
                    method = hashMap2.get(str);
                } else {
                    Method declaredMethod = cls.getDeclaredMethod(str3, clsArr);
                    hashMap2.put(str, declaredMethod);
                    method = declaredMethod;
                }
                Object invoke = method.invoke(api, objArr);
                c cVar = new c(0, bundle);
                e.k(bundle, method.getReturnType().getName(), "result", invoke);
                bundle.putString(RemoteProxy.KEY_RESULT_TYPE, method.getReturnType().getName());
                return cVar;
            } catch (Exception e16) {
                f276473e.clear();
                e16.printStackTrace();
                c cVar2 = new c(-101, bundle, e16);
                QRoute.logger.b("QRemoteProxy", "onCall exception", e16);
                return cVar2;
            }
        }
        return new c(-101, bundle, new IllegalStateException("wrong acton"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static c b(String str, Bundle bundle) {
        a aVar = f276470b;
        if (aVar == null) {
            QRoute.logger.a("QRemoteProxy", "callServerSync before init, action=" + str);
            return null;
        }
        return aVar.a(str, bundle);
    }

    public static Object c(Class<? extends QRouteApi> cls, Class<? extends QRouteApi> cls2) {
        String name = cls.getName();
        ConcurrentHashMap<String, Object> concurrentHashMap = f276472d;
        if (concurrentHashMap.containsKey(name)) {
            return concurrentHashMap.get(name);
        }
        synchronized (f276469a) {
            if (!concurrentHashMap.containsKey(name)) {
                Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), cls2.getInterfaces(), new d(cls));
                concurrentHashMap.put(name, newProxyInstance);
                return newProxyInstance;
            }
            return concurrentHashMap.get(name);
        }
    }

    public static void d(a aVar) {
        f276470b = aVar;
    }
}
