package com.tencent.mobileqq.onlinestatus.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.repository.k;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class g extends com.tencent.mobileqq.mvvm.c<k> implements Observer<List<com.tencent.mobileqq.onlinestatus.model.i>> {
    private com.tencent.mobileqq.mvvm.d C;
    private a D;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<List<com.tencent.mobileqq.onlinestatus.model.i>> f256867i;

    /* renamed from: m, reason: collision with root package name */
    private final List<com.tencent.mobileqq.onlinestatus.model.d> f256868m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void o3(List<com.tencent.mobileqq.onlinestatus.model.i> list);
    }

    public g(k kVar) {
        super(kVar);
        this.f256867i = new MutableLiveData<>();
        this.f256868m = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q1(List list) {
        P1().setValue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R1(final List list) {
        long j3;
        boolean z16;
        com.tencent.mobileqq.onlinestatus.model.i iVar;
        boolean z17;
        if (list == null) {
            return;
        }
        this.f256868m.clear();
        AppRuntime.Status status = AppRuntime.Status.online;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            AppRuntime.Status onlineStatus = ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
            j3 = af.C().M(peekAppRuntime);
            if (Objects.equals(status, onlineStatus) && 0 == j3) {
                z17 = true;
            } else {
                z17 = false;
            }
            z16 = z17;
            status = onlineStatus;
        } else {
            j3 = 0;
            z16 = false;
        }
        com.tencent.mobileqq.onlinestatus.model.i iVar2 = null;
        if (OnlineStatusToggleUtils.n()) {
            iVar = null;
            int i3 = 0;
            while (i3 < list.size()) {
                com.tencent.mobileqq.onlinestatus.model.i iVar3 = (com.tencent.mobileqq.onlinestatus.model.i) list.get(i3);
                au auVar = iVar3.f256028a;
                AppRuntime.Status status2 = auVar.f255494g;
                com.tencent.mobileqq.onlinestatus.model.i iVar4 = iVar;
                long j16 = auVar.f255489b;
                if (!z16 && Objects.equals(AppRuntime.Status.online, status2) && j16 == 0) {
                    list.remove(i3);
                    iVar = iVar3;
                } else {
                    if (Objects.equals(status, status2) && j3 == j16) {
                        list.remove(i3);
                        iVar2 = iVar3;
                    } else {
                        i3++;
                    }
                    iVar = iVar4;
                }
            }
        } else {
            com.tencent.mobileqq.onlinestatus.model.i iVar5 = null;
            int i16 = 0;
            while (i16 < list.size()) {
                com.tencent.mobileqq.onlinestatus.model.i iVar6 = (com.tencent.mobileqq.onlinestatus.model.i) list.get(i16);
                au auVar2 = iVar6.f256028a;
                AppRuntime.Status status3 = auVar2.f255494g;
                long j17 = auVar2.f255489b;
                if (Objects.equals(AppRuntime.Status.online, status3) && j17 == 0) {
                    list.remove(i16);
                    iVar5 = iVar6;
                } else if (Objects.equals(status, status3) && j3 == j17) {
                    list.remove(i16);
                    iVar2 = iVar6;
                } else {
                    i16++;
                }
            }
            iVar = iVar5;
        }
        if (iVar2 != null) {
            list.add(0, iVar2);
        }
        if (iVar != null) {
            list.add(iVar);
        }
        Iterator it = list.iterator();
        int i17 = 0;
        while (it.hasNext()) {
            com.tencent.mobileqq.onlinestatus.model.i iVar7 = (com.tencent.mobileqq.onlinestatus.model.i) it.next();
            this.f256868m.addAll(iVar7.f256029b);
            iVar7.f256032e = i17;
            i17 += iVar7.f256031d;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.viewmodel.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.Q1(list);
            }
        });
    }

    public void N1(@NonNull com.tencent.mobileqq.mvvm.d dVar) {
        this.C = dVar;
        this.f256867i.observe(dVar, this);
        T t16 = this.mRepository;
        if (t16 != 0) {
            ((k) t16).m(this);
        }
    }

    public List<com.tencent.mobileqq.onlinestatus.model.d> O1() {
        return this.f256868m;
    }

    public MutableLiveData<List<com.tencent.mobileqq.onlinestatus.model.i>> P1() {
        return this.f256867i;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: S1, reason: merged with bridge method [inline-methods] */
    public void onChanged(List<com.tencent.mobileqq.onlinestatus.model.i> list) {
        a aVar = this.D;
        if (aVar != null) {
            aVar.o3(list);
        }
    }

    public void T1() {
        ((k) this.mRepository).p(new k.a() { // from class: com.tencent.mobileqq.onlinestatus.viewmodel.e
            @Override // com.tencent.mobileqq.onlinestatus.repository.k.a
            public final void a(List list) {
                g.this.R1(list);
            }
        });
    }

    public void U1(a aVar) {
        this.D = aVar;
    }

    public void destroy() {
        com.tencent.mobileqq.mvvm.d dVar = this.C;
        if (dVar != null) {
            this.f256867i.removeObservers(dVar);
            this.C = null;
        }
        T t16 = this.mRepository;
        if (t16 != 0) {
            ((k) t16).l();
        }
        this.D = null;
    }
}
