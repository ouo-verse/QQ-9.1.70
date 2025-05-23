package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel;

import com.tencent.hippykotlin.demo.pages.nearby.base.utils.AsyncTaskTracker;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ChannelFeedListViewModel$markExpanded$1 extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ ChannelFeedListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFeedListViewModel$markExpanded$1(ChannelFeedListViewModel channelFeedListViewModel) {
        super(1);
        this.this$0 = channelFeedListViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Unit unit) {
        AsyncTaskTracker<Unit> asyncTaskTracker = this.this$0.listExpandedWaitingTask;
        Unit unit2 = Unit.INSTANCE;
        asyncTaskTracker.markDoneAndClearCbs(unit2);
        return unit2;
    }
}
