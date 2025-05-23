package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class BinaryClassAnnotationAndConstantLoaderImpl extends AbstractBinaryClassAnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {

    @NotNull
    private final AnnotationDeserializer annotationDeserializer;

    @NotNull
    private final ModuleDescriptor module;

    @NotNull
    private final NotFoundClasses notFoundClasses;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public abstract class AbstractAnnotationArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        public AbstractAnnotationArgumentVisitor() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(@Nullable Name name, @Nullable Object obj) {
            visitConstantValue(name, BinaryClassAnnotationAndConstantLoaderImpl.this.createConstant(name, obj));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@Nullable final Name name, @NotNull ClassId classId) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            final ArrayList arrayList = new ArrayList();
            BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = BinaryClassAnnotationAndConstantLoaderImpl.this;
            SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
            final KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation = binaryClassAnnotationAndConstantLoaderImpl.loadAnnotation(classId, NO_SOURCE, arrayList);
            Intrinsics.checkNotNull(loadAnnotation);
            return new KotlinJvmBinaryClass.AnnotationArgumentVisitor(this, name, arrayList) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitAnnotation$1
                private final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor $$delegate_0;
                final /* synthetic */ ArrayList<AnnotationDescriptor> $list;
                final /* synthetic */ Name $name;
                final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.this$0 = this;
                    this.$name = name;
                    this.$list = arrayList;
                    this.$$delegate_0 = KotlinJvmBinaryClass.AnnotationArgumentVisitor.this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public void visit(@Nullable Name name2, @Nullable Object obj) {
                    this.$$delegate_0.visit(name2, obj);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                @Nullable
                public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@Nullable Name name2, @NotNull ClassId classId2) {
                    Intrinsics.checkNotNullParameter(classId2, "classId");
                    return this.$$delegate_0.visitAnnotation(name2, classId2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                @Nullable
                public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@Nullable Name name2) {
                    return this.$$delegate_0.visitArray(name2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public void visitClassLiteral(@Nullable Name name2, @NotNull ClassLiteralValue value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    this.$$delegate_0.visitClassLiteral(name2, value);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public void visitEnd() {
                    Object single;
                    KotlinJvmBinaryClass.AnnotationArgumentVisitor.this.visitEnd();
                    BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor abstractAnnotationArgumentVisitor = this.this$0;
                    Name name2 = this.$name;
                    single = CollectionsKt___CollectionsKt.single((List<? extends Object>) this.$list);
                    abstractAnnotationArgumentVisitor.visitConstantValue(name2, new AnnotationValue((AnnotationDescriptor) single));
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public void visitEnum(@Nullable Name name2, @NotNull ClassId enumClassId, @NotNull Name enumEntryName) {
                    Intrinsics.checkNotNullParameter(enumClassId, "enumClassId");
                    Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
                    this.$$delegate_0.visitEnum(name2, enumClassId, enumEntryName);
                }
            };
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@Nullable Name name) {
            return new BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1(BinaryClassAnnotationAndConstantLoaderImpl.this, name, this);
        }

        public abstract void visitArrayValue(@Nullable Name name, @NotNull ArrayList<ConstantValue<?>> arrayList);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(@Nullable Name name, @NotNull ClassLiteralValue value) {
            Intrinsics.checkNotNullParameter(value, "value");
            visitConstantValue(name, new KClassValue(value));
        }

        public abstract void visitConstantValue(@Nullable Name name, @NotNull ConstantValue<?> constantValue);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(@Nullable Name name, @NotNull ClassId enumClassId, @NotNull Name enumEntryName) {
            Intrinsics.checkNotNullParameter(enumClassId, "enumClassId");
            Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
            visitConstantValue(name, new EnumValue(enumClassId, enumEntryName));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinaryClassAnnotationAndConstantLoaderImpl(@NotNull ModuleDescriptor module, @NotNull NotFoundClasses notFoundClasses, @NotNull StorageManager storageManager, @NotNull KotlinClassFinder kotlinClassFinder) {
        super(storageManager, kotlinClassFinder);
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.module = module;
        this.notFoundClasses = notFoundClasses;
        this.annotationDeserializer = new AnnotationDeserializer(module, notFoundClasses);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConstantValue<?> createConstant(Name name, Object obj) {
        ConstantValue<?> createConstantValue = ConstantValueFactory.INSTANCE.createConstantValue(obj);
        if (createConstantValue == null) {
            return ErrorValue.Companion.create("Unsupported annotation argument: " + name);
        }
        return createConstantValue;
    }

    private final ClassDescriptor resolveClass(ClassId classId) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    @Nullable
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(@NotNull final ClassId annotationClassId, @NotNull final SourceElement source, @NotNull final List<AnnotationDescriptor> result) {
        Intrinsics.checkNotNullParameter(annotationClassId, "annotationClassId");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(result, "result");
        final ClassDescriptor resolveClass = resolveClass(annotationClassId);
        return new AbstractAnnotationArgumentVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1

            @NotNull
            private final HashMap<Name, ConstantValue<?>> arguments;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.arguments = new HashMap<>();
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor
            public void visitArrayValue(@Nullable Name name, @NotNull ArrayList<ConstantValue<?>> elements) {
                Intrinsics.checkNotNullParameter(elements, "elements");
                if (name == null) {
                    return;
                }
                ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(name, resolveClass);
                if (annotationParameterByName != null) {
                    HashMap<Name, ConstantValue<?>> hashMap = this.arguments;
                    ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                    List<? extends ConstantValue<?>> compact = CollectionsKt.compact(elements);
                    KotlinType type = annotationParameterByName.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "parameter.type");
                    hashMap.put(name, constantValueFactory.createArrayValue(compact, type));
                    return;
                }
                if (BinaryClassAnnotationAndConstantLoaderImpl.this.isImplicitRepeatableContainer(annotationClassId) && Intrinsics.areEqual(name.asString(), "value")) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : elements) {
                        if (obj instanceof AnnotationValue) {
                            arrayList.add(obj);
                        }
                    }
                    List<AnnotationDescriptor> list = result;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        list.add(((AnnotationValue) it.next()).getValue());
                    }
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor
            public void visitConstantValue(@Nullable Name name, @NotNull ConstantValue<?> value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (name != null) {
                    this.arguments.put(name, value);
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitEnd() {
                if (BinaryClassAnnotationAndConstantLoaderImpl.this.isRepeatableWithImplicitContainer(annotationClassId, this.arguments) || BinaryClassAnnotationAndConstantLoaderImpl.this.isImplicitRepeatableContainer(annotationClassId)) {
                    return;
                }
                result.add(new AnnotationDescriptorImpl(resolveClass.getDefaultType(), this.arguments, source));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    @Nullable
    public ConstantValue<?> loadConstant(@NotNull String desc, @NotNull Object initializer) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) "ZBCS", (CharSequence) desc, false, 2, (Object) null);
        if (contains$default) {
            int intValue = ((Integer) initializer).intValue();
            int hashCode = desc.hashCode();
            if (hashCode == 66) {
                if (desc.equals("B")) {
                    initializer = Byte.valueOf((byte) intValue);
                }
                throw new AssertionError(desc);
            }
            if (hashCode == 67) {
                if (desc.equals(BdhLogUtil.LogTag.Tag_Conn)) {
                    initializer = Character.valueOf((char) intValue);
                }
                throw new AssertionError(desc);
            }
            if (hashCode == 83) {
                if (desc.equals(ExifInterface.LATITUDE_SOUTH)) {
                    initializer = Short.valueOf((short) intValue);
                }
                throw new AssertionError(desc);
            }
            if (hashCode == 90 && desc.equals("Z")) {
                initializer = Boolean.valueOf(intValue != 0);
            }
            throw new AssertionError(desc);
        }
        return ConstantValueFactory.INSTANCE.createConstantValue(initializer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    @NotNull
    public AnnotationDescriptor loadTypeAnnotation(@NotNull ProtoBuf.Annotation proto, @NotNull NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        return this.annotationDeserializer.deserializeAnnotation(proto, nameResolver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    @Nullable
    public ConstantValue<?> transformToUnsignedConstant(@NotNull ConstantValue<?> constant) {
        ConstantValue<?> uLongValue;
        Intrinsics.checkNotNullParameter(constant, "constant");
        if (constant instanceof ByteValue) {
            uLongValue = new UByteValue(((ByteValue) constant).getValue().byteValue());
        } else if (constant instanceof ShortValue) {
            uLongValue = new UShortValue(((ShortValue) constant).getValue().shortValue());
        } else if (constant instanceof IntValue) {
            uLongValue = new UIntValue(((IntValue) constant).getValue().intValue());
        } else {
            if (!(constant instanceof LongValue)) {
                return constant;
            }
            uLongValue = new ULongValue(((LongValue) constant).getValue().longValue());
        }
        return uLongValue;
    }
}
