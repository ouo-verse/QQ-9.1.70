package kotlin.reflect.jvm.internal.impl.storage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.StringsKt__StringsKt;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LockBasedStorageManager implements StorageManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final StorageManager NO_LOCKS;
    private static final String PACKAGE_NAME;
    private final String debugText;
    private final ExceptionHandlingStrategy exceptionHandlingStrategy;
    protected final SimpleLock lock;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V> extends CacheWithNullableValuesBasedOnMemoizedFunction<K, V> implements CacheWithNotNullValues<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            String str;
            int i16;
            if (i3 != 3) {
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i3 != 3) {
                i16 = 3;
            } else {
                i16 = 2;
            }
            Object[] objArr = new Object[i16];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        objArr[0] = "storageManager";
                    } else {
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
                    }
                } else {
                    objArr[0] = "computation";
                }
            } else {
                objArr[0] = "map";
            }
            if (i3 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    objArr[2] = "<init>";
                }
            } else {
                objArr[2] = "computeIfAbsent";
            }
            String format = String.format(str, objArr);
            if (i3 != 3) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction, kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues
        @NotNull
        public V computeIfAbsent(K k3, @NotNull Function0<? extends V> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(2);
            }
            V v3 = (V) super.computeIfAbsent(k3, function0);
            if (v3 == null) {
                $$$reportNull$$$0(3);
            }
            return v3;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        CacheWithNotNullValuesBasedOnMemoizedFunction(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<KeyWithComputation<K, V>, Object> concurrentMap) {
            super(concurrentMap);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V> extends MapBasedMemoizedFunction<KeyWithComputation<K, V>, V> implements CacheWithNullableValues<K, V> {
        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            Object[] objArr = new Object[3];
            if (i3 != 1) {
                if (i3 != 2) {
                    objArr[0] = "storageManager";
                } else {
                    objArr[0] = "computation";
                }
            } else {
                objArr[0] = "map";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i3 != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Nullable
        public V computeIfAbsent(K k3, @NotNull Function0<? extends V> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(2);
            }
            return invoke(new KeyWithComputation(k3, function0));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        CacheWithNullableValuesBasedOnMemoizedFunction(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<KeyWithComputation<K, V>, Object> concurrentMap) {
            super(lockBasedStorageManager, concurrentMap, new Function1<KeyWithComputation<K, V>, V>() { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction.1
                @Override // kotlin.jvm.functions.Function1
                public V invoke(KeyWithComputation<K, V> keyWithComputation) {
                    return (V) ((KeyWithComputation) keyWithComputation).computation.invoke();
                }
            });
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = new ExceptionHandlingStrategy() { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy.1
            private static /* synthetic */ void $$$reportNull$$$0(int i3) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy
            @NotNull
            public RuntimeException handleException(@NotNull Throwable th5) {
                if (th5 == null) {
                    $$$reportNull$$$0(0);
                }
                throw ExceptionUtilsKt.rethrow(th5);
            }
        };

        @NotNull
        RuntimeException handleException(@NotNull Throwable th5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class KeyWithComputation<K, V> {
        private final Function0<? extends V> computation;
        private final K key;

        public KeyWithComputation(K k3, Function0<? extends V> function0) {
            this.key = k3;
            this.computation = function0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass() && this.key.equals(((KeyWithComputation) obj).key)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.key.hashCode();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static abstract class LockBasedLazyValueWithPostCompute<T> extends LockBasedLazyValue<T> {

        @Nullable
        private volatile SingleThreadValue<T> valuePostCompute;

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            Object[] objArr = new Object[3];
            if (i3 != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedLazyValueWithPostCompute(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
            this.valuePostCompute = null;
        }

        protected abstract void doPostCompute(T t16);

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            SingleThreadValue<T> singleThreadValue = this.valuePostCompute;
            if (singleThreadValue != null && singleThreadValue.hasValue()) {
                return singleThreadValue.getValue();
            }
            return (T) super.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
        protected final void postCompute(T t16) {
            this.valuePostCompute = new SingleThreadValue<>(t16);
            try {
                doPostCompute(t16);
            } finally {
                this.valuePostCompute = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class LockBasedNotNullLazyValue<T> extends LockBasedLazyValue<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            String str;
            int i16;
            if (i3 != 2) {
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i3 != 2) {
                i16 = 3;
            } else {
                i16 = 2;
            }
            Object[] objArr = new Object[i16];
            if (i3 != 1) {
                if (i3 != 2) {
                    objArr[0] = "storageManager";
                } else {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
                }
            } else {
                objArr[0] = "computable";
            }
            if (i3 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i3 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i3 != 2) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedNotNullLazyValue(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        @NotNull
        public T invoke() {
            T t16 = (T) super.invoke();
            if (t16 == null) {
                $$$reportNull$$$0(2);
            }
            return t16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static abstract class LockBasedNotNullLazyValueWithPostCompute<T> extends LockBasedLazyValueWithPostCompute<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            String str;
            int i16;
            if (i3 != 2) {
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i3 != 2) {
                i16 = 3;
            } else {
                i16 = 2;
            }
            Object[] objArr = new Object[i16];
            if (i3 != 1) {
                if (i3 != 2) {
                    objArr[0] = "storageManager";
                } else {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
                }
            } else {
                objArr[0] = "computable";
            }
            if (i3 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i3 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i3 != 2) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedNotNullLazyValueWithPostCompute(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        @NotNull
        public T invoke() {
            T t16 = (T) super.invoke();
            if (t16 == null) {
                $$$reportNull$$$0(2);
            }
            return t16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNullable<K, V> {
        private final ConcurrentMap<K, Object> cache;
        private final Function1<? super K, ? extends V> compute;
        private final LockBasedStorageManager storageManager;

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            String str;
            int i16;
            if (i3 != 3 && i3 != 4) {
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i3 != 3 && i3 != 4) {
                i16 = 3;
            } else {
                i16 = 2;
            }
            Object[] objArr = new Object[i16];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3 && i3 != 4) {
                        objArr[0] = "storageManager";
                    } else {
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
                    }
                } else {
                    objArr[0] = "compute";
                }
            } else {
                objArr[0] = "map";
            }
            if (i3 != 3) {
                if (i3 != 4) {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
                } else {
                    objArr[1] = "raceCondition";
                }
            } else {
                objArr[1] = "recursionDetected";
            }
            if (i3 != 3 && i3 != 4) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i3 == 3 || i3 == 4) {
                throw new IllegalStateException(format);
            }
        }

        public MapBasedMemoizedFunction(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<K, Object> concurrentMap, @NotNull Function1<? super K, ? extends V> function1) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
            if (function1 == null) {
                $$$reportNull$$$0(2);
            }
            this.storageManager = lockBasedStorageManager;
            this.cache = concurrentMap;
            this.compute = function1;
        }

        @NotNull
        private AssertionError raceCondition(K k3, Object obj) {
            AssertionError assertionError = (AssertionError) LockBasedStorageManager.sanitizeStackTrace(new AssertionError("Race condition detected on input " + k3 + ". Old value is " + obj + " under " + this.storageManager));
            if (assertionError == null) {
                $$$reportNull$$$0(4);
            }
            return assertionError;
        }

        protected LockBasedStorageManager getStorageManager() {
            return this.storageManager;
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public V invoke(K k3) {
            V v3;
            Object obj = this.cache.get(k3);
            if (obj != null && obj != NotValue.COMPUTING) {
                return (V) WrappedValues.unescapeExceptionOrNull(obj);
            }
            this.storageManager.lock.lock();
            try {
                Object obj2 = this.cache.get(k3);
                NotValue notValue = NotValue.COMPUTING;
                if (obj2 == notValue) {
                    obj2 = NotValue.RECURSION_WAS_DETECTED;
                    RecursionDetectedResult<V> recursionDetected = recursionDetected(k3, true);
                    if (!recursionDetected.isFallThrough()) {
                        v3 = recursionDetected.getValue();
                        return v3;
                    }
                }
                if (obj2 == NotValue.RECURSION_WAS_DETECTED) {
                    RecursionDetectedResult<V> recursionDetected2 = recursionDetected(k3, false);
                    if (!recursionDetected2.isFallThrough()) {
                        v3 = recursionDetected2.getValue();
                        return v3;
                    }
                }
                if (obj2 != null) {
                    v3 = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                    return v3;
                }
                AssertionError assertionError = null;
                try {
                    this.cache.put(k3, notValue);
                    V invoke = this.compute.invoke(k3);
                    Object put = this.cache.put(k3, WrappedValues.escapeNull(invoke));
                    if (put == notValue) {
                        return invoke;
                    }
                    assertionError = raceCondition(k3, put);
                    throw assertionError;
                } catch (Throwable th5) {
                    if (!ExceptionUtilsKt.isProcessCanceledException(th5)) {
                        if (th5 != assertionError) {
                            Object put2 = this.cache.put(k3, WrappedValues.escapeThrowable(th5));
                            if (put2 != NotValue.COMPUTING) {
                                throw raceCondition(k3, put2);
                            }
                            throw this.storageManager.exceptionHandlingStrategy.handleException(th5);
                        }
                        throw this.storageManager.exceptionHandlingStrategy.handleException(th5);
                    }
                    this.cache.remove(k3);
                    throw th5;
                }
            } finally {
                this.storageManager.lock.unlock();
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable
        public boolean isComputed(K k3) {
            Object obj = this.cache.get(k3);
            if (obj != null && obj != NotValue.COMPUTING) {
                return true;
            }
            return false;
        }

        @NotNull
        protected RecursionDetectedResult<V> recursionDetected(K k3, boolean z16) {
            RecursionDetectedResult<V> recursionDetectedDefault = this.storageManager.recursionDetectedDefault("", k3);
            if (recursionDetectedDefault == null) {
                $$$reportNull$$$0(3);
            }
            return recursionDetectedDefault;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class MapBasedMemoizedFunctionToNotNull<K, V> extends MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNotNull<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            String str;
            int i16;
            if (i3 != 3) {
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i3 != 3) {
                i16 = 3;
            } else {
                i16 = 2;
            }
            Object[] objArr = new Object[i16];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        objArr[0] = "storageManager";
                    } else {
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
                    }
                } else {
                    objArr[0] = "compute";
                }
            } else {
                objArr[0] = "map";
            }
            if (i3 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i3 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i3 != 3) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MapBasedMemoizedFunctionToNotNull(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<K, Object> concurrentMap, @NotNull Function1<? super K, ? extends V> function1) {
            super(lockBasedStorageManager, concurrentMap, function1);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
            if (function1 == null) {
                $$$reportNull$$$0(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunction, kotlin.jvm.functions.Function1
        @NotNull
        public V invoke(K k3) {
            V v3 = (V) super.invoke(k3);
            if (v3 == null) {
                $$$reportNull$$$0(3);
            }
            return v3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum NotValue {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class RecursionDetectedResult<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean fallThrough;
        private final T value;

        RecursionDetectedResult(T t16, boolean z16) {
            this.value = t16;
            this.fallThrough = z16;
        }

        @NotNull
        public static <T> RecursionDetectedResult<T> fallThrough() {
            return new RecursionDetectedResult<>(null, true);
        }

        @NotNull
        public static <T> RecursionDetectedResult<T> value(T t16) {
            return new RecursionDetectedResult<>(t16, false);
        }

        public T getValue() {
            return this.value;
        }

        public boolean isFallThrough() {
            return this.fallThrough;
        }

        public String toString() {
            if (isFallThrough()) {
                return "FALL_THROUGH";
            }
            return String.valueOf(this.value);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        String format;
        if (i3 != 10 && i3 != 13 && i3 != 20 && i3 != 37) {
            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i3 != 10 && i3 != 13 && i3 != 20 && i3 != 37) {
            i16 = 3;
        } else {
            i16 = 2;
        }
        Object[] objArr = new Object[i16];
        if (i3 != 1 && i3 != 3 && i3 != 5) {
            if (i3 != 6) {
                switch (i3) {
                    case 8:
                        break;
                    case 9:
                    case 11:
                    case 14:
                    case 16:
                    case 19:
                    case 21:
                        objArr[0] = "compute";
                        break;
                    case 10:
                    case 13:
                    case 20:
                    case 37:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                        break;
                    case 12:
                    case 17:
                    case 25:
                    case 27:
                        objArr[0] = "onRecursiveCall";
                        break;
                    case 15:
                    case 18:
                    case 22:
                        objArr[0] = "map";
                        break;
                    case 23:
                    case 24:
                    case 26:
                    case 28:
                    case 30:
                    case 31:
                    case 32:
                    case 34:
                        objArr[0] = "computable";
                        break;
                    case 29:
                    case 33:
                        objArr[0] = "postCompute";
                        break;
                    case 35:
                        objArr[0] = "source";
                        break;
                    case 36:
                        objArr[0] = "throwable";
                        break;
                    default:
                        objArr[0] = "debugText";
                        break;
                }
            } else {
                objArr[0] = JoinPoint.SYNCHRONIZATION_LOCK;
            }
            if (i3 == 10 && i3 != 13) {
                if (i3 != 20) {
                    if (i3 != 37) {
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                    } else {
                        objArr[1] = "sanitizeStackTrace";
                    }
                } else {
                    objArr[1] = "createMemoizedFunctionWithNullableValues";
                }
            } else {
                objArr[1] = "createMemoizedFunction";
            }
            switch (i3) {
                case 4:
                case 5:
                case 6:
                    objArr[2] = "<init>";
                    break;
                case 7:
                case 8:
                    objArr[2] = "replaceExceptionHandling";
                    break;
                case 9:
                case 11:
                case 12:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                    objArr[2] = "createMemoizedFunction";
                    break;
                case 10:
                case 13:
                case 20:
                case 37:
                    break;
                case 19:
                case 21:
                case 22:
                    objArr[2] = "createMemoizedFunctionWithNullableValues";
                    break;
                case 23:
                case 24:
                case 25:
                    objArr[2] = "createLazyValue";
                    break;
                case 26:
                case 27:
                    objArr[2] = "createRecursionTolerantLazyValue";
                    break;
                case 28:
                case 29:
                    objArr[2] = "createLazyValueWithPostCompute";
                    break;
                case 30:
                    objArr[2] = "createNullableLazyValue";
                    break;
                case 31:
                    objArr[2] = "createRecursionTolerantNullableLazyValue";
                    break;
                case 32:
                case 33:
                    objArr[2] = "createNullableLazyValueWithPostCompute";
                    break;
                case 34:
                    objArr[2] = "compute";
                    break;
                case 35:
                    objArr[2] = "recursionDetectedDefault";
                    break;
                case 36:
                    objArr[2] = "sanitizeStackTrace";
                    break;
                default:
                    objArr[2] = "createWithExceptionHandling";
                    break;
            }
            format = String.format(str, objArr);
            if (i3 != 10 || i3 == 13 || i3 == 20 || i3 == 37) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }
        objArr[0] = "exceptionHandlingStrategy";
        if (i3 == 10) {
        }
        objArr[1] = "createMemoizedFunction";
        switch (i3) {
        }
        format = String.format(str, objArr);
        if (i3 != 10) {
        }
        throw new IllegalStateException(format);
    }

    static {
        String substringBeforeLast;
        substringBeforeLast = StringsKt__StringsKt.substringBeforeLast(LockBasedStorageManager.class.getCanonicalName(), ".", "");
        PACKAGE_NAME = substringBeforeLast;
        NO_LOCKS = new LockBasedStorageManager("NO_LOCKS", ExceptionHandlingStrategy.THROW, EmptySimpleLock.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.1
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
                    objArr[0] = "source";
                } else {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
                }
                if (i3 != 1) {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
                } else {
                    objArr[1] = "recursionDetectedDefault";
                }
                if (i3 != 1) {
                    objArr[2] = "recursionDetectedDefault";
                }
                String format = String.format(str, objArr);
                if (i3 != 1) {
                    throw new IllegalArgumentException(format);
                }
                throw new IllegalStateException(format);
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager
            @NotNull
            protected <K, V> RecursionDetectedResult<V> recursionDetectedDefault(@NotNull String str, K k3) {
                if (str == null) {
                    $$$reportNull$$$0(0);
                }
                RecursionDetectedResult<V> fallThrough = RecursionDetectedResult.fallThrough();
                if (fallThrough == null) {
                    $$$reportNull$$$0(1);
                }
                return fallThrough;
            }
        };
    }

    @NotNull
    private static <K> ConcurrentMap<K, Object> createConcurrentHashMap() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public static <T extends Throwable> T sanitizeStackTrace(@NotNull T t16) {
        if (t16 == null) {
            $$$reportNull$$$0(36);
        }
        StackTraceElement[] stackTrace = t16.getStackTrace();
        int length = stackTrace.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                if (!stackTrace[i3].getClassName().startsWith(PACKAGE_NAME)) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i3, length);
        t16.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t16;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> T compute(@NotNull Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(34);
        }
        this.lock.lock();
        try {
            return function0.invoke();
        } finally {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return new CacheWithNotNullValuesBasedOnMemoizedFunction(createConcurrentHashMap());
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues() {
        return new CacheWithNullableValuesBasedOnMemoizedFunction(createConcurrentHashMap());
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <T> NotNullLazyValue<T> createLazyValue(@NotNull Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(23);
        }
        return new LockBasedNotNullLazyValue(this, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(@NotNull Function0<? extends T> function0, final Function1<? super Boolean, ? extends T> function1, @NotNull final Function1<? super T, Unit> function12) {
        if (function0 == null) {
            $$$reportNull$$$0(28);
        }
        if (function12 == null) {
            $$$reportNull$$$0(29);
        }
        return new LockBasedNotNullLazyValueWithPostCompute<T>(this, function0) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.5
            private static /* synthetic */ void $$$reportNull$$$0(int i3) {
                String str;
                int i16;
                if (i3 != 2) {
                    str = "@NotNull method %s.%s must not return null";
                } else {
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                }
                if (i3 != 2) {
                    i16 = 2;
                } else {
                    i16 = 3;
                }
                Object[] objArr = new Object[i16];
                if (i3 != 2) {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                } else {
                    objArr[0] = "value";
                }
                if (i3 != 2) {
                    objArr[1] = "recursionDetected";
                } else {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                }
                if (i3 == 2) {
                    objArr[2] = "doPostCompute";
                }
                String format = String.format(str, objArr);
                if (i3 != 2) {
                    throw new IllegalStateException(format);
                }
                throw new IllegalArgumentException(format);
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute
            protected void doPostCompute(@NotNull T t16) {
                if (t16 == null) {
                    $$$reportNull$$$0(2);
                }
                function12.invoke(t16);
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
            @NotNull
            protected RecursionDetectedResult<T> recursionDetected(boolean z16) {
                Function1 function13 = function1;
                if (function13 == null) {
                    RecursionDetectedResult<T> recursionDetected = super.recursionDetected(z16);
                    if (recursionDetected == null) {
                        $$$reportNull$$$0(0);
                    }
                    return recursionDetected;
                }
                RecursionDetectedResult<T> value = RecursionDetectedResult.value(function13.invoke(Boolean.valueOf(z16)));
                if (value == null) {
                    $$$reportNull$$$0(1);
                }
                return value;
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(9);
        }
        MemoizedFunctionToNotNull<K, V> createMemoizedFunction = createMemoizedFunction(function1, createConcurrentHashMap());
        if (createMemoizedFunction == null) {
            $$$reportNull$$$0(10);
        }
        return createMemoizedFunction;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(19);
        }
        MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues = createMemoizedFunctionWithNullableValues(function1, createConcurrentHashMap());
        if (createMemoizedFunctionWithNullableValues == null) {
            $$$reportNull$$$0(20);
        }
        return createMemoizedFunctionWithNullableValues;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <T> NullableLazyValue<T> createNullableLazyValue(@NotNull Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(30);
        }
        return new LockBasedLazyValue(this, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(@NotNull Function0<? extends T> function0, @NotNull final T t16) {
        if (function0 == null) {
            $$$reportNull$$$0(26);
        }
        if (t16 == null) {
            $$$reportNull$$$0(27);
        }
        return new LockBasedNotNullLazyValue<T>(this, function0) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.4
            private static /* synthetic */ void $$$reportNull$$$0(int i3) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
            @NotNull
            protected RecursionDetectedResult<T> recursionDetected(boolean z16) {
                RecursionDetectedResult<T> value = RecursionDetectedResult.value(t16);
                if (value == null) {
                    $$$reportNull$$$0(0);
                }
                return value;
            }
        };
    }

    @NotNull
    protected <K, V> RecursionDetectedResult<V> recursionDetectedDefault(@NotNull String str, K k3) {
        String str2;
        if (str == null) {
            $$$reportNull$$$0(35);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Recursion detected ");
        sb5.append(str);
        if (k3 == null) {
            str2 = "";
        } else {
            str2 = "on input: " + k3;
        }
        sb5.append(str2);
        sb5.append(" under ");
        sb5.append(this);
        throw ((AssertionError) sanitizeStackTrace(new AssertionError(sb5.toString())));
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.debugText + ")";
    }

    LockBasedStorageManager(@NotNull String str, @NotNull ExceptionHandlingStrategy exceptionHandlingStrategy, @NotNull SimpleLock simpleLock) {
        if (str == null) {
            $$$reportNull$$$0(4);
        }
        if (exceptionHandlingStrategy == null) {
            $$$reportNull$$$0(5);
        }
        if (simpleLock == null) {
            $$$reportNull$$$0(6);
        }
        this.lock = simpleLock;
        this.exceptionHandlingStrategy = exceptionHandlingStrategy;
        this.debugText = str;
    }

    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> function1, @NotNull ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            $$$reportNull$$$0(14);
        }
        if (concurrentMap == null) {
            $$$reportNull$$$0(15);
        }
        return new MapBasedMemoizedFunctionToNotNull(this, concurrentMap, function1);
    }

    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> function1, @NotNull ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            $$$reportNull$$$0(21);
        }
        if (concurrentMap == null) {
            $$$reportNull$$$0(22);
        }
        return new MapBasedMemoizedFunction(this, concurrentMap, function1);
    }

    public LockBasedStorageManager(String str) {
        this(str, (Runnable) null, (Function1<InterruptedException, Unit>) null);
    }

    public LockBasedStorageManager(String str, @Nullable Runnable runnable, @Nullable Function1<InterruptedException, Unit> function1) {
        this(str, ExceptionHandlingStrategy.THROW, SimpleLock.Companion.simpleLock(runnable, function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class LockBasedLazyValue<T> implements NullableLazyValue<T> {
        private final Function0<? extends T> computable;
        private final LockBasedStorageManager storageManager;

        @Nullable
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            String str;
            int i16;
            if (i3 != 2 && i3 != 3) {
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i3 != 2 && i3 != 3) {
                i16 = 3;
            } else {
                i16 = 2;
            }
            Object[] objArr = new Object[i16];
            if (i3 != 1) {
                if (i3 != 2 && i3 != 3) {
                    objArr[0] = "storageManager";
                } else {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
                }
            } else {
                objArr[0] = "computable";
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
                } else {
                    objArr[1] = "renderDebugInformation";
                }
            } else {
                objArr[1] = "recursionDetected";
            }
            if (i3 != 2 && i3 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i3 == 2 || i3 == 3) {
                throw new IllegalStateException(format);
            }
        }

        public LockBasedLazyValue(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
            this.value = NotValue.NOT_COMPUTED;
            this.storageManager = lockBasedStorageManager;
            this.computable = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public T invoke() {
            T invoke;
            Object obj = this.value;
            if (!(obj instanceof NotValue)) {
                return (T) WrappedValues.unescapeThrowable(obj);
            }
            this.storageManager.lock.lock();
            try {
                Object obj2 = this.value;
                if (!(obj2 instanceof NotValue)) {
                    invoke = (T) WrappedValues.unescapeThrowable(obj2);
                } else {
                    NotValue notValue = NotValue.COMPUTING;
                    if (obj2 == notValue) {
                        this.value = NotValue.RECURSION_WAS_DETECTED;
                        RecursionDetectedResult<T> recursionDetected = recursionDetected(true);
                        if (!recursionDetected.isFallThrough()) {
                            invoke = recursionDetected.getValue();
                        }
                    }
                    if (obj2 == NotValue.RECURSION_WAS_DETECTED) {
                        RecursionDetectedResult<T> recursionDetected2 = recursionDetected(false);
                        if (!recursionDetected2.isFallThrough()) {
                            invoke = recursionDetected2.getValue();
                        }
                    }
                    this.value = notValue;
                    try {
                        invoke = this.computable.invoke();
                        postCompute(invoke);
                        this.value = invoke;
                    } catch (Throwable th5) {
                        if (!ExceptionUtilsKt.isProcessCanceledException(th5)) {
                            if (this.value == NotValue.COMPUTING) {
                                this.value = WrappedValues.escapeThrowable(th5);
                            }
                            throw this.storageManager.exceptionHandlingStrategy.handleException(th5);
                        }
                        this.value = NotValue.NOT_COMPUTED;
                        throw th5;
                    }
                }
                return invoke;
            } finally {
                this.storageManager.lock.unlock();
            }
        }

        public boolean isComputed() {
            if (this.value != NotValue.NOT_COMPUTED && this.value != NotValue.COMPUTING) {
                return true;
            }
            return false;
        }

        @NotNull
        protected RecursionDetectedResult<T> recursionDetected(boolean z16) {
            RecursionDetectedResult<T> recursionDetectedDefault = this.storageManager.recursionDetectedDefault("in a lazy value", null);
            if (recursionDetectedDefault == null) {
                $$$reportNull$$$0(2);
            }
            return recursionDetectedDefault;
        }

        protected void postCompute(T t16) {
        }
    }
}
