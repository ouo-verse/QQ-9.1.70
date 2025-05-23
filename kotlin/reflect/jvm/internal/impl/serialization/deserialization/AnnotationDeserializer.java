package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class AnnotationDeserializer {

    @NotNull
    private final ModuleDescriptor module;

    @NotNull
    private final NotFoundClasses notFoundClasses;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AnnotationDeserializer(@NotNull ModuleDescriptor module, @NotNull NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        this.module = module;
        this.notFoundClasses = notFoundClasses;
    }

    private final boolean doesValueConformToExpectedType(ConstantValue<?> constantValue, KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value) {
        int i3;
        ClassDescriptor classDescriptor;
        boolean z16;
        Iterable indices;
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        if (type == null) {
            i3 = -1;
        } else {
            i3 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        if (i3 != 10) {
            if (i3 != 13) {
                return Intrinsics.areEqual(constantValue.getType(this.module), kotlinType);
            }
            if ((constantValue instanceof ArrayValue) && ((ArrayValue) constantValue).getValue().size() == value.getArrayElementList().size()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                KotlinType arrayElementType = getBuiltIns().getArrayElementType(kotlinType);
                Intrinsics.checkNotNullExpressionValue(arrayElementType, "builtIns.getArrayElementType(expectedType)");
                ArrayValue arrayValue = (ArrayValue) constantValue;
                indices = CollectionsKt__CollectionsKt.getIndices(arrayValue.getValue());
                if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
                    Iterator it = indices.iterator();
                    while (it.hasNext()) {
                        int nextInt = ((IntIterator) it).nextInt();
                        ConstantValue<?> constantValue2 = arrayValue.getValue().get(nextInt);
                        ProtoBuf.Annotation.Argument.Value arrayElement = value.getArrayElement(nextInt);
                        Intrinsics.checkNotNullExpressionValue(arrayElement, "value.getArrayElement(i)");
                        if (!doesValueConformToExpectedType(constantValue2, arrayElementType, arrayElement)) {
                            return false;
                        }
                    }
                }
            } else {
                throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + constantValue).toString());
            }
        } else {
            ClassifierDescriptor mo1779getDeclarationDescriptor = kotlinType.getConstructor().mo1779getDeclarationDescriptor();
            if (mo1779getDeclarationDescriptor instanceof ClassDescriptor) {
                classDescriptor = (ClassDescriptor) mo1779getDeclarationDescriptor;
            } else {
                classDescriptor = null;
            }
            if (classDescriptor != null && !KotlinBuiltIns.isKClass(classDescriptor)) {
                return false;
            }
        }
        return true;
    }

    private final KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    private final Pair<Name, ConstantValue<?>> resolveArgument(ProtoBuf.Annotation.Argument argument, Map<Name, ? extends ValueParameterDescriptor> map, NameResolver nameResolver) {
        ValueParameterDescriptor valueParameterDescriptor = map.get(NameResolverUtilKt.getName(nameResolver, argument.getNameId()));
        if (valueParameterDescriptor == null) {
            return null;
        }
        Name name = NameResolverUtilKt.getName(nameResolver, argument.getNameId());
        KotlinType type = valueParameterDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "parameter.type");
        ProtoBuf.Annotation.Argument.Value value = argument.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "proto.value");
        return new Pair<>(name, resolveValueAndCheckExpectedType(type, value, nameResolver));
    }

    private final ClassDescriptor resolveClass(ClassId classId) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
    }

    private final ConstantValue<?> resolveValueAndCheckExpectedType(KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value, NameResolver nameResolver) {
        ConstantValue<?> resolveValue = resolveValue(kotlinType, value, nameResolver);
        if (!doesValueConformToExpectedType(resolveValue, kotlinType, value)) {
            resolveValue = null;
        }
        if (resolveValue == null) {
            return ErrorValue.Companion.create("Unexpected argument value: actual type " + value.getType() + " != expected type " + kotlinType);
        }
        return resolveValue;
    }

    @NotNull
    public final AnnotationDescriptor deserializeAnnotation(@NotNull ProtoBuf.Annotation proto, @NotNull NameResolver nameResolver) {
        Map emptyMap;
        Object singleOrNull;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        ClassDescriptor resolveClass = resolveClass(NameResolverUtilKt.getClassId(nameResolver, proto.getId()));
        emptyMap = MapsKt__MapsKt.emptyMap();
        if (proto.getArgumentCount() != 0 && !ErrorUtils.isError(resolveClass) && DescriptorUtils.isAnnotationClass(resolveClass)) {
            Collection<ClassConstructorDescriptor> constructors = resolveClass.getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "annotationClass.constructors");
            singleOrNull = CollectionsKt___CollectionsKt.singleOrNull(constructors);
            ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) singleOrNull;
            if (classConstructorDescriptor != null) {
                List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "constructor.valueParameters");
                List<ValueParameterDescriptor> list = valueParameters;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (Object obj : list) {
                    linkedHashMap.put(((ValueParameterDescriptor) obj).getName(), obj);
                }
                List<ProtoBuf.Annotation.Argument> argumentList = proto.getArgumentList();
                Intrinsics.checkNotNullExpressionValue(argumentList, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (ProtoBuf.Annotation.Argument it : argumentList) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Pair<Name, ConstantValue<?>> resolveArgument = resolveArgument(it, linkedHashMap, nameResolver);
                    if (resolveArgument != null) {
                        arrayList.add(resolveArgument);
                    }
                }
                emptyMap = MapsKt__MapsKt.toMap(arrayList);
            }
        }
        return new AnnotationDescriptorImpl(resolveClass.getDefaultType(), emptyMap, SourceElement.NO_SOURCE);
    }

    @NotNull
    public final ConstantValue<?> resolveValue(@NotNull KotlinType expectedType, @NotNull ProtoBuf.Annotation.Argument.Value value, @NotNull NameResolver nameResolver) {
        int i3;
        ConstantValue<?> charValue;
        ConstantValue<?> longValue;
        boolean z16;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Boolean bool = Flags.IS_UNSIGNED.get(value.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_UNSIGNED.get(value.flags)");
        boolean booleanValue = bool.booleanValue();
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        if (type == null) {
            i3 = -1;
        } else {
            i3 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        switch (i3) {
            case 1:
                byte intValue = (byte) value.getIntValue();
                if (booleanValue) {
                    return new UByteValue(intValue);
                }
                return new ByteValue(intValue);
            case 2:
                charValue = new CharValue((char) value.getIntValue());
                break;
            case 3:
                short intValue2 = (short) value.getIntValue();
                if (booleanValue) {
                    return new UShortValue(intValue2);
                }
                return new ShortValue(intValue2);
            case 4:
                int intValue3 = (int) value.getIntValue();
                if (booleanValue) {
                    return new UIntValue(intValue3);
                }
                return new IntValue(intValue3);
            case 5:
                long intValue4 = value.getIntValue();
                if (booleanValue) {
                    longValue = new ULongValue(intValue4);
                } else {
                    longValue = new LongValue(intValue4);
                }
                return longValue;
            case 6:
                charValue = new FloatValue(value.getFloatValue());
                break;
            case 7:
                charValue = new DoubleValue(value.getDoubleValue());
                break;
            case 8:
                if (value.getIntValue() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                charValue = new BooleanValue(z16);
                break;
            case 9:
                charValue = new StringValue(nameResolver.getString(value.getStringValue()));
                break;
            case 10:
                charValue = new KClassValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), value.getArrayDimensionCount());
                break;
            case 11:
                charValue = new EnumValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), NameResolverUtilKt.getName(nameResolver, value.getEnumValueId()));
                break;
            case 12:
                ProtoBuf.Annotation annotation = value.getAnnotation();
                Intrinsics.checkNotNullExpressionValue(annotation, "value.annotation");
                charValue = new AnnotationValue(deserializeAnnotation(annotation, nameResolver));
                break;
            case 13:
                List<ProtoBuf.Annotation.Argument.Value> arrayElementList = value.getArrayElementList();
                Intrinsics.checkNotNullExpressionValue(arrayElementList, "value.arrayElementList");
                List<ProtoBuf.Annotation.Argument.Value> list = arrayElementList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (ProtoBuf.Annotation.Argument.Value it : list) {
                    SimpleType anyType = getBuiltIns().getAnyType();
                    Intrinsics.checkNotNullExpressionValue(anyType, "builtIns.anyType");
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList.add(resolveValue(anyType, it, nameResolver));
                }
                return new DeserializedArrayValue(arrayList, expectedType);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + value.getType() + " (expected " + expectedType + ')').toString());
        }
        return charValue;
    }
}
