package com.tencent.biz.qqcircle.immersive.layer.biz.outside.search;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.request.QFSGetSearchPageRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetSearchPageRsp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerSearchViewModel extends com.tencent.biz.qqcircle.immersive.layer.base.e {
    /* JADX INFO: Access modifiers changed from: private */
    public void o2(boolean z16, long j3, String str, FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        boolean z17;
        if (z16 && feedCloudRead$StGetSearchPageRsp != null) {
            boolean z18 = true;
            boolean z19 = !TextUtils.isEmpty(this.f86506m.getStringAttachInfo());
            QLog.d("QFSLayerSearchViewModel", 1, "[handleFeedListResponse] attachInfo: " + feedCloudRead$StGetSearchPageRsp.searchFeedInfo.attachInfo.get());
            this.f86506m.setStringAttachInfo(feedCloudRead$StGetSearchPageRsp.searchFeedInfo.attachInfo.get());
            LoadInfo loadInfo = this.f86506m;
            if (feedCloudRead$StGetSearchPageRsp.searchFeedInfo.isOver.get() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            loadInfo.setFinish(z17);
            if (j3 != 0) {
                this.D.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(false));
            } else {
                List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetSearchPageRsp.searchFeedInfo.feedList.get();
                if (feedCloudRead$StGetSearchPageRsp.searchFeedInfo.isOver.get() <= 0) {
                    z18 = false;
                }
                k2(z19, list, z18, 0);
            }
            U1(str, feedCloudRead$StGetSearchPageRsp.isFirstLogin.get(), null);
        }
        this.f86506m.setCurrentState(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p2(BaseRequest baseRequest, final boolean z16, final long j3, final String str, final FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        S1(z16, baseRequest, j3, str, "requestGetSearchFeedList");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.search.QFSLayerSearchViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                QFSLayerSearchViewModel.this.o2(z16, j3, str, feedCloudRead$StGetSearchPageRsp);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.e, com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerSearchViewModel";
    }

    public void q2(String str) {
        QFSGetSearchPageRequest a16 = new QFSGetSearchPageRequest.a(str).h(this.f86506m.getStringAttachInfo()).a();
        a16.setEnableCache(false);
        VSNetworkHelper.getInstance().sendRequest(a16, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.search.e
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                QFSLayerSearchViewModel.this.p2(baseRequest, z16, j3, str2, (FeedCloudRead$StGetSearchPageRsp) obj);
            }
        });
    }
}
