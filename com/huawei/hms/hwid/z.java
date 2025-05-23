package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.api.hwid.RevokeAccessResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* compiled from: P */
/* loaded from: classes2.dex */
public class z extends TaskApiCall<u, Void> {
    public z(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(u uVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        int errorCode;
        as.b("HuaweiIdCancelAuthorizationTaskApiCall", "HuaweiIdCancelAuthorizationTaskApiCall doExecute", true);
        x.a();
        if (!TextUtils.isEmpty(str)) {
            RevokeAccessResult beanFromJsonStr = new RevokeAccessResult().getBeanFromJsonStr(str);
            if (beanFromJsonStr.getErrorCode() != null) {
                errorCode = beanFromJsonStr.getErrorCode().intValue();
                taskCompletionSource.setException(new ApiException(new Status(beanFromJsonStr.getErrorCode().intValue(), beanFromJsonStr.getErrorMsg())));
            } else {
                taskCompletionSource.setResult(null);
                errorCode = 0;
            }
        } else {
            errorCode = responseErrorCode.getErrorCode();
            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
        if (uVar != null) {
            HiAnalyticsClient.reportExit(uVar.getContext(), CommonNaming.revokeAccess, getTransactionId(), ar.a(errorCode), errorCode);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }
}
