package com.tencent.beacon.d;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f77853a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(h hVar) {
        this.f77853a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        context = this.f77853a.f77858c;
        if (context != null) {
            h hVar = this.f77853a;
            context2 = hVar.f77858c;
            hVar.a(context2);
        }
    }
}
