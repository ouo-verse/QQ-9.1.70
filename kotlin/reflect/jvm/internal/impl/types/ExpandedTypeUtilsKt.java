package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ExpandedTypeUtilsKt {
    @Nullable
    public static final KotlinTypeMarker computeExpandedTypeForInlineClass(@NotNull TypeSystemCommonBackendContext typeSystemCommonBackendContext, @NotNull KotlinTypeMarker inlineClassType) {
        Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics.checkNotNullParameter(inlineClassType, "inlineClassType");
        return computeExpandedTypeInner(typeSystemCommonBackendContext, inlineClassType, new HashSet());
    }

    private static final KotlinTypeMarker computeExpandedTypeInner(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker, HashSet<TypeConstructorMarker> hashSet) {
        KotlinTypeMarker computeExpandedTypeInner;
        boolean z16;
        KotlinTypeMarker makeNullable;
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (!hashSet.add(typeConstructor)) {
            return null;
        }
        TypeParameterMarker typeParameterClassifier = typeSystemCommonBackendContext.getTypeParameterClassifier(typeConstructor);
        if (typeParameterClassifier != null) {
            KotlinTypeMarker representativeUpperBound = typeSystemCommonBackendContext.getRepresentativeUpperBound(typeParameterClassifier);
            computeExpandedTypeInner = computeExpandedTypeInner(typeSystemCommonBackendContext, representativeUpperBound, hashSet);
            if (computeExpandedTypeInner == null) {
                return null;
            }
            if (!typeSystemCommonBackendContext.isInlineClass(typeSystemCommonBackendContext.typeConstructor(representativeUpperBound)) && (!(representativeUpperBound instanceof SimpleTypeMarker) || !typeSystemCommonBackendContext.isPrimitiveType((SimpleTypeMarker) representativeUpperBound))) {
                z16 = false;
            } else {
                z16 = true;
            }
            if ((computeExpandedTypeInner instanceof SimpleTypeMarker) && typeSystemCommonBackendContext.isPrimitiveType((SimpleTypeMarker) computeExpandedTypeInner) && typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker) && z16) {
                makeNullable = typeSystemCommonBackendContext.makeNullable(representativeUpperBound);
            } else if (!typeSystemCommonBackendContext.isNullableType(computeExpandedTypeInner) && typeSystemCommonBackendContext.isMarkedNullable(kotlinTypeMarker)) {
                makeNullable = typeSystemCommonBackendContext.makeNullable(computeExpandedTypeInner);
            }
            return makeNullable;
        }
        if (typeSystemCommonBackendContext.isInlineClass(typeConstructor)) {
            KotlinTypeMarker unsubstitutedUnderlyingType = typeSystemCommonBackendContext.getUnsubstitutedUnderlyingType(kotlinTypeMarker);
            if (unsubstitutedUnderlyingType == null || (computeExpandedTypeInner = computeExpandedTypeInner(typeSystemCommonBackendContext, unsubstitutedUnderlyingType, hashSet)) == null) {
                return null;
            }
            if (typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker)) {
                if (!typeSystemCommonBackendContext.isNullableType(computeExpandedTypeInner)) {
                    if (!(computeExpandedTypeInner instanceof SimpleTypeMarker) || !typeSystemCommonBackendContext.isPrimitiveType((SimpleTypeMarker) computeExpandedTypeInner)) {
                        return typeSystemCommonBackendContext.makeNullable(computeExpandedTypeInner);
                    }
                    return kotlinTypeMarker;
                }
                return kotlinTypeMarker;
            }
        } else {
            return kotlinTypeMarker;
        }
        return computeExpandedTypeInner;
    }
}
