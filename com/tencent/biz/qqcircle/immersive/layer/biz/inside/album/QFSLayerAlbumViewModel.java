package com.tencent.biz.qqcircle.immersive.layer.biz.inside.album;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.immersive.album.event.QFSAlbumProductListCleanEvent;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSDoCollectRequest;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListAlbumRequest;
import com.tencent.biz.qqcircle.requests.QFSCreateAlbumReq;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.sender.call.BaseCall;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import qqcircle.QQCircleFeedAlbum$AlbumInfo;
import qqcircle.QQCircleFeedAlbum$CreateAlbumRsp;
import qqcircle.QQCircleFeedBase$AlbumPageData;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerAlbumViewModel extends QFSLayerBaseViewModel {
    private QCircleAlbumBean E;
    private String F = "";
    private final MutableLiveData<QQCircleFeedBase$AlbumPageData> G = new MutableLiveData<>();
    private MutableLiveData<Boolean> H = new MutableLiveData<>();
    private final MutableLiveData<Boolean> I = new MutableLiveData<>(Boolean.FALSE);

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a(QQCircleFeedAlbum$AlbumInfo qQCircleFeedAlbum$AlbumInfo);

        void onFailed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int M2(List<e30.b> list, String str) {
        if (list != null && str != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3).g().f398449id.get().equals(str)) {
                    return i3;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String P2(int i3) {
        if (i3 == 0) {
            return this.f86506m.getStringAttachInfo();
        }
        if (i3 == 1) {
            return this.f86506m.getSPageUpAttachInfo();
        }
        if (i3 == 2) {
            return "";
        }
        throw new IllegalArgumentException("invalid load more flag:" + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<e30.b> Q2(List<FeedCloudMeta$StFeed> list) {
        return e30.d.b(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U2, reason: merged with bridge method [inline-methods] */
    public void d3(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleFeedAlbum$CreateAlbumRsp qQCircleFeedAlbum$CreateAlbumRsp, b bVar) {
        if (!(baseRequest instanceof QFSCreateAlbumReq)) {
            return;
        }
        QLog.d(getLogTag(), 1, "handleCreateAlbumResponse: retCode:" + j3 + ",isSuccess:" + z16 + ",errMsg" + str);
        if (z16 && j3 == 0 && qQCircleFeedAlbum$CreateAlbumRsp != null) {
            bVar.a(qQCircleFeedAlbum$CreateAlbumRsp.album_info.get());
            return;
        }
        QLog.e(getLogTag(), 1, "[handleCreateAlbumResponse] onReceive dispatch Error: | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        bVar.onFailed();
    }

    private void V2(final BaseRequest baseRequest, final boolean z16, final boolean z17, final long j3, final String str, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, final int i3, final boolean z18) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel.2
            @Override // java.lang.Runnable
            public void run() {
                FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp2;
                boolean z19;
                if (baseRequest instanceof QCircleGetFeedListAlbumRequest) {
                    String P2 = QFSLayerAlbumViewModel.this.P2(i3);
                    boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
                    QLog.d(QFSLayerAlbumViewModel.this.getLogTag(), 1, "handleGetAlbumFeedListResponse: retCode:" + j3 + ", isSuccess:" + z16 + ", isCache:" + isProtocolCache + ", loadMoreAction: " + i3 + ", withPreparedData: " + z18);
                    if (z17 && isProtocolCache) {
                        return;
                    }
                    QCircleGetFeedListAlbumRequest qCircleGetFeedListAlbumRequest = (QCircleGetFeedListAlbumRequest) baseRequest;
                    if (z16 && j3 == 0 && (feedCloudRead$StGetFeedListRsp2 = feedCloudRead$StGetFeedListRsp) != null) {
                        ArrayList Q2 = QFSLayerAlbumViewModel.this.Q2(feedCloudRead$StGetFeedListRsp2.vecFeed.get());
                        if (Q2 != null && Q2.size() != 0) {
                            if (feedCloudRead$StGetFeedListRsp.isFinish.get() == 1) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            UIStateData finish = UIStateData.obtainSuccess(isProtocolCache).setFinish(z19);
                            ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).f86506m.setFinish(z19);
                            int i16 = i3;
                            if (i16 == 2) {
                                ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).f86506m.setStringAttachInfo(feedCloudRead$StGetFeedListRsp.feedAttchInfo.get());
                                ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).f86506m.setPageUpAttachInfo(feedCloudRead$StGetFeedListRsp.load_more_status.page_up_attach_info.get());
                                ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).f86506m.setCanPageUp(feedCloudRead$StGetFeedListRsp.load_more_status.can_page_up.get());
                                if (z18) {
                                    QFSLayerAlbumViewModel.this.a3(finish, isProtocolCache, Q2);
                                } else {
                                    ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).C.clear();
                                    ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).C.addAll(Q2);
                                    QFSLayerAlbumViewModel qFSLayerAlbumViewModel = QFSLayerAlbumViewModel.this;
                                    int M2 = qFSLayerAlbumViewModel.M2(((QFSLayerBaseViewModel) qFSLayerAlbumViewModel).C, QFSLayerAlbumViewModel.this.F);
                                    if (M2 != -1) {
                                        finish.setPos(M2);
                                    }
                                    finish.setData(false, ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).C);
                                    ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).D.postValue(finish);
                                }
                            } else if (i16 == 1) {
                                ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).C.addAll(0, Q2);
                                ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).f86506m.setPageUpAttachInfo(feedCloudRead$StGetFeedListRsp.load_more_status.page_up_attach_info.get());
                                ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).f86506m.setCanPageUp(feedCloudRead$StGetFeedListRsp.load_more_status.can_page_up.get());
                                QFSLayerAlbumViewModel qFSLayerAlbumViewModel2 = QFSLayerAlbumViewModel.this;
                                finish.setPos(qFSLayerAlbumViewModel2.M2(((QFSLayerBaseViewModel) qFSLayerAlbumViewModel2).C, QFSLayerAlbumViewModel.this.F) + Q2.size());
                                finish.setUpTurning(true);
                                finish.setData(false, ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).C);
                                ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).D.postValue(finish);
                            } else if (i16 == 0) {
                                ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).C.addAll(Q2);
                                ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).f86506m.setStringAttachInfo(feedCloudRead$StGetFeedListRsp.feedAttchInfo.get());
                                finish.setData(true, ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).C);
                                ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).D.postValue(finish);
                            }
                        } else {
                            ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).D.postValue(UIStateData.obtainEmpty().setDataList(((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).C).setLoadMore(!TextUtils.isEmpty(P2)).setFinish(true));
                        }
                        if (feedCloudRead$StGetFeedListRsp.busiRspData.has()) {
                            QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
                            try {
                                qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
                            } catch (InvalidProtocolBufferMicroException e16) {
                                e16.printStackTrace();
                            }
                            if (qQCircleFeedBase$StFeedListBusiRspData.album_page_data.has()) {
                                QFSLayerAlbumViewModel.this.G.postValue(qQCircleFeedBase$StFeedListBusiRspData.album_page_data.get());
                            }
                        }
                        if (z17) {
                            QFSLayerAlbumViewModel.this.I.postValue(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    QLog.e(QFSLayerAlbumViewModel.this.getLogTag(), 1, "[requestData] onReceive dispatch Error: | TraceId:" + qCircleGetFeedListAlbumRequest.getTraceId() + " | SeqId:" + qCircleGetFeedListAlbumRequest.getCurrentSeq() + " | retCode:" + j3 + " | isCache:" + isProtocolCache + " | retMessage:" + str);
                    if (z17) {
                        QFSLayerAlbumViewModel.this.I.postValue(Boolean.FALSE);
                    }
                    UIStateData obtainError = UIStateData.obtainError(str);
                    obtainError.setData(!TextUtils.isEmpty(P2), ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).C).setFinish(true);
                    obtainError.setRetCode(j3);
                    ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).D.postValue(obtainError);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a3(UIStateData<List<e30.b>> uIStateData, boolean z16, ArrayList<e30.b> arrayList) {
        if (z16) {
            QLog.d("QFSAlbumViewModel", 1, "handleRefreshWithPreparedData, cache data ");
            return;
        }
        int M2 = M2(arrayList, this.F);
        int size = this.C.size();
        QLog.d("QFSAlbumViewModel", 1, "handleRefreshWithPreparedData, currFeedPos: " + M2 + ", currDataSize: " + size);
        if (M2 != -1 && size == 1) {
            if (arrayList.size() == 1) {
                QLog.d("QFSAlbumViewModel", 1, "handleRefreshWithPreparedData, filterDisplayList has one data ");
                return;
            }
            arrayList.set(M2, this.C.get(0));
            this.C.clear();
            this.C.addAll(arrayList);
            uIStateData.setUpTurning(true);
            uIStateData.setData(false, this.C);
            this.D.postValue(uIStateData);
            return;
        }
        this.C.clear();
        this.C.addAll(arrayList);
        uIStateData.setData(false, this.C);
        this.D.postValue(uIStateData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b3(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        V2(baseRequest, z16, true, j3, str, feedCloudRead$StGetFeedListRsp, 2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c3(QFSDoCollectRequest qFSDoCollectRequest, int i3, a aVar, boolean z16, long j3, String str, Object obj, Object obj2, Bundle bundle) {
        int i16 = 1;
        boolean z17 = true;
        QLog.d("QFSAlbumViewModel", 1, "[onReceive] -> traceId : " + qFSDoCollectRequest.getTraceId() + " , isSuccess : " + z16 + " , retCode : " + j3 + " , errMsg : " + str);
        if (this.G.getValue() == null) {
            return;
        }
        QQCircleFeedBase$AlbumPageData value = this.G.getValue();
        if (z16 && j3 == 0) {
            value.album.collection_info.status.set(i3);
            if (!VSNetworkHelper.isProtocolCache(str)) {
                if (i3 != 1) {
                    z17 = false;
                }
                aVar.a(z17);
            }
        } else {
            QCircleToast.o(str, 0);
            PBUInt32Field pBUInt32Field = value.album.collection_info.status;
            if (i3 == 1) {
                i16 = 0;
            }
            pBUInt32Field.set(i16);
        }
        this.G.setValue(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e3(int i3, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        V2(baseRequest, z17, false, j3, str, feedCloudRead$StGetFeedListRsp, i3, z16);
    }

    public boolean H2() {
        return this.f86506m.canPageUp();
    }

    public void I2(List<FeedCloudMeta$StFeed> list) {
        ArrayList<e30.b> Q2 = Q2(list);
        this.f86506m.setStringAttachInfo(null);
        if (Q2 != null && Q2.size() > 0) {
            this.C.addAll(Q2);
            this.D.postValue(UIStateData.obtainSuccess(false).setData(false, this.C).setFinish(true));
        }
    }

    public void J2(boolean z16, String str, long j3, String str2, String str3, String str4) {
        int i3;
        FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum = new FeedCloudMeta$FeedAlbum();
        feedCloudMeta$FeedAlbum.f398441id.set(j3);
        feedCloudMeta$FeedAlbum.owner.f398463id.set(str);
        feedCloudMeta$FeedAlbum.title.set(str2);
        feedCloudMeta$FeedAlbum.description.set(str3);
        feedCloudMeta$FeedAlbum.cover_url.set(str4);
        PBEnumField pBEnumField = feedCloudMeta$FeedAlbum.status;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        pBEnumField.set(i3);
        if (this.G.getValue() != null) {
            feedCloudMeta$FeedAlbum.collection_info.set(this.G.getValue().album.collection_info.get());
        }
        QQCircleFeedBase$AlbumPageData qQCircleFeedBase$AlbumPageData = new QQCircleFeedBase$AlbumPageData();
        qQCircleFeedBase$AlbumPageData.album.set(feedCloudMeta$FeedAlbum);
        if (this.G.getValue() != null) {
            qQCircleFeedBase$AlbumPageData.subsidiary_field_desc.set(this.G.getValue().subsidiary_field_desc.get());
        }
        this.G.setValue(qQCircleFeedBase$AlbumPageData);
    }

    public void K2(List<FeedCloudMeta$StFeed> list) {
        ArrayList<e30.b> Q2 = Q2(list);
        this.f86506m.setStringAttachInfo(null);
        this.C.clear();
        if (Q2 != null && Q2.size() > 0) {
            this.C.addAll(Q2);
            this.D.postValue(UIStateData.obtainSuccess(false).setData(false, this.C).setFinish(true));
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new QFSAlbumProductListCleanEvent());
            this.D.postValue(UIStateData.obtainEmpty().setDataList(this.C).setLoadMore(false).setFinish(true));
        }
    }

    public void L2() {
        this.I.setValue(Boolean.TRUE);
        QCircleGetFeedListAlbumRequest qCircleGetFeedListAlbumRequest = new QCircleGetFeedListAlbumRequest(this.E, P2(2), 2);
        qCircleGetFeedListAlbumRequest.setEnableCache(true);
        VSNetworkHelper.getInstance().sendRequest(qCircleGetFeedListAlbumRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.g
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSLayerAlbumViewModel.this.b3(baseRequest, z16, j3, str, (FeedCloudRead$StGetFeedListRsp) obj);
            }
        });
    }

    public List<e30.b> N2() {
        return this.C;
    }

    public MutableLiveData<QQCircleFeedBase$AlbumPageData> O2() {
        return this.G;
    }

    public QCircleAlbumBean R2() {
        return this.E;
    }

    public MutableLiveData<Boolean> S2() {
        return this.H;
    }

    public MutableLiveData<Boolean> T2() {
        return this.I;
    }

    public void W2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Y2(feedCloudMeta$StFeed, false);
    }

    public void Y2(final FeedCloudMeta$StFeed feedCloudMeta$StFeed, final boolean z16) {
        QLog.d("QFSAlbumViewModel", 1, "handlePreparedData ");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                if (z16) {
                    ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).C.clear();
                }
                ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).C.addAll(QFSLayerAlbumViewModel.this.Q2(Collections.singletonList(feedCloudMeta$StFeed)));
                UIStateData finish = UIStateData.obtainSuccess(false).setFinish(true);
                finish.setData(false, ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).C);
                ((QFSLayerBaseViewModel) QFSLayerAlbumViewModel.this).D.postValue(finish);
            }
        });
    }

    public void f3(boolean z16, final a aVar) {
        MutableLiveData<QQCircleFeedBase$AlbumPageData> mutableLiveData = this.G;
        if (mutableLiveData != null && mutableLiveData.getValue() != null) {
            QQCircleFeedBase$AlbumPageData value = this.G.getValue();
            int i3 = 1;
            QLog.i("QFSAlbumViewModel", 1, "requestCollect:" + (z16 ? 1 : 0));
            QFSDoCollectRequest.a aVar2 = new QFSDoCollectRequest.a(value.album);
            if (z16) {
                i3 = 0;
            }
            final QFSDoCollectRequest a16 = aVar2.f(i3).a();
            BaseCall<QCircleBaseRequest> addInterceptor = com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(a16).addInterceptor(new com.tencent.biz.qqcircle.immersive.personal.interceptor.a());
            final int i16 = z16 ? 1 : 0;
            addInterceptor.m250setRspOnCallBack(new Call.OnRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.i
                @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
                public final void onReceive(boolean z17, long j3, String str, Object obj, Object obj2, Bundle bundle) {
                    QFSLayerAlbumViewModel.this.c3(a16, i16, aVar, z17, j3, str, obj, obj2, bundle);
                }
            }).execute();
        }
    }

    public void g3(QQCircleFeedAlbum$AlbumInfo qQCircleFeedAlbum$AlbumInfo, List<FeedCloudMeta$StFeed> list, boolean z16, final b bVar) {
        VSNetworkHelper.getInstance().sendRequest(new QFSCreateAlbumReq(qQCircleFeedAlbum$AlbumInfo, list, z16), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.h
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                QFSLayerAlbumViewModel.this.d3(bVar, baseRequest, z17, j3, str, (QQCircleFeedAlbum$CreateAlbumRsp) obj);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QFSAlbumViewModel";
    }

    public void h3(int i3) {
        i3(i3, false);
    }

    public void i3(final int i3, final boolean z16) {
        QLog.e("QFSAlbumViewModel", 1, "requestData, action: " + i3 + ", withPreparedData: " + z16);
        if (i3 == 0 && this.I.getValue() != null && this.I.getValue().booleanValue()) {
            QLog.d("QFSAlbumViewModel", 4, "is in fake write refreshing, ban to load more");
            return;
        }
        this.f86506m.setCurLoadMoreAction(i3);
        String P2 = P2(i3);
        QCircleGetFeedListAlbumRequest qCircleGetFeedListAlbumRequest = new QCircleGetFeedListAlbumRequest(this.E, P2, i3);
        if (!z16) {
            UIStateData<List<e30.b>> obtainLoading = UIStateData.obtainLoading();
            obtainLoading.setLoadMore(true ^ TextUtils.isEmpty(P2));
            this.D.postValue(obtainLoading);
        }
        qCircleGetFeedListAlbumRequest.setEnableCache(TextUtils.isEmpty(P2));
        VSNetworkHelper.getInstance().sendRequest(qCircleGetFeedListAlbumRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.f
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                QFSLayerAlbumViewModel.this.e3(i3, z16, baseRequest, z17, j3, str, (FeedCloudRead$StGetFeedListRsp) obj);
            }
        });
    }

    public void j3(String str) {
        this.F = str;
    }

    public void k3(QCircleAlbumBean qCircleAlbumBean) {
        this.E = qCircleAlbumBean;
    }

    public void l3(QQCircleFeedBase$AlbumPageData qQCircleFeedBase$AlbumPageData) {
        if (qQCircleFeedBase$AlbumPageData == null) {
            return;
        }
        try {
            if (qQCircleFeedBase$AlbumPageData.album.f398441id.get() == this.G.getValue().album.f398441id.get()) {
                this.G.setValue(qQCircleFeedBase$AlbumPageData);
            }
        } catch (Exception e16) {
            QLog.e("QFSAlbumViewModel", 1, "updateData error", e16);
        }
    }
}
