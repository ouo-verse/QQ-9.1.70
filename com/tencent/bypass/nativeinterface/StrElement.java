package com.tencent.bypass.nativeinterface;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class StrElement {
    final String mStr;

    public StrElement(@NonNull String str) {
        this.mStr = str;
    }

    @NonNull
    public String getStr() {
        return this.mStr;
    }

    public String toString() {
        return "StrElement{mStr=" + this.mStr + "}";
    }
}
