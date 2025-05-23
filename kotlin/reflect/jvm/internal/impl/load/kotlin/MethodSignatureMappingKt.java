package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class MethodSignatureMappingKt {
    private static final void appendErasedType(StringBuilder sb5, KotlinType kotlinType) {
        sb5.append(mapToJvmType(kotlinType));
    }

    @NotNull
    public static final String computeJvmDescriptor(@NotNull FunctionDescriptor functionDescriptor, boolean z16, boolean z17) {
        String asString;
        Intrinsics.checkNotNullParameter(functionDescriptor, "<this>");
        StringBuilder sb5 = new StringBuilder();
        if (z17) {
            if (functionDescriptor instanceof ConstructorDescriptor) {
                asString = "<init>";
            } else {
                asString = functionDescriptor.getName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
            }
            sb5.append(asString);
        }
        sb5.append("(");
        ReceiverParameterDescriptor extensionReceiverParameter = functionDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics.checkNotNullExpressionValue(type, "it.type");
            appendErasedType(sb5, type);
        }
        Iterator<ValueParameterDescriptor> it = functionDescriptor.getValueParameters().iterator();
        while (it.hasNext()) {
            KotlinType type2 = it.next().getType();
            Intrinsics.checkNotNullExpressionValue(type2, "parameter.type");
            appendErasedType(sb5, type2);
        }
        sb5.append(")");
        if (z16) {
            if (DescriptorBasedTypeSignatureMappingKt.hasVoidReturnType(functionDescriptor)) {
                sb5.append("V");
            } else {
                KotlinType returnType = functionDescriptor.getReturnType();
                Intrinsics.checkNotNull(returnType);
                appendErasedType(sb5, returnType);
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    public static /* synthetic */ String computeJvmDescriptor$default(FunctionDescriptor functionDescriptor, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 2) != 0) {
            z17 = true;
        }
        return computeJvmDescriptor(functionDescriptor, z16, z17);
    }

    @Nullable
    public static final String computeJvmSignature(@NotNull CallableDescriptor callableDescriptor) {
        ClassDescriptor classDescriptor;
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Intrinsics.checkNotNullParameter(callableDescriptor, "<this>");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        if (DescriptorUtils.isLocal(callableDescriptor)) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        if (containingDeclaration instanceof ClassDescriptor) {
            classDescriptor = (ClassDescriptor) containingDeclaration;
        } else {
            classDescriptor = null;
        }
        if (classDescriptor == null || classDescriptor.getName().isSpecial()) {
            return null;
        }
        CallableDescriptor original = callableDescriptor.getOriginal();
        if (original instanceof SimpleFunctionDescriptor) {
            simpleFunctionDescriptor = (SimpleFunctionDescriptor) original;
        } else {
            simpleFunctionDescriptor = null;
        }
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        return MethodSignatureBuildingUtilsKt.signature(signatureBuildingComponents, classDescriptor, computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null));
    }

    public static final boolean forceSingleValueParameterBoxing(@NotNull CallableDescriptor f16) {
        Object single;
        JvmType.Primitive primitive;
        FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava;
        Object single2;
        Intrinsics.checkNotNullParameter(f16, "f");
        if (!(f16 instanceof FunctionDescriptor)) {
            return false;
        }
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) f16;
        if (!Intrinsics.areEqual(functionDescriptor.getName().asString(), "remove") || functionDescriptor.getValueParameters().size() != 1 || SpecialBuiltinMembers.isFromJavaOrBuiltins((CallableMemberDescriptor) f16)) {
            return false;
        }
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getOriginal().getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "f.original.valueParameters");
        single = CollectionsKt___CollectionsKt.single((List<? extends Object>) valueParameters);
        KotlinType type = ((ValueParameterDescriptor) single).getType();
        Intrinsics.checkNotNullExpressionValue(type, "f.original.valueParameters.single().type");
        JvmType mapToJvmType = mapToJvmType(type);
        JvmPrimitiveType jvmPrimitiveType = null;
        if (mapToJvmType instanceof JvmType.Primitive) {
            primitive = (JvmType.Primitive) mapToJvmType;
        } else {
            primitive = null;
        }
        if (primitive != null) {
            jvmPrimitiveType = primitive.getJvmPrimitiveType();
        }
        if (jvmPrimitiveType != JvmPrimitiveType.INT || (overriddenBuiltinFunctionWithErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(functionDescriptor)) == null) {
            return false;
        }
        List<ValueParameterDescriptor> valueParameters2 = overriddenBuiltinFunctionWithErasedValueParametersInJava.getOriginal().getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "overridden.original.valueParameters");
        single2 = CollectionsKt___CollectionsKt.single((List<? extends Object>) valueParameters2);
        KotlinType type2 = ((ValueParameterDescriptor) single2).getType();
        Intrinsics.checkNotNullExpressionValue(type2, "overridden.original.valueParameters.single().type");
        JvmType mapToJvmType2 = mapToJvmType(type2);
        DeclarationDescriptor containingDeclaration = overriddenBuiltinFunctionWithErasedValueParametersInJava.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "overridden.containingDeclaration");
        if (!Intrinsics.areEqual(DescriptorUtilsKt.getFqNameUnsafe(containingDeclaration), StandardNames.FqNames.mutableCollection.toUnsafe()) || !(mapToJvmType2 instanceof JvmType.Object) || !Intrinsics.areEqual(((JvmType.Object) mapToJvmType2).getInternalName(), "java/lang/Object")) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final String getInternalName(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqNameUnsafe unsafe = DescriptorUtilsKt.getFqNameSafe(classDescriptor).toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "fqNameSafe.toUnsafe()");
        ClassId mapKotlinToJava = javaToKotlinClassMap.mapKotlinToJava(unsafe);
        if (mapKotlinToJava != null) {
            String internalName = JvmClassName.byClassId(mapKotlinToJava).getInternalName();
            Intrinsics.checkNotNullExpressionValue(internalName, "byClassId(it).internalName");
            return internalName;
        }
        return DescriptorBasedTypeSignatureMappingKt.computeInternalName$default(classDescriptor, null, 2, null);
    }

    @NotNull
    public static final JvmType mapToJvmType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return (JvmType) DescriptorBasedTypeSignatureMappingKt.mapType$default(kotlinType, JvmTypeFactoryImpl.INSTANCE, TypeMappingMode.DEFAULT, TypeMappingConfigurationImpl.INSTANCE, null, null, 32, null);
    }
}
