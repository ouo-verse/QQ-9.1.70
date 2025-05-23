package com.tencent.mobileqq.vasgift.mvvm.business;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f311842a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f311843b = false;

    public f(T t16) {
        if (t16 != null) {
            this.f311842a = t16;
            return;
        }
        throw new IllegalArgumentException("null values in Event are not allowed.");
    }

    public T a() {
        return this.f311842a;
    }

    @Nullable
    public T b() {
        if (this.f311843b) {
            return null;
        }
        this.f311843b = true;
        return this.f311842a;
    }
}
