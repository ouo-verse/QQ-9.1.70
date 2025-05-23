package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.lang.Comparable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable {
    private static final long serialVersionUID = 0;

    @NullableDecl
    final C endpoint;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class AboveAll extends Cut<Comparable<?>> {

        /* renamed from: d, reason: collision with root package name */
        private static final AboveAll f34864d = new AboveAll();
        private static final long serialVersionUID = 0;

        AboveAll() {
            super(null);
        }

        private Object readResolve() {
            return f34864d;
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public int compareTo(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : 1;
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder sb5) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder sb5) {
            sb5.append("+\u221e)");
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> greatestValueBelow(k<Comparable<?>> kVar) {
            throw null;
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(Comparable<?> comparable) {
            return false;
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> leastValueAbove(k<Comparable<?>> kVar) {
            throw new AssertionError();
        }

        public String toString() {
            return "+\u221e";
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withLowerBoundType(BoundType boundType, k<Comparable<?>> kVar) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withUpperBoundType(BoundType boundType, k<Comparable<?>> kVar) {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        AboveValue(C c16) {
            super((Comparable) com.google.common.base.j.m(c16));
        }

        @Override // com.google.common.collect.Cut
        Cut<C> canonical(k<C> kVar) {
            C leastValueAbove = leastValueAbove(kVar);
            if (leastValueAbove != null) {
                return Cut.belowValue(leastValueAbove);
            }
            return Cut.aboveAll();
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) obj);
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder sb5) {
            sb5.append('(');
            sb5.append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder sb5) {
            sb5.append(this.endpoint);
            sb5.append(']');
        }

        @Override // com.google.common.collect.Cut
        C greatestValueBelow(k<C> kVar) {
            return this.endpoint;
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return ~this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(C c16) {
            if (Range.compareOrThrow(this.endpoint, c16) < 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.Cut
        C leastValueAbove(k<C> kVar) {
            throw null;
        }

        public String toString() {
            return "/" + this.endpoint + "\\";
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        Cut<C> withLowerBoundType(BoundType boundType, k<C> kVar) {
            int i3 = a.f34866a[boundType.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return this;
                }
                throw new AssertionError();
            }
            throw null;
        }

        @Override // com.google.common.collect.Cut
        Cut<C> withUpperBoundType(BoundType boundType, k<C> kVar) {
            int i3 = a.f34866a[boundType.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new AssertionError();
                }
                throw null;
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class BelowAll extends Cut<Comparable<?>> {

        /* renamed from: d, reason: collision with root package name */
        private static final BelowAll f34865d = new BelowAll();
        private static final long serialVersionUID = 0;

        BelowAll() {
            super(null);
        }

        private Object readResolve() {
            return f34865d;
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> canonical(k<Comparable<?>> kVar) {
            throw null;
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public int compareTo(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : -1;
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder sb5) {
            sb5.append("(-\u221e");
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder sb5) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> greatestValueBelow(k<Comparable<?>> kVar) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(Comparable<?> comparable) {
            return true;
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> leastValueAbove(k<Comparable<?>> kVar) {
            throw null;
        }

        public String toString() {
            return "-\u221e";
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withLowerBoundType(BoundType boundType, k<Comparable<?>> kVar) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withUpperBoundType(BoundType boundType, k<Comparable<?>> kVar) {
            throw new AssertionError("this statement should be unreachable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        BelowValue(C c16) {
            super((Comparable) com.google.common.base.j.m(c16));
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) obj);
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder sb5) {
            sb5.append('[');
            sb5.append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder sb5) {
            sb5.append(this.endpoint);
            sb5.append(')');
        }

        @Override // com.google.common.collect.Cut
        C greatestValueBelow(k<C> kVar) {
            throw null;
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(C c16) {
            if (Range.compareOrThrow(this.endpoint, c16) <= 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.Cut
        C leastValueAbove(k<C> kVar) {
            return this.endpoint;
        }

        public String toString() {
            return "\\" + this.endpoint + "/";
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        Cut<C> withLowerBoundType(BoundType boundType, k<C> kVar) {
            int i3 = a.f34866a[boundType.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new AssertionError();
                }
                throw null;
            }
            return this;
        }

        @Override // com.google.common.collect.Cut
        Cut<C> withUpperBoundType(BoundType boundType, k<C> kVar) {
            int i3 = a.f34866a[boundType.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return this;
                }
                throw new AssertionError();
            }
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34866a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f34866a = iArr;
            try {
                iArr[BoundType.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34866a[BoundType.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    Cut(@NullableDecl C c16) {
        this.endpoint = c16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> aboveAll() {
        return AboveAll.f34864d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> aboveValue(C c16) {
        return new AboveValue(c16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> belowAll() {
        return BelowAll.f34865d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> belowValue(C c16) {
        return new BelowValue(c16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void describeAsLowerBound(StringBuilder sb5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void describeAsUpperBound(StringBuilder sb5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public C endpoint() {
        return this.endpoint;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cut)) {
            return false;
        }
        try {
            if (compareTo((Cut) obj) != 0) {
                return false;
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    abstract C greatestValueBelow(k<C> kVar);

    public abstract int hashCode();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isLessThan(C c16);

    abstract C leastValueAbove(k<C> kVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract BoundType typeAsLowerBound();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract BoundType typeAsUpperBound();

    abstract Cut<C> withLowerBoundType(BoundType boundType, k<C> kVar);

    abstract Cut<C> withUpperBoundType(BoundType boundType, k<C> kVar);

    @Override // java.lang.Comparable
    public int compareTo(Cut<C> cut) {
        if (cut == belowAll()) {
            return 1;
        }
        if (cut == aboveAll()) {
            return -1;
        }
        int compareOrThrow = Range.compareOrThrow(this.endpoint, cut.endpoint);
        return compareOrThrow != 0 ? compareOrThrow : s1.a.a(this instanceof AboveValue, cut instanceof AboveValue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cut<C> canonical(k<C> kVar) {
        return this;
    }
}
