package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.hwid.RevokeAccessResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h extends TaskApiCall<c, Void> {
    public h(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(c cVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        int i3;
        as.b("AccountCancelAuthorizationTaskApiCall", "AccountCancelAuthorizationTaskApiCall doExecute", true);
        f.a();
        if (!TextUtils.isEmpty(str)) {
            if ("{}".equals(str)) {
                as.b("AccountCancelAuthorizationTaskApiCall", "signIn complete, body is null", true);
                taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                return;
            }
            RevokeAccessResult beanFromJsonStr = new RevokeAccessResult().getBeanFromJsonStr(str);
            if (beanFromJsonStr.getErrorCode() != null) {
                i3 = beanFromJsonStr.getErrorCode().intValue();
                taskCompletionSource.setException(new ApiException(new Status(beanFromJsonStr.getErrorCode().intValue(), beanFromJsonStr.getErrorMsg())));
            } else {
                if (responseErrorCode.getErrorCode() == 1212) {
                    as.b("AccountCancelAuthorizationTaskApiCall", "AccountCancelAuthorizationTaskApiCall 1212", true);
                    Status status = new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason());
                    ao.a(responseErrorCode, status);
                    taskCompletionSource.setException(new ApiException(status));
                } else {
                    taskCompletionSource.setResult(null);
                }
                i3 = 0;
            }
        } else {
            int errorCode = responseErrorCode.getErrorCode();
            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            i3 = errorCode;
        }
        if (cVar != null) {
            HiAnalyticsClient.reportExit(cVar.getContext(), getUri(), getTransactionId(), ar.a(i3), i3);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }
}
