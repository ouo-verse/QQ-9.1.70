package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class ModuleAwareClassDescriptor implements ClassDescriptor {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MemberScope getRefinedMemberScopeIfPossible$descriptors(@NotNull ClassDescriptor classDescriptor, @NotNull TypeSubstitution typeSubstitution, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            ModuleAwareClassDescriptor moduleAwareClassDescriptor;
            MemberScope memberScope;
            Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
            Intrinsics.checkNotNullParameter(typeSubstitution, "typeSubstitution");
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            if (classDescriptor instanceof ModuleAwareClassDescriptor) {
                moduleAwareClassDescriptor = (ModuleAwareClassDescriptor) classDescriptor;
            } else {
                moduleAwareClassDescriptor = null;
            }
            if (moduleAwareClassDescriptor == null || (memberScope = moduleAwareClassDescriptor.getMemberScope(typeSubstitution, kotlinTypeRefiner)) == null) {
                MemberScope memberScope2 = classDescriptor.getMemberScope(typeSubstitution);
                Intrinsics.checkNotNullExpressionValue(memberScope2, "this.getMemberScope(\n   \u2026ubstitution\n            )");
                return memberScope2;
            }
            return memberScope;
        }

        @NotNull
        public final MemberScope getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(@NotNull ClassDescriptor classDescriptor, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            ModuleAwareClassDescriptor moduleAwareClassDescriptor;
            MemberScope unsubstitutedMemberScope;
            Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            if (classDescriptor instanceof ModuleAwareClassDescriptor) {
                moduleAwareClassDescriptor = (ModuleAwareClassDescriptor) classDescriptor;
            } else {
                moduleAwareClassDescriptor = null;
            }
            if (moduleAwareClassDescriptor == null || (unsubstitutedMemberScope = moduleAwareClassDescriptor.getUnsubstitutedMemberScope(kotlinTypeRefiner)) == null) {
                MemberScope unsubstitutedMemberScope2 = classDescriptor.getUnsubstitutedMemberScope();
                Intrinsics.checkNotNullExpressionValue(unsubstitutedMemberScope2, "this.unsubstitutedMemberScope");
                return unsubstitutedMemberScope2;
            }
            return unsubstitutedMemberScope;
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract MemberScope getMemberScope(@NotNull TypeSubstitution typeSubstitution, @NotNull KotlinTypeRefiner kotlinTypeRefiner);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract MemberScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner);
}
