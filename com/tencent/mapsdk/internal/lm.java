package com.tencent.mapsdk.internal;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class lm<T, K> {

    /* renamed from: a, reason: collision with root package name */
    private static final int f149223a = 1024;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<T, K> f149224b;

    /* renamed from: c, reason: collision with root package name */
    private int f149225c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f149226d = 1024;

    private void a(int i3) {
        this.f149226d = i3;
    }

    private synchronized void b(T t16) {
        HashMap<T, K> hashMap = this.f149224b;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(t16);
    }

    public final synchronized void a(T t16, K k3) {
        if (this.f149224b == null) {
            this.f149224b = new HashMap<>();
        }
        this.f149224b.put(t16, k3);
    }

    public final synchronized K a(T t16) {
        HashMap<T, K> hashMap = this.f149224b;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(t16);
    }
}
