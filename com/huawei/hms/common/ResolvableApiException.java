package com.huawei.hms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ResolvableApiException extends ApiException {
    public ResolvableApiException(Status status) {
        super(status);
    }

    public PendingIntent getResolution() {
        return this.mStatus.getResolution();
    }

    public Intent getResolutionIntent() {
        return this.mStatus.getResolutionIntent();
    }

    public void startResolutionForResult(Activity activity, int i3) throws IntentSender.SendIntentException {
        this.mStatus.startResolutionForResult(activity, i3);
    }

    public ResolvableApiException(ResponseErrorCode responseErrorCode) {
        super(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason()));
        if (responseErrorCode.hasResolution()) {
            if (responseErrorCode.getParcelable() instanceof PendingIntent) {
                this.mStatus.setPendingIntent((PendingIntent) responseErrorCode.getParcelable());
            } else if (responseErrorCode.getParcelable() instanceof Intent) {
                this.mStatus.setIntent((Intent) responseErrorCode.getParcelable());
            }
        }
    }
}
