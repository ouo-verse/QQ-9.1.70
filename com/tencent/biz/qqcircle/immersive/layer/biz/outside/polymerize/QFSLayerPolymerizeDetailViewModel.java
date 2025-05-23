package com.tencent.biz.qqcircle.immersive.layer.biz.outside.polymerize;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
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
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* loaded from: classes4.dex */
public class QFSLayerPolymerizeDetailViewModel extends com.tencent.biz.qqcircle.immersive.layer.base.e {
    private QCirclePolymerizeDetailBean K;

    /* JADX INFO: Access modifiers changed from: private */
    public void p2(boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, boolean z17) {
        boolean z18;
        boolean z19;
        if (z16 && feedCloudRead$StGetFeedListRsp != null) {
            boolean z26 = true;
            if (TextUtils.isEmpty(this.f86506m.getStringAttachInfo()) && !z17) {
                z18 = false;
            } else {
                z18 = true;
            }
            QLog.d("QFSLayerPolymerizeDetailViewModel", 1, "[handleFeedListResponse] attachInfo: " + feedCloudRead$StGetFeedListRsp.feedAttchInfo.get());
            this.f86506m.setStringAttachInfo(feedCloudRead$StGetFeedListRsp.feedAttchInfo.get());
            this.f86506m.setAdAttachInfo(feedCloudRead$StGetFeedListRsp.adAttchInfo.get());
            LoadInfo loadInfo = this.f86506m;
            if (feedCloudRead$StGetFeedListRsp.isFinish.get() == 1) {
                z19 = true;
            } else {
                z19 = false;
            }
            loadInfo.setFinish(z19);
            if (feedCloudRead$StGetFeedListRsp.extInfo.has()) {
                updateSession(feedCloudRead$StGetFeedListRsp.extInfo.get());
            }
            QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
            if (feedCloudRead$StGetFeedListRsp.busiRspData.has()) {
                try {
                    qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
            }
            if (j3 != 0) {
                this.D.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(false));
            } else {
                j2(qQCircleFeedBase$StFeedListBusiRspData.middlePageData);
                w20.a.j().initOrUpdateGlobalState((List) e30.d.b(feedCloudRead$StGetFeedListRsp.vecFeed.get()), true);
                List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetFeedListRsp.vecFeed.get();
                if (feedCloudRead$StGetFeedListRsp.isFinish.get() <= 0) {
                    z26 = false;
                }
                k2(z18, list, z26, 0);
            }
            U1(str, feedCloudRead$StGetFeedListRsp.isFirstLogin.get(), this.K);
        }
        this.f86506m.setCurrentState(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q2(final boolean z16, BaseRequest baseRequest, final boolean z17, final long j3, final String str, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        S1(z17, baseRequest, j3, str, "requestPolymerizeDetailData");
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.polymerize.QFSLayerPolymerizeDetailViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                QFSLayerPolymerizeDetailViewModel.this.p2(z17, j3, str, feedCloudRead$StGetFeedListRsp, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(Object[] objArr) {
        if (objArr != null && objArr.length == 5) {
            Object obj = objArr[0];
            if (obj instanceof Boolean) {
                Object obj2 = objArr[1];
                if (obj2 instanceof QCircleGetFeedListRequest) {
                    Object obj3 = objArr[2];
                    if ((obj3 instanceof Long) && (objArr[3] instanceof String) && (objArr[4] instanceof FeedCloudRead$StGetFeedListRsp)) {
                        final Boolean bool = (Boolean) obj;
                        final long longValue = ((Long) obj3).longValue();
                        final String str = (String) objArr[3];
                        final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = (FeedCloudRead$StGetFeedListRsp) objArr[4];
                        S1(bool.booleanValue(), (QCircleGetFeedListRequest) obj2, longValue, str, "requestPolymerizeDetailData");
                        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.polymerize.QFSLayerPolymerizeDetailViewModel.2
                            @Override // java.lang.Runnable
                            public void run() {
                                QFSLayerPolymerizeDetailViewModel.this.p2(bool.booleanValue(), longValue, str, feedCloudRead$StGetFeedListRsp, false);
                            }
                        });
                    }
                }
            }
        }
    }

    private void t2() {
        PreLoader.addListener("2019", new OnTaskListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.polymerize.f
            @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
            public final void onComplete(Object[] objArr) {
                QFSLayerPolymerizeDetailViewModel.this.r2(objArr);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.e, com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerPolymerizeDetailViewModel";
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        s2(this.K, true, false);
    }

    public void s2(QCirclePolymerizeDetailBean qCirclePolymerizeDetailBean, final boolean z16, boolean z17) {
        if (qCirclePolymerizeDetailBean == null) {
            QLog.e("QFSLayerPolymerizeDetailViewModel", 1, "polymerizeDetailBean == null");
            return;
        }
        this.K = qCirclePolymerizeDetailBean;
        QCircleGetFeedListRequest qCircleGetFeedListRequest = new QCircleGetFeedListRequest(qCirclePolymerizeDetailBean, this.f86506m.getStringAttachInfo(), (String) null, true);
        qCircleGetFeedListRequest.mRequest.extInfo.set(getSession(!z16));
        qCircleGetFeedListRequest.setEnableCache(z17);
        QLog.d("QFSLayerPolymerizeDetailViewModel", 1, "attachInfo : " + this.f86506m.getStringAttachInfo() + " , isLoadMore : " + z16);
        if (PreLoader.exists("2019")) {
            t2();
        } else {
            this.D.setValue(UIStateData.obtainLoading());
            sendRequest(qCircleGetFeedListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.polymerize.e
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z18, long j3, String str, Object obj) {
                    QFSLayerPolymerizeDetailViewModel.this.q2(z16, baseRequest, z18, j3, str, (FeedCloudRead$StGetFeedListRsp) obj);
                }
            });
        }
    }
}
