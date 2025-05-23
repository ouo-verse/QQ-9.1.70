package kotlin.reflect.jvm.internal.impl.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WrappedValues {
    private static final Object NULL_VALUE = new Object() { // from class: kotlin.reflect.jvm.internal.impl.utils.WrappedValues.1
        public String toString() {
            return "NULL_VALUE";
        }
    };
    public static volatile boolean throwWrappedProcessCanceledException = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ThrowableWrapper {
        private final Throwable throwable;

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            String str;
            int i16;
            if (i3 != 1) {
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i3 != 1) {
                i16 = 3;
            } else {
                i16 = 2;
            }
            Object[] objArr = new Object[i16];
            if (i3 != 1) {
                objArr[0] = "throwable";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            }
            if (i3 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            } else {
                objArr[1] = "getThrowable";
            }
            if (i3 != 1) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i3 != 1) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @NotNull
        public Throwable getThrowable() {
            Throwable th5 = this.throwable;
            if (th5 == null) {
                $$$reportNull$$$0(1);
            }
            return th5;
        }

        public String toString() {
            return this.throwable.toString();
        }

        ThrowableWrapper(@NotNull Throwable th5) {
            if (th5 == null) {
                $$$reportNull$$$0(0);
            }
            this.throwable = th5;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable th5) {
            super("Rethrow stored exception", th5);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 1 && i3 != 2) {
            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i3 != 1 && i3 != 2) {
            i16 = 3;
        } else {
            i16 = 2;
        }
        Object[] objArr = new Object[i16];
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                objArr[0] = "value";
            } else {
                objArr[0] = "throwable";
            }
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        }
        if (i3 != 1 && i3 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        } else {
            objArr[1] = "escapeNull";
        }
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    objArr[2] = "unescapeNull";
                } else {
                    objArr[2] = "unescapeExceptionOrNull";
                }
            } else {
                objArr[2] = "escapeThrowable";
            }
        }
        String format = String.format(str, objArr);
        if (i3 == 1 || i3 == 2) {
            throw new IllegalStateException(format);
        }
    }

    @NotNull
    public static <V> Object escapeNull(@Nullable V v3) {
        if (v3 == null && (v3 = (V) NULL_VALUE) == null) {
            $$$reportNull$$$0(1);
        }
        return v3;
    }

    @NotNull
    public static Object escapeThrowable(@NotNull Throwable th5) {
        if (th5 == null) {
            $$$reportNull$$$0(3);
        }
        return new ThrowableWrapper(th5);
    }

    @Nullable
    public static <V> V unescapeExceptionOrNull(@NotNull Object obj) {
        if (obj == null) {
            $$$reportNull$$$0(4);
        }
        return (V) unescapeNull(unescapeThrowable(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static <V> V unescapeNull(@NotNull Object obj) {
        if (obj == 0) {
            $$$reportNull$$$0(0);
        }
        if (obj == NULL_VALUE) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static <V> V unescapeThrowable(@Nullable Object obj) {
        if (obj instanceof ThrowableWrapper) {
            Throwable throwable = ((ThrowableWrapper) obj).getThrowable();
            if (throwWrappedProcessCanceledException && ExceptionUtilsKt.isProcessCanceledException(throwable)) {
                throw new WrappedProcessCanceledException(throwable);
            }
            throw ExceptionUtilsKt.rethrow(throwable);
        }
        return obj;
    }
}
