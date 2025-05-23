package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QFSPushGetTaskInfoRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import qqcircle.QQCircleClient$TaskInfo;
import qqcircle.QQCircleClient$TaskInfosRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class r extends com.tencent.biz.qqcircle.viewmodels.a {
    private String C;

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<UIStateData<List<QQCircleClient$TaskInfo>>> f92876m = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleClient$TaskInfosRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleClient$TaskInfosRsp qQCircleClient$TaskInfosRsp) {
            if (qQCircleClient$TaskInfosRsp != null && z16 && j3 == 0) {
                r.this.C = qQCircleClient$TaskInfosRsp.title.get();
                r.this.f92876m.setValue(UIStateData.obtainSuccess(false).setData(false, qQCircleClient$TaskInfosRsp.infos.get()));
                com.tencent.biz.qqcircle.f.v().R(qQCircleClient$TaskInfosRsp.total_fuel.get());
                return;
            }
            r.this.f92876m.setValue(UIStateData.obtainError(str).setRetCode(j3));
            QLog.d("QFSPushMissionViewModel", 1, "Get Task Info Data Fail. | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        }
    }

    public void N1() {
        VSNetworkHelper.getInstance().sendRequest(new QFSPushGetTaskInfoRequest(100), new a());
    }

    public MutableLiveData<UIStateData<List<QQCircleClient$TaskInfo>>> O1() {
        return this.f92876m;
    }

    public String P1() {
        return this.C;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPushMissionViewModel";
    }
}
