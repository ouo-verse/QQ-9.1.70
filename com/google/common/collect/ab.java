package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class ab {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static abstract class a<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return ab.h(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) com.google.common.base.j.m(collection));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Set<?> set, @NullableDecl Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(Set<?> set) {
        int i3;
        int i16 = 0;
        for (Object obj : set) {
            if (obj != null) {
                i3 = obj.hashCode();
            } else {
                i3 = 0;
            }
            i16 = ~(~(i16 + i3));
        }
        return i16;
    }

    public static <E> Set<E> c() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static <E> HashSet<E> d() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> e(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new HashSet<>(i.a(iterable));
        }
        return f(iterable.iterator());
    }

    public static <E> HashSet<E> f(Iterator<? extends E> it) {
        HashSet<E> d16 = d();
        r.a(d16, it);
        return d16;
    }

    public static <E> LinkedHashSet<E> g() {
        return new LinkedHashSet<>();
    }

    static boolean h(Set<?> set, Collection<?> collection) {
        com.google.common.base.j.m(collection);
        if (collection instanceof u) {
            collection = ((u) collection).elementSet();
        }
        if ((collection instanceof Set) && collection.size() > set.size()) {
            return r.t(set.iterator(), collection);
        }
        return i(set, collection.iterator());
    }

    static boolean i(Set<?> set, Iterator<?> it) {
        boolean z16 = false;
        while (it.hasNext()) {
            z16 |= set.remove(it.next());
        }
        return z16;
    }
}
