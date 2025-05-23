package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public interface AdditionalClassPartsProvider {

    /* loaded from: classes28.dex */
    public static final class None implements AdditionalClassPartsProvider {

        @NotNull
        public static final None INSTANCE = new None();

        None() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        @NotNull
        public Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor classDescriptor) {
            List emptyList;
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        @NotNull
        public Collection<SimpleFunctionDescriptor> getFunctions(@NotNull Name name, @NotNull ClassDescriptor classDescriptor) {
            List emptyList;
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        @NotNull
        public Collection<Name> getFunctionsNames(@NotNull ClassDescriptor classDescriptor) {
            List emptyList;
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        @NotNull
        public Collection<KotlinType> getSupertypes(@NotNull ClassDescriptor classDescriptor) {
            List emptyList;
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    @NotNull
    Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor classDescriptor);

    @NotNull
    Collection<SimpleFunctionDescriptor> getFunctions(@NotNull Name name, @NotNull ClassDescriptor classDescriptor);

    @NotNull
    Collection<Name> getFunctionsNames(@NotNull ClassDescriptor classDescriptor);

    @NotNull
    Collection<KotlinType> getSupertypes(@NotNull ClassDescriptor classDescriptor);
}
