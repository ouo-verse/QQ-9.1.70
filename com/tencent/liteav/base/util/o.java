package com.tencent.liteav.base.util;

import com.tencent.liteav.base.util.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final l.a f119043a;

    o(l.a aVar) {
        this.f119043a = aVar;
    }

    public static Runnable a(l.a aVar) {
        return new o(aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        l.a aVar = this.f119043a;
        l.this.f119032a.execute(aVar.f119035a);
    }
}
