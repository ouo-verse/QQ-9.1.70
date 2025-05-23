package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Landroidx/compose/runtime/HotReloader;", "", "()V", "Companion", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
final class HotReloader {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0001H\u0002J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0002J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0001H\u0000\u00a2\u0006\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Landroidx/compose/runtime/HotReloader$Companion;", "", "()V", "invalidateGroupsWithKey", "", "key", "", "invalidateGroupsWithKey$runtime_release", "loadStateAndCompose", "token", "saveStateAndDispose", "context", "simulateHotReload", "simulateHotReload$runtime_release", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void loadStateAndCompose(Object token) {
            Recomposer.INSTANCE.loadStateAndComposeForHotReload$runtime_release(token);
        }

        private final Object saveStateAndDispose(Object context) {
            return Recomposer.INSTANCE.saveStateAndDisposeForHotReload$runtime_release();
        }

        public final void invalidateGroupsWithKey$runtime_release(int key) {
            Recomposer.INSTANCE.invalidateGroupsWithKey$runtime_release(key);
        }

        public final void simulateHotReload$runtime_release(Object context) {
            Intrinsics.checkNotNullParameter(context, "context");
            loadStateAndCompose(saveStateAndDispose(context));
        }

        private Companion() {
        }
    }
}
