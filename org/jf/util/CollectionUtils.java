package org.jf.util;

import com.google.common.base.k;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.Nonnull;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CollectionUtils {
    public static <T> int compareAsIterable(@Nonnull Comparator<? super T> comparator, @Nonnull Iterable<? extends T> iterable, @Nonnull Iterable<? extends T> iterable2) {
        Iterator<? extends T> it = iterable2.iterator();
        Iterator<? extends T> it5 = iterable.iterator();
        while (it5.hasNext()) {
            try {
                int compare = comparator.compare(it5.next(), it.next());
                if (compare != 0) {
                    return compare;
                }
            } catch (NoSuchElementException unused) {
                return 1;
            }
        }
        return it.hasNext() ? -1 : 0;
    }

    public static <T extends Comparable<? super T>> int compareAsList(@Nonnull Collection<? extends T> collection, @Nonnull Collection<? extends T> collection2) {
        int a16 = c.a(collection.size(), collection2.size());
        if (a16 != 0) {
            return a16;
        }
        Iterator<? extends T> it = collection2.iterator();
        Iterator<? extends T> it5 = collection.iterator();
        while (it5.hasNext()) {
            int compareTo = it5.next().compareTo(it.next());
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public static <T extends Comparable<T>> int compareAsSet(@Nonnull Collection<? extends T> collection, @Nonnull Collection<? extends T> collection2) {
        int a16 = c.a(collection.size(), collection2.size());
        if (a16 != 0) {
            return a16;
        }
        toNaturalSortedSet(collection);
        toNaturalSortedSet(collection2);
        Iterator<? extends T> it = collection2.iterator();
        Iterator<? extends T> it5 = collection.iterator();
        while (it5.hasNext()) {
            int compareTo = it5.next().compareTo(it.next());
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public static <T> boolean isNaturalSortedSet(@Nonnull Iterable<? extends T> iterable) {
        if (!(iterable instanceof SortedSet)) {
            return false;
        }
        Comparator comparator = ((SortedSet) iterable).comparator();
        if (comparator != null && !comparator.equals(Ordering.natural())) {
            return false;
        }
        return true;
    }

    public static <T> boolean isSortedSet(@Nonnull Comparator<? extends T> comparator, @Nonnull Iterable<? extends T> iterable) {
        if (iterable instanceof SortedSet) {
            Comparator comparator2 = ((SortedSet) iterable).comparator();
            if (comparator2 == null) {
                return comparator.equals(Ordering.natural());
            }
            return comparator.equals(comparator2);
        }
        return false;
    }

    public static <T> int lastIndexOf(@Nonnull Iterable<T> iterable, @Nonnull k<? super T> kVar) {
        Iterator<T> it = iterable.iterator();
        int i3 = 0;
        int i16 = -1;
        while (it.hasNext()) {
            if (kVar.apply(it.next())) {
                i16 = i3;
            }
            i3++;
        }
        return i16;
    }

    @Nonnull
    public static <T> Comparator<Collection<? extends T>> listComparator(@Nonnull final Comparator<? super T> comparator) {
        return new Comparator<Collection<? extends T>>() { // from class: org.jf.util.CollectionUtils.1
            @Override // java.util.Comparator
            public int compare(Collection<? extends T> collection, Collection<? extends T> collection2) {
                return CollectionUtils.compareAsList(comparator, collection, collection2);
            }
        };
    }

    public static <T> int listHashCode(@Nonnull Iterable<T> iterable) {
        Iterator<T> it = iterable.iterator();
        int i3 = 1;
        while (it.hasNext()) {
            i3 = (i3 * 31) + it.next().hashCode();
        }
        return i3;
    }

    @Nonnull
    public static <T> Comparator<Collection<? extends T>> setComparator(@Nonnull final Comparator<? super T> comparator) {
        return new Comparator<Collection<? extends T>>() { // from class: org.jf.util.CollectionUtils.2
            @Override // java.util.Comparator
            public int compare(Collection<? extends T> collection, Collection<? extends T> collection2) {
                return CollectionUtils.compareAsSet(comparator, collection, collection2);
            }
        };
    }

    @Nonnull
    private static <T> SortedSet<? extends T> toNaturalSortedSet(@Nonnull Collection<? extends T> collection) {
        if (isNaturalSortedSet(collection)) {
            return (SortedSet) collection;
        }
        return ImmutableSortedSet.copyOf((Collection) collection);
    }

    @Nonnull
    private static <T> SortedSet<? extends T> toSortedSet(@Nonnull Comparator<? super T> comparator, @Nonnull Collection<? extends T> collection) {
        SortedSet<? extends T> sortedSet;
        Comparator<? super Object> comparator2;
        if ((collection instanceof SortedSet) && (comparator2 = (sortedSet = (SortedSet) collection).comparator()) != null && comparator2.equals(comparator)) {
            return sortedSet;
        }
        return ImmutableSortedSet.copyOf((Comparator) comparator, (Collection) collection);
    }

    public static <T> int compareAsList(@Nonnull Comparator<? super T> comparator, @Nonnull Collection<? extends T> collection, @Nonnull Collection<? extends T> collection2) {
        int a16 = c.a(collection.size(), collection2.size());
        if (a16 != 0) {
            return a16;
        }
        Iterator<? extends T> it = collection2.iterator();
        Iterator<? extends T> it5 = collection.iterator();
        while (it5.hasNext()) {
            int compare = comparator.compare(it5.next(), it.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static <T extends Comparable<? super T>> int compareAsIterable(@Nonnull Iterable<? extends T> iterable, @Nonnull Iterable<? extends T> iterable2) {
        Iterator<? extends T> it = iterable2.iterator();
        Iterator<? extends T> it5 = iterable.iterator();
        while (it5.hasNext()) {
            try {
                int compareTo = it5.next().compareTo(it.next());
                if (compareTo != 0) {
                    return compareTo;
                }
            } catch (NoSuchElementException unused) {
                return 1;
            }
        }
        return it.hasNext() ? -1 : 0;
    }

    public static <T> int compareAsSet(@Nonnull Comparator<? super T> comparator, @Nonnull Collection<? extends T> collection, @Nonnull Collection<? extends T> collection2) {
        int a16 = c.a(collection.size(), collection2.size());
        if (a16 != 0) {
            return a16;
        }
        SortedSet sortedSet = toSortedSet(comparator, collection);
        Iterator it = toSortedSet(comparator, collection2).iterator();
        Iterator it5 = sortedSet.iterator();
        while (it5.hasNext()) {
            int compare = comparator.compare((Object) it5.next(), (Object) it.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }
}
