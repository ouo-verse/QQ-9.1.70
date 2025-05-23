package com.tencent.beacon.c.a;

import android.app.Activity;

/* compiled from: P */
/* loaded from: classes2.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f77794a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f77795b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, Activity activity) {
        this.f77795b = cVar;
        this.f77794a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        new com.tencent.beacon.c.c(this.f77794a.getApplicationContext()).a();
    }
}
