package com.tencent.luggage.wxa.xi;

import com.tencent.luggage.wxa.mc.g0;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.luggage.wxa.zp.i;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface d {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final Executor f145006a = new ExecutorC6913a();

        /* renamed from: b, reason: collision with root package name */
        public static final Executor f145007b;

        /* renamed from: c, reason: collision with root package name */
        public static final Executor f145008c;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.xi.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class ExecutorC6913a implements Executor {
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                Objects.requireNonNull(runnable);
                runnable.run();
            }

            public String toString() {
                return "ImmediateExecutor@" + hashCode();
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class b implements Executor {
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                i iVar = h.f146825d;
                Objects.requireNonNull(runnable);
                iVar.execute(runnable);
            }

            public String toString() {
                return "ThreadPoolExecutor@" + hashCode();
            }
        }

        static {
            b bVar = new b();
            f145007b = bVar;
            f145008c = bVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a(g0 g0Var);

        void a(boolean z16, List list);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public static volatile c f145009a;

        public abstract d a(com.tencent.luggage.wxa.ic.g gVar, String str, String str2);

        public abstract void a(String str);
    }

    void a(b bVar);

    void a(Executor executor);
}
