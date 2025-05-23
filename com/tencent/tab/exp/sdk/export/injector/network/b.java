package com.tencent.tab.exp.sdk.export.injector.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tab.exp.sdk.impl.x;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f374022a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f374023b;

    /* renamed from: c, reason: collision with root package name */
    private final int f374024c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f374025d;

    /* compiled from: P */
    /* renamed from: com.tencent.tab.exp.sdk.export.injector.network.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C9878b {

        /* renamed from: a, reason: collision with root package name */
        private int f374026a = 0;

        /* renamed from: b, reason: collision with root package name */
        private String f374027b = "\u6682\u672a\u5b9a\u4e49";

        /* renamed from: c, reason: collision with root package name */
        private int f374028c = 0;

        /* renamed from: d, reason: collision with root package name */
        private String f374029d = "\u6682\u672a\u5b9a\u4e49";

        @NonNull
        public b e() {
            return new b(this);
        }

        public C9878b f(int i3) {
            this.f374028c = i3;
            return this;
        }

        public C9878b g(@Nullable String str) {
            this.f374029d = str;
            return this;
        }

        public C9878b h(int i3) {
            this.f374026a = i3;
            return this;
        }

        public C9878b i(@Nullable String str) {
            this.f374027b = str;
            return this;
        }
    }

    public static boolean d(b bVar) {
        if (bVar == null || bVar.c() != 1) {
            return false;
        }
        return true;
    }

    public int a() {
        return this.f374024c;
    }

    @Nullable
    public String b() {
        return this.f374025d;
    }

    public int c() {
        return this.f374022a;
    }

    public String toString() {
        return "TabNetworkError {  mResultCode = " + this.f374022a + ", mResultMessage = " + this.f374023b + ", mErrorCode = " + this.f374024c + ", mErrorMessage = " + this.f374025d + "  }";
    }

    b(@NonNull C9878b c9878b) {
        this.f374022a = c9878b.f374026a;
        this.f374023b = x.d(c9878b.f374027b, "\u6682\u672a\u5b9a\u4e49");
        this.f374024c = c9878b.f374028c;
        this.f374025d = x.d(c9878b.f374029d, "\u6682\u672a\u5b9a\u4e49");
    }
}
