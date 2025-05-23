package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMappingUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DescriptorsJvmAbiUtil {
    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        Object[] objArr = new Object[3];
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                objArr[0] = "propertyDescriptor";
            } else {
                objArr[0] = "memberDescriptor";
            }
        } else {
            objArr[0] = "companionObject";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    objArr[2] = "isPropertyWithBackingFieldInOuterClass";
                } else {
                    objArr[2] = "hasJvmFieldAnnotation";
                }
            } else {
                objArr[2] = "isMappedIntrinsicCompanionObject";
            }
        } else {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean hasJvmFieldAnnotation(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        FieldDescriptor backingField;
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(3);
        }
        if ((callableMemberDescriptor instanceof PropertyDescriptor) && (backingField = ((PropertyDescriptor) callableMemberDescriptor).getBackingField()) != null && backingField.getAnnotations().hasAnnotation(JvmAbi.JVM_FIELD_ANNOTATION_FQ_NAME)) {
            return true;
        }
        return callableMemberDescriptor.getAnnotations().hasAnnotation(JvmAbi.JVM_FIELD_ANNOTATION_FQ_NAME);
    }

    public static boolean isClassCompanionObjectWithBackingFieldsInOuter(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(1);
        }
        if (DescriptorUtils.isCompanionObject(declarationDescriptor) && DescriptorUtils.isClassOrEnumClass(declarationDescriptor.getContainingDeclaration()) && !isMappedIntrinsicCompanionObject((ClassDescriptor) declarationDescriptor)) {
            return true;
        }
        return false;
    }

    public static boolean isMappedIntrinsicCompanionObject(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(2);
        }
        return CompanionObjectMappingUtilsKt.isMappedIntrinsicCompanionObject(CompanionObjectMapping.INSTANCE, classDescriptor);
    }

    public static boolean isPropertyWithBackingFieldInOuterClass(@NotNull PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (propertyDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return false;
        }
        if (isClassCompanionObjectWithBackingFieldsInOuter(propertyDescriptor.getContainingDeclaration())) {
            return true;
        }
        if (!DescriptorUtils.isCompanionObject(propertyDescriptor.getContainingDeclaration()) || !hasJvmFieldAnnotation(propertyDescriptor)) {
            return false;
        }
        return true;
    }
}
