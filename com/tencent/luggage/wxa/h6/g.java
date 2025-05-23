package com.tencent.luggage.wxa.h6;

import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g implements ListIterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final ListIterator f126890a;

    public g(ListIterator target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.f126890a = target;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.f126890a.hasNext();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.f126890a.hasPrevious();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.f126890a.nextIndex();
    }

    @Override // java.util.ListIterator
    public Object previous() {
        return this.f126890a.previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.f126890a.previousIndex();
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
