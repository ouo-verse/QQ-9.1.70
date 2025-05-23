package com.tencent.bypass.nativeinterface;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class Text {
    final String mLiteral;

    public Text(@NonNull String str) {
        this.mLiteral = str;
    }

    @NonNull
    public String getLiteral() {
        return this.mLiteral;
    }

    public String toString() {
        return "Text{mLiteral=" + this.mLiteral + "}";
    }
}
