package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaTypeAttributesKt {
    @NotNull
    public static final JavaTypeAttributes toAttributes(@NotNull TypeUsage typeUsage, boolean z16, boolean z17, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        Set set;
        Intrinsics.checkNotNullParameter(typeUsage, "<this>");
        if (typeParameterDescriptor != null) {
            set = SetsKt__SetsJVMKt.setOf(typeParameterDescriptor);
        } else {
            set = null;
        }
        return new JavaTypeAttributes(typeUsage, null, z17, z16, set, null, 34, null);
    }

    public static /* synthetic */ JavaTypeAttributes toAttributes$default(TypeUsage typeUsage, boolean z16, boolean z17, TypeParameterDescriptor typeParameterDescriptor, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        if ((i3 & 4) != 0) {
            typeParameterDescriptor = null;
        }
        return toAttributes(typeUsage, z16, z17, typeParameterDescriptor);
    }
}
