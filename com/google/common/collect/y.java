package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
final class y {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] a(Object[] objArr, int i3, int i16, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i3, i16, tArr.getClass());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] b(T[] tArr, int i3) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Set<E> c() {
        return CompactHashSet.create();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map<K, V> d() {
        return CompactHashMap.create();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MapMaker e(MapMaker mapMaker) {
        return mapMaker.l();
    }
}
