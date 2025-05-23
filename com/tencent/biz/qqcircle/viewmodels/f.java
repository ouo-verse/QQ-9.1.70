package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleChangePMSettingRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetPMSettingRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import qqcircle.QQCirclePrivateMsgShow$StChangePMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow$StGetPMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow$StPMSettingData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f extends com.tencent.biz.qqcircle.viewmodels.a {

    /* renamed from: m, reason: collision with root package name */
    public MutableLiveData<UIStateData<QQCirclePrivateMsgShow$StGetPMSettingRsp>> f92847m = new MutableLiveData<>();
    public MutableLiveData<UIStateData<QQCirclePrivateMsgShow$StChangePMSettingRsp>> C = new MutableLiveData<>();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<QQCirclePrivateMsgShow$StGetPMSettingRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCirclePrivateMsgShow$StGetPMSettingRsp qQCirclePrivateMsgShow$StGetPMSettingRsp) {
            String traceId;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getPMSettingRequest isSuccess:");
            sb5.append(z16);
            sb5.append(" retCode:");
            sb5.append(j3);
            sb5.append(" errorMsg:");
            sb5.append(str);
            sb5.append(" traceId: ");
            if (baseRequest == null) {
                traceId = "";
            } else {
                traceId = baseRequest.getTraceId();
            }
            sb5.append(traceId);
            sb5.append(" name: ");
            sb5.append(baseRequest.get$cmd());
            QLog.d("QOK-QCirclePrivateMessageSettingViewModel", 1, sb5.toString());
            if (z16 && j3 == 0 && qQCirclePrivateMsgShow$StGetPMSettingRsp != null) {
                f.this.f92847m.setValue(UIStateData.obtainSuccess(false).setData(false, qQCirclePrivateMsgShow$StGetPMSettingRsp));
            } else {
                f.this.f92847m.setValue(UIStateData.obtainError(str).setRetCode(j3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements VSDispatchObserver.OnVSRspCallBack<QQCirclePrivateMsgShow$StChangePMSettingRsp> {
        b() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCirclePrivateMsgShow$StChangePMSettingRsp qQCirclePrivateMsgShow$StChangePMSettingRsp) {
            String traceId;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setProfileRequest isSuccess:");
            sb5.append(z16);
            sb5.append(" retCode:");
            sb5.append(j3);
            sb5.append(" errorMsg:");
            sb5.append(str);
            sb5.append(" traceId: ");
            if (baseRequest == null) {
                traceId = "";
            } else {
                traceId = baseRequest.getTraceId();
            }
            sb5.append(traceId);
            QLog.d("QOK-QCirclePrivateMessageSettingViewModel", 1, sb5.toString());
            if (z16 && j3 == 0 && qQCirclePrivateMsgShow$StChangePMSettingRsp != null) {
                f.this.C.setValue(UIStateData.obtainSuccess(false).setData(false, qQCirclePrivateMsgShow$StChangePMSettingRsp));
            } else {
                f.this.C.setValue(UIStateData.obtainError(str).setRetCode(j3));
            }
        }
    }

    public void L1(QQCirclePrivateMsgShow$StPMSettingData qQCirclePrivateMsgShow$StPMSettingData) {
        QCircleChangePMSettingRequest qCircleChangePMSettingRequest = new QCircleChangePMSettingRequest(qQCirclePrivateMsgShow$StPMSettingData);
        this.C.setValue(UIStateData.obtainLoading());
        VSNetworkHelper.getInstance().sendRequest(qCircleChangePMSettingRequest, new b());
    }

    public void M1(String str) {
        QCircleGetPMSettingRequest qCircleGetPMSettingRequest = new QCircleGetPMSettingRequest(str);
        this.f92847m.setValue(UIStateData.obtainLoading());
        VSNetworkHelper.getInstance().sendRequest(qCircleGetPMSettingRequest, new a());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCirclePrivateMessageSettingViewModel";
    }
}
