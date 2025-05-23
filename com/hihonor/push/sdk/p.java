package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class p implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f36418a;

    public p(s sVar) {
        this.f36418a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.f36418a.f36428b.a(true);
        return null;
    }
}
