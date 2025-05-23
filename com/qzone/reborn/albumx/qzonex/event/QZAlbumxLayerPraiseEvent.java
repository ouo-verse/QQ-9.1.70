package com.qzone.reborn.albumx.qzonex.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxLayerPraiseEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "linkId", "", "lLoc", "isLike", "", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "()Z", "getLLoc", "()Ljava/lang/String;", "getLikeCount", "()I", "getLinkId", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZAlbumxLayerPraiseEvent extends SimpleBaseEvent {
    private final boolean isLike;
    private final String lLoc;
    private final int likeCount;
    private final String linkId;

    public QZAlbumxLayerPraiseEvent(String linkId, String lLoc, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(linkId, "linkId");
        Intrinsics.checkNotNullParameter(lLoc, "lLoc");
        this.linkId = linkId;
        this.lLoc = lLoc;
        this.isLike = z16;
        this.likeCount = i3;
    }

    public final String getLLoc() {
        return this.lLoc;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final String getLinkId() {
        return this.linkId;
    }

    /* renamed from: isLike, reason: from getter */
    public final boolean getIsLike() {
        return this.isLike;
    }
}
