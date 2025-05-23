package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tab.exp.sdk.export.config.TabEnvironment;
import com.tencent.tab.exp.sdk.impl.n;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class q extends n {

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final String f374158h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final String f374159i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    private final String f374160j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private final String f374161k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private final String f374162l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private final String f374163m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    private final TabEnvironment f374164n;

    /* renamed from: o, reason: collision with root package name */
    private final int f374165o;

    /* renamed from: p, reason: collision with root package name */
    private final String f374166p;

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String f() {
        return this.f374158h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String g() {
        return this.f374159i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String h() {
        return this.f374160j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public TabEnvironment i() {
        return this.f374164n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String j() {
        return this.f374163m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String k() {
        return this.f374162l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String l() {
        return this.f374166p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f374165o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String n() {
        return this.f374161k;
    }

    q(@NonNull b bVar) {
        super(bVar);
        this.f374158h = TextUtils.isEmpty(bVar.f374167h) ? "" : bVar.f374167h;
        this.f374159i = TextUtils.isEmpty(bVar.f374168i) ? "" : bVar.f374168i;
        this.f374160j = TextUtils.isEmpty(bVar.f374169j) ? "JS0B558T33E4YJ" : bVar.f374169j;
        this.f374161k = TextUtils.isEmpty(bVar.f374170k) ? "" : bVar.f374170k;
        this.f374162l = TextUtils.isEmpty(bVar.f374171l) ? "" : bVar.f374171l;
        this.f374163m = TextUtils.isEmpty(bVar.f374172m) ? "" : bVar.f374172m;
        this.f374164n = bVar.f374173n == null ? com.tencent.tab.exp.sdk.impl.a.f374063a : bVar.f374173n;
        this.f374165o = bVar.f374174o <= 0 ? 15 : bVar.f374174o;
        this.f374166p = TextUtils.isEmpty(bVar.f374175p) ? "" : bVar.f374175p;
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class b extends n.a<b, n> {

        /* renamed from: h, reason: collision with root package name */
        @NonNull
        private String f374167h = "";

        /* renamed from: i, reason: collision with root package name */
        @NonNull
        private String f374168i = "";

        /* renamed from: j, reason: collision with root package name */
        @NonNull
        private String f374169j = "JS0B558T33E4YJ";

        /* renamed from: k, reason: collision with root package name */
        @Nullable
        private String f374170k = "";

        /* renamed from: l, reason: collision with root package name */
        @Nullable
        private String f374171l = "";

        /* renamed from: m, reason: collision with root package name */
        @Nullable
        private String f374172m = "";

        /* renamed from: n, reason: collision with root package name */
        @NonNull
        private TabEnvironment f374173n = com.tencent.tab.exp.sdk.impl.a.f374063a;

        /* renamed from: o, reason: collision with root package name */
        private int f374174o = 15;

        /* renamed from: p, reason: collision with root package name */
        private String f374175p = "";

        public b A(@NonNull TabEnvironment tabEnvironment) {
            this.f374173n = tabEnvironment;
            return this;
        }

        public b C(@Nullable String str) {
            this.f374172m = str;
            return this;
        }

        public b D(@Nullable String str) {
            this.f374171l = str;
            return this;
        }

        public b E(String str) {
            this.f374175p = str;
            return this;
        }

        public b F(int i3) {
            this.f374174o = i3;
            return this;
        }

        public b G(@Nullable String str) {
            this.f374170k = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public q H(@NonNull q qVar, @NonNull String str) {
            w(qVar.f()).x(qVar.g()).y(qVar.h()).G(qVar.n()).C(str).A(qVar.i()).D(qVar.k()).F(qVar.m()).E(qVar.l()).m(qVar.b()).j(qVar.a()).l(qVar.e()).i(qVar.d()).h(qVar.c()).z();
            return new q(this);
        }

        public b w(@NonNull String str) {
            this.f374167h = str;
            return this;
        }

        public b x(@NonNull String str) {
            this.f374168i = str;
            return this;
        }

        public b y(@NonNull String str) {
            this.f374169j = str;
            return this;
        }

        @NonNull
        public q z() {
            return new q(this);
        }

        @Override // com.tencent.tab.exp.sdk.impl.n.a
        @NonNull
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public b k() {
            return this;
        }
    }
}
