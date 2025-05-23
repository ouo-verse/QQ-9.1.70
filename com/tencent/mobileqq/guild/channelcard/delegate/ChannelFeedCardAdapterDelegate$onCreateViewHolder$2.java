package com.tencent.mobileqq.guild.channelcard.delegate;

import com.tencent.mobileqq.qqguildsdk.data.IGProFeedSummary;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
/* synthetic */ class ChannelFeedCardAdapterDelegate$onCreateViewHolder$2 extends FunctionReferenceImpl implements Function2<dg1.b, IGProFeedSummary, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelFeedCardAdapterDelegate$onCreateViewHolder$2(Object obj) {
        super(2, obj, cg1.b.class, "onFeedSummaryClicked", "onFeedSummaryClicked(Lcom/tencent/mobileqq/guild/channelcard/data/ChannelCardItemData;Lcom/tencent/mobileqq/qqguildsdk/data/IGProFeedSummary;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(dg1.b bVar, IGProFeedSummary iGProFeedSummary) {
        invoke2(bVar, iGProFeedSummary);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull dg1.b p06, @NotNull IGProFeedSummary p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((cg1.b) this.receiver).q1(p06, p16);
    }
}
