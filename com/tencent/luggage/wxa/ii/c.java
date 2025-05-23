package com.tencent.luggage.wxa.ii;

import android.util.Log;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.hn.j0;
import com.tencent.luggage.wxa.hn.k1;
import com.tencent.luggage.wxa.hn.u2;
import com.tencent.luggage.wxa.ii.k;
import com.tencent.luggage.wxa.ii.l;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.mc.g0;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f130433a = new c();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a extends k.c {
        void a();

        void a(k.d dVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements l {

        /* renamed from: a, reason: collision with root package name */
        public final String f130434a;

        /* renamed from: b, reason: collision with root package name */
        public final k1 f130435b;

        /* renamed from: c, reason: collision with root package name */
        public final LinkedList f130436c;

        /* renamed from: d, reason: collision with root package name */
        public final HashMap f130437d;

        /* renamed from: e, reason: collision with root package name */
        public int f130438e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f130439f;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function1 {
            public a() {
                super(1);
            }

            public final void a(j0 batchResp) {
                Intrinsics.checkNotNullParameter(batchResp, "batchResp");
                Set<Map.Entry> entrySet = b.this.f130437d.entrySet();
                Intrinsics.checkNotNullExpressionValue(entrySet, "requestCallbacks.entries");
                for (Map.Entry e16 : entrySet) {
                    Intrinsics.checkNotNullExpressionValue(e16, "e");
                    l.a req = (l.a) com.tencent.luggage.wxa.ii.f.a(e16);
                    Function1 function1 = (Function1) ((Pair) com.tencent.luggage.wxa.ii.f.b(e16)).component1();
                    Intrinsics.checkNotNullExpressionValue(req, "req");
                    u2[] a16 = com.tencent.luggage.wxa.ii.f.a(batchResp, req);
                    Intrinsics.checkNotNull(a16);
                    function1.invoke(a16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((j0) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ii.c$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6307b extends Lambda implements Function1 {
            public C6307b() {
                super(1);
            }

            public final void a(Throwable ex5) {
                Intrinsics.checkNotNullParameter(ex5, "ex");
                Collection values = b.this.f130437d.values();
                Intrinsics.checkNotNullExpressionValue(values, "requestCallbacks.values");
                Iterator it = values.iterator();
                while (it.hasNext()) {
                    ((Function1) ((Pair) it.next()).component2()).invoke(ex5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return Unit.INSTANCE;
            }
        }

        public b(String session, Collection requestPkgInfoList, k1 cgiCommRequestSource) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(requestPkgInfoList, "requestPkgInfoList");
            Intrinsics.checkNotNullParameter(cgiCommRequestSource, "cgiCommRequestSource");
            this.f130434a = session;
            this.f130435b = cgiCommRequestSource;
            this.f130436c = new LinkedList(requestPkgInfoList);
            this.f130437d = new HashMap();
        }

        public final int a(k.d dVar, l.a aVar) {
            if (!Intrinsics.areEqual(dVar.a(), aVar.a()) || dVar.e() != aVar.g() || dVar.h() != aVar.j()) {
                return -1;
            }
            String d16 = dVar.d();
            if (d16 == null) {
                d16 = "";
            }
            String e16 = aVar.e();
            if (Intrinsics.areEqual(d16, e16 != null ? e16 : "")) {
                return 0;
            }
            if (Intrinsics.areEqual(ModulePkgInfo.MAIN_MODULE_NAME, dVar.d())) {
                String e17 = aVar.e();
                if (e17 == null || e17.length() == 0) {
                    return 0;
                }
            }
            return 1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0037, code lost:
        
            r5.remove();
            r1.f130438e = r1.f130438e;
            r1.f130437d.put(r2, new kotlin.Pair(r3, r4));
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.BatchGetCodePkgExecutor", r1 + " waitForDownloadUrl request:" + r2);
            a();
         */
        @Override // com.tencent.luggage.wxa.ii.l
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void a(l.a request, Function1 onSuccess, Function1 onError, int i3, k1 cgiCommRequestSource) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            Intrinsics.checkNotNullParameter(cgiCommRequestSource, "cgiCommRequestSource");
            Iterator it = this.f130436c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                k.d waitingRequest = (k.d) it.next();
                Intrinsics.checkNotNullExpressionValue(waitingRequest, "waitingRequest");
                if (a(waitingRequest, request) == 0) {
                    break;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
        
            r0.remove();
            a();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final synchronized void a(k.d request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Iterator it = this.f130436c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((k.d) it.next()).compareTo(request) == 0) {
                    break;
                }
            }
        }

        public final void a() {
            String joinToString$default;
            if (!this.f130436c.isEmpty()) {
                return;
            }
            if (this.f130437d.size() <= 0) {
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.BatchGetCodePkgExecutor", "session(" + this.f130434a + ")fireAllRequestsIfNeed requestCallbacks.size <= 0");
                return;
            }
            if (this.f130439f) {
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.BatchGetCodePkgExecutor", "session(" + this.f130434a + ")fireAllRequestsIfNeed cgi reentry!");
                return;
            }
            try {
                LinkedList linkedList = new LinkedList(this.f130437d.keySet());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("session(");
                sb5.append(this.f130434a);
                sb5.append(")fireAllRequestsIfNeed real call CgiRouter with requests(");
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(linkedList, ",", null, null, 0, null, null, 62, null);
                sb5.append(joinToString$default);
                sb5.append(')');
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.BatchGetCodePkgExecutor", sb5.toString());
                j.f130505a.a(linkedList, new a(), new C6307b(), this.f130438e, this.f130435b);
            } finally {
                this.f130439f = true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public static final d f130444a = new d();

        public d() {
            super(2);
        }

        public final void a(int i3, Throwable th5) {
            Intrinsics.checkNotNullParameter(th5, "<anonymous parameter 1>");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Number) obj).intValue(), (Throwable) obj2);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConcurrentSkipListSet f130445a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k.d f130446b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ C6308c f130447c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ HashSet f130448d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f130449e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function1 f130450f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ a f130451g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ b f130452h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ConcurrentSkipListSet concurrentSkipListSet, k.d dVar, C6308c c6308c, HashSet hashSet, String str, Function1 function1, a aVar, b bVar) {
            super(1);
            this.f130445a = concurrentSkipListSet;
            this.f130446b = dVar;
            this.f130447c = c6308c;
            this.f130448d = hashSet;
            this.f130449e = str;
            this.f130450f = function1;
            this.f130451g = aVar;
            this.f130452h = bVar;
        }

        public final void a(k.e response) {
            List list;
            Intrinsics.checkNotNullParameter(response, "response");
            boolean add = this.f130445a.add(response.a());
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.BatchGetCodePkgExecutor", "waitForPkg " + this.f130446b + " onSuccess(" + response.a().getPkgAppVersion() + QbAddrData.DATA_SPLITER + response.b() + ") added(" + add + ')');
            if (add) {
                C6308c c6308c = this.f130447c;
                k.d request = this.f130446b;
                Intrinsics.checkNotNullExpressionValue(request, "request");
                String pkgFilePath = response.a().getPkgFilePath();
                Intrinsics.checkNotNull(pkgFilePath);
                c6308c.a(request, pkgFilePath);
                if (this.f130445a.size() == this.f130448d.size()) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.BatchGetCodePkgExecutor", "session(" + this.f130449e + ") waitForPkg all completed");
                    Function1 function1 = this.f130450f;
                    list = CollectionsKt___CollectionsKt.toList(this.f130445a);
                    function1.invoke(list);
                    a aVar = this.f130451g;
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                if (response.b() == k.f.CACHED) {
                    b bVar = this.f130452h;
                    if (!(bVar instanceof b)) {
                        bVar = null;
                    }
                    if (bVar != null) {
                        k.d request2 = this.f130446b;
                        Intrinsics.checkNotNullExpressionValue(request2, "request");
                        bVar.a(request2);
                    }
                }
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((k.e) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k.d f130453a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f130454b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function2 f130455c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f130456d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(k.d dVar, AtomicBoolean atomicBoolean, Function2 function2, a aVar) {
            super(2);
            this.f130453a = dVar;
            this.f130454b = atomicBoolean;
            this.f130455c = function2;
            this.f130456d = aVar;
        }

        public final void a(k.a err, Throwable ex5) {
            Intrinsics.checkNotNullParameter(err, "err");
            Intrinsics.checkNotNullParameter(ex5, "ex");
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.BatchGetCodePkgExecutor", "waitForPkg " + this.f130453a + " onError(" + err + TokenParser.SP + ex5 + "), stack=" + Log.getStackTraceString(new Throwable()));
            if (!this.f130454b.getAndSet(true)) {
                this.f130455c.invoke(Integer.valueOf(err.b()), ex5);
                this.f130454b.set(true);
            }
            a aVar = this.f130456d;
            if (aVar != null) {
                k.d request = this.f130453a;
                Intrinsics.checkNotNullExpressionValue(request, "request");
                aVar.a(request);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((k.a) obj, (Throwable) obj2);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C6308c f130457a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k.d f130458b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(C6308c c6308c, k.d dVar) {
            super(1);
            this.f130457a = c6308c;
            this.f130458b = dVar;
        }

        public final void a(g0 progress) {
            Intrinsics.checkNotNullParameter(progress, "progress");
            C6308c c6308c = this.f130457a;
            k.d request = this.f130458b;
            Intrinsics.checkNotNullExpressionValue(request, "request");
            c6308c.a(request, progress);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g0) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        public static final h f130459a = new h();

        /* JADX WARN: Removed duplicated region for block: B:11:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int compare(com.tencent.luggage.wxa.mc.j jVar, com.tencent.luggage.wxa.mc.j jVar2) {
            boolean z16;
            if (Intrinsics.areEqual(jVar.getClass(), jVar2.getClass())) {
                if (jVar instanceof WxaPluginPkgInfo) {
                    Intrinsics.checkNotNull(jVar2, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo");
                    WxaPluginPkgInfo wxaPluginPkgInfo = (WxaPluginPkgInfo) jVar2;
                    WxaPluginPkgInfo wxaPluginPkgInfo2 = (WxaPluginPkgInfo) jVar;
                    if (Intrinsics.areEqual(wxaPluginPkgInfo2.provider, wxaPluginPkgInfo.provider) && wxaPluginPkgInfo2.version == wxaPluginPkgInfo.version) {
                        z16 = true;
                    }
                } else if (jVar instanceof ModulePkgInfo) {
                    Intrinsics.checkNotNull(jVar2, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo");
                    z16 = ((ModulePkgInfo) jVar).isAssignable((ModulePkgInfo) jVar2);
                }
                if (!z16) {
                    return 0;
                }
                return jVar.hashCode() - jVar2.hashCode();
            }
            z16 = false;
            if (!z16) {
            }
        }
    }

    public final void a(String appId, int i3, int i16, List requestedModuleNames, Map pickedModuleInfoList, com.tencent.luggage.wxa.dk.b reportQualitySession, Function1 onSuccess, Function1 onProgress, Function2 onError, boolean z16, k1 cgiCommRequestSource, a aVar, Map map) {
        String joinToString$default;
        n0.i iVar;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(requestedModuleNames, "requestedModuleNames");
        Intrinsics.checkNotNullParameter(pickedModuleInfoList, "pickedModuleInfoList");
        Intrinsics.checkNotNullParameter(reportQualitySession, "reportQualitySession");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onProgress, "onProgress");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(cgiCommRequestSource, "cgiCommRequestSource");
        HashSet hashSet = new HashSet();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("instanceId:");
        sb5.append(reportQualitySession.f124303a);
        sb5.append(", appId:");
        sb5.append(appId);
        sb5.append(", modules:(");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(requestedModuleNames, ",", null, null, 0, null, null, 62, null);
        sb5.append(joinToString$default);
        sb5.append(')');
        String sb6 = sb5.toString();
        Iterator it = requestedModuleNames.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            n0.i iVar2 = (n0.i) pickedModuleInfoList.get(str);
            if (iVar2 != null) {
                String str2 = sb6;
                HashSet hashSet2 = hashSet;
                k.d dVar = new k.d(appId, str, iVar2.f125944a, i16, new k.g.c(e.a.b(i16) ? i3 : 0, 0L, 2, null), z16, null, 64, null);
                if (e.a.b(i16)) {
                    com.tencent.luggage.wxa.mc.j0 a16 = com.tencent.luggage.wxa.mc.j0.a();
                    String rVar = dVar.c().toString();
                    k.g g16 = dVar.g();
                    Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.ICommonPkgFetcher.VERSION.SPECIFIED");
                    iVar = iVar2;
                    a16.a(rVar, ((k.g.c) g16).a(), iVar.f125945b);
                } else {
                    iVar = iVar2;
                }
                hashSet2.add(dVar);
                List<n0.e> list = iVar.f125946c;
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                for (n0.e plugin : list) {
                    if (plugin.f125915g > 0) {
                        String str3 = plugin.f125916h;
                        if (!(str3 == null || str3.length() == 0)) {
                            v vVar = v.f130593a;
                            if (0 == vVar.a(plugin.f125909a, plugin.f125916h)) {
                                vVar.a(plugin.f125909a, plugin.f125916h, plugin.f125915g);
                            }
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(plugin, "plugin");
                    int i17 = -1;
                    if (map != null) {
                        String str4 = plugin.f125909a;
                        Intrinsics.checkNotNullExpressionValue(str4, "plugin.provider");
                        Object obj = map.get(str4);
                        if (obj == null) {
                            obj = -1;
                        }
                        i17 = ((Number) obj).intValue();
                    }
                    hashSet2.add(com.tencent.luggage.wxa.ii.f.a(plugin, i17));
                }
                hashSet = hashSet2;
                sb6 = str2;
            } else {
                throw new IllegalStateException(("Invalid ModuleName(" + str + ')').toString());
            }
        }
        String str5 = sb6;
        HashSet hashSet3 = hashSet;
        if (hashSet3.size() > 0) {
            b bVar = new b(str5, hashSet3, cgiCommRequestSource);
            C6308c c6308c = new C6308c(onProgress);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet(h.f130459a);
            String str6 = "MicroMsg.AppBrand.BatchGetCodePkgExecutor";
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.BatchGetCodePkgExecutor", "waitForPkg requestPkgInfoList:" + hashSet3.size());
            Iterator it5 = hashSet3.iterator();
            while (it5.hasNext()) {
                k.d request = (k.d) it5.next();
                com.tencent.luggage.wxa.tn.w.d(str6, "waitForPkg request:" + request + " requestId:" + request.f());
                k.b bVar2 = k.f130516a;
                Intrinsics.checkNotNullExpressionValue(request, "request");
                C6308c c6308c2 = c6308c;
                bVar2.a(request, new e(concurrentSkipListSet, request, c6308c, hashSet3, str5, onSuccess, aVar, bVar), new f(request, atomicBoolean, onError, aVar), (r20 & 8) != 0 ? k.b.a.f130530a : new g(c6308c, request), (r20 & 16) != 0 ? j.f130505a : bVar, (r20 & 32) != 0 ? 0 : 0, cgiCommRequestSource, (r20 & 128) != 0 ? null : aVar);
                hashSet3 = hashSet3;
                str6 = str6;
                concurrentSkipListSet = concurrentSkipListSet;
                c6308c = c6308c2;
            }
            return;
        }
        throw new IllegalStateException("RequestPkgInfoList.size==0".toString());
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ii.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6308c {

        /* renamed from: a, reason: collision with root package name */
        public final Function1 f130442a;

        /* renamed from: b, reason: collision with root package name */
        public final HashMap f130443b;

        public C6308c(Function1 onProgress) {
            Intrinsics.checkNotNullParameter(onProgress, "onProgress");
            this.f130442a = onProgress;
            this.f130443b = new HashMap();
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        
            if (r7 > 0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
        
            r11 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
        
            r10 = new com.tencent.luggage.wxa.mc.g0(r11, r5, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
        
            r11 = kotlin.math.MathKt__MathJVMKt.roundToInt(((float) r5) / ((float) r7));
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(k.d request, g0 progress) {
            g0 g0Var;
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(progress, "progress");
            synchronized (this.f130443b) {
                this.f130443b.put(request, progress);
                Collection values = this.f130443b.values();
                Intrinsics.checkNotNullExpressionValue(values, "progressMap.values");
                Iterator it = values.iterator();
                long j3 = 0;
                long j16 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g0 g0Var2 = (g0) it.next();
                    if (g0Var2 == null) {
                        g0Var = null;
                        break;
                    } else {
                        j3 += Math.max(g0Var2.f134301b, 0L);
                        j16 += Math.max(g0Var2.f134302c, 0L);
                    }
                }
            }
            if (g0Var != null) {
                this.f130442a.invoke(g0Var);
            }
        }

        public final void a(k.d request, String filePath) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            if (this.f130443b.size() > 0) {
                long e16 = com.tencent.luggage.wxa.cp.x.e(filePath);
                a(request, new g0(100, e16, e16));
            }
        }
    }
}
