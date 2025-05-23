package com.tencent.biz.qqcircle.preload.task;

import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.events.QFSLayerPolymerizeDetailPreloadFinishEvent;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReporterAgent;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;

/* loaded from: classes4.dex */
public class QFSLayerPolymerizeDetailPreloadTask extends BasePreLoadTask {

    /* renamed from: a, reason: collision with root package name */
    private QCirclePolymerizeDetailBean f91606a;

    /* loaded from: classes4.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPreLoadListener f91608a;

        a(OnPreLoadListener onPreLoadListener) {
            this.f91608a = onPreLoadListener;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            QLog.d("QCirclePolymerizationPreLoaderTask", 1, "QCirclePolymerizationPreLoaderTask->onReceive: dispatch Success:" + z16 + " |CmdName:" + baseRequest.getCmd() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            OnPreLoadListener onPreLoadListener = this.f91608a;
            if (onPreLoadListener == null) {
                return;
            }
            onPreLoadListener.onLoaded(Boolean.valueOf(z16), baseRequest, Long.valueOf(j3), str, feedCloudRead$StGetFeedListRsp);
            if (!z16 || j3 != 0) {
                PreLoader.remove("2019");
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSLayerPolymerizeDetailPreloadFinishEvent());
            QFSLayerPolymerizeDetailPreloadTask.this.c(feedCloudRead$StGetFeedListRsp);
        }
    }

    public QFSLayerPolymerizeDetailPreloadTask(QCirclePolymerizeDetailBean qCirclePolymerizeDetailBean) {
        this.f91606a = qCirclePolymerizeDetailBean;
    }

    private void b(final FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.preload.task.QFSLayerPolymerizeDetailPreloadTask.2
            @Override // java.lang.Runnable
            public void run() {
                if (QQVideoPlaySDKManager.isSDKReady()) {
                    RFWPlayerPreRenderHelper.getInstance().playerRender(gb0.b.f(new RFWPlayerPreRenderBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), 10004).setPreloadVideo(gb0.b.k(feedCloudMeta$StFeed.video)).setPreloadOriginData(gb0.b.m(new e30.b(feedCloudMeta$StFeed))).setMultiLevel(true)));
                    QLog.d("QCirclePolymerizationPreLoaderTask", 1, "isSDKReady\uff0cdo preRender!");
                } else {
                    QLog.d("QCirclePolymerizationPreLoaderTask", 1, "isSDKReady not ready, don not preRender!");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp != null && !feedCloudRead$StGetFeedListRsp.vecFeed.isEmpty()) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = feedCloudRead$StGetFeedListRsp.vecFeed.get(0);
            u30.d.d().p(feedCloudMeta$StFeed);
            b(feedCloudMeta$StFeed);
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(OnPreLoadListener onPreLoadListener) {
        if (this.f91606a == null) {
            PreLoader.remove("2019");
            QLog.e("QCirclePolymerizationPreLoaderTask", 1, "polymerizeDetailBean == null");
            return;
        }
        QCircleGetFeedListRequest qCircleGetFeedListRequest = new QCircleGetFeedListRequest(this.f91606a, "", (String) null, true);
        qCircleGetFeedListRequest.mRequest.extInfo.set(QCircleReporterAgent.obtain(57).getSessionCommonExt(true));
        qCircleGetFeedListRequest.setEnableCache(false);
        VSNetworkHelper.getInstance().sendRequest(qCircleGetFeedListRequest, new a(onPreLoadListener));
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
