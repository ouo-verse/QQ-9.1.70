package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements com.google.common.base.k<C> {

    /* renamed from: d, reason: collision with root package name */
    private static final Range<Comparable> f34982d = new Range<>(Cut.belowAll(), Cut.aboveAll());
    private static final long serialVersionUID = 0;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        static final Ordering<Range<?>> INSTANCE = new RangeLexOrdering();
        private static final long serialVersionUID = 0;

        RangeLexOrdering() {
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Range<?> range, Range<?> range2) {
            return j.f().d(range.lowerBound, range2.lowerBound).d(range.upperBound, range2.upperBound).e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34983a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f34983a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34983a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b implements com.google.common.base.d<Range, Cut> {

        /* renamed from: d, reason: collision with root package name */
        static final b f34984d = new b();

        b() {
        }

        @Override // com.google.common.base.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cut apply(Range range) {
            return range.lowerBound;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c implements com.google.common.base.d<Range, Cut> {

        /* renamed from: d, reason: collision with root package name */
        static final c f34985d = new c();

        c() {
        }

        @Override // com.google.common.base.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cut apply(Range range) {
            return range.upperBound;
        }
    }

    Range(Cut<C> cut, Cut<C> cut2) {
        this.lowerBound = (Cut) com.google.common.base.j.m(cut);
        this.upperBound = (Cut) com.google.common.base.j.m(cut2);
        if (cut.compareTo((Cut) cut2) <= 0 && cut != Cut.aboveAll() && cut2 != Cut.belowAll()) {
            return;
        }
        throw new IllegalArgumentException("Invalid range: " + b(cut, cut2));
    }

    private static <T> SortedSet<T> a(Iterable<T> iterable) {
        return (SortedSet) iterable;
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) f34982d;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c16) {
        return create(Cut.belowValue(c16), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c16) {
        return create(Cut.belowAll(), Cut.aboveValue(c16));
    }

    private static String b(Cut<?> cut, Cut<?> cut2) {
        StringBuilder sb5 = new StringBuilder(16);
        cut.describeAsLowerBound(sb5);
        sb5.append("..");
        cut2.describeAsUpperBound(sb5);
        return sb5.toString();
    }

    public static <C extends Comparable<?>> Range<C> closed(C c16, C c17) {
        return create(Cut.belowValue(c16), Cut.aboveValue(c17));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c16, C c17) {
        return create(Cut.belowValue(c16), Cut.belowValue(c17));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> Range<C> create(Cut<C> cut, Cut<C> cut2) {
        return new Range<>(cut, cut2);
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c16, BoundType boundType) {
        int i3 = a.f34983a[boundType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return atLeast(c16);
            }
            throw new AssertionError();
        }
        return greaterThan(c16);
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        com.google.common.base.j.m(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet a16 = a(iterable);
            Comparator comparator = a16.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return closed((Comparable) a16.first(), (Comparable) a16.last());
            }
        }
        Iterator<C> it = iterable.iterator();
        Comparable comparable = (Comparable) com.google.common.base.j.m(it.next());
        Comparable comparable2 = comparable;
        while (it.hasNext()) {
            Comparable comparable3 = (Comparable) com.google.common.base.j.m(it.next());
            comparable = (Comparable) Ordering.natural().min(comparable, comparable3);
            comparable2 = (Comparable) Ordering.natural().max(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c16) {
        return create(Cut.aboveValue(c16), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c16) {
        return create(Cut.belowAll(), Cut.belowValue(c16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> com.google.common.base.d<Range<C>, Cut<C>> lowerBoundFn() {
        return b.f34984d;
    }

    public static <C extends Comparable<?>> Range<C> open(C c16, C c17) {
        return create(Cut.aboveValue(c16), Cut.belowValue(c17));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c16, C c17) {
        return create(Cut.aboveValue(c16), Cut.aboveValue(c17));
    }

    public static <C extends Comparable<?>> Range<C> range(C c16, BoundType boundType, C c17, BoundType boundType2) {
        Cut belowValue;
        Cut aboveValue;
        com.google.common.base.j.m(boundType);
        com.google.common.base.j.m(boundType2);
        BoundType boundType3 = BoundType.OPEN;
        if (boundType == boundType3) {
            belowValue = Cut.aboveValue(c16);
        } else {
            belowValue = Cut.belowValue(c16);
        }
        if (boundType2 == boundType3) {
            aboveValue = Cut.belowValue(c17);
        } else {
            aboveValue = Cut.aboveValue(c17);
        }
        return create(belowValue, aboveValue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> Ordering<Range<C>> rangeLexOrdering() {
        return (Ordering<Range<C>>) RangeLexOrdering.INSTANCE;
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c16) {
        return closed(c16, c16);
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c16, BoundType boundType) {
        int i3 = a.f34983a[boundType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return atMost(c16);
            }
            throw new AssertionError();
        }
        return lessThan(c16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> com.google.common.base.d<Range<C>, Cut<C>> upperBoundFn() {
        return c.f34985d;
    }

    public Range<C> canonical(k<C> kVar) {
        com.google.common.base.j.m(kVar);
        Cut<C> canonical = this.lowerBound.canonical(kVar);
        Cut<C> canonical2 = this.upperBound.canonical(kVar);
        if (canonical == this.lowerBound && canonical2 == this.upperBound) {
            return this;
        }
        return create(canonical, canonical2);
    }

    public boolean contains(C c16) {
        com.google.common.base.j.m(c16);
        if (this.lowerBound.isLessThan(c16) && !this.upperBound.isLessThan(c16)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsAll(Iterable<? extends C> iterable) {
        if (q.h(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet a16 = a(iterable);
            Comparator comparator = a16.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                if (contains((Comparable) a16.first()) && contains((Comparable) a16.last())) {
                    return true;
                }
                return false;
            }
        }
        Iterator<? extends C> it = iterable.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(Range<C> range) {
        if (this.lowerBound.compareTo((Cut) range.lowerBound) <= 0 && this.upperBound.compareTo((Cut) range.upperBound) >= 0) {
            return true;
        }
        return false;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        if (!this.lowerBound.equals(range.lowerBound) || !this.upperBound.equals(range.upperBound)) {
            return false;
        }
        return true;
    }

    public Range<C> gap(Range<C> range) {
        boolean z16;
        Range<C> range2;
        if (this.lowerBound.compareTo((Cut) range.lowerBound) < 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            range2 = this;
        } else {
            range2 = range;
        }
        if (!z16) {
            range = this;
        }
        return create(range2.upperBound, range.lowerBound);
    }

    public boolean hasLowerBound() {
        if (this.lowerBound != Cut.belowAll()) {
            return true;
        }
        return false;
    }

    public boolean hasUpperBound() {
        if (this.upperBound != Cut.aboveAll()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public Range<C> intersection(Range<C> range) {
        Cut<C> cut;
        Cut<C> cut2;
        int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (compareTo >= 0 && compareTo2 <= 0) {
            return this;
        }
        if (compareTo <= 0 && compareTo2 >= 0) {
            return range;
        }
        if (compareTo >= 0) {
            cut = this.lowerBound;
        } else {
            cut = range.lowerBound;
        }
        if (compareTo2 <= 0) {
            cut2 = this.upperBound;
        } else {
            cut2 = range.upperBound;
        }
        return create(cut, cut2);
    }

    public boolean isConnected(Range<C> range) {
        if (this.lowerBound.compareTo((Cut) range.upperBound) <= 0 && range.lowerBound.compareTo((Cut) this.upperBound) <= 0) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public C lowerEndpoint() {
        return this.lowerBound.endpoint();
    }

    Object readResolve() {
        if (equals(f34982d)) {
            return all();
        }
        return this;
    }

    public Range<C> span(Range<C> range) {
        Cut<C> cut;
        Cut<C> cut2;
        int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (compareTo <= 0 && compareTo2 >= 0) {
            return this;
        }
        if (compareTo >= 0 && compareTo2 <= 0) {
            return range;
        }
        if (compareTo <= 0) {
            cut = this.lowerBound;
        } else {
            cut = range.lowerBound;
        }
        if (compareTo2 >= 0) {
            cut2 = this.upperBound;
        } else {
            cut2 = range.upperBound;
        }
        return create(cut, cut2);
    }

    public String toString() {
        return b(this.lowerBound, this.upperBound);
    }

    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public C upperEndpoint() {
        return this.upperBound.endpoint();
    }

    @Override // com.google.common.base.k
    @Deprecated
    public boolean apply(C c16) {
        return contains(c16);
    }
}
