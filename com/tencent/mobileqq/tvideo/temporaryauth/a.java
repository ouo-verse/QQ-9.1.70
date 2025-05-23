package com.tencent.mobileqq.tvideo.temporaryauth;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import tvideo.TVideoTemporaryAuth$AuthorizeTabData;
import tvideo.TVideoTemporaryAuth$CheckAuthorizeTabResponse;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends com.tencent.biz.qqcircle.viewmodels.a {

    /* renamed from: m, reason: collision with root package name */
    public MutableLiveData<TVideoTemporaryAuth$AuthorizeTabData> f304765m = new MutableLiveData<>();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.tvideo.temporaryauth.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8864a implements VSDispatchObserver.OnVSRspCallBack<TVideoTemporaryAuth$CheckAuthorizeTabResponse> {
        C8864a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, TVideoTemporaryAuth$CheckAuthorizeTabResponse tVideoTemporaryAuth$CheckAuthorizeTabResponse) {
            if (tVideoTemporaryAuth$CheckAuthorizeTabResponse != null && z16 && j3 == 0) {
                QLog.d("TVideoCheckTemporaryAuthViewModel", 4, "allow_authorize = " + tVideoTemporaryAuth$CheckAuthorizeTabResponse.data.allow_authorize.get() + " tab_id = " + tVideoTemporaryAuth$CheckAuthorizeTabResponse.data.tab_id.get());
                a.this.f304765m.postValue(tVideoTemporaryAuth$CheckAuthorizeTabResponse.data);
            }
        }
    }

    public void L1() {
        sendRequest(new TVideoCheckTemporaryAuthRequest(), new C8864a());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TVideoCheckTemporaryAuthViewModel";
    }
}
