package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
final class Java16RecordComponentsLoader {

    @NotNull
    public static final Java16RecordComponentsLoader INSTANCE = new Java16RecordComponentsLoader();

    @Nullable
    private static Cache _cache;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Cache {

        @Nullable
        private final Method getAccessor;

        @Nullable
        private final Method getType;

        public Cache(@Nullable Method method, @Nullable Method method2) {
            this.getType = method;
            this.getAccessor = method2;
        }

        @Nullable
        public final Method getGetAccessor() {
            return this.getAccessor;
        }

        @Nullable
        public final Method getGetType() {
            return this.getType;
        }
    }

    Java16RecordComponentsLoader() {
    }

    private final Cache buildCache(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            return new Cache(cls.getMethod("getType", new Class[0]), cls.getMethod("getAccessor", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new Cache(null, null);
        }
    }

    private final Cache initCache(Object obj) {
        Cache cache = _cache;
        if (cache == null) {
            Cache buildCache = buildCache(obj);
            _cache = buildCache;
            return buildCache;
        }
        return cache;
    }

    @Nullable
    public final Method loadGetAccessor(@NotNull Object recordComponent) {
        Intrinsics.checkNotNullParameter(recordComponent, "recordComponent");
        Method getAccessor = initCache(recordComponent).getGetAccessor();
        if (getAccessor == null) {
            return null;
        }
        Object invoke = getAccessor.invoke(recordComponent, new Object[0]);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method) invoke;
    }

    @Nullable
    public final Class<?> loadGetType(@NotNull Object recordComponent) {
        Intrinsics.checkNotNullParameter(recordComponent, "recordComponent");
        Method getType = initCache(recordComponent).getGetType();
        if (getType == null) {
            return null;
        }
        Object invoke = getType.invoke(recordComponent, new Object[0]);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class) invoke;
    }
}
