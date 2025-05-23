package com.tencent.biz.qqcircle.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowListLoadEvent;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetFollowListRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StRelationInfo;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StGetFollowListRsp;
import feedcloud.FeedCloudWrite$StDoFollowRsp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleSpecialFollowManager implements Handler.Callback {
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f91502d;

    /* renamed from: e, reason: collision with root package name */
    private final SimpleEventBus f91503e;

    /* renamed from: f, reason: collision with root package name */
    private final d f91504f;

    /* renamed from: h, reason: collision with root package name */
    private final Set<String> f91505h;

    /* renamed from: i, reason: collision with root package name */
    private f f91506i;

    /* renamed from: m, reason: collision with root package name */
    private int f91507m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoFollowRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f91510a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f91511b;

        a(boolean z16, String str) {
            this.f91510a = z16;
            this.f91511b = str;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoFollowRsp feedCloudWrite$StDoFollowRsp) {
            boolean z17;
            int i3;
            QLog.d("QCircleSpecialFollowMgr", 1, "doSpecialFollow: isSuccess" + z16 + "retCode:" + j3 + "    errMsg:" + str);
            if (z16 && j3 == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                QCircleSpecialFollowManager.this.k(R.string.f195404ei, false);
                return;
            }
            synchronized (QCircleSpecialFollowManager.this) {
                QCircleSpecialFollowManager.this.f91507m++;
            }
            QCircleSpecialFollowManager.this.k(R.string.f195454en, true);
            Handler handler = QCircleSpecialFollowManager.this.f91502d;
            if (this.f91510a) {
                i3 = 1001;
            } else {
                i3 = 1002;
            }
            handler.obtainMessage(i3, this.f91511b).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFollowListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f91513a;

        b(int i3) {
            this.f91513a = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFollowListRsp feedCloudRead$StGetFollowListRsp) {
            QLog.d("QCircleSpecialFollowMgr", 1, "updateSpecialFollowList: isSuccess" + z16 + "retCode:" + j3 + "    errMsg:" + str);
            synchronized (QCircleSpecialFollowManager.this) {
                if (QCircleSpecialFollowManager.this.f91507m == this.f91513a) {
                    QCircleSpecialFollowManager.this.C = false;
                    if (z16 && j3 == 0 && feedCloudRead$StGetFollowListRsp != null) {
                        QCircleSpecialFollowManager.this.f91502d.obtainMessage(1003, new g(feedCloudRead$StGetFollowListRsp, this.f91513a)).sendToTarget();
                        return;
                    } else {
                        QCircleSpecialFollowManager.this.f91502d.obtainMessage(1005).sendToTarget();
                        return;
                    }
                }
                QCircleSpecialFollowManager.this.l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFollowListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f91515a;

        c(f fVar) {
            this.f91515a = fVar;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFollowListRsp feedCloudRead$StGetFollowListRsp) {
            QLog.d("QCircleSpecialFollowMgr", 1, "loadMoreSpecialFollowList: isSuccess" + z16 + "retCode:" + j3 + "    errMsg:" + str);
            if (z16 && j3 == 0 && feedCloudRead$StGetFollowListRsp != null) {
                QCircleSpecialFollowManager.this.f91502d.obtainMessage(1004, new g(feedCloudRead$StGetFollowListRsp, this.f91515a.f91521c)).sendToTarget();
            } else {
                QCircleSpecialFollowManager.this.f91502d.obtainMessage(1005).sendToTarget();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class d implements SimpleEventReceiver<QCircleFollowUpdateEvent> {

        /* renamed from: d, reason: collision with root package name */
        private final Handler f91517d;

        d(Handler handler) {
            this.f91517d = handler;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public ArrayList<Class<QCircleFollowUpdateEvent>> getEventClass() {
            ArrayList<Class<QCircleFollowUpdateEvent>> arrayList = new ArrayList<>();
            arrayList.add(QCircleFollowUpdateEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
            if (!(simpleBaseEvent instanceof QCircleFollowUpdateEvent)) {
                return;
            }
            QCircleFollowUpdateEvent qCircleFollowUpdateEvent = (QCircleFollowUpdateEvent) simpleBaseEvent;
            QLog.i("QCircleSpecialFollowMgr", 4, "onReceiveEvent: QCircleFollowUpdateEvent " + qCircleFollowUpdateEvent.mUserId + " " + qCircleFollowUpdateEvent.mFollowStatus);
            if (qCircleFollowUpdateEvent.mFollowStatus == 0) {
                this.f91517d.obtainMessage(1002, qCircleFollowUpdateEvent.mUserId).sendToTarget();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class e {

        /* renamed from: a, reason: collision with root package name */
        private static final QCircleSpecialFollowManager f91518a = new QCircleSpecialFollowManager();
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private final String f91519a;

        /* renamed from: b, reason: collision with root package name */
        private final long f91520b;

        /* renamed from: c, reason: collision with root package name */
        private final int f91521c;

        f(String str, long j3, int i3) {
            this.f91519a = str;
            this.f91520b = j3;
            this.f91521c = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public final List<FeedCloudMeta$StRelationInfo> f91522a;

        /* renamed from: b, reason: collision with root package name */
        public final f f91523b;

        /* renamed from: c, reason: collision with root package name */
        private final int f91524c;

        g(FeedCloudRead$StGetFollowListRsp feedCloudRead$StGetFollowListRsp, int i3) {
            this.f91522a = new LinkedList(feedCloudRead$StGetFollowListRsp.relationInfo.get());
            if (feedCloudRead$StGetFollowListRsp.hasNext.get() == 1) {
                String str = feedCloudRead$StGetFollowListRsp.attachInfo.get();
                long j3 = 0;
                for (FeedCloudCommon$Entry feedCloudCommon$Entry : feedCloudRead$StGetFollowListRsp.extInfo.mapInfo.get()) {
                    if (feedCloudCommon$Entry != null && "timestamp".equals(feedCloudCommon$Entry.key.get())) {
                        j3 = Long.parseLong(feedCloudCommon$Entry.value.get());
                    }
                }
                this.f91523b = new f(str, j3, i3);
            } else {
                this.f91523b = null;
            }
            this.f91524c = i3;
        }
    }

    QCircleSpecialFollowManager() {
        Handler handler = new Handler(Looper.getMainLooper(), this);
        this.f91502d = handler;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        this.f91503e = simpleEventBus;
        d dVar = new d(handler);
        this.f91504f = dVar;
        this.f91505h = new HashSet();
        this.f91507m = 0;
        this.C = false;
        simpleEventBus.registerReceiver(dVar);
    }

    public static QCircleSpecialFollowManager g() {
        return e.f91518a;
    }

    private void i(String str, boolean z16) {
        this.f91503e.dispatchEvent(new QCircleSpecialFollowUpdateEvent(str, z16));
        w wVar = new w(str);
        wVar.K();
        wVar.Y(z16 ? 1 : 0);
        w20.a.j().initOrUpdateGlobalState((w20.a) wVar, true);
    }

    private void j(g gVar, boolean z16) {
        this.f91503e.dispatchEvent(new QCircleSpecialFollowListLoadEvent(gVar, z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final int i3, final boolean z16) {
        this.f91502d.post(new Runnable() { // from class: com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager.2
            @Override // java.lang.Runnable
            public void run() {
                int i16;
                if (z16) {
                    i16 = QCircleToast.f91646f;
                } else {
                    i16 = QCircleToast.f91645e;
                }
                QCircleToast.l(i16, com.tencent.biz.qqcircle.utils.h.a(i3), 0, true, false);
            }
        });
    }

    public void f(FeedCloudMeta$StUser feedCloudMeta$StUser, boolean z16, Context context) {
        String str = feedCloudMeta$StUser.f398463id.get();
        QLog.d("QCircleSpecialFollowMgr", 4, "doSpecialFollow: " + str + " " + z16);
        if (TextUtils.isEmpty(str)) {
            k(R.string.f195404ei, false);
            return;
        }
        VSNetworkHelper.getInstance().sendRequest(new QCircleDoFollowRequest(feedCloudMeta$StUser, z16 ? 1 : 0, null, true, QCirclePluginUtil.getQCircleInitBean(context)), new a(z16, str));
    }

    public void h() {
        f fVar = this.f91506i;
        if (fVar == null) {
            QLog.w("QCircleSpecialFollowMgr", 1, "loadMoreSpecialFollowList: wrong");
            l();
        } else {
            VSNetworkHelper.getInstance().sendRequest(new QCircleGetFollowListRequest(fVar.f91519a, fVar.f91520b, true), new c(fVar));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                String str = (String) message.obj;
                QLog.d("QCircleSpecialFollowMgr", 1, "handleMessage: follow " + str);
                this.f91505h.add(str);
                i(str, true);
                return true;
            case 1002:
                String str2 = (String) message.obj;
                QLog.d("QCircleSpecialFollowMgr", 1, "handleMessage: cancel " + str2);
                this.f91505h.remove(str2);
                i(str2, false);
                if (this.f91505h.size() < 99 && this.f91506i != null) {
                    h();
                }
                return true;
            case 1003:
                this.f91505h.clear();
                g gVar = (g) message.obj;
                QLog.d("QCircleSpecialFollowMgr", 1, "handleMessage: update " + gVar.f91524c + " " + gVar.f91522a.size());
                Iterator<FeedCloudMeta$StRelationInfo> it = gVar.f91522a.iterator();
                while (it.hasNext()) {
                    this.f91505h.add(it.next().f398459id.get());
                }
                this.f91506i = gVar.f91523b;
                j(gVar, true);
                return true;
            case 1004:
                g gVar2 = (g) message.obj;
                QLog.d("QCircleSpecialFollowMgr", 1, "handleMessage: more " + gVar2.f91524c + " " + gVar2.f91522a.size());
                f fVar = this.f91506i;
                if (fVar != null && fVar.f91521c == gVar2.f91524c) {
                    Iterator<FeedCloudMeta$StRelationInfo> it5 = gVar2.f91522a.iterator();
                    while (it5.hasNext()) {
                        this.f91505h.add(it5.next().f398459id.get());
                    }
                    this.f91506i = gVar2.f91523b;
                    j(gVar2, false);
                }
                return true;
            case 1005:
                j(null, true);
                return true;
            default:
                return false;
        }
    }

    public void l() {
        synchronized (this) {
            if (this.C) {
                return;
            }
            this.C = true;
            int i3 = this.f91507m + 1;
            this.f91507m = i3;
            QLog.d("QCircleSpecialFollowMgr", 4, "updateSpecialFollowList: " + i3);
            VSNetworkHelper.getInstance().sendRequest(new QCircleGetFollowListRequest(null, 0L, true), new b(i3));
        }
    }
}
