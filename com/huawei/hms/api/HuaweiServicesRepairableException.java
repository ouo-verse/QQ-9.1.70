package com.huawei.hms.api;

import android.content.Intent;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HuaweiServicesRepairableException extends UserRecoverableException {
    private final int statusCode;

    public HuaweiServicesRepairableException(int i3, String str, Intent intent) {
        super(str, intent);
        this.statusCode = i3;
    }

    public int getConnectionStatusCode() {
        return this.statusCode;
    }
}
