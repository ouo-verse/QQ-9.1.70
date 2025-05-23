package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes26.dex */
abstract class n {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f374138a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f374139b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f374140c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final Set<String> f374141d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final Map<String, String> f374142e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private final Map<String, String> f374143f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private final Map<String, String> f374144g;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    protected static abstract class a<SettingBuilder extends a<SettingBuilder, Setting>, Setting extends n> {

        /* renamed from: a, reason: collision with root package name */
        private boolean f374145a = true;

        /* renamed from: b, reason: collision with root package name */
        private boolean f374146b = false;

        /* renamed from: c, reason: collision with root package name */
        private boolean f374147c = true;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private Set<String> f374148d = com.tencent.tab.exp.sdk.impl.a.f374064b;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        private Map<String, String> f374149e = com.tencent.tab.exp.sdk.impl.a.f374065c;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private Map<String, String> f374150f = com.tencent.tab.exp.sdk.impl.a.f374066d;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        private Map<String, String> f374151g = com.tencent.tab.exp.sdk.impl.a.f374067e;

        public SettingBuilder h(boolean z16) {
            this.f374147c = z16;
            return k();
        }

        public SettingBuilder i(boolean z16) {
            this.f374146b = z16;
            return k();
        }

        public SettingBuilder j(@Nullable Map<String, String> map) {
            this.f374151g = map;
            return k();
        }

        @NonNull
        protected abstract SettingBuilder k();

        public SettingBuilder l(boolean z16) {
            this.f374145a = z16;
            return k();
        }

        public SettingBuilder m(@Nullable Map<String, String> map) {
            this.f374149e = map;
            return k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public n(@NonNull a aVar) {
        this.f374138a = aVar.f374145a;
        this.f374139b = aVar.f374146b;
        this.f374140c = aVar.f374147c;
        this.f374141d = aVar.f374148d;
        this.f374142e = aVar.f374149e;
        this.f374143f = aVar.f374150f;
        this.f374144g = aVar.f374151g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Map<String, String> a() {
        return this.f374144g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Map<String, String> b() {
        return this.f374142e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f374140c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f374139b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f374138a;
    }
}
