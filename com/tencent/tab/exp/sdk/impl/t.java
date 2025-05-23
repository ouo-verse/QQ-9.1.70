package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
final class t implements id4.b {
    @Override // id4.b
    @Nullable
    public id4.a create(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new u(str);
    }
}
