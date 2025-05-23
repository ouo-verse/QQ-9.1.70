package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0003J\u0019\u0010\u0006\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/QQStrangerOnChatListUIUpdateState;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "component1", "dataList", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getDataList", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerOnChatListUIUpdateState extends SimpleBaseEvent {
    private final List<com.tencent.qqnt.chats.core.adapter.itemdata.b> dataList;

    /* JADX WARN: Multi-variable type inference failed */
    public QQStrangerOnChatListUIUpdateState(List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList = dataList;
    }

    public final List<com.tencent.qqnt.chats.core.adapter.itemdata.b> component1() {
        return this.dataList;
    }

    public final QQStrangerOnChatListUIUpdateState copy(List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        return new QQStrangerOnChatListUIUpdateState(dataList);
    }

    public final List<com.tencent.qqnt.chats.core.adapter.itemdata.b> getDataList() {
        return this.dataList;
    }

    public int hashCode() {
        return this.dataList.hashCode();
    }

    public String toString() {
        return "QQStrangerOnChatListUIUpdateState(dataList=" + this.dataList + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QQStrangerOnChatListUIUpdateState copy$default(QQStrangerOnChatListUIUpdateState qQStrangerOnChatListUIUpdateState, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = qQStrangerOnChatListUIUpdateState.dataList;
        }
        return qQStrangerOnChatListUIUpdateState.copy(list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof QQStrangerOnChatListUIUpdateState) && Intrinsics.areEqual(this.dataList, ((QQStrangerOnChatListUIUpdateState) other).dataList);
    }
}
