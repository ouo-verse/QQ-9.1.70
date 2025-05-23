package com.tencent.mobileqq.guild.api;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public String f214371a;

    /* renamed from: b, reason: collision with root package name */
    public String f214372b;

    /* renamed from: c, reason: collision with root package name */
    public String f214373c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f214374d = true;

    /* renamed from: e, reason: collision with root package name */
    public Bundle f214375e;

    public i b(String str) {
        this.f214372b = str;
        return this;
    }

    public i c(boolean z16) {
        this.f214374d = z16;
        return this;
    }

    public i d(String str) {
        this.f214373c = str;
        return this;
    }

    public i e(Bundle bundle) {
        this.f214375e = bundle;
        return this;
    }

    public i f(String str) {
        this.f214371a = str;
        return this;
    }

    public boolean g() {
        if (TextUtils.isEmpty(this.f214372b)) {
            return false;
        }
        return true;
    }

    public i a() {
        return this;
    }
}
