package com.tencent.imcore.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
class RandomGetMessageLoader$1 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean C;
    final /* synthetic */ boolean D;
    final /* synthetic */ boolean E;
    final /* synthetic */ long F;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ aj f116441d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f116442e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f116443f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f116444h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ long f116445i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ long f116446m;
    final /* synthetic */ ai this$0;

    @Override // java.lang.Runnable
    public void run() {
        boolean n3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.this$0.f116521a.U(this.f116441d);
        if (QLog.isColorLevel()) {
            QLog.d("RandomGetMessageLoader", 2, "refreshTroopUnreadMessage begin");
        }
        aj ajVar = this.f116441d;
        int i3 = this.f116442e;
        ajVar.f116543u = i3;
        ajVar.f116535m = 0;
        this.this$0.b(this.f116443f, this.f116444h, this.f116445i, i3, this.f116446m, ajVar, this.C);
        n3 = this.this$0.n(this.f116443f, this.f116444h, this.f116445i, this.f116446m, this.f116442e, this.D);
        QLog.d("RandomGetMessageLoader", 1, "refreshTroopUnreadMessage isSuccess:", Boolean.valueOf(n3));
        if (n3 && this.E) {
            BaseMessageManagerForTroopAndDisc baseMessageManagerForTroopAndDisc = this.this$0.f116521a;
            int i16 = this.f116444h;
            String str = this.f116443f;
            baseMessageManagerForTroopAndDisc.U0(i16, str, this.F, baseMessageManagerForTroopAndDisc.r(str, i16));
        }
        aj ajVar2 = this.f116441d;
        ajVar2.f116532j = n3;
        if (this.C) {
            this.this$0.f116521a.f116282e.setChangeAndNotify(ajVar2);
        }
        this.this$0.f116521a.f116282e.getFacadeHandler().post(new Runnable() { // from class: com.tencent.imcore.message.RandomGetMessageLoader$1.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RandomGetMessageLoader$1.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                Map<String, Boolean> refreshActionMap = RandomGetMessageLoader$1.this.this$0.f116521a.f116282e.getRefreshActionMap();
                RandomGetMessageLoader$1 randomGetMessageLoader$1 = RandomGetMessageLoader$1.this;
                if (refreshActionMap.containsKey(ao.f(randomGetMessageLoader$1.f116443f, randomGetMessageLoader$1.f116444h))) {
                    Map<String, Boolean> refreshActionMap2 = RandomGetMessageLoader$1.this.this$0.f116521a.f116282e.getRefreshActionMap();
                    RandomGetMessageLoader$1 randomGetMessageLoader$12 = RandomGetMessageLoader$1.this;
                    refreshActionMap2.remove(ao.f(randomGetMessageLoader$12.f116443f, randomGetMessageLoader$12.f116444h));
                }
            }
        });
        if (QLog.isColorLevel()) {
            QLog.d("RandomGetMessageLoader", 2, "refreshTroopUnreadMessage end");
        }
    }
}
