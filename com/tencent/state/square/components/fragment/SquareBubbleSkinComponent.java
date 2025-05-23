package com.tencent.state.square.components.fragment;

import android.graphics.Bitmap;
import com.tencent.state.map.MapData;
import com.tencent.state.map.MapItem;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.bubblesetting.BubbleSkinDownloadManager;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.data.SquareAvatarItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareBubbleSkinComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "onMapDataReceived", "", "data", "Lcom/tencent/state/map/MapData;", "preloadBubbleSkin", "list", "", "Lcom/tencent/state/map/MapItem;", "updateTargetBubbleSkin", "uin", "", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareBubbleSkinComponent extends SquareBaseComponent {
    private static final int DEFAULT_ID = 1;
    private static final String TAG = "SquareBubbleSkinComponent";

    private final void preloadBubbleSkin(List<? extends MapItem> list) {
        SquareBubbleInfo bubbleInfo;
        for (MapItem mapItem : list) {
            if (!(mapItem instanceof SquareAvatarItem)) {
                mapItem = null;
            }
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) mapItem;
            if (squareAvatarItem != null && (bubbleInfo = squareAvatarItem.getExtra().getBubbleInfo()) != null) {
                updateTargetBubbleSkin(squareAvatarItem.getUin(), bubbleInfo);
            }
        }
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onMapDataReceived(MapData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getDataList().isEmpty() || data.getFromCache()) {
            return;
        }
        preloadBubbleSkin(data.getDataList());
    }

    public final void updateTargetBubbleSkin(final String uin, final SquareBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        if (bubbleInfo.getId() != 1) {
            BubbleSkinDownloadManager.INSTANCE.getBubbleSkinBitmap(bubbleInfo.getSkinLink(), new Function1<Bitmap, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareBubbleSkinComponent$updateTargetBubbleSkin$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                    invoke2(bitmap);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Bitmap it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    bubbleInfo.setBitmap(it);
                    SquareView mapView = SquareBubbleSkinComponent.this.getMapView();
                    if (mapView != null) {
                        mapView.post(new Runnable() { // from class: com.tencent.state.square.components.fragment.SquareBubbleSkinComponent$updateTargetBubbleSkin$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ISquareViewUpdater updater;
                                SquareView mapView2 = SquareBubbleSkinComponent.this.getMapView();
                                if (mapView2 == null || (updater = mapView2.getUpdater()) == null) {
                                    return;
                                }
                                SquareBubbleSkinComponent$updateTargetBubbleSkin$1 squareBubbleSkinComponent$updateTargetBubbleSkin$1 = SquareBubbleSkinComponent$updateTargetBubbleSkin$1.this;
                                updater.updateBubbleSkin(uin, bubbleInfo);
                            }
                        });
                    }
                }
            });
            return;
        }
        SquareView mapView = getMapView();
        if (mapView != null) {
            mapView.post(new Runnable() { // from class: com.tencent.state.square.components.fragment.SquareBubbleSkinComponent$updateTargetBubbleSkin$2
                @Override // java.lang.Runnable
                public final void run() {
                    ISquareViewUpdater updater;
                    SquareView mapView2 = SquareBubbleSkinComponent.this.getMapView();
                    if (mapView2 == null || (updater = mapView2.getUpdater()) == null) {
                        return;
                    }
                    updater.updateBubbleSkin(uin, bubbleInfo);
                }
            });
        }
    }
}
