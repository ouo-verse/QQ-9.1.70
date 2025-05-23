package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
@Deprecated
/* loaded from: classes.dex */
public class AIOLifecycleRegistry extends Lifecycle {
    private int mAddingObserverCounter;
    private final boolean mEnforceMainThread;
    private boolean mHandlingEvent;
    private final WeakReference<LifecycleOwner> mLifecycleOwner;
    private boolean mNewEventOccurred;
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> mObserverMap;
    private ArrayList<Lifecycle.State> mParentStates;
    private Lifecycle.State mState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ObserverWithState {
        LifecycleEventObserver mLifecycleObserver;
        Lifecycle.State mState;

        ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            this.mLifecycleObserver = Lifecycling.lifecycleEventObserver(lifecycleObserver);
            this.mState = state;
        }

        void dispatchEvent(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State targetState = event.getTargetState();
            this.mState = AIOLifecycleRegistry.min(this.mState, targetState);
            this.mLifecycleObserver.onStateChanged(lifecycleOwner, event);
            this.mState = targetState;
        }
    }

    public AIOLifecycleRegistry(@NonNull LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, true);
    }

    private void backwardPass(LifecycleOwner lifecycleOwner) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> descendingIterator = this.mObserverMap.descendingIterator();
        while (descendingIterator.hasNext() && !this.mNewEventOccurred) {
            Map.Entry<LifecycleObserver, ObserverWithState> next = descendingIterator.next();
            ObserverWithState value = next.getValue();
            while (value.mState.compareTo(this.mState) > 0 && !this.mNewEventOccurred && this.mObserverMap.contains(next.getKey())) {
                Lifecycle.Event downFrom = Lifecycle.Event.downFrom(value.mState);
                if (downFrom != null) {
                    pushParentState(downFrom.getTargetState());
                    value.dispatchEvent(lifecycleOwner, downFrom);
                    popParentState();
                } else {
                    throw new IllegalStateException("no event down from " + value.mState);
                }
            }
        }
    }

    private Lifecycle.State calculateTargetState(LifecycleObserver lifecycleObserver) {
        Lifecycle.State state;
        Map.Entry<LifecycleObserver, ObserverWithState> ceil = this.mObserverMap.ceil(lifecycleObserver);
        Lifecycle.State state2 = null;
        if (ceil != null) {
            state = ceil.getValue().mState;
        } else {
            state = null;
        }
        if (!this.mParentStates.isEmpty()) {
            state2 = this.mParentStates.get(r0.size() - 1);
        }
        return min(min(this.mState, state), state2);
    }

    @SuppressLint({"RestrictedApi"})
    private void enforceMainThreadIfNeeded(String str) {
        if (this.mEnforceMainThread && !ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException("Method " + str + " must be called on the main thread");
        }
    }

    private void forwardPass(LifecycleOwner lifecycleOwner) {
        SafeIterableMap<LifecycleObserver, ObserverWithState>.IteratorWithAdditions iteratorWithAdditions = this.mObserverMap.iteratorWithAdditions();
        while (iteratorWithAdditions.hasNext() && !this.mNewEventOccurred) {
            Map.Entry next = iteratorWithAdditions.next();
            ObserverWithState observerWithState = (ObserverWithState) next.getValue();
            while (observerWithState.mState.compareTo(this.mState) < 0 && !this.mNewEventOccurred && this.mObserverMap.contains((LifecycleObserver) next.getKey())) {
                pushParentState(observerWithState.mState);
                Lifecycle.Event upFrom = Lifecycle.Event.upFrom(observerWithState.mState);
                if (upFrom != null) {
                    observerWithState.dispatchEvent(lifecycleOwner, upFrom);
                    popParentState();
                } else {
                    throw new IllegalStateException("no event up from " + observerWithState.mState);
                }
            }
        }
    }

    private boolean isSynced() {
        if (this.mObserverMap.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.mObserverMap.eldest().getValue().mState;
        Lifecycle.State state2 = this.mObserverMap.newest().getValue().mState;
        if (state == state2 && this.mState == state2) {
            return true;
        }
        return false;
    }

    static Lifecycle.State min(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        if (state2 != null && state2.compareTo(state) < 0) {
            return state2;
        }
        return state;
    }

    private void moveToState(Lifecycle.State state) {
        if (this.mState == state) {
            return;
        }
        this.mState = state;
        if (!this.mHandlingEvent && this.mAddingObserverCounter == 0) {
            this.mHandlingEvent = true;
            sync();
            this.mHandlingEvent = false;
            return;
        }
        this.mNewEventOccurred = true;
    }

    private void popParentState() {
        this.mParentStates.remove(r0.size() - 1);
    }

    private void pushParentState(Lifecycle.State state) {
        this.mParentStates.add(state);
    }

    private void sync() {
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner.get();
        if (lifecycleOwner != null) {
            while (!isSynced()) {
                this.mNewEventOccurred = false;
                if (this.mState.compareTo(this.mObserverMap.eldest().getValue().mState) < 0) {
                    backwardPass(lifecycleOwner);
                }
                Map.Entry<LifecycleObserver, ObserverWithState> newest = this.mObserverMap.newest();
                if (!this.mNewEventOccurred && newest != null && this.mState.compareTo(newest.getValue().mState) > 0) {
                    forwardPass(lifecycleOwner);
                }
            }
            this.mNewEventOccurred = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005a A[Catch: all -> 0x008b, LOOP:0: B:22:0x003d->B:28:0x005a, LOOP_END, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x000a, B:8:0x0019, B:11:0x001b, B:13:0x0025, B:15:0x0027, B:17:0x002c, B:21:0x0034, B:22:0x003d, B:24:0x0045, B:26:0x004d, B:28:0x005a, B:30:0x0065, B:31:0x007e, B:34:0x0081, B:35:0x0084, B:36:0x0089, B:40:0x0008), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081 A[Catch: all -> 0x008b, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x000a, B:8:0x0019, B:11:0x001b, B:13:0x0025, B:15:0x0027, B:17:0x002c, B:21:0x0034, B:22:0x003d, B:24:0x0045, B:26:0x004d, B:28:0x005a, B:30:0x0065, B:31:0x007e, B:34:0x0081, B:35:0x0084, B:36:0x0089, B:40:0x0008), top: B:2:0x0001 }] */
    @Override // androidx.lifecycle.Lifecycle
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addObserver(@NonNull LifecycleObserver lifecycleObserver) {
        boolean z16;
        Lifecycle.State calculateTargetState;
        Lifecycle.Event upFrom;
        synchronized (this) {
            Lifecycle.State state = this.mState;
            Lifecycle.State state2 = Lifecycle.State.DESTROYED;
            if (state != state2) {
                state2 = Lifecycle.State.INITIALIZED;
            }
            ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, state2);
            if (this.mObserverMap.putIfAbsent(lifecycleObserver, observerWithState) != null) {
                return;
            }
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner.get();
            if (lifecycleOwner == null) {
                return;
            }
            if (this.mAddingObserverCounter == 0 && !this.mHandlingEvent) {
                z16 = false;
                calculateTargetState = calculateTargetState(lifecycleObserver);
                this.mAddingObserverCounter++;
                while (observerWithState.mState.compareTo(calculateTargetState) < 0 && this.mObserverMap.contains(lifecycleObserver)) {
                    pushParentState(observerWithState.mState);
                    upFrom = Lifecycle.Event.upFrom(observerWithState.mState);
                    if (upFrom == null) {
                        observerWithState.dispatchEvent(lifecycleOwner, upFrom);
                        popParentState();
                        calculateTargetState = calculateTargetState(lifecycleObserver);
                    } else {
                        throw new IllegalStateException("no event up from " + observerWithState.mState);
                    }
                }
                if (!z16) {
                    sync();
                }
                this.mAddingObserverCounter--;
            }
            z16 = true;
            calculateTargetState = calculateTargetState(lifecycleObserver);
            this.mAddingObserverCounter++;
            while (observerWithState.mState.compareTo(calculateTargetState) < 0) {
                pushParentState(observerWithState.mState);
                upFrom = Lifecycle.Event.upFrom(observerWithState.mState);
                if (upFrom == null) {
                }
            }
            if (!z16) {
            }
            this.mAddingObserverCounter--;
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    @NonNull
    public Lifecycle.State getCurrentState() {
        return this.mState;
    }

    public int getObserverCount() {
        enforceMainThreadIfNeeded("getObserverCount");
        return this.mObserverMap.size();
    }

    public void handleLifecycleEvent(@NonNull Lifecycle.Event event) {
        synchronized (this) {
            moveToState(event.getTargetState());
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(@NonNull LifecycleObserver lifecycleObserver) {
        synchronized (this) {
            this.mObserverMap.remove(lifecycleObserver);
        }
    }

    AIOLifecycleRegistry(@NonNull LifecycleOwner lifecycleOwner, boolean z16) {
        this.mObserverMap = new FastSafeIterableMap<>();
        this.mAddingObserverCounter = 0;
        this.mHandlingEvent = false;
        this.mNewEventOccurred = false;
        this.mParentStates = new ArrayList<>();
        this.mLifecycleOwner = new WeakReference<>(lifecycleOwner);
        this.mState = Lifecycle.State.INITIALIZED;
        this.mEnforceMainThread = z16;
    }
}
