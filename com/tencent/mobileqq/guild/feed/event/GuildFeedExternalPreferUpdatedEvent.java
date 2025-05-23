package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildFeedExternalPreferUpdatedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feedId", "", "preferList", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStUser;", "Lkotlin/collections/ArrayList;", "preferCountWithoutLike", "", "(Ljava/lang/String;Ljava/util/ArrayList;I)V", "getFeedId", "()Ljava/lang/String;", "getPreferCountWithoutLike", "()I", "getPreferList", "()Ljava/util/ArrayList;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedExternalPreferUpdatedEvent extends SimpleBaseEvent {

    @NotNull
    private final String feedId;
    private final int preferCountWithoutLike;

    @NotNull
    private final ArrayList<GProStUser> preferList;

    public GuildFeedExternalPreferUpdatedEvent(@NotNull String feedId, @NotNull ArrayList<GProStUser> preferList, int i3) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(preferList, "preferList");
        this.feedId = feedId;
        this.preferList = preferList;
        this.preferCountWithoutLike = i3;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    public final int getPreferCountWithoutLike() {
        return this.preferCountWithoutLike;
    }

    @NotNull
    public final ArrayList<GProStUser> getPreferList() {
        return this.preferList;
    }
}
