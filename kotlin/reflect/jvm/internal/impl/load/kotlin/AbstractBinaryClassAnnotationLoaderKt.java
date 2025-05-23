package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class AbstractBinaryClassAnnotationLoaderKt {
    @Nullable
    public static final MemberSignature getPropertySignature(@NotNull ProtoBuf.Property proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, boolean z16, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(proto, propertySignature);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (z16) {
            JvmMemberSignature.Field jvmFieldSignature = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(proto, nameResolver, typeTable, z18);
            if (jvmFieldSignature == null) {
                return null;
            }
            return MemberSignature.Companion.fromJvmMemberSignature(jvmFieldSignature);
        }
        if (!z17 || !jvmPropertySignature.hasSyntheticMethod()) {
            return null;
        }
        MemberSignature.Companion companion = MemberSignature.Companion;
        JvmProtoBuf.JvmMethodSignature syntheticMethod = jvmPropertySignature.getSyntheticMethod();
        Intrinsics.checkNotNullExpressionValue(syntheticMethod, "signature.syntheticMethod");
        return companion.fromMethod(nameResolver, syntheticMethod);
    }

    public static /* synthetic */ MemberSignature getPropertySignature$default(ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        boolean z19;
        boolean z26;
        if ((i3 & 8) != 0) {
            z19 = false;
        } else {
            z19 = z16;
        }
        if ((i3 & 16) != 0) {
            z26 = false;
        } else {
            z26 = z17;
        }
        if ((i3 & 32) != 0) {
            z18 = true;
        }
        return getPropertySignature(property, nameResolver, typeTable, z19, z26, z18);
    }
}
