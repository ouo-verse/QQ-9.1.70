package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildFeedSquareRefreshEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "guildId", "", "channelId", "tabType", "", "showAnimation", "", "(Ljava/lang/String;Ljava/lang/String;IZ)V", "getChannelId", "()Ljava/lang/String;", "getGuildId", "getShowAnimation", "()Z", "getTabType", "()I", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedSquareRefreshEvent extends SimpleBaseEvent {

    @NotNull
    private final String channelId;

    @NotNull
    private final String guildId;
    private final boolean showAnimation;
    private final int tabType;

    public /* synthetic */ GuildFeedSquareRefreshEvent(String str, String str2, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, (i16 & 8) != 0 ? false : z16);
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    public final boolean getShowAnimation() {
        return this.showAnimation;
    }

    public final int getTabType() {
        return this.tabType;
    }

    public GuildFeedSquareRefreshEvent(@NotNull String guildId, @NotNull String channelId, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.guildId = guildId;
        this.channelId = channelId;
        this.tabType = i3;
        this.showAnimation = z16;
    }
}
