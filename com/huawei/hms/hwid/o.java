package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.hwid.StartAssistLoginResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class o extends TaskApiCall<c, Void> {
    public o(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(c cVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        int i3;
        as.b("AccountCancelAuthorizationTaskApiCall", "AccountStartAssistLoginTaskApiCall doExecute", true);
        if (!TextUtils.isEmpty(str)) {
            if ("{}".equals(str)) {
                as.b("AccountCancelAuthorizationTaskApiCall", "signIn complete, body is null", true);
                taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                return;
            }
            try {
                StartAssistLoginResult fromJson = new StartAssistLoginResult().fromJson(str);
                if (fromJson.isSuccess()) {
                    taskCompletionSource.setResult(null);
                } else {
                    taskCompletionSource.setException(new ApiException(fromJson.getStatus()));
                }
            } catch (JSONException unused) {
                as.c("AccountCancelAuthorizationTaskApiCall", "tartAssistLogin complete, but parser json exception", true);
                taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
            i3 = 0;
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
        return 14;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 60000000;
    }
}
