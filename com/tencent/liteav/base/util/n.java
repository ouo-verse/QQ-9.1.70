package com.tencent.liteav.base.util;

import com.tencent.liteav.base.util.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final l.a f119041a;

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f119042b;

    n(l.a aVar, Runnable runnable) {
        this.f119041a = aVar;
        this.f119042b = runnable;
    }

    public static Runnable a(l.a aVar, Runnable runnable) {
        return new n(aVar, runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        l.a aVar = this.f119041a;
        this.f119042b.run();
        synchronized (l.this) {
            l.this.f119034c.remove(aVar);
        }
    }
}
