package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public interface PlatformDependentTypeTransformer {

    /* loaded from: classes28.dex */
    public static final class None implements PlatformDependentTypeTransformer {

        @NotNull
        public static final None INSTANCE = new None();

        None() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer
        @NotNull
        public SimpleType transformPlatformType(@NotNull ClassId classId, @NotNull SimpleType computedType) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            Intrinsics.checkNotNullParameter(computedType, "computedType");
            return computedType;
        }
    }

    @NotNull
    SimpleType transformPlatformType(@NotNull ClassId classId, @NotNull SimpleType simpleType);
}
