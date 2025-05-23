package com.tencent.biz.qqcircle.immersive.aggregation;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSFlowAggregationInitBean;
import com.tencent.biz.qqcircle.immersive.aggregation.request.QFSGetFeedListMusicRequest;
import com.tencent.biz.qqcircle.immersive.aggregation.request.QFSGetFeedListUnifiedTagRequest;
import com.tencent.biz.qqcircle.immersive.aggregation.request.QFSGetMusicCollectionReq;
import com.tencent.biz.qqcircle.immersive.aggregation.request.QFSModMusicCollectionReq;
import com.tencent.biz.qqcircle.immersive.request.QFSGetShareDataRequest;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.Pair;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReporterAgent;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StShare;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import feedcloud.FeedCloudRead$StGetFeedSharePanelRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleSmartMatchMusic$GetMusicCollectionRsp;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFlowAggregationViewModel extends com.tencent.biz.qqcircle.viewmodels.a implements IQCircleReportSessionOperation, IDataDisplaySurface<e30.b>, Call.OnRspCallBack<QCircleBaseRequest> {
    private QFSFlowAggregationInitBean L;
    public Boolean M;
    private String N;
    private String P;
    private Boolean Q;
    private boolean R;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<UIStateData<List<e30.b>>> f84745m = new MutableLiveData<>();
    private final MutableLiveData<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>> C = new MutableLiveData<>();
    public MutableLiveData<UIStateData<List<e30.b>>> D = new MutableLiveData<>();
    private final MutableLiveData<a> E = new MutableLiveData<>();
    private final MutableLiveData<a> F = new MutableLiveData<>();
    private final MutableLiveData<Pair<Integer, Boolean>> G = new MutableLiveData<>();
    private final List<e30.b> H = new ArrayList();
    public final MutableLiveData<Pair<Boolean, FeedCloudMeta$StShare>> I = new MutableLiveData<>();
    private String J = null;
    private String K = null;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f84758a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f84759b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f84760c;

        public a(boolean z16, boolean z17, boolean z18) {
            this.f84758a = z16;
            this.f84759b = z17;
            this.f84760c = z18;
        }
    }

    public QFSFlowAggregationViewModel() {
        Boolean bool = Boolean.FALSE;
        this.M = bool;
        this.N = "";
        this.P = "";
        this.Q = bool;
        this.R = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D2(boolean z16, List<e30.b> list, boolean z17, boolean z18) {
        if (!z16) {
            this.H.clear();
        }
        this.H.addAll(list);
        this.D.setValue(UIStateData.obtainSuccess(z17).setData(z16, this.H).setFinish(z18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l2(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, final boolean z16, final boolean z17) {
        if (feedCloudRead$StGetFeedListRsp != null && feedCloudRead$StGetFeedListRsp.busiRspData.has()) {
            final QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
            try {
                qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (qQCircleFeedBase$StFeedListBusiRspData.refreshAttachInfo.has()) {
                this.K = qQCircleFeedBase$StFeedListBusiRspData.refreshAttachInfo.get();
            }
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.aggregation.QFSFlowAggregationViewModel.3
                @Override // java.lang.Runnable
                public void run() {
                    if (qQCircleFeedBase$StFeedListBusiRspData.has()) {
                        QFSFlowAggregationViewModel.this.C.setValue(UIStateData.obtainSuccess(z16).setData(z17, qQCircleFeedBase$StFeedListBusiRspData));
                    } else {
                        QFSFlowAggregationViewModel.this.C.setValue(UIStateData.obtainEmpty());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o2(final long j3, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, final boolean z16, final boolean z17) {
        final ArrayList<e30.b> b16 = e30.d.b(feedCloudRead$StGetFeedListRsp.vecFeed.get());
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.aggregation.QFSFlowAggregationViewModel.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z18;
                boolean z19;
                boolean z26 = true;
                if (b16.size() > 0) {
                    MutableLiveData mutableLiveData = QFSFlowAggregationViewModel.this.f84745m;
                    UIStateData data = UIStateData.obtainSuccess(z16).setData(z17, b16);
                    if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    mutableLiveData.setValue(data.setFinish(z19));
                    QFSFlowAggregationViewModel qFSFlowAggregationViewModel = QFSFlowAggregationViewModel.this;
                    boolean z27 = z17;
                    ArrayList arrayList = b16;
                    boolean z28 = z16;
                    if (feedCloudRead$StGetFeedListRsp.isFinish.get() <= 0) {
                        z26 = false;
                    }
                    qFSFlowAggregationViewModel.D2(z27, arrayList, z28, z26);
                    return;
                }
                MutableLiveData mutableLiveData2 = QFSFlowAggregationViewModel.this.f84745m;
                UIStateData loadMore = UIStateData.obtainEmpty().setRetCode(j3).setLoadMore(z17);
                if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                mutableLiveData2.setValue(loadMore.setFinish(z18));
                MutableLiveData<UIStateData<List<e30.b>>> mutableLiveData3 = QFSFlowAggregationViewModel.this.D;
                UIStateData loadMore2 = UIStateData.obtainEmpty().setRetCode(j3).setLoadMore(z17);
                if (feedCloudRead$StGetFeedListRsp.isFinish.get() <= 0) {
                    z26 = false;
                }
                mutableLiveData3.setValue(loadMore2.setFinish(z26));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q2(String str, boolean z16, long j3, String str2, QFSGetMusicCollectionReq qFSGetMusicCollectionReq, Object obj, Bundle bundle) {
        boolean z17;
        QLog.d("QFSFlowAggregationViewModel", 1, "getMusicCollectState success:" + z16 + ", retCode:" + j3);
        if (z16 && j3 == 0) {
            Iterator<QQCircleSmartMatchMusic$MusicInfo> it = ((QQCircleSmartMatchMusic$GetMusicCollectionRsp) obj).musicList.get().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (str.equals(it.next().songInfo.get().MID.get())) {
                        z17 = true;
                        break;
                    }
                } else {
                    z17 = false;
                    break;
                }
            }
            this.E.postValue(new a(true, z17, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(boolean z16, long j3, String str, QFSGetShareDataRequest qFSGetShareDataRequest, Object obj, Bundle bundle) {
        QLog.i("QFSFlowAggregationViewModel", 1, "getShareDataRequest success:" + z16 + ", retCode:" + j3 + ", msg:" + str);
        if (z16 && j3 == 0) {
            FeedCloudRead$StGetFeedSharePanelRsp feedCloudRead$StGetFeedSharePanelRsp = (FeedCloudRead$StGetFeedSharePanelRsp) obj;
            this.M = Boolean.valueOf(feedCloudRead$StGetFeedSharePanelRsp.is_collect.get());
            this.I.postValue(new Pair<>(Boolean.valueOf(feedCloudRead$StGetFeedSharePanelRsp.is_collect.get()), feedCloudRead$StGetFeedSharePanelRsp.share_info));
            return;
        }
        this.I.postValue(new Pair<>(Boolean.FALSE, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s2(boolean z16, long j3, String str, QFSModMusicCollectionReq qFSModMusicCollectionReq, Object obj, Bundle bundle) {
        QLog.d("QFSFlowAggregationViewModel", 1, "handleClickCollectInMusicPage success:" + z16);
        this.G.postValue(new Pair<>(Integer.valueOf(qFSModMusicCollectionReq.getModCmd()), Boolean.valueOf(z16)));
        if (qFSModMusicCollectionReq.getModCmd() == 1) {
            this.M = Boolean.valueOf(z16);
        } else {
            this.M = Boolean.valueOf(!z16);
        }
        if (z16 && j3 == 0) {
            this.F.postValue(new a(true, this.M.booleanValue(), true));
        } else {
            this.F.postValue(new a(false, this.M.booleanValue(), true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        QLog.d("QFSFlowAggregationViewModel", 1, "[sendFavoriteListToServer] success:" + z16 + " retCode:" + j3 + " errMsg:" + str);
        if (z16 && j3 == 0) {
            this.E.postValue(new a(true, true, true));
            this.M = Boolean.TRUE;
        } else {
            this.E.postValue(new a(false, false, true));
            this.M = Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u2(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        QLog.d("QFSFlowAggregationViewModel", 1, "[deleteFavorite] success:" + z16 + " retCode:" + j3 + " errMsg:" + str);
        if (z16 && j3 == 0) {
            this.E.postValue(new a(true, false, true));
            this.M = Boolean.FALSE;
        } else {
            this.E.postValue(new a(false, true, true));
            this.M = Boolean.TRUE;
        }
    }

    private void x2(QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData) {
        this.C.setValue(UIStateData.obtainSuccess(true).setData(false, qQCircleFeedBase$StFeedListBusiRspData));
    }

    public void A2(String str) {
        this.P = str;
    }

    public void B2(Boolean bool) {
        this.Q = bool;
    }

    public void C2(String str) {
        this.N = str;
    }

    public MutableLiveData<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>> X1() {
        return this.C;
    }

    public MutableLiveData<a> Z1() {
        return this.E;
    }

    public MutableLiveData<UIStateData<List<e30.b>>> a2() {
        return this.f84745m;
    }

    public MutableLiveData<a> b2() {
        return this.F;
    }

    public String c2() {
        return this.P;
    }

    public MutableLiveData<Pair<Integer, Boolean>> d2() {
        return this.G;
    }

    public void e2(final String str) {
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(new QFSGetMusicCollectionReq()).m250setRspOnCallBack(new Call.OnRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.aggregation.a
            @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
            public final void onReceive(boolean z16, long j3, String str2, Object obj, Object obj2, Bundle bundle) {
                QFSFlowAggregationViewModel.this.q2(str, z16, j3, str2, (QFSGetMusicCollectionReq) obj, obj2, bundle);
            }
        }).execute();
    }

    public void f2() {
        QLog.i("QFSFlowAggregationViewModel", 1, "unifiedType:" + j2() + " id:" + i2());
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(new QFSGetShareDataRequest(16, j2(), i2())).m250setRspOnCallBack(new Call.OnRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.aggregation.b
            @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
            public final void onReceive(boolean z16, long j3, String str, Object obj, Object obj2, Bundle bundle) {
                QFSFlowAggregationViewModel.this.r2(z16, j3, str, (QFSGetShareDataRequest) obj, obj2, bundle);
            }
        }).execute();
    }

    public Boolean g2() {
        return this.Q;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        return this.D;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        QFSFlowAggregationInitBean qFSFlowAggregationInitBean = this.L;
        if (qFSFlowAggregationInitBean == null) {
            return 0;
        }
        return qFSFlowAggregationInitBean.getAggregationType();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSFlowAggregationViewModel";
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public FeedCloudCommon$StCommonExt getSession(boolean z16) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            return qCircleReporterAgent.getSessionCommonExt(z16);
        }
        return new FeedCloudCommon$StCommonExt();
    }

    public String h2() {
        return this.N;
    }

    public String i2() {
        return this.L.getFeedUnifiedTag().unifiedId.get();
    }

    public String j2() {
        return this.L.getFeedUnifiedTag().unifiedType.get();
    }

    public String k2() {
        return String.valueOf(hashCode());
    }

    public void loadMore() {
        QCircleBaseRequest qFSGetFeedListMusicRequest;
        QFSFlowAggregationInitBean qFSFlowAggregationInitBean = this.L;
        if (qFSFlowAggregationInitBean == null) {
            return;
        }
        int aggregationType = qFSFlowAggregationInitBean.getAggregationType();
        if (aggregationType != 43) {
            if (aggregationType != 44) {
                qFSGetFeedListMusicRequest = null;
            } else {
                qFSGetFeedListMusicRequest = new QFSGetFeedListUnifiedTagRequest(this.L, this.J, this.K);
            }
        } else {
            qFSGetFeedListMusicRequest = new QFSGetFeedListMusicRequest(this.L, this.J, this.K);
        }
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().h(false).i(true).addRequest(qFSGetFeedListMusicRequest).m250setRspOnCallBack((Call.OnRspCallBack) this).execute();
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        loadMore();
    }

    public void m2(String str, boolean z16) {
        int i3 = 1;
        QLog.d("QFSFlowAggregationViewModel", 1, "handleClickCollectInMusicPage, songMid:" + str + ", isCollect:" + z16);
        if (!z16) {
            i3 = 2;
        }
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(new QFSModMusicCollectionReq(str, i3)).m250setRspOnCallBack(new Call.OnRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.aggregation.e
            @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
            public final void onReceive(boolean z17, long j3, String str2, Object obj, Object obj2, Bundle bundle) {
                QFSFlowAggregationViewModel.this.s2(z17, j3, str2, (QFSModMusicCollectionReq) obj, obj2, bundle);
            }
        }).execute();
    }

    public void n2(String str, String str2, boolean z16) {
        QLog.d("QFSFlowAggregationViewModel", 1, "handleClickCollectInUnifiedPage, unifiedType:" + str + " unifiedId:" + str2 + " isCollect:" + z16);
        if (z16) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            o83.a.f422212a.e(str, arrayList, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.aggregation.c
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str3, Object obj) {
                    QFSFlowAggregationViewModel.this.t2(baseRequest, z17, j3, str3, obj);
                }
            });
            return;
        }
        o83.a.f422212a.a(str, str2, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.aggregation.d
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str3, Object obj) {
                QFSFlowAggregationViewModel.this.u2(baseRequest, z17, j3, str3, obj);
            }
        });
    }

    public boolean p2() {
        return this.R;
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public void updateSession(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            qCircleReporterAgent.updateSubSession(feedCloudCommon$StCommonExt);
        }
    }

    @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
    /* renamed from: v2, reason: merged with bridge method [inline-methods] */
    public void onReceive(boolean z16, final long j3, String str, QCircleBaseRequest qCircleBaseRequest, final Object obj, Bundle bundle) {
        final boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
        final boolean z17 = bundle.getBoolean("qfs_extra_data_key_is_load_more");
        QLog.d("QFSFlowAggregationViewModel", 1, "requestMusicAggregationData onReceive: dispatch Success:" + z16 + " | retCode:" + j3 + " | retMessage:" + str + " | isLoadMore:" + z17 + " | isCache:" + isProtocolCache + " | responseAttachInfo:" + this.J);
        if (z16 && j3 == 0 && (obj instanceof FeedCloudRead$StGetFeedListRsp)) {
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.aggregation.QFSFlowAggregationViewModel.1
                @Override // java.lang.Runnable
                public void run() {
                    FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = (FeedCloudRead$StGetFeedListRsp) obj;
                    if (feedCloudRead$StGetFeedListRsp.extInfo.has()) {
                        QFSFlowAggregationViewModel.this.updateSession(feedCloudRead$StGetFeedListRsp.extInfo.get());
                    }
                    QFSFlowAggregationViewModel.this.J = feedCloudRead$StGetFeedListRsp.feedAttchInfo.get();
                    QFSFlowAggregationViewModel.this.o2(j3, feedCloudRead$StGetFeedListRsp, isProtocolCache, z17);
                    QFSFlowAggregationViewModel.this.l2(feedCloudRead$StGetFeedListRsp, isProtocolCache, z17);
                }
            });
        } else {
            this.f84745m.setValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(z17));
        }
    }

    public void w2(boolean z16) {
        BaseRequest qFSGetFeedListMusicRequest;
        this.f84745m.setValue(UIStateData.obtainLoading());
        QFSFlowAggregationInitBean qFSFlowAggregationInitBean = this.L;
        if (qFSFlowAggregationInitBean == null) {
            return;
        }
        int aggregationType = qFSFlowAggregationInitBean.getAggregationType();
        if (aggregationType != 43) {
            if (aggregationType != 44) {
                return;
            } else {
                qFSGetFeedListMusicRequest = new QFSGetFeedListUnifiedTagRequest(this.L, null, this.K);
            }
        } else {
            qFSGetFeedListMusicRequest = new QFSGetFeedListMusicRequest(this.L, null, this.K);
        }
        qFSGetFeedListMusicRequest.setEnableCache(z16);
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().f("2013").h(false).addRequest(qFSGetFeedListMusicRequest).m250setRspOnCallBack((Call.OnRspCallBack) this).execute();
    }

    public void y2(boolean z16) {
        this.R = z16;
    }

    public void z2(QFSFlowAggregationInitBean qFSFlowAggregationInitBean) {
        if (qFSFlowAggregationInitBean == null) {
            return;
        }
        this.L = qFSFlowAggregationInitBean;
        QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
        if (this.L.getAggregationType() == 43) {
            qQCircleFeedBase$StFeedListBusiRspData.musicPageData.setHasFlag(true);
            qQCircleFeedBase$StFeedListBusiRspData.musicPageData.music.set(qFSFlowAggregationInitBean.getFeedMusic());
        }
        x2(qQCircleFeedBase$StFeedListBusiRspData);
    }
}
