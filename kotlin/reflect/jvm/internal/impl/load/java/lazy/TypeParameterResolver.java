package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public interface TypeParameterResolver {

    /* loaded from: classes28.dex */
    public static final class EMPTY implements TypeParameterResolver {

        @NotNull
        public static final EMPTY INSTANCE = new EMPTY();

        EMPTY() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
        @Nullable
        public TypeParameterDescriptor resolveTypeParameter(@NotNull JavaTypeParameter javaTypeParameter) {
            Intrinsics.checkNotNullParameter(javaTypeParameter, "javaTypeParameter");
            return null;
        }
    }

    @Nullable
    TypeParameterDescriptor resolveTypeParameter(@NotNull JavaTypeParameter javaTypeParameter);
}
