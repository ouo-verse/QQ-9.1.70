package com.tencent.state.square.components.fragment;

import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.data.BuildingBubble;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001J\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/state/square/components/fragment/SquareBuildingComponent$queryExtraBubbles$2", "Lcom/tencent/state/service/ResultCallback;", "", "", "Lcom/tencent/state/square/data/BuildingBubble;", "onResultSuccess", "", "result", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareBuildingComponent$queryExtraBubbles$2 implements ResultCallback<Map<Integer, BuildingBubble>> {
    final /* synthetic */ SquareBuildingComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SquareBuildingComponent$queryExtraBubbles$2(SquareBuildingComponent squareBuildingComponent) {
        this.this$0 = squareBuildingComponent;
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int i3, String str) {
        ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int i3, String str, String str2) {
        ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultSuccess(final Map<Integer, BuildingBubble> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareBuildingComponent$queryExtraBubbles$2$onResultSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ISquareViewUpdater updater;
                SquareView mapView = SquareBuildingComponent$queryExtraBubbles$2.this.this$0.getMapView();
                if (mapView == null || (updater = mapView.getUpdater()) == null) {
                    return;
                }
                updater.updateExtraBuildingBubble(result);
            }
        });
    }
}
