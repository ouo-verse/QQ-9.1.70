package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mtt.abtestsdk.BuildConfig;
import hd4.b;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class c extends hd4.b {
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private static c g(@NonNull String str, @Nullable String str2, @NonNull String str3, boolean z16, @NonNull k kVar) {
        String str4;
        HashMap hashMap = new HashMap();
        hd4.b.f(hashMap, "A70", str2);
        hd4.b.f(hashMap, "A71", str);
        hd4.b.f(hashMap, "A148", kVar.c());
        hd4.b.f(hashMap, "A149", kVar.d());
        hd4.b.f(hashMap, "tab_sdk_version", BuildConfig.VERSION_NAME);
        if (z16) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        hd4.b.f(hashMap, "report_method", str4);
        return ((b) ((b) new b().i(str3).c("rqd_expimpression")).d(hashMap)).j(true).k(true).l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static c h(@NonNull String str, @Nullable String str2, @NonNull String str3, @NonNull k kVar) {
        return g(str, str2, str3, true, kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static c i(@NonNull String str, @Nullable String str2, @NonNull String str3, @NonNull k kVar) {
        return g(str, str2, str3, false, kVar);
    }

    c(@NonNull b bVar) {
        super(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class b extends b.a<b, c> {
        b() {
        }

        @NonNull
        protected c l() {
            return new c(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // hd4.c.a
        @NonNull
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public b e() {
            return this;
        }
    }
}
