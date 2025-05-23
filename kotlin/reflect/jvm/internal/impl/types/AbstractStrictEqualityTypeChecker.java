package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class AbstractStrictEqualityTypeChecker {

    @NotNull
    public static final AbstractStrictEqualityTypeChecker INSTANCE = new AbstractStrictEqualityTypeChecker();

    AbstractStrictEqualityTypeChecker() {
    }

    private final boolean strictEqualSimpleTypes(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        boolean z16;
        boolean z17;
        if (typeSystemContext.argumentsCount(simpleTypeMarker) == typeSystemContext.argumentsCount(simpleTypeMarker2) && typeSystemContext.isMarkedNullable(simpleTypeMarker) == typeSystemContext.isMarkedNullable(simpleTypeMarker2)) {
            if (typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker) == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker2) == null) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z16 == z17 && typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker), typeSystemContext.typeConstructor(simpleTypeMarker2))) {
                if (typeSystemContext.identicalArguments(simpleTypeMarker, simpleTypeMarker2)) {
                    return true;
                }
                int argumentsCount = typeSystemContext.argumentsCount(simpleTypeMarker);
                for (int i3 = 0; i3 < argumentsCount; i3++) {
                    TypeArgumentMarker argument = typeSystemContext.getArgument(simpleTypeMarker, i3);
                    TypeArgumentMarker argument2 = typeSystemContext.getArgument(simpleTypeMarker2, i3);
                    if (typeSystemContext.isStarProjection(argument) != typeSystemContext.isStarProjection(argument2)) {
                        return false;
                    }
                    if (!typeSystemContext.isStarProjection(argument) && (typeSystemContext.getVariance(argument) != typeSystemContext.getVariance(argument2) || !strictEqualTypesInternal(typeSystemContext, typeSystemContext.getType(argument), typeSystemContext.getType(argument2)))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final boolean strictEqualTypesInternal(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
        SimpleTypeMarker asSimpleType2 = typeSystemContext.asSimpleType(kotlinTypeMarker2);
        if (asSimpleType != null && asSimpleType2 != null) {
            return strictEqualSimpleTypes(typeSystemContext, asSimpleType, asSimpleType2);
        }
        FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(kotlinTypeMarker);
        FlexibleTypeMarker asFlexibleType2 = typeSystemContext.asFlexibleType(kotlinTypeMarker2);
        if (asFlexibleType == null || asFlexibleType2 == null) {
            return false;
        }
        if (strictEqualSimpleTypes(typeSystemContext, typeSystemContext.lowerBound(asFlexibleType), typeSystemContext.lowerBound(asFlexibleType2)) && strictEqualSimpleTypes(typeSystemContext, typeSystemContext.upperBound(asFlexibleType), typeSystemContext.upperBound(asFlexibleType2))) {
            return true;
        }
        return false;
    }

    public final boolean strictEqualTypes(@NotNull TypeSystemContext context, @NotNull KotlinTypeMarker a16, @NotNull KotlinTypeMarker b16) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(a16, "a");
        Intrinsics.checkNotNullParameter(b16, "b");
        return strictEqualTypesInternal(context, a16, b16);
    }
}
