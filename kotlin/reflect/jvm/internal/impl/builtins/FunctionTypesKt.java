package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FunctionTypesKt {
    public static final int contextFunctionTypeParamsCount(@NotNull KotlinType kotlinType) {
        Object value;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        AnnotationDescriptor mo1774findAnnotation = kotlinType.getAnnotations().mo1774findAnnotation(StandardNames.FqNames.contextFunctionTypeParams);
        if (mo1774findAnnotation != null) {
            value = MapsKt__MapsKt.getValue(mo1774findAnnotation.getAllValueArguments(), StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME);
            ConstantValue constantValue = (ConstantValue) value;
            Intrinsics.checkNotNull(constantValue, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
            return ((IntValue) constantValue).getValue().intValue();
        }
        return 0;
    }

    @JvmOverloads
    @NotNull
    public static final SimpleType createFunctionType(@NotNull KotlinBuiltIns builtIns, @NotNull Annotations annotations, @Nullable KotlinType kotlinType, @NotNull List<? extends KotlinType> contextReceiverTypes, @NotNull List<? extends KotlinType> parameterTypes, @Nullable List<Name> list, @NotNull KotlinType returnType, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(contextReceiverTypes, "contextReceiverTypes");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        List<TypeProjection> functionTypeArgumentProjections = getFunctionTypeArgumentProjections(kotlinType, contextReceiverTypes, parameterTypes, list, returnType, builtIns);
        int size = parameterTypes.size() + contextReceiverTypes.size();
        if (kotlinType == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        ClassDescriptor functionDescriptor = getFunctionDescriptor(builtIns, size + i3, z16);
        if (kotlinType != null) {
            annotations = withExtensionFunctionAnnotation(annotations, builtIns);
        }
        if (!contextReceiverTypes.isEmpty()) {
            annotations = withContextReceiversFunctionAnnotation(annotations, builtIns, contextReceiverTypes.size());
        }
        return KotlinTypeFactory.simpleNotNullType(TypeAttributesKt.toDefaultAttributes(annotations), functionDescriptor, functionTypeArgumentProjections);
    }

    public static /* synthetic */ SimpleType createFunctionType$default(KotlinBuiltIns kotlinBuiltIns, Annotations annotations, KotlinType kotlinType, List list, List list2, List list3, KotlinType kotlinType2, boolean z16, int i3, Object obj) {
        boolean z17;
        if ((i3 & 128) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        return createFunctionType(kotlinBuiltIns, annotations, kotlinType, list, list2, list3, kotlinType2, z17);
    }

    @Nullable
    public static final Name extractParameterNameFromFunctionTypeArgument(@NotNull KotlinType kotlinType) {
        Object singleOrNull;
        StringValue stringValue;
        String value;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        AnnotationDescriptor mo1774findAnnotation = kotlinType.getAnnotations().mo1774findAnnotation(StandardNames.FqNames.parameterName);
        if (mo1774findAnnotation != null) {
            singleOrNull = CollectionsKt___CollectionsKt.singleOrNull(mo1774findAnnotation.getAllValueArguments().values());
            if (singleOrNull instanceof StringValue) {
                stringValue = (StringValue) singleOrNull;
            } else {
                stringValue = null;
            }
            if (stringValue != null && (value = stringValue.getValue()) != null) {
                if (!Name.isValidIdentifier(value)) {
                    value = null;
                }
                if (value != null) {
                    return Name.identifier(value);
                }
            }
            return null;
        }
        return null;
    }

    @NotNull
    public static final List<KotlinType> getContextReceiverTypesFromFunctionType(@NotNull KotlinType kotlinType) {
        int collectionSizeOrDefault;
        List<KotlinType> emptyList;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        int contextFunctionTypeParamsCount = contextFunctionTypeParamsCount(kotlinType);
        if (contextFunctionTypeParamsCount == 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<TypeProjection> subList = kotlinType.getArguments().subList(0, contextFunctionTypeParamsCount);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(subList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = subList.iterator();
        while (it.hasNext()) {
            KotlinType type = ((TypeProjection) it.next()).getType();
            Intrinsics.checkNotNullExpressionValue(type, "it.type");
            arrayList.add(type);
        }
        return arrayList;
    }

    @NotNull
    public static final ClassDescriptor getFunctionDescriptor(@NotNull KotlinBuiltIns builtIns, int i3, boolean z16) {
        ClassDescriptor function;
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        if (z16) {
            function = builtIns.getSuspendFunction(i3);
        } else {
            function = builtIns.getFunction(i3);
        }
        Intrinsics.checkNotNullExpressionValue(function, "if (isSuspendFunction) b\u2026tFunction(parameterCount)");
        return function;
    }

    @NotNull
    public static final List<TypeProjection> getFunctionTypeArgumentProjections(@Nullable KotlinType kotlinType, @NotNull List<? extends KotlinType> contextReceiverTypes, @NotNull List<? extends KotlinType> parameterTypes, @Nullable List<Name> list, @NotNull KotlinType returnType, @NotNull KotlinBuiltIns builtIns) {
        int i3;
        int collectionSizeOrDefault;
        TypeProjection typeProjection;
        Name name;
        Map mapOf;
        List<? extends AnnotationDescriptor> plus;
        Intrinsics.checkNotNullParameter(contextReceiverTypes, "contextReceiverTypes");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        int size = parameterTypes.size() + contextReceiverTypes.size();
        int i16 = 0;
        if (kotlinType != null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        ArrayList arrayList = new ArrayList(size + i3 + 1);
        List<? extends KotlinType> list2 = contextReceiverTypes;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(TypeUtilsKt.asTypeProjection((KotlinType) it.next()));
        }
        arrayList.addAll(arrayList2);
        if (kotlinType != null) {
            typeProjection = TypeUtilsKt.asTypeProjection(kotlinType);
        } else {
            typeProjection = null;
        }
        CollectionsKt.addIfNotNull(arrayList, typeProjection);
        for (Object obj : parameterTypes) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            KotlinType kotlinType2 = (KotlinType) obj;
            if (list == null || (name = list.get(i16)) == null || name.isSpecial()) {
                name = null;
            }
            if (name != null) {
                FqName fqName = StandardNames.FqNames.parameterName;
                Name identifier = Name.identifier("name");
                String asString = name.asString();
                Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(identifier, new StringValue(asString)));
                BuiltInAnnotationDescriptor builtInAnnotationDescriptor = new BuiltInAnnotationDescriptor(builtIns, fqName, mapOf);
                Annotations.Companion companion = Annotations.Companion;
                plus = CollectionsKt___CollectionsKt.plus((Iterable<? extends BuiltInAnnotationDescriptor>) ((Iterable<? extends Object>) kotlinType2.getAnnotations()), builtInAnnotationDescriptor);
                kotlinType2 = TypeUtilsKt.replaceAnnotations(kotlinType2, companion.create(plus));
            }
            arrayList.add(TypeUtilsKt.asTypeProjection(kotlinType2));
            i16 = i17;
        }
        arrayList.add(TypeUtilsKt.asTypeProjection(returnType));
        return arrayList;
    }

    @Nullable
    public static final FunctionClassKind getFunctionalClassKind(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        if ((declarationDescriptor instanceof ClassDescriptor) && KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor)) {
            return getFunctionalClassKind(DescriptorUtilsKt.getFqNameUnsafe(declarationDescriptor));
        }
        return null;
    }

    @Nullable
    public static final KotlinType getReceiverTypeFromFunctionType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        if (!isTypeAnnotatedWithExtensionFunctionType(kotlinType)) {
            return null;
        }
        return kotlinType.getArguments().get(contextFunctionTypeParamsCount(kotlinType)).getType();
    }

    @NotNull
    public static final KotlinType getReturnTypeFromFunctionType(@NotNull KotlinType kotlinType) {
        Object last;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) kotlinType.getArguments());
        KotlinType type = ((TypeProjection) last).getType();
        Intrinsics.checkNotNullExpressionValue(type, "arguments.last().type");
        return type;
    }

    @NotNull
    public static final List<TypeProjection> getValueParameterTypesFromFunctionType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        return kotlinType.getArguments().subList(contextFunctionTypeParamsCount(kotlinType) + (isBuiltinExtensionFunctionalType(kotlinType) ? 1 : 0), r0.size() - 1);
    }

    public static final boolean isBuiltinExtensionFunctionalType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (isBuiltinFunctionalType(kotlinType) && isTypeAnnotatedWithExtensionFunctionType(kotlinType)) {
            return true;
        }
        return false;
    }

    public static final boolean isBuiltinFunctionalClassDescriptor(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        FunctionClassKind functionalClassKind = getFunctionalClassKind(declarationDescriptor);
        if (functionalClassKind != FunctionClassKind.Function && functionalClassKind != FunctionClassKind.SuspendFunction) {
            return false;
        }
        return true;
    }

    public static final boolean isBuiltinFunctionalType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor mo1779getDeclarationDescriptor = kotlinType.getConstructor().mo1779getDeclarationDescriptor();
        if (mo1779getDeclarationDescriptor == null || !isBuiltinFunctionalClassDescriptor(mo1779getDeclarationDescriptor)) {
            return false;
        }
        return true;
    }

    public static final boolean isFunctionType(@NotNull KotlinType kotlinType) {
        FunctionClassKind functionClassKind;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor mo1779getDeclarationDescriptor = kotlinType.getConstructor().mo1779getDeclarationDescriptor();
        if (mo1779getDeclarationDescriptor != null) {
            functionClassKind = getFunctionalClassKind(mo1779getDeclarationDescriptor);
        } else {
            functionClassKind = null;
        }
        if (functionClassKind == FunctionClassKind.Function) {
            return true;
        }
        return false;
    }

    public static final boolean isSuspendFunctionType(@NotNull KotlinType kotlinType) {
        FunctionClassKind functionClassKind;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor mo1779getDeclarationDescriptor = kotlinType.getConstructor().mo1779getDeclarationDescriptor();
        if (mo1779getDeclarationDescriptor != null) {
            functionClassKind = getFunctionalClassKind(mo1779getDeclarationDescriptor);
        } else {
            functionClassKind = null;
        }
        if (functionClassKind == FunctionClassKind.SuspendFunction) {
            return true;
        }
        return false;
    }

    private static final boolean isTypeAnnotatedWithExtensionFunctionType(KotlinType kotlinType) {
        if (kotlinType.getAnnotations().mo1774findAnnotation(StandardNames.FqNames.extensionFunctionType) != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final Annotations withContextReceiversFunctionAnnotation(@NotNull Annotations annotations, @NotNull KotlinBuiltIns builtIns, int i3) {
        Map mapOf;
        List<? extends AnnotationDescriptor> plus;
        Intrinsics.checkNotNullParameter(annotations, "<this>");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        FqName fqName = StandardNames.FqNames.contextFunctionTypeParams;
        if (!annotations.hasAnnotation(fqName)) {
            Annotations.Companion companion = Annotations.Companion;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME, new IntValue(i3)));
            plus = CollectionsKt___CollectionsKt.plus((Iterable<? extends BuiltInAnnotationDescriptor>) ((Iterable<? extends Object>) annotations), new BuiltInAnnotationDescriptor(builtIns, fqName, mapOf));
            return companion.create(plus);
        }
        return annotations;
    }

    @NotNull
    public static final Annotations withExtensionFunctionAnnotation(@NotNull Annotations annotations, @NotNull KotlinBuiltIns builtIns) {
        Map emptyMap;
        List<? extends AnnotationDescriptor> plus;
        Intrinsics.checkNotNullParameter(annotations, "<this>");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        FqName fqName = StandardNames.FqNames.extensionFunctionType;
        if (!annotations.hasAnnotation(fqName)) {
            Annotations.Companion companion = Annotations.Companion;
            emptyMap = MapsKt__MapsKt.emptyMap();
            plus = CollectionsKt___CollectionsKt.plus((Iterable<? extends BuiltInAnnotationDescriptor>) ((Iterable<? extends Object>) annotations), new BuiltInAnnotationDescriptor(builtIns, fqName, emptyMap));
            return companion.create(plus);
        }
        return annotations;
    }

    private static final FunctionClassKind getFunctionalClassKind(FqNameUnsafe fqNameUnsafe) {
        if (!fqNameUnsafe.isSafe() || fqNameUnsafe.isRoot()) {
            return null;
        }
        FunctionClassKind.Companion companion = FunctionClassKind.Companion;
        String asString = fqNameUnsafe.shortName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "shortName().asString()");
        FqName parent = fqNameUnsafe.toSafe().parent();
        Intrinsics.checkNotNullExpressionValue(parent, "toSafe().parent()");
        return companion.getFunctionalClassKind(asString, parent);
    }
}
