package com.tencent.mobileqq.tvideo.temporaryauth;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import tvideo.TVideoTemporaryAuth$AuthorizePlayData;
import tvideo.TVideoTemporaryAuth$AuthorizePlayResponse;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends com.tencent.biz.qqcircle.viewmodels.a {

    /* renamed from: m, reason: collision with root package name */
    public MutableLiveData<TVideoTemporaryAuth$AuthorizePlayData> f304767m = new MutableLiveData<>();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<TVideoTemporaryAuth$AuthorizePlayResponse> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, TVideoTemporaryAuth$AuthorizePlayResponse tVideoTemporaryAuth$AuthorizePlayResponse) {
            QLog.d("TVideoOpenTemporaryAuthViewModel", 4, "requestOpenTemporaryAuth isSuccess = " + z16 + " errMsg = " + str);
            if (tVideoTemporaryAuth$AuthorizePlayResponse != null) {
                if (tVideoTemporaryAuth$AuthorizePlayResponse.data != null) {
                    QLog.d("TVideoOpenTemporaryAuthViewModel", 4, "requestOpenTemporaryAuth authorize_ret = " + tVideoTemporaryAuth$AuthorizePlayResponse.data.authorize_ret.get() + " vid = " + tVideoTemporaryAuth$AuthorizePlayResponse.data.vid.get() + " count = " + tVideoTemporaryAuth$AuthorizePlayResponse.data.authorize_count.get());
                }
                b.this.f304767m.postValue(tVideoTemporaryAuth$AuthorizePlayResponse.data);
                return;
            }
            b.this.f304767m.postValue(null);
        }
    }

    public void L1(String str, int i3) {
        sendRequest(new TVideoOpenTemporaryAuthRequest(str, i3), new a());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TVideoOpenTemporaryAuthViewModel";
    }
}
