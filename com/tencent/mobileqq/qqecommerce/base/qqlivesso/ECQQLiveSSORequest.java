package com.tencent.mobileqq.qqecommerce.base.qqlivesso;

import com.tencent.ecommerce.base.qqlivesso.api.IECQQLiveSSORequest;
import com.tencent.ecommerce.base.qqlivesso.api.IECQQLiveSSORequestCallback;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.qqLiveRequest$GetRsp;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qg0.ECQQLiveSSOResponse;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/qqlivesso/ECQQLiveSSORequest;", "Lcom/tencent/ecommerce/base/qqlivesso/api/IECQQLiveSSORequest;", "", "service", "method", "reqData", "Lcom/tencent/ecommerce/base/qqlivesso/api/IECQQLiveSSORequestCallback;", "callback", "", "sendRequest", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECQQLiveSSORequest implements IECQQLiveSSORequest {
    @Override // com.tencent.ecommerce.base.qqlivesso.api.IECQQLiveSSORequest
    public void sendRequest(final String service, final String method, final String reqData, final IECQQLiveSSORequestCallback callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.i("ECQQLiveSSORequest", 1, "sendRequest() service=" + service + ", method=" + method + ", reqData=" + reqData);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new ECQQLiveGetRequest(service, method, reqData), new Function1<QQLiveResponse<qqLiveRequest$GetRsp>, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.base.qqlivesso.ECQQLiveSSORequest$sendRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<qqLiveRequest$GetRsp> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QQLiveResponse<qqLiveRequest$GetRsp> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                qqLiveRequest$GetRsp rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    QLog.i("ECQQLiveSSORequest", 1, "sendRequest() onReceive, " + service + ", method=" + method + ", reqData=" + reqData + ", rsp.rsp_params=" + rsp.rsp_params.get());
                    IECQQLiveSSORequestCallback iECQQLiveSSORequestCallback = callback;
                    if (iECQQLiveSSORequestCallback != null) {
                        String str = rsp.rsp_params.get();
                        if (str == null) {
                            str = "";
                        }
                        iECQQLiveSSORequestCallback.onResult(new ECQQLiveSSOResponse(true, 0, "", str));
                        return;
                    }
                    return;
                }
                QLog.i("ECQQLiveSSORequest", 1, "sendRequest() onFail, " + service + ", method=" + method + ", reqData=" + reqData + ", errCode=" + response.getRetCode() + ", errMsg=" + response.getErrMsg());
                IECQQLiveSSORequestCallback iECQQLiveSSORequestCallback2 = callback;
                if (iECQQLiveSSORequestCallback2 != null) {
                    int retCode = (int) response.getRetCode();
                    String errMsg = response.getErrMsg();
                    if (errMsg == null) {
                        errMsg = "";
                    }
                    iECQQLiveSSORequestCallback2.onResult(new ECQQLiveSSOResponse(false, retCode, errMsg, ""));
                }
            }
        });
    }
}
