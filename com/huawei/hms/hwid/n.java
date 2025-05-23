package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.hwid.SignOutResult;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class n extends TaskApiCall<c, Void> {
    public n(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(c cVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        a(responseErrorCode, str);
        if (!TextUtils.isEmpty(str)) {
            try {
                SignOutResult fromJson = new SignOutResult().fromJson(str);
                if (fromJson.isSuccess()) {
                    taskCompletionSource.setResult(null);
                } else {
                    Status status = fromJson.getStatus();
                    ao.a(responseErrorCode, status);
                    taskCompletionSource.setException(new ApiException(status));
                }
                return;
            } catch (JSONException unused) {
                Status status2 = new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason());
                ao.a(responseErrorCode, status2);
                taskCompletionSource.setException(new ApiException(status2));
                return;
            }
        }
        taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    private void a(ResponseErrorCode responseErrorCode, String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("headerErrorCode:" + responseErrorCode.getErrorCode());
        as.b("[AccountSDK]AccountSignOutTaskApiCall", sb5.toString(), true);
    }
}
