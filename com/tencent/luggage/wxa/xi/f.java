package com.tencent.luggage.wxa.xi;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.mc.g0;
import com.tencent.luggage.wxa.mc.k0;
import com.tencent.luggage.wxa.mc.t0;
import com.tencent.luggage.wxa.ml.m;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xi.a;
import com.tencent.luggage.wxa.xi.d;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mobileqq.R;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class f implements com.tencent.luggage.wxa.xi.a, d.a {

    /* renamed from: d, reason: collision with root package name */
    public final Set f145010d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.tk.h f145011e = new com.tencent.luggage.wxa.tk.h();

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.luggage.wxa.c5.e f145012f;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dn.a f145013a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f145014b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f145015c;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.xi.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class DialogInterfaceOnCancelListenerC6914a implements DialogInterface.OnCancelListener {
            public DialogInterfaceOnCancelListenerC6914a() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                a aVar = a.this;
                f.this.a(((ModulePkgInfo) aVar.f145014b.f141499a).name, a.e.CANCEL);
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class b implements Function {
            public b() {
            }

            @Override // androidx.arch.core.util.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public m.a apply(Context context) {
                Context L = f.this.f145012f.L();
                if (L == null) {
                    L = f.this.f145012f.F();
                }
                com.tencent.luggage.wxa.ml.i iVar = new com.tencent.luggage.wxa.ml.i(L);
                iVar.setMessage(L.getString(R.string.f16383247));
                return iVar;
            }
        }

        public a(com.tencent.luggage.wxa.dn.a aVar, com.tencent.luggage.wxa.tk.i iVar, com.tencent.luggage.wxa.tk.i iVar2) {
            this.f145013a = aVar;
            this.f145014b = iVar;
            this.f145015c = iVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f145013a.f124395a) {
                com.tencent.luggage.wxa.xi.c a16 = new com.tencent.luggage.wxa.xi.c().a(new DialogInterfaceOnCancelListenerC6914a());
                a16.a(new b());
                a16.a(f.this.f145012f);
                this.f145015c.f141499a = a16;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f145026a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a.b f145027b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f145028c;

        public c(com.tencent.luggage.wxa.tk.i iVar, a.b bVar, com.tencent.luggage.wxa.tk.i iVar2) {
            this.f145026a = iVar;
            this.f145027b = bVar;
            this.f145028c = iVar2;
        }

        @Override // com.tencent.luggage.wxa.xi.a.b
        public void a(g0 g0Var) {
            if (w.d() <= 1) {
                w.a("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoadProgress, appId:%s, module:%s, progress:%s", f.this.f145012f.getAppId(), ((ModulePkgInfo) this.f145026a.f141499a).name, g0Var);
            }
            a.b bVar = this.f145027b;
            if (bVar != null) {
                bVar.a(g0Var);
            }
            com.tencent.luggage.wxa.xi.c cVar = (com.tencent.luggage.wxa.xi.c) this.f145028c.f141499a;
            if (cVar != null) {
                cVar.a(g0Var.a());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements a.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f145030a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ModulePkgInfo f145031b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a.c f145032c;

        public d(boolean z16, ModulePkgInfo modulePkgInfo, a.c cVar) {
            this.f145030a = z16;
            this.f145031b = modulePkgInfo;
            this.f145032c = cVar;
        }

        @Override // com.tencent.luggage.wxa.xi.a.c
        public /* synthetic */ void a(List list) {
            s41.a.a(this, list);
        }

        @Override // com.tencent.luggage.wxa.xi.a.c
        public void a(a.e eVar) {
            if (a.e.OK == eVar && this.f145030a) {
                if (!this.f145031b.independent) {
                    f.this.a(ModulePkgInfo.MAIN_MODULE_NAME, "options.injectModuleJS");
                }
                f.this.a(this.f145031b.name, "options.injectModuleJS");
            }
            a.c cVar = this.f145032c;
            if (cVar != null) {
                cVar.a(eVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements a.InterfaceC6911a {

        /* renamed from: a, reason: collision with root package name */
        public final String f145034a;

        public e() {
            this.f145034a = f.this.d();
        }

        @Override // com.tencent.luggage.wxa.xi.a.InterfaceC6911a
        public void a(String str, a.c cVar, a.b bVar, boolean z16) {
            f.this.a(str, cVar, bVar, z16, this.f145034a);
        }

        @Override // com.tencent.luggage.wxa.xi.a.InterfaceC6911a
        public void commit() {
            d.c.f145009a.a(this.f145034a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xi.f$f, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C6915f implements a.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xi.b f145036a;

        public C6915f(com.tencent.luggage.wxa.xi.b bVar) {
            this.f145036a = bVar;
        }

        @Override // com.tencent.luggage.wxa.xi.a.c
        public /* synthetic */ void a(List list) {
            s41.a.a(this, list);
        }

        @Override // com.tencent.luggage.wxa.xi.a.c
        public void a(a.e eVar) {
            this.f145036a.a(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public final a.c f145048a;

        /* renamed from: b, reason: collision with root package name */
        public final a.b f145049b;

        public i(a.c cVar, a.b bVar) {
            this.f145048a = cVar;
            this.f145049b = bVar;
        }

        public a.b a() {
            return this.f145049b;
        }

        public a.c b() {
            return this.f145048a;
        }
    }

    public f(com.tencent.luggage.wxa.c5.e eVar) {
        this.f145012f = eVar;
    }

    @Override // com.tencent.luggage.wxa.xi.a
    public boolean b() {
        return true;
    }

    public final boolean c() {
        return a(this.f145012f.j0().f125966l);
    }

    public final String d() {
        return hashCode() + "@" + w0.a();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements a.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.c f145019a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dn.a f145020b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f145021c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f145022d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f145023e;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f145023e.f141499a != null) {
                    ((com.tencent.luggage.wxa.xi.c) b.this.f145023e.f141499a).dismiss();
                }
            }
        }

        public b(a.c cVar, com.tencent.luggage.wxa.dn.a aVar, h hVar, com.tencent.luggage.wxa.tk.i iVar, com.tencent.luggage.wxa.tk.i iVar2) {
            this.f145019a = cVar;
            this.f145020b = aVar;
            this.f145021c = hVar;
            this.f145022d = iVar;
            this.f145023e = iVar2;
        }

        @Override // com.tencent.luggage.wxa.xi.a.c
        public void a(List list) {
            a.c cVar = this.f145019a;
            if (cVar != null) {
                cVar.a(list);
            }
        }

        @Override // com.tencent.luggage.wxa.xi.a.c
        public void a(a.e eVar) {
            h hVar;
            this.f145020b.f124395a = true;
            if (a.e.OK == eVar && (hVar = this.f145021c) != null && hVar.f145045b) {
                if (!((ModulePkgInfo) this.f145022d.f141499a).independent) {
                    f.this.a(ModulePkgInfo.MAIN_MODULE_NAME, "options.injectModuleJS");
                }
                f.this.a(((ModulePkgInfo) this.f145022d.f141499a).name, "options.injectModuleJS");
            }
            f.this.f145012f.e(new a());
            a.c cVar = this.f145019a;
            if (cVar != null) {
                cVar.a(eVar);
            }
        }
    }

    public ModulePkgInfo c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.tencent.mm.plugin.appbrand.appcache.a aVar = this.f145012f.j0().f125966l;
        if (com.tencent.luggage.wxa.xi.g.a(aVar, str, "findModuleInfoByModuleName")) {
            return aVar;
        }
        String a16 = com.tencent.mm.plugin.appbrand.appcache.a.a(str);
        k0.c(this.f145012f);
        return (ModulePkgInfo) com.tencent.luggage.wxa.xi.g.a((List) aVar.f151864d, a16, "findModuleInfoByModuleName");
    }

    public ModulePkgInfo d(String str) {
        com.tencent.mm.plugin.appbrand.appcache.a aVar = this.f145012f.j0().f125966l;
        if (!w0.c(str) && !ModulePkgInfo.MAIN_MODULE_NAME.equals(str)) {
            k0.c(this.f145012f);
            ModulePkgInfo modulePkgInfo = (ModulePkgInfo) com.tencent.luggage.wxa.xi.g.a((List) aVar.f151864d, str, "findModuleInfoByResourcePath");
            if (modulePkgInfo != null) {
                return modulePkgInfo;
            }
        }
        return aVar;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements d.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f145038a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xi.b f145039b;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f145041a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List f145042b;

            public a(boolean z16, List list) {
                this.f145041a = z16;
                this.f145042b = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.e eVar;
                if (f.this.f145012f.t0()) {
                    g gVar = g.this;
                    w.b("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad with module(%s) but runtime(%s) destroyed", gVar.f145038a, f.this.f145012f.toString());
                    return;
                }
                if (this.f145041a) {
                    t0 a16 = t0.a(f.this.f145012f);
                    if (a16 == null) {
                        g gVar2 = g.this;
                        w.b("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad with module(%s) but runtime(%s) has no reader", gVar2.f145038a, f.this.f145012f.toString());
                        return;
                    } else {
                        a16.a(this.f145042b);
                        if (!f.this.f145012f.E().m().booleanValue()) {
                            f.this.f145012f.V1();
                        }
                    }
                }
                g gVar3 = g.this;
                f fVar = f.this;
                String str = gVar3.f145038a;
                if (this.f145041a) {
                    eVar = a.e.OK;
                } else {
                    eVar = a.e.FAIL;
                }
                fVar.a(str, eVar);
            }
        }

        public g(String str, com.tencent.luggage.wxa.xi.b bVar) {
            this.f145038a = str;
            this.f145039b = bVar;
        }

        @Override // com.tencent.luggage.wxa.xi.d.b
        public void a(boolean z16, List list) {
            w.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad, module(%s) succeed(%b)", this.f145038a, Boolean.valueOf(z16));
            this.f145039b.a(new a(z16, list));
        }

        @Override // com.tencent.luggage.wxa.xi.d.b
        public void a(g0 g0Var) {
            w.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "hy: on load module progress %s", g0Var);
            f.this.a(this.f145038a, g0Var);
        }
    }

    public boolean b(String str) {
        return a(str, (com.tencent.luggage.wxa.tk.i) null);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public boolean f145044a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f145045b;

        /* renamed from: c, reason: collision with root package name */
        public Executor f145046c;

        /* renamed from: d, reason: collision with root package name */
        public String f145047d;

        public h() {
            this.f145044a = false;
            this.f145045b = true;
            this.f145046c = d.a.f145008c;
            this.f145047d = null;
        }

        public String toString() {
            return "LoadModuleOptions{showPrompt=" + this.f145044a + ", injectModuleJS=" + this.f145045b + ", executor=" + this.f145046c + ", transactionKey=" + w0.d(this.f145047d) + '}';
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    public final boolean a(ModulePkgInfo modulePkgInfo) {
        boolean z16 = !w0.c(modulePkgInfo.pkgPath) && x.d(modulePkgInfo.pkgPath);
        if (z16) {
            if (!modulePkgInfo.independent) {
                a(ModulePkgInfo.MAIN_MODULE_NAME, "checkModuleLoaded");
            }
            a(modulePkgInfo.name, "checkModuleLoaded");
        }
        return z16;
    }

    public final boolean a(String str, com.tencent.luggage.wxa.tk.i iVar) {
        ModulePkgInfo d16 = w0.c(str) ? this.f145012f.j0().f125966l : d(str);
        if (iVar != null) {
            iVar.f141499a = d16;
        }
        return a(d16);
    }

    public final void a(String str, String str2) {
        com.tencent.luggage.wxa.xi.e eVar = (com.tencent.luggage.wxa.xi.e) this.f145012f.h0();
        if (eVar == null) {
            return;
        }
        w.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "injectServiceScriptSafe appId:%s, module:%s, reason:%s ret:%b", this.f145012f.getAppId(), str, str2, Boolean.valueOf(eVar.b(str)));
    }

    public final void a(String str, h hVar, a.c cVar, a.b bVar) {
        if (this.f145012f.t0()) {
            w.b("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule with path(%s), but runtime(%s) finished", str, this.f145012f.getAppId());
            if (cVar != null) {
                cVar.a(a.e.FAIL);
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
        if (a(str, iVar)) {
            w.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule appId:%s path:%s, module:%s, options:%b, [loaded]", this.f145012f.getAppId(), str, ((ModulePkgInfo) iVar.f141499a).name, hVar);
            if (cVar != null) {
                if (hVar != null && hVar.f145045b) {
                    a(((ModulePkgInfo) iVar.f141499a).name, "options.injectModuleJS");
                }
                cVar.a(a.e.OK);
                return;
            }
        }
        com.tencent.luggage.wxa.tk.i iVar2 = new com.tencent.luggage.wxa.tk.i();
        com.tencent.luggage.wxa.dn.a aVar = new com.tencent.luggage.wxa.dn.a();
        if (hVar != null && hVar.f145044a) {
            this.f145012f.e(new a(aVar, iVar, iVar2));
        }
        w.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, appId:%s path:%s, module:%s, options:%b [do loadOrAddPendingCallback]", this.f145012f.getAppId(), str, ((ModulePkgInfo) iVar.f141499a).name, hVar);
        a((ModulePkgInfo) iVar.f141499a, (a.c) new b(cVar, aVar, hVar, iVar, iVar2), true, (a.b) new c(iVar, bVar, iVar2), hVar == null ? d.a.f145008c : hVar.f145046c, hVar == null ? null : hVar.f145047d);
    }

    @Override // com.tencent.luggage.wxa.xi.a
    public void a(String str, a.c cVar, a.b bVar, boolean z16) {
        a(str, cVar, bVar, z16, null);
    }

    public final void a(String str, a.c cVar, a.b bVar, boolean z16, String str2) {
        ModulePkgInfo c16 = c(str);
        if (c16 == null) {
            w.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [not found]", this.f145012f.getAppId(), str, Boolean.valueOf(z16));
            if (cVar != null) {
                cVar.a(a.e.MODULE_NOT_FOUND);
                return;
            }
            return;
        }
        if (!a(c16)) {
            w.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [do loadOrAddPendingCallback]", this.f145012f.getAppId(), str, Boolean.valueOf(z16));
            a(c16, (a.c) new d(z16, c16, cVar), true, bVar, d.a.f145008c, str2);
            return;
        }
        w.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [loaded]", this.f145012f.getAppId(), str, Boolean.valueOf(z16));
        if (z16) {
            a(c16.name, "options.injectModuleJS");
        }
        if (cVar != null) {
            cVar.a(a.e.OK);
        }
    }

    @Override // com.tencent.luggage.wxa.xi.a
    public void a(String str, a.c cVar) {
        h hVar = new h(null);
        hVar.f145044a = true;
        hVar.f145045b = true;
        hVar.f145046c = d.a.f145006a;
        a(str, hVar, cVar, (a.b) null);
    }

    @Override // com.tencent.luggage.wxa.xi.a
    public a.InterfaceC6911a a() {
        return new e();
    }

    public final void a(ModulePkgInfo modulePkgInfo, a.c cVar, boolean z16, a.b bVar, Executor executor, String str) {
        boolean contains;
        String str2 = modulePkgInfo.name;
        boolean z17 = (ModulePkgInfo.MAIN_MODULE_NAME.equals(str2) || modulePkgInfo.independent || c()) ? false : true;
        if (z16 && cVar != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str2);
            if (z17) {
                linkedList.add(ModulePkgInfo.MAIN_MODULE_NAME);
            }
            cVar.a(linkedList);
        }
        if (z17) {
            a((ModulePkgInfo) this.f145012f.j0().f125966l, (a.c) null, false, (a.b) null, executor, str);
        }
        w.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, name %s, independent %b, should ensure __APP__ %b", modulePkgInfo.name, Boolean.valueOf(modulePkgInfo.independent), Boolean.valueOf(z17));
        a(str2, cVar, bVar);
        synchronized (this.f145010d) {
            contains = this.f145010d.contains(str2);
            if (!contains) {
                this.f145010d.add(str2);
            }
        }
        if (contains) {
            return;
        }
        com.tencent.luggage.wxa.xi.b bVar2 = new com.tencent.luggage.wxa.xi.b(2);
        if (z17) {
            a(ModulePkgInfo.MAIN_MODULE_NAME, new C6915f(bVar2), (a.b) null);
        } else {
            bVar2.a(null);
        }
        com.tencent.luggage.wxa.xi.d a16 = d.c.f145009a.a(this.f145012f, this.f145012f.j0().f125966l.a(this.f145012f.getAppId(), str2), str);
        a16.a(new g(str2, bVar2));
        a16.a(executor);
    }

    public final void a(String str, g0 g0Var) {
        Set<i> a16 = this.f145011e.a(str);
        if (a16 == null) {
            return;
        }
        for (i iVar : a16) {
            if (iVar.a() != null) {
                iVar.a().a(g0Var);
            }
        }
    }

    public final void a(String str, a.e eVar) {
        synchronized (this.f145010d) {
            this.f145010d.remove(str);
        }
        Set<i> b16 = this.f145011e.b(str);
        if (b16 == null) {
            w.b("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "markLoadingFinished %s, result %s, get null callbackSet, maybe canceled by user before", str, eVar.name());
            return;
        }
        for (i iVar : b16) {
            if (iVar.b() != null) {
                iVar.b().a(eVar);
            }
        }
    }

    public final void a(String str, a.c cVar, a.b bVar) {
        boolean contains;
        if (cVar == null && bVar == null) {
            return;
        }
        synchronized (this.f145010d) {
            contains = this.f145010d.contains(str);
        }
        if (contains || !b(str)) {
            this.f145011e.b(str, new i(cVar, bVar));
        } else if (cVar != null) {
            cVar.a(a.e.OK);
        }
    }

    @Override // com.tencent.luggage.wxa.xi.a
    public String a(String str) {
        return d(str).name;
    }
}
