package com.tencent.mobileqq.matchfriend.reborn.content.msg.top;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.matchfriend.aio.foreground.g;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/QQStrangerSendEmojiMsgEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "tinyId", "", "emojiId", "", "(JI)V", "getEmojiId", "()I", "getTinyId", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerSendEmojiMsgEvent extends SimpleBaseEvent {
    private final int emojiId;
    private final long tinyId;

    public QQStrangerSendEmojiMsgEvent(long j3, int i3) {
        this.tinyId = j3;
        this.emojiId = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final long getTinyId() {
        return this.tinyId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getEmojiId() {
        return this.emojiId;
    }

    public final QQStrangerSendEmojiMsgEvent copy(long tinyId, int emojiId) {
        return new QQStrangerSendEmojiMsgEvent(tinyId, emojiId);
    }

    public final int getEmojiId() {
        return this.emojiId;
    }

    public final long getTinyId() {
        return this.tinyId;
    }

    public int hashCode() {
        return (g.a(this.tinyId) * 31) + this.emojiId;
    }

    public String toString() {
        return "QQStrangerSendEmojiMsgEvent(tinyId=" + this.tinyId + ", emojiId=" + this.emojiId + ")";
    }

    public static /* synthetic */ QQStrangerSendEmojiMsgEvent copy$default(QQStrangerSendEmojiMsgEvent qQStrangerSendEmojiMsgEvent, long j3, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            j3 = qQStrangerSendEmojiMsgEvent.tinyId;
        }
        if ((i16 & 2) != 0) {
            i3 = qQStrangerSendEmojiMsgEvent.emojiId;
        }
        return qQStrangerSendEmojiMsgEvent.copy(j3, i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQStrangerSendEmojiMsgEvent)) {
            return false;
        }
        QQStrangerSendEmojiMsgEvent qQStrangerSendEmojiMsgEvent = (QQStrangerSendEmojiMsgEvent) other;
        return this.tinyId == qQStrangerSendEmojiMsgEvent.tinyId && this.emojiId == qQStrangerSendEmojiMsgEvent.emojiId;
    }
}
