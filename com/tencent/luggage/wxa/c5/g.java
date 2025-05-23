package com.tencent.luggage.wxa.c5;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.luggage.wxa.b5.j;
import com.tencent.luggage.wxa.ic.v;
import com.tencent.luggage.wxa.tn.w;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.apache.commons.lang.ArrayUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f123332a = new g();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f123333b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f123334a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap invoke() {
            return new ConcurrentHashMap();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f123334a);
        f123333b = lazy;
    }

    public final e a(String appId, int i3) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        e eVar = (e) b().get(appId);
        if (eVar == null || i3 != eVar.l0()) {
            return null;
        }
        return eVar;
    }

    public final ConcurrentHashMap b() {
        return (ConcurrentHashMap) f123333b.getValue();
    }

    public final void c(e rt5) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        w.d("Luggage.LuggageRuntimeStore", "stash: appId [%s]", rt5.getAppId());
        rt5.a((v) null);
        ConcurrentHashMap b16 = b();
        String appId = rt5.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "rt.appId");
        b16.put(appId, rt5);
        new j(rt5).c();
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public final e b(com.tencent.luggage.wxa.j4.d dVar) {
        e eVar;
        int lastIndex;
        String str = dVar.f125808a;
        if (!a(dVar) || (eVar = (e) b().remove(str)) == null) {
            return null;
        }
        new com.tencent.luggage.wxa.b5.g(eVar).c();
        Boolean[] boolArr = {Boolean.valueOf(eVar.s0()), Boolean.valueOf(Intrinsics.areEqual(eVar.getAppId(), dVar.f125808a)), Boolean.valueOf(!eVar.w0()), Boolean.valueOf(!eVar.t0())};
        w.d("Luggage.LuggageRuntimeStore", "poll existed runtime[" + dVar.f125808a + "], conditions[" + ArrayUtils.toString(boolArr) + ']');
        Boolean bool = boolArr[0];
        lastIndex = ArraysKt___ArraysKt.getLastIndex(boolArr);
        ?? it = new IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            bool = Boolean.valueOf(bool.booleanValue() && boolArr[it.nextInt()].booleanValue());
        }
        if (bool.booleanValue()) {
            return eVar;
        }
        return null;
    }

    public final e a(com.tencent.luggage.wxa.j4.d cfg, v runtimeContainer) {
        Intrinsics.checkNotNullParameter(cfg, "cfg");
        Intrinsics.checkNotNullParameter(runtimeContainer, "runtimeContainer");
        e b16 = b(cfg);
        if (b16 != null) {
            b16.a(runtimeContainer);
        }
        return b16;
    }

    public final boolean a(e rt5) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        com.tencent.luggage.wxa.j4.d S = rt5.S();
        Intrinsics.checkNotNullExpressionValue(S, "rt.initConfig");
        return a(S);
    }

    public final boolean c() {
        return b().isEmpty();
    }

    public final boolean a(com.tencent.luggage.wxa.j4.d dVar) {
        return dVar.f130795g0;
    }

    public final void a() {
        Collection<e> values = b().values();
        Intrinsics.checkNotNullExpressionValue(values, "runtimeMap.values");
        for (e eVar : values) {
            com.tencent.luggage.wxa.il.g K = eVar.K();
            ViewParent parent = K != null ? K.getParent() : null;
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(eVar.K());
            }
        }
    }

    public final boolean b(e rt5) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        e eVar = (e) b().get(rt5.getAppId());
        if (!Intrinsics.areEqual(eVar, rt5)) {
            return false;
        }
        w.d("Luggage.LuggageRuntimeStore", "pop appId:" + rt5.getAppId() + ", rt:" + rt5);
        b().remove(eVar.getAppId());
        new com.tencent.luggage.wxa.b5.g(eVar).c();
        return true;
    }
}
