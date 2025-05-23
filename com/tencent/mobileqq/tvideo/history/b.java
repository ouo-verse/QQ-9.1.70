package com.tencent.mobileqq.tvideo.history;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import tvideo.TVideoHistory$DataVersionData;
import tvideo.TVideoHistory$GetDataVersionResponse;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends com.tencent.biz.qqcircle.viewmodels.a {

    /* renamed from: m, reason: collision with root package name */
    public MutableLiveData<Long> f304466m = new MutableLiveData<>();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<TVideoHistory$GetDataVersionResponse> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, TVideoHistory$GetDataVersionResponse tVideoHistory$GetDataVersionResponse) {
            TVideoHistory$DataVersionData tVideoHistory$DataVersionData;
            QLog.d("TVideoHistoryVersionViewModel", 4, "requestHistoryVersion isSuccess = " + z16 + " errMsg = " + str + " rsp = " + tVideoHistory$GetDataVersionResponse);
            if (z16 && j3 == 0 && tVideoHistory$GetDataVersionResponse != null && (tVideoHistory$DataVersionData = tVideoHistory$GetDataVersionResponse.data) != null) {
                b.this.f304466m.setValue(Long.valueOf(tVideoHistory$DataVersionData.data_version.get()));
            }
        }
    }

    public void L1() {
        QLog.d("TVideoHistoryVersionViewModel", 4, "requestHistoryVersion");
        sendRequest(new TVideoHistoryVersionRequest(), new a());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TVideoHistoryVersionViewModel";
    }
}
