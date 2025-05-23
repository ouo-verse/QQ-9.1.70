package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface TypeMappingConfiguration<T> {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        @Nullable
        public static <T> String getPredefinedFullInternalNameForClass(@NotNull TypeMappingConfiguration<? extends T> typeMappingConfiguration, @NotNull ClassDescriptor classDescriptor) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            return null;
        }

        @Nullable
        public static <T> KotlinType preprocessType(@NotNull TypeMappingConfiguration<? extends T> typeMappingConfiguration, @NotNull KotlinType kotlinType) {
            Intrinsics.checkNotNullParameter(kotlinType, "kotlinType");
            return null;
        }
    }

    @NotNull
    KotlinType commonSupertype(@NotNull Collection<KotlinType> collection);

    @Nullable
    String getPredefinedFullInternalNameForClass(@NotNull ClassDescriptor classDescriptor);

    @Nullable
    String getPredefinedInternalNameForClass(@NotNull ClassDescriptor classDescriptor);

    @Nullable
    T getPredefinedTypeForClass(@NotNull ClassDescriptor classDescriptor);

    @Nullable
    KotlinType preprocessType(@NotNull KotlinType kotlinType);

    void processErrorType(@NotNull KotlinType kotlinType, @NotNull ClassDescriptor classDescriptor);
}
