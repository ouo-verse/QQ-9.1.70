package com.tencent.state.map;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/map/MapViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_data", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/state/map/MapData;", "data", "Landroidx/lifecycle/LiveData;", "getData", "()Landroidx/lifecycle/LiveData;", "updateMapData", "", "newData", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public class MapViewModel extends ViewModel {
    private final MutableLiveData<MapData> _data;
    private final LiveData<MapData> data;

    public MapViewModel() {
        MutableLiveData<MapData> mutableLiveData = new MutableLiveData<>();
        this._data = mutableLiveData;
        this.data = mutableLiveData;
    }

    public LiveData<MapData> getData() {
        return this.data;
    }

    public void updateMapData(MapData newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        this._data.postValue(newData);
    }
}
