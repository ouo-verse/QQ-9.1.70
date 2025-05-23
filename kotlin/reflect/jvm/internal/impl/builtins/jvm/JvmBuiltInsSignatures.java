package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.tencent.mobileqq.mini.cache.Entry;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JvmBuiltInsSignatures {

    @NotNull
    private static final Set<String> DROP_LIST_METHOD_SIGNATURES;

    @NotNull
    private static final Set<String> HIDDEN_CONSTRUCTOR_SIGNATURES;

    @NotNull
    private static final Set<String> HIDDEN_METHOD_SIGNATURES;

    @NotNull
    public static final JvmBuiltInsSignatures INSTANCE;

    @NotNull
    private static final Set<String> MUTABLE_METHOD_SIGNATURES;

    @NotNull
    private static final Set<String> VISIBLE_CONSTRUCTOR_SIGNATURES;

    @NotNull
    private static final Set<String> VISIBLE_METHOD_SIGNATURES;

    static {
        Set<String> plus;
        Set plus2;
        Set plus3;
        Set plus4;
        Set plus5;
        Set plus6;
        Set<String> plus7;
        Set plus8;
        Set plus9;
        Set plus10;
        Set plus11;
        Set plus12;
        Set<String> plus13;
        Set plus14;
        Set<String> plus15;
        Set plus16;
        Set<String> plus17;
        JvmBuiltInsSignatures jvmBuiltInsSignatures = new JvmBuiltInsSignatures();
        INSTANCE = jvmBuiltInsSignatures;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        plus = SetsKt___SetsKt.plus((Set<? extends String>) ((Set<? extends Object>) signatureBuildingComponents.inJavaUtil("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;")), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        DROP_LIST_METHOD_SIGNATURES = plus;
        plus2 = SetsKt___SetsKt.plus((Set) jvmBuiltInsSignatures.buildPrimitiveValueMethodsSet(), (Iterable) signatureBuildingComponents.inJavaUtil("List", "sort(Ljava/util/Comparator;)V"));
        plus3 = SetsKt___SetsKt.plus(plus2, (Iterable) signatureBuildingComponents.inJavaLang(Entry.DATA_TYPE_STRING, "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;"));
        plus4 = SetsKt___SetsKt.plus(plus3, (Iterable) signatureBuildingComponents.inJavaLang("Double", "isInfinite()Z", "isNaN()Z"));
        plus5 = SetsKt___SetsKt.plus(plus4, (Iterable) signatureBuildingComponents.inJavaLang("Float", "isInfinite()Z", "isNaN()Z"));
        plus6 = SetsKt___SetsKt.plus(plus5, (Iterable) signatureBuildingComponents.inJavaLang("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V"));
        plus7 = SetsKt___SetsKt.plus(plus6, (Iterable) signatureBuildingComponents.inJavaLang("CharSequence", "isEmpty()Z"));
        HIDDEN_METHOD_SIGNATURES = plus7;
        plus8 = SetsKt___SetsKt.plus((Set) signatureBuildingComponents.inJavaLang("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), (Iterable) signatureBuildingComponents.inJavaUtil("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V"));
        plus9 = SetsKt___SetsKt.plus(plus8, (Iterable) signatureBuildingComponents.inJavaLang("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;"));
        plus10 = SetsKt___SetsKt.plus(plus9, (Iterable) signatureBuildingComponents.inJavaLang("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V"));
        plus11 = SetsKt___SetsKt.plus(plus10, (Iterable) signatureBuildingComponents.inJavaUtil("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z"));
        plus12 = SetsKt___SetsKt.plus(plus11, (Iterable) signatureBuildingComponents.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V"));
        plus13 = SetsKt___SetsKt.plus(plus12, (Iterable) signatureBuildingComponents.inJavaUtil("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        VISIBLE_METHOD_SIGNATURES = plus13;
        plus14 = SetsKt___SetsKt.plus((Set) signatureBuildingComponents.inJavaUtil("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), (Iterable) signatureBuildingComponents.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V"));
        plus15 = SetsKt___SetsKt.plus(plus14, (Iterable) signatureBuildingComponents.inJavaUtil("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        MUTABLE_METHOD_SIGNATURES = plus15;
        Set<String> buildPrimitiveStringConstructorsSet = jvmBuiltInsSignatures.buildPrimitiveStringConstructorsSet();
        String[] constructors = signatureBuildingComponents.constructors("D");
        plus16 = SetsKt___SetsKt.plus((Set) buildPrimitiveStringConstructorsSet, (Iterable) signatureBuildingComponents.inJavaLang("Float", (String[]) Arrays.copyOf(constructors, constructors.length)));
        String[] constructors2 = signatureBuildingComponents.constructors("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        plus17 = SetsKt___SetsKt.plus(plus16, (Iterable) signatureBuildingComponents.inJavaLang(Entry.DATA_TYPE_STRING, (String[]) Arrays.copyOf(constructors2, constructors2.length)));
        HIDDEN_CONSTRUCTOR_SIGNATURES = plus17;
        String[] constructors3 = signatureBuildingComponents.constructors("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        VISIBLE_CONSTRUCTOR_SIGNATURES = signatureBuildingComponents.inJavaLang("Throwable", (String[]) Arrays.copyOf(constructors3, constructors3.length));
    }

    JvmBuiltInsSignatures() {
    }

    private final Set<String> buildPrimitiveStringConstructorsSet() {
        List listOf;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BYTE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, jvmPrimitiveType, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, jvmPrimitiveType, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT});
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            String asString = ((JvmPrimitiveType) it.next()).getWrapperFqName().shortName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "it.wrapperFqName.shortName().asString()");
            String[] constructors = signatureBuildingComponents.constructors("Ljava/lang/String;");
            CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, signatureBuildingComponents.inJavaLang(asString, (String[]) Arrays.copyOf(constructors, constructors.length)));
        }
        return linkedHashSet;
    }

    private final Set<String> buildPrimitiveValueMethodsSet() {
        List<JvmPrimitiveType> listOf;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR});
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JvmPrimitiveType jvmPrimitiveType : listOf) {
            String asString = jvmPrimitiveType.getWrapperFqName().shortName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "it.wrapperFqName.shortName().asString()");
            CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, signatureBuildingComponents.inJavaLang(asString, jvmPrimitiveType.getJavaKeywordName() + "Value()" + jvmPrimitiveType.getDesc()));
        }
        return linkedHashSet;
    }

    @NotNull
    public final Set<String> getDROP_LIST_METHOD_SIGNATURES() {
        return DROP_LIST_METHOD_SIGNATURES;
    }

    @NotNull
    public final Set<String> getHIDDEN_CONSTRUCTOR_SIGNATURES() {
        return HIDDEN_CONSTRUCTOR_SIGNATURES;
    }

    @NotNull
    public final Set<String> getHIDDEN_METHOD_SIGNATURES() {
        return HIDDEN_METHOD_SIGNATURES;
    }

    @NotNull
    public final Set<String> getMUTABLE_METHOD_SIGNATURES() {
        return MUTABLE_METHOD_SIGNATURES;
    }

    @NotNull
    public final Set<String> getVISIBLE_CONSTRUCTOR_SIGNATURES() {
        return VISIBLE_CONSTRUCTOR_SIGNATURES;
    }

    @NotNull
    public final Set<String> getVISIBLE_METHOD_SIGNATURES() {
        return VISIBLE_METHOD_SIGNATURES;
    }

    public final boolean isArrayOrPrimitiveArray(@NotNull FqNameUnsafe fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (!Intrinsics.areEqual(fqName, StandardNames.FqNames.array) && !StandardNames.isPrimitiveArray(fqName)) {
            return false;
        }
        return true;
    }

    public final boolean isSerializableInJava(@NotNull FqNameUnsafe fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (isArrayOrPrimitiveArray(fqName)) {
            return true;
        }
        ClassId mapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqName);
        if (mapKotlinToJava == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(mapKotlinToJava.asSingleFqName().asString()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
