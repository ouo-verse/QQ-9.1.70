package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaClassDataFinder implements ClassDataFinder {

    @NotNull
    private final DeserializedDescriptorResolver deserializedDescriptorResolver;

    @NotNull
    private final KotlinClassFinder kotlinClassFinder;

    public JavaClassDataFinder(@NotNull KotlinClassFinder kotlinClassFinder, @NotNull DeserializedDescriptorResolver deserializedDescriptorResolver) {
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        Intrinsics.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        this.kotlinClassFinder = kotlinClassFinder;
        this.deserializedDescriptorResolver = deserializedDescriptorResolver;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    @Nullable
    public ClassData findClassData(@NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        KotlinJvmBinaryClass findKotlinClass = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, classId);
        if (findKotlinClass == null) {
            return null;
        }
        Intrinsics.areEqual(findKotlinClass.getClassId(), classId);
        return this.deserializedDescriptorResolver.readClassData$descriptors_jvm(findKotlinClass);
    }
}
