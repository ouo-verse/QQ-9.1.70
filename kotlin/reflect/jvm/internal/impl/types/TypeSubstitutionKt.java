package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class TypeSubstitutionKt {
    @NotNull
    public static final SimpleType asSimpleType(@NotNull KotlinType kotlinType) {
        SimpleType simpleType;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof SimpleType) {
            simpleType = (SimpleType) unwrap;
        } else {
            simpleType = null;
        }
        if (simpleType != null) {
            return simpleType;
        }
        throw new IllegalStateException(("This is should be simple type: " + kotlinType).toString());
    }

    @JvmOverloads
    @NotNull
    public static final KotlinType replace(@NotNull KotlinType kotlinType, @NotNull List<? extends TypeProjection> newArguments, @NotNull Annotations newAnnotations) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(newArguments, "newArguments");
        Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        return replace$default(kotlinType, newArguments, newAnnotations, null, 4, null);
    }

    public static /* synthetic */ KotlinType replace$default(KotlinType kotlinType, List list, Annotations annotations, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = kotlinType.getArguments();
        }
        if ((i3 & 2) != 0) {
            annotations = kotlinType.getAnnotations();
        }
        if ((i3 & 4) != 0) {
            list2 = list;
        }
        return replace(kotlinType, list, annotations, list2);
    }

    @JvmOverloads
    @NotNull
    public static final KotlinType replace(@NotNull KotlinType kotlinType, @NotNull List<? extends TypeProjection> newArguments, @NotNull Annotations newAnnotations, @NotNull List<? extends TypeProjection> newArgumentsForUpperBound) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(newArguments, "newArguments");
        Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        Intrinsics.checkNotNullParameter(newArgumentsForUpperBound, "newArgumentsForUpperBound");
        if ((newArguments.isEmpty() || newArguments == kotlinType.getArguments()) && newAnnotations == kotlinType.getAnnotations()) {
            return kotlinType;
        }
        TypeAttributes attributes = kotlinType.getAttributes();
        if ((newAnnotations instanceof FilteredAnnotations) && newAnnotations.isEmpty()) {
            newAnnotations = Annotations.Companion.getEMPTY();
        }
        TypeAttributes replaceAnnotations = TypeAttributesKt.replaceAnnotations(attributes, newAnnotations);
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrap;
            return KotlinTypeFactory.flexibleType(replace(flexibleType.getLowerBound(), newArguments, replaceAnnotations), replace(flexibleType.getUpperBound(), newArgumentsForUpperBound, replaceAnnotations));
        }
        if (unwrap instanceof SimpleType) {
            return replace((SimpleType) unwrap, newArguments, replaceAnnotations);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ SimpleType replace$default(SimpleType simpleType, List list, TypeAttributes typeAttributes, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = simpleType.getArguments();
        }
        if ((i3 & 2) != 0) {
            typeAttributes = simpleType.getAttributes();
        }
        return replace(simpleType, (List<? extends TypeProjection>) list, typeAttributes);
    }

    @JvmOverloads
    @NotNull
    public static final SimpleType replace(@NotNull SimpleType simpleType, @NotNull List<? extends TypeProjection> newArguments, @NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(simpleType, "<this>");
        Intrinsics.checkNotNullParameter(newArguments, "newArguments");
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        if (newArguments.isEmpty() && newAttributes == simpleType.getAttributes()) {
            return simpleType;
        }
        if (newArguments.isEmpty()) {
            return simpleType.replaceAttributes(newAttributes);
        }
        return KotlinTypeFactory.simpleType$default(newAttributes, simpleType.getConstructor(), newArguments, simpleType.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
    }
}
