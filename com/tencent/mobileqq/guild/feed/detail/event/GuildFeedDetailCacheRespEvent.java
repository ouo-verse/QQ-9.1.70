package com.tencent.mobileqq.guild.feed.detail.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/event/GuildFeedDetailCacheRespEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feedId", "", "lastModifyTime", "", "(Ljava/lang/String;J)V", "getFeedId", "()Ljava/lang/String;", "getLastModifyTime", "()J", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedDetailCacheRespEvent extends SimpleBaseEvent {

    @NotNull
    private final String feedId;
    private final long lastModifyTime;

    public /* synthetic */ GuildFeedDetailCacheRespEvent(String str, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 0L : j3);
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    public final long getLastModifyTime() {
        return this.lastModifyTime;
    }

    public GuildFeedDetailCacheRespEvent(@NotNull String feedId, long j3) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.feedId = feedId;
        this.lastModifyTime = j3;
    }
}
