package com.tencent.mobileqq.tvideo.history;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tvideo.TVideoHistory$AddOrUpdateHistoryData;
import tvideo.TVideoHistory$AddOrUpdateHistoryResponse;
import tvideo.TVideoHistory$VideoHistoryRecord;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends com.tencent.biz.qqcircle.viewmodels.a {

    /* renamed from: m, reason: collision with root package name */
    public MutableLiveData<Long> f304464m = new MutableLiveData<>();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.tvideo.history.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8863a implements VSDispatchObserver.OnVSRspCallBack<TVideoHistory$AddOrUpdateHistoryResponse> {
        C8863a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, TVideoHistory$AddOrUpdateHistoryResponse tVideoHistory$AddOrUpdateHistoryResponse) {
            TVideoHistory$AddOrUpdateHistoryData tVideoHistory$AddOrUpdateHistoryData;
            QLog.d("TVideoHistoryUpdateViewModel", 4, "requestHistoryUpdate isSuccess = " + z16 + " errMsg = " + str + " rsp = " + tVideoHistory$AddOrUpdateHistoryResponse);
            if (z16 && j3 == 0 && tVideoHistory$AddOrUpdateHistoryResponse != null && (tVideoHistory$AddOrUpdateHistoryData = tVideoHistory$AddOrUpdateHistoryResponse.data) != null) {
                a.this.f304464m.setValue(Long.valueOf(tVideoHistory$AddOrUpdateHistoryData.data_version.get()));
            }
        }
    }

    public void L1(long j3, List<TVideoHistory$VideoHistoryRecord> list) {
        QLog.d("TVideoHistoryUpdateViewModel", 4, "requestHistoryUpdate");
        sendRequest(new TVideoHistoryUpdateRequest(j3, list), new C8863a());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TVideoHistoryUpdateViewModel";
    }
}
