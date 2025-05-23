package com.tencent.luggage.wxa.am;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f121570a;

    public c(b toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        this.f121570a = new WeakReference(toast);
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar = (b) this.f121570a.get();
        if (bVar != null) {
            bVar.dismiss();
        }
    }
}
