package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public class ReflectProperties {

    /* loaded from: classes28.dex */
    public static class LazySoftVal<T> extends Val<T> implements Function0<T> {
        private final Function0<T> initializer;
        private volatile SoftReference<Object> value;

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        public LazySoftVal(@Nullable T t16, @NotNull Function0<T> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(0);
            }
            this.value = null;
            this.initializer = function0;
            if (t16 != null) {
                this.value = new SoftReference<>(escape(t16));
            }
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.jvm.functions.Function0
        public T invoke() {
            Object obj;
            SoftReference<Object> softReference = this.value;
            if (softReference != null && (obj = softReference.get()) != null) {
                return unescape(obj);
            }
            T invoke = this.initializer.invoke();
            this.value = new SoftReference<>(escape(invoke));
            return invoke;
        }
    }

    /* loaded from: classes28.dex */
    public static class LazyVal<T> extends Val<T> {
        private final Function0<T> initializer;
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
        }

        public LazyVal(@NotNull Function0<T> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(0);
            }
            this.value = null;
            this.initializer = function0;
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.jvm.functions.Function0
        public T invoke() {
            Object obj = this.value;
            if (obj != null) {
                return unescape(obj);
            }
            T invoke = this.initializer.invoke();
            this.value = escape(invoke);
            return invoke;
        }
    }

    /* loaded from: classes28.dex */
    public static abstract class Val<T> {
        private static final Object NULL_VALUE = new Object() { // from class: kotlin.reflect.jvm.internal.ReflectProperties.Val.1
        };

        protected Object escape(T t16) {
            if (t16 == null) {
                return NULL_VALUE;
            }
            return t16;
        }

        public final T getValue(Object obj, Object obj2) {
            return invoke();
        }

        public abstract T invoke();

        /* JADX WARN: Multi-variable type inference failed */
        protected T unescape(Object obj) {
            if (obj == NULL_VALUE) {
                return null;
            }
            return obj;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i3 != 1 && i3 != 2) {
            objArr[2] = "lazy";
        } else {
            objArr[2] = "lazySoft";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @NotNull
    public static <T> LazyVal<T> lazy(@NotNull Function0<T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(0);
        }
        return new LazyVal<>(function0);
    }

    @NotNull
    public static <T> LazySoftVal<T> lazySoft(@Nullable T t16, @NotNull Function0<T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(1);
        }
        return new LazySoftVal<>(t16, function0);
    }

    @NotNull
    public static <T> LazySoftVal<T> lazySoft(@NotNull Function0<T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(2);
        }
        return lazySoft(null, function0);
    }
}
