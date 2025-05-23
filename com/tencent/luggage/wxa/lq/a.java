package com.tencent.luggage.wxa.lq;

import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.lq.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6453a {
        public static void a(a aVar) {
            b.a(aVar);
        }

        public static a a() {
            return b.a();
        }
    }

    Future a(Runnable runnable);

    Future a(Runnable runnable, long j3);

    Future execute(Runnable runnable);
}
