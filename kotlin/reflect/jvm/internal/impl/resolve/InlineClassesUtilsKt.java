package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class InlineClassesUtilsKt {

    @NotNull
    private static final ClassId JVM_INLINE_ANNOTATION_CLASS_ID;

    @NotNull
    private static final FqName JVM_INLINE_ANNOTATION_FQ_NAME;

    static {
        FqName fqName = new FqName("kotlin.jvm.JvmInline");
        JVM_INLINE_ANNOTATION_FQ_NAME = fqName;
        ClassId classId = ClassId.topLevel(fqName);
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(JVM_INLINE_ANNOTATION_FQ_NAME)");
        JVM_INLINE_ANNOTATION_CLASS_ID = classId;
    }

    public static final boolean isGetterOfUnderlyingPropertyOfInlineClass(@NotNull CallableDescriptor callableDescriptor) {
        Intrinsics.checkNotNullParameter(callableDescriptor, "<this>");
        if (callableDescriptor instanceof PropertyGetterDescriptor) {
            PropertyDescriptor correspondingProperty = ((PropertyGetterDescriptor) callableDescriptor).getCorrespondingProperty();
            Intrinsics.checkNotNullExpressionValue(correspondingProperty, "correspondingProperty");
            if (isUnderlyingPropertyOfInlineClass(correspondingProperty)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClass(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        if ((declarationDescriptor instanceof ClassDescriptor) && (((ClassDescriptor) declarationDescriptor).getValueClassRepresentation() instanceof InlineClassRepresentation)) {
            return true;
        }
        return false;
    }

    public static final boolean isInlineClassType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor mo1779getDeclarationDescriptor = kotlinType.getConstructor().mo1779getDeclarationDescriptor();
        if (mo1779getDeclarationDescriptor != null) {
            return isInlineClass(mo1779getDeclarationDescriptor);
        }
        return false;
    }

    public static final boolean isUnderlyingPropertyOfInlineClass(@NotNull VariableDescriptor variableDescriptor) {
        ClassDescriptor classDescriptor;
        InlineClassRepresentation<SimpleType> inlineClassRepresentation;
        Intrinsics.checkNotNullParameter(variableDescriptor, "<this>");
        if (variableDescriptor.getExtensionReceiverParameter() == null) {
            DeclarationDescriptor containingDeclaration = variableDescriptor.getContainingDeclaration();
            Name name = null;
            if (containingDeclaration instanceof ClassDescriptor) {
                classDescriptor = (ClassDescriptor) containingDeclaration;
            } else {
                classDescriptor = null;
            }
            if (classDescriptor != null && (inlineClassRepresentation = DescriptorUtilsKt.getInlineClassRepresentation(classDescriptor)) != null) {
                name = inlineClassRepresentation.getUnderlyingPropertyName();
            }
            if (Intrinsics.areEqual(name, variableDescriptor.getName())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static final KotlinType unsubstitutedUnderlyingType(@NotNull KotlinType kotlinType) {
        InlineClassRepresentation<SimpleType> inlineClassRepresentation;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor mo1779getDeclarationDescriptor = kotlinType.getConstructor().mo1779getDeclarationDescriptor();
        if (!(mo1779getDeclarationDescriptor instanceof ClassDescriptor)) {
            mo1779getDeclarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) mo1779getDeclarationDescriptor;
        if (classDescriptor == null || (inlineClassRepresentation = DescriptorUtilsKt.getInlineClassRepresentation(classDescriptor)) == null) {
            return null;
        }
        return inlineClassRepresentation.getUnderlyingType();
    }
}
