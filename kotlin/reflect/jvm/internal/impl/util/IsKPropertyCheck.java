package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
final class IsKPropertyCheck implements Check {

    @NotNull
    public static final IsKPropertyCheck INSTANCE = new IsKPropertyCheck();

    @NotNull
    private static final String description = "second parameter must be of type KProperty<*> or its supertype";

    IsKPropertyCheck() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        ValueParameterDescriptor secondParameter = functionDescriptor.getValueParameters().get(1);
        ReflectionTypes.Companion companion = ReflectionTypes.Companion;
        Intrinsics.checkNotNullExpressionValue(secondParameter, "secondParameter");
        KotlinType createKPropertyStarType = companion.createKPropertyStarType(DescriptorUtilsKt.getModule(secondParameter));
        if (createKPropertyStarType != null) {
            KotlinType type = secondParameter.getType();
            Intrinsics.checkNotNullExpressionValue(type, "secondParameter.type");
            return TypeUtilsKt.isSubtypeOf(createKPropertyStarType, TypeUtilsKt.makeNotNullable(type));
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @NotNull
    public String getDescription() {
        return description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }
}
