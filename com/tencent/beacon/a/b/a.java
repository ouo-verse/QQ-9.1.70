package com.tencent.beacon.a.b;

import android.os.Handler;
import android.support.annotation.NonNull;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected static volatile a f77586a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f77587b = true;

    /* compiled from: P */
    /* renamed from: com.tencent.beacon.a.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0783a {

        /* renamed from: a, reason: collision with root package name */
        static final a f77588a = new k();
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f77586a == null) {
                f77586a = new k();
            }
            aVar = f77586a;
        }
        return aVar;
    }

    public static a b() {
        return C0783a.f77588a;
    }

    public abstract Handler a(int i3);

    public abstract void a(int i3, long j3, long j16, @NonNull Runnable runnable);

    public abstract void a(int i3, boolean z16);

    public abstract void a(long j3, @NonNull Runnable runnable);

    public abstract void a(@NonNull Runnable runnable);

    public abstract void a(boolean z16);

    public abstract void b(int i3);

    public boolean c() {
        return this.f77587b;
    }

    public abstract void d();

    public static synchronized void a(@NonNull ScheduledExecutorService scheduledExecutorService) {
        synchronized (a.class) {
            if (f77586a == null) {
                f77586a = new k(scheduledExecutorService);
            }
        }
    }
}
