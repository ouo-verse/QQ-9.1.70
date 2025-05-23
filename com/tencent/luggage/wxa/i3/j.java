package com.tencent.luggage.wxa.i3;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.fd.p0;
import com.tencent.luggage.wxa.hn.k1;
import com.tencent.luggage.wxa.hn.se;
import com.tencent.luggage.wxa.ii.c;
import com.tencent.luggage.wxa.ii.j;
import com.tencent.luggage.wxa.ii.k;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.mc.g0;
import com.tencent.luggage.wxa.mc.q0;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mobileqq.R;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j implements com.tencent.luggage.wxa.uo.b {

    /* renamed from: b, reason: collision with root package name */
    public static final a f129251b = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Runnable {
        public final /* synthetic */ com.tencent.mm.plugin.appbrand.appcache.a C;
        public final /* synthetic */ long D;
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b E;
        public final /* synthetic */ AtomicBoolean F;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f129252a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f129253b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f129254c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.rc.q f129255d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dk.b f129256e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129257f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f129258g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f129259h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ List f129260i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Map f129261j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ k1 f129262k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f129263l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ j f129264m;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AtomicBoolean f129265a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(AtomicBoolean atomicBoolean) {
                super(1);
                this.f129265a = atomicBoolean;
            }

            public final void a(k.d it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.f129265a.set(true);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((k.d) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.i3.j$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6277b extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f129266a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.mm.plugin.appbrand.appcache.a f129267b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ AtomicBoolean f129268c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f129269d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ long f129270e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f129271f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6277b(j jVar, com.tencent.mm.plugin.appbrand.appcache.a aVar, AtomicBoolean atomicBoolean, String str, long j3, com.tencent.luggage.wxa.xo.b bVar) {
                super(1);
                this.f129266a = jVar;
                this.f129267b = aVar;
                this.f129268c = atomicBoolean;
                this.f129269d = str;
                this.f129270e = j3;
                this.f129271f = bVar;
            }

            public final void a(List it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.f129266a.a(this.f129267b, it);
                if (this.f129268c.get()) {
                    com.tencent.luggage.wxa.gi.b.a(this.f129269d, com.tencent.luggage.wxa.ik.a.f130637r, "", this.f129270e, w0.c());
                } else {
                    com.tencent.luggage.wxa.gi.b.a(this.f129269d, com.tencent.luggage.wxa.ik.a.f130636q, "", this.f129270e, w0.c());
                }
                this.f129271f.a(this.f129267b);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((List) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AtomicBoolean f129272a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129273b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(AtomicBoolean atomicBoolean, com.tencent.luggage.wxa.p5.f fVar) {
                super(1);
                this.f129272a = atomicBoolean;
                this.f129273b = fVar;
            }

            public final void a(g0 progress) {
                Intrinsics.checkNotNullParameter(progress, "progress");
                if (!this.f129272a.getAndSet(true)) {
                    this.f129273b.h2();
                }
                this.f129273b.h(progress.f134300a);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((g0) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class d extends Lambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f129274a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ j f129275b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ AtomicBoolean f129276c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f129277d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ long f129278e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f129279f;

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class a implements e.c {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f129280a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.xo.b f129281b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ Throwable f129282c;

                public a(String str, com.tencent.luggage.wxa.xo.b bVar, Throwable th5) {
                    this.f129280a = str;
                    this.f129281b = bVar;
                    this.f129282c = th5;
                }

                @Override // com.tencent.luggage.wxa.xo.e.c
                public final void a(se seVar) {
                    o0.a().b(this.f129280a, seVar);
                    this.f129281b.a(this.f129282c);
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.i3.j$b$d$b, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6278b implements e.a {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f129283a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.xo.b f129284b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ Throwable f129285c;

                public C6278b(String str, com.tencent.luggage.wxa.xo.b bVar, Throwable th5) {
                    this.f129283a = str;
                    this.f129284b = bVar;
                    this.f129285c = th5;
                }

                @Override // com.tencent.luggage.wxa.xo.e.a
                public final void a(Object obj) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.SubProcessGetCodePkgNew", "syncPipeline " + this.f129283a + ", fail: " + obj);
                    this.f129284b.a(this.f129285c);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(int i3, j jVar, AtomicBoolean atomicBoolean, String str, long j3, com.tencent.luggage.wxa.xo.b bVar) {
                super(2);
                this.f129274a = i3;
                this.f129275b = jVar;
                this.f129276c = atomicBoolean;
                this.f129277d = str;
                this.f129278e = j3;
                this.f129279f = bVar;
            }

            public final void a(int i3, Throwable ex5) {
                Intrinsics.checkNotNullParameter(ex5, "ex");
                com.tencent.luggage.wxa.tn.w.b("Luggage.SubProcessGetCodePkgNew", "waitForPkgList onError(" + i3 + ", " + ex5);
                if (e.a.a(this.f129274a) && k.a.PKG_RECORD_NULL.b() == i3) {
                    this.f129275b.a(this.f129274a);
                } else {
                    com.tencent.luggage.wxa.j3.c cVar = com.tencent.luggage.wxa.j3.c.f130777a;
                    Context c16 = com.tencent.luggage.wxa.tn.z.c();
                    Intrinsics.checkNotNullExpressionValue(c16, "getContext()");
                    cVar.a(c16, i3, ex5);
                }
                if (this.f129276c.get()) {
                    com.tencent.luggage.wxa.gi.b.a(this.f129277d, com.tencent.luggage.wxa.ik.a.f130637r, "", "", this.f129278e, w0.c());
                } else {
                    com.tencent.luggage.wxa.gi.b.a(this.f129277d, com.tencent.luggage.wxa.ik.a.f130636q, "", "", this.f129278e, w0.c());
                }
                com.tencent.luggage.wxa.n3.g0.a(this.f129277d, null, 2, null).a(new a(this.f129277d, this.f129279f, ex5)).a(new C6278b(this.f129277d, this.f129279f, ex5));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a(((Number) obj).intValue(), (Throwable) obj2);
                return Unit.INSTANCE;
            }
        }

        public b(Ref.ObjectRef objectRef, boolean z16, boolean z17, com.tencent.luggage.wxa.rc.q qVar, com.tencent.luggage.wxa.dk.b bVar, com.tencent.luggage.wxa.p5.f fVar, String str, int i3, List list, Map map, k1 k1Var, AtomicBoolean atomicBoolean, j jVar, com.tencent.mm.plugin.appbrand.appcache.a aVar, long j3, com.tencent.luggage.wxa.xo.b bVar2, AtomicBoolean atomicBoolean2) {
            this.f129252a = objectRef;
            this.f129253b = z16;
            this.f129254c = z17;
            this.f129255d = qVar;
            this.f129256e = bVar;
            this.f129257f = fVar;
            this.f129258g = str;
            this.f129259h = i3;
            this.f129260i = list;
            this.f129261j = map;
            this.f129262k = k1Var;
            this.f129263l = atomicBoolean;
            this.f129264m = jVar;
            this.C = aVar;
            this.D = j3;
            this.E = bVar2;
            this.F = atomicBoolean2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            boolean z16;
            boolean z17;
            com.tencent.luggage.wxa.ii.c cVar = com.tencent.luggage.wxa.ii.c.f130433a;
            int i3 = ((n0.g) this.f129252a.element).f125920a;
            if (!this.f129253b && j.a.f130506a.a(this.f129254c)) {
                com.tencent.luggage.wxa.rc.q qVar = this.f129255d;
                if (qVar != null && com.tencent.luggage.wxa.kj.t.INSTANCE.a(qVar)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = false;
                    c.a a16 = com.tencent.luggage.wxa.ii.m.f130565a.a(this.f129256e, true, this.f129257f.y1(), new a(this.f129263l));
                    String appId = this.f129258g;
                    Intrinsics.checkNotNullExpressionValue(appId, "appId");
                    cVar.a(appId, i3, this.f129259h, this.f129260i, this.f129261j, this.f129256e, new C6277b(this.f129264m, this.C, this.f129263l, this.f129258g, this.D, this.E), new c(this.F, this.f129257f), (r30 & 256) != 0 ? c.d.f130444a : new d(this.f129259h, this.f129264m, this.f129263l, this.f129258g, this.D, this.E), z16, this.f129262k, (r30 & 2048) != 0 ? null : a16, (r30 & 4096) != 0 ? null : null);
                }
            }
            z16 = true;
            c.a a162 = com.tencent.luggage.wxa.ii.m.f130565a.a(this.f129256e, true, this.f129257f.y1(), new a(this.f129263l));
            String appId2 = this.f129258g;
            Intrinsics.checkNotNullExpressionValue(appId2, "appId");
            cVar.a(appId2, i3, this.f129259h, this.f129260i, this.f129261j, this.f129256e, new C6277b(this.f129264m, this.C, this.f129263l, this.f129258g, this.D, this.E), new c(this.F, this.f129257f), (r30 & 256) != 0 ? c.d.f130444a : new d(this.f129259h, this.f129264m, this.f129263l, this.f129258g, this.D, this.E), z16, this.f129262k, (r30 & 2048) != 0 ? null : a162, (r30 & 4096) != 0 ? null : null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f129286a;

        public c(String str) {
            this.f129286a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(com.tencent.luggage.wxa.tn.z.c(), this.f129286a, 0).show();
        }
    }

    public final String a(int i3) {
        String promptText = i3 == 1 ? com.tencent.luggage.wxa.uk.j.a(R.string.yzg, new Object[0]) : com.tencent.luggage.wxa.uk.j.a(R.string.z0z, com.tencent.luggage.wxa.mc.b.b(i3));
        c0.a(new c(promptText));
        Intrinsics.checkNotNullExpressionValue(promptText, "promptText");
        return promptText;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x024f, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo.MAIN_MODULE_NAME, r3.f125933a) == false) goto L84;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object, com.tencent.luggage.wxa.fd.n0$g] */
    /* JADX WARN: Type inference failed for: r1v49, types: [T, com.tencent.luggage.wxa.fd.n0$g] */
    @Override // com.tencent.luggage.wxa.uo.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.mm.plugin.appbrand.appcache.a call(com.tencent.luggage.wxa.ap.b var) {
        ArrayList arrayListOf;
        ArrayList arrayList;
        Iterator it;
        Object obj;
        ?? a16;
        Intrinsics.checkNotNullParameter(var, "var");
        com.tencent.luggage.wxa.p5.f fVar = (com.tencent.luggage.wxa.p5.f) var.b();
        n0 n0Var = (n0) var.c();
        int l06 = fVar.l0();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? h16 = n0Var.h();
        Intrinsics.checkNotNullExpressionValue(h16, "wxaAttributes.versionInfo");
        objectRef.element = h16;
        String appId = fVar.getAppId();
        boolean Q1 = fVar.Q1();
        com.tencent.luggage.wxa.rc.q b26 = fVar.b2();
        if (b26 == null) {
            com.tencent.luggage.wxa.xo.h.a().a("LibReader is null");
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        com.tencent.luggage.wxa.dk.b a17 = com.tencent.luggage.wxa.r6.b.a(appId);
        if (a17 == null) {
            com.tencent.luggage.wxa.xo.h.a().a("QualitySession not open");
            return null;
        }
        String O = fVar.O();
        boolean R1 = fVar.R1();
        long c16 = w0.c();
        if (e.a.a(l06)) {
            String a18 = com.tencent.luggage.wxa.ii.h.a().a(appId, l06);
            if (a18 != null && (a16 = p0.a(a18)) != 0) {
                objectRef.element = a16;
            } else {
                String a19 = a(l06);
                com.tencent.luggage.wxa.tn.w.b("Luggage.SubProcessGetCodePkgNew", "call() parse extInfoJson failed with appId[" + appId + "] versionType[" + l06 + ']');
                com.tencent.luggage.wxa.xo.h.a().a(new Error(a19));
                return null;
            }
        }
        com.tencent.mm.plugin.appbrand.appcache.a aVar = new com.tencent.mm.plugin.appbrand.appcache.a();
        n0.g gVar = (n0.g) objectRef.element;
        aVar.pkgVersion = gVar.f125920a;
        aVar.f151861a = l06;
        aVar.md5 = gVar.f125923d;
        aVar.f151866f = new q0();
        com.tencent.luggage.wxa.ii.m mVar = com.tencent.luggage.wxa.ii.m.f130565a;
        n0.g gVar2 = (n0.g) objectRef.element;
        Map a26 = mVar.a(gVar2, appId, mVar.a(appId, l06, gVar2.f125920a, Q1, b26));
        Iterator it5 = a26.entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry entry = (Map.Entry) it5.next();
            String str = (String) entry.getKey();
            n0.i iVar = (n0.i) entry.getValue();
            if (Intrinsics.areEqual(ModulePkgInfo.MAIN_MODULE_NAME, str)) {
                it = it5;
            } else {
                LinkedList linkedList = aVar.f151864d;
                ModulePkgInfo modulePkgInfo = new ModulePkgInfo();
                List list = ((n0.g) objectRef.element).f125928i;
                Intrinsics.checkNotNullExpressionValue(list, "versionInfo.moduleList");
                Iterator it6 = list.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        it = it5;
                        obj = null;
                        break;
                    }
                    obj = it6.next();
                    it = it5;
                    if (Intrinsics.areEqual(str, ((n0.h) obj).f125933a)) {
                        break;
                    }
                    it5 = it;
                }
                Intrinsics.checkNotNull(obj);
                n0.h hVar = (n0.h) obj;
                modulePkgInfo.name = str;
                modulePkgInfo.md5 = iVar.f125945b;
                modulePkgInfo.independent = hVar.f125935c;
                modulePkgInfo.aliases = hVar.f125937e;
                modulePkgInfo.pkgVersion = ((n0.g) objectRef.element).f125920a;
                linkedList.add(modulePkgInfo);
            }
            List list2 = iVar.f125946c;
            if (!(list2 == null || list2.isEmpty())) {
                q0 q0Var = aVar.f151866f;
                Intrinsics.checkNotNull(q0Var);
                q0Var.a(str, com.tencent.luggage.wxa.ii.f.a(iVar.f125946c));
            }
            it5 = it;
        }
        q0 q0Var2 = aVar.f151866f;
        if (q0Var2 != null) {
            q0Var2.c();
        }
        n0.g gVar3 = (n0.g) objectRef.element;
        if (!gVar3.f125929j || w0.a(gVar3.f125928i)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ModulePkgInfo.MAIN_MODULE_NAME);
            arrayList = arrayListOf;
        } else {
            LinkedList linkedList2 = new LinkedList();
            String b16 = com.tencent.luggage.wxa.h6.o.b(com.tencent.luggage.wxa.ki.a.b(O));
            if (b16 == null || b16.length() == 0) {
                String str2 = ((n0.g) objectRef.element).f125930k;
                if (!(str2 == null || str2.length() == 0)) {
                    for (n0.h hVar2 : ((n0.g) objectRef.element).f125928i) {
                        if (Intrinsics.areEqual(((n0.g) objectRef.element).f125930k, hVar2.f125933a)) {
                            break;
                        }
                    }
                }
                hVar2 = null;
            } else {
                List list3 = ((n0.g) objectRef.element).f125928i;
                Intrinsics.checkNotNullExpressionValue(list3, "versionInfo.moduleList");
                hVar2 = (n0.h) com.tencent.luggage.wxa.xi.g.a(list3, b16, "LaunchCheckPkgHandlerSeparatedPluginsCompatible  appId:" + appId + " versionType:" + l06, false, 4, null);
            }
            if (hVar2 != null) {
                linkedList2.add(hVar2.f125933a);
            }
            if (hVar2 != null) {
                arrayList = linkedList2;
                if (!hVar2.f125935c) {
                    arrayList = linkedList2;
                }
            }
            linkedList2.add(ModulePkgInfo.MAIN_MODULE_NAME);
            arrayList = linkedList2;
        }
        ArrayList arrayList2 = arrayList;
        com.tencent.luggage.wxa.xo.b a27 = com.tencent.luggage.wxa.xo.h.a();
        a27.b();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        k1 k1Var = new k1();
        k1Var.f127976d = fVar.L1().f122984c;
        k1Var.f127977e = fVar.y1();
        k1Var.f127978f = 101;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        com.tencent.luggage.wxa.zp.h.f146825d.d(new b(objectRef, R1, Q1, b26, a17, fVar, appId, l06, arrayList2, a26, k1Var, atomicBoolean, this, aVar, c16, a27, atomicBoolean2), "Luggage.SubProcessGetCodePkgNew[" + appId + QbAddrData.DATA_SPLITER + l06 + ']');
        return null;
    }

    public final void a(com.tencent.mm.plugin.appbrand.appcache.a aVar, List list) {
        Object obj;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.mc.j jVar = (com.tencent.luggage.wxa.mc.j) it.next();
            if (jVar instanceof ModulePkgInfo) {
                Iterator it5 = aVar.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it5.next();
                        if (Intrinsics.areEqual(((ModulePkgInfo) obj).name, ((ModulePkgInfo) jVar).name)) {
                            break;
                        }
                    }
                }
                Intrinsics.checkNotNull(obj);
                ModulePkgInfo modulePkgInfo = (ModulePkgInfo) obj;
                ModulePkgInfo modulePkgInfo2 = (ModulePkgInfo) jVar;
                modulePkgInfo.pkgPath = modulePkgInfo2.pkgPath;
                modulePkgInfo.md5 = modulePkgInfo2.md5;
            } else if (jVar instanceof WxaPluginPkgInfo) {
                q0 q0Var = aVar.f151866f;
                Intrinsics.checkNotNull(q0Var);
                q0Var.a((WxaPluginPkgInfo) jVar);
            }
        }
    }
}
