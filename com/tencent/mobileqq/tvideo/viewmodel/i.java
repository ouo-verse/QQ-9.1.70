package com.tencent.mobileqq.tvideo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.tvideo.net.request.TVideoIntroductionRequest;
import com.tencent.qphone.base.util.QLog;
import tvideo.VideoBriefIntro$VideoBriefIntroductionPage;
import tvideo.VideoBriefIntro$VideoBriefIntroductionPageResponse;

/* compiled from: P */
/* loaded from: classes19.dex */
public class i extends com.tencent.biz.qqcircle.viewmodels.a {

    /* renamed from: m, reason: collision with root package name */
    public MutableLiveData<VideoBriefIntro$VideoBriefIntroductionPage> f304837m = new MutableLiveData<>();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<VideoBriefIntro$VideoBriefIntroductionPageResponse> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, VideoBriefIntro$VideoBriefIntroductionPageResponse videoBriefIntro$VideoBriefIntroductionPageResponse) {
            QLog.d("QFSTVideoIntroductionViewModel", 4, "requestPlot isSuccess = " + z16 + " errMsg = " + str + " rsp = " + videoBriefIntro$VideoBriefIntroductionPageResponse);
            if (videoBriefIntro$VideoBriefIntroductionPageResponse != null && z16 && j3 == 0) {
                i.this.f304837m.setValue(videoBriefIntro$VideoBriefIntroductionPageResponse.data);
            } else {
                i.this.f304837m.setValue(null);
            }
        }
    }

    public void L1(String str) {
        QLog.d("QFSTVideoIntroductionViewModel", 4, "requestIntroductionData cid = " + str);
        sendRequest(new TVideoIntroductionRequest(str), new a());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSTVideoIntroductionViewModel";
    }
}
