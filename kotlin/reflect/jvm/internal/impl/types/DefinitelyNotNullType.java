package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DefinitelyNotNullType extends DelegatingSimpleType implements CustomTypeParameter, DefinitelyNotNullTypeMarker {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final SimpleType original;
    private final boolean useCorrectedNullabilityForTypeParameters;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean canHaveUndefinedNullability(UnwrappedType unwrappedType) {
            if (!(unwrappedType.getConstructor() instanceof NewTypeVariableConstructor) && !(unwrappedType.getConstructor().mo1779getDeclarationDescriptor() instanceof TypeParameterDescriptor) && !(unwrappedType instanceof NewCapturedType) && !(unwrappedType instanceof StubTypeForBuilderInference)) {
                return false;
            }
            return true;
        }

        public static /* synthetic */ DefinitelyNotNullType makeDefinitelyNotNull$default(Companion companion, UnwrappedType unwrappedType, boolean z16, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            return companion.makeDefinitelyNotNull(unwrappedType, z16);
        }

        private final boolean makesSenseToBeDefinitelyNotNull(UnwrappedType unwrappedType, boolean z16) {
            TypeParameterDescriptorImpl typeParameterDescriptorImpl;
            boolean z17 = false;
            if (!canHaveUndefinedNullability(unwrappedType)) {
                return false;
            }
            if (unwrappedType instanceof StubTypeForBuilderInference) {
                return TypeUtils.isNullableType(unwrappedType);
            }
            ClassifierDescriptor mo1779getDeclarationDescriptor = unwrappedType.getConstructor().mo1779getDeclarationDescriptor();
            if (mo1779getDeclarationDescriptor instanceof TypeParameterDescriptorImpl) {
                typeParameterDescriptorImpl = (TypeParameterDescriptorImpl) mo1779getDeclarationDescriptor;
            } else {
                typeParameterDescriptorImpl = null;
            }
            if (typeParameterDescriptorImpl != null && !typeParameterDescriptorImpl.isInitialized()) {
                z17 = true;
            }
            if (z17) {
                return true;
            }
            if (z16 && (unwrappedType.getConstructor().mo1779getDeclarationDescriptor() instanceof TypeParameterDescriptor)) {
                return TypeUtils.isNullableType(unwrappedType);
            }
            return !NullabilityChecker.INSTANCE.isSubtypeOfAny(unwrappedType);
        }

        @Nullable
        public final DefinitelyNotNullType makeDefinitelyNotNull(@NotNull UnwrappedType type, boolean z16) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (type instanceof DefinitelyNotNullType) {
                return (DefinitelyNotNullType) type;
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (!makesSenseToBeDefinitelyNotNull(type, z16)) {
                return null;
            }
            if (type instanceof FlexibleType) {
                FlexibleType flexibleType = (FlexibleType) type;
                Intrinsics.areEqual(flexibleType.getLowerBound().getConstructor(), flexibleType.getUpperBound().getConstructor());
            }
            return new DefinitelyNotNullType(FlexibleTypesKt.lowerIfFlexible(type).makeNullableAsSpecified(false), z16, defaultConstructorMarker);
        }

        Companion() {
        }
    }

    public /* synthetic */ DefinitelyNotNullType(SimpleType simpleType, boolean z16, DefaultConstructorMarker defaultConstructorMarker) {
        this(simpleType, z16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    @NotNull
    protected SimpleType getDelegate() {
        return this.original;
    }

    @NotNull
    public final SimpleType getOriginal() {
        return this.original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public boolean isTypeParameter() {
        if (!(getDelegate().getConstructor() instanceof NewTypeVariableConstructor) && !(getDelegate().getConstructor().mo1779getDeclarationDescriptor() instanceof TypeParameterDescriptor)) {
            return false;
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    @NotNull
    public KotlinType substitutionResult(@NotNull KotlinType replacement) {
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull(replacement.unwrap(), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    @NotNull
    public String toString() {
        return getDelegate() + " & Any";
    }

    DefinitelyNotNullType(SimpleType simpleType, boolean z16) {
        this.original = simpleType;
        this.useCorrectedNullabilityForTypeParameters = z16;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public SimpleType makeNullableAsSpecified(boolean z16) {
        return z16 ? getDelegate().makeNullableAsSpecified(z16) : this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public SimpleType replaceAttributes(@NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new DefinitelyNotNullType(getDelegate().replaceAttributes(newAttributes), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    @NotNull
    public DefinitelyNotNullType replaceDelegate(@NotNull SimpleType delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new DefinitelyNotNullType(delegate, this.useCorrectedNullabilityForTypeParameters);
    }
}
