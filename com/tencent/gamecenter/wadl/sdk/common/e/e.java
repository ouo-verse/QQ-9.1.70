package com.tencent.gamecenter.wadl.sdk.common.e;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f107237a;

    /* renamed from: b, reason: collision with root package name */
    public String f107238b;

    public e(int i3, String str) {
        this.f107238b = "";
        this.f107237a = i3;
        this.f107238b = TextUtils.isEmpty(str) ? "" : str;
    }

    public String toString() {
        return "RetInfo{retCode=" + this.f107237a + ", retMsg='" + this.f107238b + "'}";
    }
}
