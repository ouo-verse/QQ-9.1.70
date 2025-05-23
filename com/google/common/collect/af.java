package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
abstract class af<F, T> implements Iterator<T> {

    /* renamed from: d, reason: collision with root package name */
    final Iterator<? extends F> f35014d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(Iterator<? extends F> it) {
        this.f35014d = (Iterator) com.google.common.base.j.m(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T a(F f16);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f35014d.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f35014d.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f35014d.remove();
    }
}
