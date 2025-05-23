package com.tencent.state.view;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.RelationType;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.like.IStickersChangedListener;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&JT\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H&J\u001a\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/view/IAvatarBubble;", "", "getData", "Lcom/tencent/state/square/data/OnlineStatus;", "isMe", "", "setData", "", "uin", "", "status", c.B, "Lcom/tencent/state/square/data/Stickers;", "stickersChangedListener", "Lcom/tencent/state/square/like/IStickersChangedListener;", "relationType", "Lcom/tencent/state/square/data/RelationType;", "needShowAnimation", "isPoster", "locationInfo", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "updateBubbleSkin", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "updatePlayIcon", "songMid", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IAvatarBubble {
    /* renamed from: getData */
    OnlineStatus getOnlineStatus();

    /* renamed from: isMe */
    boolean getIsMe();

    void setData(String uin, OnlineStatus status, Stickers stickers, IStickersChangedListener stickersChangedListener, RelationType relationType, boolean needShowAnimation, boolean isPoster, AvatarLocationInfo locationInfo);

    void updateBubbleSkin(SquareBubbleInfo bubbleInfo);

    void updatePlayIcon(String songMid, boolean isMe);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void setData$default(IAvatarBubble iAvatarBubble, String str, OnlineStatus onlineStatus, Stickers stickers, IStickersChangedListener iStickersChangedListener, RelationType relationType, boolean z16, boolean z17, AvatarLocationInfo avatarLocationInfo, int i3, Object obj) {
            if (obj == null) {
                iAvatarBubble.setData(str, onlineStatus, stickers, iStickersChangedListener, relationType, (i3 & 32) != 0 ? false : z16, (i3 & 64) != 0 ? false : z17, (i3 & 128) != 0 ? null : avatarLocationInfo);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setData");
        }
    }
}
