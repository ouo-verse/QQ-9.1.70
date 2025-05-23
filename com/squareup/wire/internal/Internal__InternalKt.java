package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001\u001a\u0016\u0010\t\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u000e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f\u001a\u0016\u0010\f\u001a\u00020\r2\u000e\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0011\u001a,\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\u00012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u000fH\u0007\u001a>\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0006\u0010\u0015\u001a\u00020\u00012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0018\u0018\u00010\u0011H\u0007\u001a \u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\u001a2\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\u001a\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u001a$\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u001aK\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040 \"\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010!\u001a\u001a\u0010\"\u001a\u00020#2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u001a(\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\u001a:\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0006\u0010\u0015\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\u001a:\u0010%\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0006\u0010\u0015\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\u001a!\u0010&\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010'\u001a\u0002H\u0014\u00a2\u0006\u0002\u0010(\u001a'\u0010)\u001a\u00060*j\u0002`+2\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040 \"\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010-\u001a\u0012\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u0014\u001a\u001e\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018\u001a\u000e\u00100\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0001\u001a\u0014\u00100\u001a\u00020\u00012\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f\u001a1\u00102\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\"\u0004\b\u0000\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00140\u000f2\f\u00103\u001a\b\u0012\u0004\u0012\u0002H\u001404H\u0007\u00a2\u0006\u0002\b5\u001aC\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u00112\f\u00103\u001a\b\u0012\u0004\u0012\u0002H\u001804H\u0007\u00a2\u0006\u0002\b5\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\" \u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003*\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u00066"}, d2 = {"ESCAPED_CHARS", "", "typeName", "Lkotlin/reflect/KClass;", "", "getTypeName$Internal__InternalKt", "(Ljava/lang/Object;)Lkotlin/reflect/KClass;", "boxedOneOfClassName", "oneOfName", "boxedOneOfKeyFieldName", "fieldName", "boxedOneOfKeysFieldName", "checkElementsNotNull", "", "list", "", "map", "", "copyOf", "", "T", "name", "", "K", "V", "countNonNull", "", "a", "b", "c", "d", "rest", "", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)I", "equals", "", "immutableCopyOf", "immutableCopyOfMapWithStructValues", "immutableCopyOfStruct", "value", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "missingRequiredFields", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "args", "([Ljava/lang/Object;)Ljava/lang/IllegalStateException;", "newMutableList", "newMutableMap", "sanitize", "values", "redactElements", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "-redactElements", "wire-runtime"}, k = 5, mv = {1, 4, 0}, xs = "com/squareup/wire/internal/Internal")
/* loaded from: classes3.dex */
public final /* synthetic */ class Internal__InternalKt {
    private static final String ESCAPED_CHARS = ",[]{}\\";

    @JvmName(name = "-redactElements")
    @NotNull
    /* renamed from: -redactElements, reason: not valid java name */
    public static final <T> List<T> m89redactElements(@NotNull List<? extends T> redactElements, @NotNull ProtoAdapter<T> adapter) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(redactElements, "$this$redactElements");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        List<? extends T> list = redactElements;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(adapter.redact(it.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final String boxedOneOfClassName(@NotNull String oneOfName) {
        String capitalize;
        Intrinsics.checkNotNullParameter(oneOfName, "oneOfName");
        capitalize = StringsKt__StringsJVMKt.capitalize(oneOfName);
        return capitalize;
    }

    @NotNull
    public static final String boxedOneOfKeyFieldName(@NotNull String oneOfName, @NotNull String fieldName) {
        Intrinsics.checkNotNullParameter(oneOfName, "oneOfName");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        String str = oneOfName + "_" + fieldName;
        if (str != null) {
            String upperCase = str.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
            return upperCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    public static final String boxedOneOfKeysFieldName(@NotNull String oneOfName) {
        Intrinsics.checkNotNullParameter(oneOfName, "oneOfName");
        String str = oneOfName + "_keys";
        if (str != null) {
            String upperCase = str.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
            return upperCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static final void checkElementsNotNull(@NotNull List<?> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) == null) {
                throw new NullPointerException("Element at index " + i3 + " is null");
            }
        }
    }

    @Deprecated(message = "Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith = @ReplaceWith(expression = "com.squareup.internal.Internal.copyOf(list)", imports = {}))
    @NotNull
    public static final <T> List<T> copyOf(@NotNull String name, @Nullable List<? extends T> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNull(list);
        return Internal.copyOf(list);
    }

    public static final int countNonNull(@Nullable Object obj, @Nullable Object obj2) {
        return (obj != null ? 1 : 0) + (obj2 == null ? 0 : 1);
    }

    public static final boolean equals(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != obj2 && (obj == null || !Intrinsics.areEqual(obj, obj2))) {
            return false;
        }
        return true;
    }

    private static final KClass<? extends Object> getTypeName$Internal__InternalKt(Object obj) {
        return Reflection.getOrCreateKotlinClass(obj.getClass());
    }

    @NotNull
    public static final <T> List<T> immutableCopyOf(@NotNull String name, @NotNull List<? extends T> list) {
        List emptyList;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "list");
        if (list instanceof MutableOnWriteList) {
            list = (List<T>) ((MutableOnWriteList) list).getMutableList$wire_runtime();
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        if (list == emptyList || (list instanceof ImmutableList)) {
            return (List<T>) list;
        }
        ImmutableList immutableList = new ImmutableList(list);
        if (!immutableList.contains(null)) {
            return immutableList;
        }
        throw new IllegalArgumentException((name + ".contains(null)").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> immutableCopyOfMapWithStructValues(@NotNull String name, @NotNull Map<K, ? extends V> map) {
        boolean z16;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (key != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                linkedHashMap.put(key, Internal.immutableCopyOfStruct(name, value));
            } else {
                throw new IllegalArgumentException((name + ".containsKey(null)").toString());
            }
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "Collections.unmodifiableMap(this)");
        if (unmodifiableMap != null) {
            return unmodifiableMap;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    public static final <T> T immutableCopyOfStruct(@NotNull String name, T t16) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (t16 != null && !(t16 instanceof Boolean) && !(t16 instanceof Double) && !(t16 instanceof String)) {
            if (t16 instanceof List) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((List) t16).iterator();
                while (it.hasNext()) {
                    arrayList.add(Internal.immutableCopyOfStruct(name, it.next()));
                }
                T t17 = (T) Collections.unmodifiableList(arrayList);
                Intrinsics.checkNotNullExpressionValue(t17, "Collections.unmodifiableList(this)");
                return t17;
            }
            if (t16 instanceof Map) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : ((Map) t16).entrySet()) {
                    linkedHashMap.put(Internal.immutableCopyOfStruct(name, entry.getKey()), Internal.immutableCopyOfStruct(name, entry.getValue()));
                }
                T t18 = (T) Collections.unmodifiableMap(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(t18, "Collections.unmodifiableMap(this)");
                return t18;
            }
            throw new IllegalArgumentException("struct value " + name + " must be a JSON type (null, Boolean, Double, String, List, or Map) but was " + getTypeName$Internal__InternalKt(t16) + MsgSummary.STR_COLON + t16);
        }
        return t16;
    }

    @NotNull
    public static final IllegalStateException missingRequiredFields(@NotNull Object... args) {
        IntRange until;
        IntProgression step;
        boolean z16;
        Intrinsics.checkNotNullParameter(args, "args");
        StringBuilder sb5 = new StringBuilder();
        until = RangesKt___RangesKt.until(0, args.length);
        step = RangesKt___RangesKt.step(until, 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        String str = "";
        if (step2 < 0 ? first >= last : first <= last) {
            while (true) {
                if (args[first] == null) {
                    if (sb5.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        str = ReportConstant.COSTREPORT_PREFIX;
                    }
                    sb5.append("\n  ");
                    sb5.append(args[first + 1]);
                }
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        throw new IllegalStateException("Required field" + str + " not set:" + sb6);
    }

    @NotNull
    public static final <T> List<T> newMutableList() {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return new MutableOnWriteList(emptyList);
    }

    @NotNull
    public static final <K, V> Map<K, V> newMutableMap() {
        return new LinkedHashMap();
    }

    @NotNull
    public static final String sanitize(@NotNull String value) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sb5 = new StringBuilder(value.length());
        for (int i3 = 0; i3 < value.length(); i3++) {
            char charAt = value.charAt(i3);
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) ESCAPED_CHARS, charAt, false, 2, (Object) null);
            if (contains$default) {
                sb5.append('\\');
            }
            sb5.append(charAt);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder(capacity).\u2026builderAction).toString()");
        return sb6;
    }

    @NotNull
    public static final <T> List<T> copyOf(@NotNull List<? extends T> list) {
        List<? extends T> emptyList;
        Intrinsics.checkNotNullParameter(list, "list");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        if (list != emptyList && !(list instanceof ImmutableList)) {
            return new ArrayList(list);
        }
        return new MutableOnWriteList(list);
    }

    public static final int countNonNull(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        return (obj != null ? 1 : 0) + (obj2 != null ? 1 : 0) + (obj3 == null ? 0 : 1);
    }

    public static final int countNonNull(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @NotNull Object... rest) {
        Intrinsics.checkNotNullParameter(rest, "rest");
        int i3 = obj != null ? 1 : 0;
        if (obj2 != null) {
            i3++;
        }
        if (obj3 != null) {
            i3++;
        }
        if (obj4 != null) {
            i3++;
        }
        for (Object obj5 : rest) {
            if (obj5 != null) {
                i3++;
            }
        }
        return i3;
    }

    public static final void checkElementsNotNull(@NotNull Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key == null) {
                throw new NullPointerException("map.containsKey(null)");
            }
            if (value == null) {
                throw new NullPointerException("Value for key " + key + " is null");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmName(name = "-redactElements")
    @NotNull
    /* renamed from: -redactElements, reason: not valid java name */
    public static final <K, V> Map<K, V> m90redactElements(@NotNull Map<K, ? extends V> redactElements, @NotNull ProtoAdapter<V> adapter) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(redactElements, "$this$redactElements");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(redactElements.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = redactElements.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), adapter.redact(entry.getValue()));
        }
        return linkedHashMap;
    }

    @Deprecated(message = "Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith = @ReplaceWith(expression = "com.squareup.internal.Internal.copyOf(map)", imports = {}))
    @NotNull
    public static final <K, V> Map<K, V> copyOf(@NotNull String name, @Nullable Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNull(map);
        return Internal.copyOf(map);
    }

    @NotNull
    public static final <K, V> Map<K, V> copyOf(@NotNull Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return new LinkedHashMap(map);
    }

    @NotNull
    public static final <K, V> Map<K, V> immutableCopyOf(@NotNull String name, @NotNull Map<K, ? extends V> map) {
        Map<K, V> emptyMap;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(map, "map");
        if (map.isEmpty()) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (linkedHashMap.keySet() == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Collection<K?>");
        }
        if (!r3.contains(null)) {
            if (linkedHashMap.values() == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Collection<V?>");
            }
            if (!r3.contains(null)) {
                Map<K, V> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "Collections.unmodifiableMap(this)");
                return unmodifiableMap;
            }
            throw new IllegalArgumentException((name + ".containsValue(null)").toString());
        }
        throw new IllegalArgumentException((name + ".containsKey(null)").toString());
    }

    @NotNull
    public static final String sanitize(@NotNull List<String> values) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(values, "values");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(values, null, "[", "]", 0, null, Internal__InternalKt$sanitize$2.INSTANCE, 25, null);
        return joinToString$default;
    }
}
