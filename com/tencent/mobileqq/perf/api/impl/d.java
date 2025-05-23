package com.tencent.mobileqq.perf.api.impl;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/perf/api/impl/d;", "", "", "a", "", "b", "", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "count", "<init>", "(Ljava/lang/String;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String tag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger count;

    public d(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
        this.count = new AtomicInteger(1);
    }

    public final int a() {
        return this.count.incrementAndGet();
    }

    public final boolean b() {
        return this.count.decrementAndGet() == 0;
    }
}
