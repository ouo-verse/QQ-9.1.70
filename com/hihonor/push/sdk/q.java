package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class q implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f36420a;

    public q(s sVar) {
        this.f36420a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.f36420a.f36428b.a(false);
        return null;
    }
}
