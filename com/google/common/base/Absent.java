package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class Absent<T> extends Optional<T> {
    static final Absent<Object> INSTANCE = new Absent<>();
    private static final long serialVersionUID = 0;

    Absent() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Optional<T> withType() {
        return INSTANCE;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.emptySet();
    }

    @Override // com.google.common.base.Optional
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return 2040732332;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // com.google.common.base.Optional
    public T or(T t16) {
        return (T) j.n(t16, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // com.google.common.base.Optional
    @NullableDecl
    public T orNull() {
        return null;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(d<? super T, V> dVar) {
        j.m(dVar);
        return Optional.absent();
    }

    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> optional) {
        return (Optional) j.m(optional);
    }

    @Override // com.google.common.base.Optional
    public T or(o<? extends T> oVar) {
        return (T) j.n(oVar.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }
}
