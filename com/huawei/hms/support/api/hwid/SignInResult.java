package com.huawei.hms.support.api.hwid;

import android.content.Intent;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SignInResult extends Result {
    private AuthHuaweiId authHuaweiId;
    private Intent data;

    public SignInResult() {
    }

    public AuthHuaweiId getAuthHuaweiId() {
        return this.authHuaweiId;
    }

    public Intent getData() {
        return this.data;
    }

    public boolean isSuccess() {
        return getStatus().isSuccess();
    }

    public void setAuthHuaweiId(AuthHuaweiId authHuaweiId) {
        this.authHuaweiId = authHuaweiId;
    }

    public void setData(Intent intent) {
        this.data = intent;
    }

    public SignInResult(Status status) {
        setStatus(status);
    }
}
