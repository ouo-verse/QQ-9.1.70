package kotlin.reflect.jvm.internal.impl.incremental.components;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface LookupTracker {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class DO_NOTHING implements LookupTracker {

        @NotNull
        public static final DO_NOTHING INSTANCE = new DO_NOTHING();

        DO_NOTHING() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public boolean getRequiresPosition() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public void record(@NotNull String filePath, @NotNull Position position, @NotNull String scopeFqName, @NotNull ScopeKind scopeKind, @NotNull String name) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(position, "position");
            Intrinsics.checkNotNullParameter(scopeFqName, "scopeFqName");
            Intrinsics.checkNotNullParameter(scopeKind, "scopeKind");
            Intrinsics.checkNotNullParameter(name, "name");
        }
    }

    boolean getRequiresPosition();

    void record(@NotNull String str, @NotNull Position position, @NotNull String str2, @NotNull ScopeKind scopeKind, @NotNull String str3);
}
