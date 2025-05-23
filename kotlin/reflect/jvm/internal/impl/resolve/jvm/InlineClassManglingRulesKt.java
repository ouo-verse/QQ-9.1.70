package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class InlineClassManglingRulesKt {
    private static final boolean isDontMangleClass(ClassDescriptor classDescriptor) {
        return Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(classDescriptor), StandardNames.RESULT_FQ_NAME);
    }

    public static final boolean isInlineClassThatRequiresMangling(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return InlineClassesUtilsKt.isInlineClass(declarationDescriptor) && !isDontMangleClass((ClassDescriptor) declarationDescriptor);
    }

    private static final boolean isTypeParameterWithUpperBoundThatRequiresMangling(KotlinType kotlinType) {
        TypeParameterDescriptor typeParameterDescriptor;
        ClassifierDescriptor mo1779getDeclarationDescriptor = kotlinType.getConstructor().mo1779getDeclarationDescriptor();
        if (mo1779getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            typeParameterDescriptor = (TypeParameterDescriptor) mo1779getDeclarationDescriptor;
        } else {
            typeParameterDescriptor = null;
        }
        if (typeParameterDescriptor == null) {
            return false;
        }
        return requiresFunctionNameManglingInParameterTypes(TypeUtilsKt.getRepresentativeUpperBound(typeParameterDescriptor));
    }

    private static final boolean requiresFunctionNameManglingInParameterTypes(KotlinType kotlinType) {
        if (!isInlineClassThatRequiresMangling(kotlinType) && !isTypeParameterWithUpperBoundThatRequiresMangling(kotlinType)) {
            return false;
        }
        return true;
    }

    public static final boolean shouldHideConstructorDueToInlineClassTypeValueParameters(@NotNull CallableMemberDescriptor descriptor) {
        ClassConstructorDescriptor classConstructorDescriptor;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (descriptor instanceof ClassConstructorDescriptor) {
            classConstructorDescriptor = (ClassConstructorDescriptor) descriptor;
        } else {
            classConstructorDescriptor = null;
        }
        if (classConstructorDescriptor == null || DescriptorVisibilities.isPrivate(classConstructorDescriptor.getVisibility())) {
            return false;
        }
        ClassDescriptor constructedClass = classConstructorDescriptor.getConstructedClass();
        Intrinsics.checkNotNullExpressionValue(constructedClass, "constructorDescriptor.constructedClass");
        if (InlineClassesUtilsKt.isInlineClass(constructedClass) || DescriptorUtils.isSealedClass(classConstructorDescriptor.getConstructedClass())) {
            return false;
        }
        List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "constructorDescriptor.valueParameters");
        List<ValueParameterDescriptor> list = valueParameters;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            KotlinType type = ((ValueParameterDescriptor) it.next()).getType();
            Intrinsics.checkNotNullExpressionValue(type, "it.type");
            if (requiresFunctionNameManglingInParameterTypes(type)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClassThatRequiresMangling(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor mo1779getDeclarationDescriptor = kotlinType.getConstructor().mo1779getDeclarationDescriptor();
        return mo1779getDeclarationDescriptor != null && isInlineClassThatRequiresMangling(mo1779getDeclarationDescriptor);
    }
}
