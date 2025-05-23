package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.AnnotationsContainer;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class AbstractBinaryClassAnnotationLoader<A, S extends AnnotationsContainer<? extends A>> implements AnnotationLoader<A> {

    @NotNull
    private final KotlinClassFinder kotlinClassFinder;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class AnnotationsContainer<A> {
        @NotNull
        public abstract Map<MemberSignature, List<A>> getMemberAnnotations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum PropertyRelatedElement {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            try {
                iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AbstractBinaryClassAnnotationLoader(@NotNull KotlinClassFinder kotlinClassFinder) {
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.kotlinClassFinder = kotlinClassFinder;
    }

    private final int computeJvmParameterIndexShift(ProtoContainer protoContainer, MessageLite messageLite) {
        if (messageLite instanceof ProtoBuf.Function) {
            if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Function) messageLite)) {
                return 1;
            }
        } else if (messageLite instanceof ProtoBuf.Property) {
            if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Property) messageLite)) {
                return 1;
            }
        } else if (messageLite instanceof ProtoBuf.Constructor) {
            Intrinsics.checkNotNull(protoContainer, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
            ProtoContainer.Class r46 = (ProtoContainer.Class) protoContainer;
            if (r46.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS) {
                return 2;
            }
            if (r46.isInner()) {
                return 1;
            }
        } else {
            throw new UnsupportedOperationException("Unsupported message: " + messageLite.getClass());
        }
        return 0;
    }

    private final List<A> findClassAndLoadMemberAnnotations(ProtoContainer protoContainer, MemberSignature memberSignature, boolean z16, boolean z17, Boolean bool, boolean z18) {
        List<A> emptyList;
        List<A> emptyList2;
        KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers = findClassWithAnnotationsAndInitializers(protoContainer, getSpecialCaseContainerClass(protoContainer, z16, z17, bool, z18));
        if (findClassWithAnnotationsAndInitializers == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        List<A> list = getAnnotationsContainer(findClassWithAnnotationsAndInitializers).getMemberAnnotations().get(memberSignature);
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    static /* synthetic */ List findClassAndLoadMemberAnnotations$default(AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, ProtoContainer protoContainer, MemberSignature memberSignature, boolean z16, boolean z17, Boolean bool, boolean z18, int i3, Object obj) {
        boolean z19;
        boolean z26;
        Boolean bool2;
        boolean z27;
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z19 = false;
            } else {
                z19 = z16;
            }
            if ((i3 & 8) != 0) {
                z26 = false;
            } else {
                z26 = z17;
            }
            if ((i3 & 16) != 0) {
                bool2 = null;
            } else {
                bool2 = bool;
            }
            if ((i3 & 32) != 0) {
                z27 = false;
            } else {
                z27 = z18;
            }
            return abstractBinaryClassAnnotationLoader.findClassAndLoadMemberAnnotations(protoContainer, memberSignature, z19, z26, bool2, z27);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    public static /* synthetic */ MemberSignature getCallableSignature$default(AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 16) != 0) {
                z16 = false;
            }
            return abstractBinaryClassAnnotationLoader.getCallableSignature(messageLite, nameResolver, typeTable, annotatedCallableKind, z16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    private final List<A> loadPropertyAnnotations(ProtoContainer protoContainer, ProtoBuf.Property property, PropertyRelatedElement propertyRelatedElement) {
        boolean contains$default;
        List<A> emptyList;
        List<A> emptyList2;
        List<A> emptyList3;
        Boolean bool = Flags.IS_CONST.get(property.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_CONST.get(proto.flags)");
        boolean booleanValue = bool.booleanValue();
        boolean isMovedFromInterfaceCompanion = JvmProtoBufUtil.isMovedFromInterfaceCompanion(property);
        if (propertyRelatedElement == PropertyRelatedElement.PROPERTY) {
            MemberSignature propertySignature$default = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), false, true, false, 40, null);
            if (propertySignature$default == null) {
                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList3;
            }
            return findClassAndLoadMemberAnnotations$default(this, protoContainer, propertySignature$default, true, false, Boolean.valueOf(booleanValue), isMovedFromInterfaceCompanion, 8, null);
        }
        MemberSignature propertySignature$default2 = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), true, false, false, 48, null);
        if (propertySignature$default2 == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        boolean z16 = false;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) propertySignature$default2.getSignature(), (CharSequence) "$delegate", false, 2, (Object) null);
        if (propertyRelatedElement == PropertyRelatedElement.DELEGATE_FIELD) {
            z16 = true;
        }
        if (contains$default != z16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return findClassAndLoadMemberAnnotations(protoContainer, propertySignature$default2, true, true, Boolean.valueOf(booleanValue), isMovedFromInterfaceCompanion);
    }

    private final KotlinJvmBinaryClass toBinaryClass(ProtoContainer.Class r36) {
        KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement;
        SourceElement source = r36.getSource();
        if (source instanceof KotlinJvmBinarySourceElement) {
            kotlinJvmBinarySourceElement = (KotlinJvmBinarySourceElement) source;
        } else {
            kotlinJvmBinarySourceElement = null;
        }
        if (kotlinJvmBinarySourceElement == null) {
            return null;
        }
        return kotlinJvmBinarySourceElement.getBinaryClass();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers(@NotNull ProtoContainer container, @Nullable KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (kotlinJvmBinaryClass == null) {
            if (container instanceof ProtoContainer.Class) {
                return toBinaryClass((ProtoContainer.Class) container);
            }
            return null;
        }
        return kotlinJvmBinaryClass;
    }

    @NotNull
    protected abstract S getAnnotationsContainer(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass);

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public byte[] getCachedFileContent(@NotNull KotlinJvmBinaryClass kotlinClass) {
        Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final MemberSignature getCallableSignature(@NotNull MessageLite proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @NotNull AnnotatedCallableKind kind, boolean z16) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (proto instanceof ProtoBuf.Constructor) {
            MemberSignature.Companion companion = MemberSignature.Companion;
            JvmMemberSignature.Method jvmConstructorSignature = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor) proto, nameResolver, typeTable);
            if (jvmConstructorSignature == null) {
                return null;
            }
            return companion.fromJvmMemberSignature(jvmConstructorSignature);
        }
        if (proto instanceof ProtoBuf.Function) {
            MemberSignature.Companion companion2 = MemberSignature.Companion;
            JvmMemberSignature.Method jvmMethodSignature = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function) proto, nameResolver, typeTable);
            if (jvmMethodSignature == null) {
                return null;
            }
            return companion2.fromJvmMemberSignature(jvmMethodSignature);
        }
        if (!(proto instanceof ProtoBuf.Property)) {
            return null;
        }
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage) proto, propertySignature);
        if (jvmPropertySignature == null) {
            return null;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                return AbstractBinaryClassAnnotationLoaderKt.getPropertySignature((ProtoBuf.Property) proto, nameResolver, typeTable, true, true, z16);
            }
            if (!jvmPropertySignature.hasSetter()) {
                return null;
            }
            MemberSignature.Companion companion3 = MemberSignature.Companion;
            JvmProtoBuf.JvmMethodSignature setter = jvmPropertySignature.getSetter();
            Intrinsics.checkNotNullExpressionValue(setter, "signature.setter");
            return companion3.fromMethod(nameResolver, setter);
        }
        if (!jvmPropertySignature.hasGetter()) {
            return null;
        }
        MemberSignature.Companion companion4 = MemberSignature.Companion;
        JvmProtoBuf.JvmMethodSignature getter = jvmPropertySignature.getGetter();
        Intrinsics.checkNotNullExpressionValue(getter, "signature.getter");
        return companion4.fromMethod(nameResolver, getter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final KotlinJvmBinaryClass getSpecialCaseContainerClass(@NotNull ProtoContainer container, boolean z16, boolean z17, @Nullable Boolean bool, boolean z18) {
        ProtoContainer.Class outerClass;
        JvmPackagePartSource jvmPackagePartSource;
        JvmClassName jvmClassName;
        String replace$default;
        Intrinsics.checkNotNullParameter(container, "container");
        if (z16) {
            if (bool != null) {
                if (container instanceof ProtoContainer.Class) {
                    ProtoContainer.Class r85 = (ProtoContainer.Class) container;
                    if (r85.getKind() == ProtoBuf.Class.Kind.INTERFACE) {
                        KotlinClassFinder kotlinClassFinder = this.kotlinClassFinder;
                        ClassId createNestedClassId = r85.getClassId().createNestedClassId(Name.identifier("DefaultImpls"));
                        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "container.classId.create\u2026EFAULT_IMPLS_CLASS_NAME))");
                        return KotlinClassFinderKt.findKotlinClass(kotlinClassFinder, createNestedClassId);
                    }
                }
                if (bool.booleanValue() && (container instanceof ProtoContainer.Package)) {
                    SourceElement source = container.getSource();
                    if (source instanceof JvmPackagePartSource) {
                        jvmPackagePartSource = (JvmPackagePartSource) source;
                    } else {
                        jvmPackagePartSource = null;
                    }
                    if (jvmPackagePartSource != null) {
                        jvmClassName = jvmPackagePartSource.getFacadeClassName();
                    } else {
                        jvmClassName = null;
                    }
                    if (jvmClassName != null) {
                        KotlinClassFinder kotlinClassFinder2 = this.kotlinClassFinder;
                        String internalName = jvmClassName.getInternalName();
                        Intrinsics.checkNotNullExpressionValue(internalName, "facadeClassName.internalName");
                        replace$default = StringsKt__StringsJVMKt.replace$default(internalName, '/', '.', false, 4, (Object) null);
                        ClassId classId = ClassId.topLevel(new FqName(replace$default));
                        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(facadeCl\u2026lName.replace('/', '.')))");
                        return KotlinClassFinderKt.findKotlinClass(kotlinClassFinder2, classId);
                    }
                }
            } else {
                throw new IllegalStateException(("isConst should not be null for property (container=" + container + ')').toString());
            }
        }
        if (z17 && (container instanceof ProtoContainer.Class)) {
            ProtoContainer.Class r86 = (ProtoContainer.Class) container;
            if (r86.getKind() == ProtoBuf.Class.Kind.COMPANION_OBJECT && (outerClass = r86.getOuterClass()) != null && (outerClass.getKind() == ProtoBuf.Class.Kind.CLASS || outerClass.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS || (z18 && (outerClass.getKind() == ProtoBuf.Class.Kind.INTERFACE || outerClass.getKind() == ProtoBuf.Class.Kind.ANNOTATION_CLASS)))) {
                return toBinaryClass(outerClass);
            }
        }
        if (!(container instanceof ProtoContainer.Package) || !(container.getSource() instanceof JvmPackagePartSource)) {
            return null;
        }
        SourceElement source2 = container.getSource();
        Intrinsics.checkNotNull(source2, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        JvmPackagePartSource jvmPackagePartSource2 = (JvmPackagePartSource) source2;
        KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource2.getKnownJvmBinaryClass();
        if (knownJvmBinaryClass == null) {
            return KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, jvmPackagePartSource2.getClassId());
        }
        return knownJvmBinaryClass;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isImplicitRepeatableContainer(@NotNull ClassId classId) {
        KotlinJvmBinaryClass findKotlinClass;
        Intrinsics.checkNotNullParameter(classId, "classId");
        if (classId.getOuterClassId() == null || !Intrinsics.areEqual(classId.getShortClassName().asString(), "Container") || (findKotlinClass = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, classId)) == null || !SpecialJvmAnnotations.INSTANCE.isAnnotatedWithContainerMetaAnnotation(findKotlinClass)) {
            return false;
        }
        return true;
    }

    @Nullable
    protected abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(@NotNull ClassId classId, @NotNull SourceElement sourceElement, @NotNull List<A> list);

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial(@NotNull ClassId annotationClassId, @NotNull SourceElement source, @NotNull List<A> result) {
        Intrinsics.checkNotNullParameter(annotationClassId, "annotationClassId");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(result, "result");
        if (SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS().contains(annotationClassId)) {
            return null;
        }
        return loadAnnotation(annotationClassId, source, result);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    @NotNull
    public List<A> loadCallableAnnotations(@NotNull ProtoContainer container, @NotNull MessageLite proto, @NotNull AnnotatedCallableKind kind) {
        List<A> emptyList;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (kind == AnnotatedCallableKind.PROPERTY) {
            return loadPropertyAnnotations(container, (ProtoBuf.Property) proto, PropertyRelatedElement.PROPERTY);
        }
        MemberSignature callableSignature$default = getCallableSignature$default(this, proto, container.getNameResolver(), container.getTypeTable(), kind, false, 16, null);
        if (callableSignature$default == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return findClassAndLoadMemberAnnotations$default(this, container, callableSignature$default, false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    @NotNull
    public List<A> loadClassAnnotations(@NotNull ProtoContainer.Class container) {
        Intrinsics.checkNotNullParameter(container, "container");
        KotlinJvmBinaryClass binaryClass = toBinaryClass(container);
        if (binaryClass != null) {
            final ArrayList arrayList = new ArrayList(1);
            binaryClass.loadClassAnnotations(new KotlinJvmBinaryClass.AnnotationVisitor(this) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader$loadClassAnnotations$1
                final /* synthetic */ AbstractBinaryClassAnnotationLoader<A, S> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.this$0 = this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                @Nullable
                public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement source) {
                    Intrinsics.checkNotNullParameter(classId, "classId");
                    Intrinsics.checkNotNullParameter(source, "source");
                    return this.this$0.loadAnnotationIfNotSpecial(classId, source, arrayList);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                public void visitEnd() {
                }
            }, getCachedFileContent(binaryClass));
            return arrayList;
        }
        throw new IllegalStateException(("Class for loading annotations is not found: " + container.debugFqName()).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    @NotNull
    public List<A> loadEnumEntryAnnotations(@NotNull ProtoContainer container, @NotNull ProtoBuf.EnumEntry proto) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        MemberSignature.Companion companion = MemberSignature.Companion;
        String string = container.getNameResolver().getString(proto.getName());
        String asString = ((ProtoContainer.Class) container).getClassId().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "container as ProtoContai\u2026Class).classId.asString()");
        return findClassAndLoadMemberAnnotations$default(this, container, companion.fromFieldNameAndDesc(string, ClassMapperLite.mapClass(asString)), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    @NotNull
    public List<A> loadExtensionReceiverParameterAnnotations(@NotNull ProtoContainer container, @NotNull MessageLite proto, @NotNull AnnotatedCallableKind kind) {
        List<A> emptyList;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(kind, "kind");
        MemberSignature callableSignature$default = getCallableSignature$default(this, proto, container.getNameResolver(), container.getTypeTable(), kind, false, 16, null);
        if (callableSignature$default == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return findClassAndLoadMemberAnnotations$default(this, container, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(callableSignature$default, 0), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    @NotNull
    public List<A> loadPropertyBackingFieldAnnotations(@NotNull ProtoContainer container, @NotNull ProtoBuf.Property proto) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        return loadPropertyAnnotations(container, proto, PropertyRelatedElement.BACKING_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    @NotNull
    public List<A> loadPropertyDelegateFieldAnnotations(@NotNull ProtoContainer container, @NotNull ProtoBuf.Property proto) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        return loadPropertyAnnotations(container, proto, PropertyRelatedElement.DELEGATE_FIELD);
    }

    @NotNull
    protected abstract A loadTypeAnnotation(@NotNull ProtoBuf.Annotation annotation, @NotNull NameResolver nameResolver);

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    @NotNull
    public List<A> loadTypeAnnotations(@NotNull ProtoBuf.Type proto, @NotNull NameResolver nameResolver) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Object extension = proto.getExtension(JvmProtoBuf.typeAnnotation);
        Intrinsics.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) extension;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ProtoBuf.Annotation it : iterable) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(loadTypeAnnotation(it, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    @NotNull
    public List<A> loadTypeParameterAnnotations(@NotNull ProtoBuf.TypeParameter proto, @NotNull NameResolver nameResolver) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Object extension = proto.getExtension(JvmProtoBuf.typeParameterAnnotation);
        Intrinsics.checkNotNullExpressionValue(extension, "proto.getExtension(JvmPr\u2026.typeParameterAnnotation)");
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) extension;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ProtoBuf.Annotation it : iterable) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(loadTypeAnnotation(it, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    @NotNull
    public List<A> loadValueParameterAnnotations(@NotNull ProtoContainer container, @NotNull MessageLite callableProto, @NotNull AnnotatedCallableKind kind, int i3, @NotNull ProtoBuf.ValueParameter proto) {
        List<A> emptyList;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(callableProto, "callableProto");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(proto, "proto");
        MemberSignature callableSignature$default = getCallableSignature$default(this, callableProto, container.getNameResolver(), container.getTypeTable(), kind, false, 16, null);
        if (callableSignature$default == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return findClassAndLoadMemberAnnotations$default(this, container, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(callableSignature$default, i3 + computeJvmParameterIndexShift(container, callableProto)), false, false, null, false, 60, null);
    }
}
