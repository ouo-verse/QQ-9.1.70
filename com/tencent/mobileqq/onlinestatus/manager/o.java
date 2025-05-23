package com.tencent.mobileqq.onlinestatus.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.manager.g;
import com.tencent.mobileqq.onlinestatus.utils.ae;
import com.tencent.mobileqq.onlinestatus.x;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class o implements g {

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<Long, TreeSet<com.tencent.mobileqq.onlinestatus.model.d>> f255974d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f255975e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private final ConcurrentLinkedQueue<g.a> f255976f = new ConcurrentLinkedQueue<>();

    private long A(com.tencent.mobileqq.onlinestatus.model.d dVar) {
        return B(ae.c(dVar.getStatus()), dVar.getStatus().e0());
    }

    private long B(AppRuntime.Status status, long j3) {
        return (status.getValue() << 60) + j3;
    }

    private String C() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getCurrentAccountUin();
        }
        return "";
    }

    private Map<String, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> D(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(arrayList, "OnlineStatusFriendDataManager");
            if (onlineStatusSimpleInfoWithUid != null && !onlineStatusSimpleInfoWithUid.isEmpty()) {
                HashMap hashMap = new HashMap();
                Iterator<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> it = onlineStatusSimpleInfoWithUid.iterator();
                while (it.hasNext()) {
                    com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.getUid())) {
                        hashMap.put(next.getUid(), next);
                    }
                }
                return hashMap;
            }
            return new HashMap(0);
        }
        return new HashMap(0);
    }

    private Comparator<com.tencent.mobileqq.onlinestatus.model.d> E() {
        return new Comparator() { // from class: com.tencent.mobileqq.onlinestatus.manager.n
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int F;
                F = o.F((com.tencent.mobileqq.onlinestatus.model.d) obj, (com.tencent.mobileqq.onlinestatus.model.d) obj2);
                return F;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int F(com.tencent.mobileqq.onlinestatus.model.d dVar, com.tencent.mobileqq.onlinestatus.model.d dVar2) {
        if (dVar != dVar2) {
            if (dVar == null || dVar2 == null || !dVar.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x().equals(dVar2.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
                if (dVar == null) {
                    return 1;
                }
                if (dVar2 == null) {
                    return -1;
                }
                boolean e16 = x.e(dVar.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), dVar.getStatus().F());
                boolean e17 = x.e(dVar2.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), dVar2.getStatus().F());
                if (e16 && !e17) {
                    return -1;
                }
                if ((!e16 && e17) || dVar.getStatus().F() <= dVar2.getStatus().F()) {
                    return 1;
                }
                return -1;
            }
            return 0;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        H(false);
    }

    private void I(com.tencent.mobileqq.onlinestatus.model.d dVar, String str) {
        if (dVar == null || dVar.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x().equals(str)) {
            return;
        }
        long A = A(dVar);
        TreeSet<com.tencent.mobileqq.onlinestatus.model.d> treeSet = this.f255974d.get(Long.valueOf(A));
        if (treeSet == null) {
            treeSet = new TreeSet<>(E());
            this.f255974d.put(Long.valueOf(A), treeSet);
        }
        treeSet.add(dVar);
    }

    private void J(List<com.tencent.mobileqq.onlinestatus.model.d> list) {
        if (list != null && !list.isEmpty()) {
            String C = C();
            Iterator<com.tencent.mobileqq.onlinestatus.model.d> it = list.iterator();
            while (it.hasNext()) {
                I(it.next(), C);
            }
        }
    }

    private void z() {
        if (this.f255976f.isEmpty()) {
            return;
        }
        Iterator<g.a> it = this.f255976f.iterator();
        while (it.hasNext()) {
            it.next().onUpdate();
        }
    }

    public void H(boolean z16) {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar;
        if (this.f255975e.get()) {
            if (!z16) {
                return;
            }
            while (this.f255975e.get()) {
                try {
                    LockMethodProxy.sleep(5L);
                } catch (InterruptedException e16) {
                    QLog.d("OnlineStatusFriendDataManager", 1, "triggerUpdateOnlineStatusListSync interrupt:", e16);
                }
            }
            return;
        }
        if (!this.f255975e.compareAndSet(false, true)) {
            QLog.d("OnlineStatusFriendDataManager", 1, "triggerUpdateOnlineStatusListSync failed to modify cache!!!");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("OnlineStatusFriendDataManager", 1, "null runtime!!!");
            this.f255975e.compareAndSet(true, false);
            return;
        }
        List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> allFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getAllFriend("OnlineStatusFriendDataManager");
        if (allFriend.isEmpty()) {
            ((IFriendHandlerService) peekAppRuntime.getRuntimeService(IFriendHandlerService.class, "all")).requestFriendList(false);
            this.f255975e.compareAndSet(true, false);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar : allFriend) {
            if (!dVar.x().isEmpty() && !dVar.getUid().isEmpty()) {
                arrayList.add(dVar.getUid());
            }
        }
        Map<String, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> D = D(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar2 : allFriend) {
            if (!dVar2.x().isEmpty() && !dVar2.getUid().isEmpty() && (cVar = D.get(dVar2.getUid())) != null) {
                arrayList2.add(new com.tencent.mobileqq.onlinestatus.model.d(dVar2, cVar));
            }
        }
        this.f255974d.clear();
        J(arrayList2);
        z();
        this.f255975e.compareAndSet(true, false);
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.g
    public boolean d(g.a aVar) {
        if (this.f255976f.isEmpty()) {
            return false;
        }
        return this.f255976f.remove(aVar);
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.g
    public TreeSet<com.tencent.mobileqq.onlinestatus.model.d> f(au auVar) {
        if (auVar == null) {
            return null;
        }
        return this.f255974d.get(Long.valueOf(B(auVar.f255494g, auVar.f255489b)));
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.j
    public void onDestroy() {
        if (!this.f255975e.compareAndSet(false, true)) {
            QLog.d("OnlineStatusFriendDataManager", 1, "onDestroy failed to modify cache!!!");
        } else {
            this.f255974d.clear();
            this.f255975e.compareAndSet(true, false);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.g
    public boolean s(g.a aVar) {
        if (this.f255976f.contains(aVar)) {
            return false;
        }
        return this.f255976f.add(aVar);
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.g
    public void v() {
        if (this.f255975e.get()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.manager.m
            @Override // java.lang.Runnable
            public final void run() {
                o.this.G();
            }
        }, 16, null, false);
    }
}
