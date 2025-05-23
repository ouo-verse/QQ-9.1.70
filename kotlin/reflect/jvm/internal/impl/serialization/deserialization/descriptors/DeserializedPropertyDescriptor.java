package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public final class DeserializedPropertyDescriptor extends PropertyDescriptorImpl implements DeserializedCallableMemberDescriptor {

    @Nullable
    private final DeserializedContainerSource containerSource;

    @NotNull
    private final NameResolver nameResolver;

    @NotNull
    private final ProtoBuf.Property proto;

    @NotNull
    private final TypeTable typeTable;

    @NotNull
    private final VersionRequirementTable versionRequirementTable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedPropertyDescriptor(@NotNull DeclarationDescriptor containingDeclaration, @Nullable PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull DescriptorVisibility visibility, boolean z16, @NotNull Name name, @NotNull CallableMemberDescriptor.Kind kind, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, @NotNull ProtoBuf.Property proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @NotNull VersionRequirementTable versionRequirementTable, @Nullable DeserializedContainerSource deserializedContainerSource) {
        super(containingDeclaration, propertyDescriptor, annotations, modality, visibility, z16, name, kind, SourceElement.NO_SOURCE, z17, z18, z27, false, z19, z26);
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(modality, "modality");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(versionRequirementTable, "versionRequirementTable");
        this.proto = proto;
        this.nameResolver = nameResolver;
        this.typeTable = typeTable;
        this.versionRequirementTable = versionRequirementTable;
        this.containerSource = deserializedContainerSource;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl
    @NotNull
    protected PropertyDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @NotNull Modality newModality, @NotNull DescriptorVisibility newVisibility, @Nullable PropertyDescriptor propertyDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @NotNull Name newName, @NotNull SourceElement source) {
        Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        Intrinsics.checkNotNullParameter(newModality, "newModality");
        Intrinsics.checkNotNullParameter(newVisibility, "newVisibility");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(newName, "newName");
        Intrinsics.checkNotNullParameter(source, "source");
        return new DeserializedPropertyDescriptor(newOwner, propertyDescriptor, getAnnotations(), newModality, newVisibility, isVar(), newName, kind, isLateInit(), isConst(), isExternal(), isDelegated(), isExpect(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @Nullable
    public DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public NameResolver getNameResolver() {
        return this.nameResolver;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public TypeTable getTypeTable() {
        return this.typeTable;
    }

    @NotNull
    public VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        Boolean bool = Flags.IS_EXTERNAL_PROPERTY.get(getProto().getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return bool.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public ProtoBuf.Property getProto() {
        return this.proto;
    }
}
