package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildFeedDetailLikeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "positionX", "", "positionY", "fromWeb", "", "(FFZ)V", "getFromWeb", "()Z", "getPositionX", "()F", "getPositionY", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedDetailLikeEvent extends SimpleBaseEvent {
    private final boolean fromWeb;
    private final float positionX;
    private final float positionY;

    public /* synthetic */ GuildFeedDetailLikeEvent(float f16, float f17, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, f17, (i3 & 4) != 0 ? false : z16);
    }

    public final boolean getFromWeb() {
        return this.fromWeb;
    }

    public final float getPositionX() {
        return this.positionX;
    }

    public final float getPositionY() {
        return this.positionY;
    }

    public GuildFeedDetailLikeEvent(float f16, float f17, boolean z16) {
        this.positionX = f16;
        this.positionY = f17;
        this.fromWeb = z16;
    }
}
