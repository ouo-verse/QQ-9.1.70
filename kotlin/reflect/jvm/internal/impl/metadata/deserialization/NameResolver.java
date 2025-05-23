package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface NameResolver {
    @NotNull
    String getQualifiedClassName(int i3);

    @NotNull
    String getString(int i3);

    boolean isLocalClassName(int i3);
}
