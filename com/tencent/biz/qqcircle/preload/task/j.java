package com.tencent.biz.qqcircle.preload.task;

import android.app.Activity;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListTagChallengeRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j extends BasePreLoadTask {

    /* renamed from: a, reason: collision with root package name */
    private QCircleLayerBean f91638a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f91639b;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPreLoadListener f91640a;

        a(OnPreLoadListener onPreLoadListener) {
            this.f91640a = onPreLoadListener;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            QLog.d("QFSTagChallengePreLoaderTask", 1, "[requestGetFeedListTagChallengeRequest] onReceive: dispatch Success:" + z16 + " |CmdName:" + baseRequest.getCmd() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            if (feedCloudRead$StGetFeedListRsp != null && feedCloudRead$StGetFeedListRsp.vecFeed.get().size() > 0) {
                j.this.b(new e30.b(feedCloudRead$StGetFeedListRsp.vecFeed.get(0)));
            }
            OnPreLoadListener onPreLoadListener = this.f91640a;
            if (onPreLoadListener != null) {
                onPreLoadListener.onLoaded(baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, feedCloudRead$StGetFeedListRsp);
            }
        }
    }

    public j(QCircleLayerBean qCircleLayerBean, Activity activity) {
        this.f91638a = qCircleLayerBean;
        this.f91639b = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e30.b bVar) {
        if (!o.U0()) {
            return;
        }
        RFWPlayerPreRenderHelper.getInstance().playerRender(gb0.b.f(new RFWPlayerPreRenderBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), 10012).setIsJumpTrigger(o.U0()).setPreloadVideo(gb0.b.k(bVar.g().video)).setPreloadOriginData(gb0.b.m(bVar)).setMultiLevel(true).setActivity(this.f91639b)));
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(OnPreLoadListener onPreLoadListener) {
        if (this.f91638a == null) {
            return;
        }
        QCircleGetFeedListTagChallengeRequest qCircleGetFeedListTagChallengeRequest = new QCircleGetFeedListTagChallengeRequest(this.f91638a, null, 1);
        qCircleGetFeedListTagChallengeRequest.setEnableCache(true);
        VSNetworkHelper.getInstance().sendRequest(qCircleGetFeedListTagChallengeRequest, new a(onPreLoadListener));
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
