package com.huawei.hms.common;

import com.huawei.hms.support.api.client.Status;
import com.tencent.mobileqq.activity.recent.MsgSummary;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ApiException extends Exception {
    protected final Status mStatus;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ApiException(Status status) {
        super(r0.toString());
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(status.getStatusCode());
        sb5.append(MsgSummary.STR_COLON);
        if (status.getStatusMessage() != null) {
            str = status.getStatusMessage();
        } else {
            str = "";
        }
        sb5.append(str);
        this.mStatus = status;
    }

    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}
