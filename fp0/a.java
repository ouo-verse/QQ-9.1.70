package fp0;

import androidx.collection.ArraySet;
import ip0.d;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\b\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\f\u001a\u00020\u0004R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lfp0/a;", "", "Lip0/d;", "listener", "", "a", "", "listeners", "b", "Lcp0/a;", "selectedItem", "c", "d", "Landroidx/collection/ArraySet;", "Landroidx/collection/ArraySet;", "mListeners", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArraySet<d> mListeners = new ArraySet<>();

    public final void a(@Nullable d listener) {
        if (listener != null) {
            this.mListeners.add(listener);
        }
    }

    public final void b(@Nullable Collection<? extends d> listeners) {
        if (listeners != null) {
            this.mListeners.addAll(listeners);
        }
    }

    public final void c(@Nullable cp0.a selectedItem) {
        if (!this.mListeners.isEmpty()) {
            Iterator<E> it = new ArraySet((ArraySet) this.mListeners).iterator();
            while (it.hasNext()) {
                ((d) it.next()).c(selectedItem);
            }
        }
    }

    public final void d() {
        if (!this.mListeners.isEmpty()) {
            Iterator<E> it = new ArraySet((ArraySet) this.mListeners).iterator();
            while (it.hasNext()) {
                ((d) it.next()).f();
            }
        }
    }
}
