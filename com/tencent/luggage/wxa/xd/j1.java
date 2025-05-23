package com.tencent.luggage.wxa.xd;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class j1 {

    /* renamed from: a, reason: collision with root package name */
    public static final j1 f144855a = new j1();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f144856b = new LinkedHashMap();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f144857a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e0 f144858b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y yVar, e0 e0Var) {
            super(0);
            this.f144857a = yVar;
            this.f144858b = e0Var;
        }

        public final void a() {
            j1.f144855a.a(this.f144857a, this.f144858b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void a(j1 j1Var, y yVar, long j3, e0 e0Var, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 10000;
        }
        j1Var.a(yVar, j3, e0Var);
    }

    public final void a(y type, long j3, e0 watcher) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(watcher, "watcher");
        Map map = f144856b;
        synchronized (map) {
            Object obj = map.get(type);
            if (obj == null) {
                obj = new HashSet();
                map.put(type, obj);
            }
            ((HashSet) obj).add(watcher);
        }
        com.tencent.luggage.wxa.h6.d.a(j3, new a(type, watcher));
    }

    public final void a(y type, e0 watcher) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(watcher, "watcher");
        Map map = f144856b;
        synchronized (map) {
            HashSet hashSet = (HashSet) map.get(type);
            if (hashSet != null) {
                hashSet.remove(watcher);
            }
        }
    }

    public final void a(y type, String url) {
        HashSet hashSet;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(url, "url");
        Map map = f144856b;
        synchronized (map) {
            hashSet = new HashSet();
            Object obj = map.get(type);
            if (obj == null) {
                obj = new HashSet();
                map.put(type, obj);
            }
            hashSet.addAll((Collection) obj);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((e0) it.next()).a(url);
        }
    }
}
