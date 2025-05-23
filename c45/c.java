package c45;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class c<T> implements List<T>, KMappedMarker {

    /* renamed from: f, reason: collision with root package name */
    public static final b f30312f = new b();

    /* renamed from: h, reason: collision with root package name */
    public static final c f30313h;

    /* renamed from: d, reason: collision with root package name */
    public final List<T> f30314d;

    /* renamed from: e, reason: collision with root package name */
    public final Integer f30315e;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a<T> implements List<T>, KMutableList {

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList<T> f30316d;

        public a(ArrayList<T> arrayList) {
            this.f30316d = arrayList;
        }

        @Override // java.util.List
        public final void add(int i3, T t16) {
            this.f30316d.add(i3, t16);
        }

        @Override // java.util.List
        public final boolean addAll(int i3, Collection<? extends T> collection) {
            return this.f30316d.addAll(i3, collection);
        }

        @Override // java.util.List, java.util.Collection
        public final void clear() {
            this.f30316d.clear();
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object obj) {
            return this.f30316d.contains(obj);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection<? extends Object> collection) {
            return this.f30316d.containsAll(collection);
        }

        @Override // java.util.List
        public final T get(int i3) {
            return this.f30316d.get(i3);
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            return this.f30316d.indexOf(obj);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            return this.f30316d.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator<T> iterator() {
            return this.f30316d.iterator();
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            return this.f30316d.lastIndexOf(obj);
        }

        @Override // java.util.List
        public final ListIterator<T> listIterator() {
            return this.f30316d.listIterator();
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object obj) {
            return this.f30316d.remove(obj);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection<? extends Object> collection) {
            return this.f30316d.removeAll(collection);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection<? extends Object> collection) {
            return this.f30316d.retainAll(collection);
        }

        @Override // java.util.List
        public final T set(int i3, T t16) {
            return this.f30316d.set(i3, t16);
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            return this.f30316d.size();
        }

        @Override // java.util.List
        public final List<T> subList(int i3, int i16) {
            return this.f30316d.subList(i3, i16);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        public a() {
            this(new ArrayList());
        }

        @Override // java.util.List, java.util.Collection
        public final boolean add(T t16) {
            return this.f30316d.add(t16);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection<? extends T> collection) {
            return this.f30316d.addAll(collection);
        }

        @Override // java.util.List
        public final ListIterator<T> listIterator(int i3) {
            return this.f30316d.listIterator(i3);
        }

        @Override // java.util.List
        public final T remove(int i3) {
            return this.f30316d.remove(i3);
        }

        @Override // java.util.List, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) CollectionToArray.toArray(this, tArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class b {
    }

    static {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        f30313h = new c(emptyList, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends T> list, Integer num) {
        this.f30314d = list;
        this.f30315e = num;
    }

    @Override // java.util.List
    public final void add(int i3, T t16) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i3, Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f30314d.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> collection) {
        return this.f30314d.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object obj) {
        return Intrinsics.areEqual(this.f30314d, obj);
    }

    @Override // java.util.List
    public final T get(int i3) {
        return this.f30314d.get(i3);
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return this.f30314d.hashCode();
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.f30314d.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f30314d.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return this.f30314d.iterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return this.f30314d.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator() {
        return this.f30314d.listIterator();
    }

    @Override // java.util.List
    public final T remove(int i3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<T> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final T set(int i3, T t16) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f30314d.size();
    }

    @Override // java.util.List
    public final void sort(Comparator<? super T> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List<T> subList(int i3, int i16) {
        return this.f30314d.subList(i3, i16);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public final String toString() {
        return this.f30314d.toString();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(T t16) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator(int i3) {
        return this.f30314d.listIterator(i3);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }
}
