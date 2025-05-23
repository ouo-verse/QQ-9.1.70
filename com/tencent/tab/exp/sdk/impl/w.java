package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes26.dex */
final class w {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f374181a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f374182b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f374183c = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        if (b() && !d()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f374181a.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f374182b.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f374183c.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        if (b() && c() && !d()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f374181a.set(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f374182b.set(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f374183c.set(true);
    }
}
