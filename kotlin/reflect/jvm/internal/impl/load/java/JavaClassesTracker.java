package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface JavaClassesTracker {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Default implements JavaClassesTracker {

        @NotNull
        public static final Default INSTANCE = new Default();

        Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker
        public void reportClass(@NotNull JavaClassDescriptor classDescriptor) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        }
    }

    void reportClass(@NotNull JavaClassDescriptor javaClassDescriptor);
}
