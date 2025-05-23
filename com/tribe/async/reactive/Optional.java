package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;
import java.util.NoSuchElementException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Optional<T> {
    private static final Optional<?> EMPTY = new Optional<>();
    private final T value;

    Optional() {
        this.value = null;
    }

    public static <T> Optional<T> empty() {
        return (Optional<T>) EMPTY;
    }

    public static <T> Optional<T> of(T t16) {
        return new Optional<>(t16);
    }

    public static <T> Optional<T> ofNullable(T t16) {
        if (t16 == null) {
            return empty();
        }
        return of(t16);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Optional)) {
            return false;
        }
        T t16 = this.value;
        T t17 = ((Optional) obj).value;
        if (t16 == null) {
            if (t17 == null) {
                return true;
            }
            return false;
        }
        return t16.equals(t17);
    }

    public Optional<T> filter(Predicate<? super T> predicate) {
        AssertUtils.checkNotNull(predicate);
        if (!isPresent()) {
            return this;
        }
        if (predicate.test(this.value)) {
            return this;
        }
        return empty();
    }

    public <U> Optional<U> flatMap(Function<? super T, Optional<U>> function) {
        AssertUtils.checkNotNull(function);
        if (!isPresent()) {
            return empty();
        }
        Optional<U> apply = function.apply(this.value);
        AssertUtils.checkNotNull(apply);
        return apply;
    }

    public T get() {
        T t16 = this.value;
        if (t16 != null) {
            return t16;
        }
        throw new NoSuchElementException("No value present");
    }

    public int hashCode() {
        T t16 = this.value;
        if (t16 == null) {
            return 0;
        }
        return t16.hashCode();
    }

    public void ifPresent(Consumer<? super T> consumer) {
        T t16 = this.value;
        if (t16 != null) {
            consumer.accept(t16);
        }
    }

    public boolean isPresent() {
        if (this.value != null) {
            return true;
        }
        return false;
    }

    public <U> Optional<U> map(Function<T, U> function) {
        AssertUtils.checkNotNull(function);
        if (!isPresent()) {
            return empty();
        }
        return ofNullable(function.apply(this.value));
    }

    public T orElse(T t16) {
        T t17 = this.value;
        if (t17 != null) {
            return t17;
        }
        return t16;
    }

    public T orElseGet(Supplier<? extends T> supplier) {
        T t16 = this.value;
        if (t16 == null) {
            return supplier.get();
        }
        return t16;
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> supplier) throws Throwable {
        T t16 = this.value;
        if (t16 != null) {
            return t16;
        }
        throw supplier.get();
    }

    public String toString() {
        T t16 = this.value;
        if (t16 != null) {
            return String.format("Optional[%s]", t16);
        }
        return "Optional.empty";
    }

    Optional(T t16) {
        t16.getClass();
        this.value = t16;
    }
}
