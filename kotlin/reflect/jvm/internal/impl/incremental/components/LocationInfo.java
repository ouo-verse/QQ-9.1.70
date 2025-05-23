package kotlin.reflect.jvm.internal.impl.incremental.components;

import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface LocationInfo {
    @NotNull
    String getFilePath();

    @NotNull
    Position getPosition();
}
