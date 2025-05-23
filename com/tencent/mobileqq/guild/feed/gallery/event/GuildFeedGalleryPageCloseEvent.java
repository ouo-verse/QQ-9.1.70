package com.tencent.mobileqq.guild.feed.gallery.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryPageCloseEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feedId", "", "(Ljava/lang/String;)V", "getFeedId", "()Ljava/lang/String;", "setFeedId", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedGalleryPageCloseEvent extends SimpleBaseEvent {

    @NotNull
    private String feedId;

    public GuildFeedGalleryPageCloseEvent(@NotNull String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.feedId = feedId;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    public final void setFeedId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedId = str;
    }
}
