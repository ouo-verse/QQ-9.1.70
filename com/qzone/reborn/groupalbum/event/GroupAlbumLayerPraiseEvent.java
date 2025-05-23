package com.qzone.reborn.groupalbum.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/groupalbum/event/GroupAlbumLayerPraiseEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feedId", "", "lLoc", "(Ljava/lang/String;Ljava/lang/String;)V", "getFeedId", "()Ljava/lang/String;", "getLLoc", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class GroupAlbumLayerPraiseEvent extends SimpleBaseEvent {
    private final String feedId;
    private final String lLoc;

    public GroupAlbumLayerPraiseEvent(String feedId, String lLoc) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(lLoc, "lLoc");
        this.feedId = feedId;
        this.lLoc = lLoc;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final String getLLoc() {
        return this.lLoc;
    }
}
