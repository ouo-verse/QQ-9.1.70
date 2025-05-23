package com.hihonor.cloudservice.common;

import com.hihonor.cloudservice.support.api.clients.Status;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ApiException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    protected final Status f36204a;

    public ApiException(Status status) {
        super(status.c());
        this.f36204a = status;
    }

    public int getStatusCode() {
        return this.f36204a.a();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.f36204a.c();
    }
}
