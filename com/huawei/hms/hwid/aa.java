package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aa extends TaskApiCall<u, Void> {
    public aa(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(u uVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        a(responseErrorCode, str);
        if (!TextUtils.isEmpty(str)) {
            if (responseErrorCode.getErrorCode() == 0) {
                taskCompletionSource.setResult(null);
                return;
            } else {
                taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode())));
                return;
            }
        }
        taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40000300;
    }

    private void a(ResponseErrorCode responseErrorCode, String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("headerErrorCode:" + responseErrorCode.getErrorCode());
        as.b("[HUAWEIIDSDK]HuaweiIdDeleteAuthInfoTaskApiCall", sb5.toString(), true);
    }
}
