package com.tencent.mobileqq.guild.message.api.impl.onlinepush;

import com.tencent.common.app.AppInterface;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final AppInterface f230223a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicLong f230224b = new AtomicLong(0);

    /* renamed from: c, reason: collision with root package name */
    private boolean f230225c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f230226d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f230227e = false;

    public b(AppInterface appInterface) {
        this.f230223a = appInterface;
    }

    public long a() {
        return this.f230224b.get();
    }

    public long b() {
        return this.f230224b.decrementAndGet();
    }
}
