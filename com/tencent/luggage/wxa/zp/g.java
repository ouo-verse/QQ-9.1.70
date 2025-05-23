package com.tencent.luggage.wxa.zp;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.luggage.wxa.zp.a;
import com.tencent.luggage.wxa.zp.d;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static Executor f146824a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a implements e {
        @Override // com.tencent.luggage.wxa.zp.g.e
        public void a(d.f fVar) {
            com.tencent.luggage.wxa.zp.d.f146812a = fVar;
        }

        @Override // com.tencent.luggage.wxa.zp.g.e
        public void a(d.b bVar) {
            com.tencent.luggage.wxa.zp.d.f146814c = bVar;
        }

        @Override // com.tencent.luggage.wxa.zp.g.e
        public void a(d.g gVar) {
            com.tencent.luggage.wxa.zp.d.f146813b = gVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            h.f146825d.execute(runnable);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        com.tencent.luggage.wxa.zp.a a(a.b bVar);

        void a();

        void a(e eVar);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
        void a(Thread thread, String str);

        boolean a();

        boolean b();

        boolean c();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {
        void a(d.b bVar);

        void a(d.f fVar);

        void a(d.g gVar);
    }

    public static void a(Context context, c cVar) {
        cVar.a(new a());
        com.tencent.luggage.wxa.zp.a a16 = cVar.a(new a.b());
        com.tencent.luggage.wxa.cq.b.f123843a = new com.tencent.luggage.wxa.bq.a(context, a16);
        com.tencent.luggage.wxa.gq.h.f126817a = com.tencent.luggage.wxa.gq.h.a(a16);
        h.a(context, a16);
        if (a16.f146785h) {
            a();
        }
        if (a16.f146786i) {
            try {
                Class.forName("com.tencent.threadpool.coroutines.hook.CoroutineDispatchersHookInitializer").getDeclaredMethod(ColorRingJsPlugin.Method_SetUp, new Class[0]).invoke(null, new Object[0]);
            } catch (ClassNotFoundException unused) {
                throw new IllegalArgumentException("Cannot enable hook coroutines dispatchers without depending threadpool-coroutines.");
            } catch (NoSuchMethodException unused2) {
                throw new IllegalStateException("ThreadPool internal error. Cannot find method setup in coroutines dispatchers hook initializer.");
            } catch (Exception unused3) {
                throw new IllegalStateException("ThreadPool internal error. Cannot call method setup in coroutines dispatchers hook initializer.");
            }
        }
        cVar.a();
    }

    public static void a() {
        try {
            f146824a = (Executor) com.tencent.luggage.wxa.mq.c.a(AsyncTask.class, "THREAD_POOL_EXECUTOR");
            com.tencent.luggage.wxa.mq.c.a(AsyncTask.class, "THREAD_POOL_EXECUTOR", new b());
        } catch (Exception e16) {
            com.tencent.luggage.wxa.zp.d.f146814c.e("ThreadModuleBoot", e16.toString(), new Object[0]);
        }
    }
}
