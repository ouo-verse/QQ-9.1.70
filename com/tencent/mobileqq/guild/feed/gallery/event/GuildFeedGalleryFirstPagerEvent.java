package com.tencent.mobileqq.guild.feed.gallery.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryFirstPagerEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "firstFeedId", "", "firstPos", "", "(Ljava/lang/String;I)V", "getFirstFeedId", "()Ljava/lang/String;", "getFirstPos", "()I", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedGalleryFirstPagerEvent extends SimpleBaseEvent {

    @Nullable
    private final String firstFeedId;
    private final int firstPos;

    public /* synthetic */ GuildFeedGalleryFirstPagerEvent(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? 0 : i3);
    }

    @Nullable
    public final String getFirstFeedId() {
        return this.firstFeedId;
    }

    public final int getFirstPos() {
        return this.firstPos;
    }

    public GuildFeedGalleryFirstPagerEvent(@Nullable String str, int i3) {
        this.firstFeedId = str;
        this.firstPos = i3;
    }
}
