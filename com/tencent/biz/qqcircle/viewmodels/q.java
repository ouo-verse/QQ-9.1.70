package com.tencent.biz.qqcircle.viewmodels;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageBasicDataRequest;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.sender.call.Call;
import feedcloud.FeedCloudRead$StGetMainPageBasicDataRsp;
import qqcircle.QQCircleFeedBase$StMainPageBasicBusiRspData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class q extends a implements Call.OnRspCallBack<QCircleBaseRequest> {
    private final LiveData<UIStateData<QQCircleFeedBase$StMainPageBasicBusiRspData>> C;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<UIStateData<QQCircleFeedBase$StMainPageBasicBusiRspData>> f92875m;

    public q() {
        MutableLiveData<UIStateData<QQCircleFeedBase$StMainPageBasicBusiRspData>> mutableLiveData = new MutableLiveData<>();
        this.f92875m = mutableLiveData;
        this.C = mutableLiveData;
    }

    private void M1(FeedCloudRead$StGetMainPageBasicDataRsp feedCloudRead$StGetMainPageBasicDataRsp) {
        byte[] byteArray = feedCloudRead$StGetMainPageBasicDataRsp.busiRspData.get().toByteArray();
        QQCircleFeedBase$StMainPageBasicBusiRspData qQCircleFeedBase$StMainPageBasicBusiRspData = new QQCircleFeedBase$StMainPageBasicBusiRspData();
        try {
            qQCircleFeedBase$StMainPageBasicBusiRspData.mergeFrom(byteArray);
        } catch (Exception e16) {
            QLog.e("QFSPrivacySettingViewModel", 1, "mergeFrom StMainPageBusiRspData error. " + e16);
        }
        this.f92875m.postValue(UIStateData.obtainSuccess(false).setData(false, qQCircleFeedBase$StMainPageBasicBusiRspData));
    }

    public LiveData<UIStateData<QQCircleFeedBase$StMainPageBasicBusiRspData>> L1() {
        return this.C;
    }

    @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
    /* renamed from: N1, reason: merged with bridge method [inline-methods] */
    public void onReceive(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, Bundle bundle) {
        QLog.d("QFSPrivacySettingViewModel", 1, "QOK-[onReceive] -> request = " + qCircleBaseRequest + " , traceId : " + qCircleBaseRequest.getTraceId() + " , isSuccess : " + z16 + " , retCode : " + j3 + " , errMsg : " + str + " , ownerUin : " + HostDataTransUtils.getAccount() + " , isCache : " + VSNetworkHelper.isProtocolCache(str));
        if (qCircleBaseRequest instanceof QFSGetMainPageBasicDataRequest) {
            if (z16 && j3 == 0 && (obj instanceof FeedCloudRead$StGetMainPageBasicDataRsp)) {
                M1((FeedCloudRead$StGetMainPageBasicDataRsp) obj);
            } else {
                this.f92875m.postValue(UIStateData.obtainError(str));
            }
        }
    }

    public void O1(int i3) {
        com.tencent.biz.qqcircle.immersive.personal.request.b.p(HostDataTransUtils.getAccount(), this, i3, true);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPrivacySettingViewModel";
    }
}
