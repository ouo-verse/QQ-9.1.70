package com.tencent.state.template.map;

import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.tencent.state.data.Image;
import com.tencent.state.map.MapData;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewModel;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.template.data.CommonDataKt;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.SeatButtonState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/template/map/TemplateMapViewModel;", "Lcom/tencent/state/map/MapViewModel;", "()V", "_enterRoomInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/state/template/data/EnterRoomInfo;", "_seatButtonState", "Lcom/tencent/state/template/data/SeatButtonState;", "data", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/state/map/MapData;", "getData", "()Landroidx/lifecycle/LiveData;", "enterRoomInfo", "getEnterRoomInfo", "seatButtonState", "getSeatButtonState", "getMapDataList", "", "Lcom/tencent/state/map/MapItem;", "roomInfo", "Lcom/tencent/state/template/data/CommonRoomInfo;", "updateEnterRoomInfo", "", "info", "updateSeatButtonState", "state", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateMapViewModel extends MapViewModel {
    private static final String TAG = "TemplateMapViewModel";
    private final MutableLiveData<EnterRoomInfo> _enterRoomInfo;
    private final MutableLiveData<SeatButtonState> _seatButtonState;
    private final LiveData<MapData> data;
    private final LiveData<EnterRoomInfo> enterRoomInfo;
    private final LiveData<SeatButtonState> seatButtonState;

    public TemplateMapViewModel() {
        MutableLiveData<EnterRoomInfo> mutableLiveData = new MutableLiveData<>();
        this._enterRoomInfo = mutableLiveData;
        this.enterRoomInfo = mutableLiveData;
        LiveData<MapData> map = Transformations.map(mutableLiveData, new Function<EnterRoomInfo, MapData>() { // from class: com.tencent.state.template.map.TemplateMapViewModel$data$1
            @Override // androidx.arch.core.util.Function
            public final MapData apply(EnterRoomInfo enterRoomInfo) {
                Image image;
                List<MapItem> mapDataList = TemplateMapViewModel.this.getMapDataList(enterRoomInfo.getRoom());
                CommonRoomInfo room = enterRoomInfo.getRoom();
                if (room == null || (image = room.getBackground()) == null) {
                    image = new Image("", new Size(0, 0));
                }
                return new MapData(mapDataList, image, enterRoomInfo.getIsReenter(), false, 8, null);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "Transformations.map(_ent\u2026isReenter\n        )\n    }");
        this.data = map;
        MutableLiveData<SeatButtonState> mutableLiveData2 = new MutableLiveData<>();
        this._seatButtonState = mutableLiveData2;
        this.seatButtonState = mutableLiveData2;
        mutableLiveData.observeForever(new Observer<EnterRoomInfo>() { // from class: com.tencent.state.template.map.TemplateMapViewModel.1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(EnterRoomInfo enterRoomInfo) {
                TemplateMapViewModel templateMapViewModel = TemplateMapViewModel.this;
                SeatButtonState m254getSeatButtonState = templateMapViewModel.m254getSeatButtonState();
                CommonRoomInfo room = enterRoomInfo.getRoom();
                boolean z16 = false;
                boolean z17 = room != null && CommonDataKt.isRoomFull(room);
                CommonRoomInfo room2 = enterRoomInfo.getRoom();
                if (room2 != null && CommonDataKt.isMeSeated(room2)) {
                    z16 = true;
                }
                templateMapViewModel.updateSeatButtonState(m254getSeatButtonState.copy(z17, z16));
                SquareBaseKt.getSquareLog().i(TemplateMapViewModel.TAG, "onRoomInfoUpdate: state=" + ((SeatButtonState) TemplateMapViewModel.this._seatButtonState.getValue()));
            }
        });
    }

    @Override // com.tencent.state.map.MapViewModel
    public LiveData<MapData> getData() {
        return this.data;
    }

    public final LiveData<EnterRoomInfo> getEnterRoomInfo() {
        return this.enterRoomInfo;
    }

    public abstract List<MapItem> getMapDataList(CommonRoomInfo roomInfo);

    public final LiveData<SeatButtonState> getSeatButtonState() {
        return this.seatButtonState;
    }

    public final void updateEnterRoomInfo(EnterRoomInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this._enterRoomInfo.postValue(info);
    }

    public final void updateSeatButtonState(SeatButtonState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this._seatButtonState.postValue(state);
    }

    /* renamed from: getSeatButtonState, reason: collision with other method in class */
    public final SeatButtonState m254getSeatButtonState() {
        SeatButtonState value = this._seatButtonState.getValue();
        return value != null ? value : new SeatButtonState(false, false);
    }
}
