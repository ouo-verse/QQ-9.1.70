package com.tencent.luggage.wxa.b9;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class s implements Queue {

    /* renamed from: c, reason: collision with root package name */
    public static final a f122275c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Queue f122276a;

    /* renamed from: b, reason: collision with root package name */
    public int f122277b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final s a() {
            return new s(new LinkedList());
        }
    }

    public s(Queue q16) {
        Intrinsics.checkNotNullParameter(q16, "q");
        this.f122276a = q16;
        this.f122277b = -1;
    }

    public final int a(boolean z16) {
        int size = z16 ? this.f122277b : this.f122276a.size();
        this.f122277b = -1;
        return size;
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(Object obj) {
        return this.f122276a.add(obj);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f122276a.addAll(elements);
    }

    public int b() {
        return this.f122276a.size();
    }

    public final boolean c() {
        if (this.f122277b >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection
    public void clear() {
        this.f122276a.clear();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.f122276a.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f122276a.containsAll(elements);
    }

    public final void d() {
        this.f122277b = this.f122276a.size() - 1;
    }

    @Override // java.util.Queue
    public Object element() {
        return this.f122276a.element();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f122276a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f122276a.iterator();
    }

    @Override // java.util.Queue
    public boolean offer(Object obj) {
        return this.f122276a.offer(obj);
    }

    @Override // java.util.Queue
    public Object peek() {
        return this.f122276a.peek();
    }

    @Override // java.util.Queue
    public Object poll() {
        return this.f122276a.poll();
    }

    @Override // java.util.Queue
    public Object remove() {
        return this.f122276a.remove();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f122276a.removeAll(elements);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f122276a.retainAll(elements);
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return b();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        return this.f122276a.remove(obj);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.toArray(this, array);
    }

    public final void a(Queue anotherQueue, boolean z16) {
        Intrinsics.checkNotNullParameter(anotherQueue, "anotherQueue");
        int a16 = a(z16);
        int i3 = 0;
        int i16 = 0;
        for (Object obj : this.f122276a) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (i16 <= a16) {
                anotherQueue.offer(obj);
            }
            i16 = i17;
        }
        if (a16 < 0) {
            return;
        }
        while (true) {
            this.f122276a.poll();
            if (i3 == a16) {
                return;
            } else {
                i3++;
            }
        }
    }

    public final void a(Object obj, boolean z16) {
        offer(obj);
        if (z16) {
            d();
        }
    }
}
