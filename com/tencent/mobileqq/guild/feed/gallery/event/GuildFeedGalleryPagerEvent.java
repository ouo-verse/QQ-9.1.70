package com.tencent.mobileqq.guild.feed.gallery.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.tmdownloader.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0011B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryPagerEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "curPos", "", "totalSize", "feedId", "", HippyTKDListViewAdapter.SCROLL_STATE, "Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryPagerEvent$GalleryPageScrollState;", "(IILjava/lang/String;Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryPagerEvent$GalleryPageScrollState;)V", "getCurPos", "()I", "getFeedId", "()Ljava/lang/String;", "getScrollState", "()Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryPagerEvent$GalleryPageScrollState;", "getTotalSize", "GalleryPageScrollState", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedGalleryPagerEvent extends SimpleBaseEvent {
    private final int curPos;

    @Nullable
    private final String feedId;

    @NotNull
    private final GalleryPageScrollState scrollState;
    private final int totalSize;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryPagerEvent$GalleryPageScrollState;", "", "(Ljava/lang/String;I)V", a.CONNTECTSTATE_INIT, "SCROLL_TO_RIGHT", "SCROLL_TO_LEFT", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public enum GalleryPageScrollState {
        INIT,
        SCROLL_TO_RIGHT,
        SCROLL_TO_LEFT
    }

    public GuildFeedGalleryPagerEvent(int i3, int i16, @Nullable String str, @NotNull GalleryPageScrollState scrollState) {
        Intrinsics.checkNotNullParameter(scrollState, "scrollState");
        this.curPos = i3;
        this.totalSize = i16;
        this.feedId = str;
        this.scrollState = scrollState;
    }

    public final int getCurPos() {
        return this.curPos;
    }

    @Nullable
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    public final GalleryPageScrollState getScrollState() {
        return this.scrollState;
    }

    public final int getTotalSize() {
        return this.totalSize;
    }
}
