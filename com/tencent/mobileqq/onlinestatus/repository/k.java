package com.tencent.mobileqq.onlinestatus.repository;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.aq;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.manager.g;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class k extends com.tencent.mobileqq.mvvm.a implements g.a {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.onlinestatus.manager.g f256242a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.onlinestatus.viewmodel.g f256243b;

    /* renamed from: c, reason: collision with root package name */
    private a f256244c;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        @WorkerThread
        void a(List<com.tencent.mobileqq.onlinestatus.model.i> list);
    }

    private List<au> n() {
        return af.C().n(new ArrayList<>(af.C().q()));
    }

    private List<com.tencent.mobileqq.onlinestatus.model.i> o() {
        List<au> n3 = n();
        if (n3 != null && !n3.isEmpty()) {
            long currentTimeMillis = System.currentTimeMillis();
            TreeSet treeSet = new TreeSet(new Comparator() { // from class: com.tencent.mobileqq.onlinestatus.repository.j
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int q16;
                    q16 = k.q((com.tencent.mobileqq.onlinestatus.model.i) obj, (com.tencent.mobileqq.onlinestatus.model.i) obj2);
                    return q16;
                }
            });
            int a16 = aq.a();
            for (au auVar : n3) {
                TreeSet<com.tencent.mobileqq.onlinestatus.model.d> f16 = this.f256242a.f(auVar);
                if (f16 != null && !f16.isEmpty()) {
                    com.tencent.mobileqq.onlinestatus.model.i iVar = new com.tencent.mobileqq.onlinestatus.model.i();
                    iVar.f256028a = auVar;
                    iVar.f256029b = new ArrayList();
                    Iterator<com.tencent.mobileqq.onlinestatus.model.d> it = f16.iterator();
                    int i3 = 0;
                    while (it.hasNext()) {
                        com.tencent.mobileqq.onlinestatus.model.d next = it.next();
                        if (i3 >= a16) {
                            break;
                        }
                        iVar.f256029b.add(next);
                        i3++;
                    }
                    iVar.f256030c = Math.min(i3, 10);
                    iVar.f256031d = i3;
                    treeSet.add(iVar);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusFriendListRepository", 2, "getStatusGroupData spend time: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            return new ArrayList(treeSet);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int q(com.tencent.mobileqq.onlinestatus.model.i iVar, com.tencent.mobileqq.onlinestatus.model.i iVar2) {
        if (iVar == iVar2 || iVar.f256028a.equals(iVar2.f256028a)) {
            return 0;
        }
        if (iVar.f256029b.isEmpty()) {
            return 1;
        }
        if (iVar2.f256029b.isEmpty()) {
            return -1;
        }
        if (iVar.f256029b.get(0).getStatus().F() <= iVar2.f256029b.get(0).getStatus().F()) {
            return 1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(a aVar) {
        s(o(), aVar);
    }

    private void s(@Nullable List<com.tencent.mobileqq.onlinestatus.model.i> list, @NonNull a aVar) {
        if (list != null && !list.isEmpty()) {
            aVar.a(list);
            l();
        }
    }

    public void l() {
        com.tencent.mobileqq.onlinestatus.manager.g gVar = this.f256242a;
        if (gVar != null) {
            gVar.d(this);
        }
        this.f256244c = null;
    }

    public void m(com.tencent.mobileqq.onlinestatus.viewmodel.g gVar) {
        this.f256243b = gVar;
        com.tencent.mobileqq.onlinestatus.manager.g gVar2 = (com.tencent.mobileqq.onlinestatus.manager.g) ((IOnlineStatusManagerService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.g.class);
        this.f256242a = gVar2;
        gVar2.s(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.a
    public void onDestroy() {
        com.tencent.mobileqq.onlinestatus.manager.g gVar = this.f256242a;
        if (gVar != null) {
            gVar.d(this);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.g.a
    public void onUpdate() {
        final a aVar = this.f256244c;
        if (aVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.repository.i
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.r(aVar);
                }
            }, 16, null, true);
        } else {
            s(o(), aVar);
        }
    }

    public void p(a aVar) {
        this.f256244c = aVar;
        com.tencent.mobileqq.onlinestatus.manager.g gVar = this.f256242a;
        if (gVar == null) {
            return;
        }
        gVar.v();
    }
}
