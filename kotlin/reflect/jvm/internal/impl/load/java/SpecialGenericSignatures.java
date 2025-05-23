package kotlin.reflect.jvm.internal.impl.load.java;

import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SpecialGenericSignatures {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final List<String> ERASED_COLLECTION_PARAMETER_NAMES;

    @NotNull
    private static final List<Companion.NameAndSignature> ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;

    @NotNull
    private static final List<String> ERASED_COLLECTION_PARAMETER_SIGNATURES;

    @NotNull
    private static final Set<Name> ERASED_VALUE_PARAMETERS_SHORT_NAMES;

    @NotNull
    private static final Set<String> ERASED_VALUE_PARAMETERS_SIGNATURES;

    @NotNull
    private static final Map<Companion.NameAndSignature, TypeSafeBarrierDescription> GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP;

    @NotNull
    private static final Map<Name, Name> JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;

    @NotNull
    private static final Map<Companion.NameAndSignature, Name> NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;

    @NotNull
    private static final List<Name> ORIGINAL_SHORT_NAMES;

    @NotNull
    private static final Companion.NameAndSignature REMOVE_AT_NAME_AND_SIGNATURE;

    @NotNull
    private static final Map<String, TypeSafeBarrierDescription> SIGNATURE_TO_DEFAULT_VALUES_MAP;

    @NotNull
    private static final Map<String, Name> SIGNATURE_TO_JVM_REPRESENTATION_NAME;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public static final class NameAndSignature {

            @NotNull
            private final Name name;

            @NotNull
            private final String signature;

            public NameAndSignature(@NotNull Name name, @NotNull String signature) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(signature, "signature");
                this.name = name;
                this.signature = signature;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof NameAndSignature)) {
                    return false;
                }
                NameAndSignature nameAndSignature = (NameAndSignature) obj;
                if (Intrinsics.areEqual(this.name, nameAndSignature.name) && Intrinsics.areEqual(this.signature, nameAndSignature.signature)) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final Name getName() {
                return this.name;
            }

            @NotNull
            public final String getSignature() {
                return this.signature;
            }

            public int hashCode() {
                return (this.name.hashCode() * 31) + this.signature.hashCode();
            }

            @NotNull
            public String toString() {
                return "NameAndSignature(name=" + this.name + ", signature=" + this.signature + ')';
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final NameAndSignature method(String str, String str2, String str3, String str4) {
            Name identifier = Name.identifier(str2);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(name)");
            return new NameAndSignature(identifier, SignatureBuildingComponents.INSTANCE.signature(str, str2 + '(' + str3 + ')' + str4));
        }

        @Nullable
        public final Name getBuiltinFunctionNamesByJvmName(@NotNull Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(name);
        }

        @NotNull
        public final List<String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return SpecialGenericSignatures.ERASED_COLLECTION_PARAMETER_SIGNATURES;
        }

        @NotNull
        public final Set<Name> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SHORT_NAMES;
        }

        @NotNull
        public final Set<String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SIGNATURES;
        }

        @NotNull
        public final Map<Name, Name> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return SpecialGenericSignatures.JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
        }

        @NotNull
        public final List<Name> getORIGINAL_SHORT_NAMES() {
            return SpecialGenericSignatures.ORIGINAL_SHORT_NAMES;
        }

        @NotNull
        public final NameAndSignature getREMOVE_AT_NAME_AND_SIGNATURE() {
            return SpecialGenericSignatures.REMOVE_AT_NAME_AND_SIGNATURE;
        }

        @NotNull
        public final Map<String, TypeSafeBarrierDescription> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return SpecialGenericSignatures.SIGNATURE_TO_DEFAULT_VALUES_MAP;
        }

        @NotNull
        public final Map<String, Name> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return SpecialGenericSignatures.SIGNATURE_TO_JVM_REPRESENTATION_NAME;
        }

        public final boolean getSameAsRenamedInJvmBuiltin(@NotNull Name name) {
            Intrinsics.checkNotNullParameter(name, "<this>");
            return getORIGINAL_SHORT_NAMES().contains(name);
        }

        @NotNull
        public final SpecialSignatureInfo getSpecialSignatureInfo(@NotNull String builtinSignature) {
            Object value;
            Intrinsics.checkNotNullParameter(builtinSignature, "builtinSignature");
            if (!getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(builtinSignature)) {
                value = MapsKt__MapsKt.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), builtinSignature);
                if (((TypeSafeBarrierDescription) value) == TypeSafeBarrierDescription.NULL) {
                    return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
                }
                return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
            }
            return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);

        private final boolean isObjectReplacedWithTypeParameter;

        @Nullable
        private final String valueParametersSignature;

        SpecialSignatureInfo(String str, boolean z16) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z16;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class TypeSafeBarrierDescription {

        @Nullable
        private final Object defaultValue;
        public static final TypeSafeBarrierDescription NULL = new TypeSafeBarrierDescription("NULL", 0, null);
        public static final TypeSafeBarrierDescription INDEX = new TypeSafeBarrierDescription("INDEX", 1, -1);
        public static final TypeSafeBarrierDescription FALSE = new TypeSafeBarrierDescription(Constants.KEY_OPTION_FALSE, 2, Boolean.FALSE);
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES = $values();

        /* compiled from: P */
        /* loaded from: classes28.dex */
        static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            MAP_GET_OR_DEFAULT(String str, int i3) {
                super(str, i3, r0, r0);
                DefaultConstructorMarker defaultConstructorMarker = null;
            }
        }

        private static final /* synthetic */ TypeSafeBarrierDescription[] $values() {
            return new TypeSafeBarrierDescription[]{NULL, INDEX, FALSE, MAP_GET_OR_DEFAULT};
        }

        public /* synthetic */ TypeSafeBarrierDescription(String str, int i3, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, obj);
        }

        public static TypeSafeBarrierDescription valueOf(String str) {
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, str);
        }

        public static TypeSafeBarrierDescription[] values() {
            return (TypeSafeBarrierDescription[]) $VALUES.clone();
        }

        TypeSafeBarrierDescription(String str, int i3, Object obj) {
            this.defaultValue = obj;
        }
    }

    static {
        Set<String> of5;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        Map<Companion.NameAndSignature, TypeSafeBarrierDescription> mapOf;
        int mapCapacity;
        Set plus;
        int collectionSizeOrDefault4;
        Set<Name> set;
        int collectionSizeOrDefault5;
        Set<String> set2;
        Map<Companion.NameAndSignature, Name> mapOf2;
        int mapCapacity2;
        int collectionSizeOrDefault6;
        int collectionSizeOrDefault7;
        int collectionSizeOrDefault8;
        int mapCapacity3;
        int coerceAtLeast;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"containsAll", "removeAll", "retainAll"});
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(of5, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str : of5) {
            Companion companion = Companion;
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            Intrinsics.checkNotNullExpressionValue(desc, "BOOLEAN.desc");
            arrayList.add(companion.method("java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = arrayList;
        ArrayList arrayList2 = arrayList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((Companion.NameAndSignature) it.next()).getSignature());
        }
        ERASED_COLLECTION_PARAMETER_SIGNATURES = arrayList3;
        List<Companion.NameAndSignature> list = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault3);
        Iterator<T> it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList4.add(((Companion.NameAndSignature) it5.next()).getName().asString());
        }
        ERASED_COLLECTION_PARAMETER_NAMES = arrayList4;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        Companion companion2 = Companion;
        String javaUtil = signatureBuildingComponents.javaUtil("Collection");
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BOOLEAN;
        String desc2 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc2, "BOOLEAN.desc");
        Companion.NameAndSignature method = companion2.method(javaUtil, "contains", "Ljava/lang/Object;", desc2);
        TypeSafeBarrierDescription typeSafeBarrierDescription = TypeSafeBarrierDescription.FALSE;
        String javaUtil2 = signatureBuildingComponents.javaUtil("Collection");
        String desc3 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc3, "BOOLEAN.desc");
        String javaUtil3 = signatureBuildingComponents.javaUtil("Map");
        String desc4 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc4, "BOOLEAN.desc");
        String javaUtil4 = signatureBuildingComponents.javaUtil("Map");
        String desc5 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc5, "BOOLEAN.desc");
        String javaUtil5 = signatureBuildingComponents.javaUtil("Map");
        String desc6 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc6, "BOOLEAN.desc");
        Companion.NameAndSignature method2 = companion2.method(signatureBuildingComponents.javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        TypeSafeBarrierDescription typeSafeBarrierDescription2 = TypeSafeBarrierDescription.NULL;
        String javaUtil6 = signatureBuildingComponents.javaUtil("List");
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.INT;
        String desc7 = jvmPrimitiveType2.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc7, "INT.desc");
        Companion.NameAndSignature method3 = companion2.method(javaUtil6, "indexOf", "Ljava/lang/Object;", desc7);
        TypeSafeBarrierDescription typeSafeBarrierDescription3 = TypeSafeBarrierDescription.INDEX;
        String javaUtil7 = signatureBuildingComponents.javaUtil("List");
        String desc8 = jvmPrimitiveType2.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc8, "INT.desc");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(method, typeSafeBarrierDescription), TuplesKt.to(companion2.method(javaUtil2, "remove", "Ljava/lang/Object;", desc3), typeSafeBarrierDescription), TuplesKt.to(companion2.method(javaUtil3, "containsKey", "Ljava/lang/Object;", desc4), typeSafeBarrierDescription), TuplesKt.to(companion2.method(javaUtil4, "containsValue", "Ljava/lang/Object;", desc5), typeSafeBarrierDescription), TuplesKt.to(companion2.method(javaUtil5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), typeSafeBarrierDescription), TuplesKt.to(companion2.method(signatureBuildingComponents.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), TuplesKt.to(method2, typeSafeBarrierDescription2), TuplesKt.to(companion2.method(signatureBuildingComponents.javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), typeSafeBarrierDescription2), TuplesKt.to(method3, typeSafeBarrierDescription3), TuplesKt.to(companion2.method(javaUtil7, "lastIndexOf", "Ljava/lang/Object;", desc8), typeSafeBarrierDescription3));
        GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = mapOf;
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(mapOf.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it6 = mapOf.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry entry = (Map.Entry) it6.next();
            linkedHashMap.put(((Companion.NameAndSignature) entry.getKey()).getSignature(), entry.getValue());
        }
        SIGNATURE_TO_DEFAULT_VALUES_MAP = linkedHashMap;
        plus = SetsKt___SetsKt.plus((Set) GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), (Iterable) ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
        collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(plus, 10);
        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault4);
        Iterator it7 = plus.iterator();
        while (it7.hasNext()) {
            arrayList5.add(((Companion.NameAndSignature) it7.next()).getName());
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList5);
        ERASED_VALUE_PARAMETERS_SHORT_NAMES = set;
        collectionSizeOrDefault5 = CollectionsKt__IterablesKt.collectionSizeOrDefault(plus, 10);
        ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault5);
        Iterator it8 = plus.iterator();
        while (it8.hasNext()) {
            arrayList6.add(((Companion.NameAndSignature) it8.next()).getSignature());
        }
        set2 = CollectionsKt___CollectionsKt.toSet(arrayList6);
        ERASED_VALUE_PARAMETERS_SIGNATURES = set2;
        Companion companion3 = Companion;
        JvmPrimitiveType jvmPrimitiveType3 = JvmPrimitiveType.INT;
        String desc9 = jvmPrimitiveType3.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc9, "INT.desc");
        Companion.NameAndSignature method4 = companion3.method("java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        REMOVE_AT_NAME_AND_SIGNATURE = method4;
        SignatureBuildingComponents signatureBuildingComponents2 = SignatureBuildingComponents.INSTANCE;
        String javaLang = signatureBuildingComponents2.javaLang("Number");
        String desc10 = JvmPrimitiveType.BYTE.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc10, "BYTE.desc");
        String javaLang2 = signatureBuildingComponents2.javaLang("Number");
        String desc11 = JvmPrimitiveType.SHORT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc11, "SHORT.desc");
        String javaLang3 = signatureBuildingComponents2.javaLang("Number");
        String desc12 = jvmPrimitiveType3.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc12, "INT.desc");
        String javaLang4 = signatureBuildingComponents2.javaLang("Number");
        String desc13 = JvmPrimitiveType.LONG.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc13, "LONG.desc");
        String javaLang5 = signatureBuildingComponents2.javaLang("Number");
        String desc14 = JvmPrimitiveType.FLOAT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc14, "FLOAT.desc");
        String javaLang6 = signatureBuildingComponents2.javaLang("Number");
        String desc15 = JvmPrimitiveType.DOUBLE.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc15, "DOUBLE.desc");
        String javaLang7 = signatureBuildingComponents2.javaLang("CharSequence");
        String desc16 = jvmPrimitiveType3.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc16, "INT.desc");
        String desc17 = JvmPrimitiveType.CHAR.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc17, "CHAR.desc");
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(companion3.method(javaLang, "toByte", "", desc10), Name.identifier("byteValue")), TuplesKt.to(companion3.method(javaLang2, "toShort", "", desc11), Name.identifier("shortValue")), TuplesKt.to(companion3.method(javaLang3, "toInt", "", desc12), Name.identifier("intValue")), TuplesKt.to(companion3.method(javaLang4, "toLong", "", desc13), Name.identifier("longValue")), TuplesKt.to(companion3.method(javaLang5, "toFloat", "", desc14), Name.identifier("floatValue")), TuplesKt.to(companion3.method(javaLang6, "toDouble", "", desc15), Name.identifier("doubleValue")), TuplesKt.to(method4, Name.identifier("remove")), TuplesKt.to(companion3.method(javaLang7, "get", desc16, desc17), Name.identifier("charAt")));
        NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = mapOf2;
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(mapOf2.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity2);
        Iterator<T> it9 = mapOf2.entrySet().iterator();
        while (it9.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it9.next();
            linkedHashMap2.put(((Companion.NameAndSignature) entry2.getKey()).getSignature(), entry2.getValue());
        }
        SIGNATURE_TO_JVM_REPRESENTATION_NAME = linkedHashMap2;
        Set<Companion.NameAndSignature> keySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
        collectionSizeOrDefault6 = CollectionsKt__IterablesKt.collectionSizeOrDefault(keySet, 10);
        ArrayList arrayList7 = new ArrayList(collectionSizeOrDefault6);
        Iterator<T> it10 = keySet.iterator();
        while (it10.hasNext()) {
            arrayList7.add(((Companion.NameAndSignature) it10.next()).getName());
        }
        ORIGINAL_SHORT_NAMES = arrayList7;
        Set<Map.Entry<Companion.NameAndSignature, Name>> entrySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
        collectionSizeOrDefault7 = CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10);
        ArrayList<Pair> arrayList8 = new ArrayList(collectionSizeOrDefault7);
        Iterator<T> it11 = entrySet.iterator();
        while (it11.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it11.next();
            arrayList8.add(new Pair(((Companion.NameAndSignature) entry3.getKey()).getName(), entry3.getValue()));
        }
        collectionSizeOrDefault8 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList8, 10);
        mapCapacity3 = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault8);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity3, 16);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(coerceAtLeast);
        for (Pair pair : arrayList8) {
            linkedHashMap3.put((Name) pair.getSecond(), (Name) pair.getFirst());
        }
        JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = linkedHashMap3;
    }
}
