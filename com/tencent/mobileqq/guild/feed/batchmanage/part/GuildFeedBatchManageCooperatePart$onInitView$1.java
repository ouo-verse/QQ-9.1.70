package com.tencent.mobileqq.guild.feed.batchmanage.part;

import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.guild.feed.batchmanage.search.event.FeedBatchManageSearchSelectedChannelEvent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/search/event/FeedBatchManageSearchSelectedChannelEvent;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageCooperatePart$onInitView$1", f = "GuildFeedBatchManageCooperatePart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class GuildFeedBatchManageCooperatePart$onInitView$1 extends SuspendLambda implements Function2<FeedBatchManageSearchSelectedChannelEvent, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildFeedBatchManageCooperatePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedBatchManageCooperatePart$onInitView$1(GuildFeedBatchManageCooperatePart guildFeedBatchManageCooperatePart, Continuation<? super GuildFeedBatchManageCooperatePart$onInitView$1> continuation) {
        super(2, continuation);
        this.this$0 = guildFeedBatchManageCooperatePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildFeedBatchManageCooperatePart$onInitView$1 guildFeedBatchManageCooperatePart$onInitView$1 = new GuildFeedBatchManageCooperatePart$onInitView$1(this.this$0, continuation);
        guildFeedBatchManageCooperatePart$onInitView$1.L$0 = obj;
        return guildFeedBatchManageCooperatePart$onInitView$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FeedBatchManageSearchSelectedChannelEvent feedBatchManageSearchSelectedChannelEvent, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedBatchManageCooperatePart$onInitView$1) create(feedBatchManageSearchSelectedChannelEvent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FeedBatchManageSearchSelectedChannelEvent feedBatchManageSearchSelectedChannelEvent = (FeedBatchManageSearchSelectedChannelEvent) this.L$0;
            vi1.f fVar = (vi1.f) PartIOCKt.getIocInterface(this.this$0, vi1.f.class);
            if (fVar != null) {
                fVar.h(feedBatchManageSearchSelectedChannelEvent.getSelectedChannelId());
            }
            vi1.f fVar2 = (vi1.f) PartIOCKt.getIocInterface(this.this$0, vi1.f.class);
            if (fVar2 != null) {
                fVar2.a(feedBatchManageSearchSelectedChannelEvent.getSelectedChannelName());
            }
            this.this$0.broadcastMessage("BROADCAST_REFRESH", null);
            QLog.d("GuildFeedBatchManageCooperatePart", 1, " setSelectedChannelId" + feedBatchManageSearchSelectedChannelEvent.getSelectedChannelId() + " name" + feedBatchManageSearchSelectedChannelEvent.getSelectedChannelName());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
