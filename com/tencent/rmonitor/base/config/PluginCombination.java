package com.tencent.rmonitor.base.config;

import com.tencent.rmonitor.base.config.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/rmonitor/base/config/PluginCombination;", "", "B", "a", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class PluginCombination {

    @NotNull
    private static final Lazy A;

    /* renamed from: B, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private static final d f365272a;

    /* renamed from: b, reason: collision with root package name */
    private static final d f365273b;

    /* renamed from: c, reason: collision with root package name */
    private static final d f365274c;

    /* renamed from: d, reason: collision with root package name */
    private static final d f365275d;

    /* renamed from: e, reason: collision with root package name */
    private static final d f365276e;

    /* renamed from: f, reason: collision with root package name */
    private static final d f365277f;

    /* renamed from: g, reason: collision with root package name */
    private static final d f365278g;

    /* renamed from: h, reason: collision with root package name */
    private static final d f365279h;

    /* renamed from: i, reason: collision with root package name */
    private static final d f365280i;

    /* renamed from: j, reason: collision with root package name */
    private static final d f365281j;

    /* renamed from: k, reason: collision with root package name */
    private static final d f365282k;

    /* renamed from: l, reason: collision with root package name */
    private static final d f365283l;

    /* renamed from: m, reason: collision with root package name */
    private static final d f365284m;

    /* renamed from: n, reason: collision with root package name */
    private static final d f365285n;

    /* renamed from: o, reason: collision with root package name */
    private static final d f365286o;

    /* renamed from: p, reason: collision with root package name */
    private static final d f365287p;

    /* renamed from: q, reason: collision with root package name */
    private static final d f365288q;

    /* renamed from: r, reason: collision with root package name */
    private static final d f365289r;

    /* renamed from: s, reason: collision with root package name */
    private static final d f365290s;

    /* renamed from: t, reason: collision with root package name */
    private static final d f365291t;

    /* renamed from: u, reason: collision with root package name */
    private static final d f365292u;

    /* renamed from: v, reason: collision with root package name */
    private static final d f365293v;

    /* renamed from: w, reason: collision with root package name */
    private static final d f365294w;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    private static final List<d> f365295x;

    /* renamed from: y, reason: collision with root package name */
    private static final List<d> f365296y;

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    private static final Lazy f365297z;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b \b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000fR\u0014\u0010\u001b\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u0014\u0010\u001c\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000fR\u0014\u0010\u001d\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000fR\u0014\u0010\u001e\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000fR\u0014\u0010\u001f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u000fR\u0014\u0010 \u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u000fR\u0014\u0010!\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u000bR\u0014\u0010#\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u000fR\u0014\u0010$\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u000fR\u0014\u0010%\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u000fR\u0014\u0010&\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u000f\u00a8\u0006)"}, d2 = {"Lcom/tencent/rmonitor/base/config/PluginCombination$a;", "", "Lkotlin/Function1;", "Lcom/tencent/rmonitor/base/config/d;", "block", "a", "", "pluginName", "c", "", "allPlugin", "Ljava/util/List;", "b", "()Ljava/util/List;", "asanPlugin", "Lcom/tencent/rmonitor/base/config/d;", "batteryElementMetricPlugin", "batteryElementPlugin", "batteryMetricPlugin", "batteryPlugin", "bigBitmapPlugin", "ceilingHprofPlugin", "dbPlugin", "devicePlugin", "fdLeakPlugin", "ioPlugin", "launchMetricPlugin", "leakPlugin", "loopStackPlugin", "looperMetricPlugin", "memoryQuantilePlugin", "natMemPlugin", "netQualityPlugin", "pageLaunchPlugin", "stablePlugins", "subMemoryQuantilePlugin", "trafficDetailMetricPlugin", "trafficMetricPlugin", "workThreadLagPlugin", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.base.config.PluginCombination$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ KProperty[] f365298a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "modeAllNames", "getModeAllNames()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "modeStableNames", "getModeStableNames()Ljava/util/List;"))};

        Companion() {
        }

        @Nullable
        public final Object a(@NotNull Function1<? super d, ? extends Object> block) {
            Intrinsics.checkParameterIsNotNull(block, "block");
            Iterator<T> it = b().iterator();
            Object obj = null;
            while (it.hasNext()) {
                obj = block.invoke((d) it.next());
            }
            return obj;
        }

        @NotNull
        public final List<d> b() {
            return PluginCombination.f365295x;
        }

        @JvmStatic
        @Nullable
        public final d c(@NotNull String pluginName) {
            Object obj;
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Iterator<T> it = b().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((d) obj).pluginName, pluginName)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            return (d) obj;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        List<d> listOf;
        List<d> listOf2;
        Lazy lazy;
        Lazy lazy2;
        d.m mVar = new d.m(null, null, 3, null);
        f365272a = mVar;
        d.g gVar = new d.g(null, null, 3, null);
        f365273b = gVar;
        d.j jVar = new d.j(null, null, 3, null);
        f365274c = jVar;
        d.l lVar = new d.l(null, null, 3, null);
        f365275d = lVar;
        d.f fVar = new d.f(null, null, 3, null);
        f365276e = fVar;
        d.h hVar = new d.h(null, null, 3, null);
        f365277f = hVar;
        d.o oVar = new d.o(null, null, 3, null);
        f365278g = oVar;
        d.t tVar = new d.t(null, null, 3, null);
        f365279h = tVar;
        d.i iVar = new d.i(null, null, 3, null);
        f365280i = iVar;
        d.p pVar = new d.p(null, null, 3, null);
        f365281j = pVar;
        d.a aVar = new d.a(null, null, 3, null);
        f365282k = aVar;
        d.e eVar = new d.e(null, null, 3, null);
        f365283l = eVar;
        d.s sVar = new d.s(null, null, 3, null);
        f365284m = sVar;
        d.n nVar = new d.n(null, null, 3, null);
        f365285n = nVar;
        d.k kVar = new d.k(null, null, 3, null);
        f365286o = kVar;
        d.w wVar = new d.w(null, null, 3, null);
        f365287p = wVar;
        d.v vVar = new d.v(null, null, 3, null);
        f365288q = vVar;
        d.u uVar = new d.u(null, null, 3, null);
        f365289r = uVar;
        d.q qVar = new d.q(null, null, 3, null);
        f365290s = qVar;
        d.C9744d c9744d = new d.C9744d(null, null, 3, null);
        f365291t = c9744d;
        d.c cVar = new d.c(null, null, 3, null);
        f365292u = cVar;
        d.b bVar = new d.b(null, null, 3, null);
        f365293v = bVar;
        d.r rVar = new d.r(null, null, 3, null);
        f365294w = rVar;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new d[]{jVar, gVar, hVar, mVar, lVar, iVar, pVar, aVar, eVar, sVar, fVar, nVar, oVar, tVar, kVar, wVar, vVar, uVar, qVar, cVar, c9744d, bVar, rVar});
        f365295x = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new d[]{mVar, nVar, lVar, eVar, iVar, pVar, vVar, uVar, qVar, cVar, c9744d, bVar, fVar, rVar});
        f365296y = listOf2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<String>>() { // from class: com.tencent.rmonitor.base.config.PluginCombination$Companion$modeAllNames$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<String> invoke() {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = PluginCombination.INSTANCE.b().iterator();
                while (it.hasNext()) {
                    arrayList.add(((d) it.next()).pluginName);
                }
                return arrayList;
            }
        });
        f365297z = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<List<String>>() { // from class: com.tencent.rmonitor.base.config.PluginCombination$Companion$modeStableNames$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<String> invoke() {
                List list;
                ArrayList arrayList = new ArrayList();
                list = PluginCombination.f365296y;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((d) it.next()).pluginName);
                }
                return arrayList;
            }
        });
        A = lazy2;
    }
}
