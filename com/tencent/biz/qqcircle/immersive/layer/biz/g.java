package com.tencent.biz.qqcircle.immersive.layer.biz;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.PbExtKt;
import com.tencent.biz.qqcircle.immersive.request.QFSGetMiddlePageFeedRequest;
import com.tencent.biz.qqcircle.requests.QFSGetFeedDetailRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReporterAgent;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$StGetFeedDetailRsp;
import feedcloud.FeedCloudRead$StGetFeedListRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends com.tencent.biz.qqcircle.immersive.layer.base.c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedDetailRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPreLoadListener f86535a;

        a(OnPreLoadListener onPreLoadListener) {
            this.f86535a = onPreLoadListener;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedDetailRsp feedCloudRead$StGetFeedDetailRsp) {
            QLog.d("QFSLayerDefaultPreloadTask", 1, "QFSLayerDefaultPreloadTask->onReceive: dispatch Success:" + z16 + " |CmdName:" + baseRequest.getCmd() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            OnPreLoadListener onPreLoadListener = this.f86535a;
            if (onPreLoadListener == null) {
                return;
            }
            onPreLoadListener.onLoaded(Boolean.valueOf(z16), Long.valueOf(j3), str, feedCloudRead$StGetFeedDetailRsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPreLoadListener f86537a;

        b(OnPreLoadListener onPreLoadListener) {
            this.f86537a = onPreLoadListener;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            QLog.d("QFSLayerDefaultPreloadTask", 1, "QFSLayerDefaultPreloadTask->onReceive: dispatch Success:" + z16 + " |CmdName:" + baseRequest.getCmd() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            OnPreLoadListener onPreLoadListener = this.f86537a;
            if (onPreLoadListener == null) {
                return;
            }
            onPreLoadListener.onLoaded(Boolean.valueOf(z16), Long.valueOf(j3), str, feedCloudRead$StGetFeedListRsp);
        }
    }

    private void e(OnPreLoadListener onPreLoadListener) {
        QFSGetMiddlePageFeedRequest qFSGetMiddlePageFeedRequest = new QFSGetMiddlePageFeedRequest(this.f86510a, "", false);
        qFSGetMiddlePageFeedRequest.mRequest.extInfo.set(d(false));
        if (qFSGetMiddlePageFeedRequest.mRequest.source.get() == 63 && this.f86510a.getHotEventInfo() != null) {
            PbExtKt.b(qFSGetMiddlePageFeedRequest.mRequest.extInfo.mapInfo, this.f86510a.getHotEventInfo());
        }
        if (qFSGetMiddlePageFeedRequest.mRequest.source.get() == 90 && this.f86510a.getQQVideoBusinessFeedID() != null) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("qzone_feed_id");
            feedCloudCommon$Entry.value.set(this.f86510a.getQQVideoBusinessFeedID());
            qFSGetMiddlePageFeedRequest.mRequest.extInfo.mapInfo.add(feedCloudCommon$Entry);
        }
        VSNetworkHelper.getInstance().sendRequest(qFSGetMiddlePageFeedRequest, new b(onPreLoadListener));
    }

    private void f(OnPreLoadListener onPreLoadListener) {
        a aVar = new a(onPreLoadListener);
        QFSGetFeedDetailRequest qFSGetFeedDetailRequest = new QFSGetFeedDetailRequest(this.f86510a.getFeed().f398449id.get(), false, 0, this.f86510a.getFeed(), this.f86510a);
        qFSGetFeedDetailRequest.mRequest.extInfo.set(d(true));
        VSNetworkHelper.getInstance().sendRequest(qFSGetFeedDetailRequest, aVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.c
    public String b() {
        return a();
    }

    public FeedCloudCommon$StCommonExt d(boolean z16) {
        return QCircleReporterAgent.obtain(57).getSessionCommonExt(z16);
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(OnPreLoadListener onPreLoadListener) {
        QCircleInitBean qCircleInitBean = this.f86510a;
        if (!(qCircleInitBean instanceof QCircleLayerBean)) {
            return;
        }
        if (((QCircleLayerBean) qCircleInitBean).isGetFeedList()) {
            QLog.d("QFSLayerDefaultPreloadTask", 1, "preloadFeed list");
            e(onPreLoadListener);
        } else {
            QLog.d("QFSLayerDefaultPreloadTask", 1, "preloadSingleFeed");
            f(onPreLoadListener);
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
