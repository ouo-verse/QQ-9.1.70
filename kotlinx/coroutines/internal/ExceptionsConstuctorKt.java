package kotlinx.coroutines.internal;

import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002\u001a1\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00072\u0014\b\u0004\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006H\u0082\b\u001a!\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00052\u0006\u0010\u0011\u001a\u0002H\u0010H\u0000\u00a2\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\b\b\u0002\u0010\u0014\u001a\u00020\tH\u0082\u0010\u001a\u0018\u0010\u0015\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0016\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"4\u0010\u0002\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00070\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00062\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006\u00a8\u0006\u0018"}, d2 = {"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "throwableFields", "", "createConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", RemoteHandleConst.PARAM_DEFAULT_VALUE, "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ExceptionsConstuctorKt {
    private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);

    @NotNull
    private static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();

    @NotNull
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionCtors = new WeakHashMap<>();

    private static final Function1<Throwable, Throwable> createConstructor(final Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length != 0) {
            if (length != 1) {
                if (length != 2 || !Intrinsics.areEqual(parameterTypes[0], String.class) || !Intrinsics.areEqual(parameterTypes[1], Throwable.class)) {
                    return null;
                }
                return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final Throwable invoke(@NotNull Throwable th5) {
                        Object m476constructorimpl;
                        Object newInstance;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            newInstance = constructor.newInstance(th5.getMessage(), th5);
                        } catch (Throwable th6) {
                            Result.Companion companion2 = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th6));
                        }
                        if (newInstance != null) {
                            m476constructorimpl = Result.m476constructorimpl((Throwable) newInstance);
                            if (Result.m482isFailureimpl(m476constructorimpl)) {
                                m476constructorimpl = null;
                            }
                            return (Throwable) m476constructorimpl;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            }
            Class<?> cls = parameterTypes[0];
            if (Intrinsics.areEqual(cls, Throwable.class)) {
                return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final Throwable invoke(@NotNull Throwable th5) {
                        Object m476constructorimpl;
                        Object newInstance;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            newInstance = constructor.newInstance(th5);
                        } catch (Throwable th6) {
                            Result.Companion companion2 = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th6));
                        }
                        if (newInstance != null) {
                            m476constructorimpl = Result.m476constructorimpl((Throwable) newInstance);
                            if (Result.m482isFailureimpl(m476constructorimpl)) {
                                m476constructorimpl = null;
                            }
                            return (Throwable) m476constructorimpl;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            }
            if (!Intrinsics.areEqual(cls, String.class)) {
                return null;
            }
            return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Throwable invoke(@NotNull Throwable th5) {
                    Object m476constructorimpl;
                    Object newInstance;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        newInstance = constructor.newInstance(th5.getMessage());
                    } catch (Throwable th6) {
                        Result.Companion companion2 = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th6));
                    }
                    if (newInstance != null) {
                        Throwable th7 = (Throwable) newInstance;
                        th7.initCause(th5);
                        m476constructorimpl = Result.m476constructorimpl(th7);
                        if (Result.m482isFailureimpl(m476constructorimpl)) {
                            m476constructorimpl = null;
                        }
                        return (Throwable) m476constructorimpl;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
            };
        }
        return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Throwable invoke(@NotNull Throwable th5) {
                Object m476constructorimpl;
                Object newInstance;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    newInstance = constructor.newInstance(new Object[0]);
                } catch (Throwable th6) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th6));
                }
                if (newInstance != null) {
                    Throwable th7 = (Throwable) newInstance;
                    th7.initCause(th5);
                    m476constructorimpl = Result.m476constructorimpl(th7);
                    if (Result.m482isFailureimpl(m476constructorimpl)) {
                        m476constructorimpl = null;
                    }
                    return (Throwable) m476constructorimpl;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
        };
    }

    private static final int fieldsCount(Class<?> cls, int i3) {
        do {
            int length = cls.getDeclaredFields().length;
            int i16 = 0;
            for (int i17 = 0; i17 < length; i17++) {
                if (!Modifier.isStatic(r0[i17].getModifiers())) {
                    i16++;
                }
            }
            i3 += i16;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i3;
    }

    static /* synthetic */ int fieldsCount$default(Class cls, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        return fieldsCount(cls, i3);
    }

    private static final int fieldsCountOrDefault(Class<?> cls, int i3) {
        Object m476constructorimpl;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, null)));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Integer valueOf = Integer.valueOf(i3);
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = valueOf;
        }
        return ((Number) m476constructorimpl).intValue();
    }

    private static final Function1<Throwable, Throwable> safeCtor(final Function1<? super Throwable, ? extends Throwable> function1) {
        return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$safeCtor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Throwable invoke(@NotNull Throwable th5) {
                Object m476constructorimpl;
                Function1<Throwable, Throwable> function12 = function1;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(function12.invoke(th5));
                } catch (Throwable th6) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th6));
                }
                if (Result.m482isFailureimpl(m476constructorimpl)) {
                    m476constructorimpl = null;
                }
                return (Throwable) m476constructorimpl;
            }
        };
    }

    @Nullable
    public static final <E extends Throwable> E tryCopyException(@NotNull E e16) {
        Object m476constructorimpl;
        List sortedWith;
        ReentrantReadWriteLock.ReadLock readLock;
        int i3;
        ReentrantReadWriteLock.WriteLock writeLock;
        Function1<Throwable, Throwable> function1;
        int i16;
        Object obj = null;
        if (e16 instanceof CopyableThrowable) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(((CopyableThrowable) e16).createCopy());
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (!Result.m482isFailureimpl(m476constructorimpl)) {
                obj = m476constructorimpl;
            }
            return (E) obj;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = cacheLock;
        ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
        readLock2.lock();
        try {
            Function1<Throwable, Throwable> function12 = exceptionCtors.get(e16.getClass());
            if (function12 == null) {
                int i17 = 0;
                if (throwableFields == fieldsCountOrDefault(e16.getClass(), 0)) {
                    sortedWith = ArraysKt___ArraysKt.sortedWith(e16.getClass().getConstructors(), new Comparator<T>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t16, T t17) {
                            int compareValues;
                            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((Constructor) t17).getParameterTypes().length), Integer.valueOf(((Constructor) t16).getParameterTypes().length));
                            return compareValues;
                        }
                    });
                    Iterator it = sortedWith.iterator();
                    Function1<Throwable, Throwable> function13 = null;
                    while (it.hasNext() && (function13 = createConstructor((Constructor) it.next())) == null) {
                    }
                    ReentrantReadWriteLock reentrantReadWriteLock2 = cacheLock;
                    readLock = reentrantReadWriteLock2.readLock();
                    if (reentrantReadWriteLock2.getWriteHoldCount() == 0) {
                        i3 = reentrantReadWriteLock2.getReadHoldCount();
                    } else {
                        i3 = 0;
                    }
                    for (int i18 = 0; i18 < i3; i18++) {
                        readLock.unlock();
                    }
                    writeLock = reentrantReadWriteLock2.writeLock();
                    writeLock.lock();
                    try {
                        AbstractMap abstractMap = exceptionCtors;
                        Class<?> cls = e16.getClass();
                        if (function13 == null) {
                            function1 = new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1
                                @Override // kotlin.jvm.functions.Function1
                                @Nullable
                                public final Void invoke(@NotNull Throwable th6) {
                                    return null;
                                }
                            };
                        } else {
                            function1 = function13;
                        }
                        abstractMap.put(cls, function1);
                        Unit unit = Unit.INSTANCE;
                        while (i17 < i3) {
                            readLock.lock();
                            i17++;
                        }
                        writeLock.unlock();
                        if (function13 == null) {
                            return null;
                        }
                        return (E) function13.invoke(e16);
                    } finally {
                        while (i17 < i3) {
                            readLock.lock();
                            i17++;
                        }
                        writeLock.unlock();
                    }
                }
                readLock = reentrantReadWriteLock.readLock();
                if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                    i16 = reentrantReadWriteLock.getReadHoldCount();
                } else {
                    i16 = 0;
                }
                for (int i19 = 0; i19 < i3; i19++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    exceptionCtors.put(e16.getClass(), new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1
                        @Override // kotlin.jvm.functions.Function1
                        @Nullable
                        public final Void invoke(@NotNull Throwable th6) {
                            return null;
                        }
                    });
                    Unit unit2 = Unit.INSTANCE;
                    return null;
                } finally {
                    while (i17 < i3) {
                        readLock.lock();
                        i17++;
                    }
                    writeLock.unlock();
                }
            }
            return (E) function12.invoke(e16);
        } finally {
            readLock2.unlock();
        }
    }
}
