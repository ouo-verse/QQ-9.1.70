package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class Visibility {
    private final boolean isPublicAPI;

    @NotNull
    private final String name;

    /* JADX INFO: Access modifiers changed from: protected */
    public Visibility(@NotNull String name, boolean z16) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.isPublicAPI = z16;
    }

    @Nullable
    public Integer compareTo(@NotNull Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        return Visibilities.INSTANCE.compareLocal$compiler_common(this, visibility);
    }

    @NotNull
    public String getInternalDisplayName() {
        return this.name;
    }

    public final boolean isPublicAPI() {
        return this.isPublicAPI;
    }

    @NotNull
    public final String toString() {
        return getInternalDisplayName();
    }

    @NotNull
    public Visibility normalize() {
        return this;
    }
}
