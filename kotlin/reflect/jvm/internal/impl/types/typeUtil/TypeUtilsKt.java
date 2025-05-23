package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.AbstractStubType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class TypeUtilsKt {
    @NotNull
    public static final TypeProjection asTypeProjection(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return new TypeProjectionImpl(kotlinType);
    }

    public static final boolean contains(@NotNull KotlinType kotlinType, @NotNull Function1<? super UnwrappedType, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return TypeUtils.contains(kotlinType, predicate);
    }

    private static final boolean containsSelfTypeParameter(KotlinType kotlinType, TypeConstructor typeConstructor, Set<? extends TypeParameterDescriptor> set) {
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters;
        List<TypeParameterDescriptor> list;
        Iterable<IndexedValue> withIndex;
        TypeParameterDescriptor typeParameterDescriptor;
        boolean z16;
        boolean z17;
        Object orNull;
        if (Intrinsics.areEqual(kotlinType.getConstructor(), typeConstructor)) {
            return true;
        }
        ClassifierDescriptor mo1779getDeclarationDescriptor = kotlinType.getConstructor().mo1779getDeclarationDescriptor();
        if (mo1779getDeclarationDescriptor instanceof ClassifierDescriptorWithTypeParameters) {
            classifierDescriptorWithTypeParameters = (ClassifierDescriptorWithTypeParameters) mo1779getDeclarationDescriptor;
        } else {
            classifierDescriptorWithTypeParameters = null;
        }
        if (classifierDescriptorWithTypeParameters != null) {
            list = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        } else {
            list = null;
        }
        withIndex = CollectionsKt___CollectionsKt.withIndex(kotlinType.getArguments());
        if (!(withIndex instanceof Collection) || !((Collection) withIndex).isEmpty()) {
            for (IndexedValue indexedValue : withIndex) {
                int index = indexedValue.getIndex();
                TypeProjection typeProjection = (TypeProjection) indexedValue.component2();
                if (list != null) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(list, index);
                    typeParameterDescriptor = (TypeParameterDescriptor) orNull;
                } else {
                    typeParameterDescriptor = null;
                }
                if (typeParameterDescriptor != null && set != null && set.contains(typeParameterDescriptor)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 && !typeProjection.isStarProjection()) {
                    KotlinType type = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "argument.type");
                    z17 = containsSelfTypeParameter(type, typeConstructor, set);
                } else {
                    z17 = false;
                }
                if (z17) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean containsTypeAliasParameters(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return contains(kotlinType, new Function1<UnwrappedType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$containsTypeAliasParameters$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull UnwrappedType it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ClassifierDescriptor mo1779getDeclarationDescriptor = it.getConstructor().mo1779getDeclarationDescriptor();
                return Boolean.valueOf(mo1779getDeclarationDescriptor != null ? TypeUtilsKt.isTypeAliasParameter(mo1779getDeclarationDescriptor) : false);
            }
        });
    }

    public static final boolean containsTypeParameter(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return TypeUtils.contains(kotlinType, new Function1<UnwrappedType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$containsTypeParameter$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(UnwrappedType unwrappedType) {
                return Boolean.valueOf(TypeUtils.isTypeParameter(unwrappedType));
            }
        });
    }

    @NotNull
    public static final TypeProjection createProjection(@NotNull KotlinType type, @NotNull Variance projectionKind, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        Variance variance;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(projectionKind, "projectionKind");
        if (typeParameterDescriptor != null) {
            variance = typeParameterDescriptor.getVariance();
        } else {
            variance = null;
        }
        if (variance == projectionKind) {
            projectionKind = Variance.INVARIANT;
        }
        return new TypeProjectionImpl(projectionKind, type);
    }

    @NotNull
    public static final Set<TypeParameterDescriptor> extractTypeParametersFromUpperBounds(@NotNull KotlinType kotlinType, @Nullable Set<? extends TypeParameterDescriptor> set) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        extractTypeParametersFromUpperBounds(kotlinType, kotlinType, linkedHashSet, set);
        return linkedHashSet;
    }

    @NotNull
    public static final KotlinBuiltIns getBuiltIns(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        KotlinBuiltIns builtIns = kotlinType.getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "constructor.builtIns");
        return builtIns;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
    
        r3 = r2;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final KotlinType getRepresentativeUpperBound(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        Object obj;
        Object first;
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "<this>");
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "upperBounds");
        upperBounds.isEmpty();
        List<KotlinType> upperBounds2 = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds2, "upperBounds");
        Iterator<T> it = upperBounds2.iterator();
        while (true) {
            obj = null;
            ClassDescriptor classDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ClassifierDescriptor mo1779getDeclarationDescriptor = ((KotlinType) next).getConstructor().mo1779getDeclarationDescriptor();
            if (mo1779getDeclarationDescriptor instanceof ClassDescriptor) {
                classDescriptor = (ClassDescriptor) mo1779getDeclarationDescriptor;
            }
            boolean z16 = false;
            if (classDescriptor != null && classDescriptor.getKind() != ClassKind.INTERFACE && classDescriptor.getKind() != ClassKind.ANNOTATION_CLASS) {
                z16 = true;
            }
        }
        KotlinType kotlinType = (KotlinType) obj;
        if (kotlinType == null) {
            List<KotlinType> upperBounds3 = typeParameterDescriptor.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds3, "upperBounds");
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) upperBounds3);
            Intrinsics.checkNotNullExpressionValue(first, "upperBounds.first()");
            return (KotlinType) first;
        }
        return kotlinType;
    }

    @JvmOverloads
    public static final boolean hasTypeParameterRecursiveBounds(@NotNull TypeParameterDescriptor typeParameter) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        return hasTypeParameterRecursiveBounds$default(typeParameter, null, null, 6, null);
    }

    public static /* synthetic */ boolean hasTypeParameterRecursiveBounds$default(TypeParameterDescriptor typeParameterDescriptor, TypeConstructor typeConstructor, Set set, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            typeConstructor = null;
        }
        if ((i3 & 4) != 0) {
            set = null;
        }
        return hasTypeParameterRecursiveBounds(typeParameterDescriptor, typeConstructor, set);
    }

    public static final boolean isStubType(@NotNull KotlinType kotlinType) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (kotlinType instanceof AbstractStubType) {
            return true;
        }
        if ((kotlinType instanceof DefinitelyNotNullType) && (((DefinitelyNotNullType) kotlinType).getOriginal() instanceof AbstractStubType)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }

    public static final boolean isStubTypeForBuilderInference(@NotNull KotlinType kotlinType) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (kotlinType instanceof StubTypeForBuilderInference) {
            return true;
        }
        if ((kotlinType instanceof DefinitelyNotNullType) && (((DefinitelyNotNullType) kotlinType).getOriginal() instanceof StubTypeForBuilderInference)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }

    public static final boolean isSubtypeOf(@NotNull KotlinType kotlinType, @NotNull KotlinType superType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(kotlinType, superType);
    }

    public static final boolean isTypeAliasParameter(@NotNull ClassifierDescriptor classifierDescriptor) {
        Intrinsics.checkNotNullParameter(classifierDescriptor, "<this>");
        if ((classifierDescriptor instanceof TypeParameterDescriptor) && (((TypeParameterDescriptor) classifierDescriptor).getContainingDeclaration() instanceof TypeAliasDescriptor)) {
            return true;
        }
        return false;
    }

    public static final boolean isTypeParameter(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return TypeUtils.isTypeParameter(kotlinType);
    }

    public static final boolean isUnresolvedType(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if ((type instanceof ErrorType) && ((ErrorType) type).getKind().isUnresolved()) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final KotlinType makeNotNullable(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(this)");
        return makeNotNullable;
    }

    @NotNull
    public static final KotlinType makeNullable(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        KotlinType makeNullable = TypeUtils.makeNullable(kotlinType);
        Intrinsics.checkNotNullExpressionValue(makeNullable, "makeNullable(this)");
        return makeNullable;
    }

    @NotNull
    public static final KotlinType replaceAnnotations(@NotNull KotlinType kotlinType, @NotNull Annotations newAnnotations) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        if (kotlinType.getAnnotations().isEmpty() && newAnnotations.isEmpty()) {
            return kotlinType;
        }
        return kotlinType.unwrap().replaceAttributes(TypeAttributesKt.replaceAnnotations(kotlinType.getAttributes(), newAnnotations));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [kotlin.reflect.jvm.internal.impl.types.UnwrappedType] */
    @NotNull
    public static final KotlinType replaceArgumentsWithStarProjections(@NotNull KotlinType kotlinType) {
        int collectionSizeOrDefault;
        SimpleType simpleType;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrap;
            SimpleType lowerBound = flexibleType.getLowerBound();
            if (!lowerBound.getConstructor().getParameters().isEmpty() && lowerBound.getConstructor().mo1779getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters = lowerBound.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "constructor.parameters");
                List<TypeParameterDescriptor> list = parameters;
                collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault3);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new StarProjectionImpl((TypeParameterDescriptor) it.next()));
                }
                lowerBound = TypeSubstitutionKt.replace$default(lowerBound, arrayList, null, 2, null);
            }
            SimpleType upperBound = flexibleType.getUpperBound();
            if (!upperBound.getConstructor().getParameters().isEmpty() && upperBound.getConstructor().mo1779getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters2 = upperBound.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters2, "constructor.parameters");
                List<TypeParameterDescriptor> list2 = parameters2;
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                Iterator it5 = list2.iterator();
                while (it5.hasNext()) {
                    arrayList2.add(new StarProjectionImpl((TypeParameterDescriptor) it5.next()));
                }
                upperBound = TypeSubstitutionKt.replace$default(upperBound, arrayList2, null, 2, null);
            }
            simpleType = KotlinTypeFactory.flexibleType(lowerBound, upperBound);
        } else if (unwrap instanceof SimpleType) {
            SimpleType simpleType2 = (SimpleType) unwrap;
            boolean isEmpty = simpleType2.getConstructor().getParameters().isEmpty();
            simpleType = simpleType2;
            if (!isEmpty) {
                ClassifierDescriptor mo1779getDeclarationDescriptor = simpleType2.getConstructor().mo1779getDeclarationDescriptor();
                simpleType = simpleType2;
                if (mo1779getDeclarationDescriptor != null) {
                    List<TypeParameterDescriptor> parameters3 = simpleType2.getConstructor().getParameters();
                    Intrinsics.checkNotNullExpressionValue(parameters3, "constructor.parameters");
                    List<TypeParameterDescriptor> list3 = parameters3;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                    ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                    Iterator it6 = list3.iterator();
                    while (it6.hasNext()) {
                        arrayList3.add(new StarProjectionImpl((TypeParameterDescriptor) it6.next()));
                    }
                    simpleType = TypeSubstitutionKt.replace$default(simpleType2, arrayList3, null, 2, null);
                }
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(simpleType, unwrap);
    }

    public static final boolean requiresTypeAliasExpansion(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return contains(kotlinType, new Function1<UnwrappedType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$requiresTypeAliasExpansion$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull UnwrappedType it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ClassifierDescriptor mo1779getDeclarationDescriptor = it.getConstructor().mo1779getDeclarationDescriptor();
                boolean z16 = false;
                if (mo1779getDeclarationDescriptor != null && ((mo1779getDeclarationDescriptor instanceof TypeAliasDescriptor) || (mo1779getDeclarationDescriptor instanceof TypeParameterDescriptor))) {
                    z16 = true;
                }
                return Boolean.valueOf(z16);
            }
        });
    }

    public static final boolean shouldBeUpdated(@Nullable KotlinType kotlinType) {
        if (kotlinType != null && !contains(kotlinType, new Function1<UnwrappedType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$shouldBeUpdated$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull UnwrappedType it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf((it instanceof StubTypeForBuilderInference) || (it.getConstructor() instanceof TypeVariableTypeConstructorMarker) || KotlinTypeKt.isError(it));
            }
        })) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void extractTypeParametersFromUpperBounds(KotlinType kotlinType, KotlinType kotlinType2, Set<TypeParameterDescriptor> set, Set<? extends TypeParameterDescriptor> set2) {
        TypeParameterDescriptor typeParameterDescriptor;
        boolean contains;
        Object orNull;
        ClassifierDescriptor mo1779getDeclarationDescriptor = kotlinType.getConstructor().mo1779getDeclarationDescriptor();
        if (mo1779getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            if (!Intrinsics.areEqual(kotlinType.getConstructor(), kotlinType2.getConstructor())) {
                set.add(mo1779getDeclarationDescriptor);
                return;
            }
            for (KotlinType upperBound : ((TypeParameterDescriptor) mo1779getDeclarationDescriptor).getUpperBounds()) {
                Intrinsics.checkNotNullExpressionValue(upperBound, "upperBound");
                extractTypeParametersFromUpperBounds(upperBound, kotlinType2, set, set2);
            }
            return;
        }
        ClassifierDescriptor mo1779getDeclarationDescriptor2 = kotlinType.getConstructor().mo1779getDeclarationDescriptor();
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = mo1779getDeclarationDescriptor2 instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) mo1779getDeclarationDescriptor2 : null;
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters != null ? classifierDescriptorWithTypeParameters.getDeclaredTypeParameters() : null;
        int i3 = 0;
        for (TypeProjection typeProjection : kotlinType.getArguments()) {
            int i16 = i3 + 1;
            if (declaredTypeParameters != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(declaredTypeParameters, i3);
                typeParameterDescriptor = (TypeParameterDescriptor) orNull;
            } else {
                typeParameterDescriptor = null;
            }
            if (!((typeParameterDescriptor == null || set2 == null || !set2.contains(typeParameterDescriptor)) ? false : true) && !typeProjection.isStarProjection()) {
                contains = CollectionsKt___CollectionsKt.contains(set, typeProjection.getType().getConstructor().mo1779getDeclarationDescriptor());
                if (!contains && !Intrinsics.areEqual(typeProjection.getType().getConstructor(), kotlinType2.getConstructor())) {
                    KotlinType type = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "argument.type");
                    extractTypeParametersFromUpperBounds(type, kotlinType2, set, set2);
                }
            }
            i3 = i16;
        }
    }

    @JvmOverloads
    public static final boolean hasTypeParameterRecursiveBounds(@NotNull TypeParameterDescriptor typeParameter, @Nullable TypeConstructor typeConstructor, @Nullable Set<? extends TypeParameterDescriptor> set) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        List<KotlinType> upperBounds = typeParameter.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
        List<KotlinType> list = upperBounds;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (KotlinType upperBound : list) {
            Intrinsics.checkNotNullExpressionValue(upperBound, "upperBound");
            if (containsSelfTypeParameter(upperBound, typeParameter.getDefaultType().getConstructor(), set) && (typeConstructor == null || Intrinsics.areEqual(upperBound.getConstructor(), typeConstructor))) {
                return true;
            }
        }
        return false;
    }
}
