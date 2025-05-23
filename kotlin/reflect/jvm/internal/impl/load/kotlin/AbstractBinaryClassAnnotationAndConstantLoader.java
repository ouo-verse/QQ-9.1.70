package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> extends AbstractBinaryClassAnnotationLoader<A, AnnotationsContainerWithConstants<? extends A, ? extends C>> implements AnnotationAndConstantLoader<A, C> {

    @NotNull
    private final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, AnnotationsContainerWithConstants<A, C>> storage;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class AnnotationsContainerWithConstants<A, C> extends AbstractBinaryClassAnnotationLoader.AnnotationsContainer<A> {

        @NotNull
        private final Map<MemberSignature, C> annotationParametersDefaultValues;

        @NotNull
        private final Map<MemberSignature, List<A>> memberAnnotations;

        @NotNull
        private final Map<MemberSignature, C> propertyConstants;

        /* JADX WARN: Multi-variable type inference failed */
        public AnnotationsContainerWithConstants(@NotNull Map<MemberSignature, ? extends List<? extends A>> memberAnnotations, @NotNull Map<MemberSignature, ? extends C> propertyConstants, @NotNull Map<MemberSignature, ? extends C> annotationParametersDefaultValues) {
            Intrinsics.checkNotNullParameter(memberAnnotations, "memberAnnotations");
            Intrinsics.checkNotNullParameter(propertyConstants, "propertyConstants");
            Intrinsics.checkNotNullParameter(annotationParametersDefaultValues, "annotationParametersDefaultValues");
            this.memberAnnotations = memberAnnotations;
            this.propertyConstants = propertyConstants;
            this.annotationParametersDefaultValues = annotationParametersDefaultValues;
        }

        @NotNull
        public final Map<MemberSignature, C> getAnnotationParametersDefaultValues() {
            return this.annotationParametersDefaultValues;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.AnnotationsContainer
        @NotNull
        public Map<MemberSignature, List<A>> getMemberAnnotations() {
            return this.memberAnnotations;
        }

        @NotNull
        public final Map<MemberSignature, C> getPropertyConstants() {
            return this.propertyConstants;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractBinaryClassAnnotationAndConstantLoader(@NotNull StorageManager storageManager, @NotNull KotlinClassFinder kotlinClassFinder) {
        super(kotlinClassFinder);
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.storage = storageManager.createMemoizedFunction(new Function1<KotlinJvmBinaryClass, AnnotationsContainerWithConstants<? extends A, ? extends C>>(this) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$storage$1
            final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants<A, C> invoke(@NotNull KotlinJvmBinaryClass kotlinClass) {
                AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants<A, C> loadAnnotationsAndInitializers;
                Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
                loadAnnotationsAndInitializers = this.this$0.loadAnnotationsAndInitializers(kotlinClass);
                return loadAnnotationsAndInitializers;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnnotationsContainerWithConstants<A, C> loadAnnotationsAndInitializers(final KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        final HashMap hashMap3 = new HashMap();
        kotlinJvmBinaryClass.visitMembers(new KotlinJvmBinaryClass.MemberVisitor(this) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1
            final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;

            /* compiled from: P */
            /* loaded from: classes28.dex */
            public final class AnnotationVisitorForMethod extends MemberAnnotationVisitor implements KotlinJvmBinaryClass.MethodAnnotationVisitor {
                final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnnotationVisitorForMethod(@NotNull AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, MemberSignature signature) {
                    super(abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, signature);
                    Intrinsics.checkNotNullParameter(signature, "signature");
                    this.this$0 = abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor
                @Nullable
                public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation(int i3, @NotNull ClassId classId, @NotNull SourceElement source) {
                    Intrinsics.checkNotNullParameter(classId, "classId");
                    Intrinsics.checkNotNullParameter(source, "source");
                    MemberSignature fromMethodSignatureAndParameterIndex = MemberSignature.Companion.fromMethodSignatureAndParameterIndex(getSignature(), i3);
                    Collection collection = (List) hashMap.get(fromMethodSignatureAndParameterIndex);
                    if (collection == null) {
                        collection = new ArrayList();
                        hashMap.put(fromMethodSignatureAndParameterIndex, collection);
                    }
                    return this.this$0.this$0.loadAnnotationIfNotSpecial(classId, source, collection);
                }
            }

            /* compiled from: P */
            /* loaded from: classes28.dex */
            public class MemberAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationVisitor {

                @NotNull
                private final ArrayList<A> result;

                @NotNull
                private final MemberSignature signature;
                final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 this$0;

                public MemberAnnotationVisitor(@NotNull AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, MemberSignature signature) {
                    Intrinsics.checkNotNullParameter(signature, "signature");
                    this.this$0 = abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1;
                    this.signature = signature;
                    this.result = new ArrayList<>();
                }

                @NotNull
                protected final MemberSignature getSignature() {
                    return this.signature;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                @Nullable
                public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement source) {
                    Intrinsics.checkNotNullParameter(classId, "classId");
                    Intrinsics.checkNotNullParameter(source, "source");
                    return this.this$0.this$0.loadAnnotationIfNotSpecial(classId, source, this.result);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                public void visitEnd() {
                    if (!this.result.isEmpty()) {
                        hashMap.put(this.signature, this.result);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
            @Nullable
            public KotlinJvmBinaryClass.AnnotationVisitor visitField(@NotNull Name name, @NotNull String desc, @Nullable Object obj) {
                Object loadConstant;
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(desc, "desc");
                MemberSignature.Companion companion = MemberSignature.Companion;
                String asString = name.asString();
                Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
                MemberSignature fromFieldNameAndDesc = companion.fromFieldNameAndDesc(asString, desc);
                if (obj != null && (loadConstant = this.this$0.loadConstant(desc, obj)) != null) {
                    hashMap2.put(fromFieldNameAndDesc, loadConstant);
                }
                return new MemberAnnotationVisitor(this, fromFieldNameAndDesc);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
            @Nullable
            public KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(@NotNull Name name, @NotNull String desc) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(desc, "desc");
                MemberSignature.Companion companion = MemberSignature.Companion;
                String asString = name.asString();
                Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
                return new AnnotationVisitorForMethod(this, companion.fromMethodNameAndDesc(asString, desc));
            }
        }, getCachedFileContent(kotlinJvmBinaryClass));
        return new AnnotationsContainerWithConstants<>(hashMap, hashMap2, hashMap3);
    }

    private final C loadConstantFromProperty(ProtoContainer protoContainer, ProtoBuf.Property property, AnnotatedCallableKind annotatedCallableKind, KotlinType kotlinType, Function2<? super AnnotationsContainerWithConstants<? extends A, ? extends C>, ? super MemberSignature, ? extends C> function2) {
        C invoke;
        KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers = findClassWithAnnotationsAndInitializers(protoContainer, getSpecialCaseContainerClass(protoContainer, true, true, Flags.IS_CONST.get(property.getFlags()), JvmProtoBufUtil.isMovedFromInterfaceCompanion(property)));
        if (findClassWithAnnotationsAndInitializers == null) {
            return null;
        }
        MemberSignature callableSignature = getCallableSignature(property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, findClassWithAnnotationsAndInitializers.getClassHeader().getMetadataVersion().isAtLeast(DeserializedDescriptorResolver.Companion.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm()));
        if (callableSignature == null || (invoke = function2.invoke(this.storage.invoke(findClassWithAnnotationsAndInitializers), callableSignature)) == null) {
            return null;
        }
        if (UnsignedTypes.isUnsignedType(kotlinType)) {
            return transformToUnsignedConstant(invoke);
        }
        return invoke;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isRepeatableWithImplicitContainer(@NotNull ClassId annotationClassId, @NotNull Map<Name, ? extends ConstantValue<?>> arguments) {
        KClassValue kClassValue;
        Intrinsics.checkNotNullParameter(annotationClassId, "annotationClassId");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (!Intrinsics.areEqual(annotationClassId, SpecialJvmAnnotations.INSTANCE.getJAVA_LANG_ANNOTATION_REPEATABLE())) {
            return false;
        }
        ConstantValue<?> constantValue = arguments.get(Name.identifier("value"));
        KClassValue.Value.NormalClass normalClass = null;
        if (constantValue instanceof KClassValue) {
            kClassValue = (KClassValue) constantValue;
        } else {
            kClassValue = null;
        }
        if (kClassValue == null) {
            return false;
        }
        KClassValue.Value value = kClassValue.getValue();
        if (value instanceof KClassValue.Value.NormalClass) {
            normalClass = (KClassValue.Value.NormalClass) value;
        }
        if (normalClass == null) {
            return false;
        }
        return isImplicitRepeatableContainer(normalClass.getClassId());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @Nullable
    public C loadAnnotationDefaultValue(@NotNull ProtoContainer container, @NotNull ProtoBuf.Property proto, @NotNull KotlinType expectedType) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        return loadConstantFromProperty(container, proto, AnnotatedCallableKind.PROPERTY_GETTER, expectedType, new Function2<AnnotationsContainerWithConstants<? extends A, ? extends C>, MemberSignature, C>() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationDefaultValue$1
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final C invoke(@NotNull AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants<? extends A, ? extends C> loadConstantFromProperty, @NotNull MemberSignature it) {
                Intrinsics.checkNotNullParameter(loadConstantFromProperty, "$this$loadConstantFromProperty");
                Intrinsics.checkNotNullParameter(it, "it");
                return loadConstantFromProperty.getAnnotationParametersDefaultValues().get(it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public abstract C loadConstant(@NotNull String str, @NotNull Object obj);

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @Nullable
    public C loadPropertyConstant(@NotNull ProtoContainer container, @NotNull ProtoBuf.Property proto, @NotNull KotlinType expectedType) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        return loadConstantFromProperty(container, proto, AnnotatedCallableKind.PROPERTY, expectedType, new Function2<AnnotationsContainerWithConstants<? extends A, ? extends C>, MemberSignature, C>() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadPropertyConstant$1
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final C invoke(@NotNull AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants<? extends A, ? extends C> loadConstantFromProperty, @NotNull MemberSignature it) {
                Intrinsics.checkNotNullParameter(loadConstantFromProperty, "$this$loadConstantFromProperty");
                Intrinsics.checkNotNullParameter(it, "it");
                return loadConstantFromProperty.getPropertyConstants().get(it);
            }
        });
    }

    @Nullable
    protected abstract C transformToUnsignedConstant(@NotNull C c16);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    @NotNull
    public AnnotationsContainerWithConstants<A, C> getAnnotationsContainer(@NotNull KotlinJvmBinaryClass binaryClass) {
        Intrinsics.checkNotNullParameter(binaryClass, "binaryClass");
        return this.storage.invoke(binaryClass);
    }
}
