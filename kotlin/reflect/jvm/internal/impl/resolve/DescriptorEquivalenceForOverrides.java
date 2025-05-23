package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DescriptorEquivalenceForOverrides {

    @NotNull
    public static final DescriptorEquivalenceForOverrides INSTANCE = new DescriptorEquivalenceForOverrides();

    DescriptorEquivalenceForOverrides() {
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z16, boolean z17, boolean z18, KotlinTypeRefiner kotlinTypeRefiner, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z17 = true;
        }
        boolean z19 = z17;
        if ((i3 & 16) != 0) {
            z18 = false;
        }
        return descriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent(callableDescriptor, callableDescriptor2, z16, z19, z18, kotlinTypeRefiner);
    }

    private final boolean areClassesEquivalent(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        return Intrinsics.areEqual(classDescriptor.getTypeConstructor(), classDescriptor2.getTypeConstructor());
    }

    public static /* synthetic */ boolean areEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z17 = true;
        }
        return descriptorEquivalenceForOverrides.areEquivalent(declarationDescriptor, declarationDescriptor2, z16, z17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean areTypeParametersEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z16, Function2 function2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function2 = new Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areTypeParametersEquivalent$1
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                public final Boolean invoke(@Nullable DeclarationDescriptor declarationDescriptor, @Nullable DeclarationDescriptor declarationDescriptor2) {
                    return Boolean.FALSE;
                }
            };
        }
        return descriptorEquivalenceForOverrides.areTypeParametersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, z16, function2);
    }

    private final boolean ownersEquivalent(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2, boolean z16) {
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration2 = declarationDescriptor2.getContainingDeclaration();
        if (!(containingDeclaration instanceof CallableMemberDescriptor) && !(containingDeclaration2 instanceof CallableMemberDescriptor)) {
            return areEquivalent$default(this, containingDeclaration, containingDeclaration2, z16, false, 8, null);
        }
        return function2.invoke(containingDeclaration, containingDeclaration2).booleanValue();
    }

    private final SourceElement singleSource(CallableDescriptor callableDescriptor) {
        Object singleOrNull;
        while (callableDescriptor instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) callableDescriptor;
            if (callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
            singleOrNull = CollectionsKt___CollectionsKt.singleOrNull(overriddenDescriptors);
            callableDescriptor = (CallableMemberDescriptor) singleOrNull;
            if (callableDescriptor == null) {
                return null;
            }
        }
        return callableDescriptor.getSource();
    }

    public final boolean areCallableDescriptorsEquivalent(@NotNull final CallableDescriptor a16, @NotNull final CallableDescriptor b16, final boolean z16, boolean z17, boolean z18, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(a16, "a");
        Intrinsics.checkNotNullParameter(b16, "b");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (Intrinsics.areEqual(a16, b16)) {
            return true;
        }
        if (!Intrinsics.areEqual(a16.getName(), b16.getName())) {
            return false;
        }
        if (z17 && (a16 instanceof MemberDescriptor) && (b16 instanceof MemberDescriptor) && ((MemberDescriptor) a16).isExpect() != ((MemberDescriptor) b16).isExpect()) {
            return false;
        }
        if ((Intrinsics.areEqual(a16.getContainingDeclaration(), b16.getContainingDeclaration()) && (!z16 || !Intrinsics.areEqual(singleSource(a16), singleSource(b16)))) || DescriptorUtils.isLocal(a16) || DescriptorUtils.isLocal(b16) || !ownersEquivalent(a16, b16, new Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Boolean invoke(@Nullable DeclarationDescriptor declarationDescriptor, @Nullable DeclarationDescriptor declarationDescriptor2) {
                return Boolean.FALSE;
            }
        }, z16)) {
            return false;
        }
        OverridingUtil create = OverridingUtil.create(kotlinTypeRefiner, new KotlinTypeChecker.TypeConstructorEquality() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1
            @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
            public final boolean equals(@NotNull TypeConstructor c16, @NotNull TypeConstructor c26) {
                Intrinsics.checkNotNullParameter(c16, "c1");
                Intrinsics.checkNotNullParameter(c26, "c2");
                if (Intrinsics.areEqual(c16, c26)) {
                    return true;
                }
                ClassifierDescriptor mo1779getDeclarationDescriptor = c16.mo1779getDeclarationDescriptor();
                ClassifierDescriptor mo1779getDeclarationDescriptor2 = c26.mo1779getDeclarationDescriptor();
                if ((mo1779getDeclarationDescriptor instanceof TypeParameterDescriptor) && (mo1779getDeclarationDescriptor2 instanceof TypeParameterDescriptor)) {
                    boolean z19 = z16;
                    final CallableDescriptor callableDescriptor = a16;
                    final CallableDescriptor callableDescriptor2 = b16;
                    return DescriptorEquivalenceForOverrides.INSTANCE.areTypeParametersEquivalent((TypeParameterDescriptor) mo1779getDeclarationDescriptor, (TypeParameterDescriptor) mo1779getDeclarationDescriptor2, z19, new Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        @NotNull
                        public final Boolean invoke(@Nullable DeclarationDescriptor declarationDescriptor, @Nullable DeclarationDescriptor declarationDescriptor2) {
                            return Boolean.valueOf(Intrinsics.areEqual(declarationDescriptor, CallableDescriptor.this) && Intrinsics.areEqual(declarationDescriptor2, callableDescriptor2));
                        }
                    });
                }
                return false;
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "a: CallableDescriptor,\n \u2026= a && y == b }\n        }");
        OverridingUtil.OverrideCompatibilityInfo.Result result = create.isOverridableBy(a16, b16, null, !z18).getResult();
        OverridingUtil.OverrideCompatibilityInfo.Result result2 = OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (result == result2 && create.isOverridableBy(b16, a16, null, !z18).getResult() == result2) {
            return true;
        }
        return false;
    }

    public final boolean areEquivalent(@Nullable DeclarationDescriptor declarationDescriptor, @Nullable DeclarationDescriptor declarationDescriptor2, boolean z16, boolean z17) {
        if ((declarationDescriptor instanceof ClassDescriptor) && (declarationDescriptor2 instanceof ClassDescriptor)) {
            return areClassesEquivalent((ClassDescriptor) declarationDescriptor, (ClassDescriptor) declarationDescriptor2);
        }
        if ((declarationDescriptor instanceof TypeParameterDescriptor) && (declarationDescriptor2 instanceof TypeParameterDescriptor)) {
            return areTypeParametersEquivalent$default(this, (TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, z16, null, 8, null);
        }
        if ((declarationDescriptor instanceof CallableDescriptor) && (declarationDescriptor2 instanceof CallableDescriptor)) {
            return areCallableDescriptorsEquivalent$default(this, (CallableDescriptor) declarationDescriptor, (CallableDescriptor) declarationDescriptor2, z16, z17, false, KotlinTypeRefiner.Default.INSTANCE, 16, null);
        }
        if ((declarationDescriptor instanceof PackageFragmentDescriptor) && (declarationDescriptor2 instanceof PackageFragmentDescriptor)) {
            return Intrinsics.areEqual(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), ((PackageFragmentDescriptor) declarationDescriptor2).getFqName());
        }
        return Intrinsics.areEqual(declarationDescriptor, declarationDescriptor2);
    }

    @JvmOverloads
    public final boolean areTypeParametersEquivalent(@NotNull TypeParameterDescriptor a16, @NotNull TypeParameterDescriptor b16, boolean z16) {
        Intrinsics.checkNotNullParameter(a16, "a");
        Intrinsics.checkNotNullParameter(b16, "b");
        return areTypeParametersEquivalent$default(this, a16, b16, z16, null, 8, null);
    }

    @JvmOverloads
    public final boolean areTypeParametersEquivalent(@NotNull TypeParameterDescriptor a16, @NotNull TypeParameterDescriptor b16, boolean z16, @NotNull Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> equivalentCallables) {
        Intrinsics.checkNotNullParameter(a16, "a");
        Intrinsics.checkNotNullParameter(b16, "b");
        Intrinsics.checkNotNullParameter(equivalentCallables, "equivalentCallables");
        if (Intrinsics.areEqual(a16, b16)) {
            return true;
        }
        return !Intrinsics.areEqual(a16.getContainingDeclaration(), b16.getContainingDeclaration()) && ownersEquivalent(a16, b16, equivalentCallables, z16) && a16.getIndex() == b16.getIndex();
    }
}
