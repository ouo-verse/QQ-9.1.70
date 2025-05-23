package com.tencent.state.square;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.state.map.MapData;
import com.tencent.state.map.MapViewModel;
import com.tencent.state.square.data.SquareStyleInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\"\u0010\u0018\u001a\u00020\u00172\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0015\u0010\u001b\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u001cR(\u0010\u0003\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/square/SquareMapViewModel;", "Lcom/tencent/state/map/MapViewModel;", "()V", "_buildingInfos", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/tencent/state/square/data/SquareStyleInfo;", "Lkotlin/collections/ArrayList;", "_newData", "Lcom/tencent/state/map/MapData;", "_tipType", "", "buildingInfos", "Landroidx/lifecycle/LiveData;", "getBuildingInfos", "()Landroidx/lifecycle/LiveData;", "newData", "getNewData", "tipType", "getTipType", "checkCacheSceneNetworkData", "", "onCleared", "", "updateBuildingInfos", "data", "updateMapData", "updateTipType", "(Ljava/lang/Integer;)V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareMapViewModel extends MapViewModel {
    private static final String TAG = "SquareMapViewModel";
    private final MutableLiveData<ArrayList<SquareStyleInfo>> _buildingInfos;
    private final MutableLiveData<MapData> _newData;
    private final MutableLiveData<Integer> _tipType;
    private final LiveData<ArrayList<SquareStyleInfo>> buildingInfos;
    private final LiveData<MapData> newData;
    private final LiveData<Integer> tipType;

    public SquareMapViewModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._tipType = mutableLiveData;
        this.tipType = mutableLiveData;
        MutableLiveData<ArrayList<SquareStyleInfo>> mutableLiveData2 = new MutableLiveData<>();
        this._buildingInfos = mutableLiveData2;
        this.buildingInfos = mutableLiveData2;
        MutableLiveData<MapData> mutableLiveData3 = new MutableLiveData<>();
        this._newData = mutableLiveData3;
        this.newData = mutableLiveData3;
    }

    public final boolean checkCacheSceneNetworkData() {
        MapData value = getData().getValue();
        return (value != null && value.getFromCache() && this.newData.getValue() == null) ? false : true;
    }

    public final LiveData<ArrayList<SquareStyleInfo>> getBuildingInfos() {
        return this.buildingInfos;
    }

    public final LiveData<MapData> getNewData() {
        return this.newData;
    }

    public final LiveData<Integer> getTipType() {
        return this.tipType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SquareBaseKt.getSquareLog().i(TAG, "onCleared");
    }

    @Override // com.tencent.state.map.MapViewModel
    public void updateMapData(MapData newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        MapData value = getData().getValue();
        if (value != null) {
            if (newData.getDataList().isEmpty()) {
                return;
            }
            if (!value.getBackground().isSame(newData.getBackground())) {
                newData.setReenter(true);
                super.updateMapData(newData);
                return;
            }
            this._newData.postValue(newData);
        } else {
            super.updateMapData(newData);
        }
        SquareBaseKt.getSquareLog().i(TAG, "updateMapData: useCache=" + newData.getFromCache());
    }

    public final void updateBuildingInfos(ArrayList<SquareStyleInfo> data) {
        if (data != null) {
            this._buildingInfos.setValue(data);
        }
    }

    public final void updateTipType(Integer data) {
        if (data != null) {
            data.intValue();
            this._tipType.setValue(data);
        }
    }
}
