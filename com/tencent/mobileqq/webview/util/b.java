package com.tencent.mobileqq.webview.util;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Object> f314867a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49556);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(HippyControllerProps.BOOLEAN, Boolean.FALSE);
        hashMap.put(PoiListCacheRecord.WEIGHT_TYPE, 0);
        hashMap.put(PoiListCacheRecord.TIMESTAMP_TYPE, 0L);
        hashMap.put("float", Float.valueOf(0.0f));
        hashMap.put("double", Double.valueOf(0.0d));
        hashMap.put(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT, (short) 0);
        hashMap.put("byte", (byte) 0);
        f314867a = Collections.unmodifiableMap(hashMap);
    }

    public static <T> T b(Class<T> cls, final Object obj) {
        final Class<?> cls2 = obj.getClass();
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.tencent.mobileqq.webview.util.a
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj2, Method method, Object[] objArr) {
                Object c16;
                c16 = b.c(cls2, obj, obj2, method, objArr);
                return c16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object c(Class cls, Object obj, Object obj2, Method method, Object[] objArr) throws Throwable {
        try {
            Method method2 = cls.getMethod(method.getName(), method.getParameterTypes());
            method2.setAccessible(true);
            return method2.invoke(obj, objArr);
        } catch (NoSuchMethodException e16) {
            QLog.e("CallProxy", 1, String.format("createDelegatingProxy NoSuchMethodException:%s", method), e16);
            return f314867a.get(method.getReturnType().getName());
        } catch (Throwable th5) {
            QLog.e("CallProxy", 1, String.format("createDelegatingProxy exception:%s", method), th5);
            if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                throw new RuntimeException("createDelegatingProxy exception !!!");
            }
            return f314867a.get(method.getReturnType().getName());
        }
    }
}
