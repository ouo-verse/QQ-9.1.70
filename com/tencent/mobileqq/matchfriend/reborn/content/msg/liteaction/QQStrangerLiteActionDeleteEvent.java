package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/QQStrangerLiteActionDeleteEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "position", "", "(I)V", "getPosition", "()I", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQStrangerLiteActionDeleteEvent extends SimpleBaseEvent {
    private final int position;

    public QQStrangerLiteActionDeleteEvent(int i3) {
        this.position = i3;
    }

    public final int getPosition() {
        return this.position;
    }
}
