package com.xiaomi.push;

import com.xiaomi.push.af;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fn {

    /* renamed from: a, reason: collision with root package name */
    private static af f388890a = new af(true, 20);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static class a extends af.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f388891a;

        a(Runnable runnable) {
            this.f388891a = runnable;
        }

        @Override // com.xiaomi.push.af.c
        public void b() {
            this.f388891a.run();
        }
    }

    public static void a(af.c cVar) {
        f388890a.e(cVar);
    }

    public static void b(af.c cVar, long j3) {
        f388890a.f(cVar, j3);
    }

    public static void c(Runnable runnable) {
        f388890a.e(new a(runnable));
    }
}
