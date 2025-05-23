package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.SynchronizationKt;
import androidx.compose.runtime.SynchronizedObject;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"sync", "Landroidx/compose/runtime/SynchronizedObject;", "modificationError", "", "validateRange", "", "index", "", "size", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class SnapshotStateListKt {
    private static final SynchronizedObject sync = SynchronizationKt.createSynchronizedObject();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void modificationError() {
        throw new IllegalStateException("Cannot modify a state list through an iterator".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateRange(int i3, int i16) {
        boolean z16 = false;
        if (i3 >= 0 && i3 < i16) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        throw new IndexOutOfBoundsException("index (" + i3 + ") is out of bound of [0, " + i16 + ')');
    }
}
