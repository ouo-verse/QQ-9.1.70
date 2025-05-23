package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import java.lang.ref.SoftReference;

/* compiled from: P */
/* loaded from: classes26.dex */
abstract class TabSoftTask<T> implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final SoftReference<T> f374062d;

    /* JADX INFO: Access modifiers changed from: protected */
    public TabSoftTask(T t16) {
        this.f374062d = new SoftReference<>(t16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T e() {
        return this.f374062d.get();
    }
}
