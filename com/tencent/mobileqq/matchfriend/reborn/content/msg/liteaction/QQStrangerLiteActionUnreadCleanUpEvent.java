package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/QQStrangerLiteActionUnreadCleanUpEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "notifyUI", "", "cb", "Lkotlin/Function1;", "", "(ZLkotlin/jvm/functions/Function1;)V", "getCb", "()Lkotlin/jvm/functions/Function1;", "getNotifyUI", "()Z", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQStrangerLiteActionUnreadCleanUpEvent extends SimpleBaseEvent {
    private final Function1<Boolean, Unit> cb;
    private final boolean notifyUI;

    /* JADX WARN: Multi-variable type inference failed */
    public QQStrangerLiteActionUnreadCleanUpEvent(boolean z16, Function1<? super Boolean, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.notifyUI = z16;
        this.cb = cb5;
    }

    public final Function1<Boolean, Unit> getCb() {
        return this.cb;
    }

    public final boolean getNotifyUI() {
        return this.notifyUI;
    }
}
