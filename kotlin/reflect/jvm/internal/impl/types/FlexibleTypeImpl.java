package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FlexibleTypeImpl extends FlexibleType implements CustomTypeParameter {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;
    private boolean assertionsDone;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlexibleTypeImpl(@NotNull SimpleType lowerBound, @NotNull SimpleType upperBound) {
        super(lowerBound, upperBound);
        Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        Intrinsics.checkNotNullParameter(upperBound, "upperBound");
    }

    private final void runAssertions() {
        if (RUN_SLOW_ASSERTIONS && !this.assertionsDone) {
            this.assertionsDone = true;
            FlexibleTypesKt.isFlexible(getLowerBound());
            FlexibleTypesKt.isFlexible(getUpperBound());
            Intrinsics.areEqual(getLowerBound(), getUpperBound());
            KotlinTypeChecker.DEFAULT.isSubtypeOf(getLowerBound(), getUpperBound());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    @NotNull
    public SimpleType getDelegate() {
        runAssertions();
        return getLowerBound();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public boolean isTypeParameter() {
        if ((getLowerBound().getConstructor().mo1779getDeclarationDescriptor() instanceof TypeParameterDescriptor) && Intrinsics.areEqual(getLowerBound().getConstructor(), getUpperBound().getConstructor())) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public UnwrappedType makeNullableAsSpecified(boolean z16) {
        return KotlinTypeFactory.flexibleType(getLowerBound().makeNullableAsSpecified(z16), getUpperBound().makeNullableAsSpecified(z16));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    @NotNull
    public String render(@NotNull DescriptorRenderer renderer, @NotNull DescriptorRendererOptions options) {
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        Intrinsics.checkNotNullParameter(options, "options");
        if (options.getDebugMode()) {
            return '(' + renderer.renderType(getLowerBound()) + ".." + renderer.renderType(getUpperBound()) + ')';
        }
        return renderer.renderFlexibleType(renderer.renderType(getLowerBound()), renderer.renderType(getUpperBound()), TypeUtilsKt.getBuiltIns(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public UnwrappedType replaceAttributes(@NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return KotlinTypeFactory.flexibleType(getLowerBound().replaceAttributes(newAttributes), getUpperBound().replaceAttributes(newAttributes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    @NotNull
    public KotlinType substitutionResult(@NotNull KotlinType replacement) {
        UnwrappedType flexibleType;
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        UnwrappedType unwrap = replacement.unwrap();
        if (unwrap instanceof FlexibleType) {
            flexibleType = unwrap;
        } else if (unwrap instanceof SimpleType) {
            SimpleType simpleType = (SimpleType) unwrap;
            flexibleType = KotlinTypeFactory.flexibleType(simpleType, simpleType.makeNullableAsSpecified(true));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(flexibleType, unwrap);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    @NotNull
    public String toString() {
        return '(' + getLowerBound() + ".." + getUpperBound() + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public FlexibleType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinType refineType = kotlinTypeRefiner.refineType((KotlinTypeMarker) getLowerBound());
        Intrinsics.checkNotNull(refineType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType refineType2 = kotlinTypeRefiner.refineType((KotlinTypeMarker) getUpperBound());
        Intrinsics.checkNotNull(refineType2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new FlexibleTypeImpl((SimpleType) refineType, (SimpleType) refineType2);
    }
}
