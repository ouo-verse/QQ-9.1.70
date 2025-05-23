package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/QQStrangerLiteActionPushEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "data", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "getData", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerLiteActionPushEvent extends SimpleBaseEvent {
    private final QQStrangerLiteActionModel data;

    public QQStrangerLiteActionPushEvent(QQStrangerLiteActionModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public final QQStrangerLiteActionModel getData() {
        return this.data;
    }
}
