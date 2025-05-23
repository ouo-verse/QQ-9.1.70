package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptorKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KotlinTypeFactory {

    @NotNull
    public static final KotlinTypeFactory INSTANCE = new KotlinTypeFactory();

    @NotNull
    private static final Function1<KotlinTypeRefiner, SimpleType> EMPTY_REFINED_TYPE_FACTORY = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1
        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final Void invoke(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "<anonymous parameter 0>");
            return null;
        }
    };

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ExpandedTypeOrRefinedConstructor {

        @Nullable
        private final SimpleType expandedType;

        @Nullable
        private final TypeConstructor refinedConstructor;

        public ExpandedTypeOrRefinedConstructor(@Nullable SimpleType simpleType, @Nullable TypeConstructor typeConstructor) {
            this.expandedType = simpleType;
            this.refinedConstructor = typeConstructor;
        }

        @Nullable
        public final SimpleType getExpandedType() {
            return this.expandedType;
        }

        @Nullable
        public final TypeConstructor getRefinedConstructor() {
            return this.refinedConstructor;
        }
    }

    KotlinTypeFactory() {
    }

    @JvmStatic
    @NotNull
    public static final SimpleType computeExpandedType(@NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull List<? extends TypeProjection> arguments) {
        Intrinsics.checkNotNullParameter(typeAliasDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        return new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false).expand(TypeAliasExpansion.Companion.create(null, typeAliasDescriptor, arguments), TypeAttributes.Companion.getEmpty());
    }

    private final MemberScope computeMemberScope(TypeConstructor typeConstructor, List<? extends TypeProjection> list, KotlinTypeRefiner kotlinTypeRefiner) {
        ClassifierDescriptor mo1779getDeclarationDescriptor = typeConstructor.mo1779getDeclarationDescriptor();
        if (mo1779getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            return ((TypeParameterDescriptor) mo1779getDeclarationDescriptor).getDefaultType().getMemberScope();
        }
        if (mo1779getDeclarationDescriptor instanceof ClassDescriptor) {
            if (kotlinTypeRefiner == null) {
                kotlinTypeRefiner = DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtilsKt.getModule(mo1779getDeclarationDescriptor));
            }
            if (list.isEmpty()) {
                return ModuleAwareClassDescriptorKt.getRefinedUnsubstitutedMemberScopeIfPossible((ClassDescriptor) mo1779getDeclarationDescriptor, kotlinTypeRefiner);
            }
            return ModuleAwareClassDescriptorKt.getRefinedMemberScopeIfPossible((ClassDescriptor) mo1779getDeclarationDescriptor, TypeConstructorSubstitution.Companion.create(typeConstructor, list), kotlinTypeRefiner);
        }
        if (mo1779getDeclarationDescriptor instanceof TypeAliasDescriptor) {
            ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ABBREVIATION_TYPE;
            String name = ((TypeAliasDescriptor) mo1779getDeclarationDescriptor).getName().toString();
            Intrinsics.checkNotNullExpressionValue(name, "descriptor.name.toString()");
            return ErrorUtils.createErrorScope(errorScopeKind, true, name);
        }
        if (typeConstructor instanceof IntersectionTypeConstructor) {
            return ((IntersectionTypeConstructor) typeConstructor).createScopeForKotlinType();
        }
        throw new IllegalStateException("Unsupported classifier: " + mo1779getDeclarationDescriptor + " for constructor: " + typeConstructor);
    }

    @JvmStatic
    @NotNull
    public static final UnwrappedType flexibleType(@NotNull SimpleType lowerBound, @NotNull SimpleType upperBound) {
        Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        Intrinsics.checkNotNullParameter(upperBound, "upperBound");
        if (Intrinsics.areEqual(lowerBound, upperBound)) {
            return lowerBound;
        }
        return new FlexibleTypeImpl(lowerBound, upperBound);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType integerLiteralType(@NotNull TypeAttributes attributes, @NotNull IntegerLiteralTypeConstructor constructor, boolean z16) {
        List emptyList;
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return simpleTypeWithNonTrivialMemberScope(attributes, constructor, emptyList, z16, ErrorUtils.createErrorScope(ErrorScopeKind.INTEGER_LITERAL_TYPE_SCOPE, true, "unknown integer literal type"));
    }

    public final ExpandedTypeOrRefinedConstructor refineConstructor(TypeConstructor typeConstructor, KotlinTypeRefiner kotlinTypeRefiner, List<? extends TypeProjection> list) {
        ClassifierDescriptor refineDescriptor;
        ClassifierDescriptor mo1779getDeclarationDescriptor = typeConstructor.mo1779getDeclarationDescriptor();
        if (mo1779getDeclarationDescriptor == null || (refineDescriptor = kotlinTypeRefiner.refineDescriptor(mo1779getDeclarationDescriptor)) == null) {
            return null;
        }
        if (refineDescriptor instanceof TypeAliasDescriptor) {
            return new ExpandedTypeOrRefinedConstructor(computeExpandedType((TypeAliasDescriptor) refineDescriptor, list), null);
        }
        TypeConstructor refine = refineDescriptor.getTypeConstructor().refine(kotlinTypeRefiner);
        Intrinsics.checkNotNullExpressionValue(refine, "descriptor.typeConstruct\u2026refine(kotlinTypeRefiner)");
        return new ExpandedTypeOrRefinedConstructor(null, refine);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleNotNullType(@NotNull TypeAttributes attributes, @NotNull ClassDescriptor descriptor, @NotNull List<? extends TypeProjection> arguments) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        TypeConstructor typeConstructor = descriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        return simpleType$default(attributes, typeConstructor, (List) arguments, false, (KotlinTypeRefiner) null, 16, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final SimpleType simpleType(@NotNull final TypeAttributes attributes, @NotNull final TypeConstructor constructor, @NotNull final List<? extends TypeProjection> arguments, final boolean z16, @Nullable KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (attributes.isEmpty() && arguments.isEmpty() && !z16 && constructor.mo1779getDeclarationDescriptor() != null) {
            ClassifierDescriptor mo1779getDeclarationDescriptor = constructor.mo1779getDeclarationDescriptor();
            Intrinsics.checkNotNull(mo1779getDeclarationDescriptor);
            SimpleType defaultType = mo1779getDeclarationDescriptor.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "constructor.declarationDescriptor!!.defaultType");
            return defaultType;
        }
        return simpleTypeWithNonTrivialMemberScope(attributes, constructor, arguments, z16, INSTANCE.computeMemberScope(constructor, arguments, kotlinTypeRefiner), new Function1<KotlinTypeRefiner, SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$simpleType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final SimpleType invoke(@NotNull KotlinTypeRefiner refiner) {
                KotlinTypeFactory.ExpandedTypeOrRefinedConstructor refineConstructor;
                Intrinsics.checkNotNullParameter(refiner, "refiner");
                refineConstructor = KotlinTypeFactory.INSTANCE.refineConstructor(TypeConstructor.this, refiner, arguments);
                if (refineConstructor == null) {
                    return null;
                }
                SimpleType expandedType = refineConstructor.getExpandedType();
                if (expandedType != null) {
                    return expandedType;
                }
                TypeAttributes typeAttributes = attributes;
                TypeConstructor refinedConstructor = refineConstructor.getRefinedConstructor();
                Intrinsics.checkNotNull(refinedConstructor);
                return KotlinTypeFactory.simpleType(typeAttributes, refinedConstructor, arguments, z16, refiner);
            }
        });
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List list, boolean z16, KotlinTypeRefiner kotlinTypeRefiner, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            kotlinTypeRefiner = null;
        }
        return simpleType(typeAttributes, typeConstructor, (List<? extends TypeProjection>) list, z16, kotlinTypeRefiner);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(@NotNull final TypeAttributes attributes, @NotNull final TypeConstructor constructor, @NotNull final List<? extends TypeProjection> arguments, final boolean z16, @NotNull final MemberScope memberScope) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        SimpleTypeImpl simpleTypeImpl = new SimpleTypeImpl(constructor, arguments, z16, memberScope, new Function1<KotlinTypeRefiner, SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final SimpleType invoke(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
                KotlinTypeFactory.ExpandedTypeOrRefinedConstructor refineConstructor;
                Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
                refineConstructor = KotlinTypeFactory.INSTANCE.refineConstructor(TypeConstructor.this, kotlinTypeRefiner, arguments);
                if (refineConstructor == null) {
                    return null;
                }
                SimpleType expandedType = refineConstructor.getExpandedType();
                if (expandedType != null) {
                    return expandedType;
                }
                TypeAttributes typeAttributes = attributes;
                TypeConstructor refinedConstructor = refineConstructor.getRefinedConstructor();
                Intrinsics.checkNotNull(refinedConstructor);
                return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(typeAttributes, refinedConstructor, arguments, z16, memberScope);
            }
        });
        return attributes.isEmpty() ? simpleTypeImpl : new SimpleTypeWithAttributes(simpleTypeImpl, attributes);
    }

    public static /* synthetic */ SimpleType simpleType$default(SimpleType simpleType, TypeAttributes typeAttributes, TypeConstructor typeConstructor, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            typeAttributes = simpleType.getAttributes();
        }
        if ((i3 & 4) != 0) {
            typeConstructor = simpleType.getConstructor();
        }
        if ((i3 & 8) != 0) {
            list = simpleType.getArguments();
        }
        if ((i3 & 16) != 0) {
            z16 = simpleType.isMarkedNullable();
        }
        return simpleType(simpleType, typeAttributes, typeConstructor, (List<? extends TypeProjection>) list, z16);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleType(@NotNull SimpleType baseType, @NotNull TypeAttributes annotations, @NotNull TypeConstructor constructor, @NotNull List<? extends TypeProjection> arguments, boolean z16) {
        Intrinsics.checkNotNullParameter(baseType, "baseType");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        return simpleType$default(annotations, constructor, arguments, z16, (KotlinTypeRefiner) null, 16, (Object) null);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(@NotNull TypeAttributes attributes, @NotNull TypeConstructor constructor, @NotNull List<? extends TypeProjection> arguments, boolean z16, @NotNull MemberScope memberScope, @NotNull Function1<? super KotlinTypeRefiner, ? extends SimpleType> refinedTypeFactory) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        Intrinsics.checkNotNullParameter(refinedTypeFactory, "refinedTypeFactory");
        SimpleTypeImpl simpleTypeImpl = new SimpleTypeImpl(constructor, arguments, z16, memberScope, refinedTypeFactory);
        return attributes.isEmpty() ? simpleTypeImpl : new SimpleTypeWithAttributes(simpleTypeImpl, attributes);
    }
}
