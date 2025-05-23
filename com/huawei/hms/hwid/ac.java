package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.utils.Util;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ac extends TaskApiCall<u, AuthHuaweiId> {
    public ac(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00bd  */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doExecute(u uVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<AuthHuaweiId> taskCompletionSource) {
        AuthHuaweiId authHuaweiId;
        int i3;
        as.b("[HUAWEIIDSDK]SignInTaskApiCall", "ResponseErrorCode.status:" + String.valueOf(responseErrorCode.getErrorCode()), true);
        int errorCode = responseErrorCode.getErrorCode();
        if (!TextUtils.isEmpty(str)) {
            try {
                HuaweiIdAuthResult fromJson = new HuaweiIdAuthResult().fromJson(str);
                errorCode = fromJson.getStatus().getStatusCode();
                if (fromJson.isSuccess()) {
                    as.b("[HUAWEIIDSDK]SignInTaskApiCall", "signIn success", true);
                    new w(uVar.getContext()).a();
                    authHuaweiId = fromJson.getHuaweiId();
                    try {
                        taskCompletionSource.setResult(fromJson.getHuaweiId());
                    } catch (JSONException unused) {
                        as.c("[HUAWEIIDSDK]SignInTaskApiCall", "signIn complete, but parser json exception", true);
                        taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                        i3 = errorCode;
                        y.a().a(authHuaweiId, (HuaweiIdAuthParams) null);
                        if (uVar != null) {
                        }
                        as.b("[HUAWEIIDSDK]SignInTaskApiCall", "report: api=hwid.silentSignInversion=60400302", true);
                    }
                } else {
                    as.b("[HUAWEIIDSDK]SignInTaskApiCall", "signIn failed", true);
                    taskCompletionSource.setException(new ApiException(fromJson.getStatus()));
                    authHuaweiId = null;
                }
            } catch (JSONException unused2) {
                authHuaweiId = null;
            }
            i3 = errorCode;
        } else {
            as.b("[HUAWEIIDSDK]SignInTaskApiCall", "signIn complete, response is null, failed", true);
            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            i3 = errorCode;
            authHuaweiId = null;
        }
        y.a().a(authHuaweiId, (HuaweiIdAuthParams) null);
        if (uVar != null) {
            HiAnalyticsClient.reportExit(uVar.getContext(), CommonNaming.silentSignIn, getTransactionId(), Util.getAppId(uVar.getContext()), ar.a(i3), i3, 60400302);
        }
        as.b("[HUAWEIIDSDK]SignInTaskApiCall", "report: api=hwid.silentSignInversion=60400302", true);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }
}
