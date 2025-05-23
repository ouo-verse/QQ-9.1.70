package com.tencent.state.square.detail;

import com.tencent.state.square.data.BaseResourceInfo;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import com.tencent.state.square.data.StatusLockInfo;
import com.tencent.state.square.resource.IResourceCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u001c\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J&\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u00030\u001fH&J=\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u00122\b\u0010#\u001a\u0004\u0018\u00010\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020%H&\u00a2\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u0003H&\u00a8\u0006("}, d2 = {"Lcom/tencent/state/square/detail/DetailMeListener;", "Lcom/tencent/state/square/detail/DetailCommonListener;", "clickShareMultiPoster", "", "data", "Lcom/tencent/state/square/data/SquareAvatarItem;", "inviteState", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "onClickLockMotion", "lockInfo", "Lcom/tencent/state/square/data/StatusLockInfo;", "onConfigInteraction", "avatarItem", "onPublishClick", "Lcom/tencent/state/square/data/OnlineStatus;", "motion", "Lcom/tencent/state/square/data/BaseResourceInfo;", "customText", "", "onSelectFriendClick", "motionId", "", "uin", "onSetNewStatus", "redDotId", "", "onStatusSelected", "playAvatar", "resource", "Lcom/tencent/state/square/data/Resource;", "callback", "Lkotlin/Function1;", "", "recordAvatar", "friendUin", "friendGender", "status", "Lcom/tencent/state/square/resource/IResourceCallback;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/state/square/data/Resource;Lcom/tencent/state/square/data/OnlineStatus;Lcom/tencent/state/square/resource/IResourceCallback;)V", "refreshStatusPanel", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface DetailMeListener extends DetailCommonListener {
    void clickShareMultiPoster(SquareAvatarItem data, SquareMultiMotionDetailData inviteState);

    void onClickLockMotion(StatusLockInfo lockInfo);

    void onConfigInteraction(SquareAvatarItem avatarItem);

    void onPublishClick(OnlineStatus data, BaseResourceInfo motion, String customText);

    void onSelectFriendClick(int motionId, String uin);

    void onSetNewStatus(long redDotId);

    void onStatusSelected(OnlineStatus data, BaseResourceInfo motion);

    void playAvatar(Resource resource, Function1<? super Boolean, Unit> callback);

    void recordAvatar(String friendUin, Integer friendGender, Resource resource, OnlineStatus status, IResourceCallback callback);

    void refreshStatusPanel();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onSelectFriendClick$default(DetailMeListener detailMeListener, int i3, String str, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    str = null;
                }
                detailMeListener.onSelectFriendClick(i3, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSelectFriendClick");
        }
    }
}
