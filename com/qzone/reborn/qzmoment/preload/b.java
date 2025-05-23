package com.qzone.reborn.qzmoment.preload;

import com.qzone.reborn.qzmoment.request.QZMGetFriendFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import qzonemoment.QZMomentReader$StGetFeedListRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b extends BasePreLoadTask {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(OnPreLoadListener onPreLoadListener, BaseRequest baseRequest, boolean z16, long j3, String str, QZMomentReader$StGetFeedListRsp qZMomentReader$StGetFeedListRsp) {
        QLog.d("QZMFolderPreLoaderTask", 1, "QZMFolderPreLoaderTask->onReceive: dispatch Success:" + z16 + " | CmdName:" + baseRequest.get$cmd() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        if (onPreLoadListener == null || qZMomentReader$StGetFeedListRsp == null) {
            return;
        }
        onPreLoadListener.onLoaded(Boolean.valueOf(z16), Long.valueOf(j3), str, qZMomentReader$StGetFeedListRsp);
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(final OnPreLoadListener onPreLoadListener) {
        QZMGetFriendFeedListRequest qZMGetFriendFeedListRequest = new QZMGetFriendFeedListRequest(null, null);
        VSNetworkHelper.getInstance().sendRequest(qZMGetFriendFeedListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.qzmoment.preload.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                b.b(OnPreLoadListener.this, baseRequest, z16, j3, str, (QZMomentReader$StGetFeedListRsp) obj);
            }
        });
        QLog.d("QZMFolderPreLoaderTask", 1, "QZMFolderPreLoaderTaskprefetch: CmdName:" + qZMGetFriendFeedListRequest.get$cmd() + "| TraceId:" + qZMGetFriendFeedListRequest.getTraceId() + " | SeqId:" + qZMGetFriendFeedListRequest.getCurrentSeq());
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
