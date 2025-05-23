package com.tencent.videocut.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u001aE\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a=\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001aQ\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\t*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0001\u00a2\u0006\u0004\b\f\u0010\u0006\u001aY\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\t*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001aQ\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\t*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0006\u001a+\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a3\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a+\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"K", "V", "", "key", "value", "g", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", tl.h.F, "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "T", "", "v", "e", "", "index", "f", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/util/Map;", "c", "a", "(Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;", "d", "(Ljava/util/List;ILjava/lang/Object;)Ljava/util/List;", "b", "lib_utils_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class c {
    @NotNull
    public static final <T> List<T> a(@NotNull List<? extends T> append, T t16) {
        List<T> mutableList;
        Intrinsics.checkNotNullParameter(append, "$this$append");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) append);
        mutableList.add(t16);
        return mutableList;
    }

    @NotNull
    public static final <T> List<T> b(@NotNull List<? extends T> delete, T t16) {
        List<T> mutableList;
        Intrinsics.checkNotNullParameter(delete, "$this$delete");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) delete);
        mutableList.remove(t16);
        return mutableList;
    }

    @NotNull
    public static final <K, T> Map<K, List<T>> c(@NotNull Map<K, ? extends List<? extends T>> delete, K k3, T t16) {
        Map<K, List<T>> mutableMap;
        Intrinsics.checkNotNullParameter(delete, "$this$delete");
        mutableMap = MapsKt__MapsKt.toMutableMap(delete);
        List<T> list = mutableMap.get(k3);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List<T> b16 = b(list, t16);
        if (b16.isEmpty()) {
            mutableMap.remove(k3);
        } else {
            mutableMap.put(k3, b16);
        }
        return mutableMap;
    }

    @NotNull
    public static final <T> List<T> d(@NotNull List<? extends T> insert, int i3, T t16) {
        List<T> mutableList;
        Intrinsics.checkNotNullParameter(insert, "$this$insert");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) insert);
        mutableList.add(i3, t16);
        return mutableList;
    }

    @NotNull
    public static final <K, T> Map<K, List<T>> e(@NotNull Map<K, ? extends List<? extends T>> insert, K k3, T t16) {
        Map<K, List<T>> mutableMap;
        Intrinsics.checkNotNullParameter(insert, "$this$insert");
        mutableMap = MapsKt__MapsKt.toMutableMap(insert);
        List<T> list = mutableMap.get(k3);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        mutableMap.put(k3, a(list, t16));
        return mutableMap;
    }

    @NotNull
    public static final <K, T> Map<K, List<T>> f(@NotNull Map<K, ? extends List<? extends T>> insert, K k3, T t16, int i3) {
        Map<K, List<T>> mutableMap;
        Intrinsics.checkNotNullParameter(insert, "$this$insert");
        mutableMap = MapsKt__MapsKt.toMutableMap(insert);
        List<T> list = mutableMap.get(k3);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        mutableMap.put(k3, d(list, i3, t16));
        return mutableMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> g(@NotNull Map<K, ? extends V> insertOrReplace, K k3, V v3) {
        Map<K, V> mutableMap;
        Intrinsics.checkNotNullParameter(insertOrReplace, "$this$insertOrReplace");
        mutableMap = MapsKt__MapsKt.toMutableMap(insertOrReplace);
        mutableMap.put(k3, v3);
        return mutableMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> h(@NotNull Map<K, ? extends V> remove, K k3) {
        Map<K, V> mutableMap;
        Intrinsics.checkNotNullParameter(remove, "$this$remove");
        mutableMap = MapsKt__MapsKt.toMutableMap(remove);
        mutableMap.remove(k3);
        return mutableMap;
    }
}
