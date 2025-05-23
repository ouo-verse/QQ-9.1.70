package com.tencent.qcircle.weseevideo.common.utils;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.SQLiteDatabase;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\u001a)\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002\u00a2\u0006\u0002\u0010\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u0006\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\t\u001a\u0002H\u00072\u0006\u0010\n\u001a\u0002H\b\u00a2\u0006\u0002\u0010\u000b\u001a)\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002\u00a2\u0006\u0002\u0010\u0004\u001a*\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a1\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u0002H\u0002\u00a2\u0006\u0002\u0010\u0011\u001a1\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u0002H\u0002\u00a2\u0006\u0002\u0010\u0011\u001a\u0010\u0010\u0015\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00170\u0001\u00a8\u0006\u0018"}, d2 = {"append", "", "T", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "(Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;", "items", "", "K", "V", "key", "v", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", "delete", "deleteAll", "insert", "position", "", "(Ljava/util/List;ILjava/lang/Object;)Ljava/util/List;", SQLiteDatabase.OPERATE_TYPE_REPLACE, "index", "newItem", "toArray", "", "", "libtavcut_debug"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class CollectionExtKt {
    @NotNull
    public static final <T> List<T> append(@NotNull List<? extends T> append, T t16) {
        List<T> mutableList;
        Intrinsics.checkParameterIsNotNull(append, "$this$append");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) append);
        mutableList.add(t16);
        return mutableList;
    }

    @NotNull
    public static final <T> List<T> delete(@NotNull List<? extends T> delete, T t16) {
        List<T> mutableList;
        Intrinsics.checkParameterIsNotNull(delete, "$this$delete");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) delete);
        mutableList.remove(t16);
        return mutableList;
    }

    @NotNull
    public static final <T> List<T> deleteAll(@NotNull List<? extends T> deleteAll, @NotNull List<? extends T> items) {
        List<T> mutableList;
        Intrinsics.checkParameterIsNotNull(deleteAll, "$this$deleteAll");
        Intrinsics.checkParameterIsNotNull(items, "items");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) deleteAll);
        mutableList.removeAll(items);
        return mutableList;
    }

    @NotNull
    public static final <T> List<T> insert(@NotNull List<? extends T> insert, int i3, T t16) {
        List<T> mutableList;
        Intrinsics.checkParameterIsNotNull(insert, "$this$insert");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) insert);
        mutableList.add(t16);
        return mutableList;
    }

    @NotNull
    public static final <T> List<T> replace(@NotNull List<? extends T> replace, int i3, T t16) {
        List<T> mutableList;
        Intrinsics.checkParameterIsNotNull(replace, "$this$replace");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) replace);
        mutableList.remove(i3);
        mutableList.add(i3, t16);
        return mutableList;
    }

    @NotNull
    public static final float[] toArray(@NotNull List<Float> toArray) {
        float[] floatArray;
        Intrinsics.checkParameterIsNotNull(toArray, "$this$toArray");
        floatArray = CollectionsKt___CollectionsKt.toFloatArray(toArray);
        return floatArray;
    }

    @NotNull
    public static final <T> List<T> append(@NotNull List<? extends T> append, @NotNull List<? extends T> items) {
        List<T> mutableList;
        Intrinsics.checkParameterIsNotNull(append, "$this$append");
        Intrinsics.checkParameterIsNotNull(items, "items");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) append);
        mutableList.addAll(items);
        return mutableList;
    }

    @NotNull
    public static final <K, V> Map<K, V> append(@NotNull Map<K, ? extends V> append, K k3, V v3) {
        Map<K, V> mutableMap;
        Intrinsics.checkParameterIsNotNull(append, "$this$append");
        mutableMap = MapsKt__MapsKt.toMutableMap(append);
        mutableMap.put(k3, v3);
        return mutableMap;
    }
}
