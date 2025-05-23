package com.tencent.aelight.camera.aeeditor.module.aifilter;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static final String f66175d = "a";

    /* renamed from: a, reason: collision with root package name */
    private long f66176a;

    /* renamed from: b, reason: collision with root package name */
    private long f66177b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<Integer, AIFilterProxyBase> f66178c = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aeeditor.module.aifilter.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public interface InterfaceC0571a {
        void a(int i3, c cVar);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        public static a f66179a = new a();
    }

    a() {
    }

    public static a a() {
        return b.f66179a;
    }

    public void b(int i3, int i16) {
        AIFilterProxyBase aIFilterProxyBase;
        String str = f66175d;
        ms.a.c(str, "onResponseFailed: errorCode=" + i3);
        ConcurrentHashMap<Integer, AIFilterProxyBase> concurrentHashMap = this.f66178c;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0 || (aIFilterProxyBase = this.f66178c.get(Integer.valueOf(i16))) == null) {
            return;
        }
        aIFilterProxyBase.c();
        InterfaceC0571a j3 = aIFilterProxyBase.j();
        if (j3 != null) {
            j3.a(i3, aIFilterProxyBase.h());
        } else {
            ms.a.f(str, "no observer, abandon response");
        }
    }

    public void c(List<com.tencent.aelight.camera.aeeditor.module.aifilter.b> list, int i3) {
        AIFilterProxyBase aIFilterProxyBase;
        String str = f66175d;
        ms.a.f(str, "onResponseSuccess");
        ConcurrentHashMap<Integer, AIFilterProxyBase> concurrentHashMap = this.f66178c;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0 || (aIFilterProxyBase = this.f66178c.get(Integer.valueOf(i3))) == null) {
            return;
        }
        ms.a.f(str, "proxy handleResponse");
        c k3 = aIFilterProxyBase.k(list);
        aIFilterProxyBase.c();
        this.f66177b = System.currentTimeMillis();
        ms.a.f(str, "AIFilterPref: cost = " + (this.f66177b - this.f66176a) + "ms");
        InterfaceC0571a j3 = aIFilterProxyBase.j();
        if (j3 != null) {
            ms.a.f(str, "has observer");
            if (k3 != null) {
                ms.a.f(str, "observer onAIFilterApplySuccess");
                j3.a(0, k3);
            } else {
                ms.a.f(str, "observer onAIFilterAppliedFailed, errorCode=-5");
                j3.a(-5, aIFilterProxyBase.h());
            }
            aIFilterProxyBase.l();
            return;
        }
        ms.a.f(str, "no observer, abandon response");
    }
}
