package com.tencent.mobileqq.vasgift.mvvm.business;

import android.util.Pair;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends com.tencent.mobileqq.mvvm.b {

    /* renamed from: e, reason: collision with root package name */
    public static boolean f311815e = false;

    /* renamed from: d, reason: collision with root package name */
    private f43.c f311816d = null;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements Observer<com.tencent.mobileqq.vasgift.mvvm.business.f<List<List<com.tencent.mobileqq.qqgift.data.service.d>>>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ sh2.c f311817d;

        a(sh2.c cVar) {
            this.f311817d = cVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.vasgift.mvvm.business.f<List<List<com.tencent.mobileqq.qqgift.data.service.d>>> fVar) {
            List<List<com.tencent.mobileqq.qqgift.data.service.d>> b16 = fVar.b();
            long currentTimeMillis = System.currentTimeMillis();
            if (b16 != null) {
                boolean isEmpty = b16.isEmpty();
                this.f311817d.d(isEmpty);
                if (!isEmpty) {
                    c.this.f311816d.updateData(b16);
                    c.this.f311816d.notifyDataSetChanged();
                    com.tencent.mobileqq.vasgift.utils.e.f312015a.a();
                }
                this.f311817d.v();
                VasPerfReportUtils.report(VasPerfReportUtils.WHILE_UPDATE_ITEM, VasPerfReportUtils.WITHIN_SDK, "", "", System.currentTimeMillis() - currentTimeMillis);
                if (QLog.isColorLevel()) {
                    QLog.i("GiftPanelViewBinder", 2, "[bindPanelView] onGiftData change,size:" + b16.size());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements Observer<com.tencent.mobileqq.qqgift.mvvm.business.data.b> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.qqgift.mvvm.business.data.b bVar) {
            if (bVar != null && c.this.f311816d != null) {
                c.this.f311816d.v0(bVar);
                c.this.f311816d.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vasgift.mvvm.business.c$c, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C8937c implements Observer<String> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ sh2.c f311820d;

        C8937c(sh2.c cVar) {
            this.f311820d = cVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            if (QLog.isColorLevel()) {
                QLog.i("GiftPanelViewBinder", 2, "[bindRechargeView] onRechargeData change,text:" + str);
            }
            this.f311820d.w(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d implements Observer<Long> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ sh2.c f311822d;

        d(sh2.c cVar) {
            this.f311822d = cVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            if (QLog.isColorLevel()) {
                QLog.i("GiftPanelViewBinder", 2, "[bindFreeCoinView] onFreeCoinBalance change,balance:" + l3);
            }
            this.f311822d.t(l3.longValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class e implements Observer<Long> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ sh2.c f311824d;

        e(sh2.c cVar) {
            this.f311824d = cVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            if (QLog.isColorLevel()) {
                QLog.i("GiftPanelViewBinder", 2, "[bindFreeCoinView] onMarketingBalance change,balance:" + l3);
            }
            this.f311824d.r(l3.longValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class f implements Observer<List<com.tencent.mobileqq.qqgift.mvvm.business.data.c>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ sh2.c f311826d;

        f(sh2.c cVar) {
            this.f311826d = cVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<com.tencent.mobileqq.qqgift.mvvm.business.data.c> list) {
            if (QLog.isColorLevel()) {
                QLog.i("GiftPanelViewBinder", 2, "[bindRechargeView] onTabData change,tabs:" + list.toString());
            }
            this.f311826d.x(list);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class g implements Observer<Integer> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ sh2.c f311828d;

        g(sh2.c cVar) {
            this.f311828d = cVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            if (QLog.isColorLevel()) {
                QLog.i("GiftPanelViewBinder", 2, "[bindSendGiftView] onChanged,viewType:" + num);
            }
            this.f311828d.g(num.intValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class h implements Observer<Pair<Integer, Integer>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ sh2.c f311830d;

        h(sh2.c cVar) {
            this.f311830d = cVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Pair<Integer, Integer> pair) {
            int intValue = ((Integer) pair.first).intValue();
            if (intValue != -2) {
                if (intValue != -1) {
                    if (!c.f311815e) {
                        return;
                    }
                    this.f311830d.m(((Integer) pair.first).intValue(), ((Integer) pair.second).intValue());
                    return;
                }
                this.f311830d.q(false);
                return;
            }
            this.f311830d.q(true);
        }
    }

    public void h(LifecycleOwner lifecycleOwner, QQGiftPanelViewModel qQGiftPanelViewModel, sh2.c cVar) {
        qQGiftPanelViewModel.E2().removeObservers(lifecycleOwner);
        qQGiftPanelViewModel.E2().observe(lifecycleOwner, new d(cVar));
    }

    public void i(LifecycleOwner lifecycleOwner, QQGiftPanelViewModel qQGiftPanelViewModel, sh2.c cVar) {
        f43.c cVar2 = new f43.c(cVar.a(), qQGiftPanelViewModel);
        this.f311816d = cVar2;
        cVar.setAdapter(cVar2);
        qQGiftPanelViewModel.G2().removeObservers(lifecycleOwner);
        qQGiftPanelViewModel.G2().observe(lifecycleOwner, new a(cVar));
        qQGiftPanelViewModel.N2().observe(lifecycleOwner, new b());
    }

    public void j(LifecycleOwner lifecycleOwner, QQGiftPanelViewModel qQGiftPanelViewModel, sh2.c cVar) {
        qQGiftPanelViewModel.K2().removeObservers(lifecycleOwner);
        qQGiftPanelViewModel.K2().observe(lifecycleOwner, new e(cVar));
    }

    public void k(LifecycleOwner lifecycleOwner, QQGiftPanelViewModel qQGiftPanelViewModel, sh2.c cVar) {
        qQGiftPanelViewModel.O2().removeObservers(lifecycleOwner);
        qQGiftPanelViewModel.O2().observe(lifecycleOwner, new C8937c(cVar));
    }

    public void l(LifecycleOwner lifecycleOwner, QQGiftPanelViewModel qQGiftPanelViewModel, sh2.c cVar) {
        qQGiftPanelViewModel.R2().removeObservers(lifecycleOwner);
        qQGiftPanelViewModel.R2().observe(lifecycleOwner, new g(cVar));
    }

    public void m(LifecycleOwner lifecycleOwner, QQGiftPanelViewModel qQGiftPanelViewModel, sh2.c cVar) {
        f311815e = false;
        qQGiftPanelViewModel.S2().removeObservers(lifecycleOwner);
        qQGiftPanelViewModel.S2().observe(lifecycleOwner, new h(cVar));
    }

    public void n(LifecycleOwner lifecycleOwner, QQGiftPanelViewModel qQGiftPanelViewModel, sh2.c cVar) {
        qQGiftPanelViewModel.U2().removeObservers(lifecycleOwner);
        qQGiftPanelViewModel.U2().observe(lifecycleOwner, new f(cVar));
    }
}
