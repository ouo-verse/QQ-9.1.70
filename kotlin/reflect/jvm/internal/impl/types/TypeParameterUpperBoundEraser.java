package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public final class TypeParameterUpperBoundEraser {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final Lazy erroneousErasedBound$delegate;

    @NotNull
    private final MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> getErasedUpperBound;

    @NotNull
    private final TypeParameterErasureOptions options;

    @NotNull
    private final ErasureProjectionComputer projectionComputer;

    @NotNull
    private final LockBasedStorageManager storage;

    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00ba A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0157 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x01fb A[SYNTHETIC] */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final KotlinType replaceArgumentsOfUpperBound(@NotNull KotlinType kotlinType, @NotNull TypeSubstitutor substitutor, @Nullable Set<? extends TypeParameterDescriptor> set, boolean z16) {
            UnwrappedType unwrappedType;
            int collectionSizeOrDefault;
            Object orNull;
            boolean z17;
            boolean z18;
            KotlinType type;
            int collectionSizeOrDefault2;
            Object orNull2;
            boolean z19;
            boolean z26;
            KotlinType type2;
            int collectionSizeOrDefault3;
            Object orNull3;
            boolean z27;
            boolean z28;
            KotlinType type3;
            Intrinsics.checkNotNullParameter(kotlinType, "<this>");
            Intrinsics.checkNotNullParameter(substitutor, "substitutor");
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
                    for (TypeParameterDescriptor typeParameterDescriptor : list) {
                        orNull3 = CollectionsKt___CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor.getIndex());
                        TypeProjection typeProjection = (TypeProjection) orNull3;
                        if (z16) {
                            if (typeProjection != null && (type3 = typeProjection.getType()) != null) {
                                Intrinsics.checkNotNullExpressionValue(type3, "type");
                                if (!TypeUtilsKt.containsTypeParameter(type3)) {
                                    z28 = true;
                                    if (z28) {
                                        arrayList.add(typeProjection);
                                    }
                                }
                            }
                            z28 = false;
                            if (z28) {
                            }
                        }
                        if (set != null && set.contains(typeParameterDescriptor)) {
                            z27 = true;
                        } else {
                            z27 = false;
                        }
                        if (typeProjection != null && !z27) {
                            TypeSubstitution substitution = substitutor.getSubstitution();
                            KotlinType type4 = typeProjection.getType();
                            Intrinsics.checkNotNullExpressionValue(type4, "argument.type");
                            if (substitution.mo1784get(type4) != null) {
                                arrayList.add(typeProjection);
                            }
                        }
                        typeProjection = new StarProjectionImpl(typeParameterDescriptor);
                        arrayList.add(typeProjection);
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
                    for (TypeParameterDescriptor typeParameterDescriptor2 : list2) {
                        orNull2 = CollectionsKt___CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor2.getIndex());
                        TypeProjection typeProjection2 = (TypeProjection) orNull2;
                        if (z16) {
                            if (typeProjection2 != null && (type2 = typeProjection2.getType()) != null) {
                                Intrinsics.checkNotNullExpressionValue(type2, "type");
                                if (!TypeUtilsKt.containsTypeParameter(type2)) {
                                    z26 = true;
                                    if (z26) {
                                        arrayList2.add(typeProjection2);
                                    }
                                }
                            }
                            z26 = false;
                            if (z26) {
                            }
                        }
                        if (set != null && set.contains(typeParameterDescriptor2)) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (typeProjection2 != null && !z19) {
                            TypeSubstitution substitution2 = substitutor.getSubstitution();
                            KotlinType type5 = typeProjection2.getType();
                            Intrinsics.checkNotNullExpressionValue(type5, "argument.type");
                            if (substitution2.mo1784get(type5) != null) {
                                arrayList2.add(typeProjection2);
                            }
                        }
                        typeProjection2 = new StarProjectionImpl(typeParameterDescriptor2);
                        arrayList2.add(typeProjection2);
                    }
                    upperBound = TypeSubstitutionKt.replace$default(upperBound, arrayList2, null, 2, null);
                }
                unwrappedType = KotlinTypeFactory.flexibleType(lowerBound, upperBound);
            } else if (unwrap instanceof SimpleType) {
                SimpleType simpleType = (SimpleType) unwrap;
                if (!simpleType.getConstructor().getParameters().isEmpty() && simpleType.getConstructor().mo1779getDeclarationDescriptor() != null) {
                    List<TypeParameterDescriptor> parameters3 = simpleType.getConstructor().getParameters();
                    Intrinsics.checkNotNullExpressionValue(parameters3, "constructor.parameters");
                    List<TypeParameterDescriptor> list3 = parameters3;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                    ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                    for (TypeParameterDescriptor typeParameterDescriptor3 : list3) {
                        orNull = CollectionsKt___CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor3.getIndex());
                        TypeProjection typeProjection3 = (TypeProjection) orNull;
                        if (z16) {
                            if (typeProjection3 != null && (type = typeProjection3.getType()) != null) {
                                Intrinsics.checkNotNullExpressionValue(type, "type");
                                if (!TypeUtilsKt.containsTypeParameter(type)) {
                                    z18 = true;
                                    if (z18) {
                                        arrayList3.add(typeProjection3);
                                    }
                                }
                            }
                            z18 = false;
                            if (z18) {
                            }
                        }
                        if (set != null && set.contains(typeParameterDescriptor3)) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (typeProjection3 != null && !z17) {
                            TypeSubstitution substitution3 = substitutor.getSubstitution();
                            KotlinType type6 = typeProjection3.getType();
                            Intrinsics.checkNotNullExpressionValue(type6, "argument.type");
                            if (substitution3.mo1784get(type6) != null) {
                                arrayList3.add(typeProjection3);
                            }
                        }
                        typeProjection3 = new StarProjectionImpl(typeParameterDescriptor3);
                        arrayList3.add(typeProjection3);
                    }
                    unwrappedType = TypeSubstitutionKt.replace$default(simpleType, arrayList3, null, 2, null);
                } else {
                    unwrappedType = simpleType;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            KotlinType safeSubstitute = substitutor.safeSubstitute(TypeWithEnhancementKt.inheritEnhancement(unwrappedType, unwrap), Variance.OUT_VARIANCE);
            Intrinsics.checkNotNullExpressionValue(safeSubstitute, "substitutor.safeSubstitu\u2026s, Variance.OUT_VARIANCE)");
            return safeSubstitute;
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes28.dex */
    public static final class DataToEraseUpperBound {

        @NotNull
        private final ErasureTypeAttributes typeAttr;

        @NotNull
        private final TypeParameterDescriptor typeParameter;

        public DataToEraseUpperBound(@NotNull TypeParameterDescriptor typeParameter, @NotNull ErasureTypeAttributes typeAttr) {
            Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
            Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
            this.typeParameter = typeParameter;
            this.typeAttr = typeAttr;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof DataToEraseUpperBound)) {
                return false;
            }
            DataToEraseUpperBound dataToEraseUpperBound = (DataToEraseUpperBound) obj;
            if (!Intrinsics.areEqual(dataToEraseUpperBound.typeParameter, this.typeParameter) || !Intrinsics.areEqual(dataToEraseUpperBound.typeAttr, this.typeAttr)) {
                return false;
            }
            return true;
        }

        @NotNull
        public final ErasureTypeAttributes getTypeAttr() {
            return this.typeAttr;
        }

        @NotNull
        public final TypeParameterDescriptor getTypeParameter() {
            return this.typeParameter;
        }

        public int hashCode() {
            int hashCode = this.typeParameter.hashCode();
            return hashCode + (hashCode * 31) + this.typeAttr.hashCode();
        }

        @NotNull
        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.typeParameter + ", typeAttr=" + this.typeAttr + ')';
        }
    }

    public TypeParameterUpperBoundEraser(@NotNull ErasureProjectionComputer projectionComputer, @NotNull TypeParameterErasureOptions options) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(projectionComputer, "projectionComputer");
        Intrinsics.checkNotNullParameter(options, "options");
        this.projectionComputer = projectionComputer;
        this.options = options;
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Type parameter upper bound erasure results");
        this.storage = lockBasedStorageManager;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ErrorType>() { // from class: kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser$erroneousErasedBound$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ErrorType invoke() {
                return ErrorUtils.createErrorType(ErrorTypeKind.CANNOT_COMPUTE_ERASED_BOUND, TypeParameterUpperBoundEraser.this.toString());
            }
        });
        this.erroneousErasedBound$delegate = lazy;
        MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> createMemoizedFunction = lockBasedStorageManager.createMemoizedFunction(new Function1<DataToEraseUpperBound, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser$getErasedUpperBound$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final KotlinType invoke(TypeParameterUpperBoundEraser.DataToEraseUpperBound dataToEraseUpperBound) {
                KotlinType erasedUpperBoundInternal;
                erasedUpperBoundInternal = TypeParameterUpperBoundEraser.this.getErasedUpperBoundInternal(dataToEraseUpperBound.getTypeParameter(), dataToEraseUpperBound.getTypeAttr());
                return erasedUpperBoundInternal;
            }
        });
        Intrinsics.checkNotNullExpressionValue(createMemoizedFunction, "storage.createMemoizedFu\u2026ameter, typeAttr) }\n    }");
        this.getErasedUpperBound = createMemoizedFunction;
    }

    private final KotlinType getDefaultType(ErasureTypeAttributes erasureTypeAttributes) {
        KotlinType replaceArgumentsWithStarProjections;
        SimpleType defaultType = erasureTypeAttributes.getDefaultType();
        if (defaultType == null || (replaceArgumentsWithStarProjections = TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType)) == null) {
            return getErroneousErasedBound();
        }
        return replaceArgumentsWithStarProjections;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KotlinType getErasedUpperBoundInternal(TypeParameterDescriptor typeParameterDescriptor, ErasureTypeAttributes erasureTypeAttributes) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        List list;
        int collectionSizeOrDefault2;
        Object single;
        TypeProjection computeProjection;
        Set<TypeParameterDescriptor> visitedTypeParameters = erasureTypeAttributes.getVisitedTypeParameters();
        if (visitedTypeParameters != null && visitedTypeParameters.contains(typeParameterDescriptor.getOriginal())) {
            return getDefaultType(erasureTypeAttributes);
        }
        SimpleType defaultType = typeParameterDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "typeParameter.defaultType");
        Set<TypeParameterDescriptor> extractTypeParametersFromUpperBounds = TypeUtilsKt.extractTypeParametersFromUpperBounds(defaultType, visitedTypeParameters);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(extractTypeParametersFromUpperBounds, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (TypeParameterDescriptor typeParameterDescriptor2 : extractTypeParametersFromUpperBounds) {
            if (visitedTypeParameters != null && visitedTypeParameters.contains(typeParameterDescriptor2)) {
                computeProjection = TypeUtils.makeStarProjection(typeParameterDescriptor2, erasureTypeAttributes);
                Intrinsics.checkNotNullExpressionValue(computeProjection, "makeStarProjection(it, typeAttr)");
            } else {
                computeProjection = this.projectionComputer.computeProjection(typeParameterDescriptor2, erasureTypeAttributes, this, getErasedUpperBound(typeParameterDescriptor2, erasureTypeAttributes.withNewVisitedTypeParameter(typeParameterDescriptor)));
            }
            Pair pair = TuplesKt.to(typeParameterDescriptor2.getTypeConstructor(), computeProjection);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        boolean z16 = false;
        TypeSubstitutor create = TypeSubstitutor.create(TypeConstructorSubstitution.Companion.createByConstructorsMap$default(TypeConstructorSubstitution.Companion, linkedHashMap, false, 2, null));
        Intrinsics.checkNotNullExpressionValue(create, "create(TypeConstructorSu\u2026ap(erasedTypeParameters))");
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
        Set<KotlinType> substituteErasedUpperBounds = substituteErasedUpperBounds(create, upperBounds, erasureTypeAttributes);
        if (!substituteErasedUpperBounds.isEmpty()) {
            if (this.options.getIntersectUpperBounds()) {
                list = CollectionsKt___CollectionsKt.toList(substituteErasedUpperBounds);
                List list2 = list;
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((KotlinType) it.next()).unwrap());
                }
                return IntersectionTypeKt.intersectTypes(arrayList);
            }
            if (substituteErasedUpperBounds.size() == 1) {
                z16 = true;
            }
            if (z16) {
                single = CollectionsKt___CollectionsKt.single(substituteErasedUpperBounds);
                return (KotlinType) single;
            }
            throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds".toString());
        }
        return getDefaultType(erasureTypeAttributes);
    }

    private final ErrorType getErroneousErasedBound() {
        return (ErrorType) this.erroneousErasedBound$delegate.getValue();
    }

    private final Set<KotlinType> substituteErasedUpperBounds(TypeSubstitutor typeSubstitutor, List<? extends KotlinType> list, ErasureTypeAttributes erasureTypeAttributes) {
        Set createSetBuilder;
        Set<KotlinType> build;
        createSetBuilder = SetsKt__SetsJVMKt.createSetBuilder();
        for (KotlinType kotlinType : list) {
            ClassifierDescriptor mo1779getDeclarationDescriptor = kotlinType.getConstructor().mo1779getDeclarationDescriptor();
            if (mo1779getDeclarationDescriptor instanceof ClassDescriptor) {
                createSetBuilder.add(Companion.replaceArgumentsOfUpperBound(kotlinType, typeSubstitutor, erasureTypeAttributes.getVisitedTypeParameters(), this.options.getLeaveNonTypeParameterTypes()));
            } else if (mo1779getDeclarationDescriptor instanceof TypeParameterDescriptor) {
                Set<TypeParameterDescriptor> visitedTypeParameters = erasureTypeAttributes.getVisitedTypeParameters();
                boolean z16 = false;
                if (visitedTypeParameters != null && visitedTypeParameters.contains(mo1779getDeclarationDescriptor)) {
                    z16 = true;
                }
                if (z16) {
                    createSetBuilder.add(getDefaultType(erasureTypeAttributes));
                } else {
                    List<KotlinType> upperBounds = ((TypeParameterDescriptor) mo1779getDeclarationDescriptor).getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds, "declaration.upperBounds");
                    createSetBuilder.addAll(substituteErasedUpperBounds(typeSubstitutor, upperBounds, erasureTypeAttributes));
                }
            }
            if (!this.options.getIntersectUpperBounds()) {
                break;
            }
        }
        build = SetsKt__SetsJVMKt.build(createSetBuilder);
        return build;
    }

    @NotNull
    public final KotlinType getErasedUpperBound(@NotNull TypeParameterDescriptor typeParameter, @NotNull ErasureTypeAttributes typeAttr) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
        KotlinType invoke = this.getErasedUpperBound.invoke(new DataToEraseUpperBound(typeParameter, typeAttr));
        Intrinsics.checkNotNullExpressionValue(invoke, "getErasedUpperBound(Data\u2026typeParameter, typeAttr))");
        return invoke;
    }

    public /* synthetic */ TypeParameterUpperBoundEraser(ErasureProjectionComputer erasureProjectionComputer, TypeParameterErasureOptions typeParameterErasureOptions, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(erasureProjectionComputer, (i3 & 2) != 0 ? new TypeParameterErasureOptions(false, false) : typeParameterErasureOptions);
    }
}
