package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.result.AccountAuthResult;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class m extends TaskApiCall<c, AuthAccount> {
    public m(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doExecute(c cVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<AuthAccount> taskCompletionSource) {
        AuthAccount authAccount;
        AccountAuthResult fromJson;
        as.b("[AccountSDK]AccountSignInTaskApiCall", "ResponseErrorCode.status:" + String.valueOf(responseErrorCode.getErrorCode()), true);
        int errorCode = responseErrorCode.getErrorCode();
        if (!TextUtils.isEmpty(str)) {
            if ("{}".equals(str)) {
                as.b("[AccountSDK]AccountSignInTaskApiCall", "signIn complete, body is null", true);
                taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                return;
            }
            try {
                fromJson = new AccountAuthResult().fromJson(str);
                errorCode = fromJson.getStatus().getStatusCode();
            } catch (JSONException unused) {
                authAccount = null;
            }
            if (fromJson.isSuccess()) {
                as.b("[AccountSDK]AccountSignInTaskApiCall", "signIn success", true);
                new e(cVar.getContext()).a();
                authAccount = fromJson.getAccount();
                try {
                    taskCompletionSource.setResult(fromJson.getAccount());
                } catch (JSONException unused2) {
                    as.c("[AccountSDK]AccountSignInTaskApiCall", "signIn complete, but parser json exception", true);
                    Status status = new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason());
                    ao.a(responseErrorCode, status);
                    taskCompletionSource.setException(new ApiException(status));
                    g.a().a(authAccount, (AccountAuthParams) null);
                    if (cVar != null) {
                    }
                }
                g.a().a(authAccount, (AccountAuthParams) null);
                if (cVar != null) {
                    HiAnalyticsClient.reportExit(cVar.getContext(), getUri(), getTransactionId(), ar.a(errorCode), errorCode);
                    return;
                }
                return;
            }
            as.b("[AccountSDK]AccountSignInTaskApiCall", "signIn failed", true);
            Status status2 = fromJson.getStatus();
            ao.a(responseErrorCode, status2);
            taskCompletionSource.setException(new ApiException(status2));
        } else {
            as.b("[AccountSDK]AccountSignInTaskApiCall", "signIn complete, response is null, failed", true);
            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
        authAccount = null;
        g.a().a(authAccount, (AccountAuthParams) null);
        if (cVar != null) {
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }
}
