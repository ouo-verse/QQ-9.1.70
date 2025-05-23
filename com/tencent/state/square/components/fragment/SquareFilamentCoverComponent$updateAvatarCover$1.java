package com.tencent.state.square.components.fragment;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.data.RecordSource;
import com.tencent.state.square.resource.FilamentCoverRecorder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/state/square/components/fragment/SquareFilamentCoverComponent$updateAvatarCover$1", "Lcom/tencent/state/square/resource/FilamentCoverRecorder$IRecordCallback;", "onRecordError", "", "type", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/state/square/resource/FilamentCoverRecorder$RecordRequest;", "errorCode", "onRecordSuccess", "cover", "Lcom/tencent/state/square/data/RecordSource;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareFilamentCoverComponent$updateAvatarCover$1 implements FilamentCoverRecorder.IRecordCallback {
    final /* synthetic */ String $id;
    final /* synthetic */ SquareFilamentCoverComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SquareFilamentCoverComponent$updateAvatarCover$1(SquareFilamentCoverComponent squareFilamentCoverComponent, String str) {
        this.this$0 = squareFilamentCoverComponent;
        this.$id = str;
    }

    @Override // com.tencent.state.square.resource.FilamentCoverRecorder.IRecordCallback
    public void onRecordError(int type, FilamentCoverRecorder.RecordRequest request, int errorCode) {
        Intrinsics.checkNotNullParameter(request, "request");
    }

    @Override // com.tencent.state.square.resource.FilamentCoverRecorder.IRecordCallback
    public void onRecordSuccess(FilamentCoverRecorder.RecordRequest request, RecordSource cover) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(cover, "cover");
        SquareView mapView = this.this$0.getMapView();
        if (mapView != null) {
            mapView.post(new Runnable() { // from class: com.tencent.state.square.components.fragment.SquareFilamentCoverComponent$updateAvatarCover$1$onRecordSuccess$1
                @Override // java.lang.Runnable
                public final void run() {
                    ISquareViewUpdater updater;
                    SquareView mapView2 = SquareFilamentCoverComponent$updateAvatarCover$1.this.this$0.getMapView();
                    if (mapView2 == null || (updater = mapView2.getUpdater()) == null) {
                        return;
                    }
                    updater.updateAvatarCover(SquareFilamentCoverComponent$updateAvatarCover$1.this.$id);
                }
            });
        }
    }
}
