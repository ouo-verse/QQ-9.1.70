package androidx.room;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes.dex */
class InvalidationLiveDataContainer {
    private final RoomDatabase mDatabase;

    @VisibleForTesting
    final Set<LiveData> mLiveDataSet = Collections.newSetFromMap(new IdentityHashMap());

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvalidationLiveDataContainer(RoomDatabase roomDatabase) {
        this.mDatabase = roomDatabase;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> LiveData<T> create(String[] strArr, boolean z16, Callable<T> callable) {
        return new RoomTrackingLiveData(this.mDatabase, this, z16, callable, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActive(LiveData liveData) {
        this.mLiveDataSet.add(liveData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInactive(LiveData liveData) {
        this.mLiveDataSet.remove(liveData);
    }
}
