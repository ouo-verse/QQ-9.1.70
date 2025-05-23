package e70;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.personal.interceptor.d;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.rerank.request.QFSRankEdgeGetDetailsReq;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StBatchGetFeedDetailRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends com.tencent.biz.qqcircle.viewmodels.a implements IDataDisplaySurface<e30.b>, Call.OnRspCallBack<QCircleBaseRequest> {
    private d D;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<QQCircleDitto$StItemInfo> f395826m = new ArrayList<>();
    private int C = 0;
    private final HashMap<String, List<e30.b>> E = new HashMap<>();
    private final HashMap<String, d> F = new HashMap<>();
    private final MutableLiveData<UIStateData<List<e30.b>>> G = new MutableLiveData<>();
    private final MutableLiveData<QQCircleDitto$StItemInfo> H = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R1(boolean z16, QFSRankEdgeGetDetailsReq qFSRankEdgeGetDetailsReq, long j3, String str, FeedCloudRead$StBatchGetFeedDetailRsp feedCloudRead$StBatchGetFeedDetailRsp, String str2) {
        ArrayList<e30.b> arrayList;
        QLog.d("QFSLayerHotTagViewModel", 1, "requestDetail onReceive: dispatch result:" + z16 + " | TraceId:" + qFSRankEdgeGetDetailsReq.getTraceId() + " | SeqId:" + qFSRankEdgeGetDetailsReq.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        if (z16 && j3 == 0 && feedCloudRead$StBatchGetFeedDetailRsp != null) {
            PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField = feedCloudRead$StBatchGetFeedDetailRsp.feeds;
            if (pBRepeatMessageField != null) {
                arrayList = e30.d.b(pBRepeatMessageField.get());
            } else {
                arrayList = new ArrayList<>();
            }
            this.E.put(str2, arrayList);
            QQCircleDitto$StItemInfo value = this.H.getValue();
            if (value != null && TextUtils.equals(value.name.get(), str2)) {
                this.G.postValue(UIStateData.obtainSuccess(false).setData(false, arrayList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S1(final QFSRankEdgeGetDetailsReq qFSRankEdgeGetDetailsReq, final String str, BaseRequest baseRequest, final boolean z16, final long j3, final String str2, final FeedCloudRead$StBatchGetFeedDetailRsp feedCloudRead$StBatchGetFeedDetailRsp) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: e70.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.R1(z16, qFSRankEdgeGetDetailsReq, j3, str2, feedCloudRead$StBatchGetFeedDetailRsp, str);
            }
        });
    }

    private void T1(boolean z16) {
        QQCircleDitto$StItemInfo value = this.H.getValue();
        if (value == null) {
            return;
        }
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().j(this.D).i(z16).addRequest(new QFSGetFeedListRequest.b().k(7).l(value.name.get()).a()).m250setRspOnCallBack((Call.OnRspCallBack) this).execute();
    }

    private void X1(final String str, List<FeedCloudMeta$StFeed> list) {
        final QFSRankEdgeGetDetailsReq qFSRankEdgeGetDetailsReq = new QFSRankEdgeGetDetailsReq(list);
        VSNetworkHelper.getInstance().sendRequest(qFSRankEdgeGetDetailsReq, new VSDispatchObserver.OnVSRspCallBack() { // from class: e70.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                c.this.S1(qFSRankEdgeGetDetailsReq, str, baseRequest, z16, j3, str2, (FeedCloudRead$StBatchGetFeedDetailRsp) obj);
            }
        });
    }

    public MutableLiveData<QQCircleDitto$StItemInfo> N1() {
        return this.H;
    }

    public MutableLiveData<UIStateData<List<e30.b>>> O1() {
        return this.G;
    }

    public String P1() {
        return hashCode() + "";
    }

    public void Q1(List<QQCircleDitto$StItemInfo> list) {
        if (list != null && !list.isEmpty()) {
            this.f395826m.clear();
            this.f395826m.addAll(list);
            this.C = 0;
            this.D = null;
            this.E.clear();
            this.F.clear();
            this.G.setValue(null);
            this.H.setValue(null);
            Z1();
        }
    }

    public void U1() {
        int i3 = this.C + 1;
        this.C = i3;
        if (i3 >= this.f395826m.size()) {
            this.C = 0;
        }
        Z1();
    }

    @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
    /* renamed from: W1, reason: merged with bridge method [inline-methods] */
    public void onReceive(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, Bundle bundle) {
        QLog.d("QFSLayerHotTagViewModel", 1, "[onReceive] -> request = " + qCircleBaseRequest + " , traceId : " + qCircleBaseRequest.getTraceId() + " , isSuccess : " + z16 + " , retCode : " + j3 + " , errMsg : " + str + " , isCache : " + VSNetworkHelper.isProtocolCache(str));
        if (z16 && j3 == 0 && obj != null && (obj instanceof UIStateData)) {
            UIStateData<List<e30.b>> uIStateData = (UIStateData) obj;
            if (!uIStateData.getIsLoadMore()) {
                if (this.H.getValue() == null) {
                    return;
                }
                List<e30.b> K0 = r.K0(this.E.get(this.H.getValue().name.get()), uIStateData.getData());
                this.D.f().clear();
                this.D.f().addAll(K0);
                uIStateData.setData(uIStateData.isCacheData(), K0);
            }
            this.G.postValue(uIStateData);
        }
    }

    public void Z1() {
        int size = this.f395826m.size();
        int i3 = this.C;
        if (size <= i3) {
            return;
        }
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.f395826m.get(i3);
        this.H.setValue(qQCircleDitto$StItemInfo);
        String str = qQCircleDitto$StItemInfo.name.get();
        d dVar = this.F.get(str);
        if (dVar == null) {
            d dVar2 = new d();
            this.D = dVar2;
            this.F.put(str, dVar2);
        } else {
            this.D = dVar;
        }
        List<e30.b> list = this.E.get(str);
        if (list == null) {
            X1(str, qQCircleDitto$StItemInfo.feeds.get());
            return;
        }
        if (this.D.f().size() > 0) {
            list = this.D.f();
        }
        this.G.postValue(UIStateData.obtainSuccess(false).setData(false, list));
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        return this.G;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerHotTagViewModel";
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        boolean z16;
        d dVar = this.D;
        if (dVar == null) {
            return;
        }
        if (dVar.f().size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        T1(z16);
    }
}
