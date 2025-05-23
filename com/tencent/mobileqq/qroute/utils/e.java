package com.tencent.mobileqq.qroute.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Class<?>, b> f276502a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object[] f276503b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f276504a;

        /* renamed from: b, reason: collision with root package name */
        private Boolean f276505b;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ b(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9275);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f276502a = new ConcurrentHashMap<>(8000);
        f276503b = new Object[20];
        int i3 = 0;
        while (true) {
            Object[] objArr = f276503b;
            if (i3 < objArr.length) {
                objArr[i3] = new Object();
                i3++;
            } else {
                return;
            }
        }
    }

    public static String a(Class<?> cls) {
        ConcurrentHashMap<Class<?>, b> concurrentHashMap = f276502a;
        b bVar = concurrentHashMap.get(cls);
        if (bVar != null && bVar.f276504a != null) {
            return bVar.f276504a;
        }
        synchronized (f276503b[cls.hashCode() % 20]) {
            b bVar2 = concurrentHashMap.get(cls);
            if (bVar2 != null && bVar2.f276504a != null) {
                return bVar2.f276504a;
            }
            if (bVar2 == null) {
                bVar2 = new b(null);
            }
            bVar2.f276504a = b(cls);
            concurrentHashMap.put(cls, bVar2);
            return bVar2.f276504a;
        }
    }

    private static String b(Class<?> cls) {
        StringBuilder sb5 = new StringBuilder(cls.getName());
        sb5.append("Impl");
        int lastIndexOf = sb5.lastIndexOf(".");
        if (lastIndexOf > 0) {
            int i3 = lastIndexOf + 1;
            sb5.deleteCharAt(i3);
            sb5.insert(i3, "impl.");
            return sb5.toString();
        }
        return "";
    }

    public static <T extends QRouteApi> void c(Class<T> cls) {
        if (cls.isAnnotationPresent(QAPI.class)) {
            return;
        }
        throw new IllegalStateException("QRouteApi should have QAPI Annotation, class=" + cls.getName());
    }

    public static <T extends QRouteApi> boolean d(Class<T> cls) {
        boolean z16;
        ConcurrentHashMap<Class<?>, b> concurrentHashMap = f276502a;
        b bVar = concurrentHashMap.get(cls);
        if (bVar != null && bVar.f276505b != null) {
            return bVar.f276505b.booleanValue();
        }
        synchronized (f276503b[cls.hashCode() % 10]) {
            b bVar2 = concurrentHashMap.get(cls);
            if (bVar2 != null && bVar2.f276505b != null) {
                return bVar2.f276505b.booleanValue();
            }
            QRouteFactory qRouteFactory = null;
            byte b16 = 0;
            if (bVar2 == null) {
                bVar2 = new b(b16 == true ? 1 : 0);
            }
            if (cls.isAnnotationPresent(QRouteFactory.class)) {
                qRouteFactory = (QRouteFactory) cls.getAnnotation(QRouteFactory.class);
            }
            if (qRouteFactory != null && !qRouteFactory.singleton()) {
                z16 = false;
                bVar2.f276505b = Boolean.valueOf(z16);
                concurrentHashMap.put(cls, bVar2);
                return bVar2.f276505b.booleanValue();
            }
            z16 = true;
            bVar2.f276505b = Boolean.valueOf(z16);
            concurrentHashMap.put(cls, bVar2);
            return bVar2.f276505b.booleanValue();
        }
    }
}
