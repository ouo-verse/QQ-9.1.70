package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"com/squareup/wire/internal/Internal__InternalJvmKt", "com/squareup/wire/internal/Internal__InternalKt"}, k = 4, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class Internal {
    @JvmName(name = "-redactElements")
    @NotNull
    /* renamed from: -redactElements, reason: not valid java name */
    public static final <T> List<T> m87redactElements(@NotNull List<? extends T> list, @NotNull ProtoAdapter<T> protoAdapter) {
        return Internal__InternalKt.m89redactElements(list, protoAdapter);
    }

    @NotNull
    public static final String boxedOneOfClassName(@NotNull String str) {
        return Internal__InternalKt.boxedOneOfClassName(str);
    }

    @NotNull
    public static final String boxedOneOfKeyFieldName(@NotNull String str, @NotNull String str2) {
        return Internal__InternalKt.boxedOneOfKeyFieldName(str, str2);
    }

    @NotNull
    public static final String boxedOneOfKeysFieldName(@NotNull String str) {
        return Internal__InternalKt.boxedOneOfKeysFieldName(str);
    }

    public static final void checkElementsNotNull(@NotNull List<?> list) {
        Internal__InternalKt.checkElementsNotNull(list);
    }

    @Deprecated(message = "Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith = @ReplaceWith(expression = "com.squareup.internal.Internal.copyOf(list)", imports = {}))
    @NotNull
    public static final <T> List<T> copyOf(@NotNull String str, @Nullable List<? extends T> list) {
        return Internal__InternalKt.copyOf(str, list);
    }

    public static final int countNonNull(@Nullable Object obj, @Nullable Object obj2) {
        return Internal__InternalKt.countNonNull(obj, obj2);
    }

    public static final boolean equals(@Nullable Object obj, @Nullable Object obj2) {
        return Internal__InternalKt.equals(obj, obj2);
    }

    @Nullable
    public static final <E extends WireEnum> E getIdentityOrNull(@NotNull Class<E> cls) {
        return (E) Internal__InternalJvmKt.getIdentityOrNull(cls);
    }

    @NotNull
    public static final <T> List<T> immutableCopyOf(@NotNull String str, @NotNull List<? extends T> list) {
        return Internal__InternalKt.immutableCopyOf(str, list);
    }

    @NotNull
    public static final <K, V> Map<K, V> immutableCopyOfMapWithStructValues(@NotNull String str, @NotNull Map<K, ? extends V> map) {
        return Internal__InternalKt.immutableCopyOfMapWithStructValues(str, map);
    }

    public static final <T> T immutableCopyOfStruct(@NotNull String str, T t16) {
        return (T) Internal__InternalKt.immutableCopyOfStruct(str, t16);
    }

    @NotNull
    public static final IllegalStateException missingRequiredFields(@NotNull Object... objArr) {
        return Internal__InternalKt.missingRequiredFields(objArr);
    }

    @NotNull
    public static final <T> List<T> newMutableList() {
        return Internal__InternalKt.newMutableList();
    }

    @NotNull
    public static final <K, V> Map<K, V> newMutableMap() {
        return Internal__InternalKt.newMutableMap();
    }

    public static final <T> void redactElements(@NotNull List<T> list, @NotNull ProtoAdapter<T> protoAdapter) {
        Internal__InternalJvmKt.redactElements(list, protoAdapter);
    }

    @NotNull
    public static final String sanitize(@NotNull String str) {
        return Internal__InternalKt.sanitize(str);
    }

    @JvmName(name = "-redactElements")
    @NotNull
    /* renamed from: -redactElements, reason: not valid java name */
    public static final <K, V> Map<K, V> m88redactElements(@NotNull Map<K, ? extends V> map, @NotNull ProtoAdapter<V> protoAdapter) {
        return Internal__InternalKt.m90redactElements(map, protoAdapter);
    }

    public static final void checkElementsNotNull(@NotNull Map<?, ?> map) {
        Internal__InternalKt.checkElementsNotNull(map);
    }

    @NotNull
    public static final <T> List<T> copyOf(@NotNull List<? extends T> list) {
        return Internal__InternalKt.copyOf(list);
    }

    public static final int countNonNull(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        return Internal__InternalKt.countNonNull(obj, obj2, obj3);
    }

    @NotNull
    public static final <K, V> Map<K, V> immutableCopyOf(@NotNull String str, @NotNull Map<K, ? extends V> map) {
        return Internal__InternalKt.immutableCopyOf(str, map);
    }

    public static final <T> void redactElements(@NotNull Map<?, T> map, @NotNull ProtoAdapter<T> protoAdapter) {
        Internal__InternalJvmKt.redactElements(map, protoAdapter);
    }

    @NotNull
    public static final String sanitize(@NotNull List<String> list) {
        return Internal__InternalKt.sanitize(list);
    }

    @Deprecated(message = "Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith = @ReplaceWith(expression = "com.squareup.internal.Internal.copyOf(map)", imports = {}))
    @NotNull
    public static final <K, V> Map<K, V> copyOf(@NotNull String str, @Nullable Map<K, ? extends V> map) {
        return Internal__InternalKt.copyOf(str, map);
    }

    public static final int countNonNull(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @NotNull Object... objArr) {
        return Internal__InternalKt.countNonNull(obj, obj2, obj3, obj4, objArr);
    }

    @NotNull
    public static final <K, V> Map<K, V> copyOf(@NotNull Map<K, ? extends V> map) {
        return Internal__InternalKt.copyOf(map);
    }
}
