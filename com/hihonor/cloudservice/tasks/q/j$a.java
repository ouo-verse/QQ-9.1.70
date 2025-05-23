package com.hihonor.cloudservice.tasks.q;

import com.hihonor.cloudservice.tasks.g;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
class j$a implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ g f36248d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Callable f36249e;

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f36248d.d(this.f36249e.call());
        } catch (Exception e16) {
            this.f36248d.c(e16);
        }
    }
}
