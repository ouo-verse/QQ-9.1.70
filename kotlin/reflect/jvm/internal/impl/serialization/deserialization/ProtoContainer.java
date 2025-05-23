package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public abstract class ProtoContainer {

    @NotNull
    private final NameResolver nameResolver;

    @Nullable
    private final SourceElement source;

    @NotNull
    private final TypeTable typeTable;

    /* loaded from: classes28.dex */
    public static final class Class extends ProtoContainer {

        @NotNull
        private final ClassId classId;

        @NotNull
        private final ProtoBuf.Class classProto;
        private final boolean isInner;

        @NotNull
        private final ProtoBuf.Class.Kind kind;

        @Nullable
        private final Class outerClass;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Class(@NotNull ProtoBuf.Class classProto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @Nullable SourceElement sourceElement, @Nullable Class r65) {
            super(nameResolver, typeTable, sourceElement, null);
            Intrinsics.checkNotNullParameter(classProto, "classProto");
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics.checkNotNullParameter(typeTable, "typeTable");
            this.classProto = classProto;
            this.outerClass = r65;
            this.classId = NameResolverUtilKt.getClassId(nameResolver, classProto.getFqName());
            ProtoBuf.Class.Kind kind = Flags.CLASS_KIND.get(classProto.getFlags());
            this.kind = kind == null ? ProtoBuf.Class.Kind.CLASS : kind;
            Boolean bool = Flags.IS_INNER.get(classProto.getFlags());
            Intrinsics.checkNotNullExpressionValue(bool, "IS_INNER.get(classProto.flags)");
            this.isInner = bool.booleanValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        @NotNull
        public FqName debugFqName() {
            FqName asSingleFqName = this.classId.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName, "classId.asSingleFqName()");
            return asSingleFqName;
        }

        @NotNull
        public final ClassId getClassId() {
            return this.classId;
        }

        @NotNull
        public final ProtoBuf.Class getClassProto() {
            return this.classProto;
        }

        @NotNull
        public final ProtoBuf.Class.Kind getKind() {
            return this.kind;
        }

        @Nullable
        public final Class getOuterClass() {
            return this.outerClass;
        }

        public final boolean isInner() {
            return this.isInner;
        }
    }

    /* loaded from: classes28.dex */
    public static final class Package extends ProtoContainer {

        @NotNull
        private final FqName fqName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Package(@NotNull FqName fqName, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @Nullable SourceElement sourceElement) {
            super(nameResolver, typeTable, sourceElement, null);
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics.checkNotNullParameter(typeTable, "typeTable");
            this.fqName = fqName;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        @NotNull
        public FqName debugFqName() {
            return this.fqName;
        }
    }

    public /* synthetic */ ProtoContainer(NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(nameResolver, typeTable, sourceElement);
    }

    @NotNull
    public abstract FqName debugFqName();

    @NotNull
    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    @Nullable
    public final SourceElement getSource() {
        return this.source;
    }

    @NotNull
    public final TypeTable getTypeTable() {
        return this.typeTable;
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + MsgSummary.STR_COLON + debugFqName();
    }

    ProtoContainer(NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement) {
        this.nameResolver = nameResolver;
        this.typeTable = typeTable;
        this.source = sourceElement;
    }
}
