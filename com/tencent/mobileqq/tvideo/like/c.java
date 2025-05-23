package com.tencent.mobileqq.tvideo.like;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import tvideo.TVideoLike$UserAttitudeOptionRequest;
import tvideo.TVideoLike$UserAttitudeOptionResponse;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends com.tencent.biz.qqcircle.viewmodels.a {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<TVideoLike$UserAttitudeOptionResponse> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, TVideoLike$UserAttitudeOptionResponse tVideoLike$UserAttitudeOptionResponse) {
            QLog.d("TVideoLikePublishViewModel", 4, "requestLike isSuccess = " + z16 + " errMsg = " + str);
            if (tVideoLike$UserAttitudeOptionResponse != null && tVideoLike$UserAttitudeOptionResponse.data != null) {
                QLog.d("TVideoLikePublishViewModel", 4, "requestLike rsp = " + tVideoLike$UserAttitudeOptionResponse.data.attitude_counts.get());
            }
        }
    }

    public void L1(TVideoLike$UserAttitudeOptionRequest tVideoLike$UserAttitudeOptionRequest) {
        if (tVideoLike$UserAttitudeOptionRequest == null) {
            return;
        }
        QLog.d("TVideoLikePublishViewModel", 4, "requestLike cid = " + tVideoLike$UserAttitudeOptionRequest.cid.get() + " vid = " + tVideoLike$UserAttitudeOptionRequest.vid.get() + " attitude_option_type = " + tVideoLike$UserAttitudeOptionRequest.attitude_option_type.get() + " play_back_time = " + tVideoLike$UserAttitudeOptionRequest.play_back_time.get() + " extra_params = " + tVideoLike$UserAttitudeOptionRequest.extra_params.get());
        sendRequest(new TVideoLikePublishRequest(tVideoLike$UserAttitudeOptionRequest), new a());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TVideoLikePublishViewModel";
    }
}
