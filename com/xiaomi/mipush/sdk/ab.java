package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
class ab {

    /* renamed from: a, reason: collision with root package name */
    int f388011a = 0;

    /* renamed from: b, reason: collision with root package name */
    String f388012b = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ab)) {
            ab abVar = (ab) obj;
            if (!TextUtils.isEmpty(abVar.f388012b) && abVar.f388012b.equals(this.f388012b)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
