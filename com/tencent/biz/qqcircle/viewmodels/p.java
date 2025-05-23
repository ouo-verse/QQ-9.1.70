package com.tencent.biz.qqcircle.viewmodels;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageBasicDataRequest;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call;
import feedcloud.FeedCloudRead$StGetMainPageBasicDataRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase$StMainPageBasicBusiRspData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class p extends a implements Call.OnRspCallBack<QCircleBaseRequest> {
    private final LiveData<List<Integer>> C;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<List<Integer>> f92874m;

    public p() {
        MutableLiveData<List<Integer>> mutableLiveData = new MutableLiveData<>();
        this.f92874m = mutableLiveData;
        this.C = mutableLiveData;
    }

    private void M1(FeedCloudRead$StGetMainPageBasicDataRsp feedCloudRead$StGetMainPageBasicDataRsp) {
        byte[] byteArray = feedCloudRead$StGetMainPageBasicDataRsp.busiRspData.get().toByteArray();
        QQCircleFeedBase$StMainPageBasicBusiRspData qQCircleFeedBase$StMainPageBasicBusiRspData = new QQCircleFeedBase$StMainPageBasicBusiRspData();
        try {
            qQCircleFeedBase$StMainPageBasicBusiRspData.mergeFrom(byteArray);
        } catch (Exception e16) {
            QLog.e("QFSNoticeSettingViewModel", 1, "mergeFrom StMainPageBusiRspData error. " + e16);
        }
        this.f92874m.postValue(qQCircleFeedBase$StMainPageBasicBusiRspData.opMask.get());
    }

    public LiveData<List<Integer>> L1() {
        return this.C;
    }

    @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
    /* renamed from: N1, reason: merged with bridge method [inline-methods] */
    public void onReceive(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, Bundle bundle) {
        QLog.d("QFSNoticeSettingViewModel", 1, "[onReceive] -> request = " + qCircleBaseRequest + " , traceId : " + qCircleBaseRequest.getTraceId() + " , isSuccess : " + z16 + " , retCode : " + j3 + " , errMsg : " + str + " , ownerUin : " + HostDataTransUtils.getAccount() + " , isCache : " + VSNetworkHelper.isProtocolCache(str));
        if ((qCircleBaseRequest instanceof QFSGetMainPageBasicDataRequest) && z16 && j3 == 0 && (obj instanceof FeedCloudRead$StGetMainPageBasicDataRsp)) {
            M1((FeedCloudRead$StGetMainPageBasicDataRsp) obj);
        }
    }

    public void O1(int i3) {
        com.tencent.biz.qqcircle.immersive.personal.request.b.p(HostDataTransUtils.getAccount(), this, i3, true);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSNoticeSettingViewModel";
    }
}
