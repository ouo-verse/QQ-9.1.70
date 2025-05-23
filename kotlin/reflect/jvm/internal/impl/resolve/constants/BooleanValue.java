package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class BooleanValue extends ConstantValue<Boolean> {
    public BooleanValue(boolean z16) {
        super(Boolean.valueOf(z16));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    @NotNull
    public SimpleType getType(@NotNull ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        SimpleType booleanType = module.getBuiltIns().getBooleanType();
        Intrinsics.checkNotNullExpressionValue(booleanType, "module.builtIns.booleanType");
        return booleanType;
    }
}
