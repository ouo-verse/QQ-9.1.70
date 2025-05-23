package com.tencent.gdtad.kuikly.module;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

/* compiled from: P */
/* loaded from: classes6.dex */
final class c {

    @SerializedName("context")
    public a contextInfo;

    @SerializedName("params")
    public b paramsInfo;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class a {

        @SerializedName("bundleName")
        public String bundleName;

        @SerializedName("pageName")
        public String pageName;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class b {

        @SerializedName("supportOpenMotiveAd")
        public boolean supportOpenMotiveAd;

        @SerializedName("supportWxMiniAuthorizationState")
        public boolean supportWxMiniAuthorizationState;
    }

    c() {
    }

    @NonNull
    public String toString() {
        return com.tencent.gdtad.json.a.b(this, "{}");
    }
}
