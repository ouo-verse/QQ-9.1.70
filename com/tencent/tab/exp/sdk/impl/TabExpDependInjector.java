package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TabExpDependInjector {

    @Nullable
    protected final dd4.a mLogImpl;

    @Nullable
    protected final md4.a mMetricsReportImpl;

    @Nullable
    protected final com.tencent.tab.exp.sdk.export.injector.network.a mNetworkImpl;

    @Nullable
    protected final hd4.a mReportImpl;

    @Nullable
    protected final id4.b mStorageFactoryImpl;

    @Nullable
    protected final jd4.a mThreadImpl;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        protected dd4.a f374052a = new r();

        /* renamed from: b, reason: collision with root package name */
        protected id4.b f374053b = new t();

        /* renamed from: c, reason: collision with root package name */
        protected hd4.a f374054c = new s();

        /* renamed from: d, reason: collision with root package name */
        protected jd4.a f374055d;

        /* renamed from: e, reason: collision with root package name */
        protected com.tencent.tab.exp.sdk.export.injector.network.a f374056e;

        /* renamed from: f, reason: collision with root package name */
        protected md4.a f374057f;

        public b() {
            v vVar = new v();
            this.f374055d = vVar;
            this.f374056e = new TabNetworkImpl(vVar);
            this.f374057f = new s();
        }

        @NonNull
        public TabExpDependInjector a() {
            return new TabExpDependInjector(this);
        }

        public b b(dd4.a aVar) {
            this.f374052a = aVar;
            return this;
        }

        public b c(md4.a aVar) {
            this.f374057f = aVar;
            return this;
        }

        public b d(hd4.a aVar) {
            this.f374054c = aVar;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public dd4.a getLogImpl() {
        return this.mLogImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public md4.a getMetricsReportImpl() {
        return this.mMetricsReportImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.tencent.tab.exp.sdk.export.injector.network.a getNetworkImpl() {
        return this.mNetworkImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public hd4.a getReportImpl() {
        return this.mReportImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public id4.b getStorageFactoryImpl() {
        return this.mStorageFactoryImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public jd4.a getThreadImpl() {
        return this.mThreadImpl;
    }

    TabExpDependInjector(@NonNull b bVar) {
        this.mLogImpl = bVar.f374052a;
        this.mStorageFactoryImpl = bVar.f374053b;
        this.mReportImpl = bVar.f374054c;
        this.mThreadImpl = bVar.f374055d;
        this.mNetworkImpl = bVar.f374056e;
        this.mMetricsReportImpl = bVar.f374057f;
    }
}
