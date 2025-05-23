package com.tencent.biz.qqcircle.immersive.repository.foldertab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.immersive.repository.foldertab.m;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.IQCircleColdBootServiceV2;
import com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSPreloadDataSource extends k {
    private static final int C = uq3.c.j3();

    /* renamed from: i, reason: collision with root package name */
    private final QFSTabRequestSender f89745i;

    /* renamed from: m, reason: collision with root package name */
    private Call.OnRspCallBack f89746m;

    public QFSPreloadDataSource(@NonNull l lVar) {
        super(lVar);
        this.f89745i = new QFSTabRequestSender(a(), lVar);
    }

    private boolean k(m.a aVar) {
        IPreloadTask task = ((IQCircleColdBootServiceV2) QRoute.api(IQCircleColdBootServiceV2.class)).getTask(this.f89798f);
        if (task == null) {
            QLog.d(a(), 1, "can't find preload task,source: ", Integer.valueOf(this.f89798f));
            return false;
        }
        if (!task.hasPreloadData()) {
            QLog.d(a(), 1, "has no preload data,source: ", Integer.valueOf(this.f89798f));
            return false;
        }
        return l(aVar, task);
    }

    private boolean l(m.a aVar, IPreloadTask iPreloadTask) {
        Object preloadRsp = iPreloadTask.getPreloadRsp();
        if (preloadRsp instanceof FeedCloudRead$StGetFeedListRsp) {
            w(aVar, (FeedCloudRead$StGetFeedListRsp) preloadRsp);
            return true;
        }
        byte[] preloadRspData = iPreloadTask.getPreloadRspData();
        if (preloadRspData != null && preloadRspData.length > 0) {
            x(aVar, preloadRspData);
            return true;
        }
        return false;
    }

    private boolean m(m.a aVar, int i3) {
        IPreloadTask task = ((IQCircleColdBootServiceV2) QRoute.api(IQCircleColdBootServiceV2.class)).getTask(i3);
        if (task == null) {
            QLog.d(a(), 1, "can't find preload task,source: ", Integer.valueOf(i3));
            return false;
        }
        if (!task.hasPreloadData()) {
            QLog.d(a(), 1, "has no preload data,source: ", Integer.valueOf(i3));
            return false;
        }
        return l(aVar, task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, m.a aVar) {
        String str;
        List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetFeedListRsp.vecFeed.get();
        boolean z16 = false;
        if (list != null) {
            int size = list.size();
            int i3 = C;
            if (size > i3) {
                feedCloudRead$StGetFeedListRsp.vecFeed.set(list.subList(0, i3));
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doRespondPreloadData,feedId:");
        for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : feedCloudRead$StGetFeedListRsp.vecFeed.get()) {
            if (feedCloudMeta$StFeed != null) {
                sb5.append(feedCloudMeta$StFeed.f398449id.get());
                sb5.append("|");
            }
        }
        QLog.d(a(), 1, sb5.toString());
        Object obj = aVar.f89822m.get("is_backup_rsp");
        if (obj instanceof Boolean) {
            z16 = ((Boolean) obj).booleanValue();
        }
        p60.b bVar = this.f89796d;
        if (z16) {
            str = "7";
        } else {
            str = "1";
        }
        bVar.b(str);
        this.f89745i.s(feedCloudRead$StGetFeedListRsp, aVar);
    }

    private boolean q(m.a aVar) {
        if (k(aVar)) {
            QLog.d(a(), 1, "fetchNormalPreloadDataV2 success");
            return true;
        }
        return false;
    }

    private void t(final long j3, final String str, Object obj, Object obj2, @NonNull final m.a aVar) {
        final QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest = (QCircleTabGetFeedListRequest) obj;
        final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = (FeedCloudRead$StGetFeedListRsp) obj2;
        final boolean b16 = aVar.b();
        final boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
        final int type = this.f89796d.G().getType();
        final int i3 = aVar.f89818i;
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.repository.foldertab.e
            @Override // java.lang.Runnable
            public final void run() {
                QFSPreloadDataSource.this.v(aVar, qCircleTabGetFeedListRequest, j3, str, b16, isProtocolCache, type, i3, feedCloudRead$StGetFeedListRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(m.a aVar, boolean z16, long j3, String str, Object obj, Object obj2, Bundle bundle) {
        if (z16 && j3 == 0) {
            if ((obj instanceof QCircleTabGetFeedListRequest) && (obj2 instanceof FeedCloudRead$StGetFeedListRsp)) {
                t(j3, str, obj, obj2, aVar);
                return;
            }
            return;
        }
        QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest = (QCircleTabGetFeedListRequest) obj;
        boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
        int type = this.f89796d.G().getType();
        int i3 = aVar.f89818i;
        QLog.d(a(), 1, "[doPerPullFeed] requestFeedsData onReceive: dispatch Error: Action:" + aVar.f89810a + " | TraceId:" + qCircleTabGetFeedListRequest.getTraceId() + " | SeqId:" + qCircleTabGetFeedListRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isCache:" + isProtocolCache + " | tabType:" + type + " | pullSceneType:" + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(m.a aVar, QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest, long j3, String str, boolean z16, boolean z17, int i3, int i16, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        QLog.d(a(), 1, "[handlePrePullFeedListRsp] onReceive: dispatch Success: Action:" + aVar.f89810a + " | TraceId:" + qCircleTabGetFeedListRequest.getTraceId() + " | SeqId:" + qCircleTabGetFeedListRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isLoadMore:" + z16 + " | isCache:" + z17 + " | tabType:" + i3 + " | pullSceneType:" + i16 + " | isSilenceInsertModel:" + aVar.f89817h);
        IPreloadTask task = ((IQCircleColdBootServiceV2) QRoute.api(IQCircleColdBootServiceV2.class)).getTask(this.f89798f);
        if (task == null) {
            QLog.d(a(), 1, "[handlePrePullFeedListRsp]can't find preload task,source: ", Integer.valueOf(this.f89798f));
        } else {
            task.dealWithPagePrePullRsp(feedCloudRead$StGetFeedListRsp);
        }
    }

    private void w(final m.a aVar, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.repository.foldertab.QFSPreloadDataSource.1
            @Override // java.lang.Runnable
            public void run() {
                QFSPreloadDataSource.this.o(feedCloudRead$StGetFeedListRsp, aVar);
            }
        });
    }

    private void x(final m.a aVar, final byte[] bArr) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.repository.foldertab.QFSPreloadDataSource.2
            @Override // java.lang.Runnable
            public void run() {
                FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
                try {
                    feedCloudRead$StGetFeedListRsp.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("QFSPreloadDataSource", 1, "respondPreloadData error:", e16.toString());
                }
                QFSPreloadDataSource.this.o(feedCloudRead$StGetFeedListRsp, aVar);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.repository.foldertab.k
    public String a() {
        return b() + "_QFSPreloadDataSource";
    }

    public boolean j(m.a aVar) {
        if (aVar == null || this.f89798f != 10 || !aVar.f89814e) {
            return false;
        }
        QLog.d(a(), 1, "doFetchFloatInsertData");
        FeedCloudMeta$StFeed n3 = p40.l.t().n();
        if (n3 == null) {
            QLog.d(a(), 1, "doFetchFloatInsertData no Data");
            return false;
        }
        QFSTabFeedViewModel.c cVar = new QFSTabFeedViewModel.c();
        cVar.f86642a.clear();
        e30.b bVar = new e30.b(n3);
        bVar.p();
        cVar.f86642a.add(bVar);
        cVar.f86645d = false;
        f(cVar);
        d(UIStateData.obtainSuccess(true).setData(false, cVar.f86642a).setFinish(false));
        p60.b bVar2 = this.f89796d;
        if (bVar2 != null) {
            bVar2.b("1");
        }
        return true;
    }

    public boolean n(@NonNull final m.a aVar) {
        if (((IQCircleColdBootServiceV2) QRoute.api(IQCircleColdBootServiceV2.class)).getTask(this.f89798f) == null) {
            QLog.e(a(), 1, "[doPerPullFeed] IPreloadTask is null");
            return false;
        }
        Call.OnRspCallBack onRspCallBack = new Call.OnRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.repository.foldertab.d
            @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
            public final void onReceive(boolean z16, long j3, String str, Object obj, Object obj2, Bundle bundle) {
                QFSPreloadDataSource.this.u(aVar, z16, j3, str, obj, obj2, bundle);
            }
        };
        this.f89746m = onRspCallBack;
        this.f89745i.H(aVar, onRspCallBack);
        return false;
    }

    public boolean p(m.a aVar, String str) {
        if (aVar == null || !aVar.f89813d || !"init".equals(aVar.f89810a)) {
            return false;
        }
        int i3 = this.f89798f;
        if (i3 == 10) {
            QLog.d(a(), 1, "fetchData allPush");
            if (aVar.f89816g) {
                return s(aVar, 10000);
            }
            return q(aVar);
        }
        if (i3 == 75) {
            QLog.d(a(), 1, "fetchData mTabSource:" + this.f89798f);
            return s(aVar, this.f89798f);
        }
        return false;
    }

    public boolean r(m.a aVar) {
        if (aVar == null || this.f89798f != 10 || !aVar.f89815f) {
            return false;
        }
        QLog.d(a(), 1, "fetchPushPreloadData");
        FeedCloudMeta$StFeed k3 = bb0.b.i().k(true);
        if (k3 == null) {
            QLog.d(a(), 1, "fetchPushPreloadData waitConsumePushFeed is null");
            return false;
        }
        QFSTabFeedViewModel.c cVar = new QFSTabFeedViewModel.c();
        cVar.f86642a.clear();
        e30.b bVar = new e30.b(k3);
        bVar.p();
        cVar.f86642a.add(bVar);
        cVar.f86645d = false;
        f(cVar);
        d(UIStateData.obtainSuccess(true).setData(false, cVar.f86642a).setFinish(false));
        p60.b bVar2 = this.f89796d;
        if (bVar2 != null) {
            bVar2.b("1");
        }
        return true;
    }

    public boolean s(m.a aVar, int i3) {
        if (m(aVar, i3)) {
            QLog.d(a(), 1, "fetchRedDotPreloadDataV2 success,source:" + i3);
            return true;
        }
        return false;
    }
}
