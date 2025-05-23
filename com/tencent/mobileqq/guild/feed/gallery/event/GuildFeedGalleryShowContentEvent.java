package com.tencent.mobileqq.guild.feed.gallery.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryShowContentEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", ViewStickEventHelper.IS_SHOW, "", "feedId", "", "(ZLjava/lang/String;)V", "getFeedId", "()Ljava/lang/String;", "()Z", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedGalleryShowContentEvent extends SimpleBaseEvent {

    @Nullable
    private final String feedId;
    private final boolean isShow;

    public GuildFeedGalleryShowContentEvent(boolean z16, @Nullable String str) {
        this.isShow = z16;
        this.feedId = str;
    }

    @Nullable
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: isShow, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }
}
