package com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/impl/f;", "", "", "b", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInit", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f263425a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean hasInit = new AtomicBoolean(false);

    f() {
    }

    public final boolean a() {
        return hasInit.get();
    }

    public final boolean b() {
        return hasInit.compareAndSet(false, true);
    }
}
