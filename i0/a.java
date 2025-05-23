package i0;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final g<Object> f406980a = new C10495a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class b<T> implements d<List<T>> {
        b() {
        }

        @Override // i0.a.d
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> create() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class c<T> implements g<List<T>> {
        c() {
        }

        @Override // i0.a.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull List<T> list) {
            list.clear();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface d<T> {
        T create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class e<T> implements Pools.Pool<T> {

        /* renamed from: a, reason: collision with root package name */
        private final d<T> f406981a;

        /* renamed from: b, reason: collision with root package name */
        private final g<T> f406982b;

        /* renamed from: c, reason: collision with root package name */
        private final Pools.Pool<T> f406983c;

        e(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
            this.f406983c = pool;
            this.f406981a = dVar;
            this.f406982b = gVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.f406983c.acquire();
            if (acquire == null) {
                acquire = this.f406981a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof f) {
                acquire.h().b(false);
            }
            return (T) acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t16) {
            if (t16 instanceof f) {
                ((f) t16).h().b(true);
            }
            this.f406982b.a(t16);
            return this.f406983c.release(t16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface f {
        @NonNull
        i0.c h();
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface g<T> {
        void a(@NonNull T t16);
    }

    @NonNull
    private static <T extends f> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar) {
        return b(pool, dVar, c());
    }

    @NonNull
    private static <T> Pools.Pool<T> b(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
        return new e(pool, dVar, gVar);
    }

    @NonNull
    private static <T> g<T> c() {
        return (g<T>) f406980a;
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> d(int i3, @NonNull d<T> dVar) {
        return a(new Pools.SynchronizedPool(i3), dVar);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> e() {
        return f(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> f(int i3) {
        return b(new Pools.SynchronizedPool(i3), new b(), new c());
    }

    /* compiled from: P */
    /* renamed from: i0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C10495a implements g<Object> {
        C10495a() {
        }

        @Override // i0.a.g
        public void a(@NonNull Object obj) {
        }
    }
}
