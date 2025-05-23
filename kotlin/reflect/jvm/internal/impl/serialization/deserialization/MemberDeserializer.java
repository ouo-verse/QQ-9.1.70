package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class MemberDeserializer {

    @NotNull
    private final AnnotationDeserializer annotationDeserializer;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final DeserializationContext f412761c;

    public MemberDeserializer(@NotNull DeserializationContext c16) {
        Intrinsics.checkNotNullParameter(c16, "c");
        this.f412761c = c16;
        this.annotationDeserializer = new AnnotationDeserializer(c16.getComponents().getModuleDescriptor(), c16.getComponents().getNotFoundClasses());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProtoContainer asProtoContainer(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            return new ProtoContainer.Package(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), this.f412761c.getNameResolver(), this.f412761c.getTypeTable(), this.f412761c.getContainerSource());
        }
        if (declarationDescriptor instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) declarationDescriptor).getThisAsProtoContainer$deserialization();
        }
        return null;
    }

    private final Annotations getAnnotations(final MessageLite messageLite, int i3, final AnnotatedCallableKind annotatedCallableKind) {
        if (!Flags.HAS_ANNOTATIONS.get(i3).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.f412761c.getStorageManager(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$getAnnotations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends AnnotationDescriptor> invoke() {
                DeserializationContext deserializationContext;
                ProtoContainer asProtoContainer;
                List<? extends AnnotationDescriptor> list;
                List<? extends AnnotationDescriptor> emptyList;
                DeserializationContext deserializationContext2;
                MemberDeserializer memberDeserializer = MemberDeserializer.this;
                deserializationContext = memberDeserializer.f412761c;
                asProtoContainer = memberDeserializer.asProtoContainer(deserializationContext.getContainingDeclaration());
                if (asProtoContainer != null) {
                    MemberDeserializer memberDeserializer2 = MemberDeserializer.this;
                    MessageLite messageLite2 = messageLite;
                    AnnotatedCallableKind annotatedCallableKind2 = annotatedCallableKind;
                    deserializationContext2 = memberDeserializer2.f412761c;
                    list = CollectionsKt___CollectionsKt.toList(deserializationContext2.getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(asProtoContainer, messageLite2, annotatedCallableKind2));
                } else {
                    list = null;
                }
                if (list != null) {
                    return list;
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
        });
    }

    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        ClassDescriptor classDescriptor;
        DeclarationDescriptor containingDeclaration = this.f412761c.getContainingDeclaration();
        if (containingDeclaration instanceof ClassDescriptor) {
            classDescriptor = (ClassDescriptor) containingDeclaration;
        } else {
            classDescriptor = null;
        }
        if (classDescriptor == null) {
            return null;
        }
        return classDescriptor.getThisAsReceiverParameter();
    }

    private final Annotations getPropertyFieldAnnotations(final ProtoBuf.Property property, final boolean z16) {
        if (!Flags.HAS_ANNOTATIONS.get(property.getFlags()).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.f412761c.getStorageManager(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$getPropertyFieldAnnotations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends AnnotationDescriptor> invoke() {
                DeserializationContext deserializationContext;
                ProtoContainer asProtoContainer;
                List<? extends AnnotationDescriptor> list;
                List<? extends AnnotationDescriptor> emptyList;
                DeserializationContext deserializationContext2;
                DeserializationContext deserializationContext3;
                MemberDeserializer memberDeserializer = MemberDeserializer.this;
                deserializationContext = memberDeserializer.f412761c;
                asProtoContainer = memberDeserializer.asProtoContainer(deserializationContext.getContainingDeclaration());
                if (asProtoContainer != null) {
                    boolean z17 = z16;
                    MemberDeserializer memberDeserializer2 = MemberDeserializer.this;
                    ProtoBuf.Property property2 = property;
                    if (z17) {
                        deserializationContext3 = memberDeserializer2.f412761c;
                        list = CollectionsKt___CollectionsKt.toList(deserializationContext3.getComponents().getAnnotationAndConstantLoader().loadPropertyDelegateFieldAnnotations(asProtoContainer, property2));
                    } else {
                        deserializationContext2 = memberDeserializer2.f412761c;
                        list = CollectionsKt___CollectionsKt.toList(deserializationContext2.getComponents().getAnnotationAndConstantLoader().loadPropertyBackingFieldAnnotations(asProtoContainer, property2));
                    }
                } else {
                    list = null;
                }
                if (list != null) {
                    return list;
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
        });
    }

    private final Annotations getReceiverParameterAnnotations(final MessageLite messageLite, final AnnotatedCallableKind annotatedCallableKind) {
        return new DeserializedAnnotations(this.f412761c.getStorageManager(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$getReceiverParameterAnnotations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends AnnotationDescriptor> invoke() {
                DeserializationContext deserializationContext;
                ProtoContainer asProtoContainer;
                List<AnnotationDescriptor> list;
                List<? extends AnnotationDescriptor> emptyList;
                DeserializationContext deserializationContext2;
                MemberDeserializer memberDeserializer = MemberDeserializer.this;
                deserializationContext = memberDeserializer.f412761c;
                asProtoContainer = memberDeserializer.asProtoContainer(deserializationContext.getContainingDeclaration());
                if (asProtoContainer != null) {
                    MemberDeserializer memberDeserializer2 = MemberDeserializer.this;
                    MessageLite messageLite2 = messageLite;
                    AnnotatedCallableKind annotatedCallableKind2 = annotatedCallableKind;
                    deserializationContext2 = memberDeserializer2.f412761c;
                    list = deserializationContext2.getComponents().getAnnotationAndConstantLoader().loadExtensionReceiverParameterAnnotations(asProtoContainer, messageLite2, annotatedCallableKind2);
                } else {
                    list = null;
                }
                if (list != null) {
                    return list;
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
        });
    }

    private final void initializeWithCoroutinesExperimentalityStatus(DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends ReceiverParameterDescriptor> list, List<? extends TypeParameterDescriptor> list2, List<? extends ValueParameterDescriptor> list3, KotlinType kotlinType, Modality modality, DescriptorVisibility descriptorVisibility, Map<? extends CallableDescriptor.UserDataKey<?>, ?> map) {
        deserializedSimpleFunctionDescriptor.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, list3, kotlinType, modality, descriptorVisibility, map);
    }

    private final int loadOldFlags(int i3) {
        return (i3 & 63) + ((i3 >> 8) << 6);
    }

    private final ReceiverParameterDescriptor toContextReceiver(ProtoBuf.Type type, DeserializationContext deserializationContext, CallableDescriptor callableDescriptor) {
        return DescriptorFactory.createContextReceiverParameterForCallable(callableDescriptor, deserializationContext.getTypeDeserializer().type(type), Annotations.Companion.getEMPTY());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<ValueParameterDescriptor> valueParameters(List<ProtoBuf.ValueParameter> list, final MessageLite messageLite, final AnnotatedCallableKind annotatedCallableKind) {
        int collectionSizeOrDefault;
        List<ValueParameterDescriptor> list2;
        int i3;
        Annotations empty;
        ProtoBuf.Type varargElementType;
        KotlinType kotlinType;
        DeclarationDescriptor containingDeclaration = this.f412761c.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        CallableDescriptor callableDescriptor = (CallableDescriptor) containingDeclaration;
        DeclarationDescriptor containingDeclaration2 = callableDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "callableDescriptor.containingDeclaration");
        final ProtoContainer asProtoContainer = asProtoContainer(containingDeclaration2);
        List<ProtoBuf.ValueParameter> list3 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i16 = 0;
        for (Object obj : list3) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            final ProtoBuf.ValueParameter valueParameter = (ProtoBuf.ValueParameter) obj;
            if (valueParameter.hasFlags()) {
                i3 = valueParameter.getFlags();
            } else {
                i3 = 0;
            }
            if (asProtoContainer != null) {
                Boolean bool = Flags.HAS_ANNOTATIONS.get(i3);
                Intrinsics.checkNotNullExpressionValue(bool, "HAS_ANNOTATIONS.get(flags)");
                if (bool.booleanValue()) {
                    final int i18 = i16;
                    empty = new NonEmptyDeserializedAnnotations(this.f412761c.getStorageManager(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$valueParameters$1$annotations$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final List<? extends AnnotationDescriptor> invoke() {
                            DeserializationContext deserializationContext;
                            List<? extends AnnotationDescriptor> list4;
                            deserializationContext = MemberDeserializer.this.f412761c;
                            list4 = CollectionsKt___CollectionsKt.toList(deserializationContext.getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(asProtoContainer, messageLite, annotatedCallableKind, i18, valueParameter));
                            return list4;
                        }
                    });
                    Name name = NameResolverUtilKt.getName(this.f412761c.getNameResolver(), valueParameter.getName());
                    KotlinType type = this.f412761c.getTypeDeserializer().type(ProtoTypeTableUtilKt.type(valueParameter, this.f412761c.getTypeTable()));
                    Boolean bool2 = Flags.DECLARES_DEFAULT_VALUE.get(i3);
                    Intrinsics.checkNotNullExpressionValue(bool2, "DECLARES_DEFAULT_VALUE.get(flags)");
                    boolean booleanValue = bool2.booleanValue();
                    Boolean bool3 = Flags.IS_CROSSINLINE.get(i3);
                    Intrinsics.checkNotNullExpressionValue(bool3, "IS_CROSSINLINE.get(flags)");
                    boolean booleanValue2 = bool3.booleanValue();
                    Boolean bool4 = Flags.IS_NOINLINE.get(i3);
                    Intrinsics.checkNotNullExpressionValue(bool4, "IS_NOINLINE.get(flags)");
                    boolean booleanValue3 = bool4.booleanValue();
                    varargElementType = ProtoTypeTableUtilKt.varargElementType(valueParameter, this.f412761c.getTypeTable());
                    if (varargElementType == null) {
                        kotlinType = this.f412761c.getTypeDeserializer().type(varargElementType);
                    } else {
                        kotlinType = null;
                    }
                    KotlinType kotlinType2 = kotlinType;
                    SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
                    Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
                    ArrayList arrayList2 = arrayList;
                    arrayList2.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i16, empty, name, type, booleanValue, booleanValue2, booleanValue3, kotlinType2, NO_SOURCE));
                    arrayList = arrayList2;
                    i16 = i17;
                }
            }
            empty = Annotations.Companion.getEMPTY();
            Name name2 = NameResolverUtilKt.getName(this.f412761c.getNameResolver(), valueParameter.getName());
            KotlinType type2 = this.f412761c.getTypeDeserializer().type(ProtoTypeTableUtilKt.type(valueParameter, this.f412761c.getTypeTable()));
            Boolean bool22 = Flags.DECLARES_DEFAULT_VALUE.get(i3);
            Intrinsics.checkNotNullExpressionValue(bool22, "DECLARES_DEFAULT_VALUE.get(flags)");
            boolean booleanValue4 = bool22.booleanValue();
            Boolean bool32 = Flags.IS_CROSSINLINE.get(i3);
            Intrinsics.checkNotNullExpressionValue(bool32, "IS_CROSSINLINE.get(flags)");
            boolean booleanValue22 = bool32.booleanValue();
            Boolean bool42 = Flags.IS_NOINLINE.get(i3);
            Intrinsics.checkNotNullExpressionValue(bool42, "IS_NOINLINE.get(flags)");
            boolean booleanValue32 = bool42.booleanValue();
            varargElementType = ProtoTypeTableUtilKt.varargElementType(valueParameter, this.f412761c.getTypeTable());
            if (varargElementType == null) {
            }
            KotlinType kotlinType22 = kotlinType;
            SourceElement NO_SOURCE2 = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(NO_SOURCE2, "NO_SOURCE");
            ArrayList arrayList22 = arrayList;
            arrayList22.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i16, empty, name2, type2, booleanValue4, booleanValue22, booleanValue32, kotlinType22, NO_SOURCE2));
            arrayList = arrayList22;
            i16 = i17;
        }
        list2 = CollectionsKt___CollectionsKt.toList(arrayList);
        return list2;
    }

    @NotNull
    public final ClassConstructorDescriptor loadConstructor(@NotNull ProtoBuf.Constructor proto, boolean z16) {
        List emptyList;
        Intrinsics.checkNotNullParameter(proto, "proto");
        DeclarationDescriptor containingDeclaration = this.f412761c.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        int flags = proto.getFlags();
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor = new DeserializedClassConstructorDescriptor(classDescriptor, null, getAnnotations(proto, flags, annotatedCallableKind), z16, CallableMemberDescriptor.Kind.DECLARATION, proto, this.f412761c.getNameResolver(), this.f412761c.getTypeTable(), this.f412761c.getVersionRequirementTable(), this.f412761c.getContainerSource(), null, 1024, null);
        DeserializationContext deserializationContext = this.f412761c;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        MemberDeserializer memberDeserializer = DeserializationContext.childContext$default(deserializationContext, deserializedClassConstructorDescriptor, emptyList, null, null, null, null, 60, null).getMemberDeserializer();
        List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
        deserializedClassConstructorDescriptor.initialize(memberDeserializer.valueParameters(valueParameterList, proto, annotatedCallableKind), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(proto.getFlags())));
        deserializedClassConstructorDescriptor.setReturnType(classDescriptor.getDefaultType());
        deserializedClassConstructorDescriptor.setExpect(classDescriptor.isExpect());
        deserializedClassConstructorDescriptor.setHasStableParameterNames(!Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.get(proto.getFlags()).booleanValue());
        return deserializedClassConstructorDescriptor;
    }

    @NotNull
    public final SimpleFunctionDescriptor loadFunction(@NotNull ProtoBuf.Function proto) {
        int loadOldFlags;
        Annotations empty;
        VersionRequirementTable versionRequirementTable;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        Map<? extends CallableDescriptor.UserDataKey<?>, ?> emptyMap;
        KotlinType type;
        Intrinsics.checkNotNullParameter(proto, "proto");
        if (proto.hasFlags()) {
            loadOldFlags = proto.getFlags();
        } else {
            loadOldFlags = loadOldFlags(proto.getOldFlags());
        }
        int i3 = loadOldFlags;
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        Annotations annotations = getAnnotations(proto, i3, annotatedCallableKind);
        if (ProtoTypeTableUtilKt.hasReceiver(proto)) {
            empty = getReceiverParameterAnnotations(proto, annotatedCallableKind);
        } else {
            empty = Annotations.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(this.f412761c.getContainingDeclaration()).child(NameResolverUtilKt.getName(this.f412761c.getNameResolver(), proto.getName())), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            versionRequirementTable = VersionRequirementTable.Companion.getEMPTY();
        } else {
            versionRequirementTable = this.f412761c.getVersionRequirementTable();
        }
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = new DeserializedSimpleFunctionDescriptor(this.f412761c.getContainingDeclaration(), null, annotations, NameResolverUtilKt.getName(this.f412761c.getNameResolver(), proto.getName()), ProtoEnumFlagsUtilsKt.memberKind(ProtoEnumFlags.INSTANCE, Flags.MEMBER_KIND.get(i3)), proto, this.f412761c.getNameResolver(), this.f412761c.getTypeTable(), versionRequirementTable, this.f412761c.getContainerSource(), null, 1024, null);
        DeserializationContext deserializationContext = this.f412761c;
        List<ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedSimpleFunctionDescriptor, typeParameterList, null, null, null, null, 60, null);
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(proto, this.f412761c.getTypeTable());
        if (receiverType != null && (type = childContext$default.getTypeDeserializer().type(receiverType)) != null) {
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedSimpleFunctionDescriptor, type, empty);
        } else {
            receiverParameterDescriptor = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = receiverParameterDescriptor;
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        List<ProtoBuf.Type> contextReceiverTypes = ProtoTypeTableUtilKt.contextReceiverTypes(proto, this.f412761c.getTypeTable());
        List<? extends ReceiverParameterDescriptor> arrayList = new ArrayList<>();
        Iterator<T> it = contextReceiverTypes.iterator();
        while (it.hasNext()) {
            ReceiverParameterDescriptor contextReceiver = toContextReceiver((ProtoBuf.Type) it.next(), childContext$default, deserializedSimpleFunctionDescriptor);
            if (contextReceiver != null) {
                arrayList.add(contextReceiver);
            }
        }
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        MemberDeserializer memberDeserializer = childContext$default.getMemberDeserializer();
        List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
        List<ValueParameterDescriptor> valueParameters = memberDeserializer.valueParameters(valueParameterList, proto, AnnotatedCallableKind.FUNCTION);
        KotlinType type2 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(proto, this.f412761c.getTypeTable()));
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        Modality modality = protoEnumFlags.modality(Flags.MODALITY.get(i3));
        DescriptorVisibility descriptorVisibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags, Flags.VISIBILITY.get(i3));
        emptyMap = MapsKt__MapsKt.emptyMap();
        initializeWithCoroutinesExperimentalityStatus(deserializedSimpleFunctionDescriptor, receiverParameterDescriptor2, dispatchReceiverParameter, arrayList, ownTypeParameters, valueParameters, type2, modality, descriptorVisibility, emptyMap);
        Boolean bool = Flags.IS_OPERATOR.get(i3);
        Intrinsics.checkNotNullExpressionValue(bool, "IS_OPERATOR.get(flags)");
        deserializedSimpleFunctionDescriptor.setOperator(bool.booleanValue());
        Boolean bool2 = Flags.IS_INFIX.get(i3);
        Intrinsics.checkNotNullExpressionValue(bool2, "IS_INFIX.get(flags)");
        deserializedSimpleFunctionDescriptor.setInfix(bool2.booleanValue());
        Boolean bool3 = Flags.IS_EXTERNAL_FUNCTION.get(i3);
        Intrinsics.checkNotNullExpressionValue(bool3, "IS_EXTERNAL_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor.setExternal(bool3.booleanValue());
        Boolean bool4 = Flags.IS_INLINE.get(i3);
        Intrinsics.checkNotNullExpressionValue(bool4, "IS_INLINE.get(flags)");
        deserializedSimpleFunctionDescriptor.setInline(bool4.booleanValue());
        Boolean bool5 = Flags.IS_TAILREC.get(i3);
        Intrinsics.checkNotNullExpressionValue(bool5, "IS_TAILREC.get(flags)");
        deserializedSimpleFunctionDescriptor.setTailrec(bool5.booleanValue());
        Boolean bool6 = Flags.IS_SUSPEND.get(i3);
        Intrinsics.checkNotNullExpressionValue(bool6, "IS_SUSPEND.get(flags)");
        deserializedSimpleFunctionDescriptor.setSuspend(bool6.booleanValue());
        Boolean bool7 = Flags.IS_EXPECT_FUNCTION.get(i3);
        Intrinsics.checkNotNullExpressionValue(bool7, "IS_EXPECT_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor.setExpect(bool7.booleanValue());
        deserializedSimpleFunctionDescriptor.setHasStableParameterNames(!Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.get(i3).booleanValue());
        Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction = this.f412761c.getComponents().getContractDeserializer().deserializeContractFromFunction(proto, deserializedSimpleFunctionDescriptor, this.f412761c.getTypeTable(), childContext$default.getTypeDeserializer());
        if (deserializeContractFromFunction != null) {
            deserializedSimpleFunctionDescriptor.putInUserDataMap(deserializeContractFromFunction.getFirst(), deserializeContractFromFunction.getSecond());
        }
        return deserializedSimpleFunctionDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final PropertyDescriptor loadProperty(@NotNull ProtoBuf.Property proto) {
        int loadOldFlags;
        ProtoBuf.Property property;
        Annotations empty;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        int collectionSizeOrDefault;
        Flags.FlagField<ProtoBuf.Visibility> flagField;
        DeserializationContext deserializationContext;
        Flags.FlagField<ProtoBuf.Modality> flagField2;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2;
        final DeserializedPropertyDescriptor deserializedPropertyDescriptor2;
        final ProtoBuf.Property property2;
        int i3;
        boolean z16;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        ClassDescriptor classDescriptor;
        List emptyList;
        List<ProtoBuf.ValueParameter> listOf;
        Object single;
        int i16;
        PropertyGetterDescriptorImpl createDefaultGetter;
        KotlinType type;
        Intrinsics.checkNotNullParameter(proto, "proto");
        if (proto.hasFlags()) {
            loadOldFlags = proto.getFlags();
        } else {
            loadOldFlags = loadOldFlags(proto.getOldFlags());
        }
        int i17 = loadOldFlags;
        DeclarationDescriptor containingDeclaration = this.f412761c.getContainingDeclaration();
        Annotations annotations = getAnnotations(proto, i17, AnnotatedCallableKind.PROPERTY);
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        Modality modality = protoEnumFlags.modality(Flags.MODALITY.get(i17));
        DescriptorVisibility descriptorVisibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags, Flags.VISIBILITY.get(i17));
        Boolean bool = Flags.IS_VAR.get(i17);
        Intrinsics.checkNotNullExpressionValue(bool, "IS_VAR.get(flags)");
        boolean booleanValue = bool.booleanValue();
        Name name = NameResolverUtilKt.getName(this.f412761c.getNameResolver(), proto.getName());
        CallableMemberDescriptor.Kind memberKind = ProtoEnumFlagsUtilsKt.memberKind(protoEnumFlags, Flags.MEMBER_KIND.get(i17));
        Boolean bool2 = Flags.IS_LATEINIT.get(i17);
        Intrinsics.checkNotNullExpressionValue(bool2, "IS_LATEINIT.get(flags)");
        boolean booleanValue2 = bool2.booleanValue();
        Boolean bool3 = Flags.IS_CONST.get(i17);
        Intrinsics.checkNotNullExpressionValue(bool3, "IS_CONST.get(flags)");
        boolean booleanValue3 = bool3.booleanValue();
        Boolean bool4 = Flags.IS_EXTERNAL_PROPERTY.get(i17);
        Intrinsics.checkNotNullExpressionValue(bool4, "IS_EXTERNAL_PROPERTY.get(flags)");
        boolean booleanValue4 = bool4.booleanValue();
        Boolean bool5 = Flags.IS_DELEGATED.get(i17);
        Intrinsics.checkNotNullExpressionValue(bool5, "IS_DELEGATED.get(flags)");
        boolean booleanValue5 = bool5.booleanValue();
        Boolean bool6 = Flags.IS_EXPECT_PROPERTY.get(i17);
        Intrinsics.checkNotNullExpressionValue(bool6, "IS_EXPECT_PROPERTY.get(flags)");
        DeserializedPropertyDescriptor deserializedPropertyDescriptor3 = new DeserializedPropertyDescriptor(containingDeclaration, null, annotations, modality, descriptorVisibility, booleanValue, name, memberKind, booleanValue2, booleanValue3, booleanValue4, booleanValue5, bool6.booleanValue(), proto, this.f412761c.getNameResolver(), this.f412761c.getTypeTable(), this.f412761c.getVersionRequirementTable(), this.f412761c.getContainerSource());
        DeserializationContext deserializationContext2 = this.f412761c;
        List<ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext2, deserializedPropertyDescriptor3, typeParameterList, null, null, null, null, 60, null);
        Boolean bool7 = Flags.HAS_GETTER.get(i17);
        Intrinsics.checkNotNullExpressionValue(bool7, "HAS_GETTER.get(flags)");
        boolean booleanValue6 = bool7.booleanValue();
        if (booleanValue6 && ProtoTypeTableUtilKt.hasReceiver(proto)) {
            property = proto;
            empty = getReceiverParameterAnnotations(property, AnnotatedCallableKind.PROPERTY_GETTER);
        } else {
            property = proto;
            empty = Annotations.Companion.getEMPTY();
        }
        KotlinType type2 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(property, this.f412761c.getTypeTable()));
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(property, this.f412761c.getTypeTable());
        ClassKind classKind = null;
        if (receiverType != null && (type = childContext$default.getTypeDeserializer().type(receiverType)) != null) {
            deserializedPropertyDescriptor = deserializedPropertyDescriptor3;
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedPropertyDescriptor, type, empty);
        } else {
            deserializedPropertyDescriptor = deserializedPropertyDescriptor3;
            receiverParameterDescriptor = null;
        }
        List<ProtoBuf.Type> contextReceiverTypes = ProtoTypeTableUtilKt.contextReceiverTypes(property, this.f412761c.getTypeTable());
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(contextReceiverTypes, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = contextReceiverTypes.iterator();
        while (it.hasNext()) {
            arrayList.add(toContextReceiver((ProtoBuf.Type) it.next(), childContext$default, deserializedPropertyDescriptor));
        }
        deserializedPropertyDescriptor.setType(type2, ownTypeParameters, dispatchReceiverParameter, receiverParameterDescriptor, arrayList);
        Boolean bool8 = Flags.HAS_ANNOTATIONS.get(i17);
        Intrinsics.checkNotNullExpressionValue(bool8, "HAS_ANNOTATIONS.get(flags)");
        boolean booleanValue7 = bool8.booleanValue();
        Flags.FlagField<ProtoBuf.Visibility> flagField3 = Flags.VISIBILITY;
        ProtoBuf.Visibility visibility = flagField3.get(i17);
        Flags.FlagField<ProtoBuf.Modality> flagField4 = Flags.MODALITY;
        int accessorFlags = Flags.getAccessorFlags(booleanValue7, visibility, flagField4.get(i17), false, false, false);
        if (booleanValue6) {
            if (proto.hasGetterFlags()) {
                i16 = proto.getGetterFlags();
            } else {
                i16 = accessorFlags;
            }
            Boolean bool9 = Flags.IS_NOT_DEFAULT.get(i16);
            Intrinsics.checkNotNullExpressionValue(bool9, "IS_NOT_DEFAULT.get(getterFlags)");
            boolean booleanValue8 = bool9.booleanValue();
            Boolean bool10 = Flags.IS_EXTERNAL_ACCESSOR.get(i16);
            Intrinsics.checkNotNullExpressionValue(bool10, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean booleanValue9 = bool10.booleanValue();
            Boolean bool11 = Flags.IS_INLINE_ACCESSOR.get(i16);
            Intrinsics.checkNotNullExpressionValue(bool11, "IS_INLINE_ACCESSOR.get(getterFlags)");
            boolean booleanValue10 = bool11.booleanValue();
            Annotations annotations2 = getAnnotations(property, i16, AnnotatedCallableKind.PROPERTY_GETTER);
            if (booleanValue8) {
                ProtoEnumFlags protoEnumFlags2 = ProtoEnumFlags.INSTANCE;
                deserializationContext = childContext$default;
                flagField2 = flagField4;
                flagField = flagField3;
                createDefaultGetter = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor, annotations2, protoEnumFlags2.modality(flagField4.get(i16)), ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags2, flagField3.get(i16)), !booleanValue8, booleanValue9, booleanValue10, deserializedPropertyDescriptor.getKind(), null, SourceElement.NO_SOURCE);
            } else {
                flagField = flagField3;
                deserializationContext = childContext$default;
                flagField2 = flagField4;
                createDefaultGetter = DescriptorFactory.createDefaultGetter(deserializedPropertyDescriptor, annotations2);
                Intrinsics.checkNotNullExpressionValue(createDefaultGetter, "{\n                Descri\u2026nnotations)\n            }");
            }
            createDefaultGetter.initialize(deserializedPropertyDescriptor.getReturnType());
            propertyGetterDescriptorImpl = createDefaultGetter;
        } else {
            flagField = flagField3;
            deserializationContext = childContext$default;
            flagField2 = flagField4;
            propertyGetterDescriptorImpl = null;
        }
        Boolean bool12 = Flags.HAS_SETTER.get(i17);
        Intrinsics.checkNotNullExpressionValue(bool12, "HAS_SETTER.get(flags)");
        if (bool12.booleanValue()) {
            if (proto.hasSetterFlags()) {
                accessorFlags = proto.getSetterFlags();
            }
            int i18 = accessorFlags;
            Boolean bool13 = Flags.IS_NOT_DEFAULT.get(i18);
            Intrinsics.checkNotNullExpressionValue(bool13, "IS_NOT_DEFAULT.get(setterFlags)");
            boolean booleanValue11 = bool13.booleanValue();
            Boolean bool14 = Flags.IS_EXTERNAL_ACCESSOR.get(i18);
            Intrinsics.checkNotNullExpressionValue(bool14, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean booleanValue12 = bool14.booleanValue();
            Boolean bool15 = Flags.IS_INLINE_ACCESSOR.get(i18);
            Intrinsics.checkNotNullExpressionValue(bool15, "IS_INLINE_ACCESSOR.get(setterFlags)");
            boolean booleanValue13 = bool15.booleanValue();
            AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.PROPERTY_SETTER;
            Annotations annotations3 = getAnnotations(property, i18, annotatedCallableKind);
            if (booleanValue11) {
                ProtoEnumFlags protoEnumFlags3 = ProtoEnumFlags.INSTANCE;
                propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl;
                PropertySetterDescriptorImpl propertySetterDescriptorImpl2 = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor, annotations3, protoEnumFlags3.modality(flagField2.get(i18)), ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags3, flagField.get(i18)), !booleanValue11, booleanValue12, booleanValue13, deserializedPropertyDescriptor.getKind(), null, SourceElement.NO_SOURCE);
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                z16 = true;
                deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
                property2 = property;
                i3 = i17;
                MemberDeserializer memberDeserializer = DeserializationContext.childContext$default(deserializationContext, propertySetterDescriptorImpl2, emptyList, null, null, null, null, 60, null).getMemberDeserializer();
                listOf = CollectionsKt__CollectionsJVMKt.listOf(proto.getSetterValueParameter());
                single = CollectionsKt___CollectionsKt.single((List<? extends Object>) memberDeserializer.valueParameters(listOf, property2, annotatedCallableKind));
                propertySetterDescriptorImpl2.initialize((ValueParameterDescriptor) single);
                propertySetterDescriptorImpl = propertySetterDescriptorImpl2;
            } else {
                propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl;
                DeserializedPropertyDescriptor deserializedPropertyDescriptor4 = deserializedPropertyDescriptor;
                property2 = property;
                i3 = i17;
                z16 = true;
                propertySetterDescriptorImpl = DescriptorFactory.createDefaultSetter(deserializedPropertyDescriptor4, annotations3, Annotations.Companion.getEMPTY());
                Intrinsics.checkNotNullExpressionValue(propertySetterDescriptorImpl, "{\n                Descri\u2026          )\n            }");
                deserializedPropertyDescriptor2 = deserializedPropertyDescriptor4;
            }
        } else {
            propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl;
            deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
            property2 = property;
            i3 = i17;
            z16 = true;
            propertySetterDescriptorImpl = null;
        }
        Boolean bool16 = Flags.HAS_CONSTANT.get(i3);
        Intrinsics.checkNotNullExpressionValue(bool16, "HAS_CONSTANT.get(flags)");
        if (bool16.booleanValue()) {
            deserializedPropertyDescriptor2.setCompileTimeInitializerFactory(new Function0<NullableLazyValue<? extends ConstantValue<?>>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$loadProperty$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final NullableLazyValue<? extends ConstantValue<?>> invoke() {
                    DeserializationContext deserializationContext3;
                    deserializationContext3 = MemberDeserializer.this.f412761c;
                    StorageManager storageManager = deserializationContext3.getStorageManager();
                    final MemberDeserializer memberDeserializer2 = MemberDeserializer.this;
                    final ProtoBuf.Property property3 = property2;
                    final DeserializedPropertyDescriptor deserializedPropertyDescriptor5 = deserializedPropertyDescriptor2;
                    return storageManager.createNullableLazyValue(new Function0<ConstantValue<?>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$loadProperty$4.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final ConstantValue<?> invoke() {
                            DeserializationContext deserializationContext4;
                            ProtoContainer asProtoContainer;
                            DeserializationContext deserializationContext5;
                            MemberDeserializer memberDeserializer3 = MemberDeserializer.this;
                            deserializationContext4 = memberDeserializer3.f412761c;
                            asProtoContainer = memberDeserializer3.asProtoContainer(deserializationContext4.getContainingDeclaration());
                            Intrinsics.checkNotNull(asProtoContainer);
                            deserializationContext5 = MemberDeserializer.this.f412761c;
                            AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = deserializationContext5.getComponents().getAnnotationAndConstantLoader();
                            ProtoBuf.Property property4 = property3;
                            KotlinType returnType = deserializedPropertyDescriptor5.getReturnType();
                            Intrinsics.checkNotNullExpressionValue(returnType, "property.returnType");
                            return annotationAndConstantLoader.loadPropertyConstant(asProtoContainer, property4, returnType);
                        }
                    });
                }
            });
        }
        DeclarationDescriptor containingDeclaration2 = this.f412761c.getContainingDeclaration();
        if (containingDeclaration2 instanceof ClassDescriptor) {
            classDescriptor = (ClassDescriptor) containingDeclaration2;
        } else {
            classDescriptor = null;
        }
        if (classDescriptor != null) {
            classKind = classDescriptor.getKind();
        }
        if (classKind == ClassKind.ANNOTATION_CLASS) {
            deserializedPropertyDescriptor2.setCompileTimeInitializerFactory(new Function0<NullableLazyValue<? extends ConstantValue<?>>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$loadProperty$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final NullableLazyValue<? extends ConstantValue<?>> invoke() {
                    DeserializationContext deserializationContext3;
                    deserializationContext3 = MemberDeserializer.this.f412761c;
                    StorageManager storageManager = deserializationContext3.getStorageManager();
                    final MemberDeserializer memberDeserializer2 = MemberDeserializer.this;
                    final ProtoBuf.Property property3 = property2;
                    final DeserializedPropertyDescriptor deserializedPropertyDescriptor5 = deserializedPropertyDescriptor2;
                    return storageManager.createNullableLazyValue(new Function0<ConstantValue<?>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$loadProperty$5.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final ConstantValue<?> invoke() {
                            DeserializationContext deserializationContext4;
                            ProtoContainer asProtoContainer;
                            DeserializationContext deserializationContext5;
                            MemberDeserializer memberDeserializer3 = MemberDeserializer.this;
                            deserializationContext4 = memberDeserializer3.f412761c;
                            asProtoContainer = memberDeserializer3.asProtoContainer(deserializationContext4.getContainingDeclaration());
                            Intrinsics.checkNotNull(asProtoContainer);
                            deserializationContext5 = MemberDeserializer.this.f412761c;
                            AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = deserializationContext5.getComponents().getAnnotationAndConstantLoader();
                            ProtoBuf.Property property4 = property3;
                            KotlinType returnType = deserializedPropertyDescriptor5.getReturnType();
                            Intrinsics.checkNotNullExpressionValue(returnType, "property.returnType");
                            return annotationAndConstantLoader.loadAnnotationDefaultValue(asProtoContainer, property4, returnType);
                        }
                    });
                }
            });
        }
        deserializedPropertyDescriptor2.initialize(propertyGetterDescriptorImpl2, propertySetterDescriptorImpl, new FieldDescriptorImpl(getPropertyFieldAnnotations(property2, false), deserializedPropertyDescriptor2), new FieldDescriptorImpl(getPropertyFieldAnnotations(property2, z16), deserializedPropertyDescriptor2));
        return deserializedPropertyDescriptor2;
    }

    @NotNull
    public final TypeAliasDescriptor loadTypeAlias(@NotNull ProtoBuf.TypeAlias proto) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Annotations.Companion companion = Annotations.Companion;
        List<ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(annotationList, "proto.annotationList");
        List<ProtoBuf.Annotation> list = annotationList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ProtoBuf.Annotation it : list) {
            AnnotationDeserializer annotationDeserializer = this.annotationDeserializer;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(annotationDeserializer.deserializeAnnotation(it, this.f412761c.getNameResolver()));
        }
        DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new DeserializedTypeAliasDescriptor(this.f412761c.getStorageManager(), this.f412761c.getContainingDeclaration(), companion.create(arrayList), NameResolverUtilKt.getName(this.f412761c.getNameResolver(), proto.getName()), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(proto.getFlags())), proto, this.f412761c.getNameResolver(), this.f412761c.getTypeTable(), this.f412761c.getVersionRequirementTable(), this.f412761c.getContainerSource());
        DeserializationContext deserializationContext = this.f412761c;
        List<ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedTypeAliasDescriptor, typeParameterList, null, null, null, null, 60, null);
        deserializedTypeAliasDescriptor.initialize(childContext$default.getTypeDeserializer().getOwnTypeParameters(), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.underlyingType(proto, this.f412761c.getTypeTable()), false), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.expandedType(proto, this.f412761c.getTypeTable()), false));
        return deserializedTypeAliasDescriptor;
    }
}
