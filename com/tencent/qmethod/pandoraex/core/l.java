package com.tencent.qmethod.pandoraex.core;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class l<T> {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, T> f344143a = new ConcurrentHashMap<>();

    public T a(String str, T t16) {
        T t17 = this.f344143a.get(str);
        if (t17 != null) {
            return t17;
        }
        return t16;
    }

    public void b(String str, T t16) {
        this.f344143a.put(str, t16);
    }
}
