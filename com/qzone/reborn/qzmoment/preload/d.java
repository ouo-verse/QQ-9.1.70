package com.qzone.reborn.qzmoment.preload;

import com.qzone.reborn.qzmoment.request.QZMGetFeedSharePanelRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentReader$StGetFeedSharePanelRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d extends BasePreLoadTask {

    /* renamed from: a, reason: collision with root package name */
    private final QZMomentMeta$StFeed f59002a;

    public d(QZMomentMeta$StFeed qZMomentMeta$StFeed) {
        this.f59002a = qZMomentMeta$StFeed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(OnPreLoadListener onPreLoadListener, BaseRequest baseRequest, boolean z16, long j3, String str, QZMomentReader$StGetFeedSharePanelRsp qZMomentReader$StGetFeedSharePanelRsp) {
        QLog.d("QZMGetFeedShareLoaderTask", 1, "QZMGetFeedShareLoaderTask->onReceive: dispatch Success:" + z16 + " | CmdName:" + baseRequest.getCmdName() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        if (onPreLoadListener == null || qZMomentReader$StGetFeedSharePanelRsp == null) {
            return;
        }
        onPreLoadListener.onLoaded(Boolean.valueOf(z16), Long.valueOf(j3), str, qZMomentReader$StGetFeedSharePanelRsp);
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(final OnPreLoadListener onPreLoadListener) {
        QZMGetFeedSharePanelRequest qZMGetFeedSharePanelRequest = new QZMGetFeedSharePanelRequest(this.f59002a);
        VSNetworkHelper.getInstance().sendRequest(qZMGetFeedSharePanelRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.qzmoment.preload.c
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                d.b(OnPreLoadListener.this, baseRequest, z16, j3, str, (QZMomentReader$StGetFeedSharePanelRsp) obj);
            }
        });
        QLog.d("QZMGetFeedShareLoaderTask", 1, "QZMGetFeedShareLoaderTaskprefetch: CmdName:" + qZMGetFeedSharePanelRequest.getCmdName() + "| TraceId:" + qZMGetFeedSharePanelRequest.getTraceId() + " | SeqId:" + qZMGetFeedSharePanelRequest.getCurrentSeq());
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
