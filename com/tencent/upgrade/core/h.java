package com.tencent.upgrade.core;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.upgrade.bean.HttpPostParams;
import com.tencent.upgrade.bean.HttpResult;
import com.tencent.upgrade.bean.UpgradeStrategy;
import com.tencent.upgrade.core.b;
import com.tencent.upgrade.util.HttpUtil;
import iz3.k;
import iz3.o;
import iz3.p;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private RDelivery f383828a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f383829b;

    /* renamed from: c, reason: collision with root package name */
    private f f383830c;

    /* renamed from: d, reason: collision with root package name */
    private b.InterfaceC10036b f383831d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.upgrade.core.b f383832e;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a implements b.InterfaceC10036b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // com.tencent.upgrade.core.b.InterfaceC10036b
        public void a(com.tencent.upgrade.request.a aVar, b.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                h.this.f(aVar, cVar);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class b extends TypeToken<HttpResult<UpgradeStrategy>> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class c implements p {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.upgrade.request.a f383835a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.c f383836b;

        c(com.tencent.upgrade.request.a aVar, b.c cVar) {
            this.f383835a = aVar;
            this.f383836b = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, aVar, cVar);
            }
        }

        @Override // iz3.m
        public /* synthetic */ void a(List list, List list2, List list3) {
            k.a(this, list, list2, list3);
        }

        @Override // iz3.p
        public void b(RDeliveryData rDeliveryData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                h.this.j(rDeliveryData, this.f383835a);
                b.c cVar = this.f383836b;
                if (cVar != null) {
                    cVar.a(true);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rDeliveryData);
        }

        @Override // iz3.m
        public void onFail(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                h.i(str, this.f383835a);
                b.c cVar = this.f383836b;
                if (cVar != null) {
                    cVar.a(false);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }

        @Override // iz3.l
        public /* synthetic */ void onSuccess(List list) {
            o.a(this, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class d implements HttpUtil.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.upgrade.request.a f383838a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.c f383839b;

        d(com.tencent.upgrade.request.a aVar, b.c cVar) {
            this.f383838a = aVar;
            this.f383839b = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, aVar, cVar);
            }
        }

        @Override // com.tencent.upgrade.util.HttpUtil.b
        public void onFail(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            com.tencent.upgrade.util.d.c("UpdateCheckProcessor", "doRequest onFail errorCode = " + i3 + "  errorMsg = " + str);
            if (this.f383838a.b() != null) {
                this.f383838a.b().onFail(i3, str);
            }
            b.c cVar = this.f383839b;
            if (cVar != null) {
                cVar.a(false);
            }
        }

        @Override // com.tencent.upgrade.util.HttpUtil.b
        public void onSuccess(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                h.this.k(this.f383838a, str);
                b.c cVar = this.f383839b;
                if (cVar != null) {
                    cVar.a(true);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class e extends TypeToken<HttpResult<UpgradeStrategy>> {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface f {
        void a(UpgradeStrategy upgradeStrategy);

        void b();
    }

    public h(RDelivery rDelivery, boolean z16, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, rDelivery, Boolean.valueOf(z16), fVar);
            return;
        }
        a aVar = new a();
        this.f383831d = aVar;
        this.f383832e = new com.tencent.upgrade.core.b(aVar);
        this.f383828a = rDelivery;
        this.f383829b = z16;
        this.f383830c = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.tencent.upgrade.request.a aVar, b.c cVar) {
        if (aVar == null && cVar != null) {
            cVar.a(false);
        }
        com.tencent.upgrade.checker.a a16 = com.tencent.upgrade.checker.a.a();
        if (!aVar.c() && (!aVar.e() || !a16.b(g()))) {
            com.tencent.upgrade.util.d.c("UpdateCheckProcessor", "doRequest use cached strategy");
            if (j.l().w()) {
                j(this.f383828a.y("gray_pkg_" + j.l().d(), null, true), aVar);
            } else if (aVar.b() != null) {
                aVar.b().b(j.l().h());
            }
            if (cVar != null) {
                cVar.a(true);
                return;
            }
            return;
        }
        if (j.l().w()) {
            m(aVar, cVar);
        } else {
            l(aVar, cVar);
        }
    }

    private UpgradeStrategy g() {
        com.tencent.upgrade.util.d.a("UpdateCheckProcessor", "getInternalCachedstrategy ");
        if (j.l().w()) {
            UpgradeStrategy upgradeStrategy = null;
            RDeliveryData y16 = this.f383828a.y("gray_pkg_" + j.l().d(), null, true);
            if (y16 != null) {
                HttpResult httpResult = (HttpResult) new Gson().fromJson(com.tencent.upgrade.core.f.f383826b.b(y16.getConfigValue()), new b().getType());
                com.tencent.upgrade.util.d.a("UpdateCheckProcessor", "getInternalCachedstrategy parsed result = " + httpResult);
                if (httpResult != null && httpResult.getCode() == 0) {
                    upgradeStrategy = (UpgradeStrategy) httpResult.getData();
                }
            }
            com.tencent.upgrade.util.d.a("UpdateCheckProcessor", "getInternalCachedstrategy data = " + y16 + ",strategy = " + upgradeStrategy);
            return upgradeStrategy;
        }
        return j.l().h();
    }

    private String h() {
        if (this.f383829b) {
            return "https://dev.release.qq.com/gray/queryTactics";
        }
        return "https://r.release.qq.com/gray/queryTactics";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(@NonNull String str, com.tencent.upgrade.request.a aVar) {
        com.tencent.upgrade.util.d.c("UpdateCheckProcessor", "handleRDeliveryRequestFailResp errorMsg = " + str);
        if ("config result empty".equals(str)) {
            if (aVar.b() != null) {
                aVar.b().a();
            }
        } else if (aVar.b() != null) {
            aVar.b().onFail(-1, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(RDeliveryData rDeliveryData, com.tencent.upgrade.request.a aVar) {
        com.tencent.upgrade.util.d.a("UpdateCheckProcessor", "handleRDeliveryRequestSuccessResp data = " + rDeliveryData);
        if (rDeliveryData != null) {
            com.tencent.upgrade.core.f fVar = com.tencent.upgrade.core.f.f383826b;
            boolean i3 = fVar.i();
            boolean b16 = com.tencent.upgrade.core.c.f383819b.b(j.l().h());
            com.tencent.upgrade.util.d.a("UpdateCheckProcessor", "handleRDeliveryRequestSuccessResp isCDNBusy = " + i3 + ",isInNoDisturbPeriod = " + b16);
            if (!i3 && (aVar.d() || !b16)) {
                k(aVar, fVar.b(rDeliveryData.getConfigValue()));
                return;
            } else {
                if (aVar.b() != null) {
                    aVar.b().a();
                    return;
                }
                return;
            }
        }
        if (aVar.b() != null) {
            aVar.b().a();
        }
        f fVar2 = this.f383830c;
        if (fVar2 != null) {
            fVar2.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(com.tencent.upgrade.request.a aVar, String str) {
        com.tencent.upgrade.util.d.c("UpdateCheckProcessor", "handleUpdateStrategyResult result = " + str);
        HttpResult httpResult = (HttpResult) new Gson().fromJson(str, new e().getType());
        com.tencent.upgrade.util.d.c("UpdateCheckProcessor", "handleUpdateStrategyResult parsed result = " + httpResult);
        if (httpResult != null && httpResult.getCode() == 0) {
            UpgradeStrategy upgradeStrategy = (UpgradeStrategy) httpResult.getData();
            com.tencent.upgrade.checker.b bVar = new com.tencent.upgrade.checker.b();
            if (upgradeStrategy != null && upgradeStrategy.getApkBasicInfo() != null && bVar.b(upgradeStrategy)) {
                com.tencent.upgrade.util.d.a("UpdateCheckProcessor", "handleUpdateStrategyResult get new strategy success, " + upgradeStrategy.toString());
                f fVar = this.f383830c;
                if (fVar != null) {
                    fVar.a(upgradeStrategy);
                }
                if (aVar.b() != null) {
                    aVar.b().b(upgradeStrategy);
                    return;
                }
                return;
            }
            com.tencent.upgrade.util.d.c("UpdateCheckProcessor", "handleUpdateStrategyResult get invalid strategy, strategy = " + upgradeStrategy);
            if (aVar.b() != null) {
                aVar.b().a();
                return;
            }
            return;
        }
        com.tencent.upgrade.util.d.c("UpdateCheckProcessor", "handleUpdateStrategyResult error2, result = " + httpResult);
        if (aVar.b() != null) {
            aVar.b().a();
        }
    }

    private void l(com.tencent.upgrade.request.a aVar, b.c cVar) {
        String h16 = h();
        HttpPostParams e16 = com.tencent.upgrade.network.a.e(aVar.a(), aVar.d());
        e16.print();
        HttpUtil.k(h16, e16, new d(aVar, cVar));
    }

    private void m(com.tencent.upgrade.request.a aVar, b.c cVar) {
        com.tencent.upgrade.util.d.a("UpdateCheckProcessor", "requestFromServerByRDelivery");
        for (Map.Entry<String, String> entry : aVar.a().entrySet()) {
            this.f383828a.K(entry.getKey(), entry.getValue());
        }
        com.tencent.upgrade.core.c cVar2 = com.tencent.upgrade.core.c.f383819b;
        boolean b16 = cVar2.b(j.l().h());
        if (!aVar.d() && b16) {
            if (aVar.b() != null) {
                aVar.b().a();
            }
            if (cVar != null) {
                cVar.a(true);
                return;
            }
            return;
        }
        if (!b16) {
            cVar2.a();
        }
        this.f383828a.J("gray_pkg_" + j.l().d(), new c(aVar, cVar));
    }

    public void e(boolean z16, boolean z17, boolean z18, Map<String, String> map, pw4.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), map, dVar);
            return;
        }
        com.tencent.upgrade.util.d.a("UpdateCheckProcessor", "checkUpgrade forceRequestRemoteStrategy = " + z16 + ", requestRemoteWhenCacheIsInvalid = " + z17 + ", ignoreNoDisturbPeriod = " + z18);
        this.f383832e.b(new com.tencent.upgrade.request.a(z16, z17, z18, map, dVar));
        this.f383832e.d();
    }
}
