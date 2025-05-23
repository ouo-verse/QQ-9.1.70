package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CollectionsKt {
    public static final <T> void addIfNotNull(@NotNull Collection<T> collection, @Nullable T t16) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        if (t16 != null) {
            collection.add(t16);
        }
    }

    private static final int capacity(int i3) {
        if (i3 < 3) {
            return 3;
        }
        return i3 + (i3 / 3) + 1;
    }

    @NotNull
    public static final <T> List<T> compact(@NotNull ArrayList<T> arrayList) {
        List<T> emptyList;
        Object first;
        List<T> listOf;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        if (size == 1) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            listOf = CollectionsKt__CollectionsJVMKt.listOf(first);
            return listOf;
        }
        arrayList.trimToSize();
        return arrayList;
    }

    @NotNull
    public static final <K> Map<K, Integer> mapToIndex(@NotNull Iterable<? extends K> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends K> it = iterable.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i3));
            i3++;
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> HashMap<K, V> newHashMapWithExpectedSize(int i3) {
        return new HashMap<>(capacity(i3));
    }

    @NotNull
    public static final <E> HashSet<E> newHashSetWithExpectedSize(int i3) {
        return new HashSet<>(capacity(i3));
    }

    @NotNull
    public static final <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int i3) {
        return new LinkedHashSet<>(capacity(i3));
    }
}
