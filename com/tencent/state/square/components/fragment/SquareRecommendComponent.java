package com.tencent.state.square.components.fragment;

import android.util.Size;
import com.tencent.state.map.MapData;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.SquareRecommendUserItem;
import com.tencent.state.square.mayknow.MayKnowService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareRecommendComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "onMapDataReceived", "", "data", "Lcom/tencent/state/map/MapData;", "queryRecommendUser", "mapSize", "Landroid/util/Size;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareRecommendComponent extends SquareBaseComponent {
    private final void queryRecommendUser(Size mapSize) {
        MayKnowService.INSTANCE.getSquareRecommendUsers(mapSize, new ResultCallback<List<SquareRecommendUserItem>>() { // from class: com.tencent.state.square.components.fragment.SquareRecommendComponent$queryRecommendUser$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(List<SquareRecommendUserItem> result) {
                ISquareViewUpdater updater;
                Intrinsics.checkNotNullParameter(result, "result");
                SquareView mapView = SquareRecommendComponent.this.getMapView();
                if (mapView == null || (updater = mapView.getUpdater()) == null) {
                    return;
                }
                updater.appendOrUpdateRecommendUserItem(result);
            }
        });
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onMapDataReceived(MapData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getFromCache()) {
            return;
        }
        Size size = data.getBackground().getSize();
        Square square = Square.INSTANCE;
        queryRecommendUser(new Size(ViewExtensionsKt.calPt(square.getApplication(), size.getWidth()), ViewExtensionsKt.calPt(square.getApplication(), size.getHeight())));
    }
}
