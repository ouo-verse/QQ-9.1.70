package com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFeedDetailRspInfo;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.beans.QFSPublishTempInfo;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QFSFullScreenSelectedFeedEvent;
import com.tencent.biz.qqcircle.events.QFSUpdateFeedListEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSHandleFirstTaskPublishedEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSReplaceFeedSourceEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSRerankFinishEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedVideoErrorEvent;
import com.tencent.biz.qqcircle.immersive.repository.foldertab.QFSFeedRspProcessUtils;
import com.tencent.biz.qqcircle.immersive.repository.foldertab.m;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.utils.y;
import com.tencent.biz.qqcircle.requests.QFSGetFeedDetailRequest;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.IQCircleColdBootServiceV2;
import com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask;
import com.tencent.mobileqq.qcircle.api.event.QCircleFeedOptEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSSmallInsertFeedEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSSmallRefreshSelectedEvent;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.engineer.test.api.RFWTestMock;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.helpers.QCircleSilenceInsertHelper;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReporterAgent;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$RecomNeedInfo;
import feedcloud.FeedCloudCommon$RecomReed;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedDetailRsp;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import p40.u;
import qqcircle.QQCircleCounter$RedPointInfo;
import qqcircle.QQCircleDitto$StPicTextBanner;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSTabFeedViewModel extends t30.a implements IQCircleReportSessionOperation, IDataDisplaySurface<e30.b>, SimpleEventReceiver {
    public static HashMap<String, QFSPublishTempInfo> Y = new HashMap<>();
    protected QCircleTabInfo D;
    private com.tencent.biz.qqcircle.immersive.repository.foldertab.m E;
    private com.tencent.biz.qqcircle.immersive.repository.foldertab.l F;
    private c G;
    private final MutableLiveData<c> H;
    private final MutableLiveData<FeedCloudMeta$StFeed> I;
    private final MutableLiveData<String> J;
    private final AtomicBoolean K;
    private final MutableLiveData<Long> L;
    private final MutableLiveData<UIStateData<QCircleFeedDetailRspInfo>> M;
    private com.tencent.biz.qqcircle.widgets.a N;
    private final List<FeedCloudCommon$RecomReed> P;

    @Nullable
    private r50.b Q;
    private r50.a R;
    private int S;
    private Runnable T;
    private Runnable U;
    private Runnable V;
    private com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.b W;
    private com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.a X;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements Observer<c> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(c cVar) {
            QFSTabFeedViewModel.this.p3(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends com.tencent.biz.qqcircle.widgets.a {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onTaskStateChanged(@NotNull TaskInfo taskInfo) {
            if (!r.q0(QFSTabFeedViewModel.this.D.getType())) {
                return;
            }
            if (com.tencent.biz.qqcircle.immersive.part.publishprogress.k.f88273a.d(taskInfo)) {
                QLog.i("FeedLine_QFSTabFeedViewModel", 1, "Do nothing, wait publish event.");
            } else if (taskInfo.isSuccess()) {
                QFSTabFeedViewModel.this.y2(taskInfo);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: h, reason: collision with root package name */
        public int f86649h;

        /* renamed from: a, reason: collision with root package name */
        public final List<e30.b> f86642a = Collections.synchronizedList(new ArrayList());

        /* renamed from: b, reason: collision with root package name */
        public String f86643b = null;

        /* renamed from: c, reason: collision with root package name */
        public String f86644c = null;

        /* renamed from: d, reason: collision with root package name */
        public boolean f86645d = false;

        /* renamed from: e, reason: collision with root package name */
        public FeedCloudCommon$StCommonExt f86646e = null;

        /* renamed from: f, reason: collision with root package name */
        public QQCircleDitto$StPicTextBanner f86647f = null;

        /* renamed from: g, reason: collision with root package name */
        public boolean f86648g = false;

        /* renamed from: i, reason: collision with root package name */
        public boolean f86650i = false;

        /* renamed from: j, reason: collision with root package name */
        public long f86651j = 0;

        public List<e30.b> a() {
            return this.f86642a;
        }

        public boolean b() {
            return this.f86645d;
        }

        public List<e30.b> c() {
            ArrayList arrayList;
            synchronized (this.f86642a) {
                arrayList = new ArrayList(this.f86642a);
            }
            return arrayList;
        }
    }

    public QFSTabFeedViewModel() {
        MutableLiveData<c> mutableLiveData = new MutableLiveData<>();
        this.H = mutableLiveData;
        this.I = new MutableLiveData<>(null);
        this.J = new MutableLiveData<>(null);
        this.K = new AtomicBoolean(false);
        this.L = new MutableLiveData<>(null);
        this.M = new MutableLiveData<>(null);
        this.P = new ArrayList();
        this.S = -1;
        this.W = new com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.b();
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "QFSTabFeedViewModel create new instance;" + this);
        SimpleEventBus.getInstance().registerReceiver(this);
        mutableLiveData.setValue(new c());
        mutableLiveData.observeForever(new a());
        I2();
    }

    private void A2(QFSReplaceFeedSourceEvent qFSReplaceFeedSourceEvent) {
        List<e30.b> a16;
        QCircleTabInfo qCircleTabInfo = this.D;
        if (qCircleTabInfo != null && qCircleTabInfo.getSource() == 10) {
            c value = this.H.getValue();
            if (value == null) {
                a16 = null;
            } else {
                a16 = value.a();
            }
            if (a16 != null && !a16.isEmpty()) {
                List<e30.b> originFeedSource = qFSReplaceFeedSourceEvent.getOriginFeedSource();
                List<e30.b> replaceFeedSource = qFSReplaceFeedSourceEvent.getReplaceFeedSource();
                if (originFeedSource != null && !originFeedSource.isEmpty()) {
                    int size = originFeedSource.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        e30.b bVar = originFeedSource.get(i3);
                        e30.b bVar2 = replaceFeedSource.get(i3);
                        int d16 = bj.d(a16, bj.g(bVar));
                        if (d16 <= -1) {
                            return;
                        }
                        try {
                            RFWLog.d("QASP-FeedLine_QFSTabFeedViewModel", RFWLog.USR, "[handleReplaceFeedSource] blockData: " + bj.g(bVar) + " | replaceData: " + bj.g(bVar2) + " | isPreload: " + bVar2.j() + " | mCurrentFeedPos: " + this.S + " | replacePosition: " + d16 + " | originDesc: " + bj.e(bVar) + " | replaceDesc: " + bj.e(bVar2));
                            o3(a16, d16, bVar2);
                        } catch (Throwable th5) {
                            RFWLog.e("FeedLine_QFSTabFeedViewModel", RFWLog.USR, "[handleReplaceFeedSource] ex: ", th5);
                        }
                    }
                    return;
                }
                QLog.d("QASP-FeedLine_QFSTabFeedViewModel", 1, "[handleReplaceFeedSource] origin source should not be null.");
                return;
            }
            QLog.d("QASP-FeedLine_QFSTabFeedViewModel", 1, "[handleReplaceFeedSource] source should not be null.");
        }
    }

    private void B2(@NonNull ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        com.tencent.biz.qqcircle.immersive.repository.foldertab.l lVar;
        if (!m2() || !aSEngineTabStatusEvent.getBusinessKey().equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE) || (lVar = this.F) == null) {
            return;
        }
        if (aSEngineTabStatusEvent.isSelected()) {
            lVar.w();
        } else {
            lVar.x();
        }
    }

    private void C2(@NonNull QFSSmallInsertFeedEvent qFSSmallInsertFeedEvent) {
        List<e30.b> a16;
        int i3;
        QCircleTabInfo qCircleTabInfo = this.D;
        if (qCircleTabInfo != null && qCircleTabInfo.getSource() == 10) {
            c value = this.H.getValue();
            if (value == null) {
                a16 = null;
            } else {
                a16 = value.a();
            }
            if (a16 != null && !a16.isEmpty()) {
                FeedCloudMeta$StFeed currentFeed = qFSSmallInsertFeedEvent.getCurrentFeed();
                String g16 = bj.g(currentFeed);
                if (!TextUtils.isEmpty(g16) && g16.startsWith("share_fake_")) {
                    g16 = g16.replace("share_fake_", "");
                    currentFeed.f398449id.set(g16);
                }
                int d16 = bj.d(a16, g16);
                e30.b bVar = new e30.b(currentFeed);
                if (d16 == -1) {
                    if (uq3.o.q()) {
                        D2(a16, currentFeed);
                        QLog.d("QFP-FeedLine_QFSTabFeedViewModel", 1, "INSERT-[handlerSmallInsertFeedEvent] by replace:" + value.hashCode());
                        return;
                    }
                    int i16 = this.S + 1;
                    M2(a16, bVar, i16);
                    QLog.d("QFP-FeedLine_QFSTabFeedViewModel", 1, "INSERT-[handlerSmallInsertFeedEvent] feedId: " + g16 + " | findCurrentFeedForPosition: " + d16 + " | insertPos: " + i16);
                    this.S = i16;
                    return;
                }
                a16.remove(d16);
                int i17 = this.S;
                if (d16 >= i17) {
                    i3 = i17 + 1;
                } else {
                    i3 = i17 - 1;
                }
                int max = Math.max(i3, 0);
                M2(a16, bVar, max);
                QLog.d("QFP-FeedLine_QFSTabFeedViewModel", 1, "INSERT-[handlerSmallInsertFeedEvent] feedId: " + g16 + " | findCurrentFeedForPosition: " + d16 + " | mCurrentFeedPos: " + this.S + " | insert pos: " + max);
                this.S = max;
                return;
            }
            QLog.d("QFP-FeedLine_QFSTabFeedViewModel", 1, "INSERT-[handlerSmallInsertFeedEvent] sources is empty, flow end.");
        }
    }

    private void D2(List<e30.b> list, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (list != null && feedCloudMeta$StFeed != null) {
            try {
                e30.b bVar = list.get(this.S);
                if (bVar == null) {
                    return;
                }
                FeedCloudMeta$StFeed g16 = bVar.g();
                bVar.m(new e30.b(feedCloudMeta$StFeed).p());
                UIStateData<List<e30.b>> pos = UIStateData.obtainDelete().setDataList(list).setPos(this.S);
                pos.setState(-1000);
                d3(pos);
                QLog.d("QFP-FeedLine_QFSTabFeedViewModel", 1, "INSERT-[handlerSmallInsertFeedEventReplace]  | currentPio:" + this.S + "| feedId:" + feedCloudMeta$StFeed.f398449id.get() + "| source hash code" + list.hashCode() + "| replaceID:" + bVar.e().f398449id.get());
                int max = Math.max(this.S, 0);
                c value = this.H.getValue();
                if (value == null) {
                    QLog.e("FeedLine_QFSTabFeedViewModel", 1, "VFS-[handlerSmallInsertFeedEventReplace] currentSnapshot == null, end flow.");
                    return;
                }
                if (max > list.size()) {
                    QLog.e("FeedLine_QFSTabFeedViewModel", 1, "VFS-[handlerSmallInsertFeedEventReplace] current position is illegality, end flow.");
                    return;
                }
                list.add(max, new e30.b(g16).p());
                e3(value);
                UIStateData<List<e30.b>> finish = UIStateData.obtainDelete().setDataList(list).setPos(this.S + 1).setFinish(value.b());
                finish.setState(-1002);
                d3(finish);
                this.S++;
                QLog.d("QFP-FeedLine_QFSTabFeedViewModel", 1, "INSERT-[handlerSmallInsertFeedEventReplace]  | last currentPio:" + this.S);
            } catch (Exception e16) {
                QLog.d("QFP-FeedLine_QFSTabFeedViewModel", 1, e16, new Object[0]);
            }
        }
    }

    private void E2(QFSSmallRefreshSelectedEvent qFSSmallRefreshSelectedEvent) {
        List<e30.b> a16;
        QCircleTabInfo qCircleTabInfo = this.D;
        if (qCircleTabInfo != null && qCircleTabInfo.getSource() == 10) {
            c value = this.H.getValue();
            if (value == null) {
                a16 = null;
            } else {
                a16 = value.a();
            }
            if (a16 != null && !a16.isEmpty()) {
                String g16 = bj.g(qFSSmallRefreshSelectedEvent.getCurrentFeed());
                int d16 = bj.d(a16, g16);
                if (d16 == -1) {
                    QLog.d("QFP-FeedLine_QFSTabFeedViewModel", 1, "INSERT-[handlerSmallRefreshSelectedEvent] current feed not exists sources, flow end,feedId: " + g16);
                    return;
                }
                UIStateData<List<e30.b>> obtainDelete = UIStateData.obtainDelete();
                obtainDelete.setDataList(a16);
                obtainDelete.setPos(d16);
                obtainDelete.setState(-1001);
                d3(obtainDelete);
                return;
            }
            QLog.d("QFP-FeedLine_QFSTabFeedViewModel", 1, "INSERT-[handlerSmallRefreshSelectedEvent] sources is empty, flow end.");
        }
    }

    private void E3(List<e30.b> list) {
        if (list != null && !list.isEmpty()) {
            e30.b bVar = list.get(0);
            if (y.e(bVar)) {
                FeedCloudMeta$StFeed g16 = bVar.g();
                if (g16 != null) {
                    RFWLog.d("FeedLine_QFSTabFeedViewModel", RFWLog.USR, "tryRemoveFirstAdFeed ad feed:" + g16.f398449id.get());
                }
                list.remove(bVar);
            }
        }
    }

    private void F3() {
        com.tencent.biz.qqcircle.widgets.a aVar = this.N;
        if (aVar != null) {
            QCirclePublishCallbackHelper.f93064a.v(aVar);
        }
    }

    private void G2(QFSFeedVideoErrorEvent qFSFeedVideoErrorEvent) {
        if (com.tencent.biz.qqcircle.richframework.preload.coldbootV2.h.c()) {
            k30.h.f().k(this, qFSFeedVideoErrorEvent);
        } else {
            k30.n.l(this, qFSFeedVideoErrorEvent);
        }
    }

    private void I2() {
        this.M.observeForever(new Observer() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSTabFeedViewModel.this.O2((UIStateData) obj);
            }
        });
    }

    private void L2(@NonNull List<e30.b> list, @NonNull int i3, @NonNull e30.b bVar) {
        int d16 = bj.d(list, bj.g(bVar));
        boolean z16 = true;
        int i16 = i3 + 1;
        if (d16 != -1) {
            z16 = false;
        }
        if (z16) {
            M2(list, bVar, i16);
        } else {
            W2((e30.b) RFSafeListUtils.get(list, d16));
        }
    }

    private void M2(@NonNull List<e30.b> list, @NonNull e30.b bVar, int i3) {
        c value;
        MutableLiveData<c> mutableLiveData = this.H;
        if (mutableLiveData == null) {
            value = null;
        } else {
            value = mutableLiveData.getValue();
        }
        if (value == null) {
            QLog.e("FeedLine_QFSTabFeedViewModel", 1, "VFS-[insertToDataSource] currentSnapshot == null, end flow.");
            return;
        }
        if (i3 > 0 && i3 <= list.size()) {
            list.add(i3, bVar);
            f2(list, bVar, i3 + 1);
            e3(value);
            UIStateData<List<e30.b>> finish = UIStateData.obtainDelete().setDataList(list).setPos(i3).setFinish(value.b());
            finish.setState(8);
            d3(finish);
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "INSERT-VFS-[insertAndSelectedFeed] feedId: " + bj.g(bVar) + " | adapterFeedId: " + bj.g(list.get(i3)) + " | insertPosition: " + i3 + " | content: " + bj.e(bVar) + " | sourceSize = " + list.size());
            return;
        }
        QLog.e("FeedLine_QFSTabFeedViewModel", 1, "VFS-[insertToDataSource] current position is illegality, end flow.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O2(UIStateData uIStateData) {
        QCircleFeedDetailRspInfo qCircleFeedDetailRspInfo;
        if (uIStateData == null || uIStateData.getState() != 3 || (qCircleFeedDetailRspInfo = (QCircleFeedDetailRspInfo) uIStateData.getData()) == null) {
            return;
        }
        List<e30.b> list = qCircleFeedDetailRspInfo.feeds;
        c cVar = this.G;
        if (cVar == null) {
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "[initSimpleFeedLogic] backUpRequestSnapshot is null");
            return;
        }
        List<e30.b> list2 = cVar.f86642a;
        if (list == null) {
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "[initSimpleFeedLogic] respFeeds is null");
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            e30.b bVar = list.get(i3);
            if (bVar != null) {
                int i16 = 0;
                while (true) {
                    if (i16 >= list2.size()) {
                        break;
                    }
                    e30.b bVar2 = list2.get(i16);
                    if (bVar2 != null && TextUtils.equals(bVar2.g().f398449id.get(), bVar.g().f398449id.get())) {
                        bVar2.m(bVar);
                        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "feed detail load succeed;feedId:" + bVar2.g().f398449id.get() + ", pos:" + i16);
                        break;
                    }
                    i16++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P2(e30.b bVar) {
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "VFS-[notifySelectedToFeed] feedId: " + bj.g(bVar) + " | content: " + bj.e(bVar));
        SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenSelectedFeedEvent(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q2(TaskInfo taskInfo, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedDetailRsp feedCloudRead$StGetFeedDetailRsp) {
        int i3;
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "onPublishSuccess, fetch real feed, isSuccess:" + z16 + ", retCode code: " + j3);
        if (z16 && j3 == 0 && feedCloudRead$StGetFeedDetailRsp.feed != null) {
            if (taskInfo.isVideoComment()) {
                if (QFSCommentHelper.L().e0(taskInfo.getTaskId() + "")) {
                    return;
                }
            }
            com.tencent.biz.qqcircle.manager.d.b().g(true, feedCloudRead$StGetFeedDetailRsp.feed.f398449id.get());
            r50.b bVar = this.Q;
            if (bVar != null) {
                i3 = bVar.d() + 1;
            } else {
                i3 = 0;
            }
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "onPublishSuccess, insertPos: " + i3);
            a3(feedCloudRead$StGetFeedDetailRsp, taskInfo, i3);
            if (r.m0(taskInfo.getTransParams())) {
                QLog.i("FeedLine_QFSTabFeedViewModel", 1, "onPublishSuccess, HitAIGC");
                return;
            }
            QCircleFeedOptEvent qCircleFeedOptEvent = new QCircleFeedOptEvent(1);
            qCircleFeedOptEvent.setFeedId(feedCloudRead$StGetFeedDetailRsp.feed.f398449id.get());
            qCircleFeedOptEvent.setInsertPosition(i3);
            qCircleFeedOptEvent.setFeed(feedCloudRead$StGetFeedDetailRsp.feed);
            SimpleEventBus.getInstance().dispatchEvent(qCircleFeedOptEvent);
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "dispatchEvent, QCircleFeedOptEvent");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R2(byte[] bArr) {
        try {
            FeedCloudCommon$RecomNeedInfo feedCloudCommon$RecomNeedInfo = new FeedCloudCommon$RecomNeedInfo();
            feedCloudCommon$RecomNeedInfo.mergeFrom(bArr);
            this.P.addAll(feedCloudCommon$RecomNeedInfo.unableExpoFeeds.get());
            QLog.d("QFSTabRequestSender", 1, "recoverUnexposedFeedsIfNeed success,size: ", Integer.valueOf(this.P.size()));
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSTabRequestSender", 1, "recoverUnexposedFeedsIfNeed error: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S2(long j3) {
        if (this.L.getValue() == null) {
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "setPreloadFeedReceiveTime preloadRspTime:" + j3);
            this.L.setValue(Long.valueOf(j3));
            return;
        }
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "setPreloadFeedReceiveTime preloadRspTime repeat:" + j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T2(int i3) {
        IPreloadTask task = ((IQCircleColdBootServiceV2) QRoute.api(IQCircleColdBootServiceV2.class)).getTask(i3);
        if (task != null) {
            task.clearAllCacheInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U2() {
        c cVar = this.G;
        if (cVar == null) {
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "switchToBackUpFeedList but backUpRequestSnapshot null");
            return;
        }
        this.G = null;
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "switchToBackUpFeedList");
        e3(cVar);
        d3(UIStateData.obtainSuccess(false).setData(false, cVar.a()).setPos(cVar.f86649h).setFinish(cVar.b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V2(int i3, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, List list) {
        c value = this.H.getValue();
        if (value != null && !value.f86648g) {
            value.f86649h = i3;
            this.G = value;
        }
        c cVar = new c();
        cVar.f86648g = true;
        QFSFeedRspProcessUtils.f(cVar, feedCloudRead$StGetFeedListRsp);
        QFSFeedRspProcessUtils.h(cVar, feedCloudRead$StGetFeedListRsp);
        QFSFeedRspProcessUtils.j(cVar, feedCloudRead$StGetFeedListRsp);
        QFSFeedRspProcessUtils.m(cVar, feedCloudRead$StGetFeedListRsp);
        QFSFeedRspProcessUtils.g(cVar, list, false);
        List<e30.b> c16 = QFSFeedRspProcessUtils.c(list, false);
        cVar.f86642a.clear();
        cVar.f86642a.addAll(c16);
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "switchToRedPointScreen origin feedList:" + list.size() + "validFeedList size:" + c16.size());
        w20.a.j().initOrUpdateGlobalState((List) c16, true);
        e3(cVar);
        d3(UIStateData.obtainModify().setData(false, cVar.a()).setType(100).setFinish(cVar.b()));
    }

    private void W2(final e30.b bVar) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.l
            @Override // java.lang.Runnable
            public final void run() {
                QFSTabFeedViewModel.P2(e30.b.this);
            }
        });
    }

    private void a3(FeedCloudRead$StGetFeedDetailRsp feedCloudRead$StGetFeedDetailRsp, TaskInfo taskInfo, int i3) {
        String str;
        String feedId = taskInfo.getFeedId();
        c value = this.H.getValue();
        if (value == null) {
            QLog.w("FeedLine_QFSTabFeedViewModel", 1, "onFeedPublishSuccess, currentSnapshot is null ");
            return;
        }
        List<e30.b> a16 = value.a();
        if (a16 == null) {
            QLog.w("FeedLine_QFSTabFeedViewModel", 1, "onFeedPublishSuccess, curFeedList is null ");
            return;
        }
        int i16 = 0;
        if (uq3.c.l5()) {
            boolean isVideoTask = taskInfo.isVideoTask();
            if (taskInfo.getMediaInfos().size() > 0) {
                str = taskInfo.getMediaInfos().get(0).getMediaPath();
            } else {
                str = "";
            }
            String str2 = feedCloudRead$StGetFeedDetailRsp.feed.video.fileId.get();
            boolean isLocalHdr = QCirclePluginUtil.isLocalHdr(taskInfo);
            QLog.w("FeedLine_QFSTabFeedViewModel", 1, "onFeedPublishSuccess, playUrl: " + feedCloudRead$StGetFeedDetailRsp.feed.video.playUrl.get() + ", localMediaPath: " + str + ", videoTask: " + isVideoTask + " | fileId: " + str2 + "| isLocalHdr:" + isLocalHdr);
            if (isVideoTask && !TextUtils.isEmpty(str)) {
                Y.clear();
                QFSPublishTempInfo isHdr = new QFSPublishTempInfo().setLocalPath(str).setIsHdr(isLocalHdr);
                feedCloudRead$StGetFeedDetailRsp.feed.video.attachOption.isHdrVideo.set(isLocalHdr);
                Y.put(feedCloudRead$StGetFeedDetailRsp.feed.video.fileId.get(), isHdr);
            }
        }
        uc0.a.e(feedCloudRead$StGetFeedDetailRsp.feed);
        int o26 = o2(a16, feedId);
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "onFeedPublishSuccess, targetIndex: " + o26);
        if (i3 > a16.size()) {
            i3 = a16.size();
        }
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("clientPublishFeed");
        feedCloudCommon$Entry.value.set(String.valueOf(1));
        feedCloudRead$StGetFeedDetailRsp.feed.debugInfo.debugMap.add(feedCloudCommon$Entry);
        e30.b bVar = new e30.b(feedCloudRead$StGetFeedDetailRsp.feed);
        if (o26 == -1) {
            if (a16.isEmpty()) {
                QLog.d("FeedLine_QFSTabFeedViewModel", 1, "onFeedPublishSuccess, curFeedList isEmpty");
                a16.add(bVar);
            } else {
                a16.add(i3, bVar);
                i16 = i3;
            }
        } else {
            a16.set(o26, bVar);
            i16 = o26;
        }
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "onFeedPublishSuccess, actualInsertPos: " + i16);
        this.W.d(bVar);
        e3(value);
        d3(UIStateData.obtainInsert(i16).setDataList(value.a()).setFinish(value.b()));
    }

    private void b3(final TaskInfo taskInfo) {
        VSNetworkHelper.getInstance().sendRequest(new QFSGetFeedDetailRequest(taskInfo.getFeedId(), true), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.n
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSTabFeedViewModel.this.Q2(taskInfo, baseRequest, z16, j3, str, (FeedCloudRead$StGetFeedDetailRsp) obj);
            }
        });
    }

    private void f2(@NonNull List<e30.b> list, @NonNull e30.b bVar, int i3) {
        if (i3 > 0 && i3 < list.size()) {
            e30.b bVar2 = list.get(i3);
            if (bVar2 != null && bVar2.g() != null && bVar.g() != null) {
                int i16 = bVar.g().feedType.get();
                String str = bVar2.g().f398449id.get();
                int i17 = bVar2.g().feedType.get();
                if (i16 == 4 && i17 == 4) {
                    list.remove(bVar2);
                    QLog.d(getTAG(), 1, "VFS-[checkNextFeedNeedDelete] remove next feed success, feedId: ", str);
                    return;
                }
                return;
            }
            return;
        }
        QLog.e("FeedLine_QFSTabFeedViewModel", 1, "VFS-[checkNextFeedNeedDelete] next position is illegality, end flow.");
    }

    private void f3(c cVar) {
        c value;
        List<e30.b> a16;
        int size;
        MutableLiveData<c> mutableLiveData = this.H;
        List<e30.b> list = null;
        if (mutableLiveData == null) {
            value = null;
        } else {
            value = mutableLiveData.getValue();
        }
        if (value == null) {
            a16 = null;
        } else {
            a16 = value.a();
        }
        if (cVar != null) {
            list = cVar.a();
        }
        int i3 = 0;
        if (a16 == null) {
            size = 0;
        } else {
            size = a16.size();
        }
        if (list != null) {
            i3 = list.size();
        }
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "[postSnapshotInMain] preSize: " + size + " | size: " + i3);
    }

    private void h2(@NonNull ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        if (aSEngineTabStatusEvent.getBusinessKey().equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE) && !aSEngineTabStatusEvent.isSelected()) {
            k30.j.e(this);
        }
    }

    private void h3() {
        final byte[] d16;
        if (this.D.getSource() == 10 && (d16 = uq3.k.a().d("sp_key_all_push_Unexposed_feed_info", null)) != null && d16.length > 0) {
            uq3.k.a().k("sp_key_all_push_Unexposed_feed_info", null);
            RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.m
                @Override // java.lang.Runnable
                public final void run() {
                    QFSTabFeedViewModel.this.R2(d16);
                }
            });
        }
    }

    private void i2(UIStateData<List<e30.b>> uIStateData) {
        QCircleTabInfo qCircleTabInfo;
        List<e30.b> data;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_load_more_backup_all_push_page_9_0_90", true) || !z20.g.a() || uIStateData == null || (qCircleTabInfo = this.D) == null || qCircleTabInfo.getType() != 6 || (data = uIStateData.getData()) == null) {
            return;
        }
        if (data.size() == 1) {
            e30.b h16 = z20.f.k().h(z20.f.i(data));
            if (h16 != null) {
                QLog.d(getTAG(), 1, "[dealWithFeedBackUp] use backup feed:" + h16.g().f398449id.get());
                data.add(h16);
                return;
            }
            return;
        }
        if (uIStateData.getIsLoadMore() && z20.f.k().e(data, this.S)) {
            QLog.d(getTAG(), 1, "[dealWithFeedBackUp] have remove backup feed");
        }
    }

    private void j3() {
        if (this.N == null) {
            this.N = new b();
        }
        QCirclePublishCallbackHelper.f93064a.i(this.N, false);
    }

    private void k2(QCircleFeedEvent qCircleFeedEvent) {
        c value;
        String str = qCircleFeedEvent.mTargetId;
        if (!TextUtils.isEmpty(str) && (value = this.H.getValue()) != null && value.a().size() != 0) {
            Iterator<e30.b> it = value.a().iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                e30.b next = it.next();
                if (next != null && TextUtils.equals(str, next.g().f398449id.get())) {
                    it.remove();
                    z16 = true;
                }
            }
            if (z16) {
                e3(value);
                d3(UIStateData.obtainDelete().setDataList(value.a()).setFinish(value.b()));
            }
            QLog.d(getTAG(), 1, "deleteFeedById removeFeed result: ", Boolean.valueOf(z16), ",size = ", Integer.valueOf(value.a().size()));
        }
    }

    private void k3() {
        if (this.F == null && this.D.getSource() == 10) {
            if (wa0.c.f().g() == 2) {
                if (cc0.d.n()) {
                    QLog.d("FeedLine_QFSTabFeedViewModel", 1, "register tedgeRs rerank v2 hasInstance");
                    return;
                } else {
                    QLog.d("FeedLine_QFSTabFeedViewModel", 1, "register tedgeRs rerank v2");
                    this.F = new cc0.g(this);
                }
            }
            l3();
        }
    }

    private void l3() {
        com.tencent.biz.qqcircle.immersive.repository.foldertab.l lVar;
        if (this.R != null && (lVar = this.F) != null && lVar.j() == null) {
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "registerReRankScrollerIfNeed");
            this.F.t(this.R);
        }
    }

    private boolean m2() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_clear_rerank_memory_when_exit_qcircle", 1) == 1) {
            return true;
        }
        return false;
    }

    private void m3() {
        QCircleTabInfo qCircleTabInfo = this.D;
        if (qCircleTabInfo == null) {
            QLog.w("FeedLine_QFSTabFeedViewModel", 1, "registerServiceCallbackIfNeed, mTabInfo is null ");
            return;
        }
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "registerServiceCallbackIfNeed, tabType: " + qCircleTabInfo.getType());
        if (this.D.getType() == 9 || this.D.getType() == 1) {
            j3();
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "[registerPublishCallback] enableJumpFriendTabAfterPublish() = " + uq3.c.E());
        }
    }

    private boolean n2() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_release_rerank_instance", 1) == 1) {
            return true;
        }
        return false;
    }

    private int o2(List<e30.b> list, String str) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            FeedCloudMeta$StFeed g16 = list.get(i3).g();
            if (str.startsWith("qcircle_fakeid_") && !g16.f398449id.get().startsWith("qcircle_fakeid_")) {
                QLog.d("FeedLine_QFSTabFeedViewModel", 1, "findTargetFeedFeedIndex, has none fakeFeeds");
                return -1;
            }
            if (g16.isRecomFd.get()) {
                if (str.equals(g16.recomForward.f398458id.get())) {
                    QLog.d("FeedLine_QFSTabFeedViewModel", 1, "findTargetFeedFeedIndex, find recom feed id: " + str);
                    return i3;
                }
            } else if (str.equals(g16.f398449id.get())) {
                QLog.d("FeedLine_QFSTabFeedViewModel", 1, "findTargetFeedFeedIndex, find real feed id: " + str);
                return i3;
            }
        }
        return -1;
    }

    private void o3(@NonNull List<e30.b> list, @NonNull int i3, @NonNull e30.b bVar) {
        int i16;
        if (i3 <= -1) {
            i16 = bj.b(list, bVar);
        } else {
            i16 = i3;
        }
        if (i16 > -1 && !list.isEmpty() && i3 < list.size()) {
            e30.b bVar2 = list.get(i16);
            if (bVar2 == null) {
                QLog.e("FeedLine_QFSTabFeedViewModel", 1, "INSERT-VFS-[replaceNewDataToFeedList] blockData == null.");
                return;
            }
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "INSERT-VFS-[replaceNewDataToFeedList] replacePosition: " + i16 + " | nextFeedId:" + bj.g(bVar));
            bVar2.m(bVar);
            UIStateData<List<e30.b>> pos = UIStateData.obtainDelete().setDataList(list).setPos(i16);
            pos.setState(-1000);
            d3(pos);
            return;
        }
        QLog.e("FeedLine_QFSTabFeedViewModel", 1, "INSERT-VFS-[replaceNewDataToFeedList] current param illegality, end flow,  | replacePosition: " + i16 + " | unselectedPosition: " + i3 + " | sourcesSize: " + list.size() + " | next feed id: " + bj.g(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RFWTestMock(id = "QFS_P0_FEED")
    public void p3(c cVar) {
        if (cVar != null) {
            updateSession(cVar.f86646e);
        }
    }

    private void t3(UIStateData<List<e30.b>> uIStateData) {
        List<e30.b> data = uIStateData.getData();
        if (data == null) {
            return;
        }
        for (e30.b bVar : data) {
            if (bVar != null) {
                bVar.o("FEED_REQ_FROM", Integer.valueOf(this.D.getSource()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void u3(UIStateData<List<e30.b>> uIStateData) {
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "[setFeedValue] mFeedRepository:" + this.E + ",this:" + this);
        MutableLiveData<c> mutableLiveData = this.H;
        List<e30.b> list = null;
        if (mutableLiveData != null && mutableLiveData.getValue() != null) {
            list = this.H.getValue().a();
        }
        v30.b.c(uIStateData, "tab_feed", list);
        i2(uIStateData);
        t3(uIStateData);
        this.W.e(uIStateData);
        j().setValue(uIStateData);
    }

    private void x2(QCircleFeedEvent qCircleFeedEvent) {
        QCircleTabInfo qCircleTabInfo;
        if (qCircleFeedEvent == null) {
            return;
        }
        int i3 = qCircleFeedEvent.mState;
        if (i3 == 3) {
            k2(qCircleFeedEvent);
            return;
        }
        if (i3 == 6) {
            l2(qCircleFeedEvent);
        } else if (i3 == 8 && (qCircleTabInfo = this.D) != null && qCircleTabInfo.getSource() == 10 && !TextUtils.isEmpty(qCircleFeedEvent.mTargetId)) {
            j2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y2(TaskInfo taskInfo) {
        QCircleTabInfo qCircleTabInfo = this.D;
        if (qCircleTabInfo != null && r.q0(qCircleTabInfo.getType())) {
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "handlePublishSuccess, taskInfo: " + taskInfo);
            b3(taskInfo);
            ka0.a.e("has_show_material_guide", true, WinkCommonUtil.getCurrentAccountLong());
            uq3.k.a().j("qfs_personal_has_show_new_user_bubble", true);
            return;
        }
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "[handlePublishSuccess] mTabInfo do not need register publish callback");
    }

    private void z2(QFSHandleFirstTaskPublishedEvent qFSHandleFirstTaskPublishedEvent) {
        TaskInfo taskInfo = qFSHandleFirstTaskPublishedEvent.getTaskInfo();
        if (taskInfo.isSuccess()) {
            y2(taskInfo);
        }
    }

    public void A3() {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.k
            @Override // java.lang.Runnable
            public final void run() {
                QFSTabFeedViewModel.this.U2();
            }
        });
    }

    public void C3() {
        FeedCloudMeta$StFeed k3 = bb0.b.i().k(true);
        if (k3 == null) {
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "switchToPushPreloadFeed waitConsumePushFeed is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(k3);
        List<e30.b> c16 = QFSFeedRspProcessUtils.c(arrayList, false);
        this.G = null;
        c cVar = new c();
        cVar.f86648g = false;
        cVar.f86642a.clear();
        cVar.f86642a.addAll(c16);
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "switchToPushPreloadFeed origin feedList:" + arrayList.size() + "validFeedList size:" + c16.size());
        e3(cVar);
        d3(UIStateData.obtainModify().setData(false, cVar.a()).setFinish(cVar.b()));
        new com.tencent.biz.qqcircle.immersive.repository.foldertab.j(this).k(c16);
    }

    public void D3(Context context, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, final int i3) {
        if (feedCloudRead$StGetFeedListRsp == null) {
            return;
        }
        QQCircleCounter$RedPointInfo e16 = com.tencent.biz.qqcircle.helpers.y.e(context);
        com.tencent.biz.qqcircle.helpers.y.g();
        if (!com.tencent.biz.qqcircle.helpers.y.q(e16)) {
            QLog.e("FeedLine_QFSTabFeedViewModel", 1, "switchToRedPointScreen but redPointNeedRefreshFeed return false");
            return;
        }
        if (com.tencent.biz.qqcircle.helpers.y.g().r()) {
            QLog.e("FeedLine_QFSTabFeedViewModel", 1, "[switchToRedPointScreen] current small window jump intercept refresh.");
            return;
        }
        final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(feedCloudRead$StGetFeedListRsp.vecFeed.get());
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        String str = ((FeedCloudMeta$StFeed) copyOnWriteArrayList.get(0)).f398449id.get();
        String redPointFeedId = EeveeRedpointUtil.getRedPointFeedId(e16);
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "switchToRedPointScreen feedId:" + str + ",feedIdFromRedPoint:" + redPointFeedId);
        if (!TextUtils.equals(redPointFeedId, str)) {
            return;
        }
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.j
            @Override // java.lang.Runnable
            public final void run() {
                QFSTabFeedViewModel.this.V2(i3, feedCloudRead$StGetFeedListRsp, copyOnWriteArrayList);
            }
        });
    }

    protected void F2(QFSUpdateFeedListEvent qFSUpdateFeedListEvent) {
        c value;
        QCircleTabInfo qCircleTabInfo = this.D;
        if (qCircleTabInfo != null && qCircleTabInfo.getSource() == 10) {
            MutableLiveData<c> mutableLiveData = this.H;
            List<e30.b> list = null;
            if (mutableLiveData == null) {
                value = null;
            } else {
                value = mutableLiveData.getValue();
            }
            if (value != null) {
                list = value.a();
            }
            if (list != null && !list.isEmpty()) {
                int d16 = bj.d(list, qFSUpdateFeedListEvent.getPreFeedId());
                QLog.d("FeedLine_QFSTabFeedViewModel", 1, "VFS-[handlerUpdateFeedListEvent] preFeedId:" + qFSUpdateFeedListEvent.getPreFeedId() + " | unselectedPosition: " + d16);
                if (qFSUpdateFeedListEvent.getType() == 1) {
                    L2(list, d16, qFSUpdateFeedListEvent.getNextBlockData());
                    return;
                } else {
                    if (qFSUpdateFeedListEvent.getType() == 2) {
                        o3(list, d16, qFSUpdateFeedListEvent.getNextBlockData());
                        return;
                    }
                    return;
                }
            }
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "VFS-[handlerUpdateFeedListEvent] sources is empty, flow end.");
        }
    }

    public void G3(long j3) {
        QCircleTabInfo qCircleTabInfo = this.D;
        if (qCircleTabInfo == null) {
            QLog.e("FeedLine_QFSTabFeedViewModel", 1, "updateLastGetListRspTime but mTabInfo is null");
            return;
        }
        QLog.e("FeedLine_QFSTabFeedViewModel", 1, "updateLastGetListRspTime mTabInfo info:" + qCircleTabInfo.mTab);
        if (qCircleTabInfo.getSource() == 10) {
            QCircleSilenceInsertHelper.getInstance().refreshGetListTime(j3);
        }
    }

    public void H2(String str) {
        if (QFSLayerTabPart.P.equals(str)) {
            this.f92839i = QCircleReporterAgent.obtain(1);
        } else if (QFSLayerTabPart.Q.equals(str)) {
            this.f92839i = QCircleReporterAgent.obtain(3);
        } else if (QFSLayerTabPart.R.equals(str)) {
            this.f92839i = QCircleReporterAgent.obtain(91);
        }
    }

    @Override // t30.b
    public int J() {
        return this.S;
    }

    public void J2(@NonNull com.tencent.biz.qqcircle.immersive.adapter.m mVar) {
        r50.a aVar = new r50.a(mVar);
        mVar.registerScroller(aVar);
        this.R = aVar;
        com.tencent.biz.qqcircle.immersive.repository.foldertab.m mVar2 = this.E;
        if (mVar2 != null) {
            mVar2.t(aVar);
        }
        l3();
    }

    public void K2(com.tencent.biz.qqcircle.immersive.adapter.m mVar) {
        r50.b bVar = new r50.b();
        this.Q = bVar;
        mVar.registerScroller(bVar);
    }

    public boolean N2() {
        c value = this.H.getValue();
        if (value == null) {
            return false;
        }
        List<e30.b> a16 = value.a();
        if (a16 != null && !a16.isEmpty()) {
            if (!value.f86648g) {
                QLog.d("FeedLine_QFSTabFeedViewModel", 1, "isRedPointOnScreen return false");
                return false;
            }
            String str = a16.get(0).g().f398449id.get();
            String d16 = com.tencent.biz.qqcircle.helpers.y.g().d();
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "isRedPointOnScreen redPointFeedId:" + d16 + ",screenFeedId:" + str);
            if (!TextUtils.equals(str, d16)) {
                return false;
            }
            return true;
        }
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "isRedPointOnScreen currentSnapShot feeds is empty");
        return false;
    }

    @Override // t30.a, t30.b
    public boolean R() {
        return true;
    }

    @Override // t30.a, t30.b
    public boolean R0() {
        return true;
    }

    @Override // t30.a, t30.b
    public void U0(@NonNull List<e30.b> list) {
        c value = this.H.getValue();
        if (value != null) {
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "updateFeedList feedList size:" + list.size());
            value.f86642a.clear();
            value.f86642a.addAll(list);
            e3(value);
            d3(UIStateData.obtainModify().setData(false, list).setFinish(value.b()));
        }
    }

    @RFWTestMock(id = "QFS_P0_FEED")
    public void Y2(int i3, e30.b bVar) {
        this.S = i3;
        QCircleTabInfo qCircleTabInfo = this.D;
        if (qCircleTabInfo == null) {
            QLog.e("FeedLine_QFSTabFeedViewModel", 1, "onCurrentFeedChange but mTabInfo is null");
            return;
        }
        if (qCircleTabInfo.getSource() == 10) {
            QCircleSilenceInsertHelper.getInstance().setCurrentFeedPos(i3);
        }
        if (bVar != null) {
            this.I.setValue(bVar.g());
            u.H().N0(qCircleTabInfo.getSource(), bj.g(bVar.g()));
        }
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "[onCurrentFeedChange] pos: " + i3 + " | feed id: " + bj.g(bVar));
    }

    @Override // t30.a, t30.b
    public boolean Z() {
        return true;
    }

    public synchronized void c3(final UIStateData<QCircleFeedDetailRspInfo> uIStateData) {
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "postDetailFeedList");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.M.setValue(uIStateData);
        } else {
            Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel.3
                @Override // java.lang.Runnable
                public void run() {
                    QFSTabFeedViewModel.this.M.setValue(uIStateData);
                }
            };
            y.m(this.U, runnable);
            this.U = runnable;
        }
    }

    @RFWTestMock(id = "QFS_P0_FEED")
    public synchronized void d3(final UIStateData<List<e30.b>> uIStateData) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            u3(uIStateData);
        } else {
            Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel.4
                @Override // java.lang.Runnable
                public void run() {
                    QFSTabFeedViewModel.this.u3(uIStateData);
                }
            };
            y.m(this.V, runnable);
            this.V = runnable;
        }
    }

    public void e2(FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            qCircleReporterAgent.addExtraSessionEntry(feedCloudCommon$BytesEntry);
        }
    }

    public synchronized void e3(@NonNull final c cVar) {
        f3(cVar);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.H.setValue(cVar);
        } else {
            Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel.5
                @Override // java.lang.Runnable
                public void run() {
                    QFSTabFeedViewModel.this.H.setValue(cVar);
                }
            };
            y.m(this.T, runnable);
            this.T = runnable;
        }
    }

    public void g2() {
        com.tencent.biz.qqcircle.immersive.repository.foldertab.m mVar = this.E;
        if (mVar != null) {
            mVar.E();
        }
    }

    public void g3(List<e30.b> list) {
        com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.a aVar = this.X;
        if (aVar != null) {
            aVar.d(list);
        }
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        return this.f435354m;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        if (w2() != null && w2().mTab != null) {
            return w2().mTab.tabType.get();
        }
        return 0;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleFeedEvent.class);
        arrayList.add(QFSRerankFinishEvent.class);
        arrayList.add(QFSUpdateFeedListEvent.class);
        arrayList.add(ASEngineTabStatusEvent.class);
        arrayList.add(QFSFeedVideoErrorEvent.class);
        arrayList.add(QFSSmallInsertFeedEvent.class);
        arrayList.add(QFSHandleFirstTaskPublishedEvent.class);
        arrayList.add(QFSReplaceFeedSourceEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "FeedLine_QFSTabFeedViewModel";
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public FeedCloudCommon$StCommonExt getSession(boolean z16) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            return qCircleReporterAgent.getSessionCommonExt(z16);
        }
        return new FeedCloudCommon$StCommonExt();
    }

    public boolean i3(int i3) {
        c cVar;
        int i16;
        com.tencent.biz.qqcircle.immersive.repository.foldertab.m mVar = this.E;
        if (mVar == null || !ac0.b.a(mVar.G())) {
            return false;
        }
        e30.b h16 = mVar.h();
        if (h16 == null) {
            QLog.e(getTAG(), 1, "refreshByLocalFeed currentExposedFeed is null");
            return false;
        }
        List<e30.b> i17 = mVar.i();
        E3(i17);
        if (i17 != null && !i17.isEmpty()) {
            if (mVar.d().getValue() != null) {
                cVar = mVar.d().getValue();
            } else {
                cVar = new c();
            }
            cVar.f86642a.clear();
            if (i3 == 2) {
                cVar.f86642a.add(h16);
                i16 = 1;
            } else {
                i16 = 0;
            }
            cVar.f86642a.addAll(i17);
            mVar.c(cVar);
            mVar.a(UIStateData.obtainModify().setLoadMore(false).setType(104).setPos(i16).setDataList(cVar.a()).setFinish(false));
            return true;
        }
        QLog.e(getTAG(), 1, "refreshByLocalFeed currentUnexposedFeeds is null");
        return false;
    }

    public MutableLiveData<UIStateData<List<e30.b>>> j() {
        return this.f435354m;
    }

    protected void j2() {
        c value = this.H.getValue();
        if (value != null && value.a().size() != 0) {
            Iterator<e30.b> it = value.a().iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                e30.b next = it.next();
                if (next != null && next.g().feedType.get() == 4) {
                    it.remove();
                    z16 = true;
                }
            }
            if (z16) {
                e3(value);
                d3(UIStateData.obtainDelete().setDataList(value.a()).setFinish(value.b()));
            }
            QLog.d(getTAG(), 1, "deleteAdFeed removeFeed end result: ", Boolean.valueOf(z16), ",size = ", Integer.valueOf(value.a().size()));
        }
    }

    protected void l2(QCircleFeedEvent qCircleFeedEvent) {
        c value;
        String str = qCircleFeedEvent.mTargetId;
        if (!TextUtils.isEmpty(str) && (value = this.H.getValue()) != null && value.a().size() != 0) {
            Iterator<e30.b> it = value.a().iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                e30.b next = it.next();
                if (next != null && TextUtils.equals(str, next.g().poster.f398463id.get())) {
                    it.remove();
                    z16 = true;
                }
            }
            if (z16) {
                e3(value);
                d3(UIStateData.obtainSuccess(false).setData(false, value.a()).setFinish(value.b()));
            }
            QLog.d(getTAG(), 1, "deleteFeedsByUid removeFeed result: ", Boolean.valueOf(z16), ",size = ", Integer.valueOf(value.a().size()));
        }
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        if (getDisplaySurfaceData(new Object[0]).getValue() != null && getDisplaySurfaceData(new Object[0]).getValue().getState() != 1) {
            getDisplaySurfaceData(new Object[0]).getValue().setState(1);
            r2().F(new m.a().c("load_more").m(0));
        }
    }

    public void n3(String str) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            qCircleReporterAgent.removeExtraSessionEntry(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        QLog.d("FeedLine_QFSTabFeedViewModel", 1, "onCleared " + this);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        F3();
        if (n2()) {
            com.tencent.biz.qqcircle.immersive.repository.foldertab.l lVar = this.F;
            if (lVar != null) {
                lVar.v();
            }
            this.F = null;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleFeedEvent) {
            x2((QCircleFeedEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSRerankFinishEvent) {
            k3();
            return;
        }
        if (simpleBaseEvent instanceof QFSUpdateFeedListEvent) {
            F2((QFSUpdateFeedListEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            ASEngineTabStatusEvent aSEngineTabStatusEvent = (ASEngineTabStatusEvent) simpleBaseEvent;
            B2(aSEngineTabStatusEvent);
            h2(aSEngineTabStatusEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSFeedVideoErrorEvent) {
            G2((QFSFeedVideoErrorEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSSmallInsertFeedEvent) {
            C2((QFSSmallInsertFeedEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSSmallRefreshSelectedEvent) {
            E2((QFSSmallRefreshSelectedEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSHandleFirstTaskPublishedEvent) {
            z2((QFSHandleFirstTaskPublishedEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSReplaceFeedSourceEvent) {
            A2((QFSReplaceFeedSourceEvent) simpleBaseEvent);
        }
    }

    public MutableLiveData<FeedCloudMeta$StFeed> p2() {
        return this.I;
    }

    public MutableLiveData<UIStateData<QCircleFeedDetailRspInfo>> q2() {
        return this.M;
    }

    public void q3(List<e30.b> list) {
        this.E.H(list);
    }

    public com.tencent.biz.qqcircle.immersive.repository.foldertab.m r2() {
        return this.E;
    }

    public void r3(String str, int i3, int i16) {
        this.E.I(str, i3, i16);
    }

    public List<FeedCloudCommon$RecomReed> s2() {
        if (this.P.isEmpty()) {
            return this.P;
        }
        ArrayList arrayList = new ArrayList(this.P);
        this.P.clear();
        return arrayList;
    }

    public void s3(List<e30.b> list) {
        QCircleTabInfo qCircleTabInfo = this.D;
        if (qCircleTabInfo != null && qCircleTabInfo.getSource() == 10) {
            this.E.J(list);
        }
    }

    public MutableLiveData<String> t2() {
        return this.J;
    }

    public MutableLiveData<Long> u2() {
        return this.L;
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public void updateSession(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            qCircleReporterAgent.updateSubSession(feedCloudCommon$StCommonExt);
        }
    }

    public MutableLiveData<c> v2() {
        return this.H;
    }

    public void v3(String str) {
        if (this.K.compareAndSet(false, true)) {
            this.J.postValue(str);
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "setLoadFeedType loadFeedType:" + str);
        }
    }

    public QCircleTabInfo w2() {
        return this.D;
    }

    public void w3(final long j3) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.o
            @Override // java.lang.Runnable
            public final void run() {
                QFSTabFeedViewModel.this.S2(j3);
            }
        });
    }

    public void x3(final int i3) {
        if (!com.tencent.biz.qqcircle.richframework.preload.coldbootV2.g.c()) {
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "setRedPointScreenConsumeFlag config is close");
            return;
        }
        c value = this.H.getValue();
        if (value != null) {
            boolean z16 = value.f86648g;
            if (z16) {
                new com.tencent.biz.qqcircle.immersive.repository.foldertab.j(this).k(value.a());
                RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSTabFeedViewModel.T2(i3);
                    }
                });
            }
            QLog.d("FeedLine_QFSTabFeedViewModel", 1, "setRedPointScreenConsumeFlag oldStatus:" + z16);
            value.f86648g = false;
        }
    }

    public void y3(@NonNull QCircleTabInfo qCircleTabInfo) {
        if (this.D != null) {
            return;
        }
        this.D = qCircleTabInfo;
        this.E = new com.tencent.biz.qqcircle.immersive.repository.foldertab.m(this);
        k3();
        m3();
        h3();
    }

    public void z3(com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.a aVar) {
        this.X = aVar;
    }
}
