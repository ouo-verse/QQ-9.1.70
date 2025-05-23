package com.tencent.biz.qqcircle.preload.task;

import circlesearch.CircleSearchExhibition$StPromptResp;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.immersive.request.search.QFSGetSearchPromptRequest;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h extends BasePreLoadTask {

    /* renamed from: a, reason: collision with root package name */
    private QFSSearchBean f91630a;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<CircleSearchExhibition$StPromptResp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPreLoadListener f91631a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QFSGetSearchPromptRequest f91632b;

        a(OnPreLoadListener onPreLoadListener, QFSGetSearchPromptRequest qFSGetSearchPromptRequest) {
            this.f91631a = onPreLoadListener;
            this.f91632b = qFSGetSearchPromptRequest;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CircleSearchExhibition$StPromptResp circleSearchExhibition$StPromptResp) {
            QLog.d("QFSSearchPreLoaderTask", 1, "[requestSearchPrompt] onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            OnPreLoadListener onPreLoadListener = this.f91631a;
            if (onPreLoadListener != null) {
                onPreLoadListener.onLoaded(Boolean.valueOf(z16), Long.valueOf(j3), str, circleSearchExhibition$StPromptResp);
            }
            this.f91632b.addReportExtraData("isPreload", "true").addSearchPromptRspExtraData(circleSearchExhibition$StPromptResp, z16, j3).reportCmdSuccessRate(j3, str);
        }
    }

    public h(QFSSearchBean qFSSearchBean) {
        this.f91630a = qFSSearchBean;
    }

    private FeedCloudCommon$StCommonExt a() {
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
        if (QFSVideoView.L0() != null) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("current_video_id");
            feedCloudCommon$Entry.value.set(QFSVideoView.L0());
            feedCloudCommon$StCommonExt.mapInfo.get().add(feedCloudCommon$Entry);
        }
        return feedCloudCommon$StCommonExt;
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(OnPreLoadListener onPreLoadListener) {
        if (this.f91630a == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!h60.a.e()) {
            arrayList.add(1);
        }
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        QFSGetSearchPromptRequest b16 = new QFSGetSearchPromptRequest.a().g(arrayList).f(a()).b();
        VSNetworkHelper.getInstance().sendRequest(b16, new a(onPreLoadListener, b16));
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
