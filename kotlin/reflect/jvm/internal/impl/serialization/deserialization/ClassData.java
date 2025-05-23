package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ClassData {

    @NotNull
    private final ProtoBuf.Class classProto;

    @NotNull
    private final BinaryVersion metadataVersion;

    @NotNull
    private final NameResolver nameResolver;

    @NotNull
    private final SourceElement sourceElement;

    public ClassData(@NotNull NameResolver nameResolver, @NotNull ProtoBuf.Class classProto, @NotNull BinaryVersion metadataVersion, @NotNull SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(classProto, "classProto");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(sourceElement, "sourceElement");
        this.nameResolver = nameResolver;
        this.classProto = classProto;
        this.metadataVersion = metadataVersion;
        this.sourceElement = sourceElement;
    }

    @NotNull
    public final NameResolver component1() {
        return this.nameResolver;
    }

    @NotNull
    public final ProtoBuf.Class component2() {
        return this.classProto;
    }

    @NotNull
    public final BinaryVersion component3() {
        return this.metadataVersion;
    }

    @NotNull
    public final SourceElement component4() {
        return this.sourceElement;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassData)) {
            return false;
        }
        ClassData classData = (ClassData) obj;
        if (Intrinsics.areEqual(this.nameResolver, classData.nameResolver) && Intrinsics.areEqual(this.classProto, classData.classProto) && Intrinsics.areEqual(this.metadataVersion, classData.metadataVersion) && Intrinsics.areEqual(this.sourceElement, classData.sourceElement)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.nameResolver.hashCode() * 31) + this.classProto.hashCode()) * 31) + this.metadataVersion.hashCode()) * 31) + this.sourceElement.hashCode();
    }

    @NotNull
    public String toString() {
        return "ClassData(nameResolver=" + this.nameResolver + ", classProto=" + this.classProto + ", metadataVersion=" + this.metadataVersion + ", sourceElement=" + this.sourceElement + ')';
    }
}
