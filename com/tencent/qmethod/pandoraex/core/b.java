package com.tencent.qmethod.pandoraex.core;

import android.database.Cursor;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final n f344019a = new n();

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, n> f344020b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f344021c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f344022d = null;

    private static <T> Class a(vr3.a<T> aVar) {
        Class cls = aVar.f443221f;
        if (cls != null) {
            return cls;
        }
        T t16 = aVar.f443220e;
        if (t16 != null) {
            return t16.getClass();
        }
        return null;
    }

    private <T> T c(vr3.a<T> aVar, Object... objArr) throws Throwable {
        if (!com.tencent.qmethod.pandoraex.api.e.o(aVar)) {
            return aVar.f443220e;
        }
        return (T) com.tencent.qmethod.pandoraex.api.e.a(aVar, objArr, new Object[0]);
    }

    public static b d() {
        if (f344022d == null) {
            synchronized (b.class) {
                if (f344022d == null) {
                    f344022d = new b();
                }
            }
        }
        return f344022d;
    }

    private n e(vr3.a aVar) {
        if (aVar.f443224i) {
            ConcurrentHashMap<String, n> concurrentHashMap = f344020b;
            n nVar = concurrentHashMap.get(aVar.f443216a);
            if (nVar == null) {
                synchronized (f344021c) {
                    nVar = concurrentHashMap.get(aVar.f443216a);
                    if (nVar == null) {
                        nVar = new n();
                        concurrentHashMap.put(aVar.f443216a, nVar);
                    }
                }
            }
            return nVar;
        }
        return f344019a;
    }

    private <T> T f(vr3.a<T> aVar) {
        return (T) aVar.b(e(aVar).a(aVar.f443217b, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T g(vr3.a<T> aVar) {
        Object i3 = com.tencent.qmethod.pandoraex.api.r.i(com.tencent.qmethod.pandoraex.api.q.b(), aVar.f443217b, a(aVar));
        if (i3 != null) {
            e(aVar).b(aVar.f443217b, i3);
        }
        return (T) aVar.b(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    private <T> T i(vr3.a<T> aVar, k<T> kVar, com.tencent.qmethod.pandoraex.api.d dVar) {
        if (com.tencent.qmethod.pandoraex.api.q.m()) {
            o.e("", aVar.f443217b + " callingSysAPI");
        }
        T call = kVar.call();
        l(aVar);
        Object c16 = aVar.c(call);
        boolean equals = "normal".equals(dVar.f343900a);
        if (call != null && aVar.d() && (!equals || !(c16 instanceof Cursor))) {
            e(aVar).b(aVar.f443217b, c16);
        }
        if (QQPermissionConstants.Permission.STORAGE_GROUP.equals(dVar.f343900a)) {
            com.tencent.qmethod.pandoraex.api.r.r(com.tencent.qmethod.pandoraex.api.q.b(), aVar.f443217b, c16, aVar.f443221f);
            e.d(aVar.f443217b, dVar.f343902c);
        }
        if (!equals && d.b(aVar.f443217b)) {
            d.e(aVar.f443217b, false);
        }
        return call;
    }

    @Nullable
    private <T> T j(vr3.a<T> aVar, k<T> kVar, HashMap<String, String> hashMap, Object[] objArr) throws Throwable {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport(aVar.f443216a, aVar.f443217b, aVar, hashMap);
        if (x.C(strategyAndReport)) {
            if (x.x(strategyAndReport.f343900a)) {
                boolean k3 = k(aVar);
                try {
                    if (k3) {
                        T t16 = (T) f(aVar);
                        if (t16 != null && !d.b(aVar.f443217b)) {
                            return t16;
                        }
                        return (T) i(aVar, kVar, strategyAndReport);
                    }
                    return (T) i(aVar, kVar, strategyAndReport);
                } finally {
                    m(aVar, k3);
                }
            }
            return (T) i(aVar, kVar, strategyAndReport);
        }
        if (x.A(strategyAndReport)) {
            T t17 = (T) f(aVar);
            if ("memory".equals(strategyAndReport.f343900a)) {
                if (t17 == null) {
                    return (T) c(aVar, objArr);
                }
                return t17;
            }
            if (t17 != null) {
                return t17;
            }
            if (aVar.f443221f == null && aVar.f443220e == null) {
                return (T) c(aVar, objArr);
            }
            T t18 = (T) g(aVar);
            if (t18 != null) {
                return t18;
            }
        }
        return (T) c(aVar, objArr);
    }

    private <T> boolean k(vr3.a<T> aVar) throws InterruptedException {
        Lock lock = aVar.f443226k;
        if (lock != null) {
            long j3 = aVar.f443227l;
            if (j3 > 0) {
                return lock.tryLock(j3, TimeUnit.MILLISECONDS);
            }
            lock.lock();
            return true;
        }
        return false;
    }

    private void l(vr3.a aVar) {
        String str = aVar.f443222g;
        if (str != null) {
            MonitorReporter.handleEventReport(str, aVar.f443223h);
        }
    }

    private <T> void m(vr3.a<T> aVar, boolean z16) {
        Lock lock = aVar.f443226k;
        if (lock != null) {
            if (aVar.f443227l > 0) {
                if (z16) {
                    lock.unlock();
                    return;
                }
                return;
            }
            lock.unlock();
        }
    }

    public <T> T b(vr3.a<T> aVar, k<T> kVar, HashMap<String, String> hashMap, Object... objArr) throws Throwable {
        return (T) j(aVar, kVar, hashMap, objArr);
    }

    public String h(String str, String str2) {
        n nVar;
        Object a16 = f344019a.a(str2, null);
        if (a16 == null && (nVar = f344020b.get(str)) != null) {
            a16 = nVar.a(str2, null);
        }
        if (a16 == null) {
            return com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), str2);
        }
        if (a16 instanceof String) {
            return (String) a16;
        }
        return "";
    }
}
