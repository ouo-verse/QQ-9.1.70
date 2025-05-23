package com.tencent.luggage.wxa.ii;

import android.util.ArrayMap;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.hn.k1;
import com.tencent.luggage.wxa.ii.a;
import com.tencent.luggage.wxa.ii.c;
import com.tencent.luggage.wxa.ii.k;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f130565a = new m();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class a implements c.a {
        @Override // com.tencent.luggage.wxa.ii.c.a
        public /* synthetic */ void a() {
            u21.a.a(this);
        }

        @Override // com.tencent.luggage.wxa.ii.k.c
        public /* synthetic */ void b(k.d dVar, k.e eVar) {
            u21.b.b(this, dVar, eVar);
        }

        @Override // com.tencent.luggage.wxa.ii.c.a
        public /* synthetic */ void a(k.d dVar) {
            u21.a.b(this, dVar);
        }

        @Override // com.tencent.luggage.wxa.ii.k.c
        public /* synthetic */ void a(k.d dVar, int i3, String str) {
            u21.b.a(this, dVar, i3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f130566a = new b();

        public b() {
            super(1);
        }

        public final void a(k.d dVar) {
            Intrinsics.checkNotNullParameter(dVar, "<anonymous parameter 0>");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((k.d) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dk.b f130567a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k1 f130568b;

        public c(com.tencent.luggage.wxa.dk.b bVar, k1 k1Var) {
            this.f130567a = bVar;
            this.f130568b = k1Var;
        }

        @Override // com.tencent.luggage.wxa.ii.k.c
        public void a(k.d request, k.e response) {
            boolean contains;
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(response, "response");
            if ((request.g() instanceof k.g.b) && !((k.g.b) request.g()).a()) {
                int[] PLUGINCODE_PACKAGE_TYPES = com.tencent.luggage.wxa.ip.a.f130734d;
                Intrinsics.checkNotNullExpressionValue(PLUGINCODE_PACKAGE_TYPES, "PLUGINCODE_PACKAGE_TYPES");
                contains = ArraysKt___ArraysKt.contains(PLUGINCODE_PACKAGE_TYPES, request.e());
                if (contains) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils", "onPkgCached, will update plugin(" + request.a() + ") to latest in background...");
                    com.tencent.luggage.wxa.zp.h.f146825d.d(new a(request, this.f130568b, this.f130567a.f124303a, response));
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k.d f130569a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k1 f130570b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f130571c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ k.e f130572d;

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class b extends Lambda implements Function1 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ k.d f130576a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ k.e f130577b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(k.d dVar, k.e eVar) {
                    super(1);
                    this.f130576a = dVar;
                    this.f130577b = eVar;
                }

                public final void a(k.e it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils", "update plugin(" + this.f130576a.a() + ") to latest succeed, version=" + this.f130577b.a().getPkgAppVersion() + ", source=" + this.f130577b.b());
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((k.e) obj);
                    return Unit.INSTANCE;
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.ii.m$c$a$c, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6317c extends Lambda implements Function2 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ k.d f130578a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f130579b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ AtomicInteger f130580c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ AtomicReference f130581d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C6317c(k.d dVar, String str, AtomicInteger atomicInteger, AtomicReference atomicReference) {
                    super(2);
                    this.f130578a = dVar;
                    this.f130579b = str;
                    this.f130580c = atomicInteger;
                    this.f130581d = atomicReference;
                }

                public final void a(k.a err, Throwable errMsg) {
                    Intrinsics.checkNotNullParameter(err, "err");
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils", "update plugin(" + this.f130578a.a() + ") to latest failed, ERROR(" + err + ") errMsg(" + errMsg + ')');
                    a.C6306a c6306a = com.tencent.luggage.wxa.ii.a.f130415h;
                    String instanceId = this.f130579b;
                    Intrinsics.checkNotNullExpressionValue(instanceId, "instanceId");
                    c6306a.a(instanceId, com.tencent.luggage.wxa.lg.b.UPDATE_FAILED, this.f130578a.a(), this.f130580c.get(), (String) this.f130581d.get());
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((k.a) obj, (Throwable) obj2);
                    return Unit.INSTANCE;
                }
            }

            public a(k.d dVar, k1 k1Var, String str, k.e eVar) {
                this.f130569a = dVar;
                this.f130570b = k1Var;
                this.f130571c = str;
                this.f130572d = eVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AtomicInteger atomicInteger = new AtomicInteger(0);
                AtomicReference atomicReference = new AtomicReference();
                k.f130516a.a(new k.d(this.f130569a.a(), this.f130569a.d(), this.f130569a.e(), this.f130569a.h(), ((k.g.b) this.f130569a.g()).c(), false, null, 64, null), new b(this.f130569a, this.f130572d), new C6317c(this.f130569a, this.f130571c, atomicInteger, atomicReference), (r20 & 8) != 0 ? k.b.a.f130530a : null, (r20 & 16) != 0 ? j.f130505a : null, (r20 & 32) != 0 ? 0 : 0, this.f130570b, (r20 & 128) != 0 ? null : new C6316a(this.f130571c, atomicInteger, atomicReference));
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.ii.m$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6316a implements k.c {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f130573a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ AtomicInteger f130574b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ AtomicReference f130575c;

                public C6316a(String str, AtomicInteger atomicInteger, AtomicReference atomicReference) {
                    this.f130573a = str;
                    this.f130574b = atomicInteger;
                    this.f130575c = atomicReference;
                }

                @Override // com.tencent.luggage.wxa.ii.k.c
                public void a(k.d request, int i3, String str) {
                    Intrinsics.checkNotNullParameter(request, "request");
                    a.C6306a c6306a = com.tencent.luggage.wxa.ii.a.f130415h;
                    String instanceId = this.f130573a;
                    Intrinsics.checkNotNullExpressionValue(instanceId, "instanceId");
                    c6306a.a(instanceId, com.tencent.luggage.wxa.lg.b.UPDATING, request.a(), i3, str);
                    this.f130574b.set(i3);
                    this.f130575c.set(str);
                }

                @Override // com.tencent.luggage.wxa.ii.k.c
                public void b(k.d request, k.e response) {
                    Intrinsics.checkNotNullParameter(request, "request");
                    Intrinsics.checkNotNullParameter(response, "response");
                    com.tencent.luggage.wxa.mc.j a16 = response.a();
                    Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo");
                    WxaPluginPkgInfo wxaPluginPkgInfo = (WxaPluginPkgInfo) a16;
                    a.C6306a c6306a = com.tencent.luggage.wxa.ii.a.f130415h;
                    String instanceId = this.f130573a;
                    Intrinsics.checkNotNullExpressionValue(instanceId, "instanceId");
                    c6306a.a(instanceId, com.tencent.luggage.wxa.lg.b.UPDATE_READY, request.a(), wxaPluginPkgInfo.version, wxaPluginPkgInfo.stringVersion);
                }

                @Override // com.tencent.luggage.wxa.ii.k.c
                public void a(k.d request, k.e response) {
                    Intrinsics.checkNotNullParameter(request, "request");
                    Intrinsics.checkNotNullParameter(response, "response");
                    com.tencent.luggage.wxa.mc.j a16 = response.a();
                    Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo");
                    WxaPluginPkgInfo wxaPluginPkgInfo = (WxaPluginPkgInfo) a16;
                    a.C6306a c6306a = com.tencent.luggage.wxa.ii.a.f130415h;
                    String instanceId = this.f130573a;
                    Intrinsics.checkNotNullExpressionValue(instanceId, "instanceId");
                    c6306a.a(instanceId, com.tencent.luggage.wxa.lg.b.NO_UPDATE, request.a(), wxaPluginPkgInfo.version, wxaPluginPkgInfo.stringVersion);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((n0.i) obj2).f125944a), Integer.valueOf(((n0.i) obj).f125944a));
            return compareValues;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((n0.i) obj2).f125944a), Integer.valueOf(((n0.i) obj).f125944a));
            return compareValues;
        }
    }

    public static /* synthetic */ c.a a(m mVar, com.tencent.luggage.wxa.dk.b bVar, boolean z16, boolean z17, Function1 function1, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function1 = b.f130566a;
        }
        return mVar.a(bVar, z16, z17, function1);
    }

    public final /* synthetic */ c.a a(com.tencent.luggage.wxa.dk.b reportQualitySession, boolean z16, boolean z17, Function1 onPkgMissed) {
        Intrinsics.checkNotNullParameter(reportQualitySession, "reportQualitySession");
        Intrinsics.checkNotNullParameter(onPkgMissed, "onPkgMissed");
        k1 k1Var = new k1();
        k1Var.f127976d = reportQualitySession.f124307e;
        k1Var.f127977e = z17;
        k1Var.f127978f = 1;
        return new c(reportQualitySession, k1Var);
    }

    public final boolean a(com.tencent.luggage.wxa.rc.q qVar, boolean z16) {
        if (z16) {
            return true;
        }
        String h16 = qVar.h("injectAppSeparatedPlugin");
        return h16 != null && Boolean.parseBoolean(h16);
    }

    public final boolean a(String appId, int i3, int i16, boolean z16, com.tencent.luggage.wxa.rc.q qVar) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (e.a.a(i3)) {
            if (qVar != null && a(qVar, z16)) {
                return true;
            }
        } else if (qVar != null && a(qVar, z16)) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Map a(n0.g gVar, String appId, boolean z16) {
        List<n0.i> sortedWith;
        List sortedWith2;
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        Intrinsics.checkNotNullParameter(appId, "appId");
        List list = gVar.f125928i;
        boolean z17 = true;
        if (!(list == null || list.isEmpty())) {
            ArrayMap arrayMap = new ArrayMap(gVar.f125928i.size());
            for (n0.h hVar : gVar.f125928i) {
                if (!z16) {
                    r6 = new n0.i();
                    r6.f125944a = 4;
                    r6.f125945b = hVar.f125934b;
                } else {
                    List list2 = hVar.f125940h;
                    if (list2 == null || list2.isEmpty()) {
                        List list3 = hVar.f125938f;
                        if (!(list3 == null || list3.isEmpty())) {
                            r6 = new n0.i();
                            r6.f125945b = hVar.f125939g;
                            r6.f125944a = 13;
                            r6.f125946c = new LinkedList(hVar.f125938f);
                        } else {
                            r6 = new n0.i();
                            r6.f125944a = 4;
                            r6.f125945b = hVar.f125934b;
                        }
                    } else {
                        List list4 = hVar.f125940h;
                        Intrinsics.checkNotNullExpressionValue(list4, "this.wxaWidgetInfoList");
                        sortedWith = CollectionsKt___CollectionsKt.sortedWith(list4, new e());
                        for (n0.i iVar : sortedWith) {
                            if (iVar.f125944a <= 23) {
                                break;
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                }
                arrayMap.put(hVar.f125933a, iVar);
            }
            return arrayMap;
        }
        if (!z16) {
            n0.i iVar2 = new n0.i();
            iVar2.f125944a = 0;
            iVar2.f125945b = gVar.f125923d;
            Unit unit = Unit.INSTANCE;
            return a(ModulePkgInfo.MAIN_MODULE_NAME, iVar2);
        }
        List list5 = gVar.C;
        if (list5 == null || list5.isEmpty()) {
            List list6 = gVar.f125926g;
            if (list6 != null && !list6.isEmpty()) {
                z17 = false;
            }
            if (!z17) {
                n0.i iVar3 = new n0.i();
                iVar3.f125945b = gVar.f125932m;
                iVar3.f125944a = 12;
                iVar3.f125946c = new LinkedList(gVar.f125926g);
                Unit unit2 = Unit.INSTANCE;
                return a(ModulePkgInfo.MAIN_MODULE_NAME, iVar3);
            }
            n0.i iVar4 = new n0.i();
            iVar4.f125944a = 0;
            iVar4.f125945b = gVar.f125923d;
            Unit unit3 = Unit.INSTANCE;
            return a(ModulePkgInfo.MAIN_MODULE_NAME, iVar4);
        }
        List list7 = gVar.C;
        Intrinsics.checkNotNullExpressionValue(list7, "this.widgetInfoList");
        sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(list7, new d());
        for (Object obj : sortedWith2) {
            n0.i iVar5 = (n0.i) obj;
            if (iVar5.f125944a <= 23) {
                List list8 = iVar5.f125946c;
                if (list8 != null && !list8.isEmpty()) {
                    z17 = false;
                }
                if (z17) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils", "WxaVersionInfo.pickAppropriateWidgetInfoList appId(" + appId + ") module(FALSE) split_plugin(TRUE) widgetInfo.wxaPluginCodeInfo isNullOrEmpty");
                    iVar5.f125946c = gVar.f125926g;
                }
                Unit unit4 = Unit.INSTANCE;
                return a(ModulePkgInfo.MAIN_MODULE_NAME, obj);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final Map a(Object obj, Object obj2) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(obj, obj2);
        return arrayMap;
    }
}
