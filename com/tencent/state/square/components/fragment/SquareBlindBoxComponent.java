package com.tencent.state.square.components.fragment;

import com.tencent.state.map.MapData;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasBlindBoxService;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.api.OpenHippyParams;
import com.tencent.state.square.api.SquareHippyConst;
import com.tencent.state.square.data.SquareBlindBoxEntranceInfo;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareBlindBoxComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "getBlindBoxEntrance", "", "onMapDataReceived", "data", "Lcom/tencent/state/map/MapData;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareBlindBoxComponent extends SquareBaseComponent {
    private static final String TAG = "Square_SquareBlindBoxComponent";

    private final void getBlindBoxEntrance() {
        VasBlindBoxService.getBlindBoxEntrance$default(VasBlindBoxService.INSTANCE, 0, new ResultCallback<SquareBlindBoxEntranceInfo>() { // from class: com.tencent.state.square.components.fragment.SquareBlindBoxComponent$getBlindBoxEntrance$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(SquareBlindBoxEntranceInfo result) {
                ISquareViewUpdater updater;
                Intrinsics.checkNotNullParameter(result, "result");
                String linkUrl = result.getLinkUrl();
                if (!(linkUrl == null || linkUrl.length() == 0) && result.isShow()) {
                    URLDecoder.decode(result.getLinkUrl(), "UTF-8");
                    SquareBase.INSTANCE.getConfig().getHippyEngine().preloadHippyPage(new OpenHippyParams(SquareHippyConst.SQUARE_HIPPY_BUNDLE_NAME, "vip.qq.com", result.getLinkUrl()));
                    SquareView mapView = SquareBlindBoxComponent.this.getMapView();
                    if (mapView == null || (updater = mapView.getUpdater()) == null) {
                        return;
                    }
                    updater.updateBlindBoxEntrance(result);
                }
            }
        }, 1, null);
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onMapDataReceived(MapData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getFromCache()) {
            return;
        }
        getBlindBoxEntrance();
    }
}
