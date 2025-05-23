package com.huawei.hms.support.api.entity.hwid;

import com.huawei.hms.support.api.client.Status;

/* compiled from: P */
/* loaded from: classes2.dex */
public class InvalidVersionException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private Status f37545a;

    public InvalidVersionException(Status status) {
        this.f37545a = status;
    }

    public Status getError() {
        return this.f37545a;
    }
}
