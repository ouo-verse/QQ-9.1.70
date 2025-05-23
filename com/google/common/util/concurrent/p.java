package com.google.common.util.concurrent;

import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/* compiled from: P */
/* loaded from: classes2.dex */
class p<V> extends l<V> implements q<V> {

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadFactory f35207d;

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f35208e;

    static {
        ThreadFactory b16 = new u().e(true).f("ListenableFutureAdapter-thread-%d").b();
        f35207d = b16;
        f35208e = ProxyExecutors.newCachedThreadPool(b16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Future d(p pVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ j e(p pVar) {
        throw null;
    }
}
