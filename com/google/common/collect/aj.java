package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.ListIterator;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class aj<E> extends ai<E> implements ListIterator<E> {
    @Override // java.util.ListIterator
    @Deprecated
    public final void add(E e16) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void set(E e16) {
        throw new UnsupportedOperationException();
    }
}
