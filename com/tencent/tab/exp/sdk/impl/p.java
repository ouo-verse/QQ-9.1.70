package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
final class p {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final String f374154a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final String f374155b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private String f374156a = "";

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private String f374157b = "";

        /* JADX INFO: Access modifiers changed from: package-private */
        public b c(@NonNull String str) {
            this.f374156a = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public p d() {
            return new p(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b e(@NonNull String str) {
            this.f374157b = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (x.g(this.f374154a, pVar.f374154a) && x.g(this.f374155b, pVar.f374155b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return x.h(this.f374154a, this.f374155b);
    }

    p(@NonNull b bVar) {
        this.f374154a = TextUtils.isEmpty(bVar.f374156a) ? "" : bVar.f374156a;
        this.f374155b = TextUtils.isEmpty(bVar.f374157b) ? "" : bVar.f374157b;
    }
}
