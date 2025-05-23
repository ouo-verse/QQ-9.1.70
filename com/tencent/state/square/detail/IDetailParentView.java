package com.tencent.state.square.detail;

import android.view.View;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import com.tencent.state.square.media.MapPlayableSource;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/square/detail/IDetailParentView;", "", "getCommonView", "Lcom/tencent/state/square/detail/DetailCommonView;", "getCurrentMapPlayableSource", "Lcom/tencent/state/square/media/MapPlayableSource;", "getView", "Landroid/view/View;", "onInviteStateChanged", "", "state", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "onMenuClick", "playLikeAnimation", "likeType", "", "updateBubbleView", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "updatePlayState", "data", "Lcom/tencent/state/square/data/SquareAvatarItem;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IDetailParentView {
    DetailCommonView getCommonView();

    MapPlayableSource getCurrentMapPlayableSource();

    View getView();

    void onInviteStateChanged(SquareMultiMotionDetailData state);

    void onMenuClick();

    void playLikeAnimation(int likeType);

    void updateBubbleView(OnlineStatus status);

    void updatePlayState(SquareAvatarItem data);
}
