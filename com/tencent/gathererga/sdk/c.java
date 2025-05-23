package com.tencent.gathererga.sdk;

import com.tencent.gathererga.core.TuringProvider;
import com.tencent.gathererga.core.e;
import com.tencent.gathererga.core.internal.component.cloudconf.IDConfigManagerImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Integer, Integer> f108339a;

    /* renamed from: b, reason: collision with root package name */
    public static final e f108340b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56144);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap hashMap = new HashMap();
        f108339a = hashMap;
        hashMap.put(3, 105498);
        hashMap.put(1, 108298);
        hashMap.put(2, 108308);
        hashMap.put(4, 105548);
        hashMap.put(5, 108388);
        f108340b = com.tencent.gathererga.core.internal.provider.b.g();
    }

    public static <T> T a(Class<T> cls) {
        return (T) com.tencent.gathererga.core.b.f(cls);
    }

    public static <T> T b(Class<T> cls) {
        return (T) d.e(cls);
    }

    public static void c(a aVar, b bVar) throws IllegalArgumentException {
        if (aVar != null) {
            com.tencent.gathererga.core.b.i(TuringProvider.class, com.tencent.gathererga.core.internal.provider.impl.e.class);
            com.tencent.gathererga.core.b.g(aVar);
            d.f(ul0.a.class, com.tencent.gathererga.ad.internal.c.class);
            IDConfigManagerImpl.l().d(aVar, true);
            return;
        }
        throw new IllegalArgumentException("please input valid config, current value is null");
    }

    public static void d(ConcurrentHashMap<Integer, Boolean> concurrentHashMap) {
        IDConfigManagerImpl.l().b(concurrentHashMap);
    }

    public static void f(ConcurrentHashMap<Integer, Boolean> concurrentHashMap) {
        IDConfigManagerImpl.l().c(concurrentHashMap);
    }

    public static void e(ConcurrentHashMap<Integer, Object> concurrentHashMap) {
    }
}
