package com.tencent.timi.game.liveroom.impl.room.notice;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/notice/NoticeCommitEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "announcePushMessage", "Lcom/tencent/mobileqq/qqlive/data/announce/AnnouncePushMessage;", "(Lcom/tencent/mobileqq/qqlive/data/announce/AnnouncePushMessage;)V", "getAnnouncePushMessage", "()Lcom/tencent/mobileqq/qqlive/data/announce/AnnouncePushMessage;", "setAnnouncePushMessage", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class NoticeCommitEvent extends SimpleBaseEvent {

    @NotNull
    private AnnouncePushMessage announcePushMessage;

    public NoticeCommitEvent(@NotNull AnnouncePushMessage announcePushMessage) {
        Intrinsics.checkNotNullParameter(announcePushMessage, "announcePushMessage");
        this.announcePushMessage = announcePushMessage;
    }

    @NotNull
    public final AnnouncePushMessage getAnnouncePushMessage() {
        return this.announcePushMessage;
    }

    public final void setAnnouncePushMessage(@NotNull AnnouncePushMessage announcePushMessage) {
        Intrinsics.checkNotNullParameter(announcePushMessage, "<set-?>");
        this.announcePushMessage = announcePushMessage;
    }
}
