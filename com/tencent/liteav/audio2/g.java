package com.tencent.liteav.audio2;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class g implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final e f118864a;

    g(e eVar) {
        this.f118864a = eVar;
    }

    public static Executor a(e eVar) {
        return new g(eVar);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f118864a.f118860h.a(runnable);
    }
}
