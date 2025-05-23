package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaTypeResolver {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final LazyJavaResolverContext f412755c;

    @NotNull
    private final RawProjectionComputer projectionComputer;

    @NotNull
    private final TypeParameterResolver typeParameterResolver;

    @NotNull
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    public JavaTypeResolver(@NotNull LazyJavaResolverContext c16, @NotNull TypeParameterResolver typeParameterResolver) {
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(typeParameterResolver, "typeParameterResolver");
        this.f412755c = c16;
        this.typeParameterResolver = typeParameterResolver;
        RawProjectionComputer rawProjectionComputer = new RawProjectionComputer();
        this.projectionComputer = rawProjectionComputer;
        this.typeParameterUpperBoundEraser = new TypeParameterUpperBoundEraser(rawProjectionComputer, null, 2, 0 == true ? 1 : 0);
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(JavaClassifierType javaClassifierType, ClassDescriptor classDescriptor) {
        Object lastOrNull;
        Object lastOrNull2;
        Variance variance;
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) javaClassifierType.getTypeArguments());
        if (!JavaTypesKt.isSuperWildcard((JavaType) lastOrNull)) {
            return false;
        }
        List<TypeParameterDescriptor> parameters = JavaToKotlinClassMapper.INSTANCE.convertReadOnlyToMutable(classDescriptor).getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "JavaToKotlinClassMapper.\u2026ypeConstructor.parameters");
        lastOrNull2 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) parameters);
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) lastOrNull2;
        if (typeParameterDescriptor == null || (variance = typeParameterDescriptor.getVariance()) == null || variance == Variance.OUT_VARIANCE) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if ((!r0.isEmpty()) != false) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<TypeProjection> computeArguments(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, TypeConstructor typeConstructor) {
        boolean z16;
        Iterable<IndexedValue> withIndex;
        int collectionSizeOrDefault;
        List<TypeProjection> list;
        int collectionSizeOrDefault2;
        List<TypeProjection> list2;
        if (!javaClassifierType.isRaw()) {
            if (javaClassifierType.getTypeArguments().isEmpty()) {
                Intrinsics.checkNotNullExpressionValue(typeConstructor.getParameters(), "constructor.parameters");
            }
            z16 = false;
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "constructor.parameters");
            if (!z16) {
                return computeRawTypeArguments(javaClassifierType, parameters, typeConstructor, javaTypeAttributes);
            }
            if (parameters.size() == javaClassifierType.getTypeArguments().size()) {
                withIndex = CollectionsKt___CollectionsKt.withIndex(javaClassifierType.getTypeArguments());
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(withIndex, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (IndexedValue indexedValue : withIndex) {
                    int index = indexedValue.getIndex();
                    JavaType javaType = (JavaType) indexedValue.component2();
                    parameters.size();
                    TypeParameterDescriptor parameter = parameters.get(index);
                    JavaTypeAttributes attributes$default = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
                    Intrinsics.checkNotNullExpressionValue(parameter, "parameter");
                    arrayList.add(transformToTypeProjection(javaType, attributes$default, parameter));
                }
                list = CollectionsKt___CollectionsKt.toList(arrayList);
                return list;
            }
            List<TypeParameterDescriptor> list3 = parameters;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            for (TypeParameterDescriptor typeParameterDescriptor : list3) {
                ErrorTypeKind errorTypeKind = ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER;
                String asString = typeParameterDescriptor.getName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "p.name.asString()");
                arrayList2.add(new TypeProjectionImpl(ErrorUtils.createErrorType(errorTypeKind, asString)));
            }
            list2 = CollectionsKt___CollectionsKt.toList(arrayList2);
            return list2;
        }
        z16 = true;
        List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters2, "constructor.parameters");
        if (!z16) {
        }
    }

    private final List<TypeProjection> computeRawTypeArguments(final JavaClassifierType javaClassifierType, List<? extends TypeParameterDescriptor> list, final TypeConstructor typeConstructor, final JavaTypeAttributes javaTypeAttributes) {
        int collectionSizeOrDefault;
        TypeProjection computeProjection;
        List<? extends TypeParameterDescriptor> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (final TypeParameterDescriptor typeParameterDescriptor : list2) {
            if (TypeUtilsKt.hasTypeParameterRecursiveBounds(typeParameterDescriptor, null, javaTypeAttributes.getVisitedTypeParameters())) {
                computeProjection = TypeUtils.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
            } else {
                computeProjection = this.projectionComputer.computeProjection(typeParameterDescriptor, javaTypeAttributes.markIsRaw(javaClassifierType.isRaw()), this.typeParameterUpperBoundEraser, new LazyWrappedType(this.f412755c.getStorageManager(), new Function0<KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final KotlinType invoke() {
                        TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;
                        typeParameterUpperBoundEraser = JavaTypeResolver.this.typeParameterUpperBoundEraser;
                        TypeParameterDescriptor typeParameterDescriptor2 = typeParameterDescriptor;
                        JavaTypeAttributes javaTypeAttributes2 = javaTypeAttributes;
                        ClassifierDescriptor mo1779getDeclarationDescriptor = typeConstructor.mo1779getDeclarationDescriptor();
                        return typeParameterUpperBoundEraser.getErasedUpperBound(typeParameterDescriptor2, javaTypeAttributes2.withDefaultType(mo1779getDeclarationDescriptor != null ? mo1779getDeclarationDescriptor.getDefaultType() : null).markIsRaw(javaClassifierType.isRaw()));
                    }
                }));
            }
            arrayList.add(computeProjection);
        }
        return arrayList;
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, SimpleType simpleType) {
        TypeAttributes defaultAttributes;
        if (simpleType == null || (defaultAttributes = simpleType.getAttributes()) == null) {
            defaultAttributes = TypeAttributesKt.toDefaultAttributes(new LazyJavaAnnotations(this.f412755c, javaClassifierType, false, 4, null));
        }
        TypeAttributes typeAttributes = defaultAttributes;
        TypeConstructor computeTypeConstructor = computeTypeConstructor(javaClassifierType, javaTypeAttributes);
        TypeConstructor typeConstructor = null;
        if (computeTypeConstructor == null) {
            return null;
        }
        boolean isNullable = isNullable(javaTypeAttributes);
        if (simpleType != null) {
            typeConstructor = simpleType.getConstructor();
        }
        if (Intrinsics.areEqual(typeConstructor, computeTypeConstructor) && !javaClassifierType.isRaw() && isNullable) {
            return simpleType.makeNullableAsSpecified(true);
        }
        return KotlinTypeFactory.simpleType$default(typeAttributes, computeTypeConstructor, computeArguments(javaClassifierType, javaTypeAttributes, computeTypeConstructor), isNullable, (KotlinTypeRefiner) null, 16, (Object) null);
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        TypeConstructor typeConstructor;
        JavaClassifier classifier = javaClassifierType.getClassifier();
        if (classifier == null) {
            return createNotFoundClass(javaClassifierType);
        }
        if (classifier instanceof JavaClass) {
            JavaClass javaClass = (JavaClass) classifier;
            FqName fqName = javaClass.getFqName();
            if (fqName != null) {
                ClassDescriptor mapKotlinClass = mapKotlinClass(javaClassifierType, javaTypeAttributes, fqName);
                if (mapKotlinClass == null) {
                    mapKotlinClass = this.f412755c.getComponents().getModuleClassResolver().resolveClass(javaClass);
                }
                if (mapKotlinClass == null || (typeConstructor = mapKotlinClass.getTypeConstructor()) == null) {
                    return createNotFoundClass(javaClassifierType);
                }
                return typeConstructor;
            }
            throw new AssertionError("Class type should have a FQ name: " + classifier);
        }
        if (classifier instanceof JavaTypeParameter) {
            TypeParameterDescriptor resolveTypeParameter = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter) classifier);
            if (resolveTypeParameter != null) {
                return resolveTypeParameter.getTypeConstructor();
            }
            return null;
        }
        throw new IllegalStateException("Unknown classifier kind: " + classifier);
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType javaClassifierType) {
        List<Integer> listOf;
        ClassId classId = ClassId.topLevel(new FqName(javaClassifierType.getClassifierQualifiedName()));
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(javaType.classifierQualifiedName))");
        NotFoundClasses notFoundClasses = this.f412755c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(0);
        TypeConstructor typeConstructor = notFoundClasses.getClass(classId, listOf).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "c.components.deserialize\u2026istOf(0)).typeConstructor");
        return typeConstructor;
    }

    private final boolean isConflictingArgumentFor(Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor.getVariance() == Variance.INVARIANT || variance == typeParameterDescriptor.getVariance()) {
            return false;
        }
        return true;
    }

    private final boolean isNullable(JavaTypeAttributes javaTypeAttributes) {
        if (javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.isForAnnotationParameter() || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) {
            return false;
        }
        return true;
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, FqName fqName) {
        FqName fqName2;
        if (javaTypeAttributes.isForAnnotationParameter()) {
            fqName2 = JavaTypeResolverKt.JAVA_LANG_CLASS_FQ_NAME;
            if (Intrinsics.areEqual(fqName, fqName2)) {
                return this.f412755c.getComponents().getReflectionTypes().getKClass();
            }
        }
        JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.INSTANCE;
        ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(javaToKotlinClassMapper, fqName, this.f412755c.getModule().getBuiltIns(), null, 4, null);
        if (mapJavaToKotlin$default == null) {
            return null;
        }
        if (javaToKotlinClassMapper.isReadOnly(mapJavaToKotlin$default) && (javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE || argumentsMakeSenseOnlyForMutableContainer(javaClassifierType, mapJavaToKotlin$default))) {
            return javaToKotlinClassMapper.convertReadOnlyToMutable(mapJavaToKotlin$default);
        }
        return mapJavaToKotlin$default;
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver javaTypeResolver, JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return javaTypeResolver.transformArrayType(javaArrayType, javaTypeAttributes, z16);
    }

    private final KotlinType transformJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        boolean z16;
        if (!javaTypeAttributes.isForAnnotationParameter() && javaTypeAttributes.getHowThisTypeIsUsed() != TypeUsage.SUPERTYPE) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isRaw = javaClassifierType.isRaw();
        if (!isRaw && !z16) {
            SimpleType computeSimpleJavaClassifierType = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes, null);
            if (computeSimpleJavaClassifierType == null) {
                return transformJavaClassifierType$errorType(javaClassifierType);
            }
            return computeSimpleJavaClassifierType;
        }
        SimpleType computeSimpleJavaClassifierType2 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (computeSimpleJavaClassifierType2 == null) {
            return transformJavaClassifierType$errorType(javaClassifierType);
        }
        SimpleType computeSimpleJavaClassifierType3 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), computeSimpleJavaClassifierType2);
        if (computeSimpleJavaClassifierType3 == null) {
            return transformJavaClassifierType$errorType(javaClassifierType);
        }
        if (isRaw) {
            return new RawTypeImpl(computeSimpleJavaClassifierType2, computeSimpleJavaClassifierType3);
        }
        return KotlinTypeFactory.flexibleType(computeSimpleJavaClassifierType2, computeSimpleJavaClassifierType3);
    }

    private static final ErrorType transformJavaClassifierType$errorType(JavaClassifierType javaClassifierType) {
        return ErrorUtils.createErrorType(ErrorTypeKind.UNRESOLVED_JAVA_CLASS, javaClassifierType.getPresentableText());
    }

    private final TypeProjection transformToTypeProjection(JavaType javaType, JavaTypeAttributes javaTypeAttributes, TypeParameterDescriptor typeParameterDescriptor) {
        Variance variance;
        TypeProjection makeStarProjection;
        if (javaType instanceof JavaWildcardType) {
            JavaWildcardType javaWildcardType = (JavaWildcardType) javaType;
            JavaType bound = javaWildcardType.getBound();
            if (javaWildcardType.isExtends()) {
                variance = Variance.OUT_VARIANCE;
            } else {
                variance = Variance.IN_VARIANCE;
            }
            if (bound != null && !isConflictingArgumentFor(variance, typeParameterDescriptor)) {
                makeStarProjection = TypeUtilsKt.createProjection(transformJavaType(bound, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null)), variance, typeParameterDescriptor);
            } else {
                makeStarProjection = TypeUtils.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
            }
            Intrinsics.checkNotNullExpressionValue(makeStarProjection, "{\n                val bo\u2026          }\n            }");
            return makeStarProjection;
        }
        return new TypeProjectionImpl(Variance.INVARIANT, transformJavaType(javaType, javaTypeAttributes));
    }

    @NotNull
    public final KotlinType transformArrayType(@NotNull JavaArrayType arrayType, @NotNull JavaTypeAttributes attr, boolean z16) {
        JavaPrimitiveType javaPrimitiveType;
        Variance variance;
        List<? extends AnnotationDescriptor> plus;
        Intrinsics.checkNotNullParameter(arrayType, "arrayType");
        Intrinsics.checkNotNullParameter(attr, "attr");
        JavaType componentType = arrayType.getComponentType();
        PrimitiveType primitiveType = null;
        if (componentType instanceof JavaPrimitiveType) {
            javaPrimitiveType = (JavaPrimitiveType) componentType;
        } else {
            javaPrimitiveType = null;
        }
        if (javaPrimitiveType != null) {
            primitiveType = javaPrimitiveType.getType();
        }
        LazyJavaAnnotations lazyJavaAnnotations = new LazyJavaAnnotations(this.f412755c, arrayType, true);
        if (primitiveType != null) {
            SimpleType primitiveArrayKotlinType = this.f412755c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(primitiveType);
            Intrinsics.checkNotNullExpressionValue(primitiveArrayKotlinType, "c.module.builtIns.getPri\u2026KotlinType(primitiveType)");
            Annotations.Companion companion = Annotations.Companion;
            plus = CollectionsKt___CollectionsKt.plus((Iterable) lazyJavaAnnotations, (Iterable) primitiveArrayKotlinType.getAnnotations());
            TypeUtilsKt.replaceAnnotations(primitiveArrayKotlinType, companion.create(plus));
            if (!attr.isForAnnotationParameter()) {
                return KotlinTypeFactory.flexibleType(primitiveArrayKotlinType, primitiveArrayKotlinType.makeNullableAsSpecified(true));
            }
            return primitiveArrayKotlinType;
        }
        KotlinType transformJavaType = transformJavaType(componentType, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, attr.isForAnnotationParameter(), false, null, 6, null));
        if (attr.isForAnnotationParameter()) {
            if (z16) {
                variance = Variance.OUT_VARIANCE;
            } else {
                variance = Variance.INVARIANT;
            }
            SimpleType arrayType2 = this.f412755c.getModule().getBuiltIns().getArrayType(variance, transformJavaType, lazyJavaAnnotations);
            Intrinsics.checkNotNullExpressionValue(arrayType2, "c.module.builtIns.getArr\u2026mponentType, annotations)");
            return arrayType2;
        }
        SimpleType arrayType3 = this.f412755c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, transformJavaType, lazyJavaAnnotations);
        Intrinsics.checkNotNullExpressionValue(arrayType3, "c.module.builtIns.getArr\u2026mponentType, annotations)");
        return KotlinTypeFactory.flexibleType(arrayType3, this.f412755c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, transformJavaType, lazyJavaAnnotations).makeNullableAsSpecified(true));
    }

    @NotNull
    public final KotlinType transformJavaType(@Nullable JavaType javaType, @NotNull JavaTypeAttributes attr) {
        KotlinType transformJavaType;
        SimpleType unitType;
        Intrinsics.checkNotNullParameter(attr, "attr");
        if (javaType instanceof JavaPrimitiveType) {
            PrimitiveType type = ((JavaPrimitiveType) javaType).getType();
            if (type != null) {
                unitType = this.f412755c.getModule().getBuiltIns().getPrimitiveKotlinType(type);
            } else {
                unitType = this.f412755c.getModule().getBuiltIns().getUnitType();
            }
            Intrinsics.checkNotNullExpressionValue(unitType, "{\n                val pr\u2026ns.unitType\n            }");
            return unitType;
        }
        if (javaType instanceof JavaClassifierType) {
            return transformJavaClassifierType((JavaClassifierType) javaType, attr);
        }
        if (javaType instanceof JavaArrayType) {
            return transformArrayType$default(this, (JavaArrayType) javaType, attr, false, 4, null);
        }
        if (javaType instanceof JavaWildcardType) {
            JavaType bound = ((JavaWildcardType) javaType).getBound();
            if (bound == null || (transformJavaType = transformJavaType(bound, attr)) == null) {
                SimpleType defaultBound = this.f412755c.getModule().getBuiltIns().getDefaultBound();
                Intrinsics.checkNotNullExpressionValue(defaultBound, "c.module.builtIns.defaultBound");
                return defaultBound;
            }
            return transformJavaType;
        }
        if (javaType == null) {
            SimpleType defaultBound2 = this.f412755c.getModule().getBuiltIns().getDefaultBound();
            Intrinsics.checkNotNullExpressionValue(defaultBound2, "c.module.builtIns.defaultBound");
            return defaultBound2;
        }
        throw new UnsupportedOperationException("Unsupported type: " + javaType);
    }
}
