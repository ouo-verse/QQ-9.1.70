package com.huawei.hms.hwid;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* compiled from: P */
/* loaded from: classes2.dex */
public class al extends TaskApiCall<ai, Void> {
    public al(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(ai aiVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        ag b16 = ag.b(str);
        Integer a16 = b16.a();
        String b17 = b16.b();
        if (a16 == null) {
            a16 = Integer.valueOf(responseErrorCode.getErrorCode());
            b17 = responseErrorCode.getErrorReason();
        }
        if (a(responseErrorCode, b16.a())) {
            taskCompletionSource.setResult(null);
        } else {
            taskCompletionSource.setException(new ApiException(new Status(a16.intValue(), b17)));
        }
        if (aiVar != null) {
            HiAnalyticsClient.reportExit(aiVar.getContext(), getUri(), getTransactionId(), ar.a(a16.intValue()), a16.intValue());
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        as.b("StartConsentTaskApiCall", "startConsent getApiLevel8", true);
        return 8;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 50005300;
    }

    private boolean a(ResponseErrorCode responseErrorCode, Integer num) {
        return num == null ? responseErrorCode.getStatusCode() == 0 : num.intValue() == 0;
    }
}
