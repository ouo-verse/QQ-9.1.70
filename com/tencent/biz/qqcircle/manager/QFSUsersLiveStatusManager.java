package com.tencent.biz.qqcircle.manager;

import com.tencent.biz.qqcircle.immersive.feed.event.QFSLiveStatusChangedEvent;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.requests.QFSQueryUsersLiverStatusRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$QueryUsersLiverStatusRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSUsersLiveStatusManager {

    /* renamed from: d, reason: collision with root package name */
    private static volatile QFSUsersLiveStatusManager f91525d;

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f91526a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<String> f91527b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private Runnable f91528c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$QueryUsersLiverStatusRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$QueryUsersLiverStatusRsp feedCloudRead$QueryUsersLiverStatusRsp) {
            if (z16 && j3 == 0 && feedCloudRead$QueryUsersLiverStatusRsp != null) {
                List<String> list = feedCloudRead$QueryUsersLiverStatusRsp.in_live_uids.get();
                if (list.isEmpty()) {
                    QFSUsersLiveStatusManager.this.h(new ArrayList(QFSUsersLiveStatusManager.this.f91526a));
                    QFSUsersLiveStatusManager.this.f91526a.clear();
                    QFSUsersLiveStatusManager.this.f91527b.clear();
                    QLog.d("QFSUsersLiveStatusManager", 1, "[checkFeedPostersLiveStatus] no poster in Live.");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (String str2 : QFSUsersLiveStatusManager.this.f91526a) {
                    if (!list.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    QFSUsersLiveStatusManager.this.f91526a.remove((String) it.next());
                }
                QFSUsersLiveStatusManager.this.h(arrayList);
                QFSUsersLiveStatusManager.this.f91527b.clear();
                QFSUsersLiveStatusManager.this.f91527b.addAll(list);
                Iterator<String> it5 = list.iterator();
                while (it5.hasNext()) {
                    QLog.d("QFSUsersLiveStatusManager", 1, "[checkFeedPostersLiveStatus] uin: " + it5.next() + ", isInLive.");
                }
                return;
            }
            QLog.e("QFSUsersLiveStatusManager", 1, "handleRsp isSuc:", Boolean.valueOf(z16), ",retCode:", Long.valueOf(j3), ",errMsg:", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f91528c == null) {
            this.f91528c = new Runnable() { // from class: com.tencent.biz.qqcircle.manager.QFSUsersLiveStatusManager.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSUsersLiveStatusManager.this.n();
                    QFSUsersLiveStatusManager.this.g();
                }
            };
        }
        RFWThreadManager.getInstance().execOnSubThread(this.f91528c, 180000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final List<String> list) {
        if (list != null && !list.isEmpty()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.manager.QFSUsersLiveStatusManager.3
                @Override // java.lang.Runnable
                public void run() {
                    SimpleEventBus.getInstance().dispatchEvent(new QFSLiveStatusChangedEvent(list));
                }
            });
        }
    }

    public static QFSUsersLiveStatusManager i() {
        if (f91525d == null) {
            synchronized (QFSUsersLiveStatusManager.class) {
                if (f91525d == null) {
                    f91525d = new QFSUsersLiveStatusManager();
                }
            }
        }
        return f91525d;
    }

    private boolean j() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_query_posters_live_status", true);
    }

    private boolean l(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!r.l0(feedCloudMeta$StFeed.poster.get()) && !r.p0(feedCloudMeta$StFeed)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.f91526a.isEmpty()) {
            return;
        }
        VSNetworkHelper.getInstance().sendRequest(new QFSQueryUsersLiverStatusRequest(this.f91526a), new a());
    }

    public void f(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && l(feedCloudMeta$StFeed) && j()) {
            String str = feedCloudMeta$StFeed.poster.f398463id.get();
            if (this.f91526a.contains(str)) {
                return;
            }
            this.f91526a.add(str);
            this.f91527b.add(str);
            QLog.d("QFSUsersLiveStatusManager", 1, "[addQueryUser] add live user: " + str);
        }
    }

    public boolean k(String str) {
        if (!j()) {
            return true;
        }
        return this.f91527b.contains(str);
    }

    public void m() {
        this.f91527b.clear();
        this.f91526a.clear();
        QLog.d("QFSUsersLiveStatusManager", 1, "release");
    }

    public void o() {
        if (!j()) {
            return;
        }
        g();
        QLog.d("QFSUsersLiveStatusManager", 1, "Start Check.");
    }

    public void p() {
        if (!j()) {
            return;
        }
        if (this.f91528c != null) {
            RFWThreadManager.getInstance().remove(this.f91528c);
            this.f91528c = null;
        }
        QLog.d("QFSUsersLiveStatusManager", 1, "Stop Check.");
    }
}
