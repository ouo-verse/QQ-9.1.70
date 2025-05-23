package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
abstract class a<E> extends aj<E> {

    /* renamed from: d, reason: collision with root package name */
    private final int f35006d;

    /* renamed from: e, reason: collision with root package name */
    private int f35007e;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(int i3) {
        this(i3, 0);
    }

    protected abstract E a(int i3);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        if (this.f35007e < this.f35006d) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f35007e > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i3 = this.f35007e;
            this.f35007e = i3 + 1;
            return a(i3);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f35007e;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i3 = this.f35007e - 1;
            this.f35007e = i3;
            return a(i3);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f35007e - 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(int i3, int i16) {
        com.google.common.base.j.p(i16, i3);
        this.f35006d = i3;
        this.f35007e = i16;
    }
}
