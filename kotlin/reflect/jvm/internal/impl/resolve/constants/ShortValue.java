package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ShortValue extends IntegerValueConstant<Short> {
    public ShortValue(short s16) {
        super(Short.valueOf(s16));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    @NotNull
    public String toString() {
        return getValue().intValue() + ".toShort()";
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    @NotNull
    public SimpleType getType(@NotNull ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        SimpleType shortType = module.getBuiltIns().getShortType();
        Intrinsics.checkNotNullExpressionValue(shortType, "module.builtIns.shortType");
        return shortType;
    }
}
