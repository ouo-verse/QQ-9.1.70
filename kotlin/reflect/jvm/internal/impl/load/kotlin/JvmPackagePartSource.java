package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public final class JvmPackagePartSource implements DeserializedContainerSource {

    @NotNull
    private final DeserializedContainerAbiStability abiStability;

    @NotNull
    private final JvmClassName className;

    @Nullable
    private final JvmClassName facadeClassName;

    @Nullable
    private final IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility;
    private final boolean isPreReleaseInvisible;

    @Nullable
    private final KotlinJvmBinaryClass knownJvmBinaryClass;

    @NotNull
    private final String moduleName;

    public JvmPackagePartSource(@NotNull JvmClassName className, @Nullable JvmClassName jvmClassName, @NotNull ProtoBuf.Package packageProto, @NotNull NameResolver nameResolver, @Nullable IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z16, @NotNull DeserializedContainerAbiStability abiStability, @Nullable KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        String string;
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(packageProto, "packageProto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(abiStability, "abiStability");
        this.className = className;
        this.facadeClassName = jvmClassName;
        this.incompatibility = incompatibleVersionErrorData;
        this.isPreReleaseInvisible = z16;
        this.abiStability = abiStability;
        this.knownJvmBinaryClass = kotlinJvmBinaryClass;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageModuleName = JvmProtoBuf.packageModuleName;
        Intrinsics.checkNotNullExpressionValue(packageModuleName, "packageModuleName");
        Integer num = (Integer) ProtoBufUtilKt.getExtensionOrNull(packageProto, packageModuleName);
        this.moduleName = (num == null || (string = nameResolver.getString(num.intValue())) == null) ? "main" : string;
    }

    @NotNull
    public final ClassId getClassId() {
        return new ClassId(getClassName().getPackageFqName(), getSimpleName());
    }

    @NotNull
    public JvmClassName getClassName() {
        return this.className;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    @NotNull
    public SourceFile getContainingFile() {
        SourceFile NO_SOURCE_FILE = SourceFile.NO_SOURCE_FILE;
        Intrinsics.checkNotNullExpressionValue(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @Nullable
    public JvmClassName getFacadeClassName() {
        return this.facadeClassName;
    }

    @Nullable
    public final KotlinJvmBinaryClass getKnownJvmBinaryClass() {
        return this.knownJvmBinaryClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource
    @NotNull
    public String getPresentableString() {
        return "Class '" + getClassId().asSingleFqName().asString() + '\'';
    }

    @NotNull
    public final Name getSimpleName() {
        String substringAfterLast$default;
        String internalName = getClassName().getInternalName();
        Intrinsics.checkNotNullExpressionValue(internalName, "className.internalName");
        substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(internalName, '/', (String) null, 2, (Object) null);
        Name identifier = Name.identifier(substringAfterLast$default);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(className.int\u2026.substringAfterLast('/'))");
        return identifier;
    }

    @NotNull
    public String toString() {
        return JvmPackagePartSource.class.getSimpleName() + MsgSummary.STR_COLON + getClassName();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JvmPackagePartSource(@NotNull KotlinJvmBinaryClass kotlinClass, @NotNull ProtoBuf.Package packageProto, @NotNull NameResolver nameResolver, @Nullable IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z16, @NotNull DeserializedContainerAbiStability abiStability) {
        this(r2, r1, packageProto, nameResolver, incompatibleVersionErrorData, z16, abiStability, kotlinClass);
        Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        Intrinsics.checkNotNullParameter(packageProto, "packageProto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(abiStability, "abiStability");
        JvmClassName byClassId = JvmClassName.byClassId(kotlinClass.getClassId());
        Intrinsics.checkNotNullExpressionValue(byClassId, "byClassId(kotlinClass.classId)");
        String multifileClassName = kotlinClass.getClassHeader().getMultifileClassName();
        JvmClassName jvmClassName = null;
        if (multifileClassName != null) {
            if (multifileClassName.length() > 0) {
                jvmClassName = JvmClassName.byInternalName(multifileClassName);
            }
        }
    }
}
