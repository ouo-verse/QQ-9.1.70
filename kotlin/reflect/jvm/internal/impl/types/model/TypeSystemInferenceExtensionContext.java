package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface TypeSystemInferenceExtensionContext extends TypeSystemCommonSuperTypesContext, TypeSystemContext {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        @Nullable
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull SimpleTypeMarker receiver, @NotNull TypeConstructorMarker constructor) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            return TypeSystemContext.DefaultImpls.fastCorrespondingSupertypes(typeSystemInferenceExtensionContext, receiver, constructor);
        }

        @NotNull
        public static TypeArgumentMarker get(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull TypeArgumentListMarker receiver, int i3) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return TypeSystemContext.DefaultImpls.get(typeSystemInferenceExtensionContext, receiver, i3);
        }

        @Nullable
        public static TypeArgumentMarker getArgumentOrNull(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull SimpleTypeMarker receiver, int i3) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return TypeSystemContext.DefaultImpls.getArgumentOrNull(typeSystemInferenceExtensionContext, receiver, i3);
        }

        public static boolean hasFlexibleNullability(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return TypeSystemContext.DefaultImpls.hasFlexibleNullability(typeSystemInferenceExtensionContext, receiver);
        }

        public static boolean isCapturedType(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return TypeSystemContext.DefaultImpls.isCapturedType(typeSystemInferenceExtensionContext, receiver);
        }

        public static boolean isClassType(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return TypeSystemContext.DefaultImpls.isClassType(typeSystemInferenceExtensionContext, receiver);
        }

        public static boolean isDefinitelyNotNullType(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return TypeSystemContext.DefaultImpls.isDefinitelyNotNullType(typeSystemInferenceExtensionContext, receiver);
        }

        public static boolean isDynamic(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return TypeSystemContext.DefaultImpls.isDynamic(typeSystemInferenceExtensionContext, receiver);
        }

        public static boolean isIntegerLiteralType(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return TypeSystemContext.DefaultImpls.isIntegerLiteralType(typeSystemInferenceExtensionContext, receiver);
        }

        public static boolean isMarkedNullable(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return TypeSystemContext.DefaultImpls.isMarkedNullable(typeSystemInferenceExtensionContext, receiver);
        }

        public static boolean isNothing(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return TypeSystemContext.DefaultImpls.isNothing(typeSystemInferenceExtensionContext, receiver);
        }

        @NotNull
        public static SimpleTypeMarker lowerBoundIfFlexible(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return TypeSystemContext.DefaultImpls.lowerBoundIfFlexible(typeSystemInferenceExtensionContext, receiver);
        }

        public static int size(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull TypeArgumentListMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return TypeSystemContext.DefaultImpls.size(typeSystemInferenceExtensionContext, receiver);
        }

        @NotNull
        public static TypeConstructorMarker typeConstructor(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return TypeSystemContext.DefaultImpls.typeConstructor(typeSystemInferenceExtensionContext, receiver);
        }

        @NotNull
        public static SimpleTypeMarker upperBoundIfFlexible(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return TypeSystemContext.DefaultImpls.upperBoundIfFlexible(typeSystemInferenceExtensionContext, receiver);
        }
    }
}
