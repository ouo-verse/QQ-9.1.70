package com.tencent.mobileqq.onlinestatus.binder;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.AccountPanelFragment;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.olympic.helper.a;
import com.tencent.mobileqq.onlinestatus.utils.aa;
import com.tencent.mobileqq.onlinestatus.view.s;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Objects;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import trpc.qq_status_rank.status_rank_mgr.StatusRankMgr$StatusRankRequest;
import trpc.qq_status_rank.status_rank_mgr.StatusRankMgr$StatusRankResponse;

/* compiled from: P */
/* loaded from: classes16.dex */
public class j extends com.tencent.mobileqq.mvvm.b {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Observer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AccountPanelFragment f255610d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ s f255611e;

        a(AccountPanelFragment accountPanelFragment, s sVar) {
            this.f255610d = accountPanelFragment;
            this.f255611e = sVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("AccountPanelBinder", 2, "bindSetOlympicStatusFlag onChanged called " + bool);
            }
            if (bool.booleanValue()) {
                j.this.x(this.f255610d, this.f255611e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements Observer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AccountPanelFragment f255613d;

        b(AccountPanelFragment accountPanelFragment) {
            this.f255613d = accountPanelFragment;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                this.f255613d.bj();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c implements Observer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f255615d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AccountPanelViewModel f255616e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f255617f;

        c(y yVar, AccountPanelViewModel accountPanelViewModel, QBaseActivity qBaseActivity) {
            this.f255615d = yVar;
            this.f255616e = accountPanelViewModel;
            this.f255617f = qBaseActivity;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            com.tencent.mobileqq.onlinestatus.model.g value;
            if (bool == null) {
                return;
            }
            if (!this.f255615d.isShowing()) {
                QLog.d("AccountPanelBinder", 1, "bindSetStatusResult panel not showing");
            } else if (bool.booleanValue() && this.f255616e.l2() != null && (value = this.f255616e.l2().getValue()) != null) {
                j.this.w(af.C().I(value.f256022a, value.f256023b), MobileQQ.sMobileQQ.peekAppRuntime(), this.f255617f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f255619a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AccountPanelFragment f255620b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AppRuntime f255621c;

        d(s sVar, AccountPanelFragment accountPanelFragment, AppRuntime appRuntime) {
            this.f255619a = sVar;
            this.f255620b = accountPanelFragment;
            this.f255621c = appRuntime;
        }

        @Override // com.tencent.mobileqq.onlinestatus.olympic.helper.a.b
        public void a(StatusRankMgr$StatusRankResponse statusRankMgr$StatusRankResponse) {
            if (statusRankMgr$StatusRankResponse.res.get() == 0) {
                long j3 = statusRankMgr$StatusRankResponse.rank.get();
                if (QLog.isColorLevel()) {
                    QLog.i("AccountPanelBinder", 2, "handleSwitchToOlympicStatus onGetStatusRank success: rank " + j3);
                }
                this.f255619a.x1(j3);
                aa.h(this.f255620b.getContext(), this.f255621c.getCurrentUin(), true);
                return;
            }
            QLog.e("AccountPanelBinder", 1, "handleSwitchToOlympicStatus onGetStatusRank error: " + statusRankMgr$StatusRankResponse.res.get());
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class e implements Observer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ s f255623d;

        e(s sVar) {
            this.f255623d = sVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                this.f255623d.w1();
            } else {
                this.f255623d.v0();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class f implements Observer<Integer> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AccountPanelFragment f255625d;

        f(AccountPanelFragment accountPanelFragment) {
            this.f255625d = accountPanelFragment;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            if (num == null) {
                return;
            }
            this.f255625d.bj();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class g implements Observer<List<Object>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ s f255627d;

        g(s sVar) {
            this.f255627d = sVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<Object> list) {
            if (list == null) {
                return;
            }
            this.f255627d.E1(list);
            this.f255627d.C1();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class h implements Observer<com.tencent.mobileqq.onlinestatus.model.j> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ s f255629d;

        h(s sVar) {
            this.f255629d = sVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.onlinestatus.model.j jVar) {
            if (jVar == null) {
                return;
            }
            if (jVar.f256035c) {
                this.f255629d.Q1(jVar.f256034b);
            } else {
                this.f255629d.R1();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class i implements Observer<String> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ s f255631d;

        i(s sVar) {
            this.f255631d = sVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            if (str == null) {
                return;
            }
            this.f255631d.J1(str);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.onlinestatus.binder.j$j, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class C8185j implements Observer<String> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ s f255633d;

        C8185j(s sVar) {
            this.f255633d = sVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            if (str == null) {
                return;
            }
            this.f255633d.F1(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class k implements Observer<com.tencent.mobileqq.onlinestatus.model.g> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AccountPanelFragment f255635d;

        k(AccountPanelFragment accountPanelFragment) {
            this.f255635d = accountPanelFragment;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.onlinestatus.model.g gVar) {
            if (gVar == null) {
                return;
            }
            this.f255635d.Si(gVar.f256022a, gVar.f256023b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class l implements Observer<SimpleAccount> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AccountPanelViewModel f255637d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f255638e;

        l(AccountPanelViewModel accountPanelViewModel, QBaseActivity qBaseActivity) {
            this.f255637d = accountPanelViewModel;
            this.f255638e = qBaseActivity;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(SimpleAccount simpleAccount) {
            if (simpleAccount == null) {
                return;
            }
            this.f255637d.i3(this.f255638e, simpleAccount);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class m implements Observer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AccountPanelFragment f255640d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ s f255641e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AccountPanelViewModel f255642f;

        m(AccountPanelFragment accountPanelFragment, s sVar, AccountPanelViewModel accountPanelViewModel) {
            this.f255640d = accountPanelFragment;
            this.f255641e = sVar;
            this.f255642f = accountPanelViewModel;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                j.this.z(this.f255640d, this.f255641e, this.f255642f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w(au auVar, AppRuntime appRuntime, QBaseActivity qBaseActivity) {
        com.tencent.mobileqq.onlinestatus.manager.d dVar = (com.tencent.mobileqq.onlinestatus.manager.d) ((IOnlineStatusManagerService) appRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.d.class);
        if (dVar != null) {
            return dVar.r(auVar, qBaseActivity);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(AccountPanelFragment accountPanelFragment, au auVar) {
        if (auVar == null || auVar.B == 0 || !accountPanelFragment.isShowing()) {
            return;
        }
        accountPanelFragment.cj(auVar.f255494g, auVar.f255489b);
    }

    public void i(com.tencent.mobileqq.mvvm.d dVar, AccountPanelViewModel accountPanelViewModel, s sVar) {
        accountPanelViewModel.j2().observe(dVar, new g(sVar));
    }

    public void j(com.tencent.mobileqq.mvvm.d dVar, AccountPanelViewModel accountPanelViewModel, final s sVar) {
        MutableLiveData<com.tencent.mobileqq.onlinestatus.model.e> s26 = accountPanelViewModel.s2();
        Objects.requireNonNull(sVar);
        s26.observe(dVar, new Observer() { // from class: com.tencent.mobileqq.onlinestatus.binder.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                s.this.D1((com.tencent.mobileqq.onlinestatus.model.e) obj);
            }
        });
    }

    public void k(com.tencent.mobileqq.mvvm.d dVar, AccountPanelViewModel accountPanelViewModel, AccountPanelFragment accountPanelFragment) {
        accountPanelViewModel.k2().observe(dVar, new f(accountPanelFragment));
    }

    public void l(com.tencent.mobileqq.mvvm.d dVar, AccountPanelViewModel accountPanelViewModel, s sVar, AccountPanelFragment accountPanelFragment) {
        accountPanelViewModel.l2().observe(dVar, new k(accountPanelFragment));
    }

    public void m(com.tencent.mobileqq.mvvm.d dVar, AccountPanelViewModel accountPanelViewModel, s sVar) {
        accountPanelViewModel.m2().observe(dVar, new C8185j(sVar));
    }

    public void n(com.tencent.mobileqq.mvvm.d dVar, AccountPanelViewModel accountPanelViewModel, final AccountPanelFragment accountPanelFragment) {
        accountPanelViewModel.n2().observe(dVar, new Observer() { // from class: com.tencent.mobileqq.onlinestatus.binder.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                j.y(AccountPanelFragment.this, (au) obj);
            }
        });
    }

    public void o(com.tencent.mobileqq.mvvm.d dVar, AccountPanelViewModel accountPanelViewModel, s sVar) {
        accountPanelViewModel.o2().observe(dVar, new i(sVar));
    }

    public void p(com.tencent.mobileqq.mvvm.d dVar, AccountPanelViewModel accountPanelViewModel, s sVar) {
        accountPanelViewModel.p2().observe(dVar, new e(sVar));
    }

    public void q(com.tencent.mobileqq.mvvm.d dVar, AccountPanelViewModel accountPanelViewModel, AccountPanelFragment accountPanelFragment) {
        accountPanelViewModel.q2().observe(dVar, new b(accountPanelFragment));
    }

    public void r(com.tencent.mobileqq.mvvm.d dVar, AccountPanelViewModel accountPanelViewModel, s sVar, AccountPanelFragment accountPanelFragment) {
        accountPanelViewModel.u2().observe(dVar, new a(accountPanelFragment, sVar));
    }

    public void s(com.tencent.mobileqq.mvvm.d dVar, AccountPanelViewModel accountPanelViewModel, QBaseActivity qBaseActivity, y yVar) {
        accountPanelViewModel.v2().observe(dVar, new c(yVar, accountPanelViewModel, qBaseActivity));
    }

    public void t(com.tencent.mobileqq.mvvm.d dVar, AccountPanelViewModel accountPanelViewModel, s sVar) {
        accountPanelViewModel.x2().observe(dVar, new h(sVar));
    }

    public void u(com.tencent.mobileqq.mvvm.d dVar, AccountPanelViewModel accountPanelViewModel, s sVar, QBaseActivity qBaseActivity) {
        accountPanelViewModel.y2().observe(dVar, new l(accountPanelViewModel, qBaseActivity));
    }

    public void v(com.tencent.mobileqq.mvvm.d dVar, AccountPanelViewModel accountPanelViewModel, s sVar, AccountPanelFragment accountPanelFragment) {
        accountPanelViewModel.A2().observe(dVar, new m(accountPanelFragment, sVar, accountPanelViewModel));
    }

    public void x(AccountPanelFragment accountPanelFragment, s sVar) {
        if (accountPanelFragment != null && accountPanelFragment.isShowing()) {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (!aa.e(accountPanelFragment.getContext(), waitAppRuntime.getCurrentUin())) {
                StatusRankMgr$StatusRankRequest statusRankMgr$StatusRankRequest = new StatusRankMgr$StatusRankRequest();
                statusRankMgr$StatusRankRequest.status_id.set(1080);
                statusRankMgr$StatusRankRequest.uin.set(0L);
                statusRankMgr$StatusRankRequest.genrank.set(true);
                com.tencent.mobileqq.onlinestatus.olympic.helper.a.a(waitAppRuntime, statusRankMgr$StatusRankRequest, new d(sVar, accountPanelFragment, waitAppRuntime));
            }
        }
    }

    public void z(y yVar, s sVar, AccountPanelViewModel accountPanelViewModel) {
        if (!yVar.isShowing()) {
            return;
        }
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        accountPanelViewModel.l2().setValue(new com.tencent.mobileqq.onlinestatus.model.g(((IOnlineStatusService) appInterface.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus(), af.C().M(appInterface)));
        sVar.M1();
        accountPanelViewModel.r2();
        accountPanelViewModel.A2().setValue(Boolean.FALSE);
    }
}
