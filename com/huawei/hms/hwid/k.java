package com.huawei.hms.hwid;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcelable;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.UIUtil;

/* compiled from: P */
/* loaded from: classes2.dex */
public class k extends TaskApiCall<c, Intent> {
    public k(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(c cVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Intent> taskCompletionSource) {
        if (responseErrorCode.getStatusCode() == 0 && responseErrorCode.getErrorCode() == 0) {
            as.b("AccountNoticeTaskApiCall", "Jos Notice onResult success.", true);
            a(responseErrorCode.getParcelable(), cVar, responseErrorCode, taskCompletionSource);
        } else {
            as.c("AccountNoticeTaskApiCall", "Jos Notice onResult failed:" + responseErrorCode.getErrorCode() + ",ErrReason:" + responseErrorCode.getErrorReason(), true);
        }
        if (cVar != null) {
            HiAnalyticsClient.reportExit(cVar.getContext(), getUri(), getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode());
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    private void a(Parcelable parcelable, c cVar, ResponseErrorCode responseErrorCode, TaskCompletionSource<Intent> taskCompletionSource) {
        Activity currentActivity = ActivityMgr.INST.getCurrentActivity();
        if (currentActivity != null && !currentActivity.isFinishing() && !currentActivity.isDestroyed()) {
            if (parcelable instanceof Intent) {
                try {
                    currentActivity.startActivity((Intent) parcelable);
                    return;
                } catch (Exception unused) {
                    as.d("AccountNoticeTaskApiCall", "Jos Notice startActivity meet exception", true);
                    return;
                }
            } else {
                if (parcelable instanceof PendingIntent) {
                    PendingIntent pendingIntent = (PendingIntent) parcelable;
                    try {
                        if (UIUtil.isBackground(cVar.getContext())) {
                            as.b("AccountNoticeTaskApiCall", "ui isBackground.", true);
                            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), pendingIntent)));
                        } else {
                            currentActivity.startIntentSender(pendingIntent.getIntentSender(), null, 0, 0, 0);
                        }
                        return;
                    } catch (IntentSender.SendIntentException unused2) {
                        as.d("AccountNoticeTaskApiCall", "Jos Notice startIntentSender meet exception", true);
                        return;
                    }
                }
                return;
            }
        }
        as.b("AccountNoticeTaskApiCall", "launchNoticeActivity failed, launchActivity is invalid", true);
    }
}
