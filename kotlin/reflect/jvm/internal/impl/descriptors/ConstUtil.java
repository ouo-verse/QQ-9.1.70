package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ConstUtil {

    @NotNull
    public static final ConstUtil INSTANCE = new ConstUtil();

    ConstUtil() {
    }

    @JvmStatic
    public static final boolean canBeUsedForConstVal(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return ConstUtilKt.canBeUsedForConstVal(type);
    }
}
