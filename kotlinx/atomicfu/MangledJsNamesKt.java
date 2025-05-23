package kotlinx.atomicfu;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b(\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"ADD_AND_GET", "", "ADD_AND_GET_LONG", "ARRAY_ELEMENT_GET", "ARRAY_SIZE", "ATOMIC_ARRAY_OF_NULLS", "ATOMIC_BOOLEAN_ARRAY", "ATOMIC_BOOLEAN_FACTORY", "ATOMIC_BOOLEAN_FACTORY_BINARY_COMPATIBILITY", "ATOMIC_INT_ARRAY", "ATOMIC_INT_FACTORY", "ATOMIC_INT_FACTORY_BINARY_COMPATIBILITY", "ATOMIC_LONG_ARRAY", "ATOMIC_LONG_FACTORY", "ATOMIC_LONG_FACTORY_BINARY_COMPATIBILITY", "ATOMIC_REF_ARRAY", "ATOMIC_REF_FACTORY", "ATOMIC_REF_FACTORY_BINARY_COMPATIBILITY", "ATOMIC_VALUE", "COMPARE_AND_SET", "DECREMENT_AND_GET", "DECREMENT_AND_GET_LONG", "GET_AND_ADD", "GET_AND_ADD_LONG", "GET_AND_DECREMENT", "GET_AND_DECREMENT_LONG", "GET_AND_INCREMENT", "GET_AND_INCREMENT_LONG", "GET_AND_SET", "INCREMENT_AND_GET", "INCREMENT_AND_GET_LONG", "REENTRANT_LOCK", "TRACE_APPEND_1", "TRACE_APPEND_2", "TRACE_APPEND_3", "TRACE_APPEND_4", "TRACE_BASE_CONSTRUCTOR", "TRACE_FACTORY_FUNCTION", "TRACE_FORMAT_CLASS", "TRACE_FORMAT_FORMAT_FUNCTION", "TRACE_NAMED", "atomicfu"}, k = 2, mv = {1, 4, 3})
/* loaded from: classes28.dex */
public final class MangledJsNamesKt {

    @NotNull
    public static final String ADD_AND_GET = "atomicfu$addAndGet";

    @NotNull
    public static final String ADD_AND_GET_LONG = "atomicfu$addAndGet$long";

    @NotNull
    public static final String ARRAY_ELEMENT_GET = "atomicfu$get";

    @NotNull
    public static final String ARRAY_SIZE = "atomicfu$size";

    @NotNull
    public static final String ATOMIC_ARRAY_OF_NULLS = "atomicfu$AtomicRefArray$ofNulls";

    @NotNull
    public static final String ATOMIC_BOOLEAN_ARRAY = "atomicfu$AtomicBooleanArray$boolean";

    @NotNull
    public static final String ATOMIC_BOOLEAN_FACTORY = "atomic$boolean$";

    @NotNull
    public static final String ATOMIC_BOOLEAN_FACTORY_BINARY_COMPATIBILITY = "atomic$boolean$1";

    @NotNull
    public static final String ATOMIC_INT_ARRAY = "atomicfu$AtomicIntArray$int";

    @NotNull
    public static final String ATOMIC_INT_FACTORY = "atomic$int$";

    @NotNull
    public static final String ATOMIC_INT_FACTORY_BINARY_COMPATIBILITY = "atomic$int$1";

    @NotNull
    public static final String ATOMIC_LONG_ARRAY = "atomicfu$AtomicLongArray$long";

    @NotNull
    public static final String ATOMIC_LONG_FACTORY = "atomic$long$";

    @NotNull
    public static final String ATOMIC_LONG_FACTORY_BINARY_COMPATIBILITY = "atomic$long$1";

    @NotNull
    public static final String ATOMIC_REF_ARRAY = "atomicfu$AtomicRefArray$ref";

    @NotNull
    public static final String ATOMIC_REF_FACTORY = "atomic$ref$";

    @NotNull
    public static final String ATOMIC_REF_FACTORY_BINARY_COMPATIBILITY = "atomic$ref$1";

    @NotNull
    public static final String ATOMIC_VALUE = "kotlinx$atomicfu$value";

    @NotNull
    public static final String COMPARE_AND_SET = "atomicfu$compareAndSet";

    @NotNull
    public static final String DECREMENT_AND_GET = "atomicfu$decrementAndGet";

    @NotNull
    public static final String DECREMENT_AND_GET_LONG = "atomicfu$decrementAndGet$long";

    @NotNull
    public static final String GET_AND_ADD = "atomicfu$getAndAdd";

    @NotNull
    public static final String GET_AND_ADD_LONG = "atomicfu$getAndAdd$long";

    @NotNull
    public static final String GET_AND_DECREMENT = "atomicfu$getAndDecrement";

    @NotNull
    public static final String GET_AND_DECREMENT_LONG = "atomicfu$getAndDecrement$long";

    @NotNull
    public static final String GET_AND_INCREMENT = "atomicfu$getAndIncrement";

    @NotNull
    public static final String GET_AND_INCREMENT_LONG = "atomicfu$getAndIncrement$long";

    @NotNull
    public static final String GET_AND_SET = "atomicfu$getAndSet";

    @NotNull
    public static final String INCREMENT_AND_GET = "atomicfu$incrementAndGet";

    @NotNull
    public static final String INCREMENT_AND_GET_LONG = "atomicfu$incrementAndGet$long";

    @NotNull
    public static final String REENTRANT_LOCK = "atomicfu$reentrantLock";

    @NotNull
    public static final String TRACE_APPEND_1 = "atomicfu$Trace$append$1";

    @NotNull
    public static final String TRACE_APPEND_2 = "atomicfu$Trace$append$2";

    @NotNull
    public static final String TRACE_APPEND_3 = "atomicfu$Trace$append$3";

    @NotNull
    public static final String TRACE_APPEND_4 = "atomicfu$Trace$append$4";

    @NotNull
    public static final String TRACE_BASE_CONSTRUCTOR = "atomicfu$TraceBase";

    @NotNull
    public static final String TRACE_FACTORY_FUNCTION = "atomicfu$Trace";

    @NotNull
    public static final String TRACE_FORMAT_CLASS = "atomicfu$TraceFormat";

    @NotNull
    public static final String TRACE_FORMAT_FORMAT_FUNCTION = "atomicfu$TraceFormat$format";

    @NotNull
    public static final String TRACE_NAMED = "atomicfu$Trace$named";
}
