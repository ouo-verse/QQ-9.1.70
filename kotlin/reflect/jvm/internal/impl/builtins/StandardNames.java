package kotlin.reflect.jvm.internal.impl.builtins;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.mini.cache.Entry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class StandardNames {

    @JvmField
    @NotNull
    public static final FqName ANNOTATION_PACKAGE_FQ_NAME;

    @JvmField
    @NotNull
    public static final Name BACKING_FIELD;

    @JvmField
    @NotNull
    public static final FqName BUILT_INS_PACKAGE_FQ_NAME;

    @JvmField
    @NotNull
    public static final Set<FqName> BUILT_INS_PACKAGE_FQ_NAMES;

    @JvmField
    @NotNull
    public static final Name BUILT_INS_PACKAGE_NAME;

    @JvmField
    @NotNull
    public static final Name CHAR_CODE;

    @JvmField
    @NotNull
    public static final FqName COLLECTIONS_PACKAGE_FQ_NAME;

    @JvmField
    @NotNull
    public static final Name CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME;

    @JvmField
    @NotNull
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME;

    @JvmField
    @NotNull
    public static final FqName COROUTINES_INTRINSICS_PACKAGE_FQ_NAME;

    @JvmField
    @NotNull
    public static final FqName COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME;

    @JvmField
    @NotNull
    public static final FqName COROUTINES_PACKAGE_FQ_NAME;

    @JvmField
    @NotNull
    public static final String DATA_CLASS_COMPONENT_PREFIX;

    @JvmField
    @NotNull
    public static final Name DATA_CLASS_COPY;

    @JvmField
    @NotNull
    public static final Name DEFAULT_VALUE_PARAMETER;

    @JvmField
    @NotNull
    public static final FqName DYNAMIC_FQ_NAME;

    @JvmField
    @NotNull
    public static final Name ENUM_VALUES;

    @JvmField
    @NotNull
    public static final Name ENUM_VALUE_OF;

    @JvmField
    @NotNull
    public static final Name HASHCODE_NAME;

    @NotNull
    public static final StandardNames INSTANCE = new StandardNames();

    @NotNull
    private static final FqName KOTLIN_INTERNAL_FQ_NAME;

    @JvmField
    @NotNull
    public static final FqName KOTLIN_REFLECT_FQ_NAME;

    @JvmField
    @NotNull
    public static final List<String> PREFIXES;

    @JvmField
    @NotNull
    public static final FqName RANGES_PACKAGE_FQ_NAME;

    @JvmField
    @NotNull
    public static final FqName RESULT_FQ_NAME;

    @JvmField
    @NotNull
    public static final FqName TEXT_PACKAGE_FQ_NAME;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class FqNames {

        @NotNull
        public static final FqNames INSTANCE;

        @JvmField
        @NotNull
        public static final FqNameUnsafe _boolean;

        @JvmField
        @NotNull
        public static final FqNameUnsafe _byte;

        @JvmField
        @NotNull
        public static final FqNameUnsafe _char;

        @JvmField
        @NotNull
        public static final FqNameUnsafe _double;

        @JvmField
        @NotNull
        public static final FqNameUnsafe _enum;

        @JvmField
        @NotNull
        public static final FqNameUnsafe _float;

        @JvmField
        @NotNull
        public static final FqNameUnsafe _int;

        @JvmField
        @NotNull
        public static final FqNameUnsafe _long;

        @JvmField
        @NotNull
        public static final FqNameUnsafe _short;

        @JvmField
        @NotNull
        public static final FqName annotation;

        @JvmField
        @NotNull
        public static final FqName annotationRetention;

        @JvmField
        @NotNull
        public static final FqName annotationTarget;

        @JvmField
        @NotNull
        public static final FqNameUnsafe any;

        @JvmField
        @NotNull
        public static final FqNameUnsafe array;

        @JvmField
        @NotNull
        public static final Map<FqNameUnsafe, PrimitiveType> arrayClassFqNameToPrimitiveType;

        @JvmField
        @NotNull
        public static final FqNameUnsafe charSequence;

        @JvmField
        @NotNull
        public static final FqNameUnsafe cloneable;

        @JvmField
        @NotNull
        public static final FqName collection;

        @JvmField
        @NotNull
        public static final FqName comparable;

        @JvmField
        @NotNull
        public static final FqName contextFunctionTypeParams;

        @JvmField
        @NotNull
        public static final FqName deprecated;

        @JvmField
        @NotNull
        public static final FqName deprecatedSinceKotlin;

        @JvmField
        @NotNull
        public static final FqName deprecationLevel;

        @JvmField
        @NotNull
        public static final FqName extensionFunctionType;

        @JvmField
        @NotNull
        public static final Map<FqNameUnsafe, PrimitiveType> fqNameToPrimitiveType;

        @JvmField
        @NotNull
        public static final FqNameUnsafe functionSupertype;

        @JvmField
        @NotNull
        public static final FqNameUnsafe intRange;

        @JvmField
        @NotNull
        public static final FqName iterable;

        @JvmField
        @NotNull
        public static final FqName iterator;

        @JvmField
        @NotNull
        public static final FqNameUnsafe kCallable;

        @JvmField
        @NotNull
        public static final FqNameUnsafe kClass;

        @JvmField
        @NotNull
        public static final FqNameUnsafe kDeclarationContainer;

        @JvmField
        @NotNull
        public static final FqNameUnsafe kMutableProperty0;

        @JvmField
        @NotNull
        public static final FqNameUnsafe kMutableProperty1;

        @JvmField
        @NotNull
        public static final FqNameUnsafe kMutableProperty2;

        @JvmField
        @NotNull
        public static final FqNameUnsafe kMutablePropertyFqName;

        @JvmField
        @NotNull
        public static final ClassId kProperty;

        @JvmField
        @NotNull
        public static final FqNameUnsafe kProperty0;

        @JvmField
        @NotNull
        public static final FqNameUnsafe kProperty1;

        @JvmField
        @NotNull
        public static final FqNameUnsafe kProperty2;

        @JvmField
        @NotNull
        public static final FqNameUnsafe kPropertyFqName;

        @JvmField
        @NotNull
        public static final FqName list;

        @JvmField
        @NotNull
        public static final FqName listIterator;

        @JvmField
        @NotNull
        public static final FqNameUnsafe longRange;

        @JvmField
        @NotNull
        public static final FqName map;

        @JvmField
        @NotNull
        public static final FqName mapEntry;

        @JvmField
        @NotNull
        public static final FqName mustBeDocumented;

        @JvmField
        @NotNull
        public static final FqName mutableCollection;

        @JvmField
        @NotNull
        public static final FqName mutableIterable;

        @JvmField
        @NotNull
        public static final FqName mutableIterator;

        @JvmField
        @NotNull
        public static final FqName mutableList;

        @JvmField
        @NotNull
        public static final FqName mutableListIterator;

        @JvmField
        @NotNull
        public static final FqName mutableMap;

        @JvmField
        @NotNull
        public static final FqName mutableMapEntry;

        @JvmField
        @NotNull
        public static final FqName mutableSet;

        @JvmField
        @NotNull
        public static final FqNameUnsafe nothing;

        @JvmField
        @NotNull
        public static final FqNameUnsafe number;

        @JvmField
        @NotNull
        public static final FqName parameterName;

        @JvmField
        @NotNull
        public static final ClassId parameterNameClassId;

        @JvmField
        @NotNull
        public static final Set<Name> primitiveArrayTypeShortNames;

        @JvmField
        @NotNull
        public static final Set<Name> primitiveTypeShortNames;

        @JvmField
        @NotNull
        public static final FqName publishedApi;

        @JvmField
        @NotNull
        public static final FqName repeatable;

        @JvmField
        @NotNull
        public static final ClassId repeatableClassId;

        @JvmField
        @NotNull
        public static final FqName replaceWith;

        @JvmField
        @NotNull
        public static final FqName retention;

        @JvmField
        @NotNull
        public static final ClassId retentionClassId;

        @JvmField
        @NotNull
        public static final FqName set;

        @JvmField
        @NotNull
        public static final FqNameUnsafe string;

        @JvmField
        @NotNull
        public static final FqName suppress;

        @JvmField
        @NotNull
        public static final FqName target;

        @JvmField
        @NotNull
        public static final ClassId targetClassId;

        @JvmField
        @NotNull
        public static final FqName throwable;

        @JvmField
        @NotNull
        public static final ClassId uByte;

        @JvmField
        @NotNull
        public static final FqName uByteArrayFqName;

        @JvmField
        @NotNull
        public static final FqName uByteFqName;

        @JvmField
        @NotNull
        public static final ClassId uInt;

        @JvmField
        @NotNull
        public static final FqName uIntArrayFqName;

        @JvmField
        @NotNull
        public static final FqName uIntFqName;

        @JvmField
        @NotNull
        public static final ClassId uLong;

        @JvmField
        @NotNull
        public static final FqName uLongArrayFqName;

        @JvmField
        @NotNull
        public static final FqName uLongFqName;

        @JvmField
        @NotNull
        public static final ClassId uShort;

        @JvmField
        @NotNull
        public static final FqName uShortArrayFqName;

        @JvmField
        @NotNull
        public static final FqName uShortFqName;

        @JvmField
        @NotNull
        public static final FqNameUnsafe unit;

        @JvmField
        @NotNull
        public static final FqName unsafeVariance;

        static {
            FqNames fqNames = new FqNames();
            INSTANCE = fqNames;
            any = fqNames.fqNameUnsafe("Any");
            nothing = fqNames.fqNameUnsafe("Nothing");
            cloneable = fqNames.fqNameUnsafe("Cloneable");
            suppress = fqNames.fqName("Suppress");
            unit = fqNames.fqNameUnsafe("Unit");
            charSequence = fqNames.fqNameUnsafe("CharSequence");
            string = fqNames.fqNameUnsafe(Entry.DATA_TYPE_STRING);
            array = fqNames.fqNameUnsafe(Entry.DATA_TYPE_Array);
            _boolean = fqNames.fqNameUnsafe("Boolean");
            _char = fqNames.fqNameUnsafe("Char");
            _byte = fqNames.fqNameUnsafe("Byte");
            _short = fqNames.fqNameUnsafe("Short");
            _int = fqNames.fqNameUnsafe("Int");
            _long = fqNames.fqNameUnsafe("Long");
            _float = fqNames.fqNameUnsafe("Float");
            _double = fqNames.fqNameUnsafe("Double");
            number = fqNames.fqNameUnsafe("Number");
            _enum = fqNames.fqNameUnsafe("Enum");
            functionSupertype = fqNames.fqNameUnsafe("Function");
            throwable = fqNames.fqName("Throwable");
            comparable = fqNames.fqName("Comparable");
            intRange = fqNames.rangesFqName("IntRange");
            longRange = fqNames.rangesFqName("LongRange");
            deprecated = fqNames.fqName("Deprecated");
            deprecatedSinceKotlin = fqNames.fqName("DeprecatedSinceKotlin");
            deprecationLevel = fqNames.fqName("DeprecationLevel");
            replaceWith = fqNames.fqName("ReplaceWith");
            extensionFunctionType = fqNames.fqName("ExtensionFunctionType");
            contextFunctionTypeParams = fqNames.fqName("ContextFunctionTypeParams");
            FqName fqName = fqNames.fqName("ParameterName");
            parameterName = fqName;
            ClassId classId = ClassId.topLevel(fqName);
            Intrinsics.checkNotNullExpressionValue(classId, "topLevel(parameterName)");
            parameterNameClassId = classId;
            annotation = fqNames.fqName("Annotation");
            FqName annotationName = fqNames.annotationName("Target");
            target = annotationName;
            ClassId classId2 = ClassId.topLevel(annotationName);
            Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(target)");
            targetClassId = classId2;
            annotationTarget = fqNames.annotationName("AnnotationTarget");
            annotationRetention = fqNames.annotationName("AnnotationRetention");
            FqName annotationName2 = fqNames.annotationName("Retention");
            retention = annotationName2;
            ClassId classId3 = ClassId.topLevel(annotationName2);
            Intrinsics.checkNotNullExpressionValue(classId3, "topLevel(retention)");
            retentionClassId = classId3;
            FqName annotationName3 = fqNames.annotationName("Repeatable");
            repeatable = annotationName3;
            ClassId classId4 = ClassId.topLevel(annotationName3);
            Intrinsics.checkNotNullExpressionValue(classId4, "topLevel(repeatable)");
            repeatableClassId = classId4;
            mustBeDocumented = fqNames.annotationName("MustBeDocumented");
            unsafeVariance = fqNames.fqName("UnsafeVariance");
            publishedApi = fqNames.fqName("PublishedApi");
            iterator = fqNames.collectionsFqName("Iterator");
            iterable = fqNames.collectionsFqName("Iterable");
            collection = fqNames.collectionsFqName("Collection");
            list = fqNames.collectionsFqName("List");
            listIterator = fqNames.collectionsFqName("ListIterator");
            set = fqNames.collectionsFqName("Set");
            FqName collectionsFqName = fqNames.collectionsFqName("Map");
            map = collectionsFqName;
            FqName child = collectionsFqName.child(Name.identifier("Entry"));
            Intrinsics.checkNotNullExpressionValue(child, "map.child(Name.identifier(\"Entry\"))");
            mapEntry = child;
            mutableIterator = fqNames.collectionsFqName("MutableIterator");
            mutableIterable = fqNames.collectionsFqName("MutableIterable");
            mutableCollection = fqNames.collectionsFqName("MutableCollection");
            mutableList = fqNames.collectionsFqName("MutableList");
            mutableListIterator = fqNames.collectionsFqName("MutableListIterator");
            mutableSet = fqNames.collectionsFqName("MutableSet");
            FqName collectionsFqName2 = fqNames.collectionsFqName("MutableMap");
            mutableMap = collectionsFqName2;
            FqName child2 = collectionsFqName2.child(Name.identifier("MutableEntry"));
            Intrinsics.checkNotNullExpressionValue(child2, "mutableMap.child(Name.identifier(\"MutableEntry\"))");
            mutableMapEntry = child2;
            kClass = reflect("KClass");
            kCallable = reflect("KCallable");
            kProperty0 = reflect("KProperty0");
            kProperty1 = reflect("KProperty1");
            kProperty2 = reflect("KProperty2");
            kMutableProperty0 = reflect("KMutableProperty0");
            kMutableProperty1 = reflect("KMutableProperty1");
            kMutableProperty2 = reflect("KMutableProperty2");
            FqNameUnsafe reflect = reflect("KProperty");
            kPropertyFqName = reflect;
            kMutablePropertyFqName = reflect("KMutableProperty");
            ClassId classId5 = ClassId.topLevel(reflect.toSafe());
            Intrinsics.checkNotNullExpressionValue(classId5, "topLevel(kPropertyFqName.toSafe())");
            kProperty = classId5;
            kDeclarationContainer = reflect("KDeclarationContainer");
            FqName fqName2 = fqNames.fqName("UByte");
            uByteFqName = fqName2;
            FqName fqName3 = fqNames.fqName("UShort");
            uShortFqName = fqName3;
            FqName fqName4 = fqNames.fqName("UInt");
            uIntFqName = fqName4;
            FqName fqName5 = fqNames.fqName("ULong");
            uLongFqName = fqName5;
            ClassId classId6 = ClassId.topLevel(fqName2);
            Intrinsics.checkNotNullExpressionValue(classId6, "topLevel(uByteFqName)");
            uByte = classId6;
            ClassId classId7 = ClassId.topLevel(fqName3);
            Intrinsics.checkNotNullExpressionValue(classId7, "topLevel(uShortFqName)");
            uShort = classId7;
            ClassId classId8 = ClassId.topLevel(fqName4);
            Intrinsics.checkNotNullExpressionValue(classId8, "topLevel(uIntFqName)");
            uInt = classId8;
            ClassId classId9 = ClassId.topLevel(fqName5);
            Intrinsics.checkNotNullExpressionValue(classId9, "topLevel(uLongFqName)");
            uLong = classId9;
            uByteArrayFqName = fqNames.fqName("UByteArray");
            uShortArrayFqName = fqNames.fqName("UShortArray");
            uIntArrayFqName = fqNames.fqName("UIntArray");
            uLongArrayFqName = fqNames.fqName("ULongArray");
            HashSet newHashSetWithExpectedSize = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                newHashSetWithExpectedSize.add(primitiveType.getTypeName());
            }
            primitiveTypeShortNames = newHashSetWithExpectedSize;
            HashSet newHashSetWithExpectedSize2 = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            for (PrimitiveType primitiveType2 : PrimitiveType.values()) {
                newHashSetWithExpectedSize2.add(primitiveType2.getArrayTypeName());
            }
            primitiveArrayTypeShortNames = newHashSetWithExpectedSize2;
            HashMap newHashMapWithExpectedSize = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            for (PrimitiveType primitiveType3 : PrimitiveType.values()) {
                FqNames fqNames2 = INSTANCE;
                String asString = primitiveType3.getTypeName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "primitiveType.typeName.asString()");
                newHashMapWithExpectedSize.put(fqNames2.fqNameUnsafe(asString), primitiveType3);
            }
            fqNameToPrimitiveType = newHashMapWithExpectedSize;
            HashMap newHashMapWithExpectedSize2 = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            for (PrimitiveType primitiveType4 : PrimitiveType.values()) {
                FqNames fqNames3 = INSTANCE;
                String asString2 = primitiveType4.getArrayTypeName().asString();
                Intrinsics.checkNotNullExpressionValue(asString2, "primitiveType.arrayTypeName.asString()");
                newHashMapWithExpectedSize2.put(fqNames3.fqNameUnsafe(asString2), primitiveType4);
            }
            arrayClassFqNameToPrimitiveType = newHashMapWithExpectedSize2;
        }

        FqNames() {
        }

        private final FqName annotationName(String str) {
            FqName child = StandardNames.ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "ANNOTATION_PACKAGE_FQ_NA\u2026e.identifier(simpleName))");
            return child;
        }

        private final FqName collectionsFqName(String str) {
            FqName child = StandardNames.COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "COLLECTIONS_PACKAGE_FQ_N\u2026e.identifier(simpleName))");
            return child;
        }

        private final FqName fqName(String str) {
            FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAM\u2026e.identifier(simpleName))");
            return child;
        }

        private final FqNameUnsafe fqNameUnsafe(String str) {
            FqNameUnsafe unsafe = fqName(str).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "fqName(simpleName).toUnsafe()");
            return unsafe;
        }

        private final FqNameUnsafe rangesFqName(String str) {
            FqNameUnsafe unsafe = StandardNames.RANGES_PACKAGE_FQ_NAME.child(Name.identifier(str)).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "RANGES_PACKAGE_FQ_NAME.c\u2026r(simpleName)).toUnsafe()");
            return unsafe;
        }

        @JvmStatic
        @NotNull
        public static final FqNameUnsafe reflect(@NotNull String simpleName) {
            Intrinsics.checkNotNullParameter(simpleName, "simpleName");
            FqNameUnsafe unsafe = StandardNames.KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(simpleName)).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "KOTLIN_REFLECT_FQ_NAME.c\u2026r(simpleName)).toUnsafe()");
            return unsafe;
        }
    }

    static {
        List<String> listOf;
        Set<FqName> of5;
        Name identifier = Name.identifier("field");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"field\")");
        BACKING_FIELD = identifier;
        Name identifier2 = Name.identifier("value");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"value\")");
        DEFAULT_VALUE_PARAMETER = identifier2;
        Name identifier3 = Name.identifier("values");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(\"values\")");
        ENUM_VALUES = identifier3;
        Name identifier4 = Name.identifier("valueOf");
        Intrinsics.checkNotNullExpressionValue(identifier4, "identifier(\"valueOf\")");
        ENUM_VALUE_OF = identifier4;
        Name identifier5 = Name.identifier("copy");
        Intrinsics.checkNotNullExpressionValue(identifier5, "identifier(\"copy\")");
        DATA_CLASS_COPY = identifier5;
        DATA_CLASS_COMPONENT_PREFIX = HippyQQConstants.URL_COMPONENT_NAME;
        Name identifier6 = Name.identifier("hashCode");
        Intrinsics.checkNotNullExpressionValue(identifier6, "identifier(\"hashCode\")");
        HASHCODE_NAME = identifier6;
        Name identifier7 = Name.identifier("code");
        Intrinsics.checkNotNullExpressionValue(identifier7, "identifier(\"code\")");
        CHAR_CODE = identifier7;
        Name identifier8 = Name.identifier("count");
        Intrinsics.checkNotNullExpressionValue(identifier8, "identifier(\"count\")");
        CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME = identifier8;
        DYNAMIC_FQ_NAME = new FqName("<dynamic>");
        FqName fqName = new FqName("kotlin.coroutines");
        COROUTINES_PACKAGE_FQ_NAME = fqName;
        COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.jvm.internal");
        COROUTINES_INTRINSICS_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.intrinsics");
        FqName child = fqName.child(Name.identifier("Continuation"));
        Intrinsics.checkNotNullExpressionValue(child, "COROUTINES_PACKAGE_FQ_NA\u2026entifier(\"Continuation\"))");
        CONTINUATION_INTERFACE_FQ_NAME = child;
        RESULT_FQ_NAME = new FqName("kotlin.Result");
        FqName fqName2 = new FqName("kotlin.reflect");
        KOTLIN_REFLECT_FQ_NAME = fqName2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"KProperty", "KMutableProperty", "KFunction", "KSuspendFunction"});
        PREFIXES = listOf;
        Name identifier9 = Name.identifier("kotlin");
        Intrinsics.checkNotNullExpressionValue(identifier9, "identifier(\"kotlin\")");
        BUILT_INS_PACKAGE_NAME = identifier9;
        FqName fqName3 = FqName.topLevel(identifier9);
        Intrinsics.checkNotNullExpressionValue(fqName3, "topLevel(BUILT_INS_PACKAGE_NAME)");
        BUILT_INS_PACKAGE_FQ_NAME = fqName3;
        FqName child2 = fqName3.child(Name.identifier("annotation"));
        Intrinsics.checkNotNullExpressionValue(child2, "BUILT_INS_PACKAGE_FQ_NAM\u2026identifier(\"annotation\"))");
        ANNOTATION_PACKAGE_FQ_NAME = child2;
        FqName child3 = fqName3.child(Name.identifier("collections"));
        Intrinsics.checkNotNullExpressionValue(child3, "BUILT_INS_PACKAGE_FQ_NAM\u2026dentifier(\"collections\"))");
        COLLECTIONS_PACKAGE_FQ_NAME = child3;
        FqName child4 = fqName3.child(Name.identifier("ranges"));
        Intrinsics.checkNotNullExpressionValue(child4, "BUILT_INS_PACKAGE_FQ_NAM\u2026ame.identifier(\"ranges\"))");
        RANGES_PACKAGE_FQ_NAME = child4;
        FqName child5 = fqName3.child(Name.identifier("text"));
        Intrinsics.checkNotNullExpressionValue(child5, "BUILT_INS_PACKAGE_FQ_NAM\u2026(Name.identifier(\"text\"))");
        TEXT_PACKAGE_FQ_NAME = child5;
        FqName child6 = fqName3.child(Name.identifier("internal"));
        Intrinsics.checkNotNullExpressionValue(child6, "BUILT_INS_PACKAGE_FQ_NAM\u2026e.identifier(\"internal\"))");
        KOTLIN_INTERNAL_FQ_NAME = child6;
        of5 = SetsKt__SetsKt.setOf((Object[]) new FqName[]{fqName3, child3, child4, child2, fqName2, child6, fqName});
        BUILT_INS_PACKAGE_FQ_NAMES = of5;
    }

    StandardNames() {
    }

    @JvmStatic
    @NotNull
    public static final ClassId getFunctionClassId(int i3) {
        return new ClassId(BUILT_INS_PACKAGE_FQ_NAME, Name.identifier(getFunctionName(i3)));
    }

    @JvmStatic
    @NotNull
    public static final String getFunctionName(int i3) {
        return "Function" + i3;
    }

    @JvmStatic
    @NotNull
    public static final FqName getPrimitiveFqName(@NotNull PrimitiveType primitiveType) {
        Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
        FqName child = BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.getTypeName());
        Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAM\u2026d(primitiveType.typeName)");
        return child;
    }

    @JvmStatic
    @NotNull
    public static final String getSuspendFunctionName(int i3) {
        return FunctionClassKind.SuspendFunction.getClassNamePrefix() + i3;
    }

    @JvmStatic
    public static final boolean isPrimitiveArray(@NotNull FqNameUnsafe arrayFqName) {
        Intrinsics.checkNotNullParameter(arrayFqName, "arrayFqName");
        if (FqNames.arrayClassFqNameToPrimitiveType.get(arrayFqName) != null) {
            return true;
        }
        return false;
    }
}
