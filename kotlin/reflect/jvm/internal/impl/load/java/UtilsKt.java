package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class UtilsKt {
    public static final boolean hasErasedValueParameters(@NotNull CallableMemberDescriptor memberDescriptor) {
        Intrinsics.checkNotNullParameter(memberDescriptor, "memberDescriptor");
        if ((memberDescriptor instanceof FunctionDescriptor) && Intrinsics.areEqual(memberDescriptor.getUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS), Boolean.TRUE)) {
            return true;
        }
        return false;
    }

    public static final boolean isJspecifyEnabledInStrictMode(@NotNull JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        if (javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) == ReportLevel.STRICT) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final DescriptorVisibility toDescriptorVisibility(@NotNull Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "<this>");
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.toDescriptorVisibility(visibility);
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(this)");
        return descriptorVisibility;
    }
}
