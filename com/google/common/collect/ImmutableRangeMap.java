package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements z<K, V>, Serializable {

    /* renamed from: f, reason: collision with root package name */
    private static final ImmutableRangeMap<Comparable<?>, Object> f34913f = new ImmutableRangeMap<>(ImmutableList.of(), ImmutableList.of());
    private static final long serialVersionUID = 0;

    /* renamed from: d, reason: collision with root package name */
    private final transient ImmutableList<Range<K>> f34914d;

    /* renamed from: e, reason: collision with root package name */
    private final transient ImmutableList<V> f34915e;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableMap<Range<K>, V> mapOfRanges;

        SerializedForm(ImmutableMap<Range<K>, V> immutableMap) {
            this.mapOfRanges = immutableMap;
        }

        Object createRangeMap() {
            a aVar = new a();
            ai<Map.Entry<Range<K>, V>> it = this.mapOfRanges.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Range<K>, V> next = it.next();
                aVar.b(next.getKey(), next.getValue());
            }
            return aVar.a();
        }

        Object readResolve() {
            if (this.mapOfRanges.isEmpty()) {
                return ImmutableRangeMap.of();
            }
            return createRangeMap();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class a<K extends Comparable<?>, V> {

        /* renamed from: a, reason: collision with root package name */
        private final List<Map.Entry<Range<K>, V>> f34916a = Lists.h();

        public ImmutableRangeMap<K, V> a() {
            Collections.sort(this.f34916a, Range.rangeLexOrdering().onKeys());
            ImmutableList.a aVar = new ImmutableList.a(this.f34916a.size());
            ImmutableList.a aVar2 = new ImmutableList.a(this.f34916a.size());
            for (int i3 = 0; i3 < this.f34916a.size(); i3++) {
                Range<K> key = this.f34916a.get(i3).getKey();
                if (i3 > 0) {
                    Range<K> key2 = this.f34916a.get(i3 - 1).getKey();
                    if (key.isConnected(key2) && !key.intersection(key2).isEmpty()) {
                        throw new IllegalArgumentException("Overlapping ranges: range " + key2 + " overlaps with entry " + key);
                    }
                }
                aVar.a(key);
                aVar2.a(this.f34916a.get(i3).getValue());
            }
            return new ImmutableRangeMap<>(aVar.j(), aVar2.j());
        }

        @CanIgnoreReturnValue
        public a<K, V> b(Range<K> range, V v3) {
            com.google.common.base.j.m(range);
            com.google.common.base.j.m(v3);
            com.google.common.base.j.i(!range.isEmpty(), "Range must not be empty, but was %s", range);
            this.f34916a.add(Maps.d(range, v3));
            return this;
        }
    }

    ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.f34914d = immutableList;
        this.f34915e = immutableList2;
    }

    public static <K extends Comparable<?>, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(z<K, ? extends V> zVar) {
        if (zVar instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) zVar;
        }
        Map<Range<K>, ? extends V> asMapOfRanges = zVar.asMapOfRanges();
        ImmutableList.a aVar = new ImmutableList.a(asMapOfRanges.size());
        ImmutableList.a aVar2 = new ImmutableList.a(asMapOfRanges.size());
        for (Map.Entry<Range<K>, ? extends V> entry : asMapOfRanges.entrySet()) {
            aVar.a(entry.getKey());
            aVar2.a(entry.getValue());
        }
        return new ImmutableRangeMap<>(aVar.j(), aVar2.j());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) f34913f;
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof z) {
            return asMapOfRanges().equals(((z) obj).asMapOfRanges());
        }
        return false;
    }

    @Override // com.google.common.collect.z
    @NullableDecl
    public V get(K k3) {
        int a16 = SortedLists.a(this.f34914d, Range.lowerBoundFn(), Cut.belowValue(k3), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a16 == -1 || !this.f34914d.get(a16).contains(k3)) {
            return null;
        }
        return this.f34915e.get(a16);
    }

    @NullableDecl
    public Map.Entry<Range<K>, V> getEntry(K k3) {
        int a16 = SortedLists.a(this.f34914d, Range.lowerBoundFn(), Cut.belowValue(k3), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a16 == -1) {
            return null;
        }
        Range<K> range = this.f34914d.get(a16);
        if (!range.contains(k3)) {
            return null;
        }
        return Maps.d(range, this.f34915e.get(a16));
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Deprecated
    public void put(Range<K> range, V v3) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void putAll(z<K, V> zVar) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void putCoalescing(Range<K> range, V v3) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    public Range<K> span() {
        if (!this.f34914d.isEmpty()) {
            return Range.create(this.f34914d.get(0).lowerBound, this.f34914d.get(r1.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    public String toString() {
        return asMapOfRanges().toString();
    }

    Object writeReplace() {
        return new SerializedForm(asMapOfRanges());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v3) {
        return new ImmutableRangeMap<>(ImmutableList.of(range), ImmutableList.of(v3));
    }

    @Override // 
    /* renamed from: asDescendingMapOfRanges, reason: merged with bridge method [inline-methods] */
    public ImmutableMap<Range<K>, V> mo43asDescendingMapOfRanges() {
        if (this.f34914d.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.f34914d.reverse(), Range.rangeLexOrdering().reverse()), this.f34915e.reverse());
    }

    @Override // com.google.common.collect.z
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        if (this.f34914d.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.f34914d, Range.rangeLexOrdering()), this.f34915e);
    }

    @Override // 
    /* renamed from: subRangeMap */
    public ImmutableRangeMap<K, V> mo44subRangeMap(final Range<K> range) {
        if (((Range) com.google.common.base.j.m(range)).isEmpty()) {
            return of();
        }
        if (this.f34914d.isEmpty() || range.encloses(span())) {
            return this;
        }
        ImmutableList<Range<K>> immutableList = this.f34914d;
        com.google.common.base.d upperBoundFn = Range.upperBoundFn();
        Cut<K> cut = range.lowerBound;
        SortedLists.KeyPresentBehavior keyPresentBehavior = SortedLists.KeyPresentBehavior.FIRST_AFTER;
        SortedLists.KeyAbsentBehavior keyAbsentBehavior = SortedLists.KeyAbsentBehavior.NEXT_HIGHER;
        final int a16 = SortedLists.a(immutableList, upperBoundFn, cut, keyPresentBehavior, keyAbsentBehavior);
        int a17 = SortedLists.a(this.f34914d, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, keyAbsentBehavior);
        if (a16 >= a17) {
            return of();
        }
        final int i3 = a17 - a16;
        return (ImmutableRangeMap<K, V>) new ImmutableRangeMap<K, V>(new ImmutableList<Range<K>>() { // from class: com.google.common.collect.ImmutableRangeMap.1
            @Override // com.google.common.collect.ImmutableCollection
            boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return i3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.List
            public Range<K> get(int i16) {
                com.google.common.base.j.k(i16, i3);
                return (i16 == 0 || i16 == i3 + (-1)) ? ((Range) ImmutableRangeMap.this.f34914d.get(i16 + a16)).intersection(range) : (Range) ImmutableRangeMap.this.f34914d.get(i16 + a16);
            }
        }, this.f34915e.subList(a16, a17)) { // from class: com.google.common.collect.ImmutableRangeMap.2
            @Override // com.google.common.collect.ImmutableRangeMap
            /* renamed from: asDescendingMapOfRanges */
            public /* bridge */ /* synthetic */ Map mo43asDescendingMapOfRanges() {
                return super.mo43asDescendingMapOfRanges();
            }

            @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.z
            public /* bridge */ /* synthetic */ Map asMapOfRanges() {
                return super.asMapOfRanges();
            }

            @Override // com.google.common.collect.ImmutableRangeMap
            /* renamed from: subRangeMap, reason: merged with bridge method [inline-methods] */
            public ImmutableRangeMap<K, V> mo44subRangeMap(Range<K> range2) {
                if (range.isConnected(range2)) {
                    return this.mo44subRangeMap((Range) range2.intersection(range));
                }
                return ImmutableRangeMap.of();
            }
        };
    }
}
