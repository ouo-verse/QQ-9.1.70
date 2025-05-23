package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public interface u<E> extends Collection<E> {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a<E> {
        int getCount();

        E getElement();
    }

    @CanIgnoreReturnValue
    int add(@NullableDecl E e16, int i3);

    boolean contains(@NullableDecl Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(@NullableDecl @CompatibleWith("E") Object obj);

    Set<E> elementSet();

    Set<a<E>> entrySet();

    @CanIgnoreReturnValue
    int remove(@NullableDecl @CompatibleWith("E") Object obj, int i3);

    @CanIgnoreReturnValue
    boolean remove(@NullableDecl Object obj);

    @CanIgnoreReturnValue
    int setCount(E e16, int i3);

    @CanIgnoreReturnValue
    boolean setCount(E e16, int i3, int i16);

    int size();
}
