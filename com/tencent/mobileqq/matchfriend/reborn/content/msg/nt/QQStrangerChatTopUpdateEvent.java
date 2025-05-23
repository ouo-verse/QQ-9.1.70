package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/QQStrangerChatTopUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "tinyId", "", "isTop", "", "(Ljava/lang/String;Z)V", "()Z", "getTinyId", "()Ljava/lang/String;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQStrangerChatTopUpdateEvent extends SimpleBaseEvent {
    private final boolean isTop;
    private final String tinyId;

    public QQStrangerChatTopUpdateEvent(String tinyId, boolean z16) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        this.tinyId = tinyId;
        this.isTop = z16;
    }

    public final String getTinyId() {
        return this.tinyId;
    }

    /* renamed from: isTop, reason: from getter */
    public final boolean getIsTop() {
        return this.isTop;
    }
}
