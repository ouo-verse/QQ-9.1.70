package com.huawei.hms.hwid;

import android.app.PendingIntent;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.account.AccountNaming;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* compiled from: P */
/* loaded from: classes2.dex */
public class j extends TaskApiCall<c, Void> {
    public j(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(c cVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        as.b("AccountLogoutTaskApiCall", "AccountLogoutTaskApiCall doExecute", true);
        a(responseErrorCode);
        if (responseErrorCode.getErrorCode() != 0) {
            if (CommonCode.Resolution.HAS_RESOLUTION.equals(responseErrorCode.getResolution())) {
                as.b("AccountLogoutTaskApiCall", "hms apk version is low or is not exist.", true);
                taskCompletionSource.setException(new ResolvableApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), (PendingIntent) responseErrorCode.getParcelable())));
            } else {
                as.b("AccountLogoutTaskApiCall", "AccountLogoutTaskApiCall callback.", true);
                if (responseErrorCode.getErrorCode() != 2031) {
                    taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                }
            }
            taskCompletionSource.setResult(null);
            a(cVar, responseErrorCode);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            a(cVar, responseErrorCode);
        } else {
            taskCompletionSource.setResult(null);
            a(cVar, responseErrorCode);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 16;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 60000000;
    }

    private void a(c cVar, ResponseErrorCode responseErrorCode) {
        if (cVar == null || responseErrorCode == null) {
            return;
        }
        HiAnalyticsClient.reportExit(cVar.getContext(), AccountNaming.logout, getTransactionId(), ar.a(responseErrorCode.getErrorCode()), responseErrorCode.getErrorCode());
    }

    private void a(ResponseErrorCode responseErrorCode) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("headerErrorCode:" + responseErrorCode.getErrorCode());
        as.b("AccountLogoutTaskApiCall", sb5.toString(), true);
    }
}
