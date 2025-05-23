package android.arch.lifecycle;

import android.arch.core.util.Function;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public class Transformations {
    Transformations() {
    }

    @MainThread
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> liveData, @NonNull final Function<X, Y> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: android.arch.lifecycle.Transformations.1
            @Override // android.arch.lifecycle.Observer
            public void onChanged(@Nullable X x16) {
                MediatorLiveData.this.setValue(function.apply(x16));
            }
        });
        return mediatorLiveData;
    }

    @MainThread
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> liveData, @NonNull final Function<X, LiveData<Y>> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: android.arch.lifecycle.Transformations.2
            LiveData<Y> mSource;

            @Override // android.arch.lifecycle.Observer
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
                    mediatorLiveData.addSource(liveData2, new Observer<Y>() { // from class: android.arch.lifecycle.Transformations.2.1
                        @Override // android.arch.lifecycle.Observer
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
