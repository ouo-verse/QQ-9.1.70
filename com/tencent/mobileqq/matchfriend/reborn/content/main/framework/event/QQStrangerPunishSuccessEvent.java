package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/event/QQStrangerPunishSuccessEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feedId", "", "level", "", "(Ljava/lang/String;I)V", "getFeedId", "()Ljava/lang/String;", "getLevel", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerPunishSuccessEvent extends SimpleBaseEvent {
    private final String feedId;
    private final int level;

    public QQStrangerPunishSuccessEvent(String feedId, int i3) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.feedId = feedId;
        this.level = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    public final QQStrangerPunishSuccessEvent copy(String feedId, int level) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        return new QQStrangerPunishSuccessEvent(feedId, level);
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final int getLevel() {
        return this.level;
    }

    public int hashCode() {
        return (this.feedId.hashCode() * 31) + this.level;
    }

    public String toString() {
        return "QQStrangerPunishSuccessEvent(feedId=" + this.feedId + ", level=" + this.level + ")";
    }

    public static /* synthetic */ QQStrangerPunishSuccessEvent copy$default(QQStrangerPunishSuccessEvent qQStrangerPunishSuccessEvent, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = qQStrangerPunishSuccessEvent.feedId;
        }
        if ((i16 & 2) != 0) {
            i3 = qQStrangerPunishSuccessEvent.level;
        }
        return qQStrangerPunishSuccessEvent.copy(str, i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQStrangerPunishSuccessEvent)) {
            return false;
        }
        QQStrangerPunishSuccessEvent qQStrangerPunishSuccessEvent = (QQStrangerPunishSuccessEvent) other;
        return Intrinsics.areEqual(this.feedId, qQStrangerPunishSuccessEvent.feedId) && this.level == qQStrangerPunishSuccessEvent.level;
    }
}
