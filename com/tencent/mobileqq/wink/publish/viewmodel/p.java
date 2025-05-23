package com.tencent.mobileqq.wink.publish.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.wink.request.QQWinkShoppingReq;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead$GetPublishPageCommonInfoRsp;

/* compiled from: P */
/* loaded from: classes21.dex */
public class p extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<String> f326060i = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$GetPublishPageCommonInfoRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$GetPublishPageCommonInfoRsp feedCloudRead$GetPublishPageCommonInfoRsp) {
            if (z16) {
                String str2 = feedCloudRead$GetPublishPageCommonInfoRsp.publishUser.school.get();
                if (!TextUtils.isEmpty(str2)) {
                    p.this.f326060i.postValue(str2);
                } else {
                    p.this.f326060i.postValue("");
                }
                QLog.d("PublishSchoolViewModel", 1, "isSuccess = true\u62c9\u53d6\u5230\u7684\u5b66\u6821\u540d schoolNameValue = " + str2);
                return;
            }
            p.this.f326060i.postValue("");
            QLog.d("PublishSchoolViewModel", 1, "isSuccess = false,retCode = " + j3 + ",errMsg = " + str);
        }
    }

    private void O1(VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$GetPublishPageCommonInfoRsp> onVSRspCallBack) {
        VSNetworkHelper.getInstance().sendRequest(new QQWinkShoppingReq(), onVSRspCallBack);
    }

    public MutableLiveData<String> M1() {
        return this.f326060i;
    }

    public void N1() {
        O1(new a());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "PublishSchoolViewModel";
    }
}
