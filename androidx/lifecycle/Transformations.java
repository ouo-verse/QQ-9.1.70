package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

/* compiled from: P */
/* loaded from: classes.dex */
public class Transformations {
    Transformations() {
    }

    @NonNull
    @MainThread
    public static <X> LiveData<X> distinctUntilChanged(@NonNull LiveData<X> liveData) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.3
            boolean mFirstTime = true;

            @Override // androidx.lifecycle.Observer
            public void onChanged(X x16) {
                T value = MediatorLiveData.this.getValue();
                if (this.mFirstTime || ((value == 0 && x16 != null) || (value != 0 && !value.equals(x16)))) {
                    this.mFirstTime = false;
                    MediatorLiveData.this.setValue(x16);
                }
            }
        });
        return mediatorLiveData;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> liveData, @NonNull final Function<X, Y> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable X x16) {
                MediatorLiveData.this.setValue(function.apply(x16));
            }
        });
        return mediatorLiveData;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> liveData, @NonNull final Function<X, LiveData<Y>> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.2
            LiveData<Y> mSource;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable X x16) {
                LiveData<Y> liveData2 = (LiveData) Function.this.apply(x16);
                Object obj = this.mSource;
                if (obj == liveData2) {
                    return;
                }
                if (obj != null) {
                    mediatorLiveData.removeSource(obj);
                }
                this.mSource = liveData2;
                if (liveData2 != 0) {
                    mediatorLiveData.addSource(liveData2, new Observer<Y>() { // from class: androidx.lifecycle.Transformations.2.1
                        @Override // androidx.lifecycle.Observer
                        public void onChanged(@Nullable Y y16) {
                            mediatorLiveData.setValue(y16);
                        }
                    });
                }
            }
        });
        return mediatorLiveData;
    }
}
