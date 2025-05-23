package com.qzone.reborn.groupalbum.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/groupalbum/event/GroupAlbumLayerDeleteImageEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "fromFeedDetail", "", "feedId", "", "batchId", BaseProfileQZoneComponent.KEY_IS_VIDEO, "lloc", "(ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getBatchId", "()Ljava/lang/String;", "getFeedId", "getFromFeedDetail", "()Z", "setFromFeedDetail", "(Z)V", "getLloc", "setLloc", "(Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class GroupAlbumLayerDeleteImageEvent extends SimpleBaseEvent {
    private final String batchId;
    private final String feedId;
    private boolean fromFeedDetail;
    private final boolean isVideo;
    private String lloc;

    public GroupAlbumLayerDeleteImageEvent(boolean z16, String feedId, String batchId, boolean z17, String lloc) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(lloc, "lloc");
        this.fromFeedDetail = z16;
        this.feedId = feedId;
        this.batchId = batchId;
        this.isVideo = z17;
        this.lloc = lloc;
    }

    public final String getBatchId() {
        return this.batchId;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final boolean getFromFeedDetail() {
        return this.fromFeedDetail;
    }

    public final String getLloc() {
        return this.lloc;
    }

    /* renamed from: isVideo, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    public final void setFromFeedDetail(boolean z16) {
        this.fromFeedDetail = z16;
    }

    public final void setLloc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lloc = str;
    }
}
