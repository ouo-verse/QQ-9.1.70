package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class r {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a<T> extends ai<T> {

        /* renamed from: d, reason: collision with root package name */
        int f35040d = 0;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object[] f35041e;

        a(Object[] objArr) {
            this.f35041e = objArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35040d < this.f35041e.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                Object[] objArr = this.f35041e;
                int i3 = this.f35040d;
                T t16 = (T) objArr[i3];
                objArr[i3] = null;
                this.f35040d = i3 + 1;
                return t16;
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class b<T> extends AbstractIterator<T> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Iterator f35042d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.k f35043e;

        b(Iterator it, com.google.common.base.k kVar) {
            this.f35042d = it;
            this.f35043e = kVar;
        }

        @Override // com.google.common.collect.AbstractIterator
        protected T computeNext() {
            while (this.f35042d.hasNext()) {
                T t16 = (T) this.f35042d.next();
                if (this.f35043e.apply(t16)) {
                    return t16;
                }
            }
            return endOfData();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, F] */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class c<F, T> extends af<F, T> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.d f35044e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Iterator it, com.google.common.base.d dVar) {
            super(it);
            this.f35044e = dVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.af
        public T a(F f16) {
            return (T) this.f35044e.apply(f16);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class d<T> implements Iterator<T> {

        /* renamed from: d, reason: collision with root package name */
        private int f35045d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f35046e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Iterator f35047f;

        d(int i3, Iterator it) {
            this.f35046e = i3;
            this.f35047f = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35045d < this.f35046e && this.f35047f.hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                this.f35045d++;
                return (T) this.f35047f.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f35047f.remove();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class e<T> extends ai<T> {

        /* renamed from: d, reason: collision with root package name */
        boolean f35048d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f35049e;

        e(Object obj) {
            this.f35049e = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f35048d;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f35048d) {
                this.f35048d = true;
                return (T) this.f35049e;
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class f<T> extends com.google.common.collect.a<T> {

        /* renamed from: i, reason: collision with root package name */
        static final aj<Object> f35050i = new f(new Object[0], 0, 0, 0);

        /* renamed from: f, reason: collision with root package name */
        private final T[] f35051f;

        /* renamed from: h, reason: collision with root package name */
        private final int f35052h;

        f(T[] tArr, int i3, int i16, int i17) {
            super(i16, i17);
            this.f35051f = tArr;
            this.f35052h = i3;
        }

        @Override // com.google.common.collect.a
        protected T a(int i3) {
            return this.f35051f[this.f35052h + i3];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class g<T> implements Iterator<T> {

        /* renamed from: d, reason: collision with root package name */
        @NullableDecl
        private Iterator<? extends T> f35053d;

        /* renamed from: e, reason: collision with root package name */
        private Iterator<? extends T> f35054e = r.j();

        /* renamed from: f, reason: collision with root package name */
        private Iterator<? extends Iterator<? extends T>> f35055f;

        /* renamed from: h, reason: collision with root package name */
        @NullableDecl
        private Deque<Iterator<? extends Iterator<? extends T>>> f35056h;

        g(Iterator<? extends Iterator<? extends T>> it) {
            this.f35055f = (Iterator) com.google.common.base.j.m(it);
        }

        @NullableDecl
        private Iterator<? extends Iterator<? extends T>> a() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.f35055f;
                if (it != null && it.hasNext()) {
                    return this.f35055f;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.f35056h;
                if (deque != null && !deque.isEmpty()) {
                    this.f35055f = this.f35056h.removeFirst();
                } else {
                    return null;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) com.google.common.base.j.m(this.f35054e)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> a16 = a();
                this.f35055f = a16;
                if (a16 == null) {
                    return false;
                }
                Iterator<? extends T> next = a16.next();
                this.f35054e = next;
                if (next instanceof g) {
                    g gVar = (g) next;
                    this.f35054e = gVar.f35054e;
                    if (this.f35056h == null) {
                        this.f35056h = new ArrayDeque();
                    }
                    this.f35056h.addFirst(this.f35055f);
                    if (gVar.f35056h != null) {
                        while (!gVar.f35056h.isEmpty()) {
                            this.f35056h.addFirst(gVar.f35056h.removeLast());
                        }
                    }
                    this.f35055f = gVar.f35055f;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                Iterator<? extends T> it = this.f35054e;
                this.f35053d = it;
                return it.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z16;
            if (this.f35053d != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.google.common.collect.h.d(z16);
            this.f35053d.remove();
            this.f35053d = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class h<T> extends ai<T> {

        /* renamed from: d, reason: collision with root package name */
        final Queue<x<T>> f35057d;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements Comparator<x<T>> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Comparator f35058d;

            a(Comparator comparator) {
                this.f35058d = comparator;
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(x<T> xVar, x<T> xVar2) {
                return this.f35058d.compare(xVar.peek(), xVar2.peek());
            }
        }

        public h(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
            this.f35057d = new PriorityQueue(2, new a(comparator));
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.f35057d.add(r.s(it));
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f35057d.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            x<T> remove = this.f35057d.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.f35057d.add(remove);
            }
            return next;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class i<E> implements x<E> {

        /* renamed from: d, reason: collision with root package name */
        private final Iterator<? extends E> f35060d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f35061e;

        /* renamed from: f, reason: collision with root package name */
        @NullableDecl
        private E f35062f;

        public i(Iterator<? extends E> it) {
            this.f35060d = (Iterator) com.google.common.base.j.m(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f35061e && !this.f35060d.hasNext()) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.x, java.util.Iterator
        public E next() {
            if (!this.f35061e) {
                return this.f35060d.next();
            }
            E e16 = this.f35062f;
            this.f35061e = false;
            this.f35062f = null;
            return e16;
        }

        @Override // com.google.common.collect.x
        public E peek() {
            if (!this.f35061e) {
                this.f35062f = this.f35060d.next();
                this.f35061e = true;
            }
            return this.f35062f;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.j.t(!this.f35061e, "Can't remove after you've peeked at next");
            this.f35060d.remove();
        }
    }

    @CanIgnoreReturnValue
    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        com.google.common.base.j.m(collection);
        com.google.common.base.j.m(it);
        boolean z16 = false;
        while (it.hasNext()) {
            z16 |= collection.add(it.next());
        }
        return z16;
    }

    public static <T> boolean b(Iterator<T> it, com.google.common.base.k<? super T> kVar) {
        if (p(it, kVar) != -1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ListIterator<T> c(Iterator<T> it) {
        return (ListIterator) it;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Iterator<?> it) {
        com.google.common.base.j.m(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> Iterator<T> e(Iterator<? extends Iterator<? extends T>> it) {
        return new g(it);
    }

    public static <T> Iterator<T> f(Iterator<? extends T> it, Iterator<? extends T> it5) {
        com.google.common.base.j.m(it);
        com.google.common.base.j.m(it5);
        return e(g(it, it5));
    }

    private static <T> Iterator<T> g(T... tArr) {
        return new a(tArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:
    
        if (r2.hasNext() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001e, code lost:
    
        if (r3.equals(r2.next()) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0020, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0001, code lost:
    
        if (r3 == null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:
    
        if (r2.hasNext() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        if (r2.next() != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean h(Iterator<?> it, @NullableDecl Object obj) {
    }

    public static boolean i(Iterator<?> it, Iterator<?> it5) {
        while (it.hasNext()) {
            if (!it5.hasNext() || !com.google.common.base.g.a(it.next(), it5.next())) {
                return false;
            }
        }
        return !it5.hasNext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ai<T> j() {
        return k();
    }

    static <T> aj<T> k() {
        return (aj<T>) f.f35050i;
    }

    public static <T> ai<T> l(Iterator<T> it, com.google.common.base.k<? super T> kVar) {
        com.google.common.base.j.m(it);
        com.google.common.base.j.m(kVar);
        return new b(it, kVar);
    }

    @SafeVarargs
    public static <T> ai<T> m(T... tArr) {
        return n(tArr, 0, tArr.length, 0);
    }

    static <T> aj<T> n(T[] tArr, int i3, int i16, int i17) {
        boolean z16;
        if (i16 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.d(z16);
        com.google.common.base.j.r(i3, i3 + i16, tArr.length);
        com.google.common.base.j.p(i17, i16);
        if (i16 == 0) {
            return k();
        }
        return new f(tArr, i3, i16, i17);
    }

    @NullableDecl
    public static <T> T o(Iterator<? extends T> it, @NullableDecl T t16) {
        if (it.hasNext()) {
            return it.next();
        }
        return t16;
    }

    public static <T> int p(Iterator<T> it, com.google.common.base.k<? super T> kVar) {
        com.google.common.base.j.n(kVar, "predicate");
        int i3 = 0;
        while (it.hasNext()) {
            if (kVar.apply(it.next())) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static <T> Iterator<T> q(Iterator<T> it, int i3) {
        boolean z16;
        com.google.common.base.j.m(it);
        if (i3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.e(z16, "limit is negative");
        return new d(i3, it);
    }

    @Beta
    public static <T> ai<T> r(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        com.google.common.base.j.n(iterable, "iterators");
        com.google.common.base.j.n(comparator, "comparator");
        return new h(iterable, comparator);
    }

    public static <T> x<T> s(Iterator<? extends T> it) {
        if (it instanceof i) {
            return (i) it;
        }
        return new i(it);
    }

    @CanIgnoreReturnValue
    public static boolean t(Iterator<?> it, Collection<?> collection) {
        com.google.common.base.j.m(collection);
        boolean z16 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z16 = true;
            }
        }
        return z16;
    }

    public static <T> ai<T> u(@NullableDecl T t16) {
        return new e(t16);
    }

    public static int v(Iterator<?> it) {
        long j3 = 0;
        while (it.hasNext()) {
            it.next();
            j3++;
        }
        return s1.c.b(j3);
    }

    public static String w(Iterator<?> it) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append('[');
        boolean z16 = true;
        while (it.hasNext()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append(it.next());
            z16 = false;
        }
        sb5.append(']');
        return sb5.toString();
    }

    public static <F, T> Iterator<T> x(Iterator<F> it, com.google.common.base.d<? super F, ? extends T> dVar) {
        com.google.common.base.j.m(dVar);
        return new c(it, dVar);
    }
}
