package com.xingin.xhssharesdk.p;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f390000a;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }
    }

    /* compiled from: P */
    /* renamed from: com.xingin.xhssharesdk.p.b$b, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static class RunnableC10098b implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public final SoftReference<Runnable> f390001d;

        public RunnableC10098b(Runnable runnable) {
            this.f390001d = new SoftReference<>(runnable);
        }

        @Override // java.lang.Runnable
        public final void run() {
            Runnable runnable = this.f390001d.get();
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public static void a(Runnable runnable) {
        if (f390000a == null) {
            f390000a = new a();
        }
        f390000a.post(new RunnableC10098b(runnable));
    }
}
