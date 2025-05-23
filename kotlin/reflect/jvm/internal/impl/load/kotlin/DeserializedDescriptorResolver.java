package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DeserializedDescriptorResolver {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final JvmMetadataVersion KOTLIN_1_1_EAP_METADATA_VERSION;

    @NotNull
    private static final JvmMetadataVersion KOTLIN_1_3_M1_METADATA_VERSION;

    @NotNull
    private static final JvmMetadataVersion KOTLIN_1_3_RC_METADATA_VERSION;

    @NotNull
    private static final Set<KotlinClassHeader.Kind> KOTLIN_CLASS;

    @NotNull
    private static final Set<KotlinClassHeader.Kind> KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART;
    public DeserializationComponents components;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final JvmMetadataVersion getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm() {
            return DeserializedDescriptorResolver.KOTLIN_1_3_RC_METADATA_VERSION;
        }

        Companion() {
        }
    }

    static {
        Set<KotlinClassHeader.Kind> of5;
        Set<KotlinClassHeader.Kind> of6;
        of5 = SetsKt__SetsJVMKt.setOf(KotlinClassHeader.Kind.CLASS);
        KOTLIN_CLASS = of5;
        of6 = SetsKt__SetsKt.setOf((Object[]) new KotlinClassHeader.Kind[]{KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART});
        KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART = of6;
        KOTLIN_1_1_EAP_METADATA_VERSION = new JvmMetadataVersion(1, 1, 2);
        KOTLIN_1_3_M1_METADATA_VERSION = new JvmMetadataVersion(1, 1, 11);
        KOTLIN_1_3_RC_METADATA_VERSION = new JvmMetadataVersion(1, 1, 13);
    }

    private final DeserializedContainerAbiStability getAbiStability(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (getComponents().getConfiguration().getAllowUnstableDependencies()) {
            return DeserializedContainerAbiStability.STABLE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().isUnstableFirBinary()) {
            return DeserializedContainerAbiStability.FIR_UNSTABLE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().isUnstableJvmIrBinary()) {
            return DeserializedContainerAbiStability.IR_UNSTABLE;
        }
        return DeserializedContainerAbiStability.STABLE;
    }

    private final IncompatibleVersionErrorData<JvmMetadataVersion> getIncompatibility(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (!getSkipMetadataVersionCheck() && !kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
            return new IncompatibleVersionErrorData<>(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), JvmMetadataVersion.INSTANCE, kotlinJvmBinaryClass.getLocation(), kotlinJvmBinaryClass.getClassId());
        }
        return null;
    }

    private final boolean getSkipMetadataVersionCheck() {
        return getComponents().getConfiguration().getSkipMetadataVersionCheck();
    }

    private final boolean isCompiledWith13M1(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (!getComponents().getConfiguration().getSkipPrereleaseCheck() && kotlinJvmBinaryClass.getClassHeader().isPreRelease() && Intrinsics.areEqual(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), KOTLIN_1_3_M1_METADATA_VERSION)) {
            return true;
        }
        return false;
    }

    private final boolean isPreReleaseInvisible(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if ((getComponents().getConfiguration().getReportErrorsOnPreReleaseDependencies() && (kotlinJvmBinaryClass.getClassHeader().isPreRelease() || Intrinsics.areEqual(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), KOTLIN_1_1_EAP_METADATA_VERSION))) || isCompiledWith13M1(kotlinJvmBinaryClass)) {
            return true;
        }
        return false;
    }

    private final String[] readData(KotlinJvmBinaryClass kotlinJvmBinaryClass, Set<? extends KotlinClassHeader.Kind> set) {
        KotlinClassHeader classHeader = kotlinJvmBinaryClass.getClassHeader();
        String[] data = classHeader.getData();
        if (data == null) {
            data = classHeader.getIncompatibleData();
        }
        if (data == null || !set.contains(classHeader.getKind())) {
            return null;
        }
        return data;
    }

    @Nullable
    public final MemberScope createKotlinPackagePartScope(@NotNull PackageFragmentDescriptor descriptor, @NotNull KotlinJvmBinaryClass kotlinClass) {
        String[] strings;
        Pair<JvmNameResolver, ProtoBuf.Package> pair;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        String[] readData = readData(kotlinClass, KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART);
        if (readData == null || (strings = kotlinClass.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            try {
                pair = JvmProtoBufUtil.readPackageDataFrom(readData, strings);
            } catch (InvalidProtocolBufferException e16) {
                throw new IllegalStateException("Could not read data from " + kotlinClass.getLocation(), e16);
            }
        } catch (Throwable th5) {
            if (!getSkipMetadataVersionCheck() && !kotlinClass.getClassHeader().getMetadataVersion().isCompatible()) {
                pair = null;
            } else {
                throw th5;
            }
        }
        if (pair == null) {
            return null;
        }
        JvmNameResolver component1 = pair.component1();
        ProtoBuf.Package component2 = pair.component2();
        JvmPackagePartSource jvmPackagePartSource = new JvmPackagePartSource(kotlinClass, component2, component1, getIncompatibility(kotlinClass), isPreReleaseInvisible(kotlinClass), getAbiStability(kotlinClass));
        return new DeserializedPackageMemberScope(descriptor, component2, component1, kotlinClass.getClassHeader().getMetadataVersion(), jvmPackagePartSource, getComponents(), "scope for " + jvmPackagePartSource + " in " + descriptor, new Function0<Collection<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver$createKotlinPackagePartScope$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Collection<? extends Name> invoke() {
                List emptyList;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
        });
    }

    @NotNull
    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents != null) {
            return deserializationComponents;
        }
        Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    @Nullable
    public final ClassData readClassData$descriptors_jvm(@NotNull KotlinJvmBinaryClass kotlinClass) {
        Pair<JvmNameResolver, ProtoBuf.Class> pair;
        Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        String[] readData = readData(kotlinClass, KOTLIN_CLASS);
        if (readData == null) {
            return null;
        }
        String[] strings = kotlinClass.getClassHeader().getStrings();
        try {
        } catch (Throwable th5) {
            if (!getSkipMetadataVersionCheck() && !kotlinClass.getClassHeader().getMetadataVersion().isCompatible()) {
                pair = null;
            } else {
                throw th5;
            }
        }
        if (strings == null) {
            return null;
        }
        try {
            pair = JvmProtoBufUtil.readClassDataFrom(readData, strings);
            if (pair == null) {
                return null;
            }
            return new ClassData(pair.component1(), pair.component2(), kotlinClass.getClassHeader().getMetadataVersion(), new KotlinJvmBinarySourceElement(kotlinClass, getIncompatibility(kotlinClass), isPreReleaseInvisible(kotlinClass), getAbiStability(kotlinClass)));
        } catch (InvalidProtocolBufferException e16) {
            throw new IllegalStateException("Could not read data from " + kotlinClass.getLocation(), e16);
        }
    }

    @Nullable
    public final ClassDescriptor resolveClass(@NotNull KotlinJvmBinaryClass kotlinClass) {
        Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        ClassData readClassData$descriptors_jvm = readClassData$descriptors_jvm(kotlinClass);
        if (readClassData$descriptors_jvm == null) {
            return null;
        }
        return getComponents().getClassDeserializer().deserializeClass(kotlinClass.getClassId(), readClassData$descriptors_jvm);
    }

    public final void setComponents(@NotNull DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }

    public final void setComponents(@NotNull DeserializationComponentsForJava components) {
        Intrinsics.checkNotNullParameter(components, "components");
        setComponents(components.getComponents());
    }
}
