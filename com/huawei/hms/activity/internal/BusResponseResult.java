package com.huawei.hms.activity.internal;

import android.content.Intent;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BusResponseResult {

    /* renamed from: a, reason: collision with root package name */
    private Intent f36629a;

    /* renamed from: b, reason: collision with root package name */
    private int f36630b;

    public int getCode() {
        return this.f36630b;
    }

    public Intent getIntent() {
        return this.f36629a;
    }

    public void setCode(int i3) {
        this.f36630b = i3;
    }

    public void setIntent(Intent intent) {
        this.f36629a = intent;
    }
}
