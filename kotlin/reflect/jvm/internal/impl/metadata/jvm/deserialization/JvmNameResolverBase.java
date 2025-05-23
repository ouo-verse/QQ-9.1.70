package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public class JvmNameResolverBase implements NameResolver {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final List<String> PREDEFINED_STRINGS;

    @NotNull
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP;

    /* renamed from: kotlin, reason: collision with root package name */
    @NotNull
    private static final String f412758kotlin;

    @NotNull
    private final Set<Integer> localNameIndices;

    @NotNull
    private final List<JvmProtoBuf.StringTableTypes.Record> records;

    @NotNull
    private final String[] strings;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        List listOf;
        String joinToString$default;
        List<String> listOf2;
        Iterable<IndexedValue> withIndex;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'});
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(listOf, "", null, null, 0, null, null, 62, null);
        f412758kotlin = joinToString$default;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{joinToString$default + "/Any", joinToString$default + "/Nothing", joinToString$default + "/Unit", joinToString$default + "/Throwable", joinToString$default + "/Number", joinToString$default + "/Byte", joinToString$default + "/Double", joinToString$default + "/Float", joinToString$default + "/Int", joinToString$default + "/Long", joinToString$default + "/Short", joinToString$default + "/Boolean", joinToString$default + "/Char", joinToString$default + "/CharSequence", joinToString$default + "/String", joinToString$default + "/Comparable", joinToString$default + "/Enum", joinToString$default + "/Array", joinToString$default + "/ByteArray", joinToString$default + "/DoubleArray", joinToString$default + "/FloatArray", joinToString$default + "/IntArray", joinToString$default + "/LongArray", joinToString$default + "/ShortArray", joinToString$default + "/BooleanArray", joinToString$default + "/CharArray", joinToString$default + "/Cloneable", joinToString$default + "/Annotation", joinToString$default + "/collections/Iterable", joinToString$default + "/collections/MutableIterable", joinToString$default + "/collections/Collection", joinToString$default + "/collections/MutableCollection", joinToString$default + "/collections/List", joinToString$default + "/collections/MutableList", joinToString$default + "/collections/Set", joinToString$default + "/collections/MutableSet", joinToString$default + "/collections/Map", joinToString$default + "/collections/MutableMap", joinToString$default + "/collections/Map.Entry", joinToString$default + "/collections/MutableMap.MutableEntry", joinToString$default + "/collections/Iterator", joinToString$default + "/collections/MutableIterator", joinToString$default + "/collections/ListIterator", joinToString$default + "/collections/MutableListIterator"});
        PREDEFINED_STRINGS = listOf2;
        withIndex = CollectionsKt___CollectionsKt.withIndex(listOf2);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(withIndex, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (IndexedValue indexedValue : withIndex) {
            linkedHashMap.put((String) indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex()));
        }
        PREDEFINED_STRINGS_MAP = linkedHashMap;
    }

    public JvmNameResolverBase(@NotNull String[] strings, @NotNull Set<Integer> localNameIndices, @NotNull List<JvmProtoBuf.StringTableTypes.Record> records) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(localNameIndices, "localNameIndices");
        Intrinsics.checkNotNullParameter(records, "records");
        this.strings = strings;
        this.localNameIndices = localNameIndices;
        this.records = records;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    public String getQualifiedClassName(int i3) {
        return getString(i3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    public String getString(int i3) {
        String string;
        boolean z16;
        JvmProtoBuf.StringTableTypes.Record record = this.records.get(i3);
        if (record.hasString()) {
            string = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                List<String> list = PREDEFINED_STRINGS;
                int size = list.size();
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && predefinedIndex < size) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    string = list.get(record.getPredefinedIndex());
                }
            }
            string = this.strings[i3];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            Intrinsics.checkNotNullExpressionValue(substringIndexList, "substringIndexList");
            Integer begin = substringIndexList.get(0);
            Integer end = substringIndexList.get(1);
            Intrinsics.checkNotNullExpressionValue(begin, "begin");
            if (begin.intValue() >= 0) {
                int intValue = begin.intValue();
                Intrinsics.checkNotNullExpressionValue(end, "end");
                if (intValue <= end.intValue() && end.intValue() <= string.length()) {
                    Intrinsics.checkNotNullExpressionValue(string, "string");
                    string = string.substring(begin.intValue(), end.intValue());
                    Intrinsics.checkNotNullExpressionValue(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                }
            }
        }
        String string2 = string;
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            Intrinsics.checkNotNullExpressionValue(replaceCharList, "replaceCharList");
            Integer num = replaceCharList.get(0);
            Integer num2 = replaceCharList.get(1);
            Intrinsics.checkNotNullExpressionValue(string2, "string");
            string2 = StringsKt__StringsJVMKt.replace$default(string2, (char) num.intValue(), (char) num2.intValue(), false, 4, (Object) null);
        }
        String string3 = string2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i16 = WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
        if (i16 != 2) {
            if (i16 == 3) {
                if (string3.length() >= 2) {
                    Intrinsics.checkNotNullExpressionValue(string3, "string");
                    string3 = string3.substring(1, string3.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(string3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                }
                String string4 = string3;
                Intrinsics.checkNotNullExpressionValue(string4, "string");
                string3 = StringsKt__StringsJVMKt.replace$default(string4, '$', '.', false, 4, (Object) null);
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(string3, "string");
            string3 = StringsKt__StringsJVMKt.replace$default(string3, '$', '.', false, 4, (Object) null);
        }
        Intrinsics.checkNotNullExpressionValue(string3, "string");
        return string3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i3) {
        return this.localNameIndices.contains(Integer.valueOf(i3));
    }
}
