package com.tencent.biz.qqcircle.immersive.viewmodel.pymk;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSFeedPymkBean;
import com.tencent.biz.qqcircle.immersive.personal.interceptor.f;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QFSGetFeedPymkRequest;
import com.tencent.biz.qqcircle.requests.QFSGetProfileFeedsRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.sender.call.Call;
import e30.b;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUserRecomInfo;
import feedcloud.FeedCloudRead$StGetRecomUserListRsp;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends com.tencent.biz.qqcircle.viewmodels.a implements IDataDisplaySurface<b>, Call.OnRspCallBack<QCircleBaseRequest> {
    private List<FeedCloudCommon$Entry> H;

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<QFSFeedPymkBean> f90269m = new MutableLiveData<>();
    private Queue<QFSFeedPymkBean> C = new ArrayDeque();
    private final MutableLiveData<UIStateData<List<b>>> D = new MutableLiveData<>();
    private f E = new f();
    private String F = "";
    private String G = "";

    private void P1() {
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(new QFSGetFeedPymkRequest(this.F, this.H)).m250setRspOnCallBack((Call.OnRspCallBack) this).execute();
    }

    public QFSFeedPymkBean L1() {
        return this.f90269m.getValue();
    }

    public MutableLiveData<QFSFeedPymkBean> M1() {
        return this.f90269m;
    }

    public void N1() {
        QFSFeedPymkBean L1 = L1();
        if (L1 == null) {
            return;
        }
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().i(true).j(this.E).addRequest(new QFSGetProfileFeedsRequest(L1.getUin())).m250setRspOnCallBack((Call.OnRspCallBack) this).execute();
    }

    @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
    /* renamed from: O1, reason: merged with bridge method [inline-methods] */
    public void onReceive(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, Bundle bundle) {
        QLog.d("QFSFeedPymkViewModel", 1, "[onReceive] -> request = " + qCircleBaseRequest + " , traceId : " + qCircleBaseRequest.getTraceId() + " , isSuccess : " + z16 + " , retCode : " + j3 + " , errMsg : " + str + " , isCache : " + VSNetworkHelper.isProtocolCache(str));
        if (z16 && j3 == 0) {
            if ((qCircleBaseRequest instanceof QFSGetFeedPymkRequest) && (obj instanceof FeedCloudRead$StGetRecomUserListRsp)) {
                FeedCloudRead$StGetRecomUserListRsp feedCloudRead$StGetRecomUserListRsp = (FeedCloudRead$StGetRecomUserListRsp) obj;
                this.F = feedCloudRead$StGetRecomUserListRsp.attachInfo.get();
                Iterator<FeedCloudMeta$StUserRecomInfo> it = feedCloudRead$StGetRecomUserListRsp.userRecoms.get().iterator();
                while (it.hasNext()) {
                    this.C.add(new QFSFeedPymkBean(it.next(), qCircleBaseRequest.getTraceId()));
                }
                return;
            }
            if ((qCircleBaseRequest instanceof QFSGetProfileFeedsRequest) && (obj instanceof UIStateData)) {
                this.D.setValue((UIStateData) obj);
            }
        }
    }

    public void Q1(List<FeedCloudCommon$Entry> list) {
        this.H = list;
    }

    public void R1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, boolean z16) {
        this.F = QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "loadMoreItemAttach");
        this.G = QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "loadMoreFeedAttach");
        this.C.clear();
        P1();
        QFSFeedPymkBean qFSFeedPymkBean = new QFSFeedPymkBean(qQCircleDitto$StItemInfo, ba.d(feedCloudMeta$StFeed));
        qFSFeedPymkBean.setIsFirstData(z16);
        UIStateData<List<b>> obtainSuccess = UIStateData.obtainSuccess(false);
        obtainSuccess.setData(false, qFSFeedPymkBean.getFeedBlockData());
        this.D.setValue(obtainSuccess);
        this.f90269m.setValue(qFSFeedPymkBean);
    }

    public void S1() {
        QFSFeedPymkBean poll = this.C.poll();
        if (this.C.size() < 2) {
            P1();
        }
        if (poll != null) {
            UIStateData<List<b>> obtainSuccess = UIStateData.obtainSuccess(false);
            obtainSuccess.setData(false, poll.getFeedBlockData());
            this.D.setValue(obtainSuccess);
            this.E.f().clear();
            this.E.f().addAll(poll.getFeedBlockData());
            this.E.r(this.G);
        }
        this.f90269m.setValue(poll);
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<b>>> getDisplaySurfaceData(Object... objArr) {
        return this.D;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSFeedPymkViewModel";
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        N1();
    }
}
