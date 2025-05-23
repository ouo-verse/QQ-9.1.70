package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class BuiltinMethodsWithSpecialGenericSignature extends SpecialGenericSignatures {

    @NotNull
    public static final BuiltinMethodsWithSpecialGenericSignature INSTANCE = new BuiltinMethodsWithSpecialGenericSignature();

    BuiltinMethodsWithSpecialGenericSignature() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasErasedValueParametersInJava(CallableMemberDescriptor callableMemberDescriptor) {
        boolean contains;
        contains = CollectionsKt___CollectionsKt.contains(SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SIGNATURES(), MethodSignatureMappingKt.computeJvmSignature(callableMemberDescriptor));
        return contains;
    }

    @JvmStatic
    @Nullable
    public static final FunctionDescriptor getOverriddenBuiltinFunctionWithErasedValueParametersInJava(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = INSTANCE;
        Name name = functionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "functionDescriptor.name");
        if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return null;
        }
        return (FunctionDescriptor) DescriptorUtilsKt.firstOverridden$default(functionDescriptor, false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$getOverriddenBuiltinFunctionWithErasedValueParametersInJava$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull CallableMemberDescriptor it) {
                boolean hasErasedValueParametersInJava;
                Intrinsics.checkNotNullParameter(it, "it");
                hasErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getHasErasedValueParametersInJava(it);
                return Boolean.valueOf(hasErasedValueParametersInJava);
            }
        }, 1, null);
    }

    @JvmStatic
    @Nullable
    public static final SpecialGenericSignatures.SpecialSignatureInfo getSpecialSignatureInfo(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        CallableMemberDescriptor firstOverridden$default;
        String computeJvmSignature;
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        SpecialGenericSignatures.Companion companion = SpecialGenericSignatures.Companion;
        if (!companion.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(callableMemberDescriptor.getName()) || (firstOverridden$default = DescriptorUtilsKt.firstOverridden$default(callableMemberDescriptor, false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull CallableMemberDescriptor it) {
                boolean z16;
                boolean hasErasedValueParametersInJava;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it instanceof FunctionDescriptor) {
                    hasErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getHasErasedValueParametersInJava(it);
                    if (hasErasedValueParametersInJava) {
                        z16 = true;
                        return Boolean.valueOf(z16);
                    }
                }
                z16 = false;
                return Boolean.valueOf(z16);
            }
        }, 1, null)) == null || (computeJvmSignature = MethodSignatureMappingKt.computeJvmSignature(firstOverridden$default)) == null) {
            return null;
        }
        return companion.getSpecialSignatureInfo(computeJvmSignature);
    }

    public final boolean getSameAsBuiltinMethodWithErasedValueParameters(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "<this>");
        return SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(name);
    }
}
