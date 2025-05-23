package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeAttribute;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class TypeDeserializer {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final DeserializationContext f412762c;

    @NotNull
    private final Function1<Integer, ClassifierDescriptor> classifierDescriptors;

    @NotNull
    private final String containerPresentableName;

    @NotNull
    private final String debugName;

    @Nullable
    private final TypeDeserializer parent;

    @NotNull
    private final Function1<Integer, ClassifierDescriptor> typeAliasDescriptors;

    @NotNull
    private final Map<Integer, TypeParameterDescriptor> typeParameterDescriptors;

    public TypeDeserializer(@NotNull DeserializationContext c16, @Nullable TypeDeserializer typeDeserializer, @NotNull List<ProtoBuf.TypeParameter> typeParameterProtos, @NotNull String debugName, @NotNull String containerPresentableName) {
        Map<Integer, TypeParameterDescriptor> linkedHashMap;
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(typeParameterProtos, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(debugName, "debugName");
        Intrinsics.checkNotNullParameter(containerPresentableName, "containerPresentableName");
        this.f412762c = c16;
        this.parent = typeDeserializer;
        this.debugName = debugName;
        this.containerPresentableName = containerPresentableName;
        this.classifierDescriptors = c16.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<Integer, ClassifierDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$classifierDescriptors$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ClassifierDescriptor invoke(Integer num) {
                return invoke(num.intValue());
            }

            @Nullable
            public final ClassifierDescriptor invoke(int i3) {
                ClassifierDescriptor computeClassifierDescriptor;
                computeClassifierDescriptor = TypeDeserializer.this.computeClassifierDescriptor(i3);
                return computeClassifierDescriptor;
            }
        });
        this.typeAliasDescriptors = c16.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<Integer, ClassifierDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeAliasDescriptors$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ClassifierDescriptor invoke(Integer num) {
                return invoke(num.intValue());
            }

            @Nullable
            public final ClassifierDescriptor invoke(int i3) {
                ClassifierDescriptor computeTypeAliasDescriptor;
                computeTypeAliasDescriptor = TypeDeserializer.this.computeTypeAliasDescriptor(i3);
                return computeTypeAliasDescriptor;
            }
        });
        if (typeParameterProtos.isEmpty()) {
            linkedHashMap = MapsKt__MapsKt.emptyMap();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i3 = 0;
            for (ProtoBuf.TypeParameter typeParameter : typeParameterProtos) {
                linkedHashMap.put(Integer.valueOf(typeParameter.getId()), new DeserializedTypeParameterDescriptor(this.f412762c, typeParameter, i3));
                i3++;
            }
        }
        this.typeParameterDescriptors = linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassifierDescriptor computeClassifierDescriptor(int i3) {
        ClassId classId = NameResolverUtilKt.getClassId(this.f412762c.getNameResolver(), i3);
        if (classId.isLocal()) {
            return this.f412762c.getComponents().deserializeClass(classId);
        }
        return FindClassInModuleKt.findClassifierAcrossModuleDependencies(this.f412762c.getComponents().getModuleDescriptor(), classId);
    }

    private final SimpleType computeLocalClassifierReplacementType(int i3) {
        if (NameResolverUtilKt.getClassId(this.f412762c.getNameResolver(), i3).isLocal()) {
            return this.f412762c.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassifierDescriptor computeTypeAliasDescriptor(int i3) {
        ClassId classId = NameResolverUtilKt.getClassId(this.f412762c.getNameResolver(), i3);
        if (classId.isLocal()) {
            return null;
        }
        return FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(this.f412762c.getComponents().getModuleDescriptor(), classId);
    }

    private final SimpleType createSimpleSuspendFunctionType(KotlinType kotlinType, KotlinType kotlinType2) {
        List dropLast;
        int collectionSizeOrDefault;
        KotlinBuiltIns builtIns = TypeUtilsKt.getBuiltIns(kotlinType);
        Annotations annotations = kotlinType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        List<KotlinType> contextReceiverTypesFromFunctionType = FunctionTypesKt.getContextReceiverTypesFromFunctionType(kotlinType);
        dropLast = CollectionsKt___CollectionsKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType), 1);
        List list = dropLast;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeProjection) it.next()).getType());
        }
        return FunctionTypesKt.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, contextReceiverTypesFromFunctionType, arrayList, null, kotlinType2, true).makeNullableAsSpecified(kotlinType.isMarkedNullable());
    }

    private final SimpleType createSuspendFunctionType(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z16) {
        SimpleType createSuspendFunctionTypeForBasicCase;
        int size;
        int size2 = typeConstructor.getParameters().size() - list.size();
        if (size2 != 0) {
            createSuspendFunctionTypeForBasicCase = null;
            if (size2 == 1 && (size = list.size() - 1) >= 0) {
                TypeConstructor typeConstructor2 = typeConstructor.getBuiltIns().getSuspendFunction(size).getTypeConstructor();
                Intrinsics.checkNotNullExpressionValue(typeConstructor2, "functionTypeConstructor.\u2026on(arity).typeConstructor");
                createSuspendFunctionTypeForBasicCase = KotlinTypeFactory.simpleType$default(typeAttributes, typeConstructor2, list, z16, (KotlinTypeRefiner) null, 16, (Object) null);
            }
        } else {
            createSuspendFunctionTypeForBasicCase = createSuspendFunctionTypeForBasicCase(typeAttributes, typeConstructor, list, z16);
        }
        if (createSuspendFunctionTypeForBasicCase == null) {
            return ErrorUtils.INSTANCE.createErrorTypeWithArguments(ErrorTypeKind.INCONSISTENT_SUSPEND_FUNCTION, list, typeConstructor, new String[0]);
        }
        return createSuspendFunctionTypeForBasicCase;
    }

    private final SimpleType createSuspendFunctionTypeForBasicCase(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z16) {
        SimpleType simpleType$default = KotlinTypeFactory.simpleType$default(typeAttributes, typeConstructor, list, z16, (KotlinTypeRefiner) null, 16, (Object) null);
        if (!FunctionTypesKt.isFunctionType(simpleType$default)) {
            return null;
        }
        return transformRuntimeFunctionTypeToSuspendFunction(simpleType$default);
    }

    private final TypeParameterDescriptor loadTypeParameter(int i3) {
        TypeParameterDescriptor typeParameterDescriptor = this.typeParameterDescriptors.get(Integer.valueOf(i3));
        if (typeParameterDescriptor == null) {
            TypeDeserializer typeDeserializer = this.parent;
            if (typeDeserializer != null) {
                return typeDeserializer.loadTypeParameter(i3);
            }
            return null;
        }
        return typeParameterDescriptor;
    }

    private static final List<ProtoBuf.Type.Argument> simpleType$collectAllArguments(ProtoBuf.Type type, TypeDeserializer typeDeserializer) {
        List<ProtoBuf.Type.Argument> list;
        List<ProtoBuf.Type.Argument> plus;
        List<ProtoBuf.Type.Argument> argumentList = type.getArgumentList();
        Intrinsics.checkNotNullExpressionValue(argumentList, "argumentList");
        List<ProtoBuf.Type.Argument> list2 = argumentList;
        ProtoBuf.Type outerType = ProtoTypeTableUtilKt.outerType(type, typeDeserializer.f412762c.getTypeTable());
        if (outerType != null) {
            list = simpleType$collectAllArguments(outerType, typeDeserializer);
        } else {
            list = null;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) list2, (Iterable) list);
        return plus;
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeDeserializer typeDeserializer, ProtoBuf.Type type, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return typeDeserializer.simpleType(type, z16);
    }

    private final TypeAttributes toAttributes(List<? extends TypeAttributeTranslator> list, Annotations annotations, TypeConstructor typeConstructor, DeclarationDescriptor declarationDescriptor) {
        int collectionSizeOrDefault;
        List<? extends TypeAttribute<?>> flatten;
        List<? extends TypeAttributeTranslator> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeAttributeTranslator) it.next()).toAttributes(annotations, typeConstructor, declarationDescriptor));
        }
        flatten = CollectionsKt__IterablesKt.flatten(arrayList);
        return TypeAttributes.Companion.create(flatten);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final SimpleType transformRuntimeFunctionTypeToSuspendFunction(KotlinType kotlinType) {
        Object lastOrNull;
        KotlinType type;
        FqName fqName;
        Object single;
        FqName fqName2;
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType));
        TypeProjection typeProjection = (TypeProjection) lastOrNull;
        FqName fqName3 = null;
        if (typeProjection == null || (type = typeProjection.getType()) == null) {
            return null;
        }
        ClassifierDescriptor mo1779getDeclarationDescriptor = type.getConstructor().mo1779getDeclarationDescriptor();
        if (mo1779getDeclarationDescriptor != null) {
            fqName = DescriptorUtilsKt.getFqNameSafe(mo1779getDeclarationDescriptor);
        } else {
            fqName = null;
        }
        if (type.getArguments().size() == 1) {
            if (!Intrinsics.areEqual(fqName, StandardNames.CONTINUATION_INTERFACE_FQ_NAME)) {
                fqName2 = TypeDeserializerKt.EXPERIMENTAL_CONTINUATION_FQ_NAME;
            }
            single = CollectionsKt___CollectionsKt.single((List<? extends Object>) type.getArguments());
            KotlinType type2 = ((TypeProjection) single).getType();
            Intrinsics.checkNotNullExpressionValue(type2, "continuationArgumentType.arguments.single().type");
            DeclarationDescriptor containingDeclaration = this.f412762c.getContainingDeclaration();
            if (!(containingDeclaration instanceof CallableDescriptor)) {
                containingDeclaration = null;
            }
            CallableDescriptor callableDescriptor = (CallableDescriptor) containingDeclaration;
            if (callableDescriptor != null) {
                fqName3 = DescriptorUtilsKt.fqNameOrNull(callableDescriptor);
            }
            if (Intrinsics.areEqual(fqName3, SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
                return createSimpleSuspendFunctionType(kotlinType, type2);
            }
            return createSimpleSuspendFunctionType(kotlinType, type2);
        }
        return (SimpleType) kotlinType;
    }

    private final TypeProjection typeArgument(TypeParameterDescriptor typeParameterDescriptor, ProtoBuf.Type.Argument argument) {
        if (argument.getProjection() == ProtoBuf.Type.Argument.Projection.STAR) {
            if (typeParameterDescriptor == null) {
                return new StarProjectionForAbsentTypeParameter(this.f412762c.getComponents().getModuleDescriptor().getBuiltIns());
            }
            return new StarProjectionImpl(typeParameterDescriptor);
        }
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        ProtoBuf.Type.Argument.Projection projection = argument.getProjection();
        Intrinsics.checkNotNullExpressionValue(projection, "typeArgumentProto.projection");
        Variance variance = protoEnumFlags.variance(projection);
        ProtoBuf.Type type = ProtoTypeTableUtilKt.type(argument, this.f412762c.getTypeTable());
        if (type == null) {
            return new TypeProjectionImpl(ErrorUtils.createErrorType(ErrorTypeKind.NO_RECORDED_TYPE, argument.toString()));
        }
        return new TypeProjectionImpl(variance, type(type));
    }

    private final TypeConstructor typeConstructor(ProtoBuf.Type type) {
        ClassifierDescriptor invoke;
        Object obj;
        if (type.hasClassName()) {
            invoke = this.classifierDescriptors.invoke(Integer.valueOf(type.getClassName()));
            if (invoke == null) {
                invoke = typeConstructor$notFoundClass(this, type, type.getClassName());
            }
        } else if (type.hasTypeParameter()) {
            invoke = loadTypeParameter(type.getTypeParameter());
            if (invoke == null) {
                return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER, String.valueOf(type.getTypeParameter()), this.containerPresentableName);
            }
        } else if (type.hasTypeParameterName()) {
            String string = this.f412762c.getNameResolver().getString(type.getTypeParameterName());
            Iterator<T> it = getOwnTypeParameters().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((TypeParameterDescriptor) obj).getName().asString(), string)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            invoke = (TypeParameterDescriptor) obj;
            if (invoke == null) {
                return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME, string, this.f412762c.getContainingDeclaration().toString());
            }
        } else if (type.hasTypeAliasName()) {
            invoke = this.typeAliasDescriptors.invoke(Integer.valueOf(type.getTypeAliasName()));
            if (invoke == null) {
                invoke = typeConstructor$notFoundClass(this, type, type.getTypeAliasName());
            }
        } else {
            return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.UNKNOWN_TYPE, new String[0]);
        }
        TypeConstructor typeConstructor = invoke.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "classifier.typeConstructor");
        return typeConstructor;
    }

    private static final ClassDescriptor typeConstructor$notFoundClass(final TypeDeserializer typeDeserializer, ProtoBuf.Type type, int i3) {
        Sequence generateSequence;
        Sequence map;
        List<Integer> mutableList;
        Sequence generateSequence2;
        int count;
        ClassId classId = NameResolverUtilKt.getClassId(typeDeserializer.f412762c.getNameResolver(), i3);
        generateSequence = SequencesKt__SequencesKt.generateSequence(type, (Function1<? super ProtoBuf.Type, ? extends ProtoBuf.Type>) ((Function1<? super Object, ? extends Object>) new Function1<ProtoBuf.Type, ProtoBuf.Type>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final ProtoBuf.Type invoke(@NotNull ProtoBuf.Type it) {
                DeserializationContext deserializationContext;
                Intrinsics.checkNotNullParameter(it, "it");
                deserializationContext = TypeDeserializer.this.f412762c;
                return ProtoTypeTableUtilKt.outerType(it, deserializationContext.getTypeTable());
            }
        }));
        map = SequencesKt___SequencesKt.map(generateSequence, new Function1<ProtoBuf.Type, Integer>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Integer invoke(@NotNull ProtoBuf.Type it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.getArgumentCount());
            }
        });
        mutableList = SequencesKt___SequencesKt.toMutableList(map);
        generateSequence2 = SequencesKt__SequencesKt.generateSequence(classId, (Function1<? super ClassId, ? extends ClassId>) ((Function1<? super Object, ? extends Object>) TypeDeserializer$typeConstructor$notFoundClass$classNestingLevel$1.INSTANCE));
        count = SequencesKt___SequencesKt.count(generateSequence2);
        while (mutableList.size() < count) {
            mutableList.add(0);
        }
        return typeDeserializer.f412762c.getComponents().getNotFoundClasses().getClass(classId, mutableList);
    }

    @NotNull
    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        List<TypeParameterDescriptor> list;
        list = CollectionsKt___CollectionsKt.toList(this.typeParameterDescriptors.values());
        return list;
    }

    @NotNull
    public final SimpleType simpleType(@NotNull final ProtoBuf.Type proto, boolean z16) {
        SimpleType simpleType;
        int collectionSizeOrDefault;
        List<? extends TypeProjection> list;
        SimpleType simpleType$default;
        SimpleType withAbbreviation;
        List<? extends AnnotationDescriptor> plus;
        Object orNull;
        Intrinsics.checkNotNullParameter(proto, "proto");
        if (proto.hasClassName()) {
            simpleType = computeLocalClassifierReplacementType(proto.getClassName());
        } else if (proto.hasTypeAliasName()) {
            simpleType = computeLocalClassifierReplacementType(proto.getTypeAliasName());
        } else {
            simpleType = null;
        }
        if (simpleType != null) {
            return simpleType;
        }
        TypeConstructor typeConstructor = typeConstructor(proto);
        boolean z17 = true;
        if (ErrorUtils.isError(typeConstructor.mo1779getDeclarationDescriptor())) {
            return ErrorUtils.INSTANCE.createErrorType(ErrorTypeKind.TYPE_FOR_ERROR_TYPE_CONSTRUCTOR, typeConstructor, typeConstructor.toString());
        }
        DeserializedAnnotations deserializedAnnotations = new DeserializedAnnotations(this.f412762c.getStorageManager(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$simpleType$annotations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends AnnotationDescriptor> invoke() {
                DeserializationContext deserializationContext;
                DeserializationContext deserializationContext2;
                deserializationContext = TypeDeserializer.this.f412762c;
                AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = deserializationContext.getComponents().getAnnotationAndConstantLoader();
                ProtoBuf.Type type = proto;
                deserializationContext2 = TypeDeserializer.this.f412762c;
                return annotationAndConstantLoader.loadTypeAnnotations(type, deserializationContext2.getNameResolver());
            }
        });
        TypeAttributes attributes = toAttributes(this.f412762c.getComponents().getTypeAttributeTranslators(), deserializedAnnotations, typeConstructor, this.f412762c.getContainingDeclaration());
        List<ProtoBuf.Type.Argument> simpleType$collectAllArguments = simpleType$collectAllArguments(proto, this);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(simpleType$collectAllArguments, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj : simpleType$collectAllArguments) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "constructor.parameters");
            orNull = CollectionsKt___CollectionsKt.getOrNull(parameters, i3);
            arrayList.add(typeArgument((TypeParameterDescriptor) orNull, (ProtoBuf.Type.Argument) obj));
            i3 = i16;
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        ClassifierDescriptor mo1779getDeclarationDescriptor = typeConstructor.mo1779getDeclarationDescriptor();
        if (z16 && (mo1779getDeclarationDescriptor instanceof TypeAliasDescriptor)) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            SimpleType computeExpandedType = KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) mo1779getDeclarationDescriptor, list);
            List<TypeAttributeTranslator> typeAttributeTranslators = this.f412762c.getComponents().getTypeAttributeTranslators();
            Annotations.Companion companion = Annotations.Companion;
            plus = CollectionsKt___CollectionsKt.plus((Iterable) deserializedAnnotations, (Iterable) computeExpandedType.getAnnotations());
            TypeAttributes attributes2 = toAttributes(typeAttributeTranslators, companion.create(plus), typeConstructor, this.f412762c.getContainingDeclaration());
            if (!KotlinTypeKt.isNullable(computeExpandedType) && !proto.getNullable()) {
                z17 = false;
            }
            simpleType$default = computeExpandedType.makeNullableAsSpecified(z17).replaceAttributes(attributes2);
        } else {
            Boolean bool = Flags.SUSPEND_TYPE.get(proto.getFlags());
            Intrinsics.checkNotNullExpressionValue(bool, "SUSPEND_TYPE.get(proto.flags)");
            if (bool.booleanValue()) {
                simpleType$default = createSuspendFunctionType(attributes, typeConstructor, list, proto.getNullable());
            } else {
                simpleType$default = KotlinTypeFactory.simpleType$default(attributes, typeConstructor, list, proto.getNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
                Boolean bool2 = Flags.DEFINITELY_NOT_NULL_TYPE.get(proto.getFlags());
                Intrinsics.checkNotNullExpressionValue(bool2, "DEFINITELY_NOT_NULL_TYPE.get(proto.flags)");
                if (bool2.booleanValue()) {
                    DefinitelyNotNullType makeDefinitelyNotNull$default = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, simpleType$default, false, 2, null);
                    if (makeDefinitelyNotNull$default != null) {
                        simpleType$default = makeDefinitelyNotNull$default;
                    } else {
                        throw new IllegalStateException(("null DefinitelyNotNullType for '" + simpleType$default + '\'').toString());
                    }
                }
            }
        }
        ProtoBuf.Type abbreviatedType = ProtoTypeTableUtilKt.abbreviatedType(proto, this.f412762c.getTypeTable());
        if (abbreviatedType != null && (withAbbreviation = SpecialTypesKt.withAbbreviation(simpleType$default, simpleType(abbreviatedType, false))) != null) {
            simpleType$default = withAbbreviation;
        }
        if (proto.hasClassName()) {
            return this.f412762c.getComponents().getPlatformDependentTypeTransformer().transformPlatformType(NameResolverUtilKt.getClassId(this.f412762c.getNameResolver(), proto.getClassName()), simpleType$default);
        }
        return simpleType$default;
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.debugName);
        if (this.parent == null) {
            str = "";
        } else {
            str = ". Child of " + this.parent.debugName;
        }
        sb5.append(str);
        return sb5.toString();
    }

    @NotNull
    public final KotlinType type(@NotNull ProtoBuf.Type proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        if (proto.hasFlexibleTypeCapabilitiesId()) {
            String string = this.f412762c.getNameResolver().getString(proto.getFlexibleTypeCapabilitiesId());
            SimpleType simpleType$default = simpleType$default(this, proto, false, 2, null);
            ProtoBuf.Type flexibleUpperBound = ProtoTypeTableUtilKt.flexibleUpperBound(proto, this.f412762c.getTypeTable());
            Intrinsics.checkNotNull(flexibleUpperBound);
            return this.f412762c.getComponents().getFlexibleTypeDeserializer().create(proto, string, simpleType$default, simpleType$default(this, flexibleUpperBound, false, 2, null));
        }
        return simpleType(proto, true);
    }
}
