package com.tencent.mobileqq.vas.utils;

import com.tencent.mobileqq.vas.utils.CacheHelper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0011\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/utils/CacheHelper;", "", "T", "Lcom/tencent/mobileqq/vas/utils/CacheHelper$AbsOptions;", "options", "a", "(Lcom/tencent/mobileqq/vas/utils/CacheHelper$AbsOptions;)Ljava/lang/Object;", "Ljava/util/concurrent/locks/ReadWriteLock;", "b", "Ljava/util/concurrent/locks/ReadWriteLock;", "cacheLock", "Lcom/tencent/mobileqq/vas/utils/CacheHelper$a;", "c", "Lcom/tencent/mobileqq/vas/utils/CacheHelper$a;", "objectCache", "<init>", "()V", "AbsOptions", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class CacheHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CacheHelper f311233a = new CacheHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ReadWriteLock cacheLock = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a objectCache = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0001H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0001H\u0016R\u001b\u0010\u000b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/utils/CacheHelper$AbsOptions;", "", "", "b", "a", "o", "", "d", "Lkotlin/Lazy;", "c", "()Ljava/lang/String;", "key", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static abstract class AbsOptions {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy key;

        public AbsOptions() {
            Lazy lazy;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.vas.utils.CacheHelper$AbsOptions$key$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return CacheHelper.AbsOptions.this.b();
                }
            });
            this.key = lazy;
        }

        @NotNull
        public abstract Object a();

        @NotNull
        public abstract String b();

        @NotNull
        public final String c() {
            return (String) this.key.getValue();
        }

        public boolean d(@NotNull Object o16) {
            Intrinsics.checkNotNullParameter(o16, "o");
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001R<\u0010\f\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t0\bj\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/utils/CacheHelper$a;", "", "", "key", "a", "o", "", "b", "Ljava/util/HashMap;", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "cache", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final HashMap<String, WeakReference<Object>> cache = new HashMap<>();

        @Nullable
        public final Object a(@Nullable String key) {
            WeakReference<Object> weakReference = this.cache.get(key);
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public final void b(@NotNull String key, @NotNull Object o16) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(o16, "o");
            this.cache.put(key, new WeakReference<>(o16));
        }
    }

    CacheHelper() {
    }

    @JvmStatic
    @NotNull
    public static final <T> T a(@NotNull AbsOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        String c16 = options.c();
        try {
            ReadWriteLock readWriteLock = cacheLock;
            readWriteLock.readLock().lock();
            a aVar = objectCache;
            T t16 = (T) aVar.a(c16);
            if (t16 != null) {
                if (options.d(t16)) {
                    readWriteLock.readLock().unlock();
                    return t16;
                }
            }
            readWriteLock.readLock().unlock();
            try {
                readWriteLock.writeLock().lock();
                T t17 = (T) aVar.a(c16);
                if (t17 != null && options.d(t17)) {
                    readWriteLock.writeLock().unlock();
                    return t17;
                }
                T t18 = (T) options.a();
                aVar.b(c16, t18);
                Intrinsics.checkNotNull(t18, "null cannot be cast to non-null type T of com.tencent.mobileqq.vas.utils.CacheHelper.getObject");
                readWriteLock.writeLock().unlock();
                return t18;
            } catch (Throwable th5) {
                cacheLock.writeLock().unlock();
                throw th5;
            }
        } catch (Throwable th6) {
            cacheLock.readLock().unlock();
            throw th6;
        }
    }
}
