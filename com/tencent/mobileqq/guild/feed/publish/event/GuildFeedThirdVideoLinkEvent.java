package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/event/GuildFeedThirdVideoLinkEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "url", "", "type", "", "(Ljava/lang/String;I)V", "getType", "()I", "getUrl", "()Ljava/lang/String;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedThirdVideoLinkEvent extends SimpleBaseEvent {
    private final int type;

    @NotNull
    private final String url;

    public GuildFeedThirdVideoLinkEvent(@NotNull String url, int i3) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.type = i3;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }
}
