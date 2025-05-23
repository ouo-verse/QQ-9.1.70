package androidx.activity;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class OnBackPressedCallback {
    private CopyOnWriteArrayList<Cancellable> mCancellables = new CopyOnWriteArrayList<>();
    private boolean mEnabled;

    public OnBackPressedCallback(boolean z16) {
        this.mEnabled = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addCancellable(@NonNull Cancellable cancellable) {
        this.mCancellables.add(cancellable);
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public final boolean isEnabled() {
        return this.mEnabled;
    }

    @MainThread
    public final void remove() {
        Iterator<Cancellable> it = this.mCancellables.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeCancellable(@NonNull Cancellable cancellable) {
        this.mCancellables.remove(cancellable);
    }

    @MainThread
    public final void setEnabled(boolean z16) {
        this.mEnabled = z16;
    }
}
