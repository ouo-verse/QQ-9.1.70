package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ExpandedTypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DescriptorBasedTypeSignatureMappingKt {
    @NotNull
    public static final String computeInternalName(@NotNull ClassDescriptor klass, @NotNull TypeMappingConfiguration<?> typeMappingConfiguration) {
        ClassDescriptor classDescriptor;
        String replace$default;
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(typeMappingConfiguration, "typeMappingConfiguration");
        String predefinedFullInternalNameForClass = typeMappingConfiguration.getPredefinedFullInternalNameForClass(klass);
        if (predefinedFullInternalNameForClass != null) {
            return predefinedFullInternalNameForClass;
        }
        DeclarationDescriptor containingDeclaration = klass.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "klass.containingDeclaration");
        String identifier = SpecialNames.safeIdentifier(klass.getName()).getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "safeIdentifier(klass.name).identifier");
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            FqName fqName = ((PackageFragmentDescriptor) containingDeclaration).getFqName();
            if (!fqName.isRoot()) {
                StringBuilder sb5 = new StringBuilder();
                String asString = fqName.asString();
                Intrinsics.checkNotNullExpressionValue(asString, "fqName.asString()");
                replace$default = StringsKt__StringsJVMKt.replace$default(asString, '.', '/', false, 4, (Object) null);
                sb5.append(replace$default);
                sb5.append('/');
                sb5.append(identifier);
                return sb5.toString();
            }
            return identifier;
        }
        if (containingDeclaration instanceof ClassDescriptor) {
            classDescriptor = (ClassDescriptor) containingDeclaration;
        } else {
            classDescriptor = null;
        }
        if (classDescriptor != null) {
            String predefinedInternalNameForClass = typeMappingConfiguration.getPredefinedInternalNameForClass(classDescriptor);
            if (predefinedInternalNameForClass == null) {
                predefinedInternalNameForClass = computeInternalName(classDescriptor, typeMappingConfiguration);
            }
            return predefinedInternalNameForClass + '$' + identifier;
        }
        throw new IllegalArgumentException("Unexpected container: " + containingDeclaration + " for " + klass);
    }

    public static /* synthetic */ String computeInternalName$default(ClassDescriptor classDescriptor, TypeMappingConfiguration typeMappingConfiguration, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            typeMappingConfiguration = TypeMappingConfigurationImpl.INSTANCE;
        }
        return computeInternalName(classDescriptor, typeMappingConfiguration);
    }

    public static final boolean hasVoidReturnType(@NotNull CallableDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (descriptor instanceof ConstructorDescriptor) {
            return true;
        }
        KotlinType returnType = descriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        if (KotlinBuiltIns.isUnit(returnType)) {
            KotlinType returnType2 = descriptor.getReturnType();
            Intrinsics.checkNotNull(returnType2);
            if (!TypeUtils.isNullableType(returnType2) && !(descriptor instanceof PropertyGetterDescriptor)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10, types: [T, java.lang.Object] */
    @NotNull
    public static final <T> T mapType(@NotNull KotlinType kotlinType, @NotNull JvmTypeFactory<T> factory, @NotNull TypeMappingMode mode, @NotNull TypeMappingConfiguration<? extends T> typeMappingConfiguration, @Nullable JvmDescriptorTypeWriter<T> jvmDescriptorTypeWriter, @NotNull Function3<? super KotlinType, ? super T, ? super TypeMappingMode, Unit> writeGenericType) {
        T t16;
        KotlinType kotlinType2;
        Object mapType;
        Intrinsics.checkNotNullParameter(kotlinType, "kotlinType");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(typeMappingConfiguration, "typeMappingConfiguration");
        Intrinsics.checkNotNullParameter(writeGenericType, "writeGenericType");
        KotlinType preprocessType = typeMappingConfiguration.preprocessType(kotlinType);
        if (preprocessType != null) {
            return (T) mapType(preprocessType, factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
        }
        if (FunctionTypesKt.isSuspendFunctionType(kotlinType)) {
            return (T) mapType(SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(kotlinType), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
        }
        SimpleClassicTypeSystemContext simpleClassicTypeSystemContext = SimpleClassicTypeSystemContext.INSTANCE;
        Object mapBuiltInType = TypeSignatureMappingKt.mapBuiltInType(simpleClassicTypeSystemContext, kotlinType, factory, mode);
        if (mapBuiltInType != null) {
            ?? r95 = (Object) TypeSignatureMappingKt.boxTypeIfNeeded(factory, mapBuiltInType, mode.getNeedPrimitiveBoxing());
            writeGenericType.invoke(kotlinType, r95, mode);
            return r95;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor) constructor;
            KotlinType alternativeType = intersectionTypeConstructor.getAlternativeType();
            if (alternativeType == null) {
                alternativeType = typeMappingConfiguration.commonSupertype(intersectionTypeConstructor.mo1780getSupertypes());
            }
            return (T) mapType(TypeUtilsKt.replaceArgumentsWithStarProjections(alternativeType), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
        }
        ClassifierDescriptor mo1779getDeclarationDescriptor = constructor.mo1779getDeclarationDescriptor();
        if (mo1779getDeclarationDescriptor != null) {
            if (ErrorUtils.isError(mo1779getDeclarationDescriptor)) {
                T t17 = (T) factory.createObjectType("error/NonExistentClass");
                typeMappingConfiguration.processErrorType(kotlinType, (ClassDescriptor) mo1779getDeclarationDescriptor);
                if (jvmDescriptorTypeWriter != 0) {
                    jvmDescriptorTypeWriter.writeClass(t17);
                }
                return t17;
            }
            boolean z16 = mo1779getDeclarationDescriptor instanceof ClassDescriptor;
            if (z16 && KotlinBuiltIns.isArray(kotlinType)) {
                if (kotlinType.getArguments().size() == 1) {
                    TypeProjection typeProjection = kotlinType.getArguments().get(0);
                    KotlinType type = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "memberProjection.type");
                    if (typeProjection.getProjectionKind() == Variance.IN_VARIANCE) {
                        mapType = factory.createObjectType("java/lang/Object");
                        if (jvmDescriptorTypeWriter != 0) {
                            jvmDescriptorTypeWriter.writeArrayType();
                            jvmDescriptorTypeWriter.writeClass(mapType);
                            jvmDescriptorTypeWriter.writeArrayEnd();
                        }
                    } else {
                        if (jvmDescriptorTypeWriter != 0) {
                            jvmDescriptorTypeWriter.writeArrayType();
                        }
                        Variance projectionKind = typeProjection.getProjectionKind();
                        Intrinsics.checkNotNullExpressionValue(projectionKind, "memberProjection.projectionKind");
                        mapType = mapType(type, factory, mode.toGenericArgumentMode(projectionKind, true), typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
                        if (jvmDescriptorTypeWriter != 0) {
                            jvmDescriptorTypeWriter.writeArrayEnd();
                        }
                    }
                    return (T) factory.createFromString('[' + factory.toString(mapType));
                }
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            if (z16) {
                if (InlineClassesUtilsKt.isInlineClass(mo1779getDeclarationDescriptor) && !mode.getNeedInlineClassWrapping() && (kotlinType2 = (KotlinType) ExpandedTypeUtilsKt.computeExpandedTypeForInlineClass(simpleClassicTypeSystemContext, kotlinType)) != null) {
                    return (T) mapType(kotlinType2, factory, mode.wrapInlineClassesMode(), typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
                }
                if (mode.isForAnnotationParameter() && KotlinBuiltIns.isKClass((ClassDescriptor) mo1779getDeclarationDescriptor)) {
                    t16 = (Object) factory.getJavaLangClassType();
                } else {
                    ClassDescriptor classDescriptor = (ClassDescriptor) mo1779getDeclarationDescriptor;
                    ClassDescriptor original = classDescriptor.getOriginal();
                    Intrinsics.checkNotNullExpressionValue(original, "descriptor.original");
                    T predefinedTypeForClass = typeMappingConfiguration.getPredefinedTypeForClass(original);
                    if (predefinedTypeForClass == null) {
                        if (classDescriptor.getKind() == ClassKind.ENUM_ENTRY) {
                            DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
                            Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                            classDescriptor = (ClassDescriptor) containingDeclaration;
                        }
                        ClassDescriptor original2 = classDescriptor.getOriginal();
                        Intrinsics.checkNotNullExpressionValue(original2, "enumClassIfEnumEntry.original");
                        t16 = (Object) factory.createObjectType(computeInternalName(original2, typeMappingConfiguration));
                    } else {
                        t16 = (Object) predefinedTypeForClass;
                    }
                }
                writeGenericType.invoke(kotlinType, t16, mode);
                return t16;
            }
            if (mo1779getDeclarationDescriptor instanceof TypeParameterDescriptor) {
                KotlinType representativeUpperBound = TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) mo1779getDeclarationDescriptor);
                if (kotlinType.isMarkedNullable()) {
                    representativeUpperBound = TypeUtilsKt.makeNullable(representativeUpperBound);
                }
                T t18 = (T) mapType(representativeUpperBound, factory, mode, typeMappingConfiguration, null, FunctionsKt.getDO_NOTHING_3());
                if (jvmDescriptorTypeWriter != 0) {
                    Name name = mo1779getDeclarationDescriptor.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "descriptor.getName()");
                    jvmDescriptorTypeWriter.writeTypeVariable(name, t18);
                }
                return t18;
            }
            if ((mo1779getDeclarationDescriptor instanceof TypeAliasDescriptor) && mode.getMapTypeAliases()) {
                return (T) mapType(((TypeAliasDescriptor) mo1779getDeclarationDescriptor).getExpandedType(), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
            }
            throw new UnsupportedOperationException("Unknown type " + kotlinType);
        }
        throw new UnsupportedOperationException("no descriptor for type constructor of " + kotlinType);
    }

    public static /* synthetic */ Object mapType$default(KotlinType kotlinType, JvmTypeFactory jvmTypeFactory, TypeMappingMode typeMappingMode, TypeMappingConfiguration typeMappingConfiguration, JvmDescriptorTypeWriter jvmDescriptorTypeWriter, Function3 function3, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            function3 = FunctionsKt.getDO_NOTHING_3();
        }
        return mapType(kotlinType, jvmTypeFactory, typeMappingMode, typeMappingConfiguration, jvmDescriptorTypeWriter, function3);
    }
}
