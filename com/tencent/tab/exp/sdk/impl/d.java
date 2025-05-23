package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tab.exp.sdk.impl.q;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d implements cd4.c {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private q f374069a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final TabExpDependInjector f374070b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final dd4.a f374071c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private TabExpDataManager f374072d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f374073e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final ReentrantReadWriteLock.ReadLock f374074f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final ReentrantReadWriteLock.WriteLock f374075g;

    public d(@NonNull q qVar, @NonNull TabExpDependInjector tabExpDependInjector) {
        this.f374069a = qVar;
        this.f374070b = tabExpDependInjector;
        this.f374071c = tabExpDependInjector.getLogImpl();
        this.f374072d = new TabExpDataManager(this.f374069a, tabExpDependInjector);
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f374074f = reentrantReadWriteLock.readLock();
        this.f374075g = reentrantReadWriteLock.writeLock();
    }

    private q g(@NonNull q qVar, @Nullable String str) {
        return new q.b().H(qVar, str);
    }

    @Override // cd4.a
    @Nullable
    public k a(@NonNull String str, boolean z16) {
        return e().a(str, z16);
    }

    @Override // cd4.b
    public boolean b(@NonNull k kVar) {
        return e().b(kVar);
    }

    @Override // cd4.a
    @Nullable
    public k c(@NonNull String str, boolean z16) {
        return e().c(str, z16);
    }

    @Override // cd4.c
    public void d(String str) {
        e().d(str);
    }

    @NonNull
    protected TabExpDataManager e() {
        this.f374074f.lock();
        try {
            return this.f374072d;
        } finally {
            this.f374074f.unlock();
        }
    }

    protected void f(String str) {
        dd4.a aVar = this.f374071c;
        if (aVar == null) {
            return;
        }
        aVar.i("TabExpComponent", x.a(this.f374069a.i(), this.f374069a.f(), this.f374069a.n(), this.f374069a.j(), str));
    }

    public void h(@Nullable kd4.a aVar) {
        f("start-----set true start");
        this.f374073e.set(true);
        f("start-----set true end");
        e().W(aVar);
        f("start-----finish");
    }

    public boolean i(@Nullable String str, @Nullable kd4.a aVar) {
        this.f374075g.lock();
        try {
            String d16 = x.d(this.f374069a.j(), "");
            String d17 = x.d(str, "");
            if (d16.equals(d17)) {
                f("switchGuid-----guid equals, not switch, finalTargetGuid = " + d17);
                this.f374075g.unlock();
                return false;
            }
            this.f374072d.Y();
            q g16 = g(this.f374069a, d17);
            TabExpDataManager tabExpDataManager = new TabExpDataManager(g16, this.f374070b);
            this.f374069a = g16;
            this.f374072d = tabExpDataManager;
            if (this.f374073e.get()) {
                this.f374072d.W(aVar);
                f("switchGuid-----startUse, finalTargetGuid = " + d17);
            }
            f("switchGuid-----finish, finalTargetGuid = " + d17);
            this.f374075g.unlock();
            return true;
        } catch (Throwable th5) {
            this.f374075g.unlock();
            throw th5;
        }
    }
}
