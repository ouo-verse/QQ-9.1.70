package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetLightInteractRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLightInteractInfo;
import feedcloud.FeedCloudRead$StGetLightInteractListRsp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends com.tencent.biz.qqcircle.viewmodels.a {
    public static String D = "QCircleLightInteractViewModel";

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<UIStateData<List<FeedCloudMeta$StLightInteractInfo>>> f92840m = new MutableLiveData<>();
    private String C = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetLightInteractListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f92841a;

        a(boolean z16) {
            this.f92841a = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetLightInteractListRsp feedCloudRead$StGetLightInteractListRsp) {
            boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
            QLog.d(b.D, 1, "requestPolyList onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isCache:" + isProtocolCache);
            b.this.M1(z16, j3, this.f92841a, str, feedCloudRead$StGetLightInteractListRsp);
        }
    }

    public MutableLiveData<UIStateData<List<FeedCloudMeta$StLightInteractInfo>>> L1() {
        return this.f92840m;
    }

    public void M1(boolean z16, long j3, boolean z17, String str, FeedCloudRead$StGetLightInteractListRsp feedCloudRead$StGetLightInteractListRsp) {
        boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
        if (z16 && j3 == 0 && feedCloudRead$StGetLightInteractListRsp != null) {
            this.C = feedCloudRead$StGetLightInteractListRsp.attachInfo.get();
            List<FeedCloudMeta$StLightInteractInfo> list = feedCloudRead$StGetLightInteractListRsp.listInfo.get();
            if (list.size() > 0) {
                MutableLiveData<UIStateData<List<FeedCloudMeta$StLightInteractInfo>>> mutableLiveData = this.f92840m;
                UIStateData data = UIStateData.obtainSuccess(isProtocolCache).setData(z17, list);
                boolean z18 = true;
                if (feedCloudRead$StGetLightInteractListRsp.isFinish.get() != 1) {
                    z18 = false;
                }
                mutableLiveData.setValue(data.setFinish(z18));
                return;
            }
            this.f92840m.setValue(UIStateData.obtainEmpty().setLoadMore(z17));
            return;
        }
        this.f92840m.setValue(UIStateData.obtainError(str).setLoadMore(z17));
    }

    public void N1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16, boolean z17, int i3, String str) {
        if (!z16) {
            this.C = "";
        }
        QCircleGetLightInteractRequest qCircleGetLightInteractRequest = new QCircleGetLightInteractRequest(feedCloudMeta$StFeed, this.C, i3, str);
        qCircleGetLightInteractRequest.setEnableCache(z17);
        this.f92840m.setValue(UIStateData.obtainLoading());
        sendRequest(qCircleGetLightInteractRequest, new a(z16));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return D;
    }
}
