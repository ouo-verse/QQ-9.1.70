package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public final class DeserializedTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {

    @NotNull
    private final DeserializedAnnotations annotations;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final DeserializationContext f412765c;

    @NotNull
    private final ProtoBuf.TypeParameter proto;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DeserializedTypeParameterDescriptor(@NotNull DeserializationContext c16, @NotNull ProtoBuf.TypeParameter proto, int i3) {
        super(r2, r3, r4, r5, r0.variance(r1), proto.getReified(), i3, SourceElement.NO_SOURCE, SupertypeLoopChecker.EMPTY.INSTANCE);
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(proto, "proto");
        StorageManager storageManager = c16.getStorageManager();
        DeclarationDescriptor containingDeclaration = c16.getContainingDeclaration();
        Annotations empty = Annotations.Companion.getEMPTY();
        Name name = NameResolverUtilKt.getName(c16.getNameResolver(), proto.getName());
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        ProtoBuf.TypeParameter.Variance variance = proto.getVariance();
        Intrinsics.checkNotNullExpressionValue(variance, "proto.variance");
        this.f412765c = c16;
        this.proto = proto;
        this.annotations = new DeserializedAnnotations(c16.getStorageManager(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor$annotations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends AnnotationDescriptor> invoke() {
                DeserializationContext deserializationContext;
                DeserializationContext deserializationContext2;
                List<? extends AnnotationDescriptor> list;
                deserializationContext = DeserializedTypeParameterDescriptor.this.f412765c;
                AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = deserializationContext.getComponents().getAnnotationAndConstantLoader();
                ProtoBuf.TypeParameter proto2 = DeserializedTypeParameterDescriptor.this.getProto();
                deserializationContext2 = DeserializedTypeParameterDescriptor.this.f412765c;
                list = CollectionsKt___CollectionsKt.toList(annotationAndConstantLoader.loadTypeParameterAnnotations(proto2, deserializationContext2.getNameResolver()));
                return list;
            }
        });
    }

    @NotNull
    public final ProtoBuf.TypeParameter getProto() {
        return this.proto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    @NotNull
    protected List<KotlinType> resolveUpperBounds() {
        int collectionSizeOrDefault;
        List<KotlinType> listOf;
        List<ProtoBuf.Type> upperBounds = ProtoTypeTableUtilKt.upperBounds(this.proto, this.f412765c.getTypeTable());
        if (upperBounds.isEmpty()) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(DescriptorUtilsKt.getBuiltIns(this).getDefaultBound());
            return listOf;
        }
        List<ProtoBuf.Type> list = upperBounds;
        TypeDeserializer typeDeserializer = this.f412765c.getTypeDeserializer();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(typeDeserializer.type((ProtoBuf.Type) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public DeserializedAnnotations getAnnotations() {
        return this.annotations;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    @NotNull
    /* renamed from: reportSupertypeLoopError, reason: merged with bridge method [inline-methods] */
    public Void mo1782reportSupertypeLoopError(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }
}
