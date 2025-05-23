package com.tencent.mobileqq.guild.feed.gallery.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryImmersiveEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "NotifyVerticalPageSelectedEvent", "PreloadFeedList", "Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryImmersiveEvent$NotifyVerticalPageSelectedEvent;", "Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryImmersiveEvent$PreloadFeedList;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public abstract class GuildFeedGalleryImmersiveEvent extends SimpleBaseEvent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryImmersiveEvent$NotifyVerticalPageSelectedEvent;", "Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryImmersiveEvent;", "verticalPosition", "", "isScrollUP", "", "(IZ)V", "()Z", "getVerticalPosition", "()I", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class NotifyVerticalPageSelectedEvent extends GuildFeedGalleryImmersiveEvent {
        private final boolean isScrollUP;
        private final int verticalPosition;

        public NotifyVerticalPageSelectedEvent() {
            this(0, 0 == true ? 1 : 0, 3, null);
        }

        public final int getVerticalPosition() {
            return this.verticalPosition;
        }

        /* renamed from: isScrollUP, reason: from getter */
        public final boolean getIsScrollUP() {
            return this.isScrollUP;
        }

        public /* synthetic */ NotifyVerticalPageSelectedEvent(int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? true : z16);
        }

        public NotifyVerticalPageSelectedEvent(int i3, boolean z16) {
            super(null);
            this.verticalPosition = i3;
            this.isScrollUP = z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryImmersiveEvent$PreloadFeedList;", "Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryImmersiveEvent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class PreloadFeedList extends GuildFeedGalleryImmersiveEvent {
        public PreloadFeedList() {
            super(null);
        }
    }

    public /* synthetic */ GuildFeedGalleryImmersiveEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    GuildFeedGalleryImmersiveEvent() {
    }
}
