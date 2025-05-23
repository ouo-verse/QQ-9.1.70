package com.huawei.hms.support.api.client;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BundleResult {

    /* renamed from: a, reason: collision with root package name */
    private int f37531a;

    /* renamed from: b, reason: collision with root package name */
    private Bundle f37532b;

    public BundleResult(int i3, Bundle bundle) {
        this.f37531a = i3;
        this.f37532b = bundle;
    }

    public int getResultCode() {
        return this.f37531a;
    }

    public Bundle getRspBody() {
        return this.f37532b;
    }

    public void setResultCode(int i3) {
        this.f37531a = i3;
    }

    public void setRspBody(Bundle bundle) {
        this.f37532b = bundle;
    }
}
