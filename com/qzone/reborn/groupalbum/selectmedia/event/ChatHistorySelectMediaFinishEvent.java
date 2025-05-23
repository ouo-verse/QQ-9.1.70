package com.qzone.reborn.groupalbum.selectmedia.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/event/ChatHistorySelectMediaFinishEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "groupId", "", "(Ljava/lang/String;)V", "getGroupId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final /* data */ class ChatHistorySelectMediaFinishEvent extends SimpleBaseEvent {
    private final String groupId;

    public ChatHistorySelectMediaFinishEvent(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.groupId = groupId;
    }

    /* renamed from: component1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    public final ChatHistorySelectMediaFinishEvent copy(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        return new ChatHistorySelectMediaFinishEvent(groupId);
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public int hashCode() {
        return this.groupId.hashCode();
    }

    public String toString() {
        return "ChatHistorySelectMediaFinishEvent(groupId=" + this.groupId + ")";
    }

    public static /* synthetic */ ChatHistorySelectMediaFinishEvent copy$default(ChatHistorySelectMediaFinishEvent chatHistorySelectMediaFinishEvent, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = chatHistorySelectMediaFinishEvent.groupId;
        }
        return chatHistorySelectMediaFinishEvent.copy(str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ChatHistorySelectMediaFinishEvent) && Intrinsics.areEqual(this.groupId, ((ChatHistorySelectMediaFinishEvent) other).groupId);
    }
}
