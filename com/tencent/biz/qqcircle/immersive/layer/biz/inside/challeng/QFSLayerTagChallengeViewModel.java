package com.tencent.biz.qqcircle.immersive.layer.biz.inside.challeng;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleTagChallengeInfo;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListTagChallengeRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StTagChallengePageRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerTagChallengeViewModel extends QFSLayerBaseViewModel {
    public static volatile boolean H;
    private QCircleTagChallengeInfo F;
    private final MutableLiveData<List<QCircleTagChallengeInfo>> E = new MutableLiveData<>();
    private final Map<String, e40.c> G = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QCircleGetFeedListTagChallengeRequest f86574a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f86575b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f86576c;

        a(QCircleGetFeedListTagChallengeRequest qCircleGetFeedListTagChallengeRequest, boolean z16, boolean z17) {
            this.f86574a = qCircleGetFeedListTagChallengeRequest;
            this.f86575b = z16;
            this.f86576c = z17;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            QLog.d(QFSLayerTagChallengeViewModel.this.getTAG(), 1, "[requestTagChallengeFeedsData] onReceive dispatch Success:" + z16 + " | TraceId: " + this.f86574a.getTraceId() + " | SeqId: " + this.f86574a.getCurrentSeq() + " | retCode:" + j3 + " | retMessage: " + str);
            QFSLayerTagChallengeViewModel.this.m2(baseRequest, z16, j3, str, feedCloudRead$StGetFeedListRsp, this.f86575b, this.f86576c);
            QFSLayerTagChallengeViewModel.H = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements OnTaskListener<Object> {
        b() {
        }

        @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
        public void onComplete(Object... objArr) {
            if (objArr != null && objArr.length == 5) {
                QFSLayerTagChallengeViewModel.this.m2((BaseRequest) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Long) objArr[2]).longValue(), (String) objArr[3], (FeedCloudRead$StGetFeedListRsp) objArr[4], false, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e30.b> i2(List<FeedCloudMeta$StFeed> list) {
        return e30.d.b(list);
    }

    private QCircleTagChallengeInfo j2(List<QCircleTagChallengeInfo> list) {
        if (this.F == null) {
            return null;
        }
        Iterator<QCircleTagChallengeInfo> it = list.iterator();
        while (it.hasNext() && !it.next().equals(this.F)) {
        }
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l2(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (!feedCloudRead$StGetFeedListRsp.busiRspData.has()) {
            return;
        }
        QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
        try {
            qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSLayerTagChallengeViewModel", 1, "[getTagChallengeList] get busiRspData error:", e16);
        }
        QQCircleFeedBase$StTagChallengePageRsp qQCircleFeedBase$StTagChallengePageRsp = qQCircleFeedBase$StFeedListBusiRspData.tagChallengePageRsp;
        if (qQCircleFeedBase$StTagChallengePageRsp != null && qQCircleFeedBase$StTagChallengePageRsp.has()) {
            QQCircleFeedBase$StTagChallengePageRsp qQCircleFeedBase$StTagChallengePageRsp2 = qQCircleFeedBase$StFeedListBusiRspData.tagChallengePageRsp.get();
            ArrayList arrayList = new ArrayList();
            Iterator<FeedCloudMeta$StTagInfo> it = qQCircleFeedBase$StTagChallengePageRsp2.challengeTagList.get().iterator();
            while (it.hasNext()) {
                arrayList.add(c40.d.e(it.next()));
            }
            this.E.postValue(arrayList);
            QLog.d("QFSLayerTagChallengeViewModel", 1, "[getTagChallengeList] needPreLoad: ", Boolean.valueOf(qQCircleFeedBase$StTagChallengePageRsp2.needPreLoad.get()));
            if (qQCircleFeedBase$StTagChallengePageRsp2.needPreLoad.get()) {
                u2(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2(final BaseRequest baseRequest, final boolean z16, final long j3, final String str, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, final boolean z17, final boolean z18) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.challeng.QFSLayerTagChallengeViewModel.2
            @Override // java.lang.Runnable
            public void run() {
                FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp2;
                BaseRequest baseRequest2 = baseRequest;
                if (!(baseRequest2 instanceof QCircleGetFeedListTagChallengeRequest)) {
                    return;
                }
                QCircleGetFeedListTagChallengeRequest qCircleGetFeedListTagChallengeRequest = (QCircleGetFeedListTagChallengeRequest) baseRequest2;
                ((QFSLayerBaseViewModel) QFSLayerTagChallengeViewModel.this).f86506m.setCurrentState(4);
                if (z16 && j3 == 0 && (feedCloudRead$StGetFeedListRsp2 = feedCloudRead$StGetFeedListRsp) != null) {
                    QFSLayerTagChallengeViewModel qFSLayerTagChallengeViewModel = QFSLayerTagChallengeViewModel.this;
                    qFSLayerTagChallengeViewModel.v2(feedCloudRead$StGetFeedListRsp2, ((QFSLayerBaseViewModel) qFSLayerTagChallengeViewModel).f86506m);
                    QFSLayerTagChallengeViewModel.this.l2(feedCloudRead$StGetFeedListRsp);
                    boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
                    ArrayList i26 = QFSLayerTagChallengeViewModel.this.i2(feedCloudRead$StGetFeedListRsp.vecFeed.get());
                    if (i26 != null && i26.size() != 0) {
                        QLog.i("QFSLayerTagChallengeViewModel", 1, "[handleFeedListResponse] isPreLoad: " + z18 + " |isLoadMore: " + z17);
                        if (z18) {
                            QFSLayerTagChallengeViewModel.this.w2(i26, qCircleGetFeedListTagChallengeRequest);
                        }
                        if (!z17) {
                            ((QFSLayerBaseViewModel) QFSLayerTagChallengeViewModel.this).C.clear();
                        }
                        ((QFSLayerBaseViewModel) QFSLayerTagChallengeViewModel.this).C.addAll(i26);
                        ((QFSLayerBaseViewModel) QFSLayerTagChallengeViewModel.this).D.postValue(UIStateData.obtainSuccess(isProtocolCache).setData(z17, ((QFSLayerBaseViewModel) QFSLayerTagChallengeViewModel.this).C).setFinish(((QFSLayerBaseViewModel) QFSLayerTagChallengeViewModel.this).f86506m.isFinish()));
                        return;
                    }
                    QLog.e("QFSLayerTagChallengeViewModel", 1, "[handleFeedListResponse] filterDisplayList == null || filterDisplayList.size() == 0.");
                    return;
                }
                ((QFSLayerBaseViewModel) QFSLayerTagChallengeViewModel.this).D.postValue(UIStateData.obtainError(str));
            }
        });
    }

    private boolean n2(List<e30.b> list, e30.b bVar) {
        Iterator<e30.b> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().g().get().f398449id.get().equals(bVar.g().get().f398449id.get())) {
                return true;
            }
        }
        return false;
    }

    private void o2(QCircleTagChallengeInfo qCircleTagChallengeInfo) {
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setTagChallengeInfo(qCircleTagChallengeInfo);
        s2();
        r2(qCircleLayerBean, true, true);
    }

    private void u2(List<QCircleTagChallengeInfo> list) {
        QCircleTagChallengeInfo j26 = j2(list);
        if (j26 != null && !this.G.containsKey(j26.mTagId)) {
            QLog.d("QFSLayerTagChallengeViewModel", 1, "[getTagChallengeList] preLoadNextTagData tagId: ", j26);
            o2(j26);
        } else {
            QLog.d("QFSLayerTagChallengeViewModel", 1, "[getTagChallengeList] nextTagChallengeInfo == null || MULTI_TAG_FEEDS containsKey mTagId.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v2(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, LoadInfo loadInfo) {
        loadInfo.setStringAttachInfo(feedCloudRead$StGetFeedListRsp.feedAttchInfo.get());
        boolean z16 = true;
        if (feedCloudRead$StGetFeedListRsp.isFinish.get() != 1) {
            z16 = false;
        }
        loadInfo.setFinish(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w2(ArrayList<e30.b> arrayList, QCircleGetFeedListTagChallengeRequest qCircleGetFeedListTagChallengeRequest) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<e30.b> it = arrayList.iterator();
            while (it.hasNext()) {
                e30.b next = it.next();
                QCircleTagChallengeInfo c16 = c40.d.c(next);
                if (c16 != null) {
                    if (!this.G.containsKey(c16.mTagId)) {
                        e40.c cVar = new e40.c();
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(next);
                        cVar.b(arrayList2);
                        this.G.put(c16.mTagId, cVar);
                    } else {
                        List<e30.b> a16 = this.G.get(c16.mTagId).a();
                        if (a16 != null && !n2(a16, next)) {
                            a16.add(next);
                        }
                    }
                }
            }
            return;
        }
        this.G.put(qCircleGetFeedListTagChallengeRequest.mTagChallengeInfo.mTagId, new e40.c());
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerTagChallengeViewModel";
    }

    public MutableLiveData<List<QCircleTagChallengeInfo>> k2() {
        return this.E;
    }

    public void p2(QCircleLayerBean qCircleLayerBean) {
        if (PreLoader.exists("2017")) {
            QLog.i("QFSLayerTagChallengeViewModel", 1, "runPreload");
            this.D.setValue(UIStateData.obtainLoading());
            PreLoader.addListener("2017", new b());
            return;
        }
        q2(qCircleLayerBean, false);
    }

    public void q2(QCircleLayerBean qCircleLayerBean, boolean z16) {
        r2(qCircleLayerBean, z16, false);
    }

    public void r2(QCircleLayerBean qCircleLayerBean, boolean z16, boolean z17) {
        String str;
        int i3;
        if (z16) {
            str = this.f86506m.getStringAttachInfo();
        } else {
            str = null;
        }
        if (z17) {
            i3 = 1;
        } else {
            i3 = 10;
        }
        QCircleGetFeedListTagChallengeRequest qCircleGetFeedListTagChallengeRequest = new QCircleGetFeedListTagChallengeRequest(qCircleLayerBean, str, i3);
        this.D.postValue(UIStateData.obtainLoading());
        sendRequest(qCircleGetFeedListTagChallengeRequest, new a(qCircleGetFeedListTagChallengeRequest, z16, z17));
        H = true;
    }

    public void s2() {
        this.f86506m.setStringAttachInfo(null);
        this.f86506m.setFinish(false);
    }

    public void t2(QCircleTagChallengeInfo qCircleTagChallengeInfo) {
        this.F = qCircleTagChallengeInfo;
    }
}
