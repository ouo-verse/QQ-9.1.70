package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface TypeSystemContext extends TypeSystemOptimizationContext {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        @Nullable
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker receiver, @NotNull TypeConstructorMarker constructor) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            return null;
        }

        @NotNull
        public static TypeArgumentMarker get(@NotNull TypeSystemContext typeSystemContext, @NotNull TypeArgumentListMarker receiver, int i3) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof SimpleTypeMarker) {
                return typeSystemContext.getArgument((KotlinTypeMarker) receiver, i3);
            }
            if (receiver instanceof ArgumentList) {
                TypeArgumentMarker typeArgumentMarker = ((ArgumentList) receiver).get(i3);
                Intrinsics.checkNotNullExpressionValue(typeArgumentMarker, "get(index)");
                return typeArgumentMarker;
            }
            throw new IllegalStateException(("unknown type argument list type: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @Nullable
        public static TypeArgumentMarker getArgumentOrNull(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker receiver, int i3) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            boolean z16 = false;
            if (i3 >= 0 && i3 < typeSystemContext.argumentsCount(receiver)) {
                z16 = true;
            }
            if (z16) {
                return typeSystemContext.getArgument(receiver, i3);
            }
            return null;
        }

        public static boolean hasFlexibleNullability(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (typeSystemContext.isMarkedNullable(typeSystemContext.lowerBoundIfFlexible(receiver)) != typeSystemContext.isMarkedNullable(typeSystemContext.upperBoundIfFlexible(receiver))) {
                return true;
            }
            return false;
        }

        public static boolean isCapturedType(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            CapturedTypeMarker capturedTypeMarker;
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(receiver);
            if (asSimpleType != null) {
                capturedTypeMarker = typeSystemContext.asCapturedType(asSimpleType);
            } else {
                capturedTypeMarker = null;
            }
            if (capturedTypeMarker != null) {
                return true;
            }
            return false;
        }

        public static boolean isClassType(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return typeSystemContext.isClassTypeConstructor(typeSystemContext.typeConstructor(receiver));
        }

        public static boolean isDefinitelyNotNullType(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker;
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(receiver);
            if (asSimpleType != null) {
                definitelyNotNullTypeMarker = typeSystemContext.asDefinitelyNotNullType(asSimpleType);
            } else {
                definitelyNotNullTypeMarker = null;
            }
            if (definitelyNotNullTypeMarker != null) {
                return true;
            }
            return false;
        }

        public static boolean isDynamic(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            DynamicTypeMarker dynamicTypeMarker;
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(receiver);
            if (asFlexibleType != null) {
                dynamicTypeMarker = typeSystemContext.asDynamicType(asFlexibleType);
            } else {
                dynamicTypeMarker = null;
            }
            if (dynamicTypeMarker != null) {
                return true;
            }
            return false;
        }

        public static boolean isIntegerLiteralType(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return typeSystemContext.isIntegerLiteralTypeConstructor(typeSystemContext.typeConstructor(receiver));
        }

        public static boolean isMarkedNullable(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if ((receiver instanceof SimpleTypeMarker) && typeSystemContext.isMarkedNullable((SimpleTypeMarker) receiver)) {
                return true;
            }
            return false;
        }

        public static boolean isNothing(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(receiver)) && !typeSystemContext.isNullableType(receiver)) {
                return true;
            }
            return false;
        }

        @NotNull
        public static SimpleTypeMarker lowerBoundIfFlexible(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            SimpleTypeMarker lowerBound;
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(receiver);
            if (asFlexibleType == null || (lowerBound = typeSystemContext.lowerBound(asFlexibleType)) == null) {
                SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(receiver);
                Intrinsics.checkNotNull(asSimpleType);
                return asSimpleType;
            }
            return lowerBound;
        }

        public static int size(@NotNull TypeSystemContext typeSystemContext, @NotNull TypeArgumentListMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof SimpleTypeMarker) {
                return typeSystemContext.argumentsCount((KotlinTypeMarker) receiver);
            }
            if (receiver instanceof ArgumentList) {
                return ((ArgumentList) receiver).size();
            }
            throw new IllegalStateException(("unknown type argument list type: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static TypeConstructorMarker typeConstructor(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(receiver);
            if (asSimpleType == null) {
                asSimpleType = typeSystemContext.lowerBoundIfFlexible(receiver);
            }
            return typeSystemContext.typeConstructor(asSimpleType);
        }

        @NotNull
        public static SimpleTypeMarker upperBoundIfFlexible(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker receiver) {
            SimpleTypeMarker upperBound;
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(receiver);
            if (asFlexibleType == null || (upperBound = typeSystemContext.upperBound(asFlexibleType)) == null) {
                SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(receiver);
                Intrinsics.checkNotNull(asSimpleType);
                return asSimpleType;
            }
            return upperBound;
        }
    }

    boolean areEqualTypeConstructors(@NotNull TypeConstructorMarker typeConstructorMarker, @NotNull TypeConstructorMarker typeConstructorMarker2);

    int argumentsCount(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeArgumentListMarker asArgumentList(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Nullable
    CapturedTypeMarker asCapturedType(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Nullable
    DefinitelyNotNullTypeMarker asDefinitelyNotNullType(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Nullable
    DynamicTypeMarker asDynamicType(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @Nullable
    FlexibleTypeMarker asFlexibleType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @Nullable
    RawTypeMarker asRawType(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @Nullable
    SimpleTypeMarker asSimpleType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeArgumentMarker asTypeArgument(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @Nullable
    SimpleTypeMarker captureFromArguments(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull CaptureStatus captureStatus);

    @NotNull
    CaptureStatus captureStatus(@NotNull CapturedTypeMarker capturedTypeMarker);

    @Nullable
    List<SimpleTypeMarker> fastCorrespondingSupertypes(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    TypeArgumentMarker get(@NotNull TypeArgumentListMarker typeArgumentListMarker, int i3);

    @NotNull
    TypeArgumentMarker getArgument(@NotNull KotlinTypeMarker kotlinTypeMarker, int i3);

    @Nullable
    TypeArgumentMarker getArgumentOrNull(@NotNull SimpleTypeMarker simpleTypeMarker, int i3);

    @NotNull
    List<TypeArgumentMarker> getArguments(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeParameterMarker getParameter(@NotNull TypeConstructorMarker typeConstructorMarker, int i3);

    @NotNull
    List<TypeParameterMarker> getParameters(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    KotlinTypeMarker getType(@NotNull TypeArgumentMarker typeArgumentMarker);

    @Nullable
    TypeParameterMarker getTypeParameter(@NotNull TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker);

    @Nullable
    TypeParameterMarker getTypeParameterClassifier(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    List<KotlinTypeMarker> getUpperBounds(@NotNull TypeParameterMarker typeParameterMarker);

    @NotNull
    TypeVariance getVariance(@NotNull TypeArgumentMarker typeArgumentMarker);

    @NotNull
    TypeVariance getVariance(@NotNull TypeParameterMarker typeParameterMarker);

    boolean hasFlexibleNullability(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean hasRecursiveBounds(@NotNull TypeParameterMarker typeParameterMarker, @Nullable TypeConstructorMarker typeConstructorMarker);

    @NotNull
    KotlinTypeMarker intersectTypes(@NotNull List<? extends KotlinTypeMarker> list);

    boolean isAnyConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isCapturedType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isClassType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isClassTypeConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isCommonFinalClassConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isDefinitelyNotNullType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isDenotable(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isDynamic(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isError(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isIntegerLiteralType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isIntegerLiteralTypeConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isIntersection(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isMarkedNullable(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isMarkedNullable(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isNotNullTypeParameter(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isNothing(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isNothingConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isNullableType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isOldCapturedType(@NotNull CapturedTypeMarker capturedTypeMarker);

    boolean isPrimitiveType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isProjectionNotNull(@NotNull CapturedTypeMarker capturedTypeMarker);

    boolean isSingleClassifierType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isStarProjection(@NotNull TypeArgumentMarker typeArgumentMarker);

    boolean isStubType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isStubTypeForBuilderInference(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isTypeVariableType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    SimpleTypeMarker lowerBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @NotNull
    SimpleTypeMarker lowerBoundIfFlexible(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @Nullable
    KotlinTypeMarker lowerType(@NotNull CapturedTypeMarker capturedTypeMarker);

    @NotNull
    KotlinTypeMarker makeDefinitelyNotNullOrNotNull(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    SimpleTypeMarker original(@NotNull DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker);

    int parametersCount(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    Collection<KotlinTypeMarker> possibleIntegerTypes(@NotNull SimpleTypeMarker simpleTypeMarker);

    @NotNull
    TypeArgumentMarker projection(@NotNull CapturedTypeConstructorMarker capturedTypeConstructorMarker);

    int size(@NotNull TypeArgumentListMarker typeArgumentListMarker);

    @NotNull
    TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(@NotNull SimpleTypeMarker simpleTypeMarker);

    @NotNull
    Collection<KotlinTypeMarker> supertypes(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    CapturedTypeConstructorMarker typeConstructor(@NotNull CapturedTypeMarker capturedTypeMarker);

    @NotNull
    TypeConstructorMarker typeConstructor(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeConstructorMarker typeConstructor(@NotNull SimpleTypeMarker simpleTypeMarker);

    @NotNull
    SimpleTypeMarker upperBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @NotNull
    SimpleTypeMarker upperBoundIfFlexible(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    KotlinTypeMarker withNullability(@NotNull KotlinTypeMarker kotlinTypeMarker, boolean z16);

    @NotNull
    SimpleTypeMarker withNullability(@NotNull SimpleTypeMarker simpleTypeMarker, boolean z16);
}
