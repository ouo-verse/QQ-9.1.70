package android.arch.lifecycle;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class Lifecycle {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(@NonNull State state) {
            if (compareTo(state) >= 0) {
                return true;
            }
            return false;
        }
    }

    @MainThread
    public abstract void addObserver(@NonNull LifecycleObserver lifecycleObserver);

    @NonNull
    @MainThread
    public abstract State getCurrentState();

    @MainThread
    public abstract void removeObserver(@NonNull LifecycleObserver lifecycleObserver);
}
