package com.qzone.reborn.groupalbum.event;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/groupalbum/event/GroupAlbumDeleteFeedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feedData", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;)V", "getFeedData", "()Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "setFeedData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class GroupAlbumDeleteFeedEvent extends SimpleBaseEvent {
    private BusinessFeedData feedData;

    public GroupAlbumDeleteFeedEvent(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        this.feedData = feedData;
    }

    public final BusinessFeedData getFeedData() {
        return this.feedData;
    }

    public final void setFeedData(BusinessFeedData businessFeedData) {
        Intrinsics.checkNotNullParameter(businessFeedData, "<set-?>");
        this.feedData = businessFeedData;
    }
}
