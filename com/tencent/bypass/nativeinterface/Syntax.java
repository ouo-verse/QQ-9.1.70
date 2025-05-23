package com.tencent.bypass.nativeinterface;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class Syntax {
    final String mAlias;
    final boolean mGreedy;
    final String mMatchedString;
    final boolean mTokenized;
    final String mType;

    public Syntax(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z16, boolean z17) {
        this.mType = str;
        this.mAlias = str2;
        this.mMatchedString = str3;
        this.mGreedy = z16;
        this.mTokenized = z17;
    }

    @NonNull
    public String getAlias() {
        return this.mAlias;
    }

    public boolean getGreedy() {
        return this.mGreedy;
    }

    @NonNull
    public String getMatchedString() {
        return this.mMatchedString;
    }

    public boolean getTokenized() {
        return this.mTokenized;
    }

    @NonNull
    public String getType() {
        return this.mType;
    }

    public String toString() {
        return "Syntax{mType=" + this.mType + ",mAlias=" + this.mAlias + ",mMatchedString=" + this.mMatchedString + ",mGreedy=" + this.mGreedy + ",mTokenized=" + this.mTokenized + "}";
    }
}
