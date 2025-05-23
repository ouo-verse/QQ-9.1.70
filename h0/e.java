package h0;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Executor f403952a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final Executor f403953b = new b();

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            k.t(runnable);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return f403953b;
    }

    public static Executor b() {
        return f403952a;
    }
}
