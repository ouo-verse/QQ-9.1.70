package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ErrorClassDescriptor extends ClassDescriptorImpl {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ErrorClassDescriptor(@NotNull Name name) {
        super(r1, name, r3, r4, r0, r11, false, LockBasedStorageManager.NO_LOCKS);
        List emptyList;
        List<ValueParameterDescriptor> emptyList2;
        Set<ClassConstructorDescriptor> of5;
        Intrinsics.checkNotNullParameter(name, "name");
        ErrorUtils errorUtils = ErrorUtils.INSTANCE;
        ModuleDescriptor errorModule = errorUtils.getErrorModule();
        Modality modality = Modality.OPEN;
        ClassKind classKind = ClassKind.CLASS;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        ClassConstructorDescriptorImpl create = ClassConstructorDescriptorImpl.create(this, Annotations.Companion.getEMPTY(), true, sourceElement);
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        create.initialize(emptyList2, DescriptorVisibilities.INTERNAL);
        Intrinsics.checkNotNullExpressionValue(create, "create(this, Annotations\u2026          )\n            }");
        ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ERROR_CLASS;
        String name2 = create.getName().toString();
        Intrinsics.checkNotNullExpressionValue(name2, "errorConstructor.name.toString()");
        MemberScope createErrorScope = ErrorUtils.createErrorScope(errorScopeKind, name2, "");
        ErrorTypeKind errorTypeKind = ErrorTypeKind.ERROR_CLASS;
        create.setReturnType(new ErrorType(errorUtils.createErrorTypeConstructor(errorTypeKind, new String[0]), createErrorScope, errorTypeKind, null, false, new String[0], 24, null));
        of5 = SetsKt__SetsJVMKt.setOf(create);
        initialize(createErrorScope, of5, create);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    @NotNull
    public MemberScope getMemberScope(@NotNull TypeSubstitution typeSubstitution, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(typeSubstitution, "typeSubstitution");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ERROR_CLASS;
        String name = getName().toString();
        Intrinsics.checkNotNullExpressionValue(name, "name.toString()");
        return ErrorUtils.createErrorScope(errorScopeKind, name, typeSubstitution.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    @NotNull
    public ClassDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
        Intrinsics.checkNotNullParameter(substitutor, "substitutor");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl
    @NotNull
    public String toString() {
        String asString = getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return asString;
    }
}
