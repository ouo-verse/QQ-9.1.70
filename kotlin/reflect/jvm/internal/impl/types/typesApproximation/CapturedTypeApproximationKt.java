package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CapturedTypeApproximationKt {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final ApproximationBounds<KotlinType> approximateCapturedTypes(@NotNull KotlinType type) {
        List<Pair> zip;
        Object replaceTypeArguments;
        Intrinsics.checkNotNullParameter(type, "type");
        if (FlexibleTypesKt.isFlexible(type)) {
            ApproximationBounds<KotlinType> approximateCapturedTypes = approximateCapturedTypes(FlexibleTypesKt.lowerIfFlexible(type));
            ApproximationBounds<KotlinType> approximateCapturedTypes2 = approximateCapturedTypes(FlexibleTypesKt.upperIfFlexible(type));
            return new ApproximationBounds<>(TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(approximateCapturedTypes.getLower()), FlexibleTypesKt.upperIfFlexible(approximateCapturedTypes2.getLower())), type), TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(approximateCapturedTypes.getUpper()), FlexibleTypesKt.upperIfFlexible(approximateCapturedTypes2.getUpper())), type));
        }
        TypeConstructor constructor = type.getConstructor();
        if (CapturedTypeConstructorKt.isCaptured(type)) {
            Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
            TypeProjection projection = ((CapturedTypeConstructor) constructor).getProjection();
            KotlinType type2 = projection.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "typeProjection.type");
            KotlinType approximateCapturedTypes$makeNullableIfNeeded = approximateCapturedTypes$makeNullableIfNeeded(type2, type);
            int i3 = WhenMappings.$EnumSwitchMapping$0[projection.getProjectionKind().ordinal()];
            if (i3 != 2) {
                if (i3 == 3) {
                    SimpleType nothingType = TypeUtilsKt.getBuiltIns(type).getNothingType();
                    Intrinsics.checkNotNullExpressionValue(nothingType, "type.builtIns.nothingType");
                    return new ApproximationBounds<>(approximateCapturedTypes$makeNullableIfNeeded(nothingType, type), approximateCapturedTypes$makeNullableIfNeeded);
                }
                throw new AssertionError("Only nontrivial projections should have been captured, not: " + projection);
            }
            SimpleType nullableAnyType = TypeUtilsKt.getBuiltIns(type).getNullableAnyType();
            Intrinsics.checkNotNullExpressionValue(nullableAnyType, "type.builtIns.nullableAnyType");
            return new ApproximationBounds<>(approximateCapturedTypes$makeNullableIfNeeded, nullableAnyType);
        }
        if (!type.getArguments().isEmpty() && type.getArguments().size() == constructor.getParameters().size()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<TypeProjection> arguments = type.getArguments();
            List<TypeParameterDescriptor> parameters = constructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
            zip = CollectionsKt___CollectionsKt.zip(arguments, parameters);
            for (Pair pair : zip) {
                TypeProjection typeProjection = (TypeProjection) pair.component1();
                TypeParameterDescriptor typeParameter = (TypeParameterDescriptor) pair.component2();
                Intrinsics.checkNotNullExpressionValue(typeParameter, "typeParameter");
                TypeArgument typeArgument = toTypeArgument(typeProjection, typeParameter);
                if (typeProjection.isStarProjection()) {
                    arrayList.add(typeArgument);
                    arrayList2.add(typeArgument);
                } else {
                    ApproximationBounds<TypeArgument> approximateProjection = approximateProjection(typeArgument);
                    TypeArgument component1 = approximateProjection.component1();
                    TypeArgument component2 = approximateProjection.component2();
                    arrayList.add(component1);
                    arrayList2.add(component2);
                }
            }
            boolean z16 = false;
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (!((TypeArgument) it.next()).isConsistent()) {
                        z16 = true;
                        break;
                    }
                }
            }
            if (z16) {
                replaceTypeArguments = TypeUtilsKt.getBuiltIns(type).getNothingType();
                Intrinsics.checkNotNullExpressionValue(replaceTypeArguments, "type.builtIns.nothingType");
            } else {
                replaceTypeArguments = replaceTypeArguments(type, arrayList);
            }
            return new ApproximationBounds<>(replaceTypeArguments, replaceTypeArguments(type, arrayList2));
        }
        return new ApproximationBounds<>(type, type);
    }

    private static final KotlinType approximateCapturedTypes$makeNullableIfNeeded(KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(kotlinType, kotlinType2.isMarkedNullable());
        Intrinsics.checkNotNullExpressionValue(makeNullableIfNeeded, "makeNullableIfNeeded(this, type.isMarkedNullable)");
        return makeNullableIfNeeded;
    }

    @Nullable
    public static final TypeProjection approximateCapturedTypesIfNecessary(@Nullable TypeProjection typeProjection, boolean z16) {
        if (typeProjection == null) {
            return null;
        }
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        KotlinType type = typeProjection.getType();
        Intrinsics.checkNotNullExpressionValue(type, "typeProjection.type");
        if (!TypeUtils.contains(type, new Function1<UnwrappedType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(UnwrappedType it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                return Boolean.valueOf(CapturedTypeConstructorKt.isCaptured(it));
            }
        })) {
            return typeProjection;
        }
        Variance projectionKind = typeProjection.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(projectionKind, "typeProjection.projectionKind");
        if (projectionKind == Variance.OUT_VARIANCE) {
            return new TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getUpper());
        }
        if (z16) {
            return new TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getLower());
        }
        return substituteCapturedTypesWithProjections(typeProjection);
    }

    private static final ApproximationBounds<TypeArgument> approximateProjection(TypeArgument typeArgument) {
        ApproximationBounds<KotlinType> approximateCapturedTypes = approximateCapturedTypes(typeArgument.getInProjection());
        KotlinType component1 = approximateCapturedTypes.component1();
        KotlinType component2 = approximateCapturedTypes.component2();
        ApproximationBounds<KotlinType> approximateCapturedTypes2 = approximateCapturedTypes(typeArgument.getOutProjection());
        return new ApproximationBounds<>(new TypeArgument(typeArgument.getTypeParameter(), component2, approximateCapturedTypes2.component1()), new TypeArgument(typeArgument.getTypeParameter(), component1, approximateCapturedTypes2.component2()));
    }

    private static final KotlinType replaceTypeArguments(KotlinType kotlinType, List<TypeArgument> list) {
        int collectionSizeOrDefault;
        kotlinType.getArguments().size();
        list.size();
        List<TypeArgument> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toTypeProjection((TypeArgument) it.next()));
        }
        return TypeSubstitutionKt.replace$default(kotlinType, arrayList, null, null, 6, null);
    }

    private static final TypeProjection substituteCapturedTypesWithProjections(TypeProjection typeProjection) {
        TypeSubstitutor create = TypeSubstitutor.create(new TypeConstructorSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
            @Nullable
            public TypeProjection get(@NotNull TypeConstructor key) {
                CapturedTypeConstructor capturedTypeConstructor;
                Intrinsics.checkNotNullParameter(key, "key");
                if (key instanceof CapturedTypeConstructor) {
                    capturedTypeConstructor = (CapturedTypeConstructor) key;
                } else {
                    capturedTypeConstructor = null;
                }
                if (capturedTypeConstructor == null) {
                    return null;
                }
                if (capturedTypeConstructor.getProjection().isStarProjection()) {
                    return new TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.getProjection().getType());
                }
                return capturedTypeConstructor.getProjection();
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "create(object : TypeCons\u2026ojection\n        }\n    })");
        return create.substituteWithoutApproximation(typeProjection);
    }

    private static final TypeArgument toTypeArgument(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        int i3 = WhenMappings.$EnumSwitchMapping$0[TypeSubstitutor.combine(typeParameterDescriptor.getVariance(), typeProjection).ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    SimpleType nothingType = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNothingType();
                    Intrinsics.checkNotNullExpressionValue(nothingType, "typeParameter.builtIns.nothingType");
                    KotlinType type = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "type");
                    return new TypeArgument(typeParameterDescriptor, nothingType, type);
                }
                throw new NoWhenBranchMatchedException();
            }
            KotlinType type2 = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "type");
            SimpleType nullableAnyType = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNullableAnyType();
            Intrinsics.checkNotNullExpressionValue(nullableAnyType, "typeParameter.builtIns.nullableAnyType");
            return new TypeArgument(typeParameterDescriptor, type2, nullableAnyType);
        }
        KotlinType type3 = typeProjection.getType();
        Intrinsics.checkNotNullExpressionValue(type3, "type");
        KotlinType type4 = typeProjection.getType();
        Intrinsics.checkNotNullExpressionValue(type4, "type");
        return new TypeArgument(typeParameterDescriptor, type3, type4);
    }

    private static final TypeProjection toTypeProjection(TypeArgument typeArgument) {
        typeArgument.isConsistent();
        if (!Intrinsics.areEqual(typeArgument.getInProjection(), typeArgument.getOutProjection())) {
            Variance variance = typeArgument.getTypeParameter().getVariance();
            Variance variance2 = Variance.IN_VARIANCE;
            if (variance != variance2) {
                if (KotlinBuiltIns.isNothing(typeArgument.getInProjection()) && typeArgument.getTypeParameter().getVariance() != variance2) {
                    return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(typeArgument, Variance.OUT_VARIANCE), typeArgument.getOutProjection());
                }
                if (KotlinBuiltIns.isNullableAny(typeArgument.getOutProjection())) {
                    return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(typeArgument, variance2), typeArgument.getInProjection());
                }
                return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(typeArgument, Variance.OUT_VARIANCE), typeArgument.getOutProjection());
            }
        }
        return new TypeProjectionImpl(typeArgument.getInProjection());
    }

    private static final Variance toTypeProjection$removeProjectionIfRedundant(TypeArgument typeArgument, Variance variance) {
        if (variance == typeArgument.getTypeParameter().getVariance()) {
            return Variance.INVARIANT;
        }
        return variance;
    }
}
