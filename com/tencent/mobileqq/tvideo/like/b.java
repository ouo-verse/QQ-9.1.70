package com.tencent.mobileqq.tvideo.like;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import tvideo.TVideoLike$GetAttitudeInfoResponse;
import tvideo.TVideoLike$UserAttitudeOption;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends com.tencent.biz.qqcircle.viewmodels.a {

    /* renamed from: m, reason: collision with root package name */
    public MutableLiveData<TVideoLike$UserAttitudeOption> f304485m = new MutableLiveData<>();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<TVideoLike$GetAttitudeInfoResponse> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, TVideoLike$GetAttitudeInfoResponse tVideoLike$GetAttitudeInfoResponse) {
            QLog.d("TVideoLikeDataViewModel", 4, "requestLikeData isSuccess = " + z16 + " errMsg = " + str + " rsp = " + tVideoLike$GetAttitudeInfoResponse);
            if (tVideoLike$GetAttitudeInfoResponse != null && tVideoLike$GetAttitudeInfoResponse.data != null && z16 && j3 == 0) {
                QLog.d("TVideoLikeDataViewModel", 4, "requestLike rsp counts = " + tVideoLike$GetAttitudeInfoResponse.data.attitude_counts.get());
                b.this.f304485m.setValue(tVideoLike$GetAttitudeInfoResponse.data);
                return;
            }
            b.this.f304485m.setValue(null);
        }
    }

    public void L1(String str) {
        QLog.d("TVideoLikeDataViewModel", 4, "requestLikeData vid = " + str);
        sendRequest(new TVideoLikeDataRequest(str), new a());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TVideoLikeDataViewModel";
    }
}
