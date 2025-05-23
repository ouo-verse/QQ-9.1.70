package com.qq.e.comm.plugin.stat;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
class l {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f39721a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicInteger f39722b = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f39723c = new AtomicInteger(1);

    public static int a() {
        return f39722b.getAndIncrement();
    }
}
