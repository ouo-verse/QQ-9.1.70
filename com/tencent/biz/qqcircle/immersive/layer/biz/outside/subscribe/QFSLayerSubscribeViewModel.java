package com.tencent.biz.qqcircle.immersive.layer.biz.outside.subscribe;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetSubscribeFeedsRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerSubscribeViewModel extends com.tencent.biz.qqcircle.immersive.layer.base.e {
    private QCircleInitBean K;

    /* JADX INFO: Access modifiers changed from: private */
    public void r2(boolean z16, long j3, String str, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        boolean z17;
        if (z16 && feedCloudRead$StGetFeedListRsp != null) {
            final boolean z18 = !TextUtils.isEmpty(this.f86506m.getStringAttachInfo());
            QLog.d("QFSLayerSubscribeViewModel", 1, "[handleFeedListResponse] attachInfo: " + feedCloudRead$StGetFeedListRsp.feedAttchInfo.get());
            this.f86506m.setStringAttachInfo(feedCloudRead$StGetFeedListRsp.feedAttchInfo.get());
            this.f86506m.setAdAttachInfo(feedCloudRead$StGetFeedListRsp.adAttchInfo.get());
            LoadInfo loadInfo = this.f86506m;
            if (feedCloudRead$StGetFeedListRsp.isFinish.get() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            loadInfo.setFinish(z17);
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
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.subscribe.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSLayerSubscribeViewModel.this.t2(z18, feedCloudRead$StGetFeedListRsp);
                    }
                });
            }
            U1(str, feedCloudRead$StGetFeedListRsp.isFirstLogin.get(), this.K);
        }
        this.f86506m.setCurrentState(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s2(List list, int i3) {
        k2(false, list, false, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2(boolean z16, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        boolean z17;
        List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetFeedListRsp.vecFeed.get();
        if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        k2(z16, list, z17, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u2(BaseRequest baseRequest, final boolean z16, final long j3, final String str, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        S1(z16, baseRequest, j3, str, "requestSubscribeFeedList");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.subscribe.QFSLayerSubscribeViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                QFSLayerSubscribeViewModel.this.r2(z16, j3, str, feedCloudRead$StGetFeedListRsp);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.e, com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerSubscribeViewModel";
    }

    public void q2(final List<FeedCloudMeta$StFeed> list, QCircleInitBean qCircleInitBean, final int i3) {
        if (qCircleInitBean == null) {
            QLog.d("QFSLayerSubscribeViewModel", 1, "[addFeeds] bean is null. ");
            return;
        }
        this.K = qCircleInitBean;
        HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
        if (schemeAttrs != null) {
            U1("", "1".equals(schemeAttrs.get(QCircleSchemeAttr.Detail.IS_FIRST_LOGIN)), this.K);
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.subscribe.h
            @Override // java.lang.Runnable
            public final void run() {
                QFSLayerSubscribeViewModel.this.s2(list, i3);
            }
        });
    }

    public void v2(int i3) {
        QCircleGetSubscribeFeedsRequest qCircleGetSubscribeFeedsRequest = new QCircleGetSubscribeFeedsRequest(i3, this.f86506m.getStringAttachInfo());
        qCircleGetSubscribeFeedsRequest.mRequest.extInfo.set(getSession(false));
        qCircleGetSubscribeFeedsRequest.setEnableCache(false);
        VSNetworkHelper.getInstance().sendRequest(qCircleGetSubscribeFeedsRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.subscribe.f
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSLayerSubscribeViewModel.this.u2(baseRequest, z16, j3, str, (FeedCloudRead$StGetFeedListRsp) obj);
            }
        });
    }
}
