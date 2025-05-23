package com.tencent.mobileqq.guild.feed.batchmanage.part;

import com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart$setUpTotalFeedCountCallbackAndFetchTotalCount$1", f = "GuildFeedBatchManageBottomOperationPart.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedBatchManageBottomOperationPart$setUpTotalFeedCountCallbackAndFetchTotalCount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $channelId;
    final /* synthetic */ Function1<Integer, Unit> $onUpdateBackendTotalFeedCount;
    int label;
    final /* synthetic */ GuildFeedBatchManageBottomOperationPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildFeedBatchManageBottomOperationPart$setUpTotalFeedCountCallbackAndFetchTotalCount$1(GuildFeedBatchManageBottomOperationPart guildFeedBatchManageBottomOperationPart, long j3, Function1<? super Integer, Unit> function1, Continuation<? super GuildFeedBatchManageBottomOperationPart$setUpTotalFeedCountCallbackAndFetchTotalCount$1> continuation) {
        super(2, continuation);
        this.this$0 = guildFeedBatchManageBottomOperationPart;
        this.$channelId = j3;
        this.$onUpdateBackendTotalFeedCount = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedBatchManageBottomOperationPart$setUpTotalFeedCountCallbackAndFetchTotalCount$1(this.this$0, this.$channelId, this.$onUpdateBackendTotalFeedCount, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            GuildFeedBatchManageBottomOperationPart.a aVar = this.this$0.dependency;
            long j3 = this.$channelId;
            this.label = 1;
            obj = aVar.a(j3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Integer num = (Integer) obj;
        if (num != null) {
            this.$onUpdateBackendTotalFeedCount.invoke(Boxing.boxInt(num.intValue()));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedBatchManageBottomOperationPart$setUpTotalFeedCountCallbackAndFetchTotalCount$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
