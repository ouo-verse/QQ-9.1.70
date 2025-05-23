package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public final class JavaForKotlinOverridePropertyDescriptor extends JavaPropertyDescriptor {

    @NotNull
    private final SimpleFunctionDescriptor getterMethod;

    @NotNull
    private final PropertyDescriptor overriddenProperty;

    @Nullable
    private final SimpleFunctionDescriptor setterMethod;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JavaForKotlinOverridePropertyDescriptor(@NotNull ClassDescriptor ownerDescriptor, @NotNull SimpleFunctionDescriptor getterMethod, @Nullable SimpleFunctionDescriptor simpleFunctionDescriptor, @NotNull PropertyDescriptor overriddenProperty) {
        super(ownerDescriptor, r2, r3, r4, r0, overriddenProperty.getName(), getterMethod.getSource(), null, CallableMemberDescriptor.Kind.DECLARATION, false, null);
        boolean z16;
        Intrinsics.checkNotNullParameter(ownerDescriptor, "ownerDescriptor");
        Intrinsics.checkNotNullParameter(getterMethod, "getterMethod");
        Intrinsics.checkNotNullParameter(overriddenProperty, "overriddenProperty");
        Annotations empty = Annotations.Companion.getEMPTY();
        Modality modality = getterMethod.getModality();
        DescriptorVisibility visibility = getterMethod.getVisibility();
        if (simpleFunctionDescriptor != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.getterMethod = getterMethod;
        this.setterMethod = simpleFunctionDescriptor;
        this.overriddenProperty = overriddenProperty;
    }
}
