package com.vivo.push;

import com.vivo.push.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* renamed from: com.vivo.push.r, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class RunnableC11730r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f387762a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ m f387763b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC11730r(m mVar, String str) {
        this.f387763b = mVar;
        this.f387762a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.a b16;
        b16 = this.f387763b.b(this.f387762a);
        if (b16 != null) {
            b16.a(1003, new Object[0]);
        }
    }
}
