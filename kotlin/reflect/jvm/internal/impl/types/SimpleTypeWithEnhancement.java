package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class SimpleTypeWithEnhancement extends DelegatingSimpleType implements TypeWithEnhancement {

    @NotNull
    private final SimpleType delegate;

    @NotNull
    private final KotlinType enhancement;

    public SimpleTypeWithEnhancement(@NotNull SimpleType delegate, @NotNull KotlinType enhancement) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(enhancement, "enhancement");
        this.delegate = delegate;
        this.enhancement = enhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    @NotNull
    protected SimpleType getDelegate() {
        return this.delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    @NotNull
    public KotlinType getEnhancement() {
        return this.enhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    @NotNull
    public String toString() {
        return "[@EnhancedForWarnings(" + getEnhancement() + ")] " + getOrigin();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    @NotNull
    public SimpleType getOrigin() {
        return getDelegate();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public SimpleType makeNullableAsSpecified(boolean z16) {
        UnwrappedType wrapEnhancement = TypeWithEnhancementKt.wrapEnhancement(getOrigin().makeNullableAsSpecified(z16), getEnhancement().unwrap().makeNullableAsSpecified(z16));
        Intrinsics.checkNotNull(wrapEnhancement, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (SimpleType) wrapEnhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public SimpleType replaceAttributes(@NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        UnwrappedType wrapEnhancement = TypeWithEnhancementKt.wrapEnhancement(getOrigin().replaceAttributes(newAttributes), getEnhancement());
        Intrinsics.checkNotNull(wrapEnhancement, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (SimpleType) wrapEnhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    @NotNull
    public SimpleTypeWithEnhancement replaceDelegate(@NotNull SimpleType delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new SimpleTypeWithEnhancement(delegate, getEnhancement());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public SimpleTypeWithEnhancement refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinType refineType = kotlinTypeRefiner.refineType((KotlinTypeMarker) getDelegate());
        Intrinsics.checkNotNull(refineType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new SimpleTypeWithEnhancement((SimpleType) refineType, kotlinTypeRefiner.refineType((KotlinTypeMarker) getEnhancement()));
    }
}
