package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaDescriptorUtilKt {
    public static final boolean isJavaField(@NotNull PropertyDescriptor propertyDescriptor) {
        Intrinsics.checkNotNullParameter(propertyDescriptor, "<this>");
        if (propertyDescriptor.getGetter() == null) {
            return true;
        }
        return false;
    }
}
