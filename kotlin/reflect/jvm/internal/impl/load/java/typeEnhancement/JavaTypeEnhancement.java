package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaTypeEnhancement {

    @NotNull
    private final JavaResolverSettings javaResolverSettings;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Result {
        private final int subtreeSize;

        @Nullable
        private final KotlinType type;

        public Result(@Nullable KotlinType kotlinType, int i3) {
            this.type = kotlinType;
            this.subtreeSize = i3;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        @Nullable
        public final KotlinType getType() {
            return this.type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class SimpleResult {
        private final boolean forWarnings;
        private final int subtreeSize;

        @Nullable
        private final SimpleType type;

        public SimpleResult(@Nullable SimpleType simpleType, int i3, boolean z16) {
            this.type = simpleType;
            this.subtreeSize = i3;
            this.forWarnings = z16;
        }

        public final boolean getForWarnings() {
            return this.forWarnings;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        @Nullable
        public final SimpleType getType() {
            return this.type;
        }
    }

    public JavaTypeEnhancement(@NotNull JavaResolverSettings javaResolverSettings) {
        Intrinsics.checkNotNullParameter(javaResolverSettings, "javaResolverSettings");
        this.javaResolverSettings = javaResolverSettings;
    }

    private final SimpleResult enhanceInflexible(SimpleType simpleType, Function1<? super Integer, JavaTypeQualifiers> function1, int i3, TypeComponentPosition typeComponentPosition, boolean z16, boolean z17) {
        boolean z18;
        ClassifierDescriptor enhanceMutability;
        Boolean enhancedNullability;
        TypeConstructor constructor;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        EnhancedTypeAnnotations enhancedTypeAnnotations;
        boolean z19;
        EnhancedTypeAnnotations enhancedTypeAnnotations2;
        boolean z26;
        EnhancedTypeAnnotations enhancedTypeAnnotations3;
        List listOfNotNull;
        Annotations compositeAnnotationsOrSingle;
        int collectionSizeOrDefault3;
        int collectionSizeOrDefault4;
        boolean isMarkedNullable;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        Result result;
        TypeProjection typeProjection;
        Function1<? super Integer, JavaTypeQualifiers> function12 = function1;
        boolean shouldEnhance = TypeComponentPositionKt.shouldEnhance(typeComponentPosition);
        if (z17 && z16) {
            z18 = false;
        } else {
            z18 = true;
        }
        KotlinType kotlinType = null;
        if (!shouldEnhance && simpleType.getArguments().isEmpty()) {
            return new SimpleResult(null, 1, false);
        }
        ClassifierDescriptor mo1779getDeclarationDescriptor = simpleType.getConstructor().mo1779getDeclarationDescriptor();
        if (mo1779getDeclarationDescriptor == null) {
            return new SimpleResult(null, 1, false);
        }
        JavaTypeQualifiers invoke = function12.invoke(Integer.valueOf(i3));
        enhanceMutability = TypeEnhancementKt.enhanceMutability(mo1779getDeclarationDescriptor, invoke, typeComponentPosition);
        enhancedNullability = TypeEnhancementKt.getEnhancedNullability(invoke, typeComponentPosition);
        if (enhanceMutability == null || (constructor = enhanceMutability.getTypeConstructor()) == null) {
            constructor = simpleType.getConstructor();
        }
        TypeConstructor typeConstructor = constructor;
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "enhancedClassifier?.typeConstructor ?: constructor");
        int i16 = i3 + 1;
        List<TypeProjection> arguments = simpleType.getArguments();
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
        List<TypeParameterDescriptor> list = parameters;
        Iterator<T> it = arguments.iterator();
        Iterator<T> it5 = list.iterator();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments, 10);
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(Math.min(collectionSizeOrDefault, collectionSizeOrDefault2));
        while (it.hasNext() && it5.hasNext()) {
            Object next = it.next();
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) it5.next();
            TypeProjection typeProjection2 = (TypeProjection) next;
            if (!z18) {
                z36 = z18;
                result = new Result(kotlinType, 0);
            } else {
                z36 = z18;
                if (!typeProjection2.isStarProjection()) {
                    result = enhancePossiblyFlexible(typeProjection2.getType().unwrap(), function12, i16, z17);
                } else if (function12.invoke(Integer.valueOf(i16)).getNullability() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                    UnwrappedType unwrap = typeProjection2.getType().unwrap();
                    result = new Result(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(unwrap).makeNullableAsSpecified(false), FlexibleTypesKt.upperIfFlexible(unwrap).makeNullableAsSpecified(true)), 1);
                } else {
                    result = new Result(null, 1);
                }
            }
            i16 += result.getSubtreeSize();
            if (result.getType() != null) {
                KotlinType type = result.getType();
                Variance projectionKind = typeProjection2.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind, "arg.projectionKind");
                typeProjection = TypeUtilsKt.createProjection(type, projectionKind, typeParameterDescriptor);
            } else if (enhanceMutability != null && !typeProjection2.isStarProjection()) {
                KotlinType type2 = typeProjection2.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "arg.type");
                Variance projectionKind2 = typeProjection2.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind2, "arg.projectionKind");
                typeProjection = TypeUtilsKt.createProjection(type2, projectionKind2, typeParameterDescriptor);
            } else if (enhanceMutability != null) {
                typeProjection = TypeUtils.makeStarProjection(typeParameterDescriptor);
            } else {
                typeProjection = null;
            }
            arrayList.add(typeProjection);
            function12 = function1;
            z18 = z36;
            kotlinType = null;
        }
        int i17 = i16 - i3;
        if (enhanceMutability == null && enhancedNullability == null) {
            if (!arrayList.isEmpty()) {
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    if (((TypeProjection) it6.next()) == null) {
                        z28 = true;
                    } else {
                        z28 = false;
                    }
                    if (!z28) {
                        z29 = false;
                        break;
                    }
                }
            }
            z29 = true;
            if (z29) {
                return new SimpleResult(null, i17, false);
            }
        }
        Annotations[] annotationsArr = new Annotations[3];
        annotationsArr[0] = simpleType.getAnnotations();
        enhancedTypeAnnotations = TypeEnhancementKt.ENHANCED_MUTABILITY_ANNOTATIONS;
        if (enhanceMutability != null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (!z19) {
            enhancedTypeAnnotations = null;
        }
        annotationsArr[1] = enhancedTypeAnnotations;
        enhancedTypeAnnotations2 = TypeEnhancementKt.ENHANCED_NULLABILITY_ANNOTATIONS;
        if (enhancedNullability != null) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26) {
            enhancedTypeAnnotations3 = enhancedTypeAnnotations2;
        } else {
            enhancedTypeAnnotations3 = null;
        }
        annotationsArr[2] = enhancedTypeAnnotations3;
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) annotationsArr);
        compositeAnnotationsOrSingle = TypeEnhancementKt.compositeAnnotationsOrSingle(listOfNotNull);
        TypeAttributes defaultAttributes = TypeAttributesKt.toDefaultAttributes(compositeAnnotationsOrSingle);
        List<TypeProjection> arguments2 = simpleType.getArguments();
        Iterator it7 = arrayList.iterator();
        Iterator<T> it8 = arguments2.iterator();
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments2, 10);
        ArrayList arrayList2 = new ArrayList(Math.min(collectionSizeOrDefault3, collectionSizeOrDefault4));
        while (it7.hasNext() && it8.hasNext()) {
            Object next2 = it7.next();
            TypeProjection typeProjection3 = (TypeProjection) it8.next();
            TypeProjection typeProjection4 = (TypeProjection) next2;
            if (typeProjection4 != null) {
                typeProjection3 = typeProjection4;
            }
            arrayList2.add(typeProjection3);
        }
        if (enhancedNullability != null) {
            isMarkedNullable = enhancedNullability.booleanValue();
        } else {
            isMarkedNullable = simpleType.isMarkedNullable();
        }
        SimpleType simpleType$default = KotlinTypeFactory.simpleType$default(defaultAttributes, typeConstructor, arrayList2, isMarkedNullable, (KotlinTypeRefiner) null, 16, (Object) null);
        if (invoke.getDefinitelyNotNull()) {
            simpleType$default = notNullTypeParameter(simpleType$default);
        }
        if (enhancedNullability != null && invoke.isNullabilityQualifierForWarning()) {
            z27 = true;
        } else {
            z27 = false;
        }
        return new SimpleResult(simpleType$default, i17, z27);
    }

    static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement javaTypeEnhancement, SimpleType simpleType, Function1 function1, int i3, TypeComponentPosition typeComponentPosition, boolean z16, boolean z17, int i16, Object obj) {
        boolean z18;
        boolean z19;
        if ((i16 & 8) != 0) {
            z18 = false;
        } else {
            z18 = z16;
        }
        if ((i16 & 16) != 0) {
            z19 = false;
        } else {
            z19 = z17;
        }
        return javaTypeEnhancement.enhanceInflexible(simpleType, function1, i3, typeComponentPosition, z18, z19);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0096, code lost:
    
        if (r13 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Result enhancePossiblyFlexible(UnwrappedType unwrappedType, Function1<? super Integer, JavaTypeQualifiers> function1, int i3, boolean z16) {
        KotlinType type;
        KotlinType type2;
        KotlinType kotlinType = null;
        if (KotlinTypeKt.isError(unwrappedType)) {
            return new Result(null, 1);
        }
        if (unwrappedType instanceof FlexibleType) {
            boolean z17 = unwrappedType instanceof RawType;
            FlexibleType flexibleType = (FlexibleType) unwrappedType;
            SimpleResult enhanceInflexible = enhanceInflexible(flexibleType.getLowerBound(), function1, i3, TypeComponentPosition.FLEXIBLE_LOWER, z17, z16);
            SimpleResult enhanceInflexible2 = enhanceInflexible(flexibleType.getUpperBound(), function1, i3, TypeComponentPosition.FLEXIBLE_UPPER, z17, z16);
            enhanceInflexible.getSubtreeSize();
            enhanceInflexible2.getSubtreeSize();
            if (enhanceInflexible.getType() != null || enhanceInflexible2.getType() != null) {
                if (!enhanceInflexible.getForWarnings() && !enhanceInflexible2.getForWarnings()) {
                    if (z17) {
                        SimpleType type3 = enhanceInflexible.getType();
                        if (type3 == null) {
                            type3 = flexibleType.getLowerBound();
                        }
                        SimpleType type4 = enhanceInflexible2.getType();
                        if (type4 == null) {
                            type4 = flexibleType.getUpperBound();
                        }
                        kotlinType = new RawTypeImpl(type3, type4);
                    } else {
                        SimpleType type5 = enhanceInflexible.getType();
                        if (type5 == null) {
                            type5 = flexibleType.getLowerBound();
                        }
                        SimpleType type6 = enhanceInflexible2.getType();
                        if (type6 == null) {
                            type6 = flexibleType.getUpperBound();
                        }
                        kotlinType = KotlinTypeFactory.flexibleType(type5, type6);
                    }
                } else {
                    SimpleType type7 = enhanceInflexible2.getType();
                    if (type7 != null) {
                        SimpleType type8 = enhanceInflexible.getType();
                        if (type8 == null) {
                            type8 = type7;
                        }
                        type2 = KotlinTypeFactory.flexibleType(type8, type7);
                    }
                    type2 = enhanceInflexible.getType();
                    Intrinsics.checkNotNull(type2);
                    kotlinType = TypeWithEnhancementKt.wrapEnhancement(unwrappedType, type2);
                }
            }
            return new Result(kotlinType, enhanceInflexible.getSubtreeSize());
        }
        if (unwrappedType instanceof SimpleType) {
            SimpleResult enhanceInflexible$default = enhanceInflexible$default(this, (SimpleType) unwrappedType, function1, i3, TypeComponentPosition.INFLEXIBLE, false, z16, 8, null);
            if (enhanceInflexible$default.getForWarnings()) {
                type = TypeWithEnhancementKt.wrapEnhancement(unwrappedType, enhanceInflexible$default.getType());
            } else {
                type = enhanceInflexible$default.getType();
            }
            return new Result(type, enhanceInflexible$default.getSubtreeSize());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final SimpleType notNullTypeParameter(SimpleType simpleType) {
        if (this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter()) {
            return SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, true);
        }
        return new NotNullTypeParameterImpl(simpleType);
    }

    @Nullable
    public final KotlinType enhance(@NotNull KotlinType kotlinType, @NotNull Function1<? super Integer, JavaTypeQualifiers> qualifiers, boolean z16) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(qualifiers, "qualifiers");
        return enhancePossiblyFlexible(kotlinType.unwrap(), qualifiers, 0, z16).getType();
    }
}
