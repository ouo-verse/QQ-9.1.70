package android.arch.lifecycle;

import android.arch.core.internal.SafeIterableMap;
import android.support.annotation.CallSuper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> mSources = new SafeIterableMap<>();

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class Source<V> implements Observer<V> {
        final LiveData<V> mLiveData;
        final Observer<V> mObserver;
        int mVersion = -1;

        Source(LiveData<V> liveData, Observer<V> observer) {
            this.mLiveData = liveData;
            this.mObserver = observer;
        }

        @Override // android.arch.lifecycle.Observer
        public void onChanged(@Nullable V v3) {
            if (this.mVersion != this.mLiveData.getVersion()) {
                this.mVersion = this.mLiveData.getVersion();
                this.mObserver.onChanged(v3);
            }
        }

        void plug() {
            this.mLiveData.observeForever(this);
        }

        void unplug() {
            this.mLiveData.removeObserver(this);
        }
    }

    @MainThread
    public <S> void addSource(@NonNull LiveData<S> liveData, @NonNull Observer<S> observer) {
        Source<?> source = new Source<>(liveData, observer);
        Source<?> putIfAbsent = this.mSources.putIfAbsent(liveData, source);
        if (putIfAbsent != null && putIfAbsent.mObserver != observer) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (putIfAbsent == null && hasActiveObservers()) {
            source.plug();
        }
    }

    @Override // android.arch.lifecycle.LiveData
    @CallSuper
    protected void onActive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            it.next().getValue().plug();
        }
    }

    @Override // android.arch.lifecycle.LiveData
    @CallSuper
    protected void onInactive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            it.next().getValue().unplug();
        }
    }

    @MainThread
    public <S> void removeSource(@NonNull LiveData<S> liveData) {
        Source<?> remove = this.mSources.remove(liveData);
        if (remove != null) {
            remove.unplug();
        }
    }
}
