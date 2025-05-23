package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface VariableDescriptor extends ValueDescriptor {
    @Nullable
    /* renamed from: getCompileTimeInitializer */
    ConstantValue<?> mo1775getCompileTimeInitializer();

    boolean isConst();

    boolean isLateInit();

    boolean isVar();
}
